package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "videoStartTime", "", "videoEndTime", "reverse", "", "playSpeed", "", "startTime", "endTime", "(Ljava/lang/String;JJZFJJ)V", "getPlaySpeed", "()F", "getReverse", "()Z", "getVideoEndTime", "()J", "setVideoEndTime", "(J)V", "getVideoStartTime", "setVideoStartTime", "plugin-vlog_release"})
public final class z
  extends i
{
  public long Apa;
  public long Apb;
  private final float Apc;
  private final boolean reverse;
  
  public z(String paramString, long paramLong1, boolean paramBoolean, float paramFloat, long paramLong2, long paramLong3)
  {
    super(m.AnD, e.AmS, q.AnO, paramLong2, paramLong3, 0L - paramLong1, paramString, 384);
    AppMethodBeat.i(110950);
    this.Apa = paramLong1;
    this.Apb = 0L;
    this.reverse = paramBoolean;
    this.Apc = paramFloat;
    AppMethodBeat.o(110950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */