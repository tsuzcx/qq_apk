package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class n
{
  private static Set<String> CkA;
  private static String CkB;
  private static String CkC;
  private static String lUn;
  
  static
  {
    AppMethodBeat.i(205328);
    CkA = new HashSet();
    CkB = "";
    lUn = "";
    CkC = "";
    AppMethodBeat.o(205328);
  }
  
  public static void I(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205325);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(205325);
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
      bool2 = bs.l((Boolean)paramMap.get("fromMenu"));
      localObject = bs.nullAsNil((String)paramMap.get("keyParam"));
      str2 = bs.bG((String)paramMap.get("appId"), "");
      bool1 = bs.l((Boolean)paramMap.get("isSuccess"));
      k = bs.m((Integer)paramMap.get("permissionValue"));
      j = bs.m((Integer)paramMap.get("baseErrorCode"));
      i = bs.m((Integer)paramMap.get("jsapiErrorCode"));
      str1 = bs.bG((String)paramMap.get("containerEnv"), "");
    }
    String str3 = x.aId(bs.nullAsNil(CkB));
    String str4 = x.aId(bs.nullAsNil(lUn));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (CkC == null)
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
      ac.d("MicroMsg.WebViewSecurityUtil", "report: %s", new Object[] { paramMap });
      h.wUl.kvStat(10417, paramMap);
      if (!bs.isNullOrNil(str1)) {
        h.wUl.kvStat(18816, paramMap);
      }
      if (aBw(paramString))
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
      ac.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", new Object[] { paramString });
      h.wUl.kvStat(17048, paramString);
      if (!bs.isNullOrNil(str1)) {
        h.wUl.kvStat(18817, paramString);
      }
      AppMethodBeat.o(205325);
      return;
      paramMap = CkC;
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
    AppMethodBeat.i(205324);
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
        CkB = str;
        if (i != 0)
        {
          str = "";
          label29:
          lUn = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.eCA())
        {
          CkC = paramf;
          AppMethodBeat.o(205324);
          return;
          i = 0;
          break;
          str = paramf.eCy();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        ac.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(205324);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205323);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (bs.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(205323);
  }
  
  public static boolean aBw(String paramString)
  {
    AppMethodBeat.i(205326);
    eAg();
    boolean bool = CkA.contains(paramString);
    AppMethodBeat.o(205326);
    return bool;
  }
  
  public static void aK(String paramString1, String paramString2, String paramString3)
  {
    CkB = paramString1;
    lUn = paramString2;
    CkC = paramString3;
  }
  
  private static void eAg()
  {
    AppMethodBeat.i(205327);
    if (CkA.size() > 0)
    {
      AppMethodBeat.o(205327);
      return;
    }
    CkA.add("openUrlByExtBrowser");
    CkA.add("startVoipCall");
    CkA.add("getCurrentSSID");
    CkA.add("chooseVideo");
    CkA.add("uploadVideo");
    CkA.add("getOpenDeviceId");
    CkA.add("chooseIdCard");
    CkA.add("recordVideo");
    CkA.add("chooseMedia");
    CkA.add("requestWxFacePictureVerify");
    CkA.add("requestWxFacePictureVerifyUnionVideo");
    CkA.add("openRealnameAuth");
    CkA.add("getInstallState");
    CkA.add("addDownloadTask");
    CkA.add("cancelDownloadTask");
    CkA.add("queryDownloadTask");
    CkA.add("installDownloadTask");
    CkA.add("launch3rdApp");
    CkA.add("pauseDownloadTask");
    CkA.add("resumeDownloadTask");
    CkA.add("launchApplication");
    CkA.add("addDownloadTaskStraight");
    CkA.add("profile");
    CkA.add("addContact");
    CkA.add("jumpToBizProfile");
    CkA.add("startTempSession");
    CkA.add("quicklyAddBrandContact");
    CkA.add("openBizChat");
    CkA.add("shareTimeline");
    CkA.add("sendAppMessage");
    CkA.add("sendServiceAppMessage");
    CkA.add("getSendC2CMessageRequest");
    CkA.add("shareQQ");
    CkA.add("selectSingleContact");
    CkA.add("sendAppMessageToSpecifiedContact");
    CkA.add("sendSingleAppMessage");
    CkA.add("openWeApp");
    CkA.add("launchMiniProgram");
    CkA.add("addCustomMenuItems");
    CkA.add("openUrlWithExtraWebview");
    CkA.add("enableFullScreen");
    CkA.add("openCustomWebview");
    CkA.add("openSpecificView");
    CkA.add("getBrandWCPayBindCardRequest");
    CkA.add("getTransferMoneyRequest");
    CkA.add("verifyWCPayPassword");
    CkA.add("getRecevieBizHongBaoRequest");
    CkA.add("getH5PrepayRequest");
    CkA.add("getH5TransactionRequest");
    CkA.add("getWebPayCheckoutCounterRequst");
    CkA.add("getWCPayRealnameVerify");
    CkA.add("unbindBankCard");
    CkA.add("idCardRealnameVerify");
    CkA.add("openLuckyMoneyDetailView");
    CkA.add("setWCPayPassword");
    CkA.add("openOfflinePayView");
    CkA.add("faceVerifyForPay");
    CkA.add("scanLicence");
    CkA.add("openBusinessView");
    CkA.add("getBrandWCPayRequest");
    CkA.add("requestJointPayment");
    CkA.add("editAddress");
    CkA.add("getLatestAddress");
    CkA.add("openLocation");
    CkA.add("chooseInvoiceTitle");
    CkA.add("requireSoterBiometricAuthentication");
    CkA.add("getOAID");
    AppMethodBeat.o(205327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.n
 * JD-Core Version:    0.7.0.1
 */