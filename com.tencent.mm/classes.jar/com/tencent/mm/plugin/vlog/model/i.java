package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "videoStartTime", "", "videoEndTime", "reverse", "", "playSpeed", "", "startTime", "endTime", "(Ljava/lang/String;JJZFJJ)V", "getPlaySpeed", "()F", "getReverse", "()Z", "getVideoEndTime", "()J", "setVideoEndTime", "(J)V", "getVideoStartTime", "setVideoStartTime", "plugin-vlog_release"})
public final class i
  extends d
{
  private final boolean reverse;
  public long yZx;
  public long yZy;
  private final float yZz;
  
  public i(String paramString, long paramLong1, boolean paramBoolean, float paramFloat, long paramLong2, long paramLong3)
  {
    super(e.yZh, a.yYW, f.yZm, paramLong2, paramLong3, 0L - paramLong1, paramString, 384);
    AppMethodBeat.i(110950);
    this.yZx = paramLong1;
    this.yZy = 0L;
    this.reverse = paramBoolean;
    this.yZz = paramFloat;
    AppMethodBeat.o(110950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.i
 * JD-Core Version:    0.7.0.1
 */