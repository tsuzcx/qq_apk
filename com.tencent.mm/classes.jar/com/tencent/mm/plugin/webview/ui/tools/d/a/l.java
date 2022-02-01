package com.tencent.mm.plugin.webview.ui.tools.d.a;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.k.a.a.a;
import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.u;
import d.g.b.w;
import d.g.b.z;
import d.n.n;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "invokeContext", "handler", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "seek", "msc", "data", "Lorg/json/JSONObject;", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l
  extends com.tencent.luggage.k.a.b.a
{
  private boolean BtR;
  j BtS;
  private com.tencent.mm.plugin.appbrand.jsapi.aa.e.g BtT;
  private final m BtU;
  private int bvE;
  private float bvI;
  private boolean ckA;
  private AtomicBoolean ckJ;
  private com.tencent.luggage.k.a.a cku;
  private a.a ckv;
  private int ckw;
  private int ckx;
  b cmS;
  com.tencent.luggage.k.a.a.b.b.c cmV;
  private boolean cna;
  private boolean cnb;
  private boolean cnc;
  private boolean cnd;
  private long cne;
  private boolean cnf;
  private boolean cng;
  private volatile boolean cnh;
  private boolean cni;
  private boolean cnj;
  private int cnk;
  private int cnl;
  private String cnm;
  private String cnn;
  private boolean cno;
  private boolean cnp;
  private Handler cns;
  private HandlerThread cnt;
  private float cnx;
  private float cny;
  private int ksN;
  private int ksO;
  private int ksP;
  private int ksQ;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private int mVideoHeight;
  private int mVideoWidth;
  private final d.f ngR;
  private boolean nnC;
  private final com.tencent.mm.model.d qnr;
  final d.a yQv;
  
  static
  {
    AppMethodBeat.i(189012);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(l.class), "TAG", "getTAG()Ljava/lang/String;")) };
    AppMethodBeat.o(189012);
  }
  
  public l()
  {
    AppMethodBeat.i(189034);
    this.ngR = d.g.E((d.g.a.a)new a(this));
    this.cnt = com.tencent.e.c.d.gv("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.cnx = 1.0F;
    this.cny = 1.0F;
    this.BtT = new com.tencent.mm.plugin.appbrand.jsapi.aa.e.g();
    this.BtU = new m();
    Object localObject = com.tencent.mm.model.d.aqs();
    d.g.b.k.g(localObject, "AudioHelperTool.createTool()");
    this.qnr = ((com.tencent.mm.model.d)localObject);
    this.cnt.start();
    localObject = this.cnt;
    d.g.b.k.g(localObject, "mVideoHandlerThread");
    this.cns = new Handler(((HandlerThread)localObject).getLooper());
    this.bvE = 800000;
    this.bvI = 0.75F;
    this.ksN = 10000;
    this.ksO = 25000;
    this.ksP = 15000;
    this.ksQ = 30000;
    this.yQv = ((d.a)new b());
    AppMethodBeat.o(189034);
  }
  
  private final void D(com.tencent.luggage.k.a.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(189033);
    parama = parama.EB();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(189033);
      return;
    }
    this.bvE = parama.optInt("maxInitialBitrate", 0);
    this.bvI = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.ksN = parama.optInt("minDurForQualityMs", 0);
    this.ksO = parama.optInt("maxDurForQualityMs", 0);
    this.ksP = parama.optInt("minBufferMs", 0);
    this.ksQ = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.bvE != 0)
    {
      bool1 = bool2;
      if (this.bvI != 0.0F)
      {
        bool1 = bool2;
        if (this.ksN != 0)
        {
          bool1 = bool2;
          if (this.ksO != 0)
          {
            bool1 = bool2;
            if (this.ksP != 0)
            {
              bool1 = bool2;
              if (this.ksQ != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.nnC = bool1;
    ad.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.nnC);
    AppMethodBeat.o(189033);
  }
  
  /* Error */
  private final boolean Fa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 487	com/tencent/mm/plugin/webview/ui/tools/d/a/l:ckA	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 489	com/tencent/mm/plugin/webview/ui/tools/d/a/l:BtS	Lcom/tencent/mm/plugin/webview/ui/tools/d/a/j;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	l
    //   19	7	1	bool	boolean
    //   13	2	2	localj	j
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  private final boolean Fn()
  {
    AppMethodBeat.i(189014);
    AtomicBoolean localAtomicBoolean = this.ckJ;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(189014);
      return bool;
    }
    AppMethodBeat.o(189014);
    return false;
  }
  
  private final void Fr()
  {
    AppMethodBeat.i(189021);
    if (!bt.isNullOrNil(this.cnn))
    {
      if ((this.cng) && (FI() != null) && (this.BtT != null))
      {
        if (this.BtT.a(this.cnn, this.ckw, this.ckx, this.mVideoWidth, this.mVideoHeight))
        {
          this.cnx = this.BtT.FG();
          this.cny = this.BtT.FH();
          ad.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cnn, Float.valueOf(this.cnx), Float.valueOf(this.cny) });
          com.tencent.luggage.k.a.d.a(FI(), getType(), getId(), this.cnx, this.cny);
          AppMethodBeat.o(189021);
        }
      }
      else
      {
        ad.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(189021);
      }
    }
    else {
      ad.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(189021);
  }
  
  private final boolean Ft()
  {
    AppMethodBeat.i(189031);
    com.tencent.mm.ad.c.g((d.g.a.a)new aa(this));
    Object localObject = this.cmS;
    if (localObject != null)
    {
      this.BtU.a(this.cku, (b)localObject);
      if (!this.cng)
      {
        ad.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.cnd = false;
        AppMethodBeat.o(189031);
        return true;
      }
      ad.i(getTAG(), "video stop");
      ((b)localObject).stop();
      if (Fa())
      {
        localObject = this.BtS;
        if (localObject != null) {
          ((j)localObject).eqU();
        }
      }
      AppMethodBeat.o(189031);
      return true;
    }
    AppMethodBeat.o(189031);
    return false;
  }
  
  private final void Fu()
  {
    try
    {
      AppMethodBeat.i(189025);
      if (this.cmS != null)
      {
        ad.i(getTAG(), "releaseMediaPlayer");
        b localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.a(null);
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.stop();
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.reset();
        localb = this.cmS;
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.release();
      }
      this.cmS = null;
      this.cnh = false;
      AppMethodBeat.o(189025);
      return;
    }
    finally {}
  }
  
  private final void Fw()
  {
    AppMethodBeat.i(189026);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        d.g.b.k.fvU();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(189026);
  }
  
  private final void eqV()
  {
    AppMethodBeat.i(189019);
    ad.i(getTAG(), "createMediaPlayer");
    Object localObject = this.cns;
    long l = System.currentTimeMillis();
    if (this.nnC)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c((Handler)localObject, this.bvE, this.bvI, this.ksN, this.ksO, this.ksP, this.ksQ);
      l = System.currentTimeMillis() - l;
      ad.d(getTAG(), "createMediaPlayer cost %s", new Object[] { Long.valueOf(l) });
      m localm = this.BtU;
      h.vKh.idkeyStat(1379L, 10L, 1L, false);
      h.vKh.idkeyStat(1379L, 11L, l, false);
      localm.BtX.kCP = l;
      this.cmS = ((b)localObject);
      if (this.cmS == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.cnh = bool;
      if (this.cnh) {
        break label204;
      }
      ad.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(189019);
      return;
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c((Handler)localObject);
      break;
    }
    label204:
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.d)new c(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.c)new d(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.e)new e(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.b)new f(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.f)new g(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.g)new h(this));
    localObject = this.cmS;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((b)localObject).a((b.a)new i(this));
    AppMethodBeat.o(189019);
  }
  
  private final void eqW()
  {
    AppMethodBeat.i(189024);
    this.cno = false;
    Fu();
    eqV();
    if (this.cmS != null)
    {
      b localb = this.cmS;
      if (localb == null) {
        d.g.b.k.fvU();
      }
      localb.setMute(this.cnj);
      if (this.mSurface != null)
      {
        if (!this.cnp)
        {
          ad.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localb = this.cmS;
          if (localb == null) {
            d.g.b.k.fvU();
          }
          localb.setSurface(this.mSurface);
          AppMethodBeat.o(189024);
          return;
        }
        ad.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(189024);
  }
  
  private final int getDuration()
  {
    AppMethodBeat.i(189028);
    b localb = this.cmS;
    if (localb != null)
    {
      int i = localb.getDuration();
      AppMethodBeat.o(189028);
      return i;
    }
    AppMethodBeat.o(189028);
    return 0;
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(189013);
    String str = (String)this.ngR.getValue();
    AppMethodBeat.o(189013);
    return str;
  }
  
  private final boolean iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189020);
    if (!this.cnh)
    {
      ad.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(189020);
      return false;
    }
    ad.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    m.b localb;
    if (paramInt1 == 701)
    {
      localObject = this.cmS;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      this.cnc = ((b)localObject).isPlaying();
      ad.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cnc) });
      if (Fa())
      {
        localObject = this.BtS;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      localObject = this.BtU;
      if (((m)localObject).BtX.kCW <= 0L)
      {
        localb = ((m)localObject).BtX;
        localb.kCU += 1;
        ((m)localObject).BtX.kCW = bt.eGO();
        h.vKh.idkeyStat(1379L, 30L, 1L, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(189020);
      return false;
      if (paramInt1 == 702)
      {
        localObject = this.cmS;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        boolean bool = ((b)localObject).isPlaying();
        ad.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cnc), Boolean.valueOf(bool) });
        if (this.cnc)
        {
          this.cnc = false;
          if ((bool) && (Fa()))
          {
            ad.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject = this.BtS;
            if (localObject != null) {
              ((j)localObject).eqS();
            }
          }
        }
        for (;;)
        {
          localObject = this.BtU;
          if (((m)localObject).BtX.kCX <= 0L)
          {
            ((m)localObject).BtX.kCX = bt.eGO();
            h.vKh.idkeyStat(1379L, 31L, 1L, false);
            long l = ((m)localObject).BtX.kCX - ((m)localObject).BtX.kCW;
            localb = ((m)localObject).BtX;
            localb.kCV += l;
            h.vKh.idkeyStat(1379L, 32L, l, false);
            ad.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject = ((m)localObject).BtX;
          ((m.b)localObject).kCW = 0L;
          ((m.b)localObject).kCX = 0L;
          break;
          if ((!bool) && (Fa()))
          {
            ad.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject = this.BtS;
            if (localObject != null) {
              ((j)localObject).eqU();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        ad.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = this.cmV;
        if (localObject != null) {
          ((com.tencent.luggage.k.a.a.b.b.c)localObject).cd(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.cnh) {
          ad.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          ad.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  private final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(189027);
    if (d.g.b.k.g(this.cns.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(189027);
      return true;
      this.cns.post(paramRunnable);
    }
  }
  
  private final boolean pause()
  {
    AppMethodBeat.i(189030);
    com.tencent.mm.ad.c.g((d.g.a.a)new w(this));
    if (this.cmS != null)
    {
      if (!this.cng)
      {
        ad.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.cnd = false;
        AppMethodBeat.o(189030);
        return true;
      }
      Object localObject = this.cmS;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (!((b)localObject).isPlaying())
      {
        ad.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(189030);
        return true;
      }
      ad.i(getTAG(), "video pause");
      localObject = this.cmS;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((b)localObject).pause();
      if (Fa())
      {
        localObject = this.BtS;
        if (localObject != null) {
          ((j)localObject).eqU();
        }
      }
      AppMethodBeat.o(189030);
      return true;
    }
    AppMethodBeat.o(189030);
    return false;
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(189022);
    if (this.cmS != null)
    {
      ad.i(getTAG(), "video prepare async");
      if (Fa())
      {
        localObject = this.BtS;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      this.cng = false;
      this.cnd = false;
      Object localObject = this.cmS;
      if (localObject != null) {
        ((b)localObject).prepareAsync();
      }
      localObject = this.BtU;
      if (((m)localObject).BtX.kCR <= 0L)
      {
        ((m)localObject).BtX.kCR = bt.eGO();
        h.vKh.idkeyStat(1379L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(189022);
  }
  
  private final void release()
  {
    AppMethodBeat.i(189023);
    ad.i(getTAG(), "video release");
    com.tencent.mm.ad.c.g((d.g.a.a)new z(this));
    j localj;
    if ((this.BtS instanceof j))
    {
      localj = this.BtS;
      if (localj == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(189023);
        throw ((Throwable)localObject1);
      }
      localObject1 = localj.BtJ;
      if (localObject1 == null) {
        break label251;
      }
      localObject1 = ((f)localObject1).BtE;
      if (localObject1 == null) {
        break label251;
      }
    }
    label251:
    for (Object localObject1 = ((com.tencent.mm.plugin.webview.c.d)localObject1).context;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof c)) {
        localObject2 = null;
      }
      localObject1 = (c)localObject2;
      if (localObject1 != null) {
        ((c)localObject1).b(localj.BtM);
      }
      localObject1 = localj.BgR;
      if (localObject1 != null) {
        ((com.tencent.mm.bp.a)localObject1).disable();
      }
      Ft();
      Fu();
      localObject1 = this.BtS;
      if (localObject1 != null) {
        ((j)localObject1).bdD();
      }
      this.BtS = null;
      if (this.cmV != null) {
        this.cmV = null;
      }
      Fw();
      if ((this.cku != null) && (this.ckv != null))
      {
        localObject1 = this.cku;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.luggage.k.a.a)localObject1).b(this.ckv);
        this.ckv = null;
      }
      ad.i(getTAG(), "video release handler thread");
      this.cns.removeCallbacksAndMessages(null);
      this.cnt.quitSafely();
      AppMethodBeat.o(189023);
      return;
    }
  }
  
  private final void seek(long paramLong)
  {
    AppMethodBeat.i(189032);
    if ((this.cng) && (this.cmS != null))
    {
      Object localObject;
      if (Fa())
      {
        localObject = this.BtS;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        ((j)localObject).onVideoWaiting();
      }
      if (this.cmS != null)
      {
        localObject = this.cmS;
        if (localObject != null) {}
        for (boolean bool = ((b)localObject).isPlaying();; bool = false)
        {
          this.cnb = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          ad.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cnb) });
          localObject = this.cmS;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          ((b)localObject).seekTo(paramLong);
          AppMethodBeat.o(189032);
          return;
        }
      }
    }
    else
    {
      this.cne = paramLong;
    }
    AppMethodBeat.o(189032);
  }
  
  private final boolean tB(boolean paramBoolean)
  {
    AppMethodBeat.i(189029);
    if (this.cmS != null)
    {
      com.tencent.mm.ad.c.g((d.g.a.a)new x(this));
      if (this.cng)
      {
        localObject1 = this.cmS;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        if (((b)localObject1).isPlaying())
        {
          ad.i(getTAG(), "video play, video is playing");
          if (Fa())
          {
            localObject1 = this.BtS;
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            ((j)localObject1).eqS();
          }
          AppMethodBeat.o(189029);
          return true;
        }
      }
      if (!this.cng)
      {
        ad.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.cnd = true;
        AppMethodBeat.o(189029);
        return true;
      }
      Object localObject1 = this.cmS;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      if (((b)localObject1).getState() == 5)
      {
        if (!paramBoolean)
        {
          ad.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(189029);
          return false;
        }
        ad.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.cnd = true;
        AppMethodBeat.o(189029);
        return true;
      }
      Object localObject2;
      if (this.cno)
      {
        if (!paramBoolean)
        {
          ad.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(189029);
          return false;
        }
        ad.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.cno = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cng))
          {
            ad.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              d.g.b.k.fvU();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label420;
            }
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(189029);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          eqW();
          if (this.cmS != null)
          {
            this.cnf = true;
            localObject2 = this.cmS;
            if (localObject2 == null) {
              d.g.b.k.fvU();
            }
            ((b)localObject2).setDataSource(this.cnm);
            localObject2 = getTAG();
            localObject3 = this.cmS;
            if (localObject3 == null) {
              d.g.b.k.fvU();
            }
            ad.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((b)localObject3).getState()) });
            prepareAsync();
            this.cnd = true;
          }
          AppMethodBeat.o(189029);
          return true;
          label420:
          localObject2 = (EGL10)localObject2;
          Object localObject3 = ((EGL10)localObject2).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
          ((EGL10)localObject2).eglInitialize((EGLDisplay)localObject3, null);
          Object localObject5 = new EGLConfig[1];
          int[] arrayOfInt = new int[1];
          ((EGL10)localObject2).eglChooseConfig((EGLDisplay)localObject3, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject5, 1, arrayOfInt);
          arrayOfInt = localObject5[0];
          localObject5 = ((EGL10)localObject2).eglCreateContext((EGLDisplay)localObject3, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          localObject4 = ((EGL10)localObject2).eglCreateWindowSurface((EGLDisplay)localObject3, arrayOfInt, localObject4, new int[] { 12344 });
          ((EGL10)localObject2).eglMakeCurrent((EGLDisplay)localObject3, (EGLSurface)localObject4, (EGLSurface)localObject4, (EGLContext)localObject5);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
          GLES20.glClear(16384);
          ((EGL10)localObject2).eglSwapBuffers((EGLDisplay)localObject3, (EGLSurface)localObject4);
          ((EGL10)localObject2).eglDestroySurface((EGLDisplay)localObject3, (EGLSurface)localObject4);
          localObject4 = EGL10.EGL_NO_SURFACE;
          ((EGL10)localObject2).eglMakeCurrent((EGLDisplay)localObject3, (EGLSurface)localObject4, (EGLSurface)localObject4, EGL10.EGL_NO_CONTEXT);
          ((EGL10)localObject2).eglDestroyContext((EGLDisplay)localObject3, (EGLContext)localObject5);
          ((EGL10)localObject2).eglTerminate((EGLDisplay)localObject3);
        }
      }
      ad.i(getTAG(), "video play");
      if (this.cmS != null)
      {
        if (Fa())
        {
          localObject2 = this.BtS;
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          ((j)localObject2).eqS();
        }
        localObject2 = this.cmS;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject2).start();
      }
      AppMethodBeat.o(189029);
      return true;
    }
    AppMethodBeat.o(189029);
    return false;
  }
  
  public final void EY()
  {
    AppMethodBeat.i(189017);
    k((Runnable)new m(this));
    AppMethodBeat.o(189017);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189016);
    d.g.b.k.h(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new n(this, paramSurfaceTexture));
    AppMethodBeat.o(189016);
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(189015);
    d.g.b.k.h(parama, "invokeContext");
    AppMethodBeat.o(189015);
    return true;
  }
  
  public final String i(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(189018);
    d.g.b.k.h(parama, "invokeContext");
    k((Runnable)new j(this, parama));
    AppMethodBeat.o(189018);
    return null;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    aa(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class b
    implements d.a
  {
    public final void aqt() {}
    
    public final void aqu() {}
    
    public final void aqv() {}
    
    public final void aqw() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class c
    implements b.d
  {
    c(l paraml) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188985);
      boolean bool = l.a(this.BtV, paramInt1, paramInt2);
      AppMethodBeat.o(188985);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class d
    implements b.c
  {
    d(l paraml) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188986);
      boolean bool = l.b(this.BtV, paramInt1, paramInt2);
      AppMethodBeat.o(188986);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class e
    implements b.e
  {
    e(l paraml) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(188987);
      l.l(this.BtV);
      AppMethodBeat.o(188987);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class f
    implements b.b
  {
    f(l paraml) {}
    
    public final void Fz()
    {
      AppMethodBeat.i(188988);
      l.m(this.BtV);
      AppMethodBeat.o(188988);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class g
    implements b.f
  {
    g(l paraml) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(188989);
      l.n(this.BtV);
      AppMethodBeat.o(188989);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class h
    implements b.g
  {
    h(l paraml) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188990);
      l.c(this.BtV, paramInt1, paramInt2);
      AppMethodBeat.o(188990);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class i
    implements b.a
  {
    i(l paraml) {}
    
    public final void gX(int paramInt)
    {
      AppMethodBeat.i(188991);
      l.a(this.BtV, paramInt);
      AppMethodBeat.o(188991);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(l paraml, com.tencent.luggage.k.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(188992);
      String str = parama.EC();
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(188992);
        return;
      }
      JSONObject localJSONObject = parama.EB();
      ad.i(l.a(this.BtV), "handler(%s) handleJsApi(%s), data:%s", new Object[] { l.f(this.BtV), str, localJSONObject.toString() });
      if ((d.g.b.k.g("handleVideoAction", str) ^ true))
      {
        ad.e(l.a(this.BtV), "handler(%s), not right jsapi:(%s)", new Object[] { l.f(this.BtV), str });
        AppMethodBeat.o(188992);
        return;
      }
      str = localJSONObject.optString("action", "");
      if (str == null)
      {
        AppMethodBeat.o(188992);
        return;
      }
      switch (str.hashCode())
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(188992);
            return;
            if (str.equals("operateSameLayerVideo"))
            {
              l.c(this.BtV, parama);
              AppMethodBeat.o(188992);
              return;
              if (str.equals("removeSameLayerVideo")) {
                l.d(this.BtV, parama);
              }
            }
          }
        } while (!str.equals("insertSameLayerVideo"));
        l.a(this.BtV, parama);
        AppMethodBeat.o(188992);
        return;
      } while (!str.equals("updateSameLayerVideo"));
      l.b(this.BtV, parama);
      AppMethodBeat.o(188992);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(188994);
      if (l.s(this.BtV))
      {
        if ((l.i(this.BtV) != null) && (l.t(this.BtV)) && (l.u(this.BtV) == null))
        {
          b localb = l.i(this.BtV);
          if (localb == null) {
            d.g.b.k.fvU();
          }
          boolean bool = localb.isPlaying();
          l.a(this.BtV, new AtomicBoolean(bool));
          ad.i(l.a(this.BtV), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
          l.v(this.BtV);
          AppMethodBeat.o(188994);
        }
      }
      else
      {
        if (l.w(this.BtV))
        {
          ad.i(l.a(this.BtV), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { l.x(this.BtV) });
          l.y(this.BtV);
          AppMethodBeat.o(188994);
          return;
        }
        ad.i(l.a(this.BtV), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { l.x(this.BtV) });
      }
      AppMethodBeat.o(188994);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(188995);
      l.j(this.BtV);
      ad.i(l.a(this.BtV), "handler(%s) handlePluginDestroy", new Object[] { l.f(this.BtV) });
      l.e(this.BtV);
      l.k(this.BtV);
      AppMethodBeat.o(188995);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(l paraml, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(188996);
      ad.i(l.a(this.BtV), "handler(%s) handlePluginReady", new Object[] { l.f(this.BtV) });
      l.g(this.BtV);
      l.a(this.BtV, paramSurfaceTexture);
      l.a(this.BtV, new Surface(paramSurfaceTexture));
      if (l.i(this.BtV) != null)
      {
        ad.i(l.a(this.BtV), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        b localb = l.i(this.BtV);
        if (localb == null) {
          d.g.b.k.fvU();
        }
        localb.setSurface(l.h(this.BtV));
      }
      AppMethodBeat.o(188996);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class o
    implements c.a
  {
    o(l paraml) {}
    
    public final void f(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188997);
      ad.w(l.a(this.BtV), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (l.b(this.BtV))
      {
        localObject1 = l.c(this.BtV);
        if (localObject1 != null)
        {
          ((j)localObject1).bdD();
          ((j)localObject1).bfk();
        }
      }
      try
      {
        JSONObject localJSONObject = ((j)localObject1).bdC();
        Object localObject2 = z.Jhz;
        localObject2 = Locale.US;
        d.g.b.k.g(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        d.g.b.k.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((j)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = l.d(this.BtV);
        d.g.b.k.g(paramString, "msg");
        d.g.b.k.h(paramString, "msg");
        h.vKh.idkeyStat(1379L, 40L, 1L, false);
        ad.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!bt.isNullOrNil(paramString))
        {
          if (n.I(paramString, "MEDIA_ERR_NETWORK", true)) {
            h.vKh.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((m)localObject1).BtX.kDa = paramInt1;
          ((m)localObject1).BtX.kDb = paramInt2;
          localObject1 = ((m)localObject1).BtX;
          d.g.b.k.h(paramString, "<set-?>");
          ((m.b)localObject1).errorMsg = paramString;
          l.e(this.BtV);
          AppMethodBeat.o(188997);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.e(((j)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.I(paramString, "MEDIA_ERR_DECODE", true)) {
            h.vKh.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.I(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            h.vKh.idkeyStat(1379L, 43L, 1L, false);
          } else {
            h.vKh.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(188998);
      l.b(this.BtV, this.BtW);
      AppMethodBeat.o(188998);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(188999);
      l.p(this.BtV);
      AppMethodBeat.o(188999);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189000);
      l.e(this.BtV, this.nnN, this.nnO);
      AppMethodBeat.o(189000);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189001);
      l.f(this.BtV, this.nnN, this.nnO);
      AppMethodBeat.o(189001);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189002);
      l.q(this.BtV);
      AppMethodBeat.o(189002);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189003);
      l.o(this.BtV);
      AppMethodBeat.o(189003);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189004);
      l.d(this.BtV, this.cor, this.cos);
      AppMethodBeat.o(189004);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    w(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    x(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class y
    implements a.a
  {
    public final void gP(int paramInt)
    {
      AppMethodBeat.i(189008);
      l.A(this.BtV);
      AppMethodBeat.o(189008);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(189009);
      l.B(this.BtV);
      AppMethodBeat.o(189009);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(189007);
      l.z(this.BtV);
      AppMethodBeat.o(189007);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    z(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.l
 * JD-Core Version:    0.7.0.1
 */