package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errType", "getErrType", "setErrType", "firstFrameCost", "", "getFirstFrameCost", "()J", "setFirstFrameCost", "(J)V", "hasError", "", "getHasError", "()Z", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "playTime", "getPlayTime", "setPlayTime", "renderPtsNegative", "getRenderPtsNegative", "setRenderPtsNegative", "renderPtsOutOfBound", "getRenderPtsOutOfBound", "setRenderPtsOutOfBound", "renderTime", "getRenderTime", "setRenderTime", "startTick", "getStartTick", "setStartTick", "waitCount", "getWaitCount", "setWaitCount", "waitStartTick", "waitTimeSum", "getWaitTimeSum", "setWaitTimeSum", "firstFrameRendered", "", "reset", "start", "stop", "toString", "waitEnd", "waitStart", "plugin-thumbplayer_release"})
public final class b
{
  public long UsY;
  public int UsZ;
  public long Uta;
  public long Utb;
  int Utc;
  int Utd;
  int Ute;
  public int errCode = 1000;
  public int errType;
  public long gXF;
  private String id = "";
  long vgo;
  
  public final boolean gWN()
  {
    return this.errCode != 1000;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(258711);
    this.vgo = Util.ticksToNow(this.gXF);
    AppMethodBeat.o(258711);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258712);
    String str = "start:" + this.gXF + ", stop:" + this.vgo + ", firstFrame:" + this.UsY + "; wait:" + this.UsZ + ",cost:" + this.Uta;
    AppMethodBeat.o(258712);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.b
 * JD-Core Version:    0.7.0.1
 */