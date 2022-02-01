package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class u
{
  private static Set<String> WES;
  private static String WET;
  private static String WEU;
  private static String sML;
  
  static
  {
    AppMethodBeat.i(295336);
    WES = new HashSet();
    WET = "";
    sML = "";
    WEU = "";
    AppMethodBeat.o(295336);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(295294);
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
        WET = str;
        if (i != 0)
        {
          str = "";
          label29:
          sML = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.ipb())
        {
          WEU = paramf;
          AppMethodBeat.o(295294);
          return;
          i = 0;
          break;
          str = paramf.ipa();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        Log.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(295294);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295288);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (Util.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(295288);
  }
  
  public static boolean bjU(String paramString)
  {
    AppMethodBeat.i(295321);
    itS();
    boolean bool = WES.contains(paramString);
    AppMethodBeat.o(295321);
    return bool;
  }
  
  public static void br(String paramString1, String paramString2, String paramString3)
  {
    WET = paramString1;
    sML = paramString2;
    WEU = paramString3;
  }
  
  private static void itS()
  {
    AppMethodBeat.i(295330);
    if (WES.size() > 0)
    {
      AppMethodBeat.o(295330);
      return;
    }
    WES.add("openUrlByExtBrowser");
    WES.add("startVoipCall");
    WES.add("getCurrentSSID");
    WES.add("chooseImage");
    WES.add("uploadImage");
    WES.add("chooseVideo");
    WES.add("uploadVideo");
    WES.add("getOpenDeviceId");
    WES.add("chooseIdCard");
    WES.add("recordVideo");
    WES.add("chooseMedia");
    WES.add("requestWxFacePictureVerify");
    WES.add("requestWxFacePictureVerifyUnionVideo");
    WES.add("openRealnameAuth");
    WES.add("getInstallState");
    WES.add("addDownloadTask");
    WES.add("cancelDownloadTask");
    WES.add("queryDownloadTask");
    WES.add("installDownloadTask");
    WES.add("launch3rdApp");
    WES.add("pauseDownloadTask");
    WES.add("resumeDownloadTask");
    WES.add("launchApplication");
    WES.add("addDownloadTaskStraight");
    WES.add("profile");
    WES.add("addContact");
    WES.add("jumpToBizProfile");
    WES.add("startTempSession");
    WES.add("quicklyAddBrandContact");
    WES.add("openBizChat");
    WES.add("shareTimeline");
    WES.add("sendAppMessage");
    WES.add("sendServiceAppMessage");
    WES.add("getSendC2CMessageRequest");
    WES.add("shareQQ");
    WES.add("selectSingleContact");
    WES.add("sendAppMessageToSpecifiedContact");
    WES.add("sendSingleAppMessage");
    WES.add("openWeApp");
    WES.add("launchMiniProgram");
    WES.add("addCustomMenuItems");
    WES.add("openUrlWithExtraWebview");
    WES.add("enableFullScreen");
    WES.add("openCustomWebview");
    WES.add("openSpecificView");
    WES.add("getBrandWCPayBindCardRequest");
    WES.add("getTransferMoneyRequest");
    WES.add("verifyWCPayPassword");
    WES.add("getRecevieBizHongBaoRequest");
    WES.add("getH5PrepayRequest");
    WES.add("getH5TransactionRequest");
    WES.add("getWebPayCheckoutCounterRequst");
    WES.add("getWCPayRealnameVerify");
    WES.add("unbindBankCard");
    WES.add("idCardRealnameVerify");
    WES.add("openLuckyMoneyDetailView");
    WES.add("setWCPayPassword");
    WES.add("openOfflinePayView");
    WES.add("faceVerifyForPay");
    WES.add("scanLicence");
    WES.add("openBusinessView");
    WES.add("getBrandWCPayRequest");
    WES.add("requestJointPayment");
    WES.add("editAddress");
    WES.add("getLatestAddress");
    WES.add("openLocation");
    WES.add("chooseInvoiceTitle");
    WES.add("requireSoterBiometricAuthentication");
    WES.add("getOAID");
    AppMethodBeat.o(295330);
  }
  
  public static void w(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295315);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(295315);
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
      bool2 = Util.nullAsFalse((Boolean)paramMap.get("fromMenu"));
      localObject = Util.nullAsNil((String)paramMap.get("keyParam"));
      str2 = Util.nullAs((String)paramMap.get("appId"), "");
      bool1 = Util.nullAsFalse((Boolean)paramMap.get("isSuccess"));
      k = Util.nullAsNil((Integer)paramMap.get("permissionValue"));
      j = Util.nullAsNil((Integer)paramMap.get("baseErrorCode"));
      i = Util.nullAsNil((Integer)paramMap.get("jsapiErrorCode"));
      str1 = Util.nullAs((String)paramMap.get("containerEnv"), "");
    }
    String str3 = aa.aUC(Util.nullAsNil(WET));
    String str4 = aa.aUC(Util.nullAsNil(sML));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (WEU == null)
    {
      paramMap = "";
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      if (paramString != null) {
        break label681;
      }
      paramMap = "";
      label288:
      localStringBuilder.append(paramMap);
      localStringBuilder.append(",");
      if (!bool2) {
        break label686;
      }
      paramMap = "1";
      label313:
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
        break label693;
      }
      paramMap = "1";
      label382:
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
      Log.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
      h.OAn.kvStat(10417, paramMap);
      if (!Util.isNullOrNil(str1)) {
        h.OAn.kvStat(18816, paramMap);
      }
      if (bjU(paramString))
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
          break label700;
        }
      }
    }
    label681:
    label686:
    label693:
    label700:
    for (paramString = "1";; paramString = "0")
    {
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      Log.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
      h.OAn.kvStat(17048, paramString);
      if (!Util.isNullOrNil(str1)) {
        h.OAn.kvStat(18817, paramString);
      }
      AppMethodBeat.o(295315);
      return;
      paramMap = WEU;
      break;
      paramMap = paramString;
      break label288;
      paramMap = "0";
      break label313;
      paramMap = "0";
      break label382;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.u
 * JD-Core Version:    0.7.0.1
 */