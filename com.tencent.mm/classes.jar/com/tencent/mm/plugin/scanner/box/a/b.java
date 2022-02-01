package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCopy;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.scanner.box.a.a.b
{
  public static final b OOa;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313794);
    OOa = new b();
    idA = "copy";
    AppMethodBeat.o(313794);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(313810);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str = (String)paramp.params.get("content");
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiCopy", "ScanJsApi-Call:copy content: %s", new Object[] { str });
      ClipboardHelper.setText(MMApplicationContext.getContext(), (CharSequence)str, (CharSequence)str);
      if (tQ(System.currentTimeMillis())) {
        aa.showTextToast(paramh.context, paramh.context.getString(l.i.app_copy_ok));
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(313810);
      return true;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.b
 * JD-Core Version:    0.7.0.1
 */