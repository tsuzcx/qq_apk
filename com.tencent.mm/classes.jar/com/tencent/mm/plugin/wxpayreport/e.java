package com.tencent.mm.plugin.wxpayreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayAppBrandJsapiMonitor;", "", "()V", "errMsgSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "monitoringApiList", "afterInvoke", "", "apiName", "invokeFlag", "", "beforeInvoke", "", "onAuthRequested", "onCallback", "data", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e XIO;
  private static final HashSet<String> XIP;
  private static final HashSet<String> XIQ;
  
  static
  {
    AppMethodBeat.i(261127);
    XIO = new e();
    XIP = ar.an(new String[] { "requestPayment", "requestPaymentToBank", "sendBizRedPacket", "requestVirtualPayment", "openOfflinePayView", "openWCPayCardList", "requestMallPayment", "openWCPayLQTDetail", "openWCPayLQTSave", "openWCPayLQTDepositPlan", "openWCPayLQTDepositPlanAdd", "setCurrentPaySpeech", "loadPaySpeechDialectConfig", "openWCPayOverseaPaymentReceive", "handleWCPayOverseaWalletBuffer", "requestH5Transaction", "requestJointPayment", "getWCPayOverseaPrepayRequest", "requestVerifyUserIdentity", "openSelectPayment", "requestEntrustAuthorization", "requestPayCardVerify", "requestBizSplitBillPayment", "requestQueryCashier", "sendRedPacket", "openRedPacket", "openWCCardHomePage", "openWCCertHomePage", "handleWCPayOverseaWalletBuffer", "getWCPayOverseaPrepayRequest", "requestMidasFriendPayment", "requestFacetoFacePayment", "requestPersonalPay" });
    XIQ = ar.an(new String[] { "fail:system permission denied", "fail:access denied", "fail:not supported", "fail:file doesn't exist", "fail:interrupted", "fail:auth denied", "fail:auth canceled", "fail:require permission desc", "fail:internal error invalid js component", "fail:internal error invalid android context", "fail:null system service", "fail:system error", "fail:internal error", "fail:invalid color", "fail:page don't exist", "fail:appID is empty", "fail:no focused input", "fail:native buffer exceed size limit", "fail:system permission denied", "fail:jsapi not supported", "fail:jsapi invalid request data", "fail:jsapi has no permission", "fail:jsapi user authorize denied", "fail:jsapi user authorize canceled", "fail:invalid jsapi state", "fail:invalid jsapi index", "fail:unknown payment error", "fail:limited use" });
    AppMethodBeat.o(261127);
  }
  
  public static boolean boF(String paramString)
  {
    AppMethodBeat.i(261084);
    s.u(paramString, "apiName");
    boolean bool = XIP.contains(paramString);
    AppMethodBeat.o(261084);
    return bool;
  }
  
  public static boolean boG(String paramString)
  {
    AppMethodBeat.i(261112);
    s.u(paramString, "apiName");
    if (XIP.contains(paramString))
    {
      Log.d("WcPayReport", s.X("report jsapi onAuthRequested ", paramString));
      h localh = h.XIV;
      h.bx(s.X("AppBrand-", paramString), "3", "");
      AppMethodBeat.o(261112);
      return true;
    }
    AppMethodBeat.o(261112);
    return false;
  }
  
  public static void ij(String paramString, int paramInt)
  {
    AppMethodBeat.i(261091);
    s.u(paramString, "apiName");
    Log.d("WcPayReport", s.X("afterInvoke: ", paramString));
    if ((paramInt != 1) && (XIP.contains(paramString)))
    {
      Log.d("WcPayReport", s.X("jsapi maybe not invoked: ", paramString));
      h localh = h.XIV;
      h.bx(s.X("AppBrand-", paramString), "2", "maybe not invoked");
    }
    AppMethodBeat.o(261091);
  }
  
  public static void oT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261103);
    s.u(paramString1, "apiName");
    if (!XIP.contains(paramString1))
    {
      AppMethodBeat.o(261103);
      return;
    }
    if (paramString2 != null)
    {
      paramString1 = new JSONObject(paramString2).optString("errMsg", "");
      s.s(paramString1, "errorMsg");
      paramString2 = n.a((CharSequence)paramString1, new char[] { ':' }, 2, 2);
      if (paramString2.size() != 2)
      {
        AppMethodBeat.o(261103);
        return;
      }
      paramString1 = (String)paramString2.get(0);
      paramString2 = (String)paramString2.get(1);
      Log.d("WcPayReport", "onCallback: " + paramString1 + ", " + paramString2);
      if ((XIP.contains(paramString1)) && (XIQ.contains(paramString2)))
      {
        Log.d("WcPayReport", "report jsapi callback error: " + paramString1 + ", " + paramString2);
        h localh = h.XIV;
        h.bx(s.X("AppBrand-", paramString1), "1", paramString2);
      }
    }
    AppMethodBeat.o(261103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.e
 * JD-Core Version:    0.7.0.1
 */