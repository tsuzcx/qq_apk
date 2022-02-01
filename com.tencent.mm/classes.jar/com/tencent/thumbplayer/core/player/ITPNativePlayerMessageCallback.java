package com.tencent.thumbplayer.core.player;

public abstract interface ITPNativePlayerMessageCallback
{
  public static final int ASYNC_CALL_DESELECT_TRACK = 5;
  public static final int ASYNC_CALL_PREPARE = 1;
  public static final int ASYNC_CALL_SEEK = 2;
  public static final int ASYNC_CALL_SELECT_PROGRAM = 6;
  public static final int ASYNC_CALL_SELECT_TRACK = 4;
  public static final int ASYNC_CALL_SWITCH_DEFINITION = 3;
  public static final int ERROR_DECODER_AUDIO_NOT_SUPPORT = 1210;
  public static final int ERROR_DECODER_AUDIO_STREAM = 1211;
  public static final int ERROR_DECODER_OTHERS = 1200;
  public static final int ERROR_DECODER_SUBTITLE_NOT_SUPPORT = 1230;
  public static final int ERROR_DECODER_SUBTITLE_STREAM = 1231;
  public static final int ERROR_DECODER_VIDEO_NOT_SUPPORT = 1220;
  public static final int ERROR_DECODER_VIDEO_STREAM = 1221;
  public static final int ERROR_DEMUXER_BUFFERING_TIMEOUT = 1103;
  public static final int ERROR_DEMUXER_NETWORK = 1101;
  public static final int ERROR_DEMUXER_OTHERS = 1100;
  public static final int ERROR_DEMUXER_PREPARE_TIMEOUT = 1104;
  public static final int ERROR_DEMUXER_STREAM = 1102;
  public static final int ERROR_GENERAL = 1001;
  public static final int ERROR_OK = 1000;
  public static final int ERROR_PROCESS_AUDIO_OTHERS = 1500;
  public static final int ERROR_PROCESS_VIDEO_OTHERS = 1600;
  public static final int ERROR_RENDERER_OTHERS = 1300;
  public static final int INFO_LONG0_AUDIO_HW_DECODING_SLOW = 206;
  public static final int INFO_LONG0_AUDIO_PASSTHROUGH_START = 210;
  public static final int INFO_LONG0_AUDIO_PASSTHROUGH_STOP = 211;
  public static final int INFO_LONG0_AUDIO_SW_DECODING_SLOW = 205;
  public static final int INFO_LONG0_BUFFERING_END = 201;
  public static final int INFO_LONG0_BUFFERING_START = 200;
  public static final int INFO_LONG0_CURRENT_LOOP_END = 151;
  public static final int INFO_LONG0_CURRENT_LOOP_START = 150;
  public static final int INFO_LONG0_EOS = 153;
  public static final int INFO_LONG0_FIRST_AUDIO_DECODER_START = 103;
  public static final int INFO_LONG0_FIRST_AUDIO_FRAME_RENDERED = 105;
  public static final int INFO_LONG0_FIRST_CLIP_OPENED = 101;
  public static final int INFO_LONG0_FIRST_PACKET_READ = 107;
  public static final int INFO_LONG0_FIRST_VIDEO_DECODER_START = 104;
  public static final int INFO_LONG0_FIRST_VIDEO_FRAME_RENDERED = 106;
  public static final int INFO_LONG0_KEY_PACKET_READ = 102;
  public static final int INFO_LONG0_VIDEO_HW_DECODING_SLOW = 208;
  public static final int INFO_LONG0_VIDEO_SW_DECODING_SLOW = 207;
  public static final int INFO_LONG1_AUDIO_DECODER_TYPE = 203;
  public static final int INFO_LONG1_CLIP_EOS = 152;
  public static final int INFO_LONG1_VIDEO_DECODER_TYPE = 204;
  public static final int INFO_LONG2_VIDEO_DROP_FRAME_EVENT = 209;
  public static final int INFO_LONG2_VIDEO_RESOLUTION_CHANGE = 250;
  public static final int INFO_OBJECT_PRIVATE_HLS_TAG = 501;
  public static final int INFO_OBJECT_SUBTITLE_TEXT = 502;
  public static final int INFO_OBJECT_VIDEO_CROP = 500;
  public static final int INFO_OBJECT_VIDEO_SEI_INFO = 503;
  
  public abstract void onASyncCallResult(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public abstract void onError(int paramInt1, int paramInt2);
  
  public abstract void onInfoLong(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void onInfoObject(int paramInt, Object paramObject);
  
  public static class VideoCropInfo
  {
    public int cropBottom;
    public int cropLeft;
    public int cropRight;
    public int cropTop;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
 * JD-Core Version:    0.7.0.1
 */