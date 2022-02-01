package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class n
{
  private static Set<String> EfE;
  private static String EfF;
  private static String EfG;
  private static String mzb;
  
  static
  {
    AppMethodBeat.i(213759);
    EfE = new HashSet();
    EfF = "";
    mzb = "";
    EfG = "";
    AppMethodBeat.o(213759);
  }
  
  public static void K(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213756);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(213756);
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
      bool2 = bu.o((Boolean)paramMap.get("fromMenu"));
      localObject = bu.nullAsNil((String)paramMap.get("keyParam"));
      str2 = bu.bI((String)paramMap.get("appId"), "");
      bool1 = bu.o((Boolean)paramMap.get("isSuccess"));
      k = bu.o((Integer)paramMap.get("permissionValue"));
      j = bu.o((Integer)paramMap.get("baseErrorCode"));
      i = bu.o((Integer)paramMap.get("jsapiErrorCode"));
      str1 = bu.bI((String)paramMap.get("containerEnv"), "");
    }
    String str3 = x.aPc(bu.nullAsNil(EfF));
    String str4 = x.aPc(bu.nullAsNil(mzb));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (EfG == null)
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
      ae.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
      g.yxI.kvStat(10417, paramMap);
      if (!bu.isNullOrNil(str1)) {
        g.yxI.kvStat(18816, paramMap);
      }
      if (aIn(paramString))
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
      ae.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
      g.yxI.kvStat(17048, paramString);
      if (!bu.isNullOrNil(str1)) {
        g.yxI.kvStat(18817, paramString);
      }
      AppMethodBeat.o(213756);
      return;
      paramMap = EfG;
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
    AppMethodBeat.i(213755);
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
        EfF = str;
        if (i != 0)
        {
          str = "";
          label29:
          mzb = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.ePf())
        {
          EfG = paramf;
          AppMethodBeat.o(213755);
          return;
          i = 0;
          break;
          str = paramf.ePe();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        ae.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(213755);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213754);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (bu.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(213754);
  }
  
  public static boolean aIn(String paramString)
  {
    AppMethodBeat.i(213757);
    eSF();
    boolean bool = EfE.contains(paramString);
    AppMethodBeat.o(213757);
    return bool;
  }
  
  public static void aT(String paramString1, String paramString2, String paramString3)
  {
    EfF = paramString1;
    mzb = paramString2;
    EfG = paramString3;
  }
  
  private static void eSF()
  {
    AppMethodBeat.i(213758);
    if (EfE.size() > 0)
    {
      AppMethodBeat.o(213758);
      return;
    }
    EfE.add("openUrlByExtBrowser");
    EfE.add("startVoipCall");
    EfE.add("getCurrentSSID");
    EfE.add("chooseVideo");
    EfE.add("uploadVideo");
    EfE.add("getOpenDeviceId");
    EfE.add("chooseIdCard");
    EfE.add("recordVideo");
    EfE.add("chooseMedia");
    EfE.add("requestWxFacePictureVerify");
    EfE.add("requestWxFacePictureVerifyUnionVideo");
    EfE.add("openRealnameAuth");
    EfE.add("getInstallState");
    EfE.add("addDownloadTask");
    EfE.add("cancelDownloadTask");
    EfE.add("queryDownloadTask");
    EfE.add("installDownloadTask");
    EfE.add("launch3rdApp");
    EfE.add("pauseDownloadTask");
    EfE.add("resumeDownloadTask");
    EfE.add("launchApplication");
    EfE.add("addDownloadTaskStraight");
    EfE.add("profile");
    EfE.add("addContact");
    EfE.add("jumpToBizProfile");
    EfE.add("startTempSession");
    EfE.add("quicklyAddBrandContact");
    EfE.add("openBizChat");
    EfE.add("shareTimeline");
    EfE.add("sendAppMessage");
    EfE.add("sendServiceAppMessage");
    EfE.add("getSendC2CMessageRequest");
    EfE.add("shareQQ");
    EfE.add("selectSingleContact");
    EfE.add("sendAppMessageToSpecifiedContact");
    EfE.add("sendSingleAppMessage");
    EfE.add("openWeApp");
    EfE.add("launchMiniProgram");
    EfE.add("addCustomMenuItems");
    EfE.add("openUrlWithExtraWebview");
    EfE.add("enableFullScreen");
    EfE.add("openCustomWebview");
    EfE.add("openSpecificView");
    EfE.add("getBrandWCPayBindCardRequest");
    EfE.add("getTransferMoneyRequest");
    EfE.add("verifyWCPayPassword");
    EfE.add("getRecevieBizHongBaoRequest");
    EfE.add("getH5PrepayRequest");
    EfE.add("getH5TransactionRequest");
    EfE.add("getWebPayCheckoutCounterRequst");
    EfE.add("getWCPayRealnameVerify");
    EfE.add("unbindBankCard");
    EfE.add("idCardRealnameVerify");
    EfE.add("openLuckyMoneyDetailView");
    EfE.add("setWCPayPassword");
    EfE.add("openOfflinePayView");
    EfE.add("faceVerifyForPay");
    EfE.add("scanLicence");
    EfE.add("openBusinessView");
    EfE.add("getBrandWCPayRequest");
    EfE.add("requestJointPayment");
    EfE.add("editAddress");
    EfE.add("getLatestAddress");
    EfE.add("openLocation");
    EfE.add("chooseInvoiceTitle");
    EfE.add("requireSoterBiometricAuthentication");
    EfE.add("getOAID");
    AppMethodBeat.o(213758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.n
 * JD-Core Version:    0.7.0.1
 */