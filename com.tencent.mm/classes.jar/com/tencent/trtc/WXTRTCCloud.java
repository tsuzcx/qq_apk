package com.tencent.trtc;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.c;
import com.tencent.liteav.f;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class WXTRTCCloud
  extends TRTCCloudImpl
{
  private static final String TAG = "WXTRTCCloud";
  private static WXTRTCCloud sInstance = null;
  private HashMap<String, d.b> mMapAudioVolumeListener;
  private HashMap<String, Integer> mMapLastUserVolumes;
  private HashMap<String, WeakReference<ITXLivePlayListener>> mMapMainStreamPlayListener;
  private HashMap<String, WeakReference<ITXLivePlayListener>> mMapSubStreamPlayListener;
  private WeakReference<ITXLivePushListener> mPushListener;
  
  public WXTRTCCloud(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(14312);
    this.mMapAudioVolumeListener = new HashMap();
    this.mMapLastUserVolumes = new HashMap();
    this.mPushListener = null;
    this.mMapMainStreamPlayListener = new HashMap();
    this.mMapSubStreamPlayListener = new HashMap();
    this.mConfig.W = false;
    this.mConfig.j = 1;
    this.mCaptureAndEnc.a(this.mConfig);
    this.mCaptureAndEnc.h(false);
    setLocalViewFillMode(0);
    AppMethodBeat.o(14312);
  }
  
  public static void destroySharedInstance()
  {
    AppMethodBeat.i(203640);
    try
    {
      if (sInstance != null)
      {
        TXCLog.i("WXTRTCCloud", "trtc_api destroy instance " + sInstance);
        sInstance.destroy();
        sInstance = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(203640);
    }
  }
  
  public static WXTRTCCloud sharedInstance(Context paramContext)
  {
    AppMethodBeat.i(14311);
    try
    {
      if (sInstance == null) {
        sInstance = new WXTRTCCloud(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(14311);
    }
  }
  
  public void checkDashBoard()
  {
    AppMethodBeat.i(14341);
    TXCloudVideoView localTXCloudVideoView = this.mRoomInfo.localView;
    if (localTXCloudVideoView != null)
    {
      CharSequence localCharSequence = getUploadStreamInfo();
      TXCLog.i("WXTRTCCloud", "[STATUS]" + localCharSequence.toString().replace("\n", ""));
      runOnMainThread(new d.3(this, localTXCloudVideoView, localCharSequence));
    }
    this.mRoomInfo.forEachUser(new d.5(this));
    AppMethodBeat.o(14341);
  }
  
  public void enableBlackStream(boolean paramBoolean)
  {
    AppMethodBeat.i(203643);
    runOnMainThread(new d.10(this, paramBoolean));
    runOnSDKThread(new d.11(this, paramBoolean));
    AppMethodBeat.o(203643);
  }
  
  public void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt)
  {
    AppMethodBeat.i(14313);
    super.enterRoom(paramTRTCParams, paramInt);
    AppMethodBeat.o(14313);
  }
  
  public void exitRoom()
  {
    AppMethodBeat.i(14314);
    super.exitRoom();
    runOnSDKThread(new d.1(this));
    AppMethodBeat.o(14314);
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(203641);
    int i = this.mCaptureAndEnc.r();
    AppMethodBeat.o(203641);
    return i;
  }
  
  public void notifyEvent(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14339);
    super.notifyEvent(paramString, paramInt, paramBundle);
    runOnSDKThread(new d.21(this, paramString, paramInt, paramBundle));
    AppMethodBeat.o(14339);
  }
  
  public void notifySEIMessage(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14342);
    runOnSDKThread(new d.6(this, paramArrayOfByte, paramString));
    AppMethodBeat.o(14342);
  }
  
  public void notifyStatistics(TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(14340);
    runOnSDKThread(new d.2(this, paramTRTCStatistics));
    AppMethodBeat.o(14340);
  }
  
  public void notifyUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(203644);
    runOnSDKThread(new d.18(this, paramArrayList));
    AppMethodBeat.o(203644);
  }
  
  public void pausePusher()
  {
    AppMethodBeat.i(14319);
    runOnSDKThread(new d.8(this));
    AppMethodBeat.o(14319);
  }
  
  public void registerAudioVolumeEvaluationListener(String paramString, boolean paramBoolean, ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(182436);
    runOnSDKThread(new d.16(this, paramString, paramBoolean, paramITXAudioVolumeEvaluationListener));
    AppMethodBeat.o(182436);
  }
  
  public void registerPlayListener(String paramString, boolean paramBoolean, ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14337);
    runOnSDKThread(new d.19(this, paramBoolean, paramString, paramITXLivePlayListener));
    AppMethodBeat.o(14337);
  }
  
  public void resumePusher()
  {
    AppMethodBeat.i(14320);
    runOnSDKThread(new d.9(this));
    AppMethodBeat.o(14320);
  }
  
  public void setConfig(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(14316);
    if ((paramBoolean1 != this.mConfig.K) || (paramBoolean2 != this.mConfig.L))
    {
      this.mConfig.K = paramBoolean1;
      this.mConfig.L = paramBoolean2;
      this.mCaptureAndEnc.a(this.mConfig);
    }
    AppMethodBeat.o(14316);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203642);
    this.mCaptureAndEnc.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(203642);
  }
  
  public void setLocalSurface(Surface paramSurface)
  {
    AppMethodBeat.i(14317);
    runOnSDKThread(new d.4(this, paramSurface));
    AppMethodBeat.o(14317);
  }
  
  public void setLocalSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14318);
    runOnSDKThread(new d.7(this, paramInt1, paramInt2));
    AppMethodBeat.o(14318);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(203645);
    this.mPushListener = new WeakReference(paramITXLivePushListener);
    AppMethodBeat.o(203645);
  }
  
  public void setRemoteSubStreamSurface(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(14324);
    runOnSDKThread(new d.12(this, paramString, paramSurface));
    AppMethodBeat.o(14324);
  }
  
  public void setRemoteSubStreamSurfaceSize(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14325);
    runOnSDKThread(new d.15(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(14325);
  }
  
  public void setRemoteSurface(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(14322);
    runOnSDKThread(new d.13(this, paramString, paramSurface));
    AppMethodBeat.o(14322);
  }
  
  public void setRemoteSurfaceSize(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14323);
    runOnSDKThread(new d.14(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(14323);
  }
  
  public void startLocalAudio()
  {
    AppMethodBeat.i(14315);
    this.mEnableEosMode = true;
    super.startLocalAudio();
    AppMethodBeat.o(14315);
  }
  
  public void unregisterAudioVolumeEvaluationListener(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182437);
    runOnSDKThread(new d.17(this, paramString, paramBoolean));
    AppMethodBeat.o(182437);
  }
  
  public void unregisterPlayListener(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(14338);
    runOnSDKThread(new d.20(this, paramBoolean, paramString));
    AppMethodBeat.o(14338);
  }
  
  public static abstract interface ITXAudioVolumeEvaluationListener
  {
    public abstract void onAudioVolumeEvaluationNotify(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud
 * JD-Core Version:    0.7.0.1
 */