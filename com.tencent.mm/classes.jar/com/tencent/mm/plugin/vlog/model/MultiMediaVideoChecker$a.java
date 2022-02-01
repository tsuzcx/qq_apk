package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "(IIFJIIZIII)V", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getBitrate", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getRotate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class MultiMediaVideoChecker$a
{
  public final int audioBitrate;
  final int audioChannelCount;
  public final int audioSampleRate;
  public final int bitrate;
  public final float cvL;
  public final int dGc;
  public final long duration;
  public final int height;
  public final boolean vTf;
  public final int width;
  
  public MultiMediaVideoChecker$a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.cvL = paramFloat;
    this.duration = paramLong;
    this.bitrate = paramInt3;
    this.dGc = paramInt4;
    this.vTf = paramBoolean;
    this.audioBitrate = paramInt5;
    this.audioChannelCount = paramInt6;
    this.audioSampleRate = paramInt7;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195739);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.cvL, paramObject.cvL) != 0) || (this.duration != paramObject.duration) || (this.bitrate != paramObject.bitrate) || (this.dGc != paramObject.dGc) || (this.vTf != paramObject.vTf) || (this.audioBitrate != paramObject.audioBitrate) || (this.audioChannelCount != paramObject.audioChannelCount) || (this.audioSampleRate != paramObject.audioSampleRate)) {}
      }
    }
    else
    {
      AppMethodBeat.o(195739);
      return true;
    }
    AppMethodBeat.o(195739);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195737);
    String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.cvL + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.dGc + ", isH265=" + this.vTf + ", audioBitrate=" + this.audioBitrate + ", audioChannelCount=" + this.audioChannelCount + ", audioSampleRate=" + this.audioSampleRate + ")";
    AppMethodBeat.o(195737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a
 * JD-Core Version:    0.7.0.1
 */