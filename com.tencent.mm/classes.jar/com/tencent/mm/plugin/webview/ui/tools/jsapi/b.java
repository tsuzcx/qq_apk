package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import d.g.b.p;
import d.u;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int ECX = 364;
  public static final b ECY;
  private static final String TAG = "MicroMsg.JsApiGetPasteboardContent";
  private static final String dLB = "getPasteboardContent";
  
  static
  {
    AppMethodBeat.i(164014);
    ECY = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    ECX = 364;
    dLB = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199355);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject = com.tencent.mm.pluginsdk.i.a.fee();
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "do get pasteboard content: " + (CharSequence)localObject);
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail nocontent", d.a.ae.emptyMap());
    }
    for (;;)
    {
      AppMethodBeat.o(199355);
      return true;
      i = 0;
      break;
      label114:
      localObject = d.a.ae.c(u.R("content", localObject));
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", (Map)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */