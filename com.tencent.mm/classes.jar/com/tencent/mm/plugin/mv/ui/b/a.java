package com.tencent.mm.plugin.mv.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-mv_release"})
public final class a
  implements com.tencent.mm.plugin.vlog.ui.thumb.g
{
  public final com.tencent.mm.videocomposition.g a(com.tencent.mm.plugin.vlog.ui.thumb.a parama, Object paramObject)
  {
    AppMethodBeat.i(257042);
    p.h(parama, "trackInfo");
    if (!(parama instanceof c))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TPTrackThumbInfo".toString());
      AppMethodBeat.o(257042);
      throw parama;
    }
    if (!(paramObject instanceof b.b))
    {
      parama = (Throwable)new IllegalStateException("not set resourceLoader".toString());
      AppMethodBeat.o(257042);
      throw parama;
    }
    parama = (com.tencent.mm.videocomposition.g)new b((c)parama, (b.b)paramObject);
    AppMethodBeat.o(257042);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.a
 * JD-Core Version:    0.7.0.1
 */