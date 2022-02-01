package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioLocalRecorder;
import com.tencent.liteav.audio.TXCAudioLocalRecorder.a;
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
  private TXCAudioLocalRecorder mAudioLocalRecorder;
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
    this.mAudioLocalRecorder = null;
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
    if (this.mAudioLocalRecorder == null)
    {
      this.mAudioLocalRecorder = new TXCAudioLocalRecorder();
      this.mAudioLocalRecorder.a(new TXCAudioLocalRecorder.a()
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
    }
    int i = this.mAudioLocalRecorder.a(48000, 16, false, paramString);
    AppMethodBeat.o(170218);
    return i;
  }
  
  private void internalStopDumpAudioData()
  {
    AppMethodBeat.i(170220);
    if (this.mAudioLocalRecorder != null)
    {
      this.mAudioLocalRecorder.b();
      this.mAudioLocalRecorder.a();
      this.mAudioLocalRecorder = null;
    }
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
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 213	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 214	org/json/JSONObject:<init>	()V
    //   13: astore_1
    //   14: new 216	org/json/JSONArray
    //   17: dup
    //   18: invokespecial 217	org/json/JSONArray:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc 219
    //   25: aload_2
    //   26: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 104	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   36: invokevirtual 227	java/util/HashMap:keySet	()Ljava/util/Set;
    //   39: invokeinterface 233 1 0
    //   44: astore_3
    //   45: aload_3
    //   46: invokeinterface 239 1 0
    //   51: ifeq +79 -> 130
    //   54: aload_3
    //   55: invokeinterface 243 1 0
    //   60: checkcast 205	java/lang/String
    //   63: astore 4
    //   65: new 213	org/json/JSONObject
    //   68: dup
    //   69: invokespecial 214	org/json/JSONObject:<init>	()V
    //   72: astore 5
    //   74: aload 5
    //   76: ldc 245
    //   78: aload 4
    //   80: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 5
    //   86: ldc 247
    //   88: aload_0
    //   89: getfield 104	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   92: aload 4
    //   94: invokevirtual 251	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload_2
    //   102: aload 5
    //   104: invokevirtual 254	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   107: pop
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: sipush 13989
    //   117: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: sipush 13989
    //   126: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: aload_0
    //   131: monitorexit
    //   132: new 216	org/json/JSONArray
    //   135: dup
    //   136: invokespecial 217	org/json/JSONArray:<init>	()V
    //   139: astore_2
    //   140: aload_1
    //   141: ldc_w 256
    //   144: aload_2
    //   145: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload_0
    //   150: monitorenter
    //   151: aload_0
    //   152: getfield 106	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   155: invokevirtual 227	java/util/HashMap:keySet	()Ljava/util/Set;
    //   158: invokeinterface 233 1 0
    //   163: astore_3
    //   164: aload_3
    //   165: invokeinterface 239 1 0
    //   170: ifeq +71 -> 241
    //   173: aload_3
    //   174: invokeinterface 243 1 0
    //   179: checkcast 205	java/lang/String
    //   182: astore 4
    //   184: new 213	org/json/JSONObject
    //   187: dup
    //   188: invokespecial 214	org/json/JSONObject:<init>	()V
    //   191: astore 5
    //   193: aload 5
    //   195: ldc 245
    //   197: aload 4
    //   199: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload 5
    //   205: ldc 247
    //   207: aload_0
    //   208: getfield 106	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   211: aload 4
    //   213: invokevirtual 251	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   219: pop
    //   220: aload_2
    //   221: aload 5
    //   223: invokevirtual 254	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   226: pop
    //   227: goto -63 -> 164
    //   230: astore_1
    //   231: aload_0
    //   232: monitorexit
    //   233: sipush 13989
    //   236: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_1
    //   240: athrow
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_0
    //   244: getfield 88	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   247: ifnull +47 -> 294
    //   250: aload_0
    //   251: getfield 88	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   254: invokevirtual 260	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   257: checkcast 262	com/tencent/rtmp/ITXLivePushListener
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull +32 -> 294
    //   265: new 264	android/os/Bundle
    //   268: dup
    //   269: invokespecial 265	android/os/Bundle:<init>	()V
    //   272: astore_3
    //   273: aload_3
    //   274: ldc_w 267
    //   277: aload_1
    //   278: invokevirtual 271	org/json/JSONObject:toString	()Ljava/lang/String;
    //   281: invokevirtual 275	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_2
    //   285: sipush 1020
    //   288: aload_3
    //   289: invokeinterface 279 3 0
    //   294: sipush 13989
    //   297: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	WXLivePusher
    //   13	10	1	localJSONObject1	JSONObject
    //   111	10	1	localObject1	Object
    //   122	19	1	localException	Exception
    //   230	48	1	localObject2	Object
    //   21	264	2	localObject3	Object
    //   44	245	3	localObject4	Object
    //   63	149	4	str	String
    //   72	150	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   32	45	111	finally
    //   45	108	111	finally
    //   112	114	111	finally
    //   130	132	111	finally
    //   6	32	122	java/lang/Exception
    //   114	122	122	java/lang/Exception
    //   132	151	122	java/lang/Exception
    //   233	241	122	java/lang/Exception
    //   243	261	122	java/lang/Exception
    //   265	294	122	java/lang/Exception
    //   151	164	230	finally
    //   164	227	230	finally
    //   231	233	230	finally
    //   241	243	230	finally
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
    int i2 = 0;
    int i = 0;
    int i3 = 0;
    int j = 0;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject6 = "";
    int i4 = 0;
    int k = 0;
    int i1 = i4;
    Object localObject12 = localObject6;
    Object localObject11 = localObject5;
    Object localObject7 = localObject4;
    Object localObject8 = localObject3;
    Object localObject9 = localObject2;
    Object localObject10 = localObject1;
    int n = i3;
    int m = i2;
    for (;;)
    {
      Object localObject13;
      Object localObject14;
      Object localObject15;
      Object localObject16;
      Object localObject17;
      Object localObject18;
      int i5;
      try
      {
        String[] arrayOfString = paramString.split("[?&]");
        i1 = i4;
        localObject12 = localObject6;
        localObject11 = localObject5;
        localObject7 = localObject4;
        localObject8 = localObject3;
        localObject9 = localObject2;
        localObject10 = localObject1;
        n = i3;
        m = i2;
        int i6 = arrayOfString.length;
        i2 = 0;
        if (i2 < i6)
        {
          paramString = arrayOfString[i2];
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (paramString.indexOf("=") == -1) {
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          paramString = paramString.split("[=]");
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (paramString.length != 2) {
            break label4198;
          }
          localCharSequence = paramString[0];
          paramString = paramString[1];
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (TextUtils.isEmpty(localCharSequence)) {
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (TextUtils.isEmpty(paramString)) {
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("sdkappid"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            i5 = Integer.parseInt(paramString);
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
          }
          else
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (localCharSequence.equalsIgnoreCase("roomid"))
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              i4 = Long.valueOf(paramString).intValue();
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i5 = i;
            }
            else
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              if (localCharSequence.equalsIgnoreCase("userid"))
              {
                i3 = k;
                localObject13 = localObject6;
                localObject14 = localObject5;
                localObject15 = localObject4;
                localObject16 = localObject3;
                localObject17 = localObject2;
                localObject18 = paramString;
                i4 = j;
                i5 = i;
              }
              else
              {
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                if (localCharSequence.equalsIgnoreCase("usersig"))
                {
                  i3 = k;
                  localObject13 = localObject6;
                  localObject14 = localObject5;
                  localObject15 = localObject4;
                  localObject16 = localObject3;
                  localObject17 = paramString;
                  localObject18 = localObject1;
                  i4 = j;
                  i5 = i;
                }
                else
                {
                  i1 = k;
                  localObject12 = localObject6;
                  localObject11 = localObject5;
                  localObject7 = localObject4;
                  localObject8 = localObject3;
                  localObject9 = localObject2;
                  localObject10 = localObject1;
                  n = j;
                  m = i;
                  if (localCharSequence.equalsIgnoreCase("cloudenv"))
                  {
                    i1 = k;
                    localObject12 = localObject6;
                    localObject11 = localObject5;
                    localObject7 = localObject4;
                    localObject8 = localObject3;
                    localObject9 = localObject2;
                    localObject10 = localObject1;
                    n = j;
                    m = i;
                    if (paramString.equalsIgnoreCase("pro"))
                    {
                      i1 = k;
                      localObject12 = localObject6;
                      localObject11 = localObject5;
                      localObject7 = localObject4;
                      localObject8 = localObject3;
                      localObject9 = localObject2;
                      localObject10 = localObject1;
                      n = j;
                      m = i;
                      WXTRTCCloud.setNetEnv(0);
                      i3 = k;
                      localObject13 = localObject6;
                      localObject14 = localObject5;
                      localObject15 = localObject4;
                      localObject16 = localObject3;
                      localObject17 = localObject2;
                      localObject18 = localObject1;
                      i4 = j;
                      i5 = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        CharSequence localCharSequence;
        i = i1;
        localObject5 = localObject12;
        paramString = localObject11;
        j = n;
        localObject1 = localObject10;
        localObject2 = localObject9;
        localObject3 = localObject8;
        localObject4 = localObject7;
        if ((m == 0) || ((j == 0) && (TextUtils.isEmpty(paramString))) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          AppMethodBeat.o(13984);
          return false;
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (paramString.equalsIgnoreCase("dev"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            WXTRTCCloud.setNetEnv(1);
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (paramString.equalsIgnoreCase("uat"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            WXTRTCCloud.setNetEnv(2);
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (!paramString.equalsIgnoreCase("ccc")) {
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          WXTRTCCloud.setNetEnv(3);
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          break label4198;
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("encsmall"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            localObject13 = new TRTCCloudDef.TRTCVideoEncParam();
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            ((TRTCCloudDef.TRTCVideoEncParam)localObject13).videoResolution = 100;
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            ((TRTCCloudDef.TRTCVideoEncParam)localObject13).videoFps = 15;
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            ((TRTCCloudDef.TRTCVideoEncParam)localObject13).videoBitrate = 100;
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            ((TRTCCloudDef.TRTCVideoEncParam)localObject13).videoResolutionMode = 1;
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (Integer.parseInt(paramString) == 1)
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              this.mTRTCCloud.enableEncSmallVideoStream(true, (TRTCCloudDef.TRTCVideoEncParam)localObject13);
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i4 = j;
              i5 = i;
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            this.mTRTCCloud.enableEncSmallVideoStream(false, (TRTCCloudDef.TRTCVideoEncParam)localObject13);
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("enableblackstream"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            if (Integer.parseInt(paramString) != 1) {
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            this.mTRTCCloud.enableBlackStream(true);
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("appscene"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (paramString.equalsIgnoreCase("live"))
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              this.mAppScene = 1;
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i4 = j;
              i5 = i;
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (paramString.equalsIgnoreCase("videocall"))
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              this.mAppScene = 0;
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i4 = j;
              i5 = i;
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (paramString.equalsIgnoreCase("audiocall"))
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              this.mAppScene = 2;
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i4 = j;
              i5 = i;
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            if (paramString.equalsIgnoreCase("voicechatroom"))
            {
              i1 = k;
              localObject12 = localObject6;
              localObject11 = localObject5;
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              n = j;
              m = i;
              this.mAppScene = 3;
              i3 = k;
              localObject13 = localObject6;
              localObject14 = localObject5;
              localObject15 = localObject4;
              localObject16 = localObject3;
              localObject17 = localObject2;
              localObject18 = localObject1;
              i4 = j;
              i5 = i;
              break label4198;
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            this.mAppScene = 0;
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("recvmode"))
          {
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            i3 = Integer.parseInt(paramString);
            if (i3 != 1)
            {
              if (i3 == 2)
              {
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvAudio = true;
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvVideo = false;
                i3 = k;
                localObject13 = localObject6;
                localObject14 = localObject5;
                localObject15 = localObject4;
                localObject16 = localObject3;
                localObject17 = localObject2;
                localObject18 = localObject1;
                i4 = j;
                i5 = i;
                break label4198;
              }
              if (i3 == 3)
              {
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvAudio = false;
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvVideo = true;
                i3 = k;
                localObject13 = localObject6;
                localObject14 = localObject5;
                localObject15 = localObject4;
                localObject16 = localObject3;
                localObject17 = localObject2;
                localObject18 = localObject1;
                i4 = j;
                i5 = i;
                break label4198;
              }
              if (i3 == 4)
              {
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvAudio = false;
                i1 = k;
                localObject12 = localObject6;
                localObject11 = localObject5;
                localObject7 = localObject4;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                n = j;
                m = i;
                this.mAutoRecvVideo = false;
                i3 = k;
                localObject13 = localObject6;
                localObject14 = localObject5;
                localObject15 = localObject4;
                localObject16 = localObject3;
                localObject17 = localObject2;
                localObject18 = localObject1;
                i4 = j;
                i5 = i;
                break label4198;
              }
            }
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            this.mAutoRecvAudio = true;
            i1 = k;
            localObject12 = localObject6;
            localObject11 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            n = j;
            m = i;
            this.mAutoRecvVideo = true;
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("streamid"))
          {
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = paramString;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("userdefinerecordid"))
          {
            i3 = k;
            localObject13 = localObject6;
            localObject14 = localObject5;
            localObject15 = paramString;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("strroomid"))
          {
            i3 = k;
            localObject13 = localObject6;
            localObject14 = paramString;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          if (localCharSequence.equalsIgnoreCase("privatemapkey"))
          {
            i3 = k;
            localObject13 = paramString;
            localObject14 = localObject5;
            localObject15 = localObject4;
            localObject16 = localObject3;
            localObject17 = localObject2;
            localObject18 = localObject1;
            i4 = j;
            i5 = i;
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = k;
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          if (!localCharSequence.equalsIgnoreCase("pureaudiomode")) {
            break label4198;
          }
          i1 = k;
          localObject12 = localObject6;
          localObject11 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          n = j;
          m = i;
          i3 = Integer.parseInt(paramString);
          localObject13 = localObject6;
          localObject14 = localObject5;
          localObject15 = localObject4;
          localObject16 = localObject3;
          localObject17 = localObject2;
          localObject18 = localObject1;
          i4 = j;
          i5 = i;
          break label4198;
          paramString = (String)localObject5;
          m = i;
          i = k;
          localObject5 = localObject6;
          continue;
        }
        n = 0;
        k = n;
        if (!TextUtils.isEmpty(paramString))
        {
          k = n;
          if (j == 0) {
            k = 1;
          }
        }
        this.mTRTCParams.sdkAppId = m;
        localObject6 = this.mTRTCParams;
        if (k == 0) {
          break label4153;
        }
      }
      j = -1;
      ((TRTCCloudDef.TRTCParams)localObject6).roomId = j;
      this.mTRTCParams.userId = ((String)localObject1);
      this.mTRTCParams.userSig = ((String)localObject2);
      this.mTRTCParams.privateMapKey = ((String)localObject5);
      if ((this.mAppScene == 1) || (this.mAppScene == 3))
      {
        this.mNeedCheckRole = true;
        label3971:
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          break label4164;
        }
        j = 1;
        label3986:
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label4169;
        }
        m = 1;
        label4002:
        if ((i != 1) && (i != 2)) {
          break label4175;
        }
        n = 1;
        label4015:
        if ((j == 0) && (m == 0) && (k == 0) && (n == 0)) {
          break label4181;
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
              ((JSONObject)localObject2).put("pure_audio_push_mod", i);
            }
            ((JSONObject)localObject1).put("Str_uc_params", localObject2);
          }
          if (k != 0) {
            ((JSONObject)localObject1).put("strGroupId", paramString);
          }
          this.mTRTCParams.businessInfo = ((JSONObject)localObject1).toString();
        }
        catch (Exception paramString)
        {
          label4153:
          label4164:
          label4169:
          label4175:
          label4181:
          continue;
        }
        AppMethodBeat.o(13984);
        return true;
        break;
        this.mNeedCheckRole = false;
        break label3971;
        j = 0;
        break label3986;
        m = 0;
        break label4002;
        n = 0;
        break label4015;
        this.mTRTCParams.businessInfo = "";
      }
      label4198:
      i2 += 1;
      k = i3;
      localObject6 = localObject13;
      localObject5 = localObject14;
      localObject4 = localObject15;
      localObject3 = localObject16;
      localObject2 = localObject17;
      localObject1 = localObject18;
      j = i4;
      i = i5;
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
              break label789;
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
              break label794;
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
      label789:
      i = 0;
      continue;
      label794:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher
 * JD-Core Version:    0.7.0.1
 */