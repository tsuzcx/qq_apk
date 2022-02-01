package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "enableSwipeBackGesture", "getSafeAreaInsets", "getScreenBrightness", "getStatusBarAndActionBarHeight", "getSystemScale", "getVolume", "handleMsg", "hideKeyBoard", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final p Xni;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297758);
    Xni = new p();
    OOk = 372;
    idA = "handleDeviceInfo";
    AppMethodBeat.o(297758);
  }
  
  public final boolean a(final h paramh, final com.tencent.mm.plugin.webview.jsapi.p paramp)
  {
    final float f = 0.0F;
    int i = 0;
    AppMethodBeat.i(297815);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject = (String)paramp.params.get("action");
    Log.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail action is empty"), null);
      AppMethodBeat.o(297815);
      return true;
    }
    boolean bool;
    if (s.p("enableSwipeBackGesture", localObject))
    {
      localObject = paramh.context;
      if ((localObject instanceof WebViewUI)) {}
      for (localObject = (WebViewUI)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          bool = Util.getBoolean((String)paramp.params.get("enable"), true);
          Log.i("MicroMsg.JsApiHandleDeviceInfo", s.X("enableSwipeBackGesture ", Boolean.valueOf(bool)));
          ((WebViewUI)localObject).getSwipeBackLayout().setEnableGesture(bool);
        }
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
        AppMethodBeat.o(297815);
        return true;
      }
    }
    if (s.p("enableFullScreen", localObject))
    {
      bool = Util.getBoolean((String)paramp.params.get("enable"), false);
      if ((paramh.context instanceof b))
      {
        if (!bool) {
          break label359;
        }
        switch (Util.getInt((String)paramp.params.get("orientation"), 0))
        {
        default: 
          ((b)paramh.context).bc(null, i);
        }
      }
      for (;;)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
        AppMethodBeat.o(297815);
        return true;
        i = 90;
        break;
        i = -90;
        break;
        label359:
        ((b)paramh.context).iyp();
      }
    }
    if (s.p("setOrientation", localObject))
    {
      i = Util.getInt((String)paramp.params.get("orientation"), 0);
      bool = Util.getBoolean((String)paramp.params.get("lock"), true);
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
      if ((paramh.context instanceof b))
      {
        if (!bool) {
          break label589;
        }
        localObject = paramh.context;
        if (!(localObject instanceof Activity)) {
          break label564;
        }
        localObject = (Activity)localObject;
        if (localObject != null) {
          switch (i)
          {
          default: 
            ((Activity)localObject).setRequestedOrientation(1);
          }
        }
      }
      label564:
      label589:
      label628:
      for (;;)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
        AppMethodBeat.o(297815);
        return true;
        localObject = null;
        break;
        ((Activity)localObject).setRequestedOrientation(0);
        continue;
        ((Activity)localObject).setRequestedOrientation(8);
        continue;
        localObject = paramh.context;
        if ((localObject instanceof Activity)) {}
        for (localObject = (Activity)localObject;; localObject = null)
        {
          if (localObject == null) {
            break label628;
          }
          ((Activity)localObject).setRequestedOrientation(-1);
          break;
        }
      }
    }
    if (s.p("setVolume", localObject))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)Util.getDouble((String)paramp.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(297815);
        return false;
      }
      localObject = paramh.context;
      if ((localObject instanceof Activity)) {}
      for (localObject = (Activity)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new g((Activity)localObject, f, paramh, paramp));
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return true;
    }
    if (s.p("getVolume", localObject))
    {
      localObject = paramh.context;
      if ((localObject instanceof Activity)) {}
      for (localObject = (Activity)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new d((Activity)localObject, paramh, paramp));
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return false;
    }
    if (s.p("setScreenBrightness", localObject))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)Util.getDouble((String)paramp.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(297815);
        return false;
      }
      localObject = paramh.context;
      if ((localObject instanceof Activity)) {}
      for (localObject = (Activity)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new f(paramh, f));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return true;
    }
    if (s.p("getScreenBrightness", localObject))
    {
      localObject = paramh.context;
      if ((localObject instanceof Activity)) {}
      for (localObject = (Activity)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new b((Activity)localObject, paramh, paramp));
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return false;
    }
    if (s.p("getSafeAreaInsets", localObject))
    {
      localObject = paramh.context;
      if ((localObject instanceof Activity)) {}
      for (localObject = (Activity)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new a((Activity)localObject, paramh, paramp));
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return false;
    }
    if (s.p("getStatusBarAndActionBarHeight", localObject))
    {
      d.uiThread((kotlin.g.a.a)new c(paramh, paramp));
      AppMethodBeat.o(297815);
      return true;
    }
    if (s.p("hideKeyBoard", localObject))
    {
      localObject = paramh.context;
      if ((localObject instanceof WebViewUI)) {}
      for (localObject = (WebViewUI)localObject; localObject != null; localObject = null)
      {
        d.uiThread((kotlin.g.a.a)new e((WebViewUI)localObject, paramh, paramp));
        AppMethodBeat.o(297815);
        return true;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297815);
      return false;
    }
    if (s.p("getSystemScale", localObject))
    {
      localObject = (Map)new HashMap();
      ((Map)localObject).put("systemScale", Float.valueOf(c.iRs()));
      MMWebView localMMWebView = paramh.WDz;
      if (localMMWebView == null) {}
      for (;;)
      {
        ((Map)localObject).put("density", Float.valueOf(f));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
        AppMethodBeat.o(297815);
        return false;
        f = localMMWebView.getMMDensity();
      }
    }
    AppMethodBeat.o(297815);
    return false;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(Activity paramActivity, h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(Activity paramActivity, h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(Activity paramActivity, h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(WebViewUI paramWebViewUI, h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(h paramh, float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(Activity paramActivity, float paramFloat, h paramh, com.tencent.mm.plugin.webview.jsapi.p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.p
 * JD-Core Version:    0.7.0.1
 */