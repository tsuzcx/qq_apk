package com.tencent.thumbplayer.core.common;

public class TPAudioFrame
{
  public static final long TP_CH_BACK_CENTER = 256L;
  public static final long TP_CH_BACK_LEFT = 16L;
  public static final long TP_CH_BACK_RIGHT = 32L;
  public static final long TP_CH_FRONT_CENTER = 4L;
  public static final long TP_CH_FRONT_LEFT = 1L;
  public static final long TP_CH_FRONT_LEFT_OF_CENTER = 64L;
  public static final long TP_CH_FRONT_RIGHT = 2L;
  public static final long TP_CH_FRONT_RIGHT_OF_CENTER = 128L;
  public static final long TP_CH_LAYOUT_2POINT1 = 11L;
  public static final long TP_CH_LAYOUT_2_1 = 259L;
  public static final long TP_CH_LAYOUT_2_2 = 1539L;
  public static final long TP_CH_LAYOUT_3POINT1 = 15L;
  public static final long TP_CH_LAYOUT_4POINT0 = 263L;
  public static final long TP_CH_LAYOUT_4POINT1 = 271L;
  public static final long TP_CH_LAYOUT_5POINT0 = 1543L;
  public static final long TP_CH_LAYOUT_5POINT0_BACK = 55L;
  public static final long TP_CH_LAYOUT_5POINT1 = 1551L;
  public static final long TP_CH_LAYOUT_5POINT1_BACK = 63L;
  public static final long TP_CH_LAYOUT_6POINT0 = 1799L;
  public static final long TP_CH_LAYOUT_6POINT0_FRONT = 1731L;
  public static final long TP_CH_LAYOUT_6POINT1 = 1807L;
  public static final long TP_CH_LAYOUT_6POINT1_BACK = 319L;
  public static final long TP_CH_LAYOUT_6POINT1_FRONT = 1739L;
  public static final long TP_CH_LAYOUT_7POINT0 = 1591L;
  public static final long TP_CH_LAYOUT_7POINT0_FRONT = 1735L;
  public static final long TP_CH_LAYOUT_7POINT1 = 1599L;
  public static final long TP_CH_LAYOUT_7POINT1_WIDE = 1743L;
  public static final long TP_CH_LAYOUT_7POINT1_WIDE_BACK = 255L;
  public static final long TP_CH_LAYOUT_HEXAGONAL = 311L;
  public static final long TP_CH_LAYOUT_MONO = 4L;
  public static final long TP_CH_LAYOUT_OCTAGONAL = 1847L;
  public static final long TP_CH_LAYOUT_QUAD = 51L;
  public static final long TP_CH_LAYOUT_STEREO = 3L;
  public static final long TP_CH_LAYOUT_STEREO_DOWNMIX = 1610612736L;
  public static final long TP_CH_LAYOUT_SURROUND = 7L;
  public static final long TP_CH_LOW_FREQUENCY = 8L;
  public static final long TP_CH_SIDE_LEFT = 512L;
  public static final long TP_CH_SIDE_RIGHT = 1024L;
  public static final long TP_CH_STEREO_LEFT = 536870912L;
  public static final long TP_CH_STEREO_RIGHT = 1073741824L;
  public static final long TP_CH_TOP_BACK_CENTER = 65536L;
  public static final long TP_CH_TOP_BACK_LEFT = 32768L;
  public static final long TP_CH_TOP_BACK_RIGHT = 131072L;
  public static final long TP_CH_TOP_CENTER = 2048L;
  public static final long TP_CH_TOP_FRONT_CENTER = 8192L;
  public static final long TP_CH_TOP_FRONT_LEFT = 4096L;
  public static final long TP_CH_TOP_FRONT_RIGHT = 16384L;
  public static final int TP_SAMPLE_FMT_NONE = -1;
  public static final int TP_SAMPLE_FMT_S16 = 1;
  public static final int TP_SAMPLE_FMT_S32 = 2;
  public static final int TP_SAMPLE_FMT_U8 = 0;
  public long channelLayout;
  public int channels;
  public byte[][] data;
  public int format;
  public int[] linesize;
  public int nbSamples;
  public long ptsUs;
  public int sampleRate;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioFrame
 * JD-Core Version:    0.7.0.1
 */