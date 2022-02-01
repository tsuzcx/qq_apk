package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoHide;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int CHh = 347;
  public static final c CLw;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoHide";
  private static final String dxZ = "currentMpInfoHide";
  
  static
  {
    AppMethodBeat.i(175680);
    CLw = new c();
    TAG = "MicroMsg.JsApiCurrentMpInfoHide";
    CHh = 347;
    dxZ = "currentMpInfoHide";
    AppMethodBeat.o(175680);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189489);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).CAq != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_current_info_show", false);
      ((WebViewUI)localContext).CAq.aL(localBundle);
    }
    paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
    AppMethodBeat.o(189489);
    return true;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.c
 * JD-Core Version:    0.7.0.1
 */