package com.tencent.thumbplayer.api;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TPCommonEnum
{
  public static final int MEDIA_TYPE_ATTACHMENT = 4;
  public static final int MEDIA_TYPE_AUDIO = 1;
  public static final int MEDIA_TYPE_DATA = 2;
  public static final int MEDIA_TYPE_SUBTITLE = 3;
  public static final int MEDIA_TYPE_UNKNOWN = -1;
  public static final int MEDIA_TYPE_VIDEO = 0;
  public static final int PLAYER_DESC_ID_ANDROIDPLAYER = 1;
  public static final int PLAYER_DESC_ID_THUMBPLAYER = 2;
  public static final int PLAYER_DESC_ID_THUMBPLAYER_SOFT = 3;
  public static final int PLAYER_DESC_ID_UNKNOWN = 0;
  public static final int TP_AUDIO_DECODER_FFMPEG = 1;
  public static final int TP_AUDIO_DECODER_MEDIACODEC = 2;
  public static final int TP_AUDIO_RENDERER_TYPE_AAUDIO = 2;
  public static final int TP_AUDIO_RENDERER_TYPE_AUDIOTRACK = 1;
  public static final int TP_AUDIO_RENDERER_TYPE_OBOE = 3;
  public static final int TP_AUDIO_RENDERER_TYPE_OPENAL = 5;
  public static final int TP_AUDIO_RENDERER_TYPE_OPENSL = 4;
  public static final int TP_AUDIO_SAMPLE_FORMAT_DBL = 4;
  public static final int TP_AUDIO_SAMPLE_FORMAT_DBLP = 9;
  public static final int TP_AUDIO_SAMPLE_FORMAT_FLT = 3;
  public static final int TP_AUDIO_SAMPLE_FORMAT_FLTP = 8;
  public static final int TP_AUDIO_SAMPLE_FORMAT_NONE = -1;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S16 = 1;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S16P = 6;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S32 = 2;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S32P = 7;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S64 = 10;
  public static final int TP_AUDIO_SAMPLE_FORMAT_S64P = 11;
  public static final int TP_AUDIO_SAMPLE_FORMAT_U8 = 0;
  public static final int TP_AUDIO_SAMPLE_FORMAT_U8P = 5;
  public static final int TP_DECODER_UNKNOWN = -1;
  public static final int TP_DRM_TYPE_CHINADRM_HW = 2;
  public static final int TP_DRM_TYPE_SELF_CHINADRM = 3;
  public static final int TP_DRM_TYPE_WIDEVINE_HW = 0;
  public static final int TP_DRM_TYPE_WIDEVINE_SW = 1;
  public static final int TP_HDR_TYPE_HDR10 = 0;
  public static final int TP_HDR_TYPE_HDR10PLUS = 1;
  public static final int TP_HDR_TYPE_HDRDOLBYVISION = 2;
  public static final int TP_HDR_TYPE_HDRHLG = 3;
  public static final int TP_RENDERER_TYPE_NONE = -1;
  public static final int TP_VCODEC_TYPE_AVS3 = 192;
  public static final int TP_VCODEC_TYPE_H264 = 26;
  public static final int TP_VCODEC_TYPE_HEVC = 172;
  public static final int TP_VCODEC_TYPE_UKNOW = 0;
  public static final int TP_VIDEO_DECODER_FFMPEG = 101;
  public static final int TP_VIDEO_DECODER_MEDIACODEC = 102;
  public static final int TP_VIDEO_OUTPUT_FORMAT_NONE = -1;
  public static final int TP_VIDEO_OUTPUT_FORMAT_RGB565 = 37;
  public static final int TP_VIDEO_OUTPUT_FORMAT_RGBA = 26;
  public static final int TP_VIDEO_OUTPUT_FORMAT_YUV420P = 0;
  public static final int TP_VIDEO_OUTPUT_FORMAT_YUVJ420P = 12;
  public static final int TP_VIDEO_RENDERER_TYPE_OPENGL = 101;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MEDIA_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeErrorType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeInitConfig {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
  public static @interface NativeMsgInfo {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeOptionalId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE})
  public static @interface NativePropertyId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeSeekMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeSwitchDefMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface OptionalIdType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PlayerType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface TPErrorType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface TPMsgInfo {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
  public static @interface TPOptionalId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER})
  public static @interface TPSeekMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER})
  public static @interface TPSwitchDefMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_AUDIO_DECODER_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_AUDIO_SAMPLE_FORMAT {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_DRM_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_HDR_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_VIDEO_CODEC_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_VIDEO_DECODER_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TP_VIDEO_PIXEL_FORMAT {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPCommonEnum
 * JD-Core Version:    0.7.0.1
 */