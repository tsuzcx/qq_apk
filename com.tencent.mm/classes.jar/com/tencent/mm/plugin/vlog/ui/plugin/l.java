package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.plugin.vlog.model.effect.f;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTitleItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class l
  extends j
{
  private final TextView hbb;
  
  public l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(191310);
    paramView = paramView.findViewById(2131302834);
    p.g(paramView, "itemView.findViewById(R.id.item_magic_panel_title)");
    this.hbb = ((TextView)paramView);
    AppMethodBeat.o(191310);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(191309);
    p.h(parame, "item");
    if (!(parame instanceof f)) {
      parame = null;
    }
    for (;;)
    {
      parame = (f)parame;
      if (parame != null)
      {
        this.hbb.setText((CharSequence)parame.title);
        AppMethodBeat.o(191309);
        return;
      }
      AppMethodBeat.o(191309);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.l
 * JD-Core Version:    0.7.0.1
 */