package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoSeiInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.utils.d;
import com.tencent.thumbplayer.utils.g;
import java.util.Arrays;

public final class c
{
  private static String TAG = "TPThumbPlayerUtils";
  
  public static TPAudioFrameBuffer a(TPAudioFrame paramTPAudioFrame)
  {
    AppMethodBeat.i(228737);
    if (paramTPAudioFrame == null)
    {
      AppMethodBeat.o(228737);
      return null;
    }
    TPAudioFrameBuffer localTPAudioFrameBuffer = new TPAudioFrameBuffer();
    localTPAudioFrameBuffer.format = d.aIf(paramTPAudioFrame.format);
    localTPAudioFrameBuffer.data = paramTPAudioFrame.data;
    localTPAudioFrameBuffer.size = paramTPAudioFrame.linesize;
    localTPAudioFrameBuffer.sampleRate = paramTPAudioFrame.sampleRate;
    localTPAudioFrameBuffer.channelLayout = paramTPAudioFrame.channelLayout;
    localTPAudioFrameBuffer.ptsMs = (paramTPAudioFrame.ptsUs / 1000L);
    localTPAudioFrameBuffer.nbSamples = paramTPAudioFrame.nbSamples;
    localTPAudioFrameBuffer.channels = paramTPAudioFrame.channels;
    AppMethodBeat.o(228737);
    return localTPAudioFrameBuffer;
  }
  
  public static TPPlayerMsg.TPMediaCodecInfo a(ITPNativePlayerMessageCallback.MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(228779);
    if (paramMediaCodecInfo == null)
    {
      AppMethodBeat.o(228779);
      return null;
    }
    TPPlayerMsg.TPMediaCodecInfo localTPMediaCodecInfo = new TPPlayerMsg.TPMediaCodecInfo();
    switch (paramMediaCodecInfo.mediaType)
    {
    default: 
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_UNKNOWN;
      switch (paramMediaCodecInfo.infoType)
      {
      default: 
        localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_UNKNOWN;
      }
      break;
    }
    for (;;)
    {
      localTPMediaCodecInfo.msg = paramMediaCodecInfo.msg;
      AppMethodBeat.o(228779);
      return localTPMediaCodecInfo;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO;
      break;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_AUDIO;
      break;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY;
      continue;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION;
    }
  }
  
  public static TPPlayerMsg.TPVideoCropInfo a(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    AppMethodBeat.i(228713);
    if (paramVideoCropInfo == null)
    {
      AppMethodBeat.o(228713);
      return null;
    }
    TPPlayerMsg.TPVideoCropInfo localTPVideoCropInfo = new TPPlayerMsg.TPVideoCropInfo();
    localTPVideoCropInfo.width = paramVideoCropInfo.width;
    localTPVideoCropInfo.height = paramVideoCropInfo.height;
    localTPVideoCropInfo.cropLeft = paramVideoCropInfo.cropLeft;
    localTPVideoCropInfo.cropRight = paramVideoCropInfo.cropRight;
    localTPVideoCropInfo.cropTop = paramVideoCropInfo.cropTop;
    localTPVideoCropInfo.cropBottom = paramVideoCropInfo.cropBottom;
    AppMethodBeat.o(228713);
    return localTPVideoCropInfo;
  }
  
  public static TPPlayerMsg.TPVideoSeiInfo a(ITPNativePlayerMessageCallback.VideoSeiInfo paramVideoSeiInfo)
  {
    AppMethodBeat.i(228783);
    if (paramVideoSeiInfo == null)
    {
      AppMethodBeat.o(228783);
      return null;
    }
    TPPlayerMsg.TPVideoSeiInfo localTPVideoSeiInfo = new TPPlayerMsg.TPVideoSeiInfo();
    localTPVideoSeiInfo.videoCodecType = paramVideoSeiInfo.videoCodecType;
    localTPVideoSeiInfo.videoSeiType = paramVideoSeiInfo.videoSeiType;
    localTPVideoSeiInfo.seiDataSize = paramVideoSeiInfo.dataSize;
    localTPVideoSeiInfo.seiData = Arrays.copyOf(paramVideoSeiInfo.data, paramVideoSeiInfo.dataSize);
    AppMethodBeat.o(228783);
    return localTPVideoSeiInfo;
  }
  
