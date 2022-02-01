package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class s
{
  private static Set<String> POF;
  private static String POG;
  private static String POH;
  private static String pHO;
  
  static
  {
    AppMethodBeat.i(206333);
    POF = new HashSet();
    POG = "";
    pHO = "";
    POH = "";
    AppMethodBeat.o(206333);
  }
  
  public static void S(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(206330);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(206330);
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
    String str3 = ab.aXb(Util.nullAsNil(POG));
    String str4 = ab.aXb(Util.nullAsNil(pHO));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (POH == null)
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
      Log.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
      h.IzE.kvStat(10417, paramMap);
      if (!Util.isNullOrNil(str1)) {
        h.IzE.kvStat(18816, paramMap);
      }
      if (bkk(paramString))
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
      Log.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
      h.IzE.kvStat(17048, paramString);
      if (!Util.isNullOrNil(str1)) {
        h.IzE.kvStat(18817, paramString);
      }
      AppMethodBeat.o(206330);
      return;
      paramMap = POH;
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
    AppMethodBeat.i(206328);
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
        POG = str;
        if (i != 0)
        {
          str = "";
          label29:
          pHO = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.gPH())
        {
          POH = paramf;
          AppMethodBeat.o(206328);
          return;
          i = 0;
          break;
          str = paramf.gPG();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        Log.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(206328);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206327);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (Util.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(206327);
  }
  
  public static void aY(String paramString1, String paramString2, String paramString3)
  {
    POG = paramString1;
    pHO = paramString2;
    POH = paramString3;
  }
  
  public static boolean bkk(String paramString)
  {
    AppMethodBeat.i(206331);
    gUl();
    boolean bool = POF.contains(paramString);
    AppMethodBeat.o(206331);
    return bool;
  }
  
  private static void gUl()
  {
    AppMethodBeat.i(206332);
    if (POF.size() > 0)
    {
      AppMethodBeat.o(206332);
      return;
    }
    POF.add("openUrlByExtBrowser");
    POF.add("startVoipCall");
    POF.add("getCurrentSSID");
    POF.add("chooseImage");
    POF.add("uploadImage");
    POF.add("chooseVideo");
    POF.add("uploadVideo");
    POF.add("getOpenDeviceId");
    POF.add("chooseIdCard");
    POF.add("recordVideo");
    POF.add("chooseMedia");
    POF.add("requestWxFacePictureVerify");
    POF.add("requestWxFacePictureVerifyUnionVideo");
    POF.add("openRealnameAuth");
    POF.add("getInstallState");
    POF.add("addDownloadTask");
    POF.add("cancelDownloadTask");
    POF.add("queryDownloadTask");
    POF.add("installDownloadTask");
    POF.add("launch3rdApp");
    POF.add("pauseDownloadTask");
    POF.add("resumeDownloadTask");
    POF.add("launchApplication");
    POF.add("addDownloadTaskStraight");
    POF.add("profile");
    POF.add("addContact");
    POF.add("jumpToBizProfile");
    POF.add("startTempSession");
    POF.add("quicklyAddBrandContact");
    POF.add("openBizChat");
    POF.add("shareTimeline");
    POF.add("sendAppMessage");
    POF.add("sendServiceAppMessage");
    POF.add("getSendC2CMessageRequest");
    POF.add("shareQQ");
    POF.add("selectSingleContact");
    POF.add("sendAppMessageToSpecifiedContact");
    POF.add("sendSingleAppMessage");
    POF.add("openWeApp");
    POF.add("launchMiniProgram");
    POF.add("addCustomMenuItems");
    POF.add("openUrlWithExtraWebview");
    POF.add("enableFullScreen");
    POF.add("openCustomWebview");
    POF.add("openSpecificView");
    POF.add("getBrandWCPayBindCardRequest");
    POF.add("getTransferMoneyRequest");
    POF.add("verifyWCPayPassword");
    POF.add("getRecevieBizHongBaoRequest");
    POF.add("getH5PrepayRequest");
    POF.add("getH5TransactionRequest");
    POF.add("getWebPayCheckoutCounterRequst");
    POF.add("getWCPayRealnameVerify");
    POF.add("unbindBankCard");
    POF.add("idCardRealnameVerify");
    POF.add("openLuckyMoneyDetailView");
    POF.add("setWCPayPassword");
    POF.add("openOfflinePayView");
    POF.add("faceVerifyForPay");
    POF.add("scanLicence");
    POF.add("openBusinessView");
    POF.add("getBrandWCPayRequest");
    POF.add("requestJointPayment");
    POF.add("editAddress");
    POF.add("getLatestAddress");
    POF.add("openLocation");
    POF.add("chooseInvoiceTitle");
    POF.add("requireSoterBiometricAuthentication");
    POF.add("getOAID");
    AppMethodBeat.o(206332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.s
 * JD-Core Version:    0.7.0.1
 */