package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreloadLiteApp;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends a
{
  private static final int OOk;
  public static final y XnL;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297717);
    XnL = new y();
    OOk = 405;
    idA = "preloadLiteApp";
    AppMethodBeat.o(297717);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297733);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject2 = "";
    if (paramp.WEI.has("onlyPreLoadBaseLib")) {}
    for (boolean bool = paramp.WEI.optBoolean("onlyPreLoadBaseLib");; bool = false)
    {
      Object localObject1;
      String str;
      if (!bool)
      {
        if (paramp.params.get("appId") == null)
        {
          paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": fail"), null);
          AppMethodBeat.o(297733);
          return false;
        }
        localObject1 = paramp.params.get("appId");
        if (localObject1 == null)
        {
          paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(297733);
          throw paramh;
        }
        localObject1 = (String)localObject1;
        if (paramp.params.get("page") != null)
        {
          localObject2 = paramp.params.get("page");
          if (localObject2 == null)
          {
            paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(297733);
            throw paramh;
          }
          str = (String)localObject2;
          localObject2 = localObject1;
          localObject1 = str;
        }
      }
      for (;;)
      {
        if (bool) {}
        for (str = "updateBaseLibPath";; str = "preloadLiteApp")
        {
          ((c)com.tencent.mm.kernel.h.ax(c.class)).aB((String)localObject2, (String)localObject1, str);
          paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": success"), null);
          AppMethodBeat.o(297733);
          return true;
        }
        str = "";
        localObject2 = localObject1;
        localObject1 = str;
        continue;
        localObject1 = "";
      }
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.y
 * JD-Core Version:    0.7.0.1
 */