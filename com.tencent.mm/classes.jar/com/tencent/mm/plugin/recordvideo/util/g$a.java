package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "useABA", "bitrateAdaptiveUp", "useMinMaxQP", "(IIIIIIZIII)V", "getBitrateAdaptiveUp", "()I", "setBitrateAdaptiveUp", "(I)V", "getDuration", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getUseABA", "getUseMinMaxQP", "getVideoBitrate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  public final boolean Obv;
  private final int Obw;
  public int Obx;
  private final int Oby;
  public final int duration;
  public final int fps;
  public final int hYK;
  public final int height;
  public final int videoBitrate;
  public final int width;
  
  public g$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, int paramInt8, int paramInt9)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.duration = paramInt3;
    this.hYK = paramInt4;
    this.videoBitrate = paramInt5;
    this.fps = paramInt6;
    this.Obv = paramBoolean;
    this.Obw = paramInt7;
    this.Obx = paramInt8;
    this.Oby = paramInt9;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
      if (this.height != paramObject.height) {
        return false;
      }
      if (this.duration != paramObject.duration) {
        return false;
      }
      if (this.hYK != paramObject.hYK) {
        return false;
      }
      if (this.videoBitrate != paramObject.videoBitrate) {
        return false;
      }
      if (this.fps != paramObject.fps) {
        return false;
      }
      if (this.Obv != paramObject.Obv) {
        return false;
      }
      if (this.Obw != paramObject.Obw) {
        return false;
      }
      if (this.Obx != paramObject.Obx) {
        return false;
      }
    } while (this.Oby == paramObject.Oby);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76219);
    String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.hYK + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.Obv + ", useABA=" + this.Obw + ", bitrateAdaptiveUp=" + this.Obx + ", useMinMaxQP=" + this.Oby + ')';
    AppMethodBeat.o(76219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.g.a
 * JD-Core Version:    0.7.0.1
 */