package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.h.f.a;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class q
  extends a
{
  private static final int CDJ = 331;
  public static final q JxD;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String edq = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    JxD = new q();
    TAG = "MicroMsg.JsApiRequest";
    CDJ = 331;
    edq = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(210652);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    boolean bool = com.tencent.mm.plugin.webview.h.f.a(paramn, (f.a)new a(paramf));
    AppMethodBeat.o(210652);
    return bool;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements f.a
  {
    a(com.tencent.mm.plugin.webview.d.f paramf) {}
    
    public final void a(n paramn, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(210651);
      this.CDE.IQZ.h(paramn.ISe, paramString, paramMap);
      AppMethodBeat.o(210651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.q
 * JD-Core Version:    0.7.0.1
 */