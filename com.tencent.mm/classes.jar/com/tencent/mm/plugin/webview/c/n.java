package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
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
  private static Set<String> DNF;
  private static String DNG;
  private static String DNH;
  private static String mue;
  
  static
  {
    AppMethodBeat.i(213930);
    DNF = new HashSet();
    DNG = "";
    mue = "";
    DNH = "";
    AppMethodBeat.o(213930);
  }
  
  public static void J(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213927);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(213927);
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
      bool2 = bt.o((Boolean)paramMap.get("fromMenu"));
      localObject = bt.nullAsNil((String)paramMap.get("keyParam"));
      str2 = bt.bI((String)paramMap.get("appId"), "");
      bool1 = bt.o((Boolean)paramMap.get("isSuccess"));
      k = bt.n((Integer)paramMap.get("permissionValue"));
      j = bt.n((Integer)paramMap.get("baseErrorCode"));
      i = bt.n((Integer)paramMap.get("jsapiErrorCode"));
      str1 = bt.bI((String)paramMap.get("containerEnv"), "");
    }
    String str3 = x.aNF(bt.nullAsNil(DNG));
    String str4 = x.aNF(bt.nullAsNil(mue));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (DNH == null)
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
      g.yhR.kvStat(10417, paramMap);
      if (!bt.isNullOrNil(str1)) {
        g.yhR.kvStat(18816, paramMap);
      }
      if (aGT(paramString))
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
      g.yhR.kvStat(17048, paramString);
      if (!bt.isNullOrNil(str1)) {
        g.yhR.kvStat(18817, paramString);
      }
      AppMethodBeat.o(213927);
      return;
      paramMap = DNH;
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
    AppMethodBeat.i(213926);
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
        DNG = str;
        if (i != 0)
        {
          str = "";
          label29:
          mue = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.eLw())
        {
          DNH = paramf;
          AppMethodBeat.o(213926);
          return;
          i = 0;
          break;
          str = paramf.eLv();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        ad.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(213926);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213925);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (bt.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(213925);
  }
  
  public static boolean aGT(String paramString)
  {
    AppMethodBeat.i(213928);
    eOU();
    boolean bool = DNF.contains(paramString);
    AppMethodBeat.o(213928);
    return bool;
  }
  
  public static void aS(String paramString1, String paramString2, String paramString3)
  {
    DNG = paramString1;
    mue = paramString2;
    DNH = paramString3;
  }
  
  private static void eOU()
  {
    AppMethodBeat.i(213929);
    if (DNF.size() > 0)
    {
      AppMethodBeat.o(213929);
      return;
    }
    DNF.add("openUrlByExtBrowser");
    DNF.add("startVoipCall");
    DNF.add("getCurrentSSID");
    DNF.add("chooseVideo");
    DNF.add("uploadVideo");
    DNF.add("getOpenDeviceId");
    DNF.add("chooseIdCard");
    DNF.add("recordVideo");
    DNF.add("chooseMedia");
    DNF.add("requestWxFacePictureVerify");
    DNF.add("requestWxFacePictureVerifyUnionVideo");
    DNF.add("openRealnameAuth");
    DNF.add("getInstallState");
    DNF.add("addDownloadTask");
    DNF.add("cancelDownloadTask");
    DNF.add("queryDownloadTask");
    DNF.add("installDownloadTask");
    DNF.add("launch3rdApp");
    DNF.add("pauseDownloadTask");
    DNF.add("resumeDownloadTask");
    DNF.add("launchApplication");
    DNF.add("addDownloadTaskStraight");
    DNF.add("profile");
    DNF.add("addContact");
    DNF.add("jumpToBizProfile");
    DNF.add("startTempSession");
    DNF.add("quicklyAddBrandContact");
    DNF.add("openBizChat");
    DNF.add("shareTimeline");
    DNF.add("sendAppMessage");
    DNF.add("sendServiceAppMessage");
    DNF.add("getSendC2CMessageRequest");
    DNF.add("shareQQ");
    DNF.add("selectSingleContact");
    DNF.add("sendAppMessageToSpecifiedContact");
    DNF.add("sendSingleAppMessage");
    DNF.add("openWeApp");
    DNF.add("launchMiniProgram");
    DNF.add("addCustomMenuItems");
    DNF.add("openUrlWithExtraWebview");
    DNF.add("enableFullScreen");
    DNF.add("openCustomWebview");
    DNF.add("openSpecificView");
    DNF.add("getBrandWCPayBindCardRequest");
    DNF.add("getTransferMoneyRequest");
    DNF.add("verifyWCPayPassword");
    DNF.add("getRecevieBizHongBaoRequest");
    DNF.add("getH5PrepayRequest");
    DNF.add("getH5TransactionRequest");
    DNF.add("getWebPayCheckoutCounterRequst");
    DNF.add("getWCPayRealnameVerify");
    DNF.add("unbindBankCard");
    DNF.add("idCardRealnameVerify");
    DNF.add("openLuckyMoneyDetailView");
    DNF.add("setWCPayPassword");
    DNF.add("openOfflinePayView");
    DNF.add("faceVerifyForPay");
    DNF.add("scanLicence");
    DNF.add("openBusinessView");
    DNF.add("getBrandWCPayRequest");
    DNF.add("requestJointPayment");
    DNF.add("editAddress");
    DNF.add("getLatestAddress");
    DNF.add("openLocation");
    DNF.add("chooseInvoiceTitle");
    DNF.add("requireSoterBiometricAuthentication");
    DNF.add("getOAID");
    AppMethodBeat.o(213929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.n
 * JD-Core Version:    0.7.0.1
 */