package com.tencent.thumbplayer.core.common;

public class TPVideoFrame
{
  public static final int TP_PIX_FMT_NONE = -1;
  public static final int TP_PIX_FMT_RGB565 = 37;
  public static final int TP_PIX_FMT_YUV420P = 0;
  public static final int TP_PIX_FMT_YUVJ420P = 12;
  public byte[][] data;
  public int format;
  public int height;
  public int[] linesize;
  public long ptsUs;
  public int rotation;
  public int sampleAspectRatioDen;
  public int sampleAspectRatioNum;
  public int width;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPVideoFrame
 * JD-Core Version:    0.7.0.1
 */