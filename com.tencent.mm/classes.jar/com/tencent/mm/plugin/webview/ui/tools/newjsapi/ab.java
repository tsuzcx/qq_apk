package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetPageTitle;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetPageTitle", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"})
public final class ab
  extends a
{
  private static final int IIl = 113;
  public static final ab QvN;
  private static final String TAG = "MicroMsg.JsApiSetPageTitle";
  private static final String fXz = "setPageTitle";
  
  static
  {
    AppMethodBeat.i(247549);
    QvN = new ab();
    TAG = "MicroMsg.JsApiSetPageTitle";
    IIl = 113;
    fXz = "setPageTitle";
    AppMethodBeat.o(247549);
  }
  
  private static boolean l(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(247547);
    Bundle localBundle = new Bundle(2);
    localBundle.putString("set_page_title_text", (String)paramn.params.get("title"));
    localObject3 = "";
    try
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.ab.bsf((String)paramn.params.get("wxcolor"));
      if (localObject1 != null) {
        break label309;
      }
      localObject1 = "";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Log.e(TAG, localException1.getMessage());
        Object localObject4 = localObject3;
        localObject2 = localObject4;
        continue;
        int i = 0;
        continue;
        continue;
        i = 1;
      }
    }
    localObject3 = localObject1;
    localObject4 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject3 = localObject1;
      localObject4 = (String)paramn.params.get("color");
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
    }
    try
    {
      localObject3 = (String)paramn.params.get("alpha");
      localObject4 = (CharSequence)localObject3;
      if (localObject4 == null) {
        break label312;
      }
      if (!kotlin.n.n.ba((CharSequence)localObject4)) {
        break label286;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Log.e(TAG, localException2.getMessage());
        float f = 1.0F;
      }
    }
    if (i == 0)
    {
      f = Util.getFloat((String)localObject3, 1.0F);
      localBundle.putString("set_page_title_color", (String)localObject1);
      localBundle.putFloat("set_page_title_alpha", f);
      localObject3 = paramf.context;
      localObject1 = localObject3;
      if (!(localObject3 instanceof WebViewUI)) {
        localObject1 = null;
      }
      localObject1 = (WebViewUI)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((WebViewUI)localObject1).POP;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.webview.stub.f)localObject1).l(43, localBundle);
        }
      }
      paramf.PNo.h(paramn.POu, "setPageTitle:ok", null);
      AppMethodBeat.o(247547);
      return true;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(247544);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    l(paramf, paramn);
    AppMethodBeat.o(247544);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ab
 * JD-Core Version:    0.7.0.1
 */