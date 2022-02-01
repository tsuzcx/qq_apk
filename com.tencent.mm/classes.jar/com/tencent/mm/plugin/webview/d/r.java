package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public final class r
{
  private static Set<String> ISn;
  private static String ISo;
  private static String ISp;
  private static String nKc;
  
  static
  {
    AppMethodBeat.i(224438);
    ISn = new HashSet();
    ISo = "";
    nKc = "";
    ISp = "";
    AppMethodBeat.o(224438);
  }
  
  public static void P(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224435);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
      AppMethodBeat.o(224435);
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
    String str3 = z.bfG(Util.nullAsNil(ISo));
    String str4 = z.bfG(Util.nullAsNil(nKc));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(",");
    localStringBuilder.append(str4);
    localStringBuilder.append(",");
    if (ISp == null)
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
      h.CyF.kvStat(10417, paramMap);
      if (!Util.isNullOrNil(str1)) {
        h.CyF.kvStat(18816, paramMap);
      }
      if (aYp(paramString))
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
      h.CyF.kvStat(17048, paramString);
      if (!Util.isNullOrNil(str1)) {
        h.CyF.kvStat(18817, paramString);
      }
      AppMethodBeat.o(224435);
      return;
      paramMap = ISp;
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
    AppMethodBeat.i(224434);
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
        ISo = str;
        if (i != 0)
        {
          str = "";
          label29:
          nKc = str;
          if (i == 0) {
            break label75;
          }
        }
        label75:
        for (paramf = "";; paramf = paramf.fWX())
        {
          ISp = paramf;
          AppMethodBeat.o(224434);
          return;
          i = 0;
          break;
          str = paramf.fWW();
          break label18;
          str = paramf.getCurrentUrl();
          break label29;
        }
        return;
      }
      catch (Exception paramf)
      {
        Log.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + paramf.getMessage());
        AppMethodBeat.o(224434);
      }
    }
  }
  
  public static void a(Map<String, Object> paramMap, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(224433);
    if (paramMap != null)
    {
      paramMap.put("fromMenu", Boolean.valueOf(paramBoolean));
      paramMap.put("keyParam", paramString1);
      if (Util.isNullOrNil((String)paramMap.get("appId"))) {
        paramMap.put("appId", paramString2);
      }
    }
    AppMethodBeat.o(224433);
  }
  
  public static boolean aYp(String paramString)
  {
    AppMethodBeat.i(224436);
    gbr();
    boolean bool = ISn.contains(paramString);
    AppMethodBeat.o(224436);
    return bool;
  }
  
  public static void bd(String paramString1, String paramString2, String paramString3)
  {
    ISo = paramString1;
    nKc = paramString2;
    ISp = paramString3;
  }
  
  private static void gbr()
  {
    AppMethodBeat.i(224437);
    if (ISn.size() > 0)
    {
      AppMethodBeat.o(224437);
      return;
    }
    ISn.add("openUrlByExtBrowser");
    ISn.add("startVoipCall");
    ISn.add("getCurrentSSID");
    ISn.add("chooseVideo");
    ISn.add("uploadVideo");
    ISn.add("getOpenDeviceId");
    ISn.add("chooseIdCard");
    ISn.add("recordVideo");
    ISn.add("chooseMedia");
    ISn.add("requestWxFacePictureVerify");
    ISn.add("requestWxFacePictureVerifyUnionVideo");
    ISn.add("openRealnameAuth");
    ISn.add("getInstallState");
    ISn.add("addDownloadTask");
    ISn.add("cancelDownloadTask");
    ISn.add("queryDownloadTask");
    ISn.add("installDownloadTask");
    ISn.add("launch3rdApp");
    ISn.add("pauseDownloadTask");
    ISn.add("resumeDownloadTask");
    ISn.add("launchApplication");
    ISn.add("addDownloadTaskStraight");
    ISn.add("profile");
    ISn.add("addContact");
    ISn.add("jumpToBizProfile");
    ISn.add("startTempSession");
    ISn.add("quicklyAddBrandContact");
    ISn.add("openBizChat");
    ISn.add("shareTimeline");
    ISn.add("sendAppMessage");
    ISn.add("sendServiceAppMessage");
    ISn.add("getSendC2CMessageRequest");
    ISn.add("shareQQ");
    ISn.add("selectSingleContact");
    ISn.add("sendAppMessageToSpecifiedContact");
    ISn.add("sendSingleAppMessage");
    ISn.add("openWeApp");
    ISn.add("launchMiniProgram");
    ISn.add("addCustomMenuItems");
    ISn.add("openUrlWithExtraWebview");
    ISn.add("enableFullScreen");
    ISn.add("openCustomWebview");
    ISn.add("openSpecificView");
    ISn.add("getBrandWCPayBindCardRequest");
    ISn.add("getTransferMoneyRequest");
    ISn.add("verifyWCPayPassword");
    ISn.add("getRecevieBizHongBaoRequest");
    ISn.add("getH5PrepayRequest");
    ISn.add("getH5TransactionRequest");
    ISn.add("getWebPayCheckoutCounterRequst");
    ISn.add("getWCPayRealnameVerify");
    ISn.add("unbindBankCard");
    ISn.add("idCardRealnameVerify");
    ISn.add("openLuckyMoneyDetailView");
    ISn.add("setWCPayPassword");
    ISn.add("openOfflinePayView");
    ISn.add("faceVerifyForPay");
    ISn.add("scanLicence");
    ISn.add("openBusinessView");
    ISn.add("getBrandWCPayRequest");
    ISn.add("requestJointPayment");
    ISn.add("editAddress");
    ISn.add("getLatestAddress");
    ISn.add("openLocation");
    ISn.add("chooseInvoiceTitle");
    ISn.add("requireSoterBiometricAuthentication");
    ISn.add("getOAID");
    AppMethodBeat.o(224437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.r
 * JD-Core Version:    0.7.0.1
 */