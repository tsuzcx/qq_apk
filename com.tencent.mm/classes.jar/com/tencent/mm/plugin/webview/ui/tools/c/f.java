package com.tencent.mm.plugin.webview.ui.tools.c;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.d.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.v;
import d.y;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", "getScreenBrightness", "getVolume", "handleMsg", "setOrientation", "setScreenBrightness", "setVolume", "plugin-webview_release"})
public final class f
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int Bpa = 372;
  public static final f Btt;
  private static final String dAn = "handleDeviceInfo";
  
  static
  {
    AppMethodBeat.i(188929);
    Btt = new f();
    Bpa = 372;
    dAn = "handleDeviceInfo";
    AppMethodBeat.o(188929);
  }
  
  public final boolean a(final d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    int i = 0;
    AppMethodBeat.i(188928);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject = (String)paraml.uLu.get("action");
    ad.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail action is empty", null);
      AppMethodBeat.o(188928);
      return true;
    }
    boolean bool;
    if (k.g("enableFullScreen", localObject))
    {
      bool = bt.getBoolean((String)paraml.uLu.get("enable"), false);
      if ((paramd.context instanceof b))
      {
        if (!bool) {
          break label288;
        }
        switch (bt.getInt((String)paraml.uLu.get("orientation"), 0))
        {
        }
        for (;;)
        {
          localObject = paramd.context;
          if (localObject != null) {
            break;
          }
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(188928);
          throw paramd;
          i = 90;
          continue;
          i = -90;
        }
        ((b)localObject).at(null, i);
      }
      for (;;)
      {
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
        AppMethodBeat.o(188928);
        return true;
        label288:
        localObject = paramd.context;
        if (localObject == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
          AppMethodBeat.o(188928);
          throw paramd;
        }
        ((b)localObject).eop();
      }
    }
    Context localContext;
    if (k.g("setOrientation", localObject))
    {
      i = bt.getInt((String)paraml.uLu.get("orientation"), 0);
      bool = bt.getBoolean((String)paraml.uLu.get("lock"), true);
      ad.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i + ", lock=" + bool);
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
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
        AppMethodBeat.o(188928);
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
      ad.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume");
      f = (float)bt.getDouble((String)paraml.uLu.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(188928);
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
        c.g((d.g.a.a)new e((Activity)localObject, f, paramd, paraml));
        AppMethodBeat.o(188928);
        return true;
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      AppMethodBeat.o(188928);
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
        AppMethodBeat.o(188928);
        return true;
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      AppMethodBeat.o(188928);
      return false;
    }
    if (k.g("setScreenBrightness", localObject))
    {
      ad.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness");
      f = (float)bt.getDouble((String)paraml.uLu.get("data"), 0.0D);
      if ((f < 0.0F) || (f > 1.0F))
      {
        AppMethodBeat.o(188928);
        return false;
      }
      localContext = paramd.context;
      localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      if ((Activity)localObject != null)
      {
        c.g((d.g.a.a)new d(paramd, f, paraml));
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
        AppMethodBeat.o(188928);
        return true;
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      AppMethodBeat.o(188928);
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
        AppMethodBeat.o(188928);
        return true;
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      AppMethodBeat.o(188928);
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
        AppMethodBeat.o(188928);
        return true;
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      AppMethodBeat.o(188928);
      return false;
    }
    AppMethodBeat.o(188928);
    return false;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(Activity paramActivity, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(d paramd, float paramFloat, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(Activity paramActivity, float paramFloat, d paramd, com.tencent.mm.plugin.webview.c.l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.f
 * JD-Core Version:    0.7.0.1
 */