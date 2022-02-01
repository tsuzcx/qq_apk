package com.tencent.mm.plugin.webview.ui.tools.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.waid.g;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class k
  extends a
{
  private static final int Bpa = 363;
  public static final k BtD;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String dAn = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    BtD = new k();
    TAG = "MicroMsg.JsApiSaveWaid";
    Bpa = 363;
    dAn = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188939);
    d.g.b.k.h(paramd, "env");
    d.g.b.k.h(paraml, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      ad.i(TAG, "h5 JsApiSaveWaid");
      String str = paraml.ASh.toString();
      d.g.b.k.g(str, "msg.rawParams.toString()");
      localHashMap.put("result", String.valueOf(g.aqX(str)));
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", (Map)localHashMap);
      AppMethodBeat.o(188939);
      return true;
    }
    catch (Exception localException)
    {
      ad.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", (Map)localHashMap);
      AppMethodBeat.o(188939);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.k
 * JD-Core Version:    0.7.0.1
 */