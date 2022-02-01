package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class TXLivePusher
{
  public static final int RGB_BGRA = 4;
  public static final int RGB_RGBA = 5;
  public static final int YUV_420P = 3;
  public static final int YUV_420SP = 1;
  public static final int YUV_420YpCbCr = 2;
  private b mTXTxLivePusherImpl;
  
  public TXLivePusher(Context paramContext)
  {
    AppMethodBeat.i(13556);
    this.mTXTxLivePusherImpl = new b(paramContext);
    AppMethodBeat.o(13556);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(182244);
    this.mTXTxLivePusherImpl.f(paramInt);
    AppMethodBeat.o(182244);
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(13577);
    TXBeautyManager localTXBeautyManager = this.mTXTxLivePusherImpl.r();
    AppMethodBeat.o(13577);
    return localTXBeautyManager;
  }
  
  public TXLivePushConfig getConfig()
  {
    AppMethodBeat.i(13558);
    TXLivePushConfig localTXLivePushConfig = this.mTXTxLivePusherImpl.i();
    AppMethodBeat.o(13558);
    return localTXLivePushConfig;
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(13574);
    int i = this.mTXTxLivePusherImpl.q();
    AppMethodBeat.o(13574);
    return i;
  }
  
  public int getMusicDuration(String paramString)
  {
    AppMethodBeat.i(13596);
    int i = this.mTXTxLivePusherImpl.d(paramString);
    AppMethodBeat.o(13596);
    return i;
  }
  
  public boolean isPushing()
  {
    AppMethodBeat.i(13568);
    boolean bool = this.mTXTxLivePusherImpl.m();
    AppMethodBeat.o(13568);
    return bool;
  }
  
  public void onLogRecord(String paramString)
  {
    AppMethodBeat.i(13617);
    this.mTXTxLivePusherImpl.f(paramString);
    AppMethodBeat.o(13617);
  }
  
  public boolean pauseBGM()
  {
    AppMethodBeat.i(13594);
    boolean bool = this.mTXTxLivePusherImpl.t();
    AppMethodBeat.o(13594);
    return bool;
  }
  
  public void pausePusher()
  {
    AppMethodBeat.i(13566);
    this.mTXTxLivePusherImpl.k();
    AppMethodBeat.o(13566);
  }
  
  public boolean playBGM(String paramString)
  {
    AppMethodBeat.i(13592);
    boolean bool = this.mTXTxLivePusherImpl.c(paramString);
    AppMethodBeat.o(13592);
    return bool;
  }
  
  public boolean resumeBGM()
  {
    AppMethodBeat.i(13595);
    boolean bool = this.mTXTxLivePusherImpl.u();
    AppMethodBeat.o(13595);
    return bool;
  }
  
  public void resumePusher()
  {
    AppMethodBeat.i(13567);
    this.mTXTxLivePusherImpl.l();
    AppMethodBeat.o(13567);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13609);
    this.mTXTxLivePusherImpl.a(paramArrayOfByte);
    AppMethodBeat.o(13609);
  }
  
  public int sendCustomVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(13608);
    paramInt1 = this.mTXTxLivePusherImpl.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(13608);
    return paramInt1;
  }
  
  public int sendCustomVideoTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(13607);
    paramInt1 = this.mTXTxLivePusherImpl.c(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(13607);
    return paramInt1;
  }
  
  @Deprecated
  public void sendMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13616);
    this.mTXTxLivePusherImpl.c(paramArrayOfByte);
    AppMethodBeat.o(13616);
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13615);
    boolean bool = this.mTXTxLivePusherImpl.b(paramArrayOfByte);
    AppMethodBeat.o(13615);
    return bool;
  }
  
  public void setAudioProcessListener(AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    AppMethodBeat.i(13611);
    this.mTXTxLivePusherImpl.a(paramAudioCustomProcessListener);
    AppMethodBeat.o(13611);
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(182243);
    this.mTXTxLivePusherImpl.a(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(182243);
  }
  
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(13591);
    this.mTXTxLivePusherImpl.a(paramOnBGMNotify);
    AppMethodBeat.o(13591);
  }
  
  public void setBGMPitch(float paramFloat)
  {
    AppMethodBeat.i(13599);
    this.mTXTxLivePusherImpl.e(paramFloat);
    AppMethodBeat.o(13599);
  }
  
  public boolean setBGMPosition(int paramInt)
  {
    AppMethodBeat.i(13602);
    boolean bool = this.mTXTxLivePusherImpl.c(paramInt);
    AppMethodBeat.o(13602);
    return bool;
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    AppMethodBeat.i(13597);
    boolean bool = this.mTXTxLivePusherImpl.c(paramFloat);
    AppMethodBeat.o(13597);
    return bool;
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(13578);
    boolean bool = this.mTXTxLivePusherImpl.a(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(13578);
    return bool;
  }
  
  @Deprecated
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(13584);
    getBeautyManager().setChinLevel(paramInt);
    AppMethodBeat.o(13584);
  }
  
  public void setConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(13557);
    this.mTXTxLivePusherImpl.a(paramTXLivePushConfig);
    AppMethodBeat.o(13557);
  }
  
  public void setExposureCompensation(float paramFloat)
  {
    AppMethodBeat.i(13576);
    this.mTXTxLivePusherImpl.a(paramFloat);
    AppMethodBeat.o(13576);
  }
  
  @Deprecated
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(13581);
    getBeautyManager().setEyeScaleLevel(paramInt);
    AppMethodBeat.o(13581);
  }
  
  @Deprecated
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(13585);
    getBeautyManager().setFaceShortLevel(paramInt);
    AppMethodBeat.o(13585);
  }
  
  @Deprecated
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(13582);
    getBeautyManager().setFaceSlimLevel(paramInt);
    AppMethodBeat.o(13582);
  }
  
  @Deprecated
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(13583);
    getBeautyManager().setFaceVLevel(paramInt);
    AppMethodBeat.o(13583);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(13579);
    this.mTXTxLivePusherImpl.a(paramBitmap);
    AppMethodBeat.o(13579);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(13614);
    this.mTXTxLivePusherImpl.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(13614);
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(13587);
    boolean bool = this.mTXTxLivePusherImpl.b(paramString);
    AppMethodBeat.o(13587);
    return bool;
  }
  
  public boolean setMicVolume(float paramFloat)
  {
    AppMethodBeat.i(13598);
    boolean bool = this.mTXTxLivePusherImpl.d(paramFloat);
    AppMethodBeat.o(13598);
    return bool;
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(13571);
    paramBoolean = this.mTXTxLivePusherImpl.c(paramBoolean);
    AppMethodBeat.o(13571);
    return paramBoolean;
  }
  
  @Deprecated
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(13589);
    getBeautyManager().setMotionMute(paramBoolean);
    AppMethodBeat.o(13589);
  }
  
  @Deprecated
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(13588);
    getBeautyManager().setMotionTmpl(paramString);
    AppMethodBeat.o(13588);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(13590);
    this.mTXTxLivePusherImpl.e(paramBoolean);
    AppMethodBeat.o(13590);
  }
  
  @Deprecated
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(13586);
    getBeautyManager().setNoseSlimLevel(paramInt);
    AppMethodBeat.o(13586);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(13559);
    this.mTXTxLivePusherImpl.a(paramITXLivePushListener);
    AppMethodBeat.o(13559);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(13572);
    this.mTXTxLivePusherImpl.a(paramInt);
    AppMethodBeat.o(13572);
  }
  
  public void setReverb(int paramInt)
  {
    AppMethodBeat.i(13600);
    this.mTXTxLivePusherImpl.d(paramInt);
    AppMethodBeat.o(13600);
  }
  
  public void setSpecialRatio(float paramFloat)
  {
    AppMethodBeat.i(13580);
    this.mTXTxLivePusherImpl.b(paramFloat);
    AppMethodBeat.o(13580);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(13612);
    this.mTXTxLivePusherImpl.a(paramSurface);
    AppMethodBeat.o(13612);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13613);
    this.mTXTxLivePusherImpl.a(paramInt1, paramInt2);
    AppMethodBeat.o(13613);
  }
  
  public void setVideoProcessListener(VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(13610);
    this.mTXTxLivePusherImpl.a(paramVideoCustomProcessListener);
    AppMethodBeat.o(13610);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(13569);
    this.mTXTxLivePusherImpl.a(paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(13569);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(13603);
    this.mTXTxLivePusherImpl.a(paramITXVideoRecordListener);
    AppMethodBeat.o(13603);
  }
  
  public void setVoiceChangerType(int paramInt)
  {
    AppMethodBeat.i(13601);
    this.mTXTxLivePusherImpl.e(paramInt);
    AppMethodBeat.o(13601);
  }
  
  public boolean setZoom(int paramInt)
  {
    AppMethodBeat.i(13575);
    boolean bool = this.mTXTxLivePusherImpl.b(paramInt);
    AppMethodBeat.o(13575);
    return bool;
  }
  
  public void snapshot(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(13606);
    this.mTXTxLivePusherImpl.a(paramITXSnapshotListener);
    AppMethodBeat.o(13606);
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(13560);
    this.mTXTxLivePusherImpl.a(paramTXCloudVideoView);
    AppMethodBeat.o(13560);
  }
  
  public int startPusher(String paramString)
  {
    AppMethodBeat.i(13562);
    int i = this.mTXTxLivePusherImpl.a(paramString);
    AppMethodBeat.o(13562);
    return i;
  }
  
  public int startRecord(String paramString)
  {
    AppMethodBeat.i(13604);
    int i = this.mTXTxLivePusherImpl.e(paramString);
    AppMethodBeat.o(13604);
    return i;
  }
  
  public void startScreenCapture()
  {
    AppMethodBeat.i(13564);
    this.mTXTxLivePusherImpl.n();
    AppMethodBeat.o(13564);
  }
  
  public boolean stopBGM()
  {
    AppMethodBeat.i(13593);
    boolean bool = this.mTXTxLivePusherImpl.s();
    AppMethodBeat.o(13593);
    return bool;
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(13561);
    this.mTXTxLivePusherImpl.b(paramBoolean);
    AppMethodBeat.o(13561);
  }
  
  public void stopPusher()
  {
    AppMethodBeat.i(13563);
    this.mTXTxLivePusherImpl.j();
    AppMethodBeat.o(13563);
  }
  
  public void stopRecord()
  {
    AppMethodBeat.i(13605);
    this.mTXTxLivePusherImpl.v();
    AppMethodBeat.o(13605);
  }
  
  public void stopScreenCapture()
  {
    AppMethodBeat.i(13565);
    this.mTXTxLivePusherImpl.o();
    AppMethodBeat.o(13565);
  }
  
  public void switchCamera()
  {
    AppMethodBeat.i(13570);
    this.mTXTxLivePusherImpl.p();
    AppMethodBeat.o(13570);
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    AppMethodBeat.i(13573);
    paramBoolean = this.mTXTxLivePusherImpl.d(paramBoolean);
    AppMethodBeat.o(13573);
    return paramBoolean;
  }
  
  public static abstract interface AudioCustomProcessListener
  {
    public abstract void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  }
  
  public static abstract interface VideoCustomProcessListener
  {
    public abstract void onDetectFacePoints(float[] paramArrayOfFloat);
    
    public abstract int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onTextureDestoryed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher
 * JD-Core Version:    0.7.0.1
 */