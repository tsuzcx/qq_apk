package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends a
{
  private static final int OOk = 0;
  private static final String TAG;
  public static final t Xnq;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(175684);
    Xnq = new t();
    TAG = "MicroMsg.JsApiLog";
    idA = "log";
    AppMethodBeat.o(175684);
  }
  
  private static final void cL(p paramp)
  {
    AppMethodBeat.i(297725);
    s.u(paramp, "$msg");
    Log.i(TAG, "jslog : %s", new Object[] { (String)paramp.params.get("msg") });
    AppMethodBeat.o(297725);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297749);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    com.tencent.threadpool.h.ahAA.bm(new t..ExternalSyntheticLambda0(paramp));
    AppMethodBeat.o(297749);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.t
 * JD-Core Version:    0.7.0.1
 */