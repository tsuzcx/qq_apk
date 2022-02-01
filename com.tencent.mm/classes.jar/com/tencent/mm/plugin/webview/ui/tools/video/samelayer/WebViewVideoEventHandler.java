package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a.a;
import com.tencent.mm.br.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mCurrentVideoPathPlayCount", "mEventDataObject", "Lorg/json/JSONObject;", "mLastPlayVideoPath", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "generateWaitingReadyExtInfo", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onBufferReadyReport", "onPlayerProcessStateChanged", "event", "onPlayingReport", "onStartDownloadReport", "onStartPlayerReport", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "onWaitingBufferReadyReport", "onWaitingMoovReport", "onWaitingPlayReport", "onWaitingPreDataReport", "onWaitingReadyReport", "removeFullScreenListener", "resetInvokeContext", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "BrightnessObserver", "Companion", "VolumeBroadcastReceiver", "plugin-webview_release"})
public final class WebViewVideoEventHandler
{
  public static final WebViewVideoEventHandler.b Qwk;
  private int JCi;
  com.tencent.mm.br.a Qfg;
  f Qwc;
  k Qwd;
  String Qwe;
  int Qwf;
  private JSONObject Qwg;
  com.tencent.mm.plugin.webview.ui.tools.video.c Qwh;
  ContentObserver Qwi;
  BroadcastReceiver Qwj;
  final String TAG;
  private int aKW;
  double pLW;
  private int pLm;
  private MTimerHandler pzi;
  
  static
  {
    AppMethodBeat.i(227786);
    Qwk = new WebViewVideoEventHandler.b((byte)0);
    AppMethodBeat.o(227786);
  }
  
  public WebViewVideoEventHandler()
  {
    AppMethodBeat.i(227783);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.Qwh = ((com.tencent.mm.plugin.webview.ui.tools.video.c)new c(this));
    this.JCi = -1;
    AppMethodBeat.o(227783);
  }
  
  final JSONObject bWg()
  {
    AppMethodBeat.i(227769);
    JSONObject localJSONObject = new JSONObject();
    if (this.Qwg != null) {
      localJSONObject.put("data", this.Qwg);
    }
    AppMethodBeat.o(227769);
    return localJSONObject;
  }
  
  final void bWh()
  {
    AppMethodBeat.i(227767);
    Log.i(this.TAG, "stop video update timer");
    MTimerHandler localMTimerHandler = this.pzi;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.stopTimer();
      AppMethodBeat.o(227767);
      return;
    }
    AppMethodBeat.o(227767);
  }
  
  final void bYB()
  {
    AppMethodBeat.i(227778);
    MMHandlerThread.postToMainThread((Runnable)new g(this));
    AppMethodBeat.o(227778);
  }
  
  public final void bf(long paramLong)
  {
    AppMethodBeat.i(227752);
    Log.d(this.TAG, "onVideoPreLoadedMetaData cachedSize=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 6L, 1L, false);
    if (paramLong > 0L) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 7L, 1L, false);
    }
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("preloadSize", paramLong);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(227752);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(227752);
    }
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(227775);
    Object localObject = this.Qwc;
    if (localObject != null)
    {
      paramJSONObject.put("__timestamp", System.currentTimeMillis());
      String str = ((f)localObject).hbC();
      if (!Util.isNullOrNil(str))
      {
        localObject = ((f)localObject).QvF.PNo.gUc();
        if (localObject != null)
        {
          if (str == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.webview.l.k)localObject).bd(str, paramString, paramJSONObject.toString());
          AppMethodBeat.o(227775);
          return;
        }
        AppMethodBeat.o(227775);
        return;
      }
      ((f)localObject).QvF.PNo.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(227775);
      return;
    }
    AppMethodBeat.o(227775);
  }
  
  public final void ew(String paramString)
  {
    AppMethodBeat.i(227756);
    if (paramString != null) {
      try
      {
        this.Qwg = new JSONObject(paramString);
        AppMethodBeat.o(227756);
        return;
      }
      catch (Exception paramString)
      {
        Log.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(227756);
        return;
      }
    }
    AppMethodBeat.o(227756);
  }
  
  public final void hbF()
  {
    AppMethodBeat.i(227742);
    Object localObject = this.Qwc;
    if (localObject != null)
    {
      localObject = ((f)localObject).QvF;
      if (localObject != null)
      {
        Context localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        ((com.tencent.mm.plugin.webview.d.f)localObject).setContext(localContext);
        AppMethodBeat.o(227742);
        return;
      }
    }
    AppMethodBeat.o(227742);
  }
  
  public final void hbG()
  {
    AppMethodBeat.i(227750);
    try
    {
      this.pLm = 0;
      dispatchEvent("onVideoPlay", bWg());
      Log.i(this.TAG, "start video update timer");
      if (this.pzi == null)
      {
        Log.i(this.TAG, "start video update timer, create new timer");
        this.pzi = new MTimerHandler("VideoUpdateTimer", (MTimerHandler.CallBack)new f(this), true);
      }
      Object localObject = this.pzi;
      if (localObject != null) {
        ((MTimerHandler)localObject).startTimer(0L, 250L);
      }
      MMHandlerThread.postToMainThread((Runnable)new e(this));
      Log.i(this.TAG, "onPlayingReport");
      localObject = this.Qwd;
      if ((localObject != null) && (!((k)localObject).cBL()))
      {
        AppMethodBeat.o(227750);
        return;
      }
      return;
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        m("Playing", null);
        AppMethodBeat.o(227750);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Log.e(this.TAG, "onPlayingReport fail", new Object[] { localJSONException2 });
        AppMethodBeat.o(227750);
      }
      localJSONException1 = localJSONException1;
      Log.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException1 });
      AppMethodBeat.o(227750);
      return;
    }
  }
  
  public final void hbH()
  {
    AppMethodBeat.i(227754);
    try
    {
      dispatchEvent("onVideoPause", bWg());
      bWh();
      bYB();
      AppMethodBeat.o(227754);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(this.TAG, "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void hbI()
  {
    AppMethodBeat.i(227765);
    Log.i(this.TAG, "onBufferReadyReport");
    k localk = this.Qwd;
    if ((localk != null) && (!localk.cBL()))
    {
      AppMethodBeat.o(227765);
      return;
    }
    try
    {
      m("BufferReady", null);
      AppMethodBeat.o(227765);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onBufferReadyReport fail", new Object[] { localJSONException });
      AppMethodBeat.o(227765);
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(227740);
    if ((parama instanceof f))
    {
      this.Qwc = ((f)parama);
      Object localObject = ((f)parama).QvF.context;
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
      if (!(localObject instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.Qwh);
      }
      parama = MMApplicationContext.getContext();
      p.j(parama, "MMApplicationContext.getContext()");
      if (this.Qfg == null) {
        this.Qfg = new com.tencent.mm.br.a(parama, (a.b)new d(this));
      }
      if (this.Qwi == null)
      {
        this.Qwi = ((ContentObserver)new WebViewVideoEventHandler.a(new Handler(), new WeakReference(this)));
        parama = MMApplicationContext.getContext();
        p.j(parama, "MMApplicationContext.getContext()");
        parama = parama.getApplicationContext();
        p.j(parama, "MMApplicationContext.get…text().applicationContext");
        parama = parama.getContentResolver();
        localObject = Settings.System.getUriFor("screen_brightness");
      }
      try
      {
        ContentObserver localContentObserver = this.Qwi;
        if (localContentObserver == null) {
          p.iCn();
        }
        parama.registerContentObserver((Uri)localObject, false, localContentObserver);
      }
      catch (Throwable parama)
      {
        try
        {
          parama = new IntentFilter();
          parama.addAction("android.media.VOLUME_CHANGED_ACTION");
          MMApplicationContext.getContext().registerReceiver(this.Qwj, parama);
          parama = this.Qfg;
          if (parama == null) {
            break label307;
          }
          parama.enable();
          AppMethodBeat.o(227740);
          return;
          parama = parama;
          Log.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
        }
        catch (Throwable parama)
        {
          for (;;)
          {
            Log.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
      }
      if (this.Qwj == null) {
        this.Qwj = ((BroadcastReceiver)new WebViewVideoEventHandler.VolumeBroadcastReceiver(new WeakReference(this)));
      }
    }
    label307:
    AppMethodBeat.o(227740);
  }
  
  final void m(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(227758);
    Log.i(this.TAG, "onPlayerProcessStateChanged event=".concat(String.valueOf(paramString)));
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = bWg();
      localJSONObject.put("event", paramString);
      dispatchEvent("onPlayerProcessStateChanged", localJSONObject);
      AppMethodBeat.o(227758);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e(this.TAG, "onPlayerProcessStateChanged " + paramString + " fail", new Object[] { paramJSONObject });
      AppMethodBeat.o(227758);
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(227746);
    try
    {
      dispatchEvent("onVideoWaiting", bWg());
      AppMethodBeat.o(227746);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(227746);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class c
    extends com.tencent.mm.plugin.webview.ui.tools.video.c
  {
    public final void PS()
    {
      AppMethodBeat.i(231381);
      try
      {
        JSONObject localJSONObject = WebViewVideoEventHandler.a(this.Qwm);
        WebViewVideoEventHandler.a(this.Qwm, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(231381);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(WebViewVideoEventHandler.e(this.Qwm), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(231381);
      }
    }
    
    public final void bOO()
    {
      AppMethodBeat.i(231382);
      try
      {
        JSONObject localJSONObject = WebViewVideoEventHandler.a(this.Qwm);
        WebViewVideoEventHandler.a(this.Qwm, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(231382);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(WebViewVideoEventHandler.e(this.Qwm), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(231382);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class d
    implements a.b
  {
    d(WebViewVideoEventHandler paramWebViewVideoEventHandler) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(221627);
      parama1 = this.Qwm;
      if (parama2 == null)
      {
        AppMethodBeat.o(221627);
        return;
      }
      int i;
      switch (j.$EnumSwitchMapping$0[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(221627);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        WebViewVideoEventHandler.a(parama1, i);
        if (WebViewVideoEventHandler.f(this.Qwm) != WebViewVideoEventHandler.g(this.Qwm)) {
          break;
        }
        AppMethodBeat.o(221627);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      WebViewVideoEventHandler.b(this.Qwm, WebViewVideoEventHandler.f(this.Qwm));
      Log.i(WebViewVideoEventHandler.e(this.Qwm), "onOrientationsChange currentOrientation=" + WebViewVideoEventHandler.f(this.Qwm));
      try
      {
        parama1 = WebViewVideoEventHandler.a(this.Qwm);
        parama1.put("newOrientation", WebViewVideoEventHandler.f(this.Qwm));
        if (WebViewVideoEventHandler.h(this.Qwm)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          WebViewVideoEventHandler.a(this.Qwm, "onOrientationsChange", parama1);
          AppMethodBeat.o(221627);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        Log.e(WebViewVideoEventHandler.e(this.Qwm), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(221627);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(WebViewVideoEventHandler paramWebViewVideoEventHandler) {}
    
    public final void run()
    {
      AppMethodBeat.i(216436);
      if (WebViewVideoEventHandler.d(this.Qwm) != null)
      {
        Object localObject = WebViewVideoEventHandler.d(this.Qwm);
        if (localObject == null) {
          p.iCn();
        }
        if ((((f)localObject).QvF.context instanceof Activity))
        {
          Log.i(WebViewVideoEventHandler.e(this.Qwm), "startKeepScreenOn");
          try
          {
            localObject = WebViewVideoEventHandler.d(this.Qwm);
            if (localObject == null) {
              p.iCn();
            }
            localObject = ((f)localObject).QvF.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(216436);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            Log.e(WebViewVideoEventHandler.e(this.Qwm), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(216436);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(216436);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements MTimerHandler.CallBack
  {
    f(WebViewVideoEventHandler paramWebViewVideoEventHandler) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(246208);
      if (WebViewVideoEventHandler.b(this.Qwm) != null)
      {
        WebViewVideoEventHandler localWebViewVideoEventHandler = this.Qwm;
        k localk = WebViewVideoEventHandler.b(this.Qwm);
        if (localk == null) {
          p.iCn();
        }
        WebViewVideoEventHandler.a(localWebViewVideoEventHandler, localk.getCurrentPosition(), (int)(WebViewVideoEventHandler.c(this.Qwm) * 1000.0D));
      }
      AppMethodBeat.o(246208);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(WebViewVideoEventHandler paramWebViewVideoEventHandler) {}
    
    public final void run()
    {
      AppMethodBeat.i(268163);
      if (WebViewVideoEventHandler.d(this.Qwm) != null)
      {
        Object localObject = WebViewVideoEventHandler.d(this.Qwm);
        if (localObject == null) {
          p.iCn();
        }
        if ((((f)localObject).QvF.context instanceof Activity))
        {
          Log.i(WebViewVideoEventHandler.e(this.Qwm), "startKeepScreenOn");
          try
          {
            localObject = WebViewVideoEventHandler.d(this.Qwm);
            if (localObject == null) {
              p.iCn();
            }
            localObject = ((f)localObject).QvF.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(268163);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            Log.e(WebViewVideoEventHandler.e(this.Qwm), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(268163);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(268163);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler
 * JD-Core Version:    0.7.0.1
 */