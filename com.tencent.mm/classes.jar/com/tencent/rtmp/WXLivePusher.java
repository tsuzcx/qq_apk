package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.basic.log.TXCLog;
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
  private static final String ADDRESS1 = "room://cloud.tencent.com/rtc";
  private static final String ADDRESS2 = "room://rtc.tencent.com";
  private static final String TAG = "WXLivePusher";
  private int mAppScene;
  private int mAudioVolumeEvaluationInterval;
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
  private boolean mAutoRecvAudio;
  private boolean mAutoRecvVideo;
  private WeakReference<TXLivePusher.OnBGMNotify> mBGMNotify;
  private boolean mEnterRoom;
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
        sendEventNotify(1031, getUserEnterJSONObject(paramAnonymousString));
        AppMethodBeat.o(170228);
      }
      
      public void onRemoteUserLeaveRoom(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(170229);
        super.onUserExit(paramAnonymousString, paramAnonymousInt);
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
        sendEventNotify(1034, getAudioAvailableJSONObject(paramAnonymousString, "room://cloud.tencent.com/rtc?userid=" + paramAnonymousString + "&streamtype=main", paramAnonymousBoolean));
        AppMethodBeat.o(170231);
      }
      
      public void onUserSubStreamAvailable(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(170232);
        super.onUserSubStreamAvailable(paramAnonymousString, paramAnonymousBoolean);
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
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 211	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 212	org/json/JSONObject:<init>	()V
    //   13: astore_1
    //   14: new 214	org/json/JSONArray
    //   17: dup
    //   18: invokespecial 215	org/json/JSONArray:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc 217
    //   25: aload_2
    //   26: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 102	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   36: invokevirtual 225	java/util/HashMap:keySet	()Ljava/util/Set;
    //   39: invokeinterface 231 1 0
    //   44: astore_3
    //   45: aload_3
    //   46: invokeinterface 237 1 0
    //   51: ifeq +87 -> 138
    //   54: aload_3
    //   55: invokeinterface 241 1 0
    //   60: checkcast 203	java/lang/String
    //   63: astore 4
    //   65: new 211	org/json/JSONObject
    //   68: dup
    //   69: invokespecial 212	org/json/JSONObject:<init>	()V
    //   72: astore 5
    //   74: aload 5
    //   76: ldc 243
    //   78: aload 4
    //   80: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 5
    //   86: ldc 245
    //   88: aload_0
    //   89: getfield 102	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   92: aload 4
    //   94: invokevirtual 249	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload_2
    //   102: aload 5
    //   104: invokevirtual 252	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   107: pop
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: sipush 13989
    //   117: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: ldc 22
    //   125: ldc 254
    //   127: aload_1
    //   128: invokestatic 260	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: sipush 13989
    //   134: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: aload_0
    //   139: monitorexit
    //   140: new 214	org/json/JSONArray
    //   143: dup
    //   144: invokespecial 215	org/json/JSONArray:<init>	()V
    //   147: astore_2
    //   148: aload_1
    //   149: ldc_w 262
    //   152: aload_2
    //   153: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload_0
    //   158: monitorenter
    //   159: aload_0
    //   160: getfield 104	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   163: invokevirtual 225	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 231 1 0
    //   171: astore_3
    //   172: aload_3
    //   173: invokeinterface 237 1 0
    //   178: ifeq +71 -> 249
    //   181: aload_3
    //   182: invokeinterface 241 1 0
    //   187: checkcast 203	java/lang/String
    //   190: astore 4
    //   192: new 211	org/json/JSONObject
    //   195: dup
    //   196: invokespecial 212	org/json/JSONObject:<init>	()V
    //   199: astore 5
    //   201: aload 5
    //   203: ldc 243
    //   205: aload 4
    //   207: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload 5
    //   213: ldc 245
    //   215: aload_0
    //   216: getfield 104	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   219: aload 4
    //   221: invokevirtual 249	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload_2
    //   229: aload 5
    //   231: invokevirtual 252	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   234: pop
    //   235: goto -63 -> 172
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: sipush 13989
    //   244: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_1
    //   248: athrow
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_0
    //   252: getfield 86	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   255: ifnull +47 -> 302
    //   258: aload_0
    //   259: getfield 86	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   262: invokevirtual 266	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   265: checkcast 268	com/tencent/rtmp/ITXLivePushListener
    //   268: astore_2
    //   269: aload_2
    //   270: ifnull +32 -> 302
    //   273: new 270	android/os/Bundle
    //   276: dup
    //   277: invokespecial 271	android/os/Bundle:<init>	()V
    //   280: astore_3
    //   281: aload_3
    //   282: ldc_w 273
    //   285: aload_1
    //   286: invokevirtual 277	org/json/JSONObject:toString	()Ljava/lang/String;
    //   289: invokevirtual 281	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_2
    //   293: sipush 1020
    //   296: aload_3
    //   297: invokeinterface 285 3 0
    //   302: sipush 13989
    //   305: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	WXLivePusher
    //   13	10	1	localJSONObject1	JSONObject
    //   111	10	1	localObject1	Object
    //   122	27	1	localException	Exception
    //   238	48	1	localObject2	Object
    //   21	272	2	localObject3	Object
    //   44	253	3	localObject4	Object
    //   63	157	4	str	String
    //   72	158	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   32	45	111	finally
    //   45	108	111	finally
    //   112	114	111	finally
    //   138	140	111	finally
    //   6	32	122	java/lang/Exception
    //   114	122	122	java/lang/Exception
    //   140	159	122	java/lang/Exception
    //   241	249	122	java/lang/Exception
    //   251	269	122	java/lang/Exception
    //   273	302	122	java/lang/Exception
    //   159	172	238	finally
    //   172	235	238	finally
    //   239	241	238	finally
    //   249	251	238	finally
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
    m = 0;
    i = 0;
    n = 0;
    j = 0;
    localObject1 = "";
    localObject2 = "";
    localObject3 = "";
    localObject4 = "";
    localObject6 = "";
    localObject5 = "";
    k = 0;
    try
    {
      arrayOfString = paramString.split("[?&]");
      i3 = arrayOfString.length;
      m = 0;
      k = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String[] arrayOfString;
        int i3;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        Object localObject11;
        Object localObject12;
        int i1;
        int i2;
        CharSequence localCharSequence;
        j = n;
        i = m;
        continue;
        m += 1;
        k = n;
        localObject5 = localObject7;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject3 = localObject10;
        localObject2 = localObject11;
        localObject1 = localObject12;
        j = i1;
        i = i2;
      }
    }
    if (m < i3)
    {
      paramString = arrayOfString[m];
      n = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i1 = j;
      i2 = i;
      try
      {
        if (paramString.indexOf("=") == -1) {
          break label2149;
        }
        paramString = paramString.split("[=]");
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        if (paramString.length != 2) {
          break label2149;
        }
        localCharSequence = paramString[0];
        paramString = paramString[1];
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        if (TextUtils.isEmpty(localCharSequence)) {
          break label2149;
        }
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        if (TextUtils.isEmpty(paramString)) {
          break label2149;
        }
        if (localCharSequence.equalsIgnoreCase("sdkappid"))
        {
          i2 = Integer.parseInt(paramString);
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
        }
        else if (localCharSequence.equalsIgnoreCase("roomid"))
        {
          i1 = Long.valueOf(paramString).intValue();
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i2 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("userid"))
        {
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = paramString;
          i1 = j;
          i2 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("usersig"))
        {
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = paramString;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
        }
        else if (localCharSequence.equalsIgnoreCase("cloudenv"))
        {
          if (paramString.equalsIgnoreCase("pro"))
          {
            WXTRTCCloud.setNetEnv(0);
            n = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i1 = j;
            i2 = i;
          }
        }
      }
      catch (Exception paramString) {}
      TXCLog.e("WXLivePusher", "parse trtc params failed.", paramString);
      paramString = (String)localObject6;
    }
    for (m = i; (m == 0) || ((j == 0) && (TextUtils.isEmpty(paramString))) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)); m = i)
    {
      AppMethodBeat.o(13984);
      return false;
      if (paramString.equalsIgnoreCase("dev"))
      {
        WXTRTCCloud.setNetEnv(1);
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (paramString.equalsIgnoreCase("uat"))
      {
        WXTRTCCloud.setNetEnv(2);
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      n = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i1 = j;
      i2 = i;
      if (!paramString.equalsIgnoreCase("ccc")) {
        break label2149;
      }
      WXTRTCCloud.setNetEnv(3);
      n = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i1 = j;
      i2 = i;
      break label2149;
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
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
          break label2149;
        }
        this.mTRTCCloud.enableEncSmallVideoStream(false, (TRTCCloudDef.TRTCVideoEncParam)localObject7);
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("enableblackstream"))
      {
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        if (Integer.parseInt(paramString) != 1) {
          break label2149;
        }
        this.mTRTCCloud.enableBlackStream(true);
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("appscene"))
      {
        if (paramString.equalsIgnoreCase("live"))
        {
          this.mAppScene = 1;
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
          break label2149;
        }
        if (paramString.equalsIgnoreCase("videocall"))
        {
          this.mAppScene = 0;
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
          break label2149;
        }
        if (paramString.equalsIgnoreCase("audiocall"))
        {
          this.mAppScene = 2;
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
          break label2149;
        }
        if (paramString.equalsIgnoreCase("voicechatroom"))
        {
          this.mAppScene = 3;
          n = k;
          localObject7 = localObject5;
          localObject8 = localObject6;
          localObject9 = localObject4;
          localObject10 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          i1 = j;
          i2 = i;
          break label2149;
        }
        this.mAppScene = 0;
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("recvmode"))
      {
        n = Integer.parseInt(paramString);
        if (n != 1)
        {
          if (n == 2)
          {
            this.mAutoRecvAudio = true;
            this.mAutoRecvVideo = false;
            n = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i1 = j;
            i2 = i;
            break label2149;
          }
          if (n == 3)
          {
            this.mAutoRecvAudio = false;
            this.mAutoRecvVideo = true;
            n = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i1 = j;
            i2 = i;
            break label2149;
          }
          if (n == 4)
          {
            this.mAutoRecvAudio = false;
            this.mAutoRecvVideo = false;
            n = k;
            localObject7 = localObject5;
            localObject8 = localObject6;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i1 = j;
            i2 = i;
            break label2149;
          }
        }
        this.mAutoRecvAudio = true;
        this.mAutoRecvVideo = true;
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("streamid"))
      {
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = paramString;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("userdefinerecordid"))
      {
        n = k;
        localObject7 = localObject5;
        localObject8 = localObject6;
        localObject9 = paramString;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("strroomid"))
      {
        n = k;
        localObject7 = localObject5;
        localObject8 = paramString;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      if (localCharSequence.equalsIgnoreCase("privatemapkey"))
      {
        n = k;
        localObject7 = paramString;
        localObject8 = localObject6;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i1 = j;
        i2 = i;
        break label2149;
      }
      n = k;
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i1 = j;
      i2 = i;
      if (!localCharSequence.equalsIgnoreCase("pureaudiomode")) {
        break label2149;
      }
      n = Integer.parseInt(paramString);
      localObject7 = localObject5;
      localObject8 = localObject6;
      localObject9 = localObject4;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i1 = j;
      i2 = i;
      break label2149;
      paramString = (String)localObject6;
    }
    n = 0;
    i = n;
    if (!TextUtils.isEmpty(paramString))
    {
      i = n;
      if (j == 0) {
        i = 1;
      }
    }
    this.mTRTCParams.sdkAppId = m;
    localObject6 = this.mTRTCParams;
    if (i != 0)
    {
      j = -1;
      ((TRTCCloudDef.TRTCParams)localObject6).roomId = j;
      this.mTRTCParams.userId = ((String)localObject1);
      this.mTRTCParams.userSig = ((String)localObject2);
      this.mTRTCParams.privateMapKey = ((String)localObject5);
      if ((this.mAppScene != 1) && (this.mAppScene != 3)) {
        break label2088;
      }
      this.mNeedCheckRole = true;
      label1902:
      if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
        break label2096;
      }
      j = 1;
      label1917:
      if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
        break label2101;
      }
      m = 1;
      label1933:
      if ((k != 1) && (k != 2)) {
        break label2107;
      }
      n = 1;
      label1948:
      if ((j == 0) && (m == 0) && (i == 0) && (n == 0)) {
        break label2126;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        if ((j != 0) || (m != 0))
        {
          localObject2 = new JSONObject();
          if (j != 0) {
            ((JSONObject)localObject2).put("userdefine_streamid_main", localObject3);
          }
          if (m != 0) {
            ((JSONObject)localObject2).put("userdefine_record_id", localObject4);
          }
          if (n != 0) {
            ((JSONObject)localObject2).put("pure_audio_push_mod", k);
          }
          ((JSONObject)localObject1).put("Str_uc_params", localObject2);
        }
        if (i != 0) {
          ((JSONObject)localObject1).put("strGroupId", paramString);
        }
        this.mTRTCParams.businessInfo = ((JSONObject)localObject1).toString();
      }
      catch (Exception paramString)
      {
        label2088:
        label2096:
        label2101:
        label2107:
        TXCLog.e("WXLivePusher", "build json object failed.", paramString);
        continue;
      }
      AppMethodBeat.o(13984);
      return true;
      break;
      this.mNeedCheckRole = false;
      break label1902;
      j = 0;
      break label1917;
      m = 0;
      break label1933;
      n = 0;
      break label1948;
      label2126:
      this.mTRTCParams.businessInfo = "";
    }
  }
  
  private void updateConfig(boolean paramBoolean, WXLivePushConfig paramWXLivePushConfig)
  {
    AppMethodBeat.i(13982);
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
              break label798;
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
              break label803;
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
      label798:
      i = 0;
      continue;
      label803:
      i = 0;
    }
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
    if ((this.mIsTRTC) && (this.mEnterRoom)) {
      updateConfig(false, paramWXLivePushConfig);
    }
    this.mPushConfig = paramWXLivePushConfig.clone();
    AppMethodBeat.o(13948);
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
    boolean bool = isTRTCPusherUrl(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher
 * JD-Core Version:    0.7.0.1
 */