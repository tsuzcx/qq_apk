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
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mCurrentPlayingVideoPath", "getMCurrentPlayingVideoPath", "setMCurrentPlayingVideoPath", "(Ljava/lang/String;)V", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "useThumbPlayer", "getUseThumbPlayer", "useThumbPlayer$delegate", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onHitPreload", "hit", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setPlayingWhenEnterBackground", "setSurfaceSize", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class k
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  final d.a NaP;
  String Qwn;
  boolean Qwo;
  WebViewVideoEventHandler Qwp;
  private com.tencent.mm.plugin.appbrand.jsapi.ai.e.g Qwq;
  final l Qwr;
  private int bnv;
  private float bnz;
  com.tencent.luggage.xweb_ext.extendplugin.a cFj;
  a.a cFk;
  int cFl;
  int cFm;
  boolean cFp;
  AtomicBoolean cFz;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cJC;
  boolean cJH;
  boolean cJI;
  boolean cJJ;
  boolean cJK;
  long cJL;
  boolean cJM;
  boolean cJN;
  volatile boolean cJO;
  boolean cJP;
  boolean cJQ;
  int cJR;
  int cJS;
  String cJT;
  String cJU;
  boolean cJV;
  volatile boolean cJW;
  private Handler cJZ;
  e cJz;
  private HandlerThread cKa;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cKb;
  private float cKh;
  private float cKi;
  final com.tencent.mm.model.d kKI;
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  int mVideoHeight;
  int mVideoWidth;
  private int pBl;
  private int pBm;
  private int pBn;
  private int pBo;
  private final kotlin.f pHn;
  private final kotlin.f sKP;
  private boolean sUr;
  private final kotlin.f sUw;
  
  public k()
  {
    AppMethodBeat.i(266314);
    this.pHn = kotlin.g.ar((kotlin.g.a.a)new a(this));
    this.cKa = com.tencent.e.c.d.ik("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    this.cKh = 1.0F;
    this.cKi = 1.0F;
    this.Qwq = new com.tencent.mm.plugin.appbrand.jsapi.ai.e.g();
    this.Qwr = new l();
    Object localObject = com.tencent.mm.model.d.bcs();
    p.j(localObject, "AudioHelperTool.createTool()");
    this.kKI = ((com.tencent.mm.model.d)localObject);
    this.cKa.start();
    localObject = this.cKa;
    p.j(localObject, "mVideoHandlerThread");
    this.cJZ = new Handler(((HandlerThread)localObject).getLooper());
    this.bnv = 800000;
    this.bnz = 0.75F;
    this.pBl = 10000;
    this.pBm = 25000;
    this.pBn = 15000;
    this.pBo = 30000;
    this.NaP = ((d.a)new c());
    this.sKP = kotlin.g.ar((kotlin.g.a.a)k.af.Qwv);
    this.sUw = kotlin.g.ar((kotlin.g.a.a)k.b.Qwt);
    AppMethodBeat.o(266314);
  }
  
  private final void TW()
  {
    try
    {
      AppMethodBeat.i(266288);
      if (this.cJz != null)
      {
        Log.i(getTAG(), "releaseMediaPlayer");
        e locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.a(null);
        }
        locale = this.cJz;
        if (locale != null) {
          locale.stop();
        }
        locale = this.cJz;
        if (locale != null) {
          locale.reset();
        }
        locale = this.cJz;
        if (locale != null) {
          locale.release();
        }
      }
      this.cJz = null;
      this.cJO = false;
      AppMethodBeat.o(266288);
      return;
    }
    finally {}
  }
  
  private final void aF(Bitmap paramBitmap)
  {
    AppMethodBeat.i(266305);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i(getTAG(), "bitmap recycle ".concat(String.valueOf(paramBitmap)));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(266305);
  }
  
  final void C(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(266307);
    parama = parama.SR();
    if (parama != null)
    {
      parama = parama.optJSONObject("playerConfig");
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(266307);
      return;
    }
    this.bnv = parama.optInt("maxInitialBitrate", 0);
    this.bnz = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.pBl = parama.optInt("minDurForQualityMs", 0);
    this.pBm = parama.optInt("maxDurForQualityMs", 0);
    this.pBn = parama.optInt("minBufferMs", 0);
    this.pBo = parama.optInt("maxBufferMs", 0);
    boolean bool1 = bool2;
    if (this.bnv != 0)
    {
      bool1 = bool2;
      if (this.bnz != 0.0F)
      {
        bool1 = bool2;
        if (this.pBl != 0)
        {
          bool1 = bool2;
          if (this.pBm != 0)
          {
            bool1 = bool2;
            if (this.pBn != 0)
            {
              bool1 = bool2;
              if (this.pBo != 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    this.sUr = bool1;
    Log.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.sUr);
    AppMethodBeat.o(266307);
  }
  
  final void D(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(266308);
    E(parama);
    com.tencent.e.h.ZvG.n((Runnable)new d(this, parama), 2000L);
    AppMethodBeat.o(266308);
  }
  
  final boolean Dr(boolean paramBoolean)
  {
    AppMethodBeat.i(266293);
    if ((this.cJW) && (this.Qwo))
    {
      Log.e(getTAG(), "play, background not allow play");
      AppMethodBeat.o(266293);
      return true;
    }
    if (this.cJz != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ab(this));
      if (this.cJN)
      {
        localObject1 = this.cJz;
        if ((localObject1 != null) && (((e)localObject1).isPlaying() == true))
        {
          Log.i(getTAG(), "video play, video is playing");
          if (Tt())
          {
            localObject1 = this.Qwp;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).hbG();
            }
          }
          AppMethodBeat.o(266293);
          return true;
        }
      }
      if (!this.cJN)
      {
        Log.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.cJK = true;
        AppMethodBeat.o(266293);
        return true;
      }
      Object localObject1 = this.cJz;
      if ((localObject1 != null) && (((e)localObject1).getState() == 5))
      {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(266293);
          return false;
        }
        Log.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
        prepareAsync();
        this.cJK = true;
        AppMethodBeat.o(266293);
        return true;
      }
      Object localObject2;
      if (this.cJV)
      {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(266293);
          return false;
        }
        Log.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.cJV = false;
        Object localObject4;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cJN))
          {
            Log.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurfaceTexture;
            if (localObject4 == null) {
              p.iCn();
            }
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label430;
            }
            localObject1 = new t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(266293);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        for (;;)
        {
          hbL();
          if (this.cJz != null)
          {
            this.cJM = true;
            setDataSourceWithCustomKey(this.cJT);
            localObject2 = getTAG();
            localObject3 = this.cJz;
            if (localObject3 == null) {
              p.iCn();
            }
            Log.i((String)localObject2, "video play, media player state:%s", new Object[] { Integer.valueOf(((e)localObject3).getState()) });
            prepareAsync();
            this.cJK = true;
          }
          AppMethodBeat.o(266293);
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
      if (this.cJz != null)
      {
        if (Tt())
        {
          localObject2 = this.Qwp;
          if (localObject2 != null) {
            ((WebViewVideoEventHandler)localObject2).hbG();
          }
        }
        localObject2 = this.cJz;
        if (localObject2 != null) {
          ((e)localObject2).start();
        }
      }
      AppMethodBeat.o(266293);
      return true;
    }
    AppMethodBeat.o(266293);
    return false;
  }
  
  final void E(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(266309);
    if ((!this.cJW) && ((parama.getContext() instanceof MMActivity)))
    {
      parama = parama.getContext();
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(266309);
        throw parama;
      }
      if (((MMActivity)parama).isPaused())
      {
        Log.w(getTAG(), "checkPause, onBackGround");
        hbK();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 0L, 1L, false);
      }
    }
    AppMethodBeat.o(266309);
  }
  
  final boolean TQ()
  {
    AppMethodBeat.i(266275);
    AtomicBoolean localAtomicBoolean = this.cFz;
    if (localAtomicBoolean != null)
    {
      boolean bool = localAtomicBoolean.get();
      AppMethodBeat.o(266275);
      return bool;
    }
    AppMethodBeat.o(266275);
    return false;
  }
  
  final boolean TV()
  {
    AppMethodBeat.i(266298);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ae(this));
    Object localObject = this.cJz;
    if (localObject != null)
    {
      this.Qwr.a(this.cFj, (e)localObject);
      if (!this.cJN)
      {
        Log.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.cJK = false;
        AppMethodBeat.o(266298);
        return true;
      }
      Log.i(getTAG(), "video stop");
      ((e)localObject).stop();
      if (Tt())
      {
        localObject = this.Qwp;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).hbH();
        }
      }
      AppMethodBeat.o(266298);
      return true;
    }
    AppMethodBeat.o(266298);
    return false;
  }
  
  final void TZ()
  {
    AppMethodBeat.i(266289);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.iCn();
      }
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(266289);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(266278);
    k((Runnable)new q(this));
    AppMethodBeat.o(266278);
  }
  
  /* Error */
  final boolean Tt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 809	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/k:cFp	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 602	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/k:Qwp	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
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
    //   0	34	0	this	k
    //   19	7	1	bool	boolean
    //   13	2	2	localWebViewVideoEventHandler	WebViewVideoEventHandler
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  final void Ug()
  {
    AppMethodBeat.i(266313);
    if (this.mSurfaceTexture != null)
    {
      Log.i(getTAG(), "setSurfaceSize, setDefaultBufferSize, width: %d, height: %d", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
      SurfaceTexture localSurfaceTexture = this.mSurfaceTexture;
      if (localSurfaceTexture == null) {
        p.iCn();
      }
      localSurfaceTexture.setDefaultBufferSize(this.cFl, this.cFm);
    }
    AppMethodBeat.o(266313);
  }
  
  public final boolean cBL()
  {
    AppMethodBeat.i(266310);
    boolean bool = ((Boolean)this.sKP.getValue()).booleanValue();
    AppMethodBeat.o(266310);
    return bool;
  }
  
  final void cEF()
  {
    AppMethodBeat.i(266282);
    if (!Util.isNullOrNil(this.cJU))
    {
      if ((this.cJN) && (Uq() != null) && (this.Qwq != null))
      {
        if (this.Qwq.a(this.cJU, this.cFl, this.cFm, this.mVideoWidth, this.mVideoHeight))
        {
          this.cKh = this.Qwq.Uo();
          this.cKi = this.Qwq.Up();
          Log.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cJU, Float.valueOf(this.cKh), Float.valueOf(this.cKi) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(Uq(), getType(), getId(), this.cKh, this.cKi);
          AppMethodBeat.o(266282);
        }
      }
      else
      {
        Log.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(266282);
      }
    }
    else {
      Log.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(266282);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(266277);
    p.k(paramSurfaceTexture, "surfaceTexture");
    k((Runnable)new r(this, paramSurfaceTexture));
    AppMethodBeat.o(266277);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(266276);
    p.k(parama, "invokeContext");
    AppMethodBeat.o(266276);
    return true;
  }
  
  public final boolean getAbTestVideoPreload()
  {
    AppMethodBeat.i(266311);
    boolean bool = ((Boolean)this.sUw.getValue()).booleanValue();
    AppMethodBeat.o(266311);
    return bool;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(266291);
    e locale = this.cJz;
    if (locale != null)
    {
      int i = locale.getCurrentPosition();
      AppMethodBeat.o(266291);
      return i;
    }
    AppMethodBeat.o(266291);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(266292);
    e locale = this.cJz;
    if (locale != null)
    {
      int i = locale.getDuration();
      AppMethodBeat.o(266292);
      return i;
    }
    AppMethodBeat.o(266292);
    return 0;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(266274);
    String str = (String)this.pHn.getValue();
    AppMethodBeat.o(266274);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(266279);
    p.k(parama, "invokeContext");
    k((Runnable)new n(this, parama));
    AppMethodBeat.o(266279);
    return null;
  }
  
  final void hbJ()
  {
    AppMethodBeat.i(266280);
    Log.i(getTAG(), "createMediaPlayer");
    Object localObject1 = this.cJZ;
    long l = System.currentTimeMillis();
    Object localObject2;
    if (cBL())
    {
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = new com.tencent.mm.plugin.appbrand.ae.a.a.d((Context)localObject1);
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.a)localObject1;
      l = System.currentTimeMillis() - l;
      Log.d(getTAG(), "createMediaPlayer  useThumbPlayer:" + cBL() + "  cost %s", new Object[] { Long.valueOf(l) });
      localObject2 = this.Qwr;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 11L, l, false);
      ((l)localObject2).Qww.pOh = l;
      this.cJz = ((e)localObject1);
      if (this.cJz == null) {
        break label263;
      }
    }
    label263:
    for (boolean bool = true;; bool = false)
    {
      this.cJO = bool;
      if (this.cJO) {
        break label268;
      }
      Log.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(266280);
      return;
      if (this.sUr)
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g((Handler)localObject1, this.bnv, this.bnz, this.pBl, this.pBm, this.pBn, this.pBo);
        break;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g((Handler)localObject1);
      break;
    }
    label268:
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.g)new e(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.e)new f(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.h)new g(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.b)new h(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.i)new i(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.j)new j(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.a)new k(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.d)new l(this));
    }
    localObject1 = this.cJz;
    if (localObject1 != null) {
      ((e)localObject1).a((e.f)new m(this));
    }
    localObject1 = this.Qwp;
    if (localObject1 != null)
    {
      Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onStartPlayerReport");
      localObject2 = ((WebViewVideoEventHandler)localObject1).Qwd;
      if ((localObject2 != null) && (!((k)localObject2).cBL()))
      {
        AppMethodBeat.o(266280);
        return;
      }
      try
      {
        ((WebViewVideoEventHandler)localObject1).m("StartPlayer", null);
        AppMethodBeat.o(266280);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onStartPlayerReport fail", new Object[] { localJSONException });
        AppMethodBeat.o(266280);
        return;
      }
    }
    AppMethodBeat.o(266280);
  }
  
  final void hbK()
  {
    AppMethodBeat.i(266285);
    this.cJW = true;
    Log.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(this));
    k((Runnable)new p(this));
    AppMethodBeat.o(266285);
  }
  
  final void hbL()
  {
    AppMethodBeat.i(266287);
    this.cJV = false;
    TW();
    hbJ();
    if (this.cJz != null)
    {
      e locale = this.cJz;
      if (locale != null) {
        locale.setMute(this.cJQ);
      }
      if (this.mSurface != null)
      {
        if (!this.cJW)
        {
          Log.i(getTAG(), "applyMediaPlayerParams, setSurface");
          locale = this.cJz;
          if (locale != null)
          {
            locale.setSurface(this.mSurface);
            AppMethodBeat.o(266287);
            return;
          }
          AppMethodBeat.o(266287);
          return;
        }
        Log.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
      }
    }
    AppMethodBeat.o(266287);
  }
  
  final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(266290);
    if (p.h(this.cJZ.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(266290);
      return true;
      this.cJZ.post(paramRunnable);
    }
  }
  
  final boolean lM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266281);
    if (!this.cJO)
    {
      Log.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(266281);
      return false;
    }
    Log.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    boolean bool;
    if (paramInt1 == 701)
    {
      localObject1 = this.cJz;
      if ((localObject1 != null) && (((e)localObject1).isPlaying() == true))
      {
        bool = true;
        this.cJJ = bool;
        Log.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.cJJ) });
        if (Tt())
        {
          localObject1 = this.Qwp;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).onVideoWaiting();
          }
        }
        localObject1 = this.Qwp;
        Object localObject2;
        if (localObject1 != null)
        {
          Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingBufferReadyReport");
          localObject2 = ((WebViewVideoEventHandler)localObject1).Qwd;
          if ((localObject2 == null) || (((k)localObject2).cBL())) {
            break label313;
          }
        }
        label184:
        localObject1 = this.Qwr;
        if (((l)localObject1).Qww.pOo <= 0L)
        {
          localObject2 = ((l)localObject1).Qww;
          ((l.b)localObject2).pOm += 1;
          ((l)localObject1).Qww.pOo = Util.nowMilliSecond();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 30L, 1L, false);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = this.cJz;
        if ((localObject1 != null) && (((e)localObject1).isPlaying() == true) && (this.cJW) && (this.Qwo))
        {
          this.cFz = new AtomicBoolean(true);
          pause();
        }
        AppMethodBeat.o(266281);
        return false;
        bool = false;
        break;
        try
        {
          label313:
          WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingBufferReady");
        }
        catch (JSONException localJSONException)
        {
          Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingBufferReadyReport fail", new Object[] { localJSONException });
        }
      }
      break label184;
      if (paramInt1 == 702)
      {
        localObject1 = this.cJz;
        if ((localObject1 != null) && (((e)localObject1).isPlaying() == true))
        {
          bool = true;
          label380:
          Log.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.cJJ), Boolean.valueOf(bool) });
          if (!this.cJJ) {
            break label635;
          }
          this.cJJ = false;
          if ((bool) && (Tt()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject1 = this.Qwp;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).hbG();
            }
            localObject1 = this.Qwp;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).hbI();
            }
          }
        }
        for (;;)
        {
          localObject1 = this.Qwr;
          if ((((l)localObject1).Qww.pOp <= 0L) && (((l)localObject1).Qww.pOo > 0L))
          {
            ((l)localObject1).Qww.pOp = Util.nowMilliSecond();
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 31L, 1L, false);
            long l = ((l)localObject1).Qww.pOp - ((l)localObject1).Qww.pOo;
            l.b localb = ((l)localObject1).Qww;
            localb.pOn += l;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 32L, l, false);
            Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject1 = ((l)localObject1).Qww;
          ((l.b)localObject1).pOo = 0L;
          ((l.b)localObject1).pOp = 0L;
          break;
          bool = false;
          break label380;
          label635:
          if ((!bool) && (Tt()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject1 = this.Qwp;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).hbH();
            }
            localObject1 = this.Qwp;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).hbI();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        Log.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject1 = this.cJC;
        if (localObject1 != null) {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject1).cv(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.cJO) {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        } else {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame");
        }
      }
    }
  }
  
  public final void n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(266303);
    super.n(paramBitmap);
    com.tencent.luggage.xweb_ext.extendplugin.a locala = this.cKb;
    if (locala == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(266303);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.er("fail");
      AppMethodBeat.o(266303);
      return;
    }
    if ((this.cFl != 0) && (this.cFm != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cKh * this.cFl), (int)(this.cKi * this.cFm), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      p.j(localObject1, "Base64.encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      p.j(localObject2, "StandardCharsets.UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      Log.i(getTAG(), "handlePluginScreenshotTaken size=" + ((String)localObject1).length());
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.e("ok", (Map)localObject2);
      aF(paramBitmap);
      aF(localBitmap);
      this.cKb = null;
      AppMethodBeat.o(266303);
      return;
    }
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(266295);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new aa(this));
    if (this.cJz != null)
    {
      if (!this.cJN)
      {
        Log.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.cJK = false;
        AppMethodBeat.o(266295);
        return true;
      }
      Object localObject = this.cJz;
      if ((localObject == null) || (((e)localObject).isPlaying() != true))
      {
        Log.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(266295);
        return true;
      }
      Log.i(getTAG(), "video pause");
      localObject = this.cJz;
      if (localObject != null) {
        ((e)localObject).pause();
      }
      if (Tt())
      {
        localObject = this.Qwp;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).hbH();
        }
      }
      AppMethodBeat.o(266295);
      return true;
    }
    AppMethodBeat.o(266295);
    return false;
  }
  
  final void prepareAsync()
  {
    AppMethodBeat.i(266283);
    Object localObject;
    if (this.cJz != null)
    {
      Log.i(getTAG(), "video prepare async");
      if (Tt())
      {
        localObject = this.Qwp;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).onVideoWaiting();
        }
      }
      localObject = this.Qwp;
      if (localObject != null)
      {
        Log.i(((WebViewVideoEventHandler)localObject).TAG, "onStartDownloadReport");
        k localk = ((WebViewVideoEventHandler)localObject).Qwd;
        if ((localk == null) || (localk.cBL())) {
          break label151;
        }
      }
    }
    for (;;)
    {
      this.cJN = false;
      this.cJK = false;
      localObject = this.cJz;
      if (localObject != null) {
        ((e)localObject).prepareAsync();
      }
      localObject = this.Qwr;
      if (((l)localObject).Qww.pOj <= 0L)
      {
        ((l)localObject).Qww.pOj = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 20L, 1L, false);
      }
      AppMethodBeat.o(266283);
      return;
      try
      {
        label151:
        ((WebViewVideoEventHandler)localObject).m("StartDownload", null);
      }
      catch (JSONException localJSONException)
      {
        Log.e(((WebViewVideoEventHandler)localObject).TAG, "onStartDownloadReport fail", new Object[] { localJSONException });
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(266286);
    Log.i(getTAG(), "video release");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ad(this));
    WebViewVideoEventHandler localWebViewVideoEventHandler;
    Object localObject1;
    if ((this.Qwp instanceof WebViewVideoEventHandler))
    {
      localWebViewVideoEventHandler = this.Qwp;
      if (localWebViewVideoEventHandler == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
        AppMethodBeat.o(266286);
        throw ((Throwable)localObject1);
      }
      localObject1 = localWebViewVideoEventHandler.Qwc;
      if (localObject1 == null) {
        break label285;
      }
      localObject1 = ((f)localObject1).QvF;
      if (localObject1 == null) {
        break label285;
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
        ((c)localObject1).b(localWebViewVideoEventHandler.Qwh);
      }
      localObject1 = localWebViewVideoEventHandler.Qfg;
      if (localObject1 != null) {
        ((com.tencent.mm.br.a)localObject1).disable();
      }
      if (localWebViewVideoEventHandler.Qwi != null) {}
      try
      {
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getContentResolver();
        localObject2 = localWebViewVideoEventHandler.Qwi;
        if (localObject2 == null) {
          p.iCn();
        }
        ((ContentResolver)localObject1).unregisterContentObserver((ContentObserver)localObject2);
        if (localWebViewVideoEventHandler.Qwj == null) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          MMApplicationContext.getContext().unregisterReceiver(localWebViewVideoEventHandler.Qwj);
          TV();
          TW();
          localObject1 = this.Qwp;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).bWh();
          }
          this.Qwp = null;
          if (this.cJC != null) {
            this.cJC = null;
          }
          TZ();
          Log.i(getTAG(), "video release handler thread");
          this.cJZ.removeCallbacksAndMessages(null);
          this.cKa.quitSafely();
          localObject1 = this.Qwp;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).hbF();
          }
          this.cFj = null;
          AppMethodBeat.o(266286);
          return;
          label285:
          localObject1 = null;
          continue;
          localThrowable1 = localThrowable1;
          Log.printErrStackTrace(localWebViewVideoEventHandler.TAG, localThrowable1, "unregisterContentObserver", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            Log.printErrStackTrace(localWebViewVideoEventHandler.TAG, localThrowable2, "unregisterContentObserver", new Object[0]);
          }
        }
      }
    }
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(266300);
    if ((this.cJN) && (this.cJz != null))
    {
      Object localObject;
      if (Tt())
      {
        localObject = this.Qwp;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).onVideoWaiting();
        }
      }
      if (this.cJz != null)
      {
        localObject = this.cJz;
        if (localObject != null) {}
        for (boolean bool = ((e)localObject).isPlaying();; bool = false)
        {
          this.cJI = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          Log.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cJI) });
          localObject = this.cJz;
          if (localObject == null) {
            break;
          }
          ((e)localObject).seekTo(paramLong);
          AppMethodBeat.o(266300);
          return;
        }
        AppMethodBeat.o(266300);
      }
    }
    else
    {
      this.cJL = paramLong;
    }
    AppMethodBeat.o(266300);
  }
  
  final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(266312);
    this.Qwn = paramString;
    Object localObject;
    if ((!cBL()) && (getAbTestVideoPreload()))
    {
      String str = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().aiO(paramString);
      e locale = this.cJz;
      localObject = locale;
      if (!(locale instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject).eg(paramString, str);
      }
    }
    for (;;)
    {
      localObject = this.Qwp;
      if (localObject == null) {
        break;
      }
      ((WebViewVideoEventHandler)localObject).bf(com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().f(paramString, 0L, 9223372036854775807L));
      AppMethodBeat.o(266312);
      return;
      localObject = this.cJz;
      if (localObject != null) {
        ((e)localObject).setDataSource(paramString);
      }
    }
    AppMethodBeat.o(266312);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<String>
  {
    a(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<x>
  {
    aa(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<x>
  {
    ab(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
  public static final class ac
    implements a.a
  {
    public final void iW(int paramInt)
    {
      AppMethodBeat.i(222938);
      if (1 == paramInt)
      {
        Object localObject2 = this.Qws.cFj;
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof f)) {
          localObject1 = null;
        }
        localObject1 = (f)localObject1;
        if (localObject1 != null)
        {
          localObject1 = ((f)localObject1).QvF;
          if (localObject1 != null)
          {
            localObject2 = MMApplicationContext.getContext();
            p.j(localObject2, "MMApplicationContext.getContext()");
            ((com.tencent.mm.plugin.webview.d.f)localObject1).setContext((Context)localObject2);
          }
        }
        localObject1 = this.Qws.Qwp;
        if (localObject1 != null)
        {
          ((WebViewVideoEventHandler)localObject1).hbF();
          AppMethodBeat.o(222938);
          return;
        }
        AppMethodBeat.o(222938);
        return;
      }
      this.Qws.hbK();
      AppMethodBeat.o(222938);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(222939);
      this.Qws.release();
      AppMethodBeat.o(222939);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(222934);
      k localk = this.Qws;
      localk.cJW = false;
      Log.d(localk.getTAG(), "handleWebViewForeground");
      boolean bool = localk.TQ();
      localk.cFz = null;
      if ((localk.cJz != null) && (localk.cJN) && (bool))
      {
        Log.i(localk.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
        localk.Dr(false);
      }
      AppMethodBeat.o(222934);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<x>
  {
    ad(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<x>
  {
    ae(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
  public static final class c
    implements d.a
  {
    public final void bcu() {}
    
    public final void bcv() {}
    
    public final void bcw() {}
    
    public final void bcx() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(233960);
      this.Qws.E(parama);
      AppMethodBeat.o(233960);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class e
    implements e.g
  {
    e(k paramk) {}
    
    public final boolean ct(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(223354);
      k localk = this.Qws;
      boolean bool = localk.k((Runnable)new k.w(localk, paramInt1, paramInt2));
      AppMethodBeat.o(223354);
      return bool;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class f
    implements e.e
  {
    f(k paramk) {}
    
    public final boolean cu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217656);
      k localk = this.Qws;
      boolean bool = localk.k((Runnable)new k.v(localk, paramInt1, paramInt2));
      AppMethodBeat.o(217656);
      return bool;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class g
    implements e.h
  {
    g(k paramk) {}
    
    public final void a(e parame)
    {
      AppMethodBeat.i(245675);
      parame = this.Qws;
      parame.k((Runnable)new k.x(parame));
      AppMethodBeat.o(245675);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class h
    implements e.b
  {
    h(k paramk) {}
    
    public final void Uh()
    {
      AppMethodBeat.i(215778);
      k localk = this.Qws;
      localk.k((Runnable)new k.u(localk));
      AppMethodBeat.o(215778);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class i
    implements e.i
  {
    i(k paramk) {}
    
    public final void b(e parame)
    {
      AppMethodBeat.i(259433);
      parame = this.Qws;
      parame.k((Runnable)new k.y(parame));
      AppMethodBeat.o(259433);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class j
    implements e.j
  {
    j(k paramk) {}
    
    public final void a(e parame, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(224509);
      parame = this.Qws;
      parame.k((Runnable)new k.z(parame, paramInt1, paramInt2));
      AppMethodBeat.o(224509);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class k
    implements e.a
  {
    k(k paramk) {}
    
    public final void jg(int paramInt)
    {
      AppMethodBeat.i(217134);
      k localk = this.Qws;
      localk.k((Runnable)new k.t(localk, paramInt));
      AppMethodBeat.o(217134);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "selectIndex", "", "kotlin.jvm.PlatformType", "onDownstreamChanged"})
  static final class l
    implements e.d
  {
    l(k paramk) {}
    
    public final void ajo(String paramString)
    {
      AppMethodBeat.i(243549);
      WebViewVideoEventHandler localWebViewVideoEventHandler = this.Qws.Qwp;
      if (localWebViewVideoEventHandler != null) {}
      for (;;)
      {
        try
        {
          Object localObject = localWebViewVideoEventHandler.TAG;
          StringBuilder localStringBuilder = new StringBuilder("[TRACE_ADAPTIVE] onVideoDownStreamChange selectIndex = ");
          if (paramString != null) {
            break label123;
          }
          str = "null";
          Log.i((String)localObject, str);
          localObject = localWebViewVideoEventHandler.bWg();
          str = paramString;
          if (paramString == null) {
            str = "";
          }
          ((JSONObject)localObject).put("selectIndex", str);
          localWebViewVideoEventHandler.dispatchEvent("onVideoDownStreamChange", (JSONObject)localObject);
          AppMethodBeat.o(243549);
          return;
        }
        catch (JSONException paramString)
        {
          Log.e(localWebViewVideoEventHandler.TAG, "onVideoDownStreamChange fail", new Object[] { paramString });
          AppMethodBeat.o(243549);
          return;
        }
        AppMethodBeat.o(243549);
        return;
        label123:
        String str = paramString;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "hit", "", "kotlin.jvm.PlatformType", "onHitPreload", "(Ljava/lang/Boolean;)V"})
  static final class m
    implements e.f
  {
    m(k paramk) {}
    
    public final void k(Boolean paramBoolean)
    {
      AppMethodBeat.i(220612);
      k localk = this.Qws;
      p.j(paramBoolean, "hit");
      boolean bool = paramBoolean.booleanValue();
      paramBoolean = localk.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("onHitPreload:").append(bool).append("  fileId:");
      com.tencent.mm.plugin.appbrand.ae.a.a.c localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.appbrand.ae.a.a.c.anp(localk.Qwn)).append("   preloadSize:");
      localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      Log.i(paramBoolean, com.tencent.mm.plugin.appbrand.ae.a.a.c.blh(localk.Qwn));
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 54L, 1L, false);
        AppMethodBeat.o(220612);
        return;
      }
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 55L, 1L, false);
      }
      for (;;)
      {
        paramBoolean = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
        if (com.tencent.mm.plugin.appbrand.ae.a.a.c.blh(localk.Qwn) <= 0L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 57L, 1L, false);
        AppMethodBeat.o(220612);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 56L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 58L, 1L, false);
      AppMethodBeat.o(220612);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(k paramk, com.tencent.luggage.xweb_ext.extendplugin.a parama) {}
    
    public final void run()
    {
      boolean bool2 = false;
      int i = 0;
      boolean bool1 = true;
      int k = 1;
      AppMethodBeat.i(217464);
      Object localObject1 = parama.SS();
      if (Util.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(217464);
        return;
      }
      Object localObject2 = parama.SR();
      Log.i(this.Qws.getTAG(), "handler(%s) handleJsApi(%s), data:%s", new Object[] { this.Qws.key(), localObject1, ((JSONObject)localObject2).toString() });
      if ((p.h("handleVideoAction", localObject1) ^ true))
      {
        Log.e(this.Qws.getTAG(), "handler(%s), not right jsapi:(%s)", new Object[] { this.Qws.key(), localObject1 });
        AppMethodBeat.o(217464);
        return;
      }
      localObject1 = ((JSONObject)localObject2).optString("action", "");
      if (localObject1 == null)
      {
        AppMethodBeat.o(217464);
        return;
      }
      Object localObject3;
      WebViewVideoEventHandler localWebViewVideoEventHandler;
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
            AppMethodBeat.o(217464);
            return;
            if (((String)localObject1).equals("operateSameLayerVideo"))
            {
              localObject1 = this.Qws;
              localObject2 = parama;
              if (((k)localObject1).cJz != null) {
                break;
              }
              Log.w(((k)localObject1).getTAG(), "operate, media player is null");
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).er("fail");
              AppMethodBeat.o(217464);
              return;
              if (((String)localObject1).equals("removeSameLayerVideo"))
              {
                localObject1 = this.Qws;
                localObject2 = parama;
                ((k)localObject1).release();
                if ((((k)localObject1).cFj != null) && (((k)localObject1).cFk != null))
                {
                  localObject3 = ((k)localObject1).cFj;
                  if (localObject3 == null) {
                    p.iCn();
                  }
                  ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).b(((k)localObject1).cFk);
                  ((k)localObject1).cFk = null;
                }
                ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).er("ok");
              }
            }
          }
        } while (!((String)localObject1).equals("insertSameLayerVideo"));
        localObject2 = this.Qws;
        localObject3 = parama;
        ((k)localObject2).cFj = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        ((k)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        localObject1 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).SR();
        ((k)localObject2).cFp = ((JSONObject)localObject1).optBoolean("needEvent", true);
        if ((((k)localObject2).cFp) && (((k)localObject2).Qwp != null))
        {
          localObject4 = ((k)localObject2).Qwp;
          if (localObject4 != null) {
            ((WebViewVideoEventHandler)localObject4).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject4 = ((JSONObject)localObject1).optString("data", "");
          localWebViewVideoEventHandler = ((k)localObject2).Qwp;
          if (localWebViewVideoEventHandler != null) {
            localWebViewVideoEventHandler.ew((String)localObject4);
          }
        }
        if (((k)localObject2).cJz == null)
        {
          Log.w(((k)localObject2).getTAG(), "insert, media player is null");
          ((k)localObject2).hbJ();
        }
        if (((k)localObject2).cFk == null)
        {
          ((k)localObject2).cFk = ((a.a)new k.ac((k)localObject2));
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).a(((k)localObject2).cFk);
        }
        if (((k)localObject2).mSurface != null)
        {
          Log.i(((k)localObject2).getTAG(), "insert, setSurface");
          localObject4 = ((k)localObject2).cJz;
          if (localObject4 != null) {
            ((e)localObject4).setSurface(((k)localObject2).mSurface);
          }
        }
        ((k)localObject2).cJM = ((JSONObject)localObject1).optBoolean("autoplay", false);
        ((k)localObject2).cJL = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
        ((k)localObject2).cJP = ((JSONObject)localObject1).optBoolean("loop", false);
        ((k)localObject2).cJQ = ((JSONObject)localObject1).optBoolean("muted", false);
        if (com.tencent.mm.q.a.aAo()) {
          ((k)localObject2).cJQ = true;
        }
        localObject4 = ((k)localObject2).cJz;
        if (localObject4 != null) {
          ((e)localObject4).setMute(((k)localObject2).cJQ);
        }
        ((k)localObject2).Qwo = ((JSONObject)localObject1).optBoolean("autoPauseOnBackground", true);
        if (((JSONObject)localObject1).has("position"))
        {
          localObject4 = ((JSONObject)localObject1).optJSONObject("position");
          if (localObject4 != null)
          {
            ((k)localObject2).cFl = com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONObject)localObject4).optInt("width", 0));
            ((k)localObject2).cFm = com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONObject)localObject4).optInt("height", 0));
            Log.i(((k)localObject2).getTAG(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(((k)localObject2).cFl), Integer.valueOf(((k)localObject2).cFm) });
            ((k)localObject2).Ug();
          }
        }
        ((k)localObject2).cJU = ((JSONObject)localObject1).optString("objectFit", "contain");
        if (Util.isNullOrNil(((k)localObject2).cJU)) {
          ((k)localObject2).cJU = "contain";
        }
        ((k)localObject2).cEF();
        ((k)localObject2).cJT = ((JSONObject)localObject1).optString("filePath");
        if (!Util.isNullOrNil(((k)localObject2).cJT))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn();
          p.j(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.i)localObject1).bVp()) {
            break label1048;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn();
          p.j(localObject1, "VideoCore.getInstance()");
          if (!((com.tencent.mm.plugin.appbrand.jsapi.video.i)localObject1).bVo()) {
            break label1048;
          }
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().aQ(((k)localObject2).cJT);
          label909:
          Log.i(((k)localObject2).getTAG(), "insert, path:%s, proxy=%s", new Object[] { ((k)localObject2).cJT, localObject1 });
          if (Util.isNullOrNil((String)localObject1)) {
            break label1054;
          }
          ((k)localObject2).setDataSourceWithCustomKey((String)localObject1);
          ((k)localObject2).Qwr.bnj((String)localObject1);
        }
        break;
      }
      for (;;)
      {
        ((k)localObject2).prepareAsync();
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).er("ok");
        ((k)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
        AppMethodBeat.o(217464);
        return;
        if (!((String)localObject1).equals("updateSameLayerVideo")) {
          break;
        }
        localObject2 = this.Qws;
        localObject3 = parama;
        if (((k)localObject2).cJz != null) {
          break label1080;
        }
        Log.w(((k)localObject2).getTAG(), "update, media player is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).er("fail");
        AppMethodBeat.o(217464);
        return;
        label1048:
        localObject1 = null;
        break label909;
        label1054:
        ((k)localObject2).setDataSourceWithCustomKey(((k)localObject2).cJT);
        ((k)localObject2).Qwr.bnj(((k)localObject2).cJT);
      }
      label1080:
      ((k)localObject2).C((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
      Object localObject4 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).SR();
      if (((JSONObject)localObject4).optBoolean("switchResolution", false))
      {
        ((k)localObject2).cJL = ((k)localObject2).getCurrentPosition();
        if (!((JSONObject)localObject4).has("filePath")) {
          break label2431;
        }
        localObject1 = ((JSONObject)localObject4).optString("filePath");
        if ((Util.isNullOrNil((String)localObject1)) || (n.L((String)localObject1, ((k)localObject2).cJT, true))) {
          break label2431;
        }
        ((k)localObject2).cJT = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn();
        p.j(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.i)localObject1).bVp()) {
          break label1841;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn();
        p.j(localObject1, "VideoCore.getInstance()");
        if (!((com.tencent.mm.plugin.appbrand.jsapi.video.i)localObject1).bVo()) {
          break label1841;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().aQ(((k)localObject2).cJT);
        label1224:
        Log.i(((k)localObject2).getTAG(), "update, path:%s, proxy:%s", new Object[] { ((k)localObject2).cJT, localObject1 });
        if (!Util.isNullOrNil(((k)localObject2).cJT))
        {
          ((k)localObject2).TV();
          ((k)localObject2).hbL();
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label1847;
        }
        ((k)localObject2).setDataSourceWithCustomKey((String)localObject1);
        ((k)localObject2).Qwr.bnj((String)localObject1);
      }
      label1299:
      label1361:
      label2006:
      label2421:
      label2431:
      for (int j = 1;; j = 0)
      {
        if ((((k)localObject2).mSurface != null) && (((k)localObject2).cJz != null))
        {
          if (((k)localObject2).cJW) {
            break label1873;
          }
          Log.i(((k)localObject2).getTAG(), "update, setSurface");
          localObject1 = ((k)localObject2).cJz;
          if (localObject1 != null) {
            ((e)localObject1).setSurface(((k)localObject2).mSurface);
          }
        }
        if (((JSONObject)localObject4).has("autoplay")) {
          ((k)localObject2).cJM = ((JSONObject)localObject4).optBoolean("autoplay", ((k)localObject2).cJM);
        }
        if (((JSONObject)localObject4).has("loop")) {
          ((k)localObject2).cJP = ((JSONObject)localObject4).optBoolean("loop", ((k)localObject2).cJP);
        }
        if (((JSONObject)localObject4).has("muted"))
        {
          ((k)localObject2).cJQ = ((JSONObject)localObject4).optBoolean("muted", ((k)localObject2).cJQ);
          if (com.tencent.mm.q.a.aAo()) {
            ((k)localObject2).cJQ = true;
          }
          localObject1 = ((k)localObject2).cJz;
          if (localObject1 != null) {
            ((e)localObject1).setMute(((k)localObject2).cJQ);
          }
        }
        ((k)localObject2).Qwo = ((JSONObject)localObject4).optBoolean("autoPauseOnBackground", true);
        if (((JSONObject)localObject4).has("needEvent")) {
          ((k)localObject2).cFp = ((JSONObject)localObject4).optBoolean("needEvent", ((k)localObject2).cFp);
        }
        if ((((k)localObject2).cFp) && (((k)localObject2).Qwp != null))
        {
          localObject1 = ((k)localObject2).Qwp;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          }
          localObject1 = ((JSONObject)localObject4).optString("data", "");
          if (((JSONObject)localObject4).has("data"))
          {
            localWebViewVideoEventHandler = ((k)localObject2).Qwp;
            if (localWebViewVideoEventHandler != null) {
              localWebViewVideoEventHandler.ew((String)localObject1);
            }
          }
        }
        if (((JSONObject)localObject4).has("position"))
        {
          localObject1 = ((JSONObject)localObject4).optJSONObject("position");
          if (localObject1 != null)
          {
            ((k)localObject2).cFl = com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONObject)localObject1).optInt("width", ((k)localObject2).cFl));
            ((k)localObject2).cFm = com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONObject)localObject1).optInt("height", ((k)localObject2).cFm));
            Log.i(((k)localObject2).getTAG(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(((k)localObject2).cFl), Integer.valueOf(((k)localObject2).cFm) });
            ((k)localObject2).Ug();
          }
          i = 1;
        }
        if (((JSONObject)localObject4).has("objectFit"))
        {
          ((k)localObject2).cJU = ((JSONObject)localObject4).optString("objectFit", ((k)localObject2).cJU);
          i = k;
          if (Util.isNullOrNil(((k)localObject2).cJU))
          {
            ((k)localObject2).cJU = "contain";
            i = k;
          }
        }
        for (;;)
        {
          if (i != 0) {
            ((k)localObject2).cEF();
          }
          if (j != 0)
          {
            Log.i(((k)localObject2).getTAG(), "update, media player prepare async");
            ((k)localObject2).prepareAsync();
          }
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3).er("ok");
          ((k)localObject2).D((com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          AppMethodBeat.o(217464);
          return;
          if (!((JSONObject)localObject4).has("initialTime")) {
            break;
          }
          ((k)localObject2).cJL = ((((JSONObject)localObject4).optDouble("initialTime", 0.0D) * 1000.0D));
          break;
          localObject1 = null;
          break label1224;
          ((k)localObject2).setDataSourceWithCustomKey(((k)localObject2).cJT);
          ((k)localObject2).Qwr.bnj(((k)localObject2).cJT);
          break label1299;
          Log.i(((k)localObject2).getTAG(), "update, setSurface, WebViewInBackground");
          break label1361;
          if (((k)localObject1).cFp)
          {
            localObject3 = ((k)localObject1).Qwp;
            if (localObject3 != null) {
              ((WebViewVideoEventHandler)localObject3).m((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
            }
          }
          localObject3 = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).SR();
          localObject4 = ((JSONObject)localObject3).optString("type");
          if (!Util.isNullOrNil((String)localObject4))
          {
            Log.i(((k)localObject1).getTAG(), "operate, type:%s", new Object[] { localObject4 });
            if (!n.L((String)localObject4, "play", true)) {
              break label2006;
            }
            bool1 = ((k)localObject1).Dr(true);
            if (!bool1) {
              break label2421;
            }
          }
          for (localObject1 = "ok";; localObject1 = "fail")
          {
            ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).er((String)localObject1);
            AppMethodBeat.o(217464);
            return;
            if (n.L((String)localObject4, "pause", true))
            {
              bool1 = ((k)localObject1).pause();
              break;
            }
            if (n.L((String)localObject4, "stop", true))
            {
              bool1 = ((k)localObject1).TV();
              break;
            }
            double d;
            if (n.L((String)localObject4, "seek", true))
            {
              if ((((k)localObject1).cJz != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
              {
                localObject3 = ((JSONObject)localObject3).optJSONArray("data");
                if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0)) {
                  Log.w(((k)localObject1).getTAG(), "seek, data array is null");
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
                  Log.w(((k)localObject1).getTAG(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                  break label2118;
                }
                ((k)localObject1).seek((d * 1000.0D));
              }
            }
            if (n.L((String)localObject4, "playbackRate", true))
            {
              bool1 = bool2;
              if (((k)localObject1).cJz == null) {
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
                Log.w(((k)localObject1).getTAG(), "speed, data array is null");
                bool1 = bool2;
                break;
              }
              d = ((JSONArray)localObject3).optDouble(0, -1.0D);
              if (d < 0.0D)
              {
                Log.w(((k)localObject1).getTAG(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                bool1 = bool2;
                break;
              }
              Log.i(((k)localObject1).getTAG(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
              localObject1 = ((k)localObject1).cJz;
              bool1 = bool2;
              if (localObject1 == null) {
                break;
              }
              bool1 = ((e)localObject1).aP((float)d);
              break;
            }
            bool1 = bool2;
            if (!n.L((String)localObject4, "snapshot", true)) {
              break;
            }
            ((k)localObject1).cKb = ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
            Log.i(((k)localObject1).getTAG(), "takeVideoSnapshot");
            com.tencent.luggage.xweb_ext.extendplugin.d.a(((k)localObject1).Uq(), ((k)localObject1).getType(), ((k)localObject1).getId());
            AppMethodBeat.o(217464);
            return;
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(266735);
      if (this.Qws.Qwo)
      {
        if ((this.Qws.cJz != null) && (this.Qws.cJN) && (this.Qws.cFz == null))
        {
          e locale = this.Qws.cJz;
          if ((locale != null) && (locale.isPlaying() == true)) {}
          for (boolean bool = true;; bool = false)
          {
            this.Qws.cFz = new AtomicBoolean(bool);
            Log.i(this.Qws.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
            this.Qws.pause();
            AppMethodBeat.o(266735);
            return;
          }
        }
      }
      else
      {
        if (this.Qws.TQ())
        {
          Log.i(this.Qws.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { this.Qws.type });
          this.Qws.Dr(true);
          AppMethodBeat.o(266735);
          return;
        }
        Log.i(this.Qws.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { this.Qws.type });
      }
      AppMethodBeat.o(266735);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(216233);
      k.a(this.Qws);
      Log.i(this.Qws.getTAG(), "handler(%s) handlePluginDestroy", new Object[] { this.Qws.key() });
      this.Qws.TV();
      this.Qws.TZ();
      AppMethodBeat.o(216233);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(k paramk, SurfaceTexture paramSurfaceTexture) {}
    
    public final void run()
    {
      AppMethodBeat.i(228123);
      Log.i(this.Qws.getTAG(), "handler(%s) handlePluginReady", new Object[] { this.Qws.key() });
      Object localObject = this.Qws;
      ((k)localObject).cJH = false;
      ((k)localObject).cJI = false;
      ((k)localObject).cJJ = false;
      ((k)localObject).cJK = false;
      this.Qws.mSurfaceTexture = paramSurfaceTexture;
      this.Qws.Ug();
      this.Qws.mSurface = new Surface(paramSurfaceTexture);
      if (this.Qws.cJz != null)
      {
        Log.i(this.Qws.getTAG(), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
        try
        {
          localObject = this.Qws.cJz;
          if (localObject != null)
          {
            ((e)localObject).setSurface(this.Qws.mSurface);
            AppMethodBeat.o(228123);
            return;
          }
          AppMethodBeat.o(228123);
          return;
        }
        catch (Exception localException)
        {
          Log.e(this.Qws.getTAG(), "handlePluginReady, setSurface:ex " + localException.getMessage());
        }
      }
      AppMethodBeat.o(228123);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
  static final class s
    implements c.a
  {
    s(k paramk) {}
    
    public final void i(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220579);
      Log.w(this.Qws.getTAG(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Object localObject1;
      if (this.Qws.Tt())
      {
        localObject1 = this.Qws.Qwp;
        if (localObject1 != null)
        {
          ((WebViewVideoEventHandler)localObject1).bWh();
          ((WebViewVideoEventHandler)localObject1).bYB();
        }
      }
      try
      {
        JSONObject localJSONObject = ((WebViewVideoEventHandler)localObject1).bWg();
        Object localObject2 = af.aaBG;
        localObject2 = Locale.US;
        p.j(localObject2, "Locale.US");
        localObject2 = String.format((Locale)localObject2, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
        p.j(localObject2, "java.lang.String.format(locale, format, *args)");
        localJSONObject.put("errMsg", localObject2);
        ((WebViewVideoEventHandler)localObject1).dispatchEvent("onVideoError", localJSONObject);
        localObject1 = this.Qws.Qwr;
        p.j(paramString, "msg");
        p.k(paramString, "msg");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 40L, 1L, false);
        Log.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if (!Util.isNullOrNil(paramString))
        {
          if (n.L(paramString, "MEDIA_ERR_NETWORK", true)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 41L, 1L, false);
          }
        }
        else
        {
          ((l)localObject1).Qww.pOs = paramInt1;
          ((l)localObject1).Qww.pOt = paramInt2;
          localObject1 = ((l)localObject1).Qww;
          p.k(paramString, "<set-?>");
          ((l.b)localObject1).errorMsg = paramString;
          this.Qws.TV();
          AppMethodBeat.o(220579);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((WebViewVideoEventHandler)localObject1).TAG, "OnXWebVideoError fail", new Object[] { localJSONException });
          continue;
          if (n.L(paramString, "MEDIA_ERR_DECODE", true)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 42L, 1L, false);
          } else if (n.L(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 43L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 44L, 1L, false);
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(k paramk, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(216683);
      Object localObject = this.Qws;
      int i = this.Qwu;
      if (!((k)localObject).cJO)
      {
        Log.i(((k)localObject).getTAG(), "onMediaPlayerBufferingUpdate, mp released");
        AppMethodBeat.o(216683);
        return;
      }
      if (i != ((k)localObject).cJS)
      {
        ((k)localObject).cJS = i;
        Log.i(((k)localObject).getTAG(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(i) });
      }
      if ((((k)localObject).Tt()) && (((k)localObject).cJN))
      {
        localObject = ((k)localObject).Qwp;
        if (localObject != null) {
          try
          {
            JSONObject localJSONObject = ((WebViewVideoEventHandler)localObject).bWg();
            localJSONObject.put("buffered", i);
            ((WebViewVideoEventHandler)localObject).dispatchEvent("onVideoBufferUpdate", localJSONObject);
            AppMethodBeat.o(216683);
            return;
          }
          catch (JSONException localJSONException)
          {
            Log.e(((WebViewVideoEventHandler)localObject).TAG, "OnXWebVideoProgress fail", new Object[] { localJSONException });
            AppMethodBeat.o(216683);
            return;
          }
        }
      }
      AppMethodBeat.o(216683);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(226692);
      k localk = this.Qws;
      if (!localk.cJO)
      {
        Log.i(localk.getTAG(), "onMediaPlayerCompletion, mp released");
        AppMethodBeat.o(226692);
        return;
      }
      Log.i(localk.getTAG(), "onCompletion");
      Object localObject;
      if (localk.Tt())
      {
        localObject = localk.Qwp;
        if (localObject == null) {}
      }
      try
      {
        ((WebViewVideoEventHandler)localObject).dispatchEvent("onVideoEnded", ((WebViewVideoEventHandler)localObject).bWg());
        ((WebViewVideoEventHandler)localObject).bWh();
        ((WebViewVideoEventHandler)localObject).bYB();
        localObject = localk.cJz;
        if (localObject != null)
        {
          l locall = localk.Qwr;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = localk.cFj;
          p.k(localObject, "mediaPlayer");
          if ((!Util.isNullOrNil(locall.Qww.videoPath)) && (locall.Qww.pOj > 0L))
          {
            locall.Qww.pOr = Util.nowMilliSecond();
            locall.a(locala, (e)localObject, "onMediaPlayerVideoEnd");
          }
        }
        if (localk.cJP)
        {
          Log.i(localk.getTAG(), "onCompletion, video loop playing");
          localk.cJH = true;
          localk.seek(0L);
          AppMethodBeat.o(226692);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((WebViewVideoEventHandler)localObject).TAG, "OnXWebVideoEnded fail", new Object[] { localJSONException });
        }
        Log.i(localk.getTAG(), "onCompletion, video end playing");
        localk.cJV = true;
        AppMethodBeat.o(226692);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(k paramk, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(246738);
      Object localObject = this.Qws;
      int i = this.sUE;
      int j = this.sUF;
      if (!((k)localObject).cJO)
      {
        Log.i(((k)localObject).getTAG(), "onMediaPlayerError, mp released");
        AppMethodBeat.o(246738);
        return;
      }
      Log.i(((k)localObject).getTAG(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((k)localObject).cJC;
      if (localObject != null)
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).cv(i, j);
        AppMethodBeat.o(246738);
        return;
      }
      AppMethodBeat.o(246738);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(k paramk, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(224791);
      this.Qws.lM(this.sUE, this.sUF);
      AppMethodBeat.o(224791);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(264707);
      k localk = this.Qws;
      if (!localk.cJO)
      {
        Log.i(localk.getTAG(), "onMediaPlayerPrepared, mp released");
        AppMethodBeat.o(264707);
        return;
      }
      Log.i(localk.getTAG(), "onPrepared");
      localk.cJN = true;
      localk.cEF();
      Object localObject1 = localk.Qwr;
      int i = localk.getDuration();
      long l;
      if (((l)localObject1).Qww.pOk <= 0L)
      {
        ((l)localObject1).Qww.pOk = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 21L, 1L, false);
        l = ((l)localObject1).Qww.pOk - ((l)localObject1).Qww.pOj;
        ((l)localObject1).Qww.pOl = l;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 22L, l, false);
        Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
      }
      if ((((l)localObject1).Qww.duration <= 0L) && (i > 0))
      {
        l = (1.0D * i / 1000.0D);
        ((l)localObject1).Qww.duration = l;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 26L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 24L, l, false);
        Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(l) });
      }
      Object localObject4;
      if (localk.Tt())
      {
        localObject1 = localk.Qwp;
        if (localObject1 != null)
        {
          localObject4 = localk.cJz;
          if (localObject4 == null) {
            break label720;
          }
          i = ((e)localObject4).getVideoWidth();
        }
      }
      for (;;)
      {
        localObject4 = localk.cJz;
        int j;
        int k;
        if (localObject4 != null)
        {
          j = ((e)localObject4).getVideoHeight();
          k = localk.getDuration();
          Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onVideoLoadedMetaData width=" + i + ", height=" + j + ", duration=" + k);
        }
        try
        {
          localObject4 = ((WebViewVideoEventHandler)localObject1).bWg();
          ((JSONObject)localObject4).put("width", i);
          ((JSONObject)localObject4).put("height", j);
          ((WebViewVideoEventHandler)localObject1).pLW = (k * 1.0D / 1000.0D);
          ((JSONObject)localObject4).put("duration", ((WebViewVideoEventHandler)localObject1).pLW);
          ((WebViewVideoEventHandler)localObject1).dispatchEvent("onVideoLoadedMetaData", (JSONObject)localObject4);
          localObject1 = localk.Qwp;
          if (localObject1 != null)
          {
            Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingMoovReport");
            localObject4 = ((WebViewVideoEventHandler)localObject1).Qwd;
            if ((localObject4 == null) || (((k)localObject4).cBL())) {}
          }
          else
          {
            localObject1 = localk.Qwp;
            if (localObject1 != null)
            {
              Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingPreDataReport");
              localObject4 = ((WebViewVideoEventHandler)localObject1).Qwd;
              if ((localObject4 == null) || (((k)localObject4).cBL())) {
                break label791;
              }
            }
            localObject4 = localk.Qwp;
            if (localObject4 != null)
            {
              Log.i(((WebViewVideoEventHandler)localObject4).TAG, "onWaitingReadyReport");
              localObject1 = ((WebViewVideoEventHandler)localObject4).Qwd;
              if ((localObject1 == null) || (((k)localObject1).cBL())) {
                break label827;
              }
            }
            localObject4 = localk.Qwp;
            if (localObject4 != null)
            {
              Log.i(((WebViewVideoEventHandler)localObject4).TAG, "onWaitingPlayReport");
              localObject1 = ((WebViewVideoEventHandler)localObject4).Qwd;
              if ((localObject1 == null) || (((k)localObject1).cBL())) {
                break label1103;
              }
            }
            l = localk.cJL;
            if (l > 0L)
            {
              localk.seek(l);
              localk.cJL = 0L;
            }
            Log.d(localk.getTAG(), "onPrepared, webViewInBackgroun = " + localk.cJW);
            if (localk.cJW) {
              break;
            }
            if ((!localk.cJM) && (!localk.cJK)) {
              break label1198;
            }
            Log.i(localk.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(localk.cJM), Boolean.valueOf(localk.cJK) });
            localk.Dr(true);
            AppMethodBeat.o(264707);
            return;
            label720:
            i = 0;
            continue;
            j = 0;
          }
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onVideoLoadedMetaData fail", new Object[] { localJSONException3 });
            continue;
            try
            {
              WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingMoov");
            }
            catch (JSONException localJSONException4)
            {
              Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingMoovReport fail", new Object[] { localJSONException4 });
            }
            continue;
            try
            {
              label791:
              WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingPreData");
            }
            catch (JSONException localJSONException5)
            {
              Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingPreDataReport fail", new Object[] { localJSONException5 });
            }
          }
          label827:
          label1085:
          Object localObject2;
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = localJSONException5.bWg();
              localJSONObject.put("state", 5);
              localObject1 = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
              localObject1 = localJSONException5.Qwd;
              if (localObject1 == null) {
                break label1085;
              }
              localObject1 = ((k)localObject1).Qwn;
              Object localObject5 = com.tencent.mm.plugin.appbrand.ae.a.a.c.anp((String)localObject1);
              localObject1 = localJSONException5.Qwd;
              if (localObject1 == null) {
                break label1091;
              }
              localObject1 = ((k)localObject1).Qwn;
              if ((p.h(localObject1, localJSONException5.Qwe) ^ true)) {
                localJSONException5.Qwf = 0;
              }
              localObject1 = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
              l = com.tencent.mm.plugin.appbrand.ae.a.a.c.anq((String)localObject5);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("clientMediaId", localObject5);
              localObject5 = localJSONException5.Qwd;
              if (localObject5 == null) {
                break label1097;
              }
              bool = ((k)localObject5).getAbTestVideoPreload();
              ((JSONObject)localObject1).put("isOpenVideoPreload", bool);
              ((JSONObject)localObject1).put("previousCompletedSize", l);
              ((JSONObject)localObject1).put("playCount", localJSONException5.Qwf);
              localObject1 = ((JSONObject)localObject1).toString();
              p.j(localObject1, "jsonObject.toString()");
              Log.i(localJSONException5.TAG, "generateWaitingReadyExtInfo:".concat(String.valueOf(localObject1)));
              localJSONObject.put("extInfo", localObject1);
              localJSONException5.m("WaitingReady", localJSONObject);
            }
            catch (JSONException localJSONException1)
            {
              Log.e(localJSONException5.TAG, "onWaitingReadyReport fail", new Object[] { localJSONException1 });
            }
            break;
            localObject2 = null;
            continue;
            label1091:
            localObject2 = null;
            continue;
            label1097:
            bool = false;
          }
          for (;;)
          {
            try
            {
              label1103:
              localObject2 = localJSONException5.Qwd;
              if (localObject2 == null) {
                break label1183;
              }
              localObject2 = ((k)localObject2).Qwn;
              if (!p.h(localObject2, localJSONException5.Qwe)) {
                break label1189;
              }
              localJSONException5.Qwf += 1;
              WebViewVideoEventHandler.a(localJSONException5, "WaitingPlay");
            }
            catch (JSONException localJSONException2)
            {
              Log.e(localJSONException5.TAG, "onWaitingPlayReport fail", new Object[] { localJSONException2 });
            }
            break;
            label1183:
            Object localObject3 = null;
            continue;
            label1189:
            localJSONException5.Qwf = 0;
          }
          label1198:
          Log.i(localk.getTAG(), "onPrepared, not set start play when prepared");
          AppMethodBeat.o(264707);
          return;
        }
      }
      Log.i(localk.getTAG(), "onPrepared, stop video auto play when webview in background");
      if ((localk.cJM) || (localk.cJK)) {}
      for (boolean bool = true;; bool = false)
      {
        localk.cFz = new AtomicBoolean(bool);
        AppMethodBeat.o(264707);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(242852);
      Object localObject1 = this.Qws;
      if (!((k)localObject1).cJO)
      {
        Log.i(((k)localObject1).getTAG(), "onMediaPlayerSeekComplete, mp released");
        AppMethodBeat.o(242852);
        return;
      }
      Object localObject2 = ((k)localObject1).Qwp;
      if (localObject2 != null) {}
      try
      {
        ((WebViewVideoEventHandler)localObject2).dispatchEvent("onVideoSeekEnd", ((WebViewVideoEventHandler)localObject2).bWg());
        Log.i(((k)localObject1).getTAG(), "onSeekComplete");
        if (((k)localObject1).cJH) {
          if ((((k)localObject1).cJW) && (((k)localObject1).Qwo))
          {
            Log.e(((k)localObject1).getTAG(), "onSeekComplete, background not allow play");
            AppMethodBeat.o(242852);
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(((WebViewVideoEventHandler)localObject2).TAG, "onVideoSeedEnd fail", new Object[] { localJSONException });
        }
        Log.i(((k)localObject1).getTAG(), "onSeekComplete, start when seek complete");
        ((k)localObject1).cJH = false;
        ((k)localObject1).Dr(true);
        AppMethodBeat.o(242852);
        return;
      }
      localObject2 = ((k)localObject1).cJz;
      if (localObject2 == null) {
        p.iCn();
      }
      boolean bool = ((e)localObject2).isPlaying();
      if ((((k)localObject1).cJI) && ((!((k)localObject1).cJW) || (!((k)localObject1).Qwo)))
      {
        localObject2 = ((k)localObject1).cJz;
        if (localObject2 == null) {
          p.iCn();
        }
        long l1 = ((e)localObject2).getDuration();
        localObject2 = ((k)localObject1).cJz;
        if (localObject2 == null) {
          p.iCn();
        }
        long l2 = ((e)localObject2).getCurrentPosition();
        Log.i(((k)localObject1).getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
        ((k)localObject1).cJI = false;
        if (l2 / 1000L < l1 / 1000L)
        {
          Log.i(((k)localObject1).getTAG(), "onSeekComplete, video not end");
          if ((bool) && (((k)localObject1).Tt()))
          {
            Log.i(((k)localObject1).getTAG(), "onSeekComplete, dispatch play again");
            localObject1 = ((k)localObject1).Qwp;
            if (localObject1 != null)
            {
              ((WebViewVideoEventHandler)localObject1).hbG();
              AppMethodBeat.o(242852);
              return;
            }
            AppMethodBeat.o(242852);
          }
        }
        else
        {
          Log.i(((k)localObject1).getTAG(), "onSeekComplete, video ends");
          localObject2 = ((k)localObject1).cJz;
          if (localObject2 != null) {
            ((e)localObject2).pause();
          }
          if (((k)localObject1).Tt())
          {
            localObject2 = ((k)localObject1).Qwp;
            if (localObject2 != null) {
              ((WebViewVideoEventHandler)localObject2).hbG();
            }
          }
          localObject1 = ((k)localObject1).cJz;
          if (localObject1 != null)
          {
            ((e)localObject1).start();
            AppMethodBeat.o(242852);
            return;
          }
          AppMethodBeat.o(242852);
        }
      }
      else
      {
        Log.i(((k)localObject1).getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
        if ((!bool) && (((k)localObject1).Tt()))
        {
          Log.i(((k)localObject1).getTAG(), "onSeekComplete, dispatch pause again");
          localObject2 = ((k)localObject1).Qwp;
          if (localObject2 != null) {
            ((WebViewVideoEventHandler)localObject2).hbH();
          }
        }
        if ((bool) && (((k)localObject1).cJW) && (((k)localObject1).Qwo))
        {
          ((k)localObject1).cFz = new AtomicBoolean(true);
          ((k)localObject1).pause();
        }
      }
      AppMethodBeat.o(242852);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(k paramk, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(227729);
      k localk = this.Qws;
      int i = this.cLp;
      int j = this.cLq;
      if (!localk.cJO)
      {
        Log.i(localk.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
        AppMethodBeat.o(227729);
        return;
      }
      int k = localk.getDuration();
      Log.i(localk.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(localk.cJN) });
      WebViewVideoEventHandler localWebViewVideoEventHandler;
      if ((localk.cJN) && (localk.cJz != null) && ((i != localk.mVideoWidth) || (j != localk.mVideoHeight) || (k != localk.cJR)) && (localk.Tt()))
      {
        localWebViewVideoEventHandler = localk.Qwp;
        if (localWebViewVideoEventHandler != null) {
          Log.i(localWebViewVideoEventHandler.TAG, "onVideoSizeChange width=" + i + ", height=" + j + ", duration=" + k);
        }
      }
      try
      {
        JSONObject localJSONObject = localWebViewVideoEventHandler.bWg();
        localJSONObject.put("width", i);
        localJSONObject.put("height", j);
        localWebViewVideoEventHandler.pLW = (k * 1.0D / 1000.0D);
        localJSONObject.put("duration", localWebViewVideoEventHandler.pLW);
        localWebViewVideoEventHandler.dispatchEvent("onVideoSizeChange", localJSONObject);
        localk.mVideoWidth = i;
        localk.mVideoHeight = j;
        localk.cJR = k;
        localk.cEF();
        AppMethodBeat.o(227729);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e(localWebViewVideoEventHandler.TAG, "onVideoSizeChange fail", new Object[] { localJSONException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.k
 * JD-Core Version:    0.7.0.1
 */