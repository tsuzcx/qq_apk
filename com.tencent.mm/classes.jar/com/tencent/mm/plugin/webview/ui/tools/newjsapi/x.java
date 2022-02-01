package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class x
  extends a
{
  private static final int IIl = 363;
  public static final x QvJ;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String fXz = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    QvJ = new x();
    TAG = "MicroMsg.JsApiSaveWaid";
    IIl = 363;
    fXz = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(215236);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      Log.i(TAG, "h5 JsApiSaveWaid");
      p.j(paramn.POv.toString(), "msg.rawParams.toString()");
      localHashMap.put("result", "0");
      paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localHashMap);
      AppMethodBeat.o(215236);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", (Map)localHashMap);
      AppMethodBeat.o(215236);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.x
 * JD-Core Version:    0.7.0.1
 */