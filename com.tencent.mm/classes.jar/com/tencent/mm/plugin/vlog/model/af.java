package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
public final class af
{
  public int GzL;
  public int GzM;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int frameRate;
  public int ihS;
  public String rpE;
  public int targetHeight;
  public int targetWidth;
  public int videoBitrate;
  
  private af(String paramString)
  {
    AppMethodBeat.i(110935);
    this.GzL = 0;
    this.GzM = 0;
    this.rpE = paramString;
    this.targetWidth = 0;
    this.targetHeight = 0;
    this.videoBitrate = 0;
    this.audioBitrate = 0;
    this.frameRate = 0;
    this.ihS = 0;
    this.audioSampleRate = 0;
    this.audioChannelCount = 1;
    AppMethodBeat.o(110935);
  }
  
  public final void aUb(String paramString)
  {
    AppMethodBeat.i(110934);
    p.h(paramString, "<set-?>");
    this.rpE = paramString;
    AppMethodBeat.o(110934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110939);
    if (this != paramObject)
    {
      if ((paramObject instanceof af))
      {
        paramObject = (af)paramObject;
        if ((this.GzL != paramObject.GzL) || (this.GzM != paramObject.GzM) || (!p.j(this.rpE, paramObject.rpE)) || (this.targetWidth != paramObject.targetWidth) || (this.targetHeight != paramObject.targetHeight) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.ihS != paramObject.ihS) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.audioChannelCount != paramObject.audioChannelCount)) {}
      }
    }
    else
    {
      AppMethodBeat.o(110939);
      return true;
    }
    AppMethodBeat.o(110939);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(110938);
    int j = this.GzL;
    int k = this.GzM;
    String str = this.rpE;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int m = this.targetWidth;
      int n = this.targetHeight;
      int i1 = this.videoBitrate;
      int i2 = this.audioBitrate;
      int i3 = this.frameRate;
      int i4 = this.ihS;
      int i5 = this.audioSampleRate;
      int i6 = this.audioChannelCount;
      AppMethodBeat.o(110938);
      return ((((((((i + (j * 31 + k) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110937);
    String str = "VLogGenerateModel(outputDurationMs=" + this.GzL + ", outputAudioType=" + this.GzM + ", outputPath=" + this.rpE + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ")";
    AppMethodBeat.o(110937);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.af
 * JD-Core Version:    0.7.0.1
 */