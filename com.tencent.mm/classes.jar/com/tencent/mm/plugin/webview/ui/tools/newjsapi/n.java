package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiLog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class n
  extends a
{
  private static final int EkT = 0;
  public static final n EpG;
  private static final String TAG = "MicroMsg.JsApiLog";
  private static final String dKm = "log";
  
  static
  {
    AppMethodBeat.i(175684);
    EpG = new n();
    TAG = "MicroMsg.JsApiLog";
    dKm = "log";
    AppMethodBeat.o(175684);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207661);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    h.LTJ.aR((Runnable)new a(paraml));
    AppMethodBeat.o(207661);
    return true;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(207660);
      n localn = n.EpG;
      ad.i(n.eVh(), "jslog : %s", new Object[] { (String)this.one.xaW.get("msg") });
      AppMethodBeat.o(207660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.n
 * JD-Core Version:    0.7.0.1
 */