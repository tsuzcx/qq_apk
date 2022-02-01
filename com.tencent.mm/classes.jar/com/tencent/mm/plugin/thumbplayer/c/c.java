package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "", "()V", "endTimeMs", "", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;)V", "playRate", "", "getPlayRate", "()F", "setPlayRate", "(F)V", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "type", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "getType", "()Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "setType", "(Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;)V", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public com.tencent.mm.plugin.thumbplayer.a.b GvR;
  com.tencent.mm.plugin.thumbplayer.c.a.b TDv;
  public long TDw;
  long TDx;
  g TDy;
  long endTimeMs;
  float sAn;
  public long startTimeMs;
  
  public c()
  {
    AppMethodBeat.i(272463);
    this.TDv = com.tencent.mm.plugin.thumbplayer.c.a.b.TEi;
    this.TDw = -1L;
    this.TDx = -1L;
    this.sAn = 1.0F;
    this.TDy = new g();
    AppMethodBeat.o(272463);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.c.a.b paramb)
  {
    AppMethodBeat.i(272470);
    s.u(paramb, "<set-?>");
    this.TDv = paramb;
    AppMethodBeat.o(272470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */