package com.tencent.thumbplayer.api;

import android.content.res.AssetFileDescriptor;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.a.b.b.a.h;
import com.tencent.thumbplayer.a.b.b.a.i;
import com.tencent.thumbplayer.a.b.b.a.j;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.e.a.a;
import com.tencent.thumbplayer.f.b;
import java.util.Map;

public abstract interface ITPPlayer
{
  public static final String TP_MIMETYPE_TEXT_SUBRIP = "text/x-subrip";
  public static final String TP_MIMETYPE_TEXT_VTT = "text/vtt";
  public static final int TP_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
  public static final int TP_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;
  @a.h(3)
  public static final int TP_PLAYER_SEEK_MODE_ACCURATE_POSITION = 3;
  @a.h(1)
  public static final int TP_PLAYER_SEEK_MODE_FREVIOUS_KFRAME = 1;
  @a.h(4)
  public static final int TP_PLAYER_SEEK_MODE_NEXT_CLIP = 4;
  @a.h(2)
  public static final int TP_PLAYER_SEEK_MODE_NEXT_KFRAME = 2;
  @a.j(3)
  public static final int TP_PLAYER_SWITCH_DEF_AFTER_ALL_RESOURCE_CONSUME = 3;
  @a.j(2)
  public static final int TP_PLAYER_SWITCH_DEF_FAST_WITH_KEEP_NO_BUFFERING = 2;
  @a.j(1)
  public static final int TP_PLAYER_SWITCH_DEF_IMMEDIATELY = 1;
  @a.i(2)
  public static final int TP_PLAYER_VIDEO_SURFACE_FROM_SURFACEVIEW = 2;
  @a.i(1)
  public static final int TP_PLAYER_VIDEO_SURFACE_FROM_TEXTUREVIEW = 1;
  @a.i(0)
  public static final int TP_PLAYER_VIDEO_SURFACE_UNSPECIFIED = 0;
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2);
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper);
  
  public abstract void enableTPAssetResourceLoader(a parama);
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPositionMs();
  
  public abstract int getCurrentState();
  
  public abstract long getDurationMs();
  
  public abstract long getPlayableDurationMs();
  
  public abstract ITPPlayerProxy getPlayerProxy();
  
  public abstract int getPlayerType();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract long getPropertyLong(int paramInt);
  
  public abstract String getPropertyString(int paramInt);
  
  public abstract ITPBusinessReportManager getReportManager();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setAudioNormalizeVolumeParams(String paramString);
  
  public abstract void setDataSource(AssetFileDescriptor paramAssetFileDescriptor);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener);
  
  public abstract void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener);
  
  public abstract void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener);
  
  public abstract void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener);
  
  public abstract void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener);
  
  public abstract void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener);
  
  public abstract void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener);
  
  public abstract void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener);
  
  public abstract void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener);
  
  public abstract void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener);
  
  public abstract void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener);
  
  public abstract void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener);
  
  public abstract void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySharpenSwitch();
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt);
  
  public abstract void setSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setTPSurface(ITPSurface paramITPSurface);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void stopAsync();
  
  public abstract void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
  
  public abstract void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
  
  public abstract void updateLoggerContext(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.ITPPlayer
 * JD-Core Version:    0.7.0.1
 */