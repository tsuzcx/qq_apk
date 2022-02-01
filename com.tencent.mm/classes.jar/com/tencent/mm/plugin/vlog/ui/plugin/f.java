package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicAddEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "order", "Landroid/widget/TextView;", "getOrder", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends i
{
  private final TextView Uip;
  private final ImageView dpM;
  
  public f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(282407);
    View localView = paramView.findViewById(a.f.item_magic_panel_icon);
    s.s(localView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.dpM = ((ImageView)localView);
    paramView = paramView.findViewById(a.f.item_magic_panel_order);
    s.s(paramView, "itemView.findViewById(R.id.item_magic_panel_order)");
    this.Uip = ((TextView)paramView);
    AppMethodBeat.o(282407);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(282415);
    s.u(parame, "item");
    if ((parame instanceof com.tencent.mm.plugin.vlog.model.effect.b)) {}
    for (parame = (com.tencent.mm.plugin.vlog.model.effect.b)parame;; parame = null)
    {
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.noo;
        com.tencent.mm.loader.e.blh().GD(parame.Ubx.icon).d(this.dpM);
        this.Uip.setText((CharSequence)String.valueOf(parame.order));
      }
      AppMethodBeat.o(282415);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */