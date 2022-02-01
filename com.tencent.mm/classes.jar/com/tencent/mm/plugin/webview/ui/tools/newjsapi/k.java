package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.g.f.a;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class k
  extends a
{
  private static final int CHh = 331;
  public static final k CLL;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String dxZ = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    CLL = new k();
    TAG = "MicroMsg.JsApiRequest";
    CHh = 331;
    dxZ = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189521);
    d.g.b.k.h(paramd, "env");
    d.g.b.k.h(paraml, "msg");
    boolean bool = com.tencent.mm.plugin.webview.g.f.a(paraml, (f.a)new a(paramd));
    AppMethodBeat.o(189521);
    return bool;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements f.a
  {
    a(d paramd) {}
    
    public final void a(com.tencent.mm.plugin.webview.c.l paraml, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(189520);
      this.CHk.Cjq.j(paraml.Ckt, paramString, paramMap);
      AppMethodBeat.o(189520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.k
 * JD-Core Version:    0.7.0.1
 */