package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class n
  extends a
{
  private static final int IIl = 367;
  public static final n Qvg;
  private static final String fXz = "handleAdAction";
  
  static
  {
    AppMethodBeat.i(182677);
    Qvg = new n();
    IIl = 367;
    fXz = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    int j = 0;
    AppMethodBeat.i(223577);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf.PNo.h(paramn.POu, paramn.function + ":fail action is empty", null);
      AppMethodBeat.o(223577);
      return true;
    }
    if (p.h(localObject, "report"))
    {
      localObject = (String)paramn.params.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramf.PNo.h(paramn.POu, paramn.function + ":fail data is empty", null);
        AppMethodBeat.o(223577);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = Util.safeParseInt(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      Log.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      p.j(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(k, (String)localObject);
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
      AppMethodBeat.o(223577);
      return true;
    }
    AppMethodBeat.o(223577);
    return false;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.n
 * JD-Core Version:    0.7.0.1
 */