package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class f
  extends i
{
  private final TextView NuY;
  private final ImageView bwJ;
  
  public f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(225550);
    View localView = paramView.findViewById(a.f.item_magic_panel_icon);
    p.j(localView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.bwJ = ((ImageView)localView);
    paramView = paramView.findViewById(a.f.item_magic_panel_order);
    p.j(paramView, "itemView.findViewById(R.id.item_magic_panel_order)");
    this.NuY = ((TextView)paramView);
    AppMethodBeat.o(225550);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(225548);
    p.k(parame, "item");
    if (!(parame instanceof com.tencent.mm.plugin.vlog.model.effect.b)) {
      parame = null;
    }
    for (;;)
    {
      parame = (com.tencent.mm.plugin.vlog.model.effect.b)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.kMy;
        com.tencent.mm.loader.e.aRs().Op(parame.NnS.icon).c(this.bwJ);
        this.NuY.setText((CharSequence)String.valueOf(parame.order));
        AppMethodBeat.o(225548);
        return;
      }
      AppMethodBeat.o(225548);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */