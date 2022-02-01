package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.vlog.model.effect.d;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class f
  extends h
{
  private final ImageView ka;
  
  public f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191664);
    paramView = paramView.findViewById(2131308333);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.ka = ((ImageView)paramView);
    AppMethodBeat.o(191664);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(191663);
    p.h(parame, "item");
    if (!(parame instanceof d)) {
      parame = null;
    }
    for (;;)
    {
      parame = (d)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hfa;
        com.tencent.mm.loader.e.aqU().yF(parame.BYF.dEM).c(this.ka);
        AppMethodBeat.o(191663);
        return;
      }
      AppMethodBeat.o(191663);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */