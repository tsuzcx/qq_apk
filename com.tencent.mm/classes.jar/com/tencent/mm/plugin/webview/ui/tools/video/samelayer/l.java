package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import android.view.Surface;
import com.tencent.f.i;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
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
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  final d.a Goc;
  boolean Jyf;
  j Jyg;
  private com.tencent.mm.plugin.appbrand.jsapi.ag.e.g Jyh;
  final m Jyi;
  private int bDU;
  private float bDY;
  com.tencent.luggage.xweb_ext.extendplugin.a cED;
  a.a cEE;
  int cEF;
  int cEG;
  boolean cEJ;
  AtomicBoolean cET;
  com.tencent.mm.plugin.appbrand.jsapi.video.e.c cIV;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cIY;
  private float cJD;
  private float cJE;
  boolean cJd;
  boolean cJe;
  boolean cJf;
  boolean cJg;
  long cJh;
  boolean cJi;
  boolean cJj;
  volatile boolean cJk;
  boolean cJl;
  boolean cJm;
  int cJn;
  int cJo;
  String cJp;
  String cJq;
  boolean cJr;
  volatile boolean cJs;
  private Handler cJv;
  private HandlerThread cJw;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cJx;
  final com.tencent.mm.model.d hWh;
  private int mCn;
  private int mCo;
  private int mCp;
  private int mCq;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  int mVideoHeight;
  int mVideoWidth;
  private final kotlin.f pFA;
  private boolean pNt;
  private final kotlin.f pNy;
  
  public l()
  {
    AppMethodBeat.i(210785);
    this.pFA = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.cJw = com.tencent.f.c.d.hA("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.cJD = 1.0F;
    this.cJE = 1.0F;
    this.Jyh = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.g();
    this.Jyi = new m();
    Object localObject = com.tencent.mm.model.d.aTu();
    p.g(localObject, "AudioHelperTool.createTool()");
    this.hWh = ((com.tencent.mm.model.d)localObject);
    this.cJw.start();
    localObject = this.cJw;
    p.g(localObject, "mVideoHandlerThread");
    this.cJv = new Handler(((HandlerThread)localObject).getLooper());
    this.bDU = 800000;
    this.bDY = 0.75F;
    this.mCn = 10000;
    this.mCo = 25000;
    this.mCp = 15000;
    this.mCq = 30000;
    this.Goc = ((d.a)new c());
    this.pNy = kotlin.g.ah((kotlin.g.a.a)l.b.Jyk);
    AppMethodBeat.o(210785);
  }
  
  private final void Qu()
  {
    try
    {
      AppMethodBeat.i(210769);
      if (this.cIV != null)
      {
        Log.i(getTAG(), "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.a(null);
        }
        localc = this.cIV;
        if (localc != null) {
          localc.stop();
        }
        localc = this.cIV;
        if (localc != null) {
          localc.reset();
        }
        localc = this.cIV;
        if (localc != null) {
          localc.release();
        }
      }
      this.cIV = null;
      this.cJk = false;
      AppMethodBeat.o(210769);
      return;
    }
    finally {}
  }
  
  private final void aI(Bitmap paramBitmap)
  {
    AppMethodBeat.i(210779);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i(getTAG(), "bitmap recycle ".concat(String.valueOf(paramBitmap)));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(210779);
  }
  
  private final boolean getAbTestVideoPreload()
  {
    AppMethodBeat.i(210783);
    boolean bool = ((Boolean)this.pNy.getValue()).booleanValue();
    AppMethodBeat.o(210783);
    return bool;
  }
  
  final void B(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210780);
    parama = parama.Ps();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(210780);
      return;
    }
    this.bDU = parama.optInt("maxInitialBitrate", 0);
    this.bDY = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.mCn = parama.optInt("minDurForQualityMs", 0);
    this.mCo = parama.optInt("maxDurForQualityMs", 0);
    this.mCp = parama.optInt("minBufferMs", 0);
    this.mCq = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.bDU != 0)
    {
      bool1 = bool2;
      if (this.bDY != 0.0F)
      {
        bool1 = bool2;
        if (this.mCn != 0)
        {
          bool1 = bool2;
          if (this.mCo != 0)
          {
            bool1 = bool2;
            if (this.mCp != 0)
            {
              bool1 = bool2;
              if (this.mCq != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.pNt = bool1;
    Log.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.pNt);
    AppMethodBeat.o(210780);
  }
  
  final void C(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(210781);
    D(parama);
    com.tencent.f.h.RTc.n((Runnable)new d(this, parama), 2000L);
    AppMethodBeat.o(210781);
  }
  
  final void D(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(210782);
    if ((!this.cJs) && ((parama.getContext() instanceof MMActivity)))
    {
      parama = parama.getContext();
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(210782);
        throw parama;
      }
      if (((MMActivity)parama).isPaused())
      {
        Log.w(getTAG(), "checkPause, onBackGround");
        gii();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 0L, 1L, false);
      }
    }
    AppMethodBeat.o(210782);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(210760);
    k((Runnable)new p(this));
    AppMethodBeat.o(210760);
  }
  
  /* Error */
  final boolean PS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 608	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:cEJ	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 610	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:Jyg	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/j;
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
  
  final boolean Qo()
  {
    AppMethodBeat.i(210757);
    AtomicBoolean localAtomicBoolean = this.cET;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(210757);
      return bool;
    }
    AppMethodBeat.o(210757);
    return false;
  }
  
  final boolean Qt()
  {
    AppMethodBeat.i(210776);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new ad(this));
    Object localObject = this.cIV;
    if (localObject != null)
    {
      this.Jyi.a(this.cED, (com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject);
      if (!this.cJj)
      {
        Log.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.cJg = false;
        AppMethodBeat.o(210776);
        return true;
      }
      Log.i(getTAG(), "video stop");
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).stop();
      if (PS())
      {
        localObject = this.Jyg;
        if (localObject != null) {
          ((j)localObject).gig();
        }
      }
      AppMethodBeat.o(210776);
      return true;
    }
    AppMethodBeat.o(210776);
    return false;
  }
  
  final void Qx()
  {
    AppMethodBeat.i(210770);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.hyc();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(210770);
  }
  
  final void crw()
  {
    AppMethodBeat.i(210764);
    if (!Util.isNullOrNil(this.cJq))
    {
      if ((this.cJj) && (QJ() != null) && (this.Jyh != null))
      {
        if (this.Jyh.a(this.cJq, this.cEF, this.cEG, this.mVideoWidth, this.mVideoHeight))
        {
          this.cJD = this.Jyh.QH();
          this.cJE = this.Jyh.QI();
          Log.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cJq, Float.valueOf(this.cJD), Float.valueOf(this.cJE) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), getType(), getId(), this.cJD, this.cJE);
          AppMethodBeat.o(210764);
        }
      }
      else
      {
        Log.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(210764);
      }
    }
    else {
      Log.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(210764);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(210759);
    p.h(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new q(this, paramSurfaceTexture));
    AppMethodBeat.o(210759);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(210758);
    p.h(parama, "invokeContext");
    AppMethodBeat.o(210758);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(210772);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cIV;
    if (localc != null)
    {
      int i = localc.getCurrentPosition();
      AppMethodBeat.o(210772);
      return i;
    }
    AppMethodBeat.o(210772);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(210773);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cIV;
    if (localc != null)
    {
      int i = localc.getDuration();
      AppMethodBeat.o(210773);
      return i;
    }
    AppMethodBeat.o(210773);
    return 0;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(210756);
    String str = (String)this.pFA.getValue();
    AppMethodBeat.o(210756);
    return str;
  }
  
  final void gih()
  {
    AppMethodBeat.i(210762);
    Log.i(getTAG(), "createMediaPlayer");
    Object localObject = this.cJv;
    long l = System.currentTimeMillis();
    if (this.pNt)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f((Handler)localObject, this.bDU, this.bDY, this.mCn, this.mCo, this.mCp, this.mCq);
      l = System.currentTimeMillis() - l;
      Log.d(getTAG(), "createMediaPlayer cost %s", new Object[] { Long.valueOf(l) });
      m localm = this.Jyi;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 11L, l, false);
      localm.Jym.mNo = l;
      this.cIV = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject);
      if (this.cIV == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.cJk = bool;
      if (this.cJk) {
        break label204;
      }
      Log.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(210762);
      return;
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f((Handler)localObject);
      break;
    }
    label204:
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.f)new e(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.e)new f(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.g)new g(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.b)new h(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.h)new i(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.i)new j(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a)new k(this));
    }
    localObject = this.cIV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).a((c.d)new l(this));
    }
    localObject = this.Jyg;
    if (localObject != null)
    {
      ((j)localObject).bbk("StartPlayer");
      AppMethodBeat.o(210762);
      return;
    }
    AppMethodBeat.o(210762);
  }
  
  final void gii()
  {
    AppMethodBeat.i(210766);
    this.cJs = true;
    Log.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new n(this));
    k((Runnable)new o(this));
    AppMethodBeat.o(210766);
  }
  
  final void gij()
  {
    AppMethodBeat.i(210768);
    this.cJr = false;
    Qu();
    gih();
    if (this.cIV != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cIV;
      if (localc != null) {
        localc.setMute(this.cJm);
      }
      if (this.mSurface != null)
      {
        if (!this.cJs)
        {
          Log.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localc = this.cIV;
          if (localc != null)
          {
            localc.setSurface(this.mSurface);
            AppMethodBeat.o(210768);
            return;
          }
          AppMethodBeat.o(210768);
          return;
        }
        Log.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(210768);
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(210761);
    p.h(parama, "invokeContext");
    k((Runnable)new m(this, parama));
    AppMethodBeat.o(210761);
    return null;
  }
  
  final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(210771);
    if (p.j(this.cJv.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(210771);
      return true;
      this.cJv.post(paramRunnable);
    }
  }
  
  final boolean ks(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210763);
    if (!this.cJk)
    {
      Log.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(210763);
      return false;
    }
    Log.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    boolean bool;
    m.b localb;
    if (paramInt1 == 701)
    {
      localObject = this.cIV;
      if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).isPlaying() == true))
      {
        bool = true;
        this.cJf = bool;
        Log.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cJf) });
        if (PS())
        {
          localObject = this.Jyg;
          if (localObject != null) {
            ((j)localObject).onVideoWaiting();
          }
        }
        localObject = this.Jyi;
        if (((m)localObject).Jym.mNv <= 0L)
        {
          localb = ((m)localObject).Jym;
          localb.mNt += 1;
          ((m)localObject).Jym.mNv = Util.nowMilliSecond();
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 30L, 1L, false);
        }
      }
    }
    for (;;)
    {
      localObject = this.cIV;
      if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).isPlaying() == true) && (this.cJs) && (this.Jyf))
      {
        this.cET = new AtomicBoolean(true);
        pause();
      }
      AppMethodBeat.o(210763);
      return false;
      bool = false;
      break;
      if (paramInt1 == 702)
      {
        localObject = this.cIV;
        if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).isPlaying() == true))
        {
          bool = true;
          label302:
          Log.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cJf), Boolean.valueOf(bool) });
          if (!this.cJf) {
            break label541;
          }
          this.cJf = false;
          if ((bool) && (PS()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject = this.Jyg;
            if (localObject != null) {
              ((j)localObject).gif();
            }
          }
        }
        for (;;)
        {
          localObject = this.Jyi;
          if ((((m)localObject).Jym.mNw <= 0L) && (((m)localObject).Jym.mNv > 0L))
          {
            ((m)localObject).Jym.mNw = Util.nowMilliSecond();
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 31L, 1L, false);
            long l = ((m)localObject).Jym.mNw - ((m)localObject).Jym.mNv;
            localb = ((m)localObject).Jym;
            localb.mNu += l;
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 32L, l, false);
            Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject = ((m)localObject).Jym;
          ((m.b)localObject).mNv = 0L;
          ((m.b)localObject).mNw = 0L;
          break;
          bool = false;
          break label302;
          label541:
          if ((!bool) && (PS()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject = this.Jyg;
            if (localObject != null) {
              ((j)localObject).gig();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        Log.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = this.cIY;
        if (localObject != null) {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cd(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.cJk) {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(210775);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new z(this));
    if (this.cIV != null)
    {
      if (!this.cJj)
      {
        Log.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.cJg = false;
        AppMethodBeat.o(210775);
        return true;
      }
      Object localObject = this.cIV;
      if ((localObject == null) || (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).isPlaying() != true))
      {
        Log.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(210775);
        return true;
      }
      Log.i(getTAG(), "video pause");
      localObject = this.cIV;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).pause();
      }
      if (PS())
      {
        localObject = this.Jyg;
        if (localObject != null) {
          ((j)localObject).gig();
        }
      }
      AppMethodBeat.o(210775);
      return true;
    }
    AppMethodBeat.o(210775);
    return false;
  }
  
  final void prepareAsync()
  {
    AppMethodBeat.i(210765);
    if (this.cIV != null)
    {
      Log.i(getTAG(), "video prepare async");
      if (PS())
      {
        localObject = this.Jyg;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
        localObject = this.Jyg;
        if (localObject != null) {
          ((j)localObject).bbk("StartDownload");
        }
      }
      this.cJj = false;
      this.cJg = false;
      Object localObject = this.cIV;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).prepareAsync();
      }
      localObject = this.Jyi;
      if (((m)localObject).Jym.mNq <= 0L)
      {
        ((m)localObject).Jym.mNq = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(210765);
  }
  
  final void release()
  {
    AppMethodBeat.i(210767);
    Log.i(getTAG(), "video release");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new ac(this));
    j localj;
    Object localObject1;
    if ((this.Jyg instanceof j))
    {
      localj = this.Jyg;
      if (localj == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(210767);
        throw ((Throwable)localObject1);
      }
      localObject1 = localj.JxW;
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = ((f)localObject1).JxI;
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = ((com.tencent.mm.plugin.webview.d.f)localObject1).context;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof c)) {
        localObject2 = null;
      }
      localObject1 = (c)localObject2;
      if (localObject1 != null) {
        ((c)localObject1).b(localj.JxZ);
      }
      localObject1 = localj.Jii;
      if (localObject1 != null) {
        ((com.tencent.mm.bo.a)localObject1).disable();
      }
      if (localj.Jyb != null) {}
      try
      {
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getContentResolver();
        localObject2 = localj.Jyb;
        if (localObject2 == null) {
          p.hyc();
        }
        ((ContentResolver)localObject1).unregisterContentObserver((ContentObserver)localObject2);
        if (localj.Jyc == null) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          MMApplicationContext.getContext().unregisterReceiver(localj.Jyc);
          Qt();
          Qu();
          localObject1 = this.Jyg;
          if (localObject1 != null) {
            ((j)localObject1).bKw();
          }
          this.Jyg = null;
          if (this.cIY != null) {
            this.cIY = null;
          }
          Qx();
          Log.i(getTAG(), "video release handler thread");
          this.cJv.removeCallbacksAndMessages(null);
          this.cJw.quitSafely();
          AppMethodBeat.o(210767);
          return;
          label267:
          localObject1 = null;
          continue;
          localThrowable1 = localThrowable1;
          Log.printErrStackTrace(localj.TAG, localThrowable1, "unregisterContentObserver", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            Log.printErrStackTrace(localj.TAG, localThrowable2, "unregisterContentObserver", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(210778);
    super.s(paramBitmap);
    com.tencent.luggage.xweb_ext.extendplugin.a locala = this.cJx;
    if (locala == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(210778);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.dP("fail");
      AppMethodBeat.o(210778);
      return;
    }
    if ((this.cEF != 0) && (this.cEG != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cJD * this.cEF), (int)(this.cJE * this.cEG), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      p.g(localObject1, "Base64.encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      p.g(localObject2, "StandardCharsets.UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      Log.i(getTAG(), "handlePluginScreenshotTaken size=" + ((String)localObject1).length());
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.f("ok", (Map)localObject2);
      aI(paramBitmap);
      aI(localBitmap);
      this.cJx = null;
      AppMethodBeat.o(210778);
      return;
    }
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(210777);
    if ((this.cJj) && (this.cIV != null))
    {
      Object localObject;
      if (PS())
      {
        localObject = this.Jyg;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      if (this.cIV != null)
      {
        localObject = this.cIV;
        if (localObject != null) {}
        for (boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).isPlaying();; bool = false)
        {
          this.cJe = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          Log.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cJe) });
          localObject = this.cIV;
          if (localObject == null) {
            break;
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).seekTo(paramLong);
          AppMethodBeat.o(210777);
          return;
        }
        AppMethodBeat.o(210777);
      }
    }
    else
    {
      this.cJh = paramLong;
    }
    AppMethodBeat.o(210777);
  }
  
  final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(210784);
    Object localObject;
    if (getAbTestVideoPreload())
    {
      String str = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(paramString);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.cIV;
      localObject = localc;
      if (!(localc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject).dV(paramString, str);
      }
    }
    for (;;)
    {
      localObject = this.Jyg;
      if (localObject == null) {
        break;
      }
      ((j)localObject).aX(com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().f(paramString, 0L, 9223372036854775807L));
      AppMethodBeat.o(210784);
      return;
      localObject = this.cIV;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).setDataSource(paramString);
      }
    }
    AppMethodBeat.o(210784);
  }
  
  final boolean zt(boolean paramBoolean)
  {
    AppMethodBeat.i(210774);
    if ((this.cJs) && (this.Jyf))
    {
      Log.e(getTAG(), "play, background not allow play");
      AppMethodBeat.o(210774);
      return true;
    }
    if (this.cIV != null)
    {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new aa(this));
      if (this.cJj)
      {
        localObject1 = this.cIV;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).isPlaying() == true))
        {
          Log.i(getTAG(), "video play, video is playing");
          if (PS())
          {
            localObject1 = this.Jyg;
            if (localObject1 != null) {
              ((j)localObject1).gif();
            }
          }
          AppMethodBeat.o(210774);
          return true;
        }
      }
      if (!this.cJj)
      {
        Log.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.cJg = true;
        AppMethodBeat.o(210774);
        return true;
      }
      Object localObject1 = this.cIV;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).getState() == 5))
      {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(210774);
          return false;
        }
        Log.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.cJg = true;
        AppMethodBeat.o(210774);
        return true;
      }
      Object localObject2;
      if (this.cJr)
      {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(210774);
          return false;
        }
        Log.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.cJr = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cJj))
          {
            Log.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              p.hyc();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label430;
            }
            localObject1 = new t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(210774);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          gij();
          if (this.cIV != null)
          {
            this.cJi = true;
            setDataSourceWithCustomKey(this.cJp);
            localObject2 = getTAG();
            localObject3 = this.cIV;
            if (localObject3 == null) {
              p.hyc();
            }
            Log.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject3).getState()) });
            prepareAsync();
            this.cJg = true;
          }
          AppMethodBeat.o(210774);
          return true;
          label430:
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
      Log.i(getTAG(), "video play");
      if (this.cIV != null)
      {
        if (PS())
        {
          localObject2 = this.Jyg;
          if (localObject2 != null) {
            ((j)localObject2).gif();
          }
        }
        localObject2 = this.cIV;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).start();
        }
      }
      AppMethodBeat.o(210774);
      return true;
    }
    AppMethodBeat.o(210774);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<String>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<x>
  {
    aa(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class ab
    implements a.a
  {
    public final void hU(int paramInt)
    {
      AppMethodBeat.i(210752);
      this.Jyj.gii();
      AppMethodBeat.o(210752);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(210753);
      this.Jyj.release();
      AppMethodBeat.o(210753);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(210751);
      l locall = this.Jyj;
      locall.cJs = false;
      Log.d(locall.getTAG(), "handleWebViewForeground");
      boolean bool = locall.Qo();
      locall.cET = null;
      if ((locall.cIV != null) && (locall.cJj) && (bool))
      {
        Log.i(locall.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
        locall.zt(false);
      }
      AppMethodBeat.o(210751);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<x>
  {
    ac(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<x>
  {
    ad(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class c
    implements d.a
  {
    public final void aTw() {}
    
    public final void aTx() {}
    
    public final void aTy() {}
    
    public final void aTz() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210727);
      this.Jyj.D(parama);
      AppMethodBeat.o(210727);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class e
    implements c.f
  {
    e(l paraml) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210728);
      l locall = this.Jyj;
      boolean bool = locall.k((Runnable)new l.v(locall, paramInt1, paramInt2));
      AppMethodBeat.o(210728);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class f
    implements c.e
  {
    f(l paraml) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210729);
      l locall = this.Jyj;
      boolean bool = locall.k((Runnable)new l.u(locall, paramInt1, paramInt2));
      AppMethodBeat.o(210729);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class g
    implements c.g
  {
    g(l paraml) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
    {
      AppMethodBeat.i(210730);
      paramc = this.Jyj;
      paramc.k((Runnable)new l.w(paramc));
      AppMethodBeat.o(210730);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class h
    implements c.b
  {
    h(l paraml) {}
    
    public final void QA()
    {
      AppMethodBeat.i(210731);
      l locall = this.Jyj;
      locall.k((Runnable)new l.t(locall));
      AppMethodBeat.o(210731);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class i
    implements c.h
  {
    i(l paraml) {}
    
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
    {
      AppMethodBeat.i(210732);
      paramc = this.Jyj;
      paramc.k((Runnable)new l.x(paramc));
      AppMethodBeat.o(210732);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class j
    implements c.i
  {
    j(l paraml) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210733);
      paramc = this.Jyj;
      paramc.k((Runnable)new l.y(paramc, paramInt1, paramInt2));
      AppMethodBeat.o(210733);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class k
    implements com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
  {
    k(l paraml) {}
    
    public final void id(int paramInt)
    {
      AppMethodBeat.i(210734);
      l locall = this.Jyj;
      locall.k((Runnable)new l.s(locall, paramInt));
      AppMethodBeat.o(210734);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "selectIndex", "", "kotlin.jvm.PlatformType", "onDownstreamChanged"})
  static final class l
    implements c.d
  {
    l(l paraml) {}
    
    public final void abu(String paramString)
    {
      AppMethodBeat.i(210735);
      j localj = this.Jyj.Jyg;
      if (localj != null) {}
      for (;;)
      {
        try
        {
          Object localObject = localj.TAG;
          StringBuilder localStringBuilder = new StringBuilder("[TRACE_ADAPTIVE] onVideoDownStreamChange selectIndex = ");
          if (paramString != null) {
            break label123;
          }
          str = "null";
          Log.i((String)localObject, str);
          localObject = localj.bKv();
          str = paramString;
          if (paramString == null) {
            str = "";
          }
          ((JSONObject)localObject).put("selectIndex", str);
          localj.dispatchEvent("onVideoDownStreamChange", (JSONObject)localObject);
          AppMethodBeat.o(210735);
          return;
        }
        catch (JSONException paramString)
        {
          Log.e(localj.TAG, "onVideoDownStreamChange fail", new Object[] { paramString });
          AppMethodBeat.o(210735);
          return;
        }
        AppMethodBeat.o(210735);
        return;
        label123:
        String str = paramString;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(l paraml, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      boolean bool2 = false;
      int i = 0;
      boolean bool1 = true;
      int k = 1;
      AppMethodBeat.i(210736);
      Object localObject1 = parama.Pt();
      if (Util.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(210736);
        return;
      }
      Object localObject2 = parama.Ps();
      Log.i(this.Jyj.getTAG(), "handler(%s) handleJsApi(%s), data:%s", new Object[] { this.Jyj.Lb(), localObject1, ((JSONObject)localObject2).toString() });
      if ((p.j("handleVideoAction", localObject1) ^ true))
      {
        Log.e(this.Jyj.getTAG(), "handler(%s), not right jsapi:(%s)", new Object[] { this.Jyj.Lb(), localObject1 });
        AppMethodBeat.o(210736);
        return;
      }
      localObject1 = ((JSONObject)localObject2).optString("action", "");
      if (localObject1 == null)
      {
        AppMethodBeat.o(210736);
        return;
      }
      Object localObject3;
      j localj;
      switch (((String)localObject1).hashCode())
      {
      default: 
      case -952717996: 
      case 1975278676: 
      case -1100634679: 
        do
        {
          for (;;)
          {
            AppMethodBeat.o(210736);
            return;
            if (((String)localObject1).equals("operateSameLayerVideo"))
            {
              localObject1 = this.Jyj;
              localObject2 = parama;
              if (((l)localObject1).cIV != null) {
                break;
              }
              Log.w(((l)localObject1).getTAG(), "operate, media player is null");
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dP("fail");
              AppMethodBeat.o(210736);
              return;
              if (((String)localObject1).equals("removeSameLayerVideo"))
              {
                localObject1 = this.Jyj;
                localObject2 = parama;
                ((l)localObject1).release();
                if ((((l)localObject1).cED != null) && (((l)localObject1).cEE != null))
                {
                  localObject3 = ((l)localObject1).cED;
                  if (localObject3 == null) {
                    p.hyc();
                  }
                  ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).b(((l)localObject1).cEE);
                  ((l)localObject1).cEE = null;
                }
                ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dP("ok");
              }
            }
          }
        } while (!((String)localObject1).equals("insertSameLayerVideo"));
        localObject2 = this.Jyj;
        localObject3 = parama;
        ((l)localObject2).cED = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        ((l)localObject2).B((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        if (((l)localObject2).cIV == null)
        {
          Log.w(((l)localObject2).getTAG(), "insert, media player is null");
          ((l)localObject2).gih();
        }
        if (((l)localObject2).cEE == null)
        {
          ((l)localObject2).cEE = ((a.a)new l.ab((l)localObject2));
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).a(((l)localObject2).cEE);
        }
        if (((l)localObject2).mSurface != null)
        {
          Log.i(((l)localObject2).getTAG(), "insert, setSurface");
          localObject1 = ((l)localObject2).cIV;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        localObject1 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).Ps();
        ((l)localObject2).cJi = ((JSONObject)localObject1).optBoolean("autoplay", false);
        ((l)localObject2).cJh = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
        ((l)localObject2).cJl = ((JSONObject)localObject1).optBoolean("loop", false);
        ((l)localObject2).cJm = ((JSONObject)localObject1).optBoolean("muted", false);
        if (com.tencent.mm.q.a.aty()) {
          ((l)localObject2).cJm = true;
        }
        localObject4 = ((l)localObject2).cIV;
        if (localObject4 != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject4).setMute(((l)localObject2).cJm);
        }
        ((l)localObject2).Jyf = ((JSONObject)localObject1).optBoolean("autoPauseOnBackground", true);
        ((l)localObject2).cEJ = ((JSONObject)localObject1).optBoolean("needEvent", true);
        if ((((l)localObject2).cEJ) && (((l)localObject2).Jyg != null))
        {
          localObject4 = ((l)localObject2).Jyg;
          if (localObject4 != null) {
            ((j)localObject4).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject4 = ((JSONObject)localObject1).optString("data", "");
          localj = ((l)localObject2).Jyg;
          if (localj != null) {
            localj.dV((String)localObject4);
          }
        }
        if (((JSONObject)localObject1).has("position"))
        {
          localObject4 = ((JSONObject)localObject1).optJSONObject("position");
          if (localObject4 != null)
          {
            ((l)localObject2).cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject4).optInt("width", 0));
            ((l)localObject2).cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject4).optInt("height", 0));
            Log.i(((l)localObject2).getTAG(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).cEF), Integer.valueOf(((l)localObject2).cEG) });
          }
        }
        ((l)localObject2).cJq = ((JSONObject)localObject1).optString("objectFit", "contain");
        if (Util.isNullOrNil(((l)localObject2).cJq)) {
          ((l)localObject2).cJq = "contain";
        }
        ((l)localObject2).crw();
        ((l)localObject2).cJp = ((JSONObject)localObject1).optString("filePath");
        if (!Util.isNullOrNil(((l)localObject2).cJp))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJG()) {
            break label1043;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJF()) {
            break label1043;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(((l)localObject2).cJp);
          label904:
          Log.i(((l)localObject2).getTAG(), "insert, path:%s, proxy=%s", new Object[] { ((l)localObject2).cJp, localObject1 });
          if (Util.isNullOrNil((String)localObject1)) {
            break label1049;
          }
          ((l)localObject2).setDataSourceWithCustomKey((String)localObject1);
          ((l)localObject2).Jyi.bbl((String)localObject1);
        }
        break;
      }
      for (;;)
      {
        ((l)localObject2).prepareAsync();
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dP("ok");
        ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        AppMethodBeat.o(210736);
        return;
        if (!((String)localObject1).equals("updateSameLayerVideo")) {
          break;
        }
        localObject2 = this.Jyj;
        localObject3 = parama;
        if (((l)localObject2).cIV != null) {
          break label1075;
        }
        Log.w(((l)localObject2).getTAG(), "update, media player is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dP("fail");
        AppMethodBeat.o(210736);
        return;
        label1043:
        localObject1 = null;
        break label904;
        label1049:
        ((l)localObject2).setDataSourceWithCustomKey(((l)localObject2).cJp);
        ((l)localObject2).Jyi.bbl(((l)localObject2).cJp);
      }
      label1075:
      ((l)localObject2).B((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
      Object localObject4 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).Ps();
      if (((JSONObject)localObject4).optBoolean("switchResolution", false))
      {
        ((l)localObject2).cJh = ((l)localObject2).getCurrentPosition();
        if (!((JSONObject)localObject4).has("filePath")) {
          break label2394;
        }
        localObject1 = ((JSONObject)localObject4).optString("filePath");
        if ((Util.isNullOrNil((String)localObject1)) || (n.I((String)localObject1, ((l)localObject2).cJp, true))) {
          break label2394;
        }
        ((l)localObject2).cJp = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJG()) {
          break label1831;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJF()) {
          break label1831;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(((l)localObject2).cJp);
        label1219:
        Log.i(((l)localObject2).getTAG(), "update, path:%s, proxy:%s", new Object[] { ((l)localObject2).cJp, localObject1 });
        if (!Util.isNullOrNil(((l)localObject2).cJp))
        {
          ((l)localObject2).Qt();
          ((l)localObject2).gij();
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label1837;
        }
        ((l)localObject2).setDataSourceWithCustomKey((String)localObject1);
        ((l)localObject2).Jyi.bbl((String)localObject1);
      }
      label1294:
      label1356:
      label2384:
      label2394:
      for (int j = 1;; j = 0)
      {
        if ((((l)localObject2).mSurface != null) && (((l)localObject2).cIV != null))
        {
          if (((l)localObject2).cJs) {
            break label1863;
          }
          Log.i(((l)localObject2).getTAG(), "update, setSurface");
          localObject1 = ((l)localObject2).cIV;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        if (((JSONObject)localObject4).has("autoplay")) {
          ((l)localObject2).cJi = ((JSONObject)localObject4).optBoolean("autoplay", ((l)localObject2).cJi);
        }
        if (((JSONObject)localObject4).has("loop")) {
          ((l)localObject2).cJl = ((JSONObject)localObject4).optBoolean("loop", ((l)localObject2).cJl);
        }
        if (((JSONObject)localObject4).has("muted"))
        {
          ((l)localObject2).cJm = ((JSONObject)localObject4).optBoolean("muted", ((l)localObject2).cJm);
          if (com.tencent.mm.q.a.aty()) {
            ((l)localObject2).cJm = true;
          }
          localObject1 = ((l)localObject2).cIV;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).setMute(((l)localObject2).cJm);
          }
        }
        ((l)localObject2).Jyf = ((JSONObject)localObject4).optBoolean("autoPauseOnBackground", true);
        if (((JSONObject)localObject4).has("needEvent")) {
          ((l)localObject2).cEJ = ((JSONObject)localObject4).optBoolean("needEvent", ((l)localObject2).cEJ);
        }
        if ((((l)localObject2).cEJ) && (((l)localObject2).Jyg != null))
        {
          localObject1 = ((l)localObject2).Jyg;
          if (localObject1 != null) {
            ((j)localObject1).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject1 = ((JSONObject)localObject4).optString("data", "");
          if (((JSONObject)localObject4).has("data"))
          {
            localj = ((l)localObject2).Jyg;
            if (localj != null) {
              localj.dV((String)localObject1);
            }
          }
        }
        if (((JSONObject)localObject4).has("position"))
        {
          localObject1 = ((JSONObject)localObject4).optJSONObject("position");
          if (localObject1 != null)
          {
            ((l)localObject2).cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject1).optInt("width", ((l)localObject2).cEF));
            ((l)localObject2).cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject1).optInt("height", ((l)localObject2).cEG));
            Log.i(((l)localObject2).getTAG(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).cEF), Integer.valueOf(((l)localObject2).cEG) });
          }
          i = 1;
        }
        if (((JSONObject)localObject4).has("objectFit"))
        {
          ((l)localObject2).cJq = ((JSONObject)localObject4).optString("objectFit", ((l)localObject2).cJq);
          i = k;
          if (Util.isNullOrNil(((l)localObject2).cJq))
          {
            ((l)localObject2).cJq = "contain";
            i = k;
          }
        }
        for (;;)
        {
          if (i != 0) {
            ((l)localObject2).crw();
          }
          if (j != 0)
          {
            Log.i(((l)localObject2).getTAG(), "update, media player prepare async");
            ((l)localObject2).prepareAsync();
          }
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dP("ok");
          ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          AppMethodBeat.o(210736);
          return;
          if (!((JSONObject)localObject4).has("initialTime")) {
            break;
          }
          ((l)localObject2).cJh = ((((JSONObject)localObject4).optDouble("initialTime", 0.0D) * 1000.0D));
          break;
          localObject1 = null;
          break label1219;
          ((l)localObject2).setDataSourceWithCustomKey(((l)localObject2).cJp);
          ((l)localObject2).Jyi.bbl(((l)localObject2).cJp);
          break label1294;
          Log.i(((l)localObject2).getTAG(), "update, setSurface, WebViewInBackground");
          break label1356;
          localObject3 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).Ps();
          localObject4 = ((JSONObject)localObject3).optString("type");
          if (!Util.isNullOrNil((String)localObject4))
          {
            Log.i(((l)localObject1).getTAG(), "operate, type:%s", new Object[] { localObject4 });
            if (!n.I((String)localObject4, "play", true)) {
              break label1969;
            }
            bool1 = ((l)localObject1).zt(true);
            if (!bool1) {
              break label2384;
            }
          }
          for (localObject1 = "ok";; localObject1 = "fail")
          {
            ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dP((String)localObject1);
            AppMethodBeat.o(210736);
            return;
            if (n.I((String)localObject4, "pause", true))
            {
              bool1 = ((l)localObject1).pause();
              break;
            }
            if (n.I((String)localObject4, "stop", true))
            {
              bool1 = ((l)localObject1).Qt();
              break;
            }
            double d;
            if (n.I((String)localObject4, "seek", true))
            {
              if ((((l)localObject1).cIV != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
              {
                localObject3 = ((JSONObject)localObject3).optJSONArray("data");
                if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0)) {
                  Log.w(((l)localObject1).getTAG(), "seek, data array is null");
                }
              }
              else
              {
                bool1 = false;
              }
              for (;;)
              {
                break;
                d = ((JSONArray)localObject3).optDouble(0, -1.0D);
                if (d < 0.0D)
                {
                  Log.w(((l)localObject1).getTAG(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                  break label2081;
                }
                ((l)localObject1).seek((d * 1000.0D));
              }
            }
            if (n.I((String)localObject4, "playbackRate", true))
            {
              bool1 = bool2;
              if (((l)localObject1).cIV == null) {
                break;
              }
              bool1 = bool2;
              if (localObject3 == null) {
                break;
              }
              bool1 = bool2;
              if (!((JSONObject)localObject3).has("data")) {
                break;
              }
              localObject3 = ((JSONObject)localObject3).optJSONArray("data");
              if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0))
              {
                Log.w(((l)localObject1).getTAG(), "speed, data array is null");
                bool1 = bool2;
                break;
              }
              d = ((JSONArray)localObject3).optDouble(0, -1.0D);
              if (d < 0.0D)
              {
                Log.w(((l)localObject1).getTAG(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                bool1 = bool2;
                break;
              }
              Log.i(((l)localObject1).getTAG(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
              localObject1 = ((l)localObject1).cIV;
              bool1 = bool2;
              if (localObject1 == null) {
                break;
              }
              bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).aP((float)d);
              break;
            }
            bool1 = bool2;
            if (!n.I((String)localObject4, "snapshot", true)) {
              break;
            }
            ((l)localObject1).cJx = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
            Log.i(((l)localObject1).getTAG(), "takeVideoSnapshot");
            com.tencent.luggage.xweb_ext.extendplugin.d.a(((l)localObject1).QJ(), ((l)localObject1).getType(), ((l)localObject1).getId());
            AppMethodBeat.o(210736);
            return;
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(210738);
      if (this.Jyj.Jyf)
      {
        if ((this.Jyj.cIV != null) && (this.Jyj.cJj) && (this.Jyj.cET == null))
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.e.c localc = this.Jyj.cIV;
          if ((localc != null) && (localc.isPlaying() == true)) {}
          for (boolean bool = true;; bool = false)
          {
            this.Jyj.cET = new AtomicBoolean(bool);
            Log.i(this.Jyj.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
            this.Jyj.pause();
            AppMethodBeat.o(210738);
            return;
          }
        }
      }
      else
      {
        if (this.Jyj.Qo())
        {
          Log.i(this.Jyj.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { this.Jyj.type });
          this.Jyj.zt(true);
          AppMethodBeat.o(210738);
          return;
        }
        Log.i(this.Jyj.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { this.Jyj.type });
      }
      AppMethodBeat.o(210738);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(210739);
      l.a(this.Jyj);
      Log.i(this.Jyj.getTAG(), "handler(%s) handlePluginDestroy", new Object[] { this.Jyj.Lb() });
      this.Jyj.Qt();
      this.Jyj.Qx();
      AppMethodBeat.o(210739);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(l paraml, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(210740);
      Log.i(this.Jyj.getTAG(), "handler(%s) handlePluginReady", new Object[] { this.Jyj.Lb() });
      Object localObject = this.Jyj;
      ((l)localObject).cJd = false;
      ((l)localObject).cJe = false;
      ((l)localObject).cJf = false;
      ((l)localObject).cJg = false;
      this.Jyj.mSurfaceTexture = paramSurfaceTexture;
      this.Jyj.mSurface = new Surface(paramSurfaceTexture);
      if (this.Jyj.cIV != null)
      {
        Log.i(this.Jyj.getTAG(), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        try
        {
          localObject = this.Jyj.cIV;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject).setSurface(this.Jyj.mSurface);
            AppMethodBeat.o(210740);
            return;
          }
          AppMethodBeat.o(210740);
          return;
        }
        catch (Exception localException)
        {
          Log.e(this.Jyj.getTAG(), "handlePluginReady, setSurface:ex " + localException.getMessage());
        }
      }
      AppMethodBeat.o(210740);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class r
    implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a
  {
    r(l paraml) {}
    
    public final void h(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210741);
      Log.w(this.Jyj.getTAG(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (this.Jyj.PS())
      {
        localObject1 = this.Jyj.Jyg;
        if (localObject1 != null)
        {
          ((j)localObject1).bKw();
          ((j)localObject1).bMk();
        }
      }
      try
      {
        JSONObject localJSONObject = ((j)localObject1).bKv();
        Object localObject2 = ae.SYK;
        localObject2 = Locale.US;
        p.g(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        p.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((j)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = this.Jyj.Jyi;
        p.g(paramString, "msg");
        p.h(paramString, "msg");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 40L, 1L, false);
        Log.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!Util.isNullOrNil(paramString))
        {
          if (n.I(paramString, "MEDIA_ERR_NETWORK", true)) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((m)localObject1).Jym.mNz = paramInt1;
          ((m)localObject1).Jym.mNA = paramInt2;
          localObject1 = ((m)localObject1).Jym;
          p.h(paramString, "<set-?>");
          ((m.b)localObject1).errorMsg = paramString;
          this.Jyj.Qt();
          AppMethodBeat.o(210741);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((j)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.I(paramString, "MEDIA_ERR_DECODE", true)) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.I(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 43L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(210742);
      Object localObject = this.Jyj;
      int i = this.Jyl;
      if (!((l)localObject).cJk)
      {
        Log.i(((l)localObject).getTAG(), "onMediaPlayerBufferingUpdate, mp released");
        AppMethodBeat.o(210742);
        return;
      }
      if (i != ((l)localObject).cJo)
      {
        ((l)localObject).cJo = i;
        Log.i(((l)localObject).getTAG(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(i) });
      }
      if ((((l)localObject).PS()) && (((l)localObject).cJj))
      {
        localObject = ((l)localObject).Jyg;
        if (localObject != null) {
          try
          {
            JSONObject localJSONObject = ((j)localObject).bKv();
            localJSONObject.put("buffered", i);
            ((j)localObject).dispatchEvent("onVideoBufferUpdate", localJSONObject);
            AppMethodBeat.o(210742);
            return;
          }
          catch (JSONException localJSONException)
          {
            Log.e(((j)localObject).TAG, "OnXWebVideoProgress fail", new Object[] { localJSONException });
            AppMethodBeat.o(210742);
            return;
          }
        }
      }
      AppMethodBeat.o(210742);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(210743);
      l locall = this.Jyj;
      if (!locall.cJk)
      {
        Log.i(locall.getTAG(), "onMediaPlayerCompletion, mp released");
        AppMethodBeat.o(210743);
        return;
      }
      Log.i(locall.getTAG(), "onCompletion");
      Object localObject;
      if (locall.PS())
      {
        localObject = locall.Jyg;
        if (localObject == null) {}
      }
      try
      {
        ((j)localObject).dispatchEvent("onVideoEnded", ((j)localObject).bKv());
        ((j)localObject).bKw();
        ((j)localObject).bMk();
        localObject = locall.cIV;
        if (localObject != null)
        {
          m localm = locall.Jyi;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = locall.cED;
          p.h(localObject, "mediaPlayer");
          if ((!Util.isNullOrNil(localm.Jym.videoPath)) && (localm.Jym.mNq > 0L))
          {
            localm.Jym.mNy = Util.nowMilliSecond();
            localm.a(locala, (com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject, "onMediaPlayerVideoEnd");
          }
        }
        if (locall.cJl)
        {
          Log.i(locall.getTAG(), "onCompletion, video loop playing");
          locall.cJd = true;
          locall.seek(0L);
          AppMethodBeat.o(210743);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((j)localObject).TAG, "OnXWebVideoEnded fail", new Object[] { localJSONException });
        }
        Log.i(locall.getTAG(), "onCompletion, video end playing");
        locall.cJr = true;
        AppMethodBeat.o(210743);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(210744);
      Object localObject = this.Jyj;
      int i = this.pNG;
      int j = this.pNH;
      if (!((l)localObject).cJk)
      {
        Log.i(((l)localObject).getTAG(), "onMediaPlayerError, mp released");
        AppMethodBeat.o(210744);
        return;
      }
      Log.i(((l)localObject).getTAG(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((l)localObject).cIY;
      if (localObject != null)
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cd(i, j);
        AppMethodBeat.o(210744);
        return;
      }
      AppMethodBeat.o(210744);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(210745);
      this.Jyj.ks(this.pNG, this.pNH);
      AppMethodBeat.o(210745);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(210746);
      l locall = this.Jyj;
      if (!locall.cJk)
      {
        Log.i(locall.getTAG(), "onMediaPlayerPrepared, mp released");
        AppMethodBeat.o(210746);
        return;
      }
      Log.i(locall.getTAG(), "onPrepared");
      locall.cJj = true;
      locall.crw();
      Object localObject1 = locall.Jyi;
      int i = locall.getDuration();
      long l;
      if (((m)localObject1).Jym.mNr <= 0L)
      {
        ((m)localObject1).Jym.mNr = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 21L, 1L, false);
        l = ((m)localObject1).Jym.mNr - ((m)localObject1).Jym.mNq;
        ((m)localObject1).Jym.mNs = l;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 22L, l, false);
        Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
      }
      if ((((m)localObject1).Jym.duration <= 0L) && (i > 0))
      {
        l = (1.0D * i / 1000.0D);
        ((m)localObject1).Jym.duration = l;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 26L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 24L, l, false);
        Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(l) });
      }
      Object localObject2;
      if (locall.PS())
      {
        localObject1 = locall.Jyg;
        if (localObject1 != null) {
          ((j)localObject1).bbk("WaitingPlay");
        }
        localObject1 = locall.Jyg;
        if (localObject1 != null)
        {
          localObject2 = locall.cIV;
          if (localObject2 == null) {
            break label571;
          }
          i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).getVideoWidth();
        }
      }
      for (;;)
      {
        localObject2 = locall.cIV;
        int j;
        int k;
        if (localObject2 != null)
        {
          j = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).getVideoHeight();
          k = locall.getDuration();
          Log.i(((j)localObject1).TAG, "onVideoLoadedMetaData width=" + i + ", height=" + j + ", duration=" + k);
        }
        try
        {
          localObject2 = ((j)localObject1).bKv();
          ((JSONObject)localObject2).put("width", i);
          ((JSONObject)localObject2).put("height", j);
          ((j)localObject1).mLe = (k * 1.0D / 1000.0D);
          ((JSONObject)localObject2).put("duration", ((j)localObject1).mLe);
          ((j)localObject1).dispatchEvent("onVideoLoadedMetaData", (JSONObject)localObject2);
          l = locall.cJh;
          if (l > 0L)
          {
            locall.seek(l);
            locall.cJh = 0L;
          }
          Log.d(locall.getTAG(), "onPrepared, webViewInBackgroun = " + locall.cJs);
          if (!locall.cJs) {
            if ((locall.cJi) || (locall.cJg))
            {
              Log.i(locall.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(locall.cJi), Boolean.valueOf(locall.cJg) });
              locall.zt(true);
              AppMethodBeat.o(210746);
              return;
              label571:
              i = 0;
              continue;
              j = 0;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e(((j)localObject1).TAG, "onVideoLoadedMetaData fail", new Object[] { localJSONException });
          }
          Log.i(locall.getTAG(), "onPrepared, not set start play when prepared");
          AppMethodBeat.o(210746);
          return;
        }
      }
      Log.i(locall.getTAG(), "onPrepared, stop video auto play when webview in background");
      if ((locall.cJi) || (locall.cJg)) {}
      for (boolean bool = true;; bool = false)
      {
        locall.cET = new AtomicBoolean(bool);
        AppMethodBeat.o(210746);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(210747);
      Object localObject1 = this.Jyj;
      if (!((l)localObject1).cJk)
      {
        Log.i(((l)localObject1).getTAG(), "onMediaPlayerSeekComplete, mp released");
        AppMethodBeat.o(210747);
        return;
      }
      Object localObject2 = ((l)localObject1).Jyg;
      if (localObject2 != null) {}
      try
      {
        ((j)localObject2).dispatchEvent("onVideoSeekEnd", ((j)localObject2).bKv());
        Log.i(((l)localObject1).getTAG(), "onSeekComplete");
        if (((l)localObject1).cJd) {
          if ((((l)localObject1).cJs) && (((l)localObject1).Jyf))
          {
            Log.e(((l)localObject1).getTAG(), "onSeekComplete, background not allow play");
            AppMethodBeat.o(210747);
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((j)localObject2).TAG, "onVideoSeedEnd fail", new Object[] { localJSONException });
        }
        Log.i(((l)localObject1).getTAG(), "onSeekComplete, start when seek complete");
        ((l)localObject1).cJd = false;
        ((l)localObject1).zt(true);
        AppMethodBeat.o(210747);
        return;
      }
      localObject2 = ((l)localObject1).cIV;
      if (localObject2 == null) {
        p.hyc();
      }
      boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).isPlaying();
      if ((((l)localObject1).cJe) && ((!((l)localObject1).cJs) || (!((l)localObject1).Jyf)))
      {
        localObject2 = ((l)localObject1).cIV;
        if (localObject2 == null) {
          p.hyc();
        }
        long l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).getDuration();
        localObject2 = ((l)localObject1).cIV;
        if (localObject2 == null) {
          p.hyc();
        }
        long l2 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).getCurrentPosition();
        Log.i(((l)localObject1).getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
        ((l)localObject1).cJe = false;
        if (l2 / 1000L < l1 / 1000L)
        {
          Log.i(((l)localObject1).getTAG(), "onSeekComplete, video not end");
          if ((bool) && (((l)localObject1).PS()))
          {
            Log.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch play again");
            localObject1 = ((l)localObject1).Jyg;
            if (localObject1 != null)
            {
              ((j)localObject1).gif();
              AppMethodBeat.o(210747);
              return;
            }
            AppMethodBeat.o(210747);
          }
        }
        else
        {
          Log.i(((l)localObject1).getTAG(), "onSeekComplete, video ends");
          localObject2 = ((l)localObject1).cIV;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject2).pause();
          }
          if (((l)localObject1).PS())
          {
            localObject2 = ((l)localObject1).Jyg;
            if (localObject2 != null) {
              ((j)localObject2).gif();
            }
          }
          localObject1 = ((l)localObject1).cIV;
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c)localObject1).start();
            AppMethodBeat.o(210747);
            return;
          }
          AppMethodBeat.o(210747);
        }
      }
      else
      {
        Log.i(((l)localObject1).getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
        if ((!bool) && (((l)localObject1).PS()))
        {
          Log.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch pause again");
          localObject2 = ((l)localObject1).Jyg;
          if (localObject2 != null) {
            ((j)localObject2).gig();
          }
        }
        if ((bool) && (((l)localObject1).cJs) && (((l)localObject1).Jyf))
        {
          ((l)localObject1).cET = new AtomicBoolean(true);
          ((l)localObject1).pause();
        }
      }
      AppMethodBeat.o(210747);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(210748);
      l locall = this.Jyj;
      int i = this.cKE;
      int j = this.cKF;
      if (!locall.cJk)
      {
        Log.i(locall.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
        AppMethodBeat.o(210748);
        return;
      }
      int k = locall.getDuration();
      Log.i(locall.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(locall.cJj) });
      j localj;
      if ((locall.cJj) && (locall.cIV != null) && ((i != locall.mVideoWidth) || (j != locall.mVideoHeight) || (k != locall.cJn)) && (locall.PS()))
      {
        localj = locall.Jyg;
        if (localj != null) {
          Log.i(localj.TAG, "onVideoSizeChange width=" + i + ", height=" + j + ", duration=" + k);
        }
      }
      try
      {
        JSONObject localJSONObject = localj.bKv();
        localJSONObject.put("width", i);
        localJSONObject.put("height", j);
        localj.mLe = (k * 1.0D / 1000.0D);
        localJSONObject.put("duration", localj.mLe);
        localj.dispatchEvent("onVideoSizeChange", localJSONObject);
        locall.mVideoWidth = i;
        locall.mVideoHeight = j;
        locall.cJn = k;
        locall.crw();
        AppMethodBeat.o(210748);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(localj.TAG, "onVideoSizeChange fail", new Object[] { localJSONException });
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<x>
  {
    z(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l
 * JD-Core Version:    0.7.0.1
 */