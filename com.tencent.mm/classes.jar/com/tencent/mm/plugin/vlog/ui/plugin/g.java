package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class g
  extends j
{
  private final ImageView kc;
  private final TextView utK;
  
  public g(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191279);
    View localView = paramView.findViewById(2131302832);
    p.g(localView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.kc = ((ImageView)localView);
    paramView = paramView.findViewById(2131302833);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_order)");
    this.utK = ((TextView)paramView);
    AppMethodBeat.o(191279);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(191278);
    p.h(parame, "item");
    if (!(parame instanceof com.tencent.mm.plugin.vlog.model.effect.b)) {
      parame = null;
    }
    for (;;)
    {
      parame = (com.tencent.mm.plugin.vlog.model.effect.b)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().He(parame.GAm.icon).c(this.kc);
        this.utK.setText((CharSequence)String.valueOf(parame.order));
        AppMethodBeat.o(191278);
        return;
      }
      AppMethodBeat.o(191278);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */