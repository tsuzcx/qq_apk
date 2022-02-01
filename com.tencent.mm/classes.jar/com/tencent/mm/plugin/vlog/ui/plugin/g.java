package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.effect.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class g
  extends i
{
  private final ImageView bwJ;
  
  public g(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(246289);
    paramView = paramView.findViewById(a.f.item_magic_panel_icon);
    p.j(paramView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.bwJ = ((ImageView)paramView);
    AppMethodBeat.o(246289);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(246287);
    p.k(parame, "item");
    if (!(parame instanceof d)) {
      parame = null;
    }
    for (;;)
    {
      parame = (d)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.kMy;
        com.tencent.mm.loader.e.aRs().Op(parame.NnS.icon).c(this.bwJ);
        AppMethodBeat.o(246287);
        return;
      }
      AppMethodBeat.o(246287);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */