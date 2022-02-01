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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int EkT = 295;
  public static final e EkY;
  private static final String dKm = "invokeMiniProgramAPI";
  
  static
  {
    AppMethodBeat.i(175672);
    EkY = new e();
    EkT = 295;
    dKm = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207605);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    i locali = (i)g.ab(i.class);
    if (locali != null)
    {
      String str = paraml.DNA.optString("name");
      Object localObject = paraml.DNA.opt("arg");
      locali.a(paramd.Dyx.getBinderID(), str, localObject);
    }
    for (;;)
    {
      paramd.Dyx.i(paraml.DNz, dKm + ":ok", null);
      AppMethodBeat.o(207605);
      return true;
      ((d.g.a.a)a.EkZ).invoke();
    }
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a EkZ;
    
    static
    {
      AppMethodBeat.i(175670);
      EkZ = new a();
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