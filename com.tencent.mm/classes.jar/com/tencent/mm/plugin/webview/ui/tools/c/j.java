package com.tencent.mm.plugin.webview.ui.tools.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.g.f.a;
import d.g.b.k;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class j
  extends a
{
  private static final int Bpa = 331;
  public static final j BtC;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String dAn = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    BtC = new j();
    TAG = "MicroMsg.JsApiRequest";
    Bpa = 331;
    dAn = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188938);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    boolean bool = com.tencent.mm.plugin.webview.g.f.a(paraml, (f.a)new a(paramd));
    AppMethodBeat.o(188938);
    return bool;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements f.a
  {
    a(d paramd) {}
    
    public final void a(com.tencent.mm.plugin.webview.c.l paraml, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(188937);
      this.Bpd.ARd.h(paraml.ASg, paramString, paramMap);
      AppMethodBeat.o(188937);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.j
 * JD-Core Version:    0.7.0.1
 */