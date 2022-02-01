package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g
{
  public static final b.a UoX;
  
  static
  {
    AppMethodBeat.i(281690);
    UoX = new b.a((byte)0);
    AppMethodBeat.o(281690);
  }
  
  public final c a(a parama, Object paramObject)
  {
    AppMethodBeat.i(281695);
    s.u(parama, "trackInfo");
    if (!(parama instanceof h))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TrackThumbInfo".toString());
      AppMethodBeat.o(281695);
      throw parama;
    }
    paramObject = com.tencent.mm.videocomposition.a.agDr;
    parama = (c)a.a.d(((h)parama).Uqg.UaI);
    AppMethodBeat.o(281695);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */