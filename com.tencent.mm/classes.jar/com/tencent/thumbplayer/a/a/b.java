package com.tencent.thumbplayer.a.a;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.List;
import java.util.Map;

public abstract interface b
{
  public abstract void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong);
  
  public abstract void a(c.a parama);
  
  public abstract void a(c.b paramb);
  
  public abstract void a(c.c paramc);
  
  public abstract void a(c.d paramd);
  
  public abstract void a(c.e parame);
  
  public abstract void a(c.f paramf);
  
  public abstract void a(c.g paramg);
  
  public abstract void a(c.i parami);
  
  public abstract void a(c.j paramj);
  
  public abstract void a(c.k paramk);
  
  public abstract void a(c.l paraml);
  
  public abstract void a(c.m paramm);
  
  public abstract void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract long getPlayableDurationMs();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract long getPropertyLong(int paramInt);
  
  public abstract String getPropertyString(int paramInt);
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void h(String paramString1, String paramString2, List<TPOptionalParam> paramList);
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2);
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setAudioNormalizeVolumeParams(String paramString);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset);
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void updateLoggerContext(com.tencent.thumbplayer.f.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b
 * JD-Core Version:    0.7.0.1
 */