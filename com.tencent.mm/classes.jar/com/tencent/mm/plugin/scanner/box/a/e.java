package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiShake;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "vibrator", "Landroid/os/Vibrator;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "shake", "", "plugin-scan_release"})
public final class e
  extends b
{
  public static final e CDF;
  private static final String edq = "shake";
  private static Vibrator paT;
  
  static
  {
    AppMethodBeat.i(240354);
    CDF = new e();
    edq = "shake";
    AppMethodBeat.o(240354);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(240353);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Log.d("MicroMsg.JsApiShake", "ScanJsApi-Call:shake");
    if (paT == null)
    {
      localObject = paramf.context.getSystemService("vibrator");
      if (localObject == null)
      {
        paramf = new t("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(240353);
        throw paramf;
      }
      paT = (Vibrator)localObject;
    }
    Object localObject = paT;
    if (localObject != null) {
      ((Vibrator)localObject).vibrate(10L);
    }
    paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
    AppMethodBeat.o(240353);
    return true;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.e
 * JD-Core Version:    0.7.0.1
 */