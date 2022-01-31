package com.tencent.mm.plugin.recordvideo.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "(IIIIIIIIZZ)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getNeedRemux", "setNeedRemux", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
public final class b$b
{
  public int audioSampleRate;
  public int eRF;
  public int eRu;
  public int eRv;
  public int eRw;
  public int eWL;
  public int fzT;
  public boolean qbc;
  public boolean qbd;
  public int videoBitrate;
  
  private b$b()
  {
    AppMethodBeat.i(155502);
    this.eRu = 0;
    this.eRv = 0;
    this.videoBitrate = 0;
    this.fzT = 0;
    this.eRw = 0;
    this.eWL = 0;
    this.audioSampleRate = 0;
    this.eRF = 1;
    this.qbc = false;
    this.qbd = false;
    AppMethodBeat.o(155502);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof b)) {
        break label225;
      }
      paramObject = (b)paramObject;
      if (this.eRu != paramObject.eRu) {
        break label227;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.eRv != paramObject.eRv) {
        break label232;
      }
      i = 1;
      label56:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.videoBitrate != paramObject.videoBitrate) {
        break label237;
      }
      i = 1;
      label76:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.fzT != paramObject.fzT) {
        break label242;
      }
      i = 1;
      label96:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.eRw != paramObject.eRw) {
        break label247;
      }
      i = 1;
      label116:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.eWL != paramObject.eWL) {
        break label252;
      }
      i = 1;
      label136:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate) {
        break label257;
      }
      i = 1;
      label156:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.eRF != paramObject.eRF) {
        break label262;
      }
      i = 1;
      label176:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.qbc != paramObject.qbc) {
        break label267;
      }
      i = 1;
      label196:
      bool1 = bool2;
      if (i == 0) {
        break label225;
      }
      if (this.qbd != paramObject.qbd) {
        break label272;
      }
    }
    label257:
    label262:
    label267:
    label272:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      label225:
      return bool1;
      label227:
      i = 0;
      break;
      label232:
      i = 0;
      break label56;
      label237:
      i = 0;
      break label76;
      label242:
      i = 0;
      break label96;
      label247:
      i = 0;
      break label116;
      label252:
      i = 0;
      break label136;
      i = 0;
      break label156;
      i = 0;
      break label176;
      i = 0;
      break label196;
    }
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150572);
    String str = "EncodeConfig(targetWidth=" + this.eRu + ", targetHeight=" + this.eRv + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.fzT + ", frameRate=" + this.eRw + ", videoRotate=" + this.eWL + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.eRF + ", needRemux=" + this.qbc + ", change=" + this.qbd + ')';
    AppMethodBeat.o(150572);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.b.b
 * JD-Core Version:    0.7.0.1
 */