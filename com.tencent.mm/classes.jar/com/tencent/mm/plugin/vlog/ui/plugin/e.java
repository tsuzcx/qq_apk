package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class e
  extends h
{
  private final TextView BNk;
  private final ImageView ka;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(196203);
    View localView = paramView.findViewById(2131308333);
    p.g(localView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.ka = ((ImageView)localView);
    paramView = paramView.findViewById(2131308334);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_order)");
    this.BNk = ((TextView)paramView);
    AppMethodBeat.o(196203);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(196202);
    p.h(parame, "item");
    if (!(parame instanceof com.tencent.mm.plugin.vlog.model.effect.b)) {
      parame = null;
    }
    for (;;)
    {
      parame = (com.tencent.mm.plugin.vlog.model.effect.b)parame;
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hcm;
        com.tencent.mm.loader.e.aqF().xV(parame.BHg.dDH).c(this.ka);
        this.BNk.setText((CharSequence)String.valueOf(parame.order));
        AppMethodBeat.o(196202);
        return;
      }
      AppMethodBeat.o(196202);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */