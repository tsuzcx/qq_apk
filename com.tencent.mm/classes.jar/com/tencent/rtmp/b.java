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
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.basic.d.n;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.c.a;
import com.tencent.liteav.l;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.io.File;
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
  implements com.tencent.liteav.audio.e, com.tencent.liteav.basic.c.a, c.a, l, com.tencent.liteav.qos.a
{
  private static final String b;
  private float A;
  private HashSet<String> B;
  private HashMap<Integer, Long> C;
  private ArrayList<b> D;
  private TXLivePusher.ITXAudioVolumeEvaluationListener E;
  private int F;
  private com.tencent.liteav.audio.f G;
  private a H;
  private Runnable I;
  private com.tencent.liteav.muxer.c J;
  private boolean K;
  private String L;
  private long M;
  private boolean N;
  private TXRecordCommon.ITXVideoRecordListener O;
  private boolean P;
  TXLivePusher.OnBGMNotify a;
  private TXCloudVideoView c;
  private TXLivePushConfig d;
  private ITXLivePushListener e;
  private int f;
  private TXLivePusher.VideoCustomProcessListener g;
  private TXLivePusher.AudioCustomProcessListener h;
  private com.tencent.liteav.f i;
  private com.tencent.liteav.c j;
  private TXCStreamUploader k;
  private Context l;
  private Handler m;
  private TXCQoS n;
  private com.tencent.liteav.d o;
  private String p;
  private String q;
  private boolean r;
  private int s;
  private int t;
  private boolean u;
  private boolean v;
  private int w;
  private int x;
  private float y;
  private float z;
  
  static
  {
    AppMethodBeat.i(14224);
    b = b.class.getSimpleName();
    AppMethodBeat.o(14224);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(14124);
    this.d = null;
    this.e = null;
    this.f = -1;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = "";
    this.q = "";
    this.r = false;
    this.s = -1;
    this.t = -1;
    this.u = false;
    this.v = false;
    this.w = 0;
    this.x = 0;
    this.y = 1.0F;
    this.z = 1.0F;
    this.A = 0.0F;
    this.B = new HashSet();
    this.C = new HashMap();
    this.D = new ArrayList();
    this.E = null;
    this.F = 0;
    this.G = new com.tencent.liteav.audio.f()
    {
      public void onPlayEnd(int paramAnonymousInt)
      {
        AppMethodBeat.i(14007);
        if (b.this.a != null) {
          b.this.a.onBGMComplete(paramAnonymousInt);
        }
        AppMethodBeat.o(14007);
      }
      
      public void onPlayProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(14008);
        if (b.this.a != null) {
          b.this.a.onBGMProgress(paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(14008);
      }
      
      public void onPlayStart()
      {
        AppMethodBeat.i(14006);
        if (b.this.a != null) {
          b.this.a.onBGMStart();
        }
        AppMethodBeat.o(14006);
      }
    };
    this.H = null;
    this.I = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13555);
        b.a(b.this, false);
        AppMethodBeat.o(13555);
      }
    };
    this.J = null;
    this.K = false;
    this.L = "";
    this.M = 0L;
    this.N = false;
    this.P = false;
    this.d = new TXLivePushConfig();
    this.i = new com.tencent.liteav.f();
    this.l = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.l);
    TXCLog.init();
    this.m = new Handler(Looper.getMainLooper());
    com.tencent.liteav.audio.a.a(this.l);
    this.j = new com.tencent.liteav.c(this.l);
    this.j.d(true);
    this.j.a(this);
    com.tencent.liteav.basic.b.e.a().a(null, this.l);
    TXCTimeUtil.initAppStartTime();
    this.C.put(Integer.valueOf(-1303), Long.valueOf(0L));
    this.C.put(Integer.valueOf(1101), Long.valueOf(0L));
    this.C.put(Integer.valueOf(1006), Long.valueOf(0L));
    AppMethodBeat.o(14124);
  }
  
  @TargetApi(16)
  private void A()
  {
    AppMethodBeat.i(182229);
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.d.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
    if (this.J != null) {
      this.J.b(localMediaFormat);
    }
    AppMethodBeat.o(182229);
  }
  
  private void B()
  {
    AppMethodBeat.i(14203);
    this.P = true;
    if (this.m != null) {
      this.m.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13936);
          if (b.g(b.this)) {
            b.h(b.this);
          }
          AppMethodBeat.o(13936);
        }
      }, 2000L);
    }
    AppMethodBeat.o(14203);
  }
  
  private void C()
  {
    AppMethodBeat.i(14204);
    this.P = false;
    AppMethodBeat.o(14204);
  }
  
  private void D()
  {
    AppMethodBeat.i(14205);
    Object localObject = com.tencent.liteav.basic.util.d.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    i1 = TXCStatus.c(this.q, 7004);
    i2 = TXCStatus.c(this.q, 7003);
    int i3 = TXCStatus.c(this.q, 7002);
    int i4 = TXCStatus.c(this.q, 7001);
    int i5 = TXCStatus.c(this.q, 7007);
    int i6 = TXCStatus.c(this.q, 7005);
    int i7 = TXCStatus.c(this.q, 7006);
    String str = TXCStatus.b(this.q, 7012);
    double d2 = TXCStatus.d(this.q, 4001);
    int i8 = TXCStatus.c(this.q, 4006);
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
    if (this.j != null)
    {
      localBundle.putString("AUDIO_PLAY_INFO", com.tencent.liteav.audio.a.a().d() + " | " + this.d.mAudioSample + " , " + this.d.mAudioChannels);
      localBundle.putInt("VIDEO_WIDTH", this.j.c());
      localBundle.putInt("VIDEO_HEIGHT", this.j.d());
    }
    if (this.c != null) {
      this.c.setLogText(localBundle, null, 0);
    }
    if (this.e != null) {
      this.e.onNetStatus(localBundle);
    }
    if (this.o != null) {
      this.o.e();
    }
    i2 = com.tencent.liteav.basic.util.d.e(this.l);
    if (com.tencent.liteav.basic.util.d.a(this.l))
    {
      i1 = 1;
      if (this.s != i2)
      {
        Monitor.a(2, String.format("Network: net type change from %s to %s", new Object[] { g(this.s), g(i2) }), "", 0);
        this.s = i2;
      }
      if (this.t != i1) {
        if (i1 != 1) {
          break label637;
        }
      }
    }
    label637:
    for (localObject = "background";; localObject = "foreground")
    {
      Monitor.a(2, String.format("app: switch to %s", new Object[] { localObject }), "", 0);
      this.t = i1;
      if ((this.m != null) && (this.P)) {
        this.m.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(13997);
            if (b.g(b.this)) {
              b.h(b.this);
            }
            AppMethodBeat.o(13997);
          }
        }, 2000L);
      }
      AppMethodBeat.o(14205);
      return;
      i1 = 0;
      break;
    }
  }
  
  private void E()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(14206);
    h localh = new h();
    localh.d = this.d.mAudioChannels;
    localh.e = this.d.mAudioSample;
    localh.a = 0;
    localh.c = 20;
    localh.b = 0;
    localh.f = 3;
    localh.j = true;
    localh.l = true;
    localh.k = false;
    localh.h = 40;
    localh.i = 5000;
    localh.m = this.i.P;
    localh.n = this.i.Q;
    localh.o = i(this.f);
    this.k = new TXCStreamUploader(this.l, localh);
    this.k.setID(this.q);
    this.k.setMetaData(this.d.mMetaData);
    int i4;
    int i3;
    if ((this.i.R & 0x1) != 0)
    {
      if (this.k != null) {
        this.k.setAudioInfo(this.i.s, this.i.t);
      }
      this.k.setNotifyListener(this);
      if (this.i.M) {
        this.k.setAudioMute(this.v);
      }
      this.p = this.k.start(this.p, this.i.N, this.i.O);
      if (this.i.M) {
        this.k.setMode(1);
      }
      if (!this.i.P) {
        break label432;
      }
      i4 = this.i.q;
      i3 = this.i.r;
      if (i4 >= 5) {
        break label421;
      }
      label329:
      if (i3 <= 1) {
        break label427;
      }
      label334:
      this.k.setRetryInterval(i2);
      this.k.setRetryTimes(i1);
      this.k.setVideoDropParams(false, this.i.h, 1000);
    }
    for (;;)
    {
      this.k.setSendStrategy(this.i.P, this.i.Q);
      AppMethodBeat.o(14206);
      return;
      if (this.k == null) {
        break;
      }
      this.k.setAudioInfo(this.i.s, 1);
      break;
      label421:
      i1 = i4;
      break label329;
      label427:
      i2 = i3;
      break label334;
      label432:
      this.k.setRetryInterval(this.i.r);
      this.k.setRetryTimes(this.i.q);
      this.k.setVideoDropParams(true, 40, 3000);
    }
  }
  
  private void F()
  {
    AppMethodBeat.i(14207);
    if (this.k != null)
    {
      this.k.stop();
      this.k.setNotifyListener(null);
      this.k = null;
    }
    AppMethodBeat.o(14207);
  }
  
  private void G()
  {
    AppMethodBeat.i(14208);
    this.n = new TXCQoS(true);
    this.n.setListener(this);
    this.n.setNotifyListener(this);
    this.n.setAutoAdjustBitrate(this.i.g);
    this.n.setAutoAdjustStrategy(this.i.f);
    this.n.setDefaultVideoResolution(this.i.k);
    this.n.setVideoEncBitrate(this.i.e, this.i.d, this.i.c);
    if (this.i.g) {
      this.n.start(2000L);
    }
    AppMethodBeat.o(14208);
  }
  
  private void H()
  {
    AppMethodBeat.i(14209);
    if (this.n != null)
    {
      this.n.stop();
      this.n.setListener(null);
      this.n.setNotifyListener(null);
      this.n = null;
    }
    AppMethodBeat.o(14209);
  }
  
  private void I()
  {
    AppMethodBeat.i(14210);
    this.o = new com.tencent.liteav.d(this.l);
    this.o.d(this.q);
    this.o.a(this.i.c);
    this.o.b(this.i.s);
    this.o.a(this.i.a, this.i.b);
    this.o.a(this.p);
    this.o.a();
    AppMethodBeat.o(14210);
  }
  
  private void J()
  {
    AppMethodBeat.i(14211);
    if (this.o != null)
    {
      this.o.b();
      this.o = null;
    }
    AppMethodBeat.o(14211);
  }
  
  private void K()
  {
    AppMethodBeat.i(14212);
    if (this.j != null)
    {
      this.j.setID(this.q);
      this.j.a(this);
      this.j.e();
    }
    AppMethodBeat.o(14212);
  }
  
  private void L()
  {
    AppMethodBeat.i(14213);
    if (this.j != null)
    {
      this.j.a(null);
      this.j.f();
      this.j.a(null);
    }
    AppMethodBeat.o(14213);
  }
  
  private void M()
  {
    AppMethodBeat.i(14215);
    com.tencent.liteav.audio.a.a().a(this.x);
    com.tencent.liteav.audio.a.a().b(this.w);
    com.tencent.liteav.audio.a.a().a(this.y);
    com.tencent.liteav.audio.a.a().d(this.v);
    if ((this.d.mCustomModeType & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.liteav.audio.a.a().c(bool);
      com.tencent.liteav.audio.a.a().a(this);
      if (this.d != null) {
        com.tencent.liteav.audio.a.a().a(this.d.mAudioSample, this.d.mAudioChannels, 10);
      }
      AppMethodBeat.o(14215);
      return;
    }
  }
  
  private void N()
  {
    AppMethodBeat.i(182230);
    com.tencent.liteav.audio.a.a().c();
    AppMethodBeat.o(182230);
  }
  
  private void O()
  {
    int i1 = 5;
    int i2 = 1;
    AppMethodBeat.i(182231);
    if (this.j == null)
    {
      AppMethodBeat.o(182231);
      return;
    }
    com.tencent.liteav.audio.a.a().c(this.i.v, 100);
    com.tencent.liteav.audio.a.a().b(this.i.w, 100);
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.d(this.i.x);
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.f(this.i.z);
    this.j.a(this.i);
    this.j.c(this.i.o);
    if (this.j.j())
    {
      int i4;
      int i3;
      if (this.k != null)
      {
        if (!this.i.P) {
          break label339;
        }
        i4 = this.i.q;
        i3 = this.i.r;
        if (i4 >= 5) {
          break label328;
        }
        if (i3 <= 1) {
          break label334;
        }
        label162:
        this.k.setRetryInterval(i2);
        this.k.setRetryTimes(i1);
        this.k.setVideoDropParams(false, this.i.h, 1000);
      }
      for (;;)
      {
        this.k.setSendStrategy(this.i.P, this.i.Q);
        if (this.n == null) {
          break label452;
        }
        this.n.stop();
        this.n.setAutoAdjustBitrate(this.i.g);
        this.n.setAutoAdjustStrategy(this.i.f);
        this.n.setDefaultVideoResolution(this.i.k);
        this.n.setVideoEncBitrate(this.i.e, this.i.d, this.i.c);
        if (!this.i.g) {
          break label452;
        }
        this.n.start(2000L);
        AppMethodBeat.o(182231);
        return;
        label328:
        i1 = i4;
        break;
        label334:
        i2 = i3;
        break label162;
        label339:
        this.k.setRetryInterval(this.i.r);
        this.k.setRetryTimes(this.i.q);
        this.k.setVideoDropParams(true, 40, 3000);
      }
    }
    if ((this.i.R & 0x1) != 0)
    {
      if (this.k != null)
      {
        this.k.setAudioInfo(this.i.s, this.i.t);
        AppMethodBeat.o(182231);
      }
    }
    else if (this.k != null) {
      this.k.setAudioInfo(this.i.s, 1);
    }
    label452:
    AppMethodBeat.o(182231);
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
      if (this.m != null) {
        this.m.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14060);
            if (b.i(b.this) != null) {
              b.i(b.this).onPushEvent(i1, paramBundle);
            }
            AppMethodBeat.o(14060);
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
    if (this.M == 0L) {
      this.M = paramTXSNALPacket.pts;
    }
    long l1 = paramTXSNALPacket.pts;
    long l2 = this.M;
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
      this.J.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramTXSNALPacket.pts * 1000L, i1);
      this.m.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13998);
          if (b.f(b.this) != null) {
            b.f(b.this).onRecordProgress(this.a);
          }
          AppMethodBeat.o(13998);
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
        AppMethodBeat.i(14242);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        AppMethodBeat.o(14242);
      }
    });
    AppMethodBeat.o(14199);
  }
  
  private void a(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(14196);
    this.m.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13547);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = 0;
        localTXRecordResult.descMsg = "record success";
        localTXRecordResult.videoPath = paramString1;
        localTXRecordResult.coverPath = paramString2;
        if (b.f(b.this) != null) {
          b.f(b.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(b.w(), "record complete success");
        AppMethodBeat.o(13547);
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
      this.d.setAutoAdjustBitrate(false);
      this.d.setAutoAdjustStrategy(-1);
      AppMethodBeat.o(14200);
      return;
    }
    this.d.setAutoAdjustBitrate(true);
    this.d.setAutoAdjustStrategy(i1);
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
    com.tencent.liteav.f localf = this.i;
    localf.c = paramTXLivePushConfig.mVideoBitrate;
    localf.e = paramTXLivePushConfig.mMinVideoBitrate;
    localf.d = paramTXLivePushConfig.mMaxVideoBitrate;
    localf.f = paramTXLivePushConfig.mAutoAdjustStrategy;
    localf.g = paramTXLivePushConfig.mAutoAdjustBitrate;
    localf.h = paramTXLivePushConfig.mVideoFPS;
    localf.i = paramTXLivePushConfig.mVideoEncodeGop;
    localf.j = paramTXLivePushConfig.mHardwareAccel;
    localf.k = paramTXLivePushConfig.mVideoResolution;
    if (paramTXLivePushConfig.mEnableVideoHardEncoderMainProfile) {}
    for (int i1 = 3;; i1 = 1)
    {
      localf.n = i1;
      localf.o = paramTXLivePushConfig.mLocalVideoMirrorType;
      localf.s = paramTXLivePushConfig.mAudioSample;
      localf.t = paramTXLivePushConfig.mAudioChannels;
      localf.u = paramTXLivePushConfig.mEnableAec;
      localf.v = paramTXLivePushConfig.mEnableAgc;
      localf.w = paramTXLivePushConfig.mEnableAns;
      localf.x = paramTXLivePushConfig.mVolumeType;
      localf.D = paramTXLivePushConfig.mPauseFlag;
      localf.C = paramTXLivePushConfig.mPauseFps;
      localf.A = paramTXLivePushConfig.mPauseImg;
      localf.B = paramTXLivePushConfig.mPauseTime;
      localf.M = paramTXLivePushConfig.mEnablePureAudioPush;
      localf.K = paramTXLivePushConfig.mTouchFocus;
      localf.L = paramTXLivePushConfig.mEnableZoom;
      localf.E = paramTXLivePushConfig.mWatermark;
      localf.F = paramTXLivePushConfig.mWatermarkX;
      localf.G = paramTXLivePushConfig.mWatermarkY;
      localf.H = paramTXLivePushConfig.mWatermarkXF;
      localf.I = paramTXLivePushConfig.mWatermarkYF;
      localf.J = paramTXLivePushConfig.mWatermarkWidth;
      localf.l = paramTXLivePushConfig.mHomeOrientation;
      localf.N = paramTXLivePushConfig.mEnableNearestIP;
      localf.O = paramTXLivePushConfig.mRtmpChannelType;
      localf.q = paramTXLivePushConfig.mConnectRetryCount;
      localf.r = paramTXLivePushConfig.mConnectRetryInterval;
      localf.m = paramTXLivePushConfig.mFrontCamera;
      localf.R = paramTXLivePushConfig.mCustomModeType;
      localf.S = paramTXLivePushConfig.mVideoEncoderXMirror;
      localf.T = paramTXLivePushConfig.mEnableHighResolutionCapture;
      localf.V = paramTXLivePushConfig.mEnableScreenCaptureAutoRotate;
      localf.z = paramTXLivePushConfig.mEnableAudioPreview;
      localf.a();
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
  
  private boolean g(String paramString)
  {
    AppMethodBeat.i(14131);
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
                AppMethodBeat.o(14131);
                return true;
              }
              AppMethodBeat.o(14131);
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
      TXCLog.w(b, "parse black stream flag error " + paramString.toString());
      AppMethodBeat.o(14131);
    }
  }
  
  private void h(String paramString)
  {
    AppMethodBeat.i(14201);
    if (this.k != null) {
      this.k.setID(paramString);
    }
    if (this.j != null) {
      this.j.setID(paramString);
    }
    if (this.o != null) {
      this.o.d(paramString);
    }
    com.tencent.liteav.audio.a.a().a(paramString);
    this.q = paramString;
    AppMethodBeat.o(14201);
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
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "RTC");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkMain");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkSub");
    }
  }
  
  private void x()
  {
    AppMethodBeat.i(14195);
    if ((this.F > 0) && (m()))
    {
      com.tencent.liteav.audio.a.a();
      com.tencent.liteav.audio.a.a(true);
      if (this.H == null) {
        this.H = new a(null);
      }
      this.H.a(this.F);
      if (this.m != null)
      {
        this.m.removeCallbacks(this.H);
        this.m.postDelayed(this.H, this.F);
      }
    }
    AppMethodBeat.o(14195);
  }
  
  private void y()
  {
    AppMethodBeat.i(14197);
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.a(false);
    if (this.H != null) {
      this.H.a(0);
    }
    if (this.m != null) {
      this.m.removeCallbacks(this.H);
    }
    this.H = null;
    this.F = 0;
    AppMethodBeat.o(14197);
  }
  
  private void z()
  {
    AppMethodBeat.i(14202);
    this.m.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13992);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = -1;
        localTXRecordResult.descMsg = "record video failed";
        if (b.f(b.this) != null) {
          b.f(b.this).onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(b.w(), "record complete fail");
        AppMethodBeat.o(13992);
      }
    });
    AppMethodBeat.o(14202);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14179);
    if (this.g != null)
    {
      paramInt1 = this.g.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(14179);
      return paramInt1;
    }
    AppMethodBeat.o(14179);
    return 0;
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(14129);
    TXCLog.i(b, "liteav_api startPusher ".concat(String.valueOf(this)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e(b, "start push error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(14129);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.p)) && (m()))
    {
      if (this.p.equalsIgnoreCase(paramString))
      {
        TXCLog.w(b, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
        AppMethodBeat.o(14129);
        return -1;
      }
      TXCLog.w(b, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
      j();
    }
    TXCLog.i(b, "================================================================================================================================================");
    TXCLog.i(b, "================================================================================================================================================");
    TXCLog.i(b, "============= startPush pushUrl = " + paramString + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
    TXCLog.i(b, "================================================================================================================================================");
    TXCLog.i(b, "================================================================================================================================================");
    this.p = paramString;
    h(this.p);
    E();
    K();
    M();
    G();
    I();
    Monitor.a(this.p, 0, "");
    Monitor.a(1, "startPush", "", 0);
    B();
    if (this.c != null) {
      this.c.clearLog();
    }
    if (g(this.p)) {
      this.j.b(true);
    }
    x();
    AppMethodBeat.o(14129);
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14171);
    if (this.j != null)
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
        paramInt1 = this.j.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0L);
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
    if (this.g != null) {
      this.g.onTextureDestoryed();
    }
    AppMethodBeat.o(14180);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(14147);
    TXCLog.i(b, "liteav_api setExposureCompensation ".concat(String.valueOf(paramFloat)));
    if (this.j == null)
    {
      AppMethodBeat.o(14147);
      return;
    }
    this.j.b(paramFloat);
    AppMethodBeat.o(14147);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(14137);
    if (this.j != null) {
      this.j.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(14137);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14143);
    TXCLog.i(b, "liteav_api setRenderRotation ");
    if (this.j == null)
    {
      AppMethodBeat.o(14143);
      return;
    }
    this.j.h(paramInt);
    AppMethodBeat.o(14143);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14136);
    TXCLog.i(b, "liteav_api setSurfaceSize " + paramInt1 + "," + paramInt2);
    if (this.j == null)
    {
      AppMethodBeat.o(14136);
      return;
    }
    this.j.a(paramInt1, paramInt2);
    AppMethodBeat.o(14136);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int i2 = 1;
    AppMethodBeat.i(14140);
    TXCLog.i(b, "liteav_api setVideoQuality " + paramInt + ", " + paramBoolean1 + ", " + paramBoolean2);
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
      if (this.d == null) {
        this.d = new TXLivePushConfig();
      }
      this.d.setVideoFPS(18);
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
        this.d.setHardwareAcceleration(2);
        TXCLog.e(b, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i1)));
        AppMethodBeat.o(14140);
        return;
        localObject = "false";
        break label64;
        str = "false";
        break label73;
      }
    }
    this.d.enableAEC(false);
    this.d.setHardwareAcceleration(2);
    this.d.setVideoResolution(0);
    this.d.setAudioSampleRate(48000);
    a(paramBoolean1, paramBoolean2);
    if (paramInt != 0)
    {
      this.d.setMinVideoBitrate(301);
      this.d.setVideoBitrate(800);
      this.d.setMaxVideoBitrate(900);
      paramBoolean1 = false;
      paramBoolean2 = false;
      label347:
      this.f = i1;
      localObject = this.d;
      if (!paramBoolean2) {
        break label1326;
      }
      label363:
      ((TXLivePushConfig)localObject).enableVideoHardEncoderMainProfile(bool);
      localObject = this.d;
      if (!paramBoolean2) {
        break label1332;
      }
    }
    label1326:
    label1332:
    for (paramInt = i2;; paramInt = 3)
    {
      ((TXLivePushConfig)localObject).setVideoEncodeGop(paramInt);
      if (this.i != null)
      {
        this.i.P = paramBoolean2;
        this.i.Q = paramBoolean1;
      }
      a(this.d);
      AppMethodBeat.o(14140);
      return;
      this.d.setMinVideoBitrate(500);
      this.d.setVideoBitrate(800);
      this.d.setMaxVideoBitrate(900);
      break;
      this.d.enableAEC(false);
      this.d.setHardwareAcceleration(2);
      this.d.setVideoResolution(1);
      this.d.setAudioSampleRate(48000);
      a(paramBoolean1, paramBoolean2);
      if (paramInt != 0)
      {
        this.d.setMinVideoBitrate(600);
        this.d.setVideoBitrate(1200);
        this.d.setMaxVideoBitrate(1500);
      }
      for (;;)
      {
        paramBoolean1 = false;
        paramBoolean2 = false;
        break;
        this.d.setMinVideoBitrate(800);
        this.d.setVideoBitrate(1200);
        this.d.setMaxVideoBitrate(1500);
      }
      this.d.enableAEC(false);
      this.d.setHardwareAcceleration(1);
      this.d.setVideoResolution(2);
      this.d.setAudioSampleRate(48000);
      a(paramBoolean1, paramBoolean2);
      if (paramInt != 0)
      {
        this.d.setMinVideoBitrate(600);
        this.d.setVideoBitrate(1800);
        this.d.setMaxVideoBitrate(1800);
      }
      for (;;)
      {
        paramBoolean1 = false;
        paramBoolean2 = false;
        break;
        this.d.setMinVideoBitrate(1000);
        this.d.setVideoBitrate(1800);
        this.d.setMaxVideoBitrate(1800);
      }
      this.d.enableAEC(false);
      this.d.setHardwareAcceleration(1);
      this.d.setVideoResolution(30);
      this.d.setAudioSampleRate(48000);
      a(paramBoolean1, false);
      this.d.setMinVideoBitrate(2500);
      this.d.setVideoBitrate(3000);
      this.d.setMaxVideoBitrate(3000);
      paramBoolean1 = false;
      paramBoolean2 = false;
      break label347;
      this.d.enableAEC(true);
      this.d.setHardwareAcceleration(1);
      this.d.setVideoResolution(0);
      this.d.setAudioSampleRate(48000);
      this.d.setAutoAdjustBitrate(true);
      this.d.setAutoAdjustStrategy(5);
      this.d.setMinVideoBitrate(190);
      this.d.setVideoBitrate(400);
      this.d.setMaxVideoBitrate(810);
      paramBoolean1 = true;
      paramBoolean2 = true;
      break label347;
      if (Build.VERSION.SDK_INT < 18)
      {
        this.d.enableAEC(true);
        this.d.setHardwareAcceleration(0);
        this.d.setVideoResolution(0);
        this.d.setAutoAdjustBitrate(true);
        this.d.setAutoAdjustStrategy(4);
        this.d.setMinVideoBitrate(500);
        this.d.setVideoBitrate(800);
        this.d.setMaxVideoBitrate(900);
      }
      for (;;)
      {
        this.d.setAudioSampleRate(48000);
        paramBoolean1 = false;
        paramBoolean2 = true;
        break;
        if (this.f == 1)
        {
          this.d.enableAEC(true);
          this.d.setHardwareAcceleration(1);
          this.d.setVideoResolution(0);
          this.d.setAutoAdjustBitrate(true);
          this.d.setAutoAdjustStrategy(4);
          this.d.setMinVideoBitrate(500);
          this.d.setVideoBitrate(800);
          this.d.setMaxVideoBitrate(900);
        }
        else if (this.f == 3)
        {
          this.d.enableAEC(true);
          this.d.setHardwareAcceleration(1);
          this.d.setVideoResolution(2);
          this.d.setAutoAdjustBitrate(true);
          this.d.setAutoAdjustStrategy(4);
          this.d.setMinVideoBitrate(1000);
          this.d.setVideoBitrate(1800);
          this.d.setMaxVideoBitrate(1800);
        }
        else if (this.f == 7)
        {
          this.d.enableAEC(true);
          this.d.setHardwareAcceleration(1);
          this.d.setVideoResolution(30);
          this.d.setAutoAdjustBitrate(true);
          this.d.setAutoAdjustStrategy(4);
          this.d.setMinVideoBitrate(2000);
          this.d.setVideoBitrate(3000);
          this.d.setMaxVideoBitrate(3000);
        }
        else
        {
          this.d.enableAEC(true);
          this.d.setHardwareAcceleration(1);
          this.d.setVideoResolution(1);
          this.d.setAutoAdjustBitrate(true);
          this.d.setAutoAdjustStrategy(4);
          this.d.setMinVideoBitrate(800);
          this.d.setVideoBitrate(1200);
          this.d.setMaxVideoBitrate(1500);
        }
      }
      this.d.enableAEC(true);
      this.d.setHardwareAcceleration(1);
      this.d.setVideoResolution(6);
      this.d.setAutoAdjustBitrate(false);
      this.d.setVideoBitrate(350);
      this.d.setAudioSampleRate(48000);
      paramBoolean1 = false;
      paramBoolean2 = true;
      break label347;
      bool = true;
      break label363;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(14149);
    TXCLog.d(b, "liteav_api setFilter ".concat(String.valueOf(paramBitmap)));
    if (this.j != null) {
      this.j.a(paramBitmap);
    }
    AppMethodBeat.o(14149);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(14135);
    TXCLog.i(b, "liteav_api setSurface ".concat(String.valueOf(paramSurface)));
    if (this.j == null)
    {
      AppMethodBeat.o(14135);
      return;
    }
    this.j.a(paramSurface);
    AppMethodBeat.o(14135);
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(14126);
    TXCLog.i(b, "liteav_api setPushListener ".concat(String.valueOf(paramITXLivePushListener)));
    this.e = paramITXLivePushListener;
    AppMethodBeat.o(14126);
  }
  
  public void a(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(14125);
    TXCLog.i(b, "liteav_api setConfig " + paramTXLivePushConfig + ", " + this);
    TXLivePushConfig localTXLivePushConfig = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localTXLivePushConfig = new TXLivePushConfig();
    }
    if ((localTXLivePushConfig.mCustomModeType & 0x1) == 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        localTXLivePushConfig.setAudioChannels(1);
      }
      this.d = localTXLivePushConfig;
      b(localTXLivePushConfig);
      O();
      Monitor.a(1, String.format("setConfig:[fps:%d][resolution:%d*%d][bitrate:%dkbps][minBitrate:%dkbps][maxBitrate:%dkbps][gop:%d][audioSampleRate:%d][customMode:%d]", new Object[] { Integer.valueOf(this.i.h), Integer.valueOf(this.i.a), Integer.valueOf(this.i.b), Integer.valueOf(this.i.c), Integer.valueOf(this.i.e), Integer.valueOf(this.i.d), Integer.valueOf(this.i.i), Integer.valueOf(this.i.s), Integer.valueOf(this.i.R) }), "", 0);
      AppMethodBeat.o(14125);
      return;
    }
  }
  
  public void a(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    AppMethodBeat.i(14174);
    TXCLog.i(b, "liteav_api setAudioProcessListener ".concat(String.valueOf(paramAudioCustomProcessListener)));
    this.h = paramAudioCustomProcessListener;
    AppMethodBeat.o(14174);
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.E = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14169);
    TXCLog.i(b, "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.r) || (paramITXSnapshotListener == null) || (this.j == null))
    {
      AppMethodBeat.o(14169);
      return;
    }
    if (this.j != null)
    {
      this.r = true;
      this.j.a(new n()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(182242);
          b.a(b.this, paramITXSnapshotListener, paramAnonymousBitmap);
          b.a(b.this, false);
          b.b(b.this).removeCallbacks(b.d(b.this));
          AppMethodBeat.o(182242);
        }
      });
      this.m.postDelayed(this.I, 2000L);
      AppMethodBeat.o(14169);
      return;
    }
    this.r = false;
    AppMethodBeat.o(14169);
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(14154);
    TXCLog.i(b, "liteav_api setBGMNofify ".concat(String.valueOf(paramOnBGMNotify)));
    this.a = paramOnBGMNotify;
    if (this.a != null)
    {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.G);
      AppMethodBeat.o(14154);
      return;
    }
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
    AppMethodBeat.o(14154);
  }
  
  public void a(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(14173);
    TXCLog.i(b, "liteav_api setVideoProcessListener ".concat(String.valueOf(paramVideoCustomProcessListener)));
    this.g = paramVideoCustomProcessListener;
    if (this.g == null)
    {
      if (this.j != null)
      {
        this.j.a(null);
        AppMethodBeat.o(14173);
      }
    }
    else if (this.j != null) {
      this.j.a(this);
    }
    AppMethodBeat.o(14173);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14127);
    TXCLog.i(b, "liteav_api startCameraPreview " + paramTXCloudVideoView + ", " + this);
    StringBuilder localStringBuilder = new StringBuilder("startCameraPreview [view:");
    if (paramTXCloudVideoView != null) {}
    for (int i1 = paramTXCloudVideoView.hashCode();; i1 = 0)
    {
      Monitor.a(1, i1 + "]", "", 0);
      a(this.d);
      if (!this.i.M) {
        break;
      }
      TXCLog.e(b, "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(14127);
      return;
    }
    if ((this.c != paramTXCloudVideoView) && (this.c != null)) {
      this.c.removeVideoView();
    }
    this.c = paramTXCloudVideoView;
    if (this.j == null) {
      this.j = new com.tencent.liteav.c(this.l);
    }
    this.j.a(this);
    this.j.a(this);
    this.j.a(paramTXCloudVideoView);
    this.j.b(this.d.mBeautyLevel, this.d.mWhiteningLevel, this.d.mRuddyLevel);
    com.tencent.liteav.basic.b.e.a().a(null, this.l);
    AppMethodBeat.o(14127);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(14166);
    TXCLog.i(b, "liteav_api setVideoRecordListener ".concat(String.valueOf(paramITXVideoRecordListener)));
    this.O = paramITXVideoRecordListener;
    AppMethodBeat.o(14166);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(14188);
    if (this.k != null) {
      this.k.setDropEanble(paramBoolean);
    }
    AppMethodBeat.o(14188);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14172);
    com.tencent.liteav.audio.a.a().a(paramArrayOfByte);
    AppMethodBeat.o(14172);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(14148);
    if (this.j != null)
    {
      this.j.i(paramInt1);
      this.j.b(paramInt2, paramInt3, paramInt4);
    }
    if (this.d != null)
    {
      this.d.mBeautyLevel = paramInt2;
      this.d.mWhiteningLevel = paramInt3;
      this.d.mRuddyLevel = paramInt4;
    }
    AppMethodBeat.o(14148);
    return true;
  }
  
  public int b()
  {
    AppMethodBeat.i(14181);
    int i1 = TXCStatus.c(this.q, 4002);
    AppMethodBeat.o(14181);
    return i1;
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(14150);
    com.tencent.liteav.basic.b.e.a().a(null, this.l);
    if (this.j != null) {
      this.j.a(paramFloat);
    }
    AppMethodBeat.o(14150);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14187);
    if (this.j != null) {
      this.j.a(paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.i.a = paramInt2;
      this.i.b = paramInt3;
    }
    if (paramInt1 != 0)
    {
      this.i.c = paramInt1;
      Monitor.a(2, String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", new Object[] { Integer.valueOf(this.i.f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }), "", 0);
    }
    AppMethodBeat.o(14187);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(14128);
    TXCLog.i(b, "liteav_api stopCameraPreview " + paramBoolean + ", " + this);
    Monitor.a(1, "stopCameraPreview", "", 0);
    if (this.j == null)
    {
      AppMethodBeat.o(14128);
      return;
    }
    this.j.c(paramBoolean);
    AppMethodBeat.o(14128);
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(14146);
    TXCLog.i(b, "liteav_api setZoom ".concat(String.valueOf(paramInt)));
    if (this.j == null)
    {
      AppMethodBeat.o(14146);
      return false;
    }
    boolean bool = this.j.p(paramInt);
    AppMethodBeat.o(14146);
    return bool;
  }
  
  @TargetApi(18)
  public boolean b(String paramString)
  {
    AppMethodBeat.i(14152);
    TXCLog.i(b, "liteav_api setGreenScreenFile ".concat(String.valueOf(paramString)));
    com.tencent.liteav.basic.b.e.a().a(null, this.l);
    if (this.j != null)
    {
      boolean bool = this.j.b(paramString);
      AppMethodBeat.o(14152);
      return bool;
    }
    AppMethodBeat.o(14152);
    return false;
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
      AppMethodBeat.o(14175);
    }
  }
  
  public int c()
  {
    AppMethodBeat.i(14182);
    int i1 = TXCStatus.c(this.q, 7002);
    if (this.i.P) {
      i1 += TXCStatus.c(this.q, 7001);
    }
    for (;;)
    {
      AppMethodBeat.o(14182);
      return i1;
      i1 += TXCStatus.c(this.q, 4002);
    }
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14170);
    if (this.j != null)
    {
      EGLContext localEGLContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
      paramInt1 = this.j.a(paramInt1, paramInt2, paramInt3, localEGLContext, 0L);
      AppMethodBeat.o(14170);
      return paramInt1;
    }
    AppMethodBeat.o(14170);
    return -1000;
  }
  
  @Deprecated
  public void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14176);
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
      AppMethodBeat.o(14176);
    }
  }
  
  public boolean c(float paramFloat)
  {
    AppMethodBeat.i(14160);
    TXCLog.i(b, "liteav_api setBGMVolume ".concat(String.valueOf(paramFloat)));
    this.z = paramFloat;
    boolean bool = TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
    AppMethodBeat.o(14160);
    return bool;
  }
  
  public boolean c(int paramInt)
  {
    AppMethodBeat.i(14163);
    if (TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt) == 0)
    {
      AppMethodBeat.o(14163);
      return true;
    }
    AppMethodBeat.o(14163);
    return false;
  }
  
  public boolean c(String paramString)
  {
    AppMethodBeat.i(14155);
    TXCLog.i(b, "liteav_api playBGM ".concat(String.valueOf(paramString)));
    boolean bool = TXCLiveBGMPlayer.getInstance().startPlay(paramString);
    AppMethodBeat.o(14155);
    return bool;
  }
  
  public boolean c(boolean paramBoolean)
  {
    AppMethodBeat.i(14142);
    TXCLog.i(b, "liteav_api setMirror ".concat(String.valueOf(paramBoolean)));
    if (this.d != null) {
      this.d.setVideoEncoderXMirror(paramBoolean);
    }
    if (this.j == null)
    {
      AppMethodBeat.o(14142);
      return false;
    }
    this.j.g(paramBoolean);
    AppMethodBeat.o(14142);
    return true;
  }
  
  public int d()
  {
    AppMethodBeat.i(14183);
    if (this.k == null)
    {
      AppMethodBeat.o(14183);
      return 0;
    }
    int i1 = TXCStatus.c(this.q, 7004);
    int i2 = TXCStatus.c(this.q, 7003);
    AppMethodBeat.o(14183);
    return i1 + i2;
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(14159);
    int i1 = TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
    AppMethodBeat.o(14159);
    return i1;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(14164);
    TXCLog.i(b, "liteav_api setReverb ".concat(String.valueOf(paramInt)));
    this.x = paramInt;
    com.tencent.liteav.audio.a.a().a(paramInt);
    AppMethodBeat.o(14164);
  }
  
  public boolean d(float paramFloat)
  {
    AppMethodBeat.i(14161);
    TXCLog.i(b, "liteav_api setMicVolume ".concat(String.valueOf(paramFloat)));
    this.y = paramFloat;
    boolean bool = com.tencent.liteav.audio.a.a().a(paramFloat);
    AppMethodBeat.o(14161);
    return bool;
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(14144);
    TXCLog.i(b, "liteav_api turnOnFlashLight ".concat(String.valueOf(paramBoolean)));
    if (this.j == null)
    {
      AppMethodBeat.o(14144);
      return false;
    }
    paramBoolean = this.j.e(paramBoolean);
    AppMethodBeat.o(14144);
    return paramBoolean;
  }
  
  public int e()
  {
    return 5;
  }
  
  public int e(String paramString)
  {
    AppMethodBeat.i(14167);
    TXCLog.i(b, "liteav_api startRecord ".concat(String.valueOf(paramString)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e(b, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(14167);
      return -3;
    }
    if (this.N)
    {
      TXCLog.w(b, "ignore start record when recording");
      AppMethodBeat.o(14167);
      return -1;
    }
    if ((this.j == null) || (!this.j.j()))
    {
      TXCLog.w(b, "ignore start record when not pushing");
      AppMethodBeat.o(14167);
      return -2;
    }
    TXCLog.w(b, "start record ");
    this.N = true;
    this.L = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    this.J = new com.tencent.liteav.muxer.c(this.l, 1);
    this.K = false;
    this.J.a(this.L);
    A();
    TXCDRApi.txReportDAU(this.l.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
    if (this.j != null) {
      this.j.u();
    }
    AppMethodBeat.o(14167);
    return 0;
  }
  
  public void e(float paramFloat)
  {
    AppMethodBeat.i(14162);
    this.A = paramFloat;
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
    AppMethodBeat.o(14162);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(14165);
    TXCLog.i(b, "liteav_api setVoiceChangerType ".concat(String.valueOf(paramInt)));
    this.w = paramInt;
    com.tencent.liteav.audio.a.a().b(paramInt);
    AppMethodBeat.o(14165);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(14153);
    TXCLog.i(b, "liteav_api setMute ".concat(String.valueOf(paramBoolean)));
    StringBuilder localStringBuilder = new StringBuilder("setMute:");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      Monitor.a(1, str, "", 0);
      this.v = paramBoolean;
      com.tencent.liteav.audio.a.a().d(paramBoolean);
      if ((this.d.mEnablePureAudioPush) && (this.k != null)) {
        this.k.setAudioMute(paramBoolean);
      }
      AppMethodBeat.o(14153);
      return;
    }
  }
  
  public int f()
  {
    AppMethodBeat.i(14184);
    int i1 = TXCStatus.c(this.q, 7005);
    AppMethodBeat.o(14184);
    return i1;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(182228);
    TXCLog.i(b, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)));
    Monitor.a(1, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)), "", 0);
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.F = i1;
      x();
      AppMethodBeat.o(182228);
      return;
    }
    this.F = 0;
    y();
    AppMethodBeat.o(182228);
  }
  
  public void f(String paramString)
  {
    AppMethodBeat.i(14177);
    TXCLog.i("User", paramString);
    AppMethodBeat.o(14177);
  }
  
  public int g()
  {
    AppMethodBeat.i(14185);
    int i1 = TXCStatus.c(this.q, 7007);
    AppMethodBeat.o(14185);
    return i1;
  }
  
  public int h()
  {
    AppMethodBeat.i(14186);
    int i1 = TXCStatus.c(this.q, 7021);
    AppMethodBeat.o(14186);
    return i1;
  }
  
  public TXLivePushConfig i()
  {
    return this.d;
  }
  
  public void j()
  {
    AppMethodBeat.i(14130);
    TXCLog.i(b, "liteav_api stopPusher ".concat(String.valueOf(this)));
    Monitor.a(1, "stopPush", "", 0);
    v();
    C();
    J();
    H();
    L();
    N();
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.f(false);
    this.v = false;
    this.i.P = false;
    F();
    this.p = "";
    this.B.clear();
    Monitor.a();
    this.j.b(false);
    y();
    AppMethodBeat.o(14130);
  }
  
  public void k()
  {
    AppMethodBeat.i(14132);
    TXCLog.i(b, "liteav_api pausePusher ".concat(String.valueOf(this)));
    Monitor.a(1, "pausePush", "", 0);
    if (this.j != null) {
      this.j.g();
    }
    if ((this.d.mPauseFlag & 0x2) == 2) {
      com.tencent.liteav.audio.a.a().b(true);
    }
    AppMethodBeat.o(14132);
  }
  
  public void l()
  {
    AppMethodBeat.i(14133);
    TXCLog.i(b, "liteav_api resumePusher ".concat(String.valueOf(this)));
    Monitor.a(1, "resumePush", "", 0);
    if (this.j != null) {
      this.j.h();
    }
    com.tencent.liteav.audio.a.a().b();
    AppMethodBeat.o(14133);
  }
  
  public boolean m()
  {
    AppMethodBeat.i(14134);
    if (this.j != null)
    {
      boolean bool = this.j.j();
      AppMethodBeat.o(14134);
      return bool;
    }
    AppMethodBeat.o(14134);
    return false;
  }
  
  public void n()
  {
    AppMethodBeat.i(14138);
    TXCLog.i(b, "liteav_api startScreenCapture ");
    Monitor.a(1, "startScreenCapture", "", 0);
    if (this.j == null)
    {
      AppMethodBeat.o(14138);
      return;
    }
    this.j.l();
    AppMethodBeat.o(14138);
  }
  
  public void o()
  {
    AppMethodBeat.i(14139);
    TXCLog.i(b, "liteav_api stopScreenCapture ");
    Monitor.a(1, "stopScreenCapture", "", 0);
    if (this.j == null)
    {
      AppMethodBeat.o(14139);
      return;
    }
    this.j.m();
    AppMethodBeat.o(14139);
  }
  
  public void onBackgroudPushStop()
  {
    AppMethodBeat.i(14194);
    com.tencent.liteav.audio.a.a().b();
    com.tencent.liteav.audio.a.a().b(false);
    AppMethodBeat.o(14194);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(14189);
    if (this.n != null) {
      this.n.setHasVideo(true);
    }
    if ((this.k != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null)) {}
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
        this.k.pushNAL(paramTXSNALPacket);
        if ((this.N) && (this.J != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null))
        {
          localObject1 = d(paramTXSNALPacket.nalData);
          if (!this.K)
          {
            if (paramTXSNALPacket.nalType != 0) {
              continue;
            }
            localObject2 = com.tencent.liteav.basic.util.d.a((byte[])localObject1, this.j.c(), this.j.d());
            if (localObject2 != null)
            {
              this.J.a((MediaFormat)localObject2);
              this.J.a();
              this.K = true;
              this.M = 0L;
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
    if ((this.N) && (this.J != null))
    {
      this.J.a(paramMediaFormat);
      if (!this.K)
      {
        this.J.a();
        this.K = true;
        this.M = 0L;
      }
    }
    AppMethodBeat.o(14193);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(14178);
    if (this.m != null) {
      this.m.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13938);
          if (b.e(b.this) != null) {
            b.e(b.this).setLogText(null, paramBundle, paramInt);
          }
          AppMethodBeat.o(13938);
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
    if ((this.N) && (this.J != null) && (this.K) && (paramArrayOfByte != null)) {
      this.J.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 0);
    }
    AppMethodBeat.o(14192);
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14191);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.h;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(14191);
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(14190);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.h;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    AppMethodBeat.o(14190);
  }
  
  public void p()
  {
    AppMethodBeat.i(14141);
    TXCLog.i(b, "liteav_api switchCamera ");
    Monitor.a(1, "switchCamera", "", 0);
    if (this.j == null)
    {
      AppMethodBeat.o(14141);
      return;
    }
    this.j.k();
    AppMethodBeat.o(14141);
  }
  
  public int q()
  {
    AppMethodBeat.i(14145);
    if (this.j == null)
    {
      AppMethodBeat.o(14145);
      return 0;
    }
    int i1 = this.j.r();
    AppMethodBeat.o(14145);
    return i1;
  }
  
  public TXBeautyManager r()
  {
    AppMethodBeat.i(14151);
    if (this.j == null) {
      this.j = new com.tencent.liteav.c(this.l);
    }
    TXBeautyManager localTXBeautyManager = this.j.b();
    AppMethodBeat.o(14151);
    return localTXBeautyManager;
  }
  
  public boolean s()
  {
    AppMethodBeat.i(14156);
    TXCLog.i(b, "liteav_api stopBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().stopPlay();
    AppMethodBeat.o(14156);
    return bool;
  }
  
  public boolean t()
  {
    AppMethodBeat.i(14157);
    TXCLog.i(b, "liteav_api pauseBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().pause();
    AppMethodBeat.o(14157);
    return bool;
  }
  
  public boolean u()
  {
    AppMethodBeat.i(14158);
    TXCLog.i(b, "liteav_api resumeBGM ");
    boolean bool = TXCLiveBGMPlayer.getInstance().resume();
    AppMethodBeat.o(14158);
    return bool;
  }
  
  public void v()
  {
    AppMethodBeat.i(14168);
    TXCLog.i(b, "liteav_api stopRecord ");
    if ((this.N) && (this.J != null))
    {
      int i1 = this.J.b();
      TXCLog.w(b, "start record ");
      this.N = false;
      if (i1 == 0)
      {
        AsyncTask.execute(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14005);
            Object localObject = new File(this.a).getParentFile();
            String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
            localObject = localObject + File.separator + String.format("TXUGCCover_%s.jpg", new Object[] { str });
            com.tencent.liteav.basic.util.d.a(this.a, (String)localObject);
            b.a(b.this, this.a, (String)localObject);
            AppMethodBeat.o(14005);
          }
        });
        AppMethodBeat.o(14168);
        return;
      }
      z();
    }
    AppMethodBeat.o(14168);
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
        int i = com.tencent.liteav.audio.a.a().e();
        if (b.a(b.this) != null) {
          b.a(b.this).onAudioVolumeEvaluationNotify(i);
        }
      }
      if ((b.b(b.this) != null) && (this.b > 0)) {
        b.b(b.this).postDelayed(b.c(b.this), this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.b
 * JD-Core Version:    0.7.0.1
 */