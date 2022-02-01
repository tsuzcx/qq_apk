package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class q
  extends a
{
  private static final int ECX = 363;
  public static final q EHV;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String dLB = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    EHV = new q();
    TAG = "MicroMsg.JsApiSaveWaid";
    ECX = 363;
    dLB = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199443);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      ae.i(TAG, "h5 JsApiSaveWaid");
      p.g(paraml.Efz.toString(), "msg.rawParams.toString()");
      localHashMap.put("result", "0");
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", (Map)localHashMap);
      AppMethodBeat.o(199443);
      return true;
    }
    catch (Exception localException)
    {
      ae.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", (Map)localHashMap);
      AppMethodBeat.o(199443);
    }
    return false;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.q
 * JD-Core Version:    0.7.0.1
 */