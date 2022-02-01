package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public int Obw = 0;
  public int Obx = 0;
  public int Oby = 0;
  public boolean PFe = false;
  public String PFf = "";
  public String PFg = "";
  public int audioBitrate = 0;
  public int audioChannel = 0;
  public int audioSampleRate = 0;
  public int frameRate = 0;
  public int hYK = -1;
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
    String str = "[ videoDuration: " + this.videoDuration + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.frameRate + " audioChannel: " + this.audioChannel + " audioBitrate: " + this.audioBitrate + " audioSampleRate: " + this.audioSampleRate + " useABA: " + this.Obw + " useMinMaxQP: " + this.Oby + " bitrateAdaptiveUp: " + this.Obx + " hasH264: " + this.PFe + "]";
    AppMethodBeat.o(133595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.b
 * JD-Core Version:    0.7.0.1
 */