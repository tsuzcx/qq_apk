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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.ad;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  final d.a BNv;
  boolean EIq;
  j EIr;
  private com.tencent.mm.plugin.appbrand.jsapi.ad.e.g EIs;
  final m EIt;
  private int bDT;
  private float bDX;
  AtomicBoolean csD;
  com.tencent.luggage.xweb_ext.extendplugin.a cso;
  a.a csp;
  int csq;
  int csr;
  boolean csu;
  b cuX;
  private float cvF;
  private float cvG;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cva;
  boolean cvf;
  boolean cvg;
  boolean cvh;
  boolean cvi;
  long cvj;
  boolean cvk;
  boolean cvl;
  volatile boolean cvm;
  boolean cvn;
  boolean cvo;
  int cvp;
  int cvq;
  String cvr;
  String cvs;
  boolean cvt;
  volatile boolean cvu;
  private Handler cvx;
  private HandlerThread cvy;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cvz;
  final com.tencent.mm.model.d hdv;
  private int lvA;
  private int lvB;
  private int lvC;
  private int lvz;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  int mVideoHeight;
  int mVideoWidth;
  private final d.f osd;
  private boolean ozK;
  
  public l()
  {
    AppMethodBeat.i(199558);
    this.osd = d.g.O((d.g.a.a)new l.a(this));
    this.cvy = com.tencent.e.c.d.hg("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.cvF = 1.0F;
    this.cvG = 1.0F;
    this.EIs = new com.tencent.mm.plugin.appbrand.jsapi.ad.e.g();
    this.EIt = new m();
    Object localObject = com.tencent.mm.model.d.aAm();
    p.g(localObject, "AudioHelperTool.createTool()");
    this.hdv = ((com.tencent.mm.model.d)localObject);
    this.cvy.start();
    localObject = this.cvy;
    p.g(localObject, "mVideoHandlerThread");
    this.cvx = new Handler(((HandlerThread)localObject).getLooper());
    this.bDT = 800000;
    this.bDX = 0.75F;
    this.lvz = 10000;
    this.lvA = 25000;
    this.lvB = 15000;
    this.lvC = 30000;
    this.BNv = ((d.a)new b());
    AppMethodBeat.o(199558);
  }
  
  private final void GC()
  {
    try
    {
      AppMethodBeat.i(199544);
      if (this.cuX != null)
      {
        ae.i(getTAG(), "releaseMediaPlayer");
        b localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.a(null);
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.stop();
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.reset();
        localb = this.cuX;
        if (localb == null) {
          p.gkB();
        }
        localb.release();
      }
      this.cuX = null;
      this.cvm = false;
      AppMethodBeat.o(199544);
      return;
    }
    finally {}
  }
  
  private final void av(Bitmap paramBitmap)
  {
    AppMethodBeat.i(199554);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i(getTAG(), "bitmap recycle ".concat(String.valueOf(paramBitmap)));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(199554);
  }
  
  final void C(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(199555);
    parama = parama.FJ();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(199555);
      return;
    }
    this.bDT = parama.optInt("maxInitialBitrate", 0);
    this.bDX = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.lvz = parama.optInt("minDurForQualityMs", 0);
    this.lvA = parama.optInt("maxDurForQualityMs", 0);
    this.lvB = parama.optInt("minBufferMs", 0);
    this.lvC = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.bDT != 0)
    {
      bool1 = bool2;
      if (this.bDX != 0.0F)
      {
        bool1 = bool2;
        if (this.lvz != 0)
        {
          bool1 = bool2;
          if (this.lvA != 0)
          {
            bool1 = bool2;
            if (this.lvB != 0)
            {
              bool1 = bool2;
              if (this.lvC != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.ozK = bool1;
    ae.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.ozK);
    AppMethodBeat.o(199555);
  }
  
  final void D(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(199556);
    E(parama);
    h.MqF.q((Runnable)new c(this, parama), 2000L);
    AppMethodBeat.o(199556);
  }
  
  final void E(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(199557);
    if ((!this.cvu) && ((parama.getContext() instanceof MMActivity)))
    {
      parama = parama.getContext();
      if (parama == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(199557);
        throw parama;
      }
      parama = (MMActivity)parama;
      if (parama.isPaused())
      {
        ae.w(getTAG(), "checkPause, onBackGround");
        eZc();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 0L, 1L, false);
      }
      if ((parama.isDestroyed()) || (parama.isFinishing()))
      {
        ae.w(getTAG(), "checkPause, destroyed");
        release();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 1L, 1L, false);
      }
    }
    AppMethodBeat.o(199557);
  }
  
  final boolean GB()
  {
    AppMethodBeat.i(199551);
    com.tencent.mm.ac.c.h((d.g.a.a)new ac(this));
    Object localObject = this.cuX;
    if (localObject != null)
    {
      this.EIt.a(this.cso, (b)localObject);
      if (!this.cvl)
      {
        ae.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.cvi = false;
        AppMethodBeat.o(199551);
        return true;
      }
      ae.i(getTAG(), "video stop");
      ((b)localObject).stop();
      if (Gj())
      {
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).eZa();
        }
      }
      AppMethodBeat.o(199551);
      return true;
    }
    AppMethodBeat.o(199551);
    return false;
  }
  
  final void GE()
  {
    AppMethodBeat.i(199545);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.gkB();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(199545);
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(199535);
    k((Runnable)new o(this));
    AppMethodBeat.o(199535);
  }
  
  /* Error */
  final boolean Gj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 632	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:csu	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 612	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/l:EIr	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/j;
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
  
  final boolean Gw()
  {
    AppMethodBeat.i(199532);
    AtomicBoolean localAtomicBoolean = this.csD;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(199532);
      return bool;
    }
    AppMethodBeat.o(199532);
    return false;
  }
  
  final void bTJ()
  {
    AppMethodBeat.i(199539);
    if (!bu.isNullOrNil(this.cvs))
    {
      if ((this.cvl) && (GQ() != null) && (this.EIs != null))
      {
        if (this.EIs.a(this.cvs, this.csq, this.csr, this.mVideoWidth, this.mVideoHeight))
        {
          this.cvF = this.EIs.GO();
          this.cvG = this.EIs.GP();
          ae.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cvs, Float.valueOf(this.cvF), Float.valueOf(this.cvG) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GQ(), getType(), getId(), this.cvF, this.cvG);
          AppMethodBeat.o(199539);
        }
      }
      else
      {
        ae.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(199539);
      }
    }
    else {
      ae.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(199539);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(199534);
    p.h(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new p(this, paramSurfaceTexture));
    AppMethodBeat.o(199534);
  }
  
  final void eZb()
  {
    AppMethodBeat.i(199537);
    ae.i(getTAG(), "createMediaPlayer");
    Object localObject = this.cvx;
    long l = System.currentTimeMillis();
    if (this.ozK)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c((Handler)localObject, this.bDT, this.bDX, this.lvz, this.lvA, this.lvB, this.lvC);
      l = System.currentTimeMillis() - l;
      ae.d(getTAG(), "createMediaPlayer cost %s", new Object[] { Long.valueOf(l) });
      m localm = this.EIt;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 11L, l, false);
      localm.EIw.lFE = l;
      this.cuX = ((b)localObject);
      if (this.cuX == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.cvm = bool;
      if (this.cvm) {
        break label204;
      }
      ae.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(199537);
      return;
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c((Handler)localObject);
      break;
    }
    label204:
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.e)new d(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.d)new e(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.f)new f(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.b)new g(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.g)new h(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.h)new i(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.a)new j(this));
    localObject = this.cuX;
    if (localObject == null) {
      p.gkB();
    }
    ((b)localObject).a((b.c)new k(this));
    localObject = this.EIr;
    if (localObject != null)
    {
      ((j)localObject).aKU("StartPlayer");
      AppMethodBeat.o(199537);
      return;
    }
    AppMethodBeat.o(199537);
  }
  
  final void eZc()
  {
    AppMethodBeat.i(199541);
    this.cvu = true;
    ae.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ac.c.h((d.g.a.a)new m(this));
    k((Runnable)new n(this));
    AppMethodBeat.o(199541);
  }
  
  final void eZd()
  {
    AppMethodBeat.i(199543);
    this.cvt = false;
    GC();
    eZb();
    if (this.cuX != null)
    {
      b localb = this.cuX;
      if (localb == null) {
        p.gkB();
      }
      localb.setMute(this.cvo);
      if (this.mSurface != null)
      {
        if (!this.cvu)
        {
          ae.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localb = this.cuX;
          if (localb == null) {
            p.gkB();
          }
          localb.setSurface(this.mSurface);
          AppMethodBeat.o(199543);
          return;
        }
        ae.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(199543);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(199533);
    p.h(parama, "invokeContext");
    AppMethodBeat.o(199533);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(199547);
    b localb = this.cuX;
    if (localb != null)
    {
      int i = localb.getCurrentPosition();
      AppMethodBeat.o(199547);
      return i;
    }
    AppMethodBeat.o(199547);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(199548);
    b localb = this.cuX;
    if (localb != null)
    {
      int i = localb.getDuration();
      AppMethodBeat.o(199548);
      return i;
    }
    AppMethodBeat.o(199548);
    return 0;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(199531);
    String str = (String)this.osd.getValue();
    AppMethodBeat.o(199531);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(199536);
    p.h(parama, "invokeContext");
    k((Runnable)new l(this, parama));
    AppMethodBeat.o(199536);
    return null;
  }
  
  final boolean jk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199538);
    if (!this.cvm)
    {
      ae.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(199538);
      return false;
    }
    ae.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    m.b localb;
    if (paramInt1 == 701)
    {
      localObject = this.cuX;
      if (localObject == null) {
        p.gkB();
      }
      this.cvh = ((b)localObject).isPlaying();
      ae.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cvh) });
      if (Gj())
      {
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      localObject = this.EIt;
      if (((m)localObject).EIw.lFL <= 0L)
      {
        localb = ((m)localObject).EIw;
        localb.lFJ += 1;
        ((m)localObject).EIw.lFL = bu.fpO();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 30L, 1L, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199538);
      return false;
      if (paramInt1 == 702)
      {
        localObject = this.cuX;
        if (localObject == null) {
          p.gkB();
        }
        boolean bool = ((b)localObject).isPlaying();
        ae.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cvh), Boolean.valueOf(bool) });
        if (this.cvh)
        {
          this.cvh = false;
          if ((bool) && (Gj()))
          {
            ae.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject = this.EIr;
            if (localObject != null) {
              ((j)localObject).eYY();
            }
          }
        }
        for (;;)
        {
          localObject = this.EIt;
          if ((((m)localObject).EIw.lFM <= 0L) && (((m)localObject).EIw.lFL > 0L))
          {
            ((m)localObject).EIw.lFM = bu.fpO();
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 31L, 1L, false);
            long l = ((m)localObject).EIw.lFM - ((m)localObject).EIw.lFL;
            localb = ((m)localObject).EIw;
            localb.lFK += l;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 32L, l, false);
            ae.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject = ((m)localObject).EIw;
          ((m.b)localObject).lFL = 0L;
          ((m.b)localObject).lFM = 0L;
          break;
          if ((!bool) && (Gj()))
          {
            ae.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject = this.EIr;
            if (localObject != null) {
              ((j)localObject).eZa();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        ae.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = this.cva;
        if (localObject != null) {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cd(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.cvm) {
          ae.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          ae.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(199546);
    if (p.i(this.cvx.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(199546);
      return true;
      this.cvx.post(paramRunnable);
    }
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(199550);
    com.tencent.mm.ac.c.h((d.g.a.a)new y(this));
    if (this.cuX != null)
    {
      if (!this.cvl)
      {
        ae.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.cvi = false;
        AppMethodBeat.o(199550);
        return true;
      }
      Object localObject = this.cuX;
      if (localObject == null) {
        p.gkB();
      }
      if (!((b)localObject).isPlaying())
      {
        ae.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(199550);
        return true;
      }
      ae.i(getTAG(), "video pause");
      localObject = this.cuX;
      if (localObject == null) {
        p.gkB();
      }
      ((b)localObject).pause();
      if (Gj())
      {
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).eZa();
        }
      }
      AppMethodBeat.o(199550);
      return true;
    }
    AppMethodBeat.o(199550);
    return false;
  }
  
  final void prepareAsync()
  {
    AppMethodBeat.i(199540);
    if (this.cuX != null)
    {
      ae.i(getTAG(), "video prepare async");
      if (Gj())
      {
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).aKU("StartDownload");
        }
      }
      this.cvl = false;
      this.cvi = false;
      Object localObject = this.cuX;
      if (localObject != null) {
        ((b)localObject).prepareAsync();
      }
      localObject = this.EIt;
      if (((m)localObject).EIw.lFG <= 0L)
      {
        ((m)localObject).EIw.lFG = bu.fpO();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(199540);
  }
  
  final void release()
  {
    AppMethodBeat.i(199542);
    ae.i(getTAG(), "video release");
    com.tencent.mm.ac.c.h((d.g.a.a)new ab(this));
    j localj;
    Object localObject1;
    if ((this.EIr instanceof j))
    {
      localj = this.EIr;
      if (localj == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(199542);
        throw ((Throwable)localObject1);
      }
      localObject1 = localj.EIh;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((f)localObject1).EIc;
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
        ((c)localObject1).b(localj.EIk);
      }
      localObject1 = localj.EuP;
      if (localObject1 != null) {
        ((com.tencent.mm.bo.a)localObject1).disable();
      }
      if (localj.EIm != null) {}
      try
      {
        localObject1 = ak.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        ((Context)localObject1).getContentResolver().unregisterContentObserver(localj.EIm);
        if (localj.EIn == null) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          ak.getContext().unregisterReceiver(localj.EIn);
          GB();
          GC();
          localObject1 = this.EIr;
          if (localObject1 != null) {
            ((j)localObject1).boT();
          }
          this.EIr = null;
          if (this.cva != null) {
            this.cva = null;
          }
          GE();
          ae.i(getTAG(), "video release handler thread");
          this.cvx.removeCallbacksAndMessages(null);
          this.cvy.quitSafely();
          AppMethodBeat.o(199542);
          return;
          label256:
          localObject1 = null;
          continue;
          localThrowable1 = localThrowable1;
          ae.printErrStackTrace(localj.TAG, localThrowable1, "unregisterContentObserver", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            ae.printErrStackTrace(localj.TAG, localThrowable2, "unregisterContentObserver", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(199553);
    super.s(paramBitmap);
    com.tencent.luggage.xweb_ext.extendplugin.a locala = this.cvz;
    if (locala == null)
    {
      ae.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(199553);
      return;
    }
    if (paramBitmap == null)
    {
      ae.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.dw("fail");
      AppMethodBeat.o(199553);
      return;
    }
    if ((this.csq != 0) && (this.csr != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvF * this.csq), (int)(this.cvG * this.csr), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      p.g(localObject1, "Base64.encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      p.g(localObject2, "StandardCharsets.UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      ae.i(getTAG(), "handlePluginScreenshotTaken size=" + ((String)localObject1).length());
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.f("ok", (Map)localObject2);
      av(paramBitmap);
      av(localBitmap);
      this.cvz = null;
      AppMethodBeat.o(199553);
      return;
    }
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(199552);
    if ((this.cvl) && (this.cuX != null))
    {
      Object localObject;
      if (Gj())
      {
        localObject = this.EIr;
        if (localObject != null) {
          ((j)localObject).onVideoWaiting();
        }
      }
      if (this.cuX != null)
      {
        localObject = this.cuX;
        if (localObject != null) {}
        for (boolean bool = ((b)localObject).isPlaying();; bool = false)
        {
          this.cvg = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          ae.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cvg) });
          localObject = this.cuX;
          if (localObject == null) {
            p.gkB();
          }
          ((b)localObject).seekTo(paramLong);
          AppMethodBeat.o(199552);
          return;
        }
      }
    }
    else
    {
      this.cvj = paramLong;
    }
    AppMethodBeat.o(199552);
  }
  
  final boolean vx(boolean paramBoolean)
  {
    AppMethodBeat.i(199549);
    if (this.cuX != null)
    {
      com.tencent.mm.ac.c.h((d.g.a.a)new z(this));
      if (this.cvl)
      {
        localObject1 = this.cuX;
        if (localObject1 == null) {
          p.gkB();
        }
        if (((b)localObject1).isPlaying())
        {
          ae.i(getTAG(), "video play, video is playing");
          if (Gj())
          {
            localObject1 = this.EIr;
            if (localObject1 != null) {
              ((j)localObject1).eYY();
            }
          }
          AppMethodBeat.o(199549);
          return true;
        }
      }
      if (!this.cvl)
      {
        ae.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.cvi = true;
        AppMethodBeat.o(199549);
        return true;
      }
      Object localObject1 = this.cuX;
      if (localObject1 == null) {
        p.gkB();
      }
      if (((b)localObject1).getState() == 5)
      {
        if (!paramBoolean)
        {
          ae.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(199549);
          return false;
        }
        ae.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.cvi = true;
        AppMethodBeat.o(199549);
        return true;
      }
      Object localObject2;
      if (this.cvt)
      {
        if (!paramBoolean)
        {
          ae.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(199549);
          return false;
        }
        ae.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.cvt = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cvl))
          {
            ae.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              p.gkB();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label417;
            }
            localObject1 = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(199549);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          eZd();
          if (this.cuX != null)
          {
            this.cvk = true;
            localObject2 = this.cuX;
            if (localObject2 == null) {
              p.gkB();
            }
            ((b)localObject2).setDataSource(this.cvr);
            localObject2 = getTAG();
            localObject3 = this.cuX;
            if (localObject3 == null) {
              p.gkB();
            }
            ae.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((b)localObject3).getState()) });
            prepareAsync();
            this.cvi = true;
          }
          AppMethodBeat.o(199549);
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
      ae.i(getTAG(), "video play");
      if (this.cuX != null)
      {
        if (Gj())
        {
          localObject2 = this.EIr;
          if (localObject2 != null) {
            ((j)localObject2).eYY();
          }
        }
        localObject2 = this.cuX;
        if (localObject2 == null) {
          p.gkB();
        }
        ((b)localObject2).start();
      }
      AppMethodBeat.o(199549);
      return true;
    }
    AppMethodBeat.o(199549);
    return false;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class aa
    implements a.a
  {
    public final void gF(int paramInt)
    {
      AppMethodBeat.i(199527);
      this.EIu.eZc();
      AppMethodBeat.o(199527);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(199528);
      this.EIu.release();
      AppMethodBeat.o(199528);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(199526);
      l locall = this.EIu;
      locall.cvu = false;
      ae.d(locall.getTAG(), "handleWebViewForeground");
      boolean bool = locall.Gw();
      locall.csD = null;
      if ((locall.cuX != null) && (locall.cvl) && (bool))
      {
        ae.i(locall.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
        locall.vx(false);
      }
      AppMethodBeat.o(199526);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements d.g.a.a<z>
  {
    ab(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class ac
    extends q
    implements d.g.a.a<z>
  {
    ac(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class b
    implements d.a
  {
    public final void aAo() {}
    
    public final void aAp() {}
    
    public final void aAq() {}
    
    public final void aAr() {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(199502);
      this.EIu.E(parama);
      AppMethodBeat.o(199502);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.e
  {
    d(l paraml) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199503);
      l locall = this.EIu;
      boolean bool = locall.k((Runnable)new l.u(locall, paramInt1, paramInt2));
      AppMethodBeat.o(199503);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.d
  {
    e(l paraml) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199504);
      l locall = this.EIu;
      boolean bool = locall.k((Runnable)new l.t(locall, paramInt1, paramInt2));
      AppMethodBeat.o(199504);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.f
  {
    f(l paraml) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(199505);
      paramb = this.EIu;
      paramb.k((Runnable)new l.v(paramb));
      AppMethodBeat.o(199505);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(l paraml) {}
    
    public final void GH()
    {
      AppMethodBeat.i(199506);
      l locall = this.EIu;
      locall.k((Runnable)new l.s(locall));
      AppMethodBeat.o(199506);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.g
  {
    h(l paraml) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(199507);
      paramb = this.EIu;
      paramb.k((Runnable)new l.w(paramb));
      AppMethodBeat.o(199507);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.h
  {
    i(l paraml) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199508);
      paramb = this.EIu;
      paramb.k((Runnable)new l.x(paramb, paramInt1, paramInt2));
      AppMethodBeat.o(199508);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(l paraml) {}
    
    public final void gN(int paramInt)
    {
      AppMethodBeat.i(199509);
      l locall = this.EIu;
      locall.k((Runnable)new l.r(locall, paramInt));
      AppMethodBeat.o(199509);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "selectIndex", "", "kotlin.jvm.PlatformType", "onDownstreamChanged"})
  static final class k
    implements b.c
  {
    k(l paraml) {}
    
    public final void RP(String paramString)
    {
      AppMethodBeat.i(199510);
      j localj = this.EIu.EIr;
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
          ae.i((String)localObject, str);
          localObject = localj.boS();
          str = paramString;
          if (paramString == null) {
            str = "";
          }
          ((JSONObject)localObject).put("selectIndex", str);
          localj.dispatchEvent("onVideoDownStreamChange", (JSONObject)localObject);
          AppMethodBeat.o(199510);
          return;
        }
        catch (JSONException paramString)
        {
          ae.e(localj.TAG, "onVideoDownStreamChange fail", new Object[] { paramString });
          AppMethodBeat.o(199510);
          return;
        }
        AppMethodBeat.o(199510);
        return;
        label123:
        String str = paramString;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
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
      AppMethodBeat.i(199511);
      Object localObject1 = parama.FK();
      if (bu.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(199511);
        return;
      }
      Object localObject2 = parama.FJ();
      ae.i(this.EIu.getTAG(), "handler(%s) handleJsApi(%s), data:%s", new Object[] { this.EIu.BN(), localObject1, ((JSONObject)localObject2).toString() });
      if ((p.i("handleVideoAction", localObject1) ^ true))
      {
        ae.e(this.EIu.getTAG(), "handler(%s), not right jsapi:(%s)", new Object[] { this.EIu.BN(), localObject1 });
        AppMethodBeat.o(199511);
        return;
      }
      localObject1 = ((JSONObject)localObject2).optString("action", "");
      if (localObject1 == null)
      {
        AppMethodBeat.o(199511);
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
            AppMethodBeat.o(199511);
            return;
            if (((String)localObject1).equals("operateSameLayerVideo"))
            {
              localObject1 = this.EIu;
              localObject2 = parama;
              if (((l)localObject1).cuX != null) {
                break;
              }
              ae.w(((l)localObject1).getTAG(), "operate, media player is null");
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dw("fail");
              AppMethodBeat.o(199511);
              return;
              if (((String)localObject1).equals("removeSameLayerVideo"))
              {
                localObject1 = this.EIu;
                localObject2 = parama;
                ((l)localObject1).release();
                if ((((l)localObject1).cso != null) && (((l)localObject1).csp != null))
                {
                  localObject3 = ((l)localObject1).cso;
                  if (localObject3 == null) {
                    p.gkB();
                  }
                  ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).b(((l)localObject1).csp);
                  ((l)localObject1).csp = null;
                }
                ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dw("ok");
              }
            }
          }
        } while (!((String)localObject1).equals("insertSameLayerVideo"));
        localObject2 = this.EIu;
        localObject3 = parama;
        ((l)localObject2).cso = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        if (((l)localObject2).cuX == null)
        {
          ae.w(((l)localObject2).getTAG(), "insert, media player is null");
          ((l)localObject2).eZb();
        }
        if (((l)localObject2).csp == null)
        {
          ((l)localObject2).csp = ((a.a)new l.aa((l)localObject2));
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).a(((l)localObject2).csp);
        }
        if (((l)localObject2).mSurface != null)
        {
          ae.i(((l)localObject2).getTAG(), "insert, setSurface");
          localObject1 = ((l)localObject2).cuX;
          if (localObject1 != null) {
            ((b)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        localObject1 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).FJ();
        ((l)localObject2).cvk = ((JSONObject)localObject1).optBoolean("autoplay", false);
        ((l)localObject2).cvj = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
        ((l)localObject2).cvn = ((JSONObject)localObject1).optBoolean("loop", false);
        ((l)localObject2).cvo = ((JSONObject)localObject1).optBoolean("muted", false);
        localObject4 = ((l)localObject2).cuX;
        if (localObject4 != null) {
          ((b)localObject4).setMute(((l)localObject2).cvo);
        }
        ((l)localObject2).EIq = ((JSONObject)localObject1).optBoolean("autoPauseOnBackground", true);
        ((l)localObject2).csu = ((JSONObject)localObject1).optBoolean("needEvent", true);
        if ((((l)localObject2).csu) && (((l)localObject2).EIr != null))
        {
          localObject4 = ((l)localObject2).EIr;
          if (localObject4 != null) {
            ((j)localObject4).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject4 = ((JSONObject)localObject1).optString("data", "");
          localObject5 = ((l)localObject2).EIr;
          if (localObject5 != null) {
            ((j)localObject5).dC((String)localObject4);
          }
        }
        if (((JSONObject)localObject1).has("position"))
        {
          localObject4 = ((JSONObject)localObject1).optJSONObject("position");
          if (localObject4 != null)
          {
            ((l)localObject2).csq = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject4).optInt("width", 0));
            ((l)localObject2).csr = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject4).optInt("height", 0));
            ae.i(((l)localObject2).getTAG(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).csq), Integer.valueOf(((l)localObject2).csr) });
          }
        }
        ((l)localObject2).cvs = ((JSONObject)localObject1).optString("objectFit", "contain");
        if (bu.isNullOrNil(((l)localObject2).cvs)) {
          ((l)localObject2).cvs = "contain";
        }
        ((l)localObject2).bTJ();
        ((l)localObject2).cvr = ((JSONObject)localObject1).optString("filePath");
        if (!bu.isNullOrNil(((l)localObject2).cvr))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bod()) {
            break label1061;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
          p.g(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).boc()) {
            break label1061;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob().getProxyUrl(((l)localObject2).cvr);
          label891:
          ae.i(((l)localObject2).getTAG(), "insert, path:%s, proxy=%s", new Object[] { ((l)localObject2).cvr, localObject1 });
          if (bu.isNullOrNil((String)localObject1)) {
            break label1067;
          }
          localObject4 = ((l)localObject2).cuX;
          if (localObject4 != null) {
            ((b)localObject4).setDataSource((String)localObject1);
          }
          ((l)localObject2).EIt.aKV((String)localObject1);
        }
        break;
      }
      for (;;)
      {
        localObject1 = ((l)localObject2).EIr;
        if (localObject1 != null) {
          ((j)localObject1).eYZ();
        }
        ((l)localObject2).prepareAsync();
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dw("ok");
        ((l)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        AppMethodBeat.o(199511);
        return;
        if (!((String)localObject1).equals("updateSameLayerVideo")) {
          break;
        }
        localObject2 = this.EIu;
        localObject3 = parama;
        if (((l)localObject2).cuX != null) {
          break label1107;
        }
        ae.w(((l)localObject2).getTAG(), "update, media player is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dw("fail");
        AppMethodBeat.o(199511);
        return;
        label1061:
        localObject1 = null;
        break label891;
        label1067:
        localObject1 = ((l)localObject2).cuX;
        if (localObject1 != null) {
          ((b)localObject1).setDataSource(((l)localObject2).cvr);
        }
        ((l)localObject2).EIt.aKV(((l)localObject2).cvr);
      }
      label1107:
      ((l)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
      Object localObject4 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).FJ();
      if (((JSONObject)localObject4).optBoolean("switchResolution", false))
      {
        ((l)localObject2).cvj = ((l)localObject2).getCurrentPosition();
        if (!((JSONObject)localObject4).has("filePath")) {
          break label2457;
        }
        localObject1 = ((JSONObject)localObject4).optString("filePath");
        if ((bu.isNullOrNil((String)localObject1)) || (n.H((String)localObject1, ((l)localObject2).cvr, true))) {
          break label2457;
        }
        ((l)localObject2).cvr = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bod()) {
          break label1881;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
        p.g(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).boc()) {
          break label1881;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob().getProxyUrl(((l)localObject2).cvr);
        label1251:
        ae.i(((l)localObject2).getTAG(), "update, path:%s, proxy:%s", new Object[] { ((l)localObject2).cvr, localObject1 });
        if (!bu.isNullOrNil(((l)localObject2).cvr))
        {
          ((l)localObject2).GB();
          ((l)localObject2).eZd();
        }
        if (bu.isNullOrNil((String)localObject1)) {
          break label1887;
        }
        localObject5 = ((l)localObject2).cuX;
        if (localObject5 != null) {
          ((b)localObject5).setDataSource((String)localObject1);
        }
        ((l)localObject2).EIt.aKV((String)localObject1);
        label1340:
        localObject1 = ((l)localObject2).EIr;
        if (localObject1 != null) {
          ((j)localObject1).eYZ();
        }
      }
      label1419:
      label2447:
      label2457:
      for (int j = 1;; j = 0)
      {
        if ((((l)localObject2).mSurface != null) && (((l)localObject2).cuX != null))
        {
          if (((l)localObject2).cvu) {
            break label1927;
          }
          ae.i(((l)localObject2).getTAG(), "update, setSurface");
          localObject1 = ((l)localObject2).cuX;
          if (localObject1 != null) {
            ((b)localObject1).setSurface(((l)localObject2).mSurface);
          }
        }
        if (((JSONObject)localObject4).has("autoplay")) {
          ((l)localObject2).cvk = ((JSONObject)localObject4).optBoolean("autoplay", ((l)localObject2).cvk);
        }
        if (((JSONObject)localObject4).has("loop")) {
          ((l)localObject2).cvn = ((JSONObject)localObject4).optBoolean("loop", ((l)localObject2).cvn);
        }
        if (((JSONObject)localObject4).has("muted"))
        {
          ((l)localObject2).cvo = ((JSONObject)localObject4).optBoolean("muted", ((l)localObject2).cvo);
          localObject1 = ((l)localObject2).cuX;
          if (localObject1 != null) {
            ((b)localObject1).setMute(((l)localObject2).cvo);
          }
        }
        ((l)localObject2).EIq = ((JSONObject)localObject4).optBoolean("autoPauseOnBackground", true);
        if (((JSONObject)localObject4).has("needEvent")) {
          ((l)localObject2).csu = ((JSONObject)localObject4).optBoolean("needEvent", ((l)localObject2).csu);
        }
        if ((((l)localObject2).csu) && (((l)localObject2).EIr != null))
        {
          localObject1 = ((l)localObject2).EIr;
          if (localObject1 != null) {
            ((j)localObject1).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject1 = ((JSONObject)localObject4).optString("data", "");
          if (((JSONObject)localObject4).has("data"))
          {
            localObject5 = ((l)localObject2).EIr;
            if (localObject5 != null) {
              ((j)localObject5).dC((String)localObject1);
            }
          }
        }
        if (((JSONObject)localObject4).has("position"))
        {
          localObject1 = ((JSONObject)localObject4).optJSONObject("position");
          if (localObject1 != null)
          {
            ((l)localObject2).csq = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject1).optInt("width", ((l)localObject2).csq));
            ((l)localObject2).csr = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject1).optInt("height", ((l)localObject2).csr));
            ae.i(((l)localObject2).getTAG(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(((l)localObject2).csq), Integer.valueOf(((l)localObject2).csr) });
          }
          i = 1;
        }
        if (((JSONObject)localObject4).has("objectFit"))
        {
          ((l)localObject2).cvs = ((JSONObject)localObject4).optString("objectFit", ((l)localObject2).cvs);
          i = k;
          if (bu.isNullOrNil(((l)localObject2).cvs))
          {
            ((l)localObject2).cvs = "contain";
            i = k;
          }
        }
        for (;;)
        {
          if (i != 0) {
            ((l)localObject2).bTJ();
          }
          if (j != 0)
          {
            ae.i(((l)localObject2).getTAG(), "update, media player prepare async");
            ((l)localObject2).prepareAsync();
          }
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).dw("ok");
          ((l)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          AppMethodBeat.o(199511);
          return;
          if (!((JSONObject)localObject4).has("initialTime")) {
            break;
          }
          ((l)localObject2).cvj = ((((JSONObject)localObject4).optDouble("initialTime", 0.0D) * 1000.0D));
          break;
          label1881:
          localObject1 = null;
          break label1251;
          label1887:
          localObject1 = ((l)localObject2).cuX;
          if (localObject1 != null) {
            ((b)localObject1).setDataSource(((l)localObject2).cvr);
          }
          ((l)localObject2).EIt.aKV(((l)localObject2).cvr);
          break label1340;
          ae.i(((l)localObject2).getTAG(), "update, setSurface, WebViewInBackground");
          break label1419;
          localObject3 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).FJ();
          localObject4 = ((JSONObject)localObject3).optString("type");
          if (!bu.isNullOrNil((String)localObject4))
          {
            ae.i(((l)localObject1).getTAG(), "operate, type:%s", new Object[] { localObject4 });
            if (!n.H((String)localObject4, "play", true)) {
              break label2033;
            }
            bool1 = ((l)localObject1).vx(true);
            if (!bool1) {
              break label2447;
            }
          }
          for (localObject1 = "ok";; localObject1 = "fail")
          {
            ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dw((String)localObject1);
            AppMethodBeat.o(199511);
            return;
            label2033:
            if (n.H((String)localObject4, "pause", true))
            {
              bool1 = ((l)localObject1).pause();
              break;
            }
            if (n.H((String)localObject4, "stop", true))
            {
              bool1 = ((l)localObject1).GB();
              break;
            }
            label2145:
            double d;
            if (n.H((String)localObject4, "seek", true))
            {
              if ((((l)localObject1).cuX != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
              {
                localObject3 = ((JSONObject)localObject3).optJSONArray("data");
                if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0)) {
                  ae.w(((l)localObject1).getTAG(), "seek, data array is null");
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
                  ae.w(((l)localObject1).getTAG(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                  break label2145;
                }
                ((l)localObject1).seek((d * 1000.0D));
              }
            }
            if (n.H((String)localObject4, "playbackRate", true))
            {
              bool1 = bool2;
              if (((l)localObject1).cuX == null) {
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
                ae.w(((l)localObject1).getTAG(), "speed, data array is null");
                bool1 = bool2;
                break;
              }
              d = ((JSONArray)localObject3).optDouble(0, -1.0D);
              if (d < 0.0D)
              {
                ae.w(((l)localObject1).getTAG(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                bool1 = bool2;
                break;
              }
              ae.i(((l)localObject1).getTAG(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
              localObject1 = ((l)localObject1).cuX;
              if (localObject1 == null) {
                p.gkB();
              }
              bool1 = ((b)localObject1).aF((float)d);
              break;
            }
            bool1 = bool2;
            if (!n.H((String)localObject4, "snapshot", true)) {
              break;
            }
            ((l)localObject1).cvz = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
            ae.i(((l)localObject1).getTAG(), "takeVideoSnapshot");
            com.tencent.luggage.xweb_ext.extendplugin.d.a(((l)localObject1).GQ(), ((l)localObject1).getType(), ((l)localObject1).getId());
            AppMethodBeat.o(199511);
            return;
          }
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    m(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199513);
      if (this.EIu.EIq)
      {
        if ((this.EIu.cuX != null) && (this.EIu.cvl) && (this.EIu.csD == null))
        {
          b localb = this.EIu.cuX;
          if (localb == null) {
            p.gkB();
          }
          boolean bool = localb.isPlaying();
          this.EIu.csD = new AtomicBoolean(bool);
          ae.i(this.EIu.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
          this.EIu.pause();
          AppMethodBeat.o(199513);
        }
      }
      else
      {
        if (this.EIu.Gw())
        {
          ae.i(this.EIu.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { this.EIu.type });
          this.EIu.vx(true);
          AppMethodBeat.o(199513);
          return;
        }
        ae.i(this.EIu.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { this.EIu.type });
      }
      AppMethodBeat.o(199513);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199514);
      l.a(this.EIu);
      ae.i(this.EIu.getTAG(), "handler(%s) handlePluginDestroy", new Object[] { this.EIu.BN() });
      this.EIu.GB();
      this.EIu.GE();
      AppMethodBeat.o(199514);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(l paraml, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(199515);
      ae.i(this.EIu.getTAG(), "handler(%s) handlePluginReady", new Object[] { this.EIu.BN() });
      Object localObject = this.EIu;
      ((l)localObject).cvf = false;
      ((l)localObject).cvg = false;
      ((l)localObject).cvh = false;
      ((l)localObject).cvi = false;
      this.EIu.mSurfaceTexture = paramSurfaceTexture;
      this.EIu.mSurface = new Surface(paramSurfaceTexture);
      if (this.EIu.cuX != null)
      {
        ae.i(this.EIu.getTAG(), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        try
        {
          localObject = this.EIu.cuX;
          if (localObject == null) {
            p.gkB();
          }
          ((b)localObject).setSurface(this.EIu.mSurface);
          AppMethodBeat.o(199515);
          return;
        }
        catch (Exception localException)
        {
          ae.e(this.EIu.getTAG(), "handlePluginReady, setSurface:ex " + localException.getMessage());
        }
      }
      AppMethodBeat.o(199515);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class q
    implements c.a
  {
    q(l paraml) {}
    
    public final void h(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199516);
      ae.w(this.EIu.getTAG(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (this.EIu.Gj())
      {
        localObject1 = this.EIu.EIr;
        if (localObject1 != null)
        {
          ((j)localObject1).boT();
          ((j)localObject1).bqz();
        }
      }
      try
      {
        JSONObject localJSONObject = ((j)localObject1).boS();
        Object localObject2 = ad.Njc;
        localObject2 = Locale.US;
        p.g(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        p.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((j)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = this.EIu.EIt;
        p.g(paramString, "msg");
        p.h(paramString, "msg");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 40L, 1L, false);
        ae.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!bu.isNullOrNil(paramString))
        {
          if (n.H(paramString, "MEDIA_ERR_NETWORK", true)) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((m)localObject1).EIw.lFP = paramInt1;
          ((m)localObject1).EIw.lFQ = paramInt2;
          localObject1 = ((m)localObject1).EIw;
          p.h(paramString, "<set-?>");
          ((m.b)localObject1).errorMsg = paramString;
          this.EIu.GB();
          AppMethodBeat.o(199516);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e(((j)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.H(paramString, "MEDIA_ERR_DECODE", true)) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.H(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 43L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(199517);
      Object localObject = this.EIu;
      int i = this.EIv;
      if (!((l)localObject).cvm)
      {
        ae.i(((l)localObject).getTAG(), "onMediaPlayerBufferingUpdate, mp released");
        AppMethodBeat.o(199517);
        return;
      }
      if (i != ((l)localObject).cvq)
      {
        ((l)localObject).cvq = i;
        ae.i(((l)localObject).getTAG(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(i) });
      }
      if ((((l)localObject).Gj()) && (((l)localObject).cvl))
      {
        localObject = ((l)localObject).EIr;
        if (localObject != null) {
          try
          {
            JSONObject localJSONObject = ((j)localObject).boS();
            localJSONObject.put("buffered", i);
            ((j)localObject).dispatchEvent("onVideoBufferUpdate", localJSONObject);
            AppMethodBeat.o(199517);
            return;
          }
          catch (JSONException localJSONException)
          {
            ae.e(((j)localObject).TAG, "OnXWebVideoProgress fail", new Object[] { localJSONException });
            AppMethodBeat.o(199517);
            return;
          }
        }
      }
      AppMethodBeat.o(199517);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199518);
      l locall = this.EIu;
      if (!locall.cvm)
      {
        ae.i(locall.getTAG(), "onMediaPlayerCompletion, mp released");
        AppMethodBeat.o(199518);
        return;
      }
      ae.i(locall.getTAG(), "onCompletion");
      Object localObject;
      if (locall.Gj())
      {
        localObject = locall.EIr;
        if (localObject == null) {}
      }
      try
      {
        ((j)localObject).dispatchEvent("onVideoEnded", ((j)localObject).boS());
        ((j)localObject).boT();
        ((j)localObject).bqz();
        localObject = locall.cuX;
        if (localObject != null)
        {
          m localm = locall.EIt;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = locall.cso;
          p.h(localObject, "mediaPlayer");
          if ((!bu.isNullOrNil(localm.EIw.videoPath)) && (localm.EIw.lFG > 0L))
          {
            localm.EIw.lFO = bu.fpO();
            localm.a(locala, (b)localObject, "onMediaPlayerVideoEnd");
          }
        }
        if (locall.cvn)
        {
          ae.i(locall.getTAG(), "onCompletion, video loop playing");
          locall.cvf = true;
          locall.seek(0L);
          AppMethodBeat.o(199518);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e(((j)localObject).TAG, "OnXWebVideoEnded fail", new Object[] { localJSONException });
        }
        ae.i(locall.getTAG(), "onCompletion, video end playing");
        locall.cvt = true;
        AppMethodBeat.o(199518);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(199519);
      Object localObject = this.EIu;
      int i = this.ozV;
      int j = this.ozW;
      if (!((l)localObject).cvm)
      {
        ae.i(((l)localObject).getTAG(), "onMediaPlayerError, mp released");
        AppMethodBeat.o(199519);
        return;
      }
      ae.i(((l)localObject).getTAG(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((l)localObject).cva;
      if (localObject != null)
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cd(i, j);
        AppMethodBeat.o(199519);
        return;
      }
      AppMethodBeat.o(199519);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(199520);
      this.EIu.jk(this.ozV, this.ozW);
      AppMethodBeat.o(199520);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199521);
      l locall = this.EIu;
      if (!locall.cvm)
      {
        ae.i(locall.getTAG(), "onMediaPlayerPrepared, mp released");
        AppMethodBeat.o(199521);
        return;
      }
      ae.i(locall.getTAG(), "onPrepared");
      locall.cvl = true;
      locall.bTJ();
      Object localObject1 = locall.EIt;
      int i = locall.getDuration();
      long l;
      if (((m)localObject1).EIw.lFH <= 0L)
      {
        ((m)localObject1).EIw.lFH = bu.fpO();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 21L, 1L, false);
        l = ((m)localObject1).EIw.lFH - ((m)localObject1).EIw.lFG;
        ((m)localObject1).EIw.lFI = l;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 22L, l, false);
        ae.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
      }
      if ((((m)localObject1).EIw.duration <= 0L) && (i > 0))
      {
        l = (1.0D * i / 1000.0D);
        ((m)localObject1).EIw.duration = l;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 26L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1379L, 24L, l, false);
        ae.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(l) });
      }
      Object localObject2;
      if (locall.Gj())
      {
        localObject1 = locall.EIr;
        if (localObject1 != null) {
          ((j)localObject1).aKU("WaitingPlay");
        }
        localObject1 = locall.EIr;
        if (localObject1 != null)
        {
          localObject2 = locall.cuX;
          if (localObject2 == null) {
            break label571;
          }
          i = ((b)localObject2).getVideoWidth();
        }
      }
      for (;;)
      {
        localObject2 = locall.cuX;
        int j;
        int k;
        if (localObject2 != null)
        {
          j = ((b)localObject2).getVideoHeight();
          k = locall.getDuration();
          ae.i(((j)localObject1).TAG, "onVideoLoadedMetaData width=" + i + ", height=" + j + ", duration=" + k);
        }
        try
        {
          localObject2 = ((j)localObject1).boS();
          ((JSONObject)localObject2).put("width", i);
          ((JSONObject)localObject2).put("height", j);
          ((j)localObject1).lDw = (k * 1.0D / 1000.0D);
          ((JSONObject)localObject2).put("duration", ((j)localObject1).lDw);
          ((j)localObject1).dispatchEvent("onVideoLoadedMetaData", (JSONObject)localObject2);
          l = locall.cvj;
          if (l > 0L)
          {
            locall.seek(l);
            locall.cvj = 0L;
          }
          ae.d(locall.getTAG(), "onPrepared, webViewInBackgroun = " + locall.cvu);
          if (!locall.cvu) {
            if ((locall.cvk) || (locall.cvi))
            {
              ae.i(locall.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(locall.cvk), Boolean.valueOf(locall.cvi) });
              locall.vx(true);
              AppMethodBeat.o(199521);
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
            ae.e(((j)localObject1).TAG, "onVideoLoadedMetaData fail", new Object[] { localJSONException });
          }
          ae.i(locall.getTAG(), "onPrepared, not set start play when prepared");
          AppMethodBeat.o(199521);
          return;
        }
      }
      ae.i(locall.getTAG(), "onPrepared, stop video auto play when webview in background");
      if ((locall.cvk) || (locall.cvi)) {}
      for (boolean bool = true;; bool = false)
      {
        locall.csD = new AtomicBoolean(bool);
        AppMethodBeat.o(199521);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199522);
      Object localObject1 = this.EIu;
      if (!((l)localObject1).cvm)
      {
        ae.i(((l)localObject1).getTAG(), "onMediaPlayerSeekComplete, mp released");
        AppMethodBeat.o(199522);
        return;
      }
      Object localObject2 = ((l)localObject1).EIr;
      if (localObject2 != null) {}
      try
      {
        ((j)localObject2).dispatchEvent("onVideoSeekEnd", ((j)localObject2).boS());
        ae.i(((l)localObject1).getTAG(), "onSeekComplete");
        if (((l)localObject1).cvf)
        {
          ae.i(((l)localObject1).getTAG(), "onSeekComplete, start when seek complete");
          ((l)localObject1).cvf = false;
          ((l)localObject1).vx(true);
          AppMethodBeat.o(199522);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e(((j)localObject2).TAG, "onVideoSeedEnd fail", new Object[] { localJSONException });
        }
        localObject2 = ((l)localObject1).cuX;
        if (localObject2 == null) {
          p.gkB();
        }
        boolean bool = ((b)localObject2).isPlaying();
        if (((l)localObject1).cvg)
        {
          localObject2 = ((l)localObject1).cuX;
          if (localObject2 == null) {
            p.gkB();
          }
          long l1 = ((b)localObject2).getDuration();
          localObject2 = ((l)localObject1).cuX;
          if (localObject2 == null) {
            p.gkB();
          }
          long l2 = ((b)localObject2).getCurrentPosition();
          ae.i(((l)localObject1).getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
          ((l)localObject1).cvg = false;
          if (l2 / 1000L < l1 / 1000L)
          {
            ae.i(((l)localObject1).getTAG(), "onSeekComplete, video not end");
            if ((bool) && (((l)localObject1).Gj()))
            {
              ae.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch play again");
              localObject1 = ((l)localObject1).EIr;
              if (localObject1 != null)
              {
                ((j)localObject1).eYY();
                AppMethodBeat.o(199522);
                return;
              }
              AppMethodBeat.o(199522);
            }
          }
          else
          {
            ae.i(((l)localObject1).getTAG(), "onSeekComplete, video ends");
            localObject2 = ((l)localObject1).cuX;
            if (localObject2 == null) {
              p.gkB();
            }
            ((b)localObject2).pause();
            if (((l)localObject1).Gj())
            {
              localObject2 = ((l)localObject1).EIr;
              if (localObject2 != null) {
                ((j)localObject2).eYY();
              }
            }
            localObject1 = ((l)localObject1).cuX;
            if (localObject1 == null) {
              p.gkB();
            }
            ((b)localObject1).start();
            AppMethodBeat.o(199522);
          }
        }
        else
        {
          ae.i(((l)localObject1).getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
          if ((!bool) && (((l)localObject1).Gj()))
          {
            ae.i(((l)localObject1).getTAG(), "onSeekComplete, dispatch pause again");
            localObject1 = ((l)localObject1).EIr;
            if (localObject1 != null)
            {
              ((j)localObject1).eZa();
              AppMethodBeat.o(199522);
              return;
            }
          }
        }
        AppMethodBeat.o(199522);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(199523);
      l locall = this.EIu;
      int i = this.cwz;
      int j = this.cwA;
      if (!locall.cvm)
      {
        ae.i(locall.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
        AppMethodBeat.o(199523);
        return;
      }
      int k = locall.getDuration();
      ae.i(locall.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(locall.cvl) });
      j localj;
      if ((locall.cvl) && (locall.cuX != null) && ((i != locall.mVideoWidth) || (j != locall.mVideoHeight) || (k != locall.cvp)) && (locall.Gj()))
      {
        localj = locall.EIr;
        if (localj != null) {
          ae.i(localj.TAG, "onVideoSizeChange width=" + i + ", height=" + j + ", duration=" + k);
        }
      }
      try
      {
        JSONObject localJSONObject = localj.boS();
        localJSONObject.put("width", i);
        localJSONObject.put("height", j);
        localj.lDw = (k * 1.0D / 1000.0D);
        localJSONObject.put("duration", localj.lDw);
        localj.dispatchEvent("onVideoSizeChange", localJSONObject);
        locall.mVideoWidth = i;
        locall.mVideoHeight = j;
        locall.cvp = k;
        locall.bTJ();
        AppMethodBeat.o(199523);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e(localj.TAG, "onVideoSizeChange fail", new Object[] { localJSONException });
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements d.g.a.a<z>
  {
    y(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l
 * JD-Core Version:    0.7.0.1
 */