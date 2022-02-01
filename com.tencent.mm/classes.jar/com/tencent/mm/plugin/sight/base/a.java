package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public int Cip = 0;
  public int Ciq = 0;
  public int Cir = 0;
  public int audioBitrate = 0;
  public int audioChannel = 0;
  public int audioSampleRate = 0;
  public int frameRate = 0;
  public int height = 0;
  public int pixelFormat = -1;
  public int videoBitrate = 0;
  public int videoDuration = 0;
  public int width = 0;
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(133594);
    int i = Util.videoMsToSec(this.videoDuration);
    AppMethodBeat.o(133594);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133595);
    String str = "[ videoDuration: " + this.videoDuration + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.frameRate + " audioChannel: " + this.audioChannel + " audioBitrate: " + this.audioBitrate + " audioSampleRate: " + this.audioSampleRate + " useABA: " + this.Cip + " useMinMaxQP: " + this.Cir + " bitrateAdaptiveUp: " + this.Ciq + "]";
    AppMethodBeat.o(133595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */