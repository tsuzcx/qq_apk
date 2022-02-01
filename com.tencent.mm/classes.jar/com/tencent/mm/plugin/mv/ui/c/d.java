package com.tencent.mm.plugin.mv.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.thumb.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "endTimeMs", "", "getEndTimeMs", "()J", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "playRate", "", "getPlayRate", "()F", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "cropToPlayRange", "", "start", "end", "isEmpty", "", "Companion", "plugin-mv_release"})
public final class d
  extends a
{
  public static final d.a GhF;
  public final com.tencent.mm.plugin.thumbplayer.e.d GhE;
  
  static
  {
    AppMethodBeat.i(229359);
    GhF = new d.a((byte)0);
    AppMethodBeat.o(229359);
  }
  
  public d(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(229357);
    this.GhE = paramd;
    this.NCj = 0L;
    this.NCk = this.GhE.sTg;
    this.NCl = ((float)gwv() / 1000.0F);
    AppMethodBeat.o(229357);
  }
  
  public final long getEndTimeMs()
  {
    return this.GhE.MSE + this.GhE.MSF;
  }
  
  public final float getPlayRate()
  {
    return 1.0F;
  }
  
  public final long getStartTimeMs()
  {
    return this.GhE.MSE;
  }
  
  public final long getTotalDuration()
  {
    return this.GhE.sTg;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(229354);
    if (((CharSequence)this.GhE.path).length() == 0)
    {
      AppMethodBeat.o(229354);
      return true;
    }
    AppMethodBeat.o(229354);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.c.d
 * JD-Core Version:    0.7.0.1
 */