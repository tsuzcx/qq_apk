package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public int eIM = 0;
  public int ejM = 0;
  public int height = 0;
  public int jlu = 0;
  public int odX = 0;
  public int videoBitrate = 0;
  public int width = 0;
  
  public final int bAT()
  {
    return bk.hv(this.jlu);
  }
  
  public final String toString()
  {
    return "[ videoDuration: " + this.jlu + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.eIM + " audioChannel: " + this.odX + " audioBitrate: " + this.ejM + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */