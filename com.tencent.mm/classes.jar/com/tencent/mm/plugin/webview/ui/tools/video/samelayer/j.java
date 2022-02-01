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
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onPlayerProcessStateChanged", "event", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "Companion", "plugin-webview_release"})
public final class j
{
  public static final j.a EIo;
  f EIh;
  l EIi;
  private JSONObject EIj;
  com.tencent.mm.plugin.webview.ui.tools.video.c EIk;
  private int EIl;
  ContentObserver EIm;
  BroadcastReceiver EIn;
  com.tencent.mm.bo.a EuP;
  final String TAG;
  private int bbE;
  private int lCM;
  double lDw;
  private aw luk;
  
  static
  {
    AppMethodBeat.i(199496);
    EIo = new j.a((byte)0);
    AppMethodBeat.o(199496);
  }
  
  public j()
  {
    AppMethodBeat.i(199495);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.EIk = ((com.tencent.mm.plugin.webview.ui.tools.video.c)new b(this));
    this.EIl = -1;
    AppMethodBeat.o(199495);
  }
  
  public final void aKU(String paramString)
  {
    AppMethodBeat.i(199490);
    p.h(paramString, "event");
    ae.i(this.TAG, "onPlayerProcessStateChanged event=".concat(String.valueOf(paramString)));
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("event", paramString);
      dispatchEvent("onPlayerProcessStateChanged", localJSONObject);
      AppMethodBeat.o(199490);
      return;
    }
    catch (JSONException paramString)
    {
      ae.e(this.TAG, "onVideoLoadedMetaData fail", new Object[] { paramString });
      AppMethodBeat.o(199490);
    }
  }
  
  final JSONObject boS()
  {
    AppMethodBeat.i(199492);
    JSONObject localJSONObject = new JSONObject();
    if (this.EIj != null) {
      localJSONObject.put("data", this.EIj);
    }
    AppMethodBeat.o(199492);
    return localJSONObject;
  }
  
  final void boT()
  {
    AppMethodBeat.i(199491);
    ae.i(this.TAG, "stop video update timer");
    aw localaw = this.luk;
    if (localaw != null)
    {
      localaw.stopTimer();
      AppMethodBeat.o(199491);
      return;
    }
    AppMethodBeat.o(199491);
  }
  
  final void bqz()
  {
    AppMethodBeat.i(199494);
    ar.f((Runnable)new g(this));
    AppMethodBeat.o(199494);
  }
  
  public final void dC(String paramString)
  {
    AppMethodBeat.i(199489);
    if (paramString != null) {
      try
      {
        this.EIj = new JSONObject(paramString);
        AppMethodBeat.o(199489);
        return;
      }
      catch (Exception paramString)
      {
        ae.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(199489);
        return;
      }
    }
    AppMethodBeat.o(199489);
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(199493);
    Object localObject = this.EIh;
    if (localObject != null)
    {
      paramJSONObject.put("__timestamp", System.currentTimeMillis());
      String str = ((f)localObject).eYV();
      if (!bu.isNullOrNil(str))
      {
        localObject = ((f)localObject).EIc.DQe.eSu();
        if (str == null) {
          p.gkB();
        }
        ((k)localObject).aY(str, paramString, paramJSONObject.toString());
        AppMethodBeat.o(199493);
        return;
      }
      ((f)localObject).EIc.DQe.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(199493);
      return;
    }
    AppMethodBeat.o(199493);
  }
  
  public final void eYY()
  {
    AppMethodBeat.i(199486);
    try
    {
      this.lCM = 0;
      dispatchEvent("onVideoPlay", boS());
      ae.i(this.TAG, "start video update timer");
      if (this.luk == null)
      {
        ae.i(this.TAG, "start video update timer, create new timer");
        this.luk = new aw("VideoUpdateTimer", (aw.a)new f(this), true);
      }
      aw localaw = this.luk;
      if (localaw != null) {
        localaw.ay(0L, 250L);
      }
      ar.f((Runnable)new e(this));
      AppMethodBeat.o(199486);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(199486);
    }
  }
  
  public final void eYZ()
  {
    AppMethodBeat.i(199487);
    ae.d(this.TAG, "onVideoPreLoadedMetaData");
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("preloadSize", 0L);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(199487);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(199487);
    }
  }
  
  public final void eZa()
  {
    AppMethodBeat.i(199488);
    try
    {
      dispatchEvent("onVideoPause", boS());
      boT();
      bqz();
      AppMethodBeat.o(199488);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e(this.TAG, "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(199484);
    if ((parama instanceof f))
    {
      this.EIh = ((f)parama);
      f localf = (f)parama;
      Object localObject = localf.EIc.context;
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
      if (!(localObject instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.EIk);
      }
      parama = localf.EIc.context;
      if (this.EuP == null) {
        this.EuP = new com.tencent.mm.bo.a(parama, (a.b)new d(this));
      }
      if (this.EIm == null)
      {
        this.EIm = ((ContentObserver)new c(this, new Handler()));
        parama = ak.getContext();
        p.g(parama, "MMApplicationContext.getContext()");
        parama = parama.getApplicationContext();
        p.g(parama, "MMApplicationContext.get…text().applicationContext");
        parama = parama.getContentResolver();
        localObject = Settings.System.getUriFor("screen_brightness");
      }
      try
      {
        parama.registerContentObserver((Uri)localObject, false, this.EIm);
        if (this.EIn == null) {
          this.EIn = ((BroadcastReceiver)new WebViewVideoEventHandler.initVolumeBroadcastReceiver.1(this));
        }
      }
      catch (Throwable parama)
      {
        try
        {
          parama = new IntentFilter();
          parama.addAction("android.media.VOLUME_CHANGED_ACTION");
          ak.getContext().registerReceiver(this.EIn, parama);
          parama = this.EuP;
          if (parama != null)
          {
            parama.enable();
            AppMethodBeat.o(199484);
            return;
            parama = parama;
            ae.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
        catch (Throwable parama)
        {
          for (;;)
          {
            ae.printErrStackTrace(this.TAG, parama, "initBrightnessObserver", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(199484);
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(199485);
    try
    {
      dispatchEvent("onVideoWaiting", boS());
      AppMethodBeat.o(199485);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(199485);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.video.c
  {
    public final void DD()
    {
      AppMethodBeat.i(199476);
      try
      {
        JSONObject localJSONObject = j.g(this.EIp);
        j.a(this.EIp, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(199476);
        return;
      }
      catch (JSONException localJSONException)
      {
        ae.e(j.d(this.EIp), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(199476);
      }
    }
    
    public final void bib()
    {
      AppMethodBeat.i(199477);
      try
      {
        JSONObject localJSONObject = j.g(this.EIp);
        j.a(this.EIp, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(199477);
        return;
      }
      catch (JSONException localJSONException)
      {
        ae.e(j.d(this.EIp), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(199477);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initBrightnessObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-webview_release"})
  public static final class c
    extends ContentObserver
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(199478);
      ae.d(j.d(this.EIp), "initBrightnessObserver onChange selfChange=".concat(String.valueOf(paramBoolean)));
      try
      {
        JSONObject localJSONObject = j.g(this.EIp);
        localJSONObject.put("selfChange", paramBoolean);
        j.a(this.EIp, "onBrightnessChange", localJSONObject);
        AppMethodBeat.o(199478);
        return;
      }
      catch (JSONException localJSONException)
      {
        ae.e(j.d(this.EIp), "onBrightnessChange fail  " + localJSONException.getMessage());
        AppMethodBeat.o(199478);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class d
    implements a.b
  {
    d(j paramj) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(199479);
      parama1 = this.EIp;
      if (parama2 == null)
      {
        AppMethodBeat.o(199479);
        return;
      }
      int i;
      switch (k.cqt[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(199479);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        j.a(parama1, i);
        if (j.e(this.EIp) != j.f(this.EIp)) {
          break;
        }
        AppMethodBeat.o(199479);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      j.b(this.EIp, j.e(this.EIp));
      ae.i(j.d(this.EIp), "onOrientationsChange currentOrientation=" + j.e(this.EIp));
      try
      {
        parama1 = j.g(this.EIp);
        parama1.put("newOrientation", j.e(this.EIp));
        if (j.h(this.EIp)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          j.a(this.EIp, "onOrientationsChange", parama1);
          AppMethodBeat.o(199479);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        ae.e(j.d(this.EIp), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(199479);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(199481);
      if (j.c(this.EIp) != null)
      {
        Object localObject = j.c(this.EIp);
        if (localObject == null) {
          p.gkB();
        }
        if ((((f)localObject).EIc.context instanceof Activity))
        {
          ae.i(j.d(this.EIp), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.EIp);
            if (localObject == null) {
              p.gkB();
            }
            localObject = ((f)localObject).EIc.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(199481);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ae.e(j.d(this.EIp), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(199481);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(199481);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements aw.a
  {
    f(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(199482);
      if (j.a(this.EIp) != null)
      {
        j localj = this.EIp;
        l locall = j.a(this.EIp);
        if (locall == null) {
          p.gkB();
        }
        j.a(localj, locall.getCurrentPosition(), (int)(j.b(this.EIp) * 1000.0D));
      }
      AppMethodBeat.o(199482);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(199483);
      if (j.c(this.EIp) != null)
      {
        Object localObject = j.c(this.EIp);
        if (localObject == null) {
          p.gkB();
        }
        if ((((f)localObject).EIc.context instanceof Activity))
        {
          ae.i(j.d(this.EIp), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.EIp);
            if (localObject == null) {
              p.gkB();
            }
            localObject = ((f)localObject).EIc.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(199483);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ae.e(j.d(this.EIp), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(199483);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(199483);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.j
 * JD-Core Version:    0.7.0.1
 */