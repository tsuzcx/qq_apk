package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.b.k;
import d.u;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int CHh = 364;
  public static final b CHi;
  private static final String TAG = "MicroMsg.JsApiGetPasteboardContent";
  private static final String dxZ = "getPasteboardContent";
  
  static
  {
    AppMethodBeat.i(164014);
    CHi = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    CHh = 364;
    dxZ = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189464);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject = com.tencent.mm.pluginsdk.g.a.eLv();
    ac.i(TAG, "do get pasteboard content: " + (CharSequence)localObject);
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail nocontent", ae.emptyMap());
    }
    for (;;)
    {
      AppMethodBeat.o(189464);
      return true;
      i = 0;
      break;
      label114:
      localObject = ae.b(u.Q("content", localObject));
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", (Map)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */