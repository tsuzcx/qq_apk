package com.tencent.mm.plugin.webview.ui.tools.c.a;

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
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.c.b;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.initVolumeBroadcastReceiver.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "Companion", "plugin-webview_release"})
public final class j
{
  public static final j.a CLY;
  f CLT;
  l CLU;
  private JSONObject CLV;
  b CLW;
  private int CLX;
  com.tencent.mm.bo.a Cze;
  ContentObserver Haf;
  BroadcastReceiver Hag;
  final String TAG;
  private int aRj;
  private au kTk;
  double lbY;
  private int lbo;
  
  static
  {
    AppMethodBeat.i(189562);
    CLY = new j.a((byte)0);
    AppMethodBeat.o(189562);
  }
  
  public j()
  {
    AppMethodBeat.i(189561);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.CLW = ((b)new b(this));
    this.CLX = -1;
    AppMethodBeat.o(189561);
  }
  
  final JSONObject bkx()
  {
    AppMethodBeat.i(189558);
    JSONObject localJSONObject = new JSONObject();
    if (this.CLV != null) {
      localJSONObject.put("data", this.CLV);
    }
    AppMethodBeat.o(189558);
    return localJSONObject;
  }
  
  final void bky()
  {
    AppMethodBeat.i(189557);
    ac.i(this.TAG, "stop video update timer");
    au localau = this.kTk;
    if (localau != null)
    {
      localau.stopTimer();
      AppMethodBeat.o(189557);
      return;
    }
    AppMethodBeat.o(189557);
  }
  
  final void bme()
  {
    AppMethodBeat.i(189560);
    ap.f((Runnable)new f(this));
    AppMethodBeat.o(189560);
  }
  
  public final void cx(String paramString)
  {
    AppMethodBeat.i(189556);
    if (paramString != null) {
      try
      {
        this.CLV = new JSONObject(paramString);
        AppMethodBeat.o(189556);
        return;
      }
      catch (Exception paramString)
      {
        ac.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(189556);
        return;
      }
    }
    AppMethodBeat.o(189556);
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189559);
    Object localObject = this.CLT;
    if (localObject != null)
    {
      String str = ((f)localObject).eGk();
      if (!bs.isNullOrNil(str))
      {
        localObject = ((f)localObject).CLN.Cjq.ezV();
        if (str == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.plugin.webview.k.k)localObject).aP(str, paramString, paramJSONObject.toString());
        AppMethodBeat.o(189559);
        return;
      }
      ((f)localObject).CLN.Cjq.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(189559);
      return;
    }
    AppMethodBeat.o(189559);
  }
  
  public final void eGm()
  {
    AppMethodBeat.i(189553);
    try
    {
      this.lbo = 0;
      Object localObject = bkx();
      ((JSONObject)localObject).put("timeStamp", System.currentTimeMillis());
      dispatchEvent("onVideoPlay", (JSONObject)localObject);
      ac.i(this.TAG, "start video update timer");
      if (this.kTk == null)
      {
        ac.i(this.TAG, "start video update timer, create new timer");
        this.kTk = new au("VideoUpdateTimer", (au.a)new e(this), true);
      }
      localObject = this.kTk;
      if (localObject != null) {
        ((au)localObject).au(0L, 250L);
      }
      ap.f((Runnable)new d(this));
      AppMethodBeat.o(189553);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(189553);
    }
  }
  
  public final void eGn()
  {
    AppMethodBeat.i(189554);
    ac.d(this.TAG, "onVideoPreLoadedMetaData");
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("preloadSize", 0L);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(189554);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(189554);
    }
  }
  
  public final void eGo()
  {
    AppMethodBeat.i(189555);
    try
    {
      dispatchEvent("onVideoPause", bkx());
      bky();
      bme();
      AppMethodBeat.o(189555);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e(this.TAG, "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void m(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(189551);
    if ((parama instanceof f))
    {
      this.CLT = ((f)parama);
      f localf = (f)parama;
      Object localObject = localf.CLN.context;
      parama = (com.tencent.luggage.k.a.a)localObject;
      if (!(localObject instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.CLW);
      }
      parama = localf.CLN.context;
      if (this.Cze == null) {
        this.Cze = new com.tencent.mm.bo.a(parama, (a.b)new c(this));
      }
      if (this.Haf == null)
      {
        this.Haf = ((ContentObserver)new g(this, new Handler()));
        parama = ai.getContext();
        d.g.b.k.g(parama, "MMApplicationContext.getContext()");
        parama = parama.getApplicationContext();
        d.g.b.k.g(parama, "MMApplicationContext.get…text().applicationContext");
        parama = parama.getContentResolver();
        localObject = Settings.System.getUriFor("screen_brightness");
      }
      try
      {
        parama.registerContentObserver((Uri)localObject, false, this.Haf);
        if (this.Hag == null) {
          this.Hag = ((BroadcastReceiver)new WebViewVideoEventHandler.initVolumeBroadcastReceiver.1(this));
        }
      }
      catch (Throwable parama)
      {
        try
        {
          parama = new IntentFilter();
          parama.addAction("android.media.VOLUME_CHANGED_ACTION");
          ai.getContext().registerReceiver(this.Hag, parama);
          parama = this.Cze;
          if (parama != null)
          {
            parama.enable();
            AppMethodBeat.o(189551);
            return;
            parama = parama;
            ac.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
        catch (Throwable parama)
        {
          for (;;)
          {
            ac.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(189551);
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(189552);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      dispatchEvent("onVideoWaiting", localJSONObject);
      AppMethodBeat.o(189552);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(189552);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class b
    extends b
  {
    public final void Cb()
    {
      AppMethodBeat.i(189545);
      try
      {
        JSONObject localJSONObject = j.g(this.CLZ);
        j.a(this.CLZ, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(189545);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e(j.d(this.CLZ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(189545);
      }
    }
    
    public final void bdP()
    {
      AppMethodBeat.i(189546);
      try
      {
        JSONObject localJSONObject = j.g(this.CLZ);
        j.a(this.CLZ, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(189546);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e(j.d(this.CLZ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(189546);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class c
    implements a.b
  {
    c(j paramj) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(189547);
      parama1 = this.CLZ;
      if (parama2 == null)
      {
        AppMethodBeat.o(189547);
        return;
      }
      int i;
      switch (k.cfA[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(189547);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        j.a(parama1, i);
        if (j.e(this.CLZ) != j.f(this.CLZ)) {
          break;
        }
        AppMethodBeat.o(189547);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      j.b(this.CLZ, j.e(this.CLZ));
      ac.i(j.d(this.CLZ), "onOrientationsChange currentOrientation=" + j.e(this.CLZ));
      try
      {
        parama1 = j.g(this.CLZ);
        parama1.put("newOrientation", j.e(this.CLZ));
        if (j.h(this.CLZ)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          j.a(this.CLZ, "onOrientationsChange", parama1);
          AppMethodBeat.o(189547);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        ac.e(j.d(this.CLZ), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(189547);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(189548);
      if (j.c(this.CLZ) != null)
      {
        Object localObject = j.c(this.CLZ);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if ((((f)localObject).CLN.context instanceof Activity))
        {
          ac.i(j.d(this.CLZ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.CLZ);
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            localObject = ((f)localObject).CLN.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(189548);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ac.e(j.d(this.CLZ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(189548);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(189548);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements au.a
  {
    e(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(189549);
      if (j.a(this.CLZ) != null)
      {
        j localj = this.CLZ;
        l locall = j.a(this.CLZ);
        if (locall == null) {
          d.g.b.k.fOy();
        }
        j.a(localj, locall.getCurrentPosition(), (int)(j.b(this.CLZ) * 1000.0D));
      }
      AppMethodBeat.o(189549);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(189550);
      if (j.c(this.CLZ) != null)
      {
        Object localObject = j.c(this.CLZ);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if ((((f)localObject).CLN.context instanceof Activity))
        {
          ac.i(j.d(this.CLZ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.CLZ);
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            localObject = ((f)localObject).CLN.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(189550);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ac.e(j.d(this.CLZ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(189550);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(189550);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initBrightnessObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-webview_release"})
  public static final class g
    extends ContentObserver
  {
    g(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(210107);
      ac.d(j.d(this.CLZ), "initBrightnessObserver onChange selfChange=".concat(String.valueOf(paramBoolean)));
      try
      {
        JSONObject localJSONObject = j.g(this.CLZ);
        localJSONObject.put("selfChange", paramBoolean);
        j.a(this.CLZ, "onBrightnessChange", localJSONObject);
        AppMethodBeat.o(210107);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e(j.d(this.CLZ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(210107);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.j
 * JD-Core Version:    0.7.0.1
 */