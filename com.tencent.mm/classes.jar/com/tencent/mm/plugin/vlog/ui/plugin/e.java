package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class e
  extends h
{
  private final TextView CeJ;
  private final ImageView ka;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191662);
    View localView = paramView.findViewById(2131308333);
    p.g(localView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.ka = ((ImageView)localView);
    paramView = paramView.findViewById(2131308334);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_order)");
    this.CeJ = ((TextView)paramView);
    AppMethodBeat.o(191662);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(191661);
    p.h(parame, "item");
    if (!(parame instanceof com.tencent.mm.plugin.vlog.model.effect.b)) {
      parame = null;
    }
    for (;;)
    {
      parame = (com.tencent.mm.plugin.vlog.model.effect.b)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hfa;
        com.tencent.mm.loader.e.aqU().yF(parame.BYF.dEM).c(this.ka);
        this.CeJ.setText((CharSequence)String.valueOf(parame.order));
        AppMethodBeat.o(191661);
        return;
      }
      AppMethodBeat.o(191661);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */