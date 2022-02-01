package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.plugin.vlog.model.effect.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTitleItemViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends i
{
  private final TextView mll;
  
  public k(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(282319);
    paramView = paramView.findViewById(a.f.item_magic_panel_title);
    s.s(paramView, "itemView.findViewById(R.id.item_magic_panel_title)");
    this.mll = ((TextView)paramView);
    AppMethodBeat.o(282319);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(282329);
    s.u(parame, "item");
    if ((parame instanceof f)) {}
    for (parame = (f)parame;; parame = null)
    {
      if (parame != null) {
        this.mll.setText((CharSequence)parame.title);
      }
      AppMethodBeat.o(282329);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.k
 * JD-Core Version:    0.7.0.1
 */