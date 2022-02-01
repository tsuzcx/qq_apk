package com.tencent.mm.plugin.webview.ui.tools.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i
  extends a
{
  private static final int Bpa = 0;
  public static final i BtB;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String dAn = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    BtB = new i();
    TAG = "MicroMsg.JsApiLog";
    dAn = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188936);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    paramd = TAG;
    StringBuilder localStringBuilder = new StringBuilder("jslog : ");
    paraml = paraml.uLu.get("msg");
    if (paraml == null) {
      k.fvU();
    }
    ad.i(paramd, paraml);
    AppMethodBeat.o(188936);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.i
 * JD-Core Version:    0.7.0.1
 */