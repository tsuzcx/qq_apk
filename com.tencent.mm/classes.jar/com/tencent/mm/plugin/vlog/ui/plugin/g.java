package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.effect.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicEffectItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends i
{
  private final ImageView dpM;
  
  public g(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(282391);
    paramView = paramView.findViewById(a.f.item_magic_panel_icon);
    s.s(paramView, "itemView.findViewById(R.id.item_magic_panel_icon)");
    this.dpM = ((ImageView)paramView);
    AppMethodBeat.o(282391);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.effect.e parame)
  {
    AppMethodBeat.i(282401);
    s.u(parame, "item");
    if ((parame instanceof d)) {}
    for (parame = (d)parame;; parame = null)
    {
      if (parame != null)
      {
        com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.noo;
        com.tencent.mm.loader.e.blh().GD(parame.Ubx.icon).d(this.dpM);
      }
      AppMethodBeat.o(282401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */