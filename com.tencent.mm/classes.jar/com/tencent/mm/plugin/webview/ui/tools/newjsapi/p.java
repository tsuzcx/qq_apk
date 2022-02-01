package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.g.f.a;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class p
  extends a
{
  private static final int EkT = 331;
  public static final p EpJ;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String dKm = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    EpJ = new p();
    TAG = "MicroMsg.JsApiRequest";
    EkT = 331;
    dKm = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207676);
    d.g.b.p.h(paramd, "env");
    d.g.b.p.h(paraml, "msg");
    boolean bool = com.tencent.mm.plugin.webview.g.f.a(paraml, (f.a)new a(paramd));
    AppMethodBeat.o(207676);
    return bool;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements f.a
  {
    a(d paramd) {}
    
    public final void a(com.tencent.mm.plugin.webview.c.l paraml, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(207675);
      this.EkW.Dyx.i(paraml.DNz, paramString, paramMap);
      AppMethodBeat.o(207675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.p
 * JD-Core Version:    0.7.0.1
 */