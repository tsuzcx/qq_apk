package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.n;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoHide;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int ECX = 347;
  public static final e EHx;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoHide";
  private static final String dLB = "currentMpInfoHide";
  
  static
  {
    AppMethodBeat.i(175680);
    EHx = new e();
    TAG = "MicroMsg.JsApiCurrentMpInfoHide";
    ECX = 347;
    dLB = "currentMpInfoHide";
    AppMethodBeat.o(175680);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199393);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Context localContext = paramd.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).Ewa != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_current_info_show", false);
      ((WebViewUI)localContext).Ewa.aR(localBundle);
    }
    paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
    AppMethodBeat.o(199393);
    return true;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.e
 * JD-Core Version:    0.7.0.1
 */