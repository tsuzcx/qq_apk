package com.tencent.mm.plugin.vlog.model.panel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getItemViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "", "plugin-vlog_release"})
public final class h
  implements com.tencent.mm.emoji.a.b.p
{
  private final n gpR;
  
  public h(n paramn)
  {
    AppMethodBeat.i(191340);
    this.gpR = paramn;
    AppMethodBeat.o(191340);
  }
  
  public final q<?> d(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(191339);
    d.g.b.p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496470, paramViewGroup, false);
    d.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new g(paramViewGroup, this.gpR);
    AppMethodBeat.o(191339);
    return paramViewGroup;
  }
  
  public final int lQ()
  {
    AppMethodBeat.i(191338);
    int i = b.ewh();
    AppMethodBeat.o(191338);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.h
 * JD-Core Version:    0.7.0.1
 */