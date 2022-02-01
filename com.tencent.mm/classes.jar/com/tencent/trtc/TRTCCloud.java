package com.tencent.trtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.log.TXCLog.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

public abstract class TRTCCloud
{
  private static a mTXLogListener = null;
  static WeakReference<TRTCCloud> sInstance = null;
  
  public static void destroySharedInstance() {}
  
  public static String getSDKVersion()
  {
    return TXCCommonUtil.getSDKVersionStr();
  }
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    TXCLog.setConsoleEnabled(paramBoolean);
  }
  
  public static void setLogCompressEnabled(boolean paramBoolean)
  {
    TXCLog.setLogCompressEnabled(paramBoolean);
  }
  
  public static void setLogDirPath(String paramString)
  {
    TXCLog.setLogDirPath(paramString);
  }
  
  public static void setLogLevel(int paramInt)
  {
    TXCLog.setLevel(paramInt);
  }
  
  public static void setLogListener(TRTCCloudListener.TRTCLogListener paramTRTCLogListener)
  {
    if (mTXLogListener != null) {
      mTXLogListener.Mko = null;
    }
    if (paramTRTCLogListener != null)
    {
      a locala = new a();
      mTXLogListener = locala;
      locala.Mko = paramTRTCLogListener;
    }
    for (;;)
    {
      TXCLog.setListener(mTXLogListener);
      return;
      mTXLogListener = null;
    }
  }
  
  public static native void setNetEnv(int paramInt);
  
  public static TRTCCloud sharedInstance(Context paramContext)
  {
    return TRTCCloudImpl.sharedInstance(paramContext);
  }
  
  public abstract void ConnectOtherRoom(String paramString);
  
  public abstract void DisconnectOtherRoom();
  
  public abstract void callExperimentalAPI(String paramString);
  
  public abstract void enableAudioEarMonitoring(boolean paramBoolean);
  
  public abstract void enableAudioVolumeEvaluation(int paramInt);
  
  public abstract void enableCustomAudioCapture(boolean paramBoolean);
  
  public abstract void enableCustomVideoCapture(boolean paramBoolean);
  
  public abstract int enableEncSmallVideoStream(boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam);
  
  public abstract boolean enableTorch(boolean paramBoolean);
  
  public abstract void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt);
  
  public abstract void exitRoom();
  
  public abstract int getAudioCaptureVolume();
  
  public abstract int getAudioPlayoutVolume();
  
  public abstract int getBGMDuration(String paramString);
  
  public abstract TXBeautyManager getBeautyManager();
  
  public abstract boolean isCameraAutoFocusFaceModeSupported();
  
  public abstract boolean isCameraFocusPositionInPreviewSupported();
  
  public abstract boolean isCameraTorchSupported();
  
  public abstract boolean isCameraZoomSupported();
  
  public abstract void muteAllRemoteAudio(boolean paramBoolean);
  
  public abstract void muteAllRemoteVideoStreams(boolean paramBoolean);
  
  public abstract void muteLocalAudio(boolean paramBoolean);
  
  public abstract void muteLocalVideo(boolean paramBoolean);
  
  public abstract void muteRemoteAudio(String paramString, boolean paramBoolean);
  
  public abstract void muteRemoteVideoStream(String paramString, boolean paramBoolean);
  
  public abstract void pauseAudioEffect(int paramInt);
  
  public abstract void pauseBGM();
  
  public abstract void pauseScreenCapture();
  
  public abstract void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam);
  
  public abstract void playBGM(String paramString, TRTCCloud.BGMNotify paramBGMNotify);
  
  public abstract void resumeAudioEffect(int paramInt);
  
  public abstract void resumeBGM();
  
  public abstract void resumeScreenCapture();
  
  @Deprecated
  public abstract void selectMotionTmpl(String paramString);
  
  public abstract void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame);
  
  public abstract boolean sendCustomCmdMsg(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame);
  
  public abstract boolean sendSEIMsg(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void setAllAudioEffectsVolume(int paramInt);
  
  public abstract void setAudioCaptureVolume(int paramInt);
  
  public abstract void setAudioEffectVolume(int paramInt1, int paramInt2);
  
  public abstract void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener);
  
  public abstract void setAudioPlayoutVolume(int paramInt);
  
  public abstract void setAudioRoute(int paramInt);
  
  public abstract void setBGMPlayoutVolume(int paramInt);
  
  public abstract int setBGMPosition(int paramInt);
  
  public abstract void setBGMPublishVolume(int paramInt);
  
  public abstract void setBGMVolume(int paramInt);
  
  @Deprecated
  public abstract void setBeautyStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Deprecated
  public abstract void setChinLevel(int paramInt);
  
  public abstract void setDebugViewMargin(String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin);
  
  public abstract void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2);
  
  @Deprecated
  public abstract void setEyeScaleLevel(int paramInt);
  
  @Deprecated
  public abstract void setFaceShortLevel(int paramInt);
  
  @Deprecated
  public abstract void setFaceSlimLevel(int paramInt);
  
  @Deprecated
  public abstract void setFaceVLevel(int paramInt);
  
  @Deprecated
  public abstract void setFilter(Bitmap paramBitmap);
  
  @Deprecated
  public abstract void setFilterConcentration(float paramFloat);
  
  public abstract void setFocusPosition(int paramInt1, int paramInt2);
  
  public abstract void setGSensorMode(int paramInt);
  
  @Deprecated
  @TargetApi(18)
  public abstract boolean setGreenScreenFile(String paramString);
  
  public abstract void setListener(TRTCCloudListener paramTRTCCloudListener);
  
  public abstract void setListenerHandler(Handler paramHandler);
  
  public abstract int setLocalVideoRenderListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener);
  
  public abstract void setLocalViewFillMode(int paramInt);
  
  public abstract void setLocalViewMirror(int paramInt);
  
  public abstract void setLocalViewRotation(int paramInt);
  
  @Deprecated
  public abstract void setMicVolumeOnMixing(int paramInt);
  
  public abstract void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig);
  
  @Deprecated
  public abstract void setMotionMute(boolean paramBoolean);
  
  public abstract void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam);
  
  @Deprecated
  public abstract void setNoseSlimLevel(int paramInt);
  
  public abstract int setPriorRemoteVideoStreamType(int paramInt);
  
  public abstract void setRemoteAudioVolume(String paramString, int paramInt);
  
  public abstract void setRemoteSubStreamViewFillMode(String paramString, int paramInt);
  
  public abstract void setRemoteSubStreamViewRotation(String paramString, int paramInt);
  
  public abstract int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener);
  
  public abstract int setRemoteVideoStreamType(String paramString, int paramInt);
  
  public abstract void setRemoteViewFillMode(String paramString, int paramInt);
  
  public abstract void setRemoteViewRotation(String paramString, int paramInt);
  
  public abstract void setReverbType(int paramInt);
  
  public abstract void setSystemVolumeType(int paramInt);
  
  public abstract void setVideoEncoderMirror(boolean paramBoolean);
  
  public abstract void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam);
  
  public abstract void setVideoEncoderRotation(int paramInt);
  
  public abstract boolean setVoiceChangerType(int paramInt);
  
  public abstract void setWatermark(Bitmap paramBitmap, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setZoom(int paramInt);
  
  public abstract void showDebugView(int paramInt);
  
  public abstract void snapshotVideo(String paramString, int paramInt, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener);
  
  public abstract int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams);
  
  public abstract void startLocalAudio();
  
  public abstract void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView);
  
  public abstract void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam);
  
  public abstract void startPublishing(String paramString, int paramInt);
  
  public abstract void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView);
  
  public abstract void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView);
  
  public abstract void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams);
  
  public abstract void startSpeedTest(int paramInt, String paramString1, String paramString2);
  
  public abstract void stopAllAudioEffects();
  
  public abstract void stopAllRemoteView();
  
  public abstract void stopAudioEffect(int paramInt);
  
  public abstract void stopAudioRecording();
  
  public abstract void stopBGM();
  
  public abstract void stopLocalAudio();
  
  public abstract void stopLocalPreview();
  
  public abstract void stopPublishCDNStream();
  
  public abstract void stopPublishing();
  
  public abstract void stopRemoteSubStreamView(String paramString);
  
  public abstract void stopRemoteView(String paramString);
  
  public abstract void stopScreenCapture();
  
  public abstract void stopSpeedTest();
  
  public abstract void switchCamera();
  
  public abstract void switchRole(int paramInt);
  
  static final class a
    implements TXCLog.a
  {
    TRTCCloudListener.TRTCLogListener Mko = null;
    
    public final void a(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(187559);
      TRTCCloudListener.TRTCLogListener localTRTCLogListener = this.Mko;
      if (localTRTCLogListener != null) {
        localTRTCLogListener.onLog(paramString2, paramInt, paramString1);
      }
      AppMethodBeat.o(187559);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloud
 * JD-Core Version:    0.7.0.1
 */