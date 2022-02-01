package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errType", "getErrType", "setErrType", "firstFrameCost", "", "getFirstFrameCost", "()J", "setFirstFrameCost", "(J)V", "hasError", "", "getHasError", "()Z", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "playTime", "getPlayTime", "setPlayTime", "renderPtsNegative", "getRenderPtsNegative", "setRenderPtsNegative", "renderPtsOutOfBound", "getRenderPtsOutOfBound", "setRenderPtsOutOfBound", "renderTime", "getRenderTime", "setRenderTime", "startTick", "getStartTick", "setStartTick", "waitCount", "getWaitCount", "setWaitCount", "waitStartTick", "waitTimeSum", "getWaitTimeSum", "setWaitTimeSum", "firstFrameRendered", "", "reset", "start", "stop", "toString", "waitEnd", "waitStart", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  long Ftc;
  public int TEH;
  public long TEI;
  public long TEJ;
  int TEK;
  int TEL;
  int TEM;
  public int errCode = 1000;
  public int errType;
  private String id = "";
  public long moe;
  public long wNr;
  
  public final boolean hLa()
  {
    return this.errCode != 1000;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272067);
    this.Ftc = Util.ticksToNow(this.moe);
    AppMethodBeat.o(272067);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272072);
    String str = "start:" + this.moe + ", stop:" + this.Ftc + ", firstFrame:" + this.wNr + "; wait:" + this.TEH + ",cost:" + this.TEI;
    AppMethodBeat.o(272072);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */