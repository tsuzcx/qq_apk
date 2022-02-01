package com.tencent.thumbplayer.core.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Vector;

public class TPNativePlayerInitConfig
{
  public static final int BOOL_ENABLE_ASYNC_MEDIA_CODEC = 206;
  public static final int BOOL_ENABLE_AUDIO_FRAME_CALLBACK = 402;
  public static final int BOOL_ENABLE_AUDIO_PASSTHROUGH = 210;
  public static final int BOOL_ENABLE_AUDIO_RENDERER_LATENCY_COMPENSATION = 401;
  public static final int BOOL_ENABLE_AUDIO_SYNC_FREE_RUN = 411;
  public static final int BOOL_ENABLE_AV_SYNC = 400;
  public static final int BOOL_ENABLE_COLOR_MANAGEMENT = 407;
  public static final int BOOL_ENABLE_DROPFRAME_BY_REFRESHRATE = 406;
  public static final int BOOL_ENABLE_FORCE_FFMPEG_DEMUXER = 114;
  public static final int BOOL_ENABLE_HEVC_OPTIMIZATION = 115;
  public static final int BOOL_ENABLE_MEDIA_CODEC_REUSE = 213;
  public static final int BOOL_ENABLE_MEDIA_CODEC_SET_OPERATE_RATE = 212;
  public static final int BOOL_ENABLE_MULTI_RECEIVE_FRAMES = 209;
  public static final int BOOL_ENABLE_NATIVE_MEDIA_CODEC = 204;
  public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 205;
  public static final int BOOL_ENABLE_VIDEO_FRAME_CALLBACK = 403;
  public static final int BOOL_HLS_HTTP_KEEP_ALIVE = 110;
  public static final int BOOL_HLS_SWITCH_BY_SEGMENT = 111;
  public static final int BOOL_KEEP_ORIGINAL_PTS = 112;
  public static final int BOOL_RELEASE_MEDIA_CODEC_WHEN_SET_SURFACE = 211;
  public static final int BOOL_RESET_DECODER_ON_PARAMETER_CHANGE = 201;
  public static final int BOOL_START_PLAYING_TIME_ACCURATE_SEEK = 101;
  public static final int BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS = 215;
  public static final int FLOAT_REDUCE_LATENCY_SPEED_UP_RATE = 120;
  public static final int FLOAT_VIDEO_DROP_FRAME_DETECT_MIN_RATE = 208;
  public static final int INT_AUDIO_RENDERER_TYPE = 404;
  public static final int INT_DECODER_MAX_TOLERATED_ERROR_COUNT = 200;
  public static final int INT_ENABLE_RENDERER_SHARPEN = 451;
  public static final int INT_FRAME_SIZE_BYTE = 303;
  public static final int INT_HEIGHT = 312;
  public static final int INT_PIXEL_FORMAT = 310;
  public static final int INT_REDUCE_LIVE_LATENCY_ACTION = 119;
  public static final int INT_ROTATION = 313;
  public static final int INT_SAMPLE_FORMAT = 300;
  public static final int INT_SAMPLE_RATE_HZ = 302;
  public static final int INT_STREAM_DEMUXER_FORMAT = 116;
  public static final int INT_STREAM_TYPE = 304;
  public static final int INT_TCP_RETRY_COUNT = 109;
  public static final int INT_VIDEO_RENDERER_TYPE = 405;
  public static final int INT_WIDTH = 311;
  public static final int LONG_AUDIO_NON_BLUETOOTH_MAX_LIMIT_LATENCY_MS = 409;
  public static final int LONG_BUFFERING_TIMEOUT_MS = 107;
  public static final int LONG_BUFFER_PACKET_MAX_TOTAL_DURATION_MS = 117;
  public static final int LONG_BUFFER_PACKET_MIN_TOTAL_DURATION_MS = 102;
  public static final int LONG_CHANNEL_LAYOUT = 301;
  public static final int LONG_MAX_ANALYZE_DURATION_MS = 121;
  public static final int LONG_MAX_BUFFERING_TIME_MS = 106;
  public static final int LONG_MIN_BUFFERING_PACKET_DURATION_MS = 104;
  public static final int LONG_MIN_BUFFERING_TIME_MS = 105;
  public static final int LONG_PRELOAD_PACKET_TOTAL_DURATION_MS = 103;
  public static final int LONG_PREPARE_TIMEOUT_MS = 118;
  public static final int LONG_START_PLAYING_TIME_MS = 100;
  public static final int LONG_TCP_TIMEOUT_MS = 108;
  public static final int LONG_VIDEO_DROP_FRAME_TIME_UNIT_MS = 207;
  public static final int QUEUE_INT_AUDIO_DECODER_TYPE = 202;
  public static final int QUEUE_INT_VIDEO_DECODER_TYPE = 203;
  public static final int QUEUE_STRING_HLS_TAG_CALLBACK = 113;
  public static final int STRING_SHARPEN_SHADER_PATH = 452;
  private HashMap<Integer, Boolean> mBoolMap;
  private HashMap<Integer, Float> mFloatMap;
  private HashMap<Integer, Integer> mIntMap;
  private HashMap<Integer, Long> mLongMap;
  private HashMap<Integer, Vector<Integer>> mQueueIntMap;
  private HashMap<Integer, Vector<String>> mQueueStringMap;
  private HashMap<Integer, String> mStringMap;
  
