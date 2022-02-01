package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class n
  extends a
{
  private static final int ECX = 0;
  public static final n EHR;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String dLB = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    EHR = new n();
    TAG = "MicroMsg.JsApiLog";
    dLB = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199427);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    h.MqF.aO((Runnable)new a(paraml));
    AppMethodBeat.o(199427);
    return true;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(199426);
      n localn = n.EHR;
      ae.i(n.eYU(), "jslog : %s", new Object[] { (String)this.osU.xqN.get("msg") });
      AppMethodBeat.o(199426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.n
 * JD-Core Version:    0.7.0.1
 */