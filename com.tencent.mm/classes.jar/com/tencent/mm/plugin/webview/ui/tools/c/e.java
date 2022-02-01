package com.tencent.mm.plugin.webview.ui.tools.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int Bpa = 367;
  public static final e Bts;
  private static final String dAn = "handleAdAction";
  
  static
  {
    AppMethodBeat.i(182677);
    Bts = new e();
    Bpa = 367;
    dAn = "handleAdAction";
    AppMethodBeat.o(182677);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    int j = 0;
    AppMethodBeat.i(188922);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject = (String)paraml.uLu.get("action");
    ad.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", new Object[] { localObject });
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail action is empty", null);
      AppMethodBeat.o(188922);
      return true;
    }
    if (k.g(localObject, "report"))
    {
      localObject = (String)paraml.uLu.get("data");
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail data is empty", null);
        AppMethodBeat.o(188922);
        return true;
      }
      localObject = new JSONObject((String)localObject);
      int k = bt.aGh(((JSONObject)localObject).optString("logid"));
      localObject = ((JSONObject)localObject).optString("logstr");
      ad.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", new Object[] { Integer.valueOf(k), localObject });
      k.g(localObject, "logStr");
      i = j;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        h.vKh.kvStat(k, (String)localObject);
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      AppMethodBeat.o(188922);
      return true;
    }
    AppMethodBeat.o(188922);
    return false;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.e
 * JD-Core Version:    0.7.0.1
 */