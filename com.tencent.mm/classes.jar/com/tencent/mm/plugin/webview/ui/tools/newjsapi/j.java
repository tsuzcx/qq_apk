package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.Map;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class j
  extends a
{
  private static final int EkT = 367;
  public static final j Epw;
  private static final String dKm = "handleAdAction";
  
  static
  {
    AppMethodBeat.i(182677);
    Epw = new j();
    EkT = 367;
    dKm = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    int j = 0;
    AppMethodBeat.i(207644);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject = (String)paraml.xaW.get("action");
    ad.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail action is empty", null);
      AppMethodBeat.o(207644);
      return true;
    }
    if (p.i(localObject, "report"))
    {
      localObject = (String)paraml.xaW.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail data is empty", null);
        AppMethodBeat.o(207644);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = bt.aRe(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      ad.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      p.g(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        g.yhR.kvStat(k, (String)localObject);
      }
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", null);
      AppMethodBeat.o(207644);
      return true;
    }
    AppMethodBeat.o(207644);
    return false;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.j
 * JD-Core Version:    0.7.0.1
 */