package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class r
  extends a
{
  private static final int IIl = 0;
  public static final r Qvu;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String fXz = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    Qvu = new r();
    TAG = "MicroMsg.JsApiLog";
    fXz = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(265229);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    h.ZvG.be((Runnable)new a(paramn));
    AppMethodBeat.o(265229);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(260894);
      r localr = r.Qvu;
      Log.i(r.hbA(), "jslog : %s", new Object[] { (String)this.sRE.params.get("msg") });
      AppMethodBeat.o(260894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.r
 * JD-Core Version:    0.7.0.1
 */