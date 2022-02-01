package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int CDJ = 295;
  public static final e JsD;
  private static final String edq = "invokeMiniProgramAPI";
  
  static
  {
    AppMethodBeat.i(175672);
    JsD = new e();
    CDJ = 295;
    edq = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210553);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    j localj = (j)g.af(j.class);
    if (localj != null)
    {
      String str = paramn.ISf.optString("name");
      Object localObject = paramn.ISf.opt("arg");
      localj.a(paramf.IQZ.getBinderID(), str, localObject);
    }
    for (;;)
    {
      paramf.IQZ.h(paramn.ISe, edq + ":ok", null);
      AppMethodBeat.o(210553);
      return true;
      ((kotlin.g.a.a)a.JsE).invoke();
    }
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a JsE;
    
    static
    {
      AppMethodBeat.i(175670);
      JsE = new a();
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