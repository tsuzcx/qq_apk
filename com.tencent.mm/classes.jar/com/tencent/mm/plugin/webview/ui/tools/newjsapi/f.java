package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.c.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.v;
import d.y;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", "getScreenBrightness", "getVolume", "handleMsg", "hideKeyBoard", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"})
public final class f
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int CHh = 372;
  public static final f CLz;
  private static final String dxZ = "handleDeviceInfo";
  
  static
  {
    AppMethodBeat.i(189499);
    CLz = new f();
    CHh = 372;
    dxZ = "handleDeviceInfo";
    AppMethodBeat.o(189499);
  }
  
  public final boolean a(final d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    int i = 0;
    AppMethodBeat.i(189498);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject = (String)paraml.vUl.get("action");
    ac.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject });
    if (bs.isNullOrNil((String)localObject))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail action is empty", null);
      AppMethodBeat.o(189498);
      return true;
    }
    boolean bool;
    if (k.g("enableFullScreen", localObject))
    {
      bool = bs.getBoolean((String)paraml.vUl.get("enable"), false);
      if ((paramd.context instanceof b))
      {
        if (!bool) {
          break label288;
        }
        switch (bs.getInt((String)paraml.vUl.get("orientation"), 0))
        {
        }
        for (;;)
        {
          localObject = paramd.context;
          if (localObject != null) {
            break;
          }
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(189498);
          throw paramd;
          i = 90;
          continue;
          i = -90;
        }
        ((b)localObject).av(null, i);
      }
      for (;;)
      {
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
        AppMethodBeat.o(189498);
        return true;
        label288:
        localObject = paramd.context;
        if (localObject == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(189498);
          throw paramd;
        }
        ((b)localObject).eDK();
      }
    }
    Context localContext;
    if (k.g("setOrientation", localObject))
    {
      i = bs.getInt((String)paraml.vUl.get("orientation"), 0);
      bool = bs.getBoolean((String)paraml.vUl.get("lock"), true);
      ac.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
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
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
        AppMethodBeat.o(189498);
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
    if (k.g("setVolume", localObject))
    {
      ac.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)bs.getDouble((String)paraml.vUl.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(189498);
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
        c.g((d.g.a.a)new f((Activity)localObject, f, paramd, paraml));
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return true;
    }
    if (k.g("getVolume", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.g((d.g.a.a)new c((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return false;
    }
    if (k.g("setScreenBrightness", localObject))
    {
      ac.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)bs.getDouble((String)paraml.vUl.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(189498);
        return false;
      }
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      if ((Activity)localObject != null)
      {
        c.g((d.g.a.a)new e(paramd, f, paraml));
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return true;
    }
    if (k.g("getScreenBrightness", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.g((d.g.a.a)new b((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return false;
    }
    if (k.g("getSafeAreaInsets", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        c.g((d.g.a.a)new a((Activity)localObject, paramd, paraml));
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return false;
    }
    if (k.g("hideKeyBoard", localObject))
    {
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof WebViewUI)) {
        localObject = null;
      }
      localObject = (WebViewUI)localObject;
      if (localObject != null)
      {
        c.g((d.g.a.a)new d((WebViewUI)localObject, paramd, paraml));
        AppMethodBeat.o(189498);
        return true;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189498);
      return false;
    }
    AppMethodBeat.o(189498);
    return false;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$hideKeyBoard$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(WebViewUI paramWebViewUI, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(d paramd, float paramFloat, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(Activity paramActivity, float paramFloat, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.f
 * JD-Core Version:    0.7.0.1
 */