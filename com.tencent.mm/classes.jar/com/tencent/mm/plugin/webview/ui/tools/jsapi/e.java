package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import d.g.b.p;
import d.g.b.q;
import d.z;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int ECX = 295;
  public static final e EDc;
  private static final String dLB = "invokeMiniProgramAPI";
  
  static
  {
    AppMethodBeat.i(175672);
    EDc = new e();
    ECX = 295;
    dLB = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199361);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    i locali = (i)g.ab(i.class);
    if (locali != null)
    {
      String str = paraml.Efz.optString("name");
      Object localObject = paraml.Efz.opt("arg");
      locali.a(paramd.DQe.getBinderID(), str, localObject);
    }
    for (;;)
    {
      paramd.DQe.i(paraml.Efy, dLB + ":ok", null);
      AppMethodBeat.o(199361);
      return true;
      ((d.g.a.a)a.EDd).invoke();
    }
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a EDd;
    
    static
    {
      AppMethodBeat.i(175670);
      EDd = new a();
      AppMethodBeat.o(175670);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.e
 * JD-Core Version:    0.7.0.1
 */