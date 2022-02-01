package com.tencent.mm.plugin.vlog.model.panel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.plugin.vlog.a.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getItemViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "", "plugin-vlog_release"})
public final class h
  implements com.tencent.mm.emoji.b.b.p
{
  private final com.tencent.mm.emoji.panel.a.p jLP;
  
  public h(com.tencent.mm.emoji.panel.a.p paramp)
  {
    AppMethodBeat.i(230323);
    this.jLP = paramp;
    AppMethodBeat.o(230323);
  }
  
  public final s<?> e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(230320);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.item_pag_panel, paramViewGroup, false);
    kotlin.g.b.p.j(paramViewGroup, "itemView");
    paramViewGroup = (s)new g(paramViewGroup, this.jLP);
    AppMethodBeat.o(230320);
    return paramViewGroup;
  }
  
  public final int mg()
  {
    AppMethodBeat.i(230317);
    int i = b.gua();
    AppMethodBeat.o(230317);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.h
 * JD-Core Version:    0.7.0.1
 */