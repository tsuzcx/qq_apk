package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoHide;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int CDJ = 347;
  public static final e Jxe;
  private static final String TAG = "MicroMsg.JsApiCurrentMpInfoHide";
  private static final String edq = "currentMpInfoHide";
  
  static
  {
    AppMethodBeat.i(175680);
    Jxe = new e();
    TAG = "MicroMsg.JsApiCurrentMpInfoHide";
    CDJ = 347;
    edq = "currentMpInfoHide";
    AppMethodBeat.o(175680);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210585);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Context localContext = paramf.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).ILE != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_current_info_show", false);
      ((WebViewUI)localContext).ILE.bd(localBundle);
    }
    paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
    AppMethodBeat.o(210585);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.e
 * JD-Core Version:    0.7.0.1
 */