package com.tencent.mm.plugin.vlog.model.panel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.p;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.plugin.vlog.a.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getItemViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements p
{
  private final n mkY;
  
  public h(n paramn)
  {
    AppMethodBeat.i(283653);
    this.mkY = paramn;
    AppMethodBeat.o(283653);
  }
  
  public final int aVs()
  {
    AppMethodBeat.i(283658);
    int i = b.hRI();
    AppMethodBeat.o(283658);
    return i;
  }
  
  public final q<?> h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(283666);
    s.u(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.item_pag_panel, paramViewGroup, false);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (q)new g(paramViewGroup, this.mkY);
    AppMethodBeat.o(283666);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.h
 * JD-Core Version:    0.7.0.1
 */