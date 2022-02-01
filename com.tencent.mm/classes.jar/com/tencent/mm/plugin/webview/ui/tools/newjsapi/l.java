package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.waid.g;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class l
  extends a
{
  private static final int CHh = 363;
  public static final l CLM;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String dxZ = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    CLM = new l();
    TAG = "MicroMsg.JsApiSaveWaid";
    CHh = 363;
    dxZ = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189522);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      ac.i(TAG, "h5 JsApiSaveWaid");
      String str = paraml.Cku.toString();
      k.g(str, "msg.rawParams.toString()");
      localHashMap.put("result", String.valueOf(g.awg(str)));
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", (Map)localHashMap);
      AppMethodBeat.o(189522);
      return true;
    }
    catch (Exception localException)
    {
      ac.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", (Map)localHashMap);
      AppMethodBeat.o(189522);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.l
 * JD-Core Version:    0.7.0.1
 */