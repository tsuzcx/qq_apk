package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
public final class y
{
  public int BGH;
  public int BGI;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int frameRate;
  public int hlJ;
  public String pSc;
  public int targetHeight;
  public int targetWidth;
  public int videoBitrate;
  
  private y(String paramString)
  {
    AppMethodBeat.i(110935);
    this.BGH = 0;
    this.BGI = 0;
    this.pSc = paramString;
    this.targetWidth = 0;
    this.targetHeight = 0;
    this.videoBitrate = 0;
    this.audioBitrate = 0;
    this.frameRate = 0;
    this.hlJ = 0;
    this.audioSampleRate = 0;
    this.audioChannelCount = 1;
    AppMethodBeat.o(110935);
  }
  
  public final void aDr(String paramString)
  {
    AppMethodBeat.i(110934);
    p.h(paramString, "<set-?>");
    this.pSc = paramString;
    AppMethodBeat.o(110934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110939);
    if (this != paramObject)
    {
      if ((paramObject instanceof y))
      {
        paramObject = (y)paramObject;
        if ((this.BGH != paramObject.BGH) || (this.BGI != paramObject.BGI) || (!p.i(this.pSc, paramObject.pSc)) || (this.targetWidth != paramObject.targetWidth) || (this.targetHeight != paramObject.targetHeight) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.hlJ != paramObject.hlJ) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.audioChannelCount != paramObject.audioChannelCount)) {}
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
    int j = this.BGH;
    int k = this.BGI;
    String str = this.pSc;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int m = this.targetWidth;
      int n = this.targetHeight;
      int i1 = this.videoBitrate;
      int i2 = this.audioBitrate;
      int i3 = this.frameRate;
      int i4 = this.hlJ;
      int i5 = this.audioSampleRate;
      int i6 = this.audioChannelCount;
      AppMethodBeat.o(110938);
      return ((((((((i + (j * 31 + k) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110937);
    String str = "VLogGenerateModel(outputDurationMs=" + this.BGH + ", outputAudioType=" + this.BGI + ", outputPath=" + this.pSc + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.hlJ + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ")";
    AppMethodBeat.o(110937);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */