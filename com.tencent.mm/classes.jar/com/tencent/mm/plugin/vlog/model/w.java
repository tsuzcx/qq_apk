package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
public final class w
{
  public int AoQ;
  public int AoR;
  public int audioBitrate;
  public int audioSampleRate;
  public int frameRate;
  public int gNU;
  public int gNV;
  public int gOt;
  public int gTI;
  public String poB;
  public int videoBitrate;
  
  private w(String paramString)
  {
    AppMethodBeat.i(110935);
    this.AoQ = 0;
    this.AoR = 0;
    this.poB = paramString;
    this.gNU = 0;
    this.gNV = 0;
    this.videoBitrate = 0;
    this.audioBitrate = 0;
    this.frameRate = 0;
    this.gTI = 0;
    this.audioSampleRate = 0;
    this.gOt = 1;
    AppMethodBeat.o(110935);
  }
  
  public final void ayl(String paramString)
  {
    AppMethodBeat.i(110934);
    k.h(paramString, "<set-?>");
    this.poB = paramString;
    AppMethodBeat.o(110934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110939);
    if (this != paramObject)
    {
      if ((paramObject instanceof w))
      {
        paramObject = (w)paramObject;
        if ((this.AoQ != paramObject.AoQ) || (this.AoR != paramObject.AoR) || (!k.g(this.poB, paramObject.poB)) || (this.gNU != paramObject.gNU) || (this.gNV != paramObject.gNV) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.gTI != paramObject.gTI) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.gOt != paramObject.gOt)) {}
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
    int j = this.AoQ;
    int k = this.AoR;
    String str = this.poB;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int m = this.gNU;
      int n = this.gNV;
      int i1 = this.videoBitrate;
      int i2 = this.audioBitrate;
      int i3 = this.frameRate;
      int i4 = this.gTI;
      int i5 = this.audioSampleRate;
      int i6 = this.gOt;
      AppMethodBeat.o(110938);
      return ((((((((i + (j * 31 + k) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110937);
    String str = "VLogGenerateModel(outputDurationMs=" + this.AoQ + ", outputAudioType=" + this.AoR + ", outputPath=" + this.poB + ", targetWidth=" + this.gNU + ", targetHeight=" + this.gNV + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.gTI + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gOt + ")";
    AppMethodBeat.o(110937);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */