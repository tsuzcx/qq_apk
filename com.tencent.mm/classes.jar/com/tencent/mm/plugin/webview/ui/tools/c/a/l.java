package com.tencent.mm.plugin.webview.ui.tools.c.a;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.u;
import d.g.b.w;
import d.g.b.z;
import d.n.n;
import d.v;
import d.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "invokeContext", "handler", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l
  extends com.tencent.luggage.k.a.b.a
{
  final d.a Ael;
  private boolean CMa;
  j CMb;
  private com.tencent.mm.plugin.appbrand.jsapi.z.e.g CMc;
  private final m CMd;
  private int btD;
  private float btH;
  private AtomicBoolean chI;
  private com.tencent.luggage.k.a.a cht;
  private a.a chu;
  private int chv;
  private int chw;
  private boolean chz;
  private b cjU;
  com.tencent.luggage.k.a.a.b.b.c cjX;
  private float ckA;
  private boolean ckc;
  private boolean ckd;
  private boolean cke;
  private boolean ckf;
  private long ckg;
  private boolean ckh;
  private boolean cki;
  private volatile boolean ckj;
  private boolean ckk;
  private boolean ckl;
  private int ckm;
  private int ckn;
  private String cko;
  private String ckp;
  private boolean ckq;
  private volatile boolean ckr;
  private Handler cku;
  private HandlerThread ckv;
  private volatile com.tencent.luggage.k.a.a ckw;
  private float ckz;
  private final com.tencent.mm.model.d gGY;
  private int kUd;
  private int kUe;
  private int kUf;
  private int kUg;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private int mVideoHeight;
  private int mVideoWidth;
  private final d.f nJH;
  private boolean nQC;
  
  static
  {
    AppMethodBeat.i(189595);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(l.class), "TAG", "getTAG()Ljava/lang/String;")) };
    AppMethodBeat.o(189595);
  }
  
  public l()
  {
    AppMethodBeat.i(189620);
    this.nJH = d.g.K((d.g.a.a)new a(this));
    this.ckv = com.tencent.e.c.d.gz("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.ckz = 1.0F;
    this.ckA = 1.0F;
    this.CMc = new com.tencent.mm.plugin.appbrand.jsapi.z.e.g();
    this.CMd = new m();
    Object localObject = com.tencent.mm.model.d.axh();
    d.g.b.k.g(localObject, "AudioHelperTool.createTool()");
    this.gGY = ((com.tencent.mm.model.d)localObject);
    this.ckv.start();
    localObject = this.ckv;
    d.g.b.k.g(localObject, "mVideoHandlerThread");
    this.cku = new Handler(((HandlerThread)localObject).getLooper());
    this.btD = 800000;
    this.btH = 0.75F;
    this.kUd = 10000;
    this.kUe = 25000;
    this.kUf = 15000;
    this.kUg = 30000;
    this.Ael = ((d.a)new b());
    AppMethodBeat.o(189620);
  }
  
  private final void C(com.tencent.luggage.k.a.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(189619);
    parama = parama.Ee();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(189619);
      return;
    }
    this.btD = parama.optInt("maxInitialBitrate", 0);
    this.btH = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.kUd = parama.optInt("minDurForQualityMs", 0);
    this.kUe = parama.optInt("maxDurForQualityMs", 0);
    this.kUf = parama.optInt("minBufferMs", 0);
    this.kUg = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.btD != 0)
    {
      bool1 = bool2;
      if (this.btH != 0.0F)
      {
        bool1 = bool2;
        if (this.kUd != 0)
        {
          bool1 = bool2;
          if (this.kUe != 0)
          {
            bool1 = bool2;
            if (this.kUf != 0)
            {
              bool1 = bool2;
              if (this.kUg != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.nQC = bool1;
    ac.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.nQC);
    AppMethodBeat.o(189619);
  }
  
  /* Error */
  private final boolean EE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 482	com/tencent/mm/plugin/webview/ui/tools/c/a/l:chz	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 484	com/tencent/mm/plugin/webview/ui/tools/c/a/l:CMb	Lcom/tencent/mm/plugin/webview/ui/tools/c/a/j;
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
  
  private final boolean EV()
  {
    AppMethodBeat.i(189597);
    AtomicBoolean localAtomicBoolean = this.chI;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(189597);
      return bool;
    }
    AppMethodBeat.o(189597);
    return false;
  }
  
  private final void EZ()
  {
    AppMethodBeat.i(189604);
    if (!bs.isNullOrNil(this.ckp))
    {
      if ((this.cki) && (Fq() != null) && (this.CMc != null))
      {
        if (this.CMc.a(this.ckp, this.chv, this.chw, this.mVideoWidth, this.mVideoHeight))
        {
          this.ckz = this.CMc.Fo();
          this.ckA = this.CMc.Fp();
          ac.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.ckp, Float.valueOf(this.ckz), Float.valueOf(this.ckA) });
          com.tencent.luggage.k.a.d.a(Fq(), getType(), getId(), this.ckz, this.ckA);
          AppMethodBeat.o(189604);
        }
      }
      else
      {
        ac.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(189604);
      }
    }
    else {
      ac.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(189604);
  }
  
  private final boolean Fb()
  {
    AppMethodBeat.i(189615);
    com.tencent.mm.ac.c.g((d.g.a.a)new aa(this));
    Object localObject = this.cjU;
    if (localObject != null)
    {
      this.CMd.a(this.cht, (b)localObject);
      if (!this.cki)
      {
        ac.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.ckf = false;
        AppMethodBeat.o(189615);
        return true;
      }
      ac.i(getTAG(), "video stop");
      ((b)localObject).stop();
      if (EE())
      {
        localObject = this.CMb;
        if (localObject != null) {
          ((j)localObject).eGo();
        }
      }
      AppMethodBeat.o(189615);
      return true;
    }
    AppMethodBeat.o(189615);
    return false;
  }
  
  private final void Fc()
  {
    try
    {
      AppMethodBeat.i(189608);
      if (this.cjU != null)
      {
        ac.i(getTAG(), "releaseMediaPlayer");
        b localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.a(null);
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.stop();
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.reset();
        localb = this.cjU;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.release();
      }
      this.cjU = null;
      this.ckj = false;
      AppMethodBeat.o(189608);
      return;
    }
    finally {}
  }
  
  private final void Fe()
  {
    AppMethodBeat.i(189609);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        d.g.b.k.fOy();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(189609);
  }
  
  private final void as(Bitmap paramBitmap)
  {
    AppMethodBeat.i(189618);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i(getTAG(), "bitmap recycle ".concat(String.valueOf(paramBitmap)));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(189618);
  }
  
  private final void eGp()
  {
    AppMethodBeat.i(189602);
    ac.i(getTAG(), "createMediaPlayer");
    Object localObject = this.cku;
    long l = System.currentTimeMillis();
    if (this.nQC)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c((Handler)localObject, this.btD, this.btH, this.kUd, this.kUe, this.kUf, this.kUg);
      l = System.currentTimeMillis() - l;
      ac.d(getTAG(), "createMediaPlayer cost %s", new Object[] { Long.valueOf(l) });
      m localm = this.CMd;
      h.wUl.idkeyStat(1379L, 10L, 1L, false);
      h.wUl.idkeyStat(1379L, 11L, l, false);
      localm.CMg.leg = l;
      this.cjU = ((b)localObject);
      if (this.cjU == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.ckj = bool;
      if (this.ckj) {
        break label204;
      }
      ac.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(189602);
      return;
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c((Handler)localObject);
      break;
    }
    label204:
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.d)new c(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.c)new d(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.e)new e(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.b)new f(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.f)new g(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.g)new h(this));
    localObject = this.cjU;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((b)localObject).a((b.a)new i(this));
    AppMethodBeat.o(189602);
  }
  
  private final void eGq()
  {
    AppMethodBeat.i(189607);
    this.ckq = false;
    Fc();
    eGp();
    if (this.cjU != null)
    {
      b localb = this.cjU;
      if (localb == null) {
        d.g.b.k.fOy();
      }
      localb.setMute(this.ckl);
      if (this.mSurface != null)
      {
        if (!this.ckr)
        {
          ac.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localb = this.cjU;
          if (localb == null) {
            d.g.b.k.fOy();
          }
          localb.setSurface(this.mSurface);
          AppMethodBeat.o(189607);
          return;
        }
        ac.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(189607);
  }
  
  private final void fdh()
  {
    AppMethodBeat.i(210109);
    this.ckr = true;
    ac.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ac.c.g((d.g.a.a)new k(this));
    k((Runnable)new l(this));
    AppMethodBeat.o(210109);
  }
  
  private final int getDuration()
  {
    AppMethodBeat.i(189612);
    b localb = this.cjU;
    if (localb != null)
    {
      int i = localb.getDuration();
      AppMethodBeat.o(189612);
      return i;
    }
    AppMethodBeat.o(189612);
    return 0;
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(189596);
    String str = (String)this.nJH.getValue();
    AppMethodBeat.o(189596);
    return str;
  }
  
  private final boolean iT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189603);
    if (!this.ckj)
    {
      ac.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(189603);
      return false;
    }
    ac.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    m.b localb;
    if (paramInt1 == 701)
    {
      localObject = this.cjU;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      this.cke = ((b)localObject).isPlaying();
      ac.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cke) });
      if (EE())
      {
        localObject = this.CMb;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      localObject = this.CMd;
      if (((m)localObject).CMg.leo <= 0L)
      {
        localb = ((m)localObject).CMg;
        localb.lel += 1;
        ((m)localObject).CMg.leo = bs.eWj();
        h.wUl.idkeyStat(1379L, 30L, 1L, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(189603);
      return false;
      if (paramInt1 == 702)
      {
        localObject = this.cjU;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        boolean bool = ((b)localObject).isPlaying();
        ac.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cke), Boolean.valueOf(bool) });
        if (this.cke)
        {
          this.cke = false;
          if ((bool) && (EE()))
          {
            ac.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject = this.CMb;
            if (localObject != null) {
              ((j)localObject).eGm();
            }
          }
        }
        for (;;)
        {
          localObject = this.CMd;
          if (((m)localObject).CMg.lep <= 0L)
          {
            ((m)localObject).CMg.lep = bs.eWj();
            h.wUl.idkeyStat(1379L, 31L, 1L, false);
            long l = ((m)localObject).CMg.lep - ((m)localObject).CMg.leo;
            localb = ((m)localObject).CMg;
            localb.lem += l;
            h.wUl.idkeyStat(1379L, 32L, l, false);
            ac.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject = ((m)localObject).CMg;
          ((m.b)localObject).leo = 0L;
          ((m.b)localObject).lep = 0L;
          break;
          if ((!bool) && (EE()))
          {
            ac.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject = this.CMb;
            if (localObject != null) {
              ((j)localObject).eGo();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        ac.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = this.cjX;
        if (localObject != null) {
          ((com.tencent.luggage.k.a.a.b.b.c)localObject).ca(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.ckj) {
          ac.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          ac.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  private final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(189610);
    if (d.g.b.k.g(this.cku.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(189610);
      return true;
      this.cku.post(paramRunnable);
    }
  }
  
  private final boolean pause()
  {
    AppMethodBeat.i(189614);
    com.tencent.mm.ac.c.g((d.g.a.a)new w(this));
    if (this.cjU != null)
    {
      if (!this.cki)
      {
        ac.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.ckf = false;
        AppMethodBeat.o(189614);
        return true;
      }
      Object localObject = this.cjU;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (!((b)localObject).isPlaying())
      {
        ac.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(189614);
        return true;
      }
      ac.i(getTAG(), "video pause");
      localObject = this.cjU;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((b)localObject).pause();
      if (EE())
      {
        localObject = this.CMb;
        if (localObject != null) {
          ((j)localObject).eGo();
        }
      }
      AppMethodBeat.o(189614);
      return true;
    }
    AppMethodBeat.o(189614);
    return false;
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(189605);
    if (this.cjU != null)
    {
      ac.i(getTAG(), "video prepare async");
      if (EE())
      {
        localObject = this.CMb;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      this.cki = false;
      this.ckf = false;
      Object localObject = this.cjU;
      if (localObject != null) {
        ((b)localObject).prepareAsync();
      }
      localObject = this.CMd;
      if (((m)localObject).CMg.lei <= 0L)
      {
        ((m)localObject).CMg.lei = bs.eWj();
        h.wUl.idkeyStat(1379L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(189605);
  }
  
  private final void release()
  {
    AppMethodBeat.i(189606);
    ac.i(getTAG(), "video release");
    com.tencent.mm.ac.c.g((d.g.a.a)new z(this));
    j localj;
    Object localObject1;
    if ((this.CMb instanceof j))
    {
      localj = this.CMb;
      if (localj == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(189606);
        throw ((Throwable)localObject1);
      }
      localObject1 = localj.CLT;
      if (localObject1 == null) {
        break label297;
      }
      localObject1 = ((f)localObject1).CLN;
      if (localObject1 == null) {
        break label297;
      }
      localObject1 = ((com.tencent.mm.plugin.webview.c.d)localObject1).context;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof c)) {
        localObject2 = null;
      }
      localObject1 = (c)localObject2;
      if (localObject1 != null) {
        ((c)localObject1).b(localj.CLW);
      }
      localObject1 = localj.Cze;
      if (localObject1 != null) {
        ((com.tencent.mm.bo.a)localObject1).disable();
      }
      if (localj.Haf != null) {}
      try
      {
        localObject1 = ai.getContext();
        d.g.b.k.g(localObject1, "MMApplicationContext.getContext()");
        ((Context)localObject1).getContentResolver().unregisterContentObserver(localj.Haf);
        if (localj.Hag == null) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          ai.getContext().unregisterReceiver(localj.Hag);
          Fb();
          Fc();
          localObject1 = this.CMb;
          if (localObject1 != null) {
            ((j)localObject1).bky();
          }
          this.CMb = null;
          if (this.cjX != null) {
            this.cjX = null;
          }
          Fe();
          if ((this.cht != null) && (this.chu != null))
          {
            localObject1 = this.cht;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            ((com.tencent.luggage.k.a.a)localObject1).b(this.chu);
            this.chu = null;
          }
          ac.i(getTAG(), "video release handler thread");
          this.cku.removeCallbacksAndMessages(null);
          this.ckv.quitSafely();
          AppMethodBeat.o(189606);
          return;
          label297:
          localObject1 = null;
          continue;
          localThrowable1 = localThrowable1;
          ac.printErrStackTrace(localj.TAG, localThrowable1, "unregisterContentObserver", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            ac.printErrStackTrace(localj.TAG, localThrowable2, "unregisterContentObserver", new Object[0]);
          }
        }
      }
    }
  }
  
  private final void seek(long paramLong)
  {
    AppMethodBeat.i(189616);
    if ((this.cki) && (this.cjU != null))
    {
      Object localObject;
      if (EE())
      {
        localObject = this.CMb;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        ((j)localObject).onVideoWaiting();
      }
      if (this.cjU != null)
      {
        localObject = this.cjU;
        if (localObject != null) {}
        for (boolean bool = ((b)localObject).isPlaying();; bool = false)
        {
          this.ckd = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          ac.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.ckd) });
          localObject = this.cjU;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          ((b)localObject).seekTo(paramLong);
          AppMethodBeat.o(189616);
          return;
        }
      }
    }
    else
    {
      this.ckg = paramLong;
    }
    AppMethodBeat.o(189616);
  }
  
  private final boolean uD(boolean paramBoolean)
  {
    AppMethodBeat.i(189613);
    if (this.cjU != null)
    {
      com.tencent.mm.ac.c.g((d.g.a.a)new x(this));
      if (this.cki)
      {
        localObject1 = this.cjU;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        if (((b)localObject1).isPlaying())
        {
          ac.i(getTAG(), "video play, video is playing");
          if (EE())
          {
            localObject1 = this.CMb;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            ((j)localObject1).eGm();
          }
          AppMethodBeat.o(189613);
          return true;
        }
      }
      if (!this.cki)
      {
        ac.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.ckf = true;
        AppMethodBeat.o(189613);
        return true;
      }
      Object localObject1 = this.cjU;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (((b)localObject1).getState() == 5)
      {
        if (!paramBoolean)
        {
          ac.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(189613);
          return false;
        }
        ac.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.ckf = true;
        AppMethodBeat.o(189613);
        return true;
      }
      Object localObject2;
      if (this.ckq)
      {
        if (!paramBoolean)
        {
          ac.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(189613);
          return false;
        }
        ac.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.ckq = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cki))
          {
            ac.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              d.g.b.k.fOy();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label420;
            }
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(189613);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          eGq();
          if (this.cjU != null)
          {
            this.ckh = true;
            localObject2 = this.cjU;
            if (localObject2 == null) {
              d.g.b.k.fOy();
            }
            ((b)localObject2).setDataSource(this.cko);
            localObject2 = getTAG();
            localObject3 = this.cjU;
            if (localObject3 == null) {
              d.g.b.k.fOy();
            }
            ac.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((b)localObject3).getState()) });
            prepareAsync();
            this.ckf = true;
          }
          AppMethodBeat.o(189613);
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
      ac.i(getTAG(), "video play");
      if (this.cjU != null)
      {
        if (EE())
        {
          localObject2 = this.CMb;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          ((j)localObject2).eGm();
        }
        localObject2 = this.cjU;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        ((b)localObject2).start();
      }
      AppMethodBeat.o(189613);
      return true;
    }
    AppMethodBeat.o(189613);
    return false;
  }
  
  public final void EC()
  {
    AppMethodBeat.i(189600);
    k((Runnable)new m(this));
    AppMethodBeat.o(189600);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189599);
    d.g.b.k.h(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new n(this, paramSurfaceTexture));
    AppMethodBeat.o(189599);
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(189598);
    d.g.b.k.h(parama, "invokeContext");
    AppMethodBeat.o(189598);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(189611);
    b localb = this.cjU;
    if (localb != null)
    {
      int i = localb.getCurrentPosition();
      AppMethodBeat.o(189611);
      return i;
    }
    AppMethodBeat.o(189611);
    return 0;
  }
  
  public final String h(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(189601);
    d.g.b.k.h(parama, "invokeContext");
    k((Runnable)new j(this, parama));
    AppMethodBeat.o(189601);
    return null;
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(189617);
    super.r(paramBitmap);
    com.tencent.luggage.k.a.a locala = this.ckw;
    if (locala == null)
    {
      ac.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(189617);
      return;
    }
    if (paramBitmap == null)
    {
      ac.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.cs("fail");
      AppMethodBeat.o(189617);
      return;
    }
    if ((this.chv != 0) && (this.chw != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.ckz * this.chv), (int)(this.ckA * this.chw), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      d.g.b.k.g(localObject1, "Base64.encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      d.g.b.k.g(localObject2, "StandardCharsets.UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      ac.i(getTAG(), "handlePluginScreenshotTaken size=" + ((String)localObject1).length());
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.d("ok", (Map)localObject2);
      as(paramBitmap);
      as(localBitmap);
      this.ckw = null;
      AppMethodBeat.o(189617);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    aa(l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class b
    implements d.a
  {
    public final void axj() {}
    
    public final void axk() {}
    
    public final void axl() {}
    
    public final void axm() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class c
    implements b.d
  {
    c(l paraml) {}
    
    public final boolean bY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189568);
      boolean bool = l.a(this.CMe, paramInt1, paramInt2);
      AppMethodBeat.o(189568);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class d
    implements b.c
  {
    d(l paraml) {}
    
    public final boolean bZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189569);
      boolean bool = l.b(this.CMe, paramInt1, paramInt2);
      AppMethodBeat.o(189569);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class e
    implements b.e
  {
    e(l paraml) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(189570);
      l.l(this.CMe);
      AppMethodBeat.o(189570);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class f
    implements b.b
  {
    f(l paraml) {}
    
    public final void Fh()
    {
      AppMethodBeat.i(189571);
      l.m(this.CMe);
      AppMethodBeat.o(189571);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class g
    implements b.f
  {
    g(l paraml) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(189572);
      l.n(this.CMe);
      AppMethodBeat.o(189572);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class h
    implements b.g
  {
    h(l paraml) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189573);
      l.c(this.CMe, paramInt1, paramInt2);
      AppMethodBeat.o(189573);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class i
    implements b.a
  {
    i(l paraml) {}
    
    public final void gH(int paramInt)
    {
      AppMethodBeat.i(189574);
      l.a(this.CMe, paramInt);
      AppMethodBeat.o(189574);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(l paraml, com.tencent.luggage.k.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189575);
      String str = parama.Ef();
      if (bs.isNullOrNil(str))
      {
        AppMethodBeat.o(189575);
        return;
      }
      JSONObject localJSONObject = parama.Ee();
      ac.i(l.a(this.CMe), "handler(%s) handleJsApi(%s), data:%s", new Object[] { l.f(this.CMe), str, localJSONObject.toString() });
      if ((d.g.b.k.g("handleVideoAction", str) ^ true))
      {
        ac.e(l.a(this.CMe), "handler(%s), not right jsapi:(%s)", new Object[] { l.f(this.CMe), str });
        AppMethodBeat.o(189575);
        return;
      }
      str = localJSONObject.optString("action", "");
      if (str == null)
      {
        AppMethodBeat.o(189575);
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
            AppMethodBeat.o(189575);
            return;
            if (str.equals("operateSameLayerVideo"))
            {
              l.c(this.CMe, parama);
              AppMethodBeat.o(189575);
              return;
              if (str.equals("removeSameLayerVideo")) {
                l.d(this.CMe, parama);
              }
            }
          }
        } while (!str.equals("insertSameLayerVideo"));
        l.a(this.CMe, parama);
        AppMethodBeat.o(189575);
        return;
      } while (!str.equals("updateSameLayerVideo"));
      l.b(this.CMe, parama);
      AppMethodBeat.o(189575);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189577);
      if (l.s(this.CMe))
      {
        if ((l.i(this.CMe) != null) && (l.t(this.CMe)) && (l.u(this.CMe) == null))
        {
          b localb = l.i(this.CMe);
          if (localb == null) {
            d.g.b.k.fOy();
          }
          boolean bool = localb.isPlaying();
          l.a(this.CMe, new AtomicBoolean(bool));
          ac.i(l.a(this.CMe), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
          l.v(this.CMe);
          AppMethodBeat.o(189577);
        }
      }
      else
      {
        if (l.w(this.CMe))
        {
          ac.i(l.a(this.CMe), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { l.x(this.CMe) });
          l.y(this.CMe);
          AppMethodBeat.o(189577);
          return;
        }
        ac.i(l.a(this.CMe), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { l.x(this.CMe) });
      }
      AppMethodBeat.o(189577);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189578);
      l.j(this.CMe);
      ac.i(l.a(this.CMe), "handler(%s) handlePluginDestroy", new Object[] { l.f(this.CMe) });
      l.e(this.CMe);
      l.k(this.CMe);
      AppMethodBeat.o(189578);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(l paraml, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(189579);
      ac.i(l.a(this.CMe), "handler(%s) handlePluginReady", new Object[] { l.f(this.CMe) });
      l.g(this.CMe);
      l.a(this.CMe, paramSurfaceTexture);
      l.a(this.CMe, new Surface(paramSurfaceTexture));
      if (l.i(this.CMe) != null)
      {
        ac.i(l.a(this.CMe), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        b localb = l.i(this.CMe);
        if (localb == null) {
          d.g.b.k.fOy();
        }
        localb.setSurface(l.h(this.CMe));
      }
      AppMethodBeat.o(189579);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class o
    implements c.a
  {
    o(l paraml) {}
    
    public final void f(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189580);
      ac.w(l.a(this.CMe), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (l.b(this.CMe))
      {
        localObject1 = l.c(this.CMe);
        if (localObject1 != null)
        {
          ((j)localObject1).bky();
          ((j)localObject1).bme();
        }
      }
      try
      {
        JSONObject localJSONObject = ((j)localObject1).bkx();
        Object localObject2 = z.KUT;
        localObject2 = Locale.US;
        d.g.b.k.g(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        d.g.b.k.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((j)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = l.d(this.CMe);
        d.g.b.k.g(paramString, "msg");
        d.g.b.k.h(paramString, "msg");
        h.wUl.idkeyStat(1379L, 40L, 1L, false);
        ac.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!bs.isNullOrNil(paramString))
        {
          if (n.I(paramString, "MEDIA_ERR_NETWORK", true)) {
            h.wUl.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((m)localObject1).CMg.les = paramInt1;
          ((m)localObject1).CMg.let = paramInt2;
          localObject1 = ((m)localObject1).CMg;
          d.g.b.k.h(paramString, "<set-?>");
          ((m.b)localObject1).errorMsg = paramString;
          l.e(this.CMe);
          AppMethodBeat.o(189580);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.e(((j)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.I(paramString, "MEDIA_ERR_DECODE", true)) {
            h.wUl.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.I(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            h.wUl.idkeyStat(1379L, 43L, 1L, false);
          } else {
            h.wUl.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(189581);
      l.b(this.CMe, this.CMf);
      AppMethodBeat.o(189581);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189582);
      l.p(this.CMe);
      AppMethodBeat.o(189582);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189583);
      l.e(this.CMe, this.nQN, this.nQO);
      AppMethodBeat.o(189583);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189584);
      l.f(this.CMe, this.nQN, this.nQO);
      AppMethodBeat.o(189584);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189585);
      l.q(this.CMe);
      AppMethodBeat.o(189585);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(189586);
      l.o(this.CMe);
      AppMethodBeat.o(189586);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189587);
      l.d(this.CMe, this.clt, this.clu);
      AppMethodBeat.o(189587);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    w(l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    x(l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class y
    implements a.a
  {
    public final void gz(int paramInt)
    {
      AppMethodBeat.i(189591);
      l.A(this.CMe);
      AppMethodBeat.o(189591);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(189592);
      l.B(this.CMe);
      AppMethodBeat.o(189592);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(189590);
      l.z(this.CMe);
      AppMethodBeat.o(189590);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.l
 * JD-Core Version:    0.7.0.1
 */