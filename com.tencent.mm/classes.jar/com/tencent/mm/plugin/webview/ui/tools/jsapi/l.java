package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class l
{
  private static String iIg;
  private static String keN;
  private static String uWX;
  private static Set<String> vsh;
  
  static
  {
    AppMethodBeat.i(9850);
    vsh = new HashSet();
    keN = "";
    iIg = "";
    uWX = "";
    AppMethodBeat.o(9850);
  }
  
  public static void E(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(9849);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(9849);
      return;
    }
    Object localObject = null;
    String str1 = "";
    boolean bool2;
    boolean bool1;
    int k;
    int j;
    int i;
    if (paramMap != null)
    {
      bool2 = bo.e((Boolean)paramMap.get("fromMenu"));
      localObject = bo.nullAsNil((String)paramMap.get("keyParam"));
      str1 = bo.bf((String)paramMap.get("appId"), "");
      bool1 = bo.e((Boolean)paramMap.get("isSuccess"));
      k = bo.g((Integer)paramMap.get("permissionValue"));
      j = bo.g((Integer)paramMap.get("baseErrorCode"));
      i = bo.g((Integer)paramMap.get("jsapiErrorCode"));
    }
    for (paramMap = (Map<String, Object>)localObject;; paramMap = (Map<String, Object>)localObject)
    {
      String str2 = u.amT(bo.nullAsNil(keN));
      String str3 = u.amT(bo.nullAsNil(iIg));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(",");
      localStringBuilder.append(str3);
      localStringBuilder.append(",");
      if (uWX == null)
      {
        localObject = "";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",");
        if (paramString != null) {
          break label1338;
        }
        localObject = "";
        label250:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",");
        if (!bool2) {
          break label1344;
        }
        localObject = "1";
        label275:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",");
        localObject = paramMap;
        if (paramMap == null) {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",");
        localStringBuilder.append(str1);
        localStringBuilder.append(",");
        if (!bool1) {
          break label1352;
        }
        paramMap = "1";
        label342:
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
        ab.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
        h.qsU.kvStat(10417, paramMap);
        if (vsh.size() <= 0)
        {
          vsh.add("openUrlByExtBrowser");
          vsh.add("startVoipCall");
          vsh.add("getCurrentSSID");
          vsh.add("chooseVideo");
          vsh.add("uploadVideo");
          vsh.add("getOpenDeviceId");
          vsh.add("chooseIdCard");
          vsh.add("recordVideo");
          vsh.add("chooseMedia");
          vsh.add("requestWxFacePictureVerify");
          vsh.add("requestWxFacePictureVerifyUnionVideo");
          vsh.add("openRealnameAuth");
          vsh.add("getInstallState");
          vsh.add("addDownloadTask");
          vsh.add("cancelDownloadTask");
          vsh.add("queryDownloadTask");
          vsh.add("installDownloadTask");
          vsh.add("launch3rdApp");
          vsh.add("pauseDownloadTask");
          vsh.add("resumeDownloadTask");
          vsh.add("launchApplication");
          vsh.add("addDownloadTaskStraight");
          vsh.add("profile");
          vsh.add("addContact");
          vsh.add("jumpToBizProfile");
          vsh.add("startTempSession");
          vsh.add("quicklyAddBrandContact");
          vsh.add("openBizChat");
          vsh.add("shareTimeline");
          vsh.add("sendAppMessage");
          vsh.add("sendServiceAppMessage");
          vsh.add("getSendC2CMessageRequest");
          vsh.add("shareQQ");
          vsh.add("selectSingleContact");
          vsh.add("sendAppMessageToSpecifiedContact");
          vsh.add("sendSingleAppMessage");
          vsh.add("openWeApp");
          vsh.add("launchMiniProgram");
          vsh.add("addCustomMenuItems");
          vsh.add("openUrlWithExtraWebview");
          vsh.add("enableFullScreen");
          vsh.add("openCustomWebview");
          vsh.add("openSpecificView");
          vsh.add("getBrandWCPayBindCardRequest");
          vsh.add("getTransferMoneyRequest");
          vsh.add("verifyWCPayPassword");
          vsh.add("getRecevieBizHongBaoRequest");
          vsh.add("getH5PrepayRequest");
          vsh.add("getH5TransactionRequest");
          vsh.add("getWebPayCheckoutCounterRequst");
          vsh.add("getWCPayRealnameVerify");
          vsh.add("unbindBankCard");
          vsh.add("idCardRealnameVerify");
          vsh.add("openLuckyMoneyDetailView");
          vsh.add("setWCPayPassword");
          vsh.add("openOfflinePayView");
          vsh.add("faceVerifyForPay");
          vsh.add("scanLicence");
          vsh.add("openBusinessView");
          vsh.add("getBrandWCPayRequest");
          vsh.add("editAddress");
          vsh.add("getLatestAddress");
          vsh.add("openLocation");
          vsh.add("chooseInvoiceTitle");
          vsh.add("requireSoterBiometricAuthentication");
        }
        if (vsh.contains(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(str3);
          ((StringBuilder)localObject).append(",");
          paramMap = paramString;
          if (paramString == null) {
            paramMap = "";
          }
          ((StringBuilder)localObject).append(paramMap);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(",");
          if (!bool1) {
            break label1359;
          }
        }
      }
      label1338:
      label1344:
      label1352:
      label1359:
      for (paramString = "1";; paramString = "0")
      {
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        ab.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
        h.qsU.kvStat(17048, paramString);
        AppMethodBeat.o(9849);
        return;
        localObject = uWX;
        break;
        localObject = paramString;
        break label250;
        localObject = "0";
        break label275;
        paramMap = "0";
        break label342;
      }
      i = 0;
      j = 0;
      k = 0;
      bool1 = false;
      bool2 = false;
    }
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(9848);
    int i;
    if (parame == null) {
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
        label19:
        keN = str;
        if (i != 0)
        {
          str = "";
          label30:
          iIg = str;
          if (i == 0) {
            break label77;
          }
        }
        label77:
        for (parame = "";; parame = parame.dcX())
        {
          uWX = parame;
          AppMethodBeat.o(9848);
          return;
          i = 0;
          break;
          str = parame.dcW();
          break label19;
          str = parame.getCurrentUrl();
          break label30;
        }
        return;
      }
      catch (Exception parame)
      {
        ab.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + parame.getMessage());
        AppMethodBeat.o(9848);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9847);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (bo.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(9847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.l
 * JD-Core Version:    0.7.0.1
 */