package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int CHh = 367;
  public static final e CLy;
  private static final String dxZ = "handleAdAction";
  
  static
  {
    AppMethodBeat.i(182677);
    CLy = new e();
    CHh = 367;
    dxZ = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    int j = 0;
    AppMethodBeat.i(189491);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject = (String)paraml.vUl.get("action");
    ac.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail action is empty", null);
      AppMethodBeat.o(189491);
      return true;
    }
    if (k.g(localObject, "report"))
    {
      localObject = (String)paraml.vUl.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail data is empty", null);
        AppMethodBeat.o(189491);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = bs.aLy(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      ac.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      k.g(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        h.wUl.kvStat(k, (String)localObject);
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      AppMethodBeat.o(189491);
      return true;
    }
    AppMethodBeat.o(189491);
    return false;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.e
 * JD-Core Version:    0.7.0.1
 */