package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final ac XnQ;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175687);
    XnQ = new ac();
    TAG = "MicroMsg.JsApiRequest";
    OOk = 331;
    idA = "request";
    AppMethodBeat.o(175687);
  }
  
  private static final void a(h paramh, p paramp, String paramString, Map paramMap)
  {
    AppMethodBeat.i(297621);
    s.u(paramh, "$env");
    paramh.WDy.doCallback(paramp.WEH, paramString, paramMap);
    AppMethodBeat.o(297621);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297640);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    boolean bool = com.tencent.mm.plugin.webview.g.e.a(paramp, new ac..ExternalSyntheticLambda0(paramh));
    AppMethodBeat.o(297640);
    return bool;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ac
 * JD-Core Version:    0.7.0.1
 */