package com.tencent.ttpic.config;

public class MediaConfig
{
  public static int BPS_HIGH = 0;
  public static int BPS_LOW = 0;
  public static int BPS_MEDIUM = 0;
  public static int GIF_OUTPUT_TEX_HEIGHT = 0;
  public static int GIF_OUTPUT_TEX_WIDTH = 0;
  public static int GIF_OUTPUT_WATERMARK_HEIGHT = 50;
  public static int GIF_OUTPUT_WATERMARK_WIDTH = 0;
  public static float GIF_PLAY_RATE = 0.0F;
  public static long GIF_SAMPLE_TIME_MS = 0L;
  public static int INTERMIDIATE_IMAGE_WIDTH_HIGH = 0;
  public static int INTERMIDIATE_IMAGE_WIDTH_LOW = 0;
  public static int INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 0;
  public static int MS_VIDEO_FRAME_RATE = 0;
  public static final String VIDEO_AAC_FILE_POSTFIX = ".m4a";
  public static int VIDEO_FRAME_RATE;
  public static int VIDEO_IMAGE_HEIGHT;
  public static int VIDEO_IMAGE_WIDTH;
  public static int VIDEO_OUTPUT_HEIGHT;
  public static int VIDEO_OUTPUT_HEIGHT_LONG;
  public static int VIDEO_OUTPUT_HEIGHT_SHORT;
  public static int VIDEO_OUTPUT_WATERMARK_HEIGHT;
  public static int VIDEO_OUTPUT_WATERMARK_WIDTH;
  public static int VIDEO_OUTPUT_WIDTH = 720;
  
  static
  {
    VIDEO_OUTPUT_HEIGHT = 960;
    VIDEO_OUTPUT_HEIGHT_SHORT = 720;
    VIDEO_OUTPUT_HEIGHT_LONG = 1280;
    VIDEO_FRAME_RATE = 25;
    MS_VIDEO_FRAME_RATE = 25;
    VIDEO_OUTPUT_WATERMARK_WIDTH = 140;
    VIDEO_OUTPUT_WATERMARK_HEIGHT = 55;
    VIDEO_IMAGE_WIDTH = 480;
    VIDEO_IMAGE_HEIGHT = 640;
    INTERMIDIATE_IMAGE_WIDTH_HIGH = 1080;
    INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 720;
    INTERMIDIATE_IMAGE_WIDTH_LOW = 540;
    BPS_HIGH = 5242880;
    BPS_MEDIUM = 5242880;
    BPS_LOW = 5242880;
    GIF_OUTPUT_TEX_WIDTH = 720;
    GIF_OUTPUT_TEX_HEIGHT = 720;
    GIF_PLAY_RATE = 0.5F;
    GIF_SAMPLE_TIME_MS = 200L;
    GIF_OUTPUT_WATERMARK_WIDTH = 180;
  }
  
  public static int getDowngradeWidth(int paramInt)
  {
    if (paramInt <= 0) {
      return MediaConfig.ENCODE_SIZE.HIGH.width;
    }
    if (paramInt == MediaConfig.ENCODE_SIZE.HIGH.width) {
      return MediaConfig.ENCODE_SIZE.MEDIUM.width;
    }
    if (paramInt == MediaConfig.ENCODE_SIZE.MEDIUM.width) {
      return MediaConfig.ENCODE_SIZE.LOW.width;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.config.MediaConfig
 * JD-Core Version:    0.7.0.1
 */