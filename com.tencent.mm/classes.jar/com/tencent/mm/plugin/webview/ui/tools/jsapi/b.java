package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.g.b.p;
import d.u;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int EkT = 364;
  public static final b EkU;
  private static final String TAG = "MicroMsg.JsApiGetPasteboardContent";
  private static final String dKm = "getPasteboardContent";
  
  static
  {
    AppMethodBeat.i(164014);
    EkU = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    EkT = 364;
    dKm = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207599);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject = com.tencent.mm.pluginsdk.i.a.faq();
    ad.i(TAG, "do get pasteboard content: " + (CharSequence)localObject);
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail nocontent", ae.emptyMap());
    }
    for (;;)
    {
      AppMethodBeat.o(207599);
      return true;
      i = 0;
      break;
      label114:
      localObject = ae.c(u.S("content", localObject));
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", (Map)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */