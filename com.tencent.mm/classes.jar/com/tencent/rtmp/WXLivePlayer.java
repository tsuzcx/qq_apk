package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.WXTRTCCloud;
import com.tencent.trtc.WXTRTCCloud.ITXAudioVolumeEvaluationListener;
import java.lang.ref.WeakReference;

public class WXLivePlayer
  extends TXLivePlayer
  implements ITXLivePlayListener, WXTRTCCloud.ITXAudioVolumeEvaluationListener
{
  private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
  private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
  private static final String RTMP_PROXY_ADDRESS = "room://";
  private static final String TAG = "WXLivePlayer";
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private int mAudioVolumeNotifyInterval;
  private boolean mIsRtmpProxy;
  private boolean mIsTRTC;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private WXLivePlayConfig mPlayConfig;
  private WeakReference<ITXLivePlayListener> mPlayListener;
  private int mRenderMode;
  private int mRenderRotation;
  private String mStreamType;
  private Surface mSurface;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private WXTRTCCloud mTRTCCloud;
  private boolean mTRTCPlaying;
  private String mUserId;
  private TXCloudVideoView mVideoView;
  
  public WXLivePlayer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(14101);
    this.mIsTRTC = false;
    this.mTRTCPlaying = false;
    this.mIsRtmpProxy = false;
    this.mTRTCCloud = null;
    this.mAudioVolumeListener = null;
    this.mPlayConfig = new WXLivePlayConfig();
    this.mPlayListener = null;
    this.mVideoView = null;
    this.mSurface = null;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    this.mUserId = "";
    this.mStreamType = "";
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.mRenderMode = 1;
    this.mRenderRotation = 0;
    this.mAudioVolumeNotifyInterval = 0;
    this.mTRTCCloud = WXTRTCCloud.sharedInstance(paramContext);
    AppMethodBeat.o(14101);
  }
  
  private boolean isRtmpProxyUrl(String paramString)
  {
    AppMethodBeat.i(219275);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219275);
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com")))
    {
      AppMethodBeat.o(219275);
      return false;
    }
    boolean bool = paramString.startsWith("room://");
    AppMethodBeat.o(219275);
    return bool;
  }
  
  private boolean isTRTCPlayerUrl(String paramString)
  {
    AppMethodBeat.i(14122);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14122);
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com")))
    {
      AppMethodBeat.o(14122);
      return true;
    }
    AppMethodBeat.o(14122);
    return false;
  }
  
  private boolean parseTRTCParams(String paramString)
  {
    AppMethodBeat.i(14123);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14123);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("[?&]");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (localCharSequence.indexOf("=") == -1) {
            break label187;
          }
          Object localObject = localCharSequence.split("[=]");
          if (localObject.length != 2) {
            break label187;
          }
          localCharSequence = localObject[0];
          localObject = localObject[1];
          if ((TextUtils.isEmpty(localCharSequence)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label187;
          }
          if (localCharSequence.equalsIgnoreCase("userid")) {
            this.mUserId = ((String)localObject);
          } else if (localCharSequence.equalsIgnoreCase("streamtype")) {
            this.mStreamType = ((String)localObject);
          }
        }
      }
      catch (Exception paramString)
      {
        TXCLog.e("WXLivePlayer", "parse trtc params failed.", paramString);
        if (TextUtils.isEmpty(this.mStreamType)) {
          this.mStreamType = "main";
        }
        if (TextUtils.isEmpty(this.mUserId))
        {
          AppMethodBeat.o(14123);
          return false;
        }
        AppMethodBeat.o(14123);
        return true;
      }
      label187:
      i += 1;
    }
  }
  
  private void resetParams()
  {
    this.mIsTRTC = false;
    this.mTRTCPlaying = false;
    this.mUserId = "";
    this.mStreamType = "";
  }
  
  public void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219281);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = "[API] WXLivePlayer(" + hashCode() + ") ";
    if (paramBoolean)
    {
      Monitor.a(1, paramString + " " + str, "", 0, "");
      AppMethodBeat.o(219281);
      return;
    }
    TXCLog.i("WXLivePlayer", paramString + " " + str);
    AppMethodBeat.o(219281);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(14115);
    this.mAudioVolumeNotifyInterval = paramInt;
    super.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(14115);
  }
  
  protected void finalize()
  {
    this.mTRTCCloud = null;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(14106);
    if (this.mIsTRTC)
    {
      bool = this.mTRTCPlaying;
      AppMethodBeat.o(14106);
      return bool;
    }
    boolean bool = super.isPlaying();
    AppMethodBeat.o(14106);
    return bool;
  }
  
  public void muteAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(14109);
    String str = "muteAudio mute: " + paramBoolean + ", userId: " + this.mUserId;
    if ((this.mIsTRTC) || (this.mIsRtmpProxy)) {}
    for (boolean bool = true;; bool = false)
    {
      apiOnlineLog(str, bool);
      super.setMute(paramBoolean);
      this.mMuteAudio = paramBoolean;
      if ((this.mIsTRTC) && (this.mTRTCPlaying)) {
        this.mTRTCCloud.muteRemoteAudio(this.mUserId, paramBoolean);
      }
      AppMethodBeat.o(14109);
      return;
    }
  }
  
  public void muteVideo(boolean paramBoolean)
  {
    AppMethodBeat.i(14110);
    String str = "muteVideo mute: " + paramBoolean + ", userId: " + this.mUserId;
    if ((this.mIsTRTC) || (this.mIsRtmpProxy)) {}
    for (boolean bool = true;; bool = false)
    {
      apiOnlineLog(str, bool);
      this.mMuteVideo = paramBoolean;
      if ((this.mIsTRTC) && (this.mTRTCPlaying)) {
        this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, paramBoolean);
      }
      AppMethodBeat.o(14110);
      return;
    }
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(14117);
    if (this.mAudioVolumeListener != null) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(14117);
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(14121);
    if (this.mPlayListener != null)
    {
      ITXLivePlayListener localITXLivePlayListener = (ITXLivePlayListener)this.mPlayListener.get();
      if (localITXLivePlayListener != null) {
        localITXLivePlayListener.onNetStatus(paramBundle);
      }
    }
    AppMethodBeat.o(14121);
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14120);
    Object localObject = "onPlayEvent event: ".concat(String.valueOf(paramInt));
    if ((this.mIsTRTC) || (this.mIsRtmpProxy)) {}
    for (boolean bool = true;; bool = false)
    {
      apiOnlineLog((String)localObject, bool);
      if (this.mPlayListener != null)
      {
        localObject = (ITXLivePlayListener)this.mPlayListener.get();
        if (localObject != null) {
          ((ITXLivePlayListener)localObject).onPlayEvent(paramInt, paramBundle);
        }
      }
      AppMethodBeat.o(14120);
      return;
    }
  }
  
  public void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(14113);
    String str = "setAudioRoute audioRoute: ".concat(String.valueOf(paramInt));
    if ((this.mIsTRTC) || (this.mIsRtmpProxy)) {}
    for (boolean bool = true;; bool = false)
    {
      apiOnlineLog(str, bool);
      TXCAudioEngine.setAudioRoute(paramInt);
      AppMethodBeat.o(14113);
      return;
    }
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(14116);
    super.setAudioVolumeEvaluationListener(paramITXAudioVolumeEvaluationListener);
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
    AppMethodBeat.o(14116);
  }
  
  public void setConfig(WXLivePlayConfig paramWXLivePlayConfig)
  {
    AppMethodBeat.i(14108);
    String str;
    if ("setConfig config: ".concat(String.valueOf(paramWXLivePlayConfig)) != null)
    {
      str = paramWXLivePlayConfig.toString();
      if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      apiOnlineLog(str, bool);
      super.setConfig(paramWXLivePlayConfig);
      this.mPlayConfig = paramWXLivePlayConfig;
      AppMethodBeat.o(14108);
      return;
      str = "";
      break;
    }
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14103);
    super.setPlayListener(paramITXLivePlayListener);
    this.mPlayListener = new WeakReference(paramITXLivePlayListener);
    AppMethodBeat.o(14103);
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14102);
    super.setPlayerView(paramTXCloudVideoView);
    this.mVideoView = paramTXCloudVideoView;
    AppMethodBeat.o(14102);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(14111);
    apiOnlineLog("setRenderMode mode: " + paramInt + ", userId: " + this.mUserId, false);
    super.setRenderMode(paramInt);
    if (paramInt == 0) {
      this.mRenderMode = 0;
    }
    while ((this.mIsTRTC) && (this.mTRTCPlaying)) {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
        AppMethodBeat.o(14111);
        return;
        if (paramInt == 1) {
          this.mRenderMode = 1;
        }
      }
      else
      {
        this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
      }
    }
    AppMethodBeat.o(14111);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(14112);
    apiOnlineLog("setRenderRotation rotation: " + paramInt + ", userId: " + this.mUserId, false);
    super.setRenderRotation(paramInt);
    if (paramInt == 270) {
      this.mRenderRotation = 3;
    }
    while ((this.mIsTRTC) && (this.mTRTCPlaying)) {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
        AppMethodBeat.o(14112);
        return;
        if (paramInt == 0) {
          this.mRenderRotation = 0;
        }
      }
      else
      {
        this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
      }
    }
    AppMethodBeat.o(14112);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(14104);
    super.setSurface(paramSurface);
    this.mSurface = paramSurface;
    apiOnlineLog("setSurface userId: " + this.mUserId + ", surface: " + paramSurface, false);
    if ((this.mIsTRTC) && (this.mTRTCPlaying) && (!TextUtils.isEmpty(this.mUserId)) && (!TextUtils.isEmpty(this.mStreamType)))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
        AppMethodBeat.o(14104);
        return;
      }
      this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
    }
    AppMethodBeat.o(14104);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14105);
    super.setSurfaceSize(paramInt1, paramInt2);
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    apiOnlineLog("setSurfaceSize width: " + paramInt1 + ", height: " + paramInt2 + ", userId: " + this.mUserId, false);
    if ((this.mIsTRTC) && (this.mTRTCPlaying) && (!TextUtils.isEmpty(this.mUserId)) && (!TextUtils.isEmpty(this.mStreamType)))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, paramInt1, paramInt2);
        AppMethodBeat.o(14105);
        return;
      }
      this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(14105);
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    AppMethodBeat.i(14107);
    if (this.mVideoView != null) {
      this.mVideoView.showLog(paramBoolean);
    }
    WXTRTCCloud localWXTRTCCloud = this.mTRTCCloud;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      localWXTRTCCloud.showDebugView(i);
      AppMethodBeat.o(14107);
      return;
    }
  }
  
  public void snapshot(final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14114);
    if (this.mIsTRTC)
    {
      if (this.mTRTCPlaying)
      {
        if (this.mStreamType.equalsIgnoreCase("aux"))
        {
          this.mTRTCCloud.snapshotVideo(this.mUserId, 2, new TRTCCloudListener.TRTCSnapshotListener()
          {
            public void onSnapshotComplete(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(182234);
              if (paramITXSnapshotListener != null) {
                paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              }
              AppMethodBeat.o(182234);
            }
          });
          AppMethodBeat.o(14114);
          return;
        }
        this.mTRTCCloud.snapshotVideo(this.mUserId, 0, new TRTCCloudListener.TRTCSnapshotListener()
        {
          public void onSnapshotComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(182240);
            if (paramITXSnapshotListener != null) {
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
            }
            AppMethodBeat.o(182240);
          }
        });
        AppMethodBeat.o(14114);
      }
    }
    else {
      super.snapshot(paramITXSnapshotListener);
    }
    AppMethodBeat.o(14114);
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(14118);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14118);
      return -1;
    }
    this.mIsRtmpProxy = isRtmpProxyUrl(paramString);
    this.mIsTRTC = isTRTCPlayerUrl(paramString);
    String str = "startPlay url:" + paramString + " type:" + paramInt + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId;
    boolean bool;
    if ((this.mIsTRTC) || (this.mIsRtmpProxy))
    {
      bool = true;
      apiOnlineLog(str, bool);
      if (!this.mIsTRTC) {
        break label518;
      }
      if (!parseTRTCParams(paramString)) {
        break label502;
      }
      this.mTRTCCloud.muteRemoteAudio(this.mUserId, this.mMuteAudio);
      this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, this.mMuteVideo);
      if (!this.mStreamType.equalsIgnoreCase("main")) {
        break label319;
      }
      this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 0);
      this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
      this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
      this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
      bool = false;
    }
    for (;;)
    {
      label237:
      if (bool)
      {
        this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
        if (!bool) {
          break label484;
        }
        this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
      }
      for (;;)
      {
        label256:
        this.mTRTCCloud.registerAudioVolumeEvaluationListener(this.mUserId, bool, this);
        this.mTRTCCloud.registerPlayListener(this.mUserId, bool, this);
        this.mTRTCPlaying = true;
        AppMethodBeat.o(14118);
        return 0;
        bool = false;
        break;
        label319:
        if (this.mStreamType.equalsIgnoreCase("small"))
        {
          this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 1);
          this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
          this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
          this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
          bool = false;
          break label237;
        }
        if (!this.mStreamType.equalsIgnoreCase("aux")) {
          break label541;
        }
        this.mTRTCCloud.startRemoteSubStreamView(this.mUserId, this.mVideoView);
        this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
        this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
        bool = true;
        break label237;
        this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
        break label256;
        label484:
        this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
      }
      label502:
      TXCLog.e("WXLivePlayer", "parse playUrl failed!!!");
      AppMethodBeat.o(14118);
      return -1;
      label518:
      super.enableAudioVolumeEvaluation(this.mAudioVolumeNotifyInterval);
      paramInt = super.startPlay(paramString, paramInt);
      AppMethodBeat.o(14118);
      return paramInt;
      label541:
      bool = false;
    }
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(14119);
    String str = "stopPlay isNeedClearLastImg: " + paramBoolean + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId;
    boolean bool1;
    if ((this.mIsTRTC) || (this.mIsRtmpProxy))
    {
      bool1 = true;
      apiOnlineLog(str, bool1);
      if ((paramBoolean) && (this.mVideoView != null)) {
        this.mVideoView.setVisibility(8);
      }
      if (!this.mIsTRTC) {
        break label228;
      }
      if (!this.mStreamType.equalsIgnoreCase("main")) {
        break label169;
      }
      this.mTRTCCloud.stopRemoteView(this.mUserId);
      paramBoolean = false;
    }
    for (;;)
    {
      this.mTRTCCloud.unregisterAudioVolumeEvaluationListener(this.mUserId, paramBoolean);
      this.mTRTCCloud.unregisterPlayListener(this.mUserId, paramBoolean);
      resetParams();
      AppMethodBeat.o(14119);
      return 0;
      bool1 = false;
      break;
      label169:
      if (this.mStreamType.equalsIgnoreCase("small"))
      {
        this.mTRTCCloud.stopRemoteView(this.mUserId);
        paramBoolean = false;
      }
      else if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.stopRemoteSubStreamView(this.mUserId);
        paramBoolean = bool2;
        continue;
        label228:
        resetParams();
        int i = super.stopPlay(paramBoolean);
        AppMethodBeat.o(14119);
        return i;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePlayer
 * JD-Core Version:    0.7.0.1
 */