package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "useABA", "bitrateAdaptiveUp", "useMinMaxQP", "(IIIIIIZIII)V", "getBitrateAdaptiveUp", "()I", "getDuration", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getUseABA", "getUseMinMaxQP", "getVideoBitrate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
public final class c$a
{
  public final int dHi;
  public final int duration;
  public final int fps;
  public final int height;
  public final int videoBitrate;
  public final int width;
  public final boolean yhp;
  private final int yhq;
  public final int yhr;
  private final int yhs;
  
  public c$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, int paramInt8, int paramInt9)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.duration = paramInt3;
    this.dHi = paramInt4;
    this.videoBitrate = paramInt5;
    this.fps = paramInt6;
    this.yhp = paramBoolean;
    this.yhq = paramInt7;
    this.yhr = paramInt8;
    this.yhs = paramInt9;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.duration != paramObject.duration) || (this.dHi != paramObject.dHi) || (this.videoBitrate != paramObject.videoBitrate) || (this.fps != paramObject.fps) || (this.yhp != paramObject.yhp) || (this.yhq != paramObject.yhq) || (this.yhr != paramObject.yhr) || (this.yhs != paramObject.yhs)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76219);
    String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.dHi + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.yhp + ", useABA=" + this.yhq + ", bitrateAdaptiveUp=" + this.yhr + ", useMinMaxQP=" + this.yhs + ")";
    AppMethodBeat.o(76219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c.a
 * JD-Core Version:    0.7.0.1
 */