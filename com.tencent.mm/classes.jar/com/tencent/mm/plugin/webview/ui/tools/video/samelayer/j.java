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
import com.tencent.mm.bp.a.a;
import com.tencent.mm.bp.a.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onPlayerProcessStateChanged", "event", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "Companion", "plugin-webview_release"})
public final class j
{
  public static final j.a EpY;
  com.tencent.mm.bp.a EcN;
  f EpR;
  l EpS;
  private JSONObject EpT;
  b EpU;
  private int EpV;
  ContentObserver EpW;
  BroadcastReceiver EpX;
  final String TAG;
  private int bbE;
  private av lpN;
  double lyY;
  private int lyo;
  
  static
  {
    AppMethodBeat.i(207722);
    EpY = new j.a((byte)0);
    AppMethodBeat.o(207722);
  }
  
  public j()
  {
    AppMethodBeat.i(207721);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.EpU = ((b)new b(this));
    this.EpV = -1;
    AppMethodBeat.o(207721);
  }
  
  public final void aJy(String paramString)
  {
    AppMethodBeat.i(207716);
    p.h(paramString, "event");
    ad.i(this.TAG, "onPlayerProcessStateChanged event=".concat(String.valueOf(paramString)));
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("event", paramString);
      dispatchEvent("onPlayerProcessStateChanged", localJSONObject);
      AppMethodBeat.o(207716);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e(this.TAG, "onVideoLoadedMetaData fail", new Object[] { paramString });
      AppMethodBeat.o(207716);
    }
  }
  
  final JSONObject boi()
  {
    AppMethodBeat.i(207718);
    JSONObject localJSONObject = new JSONObject();
    if (this.EpT != null) {
      localJSONObject.put("data", this.EpT);
    }
    AppMethodBeat.o(207718);
    return localJSONObject;
  }
  
  final void boj()
  {
    AppMethodBeat.i(207717);
    ad.i(this.TAG, "stop video update timer");
    av localav = this.lpN;
    if (localav != null)
    {
      localav.stopTimer();
      AppMethodBeat.o(207717);
      return;
    }
    AppMethodBeat.o(207717);
  }
  
  final void bpP()
  {
    AppMethodBeat.i(207720);
    aq.f((Runnable)new g(this));
    AppMethodBeat.o(207720);
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(207719);
    Object localObject = this.EpR;
    if (localObject != null)
    {
      paramJSONObject.put("__timestamp", System.currentTimeMillis());
      String str = ((f)localObject).eVi();
      if (!bt.isNullOrNil(str))
      {
        localObject = ((f)localObject).EpM.Dyx.eOJ();
        if (str == null) {
          p.gfZ();
        }
        ((k)localObject).aX(str, paramString, paramJSONObject.toString());
        AppMethodBeat.o(207719);
        return;
      }
      ((f)localObject).EpM.Dyx.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(207719);
      return;
    }
    AppMethodBeat.o(207719);
  }
  
  public final void dz(String paramString)
  {
    AppMethodBeat.i(207715);
    if (paramString != null) {
      try
      {
        this.EpT = new JSONObject(paramString);
        AppMethodBeat.o(207715);
        return;
      }
      catch (Exception paramString)
      {
        ad.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(207715);
        return;
      }
    }
    AppMethodBeat.o(207715);
  }
  
  public final void eVl()
  {
    AppMethodBeat.i(207712);
    try
    {
      this.lyo = 0;
      dispatchEvent("onVideoPlay", boi());
      ad.i(this.TAG, "start video update timer");
      if (this.lpN == null)
      {
        ad.i(this.TAG, "start video update timer, create new timer");
        this.lpN = new av("VideoUpdateTimer", (av.a)new f(this), true);
      }
      av localav = this.lpN;
      if (localav != null) {
        localav.az(0L, 250L);
      }
      aq.f((Runnable)new e(this));
      AppMethodBeat.o(207712);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(207712);
    }
  }
  
  public final void eVm()
  {
    AppMethodBeat.i(207713);
    ad.d(this.TAG, "onVideoPreLoadedMetaData");
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("preloadSize", 0L);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(207713);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(207713);
    }
  }
  
  public final void eVn()
  {
    AppMethodBeat.i(207714);
    try
    {
      dispatchEvent("onVideoPause", boi());
      boj();
      bpP();
      AppMethodBeat.o(207714);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e(this.TAG, "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(207710);
    if ((parama instanceof f))
    {
      this.EpR = ((f)parama);
      f localf = (f)parama;
      Object localObject = localf.EpM.context;
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
      if (!(localObject instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.EpU);
      }
      parama = localf.EpM.context;
      if (this.EcN == null) {
        this.EcN = new com.tencent.mm.bp.a(parama, (a.b)new d(this));
      }
      if (this.EpW == null)
      {
        this.EpW = ((ContentObserver)new c(this, new Handler()));
        parama = aj.getContext();
        p.g(parama, "MMApplicationContext.getContext()");
        parama = parama.getApplicationContext();
        p.g(parama, "MMApplicationContext.get…text().applicationContext");
        parama = parama.getContentResolver();
        localObject = Settings.System.getUriFor("screen_brightness");
      }
      try
      {
        parama.registerContentObserver((Uri)localObject, false, this.EpW);
        if (this.EpX == null) {
          this.EpX = ((BroadcastReceiver)new WebViewVideoEventHandler.initVolumeBroadcastReceiver.1(this));
        }
      }
      catch (Throwable parama)
      {
        try
        {
          parama = new IntentFilter();
          parama.addAction("android.media.VOLUME_CHANGED_ACTION");
          aj.getContext().registerReceiver(this.EpX, parama);
          parama = this.EcN;
          if (parama != null)
          {
            parama.enable();
            AppMethodBeat.o(207710);
            return;
            parama = parama;
            ad.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
        catch (Throwable parama)
        {
          for (;;)
          {
            ad.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(207710);
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(207711);
    try
    {
      dispatchEvent("onVideoWaiting", boi());
      AppMethodBeat.o(207711);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(207711);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class b
    extends b
  {
    public final void DA()
    {
      AppMethodBeat.i(207702);
      try
      {
        JSONObject localJSONObject = j.g(this.EpZ);
        j.a(this.EpZ, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(207702);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e(j.d(this.EpZ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(207702);
      }
    }
    
    public final void bht()
    {
      AppMethodBeat.i(207703);
      try
      {
        JSONObject localJSONObject = j.g(this.EpZ);
        j.a(this.EpZ, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(207703);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e(j.d(this.EpZ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(207703);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initBrightnessObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-webview_release"})
  public static final class c
    extends ContentObserver
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(207704);
      ad.d(j.d(this.EpZ), "initBrightnessObserver onChange selfChange=".concat(String.valueOf(paramBoolean)));
      try
      {
        JSONObject localJSONObject = j.g(this.EpZ);
        localJSONObject.put("selfChange", paramBoolean);
        j.a(this.EpZ, "onBrightnessChange", localJSONObject);
        AppMethodBeat.o(207704);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e(j.d(this.EpZ), "onBrightnessChange fail  " + localJSONException.getMessage());
        AppMethodBeat.o(207704);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class d
    implements a.b
  {
    d(j paramj) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(207705);
      parama1 = this.EpZ;
      if (parama2 == null)
      {
        AppMethodBeat.o(207705);
        return;
      }
      int i;
      switch (k.cpQ[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(207705);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        j.a(parama1, i);
        if (j.e(this.EpZ) != j.f(this.EpZ)) {
          break;
        }
        AppMethodBeat.o(207705);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      j.b(this.EpZ, j.e(this.EpZ));
      ad.i(j.d(this.EpZ), "onOrientationsChange currentOrientation=" + j.e(this.EpZ));
      try
      {
        parama1 = j.g(this.EpZ);
        parama1.put("newOrientation", j.e(this.EpZ));
        if (j.h(this.EpZ)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          j.a(this.EpZ, "onOrientationsChange", parama1);
          AppMethodBeat.o(207705);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        ad.e(j.d(this.EpZ), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(207705);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(207707);
      if (j.c(this.EpZ) != null)
      {
        Object localObject = j.c(this.EpZ);
        if (localObject == null) {
          p.gfZ();
        }
        if ((((f)localObject).EpM.context instanceof Activity))
        {
          ad.i(j.d(this.EpZ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.EpZ);
            if (localObject == null) {
              p.gfZ();
            }
            localObject = ((f)localObject).EpM.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(207707);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ad.e(j.d(this.EpZ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(207707);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(207707);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements av.a
  {
    f(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(207708);
      if (j.a(this.EpZ) != null)
      {
        j localj = this.EpZ;
        l locall = j.a(this.EpZ);
        if (locall == null) {
          p.gfZ();
        }
        j.a(localj, locall.getCurrentPosition(), (int)(j.b(this.EpZ) * 1000.0D));
      }
      AppMethodBeat.o(207708);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(207709);
      if (j.c(this.EpZ) != null)
      {
        Object localObject = j.c(this.EpZ);
        if (localObject == null) {
          p.gfZ();
        }
        if ((((f)localObject).EpM.context instanceof Activity))
        {
          ad.i(j.d(this.EpZ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.EpZ);
            if (localObject == null) {
              p.gfZ();
            }
            localObject = ((f)localObject).EpM.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(207709);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ad.e(j.d(this.EpZ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(207709);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(207709);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.j
 * JD-Core Version:    0.7.0.1
 */