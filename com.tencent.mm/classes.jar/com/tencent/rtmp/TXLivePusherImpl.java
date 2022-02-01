package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl.TXAudioEffectManagerListener;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.d.a;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;
import com.tencent.liteav.e;
import com.tencent.liteav.m;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.j;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONObject;

public class TXLivePusherImpl
  implements com.tencent.liteav.audio.g, b, d.a, com.tencent.liteav.qos.a
{
  private static final String d;
  private HashMap<Integer, Long> A;
  private TXDeviceManagerImpl B;
  private int C;
  private ArrayList<b> D;
  private TXLivePusher.ITXAudioVolumeEvaluationListener E;
  private int F;
  private com.tencent.liteav.basic.c.a G;
  private final m H;
  private com.tencent.liteav.audio.h I;
  private a J;
  private Runnable K;
  private com.tencent.liteav.muxer.c L;
  private boolean M;
  private String N;
  private long O;
  private boolean P;
  private TXRecordCommon.ITXVideoRecordListener Q;
  private boolean R;
  TXLivePusher.OnBGMNotify a;
  final TXAudioEffectManager.TXVoiceReverbType[] b;
  final TXAudioEffectManager.TXVoiceChangerType[] c;
  private TXCloudVideoView e;
  private TXLivePushConfig f;
  private ITXLivePushListener g;
  private int h;
  private TXLivePusher.VideoCustomProcessListener i;
  private TXLivePusher.AudioCustomProcessListener j;
  private com.tencent.liteav.g k;
  private d l;
  private TXCStreamUploader m;
  private Context n;
  private Handler o;
  private TXCQoS p;
  private e q;
  private String r;
  private String s;
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private boolean y;
  private HashSet<String> z;
  
  static
  {
    AppMethodBeat.i(218565);
    d = TXLivePusherImpl.class.getSimpleName();
    AppMethodBeat.o(218565);
  }
  
  public TXLivePusherImpl(Context paramContext)
  {
    AppMethodBeat.i(218477);
    this.f = null;
    this.g = null;
    this.h = -1;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = "";
    this.s = "";
    this.t = false;
    this.u = -1;
    this.v = -1;
    this.w = false;
    this.x = false;
    this.y = false;
    this.z = new HashSet();
    this.A = new HashMap();
    this.C = 0;
    this.b = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.c = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.D = new ArrayList();
    this.E = null;
    this.F = 0;
    this.G = new com.tencent.liteav.basic.c.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(218473);
        TXCLog.e(TXLivePusherImpl.w(), "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        if (TXLivePusherImpl.a(TXLivePusherImpl.this) != null)
        {
          paramAnonymousString1 = new Bundle();
          paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
          paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          paramAnonymousString1.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
          if (paramAnonymousString2 != null)
          {
            paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label149;
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          TXLivePusherImpl.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(218473);
          return;
          label149:
          paramAnonymousString3 = "";
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(218469);
        TXCLog.i(TXLivePusherImpl.w(), "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        if (TXLivePusherImpl.a(TXLivePusherImpl.this) != null)
        {
          paramAnonymousString1 = new Bundle();
          paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
          paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          paramAnonymousString1.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
          if (paramAnonymousString2 != null)
          {
            paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label149;
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          TXLivePusherImpl.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(218469);
          return;
          label149:
          paramAnonymousString3 = "";
        }
      }
      
      public void onWarning(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(218472);
        TXCLog.i(TXLivePusherImpl.w(), "onWarning => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        if (TXLivePusherImpl.a(TXLivePusherImpl.this) != null)
        {
          paramAnonymousString1 = new Bundle();
          paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
          paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          if (paramAnonymousString2 != null)
          {
            paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
            if (paramAnonymousString3 == null) {
              break label140;
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          TXLivePusherImpl.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(218472);
          return;
          label140:
          paramAnonymousString3 = "";
        }
      }
    };
    this.H = new m()
    {
      public void onGLContextCreated() {}
      
      public void onGLContextReadyToDestory()
      {
        AppMethodBeat.i(218460);
        if (TXLivePusherImpl.b(TXLivePusherImpl.this) != null) {
          TXLivePusherImpl.b(TXLivePusherImpl.this).onTextureDestoryed();
        }
        AppMethodBeat.o(218460);
      }
      
      public int onProcessVideoFrame(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(218456);
        if (TXLivePusherImpl.b(TXLivePusherImpl.this) != null)
        {
          paramAnonymousInt1 = TXLivePusherImpl.b(TXLivePusherImpl.this).onTextureCustomProcess(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          AppMethodBeat.o(218456);
          return paramAnonymousInt1;
        }
        AppMethodBeat.o(218456);
        return paramAnonymousInt1;
      }
    };
    this.I = new com.tencent.liteav.audio.h()
    {
      public void onPlayEnd(int paramAnonymousInt)
      {
        AppMethodBeat.i(218455);
        if (TXLivePusherImpl.this.a != null) {
          TXLivePusherImpl.this.a.onBGMComplete(paramAnonymousInt);
        }
        AppMethodBeat.o(218455);
      }
      
      public void onPlayProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(218459);
        if (TXLivePusherImpl.this.a != null) {
          TXLivePusherImpl.this.a.onBGMProgress(paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(218459);
      }
      
      public void onPlayStart()
      {
        AppMethodBeat.i(218450);
        if (TXLivePusherImpl.this.a != null) {
          TXLivePusherImpl.this.a.onBGMStart();
        }
        AppMethodBeat.o(218450);
      }
    };
    this.J = null;
    this.K = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218452);
        TXLivePusherImpl.a(TXLivePusherImpl.this, false);
        AppMethodBeat.o(218452);
      }
    };
    this.L = null;
    this.M = false;
    this.N = "";
    this.O = 0L;
    this.P = false;
    this.R = false;
    this.f = new TXLivePushConfig();
    this.k = new com.tencent.liteav.g();
    this.n = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.n);
    TXCLog.init();
    this.o = new Handler(Looper.getMainLooper());
    com.tencent.liteav.basic.d.c.a().a(this.n);
    TXCAudioEngine.CreateInstance(this.n, Q());
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.G));
    long l1 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.l = new d(this.n);
    this.l.e(true);
    this.l.a(this);
    LicenceCheck.a().a(null, this.n);
    TXCTimeUtil.initAppStartTime();
    this.A.put(Integer.valueOf(-1303), Long.valueOf(0L));
    this.A.put(Integer.valueOf(1101), Long.valueOf(0L));
    this.A.put(Integer.valueOf(1006), Long.valueOf(0L));
    this.B = new TXDeviceManagerImpl(this.o);
    this.B.setCaptureAndEnc(this.l);
    this.B.setDeviceManagerListener(new TXDeviceManagerImpl.TXDeviceManagerListener()
    {
      public void onSwitchAutoFocus(boolean paramAnonymousBoolean)
      {
        boolean bool2 = true;
        AppMethodBeat.i(218461);
        Object localObject = TXLivePusherImpl.c(TXLivePusherImpl.this);
        boolean bool1;
        if (!paramAnonymousBoolean)
        {
          bool1 = true;
          ((com.tencent.liteav.g)localObject).L = bool1;
          localObject = TXLivePusherImpl.d(TXLivePusherImpl.this);
          if (paramAnonymousBoolean) {
            break label60;
          }
        }
        label60:
        for (paramAnonymousBoolean = bool2;; paramAnonymousBoolean = false)
        {
          ((TXLivePushConfig)localObject).mTouchFocus = paramAnonymousBoolean;
          AppMethodBeat.o(218461);
          return;
          bool1 = false;
          break;
        }
      }
      
      public void onSwitchCamera(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218453);
        TXLivePusherImpl.c(TXLivePusherImpl.this).n = paramAnonymousBoolean;
        TXLivePusherImpl.d(TXLivePusherImpl.this).mFrontCamera = paramAnonymousBoolean;
        AppMethodBeat.o(218453);
      }
      
      public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramAnonymousTXSystemVolumeType)
      {
        AppMethodBeat.i(218466);
        switch (TXLivePusherImpl.9.a[paramAnonymousTXSystemVolumeType.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218466);
          return;
          TXLivePusherImpl.c(TXLivePusherImpl.this).y = 0;
          TXLivePusherImpl.d(TXLivePusherImpl.this).mVolumeType = 0;
          AppMethodBeat.o(218466);
          return;
          TXLivePusherImpl.c(TXLivePusherImpl.this).y = 2;
          TXLivePusherImpl.d(TXLivePusherImpl.this).mVolumeType = 2;
          AppMethodBeat.o(218466);
          return;
          TXLivePusherImpl.c(TXLivePusherImpl.this).y = 1;
          TXLivePusherImpl.d(TXLivePusherImpl.this).mVolumeType = 1;
        }
      }
    });
    TXAudioEffectManagerImpl.getAutoCacheHolder().setAudioEffectManagerListener(new TXAudioEffectManagerImpl.TXAudioEffectManagerListener()
    {
      public void onSwitchVoiceEarMonitor(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218451);
        TXLivePusherImpl.d(TXLivePusherImpl.this).mEnableAudioPreview = paramAnonymousBoolean;
        AppMethodBeat.o(218451);
      }
    });
    AppMethodBeat.o(218477);
  }
  
  private void A()
  {
    AppMethodBeat.i(218491);
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.h.a(this.f.mAudioSample, this.f.mAudioChannels, 2);
    if (this.L != null) {
      this.L.b(localMediaFormat);
    }
    AppMethodBeat.o(218491);
  }
  
  private void B()
  {
    AppMethodBeat.i(218498);
    this.R = true;
    if (this.o != null) {
      this.o.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(218464);
          if (TXLivePusherImpl.k(TXLivePusherImpl.this)) {
            TXLivePusherImpl.l(TXLivePusherImpl.this);
          }
          AppMethodBeat.o(218464);
        }
      }, 2000L);
    }
    AppMethodBeat.o(218498);
  }
  
  private void C()
  {
    this.R = false;
  }
  
  private void D()
  {
    AppMethodBeat.i(218499);
    com.tencent.liteav.a.a(this.s, null);
    AppMethodBeat.o(218499);
  }
  
  private void E()
  {
    AppMethodBeat.i(218501);
    D();
    Object localObject1 = com.tencent.liteav.basic.util.h.a();
    int i1 = localObject1[0] / 10;
    int i2 = localObject1[1] / 10;
    localObject1 = i1 + "/" + i2 + "%";
    i1 = TXCStatus.c(this.s, 7004);
    i2 = TXCStatus.c(this.s, 7003);
    int i3 = TXCStatus.c(this.s, 7002);
    int i4 = TXCStatus.c(this.s, 7001);
    int i5 = TXCStatus.c(this.s, 7007);
    int i6 = TXCStatus.c(this.s, 7005);
    int i7 = TXCStatus.c(this.s, 7006);
    Object localObject2 = TXCStatus.b(this.s, 7012);
    double d2 = TXCStatus.d(this.s, 4001);
    int i8 = TXCStatus.c(this.s, 4006);
    Bundle localBundle = new Bundle();
    localBundle.putInt("NET_SPEED", i1 + i2);
    localBundle.putInt("VIDEO_FPS", (int)d2);
    double d1 = d2;
    if (d2 < 1.0D) {
      d1 = 15.0D;
    }
    localBundle.putInt("VIDEO_GOP", (int)(i8 * 10 / (int)d1 / 10.0F + 0.5D));
    localBundle.putInt("VIDEO_DROP", i5);
    localBundle.putInt("VIDEO_BITRATE", i4);
    localBundle.putInt("AUDIO_BITRATE", i3);
    localBundle.putInt("AUDIO_CACHE", i7);
    localBundle.putInt("VIDEO_CACHE", i6);
    localBundle.putCharSequence("SERVER_IP", (CharSequence)localObject2);
    localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject1);
    if (this.l != null)
    {
      localBundle.putString("AUDIO_PLAY_INFO", TXCAudioEngine.getInstance().getAECType() + " | " + this.f.mAudioSample + " , " + this.f.mAudioChannels);
      localBundle.putInt("VIDEO_WIDTH", this.l.d());
      localBundle.putInt("VIDEO_HEIGHT", this.l.e());
    }
    if (this.e != null) {
      this.e.setLogText(localBundle, null, 0);
    }
    if (this.g != null) {
      this.g.onNetStatus(localBundle);
    }
    if (this.q != null) {
      this.q.e();
    }
    i2 = com.tencent.liteav.basic.util.h.e(this.n);
    if (com.tencent.liteav.basic.util.h.a(this.n))
    {
      i1 = 1;
      if (this.u != i2)
      {
        g("statusNotify: " + String.format("Network: net type change from %s to %s", new Object[] { g(this.u), g(i2) }));
        this.u = i2;
      }
      if (this.v != i1)
      {
        localObject2 = new StringBuilder("statusNotify: ");
        if (i1 != 1) {
          break label671;
        }
      }
    }
    label671:
    for (localObject1 = "background";; localObject1 = "foreground")
    {
      g(String.format("app: switch to %s", new Object[] { localObject1 }));
      this.v = i1;
      if ((this.o != null) && (this.R)) {
        this.o.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(218463);
            if (TXLivePusherImpl.k(TXLivePusherImpl.this)) {
              TXLivePusherImpl.l(TXLivePusherImpl.this);
            }
            AppMethodBeat.o(218463);
          }
        }, 2000L);
      }
      AppMethodBeat.o(218501);
      return;
      i1 = 0;
      break;
    }
  }
  
  private void F()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(218502);
    j localj = new j();
    localj.d = this.f.mAudioChannels;
    localj.e = this.f.mAudioSample;
    localj.a = 0;
    localj.c = 20;
    localj.b = 0;
    localj.f = 3;
    localj.j = true;
    localj.l = true;
    localj.k = false;
    localj.h = 40;
    localj.i = 5000;
    localj.m = this.k.Q;
    localj.n = this.k.R;
    localj.o = i(this.h);
    this.m = new TXCStreamUploader(this.n, localj);
    this.m.setID(this.s);
    this.m.setMetaData(this.f.mMetaData);
    if (this.m != null) {
      this.m.setAudioInfo(this.k.t, this.k.u);
    }
    this.m.setNotifyListener(this);
    if (this.k.N) {
      this.m.setAudioMute(this.x);
    }
    this.r = this.m.start(this.r, this.k.O, this.k.P);
    if (this.k.N) {
      this.m.setMode(1);
    }
    int i4;
    int i3;
    if (this.k.Q)
    {
      i4 = this.k.r;
      i3 = this.k.s;
      if (i4 < 5)
      {
        if (i3 <= 1) {
          break label390;
        }
        label322:
        this.m.setRetryInterval(i2);
        this.m.setRetryTimes(i1);
        this.m.setVideoDropParams(false, this.k.i, 1000);
      }
    }
    for (;;)
    {
      this.m.setSendStrategy(this.k.Q, this.k.R);
      AppMethodBeat.o(218502);
      return;
      i1 = i4;
      break;
      label390:
      i2 = i3;
      break label322;
      this.m.setRetryInterval(this.k.s);
      this.m.setRetryTimes(this.k.r);
      this.m.setVideoDropParams(true, 40, 3000);
    }
  }
  
  private void G()
  {
    AppMethodBeat.i(218503);
    if (this.m != null)
    {
      this.m.stop();
      this.m.setNotifyListener(null);
      this.m = null;
    }
    AppMethodBeat.o(218503);
  }
  
  private void H()
  {
    AppMethodBeat.i(218504);
    this.p = new TXCQoS(true);
    this.p.setListener(this);
    this.p.setNotifyListener(this);
    this.p.setAutoAdjustBitrate(this.k.g);
    this.p.setAutoAdjustStrategy(this.k.f);
    this.p.setDefaultVideoResolution(this.k.l);
    this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
    if (this.k.g) {
      this.p.start(2000L);
    }
    AppMethodBeat.o(218504);
  }
  
  private void I()
  {
    AppMethodBeat.i(218505);
    if (this.p != null)
    {
      this.p.stop();
      this.p.setListener(null);
      this.p.setNotifyListener(null);
      this.p = null;
    }
    AppMethodBeat.o(218505);
  }
  
  private void J()
  {
    AppMethodBeat.i(218506);
    this.q = new e(this.n);
    this.q.d(this.s);
    this.q.a(this.k.c);
    this.q.b(this.k.t);
    this.q.a(this.k.a, this.k.b);
    this.q.a(this.r);
    this.q.a();
    AppMethodBeat.o(218506);
  }
  
  private void K()
  {
    AppMethodBeat.i(218507);
    if (this.q != null)
    {
      this.q.b();
      this.q = null;
    }
    AppMethodBeat.o(218507);
  }
  
  private void L()
  {
    AppMethodBeat.i(218508);
    if (this.l != null)
    {
      this.l.setID(this.s);
      this.l.a(this);
      this.l.k(this.y);
      TXCLog.i(d, "start encoder in h265:" + this.y);
      this.l.f();
    }
    AppMethodBeat.o(218508);
  }
  
  private void M()
  {
    AppMethodBeat.i(218509);
    if (this.l != null)
    {
      this.l.a(null);
      this.l.g();
      this.l.a(null);
    }
    AppMethodBeat.o(218509);
  }
  
  private void N()
  {
    boolean bool2 = false;
    AppMethodBeat.i(218510);
    TXCAudioEngine.getInstance().setEncoderSampleRate(this.f.mAudioSample);
    TXCAudioEngine.getInstance().setEncoderChannels(this.f.mAudioChannels);
    TXCAudioEngine.getInstance().muteLocalAudio(this.x);
    if ((this.f.mCustomModeType & 0x1) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
      if (!TXCAudioEngine.hasTrae()) {
        bool2 = true;
      }
      TXCAudioEngineJNI.nativeUseSysAudioDevice(bool2);
      TXCAudioEngine.getInstance().startLocalAudio(10, bool1);
      TXCAudioEngine.getInstance().enableEncodedDataCallback(true);
      AppMethodBeat.o(218510);
      return;
    }
  }
  
  private void O()
  {
    AppMethodBeat.i(218511);
    TXCAudioEngine.getInstance().stopLocalAudio();
    AppMethodBeat.o(218511);
  }
  
  private void P()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(218514);
    if (this.l == null)
    {
      AppMethodBeat.o(218514);
      return;
    }
    TXCAudioEngine.getInstance().enableSoftAGC(this.k.w, 100);
    TXCAudioEngine.getInstance().enableSoftANS(this.k.x, 100);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setSystemVolumeType(this.k.y);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(this.k.A);
    this.l.a(this.k);
    this.l.k(this.y);
    this.l.b(this.k.p);
    if (this.l.k())
    {
      int i4;
      int i3;
      if (this.m != null)
      {
        if (!this.k.Q) {
          break label350;
        }
        i4 = this.k.r;
        i3 = this.k.s;
        if (i4 >= 5) {
          break label339;
        }
        if (i3 <= 1) {
          break label345;
        }
        label173:
        this.m.setRetryInterval(i2);
        this.m.setRetryTimes(i1);
        this.m.setVideoDropParams(false, this.k.i, 1000);
      }
      for (;;)
      {
        this.m.setSendStrategy(this.k.Q, this.k.R);
        if (this.p == null) {
          break label422;
        }
        this.p.stop();
        this.p.setAutoAdjustBitrate(this.k.g);
        this.p.setAutoAdjustStrategy(this.k.f);
        this.p.setDefaultVideoResolution(this.k.l);
        this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
        if (!this.k.g) {
          break label422;
        }
        this.p.start(2000L);
        AppMethodBeat.o(218514);
        return;
        label339:
        i1 = i4;
        break;
        label345:
        i2 = i3;
        break label173;
        label350:
        this.m.setRetryInterval(this.k.s);
        this.m.setRetryTimes(this.k.r);
        this.m.setVideoDropParams(true, 40, 3000);
      }
    }
    if (this.m != null) {
      this.m.setAudioInfo(this.k.t, this.k.u);
    }
    label422:
    AppMethodBeat.o(218514);
  }
  
  private String Q()
  {
    AppMethodBeat.i(218523);
    Object localObject = com.tencent.liteav.basic.d.c.a();
    String str = ((com.tencent.liteav.basic.d.c)localObject).c();
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(218523);
      return str;
    }
    localObject = TXCAudioEngine.buildTRAEConfig(this.n, null, ((com.tencent.liteav.basic.d.c)localObject).i(), ((com.tencent.liteav.basic.d.c)localObject).j());
    AppMethodBeat.o(218523);
    return localObject;
  }
  
  private void a(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(218517);
    final int i1 = paramInt;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(218517);
      return;
    case -1315: 
    case -1314: 
    case -1301: 
      i1 = -1301;
    }
    for (;;)
    {
      if (this.o != null) {
        this.o.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(218462);
            if (TXLivePusherImpl.a(TXLivePusherImpl.this) != null) {
              TXLivePusherImpl.a(TXLivePusherImpl.this).onPushEvent(i1, paramBundle);
            }
            AppMethodBeat.o(218462);
          }
        });
      }
      AppMethodBeat.o(218517);
      return;
      AppMethodBeat.o(218517);
      return;
      i1 = -1302;
      continue;
      AppMethodBeat.o(218517);
      return;
      AppMethodBeat.o(218517);
      return;
      i1 = 1008;
      continue;
      i1 = 1103;
      continue;
      AppMethodBeat.o(218517);
      return;
      i1 = -1303;
      continue;
      i1 = 1001;
      continue;
      i1 = 1002;
      continue;
      i1 = 1101;
      continue;
      i1 = 3003;
      continue;
      i1 = 3002;
      continue;
      i1 = 3004;
      continue;
      i1 = -1307;
      continue;
      i1 = -1307;
      continue;
      i1 = -1307;
      continue;
      i1 = -1307;
      continue;
      i1 = 1102;
      continue;
      i1 = 3005;
      continue;
      i1 = -1313;
      continue;
      i1 = 1020;
      continue;
      i1 = 1018;
      continue;
      i1 = 1019;
      continue;
      i1 = 1021;
      continue;
      i1 = 2110;
      continue;
      i1 = 1204;
      continue;
      i1 = 1104;
      continue;
      i1 = -2311;
    }
  }
  
  private void a(TXSNALPacket paramTXSNALPacket, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218493);
    if (this.O == 0L) {
      this.O = paramTXSNALPacket.pts;
    }
    long l1 = paramTXSNALPacket.pts;
    long l2 = this.O;
    int i1;
    if (paramTXSNALPacket.info == null)
    {
      if (paramTXSNALPacket.nalType != 0) {
        break label110;
      }
      i1 = 1;
    }
    for (;;)
    {
      this.L.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramTXSNALPacket.pts * 1000L, i1);
      this.o.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(218470);
          if (TXLivePusherImpl.j(TXLivePusherImpl.this) != null) {
            TXLivePusherImpl.j(TXLivePusherImpl.this).onRecordProgress(this.a);
          }
          AppMethodBeat.o(218470);
        }
      });
      AppMethodBeat.o(218493);
      return;
      i1 = paramTXSNALPacket.info.flags;
      continue;
      label110:
      i1 = 0;
    }
  }
  
  private void a(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(218494);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(218494);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218465);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        AppMethodBeat.o(218465);
      }
    });
    AppMethodBeat.o(218494);
  }
  
  private void a(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(218490);
    this.o.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218467);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = 0;
        localTXRecordResult.descMsg = "record success";
        localTXRecordResult.videoPath = paramString1;
        localTXRecordResult.coverPath = paramString2;
        if (TXLivePusherImpl.j(TXLivePusherImpl.this) != null) {
          TXLivePusherImpl.j(TXLivePusherImpl.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(TXLivePusherImpl.w(), "record complete success");
        AppMethodBeat.o(218467);
      }
    });
    AppMethodBeat.o(218490);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(218496);
    int i1 = b(paramBoolean1, paramBoolean2);
    if (i1 == -1)
    {
      this.f.setAutoAdjustBitrate(false);
      this.f.setAutoAdjustStrategy(-1);
      AppMethodBeat.o(218496);
      return;
    }
    this.f.setAutoAdjustBitrate(true);
    this.f.setAutoAdjustStrategy(i1);
    AppMethodBeat.o(218496);
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218520);
    byte[] arrayOfByte1 = h(paramInt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1 + paramArrayOfByte.length + 1];
    arrayOfByte2[0] = -14;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    paramInt = arrayOfByte1.length + 1;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, paramInt, paramArrayOfByte.length);
    arrayOfByte2[(paramInt + paramArrayOfByte.length)] = -128;
    AppMethodBeat.o(218520);
    return arrayOfByte2;
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == true)
    {
      if (paramBoolean2 == true) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  private void b(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(218480);
    TXLivePushConfig localTXLivePushConfig = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localTXLivePushConfig = new TXLivePushConfig();
    }
    this.f = localTXLivePushConfig;
    c(localTXLivePushConfig);
    P();
    AppMethodBeat.o(218480);
  }
  
  private void c(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(218513);
    com.tencent.liteav.g localg = this.k;
    localg.c = paramTXLivePushConfig.mVideoBitrate;
    localg.e = paramTXLivePushConfig.mMinVideoBitrate;
    localg.d = paramTXLivePushConfig.mMaxVideoBitrate;
    localg.f = paramTXLivePushConfig.mAutoAdjustStrategy;
    localg.g = paramTXLivePushConfig.mAutoAdjustBitrate;
    localg.i = paramTXLivePushConfig.mVideoFPS;
    localg.j = paramTXLivePushConfig.mVideoEncodeGop;
    localg.k = paramTXLivePushConfig.mHardwareAccel;
    localg.l = paramTXLivePushConfig.mVideoResolution;
    if (paramTXLivePushConfig.mEnableVideoHardEncoderMainProfile) {}
    for (int i1 = 3;; i1 = 1)
    {
      localg.o = i1;
      localg.p = paramTXLivePushConfig.mLocalVideoMirrorType;
      localg.t = paramTXLivePushConfig.mAudioSample;
      localg.u = paramTXLivePushConfig.mAudioChannels;
      localg.v = paramTXLivePushConfig.mEnableAec;
      localg.w = paramTXLivePushConfig.mEnableAgc;
      localg.x = paramTXLivePushConfig.mEnableAns;
      localg.y = paramTXLivePushConfig.mVolumeType;
      localg.E = paramTXLivePushConfig.mPauseFlag;
      localg.D = paramTXLivePushConfig.mPauseFps;
      localg.B = paramTXLivePushConfig.mPauseImg;
      localg.C = paramTXLivePushConfig.mPauseTime;
      localg.N = paramTXLivePushConfig.mEnablePureAudioPush;
      localg.L = paramTXLivePushConfig.mTouchFocus;
      localg.M = paramTXLivePushConfig.mEnableZoom;
      localg.F = paramTXLivePushConfig.mWatermark;
      localg.G = paramTXLivePushConfig.mWatermarkX;
      localg.H = paramTXLivePushConfig.mWatermarkY;
      localg.I = paramTXLivePushConfig.mWatermarkXF;
      localg.J = paramTXLivePushConfig.mWatermarkYF;
      localg.K = paramTXLivePushConfig.mWatermarkWidth;
      localg.m = paramTXLivePushConfig.mHomeOrientation;
      localg.O = paramTXLivePushConfig.mEnableNearestIP;
      localg.P = paramTXLivePushConfig.mRtmpChannelType;
      localg.r = paramTXLivePushConfig.mConnectRetryCount;
      localg.s = paramTXLivePushConfig.mConnectRetryInterval;
      localg.n = paramTXLivePushConfig.mFrontCamera;
      localg.S = paramTXLivePushConfig.mCustomModeType;
      localg.T = paramTXLivePushConfig.mVideoEncoderXMirror;
      localg.U = paramTXLivePushConfig.mEnableHighResolutionCapture;
      localg.W = paramTXLivePushConfig.mEnableScreenCaptureAutoRotate;
      localg.A = paramTXLivePushConfig.mEnableAudioPreview;
      localg.a();
      AppMethodBeat.o(218513);
      return;
    }
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218518);
    int i2 = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i2);
    int i3;
    for (int i1 = 0; i1 + 4 < i2; i1 = i1 + i3 + 4)
    {
      i3 = ByteBuffer.wrap(paramArrayOfByte, i1, 4).getInt();
      if (i1 + 4 + i3 <= i2)
      {
        arrayOfByte[i1] = 0;
        arrayOfByte[(i1 + 1)] = 0;
        arrayOfByte[(i1 + 2)] = 0;
        arrayOfByte[(i1 + 3)] = 1;
      }
    }
    AppMethodBeat.o(218518);
    return arrayOfByte;
  }
  
  private byte[] e(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218519);
    int i5 = paramArrayOfByte.length * 4 / 3 + 2;
    byte[] arrayOfByte = new byte[i5];
    int i1 = 0;
    int i3;
    for (int i2 = 0; (i1 < paramArrayOfByte.length) && (i2 < i5); i2 = i3 + 1)
    {
      int i4 = i1;
      i3 = i2;
      if (i1 + 3 < paramArrayOfByte.length)
      {
        i4 = i1;
        i3 = i2;
        if (paramArrayOfByte[i1] == 0)
        {
          i4 = i1;
          i3 = i2;
          if (paramArrayOfByte[(i1 + 1)] == 0)
          {
            i4 = i1;
            i3 = i2;
            if (paramArrayOfByte[(i1 + 2)] >= 0)
            {
              i4 = i1;
              i3 = i2;
              if (paramArrayOfByte[(i1 + 2)] <= 3)
              {
                i3 = i2 + 1;
                int i6 = i1 + 1;
                arrayOfByte[i2] = paramArrayOfByte[i1];
                i1 = i3 + 1;
                i4 = i6 + 1;
                arrayOfByte[i3] = paramArrayOfByte[i6];
                i3 = i1 + 1;
                arrayOfByte[i1] = 3;
              }
            }
          }
        }
      }
      arrayOfByte[i3] = paramArrayOfByte[i4];
      i1 = i4 + 1;
    }
    paramArrayOfByte = new byte[i2];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i2);
    AppMethodBeat.o(218519);
    return paramArrayOfByte;
  }
  
  private String g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "UNKNOWN";
    case 1: 
      return "WIFI";
    case 2: 
      return "4G";
    case 3: 
      return "3G";
    case 4: 
      return "2G";
    case 5: 
      return "WIRED";
    }
    return "5G";
  }
  
  private void h(String paramString)
  {
    AppMethodBeat.i(218481);
    if (paramString == null)
    {
      AppMethodBeat.o(218481);
      return;
    }
    if (paramString.startsWith("rtmp://"))
    {
      j(paramString);
      AppMethodBeat.o(218481);
      return;
    }
    if (paramString.startsWith("room://cloud.tencent.com"))
    {
      i(paramString);
      AppMethodBeat.o(218481);
      return;
    }
    TXCLog.i(d, "initMonitor： init default monitor.");
    Monitor.a(paramString, 0, "");
    AppMethodBeat.o(218481);
  }
  
  private byte[] h(int paramInt)
  {
    int i2 = paramInt / 255 + 1;
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    while (i1 < i2 - 1)
    {
      arrayOfByte[i1] = -1;
      i1 += 1;
    }
    arrayOfByte[(i2 - 1)] = ((byte)(paramInt % 255 & 0xFF));
    return arrayOfByte;
  }
  
  private int i(int paramInt)
  {
    AppMethodBeat.i(218521);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(218521);
      return paramInt;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "RTC");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkMain");
      continue;
      paramInt = (int)com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkSub");
    }
  }
  
  private void i(String paramString)
  {
    AppMethodBeat.i(218482);
    Object localObject1 = "";
    Object localObject2 = "";
    label276:
    label355:
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.split("[?&]");
        int i4 = arrayOfString.length;
        i2 = 0;
        i1 = 0;
        Object localObject3 = localObject2;
        localObject5 = localObject1;
        i3 = i1;
        if (i2 >= i4) {
          break label276;
        }
        Object localObject6 = arrayOfString[i2];
        localObject3 = localObject2;
        localObject5 = localObject1;
        i3 = i1;
        CharSequence localCharSequence;
        boolean bool;
        TXCLog.e(d, "initMonitorByRoom: catch exception.", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          if (((String)localObject6).indexOf("=") == -1) {
            break label355;
          }
          localObject6 = ((String)localObject6).split("[=]");
          localObject3 = localObject2;
          localObject5 = localObject1;
          i3 = i1;
          if (localObject6.length != 2) {
            break label355;
          }
          localCharSequence = localObject6[0];
          localObject6 = localObject6[1];
          localObject3 = localObject2;
          localObject5 = localObject1;
          i3 = i1;
          if (TextUtils.isEmpty(localCharSequence)) {
            break label355;
          }
          localObject3 = localObject2;
          localObject5 = localObject1;
          i3 = i1;
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            break label355;
          }
          if (localCharSequence.equalsIgnoreCase("sdkappid"))
          {
            i3 = Integer.parseInt((String)localObject6);
            localObject3 = localObject2;
            localObject5 = localObject1;
          }
          else if (localCharSequence.equalsIgnoreCase("roomid"))
          {
            localObject5 = localObject6;
            localObject3 = localObject2;
            i3 = i1;
          }
          else
          {
            bool = localCharSequence.equalsIgnoreCase("userid");
            localObject3 = localObject2;
            localObject5 = localObject1;
            i3 = i1;
            if (bool)
            {
              localObject3 = localObject6;
              localObject5 = localObject1;
              i3 = i1;
            }
          }
        }
        catch (Exception localException2)
        {
          int i2;
          Object localObject5;
          int i3;
          for (;;)
          {
            Object localObject4;
            continue;
            paramString = localException2;
          }
          i2 += 1;
          localObject2 = localException2;
          localObject1 = localObject5;
          int i1 = i3;
        }
        localException1 = localException1;
        i1 = 0;
      }
      i3 = i1;
      localObject5 = localObject1;
      localObject4 = localObject2;
      if (TextUtils.isEmpty(localObject4))
      {
        TXCLog.i(d, "initMonitorByRoom: sdkappId:" + i3 + " roomId:" + localObject5 + " userId:" + paramString);
        Monitor.a(paramString, i3, localObject5);
        AppMethodBeat.o(218482);
        return;
      }
    }
  }
  
  private void j(String paramString)
  {
    AppMethodBeat.i(218483);
    String str = k(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      TXCLog.i(d, "initMonitorByStreamId: streamId: ".concat(String.valueOf(paramString)));
      Monitor.a(paramString, 0, "");
      AppMethodBeat.o(218483);
      return;
      paramString = str;
    }
  }
  
  private String k(String paramString)
  {
    AppMethodBeat.i(218484);
    try
    {
      int i1 = paramString.lastIndexOf("/");
      int i2 = paramString.indexOf("?");
      if (i1 == -1)
      {
        TXCLog.e(d, "parseStreamId: un find slash line.");
        AppMethodBeat.o(218484);
        return null;
      }
      if (i2 != -1) {}
      for (paramString = paramString.substring(i1 + 1, i2);; paramString = paramString.substring(i1 + 1))
      {
        AppMethodBeat.o(218484);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      TXCLog.e(d, "parseStreamId: catch exception.", paramString);
      AppMethodBeat.o(218484);
    }
  }
  
  private boolean l(String paramString)
  {
    AppMethodBeat.i(218485);
    try
    {
      paramString = paramString.split("[?&]");
      int i2 = paramString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        CharSequence localCharSequence = paramString[i1];
        if (localCharSequence.indexOf("=") != -1)
        {
          Object localObject = localCharSequence.split("[=]");
          if (localObject.length == 2)
          {
            localCharSequence = localObject[0];
            localObject = localObject[1];
            if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localCharSequence.equalsIgnoreCase("enableblackstream")))
            {
              if (Integer.parseInt((String)localObject) == 1)
              {
                AppMethodBeat.o(218485);
                return true;
              }
              AppMethodBeat.o(218485);
              return false;
            }
          }
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      TXCLog.w(d, "parse black stream flag error " + paramString.toString());
      AppMethodBeat.o(218485);
    }
  }
  
  private void m(String paramString)
  {
    AppMethodBeat.i(218497);
    if (this.m != null) {
      this.m.setID(paramString);
    }
    if (this.l != null) {
      this.l.setID(paramString);
    }
    if (this.q != null) {
      this.q.d(paramString);
    }
    this.s = paramString;
    AppMethodBeat.o(218497);
  }
  
  private void x()
  {
    AppMethodBeat.i(218487);
    if ((this.F > 0) && (l()))
    {
      TXCAudioEngine.getInstance();
      TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
      if (this.J == null) {
        this.J = new a(null);
      }
      this.J.a(this.F);
      if (this.o != null)
      {
        this.o.removeCallbacks(this.J);
        this.o.postDelayed(this.J, this.F);
      }
    }
    AppMethodBeat.o(218487);
  }
  
  private void y()
  {
    AppMethodBeat.i(218488);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(false, 300);
    if (this.J != null) {
      this.J.a(0);
    }
    if (this.o != null) {
      this.o.removeCallbacks(this.J);
    }
    this.J = null;
    this.F = 0;
    AppMethodBeat.o(218488);
  }
  
  private void z()
  {
    AppMethodBeat.i(218489);
    this.o.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218468);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = -1;
        localTXRecordResult.descMsg = "record video failed";
        if (TXLivePusherImpl.j(TXLivePusherImpl.this) != null) {
          TXLivePusherImpl.j(TXLivePusherImpl.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(TXLivePusherImpl.w(), "record complete fail");
        AppMethodBeat.o(218468);
      }
    });
    AppMethodBeat.o(218489);
  }
  
  public int a()
  {
    AppMethodBeat.i(218966);
    int i1 = TXCStatus.c(this.s, 4002);
    AppMethodBeat.o(218966);
    return i1;
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(218612);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e(d, "start push error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(218612);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.r)) && (l()))
    {
      if (this.r.equalsIgnoreCase(paramString))
      {
        TXCLog.w(d, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
        AppMethodBeat.o(218612);
        return -1;
      }
      TXCLog.w(d, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
      i();
    }
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    TXCLog.i(d, "liteav_api ============= startPush pushUrl = " + paramString + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    this.r = paramString;
    m(this.r);
    F();
    L();
    N();
    H();
    J();
    h(paramString);
    g("startPusher url:".concat(String.valueOf(paramString)));
    B();
    if (this.e != null) {
      this.e.clearLog();
    }
    if (l(this.r)) {
      this.l.c(true);
    }
    if (this.C == 0) {
      TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.bv);
    }
    for (;;)
    {
      x();
      AppMethodBeat.o(218612);
      return 0;
      TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.bG);
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218896);
    if (this.l != null)
    {
      switch (paramInt1)
      {
      case 4: 
      default: 
        AppMethodBeat.o(218896);
        return -1000;
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramInt1 = this.l.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0L);
        AppMethodBeat.o(218896);
        return paramInt1;
      }
    }
    AppMethodBeat.o(218896);
    return -1000;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(218725);
    TXCLog.i(d, "liteav_api setExposureCompensation ".concat(String.valueOf(paramFloat)));
    if (this.l == null)
    {
      AppMethodBeat.o(218725);
      return;
    }
    this.l.a(paramFloat);
    AppMethodBeat.o(218725);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(218656);
    if (this.l != null) {
      this.l.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(218656);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(218700);
    TXCLog.i(d, "liteav_api setRenderRotation ");
    if (this.l == null)
    {
      AppMethodBeat.o(218700);
      return;
    }
    this.l.g(paramInt);
    AppMethodBeat.o(218700);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218651);
    TXCLog.i(d, "liteav_api setSurfaceSize " + paramInt1 + "," + paramInt2);
    if (this.l == null)
    {
      AppMethodBeat.o(218651);
      return;
    }
    this.l.a(paramInt1, paramInt2);
    AppMethodBeat.o(218651);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219009);
    if (this.l != null) {
      this.l.a(paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.k.a = paramInt2;
      this.k.b = paramInt3;
    }
    if (paramInt1 != 0)
    {
      this.k.c = paramInt1;
      g("onEncoderParamsChanged: " + String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", new Object[] { Integer.valueOf(this.k.f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    AppMethodBeat.o(219009);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int i2 = 1;
    AppMethodBeat.i(218683);
    g("setVideoQuality quality:" + paramInt + ", adjustBitrate:" + paramBoolean1 + ", adjustResolution:" + paramBoolean1 + ", adjustResolution:" + paramBoolean2);
    int i1 = paramInt;
    if (TXCBuild.VersionInt() < 18) {
      if (paramInt != 2)
      {
        i1 = paramInt;
        if (paramInt != 3) {}
      }
      else
      {
        i1 = 1;
      }
    }
    if (this.f == null) {
      this.f = new TXLivePushConfig();
    }
    this.f.setVideoFPS(18);
    if ((paramBoolean2) && (paramBoolean1)) {}
    for (paramInt = 1;; paramInt = 0) {
      switch (i1)
      {
      default: 
        this.f.setHardwareAcceleration(2);
        TXCLog.e(d, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i1)));
        AppMethodBeat.o(218683);
        return;
      }
    }
    this.f.enableAEC(false);
    this.f.setHardwareAcceleration(2);
    this.f.setVideoResolution(0);
    this.f.setAudioSampleRate(48000);
    a(paramBoolean1, paramBoolean2);
    label287:
    TXLivePushConfig localTXLivePushConfig;
    if (paramInt != 0)
    {
      this.f.setMinVideoBitrate(301);
      this.f.setVideoBitrate(800);
      this.f.setMaxVideoBitrate(900);
      paramBoolean1 = false;
      paramBoolean2 = false;
      this.h = i1;
      localTXLivePushConfig = this.f;
      if (!paramBoolean2) {
        break label1266;
      }
      label303:
      localTXLivePushConfig.enableVideoHardEncoderMainProfile(bool);
      localTXLivePushConfig = this.f;
      if (!paramBoolean2) {
        break label1272;
      }
    }
    label1266:
    label1272:
    for (paramInt = i2;; paramInt = 3)
    {
      localTXLivePushConfig.setVideoEncodeGop(paramInt);
      if (this.k != null)
      {
        this.k.Q = paramBoolean2;
        this.k.R = paramBoolean1;
      }
      b(this.f);
      AppMethodBeat.o(218683);
      return;
      this.f.setMinVideoBitrate(500);
      this.f.setVideoBitrate(800);
      this.f.setMaxVideoBitrate(900);
      break;
      this.f.enableAEC(false);
      this.f.setHardwareAcceleration(2);
      this.f.setVideoResolution(1);
      this.f.setAudioSampleRate(48000);
      a(paramBoolean1, paramBoolean2);
      if (paramInt != 0)
      {
        this.f.setMinVideoBitrate(600);
        this.f.setVideoBitrate(1200);
        this.f.setMaxVideoBitrate(1500);
      }
      for (;;)
      {
        paramBoolean1 = false;
        paramBoolean2 = false;
        break;
        this.f.setMinVideoBitrate(800);
        this.f.setVideoBitrate(1200);
        this.f.setMaxVideoBitrate(1500);
      }
      this.f.enableAEC(false);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(2);
      this.f.setAudioSampleRate(48000);
      a(paramBoolean1, paramBoolean2);
      if (paramInt != 0)
      {
        this.f.setMinVideoBitrate(600);
        this.f.setVideoBitrate(1800);
        this.f.setMaxVideoBitrate(1800);
      }
      for (;;)
      {
        paramBoolean1 = false;
        paramBoolean2 = false;
        break;
        this.f.setMinVideoBitrate(1000);
        this.f.setVideoBitrate(1800);
        this.f.setMaxVideoBitrate(1800);
      }
      this.f.enableAEC(false);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(30);
      this.f.setAudioSampleRate(48000);
      a(paramBoolean1, false);
      this.f.setMinVideoBitrate(2500);
      this.f.setVideoBitrate(3000);
      this.f.setMaxVideoBitrate(3000);
      paramBoolean1 = false;
      paramBoolean2 = false;
      break label287;
      this.f.enableAEC(true);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(0);
      this.f.setAudioSampleRate(48000);
      this.f.setAutoAdjustBitrate(true);
      this.f.setAutoAdjustStrategy(5);
      this.f.setMinVideoBitrate(190);
      this.f.setVideoBitrate(400);
      this.f.setMaxVideoBitrate(810);
      paramBoolean1 = true;
      paramBoolean2 = true;
      break label287;
      if (TXCBuild.VersionInt() < 18)
      {
        this.f.enableAEC(true);
        this.f.setHardwareAcceleration(0);
        this.f.setVideoResolution(0);
        this.f.setAutoAdjustBitrate(true);
        this.f.setAutoAdjustStrategy(4);
        this.f.setMinVideoBitrate(500);
        this.f.setVideoBitrate(800);
        this.f.setMaxVideoBitrate(900);
      }
      for (;;)
      {
        this.f.setAudioSampleRate(48000);
        paramBoolean1 = false;
        paramBoolean2 = true;
        break;
        if (this.h == 1)
        {
          this.f.enableAEC(true);
          this.f.setHardwareAcceleration(1);
          this.f.setVideoResolution(0);
          this.f.setAutoAdjustBitrate(true);
          this.f.setAutoAdjustStrategy(4);
          this.f.setMinVideoBitrate(500);
          this.f.setVideoBitrate(800);
          this.f.setMaxVideoBitrate(900);
        }
        else if (this.h == 3)
        {
          this.f.enableAEC(true);
          this.f.setHardwareAcceleration(1);
          this.f.setVideoResolution(2);
          this.f.setAutoAdjustBitrate(true);
          this.f.setAutoAdjustStrategy(4);
          this.f.setMinVideoBitrate(1000);
          this.f.setVideoBitrate(1800);
          this.f.setMaxVideoBitrate(1800);
        }
        else if (this.h == 7)
        {
          this.f.enableAEC(true);
          this.f.setHardwareAcceleration(1);
          this.f.setVideoResolution(30);
          this.f.setAutoAdjustBitrate(true);
          this.f.setAutoAdjustStrategy(4);
          this.f.setMinVideoBitrate(2000);
          this.f.setVideoBitrate(3000);
          this.f.setMaxVideoBitrate(3000);
        }
        else
        {
          this.f.enableAEC(true);
          this.f.setHardwareAcceleration(1);
          this.f.setVideoResolution(1);
          this.f.setAutoAdjustBitrate(true);
          this.f.setAutoAdjustStrategy(4);
          this.f.setMinVideoBitrate(800);
          this.f.setVideoBitrate(1200);
          this.f.setMaxVideoBitrate(1500);
        }
      }
      this.f.enableAEC(true);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(6);
      this.f.setAutoAdjustBitrate(false);
      this.f.setVideoBitrate(350);
      this.f.setAudioSampleRate(48000);
      paramBoolean1 = false;
      paramBoolean2 = true;
      break label287;
      bool = true;
      break label303;
    }
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(218648);
    TXCLog.i(d, "liteav_api setSurface ".concat(String.valueOf(paramSurface)));
    if (this.l == null)
    {
      AppMethodBeat.o(218648);
      return;
    }
    this.l.a(paramSurface);
    AppMethodBeat.o(218648);
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(218590);
    TXCLog.i(d, "liteav_api setPushListener ".concat(String.valueOf(paramITXLivePushListener)));
    this.g = paramITXLivePushListener;
    AppMethodBeat.o(218590);
  }
  
  public void a(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(218576);
    StringBuilder localStringBuilder = new StringBuilder("setConfig ");
    if (paramTXLivePushConfig != null) {}
    for (String str = paramTXLivePushConfig.toString();; str = "null")
    {
      g(str);
      b(paramTXLivePushConfig);
      AppMethodBeat.o(218576);
      return;
    }
  }
  
  public void a(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    AppMethodBeat.i(218920);
    TXCLog.i(d, "liteav_api setAudioProcessListener ".concat(String.valueOf(paramAudioCustomProcessListener)));
    this.j = paramAudioCustomProcessListener;
    AppMethodBeat.o(218920);
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.E = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(218878);
    TXCLog.i(d, "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.t) || (paramITXSnapshotListener == null) || (this.l == null))
    {
      AppMethodBeat.o(218878);
      return;
    }
    if (this.l != null)
    {
      this.t = true;
      this.l.a(new p()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(218458);
          TXLivePusherImpl.a(TXLivePusherImpl.this, paramITXSnapshotListener, paramAnonymousBitmap);
          TXLivePusherImpl.a(TXLivePusherImpl.this, false);
          TXLivePusherImpl.f(TXLivePusherImpl.this).removeCallbacks(TXLivePusherImpl.h(TXLivePusherImpl.this));
          AppMethodBeat.o(218458);
        }
      });
      this.o.postDelayed(this.K, 2000L);
      AppMethodBeat.o(218878);
      return;
    }
    this.t = false;
    AppMethodBeat.o(218878);
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(218751);
    TXCLog.i(d, "liteav_api setBGMNofify ".concat(String.valueOf(paramOnBGMNotify)));
    this.a = paramOnBGMNotify;
    if (this.a != null)
    {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.I);
      AppMethodBeat.o(218751);
      return;
    }
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
    AppMethodBeat.o(218751);
  }
  
  public void a(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(218913);
    TXCLog.i(d, "liteav_api setVideoProcessListener ".concat(String.valueOf(paramVideoCustomProcessListener)));
    this.i = paramVideoCustomProcessListener;
    if (this.i == null)
    {
      if (this.l != null)
      {
        this.l.a(null);
        AppMethodBeat.o(218913);
      }
    }
    else if (this.l != null) {
      this.l.a(this.H);
    }
    AppMethodBeat.o(218913);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(218598);
    StringBuilder localStringBuilder = new StringBuilder("startCameraPreview [view:");
    if (paramTXCloudVideoView != null) {}
    for (int i1 = paramTXCloudVideoView.hashCode();; i1 = 0)
    {
      g(i1 + "]");
      b(this.f);
      if (!this.k.N) {
        break;
      }
      TXCLog.e(d, "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(218598);
      return;
    }
    if ((this.e != paramTXCloudVideoView) && (this.e != null)) {
      this.e.removeVideoView();
    }
    this.e = paramTXCloudVideoView;
    if (this.l == null) {
      this.l = new d(this.n);
    }
    this.l.a(this);
    this.l.a(this);
    this.B.setFrontCamera(this.k.n);
    this.l.a(paramTXCloudVideoView);
    if ((this.f.mBeautyLevel > 0) || (this.f.mWhiteningLevel > 0) || (this.f.mRuddyLevel > 0)) {
      this.l.b(this.f.mBeautyLevel, this.f.mWhiteningLevel, this.f.mRuddyLevel);
    }
    LicenceCheck.a().a(null, this.n);
    AppMethodBeat.o(218598);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(218844);
    TXCLog.i(d, "liteav_api setVideoRecordListener ".concat(String.valueOf(paramITXVideoRecordListener)));
    this.Q = paramITXVideoRecordListener;
    AppMethodBeat.o(218844);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(219016);
    if (this.m != null) {
      this.m.setDropEanble(paramBoolean);
    }
    AppMethodBeat.o(219016);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218903);
    TXCAudioEngine.getInstance().sendCustomPCMData(paramArrayOfByte, this.f.mAudioSample, this.f.mAudioChannels);
    AppMethodBeat.o(218903);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(218731);
    if (this.l != null)
    {
      this.l.h(paramInt1);
      this.l.b(paramInt2, paramInt3, paramInt4);
    }
    if (this.f != null)
    {
      this.f.mBeautyLevel = paramInt2;
      this.f.mWhiteningLevel = paramInt3;
      this.f.mRuddyLevel = paramInt4;
    }
    AppMethodBeat.o(218731);
    return true;
  }
  
  public int b()
  {
    AppMethodBeat.i(218975);
    int i1 = TXCStatus.c(this.s, 7002);
    if (this.k.Q) {
      i1 += TXCStatus.c(this.s, 7001);
    }
    for (;;)
    {
      AppMethodBeat.o(218975);
      return i1;
      i1 += TXCStatus.c(this.s, 4002);
    }
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218888);
    if (this.l != null)
    {
      EGLContext localEGLContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
      paramInt1 = this.l.a(paramInt1, paramInt2, paramInt3, localEGLContext, 0L);
      AppMethodBeat.o(218888);
      return paramInt1;
    }
    AppMethodBeat.o(218888);
    return -1000;
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(218604);
    g("stopCameraPreview needClearLastImg:".concat(String.valueOf(paramBoolean)));
    if (this.l == null)
    {
      AppMethodBeat.o(218604);
      return;
    }
    this.l.d(paramBoolean);
    AppMethodBeat.o(218604);
  }
  
  public boolean b(float paramFloat)
  {
    AppMethodBeat.i(218803);
    TXCLog.i(d, "liteav_api setBGMVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
    AppMethodBeat.o(218803);
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(218720);
    TXCLog.i(d, "liteav_api setZoom ".concat(String.valueOf(paramInt)));
    if (this.l == null)
    {
      AppMethodBeat.o(218720);
      return false;
    }
    boolean bool = this.l.i(paramInt);
    AppMethodBeat.o(218720);
    return bool;
  }
  
  public boolean b(String paramString)
  {
    AppMethodBeat.i(218760);
    TXCLog.i(d, "liteav_api playBGM ".concat(String.valueOf(paramString)));
    boolean bool = TXCLiveBGMPlayer.getInstance().startPlay(paramString);
    AppMethodBeat.o(218760);
    return bool;
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218927);
    if ((paramArrayOfByte.length <= 0) || (paramArrayOfByte.length > 2048))
    {
      AppMethodBeat.o(218927);
      return false;
    }
    try
    {
      if (this.D != null)
      {
        b localb = new b(null);
        localb.a = TXCTimeUtil.generatePtsMS();
        byte[] arrayOfByte = e(paramArrayOfByte);
        localb.b = a(paramArrayOfByte.length, arrayOfByte);
        this.D.add(localb);
      }
      return true;
    }
    finally
    {
      AppMethodBeat.o(218927);
    }
  }
  
  public int c()
  {
    AppMethodBeat.i(218982);
    if (this.m == null)
    {
      AppMethodBeat.o(218982);
      return 0;
    }
    int i1 = TXCStatus.c(this.s, 7004);
    int i2 = TXCStatus.c(this.s, 7003);
    AppMethodBeat.o(218982);
    return i1 + i2;
  }
  
  public int c(String paramString)
  {
    AppMethodBeat.i(218797);
    int i1 = TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
    AppMethodBeat.o(218797);
    return i1;
  }
  
  @Deprecated
  public void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218936);
    try
    {
      if (this.D != null)
      {
        b localb = new b(null);
        localb.a = TXCTimeUtil.generatePtsMS();
        localb.b = e(paramArrayOfByte);
        this.D.add(localb);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(218936);
    }
  }
  
  public boolean c(float paramFloat)
  {
    AppMethodBeat.i(218809);
    TXCLog.i(d, "liteav_api setMicVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = TXCAudioEngine.getInstance().setSoftwareCaptureVolume(paramFloat);
    AppMethodBeat.o(218809);
    return bool;
  }
  
  public boolean c(int paramInt)
  {
    AppMethodBeat.i(218817);
    TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt);
    AppMethodBeat.o(218817);
    return true;
  }
  
  public boolean c(boolean paramBoolean)
  {
    AppMethodBeat.i(218697);
    TXCLog.i(d, "liteav_api setMirror ".concat(String.valueOf(paramBoolean)));
    if (this.f != null) {
      this.f.setVideoEncoderXMirror(paramBoolean);
    }
    if (this.l == null)
    {
      AppMethodBeat.o(218697);
      return false;
    }
    this.l.g(paramBoolean);
    AppMethodBeat.o(218697);
    return true;
  }
  
  public int d()
  {
    return 5;
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(218857);
    TXCLog.i(d, "liteav_api startRecord ".concat(String.valueOf(paramString)));
    if (TXCBuild.VersionInt() < 18)
    {
      TXCLog.e(d, "API levl is too low (record need 18, current is" + TXCBuild.VersionInt() + ")");
      AppMethodBeat.o(218857);
      return -3;
    }
    if (this.P)
    {
      TXCLog.w(d, "ignore start record when recording");
      AppMethodBeat.o(218857);
      return -1;
    }
    if ((this.l == null) || (!this.l.k()))
    {
      TXCLog.w(d, "ignore start record when not pushing");
      AppMethodBeat.o(218857);
      return -2;
    }
    TXCLog.w(d, "start record ");
    this.P = true;
    this.N = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    this.L = new com.tencent.liteav.muxer.c(this.n, 1);
    this.M = false;
    this.L.a(this.N);
    A();
    TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aI);
    if (this.l != null) {
      this.l.u();
    }
    AppMethodBeat.o(218857);
    return 0;
  }
  
  public void d(float paramFloat)
  {
    AppMethodBeat.i(218812);
    TXCLog.i(d, "liteav_api setBGMPitch ".concat(String.valueOf(paramFloat)));
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
    AppMethodBeat.o(218812);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(218823);
    TXCLog.i(d, "liteav_api setReverb ".concat(String.valueOf(paramInt)));
    if ((paramInt < 0) || (paramInt > 7))
    {
      TXCLog.e(d, "reverbType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(218823);
      return;
    }
    TXCAudioEngine.getInstance().setReverbType(this.b[paramInt]);
    AppMethodBeat.o(218823);
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(218708);
    TXCLog.i(d, "liteav_api turnOnFlashLight ".concat(String.valueOf(paramBoolean)));
    if (this.l == null)
    {
      AppMethodBeat.o(218708);
      return false;
    }
    paramBoolean = this.l.f(paramBoolean);
    AppMethodBeat.o(218708);
    return paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(218990);
    int i1 = TXCStatus.c(this.s, 7005);
    AppMethodBeat.o(218990);
    return i1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(218830);
    TXCLog.i(d, "liteav_api setVoiceChangerType ".concat(String.valueOf(paramInt)));
    if ((paramInt < 0) || (paramInt > 11))
    {
      TXCLog.e(d, "voiceChangerType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(218830);
      return;
    }
    TXCAudioEngine.getInstance().setVoiceChangerType(this.c[paramInt]);
    AppMethodBeat.o(218830);
  }
  
  public void e(String paramString)
  {
    AppMethodBeat.i(218942);
    TXCLog.i("User", paramString);
    AppMethodBeat.o(218942);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(218744);
    StringBuilder localStringBuilder = new StringBuilder("setMute:");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      g(str);
      this.x = paramBoolean;
      TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
      if ((this.f.mEnablePureAudioPush) && (this.m != null)) {
        this.m.setAudioMute(paramBoolean);
      }
      AppMethodBeat.o(218744);
      return;
    }
  }
  
  public int f()
  {
    AppMethodBeat.i(218996);
    int i1 = TXCStatus.c(this.s, 7007);
    AppMethodBeat.o(218996);
    return i1;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(218838);
    g("enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.F = i1;
      x();
      AppMethodBeat.o(218838);
      return;
    }
    this.F = 0;
    y();
    AppMethodBeat.o(218838);
  }
  
  public void f(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(218953);
    TXCLog.i(d, "callExperimentalAPI json:".concat(String.valueOf(paramString)));
    String str;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      if (!localJSONObject2.has("api"))
      {
        TXCLog.e(d, "callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(218953);
        return;
      }
      str = localJSONObject2.getString("api");
      JSONObject localJSONObject1 = null;
      if (localJSONObject2.has("params")) {
        localJSONObject1 = localJSONObject2.getJSONObject("params");
      }
      if (str.equals("setInterfaceType"))
      {
        if (localJSONObject1 == null)
        {
          TXCLog.e(d, "setInterfaceType[lack parameter]");
          AppMethodBeat.o(218953);
          return;
        }
        if (!localJSONObject1.has("type"))
        {
          TXCLog.e(d, "setInterfaceType[lack parameter]: type");
          AppMethodBeat.o(218953);
          return;
        }
        this.C = localJSONObject1.optInt("type", 0);
        AppMethodBeat.o(218953);
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e(d, "callExperimentalAPI[failed]: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(218953);
      return;
    }
    if (str.equals("enableHevcEncode"))
    {
      if ((localException != null) && (localException.has("enable")))
      {
        if (localException.getInt("enable") != 0) {
          bool = true;
        }
        this.y = bool;
        AppMethodBeat.o(218953);
      }
    }
    else {
      TXCLog.e(d, "callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
    }
    AppMethodBeat.o(218953);
  }
  
  public int g()
  {
    AppMethodBeat.i(219001);
    int i1 = TXCStatus.c(this.s, 7021);
    AppMethodBeat.o(219001);
    return i1;
  }
  
  protected void g(String paramString)
  {
    AppMethodBeat.i(219060);
    Monitor.a(1, "[API]TXLivePusher(" + hashCode() + ")", paramString, 0);
    AppMethodBeat.o(219060);
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return this.B;
  }
  
  public TXLivePushConfig h()
  {
    return this.f;
  }
  
  public void i()
  {
    AppMethodBeat.i(218617);
    g("stopPusher");
    v();
    C();
    K();
    I();
    M();
    s();
    O();
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(false);
    this.x = false;
    this.C = 0;
    this.k.Q = false;
    G();
    this.r = "";
    this.z.clear();
    Monitor.a();
    this.l.c(false);
    y();
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().UnInitAudioDevice();
    AppMethodBeat.o(218617);
  }
  
  public void j()
  {
    AppMethodBeat.i(218624);
    g("pausePusher");
    if (this.l != null) {
      this.l.h();
    }
    TXCLog.i(d, "mPauseFlag:" + this.f.mPauseFlag);
    if ((this.f.mPauseFlag & 0x2) == 2)
    {
      TXCLog.i(d, "pause audio capture when pause pusher.");
      TXCAudioEngine.getInstance().pauseAudioCapture(true);
    }
    AppMethodBeat.o(218624);
  }
  
  public void k()
  {
    AppMethodBeat.i(218632);
    g("resumePusher");
    if (this.l != null) {
      this.l.i();
    }
    TXCAudioEngine.getInstance().resumeAudioCapture();
    AppMethodBeat.o(218632);
  }
  
  public boolean l()
  {
    AppMethodBeat.i(218641);
    if (this.l != null)
    {
      boolean bool = this.l.k();
      AppMethodBeat.o(218641);
      return bool;
    }
    AppMethodBeat.o(218641);
    return false;
  }
  
  public void m()
  {
    AppMethodBeat.i(218661);
    g("startScreenCapture");
    if (this.l == null)
    {
      AppMethodBeat.o(218661);
      return;
    }
    this.l.a(null);
    AppMethodBeat.o(218661);
  }
  
  public void n()
  {
    AppMethodBeat.i(218666);
    g("stopScreenCapture");
    if (this.l == null)
    {
      AppMethodBeat.o(218666);
      return;
    }
    this.l.m();
    AppMethodBeat.o(218666);
  }
  
  public void o()
  {
    AppMethodBeat.i(218692);
    g("switchCamera");
    if (this.l == null)
    {
      AppMethodBeat.o(218692);
      return;
    }
    this.l.l();
    AppMethodBeat.o(218692);
  }
  
  public void onBackgroudPushStop()
  {
    AppMethodBeat.i(219054);
    TXCAudioEngine.getInstance().resumeAudioCapture();
    TXCAudioEngine.getInstance().pauseAudioCapture(false);
    TXCLog.i(d, "pause audio capture when background push stop.");
    AppMethodBeat.o(219054);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(219027);
    if (this.p != null) {
      this.p.setHasVideo(true);
    }
    if ((this.m != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null)) {}
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        Object localObject1;
        Object localObject2;
        if ((this.D != null) && (!this.D.isEmpty()))
        {
          localObject1 = this.D.iterator();
          i1 = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b)((Iterator)localObject1).next();
            if (((b)localObject2).a <= paramTXSNALPacket.pts)
            {
              if (((b)localObject2).b.length > 10240) {
                break label511;
              }
              i2 = ((b)localObject2).b.length;
              break label502;
            }
          }
          if (i1 != 0)
          {
            localObject1 = new byte[paramTXSNALPacket.nalData.length + i1];
            localObject2 = new byte[5];
            Iterator localIterator = this.D.iterator();
            i1 = 0;
            i2 = 0;
            if (!localIterator.hasNext()) {
              break label526;
            }
            b localb = (b)localIterator.next();
            if (localb.a > paramTXSNALPacket.pts) {
              break label526;
            }
            if (localb.b.length > 10240) {
              break label518;
            }
            i3 = localb.b.length;
            int i4 = i3 + 1;
            localObject2[0] = ((byte)(i4 >> 24 & 0xFF));
            localObject2[1] = ((byte)(i4 >> 16 & 0xFF));
            localObject2[2] = ((byte)(i4 >> 8 & 0xFF));
            localObject2[3] = ((byte)(i4 & 0xFF));
            localObject2[4] = 6;
            System.arraycopy(localObject2, 0, localObject1, i2, 5);
            i2 += 5;
            System.arraycopy(localb.b, 0, localObject1, i2, i3);
            i1 += 1;
            i2 += i3;
            continue;
            if (i3 < i1)
            {
              this.D.remove(0);
              i3 += 1;
              continue;
            }
            System.arraycopy(paramTXSNALPacket.nalData, 0, localObject1, i2, paramTXSNALPacket.nalData.length);
            paramTXSNALPacket.nalData = ((byte[])localObject1);
          }
        }
        this.m.pushNAL(paramTXSNALPacket);
        if ((this.P) && (this.L != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null))
        {
          localObject1 = d(paramTXSNALPacket.nalData);
          if (!this.M)
          {
            if (paramTXSNALPacket.nalType != 0) {
              continue;
            }
            localObject2 = com.tencent.liteav.basic.util.h.a((byte[])localObject1, this.l.d(), this.l.e());
            if (localObject2 != null)
            {
              this.L.a((MediaFormat)localObject2);
              this.L.a();
              this.M = true;
              this.O = 0L;
            }
          }
          a(paramTXSNALPacket, (byte[])localObject1);
        }
        AppMethodBeat.o(219027);
        return;
      }
      finally
      {
        AppMethodBeat.o(219027);
      }
      for (;;)
      {
        label502:
        i1 = i2 + 5 + i1;
        break;
        label511:
        i2 = 10240;
      }
      label518:
      int i3 = 10240;
      continue;
      label526:
      i3 = 0;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(219052);
    if ((this.P) && (this.L != null))
    {
      this.L.a(paramMediaFormat);
      if (!this.M)
      {
        this.L.a();
        this.M = true;
        this.O = 0L;
      }
    }
    AppMethodBeat.o(219052);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(218960);
    if (this.o != null) {
      this.o.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(218457);
          if (TXLivePusherImpl.i(TXLivePusherImpl.this) != null) {
            TXLivePusherImpl.i(TXLivePusherImpl.this).setLogText(null, paramBundle, paramInt);
          }
          AppMethodBeat.o(218457);
        }
      });
    }
    if (paramInt < 0) {
      if (paramBundle == null) {
        break label132;
      }
    }
    label132:
    for (String str = paramBundle.getString("EVT_MSG");; str = "")
    {
      str = String.format("%s [code:%d]", new Object[] { str, Integer.valueOf(paramInt) });
      g("onNotifyEvent event:" + paramInt + ", msg: " + str);
      if ((paramInt == -2310) || (paramInt == -2311)) {
        this.y = false;
      }
      a(paramInt, paramBundle);
      AppMethodBeat.o(218960);
      return;
    }
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219045);
    if ((this.P) && (this.L != null) && (this.M) && (paramArrayOfByte != null)) {
      this.L.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 0);
    }
    AppMethodBeat.o(219045);
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219039);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(219039);
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(219034);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    AppMethodBeat.o(219034);
  }
  
  public int p()
  {
    AppMethodBeat.i(218712);
    if (this.l == null)
    {
      AppMethodBeat.o(218712);
      return 0;
    }
    int i1 = this.l.r();
    AppMethodBeat.o(218712);
    return i1;
  }
  
  public TXBeautyManager q()
  {
    AppMethodBeat.i(218739);
    if (this.l == null) {
      this.l = new d(this.n);
    }
    TXBeautyManager localTXBeautyManager = this.l.b();
    AppMethodBeat.o(218739);
    return localTXBeautyManager;
  }
  
  public boolean r()
  {
    AppMethodBeat.i(218771);
    TXCLog.i(d, "liteav_api stopBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().stopPlay();
    AppMethodBeat.o(218771);
    return bool;
  }
  
  public void s()
  {
    AppMethodBeat.i(218782);
    TXCLog.i(d, "liteav_api stopAllBGM ");
    TXCLiveBGMPlayer.getInstance().stopAll();
    AppMethodBeat.o(218782);
  }
  
  public boolean t()
  {
    AppMethodBeat.i(218789);
    TXCLog.i(d, "liteav_api pauseBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().pause();
    AppMethodBeat.o(218789);
    return bool;
  }
  
  public boolean u()
  {
    AppMethodBeat.i(218792);
    TXCLog.i(d, "liteav_api resumeBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().resume();
    AppMethodBeat.o(218792);
    return bool;
  }
  
  public void v()
  {
    AppMethodBeat.i(218867);
    TXCLog.i(d, "liteav_api stopRecord ");
    if ((this.P) && (this.L != null))
    {
      int i1 = this.L.b();
      TXCLog.w(d, "start record ");
      this.P = false;
      if (i1 == 0)
      {
        AsyncTask.execute(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(218449);
            Object localObject = new File(this.a).getParentFile();
            String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
            localObject = localObject + File.separator + String.format("TXUGCCover_%s.jpg", new Object[] { str });
            com.tencent.liteav.basic.util.h.a(this.a, (String)localObject);
            TXLivePusherImpl.a(TXLivePusherImpl.this, this.a, (String)localObject);
            AppMethodBeat.o(218449);
          }
        });
        AppMethodBeat.o(218867);
        return;
      }
      z();
    }
    AppMethodBeat.o(218867);
  }
  
  class a
    implements Runnable
  {
    private int b = 300;
    
    private a() {}
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      AppMethodBeat.i(218448);
      if (TXLivePusherImpl.this.l())
      {
        int i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
        if (TXLivePusherImpl.e(TXLivePusherImpl.this) != null) {
          TXLivePusherImpl.e(TXLivePusherImpl.this).onAudioVolumeEvaluationNotify(i);
        }
      }
      if ((TXLivePusherImpl.f(TXLivePusherImpl.this) != null) && (this.b > 0)) {
        TXLivePusherImpl.f(TXLivePusherImpl.this).postDelayed(TXLivePusherImpl.g(TXLivePusherImpl.this), this.b);
      }
      AppMethodBeat.o(218448);
    }
  }
  
  class b
  {
    long a;
    byte[] b;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl
 * JD-Core Version:    0.7.0.1
 */