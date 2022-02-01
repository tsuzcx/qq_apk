package com.tencent.thumbplayer.api;

public class TPAudioFrameBuffer
{
  public static final int TP_AUDIO_CH_LAYOUT_MONO = 4;
  public static final int TP_AUDIO_CH_LAYOUT_NONE = 0;
  public static final int TP_AUDIO_CH_LAYOUT_STEREO = 3;
  private static final int TP_CH_FRONT_CENTER = 4;
  private static final int TP_CH_FRONT_LEFT = 1;
  private static final int TP_CH_FRONT_RIGHT = 2;
  public long channelLayout;
  public int channels;
  public byte[][] data;
  public int format;
  public int nbSamples;
  public long ptsMs;
  public int sampleRate;
  public int[] size;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPAudioFrameBuffer
 * JD-Core Version:    0.7.0.1
 */