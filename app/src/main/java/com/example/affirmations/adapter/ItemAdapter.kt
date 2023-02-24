package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation



class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Crea las views que se van a repetir por cada data item
    // Pueden haber data items más complejos que requieran más views por item,
    // en ese caso, le das acceso a todas las views que necesite el data item
    // Los data items aca son Affirmations
    // El ViewHolder contiene los LayoutManagers, que son los que posicionan y distribuyen los elementos
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }


    // Crea nuevas vistas (invocado por el LayoutManager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Crea una nueva vista
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    // Retorna el largo del conjunto de datos, dataset (invocado por el LayoutManager)
    override fun getItemCount(): Int = dataset.size


    // Reemplaza el contenido de las vistas ya creadas (invocado por el LayoutManager)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

    }
}