package com.tencent.mm.plugin.webview.ui.tools.d.a;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a.a;
import com.tencent.mm.bp.a.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "isLockRotation", "", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "Companion", "plugin-webview_release"})
public final class j
{
  public static final j.a BtP;
  com.tencent.mm.bp.a BgR;
  f BtJ;
  l BtK;
  private JSONObject BtL;
  com.tencent.mm.plugin.webview.ui.tools.d.b BtM;
  private int BtN;
  private int BtO;
  final String TAG;
  double kAG;
  private av krS;
  private int kzW;
  
  static
  {
    AppMethodBeat.i(188979);
    BtP = new j.a((byte)0);
    AppMethodBeat.o(188979);
  }
  
  public j()
  {
    AppMethodBeat.i(188978);
    this.TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    this.BtM = ((com.tencent.mm.plugin.webview.ui.tools.d.b)new b(this));
    this.BtO = -1;
    AppMethodBeat.o(188978);
  }
  
  final JSONObject bdC()
  {
    AppMethodBeat.i(188975);
    JSONObject localJSONObject = new JSONObject();
    if (this.BtL != null) {
      localJSONObject.put("data", this.BtL);
    }
    AppMethodBeat.o(188975);
    return localJSONObject;
  }
  
  final void bdD()
  {
    AppMethodBeat.i(188974);
    ad.i(this.TAG, "stop video update timer");
    av localav = this.krS;
    if (localav != null)
    {
      localav.stopTimer();
      AppMethodBeat.o(188974);
      return;
    }
    AppMethodBeat.o(188974);
  }
  
  final void bfk()
  {
    AppMethodBeat.i(188977);
    aq.f((Runnable)new f(this));
    AppMethodBeat.o(188977);
  }
  
  public final void cI(String paramString)
  {
    AppMethodBeat.i(188973);
    if (paramString != null) {
      try
      {
        this.BtL = new JSONObject(paramString);
        AppMethodBeat.o(188973);
        return;
      }
      catch (Exception paramString)
      {
        ad.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
        AppMethodBeat.o(188973);
        return;
      }
    }
    AppMethodBeat.o(188973);
  }
  
  final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(188976);
    Object localObject = this.BtJ;
    if (localObject != null)
    {
      String str = ((f)localObject).eqQ();
      if (!bt.isNullOrNil(str))
      {
        localObject = ((f)localObject).BtE.ARd.ekz();
        if (str == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.plugin.webview.k.k)localObject).aM(str, paramString, paramJSONObject.toString());
        AppMethodBeat.o(188976);
        return;
      }
      ((f)localObject).BtE.ARd.dispatchEvent(paramString, paramJSONObject);
      AppMethodBeat.o(188976);
      return;
    }
    AppMethodBeat.o(188976);
  }
  
  public final void eqS()
  {
    AppMethodBeat.i(188970);
    try
    {
      this.kzW = 0;
      Object localObject = bdC();
      ((JSONObject)localObject).put("timeStamp", System.currentTimeMillis());
      dispatchEvent("onVideoPlay", (JSONObject)localObject);
      ad.i(this.TAG, "start video update timer");
      if (this.krS == null)
      {
        ad.i(this.TAG, "start video update timer, create new timer");
        this.krS = new av("VideoUpdateTimer", (av.a)new e(this), true);
      }
      localObject = this.krS;
      if (localObject != null) {
        ((av)localObject).av(0L, 250L);
      }
      aq.f((Runnable)new d(this));
      AppMethodBeat.o(188970);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(188970);
    }
  }
  
  public final void eqT()
  {
    AppMethodBeat.i(188971);
    ad.d(this.TAG, "onVideoPreLoadedMetaData");
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("preloadSize", 0L);
      dispatchEvent("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(188971);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(188971);
    }
  }
  
  public final void eqU()
  {
    AppMethodBeat.i(188972);
    try
    {
      dispatchEvent("onVideoPause", bdC());
      bdD();
      bfk();
      AppMethodBeat.o(188972);
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
  
  public final void n(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(188968);
    if ((parama instanceof f))
    {
      this.BtJ = ((f)parama);
      f localf = (f)parama;
      Context localContext = localf.BtE.context;
      parama = localContext;
      if (!(localContext instanceof c)) {
        parama = null;
      }
      parama = (c)parama;
      if (parama != null) {
        parama.a(this.BtM);
      }
      parama = localf.BtE.context;
      if (this.BgR == null) {
        this.BgR = new com.tencent.mm.bp.a(parama, (a.b)new c(this));
      }
      parama = this.BgR;
      if (parama != null)
      {
        parama.enable();
        AppMethodBeat.o(188968);
        return;
      }
    }
    AppMethodBeat.o(188968);
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(188969);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      dispatchEvent("onVideoWaiting", localJSONObject);
      AppMethodBeat.o(188969);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(188969);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.d.b
  {
    public final void Cx()
    {
      AppMethodBeat.i(188962);
      try
      {
        JSONObject localJSONObject = j.g(this.BtQ);
        j.a(this.BtQ, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(188962);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e(j.d(this.BtQ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(188962);
      }
    }
    
    public final void aWR()
    {
      AppMethodBeat.i(188963);
      try
      {
        JSONObject localJSONObject = j.g(this.BtQ);
        j.a(this.BtQ, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(188963);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e(j.d(this.BtQ), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(188963);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class c
    implements a.b
  {
    c(j paramj) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(188964);
      parama1 = this.BtQ;
      if (parama2 == null)
      {
        AppMethodBeat.o(188964);
        return;
      }
      int i;
      switch (k.ciE[parama2.ordinal()])
      {
      default: 
        AppMethodBeat.o(188964);
        return;
      case 1: 
        i = 90;
      }
      for (;;)
      {
        j.a(parama1, i);
        if (j.e(this.BtQ) != j.f(this.BtQ)) {
          break;
        }
        AppMethodBeat.o(188964);
        return;
        i = -90;
        continue;
        i = 0;
        continue;
        i = 180;
      }
      j.b(this.BtQ, j.e(this.BtQ));
      ad.i(j.d(this.BtQ), "onOrientationsChange currentOrientation=" + j.e(this.BtQ));
      try
      {
        parama1 = j.g(this.BtQ);
        parama1.put("newOrientation", j.e(this.BtQ));
        if (j.h(this.BtQ)) {}
        for (i = 1;; i = 0)
        {
          parama1.put("sysLock", i);
          j.a(this.BtQ, "onOrientationsChange", parama1);
          AppMethodBeat.o(188964);
          return;
        }
        return;
      }
      catch (JSONException parama1)
      {
        ad.e(j.d(this.BtQ), "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(188964);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(188965);
      if (j.c(this.BtQ) != null)
      {
        Object localObject = j.c(this.BtQ);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if ((((f)localObject).BtE.context instanceof Activity))
        {
          ad.i(j.d(this.BtQ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.BtQ);
            if (localObject == null) {
              d.g.b.k.fvU();
            }
            localObject = ((f)localObject).BtE.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(188965);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ad.e(j.d(this.BtQ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(188965);
      return;
      label126:
      ((Activity)localException).getWindow().addFlags(128);
      AppMethodBeat.o(188965);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements av.a
  {
    e(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(188966);
      j localj;
      Object localObject;
      if (j.a(this.BtQ) != null)
      {
        localj = this.BtQ;
        localObject = j.a(this.BtQ);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localObject = ((l)localObject).cmS;
        if (localObject == null) {
          break label75;
        }
      }
      label75:
      for (int i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b)localObject).getCurrentPosition();; i = 0)
      {
        j.a(localj, i, (int)(j.b(this.BtQ) * 1000.0D));
        AppMethodBeat.o(188966);
        return true;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(188967);
      if (j.c(this.BtQ) != null)
      {
        Object localObject = j.c(this.BtQ);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if ((((f)localObject).BtE.context instanceof Activity))
        {
          ad.i(j.d(this.BtQ), "startKeepScreenOn");
          try
          {
            localObject = j.c(this.BtQ);
            if (localObject == null) {
              d.g.b.k.fvU();
            }
            localObject = ((f)localObject).BtE.context;
            if (localObject != null) {
              break label126;
            }
            localObject = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(188967);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ad.e(j.d(this.BtQ), "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
      AppMethodBeat.o(188967);
      return;
      label126:
      ((Activity)localException).getWindow().clearFlags(128);
      AppMethodBeat.o(188967);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.j
 * JD-Core Version:    0.7.0.1
 */