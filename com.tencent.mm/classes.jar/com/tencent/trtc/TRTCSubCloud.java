package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.a.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
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
    AppMethodBeat.i(222791);
    TAG = TRTCSubCloud.class.getName();
    AppMethodBeat.o(222791);
  }
  
  public TRTCSubCloud(Context paramContext, WeakReference<TRTCCloudImpl> paramWeakReference, Handler paramHandler)
  {
    super(paramContext, paramHandler);
    this.mRoomInfo.muteLocalAudio = true;
    this.mRoomInfo.muteLocalVideo = true;
    this.mMainCloud = paramWeakReference;
  }
  
  public void ConnectOtherRoom(String paramString)
  {
    AppMethodBeat.i(222719);
    super.ConnectOtherRoom(paramString);
    AppMethodBeat.o(222719);
  }
  
  public void DisconnectOtherRoom()
  {
    AppMethodBeat.i(222720);
    super.DisconnectOtherRoom();
    AppMethodBeat.o(222720);
  }
  
  public void callExperimentalAPI(final String paramString)
  {
    AppMethodBeat.i(222743);
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder("callExperimentalAPI  ").append(paramString).append(", roomid = ");
      if (this.mRoomInfo.roomId == -1L) {
        break label136;
      }
    }
    label136:
    for (Object localObject = Long.valueOf(this.mRoomInfo.roomId);; localObject = this.mRoomInfo.strRoomId)
    {
      apiLog(localObject);
      Monitor.a(1, String.format("callExperimentalAPI:%s", new Object[] { paramString }) + " self:" + hashCode(), "", 0);
      runOnSDKThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222702);
          String str;
          try
          {
            JSONObject localJSONObject2 = new JSONObject(paramString);
            if (!localJSONObject2.has("api"))
            {
              TRTCSubCloud.access$6900(TRTCSubCloud.this, "callExperimentalAPI[lack api or illegal type]: " + paramString);
              AppMethodBeat.o(222702);
              return;
            }
            str = localJSONObject2.getString("api");
            JSONObject localJSONObject1 = null;
            if (localJSONObject2.has("params")) {
              localJSONObject1 = localJSONObject2.getJSONObject("params");
            }
            if (str.equals("setSEIPayloadType"))
            {
              TRTCSubCloud.access$7000(TRTCSubCloud.this, localJSONObject1);
              AppMethodBeat.o(222702);
              return;
            }
          }
          catch (Exception localException)
          {
            TRTCSubCloud.access$7600(TRTCSubCloud.this, "callExperimentalAPI[failed]: " + paramString);
            AppMethodBeat.o(222702);
            return;
          }
          if ((!str.equals("setLocalAudioMuteMode")) && (!str.equals("setVideoEncodeParamEx")) && (!str.equals("setAudioSampleRate")))
          {
            if (str.equals("muteRemoteAudioInSpeaker"))
            {
              TRTCSubCloud.access$7100(TRTCSubCloud.this, localException);
              AppMethodBeat.o(222702);
              return;
            }
            if ((!str.equals("enableAudioAGC")) && (!str.equals("enableAudioAEC")) && (!str.equals("enableAudioANS")))
            {
              if (str.equals("setPerformanceMode"))
              {
                TRTCSubCloud.access$7200(TRTCSubCloud.this, localException);
                AppMethodBeat.o(222702);
                return;
              }
              if ((!str.equals("setCustomRenderMode")) && (!str.equals("setMediaCodecConfig")))
              {
                if (str.equals("sendJsonCMD"))
                {
                  TRTCSubCloud.access$7300(TRTCSubCloud.this, localException, paramString);
                  AppMethodBeat.o(222702);
                  return;
                }
                if (str.equals("updatePrivateMapKey"))
                {
                  TRTCSubCloud.access$7400(TRTCSubCloud.this, localException);
                  AppMethodBeat.o(222702);
                  return;
                }
                TRTCSubCloud.access$7500(TRTCSubCloud.this, "callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
              }
            }
          }
          AppMethodBeat.o(222702);
        }
      });
      AppMethodBeat.o(222743);
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
    AppMethodBeat.i(222711);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222697);
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
          AppMethodBeat.o(222697);
          return;
        }
      }
    });
    AppMethodBeat.o(222711);
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean) {}
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(222742);
    super.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(222742);
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
    AppMethodBeat.i(222715);
    if (paramTRTCParams == null)
    {
      apiLog("enter room, param nil!");
      onEnterRoom(-3316, "enter room param null");
      AppMethodBeat.o(222715);
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
      AppMethodBeat.o(222715);
      return;
    }
    final long l = localTRTCParams.roomId & 0xFFFFFFFF;
    if (l == 0L)
    {
      apiLog("enter room, room id " + l + " error");
      onEnterRoom(-3318, "room id invalid.");
      AppMethodBeat.o(222715);
      return;
    }
    String str2 = "";
    Object localObject = localTRTCParams.businessInfo;
    final String str1 = str2;
    paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject;
    if (localTRTCParams.roomId == -1)
    {
      str1 = str2;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject;
      if (!TextUtils.isEmpty(localTRTCParams.businessInfo))
      {
        try
        {
          localObject = new JSONObject(localTRTCParams.businessInfo);
          str2 = ((JSONObject)localObject).optString("strGroupId");
          ((JSONObject)localObject).remove("strGroupId");
          ((JSONObject)localObject).remove("Role");
          paramTRTCParams = "";
          str1 = str2;
          if (((JSONObject)localObject).length() != 0)
          {
            paramTRTCParams = ((JSONObject)localObject).toString();
            str1 = str2;
          }
        }
        catch (Exception paramTRTCParams)
        {
          for (;;)
          {
            apiLog("enter room, room id error, busInfo " + localTRTCParams.businessInfo);
            str1 = "";
            paramTRTCParams = "";
          }
        }
        if (TextUtils.isEmpty(str1))
        {
          onEnterRoom(-3318, "room id invalid.");
          AppMethodBeat.o(222715);
          return;
        }
      }
    }
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222710);
        if (TRTCSubCloud.this.mRoomState != 0)
        {
          if (((!TextUtils.isEmpty(str1)) && (str1.equalsIgnoreCase(TRTCSubCloud.this.mRoomInfo.strRoomId))) || (TRTCSubCloud.this.mRoomInfo.roomId == l))
          {
            TRTCSubCloud.access$1300(TRTCSubCloud.this, String.format("enter the same room[%d] again, ignore!!!", new Object[] { Long.valueOf(l) }));
            AppMethodBeat.o(222710);
            return;
          }
          TRTCSubCloud.access$1500(TRTCSubCloud.this, String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l), Long.valueOf(TRTCSubCloud.this.mRoomInfo.roomId) }));
          TRTCSubCloud.access$1602(TRTCSubCloud.this, true);
          TRTCSubCloud.this.exitRoom();
        }
        TRTCSubCloud.access$1700(TRTCSubCloud.this, "========================================================================================================");
        TRTCSubCloud.access$1800(TRTCSubCloud.this, "========================================================================================================");
        TRTCSubCloud.access$1900(TRTCSubCloud.this, String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), f.c(), f.d() }));
        TRTCSubCloud.access$2000(TRTCSubCloud.this, "========================================================================================================");
        TRTCSubCloud.access$2100(TRTCSubCloud.this, "========================================================================================================");
        TRTCSubCloud.access$2200(TRTCSubCloud.this, String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d", new Object[] { Long.valueOf(l), str1, paramInt.userId, Integer.valueOf(paramInt.sdkAppId), Integer.valueOf(paramTRTCParams) }));
        Object localObject2 = new StringBuilder("enterRoom self:").append(TRTCSubCloud.this.hashCode()).append(", roomId:");
        Object localObject1;
        String str1;
        int i;
        label430:
        String str2;
        label449:
        int j;
        label545:
        int k;
        label557:
        int m;
        if (paramInt.roomId == -1)
        {
          localObject1 = str1;
          str1 = localObject1;
          i = paramTRTCParams;
          localObject1 = "VideoCall";
          switch (paramTRTCParams)
          {
          default: 
            TXCLog.w(TRTCSubCloud.TAG, "enter room scene:%u error! default to VideoCall! " + paramTRTCParams + " self:" + TRTCSubCloud.this.hashCode());
            i = 0;
            str2 = this.e;
            if (this.f == 20)
            {
              localObject2 = "Anchor";
              Monitor.a(1, str1, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { str2, localObject1, localObject2, paramInt.streamId }), 0);
              TXCEventRecorderProxy.a("18446744073709551615", 5001, l, -1L, "", 0);
              TRTCSubCloud.access$2402(TRTCSubCloud.this, 1);
              if (TRTCSubCloud.this.mNativeRtcContext == 0L)
              {
                localObject1 = TXCCommonUtil.getSDKVersion();
                if (localObject1.length <= 0) {
                  break label1016;
                }
                j = localObject1[0];
                if (localObject1.length < 2) {
                  break label1021;
                }
                k = localObject1[1];
                if (localObject1.length < 3) {
                  break label1026;
                }
                m = localObject1[2];
                label570:
                TRTCSubCloud.access$2602(TRTCSubCloud.this, TRTCSubCloud.access$2700(TRTCSubCloud.this, j, k, m));
              }
              TRTCSubCloud.access$2800(TRTCSubCloud.this, i);
              TRTCSubCloud.access$3100(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, TRTCSubCloud.this.mPriorStreamType);
              localObject1 = TRTCSubCloud.this.mRoomInfo.getToken(TRTCSubCloud.this.mContext);
              TRTCSubCloud.access$3500(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, paramInt.sdkAppId, paramInt.userId, paramInt.userSig, (byte[])localObject1);
              if (paramInt.privateMapKey == null) {
                break label1032;
              }
              localObject1 = paramInt.privateMapKey;
              label694:
              if (str1 == null) {
                break label1039;
              }
              localObject2 = str1;
              label707:
              if (this.e == null) {
                break label1046;
              }
              str1 = this.e;
              label720:
              if (paramInt.userDefineRecordId == null) {
                break label1053;
              }
              str2 = paramInt.userDefineRecordId;
              label739:
              if (paramInt.streamId == null) {
                break label1060;
              }
            }
            break;
          }
        }
        label1026:
        label1032:
        label1039:
        label1046:
        label1053:
        label1060:
        for (String str3 = paramInt.streamId;; str3 = "")
        {
          TRTCSubCloud.access$3900(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, l, str1, (String)localObject1, (String)localObject2, this.f, 255, 0, paramTRTCParams, TRTCSubCloud.this.mPerformanceMode, f.c(), f.d(), TRTCSubCloud.this.mRecvMode, str2, str3);
          TRTCSubCloud.access$4002(TRTCSubCloud.this, this.f);
          TRTCSubCloud.access$4102(TRTCSubCloud.this, this.f);
          TRTCSubCloud.access$4200(TRTCSubCloud.this);
          TRTCSubCloud.access$4302(TRTCSubCloud.this, 0L);
          TRTCSubCloud.this.mRoomInfo.init(l, paramInt.userId);
          TRTCSubCloud.this.mRoomInfo.strRoomId = ((String)localObject2);
          TRTCSubCloud.this.mRoomInfo.sdkAppId = paramInt.sdkAppId;
          TRTCSubCloud.this.mRoomInfo.userSig = paramInt.userSig;
          TRTCSubCloud.this.mRoomInfo.privateMapKey = ((String)localObject1);
          TRTCSubCloud.this.mRoomInfo.enterTime = this.g;
          AppMethodBeat.o(222710);
          return;
          localObject1 = Integer.valueOf(paramInt.roomId);
          break;
          localObject1 = "VideoCall";
          break label430;
          localObject1 = "Live";
          break label430;
          localObject1 = "AudioCall";
          i = 0;
          break label430;
          localObject1 = "VoiceChatRoom";
          i = 1;
          break label430;
          localObject2 = "Audience";
          break label449;
          label1016:
          j = 0;
          break label545;
          label1021:
          k = 0;
          break label557;
          m = 0;
          break label570;
          localObject1 = "";
          break label694;
          localObject2 = "";
          break label707;
          str1 = "";
          break label720;
          str2 = "";
          break label739;
        }
      }
    });
    AppMethodBeat.o(222715);
  }
  
  public void exitRoom()
  {
    AppMethodBeat.i(222716);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222701);
        String str = "exitRoom " + TRTCSubCloud.this.mRoomInfo.getRoomId() + ", " + TRTCSubCloud.this.hashCode();
        TRTCSubCloud.access$5100(TRTCSubCloud.this, str);
        Monitor.a(1, str, "", 0);
        TRTCSubCloud.this.exitRoomInternal(true, "call from api");
        AppMethodBeat.o(222701);
      }
    });
    AppMethodBeat.o(222716);
  }
  
  public void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(222717);
    apiLog("exitRoomInternal reqExit: " + paramBoolean + ", reason: " + paramString + ", mRoomState: " + this.mRoomState);
    if (this.mRoomState == 0)
    {
      apiLog("exitRoom ignore when no in room");
      AppMethodBeat.o(222717);
      return;
    }
    this.mRoomState = 0;
    stopCollectStatus();
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public final void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(222706);
        TRTCSubCloud.access$5200(TRTCSubCloud.this, paramAnonymousUserInfo);
        TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramAnonymousUserInfo.tinyID));
        if (paramAnonymousUserInfo.mainRender.render != null) {
          paramAnonymousUserInfo.mainRender.render.setVideoFrameListener(null, b.a);
        }
        if (paramAnonymousUserInfo.subRender.render != null) {
          paramAnonymousUserInfo.subRender.render.setVideoFrameListener(null, b.a);
        }
        AppMethodBeat.o(222706);
      }
    });
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    AppMethodBeat.o(222717);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(222712);
    this.mSDKHandler = null;
    super.finalize();
    AppMethodBeat.o(222712);
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
    AppMethodBeat.i(222739);
    super.muteAllRemoteAudio(paramBoolean);
    AppMethodBeat.o(222739);
  }
  
  public void muteAllRemoteVideoStreams(boolean paramBoolean)
  {
    AppMethodBeat.i(222732);
    super.muteAllRemoteVideoStreams(paramBoolean);
    AppMethodBeat.o(222732);
  }
  
  public void muteLocalAudio(final boolean paramBoolean)
  {
    AppMethodBeat.i(222737);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222686);
        TRTCSubCloud.access$6100(TRTCSubCloud.this, "muteLocalAudio " + paramBoolean + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
        Monitor.a(1, String.format("muteLocalAudio mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCSubCloud.this.hashCode(), "", 0);
        TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)TRTCSubCloud.this.mMainCloud.get();
        if (localTRTCCloudImpl != null) {
          localTRTCCloudImpl.muteLocalAudio(paramBoolean, TRTCSubCloud.this);
        }
        AppMethodBeat.o(222686);
      }
    });
    AppMethodBeat.o(222737);
  }
  
  public void muteLocalVideo(final boolean paramBoolean)
  {
    AppMethodBeat.i(222730);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222696);
        TRTCSubCloud.access$5900(TRTCSubCloud.this, "muteLocalVideo " + paramBoolean + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
        Monitor.a(1, String.format("muteLocalVideo mute:%b", new Object[] { Boolean.valueOf(paramBoolean) }) + " self:" + TRTCSubCloud.this.hashCode(), "", 0);
        TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)TRTCSubCloud.this.mMainCloud.get();
        if (localTRTCCloudImpl != null) {
          localTRTCCloudImpl.muteLocalVideo(paramBoolean, TRTCSubCloud.this);
        }
        AppMethodBeat.o(222696);
      }
    });
    AppMethodBeat.o(222730);
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(222738);
    super.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(222738);
  }
  
  public void muteRemoteVideoStream(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(222731);
    super.muteRemoteVideoStream(paramString, paramBoolean);
    AppMethodBeat.o(222731);
  }
  
  public void onAudioQosChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222754);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onAudioQosChanged(this, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(222754);
  }
  
  public void onIdrFpsChanged(int paramInt)
  {
    AppMethodBeat.i(222756);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onIdrFpsChanged(this, paramInt);
    }
    AppMethodBeat.o(222756);
  }
  
  public void onVideoConfigChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(222757);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoConfigChanged(this, paramInt, paramBoolean);
    }
    AppMethodBeat.o(222757);
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(222755);
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    AppMethodBeat.o(222755);
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
    AppMethodBeat.i(222752);
    paramBoolean1 = super.sendCustomCmdMsg(paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(222752);
    return paramBoolean1;
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame) {}
  
  public boolean sendSEIMsg(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(222753);
    boolean bool = super.sendSEIMsg(paramArrayOfByte, paramInt);
    AppMethodBeat.o(222753);
    return bool;
  }
  
  public void setAllAudioEffectsVolume(int paramInt) {}
  
  public void setAudioCaptureVolume(int paramInt) {}
  
  public void setAudioEffectVolume(int paramInt1, int paramInt2) {}
  
  public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener) {}
  
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
    AppMethodBeat.i(222746);
    super.setDebugViewMargin(paramString, paramTRTCViewMargin);
    AppMethodBeat.o(222746);
  }
  
  public void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222721);
    super.setDefaultStreamRecvMode(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(222721);
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
    AppMethodBeat.i(222713);
    super.setListener(paramTRTCCloudListener);
    AppMethodBeat.o(222713);
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    AppMethodBeat.i(222714);
    super.setListenerHandler(paramHandler);
    AppMethodBeat.o(222714);
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
    AppMethodBeat.i(222751);
    super.setMixTranscodingConfig(paramTRTCTranscodingConfig);
    AppMethodBeat.o(222751);
  }
  
  public void setMotionMute(boolean paramBoolean) {}
  
  public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam) {}
  
  public void setNoseSlimLevel(int paramInt) {}
  
  public int setPriorRemoteVideoStreamType(int paramInt)
  {
    AppMethodBeat.i(222735);
    paramInt = super.setPriorRemoteVideoStreamType(paramInt);
    AppMethodBeat.o(222735);
    return paramInt;
  }
  
  public void setRemoteAudioVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(222740);
    super.setRemoteAudioVolume(paramString, paramInt);
    AppMethodBeat.o(222740);
  }
  
  public void setRemoteSubStreamViewFillMode(String paramString, int paramInt)
  {
    AppMethodBeat.i(222726);
    super.setRemoteSubStreamViewFillMode(paramString, paramInt);
    AppMethodBeat.o(222726);
  }
  
  public void setRemoteSubStreamViewRotation(String paramString, int paramInt)
  {
    AppMethodBeat.i(222727);
    super.setRemoteSubStreamViewRotation(paramString, paramInt);
    AppMethodBeat.o(222727);
  }
  
  public int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    AppMethodBeat.i(222744);
    paramInt1 = super.setRemoteVideoRenderListener(paramString, paramInt1, paramInt2, paramTRTCVideoRenderListener);
    AppMethodBeat.o(222744);
    return paramInt1;
  }
  
  public int setRemoteVideoStreamType(String paramString, int paramInt)
  {
    AppMethodBeat.i(222736);
    paramInt = super.setRemoteVideoStreamType(paramString, paramInt);
    AppMethodBeat.o(222736);
    return paramInt;
  }
  
  public void setRemoteViewFillMode(String paramString, int paramInt)
  {
    AppMethodBeat.i(222733);
    super.setRemoteViewFillMode(paramString, paramInt);
    AppMethodBeat.o(222733);
  }
  
  public void setRemoteViewRotation(String paramString, int paramInt)
  {
    AppMethodBeat.i(222734);
    super.setRemoteViewRotation(paramString, paramInt);
    AppMethodBeat.o(222734);
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
    AppMethodBeat.i(222745);
    super.showDebugView(paramInt);
    AppMethodBeat.o(222745);
  }
  
  public void snapshotVideo(final String paramString, final int paramInt, final TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    AppMethodBeat.i(222729);
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222707);
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
                  TRTCSubCloud.access$5400(TRTCSubCloud.this, "snapshotRemoteSubStreamView->userId: " + paramString);
                  localObject1 = localUserInfo.subRender.render.getVideoRender();
                }
              }
            }
          }
          while (localObject1 != null)
          {
            ((e)localObject1).a(new o()
            {
              public final void onTakePhotoComplete(final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(222700);
                TRTCSubCloud.access$5600(TRTCSubCloud.this, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(222698);
                    if (TRTCSubCloud.5.this.Spp != null) {
                      TRTCSubCloud.5.this.Spp.onSnapshotComplete(paramAnonymous2Bitmap);
                    }
                    AppMethodBeat.o(222698);
                  }
                });
                AppMethodBeat.o(222700);
              }
            });
            AppMethodBeat.o(222707);
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
                  TRTCSubCloud.access$5500(TRTCSubCloud.this, "snapshotRemoteView->userId: " + paramString);
                  localObject1 = localUserInfo.mainRender.render.getVideoRender();
                }
              }
            }
          }
          TRTCSubCloud.access$5700(TRTCSubCloud.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222695);
              if (TRTCSubCloud.5.this.Spp != null) {
                TRTCSubCloud.5.this.Spp.onSnapshotComplete(null);
              }
              AppMethodBeat.o(222695);
            }
          });
        }
        AppMethodBeat.o(222707);
      }
    });
    AppMethodBeat.o(222729);
  }
  
  public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams)
  {
    return -1;
  }
  
  public void startLocalAudio() {}
  
  public void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    AppMethodBeat.i(222747);
    super.startPublishCDNStream(paramTRTCPublishCDNParam);
    AppMethodBeat.o(222747);
  }
  
  public void startPublishing(String paramString, int paramInt)
  {
    AppMethodBeat.i(222750);
    super.startPublishing(paramString, paramInt);
    AppMethodBeat.o(222750);
  }
  
  public void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(222724);
    super.startRemoteSubStreamView(paramString, paramTXCloudVideoView);
    AppMethodBeat.o(222724);
  }
  
  public void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(222722);
    super.startRemoteView(paramString, paramTXCloudVideoView);
    AppMethodBeat.o(222722);
  }
  
  public void startSpeedTest(int paramInt, String paramString1, String paramString2) {}
  
  public void startVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(222741);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, this.mAudioVolumeEvalInterval);
    if (paramBoolean)
    {
      if (this.mVolumeLevelCalTask == null)
      {
        this.mVolumeLevelCalTask = new a(this);
        this.mSDKHandler.postDelayed(this.mVolumeLevelCalTask, this.mAudioVolumeEvalInterval);
        AppMethodBeat.o(222741);
      }
    }
    else
    {
      this.mVolumeLevelCalTask = null;
      this.mAudioVolumeEvalInterval = 0;
    }
    AppMethodBeat.o(222741);
  }
  
  public void stopAllAudioEffects() {}
  
  public void stopAllRemoteView()
  {
    AppMethodBeat.i(222728);
    super.stopAllRemoteView();
    AppMethodBeat.o(222728);
  }
  
  public void stopAudioEffect(int paramInt) {}
  
  public void stopAudioRecording() {}
  
  public void stopBGM() {}
  
  public void stopLocalAudio() {}
  
  public void stopLocalPreview() {}
  
  public void stopPublishCDNStream()
  {
    AppMethodBeat.i(222749);
    super.stopPublishCDNStream();
    AppMethodBeat.o(222749);
  }
  
  public void stopPublishing()
  {
    AppMethodBeat.i(222748);
    super.stopPublishing();
    AppMethodBeat.o(222748);
  }
  
  public void stopRemoteSubStreamView(String paramString)
  {
    AppMethodBeat.i(222725);
    super.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(222725);
  }
  
  public void stopRemoteView(String paramString)
  {
    AppMethodBeat.i(222723);
    super.stopRemoteView(paramString);
    AppMethodBeat.o(222723);
  }
  
  public void stopSpeedTest() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public void switchCamera() {}
  
  public void switchRole(int paramInt)
  {
    AppMethodBeat.i(222718);
    super.switchRole(paramInt);
    AppMethodBeat.o(222718);
  }
  
  static final class a
    implements Runnable
  {
    private WeakReference<TRTCSubCloud> a;
    
    a(TRTCSubCloud paramTRTCSubCloud)
    {
      AppMethodBeat.i(222703);
      this.a = new WeakReference(paramTRTCSubCloud);
      AppMethodBeat.o(222703);
    }
    
    public final void run()
    {
      AppMethodBeat.i(222704);
      TRTCSubCloud localTRTCSubCloud = null;
      if (this.a != null) {
        localTRTCSubCloud = (TRTCSubCloud)this.a.get();
      }
      if (localTRTCSubCloud != null)
      {
        final ArrayList localArrayList = new ArrayList();
        localTRTCSubCloud.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
        {
          public final void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
          {
            AppMethodBeat.i(222708);
            int i = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(paramAnonymousUserInfo.tinyID));
            if (i > 0)
            {
              paramAnonymousString = new TRTCCloudDef.TRTCVolumeInfo();
              paramAnonymousString.userId = paramAnonymousUserInfo.userID;
              paramAnonymousString.volume = i;
              localArrayList.add(paramAnonymousString);
            }
            AppMethodBeat.o(222708);
          }
        });
        TRTCSubCloud.access$6400(localTRTCSubCloud, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222685);
            if (this.Spw != null) {
              this.Spw.onUserVoiceVolume(localArrayList, 0);
            }
            AppMethodBeat.o(222685);
          }
        });
        if (localTRTCSubCloud.mAudioVolumeEvalInterval > 0) {
          localTRTCSubCloud.mSDKHandler.postDelayed(localTRTCSubCloud.mVolumeLevelCalTask, localTRTCSubCloud.mAudioVolumeEvalInterval);
        }
      }
      AppMethodBeat.o(222704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud
 * JD-Core Version:    0.7.0.1
 */