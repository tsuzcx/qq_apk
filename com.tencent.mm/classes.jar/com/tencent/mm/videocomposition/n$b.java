package com.tencent.mm.videocomposition;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "outputHevc", "(Landroid/util/Size;IIIIIIZZZ)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getFps", "getHighProfileEnable", "getIFrameInterval", "getOutputHevc", "getTargetSize", "()Landroid/util/Size;", "getVideoBitrate", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
public final class n$b
{
  final boolean Lnr;
  final Size Rhw;
  final boolean Rhx;
  final boolean Rhy;
  final int audioBitrate;
  public final int audioChannelCount;
  public final int audioSampleRate;
  public final int fps;
  final int idB;
  final int videoBitrate;
  
  public n$b(Size paramSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(216765);
    this.Rhw = paramSize;
    this.videoBitrate = paramInt1;
    this.fps = paramInt2;
    this.idB = paramInt3;
    this.audioBitrate = paramInt4;
    this.audioSampleRate = paramInt5;
    this.audioChannelCount = paramInt6;
    this.Rhx = paramBoolean1;
    this.Rhy = paramBoolean2;
    this.Lnr = paramBoolean3;
    AppMethodBeat.o(216765);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216768);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label241;
      }
      paramObject = (b)paramObject;
      if (!p.j(this.Rhw, paramObject.Rhw)) {
        break label241;
      }
      if (this.videoBitrate != paramObject.videoBitrate) {
        break label196;
      }
      i = 1;
      if (i == 0) {
        break label241;
      }
      if (this.fps != paramObject.fps) {
        break label201;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label241;
      }
      if (this.idB != paramObject.idB) {
        break label206;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label241;
      }
      if (this.audioBitrate != paramObject.audioBitrate) {
        break label211;
      }
      i = 1;
      label100:
      if (i == 0) {
        break label241;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate) {
        break label216;
      }
      i = 1;
      label117:
      if (i == 0) {
        break label241;
      }
      if (this.audioChannelCount != paramObject.audioChannelCount) {
        break label221;
      }
      i = 1;
      label134:
      if (i == 0) {
        break label241;
      }
      if (this.Rhx != paramObject.Rhx) {
        break label226;
      }
      i = 1;
      label151:
      if (i == 0) {
        break label241;
      }
      if (this.Rhy != paramObject.Rhy) {
        break label231;
      }
      i = 1;
      label168:
      if (i == 0) {
        break label241;
      }
      if (this.Lnr != paramObject.Lnr) {
        break label236;
      }
    }
    label196:
    label201:
    label206:
    label211:
    label216:
    label221:
    label226:
    label231:
    label236:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label241;
      }
      AppMethodBeat.o(216768);
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
      i = 0;
      break label168;
    }
    label241:
    AppMethodBeat.o(216768);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216766);
    String str = "VideoOutputConfig(targetSize=" + this.Rhw + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.idB + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.Rhx + ", aacEncodeNeedCodecSpecificData=" + this.Rhy + ", outputHevc=" + this.Lnr + ")";
    AppMethodBeat.o(216766);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.n.b
 * JD-Core Version:    0.7.0.1
 */