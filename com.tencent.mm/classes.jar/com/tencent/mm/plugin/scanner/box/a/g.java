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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiShake;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "shake", "", "plugin-scan_release"})
public final class g
  extends b
{
  public static final g IIh;
  private static final String fXz = "shake";
  
  static
  {
    AppMethodBeat.i(221666);
    IIh = new g();
    fXz = "shake";
    AppMethodBeat.o(221666);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(221661);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.d("MicroMsg.JsApiShake", "ScanJsApi-Call:shake");
    Object localObject2 = paramf.context.getSystemService("vibrator");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Vibrator)) {
      localObject1 = null;
    }
    localObject1 = (Vibrator)localObject1;
    if (localObject1 != null) {
      ((Vibrator)localObject1).vibrate(10L);
    }
    paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
    AppMethodBeat.o(221661);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.g
 * JD-Core Version:    0.7.0.1
 */