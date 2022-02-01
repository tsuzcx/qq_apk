package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "videoStartTime", "", "videoEndTime", "reverse", "", "playSpeed", "", "startTime", "endTime", "(Ljava/lang/String;JJZFJJ)V", "getPlaySpeed", "()F", "getReverse", "()Z", "getVideoEndTime", "()J", "setVideoEndTime", "(J)V", "getVideoStartTime", "setVideoStartTime", "plugin-vlog_release"})
public final class aj
  extends s
{
  public long GzW;
  public long GzX;
  private final float GzY;
  private final boolean reverse;
  
  public aj(String paramString, long paramLong1, boolean paramBoolean, float paramFloat, long paramLong2, long paramLong3)
  {
    super(y.GyZ, l.GxQ, ab.Gzk, paramLong2, paramLong3, 0L - paramLong1, paramString, 384);
    AppMethodBeat.i(110950);
    this.GzW = paramLong1;
    this.GzX = 0L;
    this.reverse = paramBoolean;
    this.GzY = paramFloat;
    AppMethodBeat.o(110950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.aj
 * JD-Core Version:    0.7.0.1
 */