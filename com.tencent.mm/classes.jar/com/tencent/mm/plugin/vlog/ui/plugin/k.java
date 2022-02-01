package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.plugin.vlog.model.effect.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTitleItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"})
public final class k
  extends i
{
  private final TextView jMg;
  
  public k(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(231273);
    paramView = paramView.findViewById(a.f.item_magic_panel_title);
    p.j(paramView, "itemView.findViewById(R.id.item_magic_panel_title)");
    this.jMg = ((TextView)paramView);
    AppMethodBeat.o(231273);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(231269);
    p.k(parame, "item");
    if (!(parame instanceof f)) {
      parame = null;
    }
    for (;;)
    {
      parame = (f)parame;
      if (parame != null)
      {
        this.jMg.setText((CharSequence)parame.title);
        AppMethodBeat.o(231269);
        return;
      }
      AppMethodBeat.o(231269);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.k
 * JD-Core Version:    0.7.0.1
 */