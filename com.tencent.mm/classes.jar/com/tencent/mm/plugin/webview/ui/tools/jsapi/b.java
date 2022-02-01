package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPasteboardContent;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final b Xil;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(164014);
    Xil = new b();
    TAG = "MicroMsg.JsApiGetPasteboardContent";
    OOk = 364;
    idA = "getPasteboardContent";
    AppMethodBeat.o(164014);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297378);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject = ClipboardHelper.getText(paramh.context);
    Log.i(TAG, s.X("do get pasteboard content: ", localObject));
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label97;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail nocontent"), ak.kkZ());
    }
    for (;;)
    {
      AppMethodBeat.o(297378);
      return true;
      i = 0;
      break;
      label97:
      s.s(localObject, "text");
      localObject = ak.l(v.Y("content", localObject));
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.b
 * JD-Core Version:    0.7.0.1
 */