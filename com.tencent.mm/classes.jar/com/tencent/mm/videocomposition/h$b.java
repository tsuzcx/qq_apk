package com.tencent.mm.videocomposition;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "(Landroid/util/Size;IIIIIIZZ)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getFps", "getHighProfileEnable", "getIFrameInterval", "getTargetSize", "()Landroid/util/Size;", "getVideoBitrate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
public final class h$b
{
  final Size LmV;
  final boolean LmW;
  final boolean OfJ;
  final int audioBitrate;
  public final int audioChannelCount;
  public final int audioSampleRate;
  final int fps;
  final int hhR;
  final int videoBitrate;
  
  public h$b(Size paramSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(220834);
    this.LmV = paramSize;
    this.videoBitrate = paramInt1;
    this.fps = paramInt2;
    this.hhR = paramInt3;
    this.audioBitrate = paramInt4;
    this.audioSampleRate = paramInt5;
    this.audioChannelCount = paramInt6;
    this.LmW = paramBoolean;
    this.OfJ = false;
    AppMethodBeat.o(220834);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220837);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label219;
      }
      paramObject = (b)paramObject;
      if (!p.i(this.LmV, paramObject.LmV)) {
        break label219;
      }
      if (this.videoBitrate != paramObject.videoBitrate) {
        break label179;
      }
      i = 1;
      if (i == 0) {
        break label219;
      }
      if (this.fps != paramObject.fps) {
        break label184;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label219;
      }
      if (this.hhR != paramObject.hhR) {
        break label189;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label219;
      }
      if (this.audioBitrate != paramObject.audioBitrate) {
        break label194;
      }
      i = 1;
      label100:
      if (i == 0) {
        break label219;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate) {
        break label199;
      }
      i = 1;
      label117:
      if (i == 0) {
        break label219;
      }
      if (this.audioChannelCount != paramObject.audioChannelCount) {
        break label204;
      }
      i = 1;
      label134:
      if (i == 0) {
        break label219;
      }
      if (this.LmW != paramObject.LmW) {
        break label209;
      }
      i = 1;
      label151:
      if (i == 0) {
        break label219;
      }
      if (this.OfJ != paramObject.OfJ) {
        break label214;
      }
    }
    label179:
    label184:
    label189:
    label194:
    label199:
    label204:
    label209:
    label214:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label219;
      }
      AppMethodBeat.o(220837);
      return true;
      i = 0;
      break;
      i = 0;
      break label66;
      i = 0;
      break label83;
      i = 0;
      break label100;
      i = 0;
      break label117;
      i = 0;
      break label134;
      i = 0;
      break label151;
    }
    label219:
    AppMethodBeat.o(220837);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220835);
    String str = "VideoOutputConfig(targetSize=" + this.LmV + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.hhR + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.LmW + ", aacEncodeNeedCodecSpecificData=" + this.OfJ + ")";
    AppMethodBeat.o(220835);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.videocomposition.h.b
 * JD-Core Version:    0.7.0.1
 */