package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class n
{
  private static Set<String> ASn;
  private static String ASo;
  private static String ASp;
  private static String lst;
  
  static
  {
    AppMethodBeat.i(189699);
    ASn = new HashSet();
    ASo = "";
    lst = "";
    ASp = "";
    AppMethodBeat.o(189699);
  }
  
  public static void H(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189696);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(189696);
      return;
    }
    boolean bool2 = false;
    Object localObject = null;
    String str2 = "";
    boolean bool1 = false;
    int k = 0;
    int j = 0;
    int i = 0;
    String str1 = "";
    if (paramMap != null)
    {
      bool2 = bt.l((Boolean)paramMap.get("fromMenu"));
      localObject = bt.nullAsNil((String)paramMap.get("keyParam"));
      str2 = bt.by((String)paramMap.get("appId"), "");
      bool1 = bt.l((Boolean)paramMap.get("isSuccess"));
      k = bt.l((Integer)paramMap.get("permissionValue"));
      j = bt.l((Integer)paramMap.get("baseErrorCode"));
      i = bt.l((Integer)paramMap.get("jsapiErrorCode"));
      str1 = bt.by((String)paramMap.get("containerEnv"), "");
    }
    String str3 = x.aCL(bt.nullAsNil(ASo));
    String str4 = x.aCL(bt.nullAsNil(lst));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (ASp == null)
    {
      paramMap = "";
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      if (paramString != null) {
        break label652;
      }
      paramMap = "";
      label277:
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      if (!bool2) {
        break label657;
      }
      paramMap = "1";
      label300:
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      paramMap = (Map<String, Object>)localObject;
      if (localObject == null) {
        paramMap = "";
      }
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      localStringBuilder.append(str2);
      localStringBuilder.append(",");
      if (!bool1) {
        break label663;
      }
      paramMap = "1";
      label365:
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      localStringBuilder.append(k);
      if (!bool1)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(0);
        localStringBuilder.append(",");
        localStringBuilder.append(j);
        localStringBuilder.append(",");
        localStringBuilder.append(i);
      }
      paramMap = localStringBuilder.toString();
      ad.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
      h.vKh.kvStat(10417, paramMap);
      if (!bt.isNullOrNil(str1)) {
        h.vKh.kvStat(18816, paramMap);
      }
      if (awe(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(str4);
        ((StringBuilder)localObject).append(",");
        paramMap = paramString;
        if (paramString == null) {
          paramMap = "";
        }
        ((StringBuilder)localObject).append(paramMap);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(",");
        if (!bool1) {
          break label669;
        }
      }
    }
    label652:
    label657:
    label663:
    label669:
    for (paramString = "1";; paramString = "0")
    {
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      ad.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
      h.vKh.kvStat(17048, paramString);
      if (!bt.isNullOrNil(str1)) {
        h.vKh.kvStat(18817, paramString);
      }
      AppMethodBeat.o(189696);
      return;
      paramMap = ASp;
      break;
      paramMap = paramString;
      break label277;
      paramMap = "0";
      break label300;
      paramMap = "0";
      break label365;
    }
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(189695);
    int i;
    if (paramf == null) {
      i = 1;
    }
    for (;;)
    {
      String str;
      if (i != 0) {
        str = "";
      }
      try
      {
        label18:
        ASo = str;
        if (i != 0)
        {
          str = "";
          label29:
          lst = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.eng())
        {
          ASp = paramf;
          AppMethodBeat.o(189695);
          return;
          i = 0;
          break;
          str = paramf.ene();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        ad.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(189695);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189694);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (bt.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(189694);
  }
  
  public static void aH(String paramString1, String paramString2, String paramString3)
  {
    ASo = paramString1;
    lst = paramString2;
    ASp = paramString3;
  }
  
  public static boolean awe(String paramString)
  {
    AppMethodBeat.i(189697);
    ekK();
    boolean bool = ASn.contains(paramString);
    AppMethodBeat.o(189697);
    return bool;
  }
  
  private static void ekK()
  {
    AppMethodBeat.i(189698);
    if (ASn.size() > 0)
    {
      AppMethodBeat.o(189698);
      return;
    }
    ASn.add("openUrlByExtBrowser");
    ASn.add("startVoipCall");
    ASn.add("getCurrentSSID");
    ASn.add("chooseVideo");
    ASn.add("uploadVideo");
    ASn.add("getOpenDeviceId");
    ASn.add("chooseIdCard");
    ASn.add("recordVideo");
    ASn.add("chooseMedia");
    ASn.add("requestWxFacePictureVerify");
    ASn.add("requestWxFacePictureVerifyUnionVideo");
    ASn.add("openRealnameAuth");
    ASn.add("getInstallState");
    ASn.add("addDownloadTask");
    ASn.add("cancelDownloadTask");
    ASn.add("queryDownloadTask");
    ASn.add("installDownloadTask");
    ASn.add("launch3rdApp");
    ASn.add("pauseDownloadTask");
    ASn.add("resumeDownloadTask");
    ASn.add("launchApplication");
    ASn.add("addDownloadTaskStraight");
    ASn.add("profile");
    ASn.add("addContact");
    ASn.add("jumpToBizProfile");
    ASn.add("startTempSession");
    ASn.add("quicklyAddBrandContact");
    ASn.add("openBizChat");
    ASn.add("shareTimeline");
    ASn.add("sendAppMessage");
    ASn.add("sendServiceAppMessage");
    ASn.add("getSendC2CMessageRequest");
    ASn.add("shareQQ");
    ASn.add("selectSingleContact");
    ASn.add("sendAppMessageToSpecifiedContact");
    ASn.add("sendSingleAppMessage");
    ASn.add("openWeApp");
    ASn.add("launchMiniProgram");
    ASn.add("addCustomMenuItems");
    ASn.add("openUrlWithExtraWebview");
    ASn.add("enableFullScreen");
    ASn.add("openCustomWebview");
    ASn.add("openSpecificView");
    ASn.add("getBrandWCPayBindCardRequest");
    ASn.add("getTransferMoneyRequest");
    ASn.add("verifyWCPayPassword");
    ASn.add("getRecevieBizHongBaoRequest");
    ASn.add("getH5PrepayRequest");
    ASn.add("getH5TransactionRequest");
    ASn.add("getWebPayCheckoutCounterRequst");
    ASn.add("getWCPayRealnameVerify");
    ASn.add("unbindBankCard");
    ASn.add("idCardRealnameVerify");
    ASn.add("openLuckyMoneyDetailView");
    ASn.add("setWCPayPassword");
    ASn.add("openOfflinePayView");
    ASn.add("faceVerifyForPay");
    ASn.add("scanLicence");
    ASn.add("openBusinessView");
    ASn.add("getBrandWCPayRequest");
    ASn.add("requestJointPayment");
    ASn.add("editAddress");
    ASn.add("getLatestAddress");
    ASn.add("openLocation");
    ASn.add("chooseInvoiceTitle");
    ASn.add("requireSoterBiometricAuthentication");
    ASn.add("getOAID");
    AppMethodBeat.o(189698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.n
 * JD-Core Version:    0.7.0.1
 */