  public TPNativePlayerInitConfig()
  {
    AppMethodBeat.i(228249);
    this.mIntMap = new HashMap();
    this.mStringMap = new HashMap();
    this.mLongMap = new HashMap();
    this.mFloatMap = new HashMap();
    this.mBoolMap = new HashMap();
    this.mQueueIntMap = new HashMap();
    this.mQueueStringMap = new HashMap();
    AppMethodBeat.o(228249);
  }
  
  public void addQueueInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228254);
    Vector localVector2 = (Vector)this.mQueueIntMap.get(Integer.valueOf(paramInt1));
    Vector localVector1 = localVector2;
    if (localVector2 == null)
    {
      localVector1 = new Vector();
      this.mQueueIntMap.put(Integer.valueOf(paramInt1), localVector1);
    }
    localVector1.add(Integer.valueOf(paramInt2));
    AppMethodBeat.o(228254);
  }
  
  public void addQueueString(int paramInt, String paramString)
  {
    AppMethodBeat.i(228261);
    Vector localVector2 = (Vector)this.mQueueStringMap.get(Integer.valueOf(paramInt));
    Vector localVector1 = localVector2;
    if (localVector2 == null)
    {
      localVector1 = new Vector();
      this.mQueueStringMap.put(Integer.valueOf(paramInt), localVector1);
    }
    localVector1.add(paramString);
    AppMethodBeat.o(228261);
  }
  
  public HashMap<Integer, Boolean> getBoolMap()
  {
    return this.mBoolMap;
  }
  
  public HashMap<Integer, Float> getFloatMap()
  {
    return this.mFloatMap;
  }
  
  public HashMap<Integer, Integer> getIntMap()
  {
    return this.mIntMap;
  }
  
  public HashMap<Integer, Long> getLongMap()
  {
    return this.mLongMap;
  }
  
  public HashMap<Integer, Vector<Integer>> getQueueIntMap()
  {
    return this.mQueueIntMap;
  }
  
  public HashMap<Integer, Vector<String>> getQueueStringMap()
  {
    return this.mQueueStringMap;
  }
  
  public HashMap<Integer, String> getStringMap()
  {
    return this.mStringMap;
  }
  
  public void setBool(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(228287);
    this.mBoolMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228287);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(228282);
    this.mFloatMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    AppMethodBeat.o(228282);
  }
  
  public void setInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228267);
    this.mIntMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    AppMethodBeat.o(228267);
  }
  
  public void setLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228278);
    this.mLongMap.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    AppMethodBeat.o(228278);
  }
  
  public void setString(int paramInt, String paramString)
  {
    AppMethodBeat.i(228272);
    this.mStringMap.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(228272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig
 * JD-Core Version:    0.7.0.1
 */