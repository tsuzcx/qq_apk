package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
public final class g
{
  public int audioBitrate;
  public int audioSampleRate;
  public int frameRate;
  public int gnH;
  public int gnh;
  public int gni;
  public int gta;
  public String oLh;
  public int videoBitrate;
  public int yZp;
  public int yZq;
  
  private g(String paramString)
  {
    AppMethodBeat.i(110935);
    this.yZp = 0;
    this.yZq = 0;
    this.oLh = paramString;
    this.gnh = 0;
    this.gni = 0;
    this.videoBitrate = 0;
    this.audioBitrate = 0;
    this.frameRate = 0;
    this.gta = 0;
    this.audioSampleRate = 0;
    this.gnH = 1;
    AppMethodBeat.o(110935);
  }
  
  public final void asV(String paramString)
  {
    AppMethodBeat.i(110934);
    k.h(paramString, "<set-?>");
    this.oLh = paramString;
    AppMethodBeat.o(110934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110939);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.yZp != paramObject.yZp) || (this.yZq != paramObject.yZq) || (!k.g(this.oLh, paramObject.oLh)) || (this.gnh != paramObject.gnh) || (this.gni != paramObject.gni) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.gta != paramObject.gta) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.gnH != paramObject.gnH)) {}
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
    int j = this.yZp;
    int k = this.yZq;
    String str = this.oLh;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int m = this.gnh;
      int n = this.gni;
      int i1 = this.videoBitrate;
      int i2 = this.audioBitrate;
      int i3 = this.frameRate;
      int i4 = this.gta;
      int i5 = this.audioSampleRate;
      int i6 = this.gnH;
      AppMethodBeat.o(110938);
      return ((((((((i + (j * 31 + k) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110937);
    String str = "VLogGenerateModel(outputDurationMs=" + this.yZp + ", outputAudioType=" + this.yZq + ", outputPath=" + this.oLh + ", targetWidth=" + this.gnh + ", targetHeight=" + this.gni + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.gta + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gnH + ")";
    AppMethodBeat.o(110937);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.g
 * JD-Core Version:    0.7.0.1
 */