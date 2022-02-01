package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

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
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mCurrentPlayingVideoPath", "getMCurrentPlayingVideoPath", "setMCurrentPlayingVideoPath", "(Ljava/lang/String;)V", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoType", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurfaceInternal", "surface", "clearSurfaceTexture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "handlePluginReadyForGPUProcess", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onHitPreload", "hit", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", "play", "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseSurface", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setPlayingWhenEnterBackground", "setVideoType", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private HandlerThread JV;
  final d.a TNy;
  String XoI;
  private boolean XoJ;
  private int XoK;
  WebViewVideoEventHandler XoL;
  private com.tencent.mm.plugin.appbrand.jsapi.al.e.g XoM;
  private final k XoN;
  private int dhq;
  private float dhu;
  private int eDA;
  private int eDB;
  private String eDC;
  private String eDD;
  private boolean eDE;
  volatile boolean eDF;
  private Handler eDL;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.a eDM;
  private float eDS;
  private float eDT;
  com.tencent.mm.plugin.appbrand.jsapi.video.e.g eDi;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c eDl;
  private boolean eDq;
  private boolean eDr;
  private boolean eDs;
  private boolean eDt;
  private long eDu;
  private boolean eDv;
  boolean eDw;
  private volatile boolean eDx;
  private boolean eDy;
  private boolean eDz;
  private int eyA;
  private boolean eyD;
  AtomicBoolean eyN;
  com.tencent.luggage.xweb_ext.extendplugin.a eyx;
  private a.a eyy;
  private int eyz;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  final com.tencent.mm.model.d nmW;
  private int sGk;
  private int sGl;
  private int sGm;
  private int sGn;
  private final kotlin.j sMn;
  private boolean vZF;
  final kotlin.j vZK;
  
  public j()
  {
    AppMethodBeat.i(297130);
    this.sMn = kotlin.k.cm((kotlin.g.a.a)new j.a(this));
    this.JV = com.tencent.threadpool.c.d.jw(s.X("WebViewVideoThread_", Long.valueOf(System.currentTimeMillis())), 5);
    this.eDS = 1.0F;
    this.eDT = 1.0F;
    this.XoM = new com.tencent.mm.plugin.appbrand.jsapi.al.e.g();
    this.XoN = new k();
    com.tencent.mm.model.d locald = new com.tencent.mm.model.d();
    s.s(locald, "createTool()");
    this.nmW = locald;
    this.JV.start();
    this.eDL = new Handler(this.JV.getLooper());
    this.dhq = 800000;
    this.dhu = 0.75F;
    this.sGk = 10000;
    this.sGl = 25000;
    this.sGm = 15000;
    this.sGn = 30000;
    this.TNy = ((d.a)new c());
    this.vZK = kotlin.k.cm((kotlin.g.a.a)j.b.XoP);
    AppMethodBeat.o(297130);
  }
  
  private final void C(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(297234);
    parama = parama.atw();
    if (parama == null) {}
    for (parama = null; parama == null; parama = parama.optJSONObject("playerConfig"))
    {
      AppMethodBeat.o(297234);
      return;
    }
    this.dhq = parama.optInt("maxInitialBitrate", 0);
    this.dhu = ((float)parama.optDouble("bandwidthFraction", 0.0D));
    this.sGk = parama.optInt("minDurForQualityMs", 0);
    this.sGl = parama.optInt("maxDurForQualityMs", 0);
    this.sGm = parama.optInt("minBufferMs", 0);
    this.sGn = parama.optInt("maxBufferMs", 0);
    int i;
    if (this.dhq != 0) {
      if (this.dhu == 0.0F)
      {
        i = 1;
        if ((i != 0) || (this.sGk == 0) || (this.sGl == 0) || (this.sGm == 0) || (this.sGn == 0)) {
          break label203;
        }
      }
    }
    for (;;)
    {
      this.vZF = bool;
      Log.i(getTAG(), s.X("setExoPlayerParam checkExoPlayerParam result = ", Boolean.valueOf(this.vZF)));
      AppMethodBeat.o(297234);
      return;
      i = 0;
      break;
      label203:
      bool = false;
    }
  }
  
  private final void D(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297237);
    parama = parama.atw();
    if (parama == null) {}
    for (parama = null; parama == null; parama = parama.optJSONObject("downloadConfig"))
    {
      AppMethodBeat.o(297237);
      return;
    }
    this.XoK = parama.optInt("videoType", 0);
    AppMethodBeat.o(297237);
  }
  
  private final void E(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297242);
    F(parama);
    com.tencent.threadpool.h.ahAA.o(new j..ExternalSyntheticLambda21(this, parama), 2000L);
    AppMethodBeat.o(297242);
  }
  
  private final void F(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297248);
    if ((!this.eDF) && ((parama.getContext() instanceof MMActivity)))
    {
      parama = parama.getContext();
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(297248);
        throw parama;
      }
      if (((MMActivity)parama).isPaused())
      {
        Log.w(getTAG(), "checkPause, onBackGround");
        iBX();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 0L, 1L, false);
      }
    }
    AppMethodBeat.o(297248);
  }
  
  private static final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, j paramj)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = true;
    int k = 1;
    AppMethodBeat.i(297286);
    s.u(parama, "$invokeContext");
    s.u(paramj, "this$0");
    Object localObject1 = parama.atx();
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(297286);
      return;
    }
    Object localObject2 = parama.atw();
    Log.i(paramj.getTAG(), "handler(%s) handleJsApi(%s), data:%s", new Object[] { paramj.key(), localObject1, ((JSONObject)localObject2).toString() });
    if (!s.p("handleVideoAction", localObject1))
    {
      Log.e(paramj.getTAG(), "handler(%s), not right jsapi:(%s)", new Object[] { paramj.key(), localObject1 });
      AppMethodBeat.o(297286);
      return;
    }
    localObject1 = ((JSONObject)localObject2).optString("action", "");
    if (localObject1 != null) {}
    switch (((String)localObject1).hashCode())
    {
    default: 
      AppMethodBeat.o(297286);
      return;
    case -952717996: 
      if (((String)localObject1).equals("operateSameLayerVideo")) {
        break label1641;
      }
      AppMethodBeat.o(297286);
      return;
    case 1975278676: 
      if (((String)localObject1).equals("removeSameLayerVideo")) {
        break label2194;
      }
      AppMethodBeat.o(297286);
      return;
    case -1100634679: 
      if (!((String)localObject1).equals("insertSameLayerVideo"))
      {
        AppMethodBeat.o(297286);
        return;
      }
      break;
    case -312131623: 
      if (((String)localObject1).equals("updateSameLayerVideo")) {
        break label863;
      }
      AppMethodBeat.o(297286);
      return;
    }
    paramj.eyx = parama;
    paramj.C(parama);
    paramj.D(parama);
    localObject1 = parama.atw();
    paramj.eyD = ((JSONObject)localObject1).optBoolean("needEvent", true);
    WebViewVideoEventHandler localWebViewVideoEventHandler;
    if ((paramj.eyD) && (paramj.XoL != null))
    {
      localObject2 = paramj.XoL;
      if (localObject2 != null) {
        ((WebViewVideoEventHandler)localObject2).m(parama);
      }
      localObject2 = ((JSONObject)localObject1).optString("data", "");
      localWebViewVideoEventHandler = paramj.XoL;
      if (localWebViewVideoEventHandler != null) {
        localWebViewVideoEventHandler.fT((String)localObject2);
      }
    }
    if (paramj.eDi == null)
    {
      Log.w(paramj.getTAG(), "insert, media player is null");
      paramj.iBW();
    }
    if (paramj.eyy == null)
    {
      paramj.eyy = ((a.a)new g(paramj));
      parama.a(paramj.eyy);
    }
    if (paramj.mSurface != null)
    {
      Log.i(paramj.getTAG(), "insert, setSurface");
      localObject2 = paramj.eDi;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).setSurface(paramj.mSurface);
      }
    }
    paramj.eDv = ((JSONObject)localObject1).optBoolean("autoplay", false);
    paramj.eDu = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
    paramj.eDy = ((JSONObject)localObject1).optBoolean("loop", false);
    paramj.eDz = ((JSONObject)localObject1).optBoolean("muted", false);
    if (com.tencent.mm.n.a.aTj()) {
      paramj.eDz = true;
    }
    localObject2 = paramj.eDi;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).setMute(paramj.eDz);
    }
    paramj.XoJ = ((JSONObject)localObject1).optBoolean("autoPauseOnBackground", true);
    if (((JSONObject)localObject1).has("position"))
    {
      localObject2 = ((JSONObject)localObject1).optJSONObject("position");
      if (localObject2 != null)
      {
        paramj.eyz = com.tencent.mm.plugin.appbrand.af.i.DC(((JSONObject)localObject2).optInt("width", 0));
        paramj.eyA = com.tencent.mm.plugin.appbrand.af.i.DC(((JSONObject)localObject2).optInt("height", 0));
        Log.i(paramj.getTAG(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(paramj.eyz), Integer.valueOf(paramj.eyA) });
      }
    }
    paramj.eDD = ((JSONObject)localObject1).optString("objectFit", "contain");
    if (Util.isNullOrNil(paramj.eDD)) {
      paramj.eDD = "contain";
    }
    paramj.dif();
    paramj.eDC = ((JSONObject)localObject1).optString("filePath");
    if (!Util.isNullOrNil(paramj.eDC))
    {
      if ((!com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAx) || (!com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAy)) {
        break label835;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().cd(paramj.eDC);
      Log.i(paramj.getTAG(), "insert, path:%s, proxy=%s", new Object[] { paramj.eDC, localObject1 });
      if (Util.isNullOrNil((String)localObject1)) {
        break label841;
      }
      paramj.setDataSourceWithCustomKey((String)localObject1);
      paramj.XoN.bmQ((String)localObject1);
    }
    for (;;)
    {
      paramj.prepareAsync();
      parama.fO("ok");
      paramj.E(parama);
      AppMethodBeat.o(297286);
      return;
      label835:
      localObject1 = null;
      break;
      label841:
      paramj.setDataSourceWithCustomKey(paramj.eDC);
      paramj.XoN.bmQ(paramj.eDC);
    }
    label863:
    if (paramj.eDi == null)
    {
      Log.w(paramj.getTAG(), "update, media player is null");
      parama.fO("fail");
      AppMethodBeat.o(297286);
      return;
    }
    paramj.C(parama);
    paramj.D(parama);
    localObject2 = parama.atw();
    if (((JSONObject)localObject2).optBoolean("switchResolution", false))
    {
      paramj.eDu = paramj.getCurrentPosition();
      label936:
      if (!((JSONObject)localObject2).has("filePath")) {
        break label2255;
      }
      localObject1 = ((JSONObject)localObject2).optString("filePath");
      if ((Util.isNullOrNil((String)localObject1)) || (n.T((String)localObject1, paramj.eDC, true))) {
        break label2255;
      }
      paramj.eDC = ((String)localObject1);
      if ((!com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAx) || (!com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAy)) {
        break label1600;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().cd(paramj.eDC);
      label1014:
      Log.i(paramj.getTAG(), "update, path:%s, proxy:%s", new Object[] { paramj.eDC, localObject1 });
      if (!Util.isNullOrNil(paramj.eDC))
      {
        paramj.stop();
        paramj.iBY();
      }
      if (Util.isNullOrNil((String)localObject1)) {
        break label1606;
      }
      paramj.setDataSourceWithCustomKey((String)localObject1);
      paramj.XoN.bmQ((String)localObject1);
    }
    label1082:
    label1600:
    label1606:
    label2255:
    for (int j = 1;; j = 0)
    {
      if ((paramj.mSurface != null) && (paramj.eDi != null))
      {
        if (paramj.eDF) {
          break label1628;
        }
        Log.i(paramj.getTAG(), "update, setSurface");
        localObject1 = paramj.eDi;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).setSurface(paramj.mSurface);
        }
      }
      label1138:
      if (((JSONObject)localObject2).has("autoplay")) {
        paramj.eDv = ((JSONObject)localObject2).optBoolean("autoplay", paramj.eDv);
      }
      if (((JSONObject)localObject2).has("loop")) {
        paramj.eDy = ((JSONObject)localObject2).optBoolean("loop", paramj.eDy);
      }
      if (((JSONObject)localObject2).has("muted"))
      {
        paramj.eDz = ((JSONObject)localObject2).optBoolean("muted", paramj.eDz);
        if (com.tencent.mm.n.a.aTj()) {
          paramj.eDz = true;
        }
        localObject1 = paramj.eDi;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).setMute(paramj.eDz);
        }
      }
      paramj.XoJ = ((JSONObject)localObject2).optBoolean("autoPauseOnBackground", true);
      if (((JSONObject)localObject2).has("needEvent")) {
        paramj.eyD = ((JSONObject)localObject2).optBoolean("needEvent", paramj.eyD);
      }
      if ((paramj.eyD) && (paramj.XoL != null))
      {
        localObject1 = paramj.XoL;
        if (localObject1 != null) {
          ((WebViewVideoEventHandler)localObject1).m(parama);
        }
        localObject1 = ((JSONObject)localObject2).optString("data", "");
        if (((JSONObject)localObject2).has("data"))
        {
          localWebViewVideoEventHandler = paramj.XoL;
          if (localWebViewVideoEventHandler != null) {
            localWebViewVideoEventHandler.fT((String)localObject1);
          }
        }
      }
      if (((JSONObject)localObject2).has("position"))
      {
        localObject1 = ((JSONObject)localObject2).optJSONObject("position");
        if (localObject1 != null)
        {
          paramj.eyz = com.tencent.mm.plugin.appbrand.af.i.DC(((JSONObject)localObject1).optInt("width", paramj.eyz));
          paramj.eyA = com.tencent.mm.plugin.appbrand.af.i.DC(((JSONObject)localObject1).optInt("height", paramj.eyA));
          Log.i(paramj.getTAG(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(paramj.eyz), Integer.valueOf(paramj.eyA) });
        }
        i = 1;
      }
      if (((JSONObject)localObject2).has("objectFit"))
      {
        paramj.eDD = ((JSONObject)localObject2).optString("objectFit", paramj.eDD);
        i = k;
        if (Util.isNullOrNil(paramj.eDD))
        {
          paramj.eDD = "contain";
          i = k;
        }
      }
      for (;;)
      {
        if (i != 0) {
          paramj.dif();
        }
        if (j != 0)
        {
          Log.i(paramj.getTAG(), "update, media player prepare async");
          paramj.prepareAsync();
        }
        parama.fO("ok");
        paramj.E(parama);
        AppMethodBeat.o(297286);
        return;
        if (!((JSONObject)localObject2).has("initialTime")) {
          break label936;
        }
        paramj.eDu = ((((JSONObject)localObject2).optDouble("initialTime", 0.0D) * 1000.0D));
        break label936;
        localObject1 = null;
        break label1014;
        paramj.setDataSourceWithCustomKey(paramj.eDC);
        paramj.XoN.bmQ(paramj.eDC);
        break label1082;
        label1628:
        Log.i(paramj.getTAG(), "update, setSurface, WebViewInBackground");
        break label1138;
        label1641:
        if (paramj.eDi == null)
        {
          Log.w(paramj.getTAG(), "operate, media player is null");
          parama.fO("fail");
          AppMethodBeat.o(297286);
          return;
        }
        if (paramj.eyD)
        {
          localObject1 = paramj.XoL;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).m(parama);
          }
        }
        localObject1 = parama.atw();
        localObject2 = ((JSONObject)localObject1).optString("type");
        if (!Util.isNullOrNil((String)localObject2))
        {
          Log.i(paramj.getTAG(), "operate, type:%s", new Object[] { localObject2 });
          if (!n.T((String)localObject2, "play", true)) {
            break label1787;
          }
          bool1 = paramj.IZ(true);
          if (!bool1) {
            break label2187;
          }
        }
        for (paramj = "ok";; paramj = "fail")
        {
          parama.fO(paramj);
          AppMethodBeat.o(297286);
          return;
          label1787:
          if (n.T((String)localObject2, "pause", true))
          {
            bool1 = paramj.pause();
            break;
          }
          if (n.T((String)localObject2, "stop", true))
          {
            bool1 = paramj.stop();
            break;
          }
          label1897:
          double d;
          if (n.T((String)localObject2, "seek", true))
          {
            if ((paramj.eDi != null) && (localObject1 != null) && (((JSONObject)localObject1).has("data")))
            {
              localObject1 = ((JSONObject)localObject1).optJSONArray("data");
              if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0)) {
                Log.w(paramj.getTAG(), "seek, data array is null");
              }
            }
            else
            {
              bool1 = false;
            }
            for (;;)
            {
              break;
              d = ((JSONArray)localObject1).optDouble(0, -1.0D);
              if (d < 0.0D)
              {
                Log.w(paramj.getTAG(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                break label1897;
              }
              paramj.seek((1000.0D * d));
            }
          }
          if (n.T((String)localObject2, "playbackRate", true))
          {
            bool1 = bool2;
            if (paramj.eDi == null) {
              break;
            }
            bool1 = bool2;
            if (localObject1 == null) {
              break;
            }
            bool1 = bool2;
            if (!((JSONObject)localObject1).has("data")) {
              break;
            }
            localObject1 = ((JSONObject)localObject1).optJSONArray("data");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
            {
              Log.w(paramj.getTAG(), "speed, data array is null");
              bool1 = bool2;
              break;
            }
            d = ((JSONArray)localObject1).optDouble(0, -1.0D);
            if (d < 0.0D)
            {
              Log.w(paramj.getTAG(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
              bool1 = bool2;
              break;
            }
            Log.i(paramj.getTAG(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
            paramj = paramj.eDi;
            bool1 = bool2;
            if (paramj == null) {
              break;
            }
            bool1 = paramj.bN((float)d);
            break;
          }
          bool1 = bool2;
          if (!n.T((String)localObject2, "snapshot", true)) {
            break;
          }
          paramj.eDM = parama;
          Log.i(paramj.getTAG(), "takeVideoSnapshot");
          com.tencent.luggage.xweb_ext.extendplugin.d.a(paramj.auT(), paramj.type, paramj.getId());
          AppMethodBeat.o(297286);
          return;
        }
        paramj.release();
        if ((paramj.eyx != null) && (paramj.eyy != null))
        {
          localObject1 = paramj.eyx;
          s.checkNotNull(localObject1);
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject1).b(paramj.eyy);
          paramj.eyy = null;
        }
        parama.fO("ok");
        break;
      }
    }
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(297265);
    s.u(paramj, "this$0");
    paramj.atW();
    Log.i(paramj.getTAG(), "handler(%s) handlePluginDestroy", new Object[] { paramj.key() });
    paramj.stop();
    paramj.dhZ();
    AppMethodBeat.o(297265);
  }
  
  private static final void a(j paramj, int paramInt)
  {
    AppMethodBeat.i(297326);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerBufferingUpdate, mp released");
      AppMethodBeat.o(297326);
      return;
    }
    if (paramInt != paramj.eDB)
    {
      paramj.eDB = paramInt;
      Log.i(paramj.getTAG(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramj.atY()) && (paramj.eDw))
    {
      paramj = paramj.XoL;
      if (paramj != null) {
        try
        {
          JSONObject localJSONObject = paramj.cws();
          localJSONObject.put("buffered", paramInt);
          paramj.n("onVideoBufferUpdate", localJSONObject);
          AppMethodBeat.o(297326);
          return;
        }
        catch (JSONException localJSONException)
        {
          Log.e(paramj.TAG, "OnXWebVideoProgress fail", new Object[] { localJSONException });
        }
      }
    }
    AppMethodBeat.o(297326);
  }
  
  private static final void a(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297335);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
      AppMethodBeat.o(297335);
      return;
    }
    int i = paramj.getDuration();
    Log.i(paramj.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(paramj.eDw) });
    WebViewVideoEventHandler localWebViewVideoEventHandler;
    if ((paramj.eDw) && (paramj.eDi != null) && ((paramInt1 != paramj.mVideoWidth) || (paramInt2 != paramj.mVideoHeight) || (i != paramj.eDA)) && (paramj.atY()))
    {
      localWebViewVideoEventHandler = paramj.XoL;
      if (localWebViewVideoEventHandler != null) {
        Log.i(localWebViewVideoEventHandler.TAG, "onVideoSizeChange width=" + paramInt1 + ", height=" + paramInt2 + ", duration=" + i);
      }
    }
    try
    {
      JSONObject localJSONObject = localWebViewVideoEventHandler.cws();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      localWebViewVideoEventHandler.sQM = (i * 1.0D / 1000.0D);
      localJSONObject.put("duration", localWebViewVideoEventHandler.sQM);
      localWebViewVideoEventHandler.n("onVideoSizeChange", localJSONObject);
      paramj.mVideoWidth = paramInt1;
      paramj.mVideoHeight = paramInt2;
      paramj.eDA = i;
      paramj.dif();
      AppMethodBeat.o(297335);
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
  
  private static final void a(j paramj, Surface paramSurface)
  {
    AppMethodBeat.i(297261);
    s.u(paramj, "this$0");
    s.u(paramSurface, "$surface");
    Log.i(paramj.getTAG(), "handler(%s) handlePluginReady", new Object[] { paramj.key() });
    paramj.eDq = false;
    paramj.eDr = false;
    paramj.eDs = false;
    paramj.eDt = false;
    paramj.mSurface = paramSurface;
    if (paramj.eDi != null)
    {
      Log.i(paramj.getTAG(), "handlePluginReady, setSurface:%s", new Object[] { paramSurface });
      try
      {
        paramSurface = paramj.eDi;
        if (paramSurface != null)
        {
          paramSurface.setSurface(paramj.mSurface);
          AppMethodBeat.o(297261);
          return;
        }
      }
      catch (Exception paramSurface)
      {
        Log.e(paramj.getTAG(), s.X("handlePluginReady, setSurface:ex ", paramSurface.getMessage()));
      }
    }
    AppMethodBeat.o(297261);
  }
  
  private static final void a(j paramj, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297384);
    s.u(paramj, "this$0");
    s.u(parama, "$invokeContext");
    paramj.F(parama);
    AppMethodBeat.o(297384);
  }
  
  private static final void a(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(297300);
    s.u(paramj, "this$0");
    paramj.o(new j..ExternalSyntheticLambda11(paramj));
    AppMethodBeat.o(297300);
  }
  
  private static final void a(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, int paramInt)
  {
    AppMethodBeat.i(297313);
    s.u(paramj, "this$0");
    paramj.o(new j..ExternalSyntheticLambda16(paramj, paramInt));
    AppMethodBeat.o(297313);
  }
  
  private static final void a(j paramj, Boolean paramBoolean)
  {
    AppMethodBeat.i(297323);
    s.u(paramj, "this$0");
    s.s(paramBoolean, "hit");
    boolean bool = paramBoolean.booleanValue();
    paramBoolean = paramj.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("onHitPreload:").append(bool).append("  fileId:");
    com.tencent.mm.plugin.appbrand.ag.b.a.c localc = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
    localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.appbrand.ag.b.a.c.agJ(paramj.XoI)).append("   preloadSize:");
    localc = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
    Log.i(paramBoolean, com.tencent.mm.plugin.appbrand.ag.b.a.c.agK(paramj.XoI));
    if (bool)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 54L, 1L, false);
      AppMethodBeat.o(297323);
      return;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 55L, 1L, false);
    }
    for (;;)
    {
      paramBoolean = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
      if (com.tencent.mm.plugin.appbrand.ag.b.a.c.agK(paramj.XoI) <= 0L) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 57L, 1L, false);
      AppMethodBeat.o(297323);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 56L, 1L, false);
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 58L, 1L, false);
    AppMethodBeat.o(297323);
  }
  
  private static final void a(j paramj, String paramString)
  {
    AppMethodBeat.i(297319);
    s.u(paramj, "this$0");
    WebViewVideoEventHandler localWebViewVideoEventHandler = paramj.XoL;
    if (localWebViewVideoEventHandler != null) {
      try
      {
        Object localObject = localWebViewVideoEventHandler.TAG;
        if (paramString == null) {}
        for (paramj = "null";; paramj = paramString)
        {
          Log.i((String)localObject, s.X("[TRACE_ADAPTIVE] onVideoDownStreamChange selectIndex = ", paramj));
          localObject = localWebViewVideoEventHandler.cws();
          paramj = paramString;
          if (paramString == null) {
            paramj = "";
          }
          ((JSONObject)localObject).put("selectIndex", paramj);
          localWebViewVideoEventHandler.n("onVideoDownStreamChange", (JSONObject)localObject);
          AppMethodBeat.o(297319);
          return;
        }
        AppMethodBeat.o(297319);
      }
      catch (JSONException paramj)
      {
        Log.e(localWebViewVideoEventHandler.TAG, "onVideoDownStreamChange fail", new Object[] { paramj });
      }
    }
  }
  
  private static final void a(j paramj, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297257);
    s.u(paramj, "this$0");
    Log.w(paramj.getTAG(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramj.atY())
    {
      localObject = paramj.XoL;
      if (localObject != null) {
        ((WebViewVideoEventHandler)localObject).onVideoError(paramString, paramInt1, paramInt2);
      }
    }
    Object localObject = paramj.XoN;
    s.s(paramString, "msg");
    s.u(paramString, "msg");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 40L, 1L, false);
    Log.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!Util.isNullOrNil(paramString))
    {
      if (!n.T(paramString, "MEDIA_ERR_NETWORK", true)) {
        break label214;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 41L, 1L, false);
    }
    for (;;)
    {
      ((k)localObject).XoR.sSQ = paramInt1;
      ((k)localObject).XoR.sSR = paramInt2;
      localObject = ((k)localObject).XoR;
      s.u(paramString, "<set-?>");
      ((k.b)localObject).errorMsg = paramString;
      paramj.stop();
      AppMethodBeat.o(297257);
      return;
      label214:
      if (n.T(paramString, "MEDIA_ERR_DECODE", true)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 42L, 1L, false);
      } else if (n.T(paramString, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 43L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 44L, 1L, false);
      }
    }
  }
  
  private static final boolean a(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297292);
    s.u(paramj, "this$0");
    boolean bool = paramj.o(new j..ExternalSyntheticLambda19(paramj, paramInt1, paramInt2));
    AppMethodBeat.o(297292);
    return bool;
  }
  
  private final void aW(Bitmap paramBitmap)
  {
    AppMethodBeat.i(297228);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i(getTAG(), s.X("bitmap recycle ", paramBitmap));
      paramBitmap.recycle();
    }
    AppMethodBeat.o(297228);
  }
  
  /* Error */
  private final boolean atY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 681	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:eyD	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
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
    //   0	34	0	this	j
    //   19	7	1	bool	boolean
    //   13	2	2	localWebViewVideoEventHandler	WebViewVideoEventHandler
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  private final void auC()
  {
    try
    {
      AppMethodBeat.i(297184);
      if (this.eDi != null)
      {
        Log.i(getTAG(), "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.a(null);
        }
        localg = this.eDi;
        if (localg != null) {
          localg.stop();
        }
        localg = this.eDi;
        if (localg != null) {
          localg.reset();
        }
        localg = this.eDi;
        if (localg != null) {
          localg.release();
        }
      }
      this.eDi = null;
      this.eDx = false;
      AppMethodBeat.o(297184);
      return;
    }
    finally {}
  }
  
  private static final void b(j paramj)
  {
    AppMethodBeat.i(297344);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerSeekComplete, mp released");
      AppMethodBeat.o(297344);
      return;
    }
    Object localObject = paramj.XoL;
    if (localObject != null) {}
    try
    {
      ((WebViewVideoEventHandler)localObject).n("onVideoSeekEnd", ((WebViewVideoEventHandler)localObject).cws());
      Log.i(paramj.getTAG(), "onSeekComplete");
      if (paramj.eDq) {
        if ((paramj.eDF) && (paramj.XoJ))
        {
          Log.e(paramj.getTAG(), "onSeekComplete, background not allow play");
          AppMethodBeat.o(297344);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(((WebViewVideoEventHandler)localObject).TAG, "onVideoSeedEnd fail", new Object[] { localJSONException });
      }
      Log.i(paramj.getTAG(), "onSeekComplete, start when seek complete");
      paramj.eDq = false;
      paramj.IZ(true);
      AppMethodBeat.o(297344);
      return;
    }
    localObject = paramj.eDi;
    s.checkNotNull(localObject);
    boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).isPlaying();
    if ((paramj.eDr) && ((!paramj.eDF) || (!paramj.XoJ)))
    {
      localObject = paramj.eDi;
      s.checkNotNull(localObject);
      long l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).getDuration();
      localObject = paramj.eDi;
      s.checkNotNull(localObject);
      long l2 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).getCurrentPosition();
      Log.i(paramj.getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
      paramj.eDr = false;
      if (l2 / 1000L < l1 / 1000L)
      {
        Log.i(paramj.getTAG(), "onSeekComplete, video not end");
        if ((bool) && (paramj.atY()))
        {
          Log.i(paramj.getTAG(), "onSeekComplete, dispatch play again");
          paramj = paramj.XoL;
          if (paramj != null)
          {
            paramj.iBT();
            AppMethodBeat.o(297344);
          }
        }
      }
      else
      {
        Log.i(paramj.getTAG(), "onSeekComplete, video ends");
        localObject = paramj.eDi;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).pause();
        }
        if (paramj.atY())
        {
          localObject = paramj.XoL;
          if (localObject != null) {
            ((WebViewVideoEventHandler)localObject).iBT();
          }
        }
        paramj = paramj.eDi;
        if (paramj != null)
        {
          paramj.start();
          AppMethodBeat.o(297344);
        }
      }
    }
    else
    {
      Log.i(paramj.getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (paramj.atY()))
      {
        Log.i(paramj.getTAG(), "onSeekComplete, dispatch pause again");
        localObject = paramj.XoL;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).iBU();
        }
      }
      if ((bool) && (paramj.eDF) && (paramj.XoJ))
      {
        paramj.eyN = new AtomicBoolean(true);
        paramj.pause();
      }
    }
    AppMethodBeat.o(297344);
  }
  
  private static final void b(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297371);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerError, mp released");
      AppMethodBeat.o(297371);
      return;
    }
    Log.i(paramj.getTAG(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramj = paramj.eDl;
    if (paramj != null) {
      paramj.di(paramInt1, paramInt2);
    }
    AppMethodBeat.o(297371);
  }
  
  private static final void b(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(297303);
    s.u(paramj, "this$0");
    paramj.o(new j..ExternalSyntheticLambda14(paramj));
    AppMethodBeat.o(297303);
  }
  
  private static final boolean b(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297296);
    s.u(paramj, "this$0");
    boolean bool = paramj.o(new j..ExternalSyntheticLambda18(paramj, paramInt1, paramInt2));
    AppMethodBeat.o(297296);
    return bool;
  }
  
  private static final void c(j paramj)
  {
    AppMethodBeat.i(297351);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerCompletion, mp released");
      AppMethodBeat.o(297351);
      return;
    }
    Log.i(paramj.getTAG(), "onCompletion");
    if (paramj.atY())
    {
      localObject = paramj.XoL;
      if (localObject != null) {
        ((WebViewVideoEventHandler)localObject).onVideoEnded();
      }
    }
    Object localObject = paramj.eDi;
    if (localObject != null)
    {
      k localk = paramj.XoN;
      com.tencent.luggage.xweb_ext.extendplugin.a locala = paramj.eyx;
      s.u(localObject, "mediaPlayer");
      if ((!Util.isNullOrNil(localk.XoR.videoPath)) && (localk.XoR.sSH > 0L))
      {
        localk.XoR.sSP = Util.nowMilliSecond();
        localk.a(locala, (com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject, "onMediaPlayerVideoEnd");
      }
    }
    if (paramj.eDy)
    {
      Log.i(paramj.getTAG(), "onCompletion, video loop playing");
      paramj.eDq = true;
      paramj.seek(0L);
      AppMethodBeat.o(297351);
      return;
    }
    Log.i(paramj.getTAG(), "onCompletion, video end playing");
    paramj.eDE = true;
    AppMethodBeat.o(297351);
  }
  
  private static final void c(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297377);
    s.u(paramj, "this$0");
    paramj.nw(paramInt1, paramInt2);
    AppMethodBeat.o(297377);
  }
  
  private static final void c(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(297307);
    s.u(paramj, "this$0");
    paramj.o(new j..ExternalSyntheticLambda12(paramj));
    AppMethodBeat.o(297307);
  }
  
  private static final void c(j paramj, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297310);
    s.u(paramj, "this$0");
    paramj.o(new j..ExternalSyntheticLambda17(paramj, paramInt1, paramInt2));
    AppMethodBeat.o(297310);
  }
  
  private static final void d(j paramj)
  {
    AppMethodBeat.i(297367);
    s.u(paramj, "this$0");
    if (!paramj.eDx)
    {
      Log.i(paramj.getTAG(), "onMediaPlayerPrepared, mp released");
      AppMethodBeat.o(297367);
      return;
    }
    Log.i(paramj.getTAG(), "onPrepared");
    paramj.eDw = true;
    paramj.dif();
    Object localObject1 = paramj.XoN;
    int i = paramj.getDuration();
    long l;
    if (((k)localObject1).XoR.sSI <= 0L)
    {
      ((k)localObject1).XoR.sSI = Util.nowMilliSecond();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 21L, 1L, false);
      l = ((k)localObject1).XoR.sSI - ((k)localObject1).XoR.sSH;
      ((k)localObject1).XoR.sSJ = l;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 22L, l, false);
      Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
    }
    if ((((k)localObject1).XoR.duration <= 0L) && (i > 0))
    {
      l = (1.0D * i / 1000.0D);
      ((k)localObject1).XoR.duration = l;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 26L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 24L, l, false);
      Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(l) });
    }
    Object localObject2;
    if (paramj.atY())
    {
      localObject1 = paramj.XoL;
      if (localObject1 != null)
      {
        localObject2 = paramj.eDi;
        if (localObject2 != null) {
          break label937;
        }
        i = 0;
      }
    }
    for (;;)
    {
      localObject2 = paramj.eDi;
      int j;
      label302:
      int k;
      if (localObject2 == null)
      {
        j = 0;
        k = paramj.getDuration();
        Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onVideoLoadedMetaData width=" + i + ", height=" + j + ", duration=" + k);
      }
      try
      {
        localObject2 = ((WebViewVideoEventHandler)localObject1).cws();
        ((JSONObject)localObject2).put("width", i);
        ((JSONObject)localObject2).put("height", j);
        ((WebViewVideoEventHandler)localObject1).sQM = (k * 1.0D / 1000.0D);
        ((JSONObject)localObject2).put("duration", ((WebViewVideoEventHandler)localObject1).sQM);
        ((WebViewVideoEventHandler)localObject1).n("onVideoLoadedMetaData", (JSONObject)localObject2);
        localObject1 = paramj.XoL;
        if (localObject1 != null)
        {
          Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingMoovReport");
          localObject2 = com.tencent.mm.plugin.webview.k.k.Xtc;
          if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
        }
      }
      catch (JSONException localJSONException4)
      {
        try
        {
          WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingMoov");
          localObject1 = paramj.XoL;
          if (localObject1 != null)
          {
            Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingPreDataReport");
            localObject2 = com.tencent.mm.plugin.webview.k.k.Xtc;
            if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
          }
        }
        catch (JSONException localJSONException4)
        {
          try
          {
            for (;;)
            {
              WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingPreData");
              localObject2 = paramj.XoL;
              if (localObject2 != null)
              {
                Log.i(((WebViewVideoEventHandler)localObject2).TAG, "onWaitingReadyReport");
                localObject1 = com.tencent.mm.plugin.webview.k.k.Xtc;
                if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
              }
              try
              {
                JSONObject localJSONObject = ((WebViewVideoEventHandler)localObject2).cws();
                localJSONObject.put("state", 5);
                localObject1 = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
                localObject1 = ((WebViewVideoEventHandler)localObject2).Xoz;
                if (localObject1 != null) {
                  break label1034;
                }
                localObject1 = null;
                localObject3 = com.tencent.mm.plugin.appbrand.ag.b.a.c.agJ((String)localObject1);
                localObject1 = ((WebViewVideoEventHandler)localObject2).Xoz;
                if (localObject1 != null) {
                  break label1044;
                }
                localObject1 = null;
                if (!s.p(localObject1, ((WebViewVideoEventHandler)localObject2).XoA)) {
                  ((WebViewVideoEventHandler)localObject2).XoB = 0;
                }
                localObject1 = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
                l = com.tencent.mm.plugin.appbrand.ag.b.a.c.agL((String)localObject3);
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("clientMediaId", localObject3);
                localObject3 = ((WebViewVideoEventHandler)localObject2).Xoz;
                if (localObject3 != null) {
                  break label1054;
                }
                bool = false;
                ((JSONObject)localObject1).put("isOpenVideoPreload", bool);
                ((JSONObject)localObject1).put("previousCompletedSize", l);
                ((JSONObject)localObject1).put("playCount", ((WebViewVideoEventHandler)localObject2).XoB);
                localObject1 = ((JSONObject)localObject1).toString();
                s.s(localObject1, "jsonObject.toString()");
                Log.i(((WebViewVideoEventHandler)localObject2).TAG, s.X("generateWaitingReadyExtInfo:", localObject1));
                localJSONObject.put("extInfo", localObject1);
                ((WebViewVideoEventHandler)localObject2).q("WaitingReady", localJSONObject);
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  Object localObject3;
                  Log.e(localJSONException5.TAG, "onWaitingReadyReport fail", new Object[] { localJSONException1 });
                  continue;
                  str = localJSONException1.XoI;
                  continue;
                  localJSONException5.XoB = 0;
                }
              }
              localObject2 = paramj.XoL;
              if (localObject2 != null)
              {
                Log.i(((WebViewVideoEventHandler)localObject2).TAG, "onWaitingPlayReport");
                localObject1 = com.tencent.mm.plugin.webview.k.k.Xtc;
                if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
              }
              try
              {
                localObject1 = ((WebViewVideoEventHandler)localObject2).Xoz;
                if (localObject1 != null) {
                  break label1100;
                }
                localObject1 = null;
                if (!s.p(localObject1, ((WebViewVideoEventHandler)localObject2).XoA)) {
                  break label1110;
                }
                ((WebViewVideoEventHandler)localObject2).XoB += 1;
                WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject2, "WaitingPlay");
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  String str;
                  Log.e(localJSONException5.TAG, "onWaitingPlayReport fail", new Object[] { localJSONException2 });
                }
                Log.i(paramj.getTAG(), "onPrepared, not set start play when prepared");
                AppMethodBeat.o(297367);
                return;
              }
              l = paramj.eDu;
              if (l > 0L)
              {
                paramj.seek(l);
                paramj.eDu = 0L;
              }
              Log.d(paramj.getTAG(), s.X("onPrepared, webViewInBackgroun = ", Boolean.valueOf(paramj.eDF)));
              if (paramj.eDF) {
                break label1161;
              }
              if ((!paramj.eDv) && (!paramj.eDt)) {
                break label1144;
              }
              Log.i(paramj.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(paramj.eDv), Boolean.valueOf(paramj.eDt) });
              paramj.IZ(true);
              AppMethodBeat.o(297367);
              return;
              label937:
              i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).getVideoWidth();
              break;
              j = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).getVideoHeight();
              break label302;
              localJSONException3 = localJSONException3;
              Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onVideoLoadedMetaData fail", new Object[] { localJSONException3 });
            }
            localJSONException4 = localJSONException4;
            Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingMoovReport fail", new Object[] { localJSONException4 });
          }
          catch (JSONException localJSONException5)
          {
            for (;;)
            {
              Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingPreDataReport fail", new Object[] { localJSONException5 });
              continue;
              label1034:
              localObject1 = ((j)localObject1).XoI;
              continue;
              label1044:
              localObject1 = ((j)localObject1).XoI;
              continue;
              label1054:
              bool = ((Boolean)((j)localObject3).vZK.getValue()).booleanValue();
            }
          }
        }
      }
    }
    label1100:
    label1110:
    label1144:
    Log.i(paramj.getTAG(), "onPrepared, stop video auto play when webview in background");
    label1161:
    if ((paramj.eDv) || (paramj.eDt)) {}
    for (boolean bool = true;; bool = false)
    {
      paramj.eyN = new AtomicBoolean(bool);
      AppMethodBeat.o(297367);
      return;
    }
  }
  
  private final void dhZ()
  {
    AppMethodBeat.i(297189);
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      s.checkNotNull(localSurface);
      localSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(297189);
  }
  
  private final void dif()
  {
    AppMethodBeat.i(297157);
    if (!Util.isNullOrNil(this.eDD))
    {
      if ((this.eDw) && (auT() != null) && (this.XoM != null))
      {
        if (this.XoM.a(this.eDD, this.eyz, this.eyA, this.mVideoWidth, this.mVideoHeight))
        {
          this.eDS = this.XoM.sQQ;
          this.eDT = this.XoM.sQR;
          Log.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.eDD, Float.valueOf(this.eDS), Float.valueOf(this.eDT) });
          com.tencent.luggage.xweb_ext.extendplugin.d.a(auT(), this.type, getId(), this.eDS, this.eDT);
          AppMethodBeat.o(297157);
        }
      }
      else
      {
        Log.i(getTAG(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(297157);
      }
    }
    else {
      Log.i(getTAG(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(297157);
  }
  
  private static final void e(j paramj)
  {
    AppMethodBeat.i(297379);
    s.u(paramj, "this$0");
    if (paramj.XoJ)
    {
      if ((paramj.eDi != null) && (paramj.eDw) && (paramj.eyN == null))
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = paramj.eDi;
        if ((localg != null) && (localg.isPlaying() == true)) {}
        for (boolean bool = true;; bool = false)
        {
          paramj.eyN = new AtomicBoolean(bool);
          Log.i(paramj.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
          paramj.pause();
          AppMethodBeat.o(297379);
          return;
        }
      }
    }
    else
    {
      if (paramj.auy())
      {
        Log.i(paramj.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { paramj.type });
        paramj.IZ(true);
        AppMethodBeat.o(297379);
        return;
      }
      Log.i(paramj.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { paramj.type });
    }
    AppMethodBeat.o(297379);
  }
  
  private final int getDuration()
  {
    AppMethodBeat.i(297203);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = this.eDi;
    if (localg == null)
    {
      AppMethodBeat.o(297203);
      return 0;
    }
    int i = localg.getDuration();
    AppMethodBeat.o(297203);
    return i;
  }
  
  private final void iBW()
  {
    AppMethodBeat.i(297137);
    Log.i(getTAG(), "createMediaPlayer");
    Object localObject1 = this.eDL;
    long l = System.currentTimeMillis();
    Object localObject2 = com.tencent.mm.plugin.webview.k.k.Xtc;
    boolean bool = com.tencent.mm.plugin.webview.k.k.iCU();
    if (bool)
    {
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      localObject1 = new com.tencent.mm.plugin.appbrand.ag.b.a.d((Context)localObject1);
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.a)localObject1;
      l = System.currentTimeMillis() - l;
      Log.i(getTAG(), "createMediaPlayer  useThumbPlayer:" + bool + "  cost %s", new Object[] { Long.valueOf(l) });
      localObject2 = this.XoN;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 11L, l, false);
      ((k)localObject2).XoR.sSF = l;
      this.eDi = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1);
      if (this.eDi == null) {
        break label266;
      }
    }
    label266:
    for (bool = true;; bool = false)
    {
      this.eDx = bool;
      if (this.eDx) {
        break label271;
      }
      Log.e(getTAG(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(297137);
      return;
      if (this.vZF)
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j((Handler)localObject1, this.dhq, this.dhu, this.sGk, this.sGl, this.sGm, this.sGn);
        break;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j((Handler)localObject1);
      break;
    }
    label271:
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda6(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda4(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda7(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda2(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda8(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda9(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda1(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda3(this));
    }
    localObject1 = this.eDi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).a(new j..ExternalSyntheticLambda5(this));
    }
    localObject1 = this.XoL;
    if (localObject1 != null)
    {
      Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onStartPlayerReport");
      localObject2 = com.tencent.mm.plugin.webview.k.k.Xtc;
      if (com.tencent.mm.plugin.webview.k.k.iCU()) {
        try
        {
          ((WebViewVideoEventHandler)localObject1).q("StartPlayer", null);
          AppMethodBeat.o(297137);
          return;
        }
        catch (JSONException localJSONException)
        {
          Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onStartPlayerReport fail", new Object[] { localJSONException });
        }
      }
    }
    AppMethodBeat.o(297137);
  }
  
  private final void iBX()
  {
    AppMethodBeat.i(297168);
    this.eDF = true;
    Log.d(getTAG(), "handleWebViewBackground");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    o(new j..ExternalSyntheticLambda13(this));
    AppMethodBeat.o(297168);
  }
  
  private final void iBY()
  {
    AppMethodBeat.i(297175);
    this.eDE = false;
    auC();
    iBW();
    if (this.eDi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = this.eDi;
      if (localg != null) {
        localg.setMute(this.eDz);
      }
      if (this.mSurface != null) {
        if (!this.eDF)
        {
          Log.i(getTAG(), "applyMediaPlayerParams, setSurface");
          localg = this.eDi;
          if (localg != null)
          {
            localg.setSurface(this.mSurface);
            AppMethodBeat.o(297175);
          }
        }
        else
        {
          Log.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
        }
      }
    }
    AppMethodBeat.o(297175);
  }
  
  private final boolean nw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297147);
    if (!this.eDx)
    {
      Log.i(getTAG(), "onMediaPlayerInfo, mp released");
      AppMethodBeat.o(297147);
      return false;
    }
    Log.i(getTAG(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    boolean bool;
    Object localObject2;
    if (paramInt1 == 701)
    {
      localObject1 = this.eDi;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).isPlaying() == true))
      {
        bool = true;
        this.eDs = bool;
        Log.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.eDs) });
        if (atY())
        {
          localObject1 = this.XoL;
          if (localObject1 != null) {
            ((WebViewVideoEventHandler)localObject1).onVideoWaiting();
          }
        }
        localObject1 = this.XoL;
        if (localObject1 != null)
        {
          Log.i(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingBufferReadyReport");
          localObject2 = com.tencent.mm.plugin.webview.k.k.Xtc;
          if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        WebViewVideoEventHandler.a((WebViewVideoEventHandler)localObject1, "WaitingBufferReady");
        localObject1 = this.XoN;
        if (((k)localObject1).XoR.sSM <= 0L)
        {
          localObject2 = ((k)localObject1).XoR;
          ((k.b)localObject2).sSK += 1;
          ((k)localObject1).XoR.sSM = Util.nowMilliSecond();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 30L, 1L, false);
        }
        localObject1 = this.eDi;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).isPlaying() != true)) {
          break label781;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) && (this.eDF) && (this.XoJ))
        {
          this.eyN = new AtomicBoolean(true);
          pause();
        }
        AppMethodBeat.o(297147);
        return false;
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        Log.e(((WebViewVideoEventHandler)localObject1).TAG, "onWaitingBufferReadyReport fail", new Object[] { localJSONException });
        continue;
      }
      if (paramInt1 == 702)
      {
        localObject1 = this.eDi;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).isPlaying() == true))
        {
          bool = true;
          label374:
          Log.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.eDs), Boolean.valueOf(bool) });
          if (!this.eDs) {
            break label629;
          }
          this.eDs = false;
          if ((bool) && (atY()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video play");
            localObject1 = this.XoL;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).iBT();
            }
            localObject1 = this.XoL;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).iBV();
            }
          }
        }
        for (;;)
        {
          localObject1 = this.XoN;
          if ((((k)localObject1).XoR.sSN <= 0L) && (((k)localObject1).XoR.sSM > 0L))
          {
            ((k)localObject1).XoR.sSN = Util.nowMilliSecond();
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 31L, 1L, false);
            long l = ((k)localObject1).XoR.sSN - ((k)localObject1).XoR.sSM;
            k.b localb = ((k)localObject1).XoR;
            localb.sSL += l;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 32L, l, false);
            Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
          }
          localObject1 = ((k)localObject1).XoR;
          ((k.b)localObject1).sSM = 0L;
          ((k.b)localObject1).sSN = 0L;
          break;
          bool = false;
          break label374;
          label629:
          if ((!bool) && (atY()))
          {
            Log.i(getTAG(), "onInfo, buffering end, notify video pause");
            localObject1 = this.XoL;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).iBU();
            }
            localObject1 = this.XoL;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).iBV();
            }
          }
        }
      }
      if (paramInt2 == -1004)
      {
        Log.i(getTAG(), "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject1 = this.eDl;
        if (localObject1 != null) {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject1).di(paramInt1, paramInt2);
        }
      }
      else if (paramInt1 == 3)
      {
        if (!this.eDx)
        {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
        }
        else
        {
          Log.i(getTAG(), "onMediaPlayerVideoFirstFrame");
          continue;
          label781:
          paramInt1 = 0;
        }
      }
    }
  }
  
  private final boolean o(Runnable paramRunnable)
  {
    AppMethodBeat.i(297195);
    if (s.p(this.eDL.getLooper(), Looper.myLooper())) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(297195);
      return true;
      this.eDL.post(paramRunnable);
    }
  }
  
  private final boolean pause()
  {
    int j = 0;
    AppMethodBeat.i(297211);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    if (this.eDi != null)
    {
      if (!this.eDw)
      {
        Log.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
        this.eDt = false;
        AppMethodBeat.o(297211);
        return true;
      }
      Object localObject = this.eDi;
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).isPlaying() == true) {
          i = 1;
        }
      }
      if (i == 0)
      {
        Log.i(getTAG(), "video pause, video is not playing");
        AppMethodBeat.o(297211);
        return true;
      }
      Log.i(getTAG(), "video pause");
      localObject = this.eDi;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).pause();
      }
      if (atY())
      {
        localObject = this.XoL;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).iBU();
        }
      }
      AppMethodBeat.o(297211);
      return true;
    }
    AppMethodBeat.o(297211);
    return false;
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(297164);
    Object localObject;
    if (this.eDi != null)
    {
      Log.i(getTAG(), "video prepare async");
      if (atY())
      {
        localObject = this.XoL;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).onVideoWaiting();
        }
      }
      localObject = this.XoL;
      if (localObject != null)
      {
        Log.i(((WebViewVideoEventHandler)localObject).TAG, "onStartDownloadReport");
        com.tencent.mm.plugin.webview.k.k localk = com.tencent.mm.plugin.webview.k.k.Xtc;
        if (!com.tencent.mm.plugin.webview.k.k.iCU()) {}
      }
    }
    try
    {
      ((WebViewVideoEventHandler)localObject).q("StartDownload", null);
      this.eDw = false;
      this.eDt = false;
      localObject = this.eDi;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).prepareAsync();
      }
      localObject = this.XoN;
      if (((k)localObject).XoR.sSH <= 0L)
      {
        ((k)localObject).XoR.sSH = Util.nowMilliSecond();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 20L, 1L, false);
      }
      AppMethodBeat.o(297164);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(((WebViewVideoEventHandler)localObject).TAG, "onStartDownloadReport fail", new Object[] { localJSONException });
      }
    }
  }
  
  private final void seek(long paramLong)
  {
    AppMethodBeat.i(297222);
    if ((this.eDw) && (this.eDi != null))
    {
      Object localObject;
      if (atY())
      {
        localObject = this.XoL;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).onVideoWaiting();
        }
      }
      if (this.eDi != null)
      {
        localObject = this.eDi;
        if (localObject == null) {}
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).isPlaying())
        {
          this.eDr = bool;
          paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
          Log.i(getTAG(), "seek, position:%s, isPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.eDr) });
          localObject = this.eDi;
          if (localObject == null) {
            break;
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).seekTo(paramLong);
          AppMethodBeat.o(297222);
          return;
        }
      }
    }
    else
    {
      this.eDu = paramLong;
    }
    AppMethodBeat.o(297222);
  }
  
  private final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(297253);
    this.XoI = paramString;
    Object localObject = com.tencent.mm.plugin.webview.k.k.Xtc;
    if (com.tencent.mm.plugin.webview.k.k.iCU())
    {
      localObject = this.eDi;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).cM(paramString, this.XoK);
      }
    }
    label114:
    for (;;)
    {
      localObject = this.XoL;
      if (localObject != null) {
        ((WebViewVideoEventHandler)localObject).dx(com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().f(paramString, 0L, 9223372036854775807L));
      }
      AppMethodBeat.o(297253);
      return;
      com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD();
      String str = com.tencent.mm.plugin.appbrand.jsapi.video.i.abO(paramString);
      localObject = this.eDi;
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)) {}
      for (localObject = (com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label114;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject).ez(paramString, str);
        break;
      }
    }
  }
  
  private final boolean stop()
  {
    AppMethodBeat.i(297216);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this));
    Object localObject = this.eDi;
    if (localObject != null)
    {
      this.XoN.a(this.eyx, (com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject);
      if (!this.eDw)
      {
        Log.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
        this.eDt = false;
        AppMethodBeat.o(297216);
        return true;
      }
      Log.i(getTAG(), "video stop");
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject).stop();
      if (atY())
      {
        localObject = this.XoL;
        if (localObject != null) {
          ((WebViewVideoEventHandler)localObject).iBU();
        }
      }
      AppMethodBeat.o(297216);
      return true;
    }
    AppMethodBeat.o(297216);
    return false;
  }
  
  final boolean IZ(boolean paramBoolean)
  {
    AppMethodBeat.i(297526);
    if ((this.eDF) && (this.XoJ))
    {
      Log.e(getTAG(), "play, background not allow play");
      AppMethodBeat.o(297526);
      return true;
    }
    if (this.eDi != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
      int i;
      if (this.eDw)
      {
        localObject1 = this.eDi;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).isPlaying() == true)) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i(getTAG(), "video play, video is playing");
          if (atY())
          {
            localObject1 = this.XoL;
            if (localObject1 != null) {
              ((WebViewVideoEventHandler)localObject1).iBT();
            }
          }
          AppMethodBeat.o(297526);
          return true;
        }
      }
      if (!this.eDw)
      {
        Log.i(getTAG(), "video play, video not prepared yet, start until prepared");
        this.eDt = true;
        AppMethodBeat.o(297526);
        return true;
      }
      Object localObject1 = this.eDi;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject1).getState() == 5)) {
        i = 1;
      }
      while (i != 0) {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(297526);
          return false;
          i = 0;
        }
        else
        {
          Log.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
          prepareAsync();
          this.eDt = true;
          AppMethodBeat.o(297526);
          return true;
        }
      }
      Object localObject2;
      if (this.eDE)
      {
        if (!paramBoolean)
        {
          Log.i(getTAG(), "video has ended playing, do not restart");
          AppMethodBeat.o(297526);
          return false;
        }
        Log.i(getTAG(), "video play, video has ended playing, clear surface and start again");
        this.eDE = false;
        Object localObject4;
        try
        {
          if ((this.mSurface != null) && (this.eDw))
          {
            Log.i(getTAG(), "clearSurfaceTexture");
            localObject4 = this.mSurface;
            s.checkNotNull(localObject4);
            localObject1 = EGLContext.getEGL();
            if (localObject1 != null) {
              break label442;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(297526);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(getTAG(), (Throwable)localException, "clearSurfaceTexture error", new Object[0]);
        }
        iBY();
        Object localObject3;
        if (this.eDi != null)
        {
          this.eDv = true;
          setDataSourceWithCustomKey(this.eDC);
          localObject3 = getTAG();
          localObject2 = this.eDi;
          if (localObject2 != null) {
            break label731;
          }
        }
        label442:
        label731:
        for (localObject2 = null;; localObject2 = Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).getState()))
        {
          Log.i((String)localObject3, "video play, media player state:%s", new Object[] { localObject2 });
          prepareAsync();
          this.eDt = true;
          AppMethodBeat.o(297526);
          return true;
          localObject2 = (EGL10)localObject2;
          localObject3 = ((EGL10)localObject2).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
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
          break;
        }
      }
      Log.i(getTAG(), "video play");
      if (this.eDi != null)
      {
        if (atY())
        {
          localObject2 = this.XoL;
          if (localObject2 != null) {
            ((WebViewVideoEventHandler)localObject2).iBT();
          }
        }
        localObject2 = this.eDi;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.jsapi.video.e.g)localObject2).start();
        }
      }
      AppMethodBeat.o(297526);
      return true;
    }
    AppMethodBeat.o(297526);
    return false;
  }
  
  public final void atW()
  {
    AppMethodBeat.i(297495);
    o(new j..ExternalSyntheticLambda15(this));
    AppMethodBeat.o(297495);
  }
  
  final boolean auy()
  {
    AppMethodBeat.i(297484);
    AtomicBoolean localAtomicBoolean = this.eyN;
    if (localAtomicBoolean == null)
    {
      AppMethodBeat.o(297484);
      return false;
    }
    boolean bool = localAtomicBoolean.get();
    AppMethodBeat.o(297484);
    return bool;
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(297491);
    s.u(paramSurfaceTexture, "surfaceTexture");
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(297491);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297488);
    s.u(parama, "invokeContext");
    AppMethodBeat.o(297488);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(297514);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = this.eDi;
    if (localg == null)
    {
      AppMethodBeat.o(297514);
      return 0;
    }
    int i = localg.getCurrentPosition();
    AppMethodBeat.o(297514);
    return i;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(297478);
    String str = (String)this.sMn.getValue();
    AppMethodBeat.o(297478);
    return str;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(297500);
    s.u(parama, "invokeContext");
    o(new j..ExternalSyntheticLambda10(parama, this));
    AppMethodBeat.o(297500);
    return null;
  }
  
  public final void hUG()
  {
    AppMethodBeat.i(297486);
    Object localObject = new WebViewVideoEventHandler();
    ((WebViewVideoEventHandler)localObject).Xoz = this;
    ah localah = ah.aiuX;
    this.XoL = ((WebViewVideoEventHandler)localObject);
    this.eDl = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)new i());
    localObject = this.eDl;
    if (localObject != null) {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).a(new j..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(297486);
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(297493);
    s.u(paramSurface, "surface");
    super.i(paramSurface);
    o(new j..ExternalSyntheticLambda20(this, paramSurface));
    AppMethodBeat.o(297493);
  }
  
  /* Error */
  final void release()
  {
    // Byte code:
    //   0: ldc_w 1870
    //   3: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 523	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:getTAG	()Ljava/lang/String;
    //   10: ldc_w 1872
    //   13: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: new 16	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j$h
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 1873	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j$h:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/j;)V
    //   24: checkcast 384	kotlin/g/a/a
    //   27: invokestatic 1575	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
    //   30: aload_0
    //   31: getfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
    //   34: ifnull +126 -> 160
    //   37: aload_0
    //   38: getfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +22 -> 65
    //   46: new 575	java/lang/NullPointerException
    //   49: dup
    //   50: ldc_w 1875
    //   53: invokespecial 579	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: ldc_w 1870
    //   60: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: aload_2
    //   66: getfield 1879	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:Xoy	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/f;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +183 -> 254
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: instanceof 1881
    //   80: ifeq +196 -> 276
    //   83: aload_1
    //   84: checkcast 1881	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/c
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +13 -> 102
    //   92: aload_1
    //   93: aload_2
    //   94: getfield 1885	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoD	Lcom/tencent/mm/plugin/webview/ui/tools/video/c;
    //   97: invokeinterface 1888 2 0
    //   102: aload_2
    //   103: getfield 1892	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:WXe	Lcom/tencent/mm/bj/a;
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1897	com/tencent/mm/bj/a:disable	()V
    //   115: aload_2
    //   116: getfield 1901	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoE	Landroid/database/ContentObserver;
    //   119: ifnull +24 -> 143
    //   122: invokestatic 1091	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   125: invokevirtual 1907	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   128: astore_1
    //   129: aload_2
    //   130: getfield 1901	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoE	Landroid/database/ContentObserver;
    //   133: astore_3
    //   134: aload_3
    //   135: invokestatic 929	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   138: aload_1
    //   139: aload_3
    //   140: invokevirtual 1913	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   143: aload_2
    //   144: getfield 1917	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoF	Landroid/content/BroadcastReceiver;
    //   147: ifnull +13 -> 160
    //   150: invokestatic 1091	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   153: aload_2
    //   154: getfield 1917	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoF	Landroid/content/BroadcastReceiver;
    //   157: invokevirtual 1921	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   160: aload_0
    //   161: invokespecial 837	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:stop	()Z
    //   164: pop
    //   165: aload_0
    //   166: invokespecial 1581	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:auC	()V
    //   169: aload_0
    //   170: getfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 1924	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:cwt	()V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
    //   187: aload_0
    //   188: getfield 1263	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:eDl	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/c;
    //   191: ifnull +8 -> 199
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 1263	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:eDl	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/c;
    //   199: aload_0
    //   200: invokespecial 940	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:dhZ	()V
    //   203: aload_0
    //   204: invokevirtual 523	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:getTAG	()Ljava/lang/String;
    //   207: ldc_w 1926
    //   210: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: getfield 461	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:eDL	Landroid/os/Handler;
    //   217: aconst_null
    //   218: invokevirtual 1929	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   221: aload_0
    //   222: getfield 420	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:JV	Landroid/os/HandlerThread;
    //   225: invokevirtual 1932	android/os/HandlerThread:quitSafely	()Z
    //   228: pop
    //   229: aload_0
    //   230: getfield 683	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:XoL	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 1935	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:iBS	()V
    //   242: aload_0
    //   243: aconst_null
    //   244: putfield 669	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/j:eyx	Lcom/tencent/luggage/xweb_ext/extendplugin/a;
    //   247: ldc_w 1870
    //   250: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: return
    //   254: aload_1
    //   255: getfield 1941	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/f:Xnu	Lcom/tencent/mm/plugin/webview/jsapi/h;
    //   258: astore_1
    //   259: aload_1
    //   260: ifnonnull +8 -> 268
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -189 -> 76
    //   268: aload_1
    //   269: getfield 1947	com/tencent/mm/plugin/webview/jsapi/h:context	Landroid/content/Context;
    //   272: astore_1
    //   273: goto -197 -> 76
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -190 -> 88
    //   281: astore_1
    //   282: aload_2
    //   283: getfield 973	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:TAG	Ljava/lang/String;
    //   286: aload_1
    //   287: ldc_w 1948
    //   290: iconst_0
    //   291: anewarray 623	java/lang/Object
    //   294: invokestatic 1748	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: goto -154 -> 143
    //   300: astore_1
    //   301: aload_2
    //   302: getfield 973	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:TAG	Ljava/lang/String;
    //   305: aload_1
    //   306: ldc_w 1948
    //   309: iconst_0
    //   310: anewarray 623	java/lang/Object
    //   313: invokestatic 1748	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: goto -156 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	j
    //   56	222	1	localObject	Object
    //   281	6	1	localThrowable1	Throwable
    //   300	6	1	localThrowable2	Throwable
    //   41	261	2	localWebViewVideoEventHandler	WebViewVideoEventHandler
    //   133	7	3	localContentObserver	android.database.ContentObserver
    // Exception table:
    //   from	to	target	type
    //   122	143	281	finally
    //   150	160	300	finally
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(297535);
    super.y(paramBitmap);
    com.tencent.luggage.xweb_ext.extendplugin.a locala = this.eDM;
    if (locala == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
      AppMethodBeat.o(297535);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
      locala.fO("fail");
      AppMethodBeat.o(297535);
      return;
    }
    if ((this.eyz != 0) && (this.eyA != 0)) {}
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.eDS * this.eyz), (int)(this.eDT * this.eyA), false);; localBitmap = paramBitmap)
    {
      Object localObject1 = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      s.s(localObject1, "encode(b, Base64.NO_WRAP)");
      Object localObject2 = StandardCharsets.UTF_8;
      s.s(localObject2, "UTF_8");
      localObject1 = new String((byte[])localObject1, (Charset)localObject2);
      Log.i(getTAG(), s.X("handlePluginScreenshotTaken size=", Integer.valueOf(((String)localObject1).length())));
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("image", localObject1);
      locala.e("ok", (Map)localObject2);
      aW(paramBitmap);
      aW(localBitmap);
      this.eDM = null;
      AppMethodBeat.o(297535);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d.a
  {
    public final void bAi() {}
    
    public final void bAj() {}
    
    public final void bAk() {}
    
    public final void bAl() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements a.a
  {
    g(j paramj) {}
    
    public final void my(int paramInt)
    {
      AppMethodBeat.i(297149);
      if (1 == paramInt)
      {
        Object localObject = this.XoO.eyx;
        if ((localObject instanceof f))
        {
          localObject = (f)localObject;
          if (localObject != null) {
            break label82;
          }
        }
        label82:
        for (localObject = null;; localObject = ((f)localObject).Xnu)
        {
          if (localObject != null)
          {
            Context localContext = MMApplicationContext.getContext();
            s.s(localContext, "getContext()");
            ((com.tencent.mm.plugin.webview.jsapi.h)localObject).setContext(localContext);
          }
          localObject = this.XoO.XoL;
          if (localObject == null) {
            break label97;
          }
          ((WebViewVideoEventHandler)localObject).iBS();
          AppMethodBeat.o(297149);
          return;
          localObject = null;
          break;
        }
      }
      j.f(this.XoO);
      label97:
      AppMethodBeat.o(297149);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(297156);
      this.XoO.release();
      AppMethodBeat.o(297156);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(297144);
      j localj = this.XoO;
      localj.eDF = false;
      Log.d(localj.getTAG(), "handleWebViewForeground");
      boolean bool = localj.auy();
      localj.eyN = null;
      if ((localj.eDi != null) && (localj.eDw) && (bool))
      {
        Log.i(localj.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
        localj.IZ(false);
      }
      AppMethodBeat.o(297144);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.j
 * JD-Core Version:    0.7.0.1
 */