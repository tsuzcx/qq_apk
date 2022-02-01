package com.tencent.mm.plugin.vlog.model.panel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getItemViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "", "plugin-vlog_release"})
public final class h
  implements com.tencent.mm.emoji.b.b.p
{
  private final n haK;
  
  public h(n paramn)
  {
    AppMethodBeat.i(190800);
    this.haK = paramn;
    AppMethodBeat.o(190800);
  }
  
  public final q<?> d(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(190799);
    kotlin.g.b.p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495123, paramViewGroup, false);
    kotlin.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new g(paramViewGroup, this.haK);
    AppMethodBeat.o(190799);
    return paramViewGroup;
  }
  
  public final int lU()
  {
    AppMethodBeat.i(190798);
    int i = b.fCc();
    AppMethodBeat.o(190798);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.h
 * JD-Core Version:    0.7.0.1
 */