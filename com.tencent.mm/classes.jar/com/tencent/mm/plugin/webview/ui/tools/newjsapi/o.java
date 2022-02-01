package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends a
{
  private static final int OOk;
  public static final o Xnh;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(182677);
    Xnh = new o();
    OOk = 367;
    idA = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    int j = 0;
    AppMethodBeat.i(297809);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject = (String)paramp.params.get("action");
    Log.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail action is empty"), null);
      AppMethodBeat.o(297809);
      return true;
    }
    if (s.p(localObject, "report"))
    {
      localObject = (String)paramp.params.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail data is empty"), null);
        AppMethodBeat.o(297809);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = Util.safeParseInt(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      Log.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      s.s(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(k, (String)localObject);
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297809);
      return true;
    }
    AppMethodBeat.o(297809);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.o
 * JD-Core Version:    0.7.0.1
 */