package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenUrlWithExtraWebview;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "compatibilityMode", "", "getCompatibilityMode", "()Z", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  private static final String TAG;
  private static final boolean WFo;
  public static final x XnH;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297711);
    XnH = new x();
    TAG = "MicroMsg.JsApiOpenUrlWithExtraWebview";
    OOk = 173;
    idA = "openUrlWithExtraWebview";
    WFo = true;
    AppMethodBeat.o(297711);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297730);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (Util.getBoolean((String)paramp.params.get("halfScreen"), false))
    {
      String str = (String)paramp.params.get("url");
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail_invalid_url"), null);
        AppMethodBeat.o(297730);
        return false;
      }
      float f = Util.getFloat((String)paramp.params.get("heightPercent"), 0.75F);
      boolean bool1 = Util.getBoolean((String)paramp.params.get("reuseWebView"), false);
      boolean bool2 = Util.getBoolean((String)paramp.params.get("immersiveUIStyle"), false);
      localObject = (String)paramp.params.get("extData");
      i = Util.getInt((String)paramp.params.get("backMode"), 0);
      int j = Util.getInt((String)paramp.params.get("openType"), 0);
      new com.tencent.mm.plugin.webview.ui.tools.widget.a(paramh.context, str, new c(f, (String)localObject, bool1, false, i, bool2, j), 4).show();
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297730);
      return true;
    }
    AppMethodBeat.o(297730);
    return false;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  public final boolean itW()
  {
    return WFo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.x
 * JD-Core Version:    0.7.0.1
 */