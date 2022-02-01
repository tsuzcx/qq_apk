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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class t
  extends a
{
  private static final int CDJ = 363;
  public static final t JxK;
  private static final String TAG = "MicroMsg.JsApiSaveWaid";
  private static final String edq = "saveWaid";
  
  static
  {
    AppMethodBeat.i(175689);
    JxK = new t();
    TAG = "MicroMsg.JsApiSaveWaid";
    CDJ = 363;
    edq = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210666);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      Log.i(TAG, "h5 JsApiSaveWaid");
      p.g(paramn.ISf.toString(), "msg.rawParams.toString()");
      localHashMap.put("result", "0");
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", (Map)localHashMap);
      AppMethodBeat.o(210666);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(localException)));
      localHashMap.put("result", "0");
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", (Map)localHashMap);
      AppMethodBeat.o(210666);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.t
 * JD-Core Version:    0.7.0.1
 */