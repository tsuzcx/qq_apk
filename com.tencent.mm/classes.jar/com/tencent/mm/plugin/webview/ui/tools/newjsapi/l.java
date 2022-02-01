package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", "getScreenBrightness", "getVolume", "handleMsg", "hideKeyBoard", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"})
public final class l
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int CDJ = 372;
  public static final l Jxn;
  private static final String edq = "handleDeviceInfo";
  
  static
  {
    AppMethodBeat.i(210606);
    Jxn = new l();
    CDJ = 372;
    edq = "handleDeviceInfo";
    AppMethodBeat.o(210606);
  }
  
  public final boolean a(final f paramf, final n paramn)
  {
    int i = 0;
    AppMethodBeat.i(210605);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail action is empty", null);
      AppMethodBeat.o(210605);
      return true;
    }
    boolean bool;
    if (p.j("enableFullScreen", localObject))
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
          localObject = paramf.context;
          if (localObject != null) {
            break;
          }
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(210605);
          throw paramf;
          i = 90;
          continue;
          i = -90;
        }
        ((b)localObject).aB(null, i);
      }
      for (;;)
      {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
        AppMethodBeat.o(210605);
        return true;
        label288:
        localObject = paramf.context;
        if (localObject == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(210605);
          throw paramf;
        }
        ((b)localObject).gfl();
      }
    }
    Context localContext;
    if (p.j("setOrientation", localObject))
    {
      i = Util.getInt((String)paramn.params.get("orientation"), 0);
      bool = Util.getBoolean((String)paramn.params.get("lock"), true);
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
      if ((paramf.context instanceof b))
      {
        if (!bool) {
          break label554;
        }
        localContext = paramf.context;
        localObject = localContext;
        if (!(localContext instanceof Activity)) {
          localObject = null;
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
      for (;;)
      {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
        AppMethodBeat.o(210605);
        return true;
        ((Activity)localObject).setRequestedOrientation(0);
        continue;
        ((Activity)localObject).setRequestedOrientation(8);
        continue;
        label554:
        localContext = paramf.context;
        localObject = localContext;
        if (!(localContext instanceof Activity)) {
          localObject = null;
        }
        localObject = (Activity)localObject;
        if (localObject != null) {
          ((Activity)localObject).setRequestedOrientation(-1);
        }
      }
    }
    final float f;
    if (p.j("setVolume", localObject))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)Util.getDouble((String)paramn.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(210605);
        return false;
      }
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        d.h((kotlin.g.a.a)new f((Activity)localObject, f, paramf, paramn));
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return true;
    }
    if (p.j("getVolume", localObject))
    {
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        d.h((kotlin.g.a.a)new c((Activity)localObject, paramf, paramn));
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return false;
    }
    if (p.j("setScreenBrightness", localObject))
    {
      Log.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)Util.getDouble((String)paramn.params.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(210605);
        return false;
      }
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      if ((Activity)localObject != null)
      {
        d.h((kotlin.g.a.a)new e(paramf, f, paramn));
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return true;
    }
    if (p.j("getScreenBrightness", localObject))
    {
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        d.h((kotlin.g.a.a)new b((Activity)localObject, paramf, paramn));
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return false;
    }
    if (p.j("getSafeAreaInsets", localObject))
    {
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        d.h((kotlin.g.a.a)new a((Activity)localObject, paramf, paramn));
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return false;
    }
    if (p.j("hideKeyBoard", localObject))
    {
      localContext = paramf.context;
      localObject = localContext;
      if (!(localContext instanceof WebViewUI)) {
        localObject = null;
      }
      localObject = (WebViewUI)localObject;
      if (localObject != null)
      {
        d.h((kotlin.g.a.a)new d((WebViewUI)localObject, paramf, paramn));
        AppMethodBeat.o(210605);
        return true;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210605);
      return false;
    }
    AppMethodBeat.o(210605);
    return false;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(Activity paramActivity, f paramf, n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$hideKeyBoard$1$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(WebViewUI paramWebViewUI, f paramf, n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, float paramFloat, n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.l
 * JD-Core Version:    0.7.0.1
 */