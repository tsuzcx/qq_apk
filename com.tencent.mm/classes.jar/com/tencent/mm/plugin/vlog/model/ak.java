package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "videoStartTime", "", "videoEndTime", "reverse", "", "playSpeed", "", "startTime", "endTime", "(Ljava/lang/String;JJZFJJ)V", "getPlaySpeed", "()F", "getReverse", "()Z", "getVideoEndTime", "()J", "setVideoEndTime", "(J)V", "getVideoStartTime", "setVideoStartTime", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends s
{
  public long Ubf;
  public long Ubg;
  private final float Ubh;
  private final boolean reverse;
  
  public ak(String paramString, long paramLong1, boolean paramBoolean, float paramFloat, long paramLong2, long paramLong3)
  {
    super(y.Uad, l.TYU, aa.Uao, paramLong2, paramLong3, 0L - paramLong1, paramString, 384);
    AppMethodBeat.i(110950);
    this.Ubf = paramLong1;
    this.Ubg = 0L;
    this.reverse = paramBoolean;
    this.Ubh = paramFloat;
    AppMethodBeat.o(110950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ak
 * JD-Core Version:    0.7.0.1
 */