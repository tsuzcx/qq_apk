package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoHide;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int IIl = 347;
  public static final e QuT;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoHide";
  private static final String fXz = "currentMpInfoHide";
  
  static
  {
    AppMethodBeat.i(175680);
    QuT = new e();
    TAG = "MicroMsg.JsApiCurrentMpInfoHide";
    IIl = 347;
    fXz = "currentMpInfoHide";
    AppMethodBeat.o(175680);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(221859);
    kotlin.g.b.p.k(paramf, "env");
    kotlin.g.b.p.k(paramn, "msg");
    Context localContext = paramf.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).PHI != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_current_info_show", false);
      ((WebViewUI)localContext).PHI.ba(localBundle);
    }
    paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
    AppMethodBeat.o(221859);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.e
 * JD-Core Version:    0.7.0.1
 */