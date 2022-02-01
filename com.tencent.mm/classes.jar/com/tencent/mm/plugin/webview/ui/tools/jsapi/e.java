package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import d.g.b.k;
import d.y;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int CHh = 295;
  public static final e CHm;
  private static final String dxZ = "invokeMiniProgramAPI";
  
  static
  {
    AppMethodBeat.i(175672);
    CHm = new e();
    CHh = 295;
    dxZ = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189470);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    i locali = (i)g.ab(i.class);
    if (locali != null)
    {
      String str = paraml.Cku.optString("name");
      Object localObject = paraml.Cku.opt("arg");
      locali.a(paramd.Cjq.getBinderID(), str, localObject);
    }
    for (;;)
    {
      paramd.Cjq.j(paraml.Ckt, dxZ + ":ok", null);
      AppMethodBeat.o(189470);
      return true;
      ((d.g.a.a)a.CHn).invoke();
    }
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a CHn;
    
    static
    {
      AppMethodBeat.i(175670);
      CHn = new a();
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