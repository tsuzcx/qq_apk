package com.tencent.trtc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.c;
import com.tencent.liteav.f;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WXTRTCCloud
  extends TRTCCloudImpl
{
  private static final String TAG = "WXTRTCCloud";
  private static WXTRTCCloud sInstance = null;
  private HashMap<String, a> mMapAudioVolumeListener;
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
    AppMethodBeat.i(193198);
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
      AppMethodBeat.o(193198);
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
    final TXCloudVideoView localTXCloudVideoView = this.mRoomInfo.localView;
    if (localTXCloudVideoView != null)
    {
      final CharSequence localCharSequence = getUploadStreamInfo();
      TXCLog.i("WXTRTCCloud", "[STATUS]" + localCharSequence.toString().replace("\n", ""));
      runOnMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(14287);
          localTXCloudVideoView.setDashBoardStatusInfo(localCharSequence);
          AppMethodBeat.o(14287);
        }
      });
    }
    this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction()
    {
      public final void accept(String paramAnonymousString, TRTCRoomInfo.UserInfo paramAnonymousUserInfo)
      {
        AppMethodBeat.i(182435);
        if ((paramAnonymousUserInfo.mainRender.render != null) && (paramAnonymousUserInfo.mainRender.render.isRendering())) {
          paramAnonymousUserInfo.mainRender.render.updateLoadInfo();
        }
        if ((paramAnonymousUserInfo.subRender.render != null) && (paramAnonymousUserInfo.subRender.render.isRendering())) {
          paramAnonymousUserInfo.subRender.render.updateLoadInfo();
        }
        WXTRTCCloud.access$4800(WXTRTCCloud.this, paramAnonymousUserInfo.mainRender.view, paramAnonymousUserInfo.mainRender.render, paramAnonymousUserInfo);
        WXTRTCCloud.access$4900(WXTRTCCloud.this, paramAnonymousUserInfo.subRender.view, paramAnonymousUserInfo.subRender.render, paramAnonymousUserInfo);
        AppMethodBeat.o(182435);
      }
    });
    AppMethodBeat.o(14341);
  }
  
  public void enableBlackStream(final boolean paramBoolean)
  {
    AppMethodBeat.i(193201);
    runOnMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14375);
        WXTRTCCloud.access$1400(WXTRTCCloud.this, "enableBlackStream " + paramBoolean);
        if (WXTRTCCloud.this.mCaptureAndEnc != null) {
          WXTRTCCloud.this.mCaptureAndEnc.b(paramBoolean);
        }
        AppMethodBeat.o(14375);
      }
    });
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14292);
        if (paramBoolean) {
          WXTRTCCloud.access$1800(WXTRTCCloud.this, WXTRTCCloud.this.mNativeRtcContext, 2);
        }
        AppMethodBeat.o(14292);
      }
    });
    AppMethodBeat.o(193201);
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
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14310);
        WXTRTCCloud.this.mMapAudioVolumeListener.clear();
        WXTRTCCloud.this.mMapLastUserVolumes.clear();
        WXTRTCCloud.this.mMapMainStreamPlayListener.clear();
        WXTRTCCloud.this.mMapSubStreamPlayListener.clear();
        AppMethodBeat.o(14310);
      }
    });
    AppMethodBeat.o(14314);
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(193199);
    int i = this.mCaptureAndEnc.r();
    AppMethodBeat.o(193199);
    return i;
  }
  
  public void notifyEvent(final String paramString, final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(14339);
    super.notifyEvent(paramString, paramInt, paramBundle);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14300);
        Object localObject;
        if ((TextUtils.isEmpty(paramString)) || ((WXTRTCCloud.this.mRoomInfo.userId != null) && (paramString.equalsIgnoreCase(WXTRTCCloud.this.mRoomInfo.userId))))
        {
          if (WXTRTCCloud.this.mPushListener != null)
          {
            localObject = (ITXLivePushListener)WXTRTCCloud.this.mPushListener.get();
            if (localObject != null) {
              ((ITXLivePushListener)localObject).onPushEvent(paramInt, paramBundle);
            }
            AppMethodBeat.o(14300);
          }
        }
        else
        {
          int i = paramBundle.getInt("EVT_STREAM_TYPE", 2);
          if (WXTRTCCloud.this.mRoomInfo.getUser(paramString) != null)
          {
            localObject = null;
            if (i != 7) {
              break label211;
            }
            if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(paramString)) {
              localObject = (WeakReference)WXTRTCCloud.this.mMapSubStreamPlayListener.get(paramString);
            }
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
            if (localObject != null) {
              ((ITXLivePlayListener)localObject).onPlayEvent(paramInt, paramBundle);
            }
          }
          AppMethodBeat.o(14300);
          return;
          label211:
          if (WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(paramString)) {
            localObject = (WeakReference)WXTRTCCloud.this.mMapMainStreamPlayListener.get(paramString);
          }
        }
      }
    });
    AppMethodBeat.o(14339);
  }
  
  public void notifySEIMessage(final String paramString, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14342);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14290);
        Object localObject;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
        {
          localObject = null;
          if (!WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(paramString)) {
            break label114;
          }
          localObject = (WeakReference)WXTRTCCloud.this.mMapMainStreamPlayListener.get(paramString);
        }
        for (;;)
        {
          if (localObject != null)
          {
            localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
            if (localObject != null)
            {
              Bundle localBundle = new Bundle();
              localBundle.putByteArray("EVT_GET_MSG", paramArrayOfByte);
              ((ITXLivePlayListener)localObject).onPlayEvent(2012, localBundle);
            }
          }
          AppMethodBeat.o(14290);
          return;
          label114:
          if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(paramString)) {
            localObject = (WeakReference)WXTRTCCloud.this.mMapSubStreamPlayListener.get(paramString);
          }
        }
      }
    });
    AppMethodBeat.o(14342);
  }
  
  public void notifyStatistics(final TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(14340);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14303);
        String str1 = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(paramTRTCStatistics.appCpu), Integer.valueOf(paramTRTCStatistics.systemCpu) });
        String str2 = TXCStatus.b("18446744073709551615", 10001);
        Object localObject1 = paramTRTCStatistics.localArray.iterator();
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int j;
        Object localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TRTCStatistics.TRTCLocalStatistics)((Iterator)localObject1).next();
          if (((TRTCStatistics.TRTCLocalStatistics)localObject2).streamType == 0)
          {
            k = ((TRTCStatistics.TRTCLocalStatistics)localObject2).width;
            m = ((TRTCStatistics.TRTCLocalStatistics)localObject2).height;
            n = ((TRTCStatistics.TRTCLocalStatistics)localObject2).frameRate;
            i1 = ((TRTCStatistics.TRTCLocalStatistics)localObject2).videoBitrate;
            i2 = ((TRTCStatistics.TRTCLocalStatistics)localObject2).audioBitrate;
            i3 = WXTRTCCloud.access$4400(WXTRTCCloud.this, paramTRTCStatistics.rtt, paramTRTCStatistics.upLoss);
            i = 0;
            if (WXTRTCCloud.this.mAppScene == 1)
            {
              j = TXCStatus.c("18446744073709551615", 4006);
              i = j;
              if (n > 0) {
                i = (int)(j * 10 / n / 10.0F + 0.5D);
              }
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("CPU_USAGE", str1);
            ((Bundle)localObject2).putInt("VIDEO_WIDTH", k);
            ((Bundle)localObject2).putInt("VIDEO_HEIGHT", m);
            ((Bundle)localObject2).putInt("VIDEO_FPS", n);
            ((Bundle)localObject2).putInt("VIDEO_GOP", i);
            ((Bundle)localObject2).putInt("NET_SPEED", i2 + i1);
            ((Bundle)localObject2).putInt("VIDEO_BITRATE", i1);
            ((Bundle)localObject2).putInt("AUDIO_BITRATE", i2);
            ((Bundle)localObject2).putString("AUDIO_PLAY_INFO", "");
            ((Bundle)localObject2).putString("SERVER_IP", str2);
            ((Bundle)localObject2).putInt("NET_QUALITY_LEVEL", i3);
            if (WXTRTCCloud.this.mPushListener != null)
            {
              localObject3 = (ITXLivePushListener)WXTRTCCloud.this.mPushListener.get();
              if (localObject3 != null) {
                ((ITXLivePushListener)localObject3).onNetStatus((Bundle)localObject2);
              }
            }
          }
        }
        Object localObject2 = paramTRTCStatistics.remoteArray.iterator();
        String str3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (TRTCStatistics.TRTCRemoteStatistics)((Iterator)localObject2).next();
          i1 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).streamType;
          str3 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).userId;
          i2 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).width;
          i3 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).height;
          i4 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).frameRate;
          i5 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).videoBitrate;
          i6 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).audioBitrate;
          m = 0;
          k = 0;
          j = 0;
          i7 = WXTRTCCloud.access$4600(WXTRTCCloud.this, paramTRTCStatistics.rtt, ((TRTCStatistics.TRTCRemoteStatistics)localObject1).finalLoss);
          localObject1 = WXTRTCCloud.this.mRoomInfo.getUser(str3);
          if (localObject1 == null) {
            break label844;
          }
          i = 2;
          switch (i1)
          {
          default: 
            label512:
            m = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 2007);
            k = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6010, i);
            n = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6011, i);
            j = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6012, i);
          }
        }
        label844:
        for (int i = n;; i = 0)
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("CPU_USAGE", str1);
          ((Bundle)localObject3).putInt("VIDEO_WIDTH", i2);
          ((Bundle)localObject3).putInt("VIDEO_HEIGHT", i3);
          ((Bundle)localObject3).putInt("VIDEO_FPS", i4);
          ((Bundle)localObject3).putInt("NET_SPEED", i6 + i5);
          ((Bundle)localObject3).putInt("VIDEO_BITRATE", i5);
          ((Bundle)localObject3).putInt("AUDIO_BITRATE", i6);
          ((Bundle)localObject3).putInt("AUDIO_CACHE", m);
          ((Bundle)localObject3).putInt("VIDEO_CACHE", k);
          ((Bundle)localObject3).putInt("V_SUM_CACHE_SIZE", i);
          ((Bundle)localObject3).putInt("V_DEC_CACHE_SIZE", j);
          ((Bundle)localObject3).putString("AUDIO_PLAY_INFO", "");
          ((Bundle)localObject3).putString("SERVER_IP", str2);
          ((Bundle)localObject3).putInt("NET_QUALITY_LEVEL", i7);
          localObject1 = null;
          if (i1 == 2) {
            if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(str3)) {
              localObject1 = (WeakReference)WXTRTCCloud.this.mMapSubStreamPlayListener.get(str3);
            }
          }
          while (localObject1 != null)
          {
            localObject1 = (ITXLivePlayListener)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              break;
            }
            ((ITXLivePlayListener)localObject1).onNetStatus((Bundle)localObject3);
            break;
            i = 2;
            break label512;
            i = 3;
            break label512;
            i = 7;
            break label512;
            if (WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(str3)) {
              localObject1 = (WeakReference)WXTRTCCloud.this.mMapMainStreamPlayListener.get(str3);
            }
          }
          AppMethodBeat.o(14303);
          return;
        }
      }
    });
    AppMethodBeat.o(14340);
  }
  
  public void notifyUserVoiceVolume(final ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(193202);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14294);
        Object localObject1 = new ArrayList();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          if (WXTRTCCloud.this.mMapLastUserVolumes.size() > 0)
          {
            localObject2 = WXTRTCCloud.this.mMapLastUserVolumes.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localObject4 = new TRTCCloudDef.TRTCVolumeInfo();
              ((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId = ((String)localObject3);
              ((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume = 0;
              ((ArrayList)localObject1).add(localObject4);
            }
            WXTRTCCloud.this.mMapLastUserVolumes.clear();
          }
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        label131:
        label497:
        for (;;)
        {
          int i;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject2).next();
            localObject3 = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).userId;
            i = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).volume;
            if (!WXTRTCCloud.this.mMapAudioVolumeListener.keySet().contains(localObject3)) {
              continue;
            }
            localObject1 = (WXTRTCCloud.a)WXTRTCCloud.this.mMapAudioVolumeListener.get(localObject3);
            if ((localObject1 == null) || (i == ((WXTRTCCloud.a)localObject1).a)) {
              continue;
            }
            ((WXTRTCCloud.a)localObject1).a = i;
            if (((WXTRTCCloud.a)localObject1).Kuz != null) {
              localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((WXTRTCCloud.a)localObject1).Kuz.get();
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label497;
            }
            ((WXTRTCCloud.ITXAudioVolumeEvaluationListener)localObject1).onAudioVolumeEvaluationNotify(i);
            break label131;
            localObject3 = paramArrayList;
            Collections.sort((List)localObject3, new Comparator() {});
            localObject2 = new HashMap();
            localObject3 = ((ArrayList)localObject3).iterator();
            int j;
            for (i = 0; ((Iterator)localObject3).hasNext(); i = j)
            {
              localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
              if (i >= 10) {
                break;
              }
              j = i;
              if (((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume > 10)
              {
                j = i + 1;
                ((HashMap)localObject2).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
                ((ArrayList)localObject1).add(localObject4);
              }
            }
            localObject3 = WXTRTCCloud.this.mMapLastUserVolumes.keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              if (!((HashMap)localObject2).containsKey(localObject4))
              {
                TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                localTRTCVolumeInfo.userId = ((String)localObject4);
                localTRTCVolumeInfo.volume = 0;
                ((ArrayList)localObject1).add(localTRTCVolumeInfo);
              }
            }
            WXTRTCCloud.this.mMapLastUserVolumes.clear();
            WXTRTCCloud.this.mMapLastUserVolumes.putAll((Map)localObject2);
            break;
            if (((WXTRTCCloud.a)localObject1).c != null)
            {
              localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((WXTRTCCloud.a)localObject1).c.get();
              continue;
              AppMethodBeat.o(14294);
            }
            else
            {
              localObject1 = null;
            }
          }
        }
      }
    });
    AppMethodBeat.o(193202);
  }
  
  public void pausePusher()
  {
    AppMethodBeat.i(14319);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160399);
        WXTRTCCloud.access$800(WXTRTCCloud.this, "pausePusher");
        if (WXTRTCCloud.this.mCaptureAndEnc != null) {
          WXTRTCCloud.this.mCaptureAndEnc.g();
        }
        AppMethodBeat.o(160399);
      }
    });
    AppMethodBeat.o(14319);
  }
  
  public void registerAudioVolumeEvaluationListener(final String paramString, final boolean paramBoolean, final WXTRTCCloud.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(182436);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14306);
        WXTRTCCloud.a locala;
        if (WXTRTCCloud.this.mMapAudioVolumeListener.containsKey(paramString))
        {
          locala = (WXTRTCCloud.a)WXTRTCCloud.this.mMapAudioVolumeListener.get(paramString);
          if (locala != null)
          {
            if (!paramBoolean) {
              break label107;
            }
            locala.c = new WeakReference(paramITXAudioVolumeEvaluationListener);
          }
        }
        for (;;)
        {
          WXTRTCCloud.this.mMapAudioVolumeListener.put(paramString, locala);
          AppMethodBeat.o(14306);
          return;
          locala = new WXTRTCCloud.a((byte)0);
          locala.a = 0;
          break;
          label107:
          locala.Kuz = new WeakReference(paramITXAudioVolumeEvaluationListener);
        }
      }
    });
    AppMethodBeat.o(182436);
  }
  
  public void registerPlayListener(final String paramString, final boolean paramBoolean, final ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14337);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14293);
        if (paramBoolean)
        {
          WXTRTCCloud.this.mMapSubStreamPlayListener.put(paramString, new WeakReference(paramITXLivePlayListener));
          AppMethodBeat.o(14293);
          return;
        }
        WXTRTCCloud.this.mMapMainStreamPlayListener.put(paramString, new WeakReference(paramITXLivePlayListener));
        AppMethodBeat.o(14293);
      }
    });
    AppMethodBeat.o(14337);
  }
  
  public void resumePusher()
  {
    AppMethodBeat.i(14320);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14305);
        WXTRTCCloud.access$1100(WXTRTCCloud.this, "resumePusher");
        if (WXTRTCCloud.this.mCaptureAndEnc != null) {
          WXTRTCCloud.this.mCaptureAndEnc.h();
        }
        AppMethodBeat.o(14305);
      }
    });
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
    AppMethodBeat.i(193200);
    this.mCaptureAndEnc.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(193200);
  }
  
  public void setLocalSurface(final Surface paramSurface)
  {
    AppMethodBeat.i(14317);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14302);
        WXTRTCCloud.access$400(WXTRTCCloud.this, "setLocalSurface " + paramSurface);
        WXTRTCCloud.this.mCaptureAndEnc.a(paramSurface);
        AppMethodBeat.o(14302);
      }
    });
    AppMethodBeat.o(14317);
  }
  
  public void setLocalSurfaceSize(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(14318);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14308);
        WXTRTCCloud.access$600(WXTRTCCloud.this, "setLocalSurfaceSize: " + paramInt1 + "," + paramInt2);
        WXTRTCCloud.this.mCaptureAndEnc.a(paramInt1, paramInt2);
        AppMethodBeat.o(14308);
      }
    });
    AppMethodBeat.o(14318);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(193203);
    this.mPushListener = new WeakReference(paramITXLivePushListener);
    AppMethodBeat.o(193203);
  }
  
  public void setRemoteSubStreamSurface(final String paramString, final Surface paramSurface)
  {
    AppMethodBeat.i(14324);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14289);
        WXTRTCCloud.access$2900(WXTRTCCloud.this, "setRemoteSubStreamSurface " + paramString + ", " + paramSurface);
        Object localObject = WXTRTCCloud.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
          if (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((e)localObject).a(paramSurface);
              AppMethodBeat.o(14289);
              return;
            }
            WXTRTCCloud.access$3100(WXTRTCCloud.this, "videoRender no exist");
            AppMethodBeat.o(14289);
            return;
          }
          WXTRTCCloud.access$3200(WXTRTCCloud.this, "render no exist");
          AppMethodBeat.o(14289);
          return;
        }
        WXTRTCCloud.access$3300(WXTRTCCloud.this, "user no exist");
        AppMethodBeat.o(14289);
      }
    });
    AppMethodBeat.o(14324);
  }
  
  public void setRemoteSubStreamSurfaceSize(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(14325);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14307);
        WXTRTCCloud.access$3400(WXTRTCCloud.this, "seRemoteSubStreamSurfaceSize: " + paramString + ", " + paramInt1 + "," + paramInt2);
        Object localObject = WXTRTCCloud.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
          if (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((e)localObject).c(paramInt1, paramInt2);
              AppMethodBeat.o(14307);
              return;
            }
            WXTRTCCloud.access$3600(WXTRTCCloud.this, "videoRender no exist");
            AppMethodBeat.o(14307);
            return;
          }
          WXTRTCCloud.access$3700(WXTRTCCloud.this, "render no exist");
          AppMethodBeat.o(14307);
          return;
        }
        WXTRTCCloud.access$3800(WXTRTCCloud.this, "user no exist");
        AppMethodBeat.o(14307);
      }
    });
    AppMethodBeat.o(14325);
  }
  
  public void setRemoteSurface(final String paramString, final Surface paramSurface)
  {
    AppMethodBeat.i(14322);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14304);
        WXTRTCCloud.access$1900(WXTRTCCloud.this, "setRemoteSurface " + paramString + ", " + paramSurface);
        Object localObject = WXTRTCCloud.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
          if (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((e)localObject).a(paramSurface);
              AppMethodBeat.o(14304);
              return;
            }
            WXTRTCCloud.access$2100(WXTRTCCloud.this, "videoRender no exist");
            AppMethodBeat.o(14304);
            return;
          }
          WXTRTCCloud.access$2200(WXTRTCCloud.this, "render no exist");
          AppMethodBeat.o(14304);
          return;
        }
        WXTRTCCloud.access$2300(WXTRTCCloud.this, "user no exist");
        AppMethodBeat.o(14304);
      }
    });
    AppMethodBeat.o(14322);
  }
  
  public void setRemoteSurfaceSize(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(14323);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14378);
        WXTRTCCloud.access$2400(WXTRTCCloud.this, "seRemoteSurfaceSize: " + paramString + ", " + paramInt1 + "," + paramInt2);
        Object localObject = WXTRTCCloud.this.mRoomInfo.getUser(paramString);
        if (localObject != null)
        {
          localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
          if (localObject != null)
          {
            localObject = ((TXCRenderAndDec)localObject).getVideoRender();
            if (localObject != null)
            {
              ((e)localObject).c(paramInt1, paramInt2);
              AppMethodBeat.o(14378);
              return;
            }
            WXTRTCCloud.access$2600(WXTRTCCloud.this, "videoRender no exist");
            AppMethodBeat.o(14378);
            return;
          }
          WXTRTCCloud.access$2700(WXTRTCCloud.this, "render no exist");
          AppMethodBeat.o(14378);
          return;
        }
        WXTRTCCloud.access$2800(WXTRTCCloud.this, "user no exist");
        AppMethodBeat.o(14378);
      }
    });
    AppMethodBeat.o(14323);
  }
  
  public void startLocalAudio()
  {
    AppMethodBeat.i(14315);
    this.mEnableEosMode = true;
    super.startLocalAudio();
    AppMethodBeat.o(14315);
  }
  
  public void unregisterAudioVolumeEvaluationListener(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(182437);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14296);
        if (WXTRTCCloud.this.mMapAudioVolumeListener.containsKey(paramString))
        {
          WXTRTCCloud.a locala = (WXTRTCCloud.a)WXTRTCCloud.this.mMapAudioVolumeListener.get(paramString);
          if (locala != null)
          {
            if (paramBoolean) {
              locala.c = null;
            }
            while ((locala.Kuz == null) && (locala.c == null))
            {
              WXTRTCCloud.this.mMapAudioVolumeListener.remove(paramString);
              AppMethodBeat.o(14296);
              return;
              locala.Kuz = null;
            }
          }
          WXTRTCCloud.this.mMapAudioVolumeListener.remove(paramString);
        }
        AppMethodBeat.o(14296);
      }
    });
    AppMethodBeat.o(182437);
  }
  
  public void unregisterPlayListener(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(14338);
    runOnSDKThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14309);
        if (paramBoolean)
        {
          WXTRTCCloud.this.mMapSubStreamPlayListener.remove(paramString);
          AppMethodBeat.o(14309);
          return;
        }
        WXTRTCCloud.this.mMapMainStreamPlayListener.remove(paramString);
        AppMethodBeat.o(14309);
      }
    });
    AppMethodBeat.o(14338);
  }
  
  static final class a
  {
    public WeakReference<WXTRTCCloud.ITXAudioVolumeEvaluationListener> Kuz = null;
    public int a;
    public WeakReference<WXTRTCCloud.ITXAudioVolumeEvaluationListener> c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud
 * JD-Core Version:    0.7.0.1
 */