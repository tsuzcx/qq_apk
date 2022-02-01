package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final ag XnW;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175689);
    XnW = new ag();
    TAG = "MicroMsg.JsApiSaveWaid";
    OOk = 363;
    idA = "saveWaid";
    AppMethodBeat.o(175689);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297555);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    HashMap localHashMap = new HashMap();
    try
    {
      Log.i(TAG, "h5 JsApiSaveWaid");
      s.s(paramp.WEI.toString(), "msg.rawParams.toString()");
      localHashMap.put("result", "0");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localHashMap);
      AppMethodBeat.o(297555);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(TAG, s.X("h5 JsApiSaveWaid exp=", localException));
      localHashMap.put("result", "0");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), (Map)localHashMap);
      AppMethodBeat.o(297555);
    }
    return false;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ag
 * JD-Core Version:    0.7.0.1
 */