package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.WxQBarResult;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.o;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "SCAN_REPORT_SCENE_APPBRAND_JSAPI", "SCAN_REPORT_SCENE_DEFAULT", "SCAN_REPORT_SCENE_SNS_AD", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "scanCost", "reportMultiCodeCancel", "reportMultiCodeClick", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class ac
{
  private static String dyV;
  private static HashMap<Integer, String> ynU;
  private static HashMap<Integer, String> ynV;
  private static HashMap<Integer, Integer> ynW;
  private static HashMap<String, b> ynX;
  private static boolean ynY;
  private static ac.a ynZ;
  private static long yoa;
  public static final ac yob;
  
  static
  {
    AppMethodBeat.i(52238);
    yob = new ac();
    dyV = "";
    ynU = new HashMap();
    ynV = new HashMap();
    ynW = new HashMap();
    ynX = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void O(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    g localg;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localg = g.yhR;
        paramInt = 102;
      }
    }
    for (;;)
    {
      localg.dD(1259, paramInt);
      do
      {
        AppMethodBeat.o(170039);
        return;
      } while (paramInt != 2);
      localg = g.yhR;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
  }
  
  public static final void OA(int paramInt)
  {
    AppMethodBeat.i(170036);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (OF(paramInt))
    {
      localInteger = (Integer)ynW.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)ynW).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        g.yhR.dD(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)ynW.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)ynW).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      g.yhR.dD(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void OB(int paramInt)
  {
    AppMethodBeat.i(170037);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (OF(paramInt))
    {
      localInteger = (Integer)ynW.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)ynW).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      g.yhR.dD(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)ynW.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        break label143;
      }
    }
    label143:
    while (localInteger.intValue() != 1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)ynW).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    g.yhR.dD(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void OC(int paramInt)
  {
    AppMethodBeat.i(170040);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (OF(paramInt))
    {
      g.yhR.dD(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      g.yhR.dD(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void OD(int paramInt)
  {
    AppMethodBeat.i(170041);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (OF(paramInt))
    {
      g.yhR.dD(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      g.yhR.dD(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void OE(int paramInt)
  {
    AppMethodBeat.i(170042);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (OF(paramInt))
    {
      g.yhR.dD(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      g.yhR.dD(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean OF(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static final void Ot(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)ynV).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), ynV.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String Ou(int paramInt)
  {
    AppMethodBeat.i(186322);
    String str = (String)ynV.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(186322);
    return str;
  }
  
  public static final void Ov(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!OF(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)ynU).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), ynU.get(Integer.valueOf(paramInt)) });
    String str1 = (String)ynV.get(Integer.valueOf(paramInt));
    String str2 = (String)ynU.get(Integer.valueOf(paramInt));
    if (str1 != null) {
      if (((CharSequence)str1).length() > 0)
      {
        paramInt = 1;
        if (paramInt != 1) {
          break label343;
        }
        if (str2 == null) {
          break label256;
        }
        if (((CharSequence)str2).length() <= 0) {
          break label251;
        }
      }
    }
    b localb;
    label251:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 1) {
        break label343;
      }
      String str3 = str1 + "," + str2;
      localb = (b)ynX.get(str3);
      if (localb != null) {
        break label263;
      }
      localb = new b();
      localb.awI(str1);
      localb.awJ(str2);
      ((Map)ynX).put(str3, localb);
      AppMethodBeat.o(52224);
      return;
      paramInt = 0;
      break;
      AppMethodBeat.o(52224);
      return;
    }
    label256:
    AppMethodBeat.o(52224);
    return;
    label263:
    localb.yoh = "";
    localb.yoi = "";
    localb.yoj = 0L;
    localb.yok = 0L;
    localb.yol = 0L;
    localb.fFu = 0;
    localb.yom = 0L;
    localb.yon = 0L;
    localb.tlk = 0L;
    localb.dnh = 0;
    localb.yoo = false;
    localb.awI(str1);
    localb.awJ(str2);
    label343:
    AppMethodBeat.o(52224);
  }
  
  public static final String Ow(int paramInt)
  {
    AppMethodBeat.i(186323);
    String str = (String)ynU.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(186323);
    return str;
  }
  
  private static int Ox(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 4: 
    case 8: 
      return 1;
    case 12: 
      return 2;
    }
    return 3;
  }
  
  private static int Oy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static final void Oz(int paramInt)
  {
    AppMethodBeat.i(161056);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      g.yhR.dD(1259, 20);
      g.yhR.dD(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      g.yhR.dD(1259, 20);
      g.yhR.dD(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  private static int a(BaseScanRequest paramBaseScanRequest)
  {
    if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
      return 1;
    }
    if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).requestType == 2)) {
      return 2;
    }
    return 0;
  }
  
  public static final void a(int paramInt, BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(186325);
    b localb = dLj();
    if (localb == null)
    {
      AppMethodBeat.o(186325);
      return;
    }
    localb.fFu = paramInt;
    if (localb.yok > localb.yoj) {
      localb.yol = (localb.yok - localb.yoj);
    }
    if (localb.yol > 0L)
    {
      paramInt = a(paramBaseScanRequest);
      paramBaseScanRequest = b(paramBaseScanRequest);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second });
      g.yhR.f(18560, new Object[] { localb.yoh, localb.yoi, Long.valueOf(localb.yoj), Long.valueOf(localb.yok), Long.valueOf(localb.yol), Integer.valueOf(localb.fFu), Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second, dyV });
    }
    ((Map)ynU).put(Integer.valueOf(12), "");
    AppMethodBeat.o(186325);
  }
  
  public static final void a(int paramInt1, BaseScanRequest paramBaseScanRequest, int paramInt2)
  {
    AppMethodBeat.i(186324);
    String str1 = (String)ynV.get(Integer.valueOf(12));
    String str2 = (String)ynU.get(Integer.valueOf(12));
    CharSequence localCharSequence = (CharSequence)str1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)str2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label106;
        }
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label111;
      }
      AppMethodBeat.o(186324);
      return;
      i = 0;
      break;
    }
    label111:
    paramInt1 = Oy(paramInt1);
    i = a(paramBaseScanRequest);
    paramBaseScanRequest = b(paramBaseScanRequest);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", new Object[] { Integer.valueOf(18558), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.yhR.f(18558, new Object[] { str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), paramBaseScanRequest.first, paramBaseScanRequest.second, dyV });
    AppMethodBeat.o(186324);
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(186328);
    p.h(paramList, "codeResultList");
    ynZ = new ac.a(paramList, paramLong);
    try
    {
      paramList = ynZ;
      String str;
      if (paramList != null)
      {
        str = Ou(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.yoc = paramLong;
        }
      }
      else
      {
        paramList = ynZ;
        if (paramList == null) {
          break label106;
        }
        str = Ow(paramInt);
        if (str == null) {
          break label99;
        }
      }
      label99:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.yod = paramLong;
        AppMethodBeat.o(186328);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label106:
      AppMethodBeat.o(186328);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(186328);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg;
    if (OF(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        g.yhR.dD(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localg = g.yhR;
        paramInt1 = 60;
      }
    }
    for (;;)
    {
      localg.dD(1259, paramInt1);
      label102:
      label125:
      do
      {
        AppMethodBeat.o(170038);
        return;
        if (paramInt3 > 1) {
          g.yhR.dD(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localg = g.yhR;
      if (paramBoolean) {
        paramInt1 = 58;
      } else {
        paramInt1 = 59;
      }
    }
  }
  
  public static final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(52233);
    a(paramInt, paramBoolean, paramLong, false);
    AppMethodBeat.o(52233);
  }
  
  public static final void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(52234);
    b localb = dLj();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.yon = paramLong;
    localb.yoo = paramBoolean1;
    localb.dnh = Oy(paramInt);
    if ((localb.yom > 0L) && (localb.yon > 0L)) {
      localb.tlk = (localb.yon - localb.yom);
    }
    int i;
    if ((localb.tlk > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.yoh, localb.yoi, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.tlk), Integer.valueOf(i) });
      g.yhR.f(18724, new Object[] { localb.yoh, localb.yoi, Integer.valueOf(localb.dnh), Integer.valueOf(i), Long.valueOf(localb.tlk) });
      AppMethodBeat.o(52234);
      return;
      label251:
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(161974);
    if (!ynY)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      g.yhR.dD(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        g.yhR.dD(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          g.yhR.dD(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          g.yhR.dD(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          g.yhR.dD(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          g.yhR.dD(1259, 26);
        } else if (paramLong >= 5000L) {
          g.yhR.dD(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          g.yhR.dD(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          g.yhR.dD(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          g.yhR.dD(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          g.yhR.dD(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          g.yhR.dD(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = dLj();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.yom = paramLong;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.yoh, localb.yoi, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  private static o<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(186333);
    label148:
    for (;;)
    {
      try
      {
        if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
        {
          String str = paramBaseScanRequest.getExtra("key_sns_ad_ux_info", "");
          p.g(str, "bizInfo");
          paramBaseScanRequest = (String)j.E(n.a((CharSequence)str, new String[] { "|" }), 1);
          if (paramBaseScanRequest != null) {
            break label148;
          }
          paramBaseScanRequest = "";
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new o(paramBaseScanRequest, str);
          AppMethodBeat.o(186333);
          return paramBaseScanRequest;
        }
      }
      catch (Exception paramBaseScanRequest)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
        paramBaseScanRequest = new o("", "");
        AppMethodBeat.o(186333);
        return paramBaseScanRequest;
      }
    }
  }
  
  public static final void b(int paramInt1, BaseScanRequest paramBaseScanRequest, int paramInt2)
  {
    AppMethodBeat.i(186330);
    paramInt1 = Ox(paramInt1);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt2 == 1)
    {
      yoa = l3;
      l1 = l2;
    }
    for (;;)
    {
      int i = a(paramBaseScanRequest);
      o localo = b(paramBaseScanRequest);
      g.yhR.f(20275, new Object[] { localo.first, localo.second, dyV, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l3), Long.valueOf(l1) });
      if ((paramInt2 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        g.yhR.dD(1259, 108);
      }
      AppMethodBeat.o(186330);
      return;
      l1 = l2;
      if (paramInt2 == 2)
      {
        l1 = l2;
        if (yoa > 0L)
        {
          l1 = l3 - yoa;
          yoa = 0L;
        }
      }
    }
  }
  
  public static final void dLh()
  {
    AppMethodBeat.i(52220);
    dyV = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  public static final String dLi()
  {
    return dyV;
  }
  
  private static b dLj()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)ynV.get(Integer.valueOf(12));
    String str = (String)ynU.get(Integer.valueOf(12));
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if ((i != 1) || (str == null)) {
          break label136;
        }
        if (((CharSequence)str).length() <= 0) {
          break label131;
        }
      }
      label131:
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label136;
        }
        localObject = (String)localObject + "," + str;
        localObject = (b)ynX.get(localObject);
        AppMethodBeat.o(52235);
        return localObject;
        i = 0;
        break;
      }
    }
    label136:
    AppMethodBeat.o(52235);
    return null;
  }
  
  public static final void dLk()
  {
    AppMethodBeat.i(52236);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    g.yhR.dD(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void dLl()
  {
    AppMethodBeat.i(52237);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    g.yhR.dD(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void dLm()
  {
    AppMethodBeat.i(161973);
    if (ynY)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      g.yhR.dD(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void dLn()
  {
    AppMethodBeat.i(186326);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    g.yhR.dD(1259, 62);
    AppMethodBeat.o(186326);
  }
  
  public static final void dLo()
  {
    AppMethodBeat.i(186327);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    g.yhR.dD(1259, 63);
    AppMethodBeat.o(186327);
  }
  
  public static final void e(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186331);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      g.yhR.dD(1259, 109);
    }
    AppMethodBeat.o(186331);
  }
  
  public static final void f(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186332);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      g.yhR.dD(1259, 110);
    }
    AppMethodBeat.o(186332);
  }
  
  public static final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    g localg;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localg = g.yhR;
      if (!paramBoolean2) {
        break label67;
      }
    }
    label67:
    for (paramInt = 29;; paramInt = 30)
    {
      localg.dD(1259, paramInt);
      AppMethodBeat.o(161975);
      return;
    }
  }
  
  public static final void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)dyV).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = Ox(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), dyV });
      g.yhR.f(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), dyV });
      AppMethodBeat.o(52221);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
    }
  }
  
  public static final void hn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)ynV.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = Ox(paramInt1);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    g.yhR.f(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void l(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(186329);
    if (ynZ == null)
    {
      AppMethodBeat.o(186329);
      return;
    }
    Object localObject1 = ynZ;
    if (localObject1 == null) {
      p.gfZ();
    }
    int i = ((ac.a)localObject1).yof.size();
    localObject1 = ynZ;
    if (localObject1 == null) {
      p.gfZ();
    }
    long l1 = ((ac.a)localObject1).yoc;
    localObject1 = ynZ;
    if (localObject1 == null) {
      p.gfZ();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession:  %d, scanSession: %d, chooseIndex: %d, resultOpType: %d, scanCost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((ac.a)localObject1).yod), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    localObject1 = ynZ;
    if (localObject1 == null) {
      p.gfZ();
    }
    if (!((ac.a)localObject1).fJh)
    {
      localObject1 = ynZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((ac.a)localObject1).yoe = paramInt2;
      localObject1 = ynZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((ac.a)localObject1).fJh = true;
      List localList2 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      List localList1 = (List)new ArrayList();
      localObject1 = ynZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      Object localObject4 = ((Iterable)((ac.a)localObject1).yof).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (WxQBarResult)((Iterator)localObject4).next();
        if (localObject1 != null)
        {
          localObject2 = URLEncoder.encode(((WxQBarResult)localObject1).data, "utf-8");
          p.g(localObject2, "URLEncoder.encode(codeResult.data, \"utf-8\")");
          localList2.add(localObject2);
          ((List)localObject3).add(Integer.valueOf(((WxQBarResult)localObject1).priorityLevel));
          localObject2 = ((WxQBarResult)localObject1).typeName;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localList1.add(localObject1);
        }
      }
      localObject4 = g.yhR;
      localObject1 = ynZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramLong = ((ac.a)localObject1).yoc;
      localObject1 = ynZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      i = ((ac.a)localObject1).yof.size();
      String str1 = j.a((Iterable)localList2, (CharSequence)"#", null, null, 0, null, null, 62);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
      Object localObject2 = (String)j.E(localList2, paramInt2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = (Integer)j.E((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = Integer.valueOf(0);
      }
      localObject3 = ynZ;
      if (localObject3 == null) {
        p.gfZ();
      }
      l1 = ((ac.a)localObject3).yog;
      localObject3 = ynZ;
      if (localObject3 == null) {
        p.gfZ();
      }
      long l2 = ((ac.a)localObject3).yoc;
      localObject3 = j.a((Iterable)localList1, (CharSequence)"#", null, null, 0, null, null, 62);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode typeName: ".concat(String.valueOf(localObject3)));
      ((g)localObject4).f(19332, new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject1, localObject2, Long.valueOf(l1), Long.valueOf(l2), localObject3 });
      ynZ = null;
    }
    AppMethodBeat.o(186329);
  }
  
  public static final void qq(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    u.a((v)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ynY = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  public static final void yZ(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = dLj();
    if (localb != null) {
      localb.yoj = paramLong;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void za(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = dLj();
    if (localb != null) {
      localb.yok = paramLong;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    int dnh;
    int fFu;
    long tlk;
    String yoh = "";
    String yoi = "";
    long yoj;
    long yok;
    long yol;
    long yom;
    long yon;
    boolean yoo;
    
    public final void awI(String paramString)
    {
      AppMethodBeat.i(52215);
      p.h(paramString, "<set-?>");
      this.yoh = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void awJ(String paramString)
    {
      AppMethodBeat.i(52216);
      p.h(paramString, "<set-?>");
      this.yoi = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = d.g.b.ad.MLZ;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.yoh, this.yoi, Long.valueOf(this.yoj), Long.valueOf(this.yok), Long.valueOf(this.yol), Integer.valueOf(this.fFu) }, 6));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements v
  {
    c(boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(52219);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52218);
          ac localac = ac.yob;
          ac.h(this.yor.yop, this.yos, this.yor.yoq);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac
 * JD-Core Version:    0.7.0.1
 */