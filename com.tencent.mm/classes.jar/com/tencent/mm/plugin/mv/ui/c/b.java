package com.tencent.mm.plugin.mv.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.f.b.b;
import com.tencent.mm.plugin.vlog.ui.thumb.a;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-mv_release"})
public final class b
  implements g
{
  public final com.tencent.mm.videocomposition.c a(a parama, Object paramObject)
  {
    AppMethodBeat.i(242258);
    p.k(parama, "trackInfo");
    if (!(parama instanceof d))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TPTrackThumbInfo".toString());
      AppMethodBeat.o(242258);
      throw parama;
    }
    if (!(paramObject instanceof b.b))
    {
      parama = (Throwable)new IllegalStateException("not set resourceLoader".toString());
      AppMethodBeat.o(242258);
      throw parama;
    }
    parama = (com.tencent.mm.videocomposition.c)new c((d)parama, (b.b)paramObject);
    AppMethodBeat.o(242258);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.c.b
 * JD-Core Version:    0.7.0.1
 */