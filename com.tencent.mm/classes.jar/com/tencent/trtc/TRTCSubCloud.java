package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.g.a;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCEncodeTypeDecision;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class TRTCSubCloud
  extends TRTCCloudImpl
{
  private static final String TAG;
  protected WeakReference<TRTCCloudImpl> mMainCloud = null;
  private a mVolumeLevelCalTask = null;
  
  static
  {
    AppMethodBeat.i(216426);
    TAG = TRTCSubCloud.class.getName();
    AppMethodBeat.o(216426);
  }
  
  public TRTCSubCloud(Context paramContext, WeakReference<TRTCCloudImpl> paramWeakReference, f paramf)
  {
    super(paramContext, paramf);
    this.mRoomInfo.muteLocalAudio = true;
    this.mRoomInfo.muteLocalVideo = true;
    this.mMainCloud = paramWeakReference;
  }
  
  public void ConnectOtherRoom(String paramString)
  {
    AppMethodBeat.i(216281);
    super.ConnectOtherRoom(paramString);
    AppMethodBeat.o(216281);
  }
  
  public void DisconnectOtherRoom()
  {
    AppMethodBeat.i(216282);
    super.DisconnectOtherRoom();
    AppMethodBeat.o(216282);
  }
  
  public void callExperimentalAPI(final String paramString)
  {
    AppMethodBeat.i(216335);
    Object localObject2;
    Object localObject1;
    if (paramString != null)
    {
      localObject2 = new StringBuilder("callExperimentalAPI  ").append(paramString).append(", roomid = ");
      if (this.mRoomInfo.roomId == -1L) {
        break label129;
      }
      localObject1 = Long.valueOf(this.mRoomInfo.roomId);
    }
    for (;;)
    {
      apiOnlineLog(localObject1);
      localObject2 = "";
      final Object localObject4 = null;
      localObject1 = localObject2;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = localObject2;
        if (!localJSONObject.has("api"))
        {
          localObject1 = localObject2;
          apiLog("callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(216335);
          return;
          label129:
          localObject1 = this.mRoomInfo.strRoomId;
        }
        else
        {
          localObject1 = localObject2;
          localObject2 = localJSONObject.getString("api");
          localObject1 = localObject2;
          boolean bool = localJSONObject.has("params");
          if (!bool)
          {
            AppMethodBeat.o(216335);
            return;
          }
          localObject1 = localObject2;
          localJSONObject = localJSONObject.getJSONObject("params");
          localObject1 = localJSONObject;
          localObject4 = localObject2;
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        final Object localObject3;
        for (;;)
        {
          apiLog("callExperimentalAPI[failed]: ".concat(String.valueOf(paramString)));
          localObject3 = localObject4;
          localObject4 = localObject1;
        }
        runOnSDKThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216612);
            try
            {
              if (localObject4.equals("setSEIPayloadType"))
              {
                TRTCSubCloud.access$7100(TRTCSubCloud.this, localObject3);
                AppMethodBeat.o(216612);
                return;
              }
              if ((localObject4.equals("setLocalAudioMuteMode")) || (localObject4.equals("setVideoEncodeParamEx")) || (localObject4.equals("setAudioSampleRate"))) {
                break label350;
              }
              if (localObject4.equals("muteRemoteAudioInSpeaker"))
              {
                TRTCSubCloud.access$7200(TRTCSubCloud.this, localObject3);
                AppMethodBeat.o(216612);
                return;
              }
            }
            catch (Exception localException)
            {
              TRTCSubCloud.access$7800(TRTCSubCloud.this, "callExperimentalAPI[failed]: " + paramString);
              AppMethodBeat.o(216612);
              return;
            }
            if ((!localObject4.equals("enableAudioAGC")) && (!localObject4.equals("enableAudioAEC")) && (!localObject4.equals("enableAudioANS")))
            {
              if (localObject4.equals("setPerformanceMode"))
              {
                TRTCSubCloud.access$7300(TRTCSubCloud.this, localObject3);
                AppMethodBeat.o(216612);
                return;
              }
              if ((!localObject4.equals("setCustomRenderMode")) && (!localObject4.equals("setMediaCodecConfig")) && (!localObject4.equals("setKeepAVCaptureOption")))
              {
                if (localObject4.equals("sendJsonCMD"))
                {
                  TRTCSubCloud.access$7400(TRTCSubCloud.this, localObject3, paramString);
                  AppMethodBeat.o(216612);
                  return;
                }
                if (localObject4.equals("updatePrivateMapKey"))
                {
                  TRTCSubCloud.access$7500(TRTCSubCloud.this, localObject3);
                  AppMethodBeat.o(216612);
                  return;
                }
                if (localObject4.equals("setRoomType"))
                {
                  TRTCSubCloud.access$7600(TRTCSubCloud.this, localObject3);
                  AppMethodBeat.o(216612);
                  return;
                }
                TRTCSubCloud.access$7700(TRTCSubCloud.this, "callExperimentalAPI[illegal api]: " + localObject4);
              }
            }
            label350:
            AppMethodBeat.o(216612);
          }
        });
        AppMethodBeat.o(216335);
      }
    }
    if (localObject4.equals("setEncodedDataProcessingListener"))
    {
      setEncodedDataProcessingListener((JSONObject)localObject2);
      AppMethodBeat.o(216335);
      return;
    }
  }
  
  protected void collectCustomCaptureFps() {}
  
  public TRTCCloud createSubCloud()
  {
    return null;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(216263);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216604);
        synchronized (TRTCSubCloud.this.mNativeLock)
        {
          if (TRTCSubCloud.this.mNativeRtcContext != 0L)
          {
            TRTCSubCloud.access$200(TRTCSubCloud.this, "destroy context");
            TRTCSubCloud.access$400(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext);
          }
          TRTCSubCloud.access$502(TRTCSubCloud.this, 0L);
          TRTCSubCloud.access$602(TRTCSubCloud.this, null);
          TRTCSubCloud.access$702(TRTCSubCloud.this, null);
          TRTCSubCloud.this.mCurrentPublishClouds.clear();
          TRTCSubCloud.this.mSubClouds.clear();
          a.a().a(TRTCSubCloud.this.hashCode());
          AppMethodBeat.o(216604);
          return;
        }
      }
    });
    AppMethodBeat.o(216263);
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean) {}
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(216322);
    super.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(216322);
  }
  
  public void enableCustomAudioCapture(boolean paramBoolean) {}
  
  public void enableCustomVideoCapture(boolean paramBoolean) {}
  
  public int enableEncSmallVideoStream(boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    return -1;
  }
  
  public boolean enableTorch(boolean paramBoolean)
  {
    return false;
  }
  
  public void enterRoom(final TRTCCloudDef.TRTCParams paramTRTCParams, final int paramInt)
  {
    AppMethodBeat.i(216276);
    if (paramTRTCParams == null)
    {
      apiLog("enter room, param nil!");
      onEnterRoom(-3316, "enter room param null");
      AppMethodBeat.o(216276);
      return;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams(paramTRTCParams);
    if ((localTRTCParams.sdkAppId == 0) || (TextUtils.isEmpty(localTRTCParams.userId)) || (TextUtils.isEmpty(localTRTCParams.userSig)))
    {
      apiLog("enterRoom param invalid:".concat(String.valueOf(localTRTCParams)));
      if (localTRTCParams.sdkAppId == 0) {
        onEnterRoom(-3317, "enter room sdkAppId invalid.");
      }
      if (TextUtils.isEmpty(localTRTCParams.userSig)) {
        onEnterRoom(-3320, "enter room userSig invalid.");
      }
      if (TextUtils.isEmpty(localTRTCParams.userId)) {
        onEnterRoom(-3319, "enter room userId invalid.");
      }
      AppMethodBeat.o(216276);
      return;
    }
    final long l = localTRTCParams.roomId & 0xFFFFFFFF;
    paramTRTCParams = "";
    Object localObject1 = localTRTCParams.businessInfo;
    Object localObject2;
    if ((l == 0L) || ((localTRTCParams.roomId == -1) && (!TextUtils.isEmpty(localTRTCParams.businessInfo))))
    {
      if (l == 0L) {
        paramTRTCParams = localTRTCParams.strRoomId;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append(((JSONObject)localObject2).optString("strGroupId").toString());
          ((JSONObject)localObject2).remove("strGroupId");
          ((JSONObject)localObject2).remove("Role");
          if (localTRTCParams.roomId != -1) {
            break label413;
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          paramTRTCParams = "";
          if (((JSONObject)localObject2).length() != 0) {
            paramTRTCParams = ((JSONObject)localObject2).toString();
          }
        }
        catch (Exception paramTRTCParams)
        {
          for (;;)
          {
            label316:
            apiLog("enter room, room id error, busInfo " + localTRTCParams.businessInfo);
            localObject1 = "";
            paramTRTCParams = "";
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          onEnterRoom(-3318, "room id invalid.");
          AppMethodBeat.o(216276);
          return;
        }
      }
    }
    for (;;)
    {
      runOnSDKThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215892);
          if (TRTCSubCloud.this.mRoomState != 0)
          {
            if (((!TextUtils.isEmpty(this.a)) && (this.a.equalsIgnoreCase(TRTCSubCloud.this.mRoomInfo.strRoomId))) || (TRTCSubCloud.this.mRoomInfo.roomId == l))
            {
              TRTCSubCloud.access$1300(TRTCSubCloud.this, String.format("enter the same room[%d] again, ignore!!!", new Object[] { Long.valueOf(l) }));
              AppMethodBeat.o(215892);
              return;
            }
            TRTCSubCloud.access$1500(TRTCSubCloud.this, String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l), Long.valueOf(TRTCSubCloud.this.mRoomInfo.roomId) }));
            TRTCSubCloud.access$1602(TRTCSubCloud.this, true);
            TRTCSubCloud.this.exitRoom();
          }
          TRTCSubCloud.access$1700(TRTCSubCloud.this, "========================================================================================================");
          TRTCSubCloud.access$1800(TRTCSubCloud.this, "========================================================================================================");
          TRTCSubCloud.access$1900(TRTCSubCloud.this, String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), h.c(), h.d() }));
          TRTCSubCloud.access$2000(TRTCSubCloud.this, "========================================================================================================");
          TRTCSubCloud.access$2100(TRTCSubCloud.this, "========================================================================================================");
          Object localObject2 = new StringBuilder("enterRoom(sub) roomId:");
          Object localObject1;
          int i;
          label350:
          Object localObject3;
          Object localObject4;
          label389:
          int j;
          label491:
          int k;
          label503:
          int m;
          if (paramInt.roomId == -1)
          {
            localObject1 = this.a;
            localObject2 = localObject1;
            i = paramTRTCParams;
            localObject1 = "VideoCall";
            switch (paramTRTCParams)
            {
            default: 
              TXCLog.w(TRTCSubCloud.TAG, "enter room scene:%u error! default to VideoCall! " + paramTRTCParams + " self:" + TRTCSubCloud.this.hashCode());
              i = 0;
              localObject3 = TRTCSubCloud.this;
              localObject4 = new StringBuilder().append((String)localObject2);
              str = this.e;
              if (this.f == 20)
              {
                localObject2 = "Anchor";
                TRTCSubCloud.access$2300((TRTCSubCloud)localObject3, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { str, localObject1, localObject2, paramInt.streamId }));
                TXCEventRecorderProxy.a("18446744073709551615", 5001, l, -1L, "", 0);
                TRTCSubCloud.access$2402(TRTCSubCloud.this, 1);
                if (TRTCSubCloud.this.mNativeRtcContext == 0L)
                {
                  localObject1 = TXCCommonUtil.getSDKVersion();
                  if (localObject1.length <= 0) {
                    break label1015;
                  }
                  j = localObject1[0];
                  if (localObject1.length < 2) {
                    break label1020;
                  }
                  k = localObject1[1];
                  if (localObject1.length < 3) {
                    break label1025;
                  }
                  m = localObject1[2];
                  label516:
                  TRTCSubCloud.access$2602(TRTCSubCloud.this, TRTCSubCloud.access$2700(TRTCSubCloud.this, j, k, m));
                }
                TRTCSubCloud.access$2800(TRTCSubCloud.this, i);
                TRTCSubCloud.access$3100(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, TRTCSubCloud.this.mPriorStreamType);
                localObject1 = TRTCSubCloud.this.mRoomInfo.getToken(TRTCSubCloud.this.mContext);
                TRTCSubCloud.access$3500(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, paramInt.sdkAppId, paramInt.userId, paramInt.userSig, (byte[])localObject1);
                localObject1 = (TRTCCloudImpl)TRTCSubCloud.this.mMainCloud.get();
                if (localObject1 != null)
                {
                  ((TRTCCloudImpl)localObject1).makeStreamsEffectiveAfterNetworkInited();
                  ((TRTCCloudImpl)localObject1).flushBigVideoEncParamsIntoNetwork();
                  ((TRTCCloudImpl)localObject1).flushSmallVideoEncParamsIntoNetwork();
                }
                if (paramInt.privateMapKey == null) {
                  break label1031;
                }
                localObject1 = paramInt.privateMapKey;
                label675:
                if (this.a == null) {
                  break label1038;
                }
                localObject2 = this.a;
                label688:
                if (this.e == null) {
                  break label1045;
                }
                localObject3 = this.e;
                label701:
                if (paramInt.userDefineRecordId == null) {
                  break label1052;
                }
                localObject4 = paramInt.userDefineRecordId;
                label720:
                if (paramInt.streamId == null) {
                  break label1059;
                }
              }
              break;
            }
          }
          label1025:
          label1031:
          label1038:
          label1045:
          label1052:
          label1059:
          for (String str = paramInt.streamId;; str = "")
          {
            i = TRTCEncodeTypeDecision.getEnterRoomCodecSupportValue();
            TRTCSubCloud.access$4000(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, l, (String)localObject3, (String)localObject1, (String)localObject2, this.f, 255, 0, paramTRTCParams, TRTCSubCloud.this.mPerformanceMode, h.c(), h.d(), TRTCSubCloud.this.mRecvMode, (String)localObject4, str, TRTCSubCloud.this.mRoomType, i, g.a.a.a());
            TRTCSubCloud.access$4102(TRTCSubCloud.this, this.f);
            TRTCSubCloud.access$4202(TRTCSubCloud.this, this.f);
            TRTCSubCloud.access$4300(TRTCSubCloud.this);
            TRTCSubCloud.access$4402(TRTCSubCloud.this, 0L);
            TRTCSubCloud.this.mRoomInfo.init(l, paramInt.userId);
            TRTCSubCloud.this.mRoomInfo.strRoomId = ((String)localObject2);
            TRTCSubCloud.this.mRoomInfo.sdkAppId = paramInt.sdkAppId;
            TRTCSubCloud.this.mRoomInfo.userSig = paramInt.userSig;
            TRTCSubCloud.this.mRoomInfo.privateMapKey = ((String)localObject1);
            TRTCSubCloud.this.mRoomInfo.enterTime = this.g;
            AppMethodBeat.o(215892);
            return;
            localObject1 = Integer.valueOf(paramInt.roomId);
            break;
            localObject1 = "VideoCall";
            break label350;
            localObject1 = "Live";
            break label350;
            localObject1 = "AudioCall";
            i = 0;
            break label350;
            localObject1 = "VoiceChatRoom";
            i = 1;
            break label350;
            localObject2 = "Audience";
            break label389;
            label1015:
            j = 0;
            break label491;
            label1020:
            k = 0;
            break label503;
            m = 0;
            break label516;
            localObject1 = "";
            break label675;
            localObject2 = "";
            break label688;
            localObject3 = "";
            break label701;
            localObject4 = "";
            break label720;
          }
        }
      });
      AppMethodBeat.o(216276);
      return;
      label413:
      localObject1 = paramTRTCParams;
      break;
      localObject2 = paramTRTCParams;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
      localObject1 = localObject2;
      break label316;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
      localObject1 = "";
    }
  }
  
  public void exitRoom()
  {
    AppMethodBeat.i(216278);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216444);
        String str = "exitRoom " + TRTCSubCloud.this.mRoomInfo.getRoomId();
        TRTCSubCloud.access$5200(TRTCSubCloud.this, str);
        TRTCSubCloud.this.exitRoomInternal(true, "call from api");
        AppMethodBeat.o(216444);
      }
    });
    AppMethodBeat.o(216278);
  }
  
  public void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(216279);
    apiLog("exitRoomInternal reqExit: " + paramBoolean + ", reason: " + paramString + ", mRoomState: " + this.mRoomState);
    if (this.mRoomState == 0)
    {
      clearRemoteMuteStates();
      apiLog("exitRoom ignore when no in room");
      AppMethodBeat.o(216279);
      return;
    }
    this.mRoomState = 0;
    this.mRoomType = 0;
    stopCollectStatus();
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public final void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(216559);
        TRTCSubCloud.access$5300(TRTCSubCloud.this, paramAnonymousUserInfo);
        a.a().a(String.valueOf(paramAnonymousUserInfo.tinyID), TRTCSubCloud.this.hashCode());
        if (paramAnonymousUserInfo.mainRender.render != null) {
          paramAnonymousUserInfo.mainRender.render.setVideoFrameListener(null, b.a);
        }
        if (paramAnonymousUserInfo.subRender.render != null) {
          paramAnonymousUserInfo.subRender.render.setVideoFrameListener(null, b.a);
        }
        AppMethodBeat.o(216559);
      }
    });
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    AppMethodBeat.o(216279);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(216267);
    this.mSDKHandler = null;
    super.finalize();
    AppMethodBeat.o(216267);
  }
  
  public int getAudioCaptureVolume()
  {
    return 0;
  }
  
  public int getAudioPlayoutVolume()
  {
    return 0;
  }
  
  public int getBGMDuration(String paramString)
  {
    return 0;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return null;
  }
  
  public boolean isCameraAutoFocusFaceModeSupported()
  {
    return false;
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    return false;
  }
  
  public boolean isCameraTorchSupported()
  {
    return false;
  }
  
  public boolean isCameraZoomSupported()
  {
    return false;
  }
  
  public void muteAllRemoteAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(216315);
    super.muteAllRemoteAudio(paramBoolean);
    AppMethodBeat.o(216315);
  }
  
  public void muteAllRemoteVideoStreams(boolean paramBoolean)
  {
    AppMethodBeat.i(216305);
    super.muteAllRemoteVideoStreams(paramBoolean);
    AppMethodBeat.o(216305);
  }
  
  public void muteLocalAudio(final boolean paramBoolean)
  {
    AppMethodBeat.i(216312);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216151);
        TRTCSubCloud.access$6200(TRTCSubCloud.this, "muteLocalAudio " + paramBoolean + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
        TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)TRTCSubCloud.this.mMainCloud.get();
        if (localTRTCCloudImpl != null) {
          localTRTCCloudImpl.muteLocalAudio(paramBoolean, TRTCSubCloud.this);
        }
        AppMethodBeat.o(216151);
      }
    });
    AppMethodBeat.o(216312);
  }
  
  public void muteLocalVideo(final boolean paramBoolean)
  {
    AppMethodBeat.i(216303);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216658);
        TRTCSubCloud.access$6000(TRTCSubCloud.this, "muteLocalVideo mute:" + paramBoolean + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
        TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)TRTCSubCloud.this.mMainCloud.get();
        if (localTRTCCloudImpl != null) {
          localTRTCCloudImpl.muteLocalVideo(paramBoolean, TRTCSubCloud.this);
        }
        AppMethodBeat.o(216658);
      }
    });
    AppMethodBeat.o(216303);
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(216313);
    super.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(216313);
  }
  
  public void muteRemoteVideoStream(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(216304);
    super.muteRemoteVideoStream(paramString, paramBoolean);
    AppMethodBeat.o(216304);
  }
  
  public void onAudioQosChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216362);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onAudioQosChanged(this, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(216362);
  }
  
  public void onIdrFpsChanged(int paramInt)
  {
    AppMethodBeat.i(216365);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onIdrFpsChanged(this, paramInt);
    }
    AppMethodBeat.o(216365);
  }
  
  public void onVideoConfigChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216366);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoConfigChanged(this, paramInt, paramBoolean);
    }
    AppMethodBeat.o(216366);
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(216364);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    AppMethodBeat.o(216364);
  }
  
  public void pauseAudioEffect(int paramInt) {}
  
  public void pauseBGM() {}
  
  public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam) {}
  
  public void playBGM(String paramString, TRTCCloud.BGMNotify paramBGMNotify) {}
  
  public void resumeAudioEffect(int paramInt) {}
  
  public void resumeBGM() {}
  
  public void selectMotionTmpl(String paramString) {}
  
  public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public boolean sendCustomCmdMsg(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216356);
    paramBoolean1 = super.sendCustomCmdMsg(paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(216356);
    return paramBoolean1;
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame) {}
  
  public boolean sendSEIMsg(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(216358);
    boolean bool = super.sendSEIMsg(paramArrayOfByte, paramInt);
    AppMethodBeat.o(216358);
    return bool;
  }
  
  public void setAllAudioEffectsVolume(int paramInt) {}
  
  public void setAudioCaptureVolume(int paramInt) {}
  
  public void setAudioEffectVolume(int paramInt1, int paramInt2) {}
  
  public void setAudioFrameListener(final TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener)
  {
    AppMethodBeat.i(216360);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216641);
        TRTCSubCloud.access$7900(TRTCSubCloud.this, "SubCloud setAudioFrameListener " + paramTRTCAudioFrameListener);
        TRTCSubCloud.access$8002(TRTCSubCloud.this, paramTRTCAudioFrameListener);
        if (TRTCSubCloud.this.mAudioFrameListener == null)
        {
          TRTCSubCloud.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
          {
            public final void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
            {
              AppMethodBeat.i(215875);
              TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), null);
              AppMethodBeat.o(215875);
            }
          });
          AppMethodBeat.o(216641);
          return;
        }
        TRTCSubCloud.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public final void accept(String paramAnonymous2String, TRTCRoomInfo.UserInfo paramAnonymous2UserInfo)
          {
            AppMethodBeat.i(216086);
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramAnonymous2UserInfo.tinyID), TRTCSubCloud.this);
            AppMethodBeat.o(216086);
          }
        });
        AppMethodBeat.o(216641);
      }
    });
    AppMethodBeat.o(216360);
  }
  
  public void setAudioPlayoutVolume(int paramInt) {}
  
  public void setAudioRoute(int paramInt) {}
  
  public void setBGMPlayoutVolume(int paramInt) {}
  
  public int setBGMPosition(int paramInt)
  {
    return 0;
  }
  
  public void setBGMPublishVolume(int paramInt) {}
  
  public void setBGMVolume(int paramInt) {}
  
  public void setBeautyStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setChinLevel(int paramInt) {}
  
  public void setDebugViewMargin(String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    AppMethodBeat.i(216349);
    super.setDebugViewMargin(paramString, paramTRTCViewMargin);
    AppMethodBeat.o(216349);
  }
  
  public void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216284);
    super.setDefaultStreamRecvMode(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(216284);
  }
  
  public void setEyeScaleLevel(int paramInt) {}
  
  public void setFaceShortLevel(int paramInt) {}
  
  public void setFaceSlimLevel(int paramInt) {}
  
  public void setFaceVLevel(int paramInt) {}
  
  public void setFilter(Bitmap paramBitmap) {}
  
  public void setFilterConcentration(float paramFloat) {}
  
  public void setFocusPosition(int paramInt1, int paramInt2) {}
  
  public void setGSensorMode(int paramInt) {}
  
  public boolean setGreenScreenFile(String paramString)
  {
    return false;
  }
  
  public void setListener(TRTCCloudListener paramTRTCCloudListener)
  {
    AppMethodBeat.i(216271);
    super.setListener(paramTRTCCloudListener);
    AppMethodBeat.o(216271);
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    AppMethodBeat.i(216274);
    super.setListenerHandler(paramHandler);
    AppMethodBeat.o(216274);
  }
  
  public int setLocalVideoRenderListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    return -1;
  }
  
  public void setLocalViewFillMode(int paramInt) {}
  
  public void setLocalViewMirror(int paramInt) {}
  
  public void setLocalViewRotation(int paramInt) {}
  
  public void setMicVolumeOnMixing(int paramInt) {}
  
  public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    AppMethodBeat.i(216355);
    super.setMixTranscodingConfig(paramTRTCTranscodingConfig);
    AppMethodBeat.o(216355);
  }
  
  public void setMotionMute(boolean paramBoolean) {}
  
  public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam) {}
  
  public void setNoseSlimLevel(int paramInt) {}
  
  public int setPriorRemoteVideoStreamType(int paramInt)
  {
    AppMethodBeat.i(216310);
    paramInt = super.setPriorRemoteVideoStreamType(paramInt);
    AppMethodBeat.o(216310);
    return paramInt;
  }
  
  public void setRemoteAudioVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(216316);
    super.setRemoteAudioVolume(paramString, paramInt);
    AppMethodBeat.o(216316);
  }
  
  public void setRemoteSubStreamViewFillMode(String paramString, int paramInt)
  {
    AppMethodBeat.i(216296);
    super.setRemoteSubStreamViewFillMode(paramString, paramInt);
    AppMethodBeat.o(216296);
  }
  
  public void setRemoteSubStreamViewRotation(String paramString, int paramInt)
  {
    AppMethodBeat.i(216298);
    super.setRemoteSubStreamViewRotation(paramString, paramInt);
    AppMethodBeat.o(216298);
  }
  
  public int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(216337);
    paramInt1 = super.setRemoteVideoRenderListener(paramString, paramInt1, paramInt2, paramTRTCVideoRenderListener);
    AppMethodBeat.o(216337);
    return paramInt1;
  }
  
  public int setRemoteVideoStreamType(String paramString, int paramInt)
  {
    AppMethodBeat.i(216311);
    paramInt = super.setRemoteVideoStreamType(paramString, paramInt);
    AppMethodBeat.o(216311);
    return paramInt;
  }
  
  public void setRemoteViewFillMode(String paramString, int paramInt)
  {
    AppMethodBeat.i(216307);
    super.setRemoteViewFillMode(paramString, paramInt);
    AppMethodBeat.o(216307);
  }
  
  public void setRemoteViewRotation(String paramString, int paramInt)
  {
    AppMethodBeat.i(216308);
    super.setRemoteViewRotation(paramString, paramInt);
    AppMethodBeat.o(216308);
  }
  
  public void setReverbType(int paramInt) {}
  
  public void setSystemVolumeType(int paramInt) {}
  
  public void setVideoEncoderMirror(boolean paramBoolean) {}
  
  public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam) {}
  
  public void setVideoEncoderRotation(int paramInt) {}
  
  public boolean setVoiceChangerType(int paramInt)
  {
    return false;
  }
  
  public void setWatermark(Bitmap paramBitmap, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void setZoom(int paramInt) {}
  
  public void showDebugView(int paramInt)
  {
    AppMethodBeat.i(216348);
    super.showDebugView(paramInt);
    AppMethodBeat.o(216348);
  }
  
  public void snapshotVideo(final String paramString, final int paramInt, final TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    AppMethodBeat.i(216301);
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215864);
        if (paramString != null)
        {
          TRTCRoomInfo.UserInfo localUserInfo = TRTCSubCloud.this.mRoomInfo.getUser(paramString);
          Object localObject2 = null;
          Object localObject1;
          if (paramInt == 2)
          {
            localObject1 = localObject2;
            if (localUserInfo != null)
            {
              localObject1 = localObject2;
              if (localUserInfo.mainRender != null)
              {
                localObject1 = localObject2;
                if (localUserInfo.mainRender.render != null)
                {
                  TRTCSubCloud.access$5500(TRTCSubCloud.this, "snapshotRemoteSubStreamView->userId: " + paramString);
                  localObject1 = localUserInfo.subRender.render.getVideoRender();
                }
              }
            }
          }
          while (localObject1 != null)
          {
            ((e)localObject1).a(new p()
            {
              public final void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(216147);
                TRTCSubCloud.access$5700(TRTCSubCloud.this, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(215938);
                    if (TRTCSubCloud.5.this.ZQW != null) {
                      TRTCSubCloud.5.this.ZQW.onSnapshotComplete(paramAnonymous2Bitmap);
                    }
                    AppMethodBeat.o(215938);
                  }
                });
                AppMethodBeat.o(216147);
              }
            });
            AppMethodBeat.o(215864);
            return;
            localObject1 = localObject2;
            if (localUserInfo != null)
            {
              localObject1 = localObject2;
              if (localUserInfo.mainRender != null)
              {
                localObject1 = localObject2;
                if (localUserInfo.mainRender.render != null)
                {
                  TRTCSubCloud.access$5600(TRTCSubCloud.this, "snapshotRemoteView->userId: " + paramString);
                  localObject1 = localUserInfo.mainRender.render.getVideoRender();
                }
              }
            }
          }
          TRTCSubCloud.access$5800(TRTCSubCloud.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216521);
              if (TRTCSubCloud.5.this.ZQW != null) {
                TRTCSubCloud.5.this.ZQW.onSnapshotComplete(null);
              }
              AppMethodBeat.o(216521);
            }
          });
        }
        AppMethodBeat.o(215864);
      }
    });
    AppMethodBeat.o(216301);
  }
  
  public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams)
  {
    return -1;
  }
  
  public void startLocalAudio() {}
  
  public void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    AppMethodBeat.i(216351);
    super.startPublishCDNStream(paramTRTCPublishCDNParam);
    AppMethodBeat.o(216351);
  }
  
  public void startPublishing(String paramString, int paramInt)
  {
    AppMethodBeat.i(216354);
    super.startPublishing(paramString, paramInt);
    AppMethodBeat.o(216354);
  }
  
  public void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(216293);
    super.startRemoteSubStreamView(paramString, paramTXCloudVideoView);
    AppMethodBeat.o(216293);
  }
  
  public void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(216287);
    super.startRemoteView(paramString, paramTXCloudVideoView);
    AppMethodBeat.o(216287);
  }
  
  public void startSpeedTest(int paramInt, String paramString1, String paramString2) {}
  
  public void startVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(216321);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, this.mAudioVolumeEvalInterval);
    if (paramBoolean)
    {
      if (this.mVolumeLevelCalTask == null)
      {
        this.mVolumeLevelCalTask = new a(this);
        this.mSDKHandler.postDelayed(this.mVolumeLevelCalTask, this.mAudioVolumeEvalInterval);
        AppMethodBeat.o(216321);
      }
    }
    else
    {
      this.mVolumeLevelCalTask = null;
      this.mAudioVolumeEvalInterval = 0;
    }
    AppMethodBeat.o(216321);
  }
  
  public void stopAllAudioEffects() {}
  
  public void stopAllRemoteView()
  {
    AppMethodBeat.i(216299);
    super.stopAllRemoteView();
    AppMethodBeat.o(216299);
  }
  
  public void stopAudioEffect(int paramInt) {}
  
  public void stopAudioRecording() {}
  
  public void stopBGM() {}
  
  public void stopLocalAudio() {}
  
  public void stopLocalPreview() {}
  
  public void stopPublishCDNStream()
  {
    AppMethodBeat.i(216353);
    super.stopPublishCDNStream();
    AppMethodBeat.o(216353);
  }
  
  public void stopPublishing()
  {
    AppMethodBeat.i(216352);
    super.stopPublishing();
    AppMethodBeat.o(216352);
  }
  
  public void stopRemoteSubStreamView(String paramString)
  {
    AppMethodBeat.i(216295);
    super.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(216295);
  }
  
  public void stopRemoteView(String paramString)
  {
    AppMethodBeat.i(216291);
    super.stopRemoteView(paramString);
    AppMethodBeat.o(216291);
  }
  
  public void stopSpeedTest() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public void switchCamera() {}
  
  public void switchRole(int paramInt)
  {
    AppMethodBeat.i(216280);
    super.switchRole(paramInt);
    AppMethodBeat.o(216280);
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<TRTCSubCloud> a;
    
    a(TRTCSubCloud paramTRTCSubCloud)
    {
      AppMethodBeat.i(216069);
      this.a = new WeakReference(paramTRTCSubCloud);
      AppMethodBeat.o(216069);
    }
    
    public void run()
    {
      AppMethodBeat.i(216072);
      TRTCSubCloud localTRTCSubCloud = null;
      if (this.a != null) {
        localTRTCSubCloud = (TRTCSubCloud)this.a.get();
      }
      if (localTRTCSubCloud != null)
      {
        final ArrayList localArrayList = new ArrayList();
        int i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
        if (i > 0)
        {
          TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
          localTRTCVolumeInfo.userId = localTRTCSubCloud.mRoomInfo.userId;
          localTRTCVolumeInfo.volume = i;
          localArrayList.add(localTRTCVolumeInfo);
        }
        localTRTCSubCloud.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public final void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
          {
            AppMethodBeat.i(216126);
            int i = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(paramAnonymousUserInfo.tinyID));
            if (i > 0)
            {
              paramAnonymousString = new TRTCCloudDef.TRTCVolumeInfo();
              paramAnonymousString.userId = paramAnonymousUserInfo.userID;
              paramAnonymousString.volume = i;
              localArrayList.add(paramAnonymousString);
            }
            AppMethodBeat.o(216126);
          }
        });
        TRTCSubCloud.access$6600(localTRTCSubCloud, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216517);
            if (this.ZRe != null) {
              this.ZRe.onUserVoiceVolume(localArrayList, 0);
            }
            AppMethodBeat.o(216517);
          }
        });
        if (localTRTCSubCloud.mAudioVolumeEvalInterval > 0) {
          localTRTCSubCloud.mSDKHandler.postDelayed(localTRTCSubCloud.mVolumeLevelCalTask, localTRTCSubCloud.mAudioVolumeEvalInterval);
        }
      }
      AppMethodBeat.o(216072);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud
 * JD-Core Version:    0.7.0.1
 */