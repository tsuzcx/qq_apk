package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "originTrack", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "enableStart", "", "enableEnd", "(Lcom/tencent/mm/videocomposition/CompositionTrack;ZZ)V", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "endTimeMs", "", "getEndTimeMs", "()J", "playRate", "", "getPlayRate", "()F", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "cropToPlayRange", "", "start", "end", "isEmpty", "Companion", "plugin-vlog_release"})
public class h
  extends a
{
  private static final ad NDJ;
  public static final a NDK;
  public final ad NDI;
  
  static
  {
    AppMethodBeat.i(230709);
    NDK = new a((byte)0);
    NDJ = new ad("", 0);
    AppMethodBeat.o(230709);
  }
  
  public h(ad paramad)
  {
    AppMethodBeat.i(230701);
    this.NDI = paramad;
    if (this.NDI.Nng.YHU >= 0L) {
      this.NCj = (this.NDI.Nng.MQV + (this.NDI.Nng.YHU - this.NDI.Nng.startTimeMs));
    }
    if (this.NDI.Nng.YHV >= 0L) {
      this.NCk = (this.NDI.Nng.MQW + (this.NDI.Nng.YHV - this.NDI.Nng.endTimeMs));
    }
    AppMethodBeat.o(230701);
  }
  
  public h(b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(new ad(paramb.path, paramb.type, 0));
    AppMethodBeat.i(230704);
    this.NCj = paramb.MQV;
    this.NCk = (paramb.MQW - paramb.MQX.duration);
    if (paramBoolean1) {
      this.NCj = 0L;
    }
    if (paramBoolean2) {
      this.NCk = paramb.NwS;
    }
    AppMethodBeat.o(230704);
  }
  
  public final long getEndTimeMs()
  {
    return this.NDI.Nng.endTimeMs;
  }
  
  public final float getPlayRate()
  {
    return this.NDI.Nng.pvh;
  }
  
  public final long getStartTimeMs()
  {
    return this.NDI.Nng.startTimeMs;
  }
  
  public long getTotalDuration()
  {
    return this.NDI.Nng.NwS;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(230696);
    if (!p.h(this.NDI, NDJ)) {
      if (((CharSequence)this.NDI.path).length() != 0) {
        break label49;
      }
    }
    label49:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(230696);
      return true;
    }
    AppMethodBeat.o(230696);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static h gwz()
    {
      AppMethodBeat.i(246728);
      h localh = new h(h.gwy());
      localh.ksu = 0;
      AppMethodBeat.o(246728);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.h
 * JD-Core Version:    0.7.0.1
 */