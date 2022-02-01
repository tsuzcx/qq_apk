package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", "getScreenBrightness", "getSystemScale", "getVolume", "handleMsg", "hideKeyBoard", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"})
public final class o
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 372;
  public static final o Qvh;
  private static final String fXz = "handleDeviceInfo";
  
  static
  {
    AppMethodBeat.i(257854);
    Qvh = new o();
    IIl = 372;
    fXz = "handleDeviceInfo";
    AppMethodBeat.o(257854);
  }
  
  public final boolean a(final f paramf, final n paramn)
  {
    int i = 0;
    AppMethodBeat.i(257852);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject1 = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject1 });
    if (Util.isNullOrNil((String)localObject1))
    {
      paramf.PNo.h(paramn.POu, paramn.function + ":fail action is empty", null);
      AppMethodBeat.o(257852);
      return true;
    }
    boolean bool;
    if (p.h("enableFullScreen", localObject1))
    {
      bool = Util.getBoolean((String)paramn.params.get("enable"), false);
      if ((paramf.context instanceof b))
      {
        if (!bool) {
          break label288;
        }
        switch (Util.getInt((String)paramn.params.get("orientation"), 0))
        {
        }
        for (;;)
        {
          localObject1 = paramf.context;
          if (localObject1 != null) {
            break;
          }
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(257852);
          throw paramf;
          i = 90;
          continue;
          i = -90;
        }
        ((b)localObject1).aG(null, i);
      }
      for (;;)
      {
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
        AppMethodBeat.o(257852);
        return true;
        label288:
        localObject1 = paramf.context;
        if (localObject1 == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(257852);
          throw paramf;
        }
        ((b)localObject1).gYv();
      }
    }
    Object localObject2;
    if (p.h("setOrientation", localObject1))
    {
      i = Util.getInt((String)paramn.params.get("orientation"), 0);
      bool = Util.getBoolean((String)paramn.params.get("lock"), true);
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
      if ((paramf.context instanceof b))
      {
        if (!bool) {
          break label554;
        }
        localObject2 = paramf.context;
        localObject1 = localObject2;
        if (!(localObject2 instanceof Activity)) {
          localObject1 = null;
        }
        localObject1 = (Activity)localObject1;
        if (localObject1 != null) {
          switch (i)
          {
          default: 
            ((Activity)localObject1).setRequestedOrientation(1);
          }
        }
      }
      for (;;)
      {
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
        AppMethodBeat.o(257852);
        return true;
        ((Activity)localObject1).setRequestedOrientation(0);
        continue;
        ((Activity)localObject1).setRequestedOrientation(8);
        continue;
        label554:
        localObject2 = paramf.context;
        localObject1 = localObject2;
        if (!(localObject2 instanceof Activity)) {
          localObject1 = null;
        }
        localObject1 = (Activity)localObject1;
        if (localObject1 != null) {
          ((Activity)localObject1).setRequestedOrientation(-1);
        }
      }
    }
    final float f;
    if (p.h("setVolume", localObject1))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)Util.getDouble((String)paramn.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(257852);
        return false;
      }
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Activity)) {
        localObject1 = null;
      }
      localObject1 = (Activity)localObject1;
      if (localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new f((Activity)localObject1, f, paramf, paramn));
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return true;
    }
    if (p.h("getVolume", localObject1))
    {
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Activity)) {
        localObject1 = null;
      }
      localObject1 = (Activity)localObject1;
      if (localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new c((Activity)localObject1, paramf, paramn));
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return false;
    }
    if (p.h("setScreenBrightness", localObject1))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)Util.getDouble((String)paramn.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(257852);
        return false;
      }
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Activity)) {
        localObject1 = null;
      }
      if ((Activity)localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new e(paramf, f, paramn));
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return true;
    }
    if (p.h("getScreenBrightness", localObject1))
    {
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Activity)) {
        localObject1 = null;
      }
      localObject1 = (Activity)localObject1;
      if (localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new b((Activity)localObject1, paramf, paramn));
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return false;
    }
    if (p.h("getSafeAreaInsets", localObject1))
    {
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof Activity)) {
        localObject1 = null;
      }
      localObject1 = (Activity)localObject1;
      if (localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new a((Activity)localObject1, paramf, paramn));
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return false;
    }
    if (p.h("hideKeyBoard", localObject1))
    {
      localObject2 = paramf.context;
      localObject1 = localObject2;
      if (!(localObject2 instanceof WebViewUI)) {
        localObject1 = null;
      }
      localObject1 = (WebViewUI)localObject1;
      if (localObject1 != null)
      {
        d.uiThread((kotlin.g.a.a)new d((WebViewUI)localObject1, paramf, paramn));
        AppMethodBeat.o(257852);
        return true;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(257852);
      return false;
    }
    if (p.h("getSystemScale", localObject1))
    {
      localObject2 = (Map)new HashMap();
      ((Map)localObject2).put("systemScale", Float.valueOf(com.tencent.mm.cj.a.hrd()));
      localObject1 = paramf.PNp;
      if (localObject1 != null) {}
      for (localObject1 = Float.valueOf(((MMWebView)localObject1).getMMDensity());; localObject1 = Float.valueOf(0.0F))
      {
        ((Map)localObject2).put("density", localObject1);
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localObject2);
        AppMethodBeat.o(257852);
        return false;
      }
    }
    AppMethodBeat.o(257852);
    return false;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$hideKeyBoard$1$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(WebViewUI paramWebViewUI, f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, float paramFloat, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(Activity paramActivity, float paramFloat, f paramf, n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.o
 * JD-Core Version:    0.7.0.1
 */