  public static TPPostProcessFrameBuffer a(TPPostProcessFrame paramTPPostProcessFrame)
  {
    int i = 2;
    AppMethodBeat.i(228766);
    if (paramTPPostProcessFrame == null)
    {
      AppMethodBeat.o(228766);
      return null;
    }
    TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = new TPPostProcessFrameBuffer();
    int j = paramTPPostProcessFrame.mediaType;
    if (-1 != j) {
      if (j == 0)
      {
        i = 0;
        localTPPostProcessFrameBuffer.mediaType = i;
        if (localTPPostProcessFrameBuffer.mediaType != 0) {
          break label220;
        }
        localTPPostProcessFrameBuffer.format = d.aIe(paramTPPostProcessFrame.format);
      }
    }
    for (;;)
    {
      localTPPostProcessFrameBuffer.data = paramTPPostProcessFrame.data;
      localTPPostProcessFrameBuffer.size = paramTPPostProcessFrame.linesize;
      localTPPostProcessFrameBuffer.sampleRate = paramTPPostProcessFrame.sampleRate;
      localTPPostProcessFrameBuffer.channelLayout = paramTPPostProcessFrame.channelLayout;
      localTPPostProcessFrameBuffer.ptsMs = (paramTPPostProcessFrame.ptsUs / 1000L);
      localTPPostProcessFrameBuffer.nbSamples = paramTPPostProcessFrame.nbSamples;
      localTPPostProcessFrameBuffer.channels = paramTPPostProcessFrame.channels;
      localTPPostProcessFrameBuffer.width = paramTPPostProcessFrame.width;
      localTPPostProcessFrameBuffer.height = paramTPPostProcessFrame.height;
      localTPPostProcessFrameBuffer.sampleAspectRatioNum = paramTPPostProcessFrame.sampleAspectRatioNum;
      localTPPostProcessFrameBuffer.sampleAspectRatioDen = paramTPPostProcessFrame.sampleAspectRatioDen;
      localTPPostProcessFrameBuffer.rotation = paramTPPostProcessFrame.rotation;
      localTPPostProcessFrameBuffer.perfData = paramTPPostProcessFrame.perfData;
      AppMethodBeat.o(228766);
      return localTPPostProcessFrameBuffer;
      if (1 == j)
      {
        i = 1;
        break;
      }
      if (2 == j) {
        break;
      }
      if (3 == j)
      {
        i = 3;
        break;
      }
      if (4 == j)
      {
        i = 4;
        break;
      }
      i = -1;
      break;
      label220:
      if (localTPPostProcessFrameBuffer.mediaType == 1) {
        localTPPostProcessFrameBuffer.format = d.aIf(paramTPPostProcessFrame.format);
      }
    }
  }
  
  public static TPSubtitleFrameBuffer a(TPSubtitleFrame paramTPSubtitleFrame)
  {
    int i = 26;
    AppMethodBeat.i(228763);
    if (paramTPSubtitleFrame == null)
    {
      AppMethodBeat.o(228763);
      return null;
    }
    TPSubtitleFrameBuffer localTPSubtitleFrameBuffer = new TPSubtitleFrameBuffer();
    localTPSubtitleFrameBuffer.data = paramTPSubtitleFrame.data;
    localTPSubtitleFrameBuffer.lineSize = paramTPSubtitleFrame.linesize;
    int j = paramTPSubtitleFrame.format;
    if ((-1 != j) && (26 == j)) {}
    for (;;)
    {
      localTPSubtitleFrameBuffer.format = i;
      localTPSubtitleFrameBuffer.srcHeight = paramTPSubtitleFrame.height;
      localTPSubtitleFrameBuffer.srcWidth = paramTPSubtitleFrame.width;
      localTPSubtitleFrameBuffer.dstHeight = paramTPSubtitleFrame.height;
      localTPSubtitleFrameBuffer.dstWidth = paramTPSubtitleFrame.width;
      localTPSubtitleFrameBuffer.rotation = paramTPSubtitleFrame.rotation;
      localTPSubtitleFrameBuffer.ptsMs = (paramTPSubtitleFrame.ptsUs / 1000L);
      AppMethodBeat.o(228763);
      return localTPSubtitleFrameBuffer;
      i = -1;
    }
  }
  
