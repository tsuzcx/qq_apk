package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.vlog.model.effect.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class h
  extends j
{
  private final ImageView kc;
  
  public h(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191281);
    paramView = paramView.findViewById(2131302832);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.kc = ((ImageView)paramView);
    AppMethodBeat.o(191281);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(191280);
    p.h(parame, "item");
    if (!(parame instanceof d)) {
      parame = null;
    }
    for (;;)
    {
      parame = (d)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().He(parame.GAm.icon).c(this.kc);
        AppMethodBeat.o(191280);
        return;
      }
      AppMethodBeat.o(191280);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.h
 * JD-Core Version:    0.7.0.1
 */