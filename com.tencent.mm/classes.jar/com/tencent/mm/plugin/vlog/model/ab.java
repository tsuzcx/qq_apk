package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "videoStartTime", "", "videoEndTime", "reverse", "", "playSpeed", "", "startTime", "endTime", "(Ljava/lang/String;JJZFJJ)V", "getPlaySpeed", "()F", "getReverse", "()Z", "getVideoEndTime", "()J", "setVideoEndTime", "(J)V", "getVideoStartTime", "setVideoStartTime", "plugin-vlog_release"})
public final class ab
  extends l
{
  public long BYp;
  public long BYq;
  private final float BYr;
  private final boolean reverse;
  
  public ab(String paramString, long paramLong1, boolean paramBoolean, float paramFloat, long paramLong2, long paramLong3)
  {
    super(r.BXu, h.BWD, u.BXF, paramLong2, paramLong3, 0L - paramLong1, paramString, 384);
    AppMethodBeat.i(110950);
    this.BYp = paramLong1;
    this.BYq = 0L;
    this.reverse = paramBoolean;
    this.BYr = paramFloat;
    AppMethodBeat.o(110950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */