package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "Companion", "plugin-vlog_release"})
public final class b
  implements g
{
  public static final a NCr;
  
  static
  {
    AppMethodBeat.i(235258);
    NCr = new a((byte)0);
    AppMethodBeat.o(235258);
  }
  
  public final c a(a parama, Object paramObject)
  {
    AppMethodBeat.i(235254);
    p.k(parama, "trackInfo");
    if (!(parama instanceof h))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TrackThumbInfo".toString());
      AppMethodBeat.o(235254);
      throw parama;
    }
    paramObject = com.tencent.mm.videocomposition.a.YHM;
    parama = (c)a.a.d(((h)parama).NDI.Nng);
    AppMethodBeat.o(235254);
    return parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */