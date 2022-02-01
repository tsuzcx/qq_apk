package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoHide;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final e XmQ;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175680);
    XmQ = new e();
    TAG = "MicroMsg.JsApiCurrentMpInfoHide";
    OOk = 347;
    idA = "currentMpInfoHide";
    AppMethodBeat.o(175680);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297899);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Context localContext = paramh.context;
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).Wyi != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_current_info_show", false);
      ((WebViewUI)localContext).Wyi.bD(localBundle);
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
    AppMethodBeat.o(297899);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.e
 * JD-Core Version:    0.7.0.1
 */