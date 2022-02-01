package com.tencent.mm.plugin.mv.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "cropToPlayRange", "", "start", "", "end", "isEmpty", "", "Companion", "plugin-mv_release"})
public final class c
  extends com.tencent.mm.plugin.vlog.ui.thumb.a
{
  public static final c.a AsB;
  final com.tencent.mm.plugin.thumbplayer.d.a AsA;
  
  static
  {
    AppMethodBeat.i(257068);
    AsB = new c.a((byte)0);
    AppMethodBeat.o(257068);
  }
  
  public c(com.tencent.mm.plugin.thumbplayer.d.a parama)
  {
    AppMethodBeat.i(257067);
    this.AsA = parama;
    this.GOD = 0L;
    this.GOE = this.AsA.pLQ;
    this.GOF = ((float)fEu() / 1000.0F);
    AppMethodBeat.o(257067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.c
 * JD-Core Version:    0.7.0.1
 */