package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCopy;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class b
  extends com.tencent.mm.plugin.scanner.box.a.a.b
{
  public static final b CDB;
  private static final String edq = "copy";
  
  static
  {
    AppMethodBeat.i(240344);
    CDB = new b();
    edq = "copy";
    AppMethodBeat.o(240344);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(240343);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    String str = (String)paramn.params.get("content");
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiCopy", "ScanJsApi-Call:copy content: %s", new Object[] { str });
      ClipboardHelper.setText(MMApplicationContext.getContext(), (CharSequence)str, (CharSequence)str);
      if (Iu(System.currentTimeMillis())) {
        u.cE(paramf.context, paramf.context.getString(2131755773));
      }
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
      AppMethodBeat.o(240343);
      return true;
    }
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.b
 * JD-Core Version:    0.7.0.1
 */