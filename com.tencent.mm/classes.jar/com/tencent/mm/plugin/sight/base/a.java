package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public int audioBitrate = 0;
  public int audioChannel = 0;
  public int frameRate = 0;
  public int height = 0;
  public int videoBitrate = 0;
  public int videoDuration = 0;
  public int vtN = 0;
  public int vtO = 0;
  public int vtP = 0;
  public int width = 0;
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(133594);
    int i = bt.vN(this.videoDuration);
    AppMethodBeat.o(133594);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133595);
    String str = "[ videoDuration: " + this.videoDuration + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.frameRate + " audioChannel: " + this.audioChannel + " audioBitrate: " + this.audioBitrate + " useABA: " + this.vtN + " useMinMaxQP: " + this.vtP + " bitrateAdaptiveUp: " + this.vtO + "]";
    AppMethodBeat.o(133595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */