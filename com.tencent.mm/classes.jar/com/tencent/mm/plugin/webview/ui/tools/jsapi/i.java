package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiRequestKidsPayRechargePayment;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "REQUEST_CODE", "", "TAG", "", "controlByte", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  private static final int REQUEST_CODE;
  public static final i Xis;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297462);
    Xis = new i();
    OOk = 442;
    idA = "requestKidsPayRechargePayment";
    REQUEST_CODE = com.tencent.luggage.sdk.h.a.ce(Xis);
    AppMethodBeat.o(297462);
  }
  
  private static final boolean a(p paramp, h paramh, int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(297459);
    s.u(paramp, "$msg");
    s.u(paramh, "$env");
    Log.i("MicroMsg.JsApiRequestKidsPayRechargePayment", "on Activity result: %s", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 != REQUEST_CODE)
    {
      AppMethodBeat.o(297459);
      return false;
    }
    Object localObject1;
    Object localObject2;
    if (paramIntent == null)
    {
      localObject1 = "fail";
      String str = paramp.function;
      s.s(str, "msg.function");
      localObject2 = localObject1;
      if (!n.U((String)localObject1, str, false)) {
        localObject2 = s.X(paramp.function, localObject1);
      }
      paramh.WDy.doCallback(paramp.WEH, (String)localObject2, null);
      paramp = paramh.context;
      if (!(paramp instanceof WebViewUI)) {
        break label240;
      }
      paramp = (WebViewUI)paramp;
      label133:
      if (paramp != null)
      {
        paramInt1 = i;
        if (paramIntent != null)
        {
          paramInt1 = i;
          if (paramIntent.getIntExtra("closeWindow", 0) == 1) {
            paramInt1 = 1;
          }
        }
        if (paramInt1 == 0) {
          break label245;
        }
      }
    }
    for (;;)
    {
      if (paramp != null) {
        paramp.finish();
      }
      AppMethodBeat.o(297459);
      return true;
      localObject2 = paramIntent.getStringExtra("ret");
      if (localObject2 == null)
      {
        localObject1 = "fail";
        break;
      }
      if (paramInt2 == -1)
      {
        paramInt1 = 1;
        label209:
        if (paramInt1 == 0) {
          break label234;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "fail";
        break;
        paramInt1 = 0;
        break label209;
        label234:
        localObject2 = null;
      }
      label240:
      paramp = null;
      break label133;
      label245:
      paramp = null;
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297479);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiRequestKidsPayRechargePayment", s.X("handled, params: ", paramp.params));
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", (String)paramp.params.get("appId"));
    localBundle.putString("timeStamp", (String)paramp.params.get("timeStamp"));
    localBundle.putString("package", (String)paramp.params.get("package"));
    localBundle.putString("nonceStr", (String)paramp.params.get("nonceStr"));
    localBundle.putString("paySign", (String)paramp.params.get("paySign"));
    localBundle.putString("signType", (String)paramp.params.get("signType"));
    localBundle.putString("webViewUrl", (String)paramp.params.get("url"));
    localBundle.putString("jsapiName", idA);
    com.tencent.luggage.l.e.bt(paramh.context).b(new i..ExternalSyntheticLambda0(paramp, paramh));
    c.b(paramh.context, "wallet", ".ui.WXPayJsApiKindaEntranceUI", new Intent().putExtras(localBundle), REQUEST_CODE);
    AppMethodBeat.o(297479);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */