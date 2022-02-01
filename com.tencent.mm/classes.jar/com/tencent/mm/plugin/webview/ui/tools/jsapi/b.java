package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends a
{
  private static final int CDJ = 364;
  public static final b JsA;
  private static final String TAG = "MicroMsg.JsApiGetPasteboardContent";
  private static final String edq = "getPasteboardContent";
  
  static
  {
    AppMethodBeat.i(164014);
    JsA = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    CDJ = 364;
    edq = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210547);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject = ClipboardHelper.getText(paramf.context);
    Log.i(TAG, "do get pasteboard content: " + (CharSequence)localObject);
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail nocontent", ae.emptyMap());
    }
    for (;;)
    {
      AppMethodBeat.o(210547);
      return true;
      i = 0;
      break;
      label118:
      localObject = ae.b(s.U("content", localObject));
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", (Map)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */