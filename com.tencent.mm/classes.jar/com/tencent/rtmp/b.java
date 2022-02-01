package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.d.a;
import com.tencent.liteav.g;
import com.tencent.liteav.m;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
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

public class b
  implements com.tencent.liteav.audio.e, com.tencent.liteav.basic.b.b, d.a, m, com.tencent.liteav.qos.a
{
  private static final String d;
  private ArrayList<b> A;
  private TXLivePusher.ITXAudioVolumeEvaluationListener B;
  private int C;
  private com.tencent.liteav.basic.b.a D;
  private com.tencent.liteav.audio.f E;
  private a F;
  private Runnable G;
  private com.tencent.liteav.muxer.c H;
  private boolean I;
  private String J;
  private long K;
  private boolean L;
  private TXRecordCommon.ITXVideoRecordListener M;
  private boolean N;
  TXLivePusher.OnBGMNotify a;
  final TXAudioEffectManager.TXVoiceReverbType[] b;
  final TXAudioEffectManager.TXVoiceChangerType[] c;
  private TXCloudVideoView e;
  private TXLivePushConfig f;
  private ITXLivePushListener g;
  private int h;
  private TXLivePusher.VideoCustomProcessListener i;
  private TXLivePusher.AudioCustomProcessListener j;
  private g k;
  private d l;
  private TXCStreamUploader m;
  private Context n;
  private Handler o;
  private TXCQoS p;
  private com.tencent.liteav.e q;
  private String r;
  private String s;
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private HashSet<String> y;
  private HashMap<Integer, Long> z;
  
  static
  {
    AppMethodBeat.i(14224);
    d = b.class.getSimpleName();
    AppMethodBeat.o(14224);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(14124);
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
    this.y = new HashSet();
    this.z = new HashMap();
    this.b = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.c = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.A = new ArrayList();
    this.B = null;
    this.C = 0;
    this.D = new com.tencent.liteav.basic.b.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222683);
        TXCLog.e(b.x(), "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        if (b.a(b.this) != null)
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
          b.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(222683);
          return;
          label140:
          paramAnonymousString3 = "";
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(222682);
        TXCLog.i(b.x(), "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        if (b.a(b.this) != null)
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
          b.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(222682);
          return;
          label140:
          paramAnonymousString3 = "";
        }
      }
    };
    this.E = new com.tencent.liteav.audio.f()
    {
      public void onPlayEnd(int paramAnonymousInt)
      {
        AppMethodBeat.i(222666);
        if (b.this.a != null) {
          b.this.a.onBGMComplete(paramAnonymousInt);
        }
        AppMethodBeat.o(222666);
      }
      
      public void onPlayProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(222667);
        if (b.this.a != null) {
          b.this.a.onBGMProgress(paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(222667);
      }
      
      public void onPlayStart()
      {
        AppMethodBeat.i(222665);
        if (b.this.a != null) {
          b.this.a.onBGMStart();
        }
        AppMethodBeat.o(222665);
      }
    };
    this.F = null;
    this.G = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222655);
        b.a(b.this, false);
        AppMethodBeat.o(222655);
      }
    };
    this.H = null;
    this.I = false;
    this.J = "";
    this.K = 0L;
    this.L = false;
    this.N = false;
    this.f = new TXLivePushConfig();
    this.k = new g();
    this.n = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.n);
    TXCLog.init();
    this.o = new Handler(Looper.getMainLooper());
    com.tencent.liteav.basic.d.c.a().a(this.n);
    TXCAudioEngine.CreateInstance(this.n, R());
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.D));
    long l1 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.l = new d(this.n);
    this.l.d(true);
    this.l.a(this);
    LicenceCheck.a().a(null, this.n);
    TXCTimeUtil.initAppStartTime();
    this.z.put(Integer.valueOf(-1303), Long.valueOf(0L));
    this.z.put(Integer.valueOf(1101), Long.valueOf(0L));
    this.z.put(Integer.valueOf(1006), Long.valueOf(0L));
    AppMethodBeat.o(14124);
  }
  
  private void A()
  {
    AppMethodBeat.i(182229);
    this.o.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13998);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = -1;
        localTXRecordResult.descMsg = "record video failed";
        if (b.g(b.this) != null) {
          b.g(b.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(b.x(), "record complete fail");
        AppMethodBeat.o(13998);
      }
    });
    AppMethodBeat.o(182229);
  }
  
  @TargetApi(16)
  private void B()
  {
    AppMethodBeat.i(14203);
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.f.a(this.f.mAudioSample, this.f.mAudioChannels, 2);
    if (this.H != null) {
      this.H.b(localMediaFormat);
    }
    AppMethodBeat.o(14203);
  }
  
  private void C()
  {
    AppMethodBeat.i(14204);
    this.N = true;
    if (this.o != null) {
      this.o.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13997);
          if (b.h(b.this)) {
            b.i(b.this);
          }
          AppMethodBeat.o(13997);
        }
      }, 2000L);
    }
    AppMethodBeat.o(14204);
  }
  
  private void D()
  {
    AppMethodBeat.i(14205);
    this.N = false;
    AppMethodBeat.o(14205);
  }
  
  private void E()
  {
    AppMethodBeat.i(14206);
    com.tencent.liteav.a.a(this.s, null);
    AppMethodBeat.o(14206);
  }
  
  private void F()
  {
    AppMethodBeat.i(14207);
    E();
    Object localObject = com.tencent.liteav.basic.util.f.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    i1 = TXCStatus.c(this.s, 7004);
    i2 = TXCStatus.c(this.s, 7003);
    int i3 = TXCStatus.c(this.s, 7002);
    int i4 = TXCStatus.c(this.s, 7001);
    int i5 = TXCStatus.c(this.s, 7007);
    int i6 = TXCStatus.c(this.s, 7005);
    int i7 = TXCStatus.c(this.s, 7006);
    String str = TXCStatus.b(this.s, 7012);
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
    localBundle.putCharSequence("SERVER_IP", str);
    localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
    if (this.l != null)
    {
      localBundle.putString("AUDIO_PLAY_INFO", TXCAudioEngine.getInstance().getAECType() + " | " + this.f.mAudioSample + " , " + this.f.mAudioChannels);
      localBundle.putInt("VIDEO_WIDTH", this.l.c());
      localBundle.putInt("VIDEO_HEIGHT", this.l.d());
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
    i2 = com.tencent.liteav.basic.util.f.e(this.n);
    if (com.tencent.liteav.basic.util.f.a(this.n))
    {
      i1 = 1;
      if (this.u != i2)
      {
        Monitor.a(2, String.format("Network: net type change from %s to %s", new Object[] { g(this.u), g(i2) }), "", 0);
        this.u = i2;
      }
      if (this.v != i1) {
        if (i1 != 1) {
          break label641;
        }
      }
    }
    label641:
    for (localObject = "background";; localObject = "foreground")
    {
      Monitor.a(2, String.format("app: switch to %s", new Object[] { localObject }), "", 0);
      this.v = i1;
      if ((this.o != null) && (this.N)) {
        this.o.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14060);
            if (b.h(b.this)) {
              b.i(b.this);
            }
            AppMethodBeat.o(14060);
          }
        }, 2000L);
      }
      AppMethodBeat.o(14207);
      return;
      i1 = 0;
      break;
    }
  }
  
  private void G()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(14208);
    h localh = new h();
    localh.d = this.f.mAudioChannels;
    localh.e = this.f.mAudioSample;
    localh.a = 0;
    localh.c = 20;
    localh.b = 0;
    localh.f = 3;
    localh.j = true;
    localh.l = true;
    localh.k = false;
    localh.h = 40;
    localh.i = 5000;
    localh.m = this.k.P;
    localh.n = this.k.Q;
    localh.o = i(this.h);
    this.m = new TXCStreamUploader(this.n, localh);
    this.m.setID(this.s);
    this.m.setMetaData(this.f.mMetaData);
    if (this.m != null) {
      this.m.setAudioInfo(this.k.s, this.k.t);
    }
    this.m.setNotifyListener(this);
    if (this.k.M) {
      this.m.setAudioMute(this.x);
    }
    this.r = this.m.start(this.r, this.k.N, this.k.O);
    if (this.k.M) {
      this.m.setMode(1);
    }
    int i4;
    int i3;
    if (this.k.P)
    {
      i4 = this.k.q;
      i3 = this.k.r;
      if (i4 < 5)
      {
        if (i3 <= 1) {
          break label390;
        }
        label322:
        this.m.setRetryInterval(i2);
        this.m.setRetryTimes(i1);
        this.m.setVideoDropParams(false, this.k.h, 1000);
      }
    }
    for (;;)
    {
      this.m.setSendStrategy(this.k.P, this.k.Q);
      AppMethodBeat.o(14208);
      return;
      i1 = i4;
      break;
      label390:
      i2 = i3;
      break label322;
      this.m.setRetryInterval(this.k.r);
      this.m.setRetryTimes(this.k.q);
      this.m.setVideoDropParams(true, 40, 3000);
    }
  }
  
  private void H()
  {
    AppMethodBeat.i(14209);
    if (this.m != null)
    {
      this.m.stop();
      this.m.setNotifyListener(null);
      this.m = null;
    }
    AppMethodBeat.o(14209);
  }
  
  private void I()
  {
    AppMethodBeat.i(14210);
    this.p = new TXCQoS(true);
    this.p.setListener(this);
    this.p.setNotifyListener(this);
    this.p.setAutoAdjustBitrate(this.k.g);
    this.p.setAutoAdjustStrategy(this.k.f);
    this.p.setDefaultVideoResolution(this.k.k);
    this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
    if (this.k.g) {
      this.p.start(2000L);
    }
    AppMethodBeat.o(14210);
  }
  
  private void J()
  {
    AppMethodBeat.i(14211);
    if (this.p != null)
    {
      this.p.stop();
      this.p.setListener(null);
      this.p.setNotifyListener(null);
      this.p = null;
    }
    AppMethodBeat.o(14211);
  }
  
  private void K()
  {
    AppMethodBeat.i(14212);
    this.q = new com.tencent.liteav.e(this.n);
    this.q.d(this.s);
    this.q.a(this.k.c);
    this.q.b(this.k.s);
    this.q.a(this.k.a, this.k.b);
    this.q.a(this.r);
    this.q.a();
    AppMethodBeat.o(14212);
  }
  
  private void L()
  {
    AppMethodBeat.i(14213);
    if (this.q != null)
    {
      this.q.b();
      this.q = null;
    }
    AppMethodBeat.o(14213);
  }
  
  private void M()
  {
    AppMethodBeat.i(14215);
    if (this.l != null)
    {
      this.l.setID(this.s);
      this.l.a(this);
      this.l.e();
    }
    AppMethodBeat.o(14215);
  }
  
  private void N()
  {
    AppMethodBeat.i(182230);
    if (this.l != null)
    {
      this.l.a(null);
      this.l.f();
      this.l.a(null);
    }
    AppMethodBeat.o(182230);
  }
  
  private void O()
  {
    boolean bool2 = false;
    AppMethodBeat.i(182231);
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
      AppMethodBeat.o(182231);
      return;
    }
  }
  
  private void P()
  {
    AppMethodBeat.i(222678);
    TXCAudioEngine.getInstance().stopLocalAudio();
    AppMethodBeat.o(222678);
  }
  
  private void Q()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(222679);
    if (this.l == null)
    {
      AppMethodBeat.o(222679);
      return;
    }
    TXCAudioEngine.getInstance().enableSoftAGC(this.k.v, 100);
    TXCAudioEngine.getInstance().enableSoftANS(this.k.w, 100);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setSystemVolumeType(this.k.x);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(this.k.z);
    this.l.a(this.k);
    this.l.b(this.k.o);
    if (this.l.j())
    {
      int i4;
      int i3;
      if (this.m != null)
      {
        if (!this.k.P) {
          break label339;
        }
        i4 = this.k.q;
        i3 = this.k.r;
        if (i4 >= 5) {
          break label328;
        }
        if (i3 <= 1) {
          break label334;
        }
        label162:
        this.m.setRetryInterval(i2);
        this.m.setRetryTimes(i1);
        this.m.setVideoDropParams(false, this.k.h, 1000);
      }
      for (;;)
      {
        this.m.setSendStrategy(this.k.P, this.k.Q);
        if (this.p == null) {
          break label411;
        }
        this.p.stop();
        this.p.setAutoAdjustBitrate(this.k.g);
        this.p.setAutoAdjustStrategy(this.k.f);
        this.p.setDefaultVideoResolution(this.k.k);
        this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
        if (!this.k.g) {
          break label411;
        }
        this.p.start(2000L);
        AppMethodBeat.o(222679);
        return;
        label328:
        i1 = i4;
        break;
        label334:
        i2 = i3;
        break label162;
        label339:
        this.m.setRetryInterval(this.k.r);
        this.m.setRetryTimes(this.k.q);
        this.m.setVideoDropParams(true, 40, 3000);
      }
    }
    if (this.m != null) {
      this.m.setAudioInfo(this.k.s, this.k.t);
    }
    label411:
    AppMethodBeat.o(222679);
  }
  
  private String R()
  {
    AppMethodBeat.i(222680);
    Object localObject = com.tencent.liteav.basic.d.c.a();
    String str = ((com.tencent.liteav.basic.d.c)localObject).c();
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(222680);
      return str;
    }
    localObject = TXCAudioEngine.buildTRAEConfig(this.n, null, ((com.tencent.liteav.basic.d.c)localObject).h(), ((com.tencent.liteav.basic.d.c)localObject).i());
    AppMethodBeat.o(222680);
    return localObject;
  }
  
  private void a(int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(14216);
    final int i1 = paramInt;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(14216);
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
            AppMethodBeat.i(13555);
            if (b.a(b.this) != null) {
              b.a(b.this).onPushEvent(i1, paramBundle);
            }
            AppMethodBeat.o(13555);
          }
        });
      }
      AppMethodBeat.o(14216);
      return;
      AppMethodBeat.o(14216);
      return;
      i1 = -1302;
      continue;
      AppMethodBeat.o(14216);
      return;
      AppMethodBeat.o(14216);
      return;
      i1 = 1008;
      continue;
      i1 = 1103;
      continue;
      AppMethodBeat.o(14216);
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
    }
  }
  
  private void a(TXSNALPacket paramTXSNALPacket, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14198);
    if (this.K == 0L) {
      this.K = paramTXSNALPacket.pts;
    }
    long l1 = paramTXSNALPacket.pts;
    long l2 = this.K;
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
      this.H.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramTXSNALPacket.pts * 1000L, i1);
      this.o.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222658);
          if (b.g(b.this) != null) {
            b.g(b.this).onRecordProgress(this.a);
          }
          AppMethodBeat.o(222658);
        }
      });
      AppMethodBeat.o(14198);
      return;
      i1 = paramTXSNALPacket.info.flags;
      continue;
      label110:
      i1 = 0;
    }
  }
  
  private void a(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(14199);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(14199);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13936);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        AppMethodBeat.o(13936);
      }
    });
    AppMethodBeat.o(14199);
  }
  
  private void a(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(14196);
    this.o.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14242);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = 0;
        localTXRecordResult.descMsg = "record success";
        localTXRecordResult.videoPath = paramString1;
        localTXRecordResult.coverPath = paramString2;
        if (b.g(b.this) != null) {
          b.g(b.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(b.x(), "record complete success");
        AppMethodBeat.o(14242);
      }
    });
    AppMethodBeat.o(14196);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(14200);
    int i1 = b(paramBoolean1, paramBoolean2);
    if (i1 == -1)
    {
      this.f.setAutoAdjustBitrate(false);
      this.f.setAutoAdjustStrategy(-1);
      AppMethodBeat.o(14200);
      return;
    }
    this.f.setAutoAdjustBitrate(true);
    this.f.setAutoAdjustStrategy(i1);
    AppMethodBeat.o(14200);
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14219);
    byte[] arrayOfByte1 = h(paramInt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1 + paramArrayOfByte.length + 1];
    arrayOfByte2[0] = -14;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    paramInt = arrayOfByte1.length + 1;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, paramInt, paramArrayOfByte.length);
    arrayOfByte2[(paramInt + paramArrayOfByte.length)] = -128;
    AppMethodBeat.o(14219);
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
    AppMethodBeat.i(14214);
    g localg = this.k;
    localg.c = paramTXLivePushConfig.mVideoBitrate;
    localg.e = paramTXLivePushConfig.mMinVideoBitrate;
    localg.d = paramTXLivePushConfig.mMaxVideoBitrate;
    localg.f = paramTXLivePushConfig.mAutoAdjustStrategy;
    localg.g = paramTXLivePushConfig.mAutoAdjustBitrate;
    localg.h = paramTXLivePushConfig.mVideoFPS;
    localg.i = paramTXLivePushConfig.mVideoEncodeGop;
    localg.j = paramTXLivePushConfig.mHardwareAccel;
    localg.k = paramTXLivePushConfig.mVideoResolution;
    if (paramTXLivePushConfig.mEnableVideoHardEncoderMainProfile) {}
    for (int i1 = 3;; i1 = 1)
    {
      localg.n = i1;
      localg.o = paramTXLivePushConfig.mLocalVideoMirrorType;
      localg.s = paramTXLivePushConfig.mAudioSample;
      localg.t = paramTXLivePushConfig.mAudioChannels;
      localg.u = paramTXLivePushConfig.mEnableAec;
      localg.v = paramTXLivePushConfig.mEnableAgc;
      localg.w = paramTXLivePushConfig.mEnableAns;
      localg.x = paramTXLivePushConfig.mVolumeType;
      localg.D = paramTXLivePushConfig.mPauseFlag;
      localg.C = paramTXLivePushConfig.mPauseFps;
      localg.A = paramTXLivePushConfig.mPauseImg;
      localg.B = paramTXLivePushConfig.mPauseTime;
      localg.M = paramTXLivePushConfig.mEnablePureAudioPush;
      localg.K = paramTXLivePushConfig.mTouchFocus;
      localg.L = paramTXLivePushConfig.mEnableZoom;
      localg.E = paramTXLivePushConfig.mWatermark;
      localg.F = paramTXLivePushConfig.mWatermarkX;
      localg.G = paramTXLivePushConfig.mWatermarkY;
      localg.H = paramTXLivePushConfig.mWatermarkXF;
      localg.I = paramTXLivePushConfig.mWatermarkYF;
      localg.J = paramTXLivePushConfig.mWatermarkWidth;
      localg.l = paramTXLivePushConfig.mHomeOrientation;
      localg.N = paramTXLivePushConfig.mEnableNearestIP;
      localg.O = paramTXLivePushConfig.mRtmpChannelType;
      localg.q = paramTXLivePushConfig.mConnectRetryCount;
      localg.r = paramTXLivePushConfig.mConnectRetryInterval;
      localg.m = paramTXLivePushConfig.mFrontCamera;
      localg.R = paramTXLivePushConfig.mCustomModeType;
      localg.S = paramTXLivePushConfig.mVideoEncoderXMirror;
      localg.T = paramTXLivePushConfig.mEnableHighResolutionCapture;
      localg.V = paramTXLivePushConfig.mEnableScreenCaptureAutoRotate;
      localg.z = paramTXLivePushConfig.mEnableAudioPreview;
      localg.a();
      AppMethodBeat.o(14214);
      return;
    }
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14217);
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
    AppMethodBeat.o(14217);
    return arrayOfByte;
  }
  
  private byte[] e(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14218);
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
    AppMethodBeat.o(14218);
    return paramArrayOfByte;
  }
  
  private boolean f(String paramString)
  {
    AppMethodBeat.i(222669);
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
                AppMethodBeat.o(222669);
                return true;
              }
              AppMethodBeat.o(222669);
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
      AppMethodBeat.o(222669);
    }
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
    }
    return "WIRED";
  }
  
  private void g(String paramString)
  {
    AppMethodBeat.i(222677);
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
    AppMethodBeat.o(222677);
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
    AppMethodBeat.i(182232);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(182232);
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
  
  private void y()
  {
    AppMethodBeat.i(14197);
    if ((this.C > 0) && (m()))
    {
      TXCAudioEngine.getInstance();
      TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
      if (this.F == null) {
        this.F = new a(null);
      }
      this.F.a(this.C);
      if (this.o != null)
      {
        this.o.removeCallbacks(this.F);
        this.o.postDelayed(this.F, this.C);
      }
    }
    AppMethodBeat.o(14197);
  }
  
  private void z()
  {
    AppMethodBeat.i(14202);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(false, 300);
    if (this.F != null) {
      this.F.a(0);
    }
    if (this.o != null) {
      this.o.removeCallbacks(this.F);
    }
    this.F = null;
    this.C = 0;
    AppMethodBeat.o(14202);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14179);
    if (this.i != null)
    {
      paramInt1 = this.i.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(14179);
      return paramInt1;
    }
    AppMethodBeat.o(14179);
    return 0;
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(14129);
    TXCLog.i(d, "liteav_api startPusher ".concat(String.valueOf(this)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e(d, "start push error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(14129);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.r)) && (m()))
    {
      if (this.r.equalsIgnoreCase(paramString))
      {
        TXCLog.w(d, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
        AppMethodBeat.o(14129);
        return -1;
      }
      TXCLog.w(d, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
      j();
    }
    TXCLog.i(d, "================================================================================================================================================");
    TXCLog.i(d, "================================================================================================================================================");
    TXCLog.i(d, "============= startPush pushUrl = " + paramString + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
    TXCLog.i(d, "================================================================================================================================================");
    TXCLog.i(d, "================================================================================================================================================");
    this.r = paramString;
    g(this.r);
    G();
    M();
    O();
    I();
    K();
    Monitor.a(this.r, 0, "");
    Monitor.a(1, "startPush", "", 0);
    C();
    if (this.e != null) {
      this.e.clearLog();
    }
    if (f(this.r)) {
      this.l.b(true);
    }
    y();
    AppMethodBeat.o(14129);
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14171);
    if (this.l != null)
    {
      switch (paramInt1)
      {
      case 4: 
      default: 
        AppMethodBeat.o(14171);
        return -1000;
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramInt1 = this.l.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0L);
        AppMethodBeat.o(14171);
        return paramInt1;
      }
    }
    AppMethodBeat.o(14171);
    return -1000;
  }
  
  public void a()
  {
    AppMethodBeat.i(14180);
    if (this.i != null) {
      this.i.onTextureDestoryed();
    }
    AppMethodBeat.o(14180);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(14147);
    TXCLog.i(d, "liteav_api setExposureCompensation ".concat(String.valueOf(paramFloat)));
    if (this.l == null)
    {
      AppMethodBeat.o(14147);
      return;
    }
    this.l.a(paramFloat);
    AppMethodBeat.o(14147);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(14137);
    if (this.l != null) {
      this.l.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(14137);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14143);
    TXCLog.i(d, "liteav_api setRenderRotation ");
    if (this.l == null)
    {
      AppMethodBeat.o(14143);
      return;
    }
    this.l.g(paramInt);
    AppMethodBeat.o(14143);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14136);
    TXCLog.i(d, "liteav_api setSurfaceSize " + paramInt1 + "," + paramInt2);
    if (this.l == null)
    {
      AppMethodBeat.o(14136);
      return;
    }
    this.l.a(paramInt1, paramInt2);
    AppMethodBeat.o(14136);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int i2 = 1;
    AppMethodBeat.i(14140);
    TXCLog.i(d, "liteav_api setVideoQuality " + paramInt + ", " + paramBoolean1 + ", " + paramBoolean2);
    Object localObject;
    label64:
    String str;
    label73:
    int i1;
    if (paramBoolean1)
    {
      localObject = "true";
      if (!paramBoolean2) {
        break label256;
      }
      str = "true";
      Monitor.a(1, String.format("setVideoQuality:[quality:%d][adjustBitrate:%s][adjustResolution:%s]", new Object[] { Integer.valueOf(paramInt), localObject, str }), "", 0);
      i1 = paramInt;
      if (Build.VERSION.SDK_INT < 18) {
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
      if ((!paramBoolean2) || (!paramBoolean1)) {
        break label264;
      }
    }
    label256:
    label264:
    for (paramInt = 1;; paramInt = 0) {
      switch (i1)
      {
      default: 
        this.f.setHardwareAcceleration(2);
        TXCLog.e(d, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i1)));
        AppMethodBeat.o(14140);
        return;
        localObject = "false";
        break label64;
        str = "false";
        break label73;
      }
    }
    this.f.enableAEC(false);
    this.f.setHardwareAcceleration(2);
    this.f.setVideoResolution(0);
    this.f.setAudioSampleRate(48000);
    a(paramBoolean1, paramBoolean2);
    if (paramInt != 0)
    {
      this.f.setMinVideoBitrate(301);
      this.f.setVideoBitrate(800);
      this.f.setMaxVideoBitrate(900);
      paramBoolean1 = false;
      paramBoolean2 = false;
      label347:
      this.h = i1;
      localObject = this.f;
      if (!paramBoolean2) {
        break label1326;
      }
      label363:
      ((TXLivePushConfig)localObject).enableVideoHardEncoderMainProfile(bool);
      localObject = this.f;
      if (!paramBoolean2) {
        break label1332;
      }
    }
    label1326:
    label1332:
    for (paramInt = i2;; paramInt = 3)
    {
      ((TXLivePushConfig)localObject).setVideoEncodeGop(paramInt);
      if (this.k != null)
      {
        this.k.P = paramBoolean2;
        this.k.Q = paramBoolean1;
      }
      a(this.f);
      AppMethodBeat.o(14140);
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
      break label347;
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
      break label347;
      if (Build.VERSION.SDK_INT < 18)
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
      break label347;
      bool = true;
      break label363;
    }
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(14135);
    TXCLog.i(d, "liteav_api setSurface ".concat(String.valueOf(paramSurface)));
    if (this.l == null)
    {
      AppMethodBeat.o(14135);
      return;
    }
    this.l.a(paramSurface);
    AppMethodBeat.o(14135);
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(14126);
    TXCLog.i(d, "liteav_api setPushListener ".concat(String.valueOf(paramITXLivePushListener)));
    this.g = paramITXLivePushListener;
    AppMethodBeat.o(14126);
  }
  
  public void a(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(14125);
    TXCLog.i(d, "liteav_api setConfig " + paramTXLivePushConfig + ", " + this);
    TXLivePushConfig localTXLivePushConfig = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localTXLivePushConfig = new TXLivePushConfig();
    }
    this.f = localTXLivePushConfig;
    b(localTXLivePushConfig);
    Q();
    Monitor.a(1, String.format("setConfig:[fps:%d][resolution:%d*%d][bitrate:%dkbps][minBitrate:%dkbps][maxBitrate:%dkbps][gop:%d][audioSampleRate:%d][customMode:%d]", new Object[] { Integer.valueOf(this.k.h), Integer.valueOf(this.k.a), Integer.valueOf(this.k.b), Integer.valueOf(this.k.c), Integer.valueOf(this.k.e), Integer.valueOf(this.k.d), Integer.valueOf(this.k.i), Integer.valueOf(this.k.s), Integer.valueOf(this.k.R) }), "", 0);
    AppMethodBeat.o(14125);
  }
  
  public void a(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    AppMethodBeat.i(14174);
    TXCLog.i(d, "liteav_api setAudioProcessListener ".concat(String.valueOf(paramAudioCustomProcessListener)));
    this.j = paramAudioCustomProcessListener;
    AppMethodBeat.o(14174);
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.B = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14169);
    TXCLog.i(d, "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.t) || (paramITXSnapshotListener == null) || (this.l == null))
    {
      AppMethodBeat.o(14169);
      return;
    }
    if (this.l != null)
    {
      this.t = true;
      this.l.a(new o()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(222668);
          b.a(b.this, paramITXSnapshotListener, paramAnonymousBitmap);
          b.a(b.this, false);
          b.c(b.this).removeCallbacks(b.e(b.this));
          AppMethodBeat.o(222668);
        }
      });
      this.o.postDelayed(this.G, 2000L);
      AppMethodBeat.o(14169);
      return;
    }
    this.t = false;
    AppMethodBeat.o(14169);
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(14154);
    TXCLog.i(d, "liteav_api setBGMNofify ".concat(String.valueOf(paramOnBGMNotify)));
    this.a = paramOnBGMNotify;
    if (this.a != null)
    {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.E);
      AppMethodBeat.o(14154);
      return;
    }
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
    AppMethodBeat.o(14154);
  }
  
  public void a(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(14173);
    TXCLog.i(d, "liteav_api setVideoProcessListener ".concat(String.valueOf(paramVideoCustomProcessListener)));
    this.i = paramVideoCustomProcessListener;
    if (this.i == null)
    {
      if (this.l != null)
      {
        this.l.a(null);
        AppMethodBeat.o(14173);
      }
    }
    else if (this.l != null) {
      this.l.a(this);
    }
    AppMethodBeat.o(14173);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14127);
    TXCLog.i(d, "liteav_api startCameraPreview " + paramTXCloudVideoView + ", " + this);
    StringBuilder localStringBuilder = new StringBuilder("startCameraPreview [view:");
    if (paramTXCloudVideoView != null) {}
    for (int i1 = paramTXCloudVideoView.hashCode();; i1 = 0)
    {
      Monitor.a(1, i1 + "]", "", 0);
      a(this.f);
      if (!this.k.M) {
        break;
      }
      TXCLog.e(d, "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(14127);
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
    this.l.a(paramTXCloudVideoView);
    this.l.b(this.f.mBeautyLevel, this.f.mWhiteningLevel, this.f.mRuddyLevel);
    LicenceCheck.a().a(null, this.n);
    AppMethodBeat.o(14127);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(14166);
    TXCLog.i(d, "liteav_api setVideoRecordListener ".concat(String.valueOf(paramITXVideoRecordListener)));
    this.M = paramITXVideoRecordListener;
    AppMethodBeat.o(14166);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(14188);
    if (this.m != null) {
      this.m.setDropEanble(paramBoolean);
    }
    AppMethodBeat.o(14188);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14172);
    TXCAudioEngine.getInstance().sendCustomPCMData(paramArrayOfByte, this.f.mAudioSample, this.f.mAudioChannels);
    AppMethodBeat.o(14172);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(14148);
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
    AppMethodBeat.o(14148);
    return true;
  }
  
  public int b()
  {
    AppMethodBeat.i(14181);
    int i1 = TXCStatus.c(this.s, 4002);
    AppMethodBeat.o(14181);
    return i1;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14187);
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
      Monitor.a(2, String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", new Object[] { Integer.valueOf(this.k.f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }), "", 0);
    }
    AppMethodBeat.o(14187);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(14128);
    TXCLog.i(d, "liteav_api stopCameraPreview " + paramBoolean + ", " + this);
    Monitor.a(1, "stopCameraPreview", "", 0);
    if (this.l == null)
    {
      AppMethodBeat.o(14128);
      return;
    }
    this.l.c(paramBoolean);
    AppMethodBeat.o(14128);
  }
  
  public boolean b(float paramFloat)
  {
    AppMethodBeat.i(222673);
    TXCLog.i(d, "liteav_api setBGMVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
    AppMethodBeat.o(222673);
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(14146);
    TXCLog.i(d, "liteav_api setZoom ".concat(String.valueOf(paramInt)));
    if (this.l == null)
    {
      AppMethodBeat.o(14146);
      return false;
    }
    boolean bool = this.l.i(paramInt);
    AppMethodBeat.o(14146);
    return bool;
  }
  
  public boolean b(String paramString)
  {
    AppMethodBeat.i(14152);
    TXCLog.i(d, "liteav_api playBGM ".concat(String.valueOf(paramString)));
    boolean bool = TXCLiveBGMPlayer.getInstance().startPlay(paramString);
    AppMethodBeat.o(14152);
    return bool;
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14175);
    if ((paramArrayOfByte.length <= 0) || (paramArrayOfByte.length > 2048))
    {
      AppMethodBeat.o(14175);
      return false;
    }
    try
    {
      if (this.A != null)
      {
        b localb = new b(null);
        localb.a = TXCTimeUtil.generatePtsMS();
        byte[] arrayOfByte = e(paramArrayOfByte);
        localb.b = a(paramArrayOfByte.length, arrayOfByte);
        this.A.add(localb);
      }
      return true;
    }
    finally
    {
      AppMethodBeat.o(14175);
    }
  }
  
  public int c()
  {
    AppMethodBeat.i(14182);
    int i1 = TXCStatus.c(this.s, 7002);
    if (this.k.P) {
      i1 += TXCStatus.c(this.s, 7001);
    }
    for (;;)
    {
      AppMethodBeat.o(14182);
      return i1;
      i1 += TXCStatus.c(this.s, 4002);
    }
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14170);
    if (this.l != null)
    {
      EGLContext localEGLContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
      paramInt1 = this.l.a(paramInt1, paramInt2, paramInt3, localEGLContext, 0L);
      AppMethodBeat.o(14170);
      return paramInt1;
    }
    AppMethodBeat.o(14170);
    return -1000;
  }
  
  public int c(String paramString)
  {
    AppMethodBeat.i(222672);
    int i1 = TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
    AppMethodBeat.o(222672);
    return i1;
  }
  
  @Deprecated
  public void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14176);
    try
    {
      if (this.A != null)
      {
        b localb = new b(null);
        localb.a = TXCTimeUtil.generatePtsMS();
        localb.b = e(paramArrayOfByte);
        this.A.add(localb);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14176);
    }
  }
  
  public boolean c(float paramFloat)
  {
    AppMethodBeat.i(14160);
    TXCLog.i(d, "liteav_api setMicVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = TXCAudioEngine.getInstance().setSoftwareCaptureVolume(paramFloat);
    AppMethodBeat.o(14160);
    return bool;
  }
  
  public boolean c(int paramInt)
  {
    AppMethodBeat.i(14163);
    TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt);
    AppMethodBeat.o(14163);
    return true;
  }
  
  public boolean c(boolean paramBoolean)
  {
    AppMethodBeat.i(14142);
    TXCLog.i(d, "liteav_api setMirror ".concat(String.valueOf(paramBoolean)));
    if (this.f != null) {
      this.f.setVideoEncoderXMirror(paramBoolean);
    }
    if (this.l == null)
    {
      AppMethodBeat.o(14142);
      return false;
    }
    this.l.f(paramBoolean);
    AppMethodBeat.o(14142);
    return true;
  }
  
  public int d()
  {
    AppMethodBeat.i(14183);
    if (this.m == null)
    {
      AppMethodBeat.o(14183);
      return 0;
    }
    int i1 = TXCStatus.c(this.s, 7004);
    int i2 = TXCStatus.c(this.s, 7003);
    AppMethodBeat.o(14183);
    return i1 + i2;
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(14159);
    TXCLog.i(d, "liteav_api startRecord ".concat(String.valueOf(paramString)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e(d, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(14159);
      return -3;
    }
    if (this.L)
    {
      TXCLog.w(d, "ignore start record when recording");
      AppMethodBeat.o(14159);
      return -1;
    }
    if ((this.l == null) || (!this.l.j()))
    {
      TXCLog.w(d, "ignore start record when not pushing");
      AppMethodBeat.o(14159);
      return -2;
    }
    TXCLog.w(d, "start record ");
    this.L = true;
    this.J = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    this.H = new com.tencent.liteav.muxer.c(this.n, 1);
    this.I = false;
    this.H.a(this.J);
    B();
    TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
    if (this.l != null) {
      this.l.t();
    }
    AppMethodBeat.o(14159);
    return 0;
  }
  
  public void d(float paramFloat)
  {
    AppMethodBeat.i(222674);
    TXCLog.i(d, "liteav_api setBGMPitch ".concat(String.valueOf(paramFloat)));
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
    AppMethodBeat.o(222674);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(14164);
    TXCLog.i(d, "liteav_api setReverb ".concat(String.valueOf(paramInt)));
    if ((paramInt < 0) || (paramInt > 7))
    {
      TXCLog.e(d, "reverbType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(14164);
      return;
    }
    TXCAudioEngine.getInstance().setReverbType(this.b[paramInt]);
    AppMethodBeat.o(14164);
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(14144);
    TXCLog.i(d, "liteav_api turnOnFlashLight ".concat(String.valueOf(paramBoolean)));
    if (this.l == null)
    {
      AppMethodBeat.o(14144);
      return false;
    }
    paramBoolean = this.l.e(paramBoolean);
    AppMethodBeat.o(14144);
    return paramBoolean;
  }
  
  public int e()
  {
    return 5;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(14165);
    TXCLog.i(d, "liteav_api setVoiceChangerType ".concat(String.valueOf(paramInt)));
    if ((paramInt < 0) || (paramInt > 11))
    {
      TXCLog.e(d, "voiceChangerType not support :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(14165);
      return;
    }
    TXCAudioEngine.getInstance().setVoiceChangerType(this.c[paramInt]);
    AppMethodBeat.o(14165);
  }
  
  public void e(String paramString)
  {
    AppMethodBeat.i(222676);
    TXCLog.i("User", paramString);
    AppMethodBeat.o(222676);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(14153);
    TXCLog.i(d, "liteav_api setMute ".concat(String.valueOf(paramBoolean)));
    StringBuilder localStringBuilder = new StringBuilder("setMute:");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      Monitor.a(1, str, "", 0);
      this.x = paramBoolean;
      TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
      if ((this.f.mEnablePureAudioPush) && (this.m != null)) {
        this.m.setAudioMute(paramBoolean);
      }
      AppMethodBeat.o(14153);
      return;
    }
  }
  
  public int f()
  {
    AppMethodBeat.i(14184);
    int i1 = TXCStatus.c(this.s, 7005);
    AppMethodBeat.o(14184);
    return i1;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(182228);
    TXCLog.i(d, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)));
    Monitor.a(1, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)), "", 0);
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.C = i1;
      y();
      AppMethodBeat.o(182228);
      return;
    }
    this.C = 0;
    z();
    AppMethodBeat.o(182228);
  }
  
  public int g()
  {
    AppMethodBeat.i(14185);
    int i1 = TXCStatus.c(this.s, 7007);
    AppMethodBeat.o(14185);
    return i1;
  }
  
  public int h()
  {
    AppMethodBeat.i(14186);
    int i1 = TXCStatus.c(this.s, 7021);
    AppMethodBeat.o(14186);
    return i1;
  }
  
  public TXLivePushConfig i()
  {
    return this.f;
  }
  
  public void j()
  {
    AppMethodBeat.i(14130);
    TXCLog.i(d, "liteav_api stopPusher ".concat(String.valueOf(this)));
    Monitor.a(1, "stopPush", "", 0);
    w();
    D();
    L();
    J();
    N();
    t();
    P();
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(false);
    this.x = false;
    this.k.P = false;
    H();
    this.r = "";
    this.y.clear();
    Monitor.a();
    this.l.b(false);
    z();
    TXCAudioEngine.getInstance().clean();
    AppMethodBeat.o(14130);
  }
  
  public void k()
  {
    AppMethodBeat.i(14132);
    TXCLog.i(d, "liteav_api pausePusher ".concat(String.valueOf(this)));
    Monitor.a(1, "pausePush", "", 0);
    if (this.l != null) {
      this.l.g();
    }
    TXCLog.i(d, "mPauseFlag:" + this.f.mPauseFlag);
    if ((this.f.mPauseFlag & 0x2) == 2) {
      TXCAudioEngine.getInstance().pauseAudioCapture(true);
    }
    AppMethodBeat.o(14132);
  }
  
  public void l()
  {
    AppMethodBeat.i(14133);
    TXCLog.i(d, "liteav_api resumePusher ".concat(String.valueOf(this)));
    Monitor.a(1, "resumePush", "", 0);
    if (this.l != null) {
      this.l.h();
    }
    TXCAudioEngine.getInstance().resumeAudioCapture();
    AppMethodBeat.o(14133);
  }
  
  public boolean m()
  {
    AppMethodBeat.i(14134);
    if (this.l != null)
    {
      boolean bool = this.l.j();
      AppMethodBeat.o(14134);
      return bool;
    }
    AppMethodBeat.o(14134);
    return false;
  }
  
  public void n()
  {
    AppMethodBeat.i(14138);
    TXCLog.i(d, "liteav_api startScreenCapture ");
    Monitor.a(1, "startScreenCapture", "", 0);
    if (this.l == null)
    {
      AppMethodBeat.o(14138);
      return;
    }
    this.l.a(null);
    AppMethodBeat.o(14138);
  }
  
  public void o()
  {
    AppMethodBeat.i(14139);
    TXCLog.i(d, "liteav_api stopScreenCapture ");
    Monitor.a(1, "stopScreenCapture", "", 0);
    if (this.l == null)
    {
      AppMethodBeat.o(14139);
      return;
    }
    this.l.l();
    AppMethodBeat.o(14139);
  }
  
  public void onBackgroudPushStop()
  {
    AppMethodBeat.i(14194);
    TXCAudioEngine.getInstance().resumeAudioCapture();
    TXCAudioEngine.getInstance().muteLocalAudio(false);
    AppMethodBeat.o(14194);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(14189);
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
        if ((this.A != null) && (!this.A.isEmpty()))
        {
          localObject1 = this.A.iterator();
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
            Iterator localIterator = this.A.iterator();
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
              this.A.remove(0);
              i3 += 1;
              continue;
            }
            System.arraycopy(paramTXSNALPacket.nalData, 0, localObject1, i2, paramTXSNALPacket.nalData.length);
            paramTXSNALPacket.nalData = ((byte[])localObject1);
          }
        }
        this.m.pushNAL(paramTXSNALPacket);
        if ((this.L) && (this.H != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null))
        {
          localObject1 = d(paramTXSNALPacket.nalData);
          if (!this.I)
          {
            if (paramTXSNALPacket.nalType != 0) {
              continue;
            }
            localObject2 = com.tencent.liteav.basic.util.f.a((byte[])localObject1, this.l.c(), this.l.d());
            if (localObject2 != null)
            {
              this.H.a((MediaFormat)localObject2);
              this.H.a();
              this.I = true;
              this.K = 0L;
            }
          }
          a(paramTXSNALPacket, (byte[])localObject1);
        }
        AppMethodBeat.o(14189);
        return;
      }
      finally
      {
        AppMethodBeat.o(14189);
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
    AppMethodBeat.i(14193);
    if ((this.L) && (this.H != null))
    {
      this.H.a(paramMediaFormat);
      if (!this.I)
      {
        this.H.a();
        this.I = true;
        this.K = 0L;
      }
    }
    AppMethodBeat.o(14193);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(14178);
    if (this.o != null) {
      this.o.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13547);
          if (b.f(b.this) != null) {
            b.f(b.this).setLogText(null, paramBundle, paramInt);
          }
          AppMethodBeat.o(13547);
        }
      });
    }
    if (paramInt < 0) {
      if (paramBundle == null) {
        break label88;
      }
    }
    label88:
    for (String str = paramBundle.getString("EVT_MSG");; str = "")
    {
      Monitor.a(3, String.format("%s [errcode:%d]", new Object[] { str, Integer.valueOf(paramInt) }), "", 0);
      a(paramInt, paramBundle);
      AppMethodBeat.o(14178);
      return;
    }
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14192);
    if ((this.L) && (this.H != null) && (this.I) && (paramArrayOfByte != null)) {
      this.H.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 0);
    }
    AppMethodBeat.o(14192);
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14191);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(14191);
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(14190);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    AppMethodBeat.o(14190);
  }
  
  public void p()
  {
    AppMethodBeat.i(14141);
    TXCLog.i(d, "liteav_api switchCamera ");
    Monitor.a(1, "switchCamera", "", 0);
    if (this.l == null)
    {
      AppMethodBeat.o(14141);
      return;
    }
    this.l.k();
    AppMethodBeat.o(14141);
  }
  
  public int q()
  {
    AppMethodBeat.i(14145);
    if (this.l == null)
    {
      AppMethodBeat.o(14145);
      return 0;
    }
    int i1 = this.l.q();
    AppMethodBeat.o(14145);
    return i1;
  }
  
  public TXBeautyManager r()
  {
    AppMethodBeat.i(14151);
    if (this.l == null) {
      this.l = new d(this.n);
    }
    TXBeautyManager localTXBeautyManager = this.l.b();
    AppMethodBeat.o(14151);
    return localTXBeautyManager;
  }
  
  public boolean s()
  {
    AppMethodBeat.i(14156);
    TXCLog.i(d, "liteav_api stopBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().stopPlay();
    AppMethodBeat.o(14156);
    return bool;
  }
  
  public void t()
  {
    AppMethodBeat.i(222670);
    TXCLog.i(d, "liteav_api stopAllBGM ");
    TXCLiveBGMPlayer.getInstance().stopAll();
    AppMethodBeat.o(222670);
  }
  
  public boolean u()
  {
    AppMethodBeat.i(14158);
    TXCLog.i(d, "liteav_api pauseBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().pause();
    AppMethodBeat.o(14158);
    return bool;
  }
  
  public boolean v()
  {
    AppMethodBeat.i(222671);
    TXCLog.i(d, "liteav_api resumeBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().resume();
    AppMethodBeat.o(222671);
    return bool;
  }
  
  public void w()
  {
    AppMethodBeat.i(222675);
    TXCLog.i(d, "liteav_api stopRecord ");
    if ((this.L) && (this.H != null))
    {
      int i1 = this.H.b();
      TXCLog.w(d, "start record ");
      this.L = false;
      if (i1 == 0)
      {
        AsyncTask.execute(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(13938);
            Object localObject = new File(this.a).getParentFile();
            String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
            localObject = localObject + File.separator + String.format("TXUGCCover_%s.jpg", new Object[] { str });
            com.tencent.liteav.basic.util.f.a(this.a, (String)localObject);
            b.a(b.this, this.a, (String)localObject);
            AppMethodBeat.o(13938);
          }
        });
        AppMethodBeat.o(222675);
        return;
      }
      A();
    }
    AppMethodBeat.o(222675);
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
      AppMethodBeat.i(182241);
      if (b.this.m())
      {
        int i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
        if (b.b(b.this) != null) {
          b.b(b.this).onAudioVolumeEvaluationNotify(i);
        }
      }
      if ((b.c(b.this) != null) && (this.b > 0)) {
        b.c(b.this).postDelayed(b.d(b.this), this.b);
      }
      AppMethodBeat.o(182241);
    }
  }
  
  class b
  {
    long a;
    byte[] b;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.b
 * JD-Core Version:    0.7.0.1
 */