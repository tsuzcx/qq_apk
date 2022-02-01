package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "frameWidth", "", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "isDragLeft", "", "()Z", "setDragLeft", "(Z)V", "isDragRight", "setDragRight", "segmentStartTimeMs", "", "getSegmentStartTimeMs", "()J", "setSegmentStartTimeMs", "(J)V", "totalDuration", "getTotalDuration", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfoForTotalDuration", "Companion", "plugin-vlog_release"})
public final class h
  extends a
{
  private static final ad GQd;
  public static final a GQe;
  long GPZ;
  boolean GQa;
  boolean GQb;
  public final ad GQc;
  int kxW;
  public int trackIndex;
  
  static
  {
    AppMethodBeat.i(192163);
    GQe = new a((byte)0);
    GQd = new ad("", 0);
    AppMethodBeat.o(192163);
  }
  
  public h(ad paramad)
  {
    AppMethodBeat.i(192162);
    this.GQc = paramad;
    this.trackIndex = -1;
    this.kxW = 1;
    if (this.GQc.GzA.Rhd >= 0L) {
      this.GOD = (this.GQc.GzA.GGz + (this.GQc.GzA.Rhd - this.GQc.GzA.startTimeMs));
    }
    if (this.GQc.GzA.Rhe >= 0L) {
      this.GOE = (this.GQc.GzA.GGA + (this.GQc.GzA.Rhe - this.GQc.GzA.endTimeMs));
    }
    AppMethodBeat.o(192162);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(192161);
    if (!p.j(this.GQc, GQd)) {
      if (((CharSequence)this.GQc.path).length() != 0) {
        break label49;
      }
    }
    label49:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192161);
      return true;
    }
    AppMethodBeat.o(192161);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static h fEy()
    {
      AppMethodBeat.i(192160);
      h localh = new h(h.fEx());
      localh.hEp = 0;
      AppMethodBeat.o(192160);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.h
 * JD-Core Version:    0.7.0.1
 */