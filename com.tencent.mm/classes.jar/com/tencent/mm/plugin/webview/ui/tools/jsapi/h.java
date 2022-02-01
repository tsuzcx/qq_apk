package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiPreDownloadMiniProgramPackage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  private static final int OOk;
  public static final h Xir;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297464);
    Xir = new h();
    OOk = 443;
    idA = "predownloadMiniProgramPackage";
    AppMethodBeat.o(297464);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297476);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str1 = aj.au(paramp.params, "username");
    String str2 = aj.au(paramp.params, "path");
    int j = aj.c(paramp.params, "scene", 1);
    CharSequence localCharSequence = (CharSequence)str1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":fail invalid data"), null);
      AppMethodBeat.o(297476);
      return true;
    }
    ((y)com.tencent.mm.kernel.h.ax(y.class)).y(str1, str2, j);
    paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":ok"), null);
    AppMethodBeat.o(297476);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.h
 * JD-Core Version:    0.7.0.1
 */