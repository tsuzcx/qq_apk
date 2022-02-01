package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.n.n;
import d.v;
import d.z;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  final d.a BvX;
  boolean Eqa;
  j Eqb;
  private com.tencent.mm.plugin.appbrand.jsapi.ac.e.g Eqc;
  final m Eqd;
  private int bDT;
  private float bDX;
  com.tencent.luggage.xweb_ext.extendplugin.a crL;
  a.a crM;
  int crN;
  int crO;
  boolean crR;
  AtomicBoolean csa;
  boolean cuC;
  boolean cuD;
  boolean cuE;
  boolean cuF;
  long cuG;
  boolean cuH;
  boolean cuI;
  volatile boolean cuJ;
  boolean cuK;
  boolean cuL;
  int cuM;
  int cuN;
  String cuO;
  String cuP;
  boolean cuQ;
  volatile boolean cuR;
  private Handler cuU;
  private HandlerThread cuV;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cuW;
  b cuu;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cux;
  private float cvc;
  private float cvd;
  final com.tencent.mm.model.d haI;
  private int lra;
  private int lrb;
  private int lrc;
  private int lrd;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  int mVideoHeight;
  int mVideoWidth;
  private final d.f omn;
  private boolean otj;
  
  public l()
  {
    AppMethodBeat.i(207784);
    this.omn = d.g.O((d.g.a.a)new a(this));
    this.cuV = com.tencent.e.c.d.gX("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.cvc = 1.0F;
    this.cvd = 1.0F;
    this.Eqc = new com.tencent.mm.plugin.appbrand.jsapi.ac.e.g();
    this.Eqd = new m();
    Object localObject = com.tencent.mm.model.d.azW();
    p.g(localObject, "AudioHelperTool.createTool()");
    this.haI = ((com.tencent.mm.model.d)localObject);
    this.cuV.start();
    localObject = this.cuV;
    p.g(localObject, "mVideoHandlerThread");
    this.cuU = new Handler(((HandlerThread)localObject).getLooper());
    this.bDT = 800000;
    this.bDX = 0.75F;
    this.lra = 10000;
    this.lrb = 25000;
    this.lrc = 15000;
    this.lrd = 30000;
    this.BvX = ((d.a)new b());
    AppMethodBeat.o(207784);
  }
  
  private final void Gw()
  {
    try
    {
      AppMethodBeat.i(207770);
      if (this.cuu != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "releaseMediaPlayer");
        b localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.a(null);
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.stop();
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.reset();
        localb = this.cuu;
        if (localb == null) {
          p.gfZ();
        }
        localb.release();
      }
      this.cuu = null;
      this.cuJ = false;
      AppMethodBeat.o(207770);
      return;
    }
    finally {}
  }
  
  private final void au(Bitmap paramBitmap)
  {
    AppMethodBeat.i(207780);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "bitmap recycle ".concat(String.valueOf(paramBitmap)));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(207780);
  }
  
  final void C(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(207781);
    parama = parama.FD();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(207781);
      return;
    }
    this.bDT = parama.optInt("maxInitialBitrate", 0);
    this.bDX = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.lra = parama.optInt("minDurForQualityMs", 0);
    this.lrb = parama.optInt("maxDurForQualityMs", 0);
    this.lrc = parama.optInt("minBufferMs", 0);
    this.lrd = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.bDT != 0)
    {
      bool1 = bool2;
      if (this.bDX != 0.0F)
      {
        bool1 = bool2;
        if (this.lra != 0)
        {
          bool1 = bool2;
          if (this.lrb != 0)
          {
            bool1 = bool2;
            if (this.lrc != 0)
            {
              bool1 = bool2;
              if (this.lrd != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.otj = bool1;
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.otj);
    AppMethodBeat.o(207781);
  }
  
  final void D(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(207782);
    E(parama);
    h.LTJ.q((Runnable)new c(this, parama), 2000L);
    AppMethodBeat.o(207782);
  }
  
  final void E(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(207783);
    if ((!this.cuR) && ((parama.getContext() instanceof MMActivity)))
    {
      parama = parama.getContext();
      if (parama == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(207783);
        throw parama;
      }
      parama = (MMActivity)parama;
      if (parama.isPaused())
      {
        com.tencent.mm.sdk.platformtools.ad.w(getTAG(), "checkPause, onBackGround");
        eVp();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 0L, 1L, false);
      }
      if ((parama.isDestroyed()) || (parama.isFinishing()))
      {
        com.tencent.mm.sdk.platformtools.ad.w(getTAG(), "checkPause, destroyed");
        release();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 1L, 1L, false);
      }
    }
    AppMethodBeat.o(207783);
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(207761);
    k((Runnable)new o(this));
    AppMethodBeat.o(207761);
  }
  
  /* Error */
  final boolean Gd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 594	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:crR	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 596	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:Eqb	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/j;
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
  
  final boolean Gq()
  {
    AppMethodBeat.i(207758);
    AtomicBoolean localAtomicBoolean = this.csa;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(207758);
      return bool;
    }
    AppMethodBeat.o(207758);
    return false;
  }
  
  final boolean Gv()
  {
    AppMethodBeat.i(207777);
    com.tencent.mm.ad.c.g((d.g.a.a)new ac(this));
    Object localObject = this.cuu;
    if (localObject != null)
    {
      this.Eqd.a(this.crL, (b)localObject);
      if (!this.cuI)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.cuF = false;
        AppMethodBeat.o(207777);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video stop");
      ((b)localObject).stop();
      if (Gd())
      {
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).eVn();
        }
      }
      AppMethodBeat.o(207777);
      return true;
    }
    AppMethodBeat.o(207777);
    return false;
  }
  
  final void Gy()
  {
    AppMethodBeat.i(207771);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.gfZ();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(207771);
  }
  
  final void bSw()
  {
    AppMethodBeat.i(207765);
    if (!bt.isNullOrNil(this.cuP))
    {
      if ((this.cuI) && (GK() != null) && (this.Eqc != null))
      {
        if (this.Eqc.a(this.cuP, this.crN, this.crO, this.mVideoWidth, this.mVideoHeight))
        {
          this.cvc = this.Eqc.GI();
          this.cvd = this.Eqc.GJ();
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cuP, Float.valueOf(this.cvc), Float.valueOf(this.cvd) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GK(), getType(), getId(), this.cvc, this.cvd);
          AppMethodBeat.o(207765);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(207765);
      }
    }
    else {
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(207765);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(207760);
    p.h(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new p(this, paramSurfaceTexture));
    AppMethodBeat.o(207760);
  }
  
  final void eVo()
  {
    AppMethodBeat.i(207763);
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "createMediaPlayer");
    Object localObject = this.cuU;
    long l = System.currentTimeMillis();
    if (this.otj)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c((Handler)localObject, this.bDT, this.bDX, this.lra, this.lrb, this.lrc, this.lrd);
      l = System.currentTimeMillis() - l;
      com.tencent.mm.sdk.platformtools.ad.d(getTAG(), "createMediaPlayer cost %s", new Object[] { Long.valueOf(l) });
      m localm = this.Eqd;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 11L, l, false);
      localm.Eqg.lBg = l;
      this.cuu = ((b)localObject);
      if (this.cuu == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.cuJ = bool;
      if (this.cuJ) {
        break label204;
      }
      com.tencent.mm.sdk.platformtools.ad.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(207763);
      return;
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c((Handler)localObject);
      break;
    }
    label204:
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.e)new d(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.d)new e(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.f)new f(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.b)new g(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.g)new h(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.h)new i(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.a)new j(this));
    localObject = this.cuu;
    if (localObject == null) {
      p.gfZ();
    }
    ((b)localObject).a((b.c)new k(this));
    localObject = this.Eqb;
    if (localObject != null)
    {
      ((j)localObject).aJy("StartPlayer");
      AppMethodBeat.o(207763);
      return;
    }
    AppMethodBeat.o(207763);
  }
  
  final void eVp()
  {
    AppMethodBeat.i(207767);
    this.cuR = true;
    com.tencent.mm.sdk.platformtools.ad.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ad.c.g((d.g.a.a)new m(this));
    k((Runnable)new n(this));
    AppMethodBeat.o(207767);
  }
  
  final void eVq()
  {
    AppMethodBeat.i(207769);
    this.cuQ = false;
    Gw();
    eVo();
    if (this.cuu != null)
    {
      b localb = this.cuu;
      if (localb == null) {
        p.gfZ();
      }
      localb.setMute(this.cuL);
      if (this.mSurface != null)
      {
        if (!this.cuR)
        {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localb = this.cuu;
          if (localb == null) {
            p.gfZ();
          }
          localb.setSurface(this.mSurface);
          AppMethodBeat.o(207769);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(207769);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(207759);
    p.h(parama, "invokeContext");
    AppMethodBeat.o(207759);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(207773);
    b localb = this.cuu;
    if (localb != null)
    {
      int i = localb.getCurrentPosition();
      AppMethodBeat.o(207773);
      return i;
    }
    AppMethodBeat.o(207773);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(207774);
    b localb = this.cuu;
    if (localb != null)
    {
      int i = localb.getDuration();
      AppMethodBeat.o(207774);
      return i;
    }
    AppMethodBeat.o(207774);
    return 0;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(207757);
    String str = (String)this.omn.getValue();
    AppMethodBeat.o(207757);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(207762);
    p.h(parama, "invokeContext");
    k((Runnable)new l(this, parama));
    AppMethodBeat.o(207762);
    return null;
  }
  
  final boolean jg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207764);
    if (!this.cuJ)
    {
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(207764);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    m.b localb;
    if (paramInt1 == 701)
    {
      localObject = this.cuu;
      if (localObject == null) {
        p.gfZ();
      }
      this.cuE = ((b)localObject).isPlaying();
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cuE) });
      if (Gd())
      {
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      localObject = this.Eqd;
      if (((m)localObject).Eqg.lBn <= 0L)
      {
        localb = ((m)localObject).Eqg;
        localb.lBl += 1;
        ((m)localObject).Eqg.lBn = bt.flT();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 30L, 1L, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(207764);
      return false;
      if (paramInt1 == 702)
      {
        localObject = this.cuu;
        if (localObject == null) {
          p.gfZ();
        }
        boolean bool = ((b)localObject).isPlaying();
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cuE), Boolean.valueOf(bool) });
        if (this.cuE)
        {
          this.cuE = false;
          if ((bool) && (Gd()))
          {
            com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject = this.Eqb;
            if (localObject != null) {
              ((j)localObject).eVl();
            }
          }
        }
        for (;;)
        {
          localObject = this.Eqd;
          if ((((m)localObject).Eqg.lBo <= 0L) && (((m)localObject).Eqg.lBn > 0L))
          {
            ((m)localObject).Eqg.lBo = bt.flT();
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 31L, 1L, false);
            long l = ((m)localObject).Eqg.lBo - ((m)localObject).Eqg.lBn;
            localb = ((m)localObject).Eqg;
            localb.lBm += l;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 32L, l, false);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject = ((m)localObject).Eqg;
          ((m.b)localObject).lBn = 0L;
          ((m.b)localObject).lBo = 0L;
          break;
          if ((!bool) && (Gd()))
          {
            com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject = this.Eqb;
            if (localObject != null) {
              ((j)localObject).eVn();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = this.cux;
        if (localObject != null) {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cc(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.cuJ) {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(207772);
    if (p.i(this.cuU.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(207772);
      return true;
      this.cuU.post(paramRunnable);
    }
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(207776);
    com.tencent.mm.ad.c.g((d.g.a.a)new y(this));
    if (this.cuu != null)
    {
      if (!this.cuI)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.cuF = false;
        AppMethodBeat.o(207776);
        return true;
      }
      Object localObject = this.cuu;
      if (localObject == null) {
        p.gfZ();
      }
      if (!((b)localObject).isPlaying())
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(207776);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video pause");
      localObject = this.cuu;
      if (localObject == null) {
        p.gfZ();
      }
      ((b)localObject).pause();
      if (Gd())
      {
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).eVn();
        }
      }
      AppMethodBeat.o(207776);
      return true;
    }
    AppMethodBeat.o(207776);
    return false;
  }
  
  final void prepareAsync()
  {
    AppMethodBeat.i(207766);
    if (this.cuu != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video prepare async");
      if (Gd())
      {
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).aJy("StartDownload");
        }
      }
      this.cuI = false;
      this.cuF = false;
      Object localObject = this.cuu;
      if (localObject != null) {
        ((b)localObject).prepareAsync();
      }
      localObject = this.Eqd;
      if (((m)localObject).Eqg.lBi <= 0L)
      {
        ((m)localObject).Eqg.lBi = bt.flT();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(207766);
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(207779);
    super.r(paramBitmap);
    com.tencent.luggage.xweb_ext.extendplugin.a locala = this.cuW;
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(207779);
      return;
    }
    if (paramBitmap == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.du("fail");
      AppMethodBeat.o(207779);
      return;
    }
    if ((this.crN != 0) && (this.crO != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvc * this.crN), (int)(this.cvd * this.crO), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      p.g(localObject1, "Base64.encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      p.g(localObject2, "StandardCharsets.UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "handlePluginScreenshotTaken size=" + ((String)localObject1).length());
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.e("ok", (Map)localObject2);
      au(paramBitmap);
      au(localBitmap);
      this.cuW = null;
      AppMethodBeat.o(207779);
      return;
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(207768);
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video release");
    com.tencent.mm.ad.c.g((d.g.a.a)new ab(this));
    j localj;
    Object localObject1;
    if ((this.Eqb instanceof j))
    {
      localj = this.Eqb;
      if (localj == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(207768);
        throw ((Throwable)localObject1);
      }
      localObject1 = localj.EpR;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((f)localObject1).EpM;
      if (localObject1 == null) {
        break label256;
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
        ((c)localObject1).b(localj.EpU);
      }
      localObject1 = localj.EcN;
      if (localObject1 != null) {
        ((com.tencent.mm.bp.a)localObject1).disable();
      }
      if (localj.EpW != null) {}
      try
      {
        localObject1 = aj.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        ((Context)localObject1).getContentResolver().unregisterContentObserver(localj.EpW);
        if (localj.EpX == null) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          aj.getContext().unregisterReceiver(localj.EpX);
          Gv();
          Gw();
          localObject1 = this.Eqb;
          if (localObject1 != null) {
            ((j)localObject1).boj();
          }
          this.Eqb = null;
          if (this.cux != null) {
            this.cux = null;
          }
          Gy();
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video release handler thread");
          this.cuU.removeCallbacksAndMessages(null);
          this.cuV.quitSafely();
          AppMethodBeat.o(207768);
          return;
          label256:
          localObject1 = null;
          continue;
          localThrowable1 = localThrowable1;
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(localj.TAG, localThrowable1, "unregisterContentObserver", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(localj.TAG, localThrowable2, "unregisterContentObserver", new Object[0]);
          }
        }
      }
    }
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(207778);
    if ((this.cuI) && (this.cuu != null))
    {
      Object localObject;
      if (Gd())
      {
        localObject = this.Eqb;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      if (this.cuu != null)
      {
        localObject = this.cuu;
        if (localObject != null) {}
        for (boolean bool = ((b)localObject).isPlaying();; bool = false)
        {
          this.cuD = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cuD) });
          localObject = this.cuu;
          if (localObject == null) {
            p.gfZ();
          }
          ((b)localObject).seekTo(paramLong);
          AppMethodBeat.o(207778);
          return;
        }
      }
    }
    else
    {
      this.cuG = paramLong;
    }
    AppMethodBeat.o(207778);
  }
  
  final boolean vo(boolean paramBoolean)
  {
    AppMethodBeat.i(207775);
    if (this.cuu != null)
    {
      com.tencent.mm.ad.c.g((d.g.a.a)new z(this));
      if (this.cuI)
      {
        localObject1 = this.cuu;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((b)localObject1).isPlaying())
        {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video play, video is playing");
          if (Gd())
          {
            localObject1 = this.Eqb;
            if (localObject1 != null) {
              ((j)localObject1).eVl();
            }
          }
          AppMethodBeat.o(207775);
          return true;
        }
      }
      if (!this.cuI)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.cuF = true;
        AppMethodBeat.o(207775);
        return true;
      }
      Object localObject1 = this.cuu;
      if (localObject1 == null) {
        p.gfZ();
      }
      if (((b)localObject1).getState() == 5)
      {
        if (!paramBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(207775);
          return false;
        }
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.cuF = true;
        AppMethodBeat.o(207775);
        return true;
      }
      Object localObject2;
      if (this.cuQ)
      {
        if (!paramBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(207775);
          return false;
        }
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.cuQ = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cuI))
          {
            com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              p.gfZ();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label417;
            }
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(207775);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          eVq();
          if (this.cuu != null)
          {
            this.cuH = true;
            localObject2 = this.cuu;
            if (localObject2 == null) {
              p.gfZ();
            }
            ((b)localObject2).setDataSource(this.cuO);
            localObject2 = getTAG();
            localObject3 = this.cuu;
            if (localObject3 == null) {
              p.gfZ();
            }
            com.tencent.mm.sdk.platformtools.ad.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((b)localObject3).getState()) });
            prepareAsync();
            this.cuF = true;
          }
          AppMethodBeat.o(207775);
          return true;
          label417:
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
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "video play");
      if (this.cuu != null)
      {
        if (Gd())
        {
          localObject2 = this.Eqb;
          if (localObject2 != null) {
            ((j)localObject2).eVl();
          }
        }
        localObject2 = this.cuu;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((b)localObject2).start();
      }
      AppMethodBeat.o(207775);
      return true;
    }
    AppMethodBeat.o(207775);
    return false;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<String>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class aa
    implements a.a
  {
    public final void gE(int paramInt)
    {
      AppMethodBeat.i(207753);
      this.Eqe.eVp();
      AppMethodBeat.o(207753);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(207754);
      this.Eqe.release();
      AppMethodBeat.o(207754);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(207752);
      l locall = this.Eqe;
      locall.cuR = false;
      com.tencent.mm.sdk.platformtools.ad.d(locall.getTAG(), "handleWebViewForeground");
      boolean bool = locall.Gq();
      locall.csa = null;
      if ((locall.cuu != null) && (locall.cuI) && (bool))
      {
        com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
        locall.vo(false);
      }
      AppMethodBeat.o(207752);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements d.g.a.a<z>
  {
    ab(l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class ac
    extends q
    implements d.g.a.a<z>
  {
    ac(l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class b
    implements d.a
  {
    public final void aAa() {}
    
    public final void aAb() {}
    
    public final void azY() {}
    
    public final void azZ() {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207728);
      this.Eqe.E(parama);
      AppMethodBeat.o(207728);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.e
  {
    d(l paraml) {}
    
    public final boolean ca(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207729);
      l locall = this.Eqe;
      boolean bool = locall.k((Runnable)new l.u(locall, paramInt1, paramInt2));
      AppMethodBeat.o(207729);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.d
  {
    e(l paraml) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207730);
      l locall = this.Eqe;
      boolean bool = locall.k((Runnable)new l.t(locall, paramInt1, paramInt2));
      AppMethodBeat.o(207730);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.f
  {
    f(l paraml) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(207731);
      paramb = this.Eqe;
      paramb.k((Runnable)new l.v(paramb));
      AppMethodBeat.o(207731);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(l paraml) {}
    
    public final void GB()
    {
      AppMethodBeat.i(207732);
      l locall = this.Eqe;
      locall.k((Runnable)new l.s(locall));
      AppMethodBeat.o(207732);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.g
  {
    h(l paraml) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(207733);
      paramb = this.Eqe;
      paramb.k((Runnable)new l.w(paramb));
      AppMethodBeat.o(207733);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.h
  {
    i(l paraml) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207734);
      paramb = this.Eqe;
      paramb.k((Runnable)new l.x(paramb, paramInt1, paramInt2));
      AppMethodBeat.o(207734);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(l paraml) {}
    
    public final void gM(int paramInt)
    {
      AppMethodBeat.i(207735);
      l locall = this.Eqe;
      locall.k((Runnable)new l.r(locall, paramInt));
      AppMethodBeat.o(207735);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "selectIndex", "", "kotlin.jvm.PlatformType", "onDownstreamChanged"})
  static final class k
    implements b.c
  {
    k(l paraml) {}
    
    public final void Rg(String paramString)
    {
      AppMethodBeat.i(207736);
      j localj = this.Eqe.Eqb;
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
          com.tencent.mm.sdk.platformtools.ad.i((String)localObject, str);
          localObject = localj.boi();
          str = paramString;
          if (paramString == null) {
            str = "";
          }
          ((JSONObject)localObject).put("selectIndex", str);
          localj.dispatchEvent("onVideoDownStreamChange", (JSONObject)localObject);
          AppMethodBeat.o(207736);
          return;
        }
        catch (JSONException paramString)
        {
          com.tencent.mm.sdk.platformtools.ad.e(localj.TAG, "onVideoDownStreamChange fail", new Object[] { paramString });
          AppMethodBeat.o(207736);
          return;
        }
        AppMethodBeat.o(207736);
        return;
        label123:
        String str = paramString;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(l paraml, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      boolean bool2 = false;
      int i = 0;
      boolean bool1 = true;
      int k = 1;
      AppMethodBeat.i(207737);
      Object localObject1 = parama.FE();
      if (bt.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(207737);
        return;
      }
      Object localObject2 = parama.FD();
      com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handler(%s) handleJsApi(%s), data:%s", new Object[] { this.Eqe.BM(), localObject1, ((JSONObject)localObject2).toString() });
      if ((p.i("handleVideoAction", localObject1) ^ true))
      {
        com.tencent.mm.sdk.platformtools.ad.e(this.Eqe.getTAG(), "handler(%s), not right jsapi:(%s)", new Object[] { this.Eqe.BM(), localObject1 });
        AppMethodBeat.o(207737);
        return;
      }
      localObject1 = ((JSONObject)localObject2).optString("action", "");
      if (localObject1 == null)
      {
        AppMethodBeat.o(207737);
        return;
      }
      Object localObject3;
      Object localObject5;
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
            AppMethodBeat.o(207737);
            return;
            if (((String)localObject1).equals("operateSameLayerVideo"))
            {
              localObject1 = this.Eqe;
              localObject2 = parama;
              if (((l)localObject1).cuu != null) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.w(((l)localObject1).getTAG(), "operate, media player is null");
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).du("fail");
              AppMethodBeat.o(207737);
              return;
              if (((String)localObject1).equals("removeSameLayerVideo"))
              {
                localObject1 = this.Eqe;
                localObject2 = parama;
                ((l)localObject1).release();
                if ((((l)localObject1).crL != null) && (((l)localObject1).crM != null))
                {
                  localObject3 = ((l)localObject1).crL;
                  if (localObject3 == null) {
                    p.gfZ();
                  }
                  ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).b(((l)localObject1).crM);
                  ((l)localObject1).crM = null;
                }
                ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).du("ok");
              }
            }
          }
        } while (!((String)localObject1).equals("insertSameLayerVideo"));
        localObject2 = this.Eqe;
        localObject3 = parama;
        ((l)localObject2).crL = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        if (((l)localObject2).cuu == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w(((l)localObject2).getTAG(), "insert, media player is null");
          ((l)localObject2).eVo();
        }
        if (((l)localObject2).crM == null)
        {
          ((l)localObject2).crM = ((a.a)new l.aa((l)localObject2));
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).a(((l)localObject2).crM);
        }
        if (((l)localObject2).mSurface != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "insert, setSurface");
          localObject1 = ((l)localObject2).cuu;
          if (localObject1 != null) {
            ((b)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        localObject1 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).FD();
        ((l)localObject2).cuH = ((JSONObject)localObject1).optBoolean("autoplay", false);
        ((l)localObject2).cuG = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
        ((l)localObject2).cuK = ((JSONObject)localObject1).optBoolean("loop", false);
        ((l)localObject2).cuL = ((JSONObject)localObject1).optBoolean("muted", false);
        localObject4 = ((l)localObject2).cuu;
        if (localObject4 != null) {
          ((b)localObject4).setMute(((l)localObject2).cuL);
        }
        ((l)localObject2).Eqa = ((JSONObject)localObject1).optBoolean("autoPauseOnBackground", true);
        ((l)localObject2).crR = ((JSONObject)localObject1).optBoolean("needEvent", true);
        if ((((l)localObject2).crR) && (((l)localObject2).Eqb != null))
        {
          localObject4 = ((l)localObject2).Eqb;
          if (localObject4 != null) {
            ((j)localObject4).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject4 = ((JSONObject)localObject1).optString("data", "");
          localObject5 = ((l)localObject2).Eqb;
          if (localObject5 != null) {
            ((j)localObject5).dz((String)localObject4);
          }
        }
        if (((JSONObject)localObject1).has("position"))
        {
          localObject4 = ((JSONObject)localObject1).optJSONObject("position");
          if (localObject4 != null)
          {
            ((l)localObject2).crN = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject4).optInt("width", 0));
            ((l)localObject2).crO = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject4).optInt("height", 0));
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).crN), Integer.valueOf(((l)localObject2).crO) });
          }
        }
        ((l)localObject2).cuP = ((JSONObject)localObject1).optString("objectFit", "contain");
        if (bt.isNullOrNil(((l)localObject2).cuP)) {
          ((l)localObject2).cuP = "contain";
        }
        ((l)localObject2).bSw();
        ((l)localObject2).cuO = ((JSONObject)localObject1).optString("filePath");
        if (!bt.isNullOrNil(((l)localObject2).cuO))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bnt()) {
            break label1061;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bns()) {
            break label1061;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().getProxyUrl(((l)localObject2).cuO);
          label891:
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "insert, path:%s, proxy=%s", new Object[] { ((l)localObject2).cuO, localObject1 });
          if (bt.isNullOrNil((String)localObject1)) {
            break label1067;
          }
          localObject4 = ((l)localObject2).cuu;
          if (localObject4 != null) {
            ((b)localObject4).setDataSource((String)localObject1);
          }
          ((l)localObject2).Eqd.aJz((String)localObject1);
        }
        break;
      }
      for (;;)
      {
        localObject1 = ((l)localObject2).Eqb;
        if (localObject1 != null) {
          ((j)localObject1).eVm();
        }
        ((l)localObject2).prepareAsync();
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).du("ok");
        ((l)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        AppMethodBeat.o(207737);
        return;
        if (!((String)localObject1).equals("updateSameLayerVideo")) {
          break;
        }
        localObject2 = this.Eqe;
        localObject3 = parama;
        if (((l)localObject2).cuu != null) {
          break label1107;
        }
        com.tencent.mm.sdk.platformtools.ad.w(((l)localObject2).getTAG(), "update, media player is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).du("fail");
        AppMethodBeat.o(207737);
        return;
        label1061:
        localObject1 = null;
        break label891;
        label1067:
        localObject1 = ((l)localObject2).cuu;
        if (localObject1 != null) {
          ((b)localObject1).setDataSource(((l)localObject2).cuO);
        }
        ((l)localObject2).Eqd.aJz(((l)localObject2).cuO);
      }
      label1107:
      ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
      Object localObject4 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).FD();
      if (((JSONObject)localObject4).optBoolean("switchResolution", false))
      {
        ((l)localObject2).cuG = ((l)localObject2).getCurrentPosition();
        if (!((JSONObject)localObject4).has("filePath")) {
          break label2457;
        }
        localObject1 = ((JSONObject)localObject4).optString("filePath");
        if ((bt.isNullOrNil((String)localObject1)) || (n.H((String)localObject1, ((l)localObject2).cuO, true))) {
          break label2457;
        }
        ((l)localObject2).cuO = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bnt()) {
          break label1881;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bns()) {
          break label1881;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().getProxyUrl(((l)localObject2).cuO);
        label1251:
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "update, path:%s, proxy:%s", new Object[] { ((l)localObject2).cuO, localObject1 });
        if (!bt.isNullOrNil(((l)localObject2).cuO))
        {
          ((l)localObject2).Gv();
          ((l)localObject2).eVq();
        }
        if (bt.isNullOrNil((String)localObject1)) {
          break label1887;
        }
        localObject5 = ((l)localObject2).cuu;
        if (localObject5 != null) {
          ((b)localObject5).setDataSource((String)localObject1);
        }
        ((l)localObject2).Eqd.aJz((String)localObject1);
        label1340:
        localObject1 = ((l)localObject2).Eqb;
        if (localObject1 != null) {
          ((j)localObject1).eVm();
        }
      }
      label1419:
      label2447:
      label2457:
      for (int j = 1;; j = 0)
      {
        if ((((l)localObject2).mSurface != null) && (((l)localObject2).cuu != null))
        {
          if (((l)localObject2).cuR) {
            break label1927;
          }
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "update, setSurface");
          localObject1 = ((l)localObject2).cuu;
          if (localObject1 != null) {
            ((b)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        if (((JSONObject)localObject4).has("autoplay")) {
          ((l)localObject2).cuH = ((JSONObject)localObject4).optBoolean("autoplay", ((l)localObject2).cuH);
        }
        if (((JSONObject)localObject4).has("loop")) {
          ((l)localObject2).cuK = ((JSONObject)localObject4).optBoolean("loop", ((l)localObject2).cuK);
        }
        if (((JSONObject)localObject4).has("muted"))
        {
          ((l)localObject2).cuL = ((JSONObject)localObject4).optBoolean("muted", ((l)localObject2).cuL);
          localObject1 = ((l)localObject2).cuu;
          if (localObject1 != null) {
            ((b)localObject1).setMute(((l)localObject2).cuL);
          }
        }
        ((l)localObject2).Eqa = ((JSONObject)localObject4).optBoolean("autoPauseOnBackground", true);
        if (((JSONObject)localObject4).has("needEvent")) {
          ((l)localObject2).crR = ((JSONObject)localObject4).optBoolean("needEvent", ((l)localObject2).crR);
        }
        if ((((l)localObject2).crR) && (((l)localObject2).Eqb != null))
        {
          localObject1 = ((l)localObject2).Eqb;
          if (localObject1 != null) {
            ((j)localObject1).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject1 = ((JSONObject)localObject4).optString("data", "");
          if (((JSONObject)localObject4).has("data"))
          {
            localObject5 = ((l)localObject2).Eqb;
            if (localObject5 != null) {
              ((j)localObject5).dz((String)localObject1);
            }
          }
        }
        if (((JSONObject)localObject4).has("position"))
        {
          localObject1 = ((JSONObject)localObject4).optJSONObject("position");
          if (localObject1 != null)
          {
            ((l)localObject2).crN = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject1).optInt("width", ((l)localObject2).crN));
            ((l)localObject2).crO = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject1).optInt("height", ((l)localObject2).crO));
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).crN), Integer.valueOf(((l)localObject2).crO) });
          }
          i = 1;
        }
        if (((JSONObject)localObject4).has("objectFit"))
        {
          ((l)localObject2).cuP = ((JSONObject)localObject4).optString("objectFit", ((l)localObject2).cuP);
          i = k;
          if (bt.isNullOrNil(((l)localObject2).cuP))
          {
            ((l)localObject2).cuP = "contain";
            i = k;
          }
        }
        for (;;)
        {
          if (i != 0) {
            ((l)localObject2).bSw();
          }
          if (j != 0)
          {
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "update, media player prepare async");
            ((l)localObject2).prepareAsync();
          }
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).du("ok");
          ((l)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          AppMethodBeat.o(207737);
          return;
          if (!((JSONObject)localObject4).has("initialTime")) {
            break;
          }
          ((l)localObject2).cuG = ((((JSONObject)localObject4).optDouble("initialTime", 0.0D) * 1000.0D));
          break;
          label1881:
          localObject1 = null;
          break label1251;
          label1887:
          localObject1 = ((l)localObject2).cuu;
          if (localObject1 != null) {
            ((b)localObject1).setDataSource(((l)localObject2).cuO);
          }
          ((l)localObject2).Eqd.aJz(((l)localObject2).cuO);
          break label1340;
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject2).getTAG(), "update, setSurface, WebViewInBackground");
          break label1419;
          localObject3 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).FD();
          localObject4 = ((JSONObject)localObject3).optString("type");
          if (!bt.isNullOrNil((String)localObject4))
          {
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "operate, type:%s", new Object[] { localObject4 });
            if (!n.H((String)localObject4, "play", true)) {
              break label2033;
            }
            bool1 = ((l)localObject1).vo(true);
            if (!bool1) {
              break label2447;
            }
          }
          for (localObject1 = "ok";; localObject1 = "fail")
          {
            ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).du((String)localObject1);
            AppMethodBeat.o(207737);
            return;
            label2033:
            if (n.H((String)localObject4, "pause", true))
            {
              bool1 = ((l)localObject1).pause();
              break;
            }
            if (n.H((String)localObject4, "stop", true))
            {
              bool1 = ((l)localObject1).Gv();
              break;
            }
            label2145:
            double d;
            if (n.H((String)localObject4, "seek", true))
            {
              if ((((l)localObject1).cuu != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
              {
                localObject3 = ((JSONObject)localObject3).optJSONArray("data");
                if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0)) {
                  com.tencent.mm.sdk.platformtools.ad.w(((l)localObject1).getTAG(), "seek, data array is null");
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
                  com.tencent.mm.sdk.platformtools.ad.w(((l)localObject1).getTAG(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                  break label2145;
                }
                ((l)localObject1).seek((d * 1000.0D));
              }
            }
            if (n.H((String)localObject4, "playbackRate", true))
            {
              bool1 = bool2;
              if (((l)localObject1).cuu == null) {
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
                com.tencent.mm.sdk.platformtools.ad.w(((l)localObject1).getTAG(), "speed, data array is null");
                bool1 = bool2;
                break;
              }
              d = ((JSONArray)localObject3).optDouble(0, -1.0D);
              if (d < 0.0D)
              {
                com.tencent.mm.sdk.platformtools.ad.w(((l)localObject1).getTAG(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                bool1 = bool2;
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
              localObject1 = ((l)localObject1).cuu;
              if (localObject1 == null) {
                p.gfZ();
              }
              bool1 = ((b)localObject1).aF((float)d);
              break;
            }
            bool1 = bool2;
            if (!n.H((String)localObject4, "snapshot", true)) {
              break;
            }
            ((l)localObject1).cuW = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "takeVideoSnapshot");
            com.tencent.luggage.xweb_ext.extendplugin.d.a(((l)localObject1).GK(), ((l)localObject1).getType(), ((l)localObject1).getId());
            AppMethodBeat.o(207737);
            return;
          }
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    m(l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207739);
      if (this.Eqe.Eqa)
      {
        if ((this.Eqe.cuu != null) && (this.Eqe.cuI) && (this.Eqe.csa == null))
        {
          b localb = this.Eqe.cuu;
          if (localb == null) {
            p.gfZ();
          }
          boolean bool = localb.isPlaying();
          this.Eqe.csa = new AtomicBoolean(bool);
          com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
          this.Eqe.pause();
          AppMethodBeat.o(207739);
        }
      }
      else
      {
        if (this.Eqe.Gq())
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { this.Eqe.type });
          this.Eqe.vo(true);
          AppMethodBeat.o(207739);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { this.Eqe.type });
      }
      AppMethodBeat.o(207739);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207740);
      l.a(this.Eqe);
      com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handler(%s) handlePluginDestroy", new Object[] { this.Eqe.BM() });
      this.Eqe.Gv();
      this.Eqe.Gy();
      AppMethodBeat.o(207740);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(l paraml, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(207741);
      com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handler(%s) handlePluginReady", new Object[] { this.Eqe.BM() });
      Object localObject = this.Eqe;
      ((l)localObject).cuC = false;
      ((l)localObject).cuD = false;
      ((l)localObject).cuE = false;
      ((l)localObject).cuF = false;
      this.Eqe.mSurfaceTexture = paramSurfaceTexture;
      this.Eqe.mSurface = new Surface(paramSurfaceTexture);
      if (this.Eqe.cuu != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(this.Eqe.getTAG(), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        try
        {
          localObject = this.Eqe.cuu;
          if (localObject == null) {
            p.gfZ();
          }
          ((b)localObject).setSurface(this.Eqe.mSurface);
          AppMethodBeat.o(207741);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.e(this.Eqe.getTAG(), "handlePluginReady, setSurface:ex " + localException.getMessage());
        }
      }
      AppMethodBeat.o(207741);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class q
    implements c.a
  {
    q(l paraml) {}
    
    public final void h(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207742);
      com.tencent.mm.sdk.platformtools.ad.w(this.Eqe.getTAG(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (this.Eqe.Gd())
      {
        localObject1 = this.Eqe.Eqb;
        if (localObject1 != null)
        {
          ((j)localObject1).boj();
          ((j)localObject1).bpP();
        }
      }
      try
      {
        JSONObject localJSONObject = ((j)localObject1).boi();
        Object localObject2 = d.g.b.ad.MLZ;
        localObject2 = Locale.US;
        p.g(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        p.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((j)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = this.Eqe.Eqd;
        p.g(paramString, "msg");
        p.h(paramString, "msg");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 40L, 1L, false);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!bt.isNullOrNil(paramString))
        {
          if (n.H(paramString, "MEDIA_ERR_NETWORK", true)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((m)localObject1).Eqg.lBr = paramInt1;
          ((m)localObject1).Eqg.lBs = paramInt2;
          localObject1 = ((m)localObject1).Eqg;
          p.h(paramString, "<set-?>");
          ((m.b)localObject1).errorMsg = paramString;
          this.Eqe.Gv();
          AppMethodBeat.o(207742);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e(((j)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.H(paramString, "MEDIA_ERR_DECODE", true)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.H(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 43L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(207743);
      Object localObject = this.Eqe;
      int i = this.Eqf;
      if (!((l)localObject).cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject).getTAG(), "onMediaPlayerBufferingUpdate, mp released");
        AppMethodBeat.o(207743);
        return;
      }
      if (i != ((l)localObject).cuN)
      {
        ((l)localObject).cuN = i;
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject).getTAG(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(i) });
      }
      if ((((l)localObject).Gd()) && (((l)localObject).cuI))
      {
        localObject = ((l)localObject).Eqb;
        if (localObject != null) {
          try
          {
            JSONObject localJSONObject = ((j)localObject).boi();
            localJSONObject.put("buffered", i);
            ((j)localObject).dispatchEvent("onVideoBufferUpdate", localJSONObject);
            AppMethodBeat.o(207743);
            return;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.mm.sdk.platformtools.ad.e(((j)localObject).TAG, "OnXWebVideoProgress fail", new Object[] { localJSONException });
            AppMethodBeat.o(207743);
            return;
          }
        }
      }
      AppMethodBeat.o(207743);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207744);
      l locall = this.Eqe;
      if (!locall.cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onMediaPlayerCompletion, mp released");
        AppMethodBeat.o(207744);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onCompletion");
      Object localObject;
      if (locall.Gd())
      {
        localObject = locall.Eqb;
        if (localObject == null) {}
      }
      try
      {
        ((j)localObject).dispatchEvent("onVideoEnded", ((j)localObject).boi());
        ((j)localObject).boj();
        ((j)localObject).bpP();
        localObject = locall.cuu;
        if (localObject != null)
        {
          m localm = locall.Eqd;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = locall.crL;
          p.h(localObject, "mediaPlayer");
          if ((!bt.isNullOrNil(localm.Eqg.videoPath)) && (localm.Eqg.lBi > 0L))
          {
            localm.Eqg.lBq = bt.flT();
            localm.a(locala, (b)localObject, "onMediaPlayerVideoEnd");
          }
        }
        if (locall.cuK)
        {
          com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onCompletion, video loop playing");
          locall.cuC = true;
          locall.seek(0L);
          AppMethodBeat.o(207744);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e(((j)localObject).TAG, "OnXWebVideoEnded fail", new Object[] { localJSONException });
        }
        com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onCompletion, video end playing");
        locall.cuQ = true;
        AppMethodBeat.o(207744);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207745);
      Object localObject = this.Eqe;
      int i = this.otu;
      int j = this.otv;
      if (!((l)localObject).cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject).getTAG(), "onMediaPlayerError, mp released");
        AppMethodBeat.o(207745);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i(((l)localObject).getTAG(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((l)localObject).cux;
      if (localObject != null)
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cc(i, j);
        AppMethodBeat.o(207745);
        return;
      }
      AppMethodBeat.o(207745);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207746);
      this.Eqe.jg(this.otu, this.otv);
      AppMethodBeat.o(207746);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207747);
      l locall = this.Eqe;
      if (!locall.cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onMediaPlayerPrepared, mp released");
        AppMethodBeat.o(207747);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onPrepared");
      locall.cuI = true;
      locall.bSw();
      Object localObject1 = locall.Eqd;
      int i = locall.getDuration();
      long l;
      if (((m)localObject1).Eqg.lBj <= 0L)
      {
        ((m)localObject1).Eqg.lBj = bt.flT();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 21L, 1L, false);
        l = ((m)localObject1).Eqg.lBj - ((m)localObject1).Eqg.lBi;
        ((m)localObject1).Eqg.lBk = l;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 22L, l, false);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
      }
      if ((((m)localObject1).Eqg.duration <= 0L) && (i > 0))
      {
        l = (1.0D * i / 1000.0D);
        ((m)localObject1).Eqg.duration = l;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 26L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1379L, 24L, l, false);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(l) });
      }
      Object localObject2;
      if (locall.Gd())
      {
        localObject1 = locall.Eqb;
        if (localObject1 != null) {
          ((j)localObject1).aJy("WaitingPlay");
        }
        localObject1 = locall.Eqb;
        if (localObject1 != null)
        {
          localObject2 = locall.cuu;
          if (localObject2 == null) {
            break label571;
          }
          i = ((b)localObject2).getVideoWidth();
        }
      }
      for (;;)
      {
        localObject2 = locall.cuu;
        int j;
        int k;
        if (localObject2 != null)
        {
          j = ((b)localObject2).getVideoHeight();
          k = locall.getDuration();
          com.tencent.mm.sdk.platformtools.ad.i(((j)localObject1).TAG, "onVideoLoadedMetaData width=" + i + ", height=" + j + ", duration=" + k);
        }
        try
        {
          localObject2 = ((j)localObject1).boi();
          ((JSONObject)localObject2).put("width", i);
          ((JSONObject)localObject2).put("height", j);
          ((j)localObject1).lyY = (k * 1.0D / 1000.0D);
          ((JSONObject)localObject2).put("duration", ((j)localObject1).lyY);
          ((j)localObject1).dispatchEvent("onVideoLoadedMetaData", (JSONObject)localObject2);
          l = locall.cuG;
          if (l > 0L)
          {
            locall.seek(l);
            locall.cuG = 0L;
          }
          com.tencent.mm.sdk.platformtools.ad.d(locall.getTAG(), "onPrepared, webViewInBackgroun = " + locall.cuR);
          if (!locall.cuR) {
            if ((locall.cuH) || (locall.cuF))
            {
              com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(locall.cuH), Boolean.valueOf(locall.cuF) });
              locall.vo(true);
              AppMethodBeat.o(207747);
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
            com.tencent.mm.sdk.platformtools.ad.e(((j)localObject1).TAG, "onVideoLoadedMetaData fail", new Object[] { localJSONException });
          }
          com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onPrepared, not set start play when prepared");
          AppMethodBeat.o(207747);
          return;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onPrepared, stop video auto play when webview in background");
      if ((locall.cuH) || (locall.cuF)) {}
      for (boolean bool = true;; bool = false)
      {
        locall.csa = new AtomicBoolean(bool);
        AppMethodBeat.o(207747);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207748);
      Object localObject1 = this.Eqe;
      if (!((l)localObject1).cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onMediaPlayerSeekComplete, mp released");
        AppMethodBeat.o(207748);
        return;
      }
      Object localObject2 = ((l)localObject1).Eqb;
      if (localObject2 != null) {}
      try
      {
        ((j)localObject2).dispatchEvent("onVideoSeekEnd", ((j)localObject2).boi());
        com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete");
        if (((l)localObject1).cuC)
        {
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, start when seek complete");
          ((l)localObject1).cuC = false;
          ((l)localObject1).vo(true);
          AppMethodBeat.o(207748);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e(((j)localObject2).TAG, "onVideoSeedEnd fail", new Object[] { localJSONException });
        }
        localObject2 = ((l)localObject1).cuu;
        if (localObject2 == null) {
          p.gfZ();
        }
        boolean bool = ((b)localObject2).isPlaying();
        if (((l)localObject1).cuD)
        {
          localObject2 = ((l)localObject1).cuu;
          if (localObject2 == null) {
            p.gfZ();
          }
          long l1 = ((b)localObject2).getDuration();
          localObject2 = ((l)localObject1).cuu;
          if (localObject2 == null) {
            p.gfZ();
          }
          long l2 = ((b)localObject2).getCurrentPosition();
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
          ((l)localObject1).cuD = false;
          if (l2 / 1000L < l1 / 1000L)
          {
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, video not end");
            if ((bool) && (((l)localObject1).Gd()))
            {
              com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch play again");
              localObject1 = ((l)localObject1).Eqb;
              if (localObject1 != null)
              {
                ((j)localObject1).eVl();
                AppMethodBeat.o(207748);
                return;
              }
              AppMethodBeat.o(207748);
            }
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, video ends");
            localObject2 = ((l)localObject1).cuu;
            if (localObject2 == null) {
              p.gfZ();
            }
            ((b)localObject2).pause();
            if (((l)localObject1).Gd())
            {
              localObject2 = ((l)localObject1).Eqb;
              if (localObject2 != null) {
                ((j)localObject2).eVl();
              }
            }
            localObject1 = ((l)localObject1).cuu;
            if (localObject1 == null) {
              p.gfZ();
            }
            ((b)localObject1).start();
            AppMethodBeat.o(207748);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
          if ((!bool) && (((l)localObject1).Gd()))
          {
            com.tencent.mm.sdk.platformtools.ad.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch pause again");
            localObject1 = ((l)localObject1).Eqb;
            if (localObject1 != null)
            {
              ((j)localObject1).eVn();
              AppMethodBeat.o(207748);
              return;
            }
          }
        }
        AppMethodBeat.o(207748);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207749);
      l locall = this.Eqe;
      int i = this.cvV;
      int j = this.cvW;
      if (!locall.cuJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
        AppMethodBeat.o(207749);
        return;
      }
      int k = locall.getDuration();
      com.tencent.mm.sdk.platformtools.ad.i(locall.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(locall.cuI) });
      j localj;
      if ((locall.cuI) && (locall.cuu != null) && ((i != locall.mVideoWidth) || (j != locall.mVideoHeight) || (k != locall.cuM)) && (locall.Gd()))
      {
        localj = locall.Eqb;
        if (localj != null) {
          com.tencent.mm.sdk.platformtools.ad.i(localj.TAG, "onVideoSizeChange width=" + i + ", height=" + j + ", duration=" + k);
        }
      }
      try
      {
        JSONObject localJSONObject = localj.boi();
        localJSONObject.put("width", i);
        localJSONObject.put("height", j);
        localj.lyY = (k * 1.0D / 1000.0D);
        localJSONObject.put("duration", localj.lyY);
        localj.dispatchEvent("onVideoSizeChange", localJSONObject);
        locall.mVideoWidth = i;
        locall.mVideoHeight = j;
        locall.cuM = k;
        locall.bSw();
        AppMethodBeat.o(207749);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e(localj.TAG, "onVideoSizeChange fail", new Object[] { localJSONException });
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements d.g.a.a<z>
  {
    y(l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements d.g.a.a<z>
  {
    z(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l
 * JD-Core Version:    0.7.0.1
 */