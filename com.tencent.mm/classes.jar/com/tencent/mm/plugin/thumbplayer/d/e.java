package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.d.a.b;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.videocomposition.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "", "()V", "endTimeMs", "", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "playRate", "", "getPlayRate", "()F", "setPlayRate", "(F)V", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "type", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "getType", "()Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "setType", "(Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;)V", "plugin-thumbplayer_release"})
public final class e
{
  public d GhE;
  b MQU;
  public long MQV;
  long MQW;
  g MQX;
  long endTimeMs;
  float pvh;
  public long startTimeMs;
  
  public e()
  {
    AppMethodBeat.i(191045);
    this.MQU = b.MRL;
    this.MQV = -1L;
    this.MQW = -1L;
    this.pvh = 1.0F;
    this.MQX = new g();
    AppMethodBeat.o(191045);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(191039);
    p.k(paramb, "<set-?>");
    this.MQU = paramb;
    AppMethodBeat.o(191039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.e
 * JD-Core Version:    0.7.0.1
 */