package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.plugin.vlog.model.effect.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTitleItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class j
  extends h
{
  private final TextView gqi;
  
  public j(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191693);
    paramView = paramView.findViewById(2131308335);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_title)");
    this.gqi = ((TextView)paramView);
    AppMethodBeat.o(191693);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(191692);
    p.h(parame, "item");
    if (!(parame instanceof f)) {
      parame = null;
    }
    for (;;)
    {
      parame = (f)parame;
      if (parame != null)
      {
        this.gqi.setText((CharSequence)parame.title);
        AppMethodBeat.o(191692);
        return;
      }
      AppMethodBeat.o(191692);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.j
 * JD-Core Version:    0.7.0.1
 */