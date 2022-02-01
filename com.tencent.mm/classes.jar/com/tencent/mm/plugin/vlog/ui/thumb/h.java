package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "originTrack", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "enableStart", "", "enableEnd", "(Lcom/tencent/mm/videocomposition/CompositionTrack;ZZ)V", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "endTimeMs", "", "getEndTimeMs", "()J", "playRate", "", "getPlayRate", "()F", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "cropToPlayRange", "", "start", "end", "isEmpty", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends a
{
  public static final a Uqf;
  private static final ad Uqh;
  public final ad Uqg;
  
  static
  {
    AppMethodBeat.i(281632);
    Uqf = new a((byte)0);
    Uqh = new ad("", 0);
    AppMethodBeat.o(281632);
  }
  
  public h(ad paramad)
  {
    AppMethodBeat.i(281610);
    this.Uqg = paramad;
    if (this.Uqg.UaI.agDB >= 0L) {
      this.UoP = (this.Uqg.UaI.TDw + (this.Uqg.UaI.agDB - this.Uqg.UaI.startTimeMs));
    }
    if (this.Uqg.UaI.agDC >= 0L) {
      this.UoQ = (this.Uqg.UaI.TDx + (this.Uqg.UaI.agDC - this.Uqg.UaI.endTimeMs));
    }
    AppMethodBeat.o(281610);
  }
  
  public h(b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(new ad(paramb.path, paramb.type, 0));
    AppMethodBeat.i(281618);
    this.UoP = paramb.TDw;
    this.UoQ = (paramb.TDx - paramb.TDy.duration);
    if (paramBoolean1) {
      this.UoP = 0L;
    }
    if (paramBoolean2) {
      this.UoQ = paramb.UjZ;
    }
    AppMethodBeat.o(281618);
  }
  
  public final long getEndTimeMs()
  {
    return this.Uqg.UaI.endTimeMs;
  }
  
  public final float getPlayRate()
  {
    return this.Uqg.UaI.sAn;
  }
  
  public final long getStartTimeMs()
  {
    return this.Uqg.UaI.startTimeMs;
  }
  
  public long getTotalDuration()
  {
    return this.Uqg.UaI.UjZ;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(281662);
    if (!s.p(this.Uqg, Uqh)) {
      if (((CharSequence)this.Uqg.path).length() != 0) {
        break label49;
      }
    }
    label49:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(281662);
      return true;
    }
    AppMethodBeat.o(281662);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static h hUs()
    {
      AppMethodBeat.i(281708);
      h localh = new h(h.hUr());
      localh.mWn = 0;
      AppMethodBeat.o(281708);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.h
 * JD-Core Version:    0.7.0.1
 */