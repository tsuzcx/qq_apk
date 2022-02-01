package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.plugin.vlog.model.effect.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public abstract class i
  extends RecyclerView.v
{
  public i(View paramView)
  {
    super(paramView);
  }
  
  public void a(e parame)
  {
    p.k(parame, "item");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */