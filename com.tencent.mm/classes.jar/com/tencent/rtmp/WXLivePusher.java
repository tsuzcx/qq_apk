package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.WXTRTCCloud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXLivePusher
  extends TXLivePusher
{
  private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
  private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
  private static final String RTMP_PROXY_ADDRESS = "room://cloud.tencent.com";
  private static final String TAG = "WXLivePusher";
  private int mAppScene;
  private int mAudioVolumeEvaluationInterval;
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
  private boolean mAutoRecvAudio;
  private boolean mAutoRecvVideo;
  private WeakReference<TXLivePusher.OnBGMNotify> mBGMNotify;
  private boolean mEnterRoom;
  private boolean mIsRtmpProxy;
  private boolean mIsTRTC;
  private HashMap<String, String> mMapMainStream;
  private HashMap<String, String> mMapSubStream;
  private boolean mNeedCheckRole;
  private WXLivePushConfig mPushConfig;
  private WeakReference<ITXLivePushListener> mPushListener;
  private boolean mStartAudio;
  private boolean mStartPreview;
  private WXTRTCCloud mTRTCCloud;
  private TRTCCloudListener mTRTCCloudListener;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private TXCloudVideoView mVideoView;
  
  public WXLivePusher(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(13945);
    this.mTRTCCloud = null;
    this.mTRTCParams = null;
    this.mAppScene = 0;
    this.mIsTRTC = false;
    this.mStartPreview = false;
    this.mStartAudio = false;
    this.mEnterRoom = false;
    this.mNeedCheckRole = false;
    this.mIsRtmpProxy = false;
    this.mAutoRecvAudio = true;
    this.mAutoRecvVideo = true;
    this.mPushListener = null;
    this.mVideoView = null;
    this.mBGMNotify = null;
    this.mPushConfig = new WXLivePushConfig();
    this.mMapMainStream = new HashMap();
    this.mMapSubStream = new HashMap();
    this.mAudioVolumeEvaluationListener = null;
    this.mAudioVolumeEvaluationInterval = 0;
    this.mTRTCCloudListener = new TRTCCloudListener()
    {
      private JSONObject getAudioAvailableJSONObject(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170239);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramAnonymousString1);
          localJSONObject.put("playurl", paramAnonymousString2);
          localJSONObject.put("hasaudio", paramAnonymousBoolean);
          AppMethodBeat.o(170239);
          return localJSONObject;
        }
        catch (Exception paramAnonymousString1)
        {
          TXCLog.e("WXLivePusher", "build json object failed.", paramAnonymousString1);
          AppMethodBeat.o(170239);
        }
        return null;
      }
      
      private JSONObject getUserEnterJSONObject(String paramAnonymousString)
      {
        AppMethodBeat.i(170236);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramAnonymousString);
          AppMethodBeat.o(170236);
          return localJSONObject;
        }
        catch (Exception paramAnonymousString)
        {
          TXCLog.e("WXLivePusher", "build json object failed.", paramAnonymousString);
          AppMethodBeat.o(170236);
        }
        return null;
      }
      
      private JSONObject getUserExitJSONObject(String paramAnonymousString)
      {
        AppMethodBeat.i(170237);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramAnonymousString);
          AppMethodBeat.o(170237);
          return localJSONObject;
        }
        catch (Exception paramAnonymousString)
        {
          TXCLog.e("WXLivePusher", "build json object failed.", paramAnonymousString);
          AppMethodBeat.o(170237);
        }
        return null;
      }
      
      private JSONObject getVideoAvailableJSONObject(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170238);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramAnonymousString1);
          localJSONObject.put("playurl", paramAnonymousString2);
          localJSONObject.put("streamtype", paramAnonymousString3);
          localJSONObject.put("hasvideo", paramAnonymousBoolean);
          AppMethodBeat.o(170238);
          return localJSONObject;
        }
        catch (Exception paramAnonymousString1)
        {
          TXCLog.e("WXLivePusher", "build json object failed.", paramAnonymousString1);
          AppMethodBeat.o(170238);
        }
        return null;
      }
      
      private void sendEventNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(170240);
        if (WXLivePusher.this.mPushListener != null)
        {
          ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.this.mPushListener.get();
          if (localITXLivePushListener != null) {
            localITXLivePushListener.onPushEvent(paramAnonymousInt, new Bundle());
          }
        }
        AppMethodBeat.o(170240);
      }
      
      private void sendEventNotify(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(170241);
        if (WXLivePusher.this.mPushListener != null)
        {
          ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.this.mPushListener.get();
          if (localITXLivePushListener != null)
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("EVT_MSG", paramAnonymousString);
            localITXLivePushListener.onPushEvent(paramAnonymousInt, localBundle);
          }
        }
        AppMethodBeat.o(170241);
      }
      
      private void sendEventNotify(int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(170242);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          Object localObject = new JSONArray();
          ((JSONArray)localObject).put(paramAnonymousJSONObject);
          localJSONObject.put("userlist", localObject);
          if (WXLivePusher.this.mPushListener != null)
          {
            paramAnonymousJSONObject = (ITXLivePushListener)WXLivePusher.this.mPushListener.get();
            if (paramAnonymousJSONObject != null)
            {
              localObject = new Bundle();
              ((Bundle)localObject).putString("EVT_MSG", localJSONObject.toString());
              paramAnonymousJSONObject.onPushEvent(paramAnonymousInt, (Bundle)localObject);
            }
          }
          AppMethodBeat.o(170242);
          return;
        }
        catch (Exception paramAnonymousJSONObject)
        {
          TXCLog.e("WXLivePusher", "send event failed.", paramAnonymousJSONObject);
          AppMethodBeat.o(170242);
        }
      }
      
      public void onEnterRoom(long paramAnonymousLong)
      {
        AppMethodBeat.i(170226);
        super.onEnterRoom(paramAnonymousLong);
        WXLivePusher.this.apiOnlineLog("onEnterRoom result: ".concat(String.valueOf(paramAnonymousLong)), true);
        if (paramAnonymousLong > 0L)
        {
          WXLivePusher.access$202(WXLivePusher.this, true);
          sendEventNotify(1018, "onEnterRoom success, time cost[" + paramAnonymousLong + "]");
          if (WXLivePusher.this.mNeedCheckRole)
          {
            if ((WXLivePusher.this.mStartAudio) || (WXLivePusher.this.mStartPreview))
            {
              WXLivePusher.this.mTRTCCloud.switchRole(20);
              AppMethodBeat.o(170226);
              return;
            }
            WXLivePusher.this.mTRTCCloud.switchRole(21);
            AppMethodBeat.o(170226);
          }
        }
        else
        {
          WXLivePusher.access$202(WXLivePusher.this, false);
          sendEventNotify(1022, "onEnterRoom failed, error code[" + paramAnonymousLong + "]");
        }
        AppMethodBeat.o(170226);
      }
      
      public void onError(int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(170224);
        super.onError(paramAnonymousInt, paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(170224);
      }
      
      public void onExitRoom(int paramAnonymousInt)
      {
        AppMethodBeat.i(170227);
        WXLivePusher.this.apiOnlineLog("onExitRoom reason: ".concat(String.valueOf(paramAnonymousInt)), true);
        super.onExitRoom(paramAnonymousInt);
        WXLivePusher.access$202(WXLivePusher.this, false);
        sendEventNotify(1019, "onExitRoom reason[" + paramAnonymousInt + "]");
        AppMethodBeat.o(170227);
      }
      
      public void onRecvSEIMsg(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(170235);
        WXLivePusher.this.mTRTCCloud.notifySEIMessage(paramAnonymousString, paramAnonymousArrayOfByte);
        AppMethodBeat.o(170235);
      }
      
      public void onRemoteUserEnterRoom(String paramAnonymousString)
      {
        AppMethodBeat.i(170228);
        super.onUserEnter(paramAnonymousString);
        WXLivePusher.this.apiOnlineLog("onRemoteUserEnterRoom userId: ".concat(String.valueOf(paramAnonymousString)), true);
        sendEventNotify(1031, getUserEnterJSONObject(paramAnonymousString));
        AppMethodBeat.o(170228);
      }
      
      public void onRemoteUserLeaveRoom(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(170229);
        super.onUserExit(paramAnonymousString, paramAnonymousInt);
        WXLivePusher.this.apiOnlineLog("onRemoteUserLeaveRoom userId: " + paramAnonymousString + ", reason: " + paramAnonymousInt, true);
        sendEventNotify(1032, getUserExitJSONObject(paramAnonymousString));
        AppMethodBeat.o(170229);
      }
      
      public void onStatistics(TRTCStatistics paramAnonymousTRTCStatistics)
      {
        AppMethodBeat.i(170234);
        WXLivePusher.this.mTRTCCloud.notifyStatistics(paramAnonymousTRTCStatistics);
        AppMethodBeat.o(170234);
      }
      
      public void onUserAudioAvailable(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170231);
        super.onUserAudioAvailable(paramAnonymousString, paramAnonymousBoolean);
        WXLivePusher.this.apiOnlineLog("onUserAudioAvailable userId: " + paramAnonymousString + ", available: " + paramAnonymousBoolean, true);
        sendEventNotify(1034, getAudioAvailableJSONObject(paramAnonymousString, "room://cloud.tencent.com/rtc?userid=" + paramAnonymousString + "&streamtype=main", paramAnonymousBoolean));
        AppMethodBeat.o(170231);
      }
      
      public void onUserSubStreamAvailable(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170232);
        super.onUserSubStreamAvailable(paramAnonymousString, paramAnonymousBoolean);
        WXLivePusher.this.apiOnlineLog("onUserSubStreamAvailable userId: " + paramAnonymousString + ", available: " + paramAnonymousBoolean, true);
        String str = "room://cloud.tencent.com/rtc?userid=" + paramAnonymousString + "&streamtype=aux";
        if (paramAnonymousBoolean) {
          sendEventNotify(1033, getVideoAvailableJSONObject(paramAnonymousString, str, "aux", true));
        }
        for (;;)
        {
          WXLivePusher.access$800(WXLivePusher.this, paramAnonymousBoolean, paramAnonymousString, str);
          AppMethodBeat.o(170232);
          return;
          sendEventNotify(1033, getVideoAvailableJSONObject(paramAnonymousString, str, "aux", false));
        }
      }
      
      public void onUserVideoAvailable(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170230);
        super.onUserVideoAvailable(paramAnonymousString, paramAnonymousBoolean);
        WXLivePusher.this.apiOnlineLog("onUserVideoAvailable userId: " + paramAnonymousString + ", available: " + paramAnonymousBoolean, true);
        String str = "room://cloud.tencent.com/rtc?userid=" + paramAnonymousString + "&streamtype=main";
        sendEventNotify(1033, getVideoAvailableJSONObject(paramAnonymousString, str, "main", paramAnonymousBoolean));
        if (paramAnonymousBoolean)
        {
          WXLivePusher.access$700(WXLivePusher.this, true, paramAnonymousString, str);
          AppMethodBeat.o(170230);
          return;
        }
        WXLivePusher.access$700(WXLivePusher.this, false, paramAnonymousString, "");
        AppMethodBeat.o(170230);
      }
      
      public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramAnonymousArrayList, int paramAnonymousInt)
      {
        AppMethodBeat.i(170233);
        if (WXLivePusher.this.mAudioVolumeEvaluationInterval > 0)
        {
          Iterator localIterator = paramAnonymousArrayList.iterator();
          while (localIterator.hasNext())
          {
            TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = (TRTCCloudDef.TRTCVolumeInfo)localIterator.next();
            if ((localTRTCVolumeInfo != null) && (localTRTCVolumeInfo.userId != null) && (WXLivePusher.this.mTRTCParams != null) && (localTRTCVolumeInfo.userId.equalsIgnoreCase(WXLivePusher.this.mTRTCParams.userId))) {
              if (WXLivePusher.this.mAudioVolumeEvaluationListener != null) {
                WXLivePusher.this.mAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(localTRTCVolumeInfo.volume);
              }
            }
          }
        }
        WXLivePusher.this.mTRTCCloud.notifyUserVoiceVolume(paramAnonymousArrayList, paramAnonymousInt);
        AppMethodBeat.o(170233);
      }
      
      public void onWarning(int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(170225);
        super.onWarning(paramAnonymousInt, paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(170225);
      }
    };
    this.mTRTCParams = new TRTCCloudDef.TRTCParams();
    this.mTRTCCloud = WXTRTCCloud.sharedInstance(paramContext);
    this.mTRTCCloud.setListener(this.mTRTCCloudListener);
    AppMethodBeat.o(13945);
  }
  
  private void checkSwitchAnchor()
  {
    AppMethodBeat.i(13980);
    if ((this.mIsTRTC) && (this.mNeedCheckRole) && (this.mEnterRoom) && ((this.mStartPreview) || (this.mStartAudio))) {
      this.mTRTCCloud.switchRole(20);
    }
    AppMethodBeat.o(13980);
  }
  
  private void checkSwitchAudience()
  {
    AppMethodBeat.i(13981);
    if ((this.mIsTRTC) && (this.mNeedCheckRole) && (this.mEnterRoom) && (!this.mStartPreview) && (!this.mStartAudio)) {
      this.mTRTCCloud.switchRole(21);
    }
    AppMethodBeat.o(13981);
  }
  
  private void clearMainStream()
  {
    AppMethodBeat.i(13985);
    try
    {
      this.mMapMainStream.clear();
      return;
    }
    finally
    {
      AppMethodBeat.o(13985);
    }
  }
  
  private void clearSubStream()
  {
    AppMethodBeat.i(13986);
    try
    {
      this.mMapSubStream.clear();
      return;
    }
    finally
    {
      AppMethodBeat.o(13986);
    }
  }
  
  private int internalStartDumpAudioData(String paramString)
  {
    AppMethodBeat.i(170218);
    TXCAudioEngine.getInstance().setAudioDumpingListener(new TXCAudioEngineJNI.a()
    {
      public void onLocalAudioWriteFailed()
      {
        AppMethodBeat.i(170223);
        if (WXLivePusher.this.mPushListener != null)
        {
          ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.this.mPushListener.get();
          if (localITXLivePushListener != null)
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("EVT_MSG", "write file failed when recording audio");
            localITXLivePushListener.onPushEvent(7001, localBundle);
          }
        }
        AppMethodBeat.o(170223);
      }
    });
    int i = TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, paramString);
    AppMethodBeat.o(170218);
    return i;
  }
  
  private void internalStopDumpAudioData()
  {
    AppMethodBeat.i(170220);
    TXCAudioEngine.getInstance().stopLocalAudioDumping();
    AppMethodBeat.o(170220);
  }
  
  private boolean isRtmpProxyUrl(String paramString)
  {
    AppMethodBeat.i(218471);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(218471);
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com")))
    {
      AppMethodBeat.o(218471);
      return false;
    }
    boolean bool = paramString.startsWith("room://cloud.tencent.com");
    AppMethodBeat.o(218471);
    return bool;
  }
  
  private boolean isTRTCPusherUrl(String paramString)
  {
    AppMethodBeat.i(13983);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(13983);
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com")))
    {
      AppMethodBeat.o(13983);
      return true;
    }
    AppMethodBeat.o(13983);
    return false;
  }
  
  /* Error */
  private void notifyFullUserList()
  {
    // Byte code:
    //   0: sipush 13989
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 219	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 220	org/json/JSONObject:<init>	()V
    //   13: astore_1
    //   14: new 222	org/json/JSONArray
    //   17: dup
    //   18: invokespecial 223	org/json/JSONArray:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc 225
    //   25: aload_2
    //   26: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 108	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   36: invokevirtual 233	java/util/HashMap:keySet	()Ljava/util/Set;
    //   39: invokeinterface 239 1 0
    //   44: astore_3
    //   45: aload_3
    //   46: invokeinterface 245 1 0
    //   51: ifeq +88 -> 139
    //   54: aload_3
    //   55: invokeinterface 249 1 0
    //   60: checkcast 210	java/lang/String
    //   63: astore 4
    //   65: new 219	org/json/JSONObject
    //   68: dup
    //   69: invokespecial 220	org/json/JSONObject:<init>	()V
    //   72: astore 5
    //   74: aload 5
    //   76: ldc 251
    //   78: aload 4
    //   80: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 5
    //   86: ldc 253
    //   88: aload_0
    //   89: getfield 108	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   92: aload 4
    //   94: invokevirtual 257	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload_2
    //   102: aload 5
    //   104: invokevirtual 260	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   107: pop
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: sipush 13989
    //   117: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: ldc 25
    //   125: ldc_w 262
    //   128: aload_1
    //   129: invokestatic 268	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: sipush 13989
    //   135: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: aload_0
    //   140: monitorexit
    //   141: new 222	org/json/JSONArray
    //   144: dup
    //   145: invokespecial 223	org/json/JSONArray:<init>	()V
    //   148: astore_2
    //   149: aload_1
    //   150: ldc_w 270
    //   153: aload_2
    //   154: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_0
    //   159: monitorenter
    //   160: aload_0
    //   161: getfield 110	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   164: invokevirtual 233	java/util/HashMap:keySet	()Ljava/util/Set;
    //   167: invokeinterface 239 1 0
    //   172: astore_3
    //   173: aload_3
    //   174: invokeinterface 245 1 0
    //   179: ifeq +71 -> 250
    //   182: aload_3
    //   183: invokeinterface 249 1 0
    //   188: checkcast 210	java/lang/String
    //   191: astore 4
    //   193: new 219	org/json/JSONObject
    //   196: dup
    //   197: invokespecial 220	org/json/JSONObject:<init>	()V
    //   200: astore 5
    //   202: aload 5
    //   204: ldc 251
    //   206: aload 4
    //   208: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 5
    //   214: ldc 253
    //   216: aload_0
    //   217: getfield 110	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   220: aload 4
    //   222: invokevirtual 257	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   225: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_2
    //   230: aload 5
    //   232: invokevirtual 260	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   235: pop
    //   236: goto -63 -> 173
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: sipush 13989
    //   245: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_1
    //   249: athrow
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_0
    //   253: getfield 92	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   256: ifnull +47 -> 303
    //   259: aload_0
    //   260: getfield 92	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   263: invokevirtual 274	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   266: checkcast 276	com/tencent/rtmp/ITXLivePushListener
    //   269: astore_2
    //   270: aload_2
    //   271: ifnull +32 -> 303
    //   274: new 278	android/os/Bundle
    //   277: dup
    //   278: invokespecial 279	android/os/Bundle:<init>	()V
    //   281: astore_3
    //   282: aload_3
    //   283: ldc_w 281
    //   286: aload_1
    //   287: invokevirtual 285	org/json/JSONObject:toString	()Ljava/lang/String;
    //   290: invokevirtual 289	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_2
    //   294: sipush 1020
    //   297: aload_3
    //   298: invokeinterface 293 3 0
    //   303: sipush 13989
    //   306: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	WXLivePusher
    //   13	10	1	localJSONObject1	JSONObject
    //   111	10	1	localObject1	Object
    //   122	28	1	localException	Exception
    //   239	48	1	localObject2	Object
    //   21	273	2	localObject3	Object
    //   44	254	3	localObject4	Object
    //   63	158	4	str	String
    //   72	159	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   32	45	111	finally
    //   45	108	111	finally
    //   139	141	111	finally
    //   6	32	122	java/lang/Exception
    //   112	122	122	java/lang/Exception
    //   141	160	122	java/lang/Exception
    //   240	250	122	java/lang/Exception
    //   252	270	122	java/lang/Exception
    //   274	303	122	java/lang/Exception
    //   160	173	239	finally
    //   173	236	239	finally
    //   250	252	239	finally
  }
  
  private void notifyMainStreamChange(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(13987);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mMapMainStream.put(paramString1, paramString2);
        notifyFullUserList();
        AppMethodBeat.o(13987);
        return;
      }
      finally
      {
        AppMethodBeat.o(13987);
      }
      this.mMapMainStream.remove(paramString1);
    }
  }
  
  private void notifySubStreamChange(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(13988);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mMapSubStream.put(paramString1, paramString2);
        notifyFullUserList();
        AppMethodBeat.o(13988);
        return;
      }
      finally
      {
        AppMethodBeat.o(13988);
      }
      this.mMapSubStream.remove(paramString1);
    }
  }
  
  private boolean parseTRTCParams(String paramString)
  {
    AppMethodBeat.i(13984);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(13984);
      return false;
    }
    i1 = 0;
    i = 0;
    i2 = 0;
    j = 0;
    localObject1 = "";
    localObject2 = "";
    localObject3 = "";
    localObject4 = "";
    localObject6 = "";
    localObject5 = "";
    i3 = 0;
    k = 0;
    i4 = 0;
    m = 0;
    n = 0;
    try
    {
      arrayOfString = paramString.split("[?&]");
      i7 = arrayOfString.length;
      i1 = 0;
      n = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String[] arrayOfString;
        int i7;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        Object localObject11;
        Object localObject12;
        int i5;
        int i6;
        CharSequence localCharSequence;
        m = i4;
        k = i3;
        j = i2;
        i = i1;
        continue;
        i1 += 1;
        n = i2;
        m = i3;
        k = i4;
        localObject5 = localObject7;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject3 = localObject10;
        localObject2 = localObject11;
        localObject1 = localObject12;
        j = i5;
        i = i6;
      }
    }
    if (i1 < i7)
    {
      paramString = arrayOfString[i1];
      i2 = n;
      i3 = m;
      i4 = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i5 = j;
      i6 = i;
      try
      {
        if (paramString.indexOf("=") == -1) {
          break label2523;
        }
        paramString = paramString.split("[=]");
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        if (paramString.length != 2) {
          break label2523;
        }
        localCharSequence = paramString[0];
        paramString = paramString[1];
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        if (TextUtils.isEmpty(localCharSequence)) {
          break label2523;
        }
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        if (TextUtils.isEmpty(paramString)) {
          break label2523;
        }
        if (localCharSequence.equalsIgnoreCase("sdkappid"))
        {
          i6 = Integer.parseInt(paramString);
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
        }
        else if (localCharSequence.equalsIgnoreCase("roomid"))
        {
          i5 = Long.valueOf(paramString).intValue();
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i6 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("userid"))
        {
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = paramString;
          i5 = j;
          i6 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("usersig"))
        {
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = paramString;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("cloudenv"))
        {
          if (paramString.equalsIgnoreCase("pro"))
          {
            WXTRTCCloud.setNetEnv(0);
            i2 = n;
            i3 = m;
            i4 = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i5 = j;
            i6 = i;
          }
        }
      }
      catch (Exception paramString) {}
      TXCLog.e("WXLivePusher", "parse trtc params failed.", paramString);
      i1 = m;
      m = k;
      k = i1;
      i1 = i;
    }
    while ((i1 == 0) || ((j == 0) && (TextUtils.isEmpty((CharSequence)localObject6))) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      AppMethodBeat.o(13984);
      return false;
      if (paramString.equalsIgnoreCase("dev"))
      {
        WXTRTCCloud.setNetEnv(1);
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (paramString.equalsIgnoreCase("uat"))
      {
        WXTRTCCloud.setNetEnv(2);
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      i2 = n;
      i3 = m;
      i4 = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i5 = j;
      i6 = i;
      if (!paramString.equalsIgnoreCase("ccc")) {
        break label2523;
      }
      WXTRTCCloud.setNetEnv(3);
      i2 = n;
      i3 = m;
      i4 = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i5 = j;
      i6 = i;
      break label2523;
      if (localCharSequence.equalsIgnoreCase("encsmall"))
      {
        localObject7 = new TRTCCloudDef.TRTCVideoEncParam();
        ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoResolution = 100;
        ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoFps = 15;
        ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoBitrate = 100;
        ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoResolutionMode = 1;
        if (Integer.parseInt(paramString) == 1)
        {
          this.mTRTCCloud.enableEncSmallVideoStream(true, (TRTCCloudDef.TRTCVideoEncParam)localObject7);
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
          break label2523;
        }
        this.mTRTCCloud.enableEncSmallVideoStream(false, (TRTCCloudDef.TRTCVideoEncParam)localObject7);
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("enableblackstream"))
      {
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        if (Integer.parseInt(paramString) != 1) {
          break label2523;
        }
        this.mTRTCCloud.enableBlackStream(true);
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("appscene"))
      {
        if (paramString.equalsIgnoreCase("live"))
        {
          this.mAppScene = 1;
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
          break label2523;
        }
        if (paramString.equalsIgnoreCase("videocall"))
        {
          this.mAppScene = 0;
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
          break label2523;
        }
        if (paramString.equalsIgnoreCase("audiocall"))
        {
          this.mAppScene = 2;
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
          break label2523;
        }
        if (paramString.equalsIgnoreCase("voicechatroom"))
        {
          this.mAppScene = 3;
          i2 = n;
          i3 = m;
          i4 = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i5 = j;
          i6 = i;
          break label2523;
        }
        this.mAppScene = 0;
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("recvmode"))
      {
        i2 = Integer.parseInt(paramString);
        if (i2 != 1)
        {
          if (i2 == 2)
          {
            this.mAutoRecvAudio = true;
            this.mAutoRecvVideo = false;
            i2 = n;
            i3 = m;
            i4 = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i5 = j;
            i6 = i;
            break label2523;
          }
          if (i2 == 3)
          {
            this.mAutoRecvAudio = false;
            this.mAutoRecvVideo = true;
            i2 = n;
            i3 = m;
            i4 = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i5 = j;
            i6 = i;
            break label2523;
          }
          if (i2 == 4)
          {
            this.mAutoRecvAudio = false;
            this.mAutoRecvVideo = false;
            i2 = n;
            i3 = m;
            i4 = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i5 = j;
            i6 = i;
            break label2523;
          }
        }
        this.mAutoRecvAudio = true;
        this.mAutoRecvVideo = true;
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("streamid"))
      {
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = paramString;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("userdefinerecordid"))
      {
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = paramString;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("strroomid"))
      {
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = localObject5;
        localObject8 = paramString;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("privatemapkey"))
      {
        i2 = n;
        i3 = m;
        i4 = k;
        localObject7 = paramString;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      if (localCharSequence.equalsIgnoreCase("pureaudiomode"))
      {
        i4 = Integer.parseInt(paramString);
        i2 = n;
        i3 = m;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i5 = j;
        i6 = i;
        break label2523;
      }
      i2 = n;
      i3 = m;
      i4 = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i5 = j;
      i6 = i;
      if (!localCharSequence.equalsIgnoreCase("uc_biz_type")) {
        break label2523;
      }
      i3 = Integer.parseInt(paramString);
      i2 = 1;
      i4 = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i5 = j;
      i6 = i;
      break label2523;
      i2 = k;
      i1 = i;
      k = m;
      m = i2;
    }
    i2 = 0;
    i = i2;
    if (!TextUtils.isEmpty((CharSequence)localObject6))
    {
      i = i2;
      if (j == 0) {
        i = 1;
      }
    }
    this.mTRTCParams.sdkAppId = i1;
    paramString = this.mTRTCParams;
    if (i != 0)
    {
      j = -1;
      paramString.roomId = j;
      this.mTRTCParams.userId = ((String)localObject1);
      this.mTRTCParams.userSig = ((String)localObject2);
      this.mTRTCParams.privateMapKey = ((String)localObject5);
      if ((this.mAppScene != 1) && (this.mAppScene != 3)) {
        break label2454;
      }
      this.mNeedCheckRole = true;
      label2245:
      if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
        break label2462;
      }
      j = 1;
      label2260:
      if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
        break label2467;
      }
      i1 = 1;
      label2276:
      if ((m != 1) && (m != 2)) {
        break label2473;
      }
      i2 = 1;
      label2291:
      if ((j == 0) && (i1 == 0) && (i == 0) && (i2 == 0) && (n == 0)) {
        break label2492;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        if ((j != 0) || (i1 != 0) || (n != 0))
        {
          localObject1 = new JSONObject();
          if (j != 0) {
            ((JSONObject)localObject1).put("userdefine_streamid_main", localObject3);
          }
          if (i1 != 0) {
            ((JSONObject)localObject1).put("userdefine_record_id", localObject4);
          }
          if (i2 != 0) {
            ((JSONObject)localObject1).put("pure_audio_push_mod", m);
          }
          if (n != 0) {
            ((JSONObject)localObject1).put("uc_biz_type", k);
          }
          paramString.put("Str_uc_params", localObject1);
        }
        if (i != 0) {
          paramString.put("strGroupId", localObject6);
        }
        this.mTRTCParams.businessInfo = paramString.toString();
      }
      catch (Exception paramString)
      {
        label2454:
        label2462:
        label2467:
        label2473:
        TXCLog.e("WXLivePusher", "build json object failed.", paramString);
        continue;
      }
      AppMethodBeat.o(13984);
      return true;
      break;
      this.mNeedCheckRole = false;
      break label2245;
      j = 0;
      break label2260;
      i1 = 0;
      break label2276;
      i2 = 0;
      break label2291;
      label2492:
      this.mTRTCParams.businessInfo = "";
    }
  }
  
  private void updateConfig(boolean paramBoolean, WXLivePushConfig paramWXLivePushConfig)
  {
    AppMethodBeat.i(13982);
    apiOnlineLog("updateConfig force: " + paramBoolean + ", config: " + paramWXLivePushConfig.toString() + ", isTRTC: " + this.mIsTRTC, true);
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1;
        int j;
        JSONObject localJSONObject2;
        if ((paramWXLivePushConfig.mVideoEncodeWidth != this.mPushConfig.mVideoEncodeWidth) || (paramWXLivePushConfig.mVideoEncodeHeight != this.mPushConfig.mVideoEncodeHeight) || (paramWXLivePushConfig.mMaxVideoBitrate != this.mPushConfig.mMaxVideoBitrate) || (paramWXLivePushConfig.mHomeOrientation != this.mPushConfig.mHomeOrientation))
        {
          localJSONObject1 = new JSONObject();
          if ((paramWXLivePushConfig.mHomeOrientation != 0) && (paramWXLivePushConfig.mHomeOrientation != 2)) {
            continue;
          }
          if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight)
          {
            j = paramWXLivePushConfig.mVideoEncodeWidth;
            if (paramWXLivePushConfig.mVideoEncodeWidth <= paramWXLivePushConfig.mVideoEncodeHeight) {
              continue;
            }
            i = paramWXLivePushConfig.mVideoEncodeHeight;
            localJSONObject1.put("codecType", 1);
            localJSONObject1.put("streamType", 0);
            localJSONObject1.put("videoWidth", j);
            localJSONObject1.put("videoHeight", i);
            localJSONObject1.put("videoBitrate", paramWXLivePushConfig.mMaxVideoBitrate);
            localJSONObject1.put("videoFps", 15);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("api", "setVideoEncodeParamEx");
            localJSONObject2.put("params", localJSONObject1);
            this.mTRTCCloud.callExperimentalAPI(localJSONObject2.toString());
          }
        }
        else if ((!paramBoolean) && (paramWXLivePushConfig.mLocalVideoMirrorType == this.mPushConfig.mLocalVideoMirrorType)) {}
        switch (paramWXLivePushConfig.mLocalVideoMirrorType)
        {
        default: 
          this.mTRTCCloud.setLocalViewMirror(i);
          if ((paramBoolean) || (paramWXLivePushConfig.mAudioSample != this.mPushConfig.mAudioSample))
          {
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("sampleRate", paramWXLivePushConfig.mAudioSample);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("api", "setAudioSampleRate");
            localJSONObject2.put("params", localJSONObject1);
            this.mTRTCCloud.callExperimentalAPI(localJSONObject2.toString());
          }
          if ((paramBoolean) || (paramWXLivePushConfig.mEnableAgc != this.mPushConfig.mEnableAgc))
          {
            localJSONObject1 = new JSONObject();
            if (!paramWXLivePushConfig.mEnableAgc) {
              break label846;
            }
            i = 1;
            localJSONObject1.put("enable", i);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("api", "enableAudioAGC");
            localJSONObject2.put("params", localJSONObject1);
            this.mTRTCCloud.callExperimentalAPI(localJSONObject2.toString());
          }
          if ((paramBoolean) || (paramWXLivePushConfig.mEnableAns != this.mPushConfig.mEnableAns))
          {
            localJSONObject1 = new JSONObject();
            if (!paramWXLivePushConfig.mEnableAns) {
              break label851;
            }
            i = 1;
            localJSONObject1.put("enable", i);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("api", "enableAudioANS");
            localJSONObject2.put("params", localJSONObject1);
            this.mTRTCCloud.callExperimentalAPI(localJSONObject2.toString());
          }
          if ((paramBoolean) || (paramWXLivePushConfig.mVolumeType != this.mPushConfig.mVolumeType))
          {
            if (paramWXLivePushConfig.mVolumeType == 1)
            {
              i = 1;
              this.mTRTCCloud.setSystemVolumeType(i);
            }
          }
          else
          {
            if ((paramBoolean) || (paramWXLivePushConfig.mTouchFocus != this.mPushConfig.mTouchFocus) || (paramWXLivePushConfig.mEnableZoom != this.mPushConfig.mEnableZoom)) {
              this.mTRTCCloud.setConfig(paramWXLivePushConfig.mTouchFocus, paramWXLivePushConfig.mEnableZoom);
            }
            if ((paramBoolean) || (paramWXLivePushConfig.mEnableAudioPreview != this.mPushConfig.mEnableAudioPreview)) {
              this.mTRTCCloud.enableAudioEarMonitoring(paramWXLivePushConfig.mEnableAudioPreview);
            }
            AppMethodBeat.o(13982);
            return;
            j = paramWXLivePushConfig.mVideoEncodeHeight;
            continue;
            i = paramWXLivePushConfig.mVideoEncodeWidth;
            continue;
            if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight)
            {
              j = paramWXLivePushConfig.mVideoEncodeHeight;
              if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight) {
                i = paramWXLivePushConfig.mVideoEncodeWidth;
              }
            }
            else
            {
              j = paramWXLivePushConfig.mVideoEncodeWidth;
              continue;
            }
            i = paramWXLivePushConfig.mVideoEncodeHeight;
            continue;
          }
          i = paramWXLivePushConfig.mVolumeType;
          if (i == 2)
          {
            i = 2;
            continue;
          }
          i = 0;
          continue;
          i = 0;
        }
      }
      catch (Exception paramWXLivePushConfig)
      {
        TXCLog.e("WXLivePusher", "update config failed.", paramWXLivePushConfig);
        AppMethodBeat.o(13982);
        return;
      }
      continue;
      int i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      label846:
      i = 0;
      continue;
      label851:
      i = 0;
    }
  }
  
  public void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(218522);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = "[API] WXLivePusher(" + hashCode() + ") ";
    if (paramBoolean)
    {
      Monitor.a(1, paramString + " " + str, "", 0, "");
      AppMethodBeat.o(218522);
      return;
    }
    TXCLog.i("WXLivePusher", paramString + " " + str);
    AppMethodBeat.o(218522);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(182237);
    if (!this.mIsTRTC) {
      super.enableAudioVolumeEvaluation(paramInt);
    }
    this.mAudioVolumeEvaluationInterval = paramInt;
    AppMethodBeat.o(182237);
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(13960);
    if (this.mIsTRTC)
    {
      i = this.mTRTCCloud.getMaxZoom();
      AppMethodBeat.o(13960);
      return i;
    }
    int i = super.getMaxZoom();
    AppMethodBeat.o(13960);
    return i;
  }
  
  public boolean isPushing()
  {
    AppMethodBeat.i(13964);
    if (this.mIsTRTC)
    {
      bool = this.mEnterRoom;
      AppMethodBeat.o(13964);
      return bool;
    }
    boolean bool = super.isPushing();
    AppMethodBeat.o(13964);
    return bool;
  }
  
  public boolean pauseBGM()
  {
    AppMethodBeat.i(13973);
    if (this.mIsTRTC) {
      this.mTRTCCloud.pauseBGM();
    }
    for (;;)
    {
      AppMethodBeat.o(13973);
      return true;
      super.pauseBGM();
    }
  }
  
  public void pausePusher()
  {
    AppMethodBeat.i(13967);
    apiOnlineLog("pausePusher isTRTC: " + this.mIsTRTC, true);
    if (this.mIsTRTC)
    {
      if ((this.mStartPreview) && ((this.mPushConfig.mPauseFlag & 0x1) == 1)) {
        this.mTRTCCloud.pausePusher();
      }
      if ((this.mStartAudio) && ((this.mPushConfig.mPauseFlag & 0x2) == 2))
      {
        this.mTRTCCloud.muteLocalAudio(true);
        AppMethodBeat.o(13967);
      }
    }
    else
    {
      super.pausePusher();
    }
    AppMethodBeat.o(13967);
  }
  
  public boolean playBGM(String paramString)
  {
    AppMethodBeat.i(13971);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.playBGM(paramString, new TRTCCloud.BGMNotify()
      {
        public void onBGMComplete(int paramAnonymousInt)
        {
          AppMethodBeat.i(170246);
          if (WXLivePusher.this.mBGMNotify != null)
          {
            TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.this.mBGMNotify.get();
            if (localOnBGMNotify != null) {
              localOnBGMNotify.onBGMComplete(paramAnonymousInt);
            }
          }
          AppMethodBeat.o(170246);
        }
        
        public void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
        {
          AppMethodBeat.i(170245);
          if (WXLivePusher.this.mBGMNotify != null)
          {
            TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.this.mBGMNotify.get();
            if (localOnBGMNotify != null) {
              localOnBGMNotify.onBGMProgress(paramAnonymousLong1, paramAnonymousLong2);
            }
          }
          AppMethodBeat.o(170245);
        }
        
        public void onBGMStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(170244);
          if (WXLivePusher.this.mBGMNotify != null)
          {
            TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.this.mBGMNotify.get();
            if (localOnBGMNotify != null) {
              localOnBGMNotify.onBGMStart();
            }
          }
          AppMethodBeat.o(170244);
        }
      });
      AppMethodBeat.o(13971);
      return true;
    }
    boolean bool = super.playBGM(paramString);
    AppMethodBeat.o(13971);
    return bool;
  }
  
  public void resetParams()
  {
    AppMethodBeat.i(13979);
    this.mAppScene = 0;
    this.mIsTRTC = false;
    this.mStartPreview = false;
    this.mStartAudio = false;
    this.mEnterRoom = false;
    this.mNeedCheckRole = false;
    this.mAutoRecvAudio = true;
    this.mAutoRecvVideo = true;
    clearMainStream();
    clearSubStream();
    AppMethodBeat.o(13979);
  }
  
  public boolean resumeBGM()
  {
    AppMethodBeat.i(13974);
    if (this.mIsTRTC) {
      this.mTRTCCloud.resumeBGM();
    }
    for (;;)
    {
      AppMethodBeat.o(13974);
      return true;
      super.resumeBGM();
    }
  }
  
  public void resumePusher()
  {
    AppMethodBeat.i(13968);
    apiOnlineLog("resumePusher isTRTC: " + this.mIsTRTC, true);
    if (this.mIsTRTC)
    {
      if ((this.mStartPreview) && ((this.mPushConfig.mPauseFlag & 0x1) == 1)) {
        this.mTRTCCloud.resumePusher();
      }
      if ((this.mStartAudio) && ((this.mPushConfig.mPauseFlag & 0x2) == 2))
      {
        this.mTRTCCloud.muteLocalAudio(false);
        AppMethodBeat.o(13968);
      }
    }
    else
    {
      super.resumePusher();
    }
    AppMethodBeat.o(13968);
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13978);
    if (this.mIsTRTC)
    {
      bool = this.mTRTCCloud.sendSEIMsg(paramArrayOfByte, 1);
      AppMethodBeat.o(13978);
      return bool;
    }
    boolean bool = super.sendMessageEx(paramArrayOfByte);
    AppMethodBeat.o(13978);
    return bool;
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(182236);
    if (!this.mIsTRTC) {
      super.setAudioVolumeEvaluationListener(paramITXAudioVolumeEvaluationListener);
    }
    this.mAudioVolumeEvaluationListener = paramITXAudioVolumeEvaluationListener;
    AppMethodBeat.o(182236);
  }
  
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(13970);
    super.setBGMNofify(paramOnBGMNotify);
    this.mBGMNotify = new WeakReference(paramOnBGMNotify);
    AppMethodBeat.o(13970);
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    AppMethodBeat.i(13975);
    if (this.mIsTRTC) {
      this.mTRTCCloud.setBGMVolume(Math.round(100.0F * paramFloat));
    }
    for (;;)
    {
      AppMethodBeat.o(13975);
      return true;
      super.setBGMVolume(paramFloat);
    }
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(13951);
    super.setBeautyFilter(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mTRTCCloud.setBeautyStyle(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(13951);
    return true;
  }
  
  public void setConfig(WXLivePushConfig paramWXLivePushConfig)
  {
    AppMethodBeat.i(13948);
    super.setConfig(paramWXLivePushConfig);
    if (this.mIsTRTC) {
      if ("setConfig config: ".concat(String.valueOf(paramWXLivePushConfig)) == null) {
        break label70;
      }
    }
    label70:
    for (String str = paramWXLivePushConfig.toString();; str = "")
    {
      apiOnlineLog(str, true);
      if (this.mEnterRoom) {
        updateConfig(false, paramWXLivePushConfig);
      }
      this.mPushConfig = paramWXLivePushConfig.clone();
      AppMethodBeat.o(13948);
      return;
    }
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(182235);
    super.setFilter(paramBitmap);
    this.mTRTCCloud.setFilter(paramBitmap);
    AppMethodBeat.o(182235);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(13962);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.setFocusPosition(paramFloat1, paramFloat2);
      AppMethodBeat.o(13962);
      return;
    }
    super.setFocusPosition(paramFloat1, paramFloat2);
    AppMethodBeat.o(13962);
  }
  
  public boolean setMicVolume(float paramFloat)
  {
    AppMethodBeat.i(13976);
    if (this.mIsTRTC) {
      this.mTRTCCloud.setMicVolumeOnMixing(Math.round(100.0F * paramFloat));
    }
    for (;;)
    {
      AppMethodBeat.o(13976);
      return true;
      super.setMicVolume(paramFloat);
    }
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(13957);
    super.setMirror(paramBoolean);
    this.mTRTCCloud.setVideoEncoderMirror(paramBoolean);
    AppMethodBeat.o(13957);
    return true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(13958);
    apiOnlineLog("setMute mute: ".concat(String.valueOf(paramBoolean)), true);
    super.setMute(paramBoolean);
    this.mTRTCCloud.muteLocalAudio(paramBoolean);
    AppMethodBeat.o(13958);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(13946);
    super.setPushListener(paramITXLivePushListener);
    this.mTRTCCloud.setPushListener(paramITXLivePushListener);
    this.mPushListener = new WeakReference(paramITXLivePushListener);
    AppMethodBeat.o(13946);
  }
  
  public void setPusherUrl(String paramString)
  {
    AppMethodBeat.i(13947);
    this.mIsTRTC = isTRTCPusherUrl(paramString);
    AppMethodBeat.o(13947);
  }
  
  public void setReverb(int paramInt)
  {
    AppMethodBeat.i(13977);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.setReverbType(paramInt);
      AppMethodBeat.o(13977);
      return;
    }
    super.setReverb(paramInt);
    AppMethodBeat.o(13977);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(13949);
    super.setSurface(paramSurface);
    this.mTRTCCloud.setLocalSurface(paramSurface);
    AppMethodBeat.o(13949);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13950);
    super.setSurfaceSize(paramInt1, paramInt2);
    this.mTRTCCloud.setLocalSurfaceSize(paramInt1, paramInt2);
    AppMethodBeat.o(13950);
  }
  
  public boolean setZoom(int paramInt)
  {
    AppMethodBeat.i(13961);
    if (this.mIsTRTC) {
      this.mTRTCCloud.setZoom(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(13961);
      return true;
      super.setZoom(paramInt);
    }
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    AppMethodBeat.i(13963);
    if (this.mVideoView != null) {
      this.mVideoView.showLog(paramBoolean);
    }
    WXTRTCCloud localWXTRTCCloud = this.mTRTCCloud;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      localWXTRTCCloud.showDebugView(i);
      AppMethodBeat.o(13963);
      return;
    }
  }
  
  public void snapshot(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(13969);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.snapshotVideo(null, 0, new TRTCCloudListener.TRTCSnapshotListener()
      {
        public void onSnapshotComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(182245);
          if (paramITXSnapshotListener != null) {
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(182245);
        }
      });
      AppMethodBeat.o(13969);
      return;
    }
    super.snapshot(paramITXSnapshotListener);
    AppMethodBeat.o(13969);
  }
  
  public void startAudioRecord()
  {
    AppMethodBeat.i(13954);
    if (this.mIsTRTC) {
      this.mTRTCCloud.startLocalAudio();
    }
    this.mStartAudio = true;
    checkSwitchAnchor();
    AppMethodBeat.o(13954);
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(13952);
    apiOnlineLog("startCameraPreview view: ".concat(String.valueOf(paramTXCloudVideoView)), true);
    if (this.mIsTRTC) {
      this.mTRTCCloud.startLocalPreview(this.mPushConfig.mFrontCamera, paramTXCloudVideoView);
    }
    for (;;)
    {
      this.mVideoView = paramTXCloudVideoView;
      this.mStartPreview = true;
      checkSwitchAnchor();
      AppMethodBeat.o(13952);
      return;
      super.startCameraPreview(paramTXCloudVideoView);
    }
  }
  
  public int startDumpAudioData(String paramString)
  {
    AppMethodBeat.i(170217);
    if (this.mIsTRTC)
    {
      TRTCCloudDef.TRTCAudioRecordingParams localTRTCAudioRecordingParams = new TRTCCloudDef.TRTCAudioRecordingParams();
      localTRTCAudioRecordingParams.filePath = paramString;
      i = this.mTRTCCloud.startAudioRecording(localTRTCAudioRecordingParams);
      AppMethodBeat.o(170217);
      return i;
    }
    int i = internalStartDumpAudioData(paramString);
    AppMethodBeat.o(170217);
    return i;
  }
  
  public int startPusher(String paramString)
  {
    AppMethodBeat.i(13965);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(13965);
      return -1;
    }
    this.mIsRtmpProxy = isRtmpProxyUrl(paramString);
    boolean bool = isTRTCPusherUrl(paramString);
    apiOnlineLog("startPusher url: " + paramString + ", isTRTC: " + this.mIsTRTC, true);
    if (!bool)
    {
      this.mIsTRTC = bool;
      int i = super.startPusher(paramString);
      AppMethodBeat.o(13965);
      return i;
    }
    if (!parseTRTCParams(paramString))
    {
      TXCLog.e("WXLivePusher", "parse pusherUrl failed!!!");
      AppMethodBeat.o(13965);
      return -1;
    }
    if ((!this.mIsTRTC) && (bool == true))
    {
      if (this.mStartPreview)
      {
        super.stopCameraPreview(true);
        this.mTRTCCloud.startLocalPreview(true, this.mVideoView);
      }
      if (this.mStartAudio) {
        this.mTRTCCloud.startLocalAudio();
      }
    }
    if (this.mNeedCheckRole) {
      if ((this.mStartPreview) || (this.mStartAudio)) {
        this.mTRTCParams.role = 20;
      }
    }
    for (;;)
    {
      this.mIsTRTC = bool;
      updateConfig(true, this.mPushConfig);
      this.mTRTCCloud.setDefaultStreamRecvMode(this.mAutoRecvAudio, this.mAutoRecvVideo);
      this.mTRTCCloud.enableAudioVolumeEvaluation(300);
      this.mTRTCCloud.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(13965);
      return 0;
      this.mTRTCParams.role = 21;
      continue;
      this.mTRTCParams.role = 20;
    }
  }
  
  public void stopAudioRecord()
  {
    AppMethodBeat.i(13955);
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopLocalAudio();
    }
    this.mStartAudio = false;
    checkSwitchAudience();
    AppMethodBeat.o(13955);
  }
  
  public boolean stopBGM()
  {
    AppMethodBeat.i(13972);
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopBGM();
    }
    for (;;)
    {
      AppMethodBeat.o(13972);
      return true;
      super.stopBGM();
    }
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(13953);
    apiOnlineLog("stopCameraPreview isNeedClearLastImg: ".concat(String.valueOf(paramBoolean)), true);
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopLocalPreview();
    }
    for (;;)
    {
      this.mStartPreview = false;
      checkSwitchAudience();
      AppMethodBeat.o(13953);
      return;
      super.stopCameraPreview(true);
    }
  }
  
  public void stopDumpAudioData()
  {
    AppMethodBeat.i(170219);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.stopAudioRecording();
      AppMethodBeat.o(170219);
      return;
    }
    internalStopDumpAudioData();
    AppMethodBeat.o(170219);
  }
  
  public void stopPusher()
  {
    AppMethodBeat.i(13966);
    apiOnlineLog("stopPusher isTRTC: " + this.mIsTRTC, true);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.exitRoom();
      this.mTRTCCloud.setLocalViewMirror(0);
    }
    for (;;)
    {
      resetParams();
      AppMethodBeat.o(13966);
      return;
      internalStopDumpAudioData();
      super.stopPusher();
    }
  }
  
  public void switchCamera()
  {
    AppMethodBeat.i(13956);
    if (this.mIsTRTC)
    {
      WXLivePushConfig localWXLivePushConfig = this.mPushConfig;
      if (!this.mPushConfig.mFrontCamera) {}
      for (boolean bool = true;; bool = false)
      {
        localWXLivePushConfig.mFrontCamera = bool;
        this.mTRTCCloud.switchCamera();
        AppMethodBeat.o(13956);
        return;
      }
    }
    super.switchCamera();
    AppMethodBeat.o(13956);
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    AppMethodBeat.i(13959);
    if (this.mIsTRTC)
    {
      paramBoolean = this.mTRTCCloud.enableTorch(paramBoolean);
      AppMethodBeat.o(13959);
      return paramBoolean;
    }
    paramBoolean = super.turnOnFlashLight(paramBoolean);
    AppMethodBeat.o(13959);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher
 * JD-Core Version:    0.7.0.1
 */