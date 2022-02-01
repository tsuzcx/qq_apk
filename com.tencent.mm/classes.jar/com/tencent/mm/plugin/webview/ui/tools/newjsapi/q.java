package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class q
  extends a
{
  private static final int EkT = 363;
  public static final q EpK;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String dKm = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    EpK = new q();
    TAG = "MicroMsg.JsApiSaveWaid";
    EkT = 363;
    dKm = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207677);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      ad.i(TAG, "h5 JsApiSaveWaid");
      p.g(paraml.DNA.toString(), "msg.rawParams.toString()");
      localHashMap.put("result", "0");
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", (Map)localHashMap);
      AppMethodBeat.o(207677);
      return true;
    }
    catch (Exception localException)
    {
      ad.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail", (Map)localHashMap);
      AppMethodBeat.o(207677);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.q
 * JD-Core Version:    0.7.0.1
 */