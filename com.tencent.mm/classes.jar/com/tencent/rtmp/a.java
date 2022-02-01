package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.j;
import com.tencent.liteav.j.a;
import com.tencent.liteav.n;
import com.tencent.liteav.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import org.json.JSONObject;

public class a
  implements com.tencent.liteav.basic.c.b
{
  private String A;
  private int B;
  private long C;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener D;
  private int E;
  private long F;
  private String G;
  private int H;
  private int I;
  private a J;
  private TXLivePlayer.ITXAudioRawDataListener K;
  private TXCloudVideoView a;
  private Surface b;
  private int c;
  private int d;
  private ITXLivePlayListener e;
  private TXLivePlayConfig f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private String k;
  private boolean l;
  private int m;
  private TXLivePlayer.ITXVideoRawDataListener n;
  private byte[] o;
  private Object p;
  private TXLivePlayer.ITXLivePlayVideoRenderListener q;
  private Context r;
  private Handler s;
  private n t;
  private boolean u;
  private float v;
  private boolean w;
  private j x;
  private boolean y;
  private long z;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(14062);
    this.g = false;
    this.h = true;
    this.k = "";
    this.l = false;
    this.m = 100;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.u = true;
    this.v = 1.0F;
    this.w = false;
    this.B = -1;
    this.C = 0L;
    this.D = null;
    this.E = 0;
    this.I = 0;
    this.J = null;
    this.e = null;
    this.r = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.r);
    TXCLog.init();
    this.s = new Handler(Looper.getMainLooper());
    TXCCommonUtil.setAppContext(this.r);
    TXCLog.init();
    AppMethodBeat.o(14062);
  }
  
  private String a(Bundle paramBundle)
  {
    AppMethodBeat.i(219426);
    paramBundle = " IP:" + paramBundle.getString("SERVER_IP") + " RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT") + " FPS:" + paramBundle.getInt("VIDEO_FPS") + " GOP:" + paramBundle.getInt("VIDEO_GOP") + "s Speed:" + paramBundle.getInt("NET_SPEED") + "Kbps AudioSpeed:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps VideoSpeed:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps AudioCache:" + paramBundle.getInt("AUDIO_CACHE") + " VideoCache:" + paramBundle.getInt("VIDEO_CACHE") + " VideoCacheFrameCount:" + paramBundle.getInt("V_SUM_CACHE_SIZE") + " VideoDecoderCacheFrameCount:" + paramBundle.getInt("V_DEC_CACHE_SIZE") + " AVJitterSync:" + paramBundle.getInt("AV_RECV_INTERVAL") + " AVPlaySync:" + paramBundle.getInt("AV_PLAY_INTERVAL") + " AudioParamsInfo:" + paramBundle.getString("AUDIO_PLAY_INFO");
    AppMethodBeat.o(219426);
    return paramBundle;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(219410);
    if ((paramInt == 15001) && (paramBundle != null))
    {
      String str = this.k;
      if (str == null)
      {
        AppMethodBeat.o(219410);
        return;
      }
      boolean bool = str.startsWith("room://");
      this.G = a(paramBundle);
      paramInt = paramBundle.getInt("AUDIO_CACHE", 0);
      int i1 = paramBundle.getInt("NET_SPEED", 0);
      int i2 = paramBundle.getInt("VIDEO_FPS", 0);
      int i3 = paramBundle.getInt("AV_RECV_INTERVAL");
      int i4 = paramBundle.getInt("AV_PLAY_INTERVAL");
      if (((!bool) && (this.H > paramInt)) || (i1 < 10) || ((i2 != 0) && (i2 < 5)) || (Math.abs(i3) > 5000) || (Math.abs(i4) > 5000)) {
        h();
      }
      AppMethodBeat.o(219410);
      return;
    }
    if ((paramInt == 2007) || (paramInt == 2105))
    {
      TXCLog.i("TXLivePlayer", "[Event]code:" + paramInt + " param:" + paramBundle);
      h();
    }
    AppMethodBeat.o(219410);
  }
  
  private void a(final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(14099);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(14099);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(219282);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        a.a(a.this, false);
        AppMethodBeat.o(219282);
      }
    });
    AppMethodBeat.o(14099);
  }
  
  private String c(String paramString, int paramInt)
  {
    AppMethodBeat.i(14098);
    Object localObject = paramString;
    if (paramInt != 6) {}
    label64:
    label90:
    label228:
    label235:
    label241:
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i1;
      try
      {
        localObject = paramString.getBytes("UTF-8");
        localStringBuilder = new StringBuilder(localObject.length);
        paramInt = 0;
        if (paramInt >= localObject.length) {
          break label131;
        }
        if (localObject[paramInt] >= 0) {
          break label235;
        }
        i1 = localObject[paramInt] + 256;
      }
      catch (Exception localException)
      {
        TXCLog.e("TXLivePlayer", "check play url failed.", localException);
        str = paramString;
      }
      localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i1) }));
      break label228;
      localStringBuilder.append((char)i1);
      break label228;
      String str;
      for (;;)
      {
        paramString = str.trim();
        AppMethodBeat.o(14098);
        return paramString;
        str = localStringBuilder.toString();
      }
      for (;;)
      {
        if ((i1 <= 32) || (i1 >= 127) || (i1 == 34) || (i1 == 37) || (i1 == 60) || (i1 == 62) || (i1 == 91) || (i1 == 125) || (i1 == 92) || (i1 == 93) || (i1 == 94) || (i1 == 96) || (i1 == 123)) {
          break label241;
        }
        if (i1 != 124) {
          break label90;
        }
        break label64;
        paramInt += 1;
        break;
        i1 = str[paramInt];
      }
    }
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(219306);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.i("TXLivePlayer", "[API] TXLivePlayer(" + hashCode() + ") " + str);
    AppMethodBeat.o(219306);
  }
  
  private void f()
  {
    AppMethodBeat.i(14082);
    if ((this.t != null) && (this.E > 0))
    {
      if (this.J == null) {
        this.J = new a(null);
      }
      this.J.a(this.E);
      if (this.s != null)
      {
        this.s.removeCallbacks(this.J);
        this.s.postDelayed(this.J, this.E);
      }
    }
    AppMethodBeat.o(14082);
  }
  
  private void g()
  {
    AppMethodBeat.i(14083);
    if ((this.s != null) && (this.J != null)) {
      this.s.removeCallbacks(this.J);
    }
    this.J = null;
    this.E = 0;
    AppMethodBeat.o(14083);
  }
  
  private void h()
  {
    AppMethodBeat.i(219413);
    long l1 = System.currentTimeMillis();
    if (l1 - this.F > 3000L)
    {
      this.F = l1;
      c("[Statistics] logStatisticsStr statistics:" + this.G);
    }
    AppMethodBeat.o(219413);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(219430);
    if ((Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("Che2-TL00")))
    {
      AppMethodBeat.o(219430);
      return true;
    }
    AppMethodBeat.o(219430);
    return false;
  }
  
  public int a(TXLivePlayer.ITXLivePlayVideoRenderListener paramITXLivePlayVideoRenderListener, Object paramObject)
  {
    AppMethodBeat.i(219369);
    c("setVideoRenderListener listener:" + paramITXLivePlayVideoRenderListener + " context:" + paramObject);
    if (paramObject != null) {
      if (Build.VERSION.SDK_INT >= 17)
      {
        if ((!(paramObject instanceof javax.microedition.khronos.egl.EGLContext)) && (!(paramObject instanceof android.opengl.EGLContext)))
        {
          TXCLog.w("TXLivePlayer", "setVideoRenderListener error when glContext error ".concat(String.valueOf(paramObject)));
          AppMethodBeat.o(219369);
          return -1;
        }
      }
      else if (!(paramObject instanceof javax.microedition.khronos.egl.EGLContext))
      {
        TXCLog.w("TXLivePlayer", "setVideoRenderListener error when glContext error ".concat(String.valueOf(paramObject)));
        AppMethodBeat.o(219369);
        return -1;
      }
    }
    this.p = paramObject;
    this.q = paramITXLivePlayVideoRenderListener;
    if (this.t != null)
    {
      if (paramITXLivePlayVideoRenderListener == null) {
        break label166;
      }
      this.t.a(new o()
      {
        public void onRenderVideoFrame(String paramAnonymousString, int paramAnonymousInt, TXSVideoFrame paramAnonymousTXSVideoFrame)
        {
          AppMethodBeat.i(13944);
          if ((paramAnonymousTXSVideoFrame == null) || (paramAnonymousTXSVideoFrame.width <= 0) || (paramAnonymousTXSVideoFrame.height <= 0))
          {
            AppMethodBeat.o(13944);
            return;
          }
          paramAnonymousString = a.e(a.this);
          if (paramAnonymousString != null)
          {
            TXLivePlayer.TXLiteAVTexture localTXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
            localTXLiteAVTexture.textureId = paramAnonymousTXSVideoFrame.textureId;
            localTXLiteAVTexture.width = paramAnonymousTXSVideoFrame.width;
            localTXLiteAVTexture.height = paramAnonymousTXSVideoFrame.height;
            localTXLiteAVTexture.eglContext = paramAnonymousTXSVideoFrame.eglContext;
            paramAnonymousString.onRenderVideoFrame(localTXLiteAVTexture);
          }
          AppMethodBeat.o(13944);
        }
      }, com.tencent.liteav.basic.b.b.c, paramObject);
    }
    for (;;)
    {
      AppMethodBeat.o(219369);
      return 0;
      label166:
      this.t.a(null, com.tencent.liteav.basic.b.b.a, null);
    }
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(14079);
    c("[SwitchStream]switchStream url:".concat(String.valueOf(paramString)));
    if (this.t != null)
    {
      int i1 = this.t.a(paramString);
      AppMethodBeat.o(14079);
      return i1;
    }
    AppMethodBeat.o(14079);
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(14066);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXLivePlayer", "start play error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(14066);
      return -1;
    }
    if (!TextUtils.isEmpty(this.k))
    {
      if ((this.k.equalsIgnoreCase(paramString)) && (a()))
      {
        TXCLog.e("TXLivePlayer", "start play error when new url is the same with old url  ".concat(String.valueOf(this)));
        if (this.y) {
          onNotifyEvent(2004, new Bundle());
        }
        if (this.y)
        {
          AppMethodBeat.o(14066);
          return 0;
        }
        AppMethodBeat.o(14066);
        return -1;
      }
      TXCLog.w("TXLivePlayer", " stop old play when new url is not the same with old url  ".concat(String.valueOf(this)));
      if (this.t != null) {
        this.t.a(false);
      }
      this.k = "";
    }
    TXCDRApi.initCrashReport(this.r);
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "=====  StartPlay url = " + paramString + " playType = " + paramInt + " DeviceName = " + com.tencent.liteav.basic.util.h.c() + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    if ((this.B == -1) || (this.B != paramInt)) {
      this.t = com.tencent.liteav.p.a(this.r, paramInt);
    }
    this.B = paramInt;
    if (this.t == null)
    {
      TXCLog.i("TXLivePlayer", "liteav_api startPlay create palyer failed".concat(String.valueOf(this)));
      AppMethodBeat.o(14066);
      return -2;
    }
    this.k = c(paramString, paramInt);
    c("startPlay url:" + paramString + " type:" + paramInt + " inner instance:" + this.t.hashCode());
    a(this.f);
    if (this.a != null)
    {
      this.a.clearLog();
      this.a.setVisibility(0);
    }
    this.t.a(this.a);
    this.t.a(this);
    this.t.d(this.u);
    if (this.b != null)
    {
      this.t.a(this.b);
      this.t.a(this.c, this.d);
    }
    this.t.a(this.k, paramInt);
    this.t.b(this.l);
    this.t.c(this.m);
    this.t.a(this.v);
    this.t.b(this.j);
    this.t.a(this.i);
    this.t.a(this.K);
    if (this.n != null) {
      a(this.n);
    }
    if (this.q != null) {
      a(this.q, this.p);
    }
    long l1;
    if (this.t.e())
    {
      this.A = this.k;
      if (this.x == null) {
        break label696;
      }
      l1 = this.x.a();
      this.z = l1;
      if (this.z > 0L) {
        this.t.f();
      }
    }
    if (this.I == 0) {
      TXCDRApi.txReportDAU(this.r.getApplicationContext(), com.tencent.liteav.basic.datareport.a.bu);
    }
    for (;;)
    {
      f();
      AppMethodBeat.o(14066);
      return 0;
      label696:
      l1 = 0L;
      break;
      TXCDRApi.txReportDAU(this.r.getApplicationContext(), com.tencent.liteav.basic.datareport.a.bH);
    }
  }
  
  public int a(boolean paramBoolean)
  {
    AppMethodBeat.i(14067);
    c("stopPlay need clear:".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.a != null)) {
      this.a.setVisibility(8);
    }
    g();
    if (this.t != null) {
      this.t.a(paramBoolean);
    }
    this.k = "";
    this.z = 0L;
    this.I = 0;
    this.x = null;
    this.y = false;
    AppMethodBeat.o(14067);
    return 0;
  }
  
  @Deprecated
  public void a(float paramFloat)
  {
    AppMethodBeat.i(14095);
    TXCLog.i("TXLivePlayer", "setRate ".concat(String.valueOf(paramFloat)));
    this.v = paramFloat;
    if (this.t != null) {
      this.t.a(paramFloat);
    }
    AppMethodBeat.o(14095);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14073);
    c("setRenderMode mode:".concat(String.valueOf(paramInt)));
    this.i = paramInt;
    if (this.t != null) {
      this.t.a(paramInt);
    }
    AppMethodBeat.o(14073);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14072);
    c("setSurfaceSize width:" + paramInt1 + " height:" + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.t != null) {
      this.t.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(14072);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(14071);
    c("setSurface old:" + this.b + " new:" + paramSurface);
    this.b = paramSurface;
    if (this.t != null) {
      this.t.a(this.b);
    }
    AppMethodBeat.o(14071);
  }
  
  public void a(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14064);
    c("setPlayListener listener:".concat(String.valueOf(paramITXLivePlayListener)));
    this.e = paramITXLivePlayListener;
    AppMethodBeat.o(14064);
  }
  
  public void a(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(14063);
    StringBuilder localStringBuilder = new StringBuilder("setConfig");
    if (paramTXLivePlayConfig != null) {}
    for (Object localObject = paramTXLivePlayConfig.toString();; localObject = null)
    {
      c((String)localObject);
      this.f = paramTXLivePlayConfig;
      if (this.f == null) {
        this.f = new TXLivePlayConfig();
      }
      if (this.t != null)
      {
        localObject = this.t.i();
        paramTXLivePlayConfig = (TXLivePlayConfig)localObject;
        if (localObject == null) {
          paramTXLivePlayConfig = new com.tencent.liteav.h();
        }
        this.H = ((int)(this.f.mMinAutoAdjustCacheTime * 1000.0F));
        paramTXLivePlayConfig.a = this.f.mCacheTime;
        paramTXLivePlayConfig.g = this.f.mAutoAdjustCacheTime;
        paramTXLivePlayConfig.c = this.f.mMinAutoAdjustCacheTime;
        paramTXLivePlayConfig.b = this.f.mMaxAutoAdjustCacheTime;
        paramTXLivePlayConfig.d = this.f.mVideoBlockThreshold;
        paramTXLivePlayConfig.e = this.f.mConnectRetryCount;
        paramTXLivePlayConfig.f = this.f.mConnectRetryInterval;
        paramTXLivePlayConfig.i = this.f.mEnableNearestIP;
        paramTXLivePlayConfig.m = this.f.mRtmpChannelType;
        paramTXLivePlayConfig.h = this.g;
        paramTXLivePlayConfig.n = this.f.mCacheFolderPath;
        paramTXLivePlayConfig.o = this.f.mMaxCacheItems;
        paramTXLivePlayConfig.j = this.f.mEnableMessage;
        paramTXLivePlayConfig.k = this.f.mEnableMetaData;
        paramTXLivePlayConfig.l = this.f.mFlvSessionKey;
        paramTXLivePlayConfig.p = this.f.mHeaders;
        TXCLog.i("TXLivePlayer", "liteav_api setConfig [cacheTime:" + this.f.mCacheTime + "][autoAdjustCacheTime:" + this.f.mAutoAdjustCacheTime + "][minAutoAdjustCacheTime:" + this.f.mMinAutoAdjustCacheTime + "][maxAutoAdjustCacheTime:" + this.f.mMaxAutoAdjustCacheTime + "][videoBlockThreshold:" + this.f.mVideoBlockThreshold + "][connectRetryCount:" + this.f.mConnectRetryCount + "][connectRetryInterval:" + this.f.mConnectRetryInterval + "][enableHWDec:" + this.g + "][enableMessage:" + this.f.mEnableMessage + "][enableMetaData:" + this.f.mEnableMetaData + "][flvSessionKey:" + this.f.mFlvSessionKey);
        this.t.a(paramTXLivePlayConfig);
      }
      AppMethodBeat.o(14063);
      return;
    }
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(14090);
    c("setAudioRawDataListener listener:".concat(String.valueOf(paramITXAudioRawDataListener)));
    this.K = paramITXAudioRawDataListener;
    if (this.t != null) {
      this.t.a(paramITXAudioRawDataListener);
    }
    AppMethodBeat.o(14090);
  }
  
  public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.D = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14087);
    c("snapshot listener:".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.w) || (paramITXSnapshotListener == null))
    {
      AppMethodBeat.o(14087);
      return;
    }
    this.w = true;
    if (this.t != null)
    {
      this.t.a(new com.tencent.liteav.basic.opengl.p()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(182238);
          a.a(a.this, paramITXSnapshotListener, paramAnonymousBitmap);
          AppMethodBeat.o(182238);
        }
      });
      AppMethodBeat.o(14087);
      return;
    }
    this.w = false;
    AppMethodBeat.o(14087);
  }
  
  public void a(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    AppMethodBeat.i(14089);
    c("setVideoRawDataListener listener:".concat(String.valueOf(paramITXVideoRawDataListener)));
    this.n = paramITXVideoRawDataListener;
    if (this.t == null)
    {
      AppMethodBeat.o(14089);
      return;
    }
    if (paramITXVideoRawDataListener != null)
    {
      this.t.a(new o()
      {
        public void onRenderVideoFrame(String paramAnonymousString, int paramAnonymousInt, TXSVideoFrame paramAnonymousTXSVideoFrame)
        {
          AppMethodBeat.i(218888);
          if ((paramAnonymousTXSVideoFrame == null) || (paramAnonymousTXSVideoFrame.width <= 0) || (paramAnonymousTXSVideoFrame.height <= 0))
          {
            AppMethodBeat.o(218888);
            return;
          }
          paramAnonymousString = a.f(a.this);
          a.a(a.this, null);
          TXLivePlayer.ITXVideoRawDataListener localITXVideoRawDataListener = a.g(a.this);
          if ((localITXVideoRawDataListener != null) && (paramAnonymousString != null))
          {
            if (paramAnonymousString.length >= paramAnonymousTXSVideoFrame.width * paramAnonymousTXSVideoFrame.height * 3 / 2)
            {
              paramAnonymousTXSVideoFrame.loadYUVArray(paramAnonymousString);
              localITXVideoRawDataListener.onVideoRawDataAvailable(paramAnonymousString, paramAnonymousTXSVideoFrame.width, paramAnonymousTXSVideoFrame.height, (int)paramAnonymousTXSVideoFrame.pts);
              paramAnonymousTXSVideoFrame.release();
              AppMethodBeat.o(218888);
              return;
            }
            TXCLog.e("TXLivePlayer", "raw data buffer length is too large");
          }
          AppMethodBeat.o(218888);
        }
      }, com.tencent.liteav.basic.b.b.b, null);
      AppMethodBeat.o(14089);
      return;
    }
    this.t.a(null, com.tencent.liteav.basic.b.b.a, null);
    AppMethodBeat.o(14089);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14065);
    c("setPlayerView old:" + this.a + " new:" + paramTXCloudVideoView);
    this.a = paramTXCloudVideoView;
    if (this.t != null) {
      this.t.a(paramTXCloudVideoView);
    }
    AppMethodBeat.o(14065);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(14084);
    c("setVideoRecordListener listener:".concat(String.valueOf(paramITXVideoRecordListener)));
    if (this.t != null) {
      this.t.a(paramITXVideoRecordListener);
    }
    AppMethodBeat.o(14084);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(14068);
    if (this.t != null)
    {
      boolean bool = this.t.c();
      AppMethodBeat.o(14068);
      return bool;
    }
    AppMethodBeat.o(14068);
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14088);
    if ((this.k == null) || (this.k.isEmpty()))
    {
      AppMethodBeat.o(14088);
      return false;
    }
    if (this.g)
    {
      TXLog.e("TXLivePlayer", "can not addVideoRawData because of hw decode has set!");
      AppMethodBeat.o(14088);
      return false;
    }
    if (this.t == null)
    {
      TXCLog.e("TXLivePlayer", "player hasn't created or not instanceof live player");
      AppMethodBeat.o(14088);
      return false;
    }
    this.o = paramArrayOfByte;
    AppMethodBeat.o(14088);
    return true;
  }
  
  public int b(String paramString, int paramInt)
  {
    AppMethodBeat.i(14091);
    c("prepareLiveSeek domain:" + paramString + " bizid:" + paramInt);
    if (this.x == null) {
      this.x = new j();
    }
    if (this.x != null)
    {
      paramInt = this.x.a(this.k, paramString, paramInt, new j.a()
      {
        public void a(long paramAnonymousLong)
        {
          AppMethodBeat.i(219203);
          a.a(a.this, paramAnonymousLong);
          if (a.a(a.this) != null) {
            a.a(a.this).f();
          }
          AppMethodBeat.o(219203);
        }
      });
      AppMethodBeat.o(14091);
      return paramInt;
    }
    AppMethodBeat.o(14091);
    return -1;
  }
  
  public void b()
  {
    AppMethodBeat.i(14069);
    c("pause");
    if (this.t != null)
    {
      TXCLog.w("TXLivePlayer", "pause play");
      this.t.a();
    }
    AppMethodBeat.o(14069);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(14074);
    c("setRenderRotation rotation:".concat(String.valueOf(paramInt)));
    this.j = paramInt;
    if (this.t != null) {
      this.t.b(paramInt);
    }
    AppMethodBeat.o(14074);
  }
  
  public void b(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(14081);
    c("callExperimentalAPI json:".concat(String.valueOf(paramString)));
    String str;
    try
    {
      Object localObject = new JSONObject(paramString);
      if (!((JSONObject)localObject).has("api"))
      {
        TXCLog.e("TXLivePlayer", "callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(14081);
        return;
      }
      str = ((JSONObject)localObject).getString("api");
      JSONObject localJSONObject = null;
      if (((JSONObject)localObject).has("params")) {
        localJSONObject = ((JSONObject)localObject).getJSONObject("params");
      }
      if (str.equals("muteRemoteAudioInSpeaker"))
      {
        if (localJSONObject == null)
        {
          TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]");
          AppMethodBeat.o(14081);
          return;
        }
        if (!localJSONObject.has("enable"))
        {
          TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]: enable");
          AppMethodBeat.o(14081);
          return;
        }
        int i1 = localJSONObject.getInt("enable");
        if (this.t != null)
        {
          localObject = this.t;
          if (i1 != 1) {
            break label224;
          }
          ((n)localObject).c(bool);
        }
      }
      for (;;)
      {
        if (!str.equals("setInterfaceType")) {
          break label321;
        }
        if (localJSONObject != null) {
          break label274;
        }
        TXCLog.e("TXLivePlayer", "setInterfaceType[lack parameter]");
        AppMethodBeat.o(14081);
        return;
        label224:
        bool = false;
        break;
        TXCLog.e("TXLivePlayer", "callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
      }
      if (localException.has("type")) {
        break label301;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXLivePlayer", "callExperimentalAPI[failed]: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(14081);
      return;
    }
    label274:
    TXCLog.e("TXLivePlayer", "setInterfaceType[lack parameter]: type");
    AppMethodBeat.o(14081);
    return;
    label301:
    this.I = localException.optInt("type", 0);
    AppMethodBeat.o(14081);
    return;
    label321:
    TXCLog.e("TXLivePlayer", "callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
    AppMethodBeat.o(14081);
  }
  
  public boolean b(boolean paramBoolean)
  {
    AppMethodBeat.i(14075);
    c("enableHardwareDecode enable:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
        AppMethodBeat.o(14075);
        return false;
      }
      if (i())
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
        AppMethodBeat.o(14075);
        return false;
      }
    }
    this.g = paramBoolean;
    if (this.t != null)
    {
      com.tencent.liteav.h localh2 = this.t.i();
      com.tencent.liteav.h localh1 = localh2;
      if (localh2 == null) {
        localh1 = new com.tencent.liteav.h();
      }
      localh1.h = this.g;
      this.t.a(localh1);
    }
    AppMethodBeat.o(14075);
    return true;
  }
  
  public void c()
  {
    AppMethodBeat.i(14070);
    c("resume");
    if (this.t != null)
    {
      this.t.b();
      if (this.t.e()) {
        if (this.x == null) {
          break label80;
        }
      }
    }
    label80:
    for (long l1 = this.x.a();; l1 = 0L)
    {
      this.z = l1;
      if (this.z > 0L) {
        this.t.f();
      }
      AppMethodBeat.o(14070);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    int i1 = 100;
    AppMethodBeat.i(14077);
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 100) {
        paramInt = i1;
      }
      for (;;)
      {
        c("setVolume volume:".concat(String.valueOf(paramInt)));
        this.m = paramInt;
        if (this.t != null) {
          this.t.c(paramInt);
        }
        AppMethodBeat.o(14077);
        return;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(14076);
    c("setMute mute:".concat(String.valueOf(paramBoolean)));
    this.l = paramBoolean;
    if (this.t != null) {
      this.t.b(paramBoolean);
    }
    AppMethodBeat.o(14076);
  }
  
  public int d()
  {
    AppMethodBeat.i(14086);
    c("stopRecord");
    if (this.t != null)
    {
      int i1 = this.t.d();
      AppMethodBeat.o(14086);
      return i1;
    }
    AppMethodBeat.o(14086);
    return -1;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(14078);
    c("setAudioRoute route:".concat(String.valueOf(paramInt)));
    TXCAudioEngine.setAudioRoute(paramInt);
    AppMethodBeat.o(14078);
  }
  
  @Deprecated
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(14094);
    TXCLog.i("TXLivePlayer", "setAutoPlay ".concat(String.valueOf(paramBoolean)));
    this.u = paramBoolean;
    AppMethodBeat.o(14094);
  }
  
  public int e()
  {
    AppMethodBeat.i(14093);
    c("resumeLive");
    if (this.y)
    {
      this.y = false;
      int i1 = a(this.A, 1);
      AppMethodBeat.o(14093);
      return i1;
    }
    AppMethodBeat.o(14093);
    return -1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(14080);
    c("enableAudioVolumeEvaluation intervalMs:".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.E = i1;
      f();
      AppMethodBeat.o(14080);
      return;
    }
    this.E = 0;
    g();
    AppMethodBeat.o(14080);
  }
  
  public int f(int paramInt)
  {
    AppMethodBeat.i(14085);
    c("startRecord type:".concat(String.valueOf(paramInt)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXLivePlayer", "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(14085);
      return -3;
    }
    if (!a())
    {
      TXCLog.e("TXLivePlayer", "startRecord: there is no playing stream");
      AppMethodBeat.o(14085);
      return -1;
    }
    if (this.t != null)
    {
      paramInt = this.t.d(paramInt);
      AppMethodBeat.o(14085);
      return paramInt;
    }
    AppMethodBeat.o(14085);
    return -1;
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(14092);
    c("seek time:".concat(String.valueOf(paramInt)));
    if (this.t != null)
    {
      if ((this.t.e()) || (this.y))
      {
        String str;
        if (this.x != null)
        {
          str = this.x.a(paramInt);
          if (TextUtils.isEmpty(str)) {
            break label119;
          }
          if (a(str, 3) != 0) {
            break label114;
          }
        }
        label114:
        for (boolean bool = true;; bool = false)
        {
          this.y = bool;
          if (!this.y) {
            break label145;
          }
          this.z = (paramInt * 1000);
          AppMethodBeat.o(14092);
          return;
          str = "";
          break;
        }
        label119:
        if (this.e != null) {
          this.e.onPlayEvent(-2301, new Bundle());
        }
        label145:
        AppMethodBeat.o(14092);
        return;
      }
      this.t.e(paramInt);
    }
    AppMethodBeat.o(14092);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14096);
    a(paramInt, paramBundle);
    int i1;
    if (paramInt == 15001)
    {
      if (this.a != null) {
        this.a.setLogText(paramBundle, null, 0);
      }
      if (this.e != null)
      {
        this.e.onNetStatus(paramBundle);
        AppMethodBeat.o(14096);
      }
    }
    else
    {
      if (paramInt == 2005)
      {
        l1 = paramBundle.getInt("EVT_PLAY_PROGRESS_MS") + this.z;
        if (l1 > 0L)
        {
          paramBundle.putInt("EVT_PLAY_PROGRESS", (int)(l1 / 1000L));
          paramBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)l1);
          if (this.e != null) {
            this.e.onPlayEvent(paramInt, paramBundle);
          }
        }
        AppMethodBeat.o(14096);
        return;
      }
      long l1 = System.currentTimeMillis();
      if (paramInt == 2101)
      {
        if (l1 - this.C < 5000L)
        {
          AppMethodBeat.o(14096);
          return;
        }
        this.C = l1;
      }
      if ((paramInt != 2005) && (paramInt != 2012) && (this.k != null) && (this.k.length() > 0))
      {
        String str = paramBundle.getString("EVT_MSG");
        c("onNotifyEvent event:" + paramInt + " msg:" + str);
      }
      i1 = paramInt;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(14096);
        return;
      case 2026: 
        i1 = 2026;
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.setLogText(null, paramBundle, i1);
      }
      if (this.e != null) {
        this.e.onPlayEvent(i1, paramBundle);
      }
      AppMethodBeat.o(14096);
      return;
      i1 = 2007;
      continue;
      i1 = 2004;
      continue;
      i1 = 2008;
      continue;
      i1 = 2106;
      continue;
      AppMethodBeat.o(14096);
      return;
      i1 = 2101;
      continue;
      i1 = -2304;
      continue;
      i1 = 2001;
      continue;
      i1 = 3003;
      continue;
      i1 = 3002;
      continue;
      i1 = 2103;
      continue;
      i1 = 2002;
      continue;
      i1 = 3002;
      continue;
      i1 = -2301;
      continue;
      i1 = -2302;
      continue;
      i1 = -2301;
      continue;
      i1 = 3005;
      continue;
      i1 = 2012;
      continue;
      i1 = 2015;
      continue;
      i1 = -2307;
      continue;
      i1 = 2005;
      continue;
      i1 = 2009;
      continue;
      i1 = 2028;
      continue;
      i1 = 2013;
      continue;
      i1 = 2031;
    }
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
      AppMethodBeat.i(14240);
      if ((a.a(a.this) != null) && (a.a(a.this).c()))
      {
        int i = a.a(a.this).h();
        if (a.b(a.this) != null) {
          a.b(a.this).onAudioVolumeEvaluationNotify(i);
        }
      }
      if ((a.c(a.this) != null) && (this.b > 0)) {
        a.c(a.this).postDelayed(a.d(a.this), this.b);
      }
      AppMethodBeat.o(14240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.a
 * JD-Core Version:    0.7.0.1
 */