package com.tencent.thumbplayer.api;

public class TPSubtitleFrameBuffer
{
  public static final int TP_PLAYER_SUBTITLE_OUTPUT_FORMAT_NONE = -1;
  public static final int TP_PLAYER_SUBTITLE_OUTPUT_FORMAT_RGBA = 26;
  public byte[][] data;
  public int dstHeight;
  public int dstWidth;
  public int flags;
  public int format;
  public int[] lineSize;
  public long ptsMs;
  public int rotation;
  public int srcHeight;
  public int srcWidth;
  public int trackID;
  
  public byte[][] getData()
  {
    return this.data;
  }
  
  public int getDstHeight()
  {
    return this.dstHeight;
  }
  
  public int getDstWidth()
  {
    return this.dstWidth;
  }
  
  public int getFlags()
  {
    return this.flags;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public int[] getLineSize()
  {
    return this.lineSize;
  }
  
  public long getPtsMs()
  {
    return this.ptsMs;
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public int getSrcHeight()
  {
    return this.srcHeight;
  }
  
  public int getSrcWidth()
  {
    return this.srcWidth;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPSubtitleFrameBuffer
 * JD-Core Version:    0.7.0.1
 */