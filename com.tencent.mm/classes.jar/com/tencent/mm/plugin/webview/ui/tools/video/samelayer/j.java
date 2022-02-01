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
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onPlayerProcessStateChanged", "event", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "Companion", "plugin-webview_release"})
public final class j
{
  public static final j.a Jyd;
  com.tencent.mm.bo.a Jii;
  f JxW;
  l JxX;
  private JSONObject JxY;
  com.tencent.mm.plugin.webview.ui.tools.video.c JxZ;
  private int Jya;
  ContentObserver Jyb;
  BroadcastReceiver Jyc;
  final String TAG;
  private int bby;
  private MTimerHandler mAM;
  private int mKu;
  double mLe;
  
  static
  {
    AppMethodBeat.i(210719);
    Jyd = new j.a((byte)0);
    AppMethodBeat.o(210719);
  }
  
  public j()
  {
    AppMethodBeat.i(210718);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.JxZ = ((com.tencent.mm.plugin.webview.ui.tools.video.c)new b(this));
    this.Jya = -1;
    AppMethodBeat.o(210718);
  }
  
  public final void aX(long paramLong)
  {
    AppMethodBeat.i(210710);
    Log.d(this.TAG, "onVideoPreLoadedMetaData cachedSize=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 6L, 1L, false);
    if (paramLong > 0L) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1379L, 7L, 1L, false);
    }
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("preloadSize", paramLong);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(210710);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(210710);
    }
  }
  
  final JSONObject bKv()
  {
    AppMethodBeat.i(210715);
    JSONObject localJSONObject = new JSONObject();
    if (this.JxY != null) {
      localJSONObject.put("data", this.JxY);
    }
    AppMethodBeat.o(210715);
    return localJSONObject;
  }
  
  final void bKw()
  {
    AppMethodBeat.i(210714);
    Log.i(this.TAG, "stop video update timer");
    MTimerHandler localMTimerHandler = this.mAM;
    if (localMTimerHandler != null)
    {
      localMTimerHandler.stopTimer();
      AppMethodBeat.o(210714);
      return;
    }
    AppMethodBeat.o(210714);
  }
  
  final void bMk()
  {
    AppMethodBeat.i(210717);
    MMHandlerThread.postToMainThread((Runnable)new g(this));
    AppMethodBeat.o(210717);
  }
  
  public final void bbk(String paramString)
  {
    AppMethodBeat.i(210713);
    p.h(paramString, "event");
    Log.i(this.TAG, "onPlayerProcessStateChanged event=".concat(String.valueOf(paramString)));
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("event", paramString);
      dispatchEvent("onPlayerProcessStateChanged", localJSONObject);
      AppMethodBeat.o(210713);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e(this.TAG, "onVideoLoadedMetaData fail", new Object[] { paramString });
      AppMethodBeat.o(210713);
    }
  }
  
  public final void dV(String paramString)
  {
    AppMethodBeat.i(210712);
    if (paramString != null) {
      try
      {
        this.JxY = new JSONObject(paramString);
        AppMethodBeat.o(210712);
        return;
      }
      catch (Exception paramString)
      {
        Log.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(210712);
        return;
      }
    }
    AppMethodBeat.o(210712);
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(210716);
    Object localObject = this.JxW;
    if (localObject != null)
    {
      paramJSONObject.put("__timestamp", System.currentTimeMillis());
      String str = ((f)localObject).gid();
      if (!Util.isNullOrNil(str))
      {
        localObject = ((f)localObject).JxI.IQZ.gbi();
        if (localObject != null)
        {
          if (str == null) {
            p.hyc();
          }
          ((k)localObject).bi(str, paramString, paramJSONObject.toString());
          AppMethodBeat.o(210716);
          return;
        }
        AppMethodBeat.o(210716);
        return;
      }
      ((f)localObject).JxI.IQZ.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(210716);
      return;
    }
    AppMethodBeat.o(210716);
  }
  
  public final void gif()
  {
    AppMethodBeat.i(210709);
    try
    {
      this.mKu = 0;
      dispatchEvent("onVideoPlay", bKv());
      Log.i(this.TAG, "start video update timer");
      if (this.mAM == null)
      {
        Log.i(this.TAG, "start video update timer, create new timer");
        this.mAM = new MTimerHandler("VideoUpdateTimer", (MTimerHandler.CallBack)new f(this), true);
      }
      MTimerHandler localMTimerHandler = this.mAM;
      if (localMTimerHandler != null) {
        localMTimerHandler.startTimer(0L, 250L);
      }
      MMHandlerThread.postToMainThread((Runnable)new e(this));
      AppMethodBeat.o(210709);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(210709);
    }
  }
  
  public final void gig()
  {
    AppMethodBeat.i(210711);
    try
    {
      dispatchEvent("onVideoPause", bKv());
      bKw();
      bMk();
      AppMethodBeat.o(210711);
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
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(210707);
    if ((parama instanceof f))
    {
      this.JxW = ((f)parama);
      Object localObject2 = (f)parama;
      Object localObject1 = ((f)localObject2).JxI.context;
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject1;
      if (!(localObject1 instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.JxZ);
      }
      parama = ((f)localObject2).JxI.context;
      if (this.Jii == null) {
        this.Jii = new com.tencent.mm.bo.a(parama, (a.b)new d(this));
      }
      if (this.Jyb == null)
      {
        this.Jyb = ((ContentObserver)new c(this, new Handler()));
        parama = MMApplicationContext.getContext();
        p.g(parama, "MMApplicationContext.getContext()");
        parama = parama.getApplicationContext();
        p.g(parama, "MMApplicationContext.get…text().applicationContext");
        parama = parama.getContentResolver();
        localObject1 = Settings.System.getUriFor("screen_brightness");
      }
      try
      {
        localObject2 = this.Jyb;
        if (localObject2 == null) {
          p.hyc();
        }
        parama.registerContentObserver((Uri)localObject1, false, (ContentObserver)localObject2);
      }
      catch (Throwable parama)
      {
        try
        {
          parama = new IntentFilter();
          parama.addAction("android.media.VOLUME_CHANGED_ACTION");
          MMApplicationContext.getContext().registerReceiver(this.Jyc, parama);
          parama = this.Jii;
          if (parama == null) {
            break label292;
          }
          parama.enable();
          AppMethodBeat.o(210707);
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
      if (this.Jyc == null) {
        this.Jyc = ((BroadcastReceiver)new WebViewVideoEventHandler.initVolumeBroadcastReceiver.1(this));
      }
    }
    label292:
    AppMethodBeat.o(210707);
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(210708);
    try
    {
      dispatchEvent("onVideoWaiting", bKv());
      AppMethodBeat.o(210708);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(210708);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.video.c
  {
    public final void Na()
    {
      AppMethodBeat.i(210699);
      try
      {
        JSONObject localJSONObject = j.g(this.Jye);
        j.a(this.Jye, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(210699);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(j.d(this.Jye), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(210699);
      }
    }
    
    public final void bDq()
    {
      AppMethodBeat.i(210700);
      try
      {
        JSONObject localJSONObject = j.g(this.Jye);
        j.a(this.Jye, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(210700);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(j.d(this.Jye), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(210700);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initBrightnessObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-webview_release"})
  public static final class c
    extends ContentObserver
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(210701);
      Log.d(j.d(this.Jye), "initBrightnessObserver onChange selfChange=".concat(String.valueOf(paramBoolean)));
      try
      {
        JSONObject localJSONObject = j.g(this.Jye);
        localJSONObject.put("selfChange", paramBoolean);
        j.a(this.Jye, "onBrightnessChange", localJSONObject);
        AppMethodBeat.o(210701);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(j.d(this.Jye), "onBrightnessChange fail  " + localJSONException.getMessage());
        AppMethodBeat.o(210701);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class d
    implements a.b
  {
    d(j paramj) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(210702);
      parama1 = this.Jye;
      if (parama2 == null)
      {
        AppMethodBeat.o(210702);
        return;
      }
      int i;
      switch (k.$EnumSwitchMapping$0[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(210702);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        j.a(parama1, i);
        if (j.e(this.Jye) != j.f(this.Jye)) {
          break;
        }
        AppMethodBeat.o(210702);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      j.b(this.Jye, j.e(this.Jye));
      Log.i(j.d(this.Jye), "onOrientationsChange currentOrientation=" + j.e(this.Jye));
      try
      {
        parama1 = j.g(this.Jye);
        parama1.put("newOrientation", j.e(this.Jye));
        if (j.h(this.Jye)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          j.a(this.Jye, "onOrientationsChange", parama1);
          AppMethodBeat.o(210702);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        Log.e(j.d(this.Jye), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(210702);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(210704);
      if (j.c(this.Jye) != null)
      {
        Object localObject = j.c(this.Jye);
        if (localObject == null) {
          p.hyc();
        }
        if ((((f)localObject).JxI.context instanceof Activity))
        {
          Log.i(j.d(this.Jye), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.Jye);
            if (localObject == null) {
              p.hyc();
            }
            localObject = ((f)localObject).JxI.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(210704);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            Log.e(j.d(this.Jye), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(210704);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(210704);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements MTimerHandler.CallBack
  {
    f(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(210705);
      if (j.a(this.Jye) != null)
      {
        j localj = this.Jye;
        l locall = j.a(this.Jye);
        if (locall == null) {
          p.hyc();
        }
        j.a(localj, locall.getCurrentPosition(), (int)(j.b(this.Jye) * 1000.0D));
      }
      AppMethodBeat.o(210705);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(210706);
      if (j.c(this.Jye) != null)
      {
        Object localObject = j.c(this.Jye);
        if (localObject == null) {
          p.hyc();
        }
        if ((((f)localObject).JxI.context instanceof Activity))
        {
          Log.i(j.d(this.Jye), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.Jye);
            if (localObject == null) {
              p.hyc();
            }
            localObject = ((f)localObject).JxI.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(210706);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            Log.e(j.d(this.Jye), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(210706);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(210706);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.j
 * JD-Core Version:    0.7.0.1
 */