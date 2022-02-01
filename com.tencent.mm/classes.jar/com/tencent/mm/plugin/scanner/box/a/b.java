package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCopy;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class b
  extends com.tencent.mm.plugin.scanner.box.a.a.b
{
  public static final b IIb;
  private static final String fXz = "copy";
  
  static
  {
    AppMethodBeat.i(220175);
    IIb = new b();
    fXz = "copy";
    AppMethodBeat.o(220175);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(220173);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    String str = (String)paramn.params.get("content");
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiCopy", "ScanJsApi-Call:copy content: %s", new Object[] { str });
      ClipboardHelper.setText(MMApplicationContext.getContext(), (CharSequence)str, (CharSequence)str);
      if (PO(System.currentTimeMillis())) {
        w.cP(paramf.context, paramf.context.getString(l.i.app_copy_ok));
      }
      paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
      AppMethodBeat.o(220173);
      return true;
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.b
 * JD-Core Version:    0.7.0.1
 */