  public static TPSurfaceRenderInfo a(TPNativePlayerSurfaceRenderInfo paramTPNativePlayerSurfaceRenderInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(228789);
    if (paramTPNativePlayerSurfaceRenderInfo == null)
    {
      AppMethodBeat.o(228789);
      return null;
    }
    TPSurfaceRenderInfo localTPSurfaceRenderInfo = new TPSurfaceRenderInfo();
    localTPSurfaceRenderInfo.displayWidth = paramTPNativePlayerSurfaceRenderInfo.displayWidth;
    localTPSurfaceRenderInfo.displayHeight = paramTPNativePlayerSurfaceRenderInfo.displayHeight;
    TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo localTPVideoCropInfo = paramTPNativePlayerSurfaceRenderInfo.videoCropInfo;
    if (localTPVideoCropInfo == null) {
      paramTPNativePlayerSurfaceRenderInfo = localObject;
    }
    for (;;)
    {
      localTPSurfaceRenderInfo.videoCropInfo = paramTPNativePlayerSurfaceRenderInfo;
      AppMethodBeat.o(228789);
      return localTPSurfaceRenderInfo;
      paramTPNativePlayerSurfaceRenderInfo = new TPSurfaceRenderInfo.TPVideoCropInfo();
      paramTPNativePlayerSurfaceRenderInfo.cropLeft = localTPVideoCropInfo.cropLeft;
      paramTPNativePlayerSurfaceRenderInfo.cropRight = localTPVideoCropInfo.cropRight;
      paramTPNativePlayerSurfaceRenderInfo.cropTop = localTPVideoCropInfo.cropTop;
      paramTPNativePlayerSurfaceRenderInfo.cropBottom = localTPVideoCropInfo.cropBottom;
      paramTPNativePlayerSurfaceRenderInfo.width = localTPVideoCropInfo.width;
      paramTPNativePlayerSurfaceRenderInfo.height = localTPVideoCropInfo.height;
    }
  }
  
  public static TPVideoFrameBuffer a(TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(228731);
    TPVideoFrameBuffer localTPVideoFrameBuffer = new TPVideoFrameBuffer();
    localTPVideoFrameBuffer.data = paramTPVideoFrame.data;
    localTPVideoFrameBuffer.lineSize = paramTPVideoFrame.linesize;
    localTPVideoFrameBuffer.format = d.aIe(paramTPVideoFrame.format);
    localTPVideoFrameBuffer.srcHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.srcWidth = paramTPVideoFrame.width;
    localTPVideoFrameBuffer.dstHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.dstWidth = paramTPVideoFrame.width;
    if ((paramTPVideoFrame.sampleAspectRatioDen > 0) && (paramTPVideoFrame.sampleAspectRatioNum > 0)) {
      localTPVideoFrameBuffer.dstWidth = Math.round(paramTPVideoFrame.sampleAspectRatioNum / paramTPVideoFrame.sampleAspectRatioDen * localTPVideoFrameBuffer.dstWidth);
    }
    localTPVideoFrameBuffer.rotation = paramTPVideoFrame.rotation;
    localTPVideoFrameBuffer.ptsMs = (paramTPVideoFrame.ptsUs / 1000L);
    AppMethodBeat.o(228731);
    return localTPVideoFrameBuffer;
  }
  
