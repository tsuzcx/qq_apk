package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetBounceBackground;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetBounceBackground", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends a
{
  public static final int OOk;
  public static final ah XnX;
  public static final String idA;
  
  static
  {
    AppMethodBeat.i(297520);
    XnX = new ah();
    OOk = 218;
    idA = "setBounceBackground";
    AppMethodBeat.o(297520);
  }
  
  private static boolean n(h paramh, p paramp)
  {
    AppMethodBeat.i(297516);
    String str2 = aa.brW((String)paramp.params.get("wxbackgroundColor"));
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = (String)paramp.params.get("backgroundColor");
    }
    try
    {
      int i = f.fo(str1, paramh.context.getResources().getColor(c.c.webview_logo_bg_color));
      if ((paramh.context instanceof MMActivity)) {
        ((WebViewUI)paramh.context).auv(i);
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":ok"), null);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiSetBounceBackground", (Throwable)localException, "setBounceBackground exception", new Object[0]);
        paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":fail"), null);
      }
    }
    AppMethodBeat.o(297516);
    return true;
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297534);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    boolean bool = n(paramh, paramp);
    AppMethodBeat.o(297534);
    return bool;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ah
 * JD-Core Version:    0.7.0.1
 */