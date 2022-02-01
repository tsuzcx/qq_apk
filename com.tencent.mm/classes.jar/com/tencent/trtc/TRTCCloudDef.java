package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class TRTCCloudDef
{
  public static final int TRTCAudioSampleRate16000 = 16000;
  public static final int TRTCAudioSampleRate32000 = 32000;
  public static final int TRTCAudioSampleRate44100 = 44100;
  public static final int TRTCAudioSampleRate48000 = 48000;
  public static final int TRTCRoleAnchor = 20;
  public static final int TRTCRoleAudience = 21;
  public static final int TRTCSystemVolumeTypeAuto = 0;
  public static final int TRTCSystemVolumeTypeMedia = 1;
  public static final int TRTCSystemVolumeTypeVOIP = 2;
  public static final int TRTC_APP_SCENE_AUDIOCALL = 2;
  public static final int TRTC_APP_SCENE_LIVE = 1;
  public static final int TRTC_APP_SCENE_VIDEOCALL = 0;
  public static final int TRTC_APP_SCENE_VOICE_CHATROOM = 3;
  public static final int TRTC_AUDIO_FRAME_FORMAT_PCM = 1;
  public static final int TRTC_AUDIO_ROUTE_EARPIECE = 1;
  public static final int TRTC_AUDIO_ROUTE_SPEAKER = 0;
  public static final int TRTC_BEAUTY_STYLE_NATURE = 1;
  public static final int TRTC_BEAUTY_STYLE_SMOOTH = 0;
  public static final int TRTC_DEBUG_VIEW_LEVEL_ALL = 2;
  public static final int TRTC_DEBUG_VIEW_LEVEL_GONE = 0;
  public static final int TRTC_DEBUG_VIEW_LEVEL_STATUS = 1;
  public static final int TRTC_GSENSOR_MODE_DISABLE = 0;
  public static final int TRTC_GSENSOR_MODE_UIAUTOLAYOUT = 1;
  public static final int TRTC_GSENSOR_MODE_UIFIXLAYOUT = 2;
  public static final int TRTC_LOG_LEVEL_DEBUG = 1;
  public static final int TRTC_LOG_LEVEL_ERROR = 4;
  public static final int TRTC_LOG_LEVEL_FATAL = 5;
  public static final int TRTC_LOG_LEVEL_INFO = 2;
  public static final int TRTC_LOG_LEVEL_NULL = 6;
  public static final int TRTC_LOG_LEVEL_VERBOSE = 0;
  public static final int TRTC_LOG_LEVEL_WARN = 3;
  public static final int TRTC_QUALITY_Bad = 4;
  public static final int TRTC_QUALITY_Down = 6;
  public static final int TRTC_QUALITY_Excellent = 1;
  public static final int TRTC_QUALITY_Good = 2;
  public static final int TRTC_QUALITY_Poor = 3;
  public static final int TRTC_QUALITY_UNKNOWN = 0;
  public static final int TRTC_QUALITY_Vbad = 5;
  public static final int TRTC_REVERB_TYPE_0 = 0;
  public static final int TRTC_REVERB_TYPE_1 = 1;
  public static final int TRTC_REVERB_TYPE_2 = 2;
  public static final int TRTC_REVERB_TYPE_3 = 3;
  public static final int TRTC_REVERB_TYPE_4 = 4;
  public static final int TRTC_REVERB_TYPE_5 = 5;
  public static final int TRTC_REVERB_TYPE_6 = 6;
  public static final int TRTC_REVERB_TYPE_7 = 7;
  public static final String TRTC_SDK_VERSION = "0.0.0.0";
  public static final int TRTC_TranscodingConfigMode_Manual = 1;
  public static final int TRTC_TranscodingConfigMode_Template_PresetLayout = 3;
  public static final int TRTC_TranscodingConfigMode_Template_PureAudio = 2;
  public static final int TRTC_TranscodingConfigMode_Template_ScreenSharing = 4;
  public static final int TRTC_TranscodingConfigMode_Unknown = 0;
  public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_ARRAY = 2;
  public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_BUFFER = 1;
  public static final int TRTC_VIDEO_BUFFER_TYPE_TEXTURE = 3;
  public static final int TRTC_VIDEO_BUFFER_TYPE_UNKNOWN = 0;
  public static final int TRTC_VIDEO_MIRROR_TYPE_AUTO = 0;
  public static final int TRTC_VIDEO_MIRROR_TYPE_DISABLE = 2;
  public static final int TRTC_VIDEO_MIRROR_TYPE_ENABLE = 1;
  public static final int TRTC_VIDEO_PIXEL_FORMAT_I420 = 1;
  public static final int TRTC_VIDEO_PIXEL_FORMAT_NV21 = 4;
  public static final int TRTC_VIDEO_PIXEL_FORMAT_TEXTURE_EXTERNAL_OES = 3;
  public static final int TRTC_VIDEO_PIXEL_FORMAT_Texture_2D = 2;
  public static final int TRTC_VIDEO_PIXEL_FORMAT_UNKNOWN = 0;
  public static final int TRTC_VIDEO_QOS_PREFERENCE_CLEAR = 2;
  public static final int TRTC_VIDEO_QOS_PREFERENCE_SMOOTH = 1;
  public static final int TRTC_VIDEO_RENDER_MODE_FILL = 0;
  public static final int TRTC_VIDEO_RENDER_MODE_FIT = 1;
  public static final int TRTC_VIDEO_RESOLUTION_120_120 = 1;
  public static final int TRTC_VIDEO_RESOLUTION_1280_720 = 112;
  public static final int TRTC_VIDEO_RESOLUTION_160_120 = 50;
  public static final int TRTC_VIDEO_RESOLUTION_160_160 = 3;
  public static final int TRTC_VIDEO_RESOLUTION_160_90 = 100;
  public static final int TRTC_VIDEO_RESOLUTION_240_180 = 52;
  public static final int TRTC_VIDEO_RESOLUTION_256_144 = 102;
  public static final int TRTC_VIDEO_RESOLUTION_270_270 = 5;
  public static final int TRTC_VIDEO_RESOLUTION_280_210 = 54;
  public static final int TRTC_VIDEO_RESOLUTION_320_180 = 104;
  public static final int TRTC_VIDEO_RESOLUTION_320_240 = 56;
  public static final int TRTC_VIDEO_RESOLUTION_400_300 = 58;
  public static final int TRTC_VIDEO_RESOLUTION_480_270 = 106;
  public static final int TRTC_VIDEO_RESOLUTION_480_360 = 60;
  public static final int TRTC_VIDEO_RESOLUTION_480_480 = 7;
  public static final int TRTC_VIDEO_RESOLUTION_640_360 = 108;
  public static final int TRTC_VIDEO_RESOLUTION_640_480 = 62;
  public static final int TRTC_VIDEO_RESOLUTION_960_540 = 110;
  public static final int TRTC_VIDEO_RESOLUTION_960_720 = 64;
  public static final int TRTC_VIDEO_RESOLUTION_MODE_LANDSCAPE = 0;
  public static final int TRTC_VIDEO_RESOLUTION_MODE_PORTRAIT = 1;
  public static final int TRTC_VIDEO_ROTATION_0 = 0;
  public static final int TRTC_VIDEO_ROTATION_180 = 2;
  public static final int TRTC_VIDEO_ROTATION_270 = 3;
  public static final int TRTC_VIDEO_ROTATION_90 = 1;
  public static final int TRTC_VIDEO_STREAM_TYPE_BIG = 0;
  public static final int TRTC_VIDEO_STREAM_TYPE_SMALL = 1;
  public static final int TRTC_VIDEO_STREAM_TYPE_SUB = 2;
  public static final int TRTC_VOICE_CHANGER_TYPE_0 = 0;
  public static final int TRTC_VOICE_CHANGER_TYPE_1 = 1;
  public static final int TRTC_VOICE_CHANGER_TYPE_10 = 10;
  public static final int TRTC_VOICE_CHANGER_TYPE_11 = 11;
  public static final int TRTC_VOICE_CHANGER_TYPE_2 = 2;
  public static final int TRTC_VOICE_CHANGER_TYPE_3 = 3;
  public static final int TRTC_VOICE_CHANGER_TYPE_4 = 4;
  public static final int TRTC_VOICE_CHANGER_TYPE_5 = 5;
  public static final int TRTC_VOICE_CHANGER_TYPE_6 = 6;
  public static final int TRTC_VOICE_CHANGER_TYPE_7 = 7;
  public static final int TRTC_VOICE_CHANGER_TYPE_8 = 8;
  public static final int TRTC_VOICE_CHANGER_TYPE_9 = 9;
  public static final int VIDEO_QOS_CONTROL_CLIENT = 0;
  public static final int VIDEO_QOS_CONTROL_SERVER = 1;
  
  public static class TRTCAudioEffectParam
  {
    public int effectId;
    public int loopCount;
    public String path;
    public boolean publish;
    public int volume;
    
    public TRTCAudioEffectParam(int paramInt, String paramString)
    {
      this.path = paramString;
      this.effectId = paramInt;
      this.loopCount = 0;
      this.publish = false;
      this.volume = 100;
    }
  }
  
  public static class TRTCAudioFrame
  {
    public int channel;
    public byte[] data;
    public int sampleRate;
    public long timestamp;
  }
  
  public static class TRTCAudioRecordingParams
  {
    public String filePath = "";
  }
  
  public static class TRTCMixUser
  {
    public int height;
    public boolean pureAudio;
    public String roomId;
    public int streamType;
    public String userId;
    public int width;
    public int x;
    public int y;
    public int zOrder;
    
    public TRTCMixUser()
    {
      this.userId = "";
      this.x = 0;
      this.y = 0;
      this.width = 0;
      this.height = 0;
      this.zOrder = 0;
      this.streamType = 0;
    }
    
    public TRTCMixUser(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.userId = paramString;
      this.x = paramInt1;
      this.y = paramInt2;
      this.width = paramInt3;
      this.height = paramInt4;
      this.zOrder = paramInt5;
      this.streamType = 0;
    }
  }
  
  public static class TRTCNetworkQosParam
  {
    public int controlMode;
    public int preference;
  }
  
  public static class TRTCParams
  {
    public String businessInfo = "";
    public String privateMapKey = "";
    public int role = 20;
    public int roomId = 0;
    public int sdkAppId = 0;
    public String streamId;
    public String userDefineRecordId;
    public String userId = "";
    public String userSig = "";
    
    public TRTCParams() {}
    
    public TRTCParams(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
    {
      this.sdkAppId = paramInt1;
      this.userId = paramString1;
      this.userSig = paramString2;
      this.roomId = paramInt2;
      this.privateMapKey = paramString3;
      this.businessInfo = paramString4;
    }
  }
  
  public static class TRTCPublishCDNParam
  {
    public int appId;
    public int bizId;
    public String url;
  }
  
  public static class TRTCQuality
  {
    public int quality;
    public String userId;
  }
  
  public static class TRTCSpeedTestResult
  {
    public float downLostRate;
    public String ip;
    public int quality;
    public int rtt;
    public float upLostRate;
  }
  
  public static class TRTCTexture
  {
    public javax.microedition.khronos.egl.EGLContext eglContext10;
    public android.opengl.EGLContext eglContext14;
    public int textureId;
  }
  
  public static class TRTCTranscodingConfig
  {
    public int appId;
    public int audioBitrate = 64;
    public int audioChannels = 1;
    public int audioSampleRate = 48000;
    public int backgroundColor = 0;
    public int bizId;
    public ArrayList<TRTCCloudDef.TRTCMixUser> mixUsers;
    public int mode = 0;
    public int videoBitrate = 0;
    public int videoFramerate = 15;
    public int videoGOP = 2;
    public int videoHeight = 0;
    public int videoWidth = 0;
    
    public String toString()
    {
      AppMethodBeat.i(182442);
      String str = "TRTCTranscodingConfig{appId=" + this.appId + ", bizId=" + this.bizId + ", mode=" + this.mode + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", videoFramerate=" + this.videoFramerate + ", videoGOP=" + this.videoGOP + ", backgroundColor=" + this.backgroundColor + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", audioChannels=" + this.audioChannels + ", mixUsers=" + this.mixUsers + '}';
      AppMethodBeat.o(182442);
      return str;
    }
  }
  
  public static class TRTCVideoEncParam
  {
    public boolean enableAdjustRes;
    public int videoBitrate;
    public int videoFps;
    public int videoResolution;
    public int videoResolutionMode;
  }
  
  public static class TRTCVideoFrame
  {
    public ByteBuffer buffer;
    public int bufferType;
    public byte[] data;
    public int height;
    public int pixelFormat;
    public int rotation;
    public TRTCCloudDef.TRTCTexture texture;
    public long timestamp;
    public int width;
  }
  
  public static class TRTCVolumeInfo
  {
    public String userId;
    public int volume;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef
 * JD-Core Version:    0.7.0.1
 */