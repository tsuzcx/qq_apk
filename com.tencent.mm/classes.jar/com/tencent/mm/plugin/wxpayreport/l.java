package com.tencent.mm.plugin.wxpayreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayWebJsapiMonitor;", "Lcom/tencent/mm/plugin/webview/jsapi/api/IJsapiMonitor;", "()V", "allFailList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "functionMapping", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "systemErrorList", "afterDealJsapiMsg", "", "function", "callbackId", "report", "", "", "beforeDealJsapiMsg", "onJsapiCallback", "ret", "retValue", "Companion", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements a
{
  public static final a XJs;
  private final HashSet<String> XJt;
  private final HashSet<String> XJu;
  private final HashMap<String, String> XJv;
  
  static
  {
    AppMethodBeat.i(261108);
    XJs = new a((byte)0);
    AppMethodBeat.o(261108);
  }
  
  public l()
  {
    AppMethodBeat.i(261099);
    this.XJt = ar.an(new String[] { "getBrandWCPayRequest", "getBrandWCPayBindCardRequest", "openWCPaySpecificView", "verifyWCPayPassword", "getH5TransactionRequest", "getH5PrepayRequest", "getWCPayRealnameVerify", "selectWalletCurrency", "changePayActivityView", "unbindBankCard", "uploadIdCardSuccess", "idCardRealnameVerify", "setWCPayPassword", "handleWCPayWalletBuffer", "faceVerifyForPay" });
    this.XJu = ar.an(new String[] { "chooseImage", "uploadImage", "chooseIdCard" });
    this.XJv = new HashMap();
    AppMethodBeat.o(261099);
  }
  
  public final void j(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(261129);
    s.u(paramString1, "function");
    s.u(paramString2, "callbackId");
    if (this.XJt.contains(paramString1))
    {
      if (paramMap == null) {}
      for (paramString2 = null; paramString2 == null; paramString2 = paramMap.get("jsapiHandleResult"))
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(261129);
        throw paramString1;
      }
      int i = ((Integer)paramString2).intValue();
      if (i != 1) {
        switch (i)
        {
        default: 
          paramString2 = "maybe not invoked";
        }
      }
    }
    for (;;)
    {
      paramMap = h.XIV;
      h.bx(s.X("H5Jsapi-", paramString1), "2", paramString2);
      AppMethodBeat.o(261129);
      return;
      paramString2 = "check not available";
      continue;
      paramString2 = "is floating";
      continue;
      paramString2 = "null pointer";
      continue;
      paramString2 = "limited jsapi";
      continue;
      paramString2 = "happen exception";
    }
  }
  
  public final void oi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261118);
    s.u(paramString1, "function");
    s.u(paramString2, "callbackId");
    Log.d("MicroMsg.WcPayReport|WcPayWebJsapiMonitor", "beforeDealJsapi: " + paramString1 + ", " + paramString2);
    ((Map)this.XJv).put(paramString2, paramString1);
    AppMethodBeat.o(261118);
  }
  
  public final void oj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261140);
    Log.d("MicroMsg.WcPayReport|WcPayWebJsapiMonitor", "onJsapiCallback: " + paramString1 + ", " + paramString2);
    if (paramString2 != null)
    {
      h localh;
      switch (paramString2.hashCode())
      {
      default: 
      case 1484725775: 
        do
        {
          if (n.i((CharSequence)paramString2, (CharSequence)"fail"))
          {
            paramString1 = (String)((Map)this.XJv).get(paramString1);
            if ((paramString1 != null) && (this.XJu.contains(paramString1)))
            {
              Log.w("MicroMsg.WcPayReport|WcPayWebJsapiMonitor", "report jsapi biz error: " + paramString1 + ", " + paramString2);
              localh = h.XIV;
              h.bx(s.X("H5Jsapi-", paramString1), "3", paramString2);
            }
          }
          AppMethodBeat.o(261140);
          return;
        } while (!paramString2.equals("system:function_not_exist"));
      }
      for (;;)
      {
        paramString1 = (String)((Map)this.XJv).get(paramString1);
        if (paramString1 == null) {
          break label305;
        }
        if ((this.XJt.contains(paramString1)) || (this.XJu.contains(paramString1)))
        {
          Log.w("MicroMsg.WcPayReport|WcPayWebJsapiMonitor", "report jsapi system error: " + paramString1 + ", " + paramString2);
          localh = h.XIV;
          h.bx(s.X("H5Jsapi-", paramString1), "1", paramString2);
        }
        AppMethodBeat.o(261140);
        return;
        if (!paramString2.equals("system:too_frequent")) {
          if ((goto 76) || (!paramString2.equals("system:access_denied"))) {
            break;
          }
        }
      }
    }
    label305:
    AppMethodBeat.o(261140);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayWebJsapiMonitor$Companion;", "", "()V", "TAG", "", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.l
 * JD-Core Version:    0.7.0.1
 */