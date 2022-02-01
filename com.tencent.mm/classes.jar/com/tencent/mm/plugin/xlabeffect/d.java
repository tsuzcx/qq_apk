package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/XEffectReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "initCost", "", "getInitCost", "()J", "setInitCost", "(J)V", "initStart", "lastRenderStart", "lastTrackStart", "renderCost", "getRenderCost", "renderCostSum", "getRenderCostSum", "setRenderCostSum", "renderCount", "getRenderCount", "setRenderCount", "trackCost", "getTrackCost", "trackCostSum", "getTrackCostSum", "setTrackCostSum", "trackCount", "getTrackCount", "setTrackCount", "destroy", "", "faceTrackEnd", "faceTrackStart", "initEnd", "initError", "renderEnd", "renderStart", "plugin-xlabeffect_release"})
public final class d
{
  public long QPG;
  long QPH;
  long QPI;
  long QPJ;
  public int errCode;
  private long kYp;
  private int kYq;
  long kYr;
  int trackCount;
  
  public final long aVi()
  {
    if (this.kYq == 0) {
      return 0L;
    }
    return this.kYp / this.kYq;
  }
  
  public final long heX()
  {
    if (this.trackCount == 0) {
      return 0L;
    }
    return this.QPH / this.trackCount;
  }
  
  public final void heY()
  {
    AppMethodBeat.i(186905);
    this.kYq += 1;
    this.kYp += Util.ticksToNow(this.kYr);
    AppMethodBeat.o(186905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.d
 * JD-Core Version:    0.7.0.1
 */