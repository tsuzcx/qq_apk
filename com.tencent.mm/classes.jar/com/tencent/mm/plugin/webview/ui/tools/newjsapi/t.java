package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.h.e;
import com.tencent.mm.plugin.webview.h.e.a;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class t
  extends a
{
  private static final int IIl = 331;
  public static final t QvA;
  private static final String TAG = "MicroMsg.JsApiRequest";
  private static final String fXz = "request";
  
  static
  {
    AppMethodBeat.i(175687);
    QvA = new t();
    TAG = "MicroMsg.JsApiRequest";
    IIl = 331;
    fXz = "request";
    AppMethodBeat.o(175687);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(266656);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    boolean bool = e.a(paramn, (e.a)new a(paramf));
    AppMethodBeat.o(266656);
    return bool;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
  static final class a
    implements e.a
  {
    a(f paramf) {}
    
    public final void a(n paramn, String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(227611);
      this.IIg.PNo.h(paramn.POu, paramString, paramMap);
      AppMethodBeat.o(227611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.t
 * JD-Core Version:    0.7.0.1
 */