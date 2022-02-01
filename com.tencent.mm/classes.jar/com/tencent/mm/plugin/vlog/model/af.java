package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public int UaS;
  public int UaT;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int frameRate;
  public int nCg;
  public int nxO;
  public int nxP;
  public String outputPath;
  public int videoBitrate;
  
  private af(String paramString)
  {
    AppMethodBeat.i(110935);
    this.UaS = 0;
    this.UaT = 0;
    this.outputPath = paramString;
    this.nxO = 0;
    this.nxP = 0;
    this.videoBitrate = 0;
    this.audioBitrate = 0;
    this.frameRate = 0;
    this.nCg = 0;
    this.audioSampleRate = 0;
    this.audioChannelCount = 1;
    AppMethodBeat.o(110935);
  }
  
  public final void bff(String paramString)
  {
    AppMethodBeat.i(110934);
    s.u(paramString, "<set-?>");
    this.outputPath = paramString;
    AppMethodBeat.o(110934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110939);
    if (this == paramObject)
    {
      AppMethodBeat.o(110939);
      return true;
    }
    if (!(paramObject instanceof af))
    {
      AppMethodBeat.o(110939);
      return false;
    }
    paramObject = (af)paramObject;
    if (this.UaS != paramObject.UaS)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.UaT != paramObject.UaT)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (!s.p(this.outputPath, paramObject.outputPath))
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.nxO != paramObject.nxO)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.nxP != paramObject.nxP)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.videoBitrate != paramObject.videoBitrate)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.audioBitrate != paramObject.audioBitrate)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.frameRate != paramObject.frameRate)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.nCg != paramObject.nCg)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.audioSampleRate != paramObject.audioSampleRate)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    if (this.audioChannelCount != paramObject.audioChannelCount)
    {
      AppMethodBeat.o(110939);
      return false;
    }
    AppMethodBeat.o(110939);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(110938);
    int i = this.UaS;
    int j = this.UaT;
    int k = this.outputPath.hashCode();
    int m = this.nxO;
    int n = this.nxP;
    int i1 = this.videoBitrate;
    int i2 = this.audioBitrate;
    int i3 = this.frameRate;
    int i4 = this.nCg;
    int i5 = this.audioSampleRate;
    int i6 = this.audioChannelCount;
    AppMethodBeat.o(110938);
    return (((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110937);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VLogGenerateModel(outputDurationMs=").append(this.UaS).append(", outputAudioType=").append(this.UaT).append(", outputPath=").append(this.outputPath).append(", targetWidth=").append(this.nxO).append(", targetHeight=").append(this.nxP).append(", videoBitrate=").append(this.videoBitrate).append(", audioBitrate=").append(this.audioBitrate).append(", frameRate=").append(this.frameRate).append(", videoRotate=").append(this.nCg).append(", audioSampleRate=").append(this.audioSampleRate).append(", audioChannelCount=").append(this.audioChannelCount).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(110937);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.af
 * JD-Core Version:    0.7.0.1
 */