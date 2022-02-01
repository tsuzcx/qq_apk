package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "Companion", "plugin-vlog_release"})
public final class b
  implements g
{
  public static final b.a GOI;
  
  static
  {
    AppMethodBeat.i(192026);
    GOI = new b.a((byte)0);
    AppMethodBeat.o(192026);
  }
  
  public final com.tencent.mm.videocomposition.g a(a parama, Object paramObject)
  {
    AppMethodBeat.i(192025);
    p.h(parama, "trackInfo");
    if (!(parama instanceof h))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TrackThumbInfo".toString());
      AppMethodBeat.o(192025);
      throw parama;
    }
    paramObject = c.RgU;
    parama = (com.tencent.mm.videocomposition.g)c.a.b(((h)parama).GQc.GzA);
    AppMethodBeat.o(192025);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */