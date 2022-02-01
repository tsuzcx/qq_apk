package com.tencent.thumbplayer.api;

import java.util.HashMap;

public class TPPostProcessFrameBuffer
{
  public static final int EVENT_EOS = 1;
  public static final int EVENT_FLUSH = 2;
  public long channelLayout;
  public int channels;
  public byte[][] data;
  public int eventFlag;
  public int format;
  public int height;
  public int mediaType;
  public int nbSamples;
  public HashMap<String, Long> perfData;
  public long ptsMs;
  public int rotation;
  public int sampleAspectRatioDen;
  public int sampleAspectRatioNum;
  public int sampleRate;
  public int[] size;
  public int width;
  
  public long getChannelLayout()
  {
    return this.channelLayout;
  }
  
  public byte[][] getData()
  {
    return this.data;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public long getPtsMs()
  {
    return this.ptsMs;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int[] getSize()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPostProcessFrameBuffer
 * JD-Core Version:    0.7.0.1
 */