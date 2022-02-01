package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/XEffectReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "initCost", "", "getInitCost", "()J", "setInitCost", "(J)V", "initStart", "lastRenderStart", "lastTrackStart", "renderCost", "getRenderCost", "renderCostSum", "getRenderCostSum", "setRenderCostSum", "renderCount", "getRenderCount", "setRenderCount", "trackCost", "getTrackCost", "trackCostSum", "getTrackCostSum", "setTrackCostSum", "trackCount", "getTrackCount", "setTrackCount", "destroy", "", "faceTrackEnd", "faceTrackStart", "initEnd", "initError", "renderEnd", "renderStart", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public long XKP;
  long XKQ;
  long XKR;
  long XKS;
  public int errCode;
  private long nDw;
  private int nDx;
  long nDy;
  int trackCount;
  
  public final long bpQ()
  {
    if (this.nDx == 0) {
      return 0L;
    }
    return this.nDw / this.nDx;
  }
  
  public final long iFY()
  {
    if (this.trackCount == 0) {
      return 0L;
    }
    return this.XKQ / this.trackCount;
  }
  
  public final void iFZ()
  {
    AppMethodBeat.i(261638);
    this.nDx += 1;
    this.nDw += Util.ticksToNow(this.nDy);
    AppMethodBeat.o(261638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.j
 * JD-Core Version:    0.7.0.1
 */