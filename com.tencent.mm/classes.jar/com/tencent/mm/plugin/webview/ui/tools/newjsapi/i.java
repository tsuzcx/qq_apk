package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i
  extends a
{
  private static final int CHh = 0;
  public static final i CLI;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String dxZ = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    CLI = new i();
    TAG = "MicroMsg.JsApiLog";
    dxZ = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189506);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    paramd = TAG;
    StringBuilder localStringBuilder = new StringBuilder("jslog : ");
    paraml = paraml.vUl.get("msg");
    if (paraml == null) {
      k.fOy();
    }
    ac.i(paramd, paraml);
    AppMethodBeat.o(189506);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.i
 * JD-Core Version:    0.7.0.1
 */