  public static int aHy(int paramInt)
  {
    AppMethodBeat.i(228720);
    switch (paramInt)
    {
    default: 
      g.e(TAG, "decoderType: " + paramInt + " not recognition, return -1");
      paramInt = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(228720);
      return paramInt;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 101;
      continue;
      paramInt = 102;
    }
  }
  
  public static TPPostProcessFrame c(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    int k = 1;
    int j = -1;
    AppMethodBeat.i(228773);
    if (paramTPPostProcessFrameBuffer == null)
    {
      AppMethodBeat.o(228773);
      return null;
    }
    TPPostProcessFrame localTPPostProcessFrame = new TPPostProcessFrame();
    int i = paramTPPostProcessFrameBuffer.mediaType;
    if (-1 != i) {
      if (i == 0)
      {
        i = 0;
        localTPPostProcessFrame.mediaType = i;
        if (localTPPostProcessFrame.mediaType != 0) {
          break label298;
        }
        k = paramTPPostProcessFrameBuffer.format;
        i = j;
        if (-1 != k)
        {
          if (k != 0) {
            break label260;
          }
          i = 0;
        }
        localTPPostProcessFrame.format = i;
      }
    }
    label260:
    label298:
    while (localTPPostProcessFrame.mediaType != 1) {
      for (;;)
      {
        localTPPostProcessFrame.data = paramTPPostProcessFrameBuffer.data;
        localTPPostProcessFrame.linesize = paramTPPostProcessFrameBuffer.size;
        localTPPostProcessFrame.sampleRate = paramTPPostProcessFrameBuffer.sampleRate;
        localTPPostProcessFrame.channelLayout = paramTPPostProcessFrameBuffer.channelLayout;
        localTPPostProcessFrame.ptsUs = (paramTPPostProcessFrameBuffer.ptsMs * 1000L);
        localTPPostProcessFrame.nbSamples = paramTPPostProcessFrameBuffer.nbSamples;
        localTPPostProcessFrame.channels = paramTPPostProcessFrameBuffer.channels;
        localTPPostProcessFrame.width = paramTPPostProcessFrameBuffer.width;
        localTPPostProcessFrame.height = paramTPPostProcessFrameBuffer.height;
        localTPPostProcessFrame.sampleAspectRatioNum = paramTPPostProcessFrameBuffer.sampleAspectRatioNum;
        localTPPostProcessFrame.sampleAspectRatioDen = paramTPPostProcessFrameBuffer.sampleAspectRatioDen;
        localTPPostProcessFrame.rotation = paramTPPostProcessFrameBuffer.rotation;
        localTPPostProcessFrame.perfData = paramTPPostProcessFrameBuffer.perfData;
        AppMethodBeat.o(228773);
        return localTPPostProcessFrame;
        if (1 == i)
        {
          i = 1;
          break;
        }
        if (2 == i)
        {
          i = 2;
          break;
        }
        if (3 == i)
        {
          i = 3;
          break;
        }
        if (4 == i)
        {
          i = 4;
          break;
        }
        i = -1;
        break;
        if (12 == k)
        {
          i = 12;
        }
        else if (26 == k)
        {
          i = 26;
        }
        else
        {
          i = j;
          if (37 == k) {
            i = 37;
          }
        }
      }
    }
    j = paramTPPostProcessFrameBuffer.format;
    if (-1 != j) {
      if (j == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      localTPPostProcessFrame.format = i;
      break;
      i = k;
      if (1 != j) {
        if (2 == j) {
          i = 2;
        } else if (3 == j) {
          i = 3;
        } else if (4 == j) {
          i = 4;
        } else if (5 == j) {
          i = 5;
        } else if (6 == j) {
          i = 6;
        } else if (7 == j) {
          i = 7;
        } else if (8 == j) {
          i = 8;
        } else if (9 == j) {
          i = 9;
        } else if (10 == j) {
          i = 10;
        } else if (11 == j) {
          i = 11;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */