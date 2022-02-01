package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class o
  extends a
{
  private static final int CDJ = 0;
  public static final o Jxz;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String edq = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    Jxz = new o();
    TAG = "MicroMsg.JsApiLog";
    edq = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210627);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    h.RTc.aX((Runnable)new a(paramn));
    AppMethodBeat.o(210627);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(210626);
      o localo = o.Jxz;
      Log.i(o.gib(), "jslog : %s", new Object[] { (String)this.pGr.params.get("msg") });
      AppMethodBeat.o(210626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.o
 * JD-Core Version:    0.7.0.1
 */