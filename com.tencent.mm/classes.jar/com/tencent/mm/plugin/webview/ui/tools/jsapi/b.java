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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends a
{
  private static final int IIl = 364;
  public static final b QpX;
  private static final String TAG = "MicroMsg.JsApiGetPasteboardContent";
  private static final String fXz = "getPasteboardContent";
  
  static
  {
    AppMethodBeat.i(164014);
    QpX = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    IIl = 364;
    fXz = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(225947);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject = ClipboardHelper.getText(paramf.context);
    Log.i(TAG, "do get pasteboard content: " + (CharSequence)localObject);
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":fail nocontent", ae.iBR());
    }
    for (;;)
    {
      AppMethodBeat.o(225947);
      return true;
      i = 0;
      break;
      label118:
      localObject = ae.d(s.M("content", localObject));
      paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localObject);
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */