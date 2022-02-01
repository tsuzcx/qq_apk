package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.d.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class f
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 295;
  public static final f Qqb;
  static final String fXz = "invokeMiniProgramAPI";
  
  static
  {
    AppMethodBeat.i(175672);
    Qqb = new f();
    IIl = 295;
    fXz = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(267858);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    j localj = (j)com.tencent.mm.kernel.h.ae(j.class);
    if (localj != null)
    {
      String str = paramn.POv.optString("name");
      Object localObject = paramn.POv.opt("arg");
      localj.a(paramf.PNo.getBinderID(), str, localObject);
    }
    for (;;)
    {
      paramf.PNo.h(paramn.POu, fXz + ":ok", null);
      AppMethodBeat.o(267858);
      return true;
      ((kotlin.g.a.a)a.Qqc).invoke();
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a Qqc;
    
    static
    {
      AppMethodBeat.i(175670);
      Qqc = new a();
      AppMethodBeat.o(175670);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f
 * JD-Core Version:    0.7.0.1
 */