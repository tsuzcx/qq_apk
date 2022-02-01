package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", "getScreenBrightness", "getVolume", "handleMsg", "hideKeyBoard", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"})
public final class k
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int ECX = 372;
  public static final k EHF;
  private static final String dLB = "handleDeviceInfo";
  
  static
  {
    AppMethodBeat.i(199411);
    EHF = new k();
    ECX = 372;
    dLB = "handleDeviceInfo";
    AppMethodBeat.o(199411);
  }
  
  public final boolean a(final d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    int i = 0;
    AppMethodBeat.i(199410);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject = (String)paraml.xqN.get("action");
    ae.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail action is empty", null);
      AppMethodBeat.o(199410);
      return true;
    }
    boolean bool;
    if (p.i("enableFullScreen", localObject))
    {
      bool = bu.getBoolean((String)paraml.xqN.get("enable"), false);
      if ((paramd.context instanceof b))
      {
        if (!bool) {
          break label288;
        }
        switch (bu.getInt((String)paraml.xqN.get("orientation"), 0))
        {
        }
        for (;;)
        {
          localObject = paramd.context;
          if (localObject != null) {
            break;
          }
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(199410);
          throw paramd;
          i = 90;
          continue;
          i = -90;
        }
        ((b)localObject).aw(null, i);
      }
      for (;;)
      {
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
        AppMethodBeat.o(199410);
        return true;
        label288:
        localObject = paramd.context;
        if (localObject == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(199410);
          throw paramd;
        }
        ((b)localObject).eWo();
      }
    }
    Context localContext;
    if (p.i("setOrientation", localObject))
    {
      i = bu.getInt((String)paraml.xqN.get("orientation"), 0);
      bool = bu.getBoolean((String)paraml.xqN.get("lock"), true);
      ae.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
      if ((paramd.context instanceof b))
      {
        if (!bool) {
          break label554;
        }
        localContext = paramd.context;
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
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
        AppMethodBeat.o(199410);
        return true;
        ((Activity)localObject).setRequestedOrientation(0);
        continue;
        ((Activity)localObject).setRequestedOrientation(8);
        continue;
        label554:
        localContext = paramd.context;
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
    if (p.i("setVolume", localObject))
    {
      ae.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)bu.getDouble((String)paraml.xqN.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(199410);
        return false;
      }
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.h((d.g.a.a)new f((Activity)localObject, f, paramd, paraml));
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return true;
    }
    if (p.i("getVolume", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.h((d.g.a.a)new c((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return false;
    }
    if (p.i("setScreenBrightness", localObject))
    {
      ae.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)bu.getDouble((String)paraml.xqN.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(199410);
        return false;
      }
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      if ((Activity)localObject != null)
      {
        c.h((d.g.a.a)new e(paramd, f, paraml));
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return true;
    }
    if (p.i("getScreenBrightness", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.h((d.g.a.a)new b((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return false;
    }
    if (p.i("getSafeAreaInsets", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.h((d.g.a.a)new a((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return false;
    }
    if (p.i("hideKeyBoard", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof WebViewUI)) {
        localObject = null;
      }
      localObject = (WebViewUI)localObject;
      if (localObject != null)
      {
        c.h((d.g.a.a)new d((WebViewUI)localObject, paramd, paraml));
        AppMethodBeat.o(199410);
        return true;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199410);
      return false;
    }
    AppMethodBeat.o(199410);
    return false;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$hideKeyBoard$1$1"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(WebViewUI paramWebViewUI, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(d paramd, float paramFloat, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(Activity paramActivity, float paramFloat, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.k
 * JD-Core Version:    0.7.0.1
 */