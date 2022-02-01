package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public int audioBitrate = 0;
  public int audioChannel = 0;
  public int frameRate = 0;
  public int height = 0;
  public int videoBitrate = 0;
  public int videoDuration = 0;
  public int wDQ = 0;
  public int wDR = 0;
  public int wDS = 0;
  public int width = 0;
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(133594);
    int i = bs.Aq(this.videoDuration);
    AppMethodBeat.o(133594);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133595);
    String str = "[ videoDuration: " + this.videoDuration + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.frameRate + " audioChannel: " + this.audioChannel + " audioBitrate: " + this.audioBitrate + " useABA: " + this.wDQ + " useMinMaxQP: " + this.wDS + " bitrateAdaptiveUp: " + this.wDR + "]";
    AppMethodBeat.o(133595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */