package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiShake;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "shake", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b
{
  public static final g OOf;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313787);
    OOf = new g();
    idA = "shake";
    AppMethodBeat.o(313787);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(313804);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.d("MicroMsg.JsApiShake", "ScanJsApi-Call:shake");
    Object localObject = paramh.context.getSystemService("vibrator");
    if ((localObject instanceof Vibrator)) {}
    for (localObject = (Vibrator)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(10L);
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(313804);
      return true;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.g
 * JD-Core Version:    0.7.0.1
 */