package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class k
  extends a
{
  private static final int CDJ = 367;
  public static final k Jxm;
  private static final String edq = "handleAdAction";
  
  static
  {
    AppMethodBeat.i(182677);
    Jxm = new k();
    CDJ = 367;
    edq = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    int j = 0;
    AppMethodBeat.i(210598);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail action is empty", null);
      AppMethodBeat.o(210598);
      return true;
    }
    if (p.j(localObject, "report"))
    {
      localObject = (String)paramn.params.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail data is empty", null);
        AppMethodBeat.o(210598);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = Util.safeParseInt(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      Log.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      p.g(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(k, (String)localObject);
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
      AppMethodBeat.o(210598);
      return true;
    }
    AppMethodBeat.o(210598);
    return false;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.k
 * JD-Core Version:    0.7.0.1
 */