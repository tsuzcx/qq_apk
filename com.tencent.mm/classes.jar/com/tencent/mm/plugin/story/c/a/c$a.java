package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
public final class c$a
{
  public static final a srS;
  public int audioSampleRate;
  public int duration;
  public int eRu;
  public int eRv;
  public int eRw;
  public int eWL;
  public int eqK;
  int fAg;
  public int fzT;
  int fzU;
  int fzV;
  int fzW;
  boolean isDefault;
  public VideoTransPara qbq;
  float srR;
  public int videoBitrate;
  
  static
  {
    AppMethodBeat.i(108960);
    srS = new a((byte)0);
    AppMethodBeat.o(108960);
  }
  
  private c$a()
  {
    AppMethodBeat.i(108959);
    this.eRu = 0;
    this.eRv = 0;
    this.videoBitrate = 0;
    this.fzT = 0;
    this.eRw = 0;
    this.eWL = 0;
    this.duration = 0;
    this.fzU = 0;
    this.fzV = 0;
    this.fzW = 0;
    this.isDefault = false;
    this.fAg = 0;
    this.audioSampleRate = 0;
    this.eqK = 2;
    this.srR = 1.3F;
    this.qbq = new VideoTransPara();
    AppMethodBeat.o(108959);
  }
  
  public final void acE(String paramString)
  {
    AppMethodBeat.i(108957);
    j.q(paramString, "path");
    ab.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.sight.base.d.Zo(paramString);
    int m;
    int i2;
    int i;
    int j;
    int k;
    if (localObject != null)
    {
      i1 = ((com.tencent.mm.plugin.sight.base.a)localObject).width;
      n = ((com.tencent.mm.plugin.sight.base.a)localObject).height;
      m = ((com.tencent.mm.plugin.sight.base.a)localObject).videoBitrate;
      i2 = ((com.tencent.mm.plugin.sight.base.a)localObject).eRw;
      if (n > 0)
      {
        i = n;
        j = i1;
        k = m;
        if (i1 > 0) {}
      }
      else
      {
        i = n;
        j = i1;
        k = m;
      }
    }
    try
    {
      localObject = new MediaMetadataRetriever();
      i = n;
      j = i1;
      k = m;
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      i = n;
      j = i1;
      k = m;
      i1 = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
      i = n;
      j = i1;
      k = m;
      n = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
      i = n;
      j = i1;
      k = m;
      m = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), 0);
      i = n;
      j = i1;
      k = m;
      ((MediaMetadataRetriever)localObject).release();
      k = m;
      j = i1;
      i = n;
    }
    catch (Exception localException)
    {
      label229:
      break label229;
    }
    int n = i2;
    if (i2 <= 0)
    {
      localObject = c.srQ;
      n = c.acD(paramString);
    }
    int i1 = SightVideoJNI.getMp4Rotate(paramString);
    ab.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + this.videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
    if (k < this.videoBitrate) {
      this.videoBitrate = k;
    }
    if ((i1 == 90) || (i1 == 270))
    {
      m = i;
      k = j;
      if (i > this.eRu)
      {
        m = i;
        k = j;
        if (i - this.eRu > 16)
        {
          k = (int)(this.eRu / i * j);
          m = this.eRu;
        }
      }
    }
    for (;;)
    {
      i = m;
      if (m % 16 != 0) {
        i = com.tencent.mm.plugin.mmsight.d.zn(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.zn(k);
      }
      if (this.eRw > n) {
        this.eRw = n;
      }
      this.eRv = i;
      this.eRu = j;
      this.eWL = i1;
      AppMethodBeat.o(108957);
      return;
      com.tencent.mm.plugin.story.image2video.d.czT();
      this.eRu = com.tencent.mm.plugin.story.image2video.d.Width;
      this.eRv = com.tencent.mm.plugin.story.image2video.d.Height;
      this.eRw = com.tencent.mm.plugin.story.image2video.d.ssU;
      float f2 = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUQ, 2.0F);
      float f1 = f2;
      if (f2 <= 1.0F) {
        f1 = 1.0F;
      }
      this.videoBitrate = ((int)(this.videoBitrate * f1));
      this.eWL = 0;
      ab.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + this.eRu + ", " + this.eRv + ", " + this.eRw + ", " + this.eWL + ", " + this.videoBitrate + ", " + f1);
      AppMethodBeat.o(108957);
      return;
      m = i;
      k = j;
      if (j > this.eRu)
      {
        m = i;
        k = j;
        if (j - this.eRu > 16)
        {
          f1 = this.eRu / j;
          m = (int)(i * f1);
          k = this.eRu;
        }
      }
    }
  }
  
  public final boolean acF(String paramString)
  {
    AppMethodBeat.i(108958);
    j.q(paramString, "path");
    if ((ab.getLogLevel() >= 0) && (com.tencent.mm.plugin.story.image2video.d.ssY))
    {
      AppMethodBeat.o(108958);
      return true;
    }
    Object localObject = com.tencent.mm.plugin.sight.base.d.Zo(paramString);
    if (localObject != null) {}
    for (int i = ((com.tencent.mm.plugin.sight.base.a)localObject).videoBitrate;; i = 0)
    {
      int j = i;
      if (i <= 0) {
        j = i;
      }
      try
      {
        localObject = new MediaMetadataRetriever();
        j = i;
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        j = i;
        i = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), 0);
        j = i;
        ((MediaMetadataRetriever)localObject).release();
        j = i;
      }
      catch (Exception localException)
      {
        label97:
        break label97;
      }
      ab.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + paramString + ", bitrate:" + j + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.srR);
      if (j > this.videoBitrate * this.srR)
      {
        AppMethodBeat.o(108958);
        return true;
      }
      AppMethodBeat.o(108958);
      return false;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108963);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label353;
      }
      paramObject = (a)paramObject;
      if (this.eRu != paramObject.eRu) {
        break label283;
      }
      i = 1;
      if (i == 0) {
        break label353;
      }
      if (this.eRv != paramObject.eRv) {
        break label288;
      }
      i = 1;
      label53:
      if (i == 0) {
        break label353;
      }
      if (this.videoBitrate != paramObject.videoBitrate) {
        break label293;
      }
      i = 1;
      label70:
      if (i == 0) {
        break label353;
      }
      if (this.fzT != paramObject.fzT) {
        break label298;
      }
      i = 1;
      label87:
      if (i == 0) {
        break label353;
      }
      if (this.eRw != paramObject.eRw) {
        break label303;
      }
      i = 1;
      label104:
      if (i == 0) {
        break label353;
      }
      if (this.eWL != paramObject.eWL) {
        break label308;
      }
      i = 1;
      label121:
      if (i == 0) {
        break label353;
      }
      if (this.duration != paramObject.duration) {
        break label313;
      }
      i = 1;
      label138:
      if (i == 0) {
        break label353;
      }
      if (this.fzU != paramObject.fzU) {
        break label318;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label353;
      }
      if (this.fzV != paramObject.fzV) {
        break label323;
      }
      i = 1;
      label172:
      if (i == 0) {
        break label353;
      }
      if (this.fzW != paramObject.fzW) {
        break label328;
      }
      i = 1;
      label189:
      if (i == 0) {
        break label353;
      }
      if (this.isDefault != paramObject.isDefault) {
        break label333;
      }
      i = 1;
      label206:
      if (i == 0) {
        break label353;
      }
      if (this.fAg != paramObject.fAg) {
        break label338;
      }
      i = 1;
      label223:
      if (i == 0) {
        break label353;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate) {
        break label343;
      }
      i = 1;
      label240:
      if (i == 0) {
        break label353;
      }
      if (this.eqK != paramObject.eqK) {
        break label348;
      }
    }
    label283:
    label288:
    label293:
    label298:
    label303:
    label308:
    label313:
    label318:
    label323:
    label328:
    label333:
    label338:
    label343:
    label348:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (Float.compare(this.srR, paramObject.srR) != 0)) {
        break label353;
      }
      AppMethodBeat.o(108963);
      return true;
      i = 0;
      break;
      i = 0;
      break label53;
      i = 0;
      break label70;
      i = 0;
      break label87;
      i = 0;
      break label104;
      i = 0;
      break label121;
      i = 0;
      break label138;
      i = 0;
      break label155;
      i = 0;
      break label172;
      i = 0;
      break label189;
      i = 0;
      break label206;
      i = 0;
      break label223;
      i = 0;
      break label240;
    }
    label353:
    AppMethodBeat.o(108963);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108961);
    String str = "EncodeConfig(targetWidth=" + this.eRu + ", targetHeight=" + this.eRv + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.fzT + ", frameRate=" + this.eRw + ", videoRotate=" + this.eWL + ", duration=" + this.duration + ", iFrame=" + this.fzU + ", profileIndex=" + this.fzV + ", presetIndex=" + this.fzW + ", isDefault=" + this.isDefault + ", thumbSize=" + this.fAg + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.eqK + ", exceedVideoBitrateTolerance=" + this.srR + ")";
    AppMethodBeat.o(108961);
    return str;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */