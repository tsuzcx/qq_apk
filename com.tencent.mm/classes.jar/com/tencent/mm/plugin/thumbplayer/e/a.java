package com.tencent.mm.plugin.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errType", "getErrType", "setErrType", "firstFrameCost", "", "getFirstFrameCost", "()J", "setFirstFrameCost", "(J)V", "hasError", "", "getHasError", "()Z", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "playTime", "getPlayTime", "setPlayTime", "renderPtsNegative", "getRenderPtsNegative", "setRenderPtsNegative", "renderPtsOutOfBound", "getRenderPtsOutOfBound", "setRenderPtsOutOfBound", "renderTime", "getRenderTime", "setRenderTime", "startTick", "getStartTick", "setStartTick", "waitCount", "getWaitCount", "setWaitCount", "waitStartTick", "waitTimeSum", "getWaitTimeSum", "setWaitTimeSum", "firstFrameRendered", "", "reset", "start", "stop", "toString", "waitEnd", "waitStart", "plugin-thumbplayer_release"})
public final class a
{
  public int MSn;
  public long MSo;
  public long MSp;
  int MSq;
  int MSr;
  int MSs;
  public int errCode = 1000;
  public int errType;
  private String id = "";
  public long jID;
  public long tJV;
  long zXw;
  
  public final boolean gon()
  {
    return this.errCode != 1000;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191843);
    this.zXw = Util.ticksToNow(this.jID);
    AppMethodBeat.o(191843);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191849);
    String str = "start:" + this.jID + ", stop:" + this.zXw + ", firstFrame:" + this.tJV + "; wait:" + this.MSn + ",cost:" + this.MSo;
    AppMethodBeat.o(191849);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.a
 * JD-Core Version:    0.7.0.1
 */