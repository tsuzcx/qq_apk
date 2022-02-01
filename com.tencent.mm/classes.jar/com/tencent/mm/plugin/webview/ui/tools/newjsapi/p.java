package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.g.f.a;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class p
  extends a
{
  private static final int ECX = 331;
  public static final p EHU;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String dLB = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    EHU = new p();
    TAG = "MicroMsg.JsApiRequest";
    ECX = 331;
    dLB = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199442);
    d.g.b.p.h(paramd, "env");
    d.g.b.p.h(paraml, "msg");
    boolean bool = com.tencent.mm.plugin.webview.g.f.a(paraml, (f.a)new a(paramd));
    AppMethodBeat.o(199442);
    return bool;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements f.a
  {
    a(d paramd) {}
    
    public final void a(com.tencent.mm.plugin.webview.c.l paraml, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(199441);
      this.EDa.DQe.i(paraml.Efy, paramString, paramMap);
      AppMethodBeat.o(199441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.p
 * JD-Core Version:    0.7.0.1
 */