package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.plugin.vlog.model.effect.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
  extends RecyclerView.v
{
  public i(View paramView)
  {
    super(paramView);
  }
  
  public void a(e parame)
  {
    s.u(parame, "item");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */