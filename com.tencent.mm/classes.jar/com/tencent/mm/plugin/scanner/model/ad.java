package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "SCAN_REPORT_SCENE_APPBRAND_JSAPI", "SCAN_REPORT_SCENE_DEFAULT", "SCAN_REPORT_SCENE_SNS_AD", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "scanCost", "reportMultiCodeCancel", "reportMultiCodeClick", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class ad
{
  private static String dAa;
  private static HashMap<Integer, String> yDT;
  private static HashMap<Integer, String> yDU;
  private static HashMap<Integer, Integer> yDV;
  private static HashMap<String, b> yDW;
  private static boolean yDX;
  private static ad.a yDY;
  private static long yDZ;
  public static final ad yEa;
  
  static
  {
    AppMethodBeat.i(52238);
    yEa = new ad();
    dAa = "";
    yDT = new HashMap();
    yDU = new HashMap();
    yDV = new HashMap();
    yDW = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void Pa(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)yDU).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ae.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), yDU.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String Pb(int paramInt)
  {
    AppMethodBeat.i(189612);
    String str = (String)yDU.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(189612);
    return str;
  }
  
  public static final void Pc(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!Pm(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)yDT).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ae.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), yDT.get(Integer.valueOf(paramInt)) });
    String str1 = (String)yDU.get(Integer.valueOf(paramInt));
    String str2 = (String)yDT.get(Integer.valueOf(paramInt));
    if (str1 != null) {
      if (((CharSequence)str1).length() > 0)
      {
        paramInt = 1;
        if (paramInt != 1) {
          break label336;
        }
        if (str2 == null) {
          break label250;
        }
        if (((CharSequence)str2).length() <= 0) {
          break label245;
        }
      }
    }
    b localb;
    label245:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 1) {
        break label336;
      }
      String str3 = str1 + "," + str2;
      localb = (b)yDW.get(str3);
      if (localb != null) {
        break label256;
      }
      localb = new b();
      localb.axX(str1);
      localb.axY(str2);
      ((Map)yDW).put(str3, localb);
      AppMethodBeat.o(52224);
      return;
      paramInt = 0;
      break;
      AppMethodBeat.o(52224);
      return;
    }
    label250:
    AppMethodBeat.o(52224);
    return;
    label256:
    localb.yEg = "";
    localb.yEh = "";
    localb.yEi = 0L;
    localb.yEj = 0L;
    localb.yEk = 0L;
    localb.fHy = 0;
    localb.yEl = 0L;
    localb.yEm = 0L;
    localb.twc = 0L;
    localb.doj = 0;
    localb.yEn = false;
    localb.axX(str1);
    localb.axY(str2);
    label336:
    AppMethodBeat.o(52224);
  }
  
  public static final String Pd(int paramInt)
  {
    AppMethodBeat.i(189613);
    String str = (String)yDT.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(189613);
    return str;
  }
  
  private static int Pe(int paramInt)
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
  
  private static int Pf(int paramInt)
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
  
  public static final void Pg(int paramInt)
  {
    AppMethodBeat.i(161056);
    ae.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      g.yxI.dD(1259, 20);
      g.yxI.dD(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      g.yxI.dD(1259, 20);
      g.yxI.dD(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  public static final void Ph(int paramInt)
  {
    AppMethodBeat.i(170036);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Pm(paramInt))
    {
      localInteger = (Integer)yDV.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)yDV).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        g.yxI.dD(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)yDV.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)yDV).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      g.yxI.dD(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void Pi(int paramInt)
  {
    AppMethodBeat.i(170037);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (Pm(paramInt))
    {
      localInteger = (Integer)yDV.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ae.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)yDV).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      g.yxI.dD(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)yDV.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        break label150;
      }
    }
    label150:
    while (localInteger.intValue() != 1)
    {
      ae.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)yDV).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    g.yxI.dD(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void Pj(int paramInt)
  {
    AppMethodBeat.i(170040);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Pm(paramInt))
    {
      g.yxI.dD(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      g.yxI.dD(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void Pk(int paramInt)
  {
    AppMethodBeat.i(170041);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Pm(paramInt))
    {
      g.yxI.dD(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      g.yxI.dD(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void Pl(int paramInt)
  {
    AppMethodBeat.i(170042);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Pm(paramInt))
    {
      g.yxI.dD(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      g.yxI.dD(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean Pm(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static final void R(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    g localg;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localg = g.yxI;
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
      localg = g.yxI;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
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
    AppMethodBeat.i(189615);
    b localb = dOC();
    if (localb == null)
    {
      AppMethodBeat.o(189615);
      return;
    }
    localb.fHy = paramInt;
    if (localb.yEj > localb.yEi) {
      localb.yEk = (localb.yEj - localb.yEi);
    }
    if (localb.yEk > 0L)
    {
      paramInt = a(paramBaseScanRequest);
      paramBaseScanRequest = b(paramBaseScanRequest);
      ae.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second });
      g.yxI.f(18560, new Object[] { localb.yEg, localb.yEh, Long.valueOf(localb.yEi), Long.valueOf(localb.yEj), Long.valueOf(localb.yEk), Integer.valueOf(localb.fHy), Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second, dAa });
    }
    ((Map)yDT).put(Integer.valueOf(12), "");
    AppMethodBeat.o(189615);
  }
  
  public static final void a(int paramInt1, BaseScanRequest paramBaseScanRequest, int paramInt2)
  {
    AppMethodBeat.i(189614);
    String str1 = (String)yDU.get(Integer.valueOf(12));
    String str2 = (String)yDT.get(Integer.valueOf(12));
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
      AppMethodBeat.o(189614);
      return;
      i = 0;
      break;
    }
    label111:
    paramInt1 = Pf(paramInt1);
    i = a(paramBaseScanRequest);
    paramBaseScanRequest = b(paramBaseScanRequest);
    ae.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", new Object[] { Integer.valueOf(18558), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.yxI.f(18558, new Object[] { str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), paramBaseScanRequest.first, paramBaseScanRequest.second, dAa });
    AppMethodBeat.o(189614);
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(189618);
    p.h(paramList, "codeResultList");
    yDY = new ad.a(paramList, paramLong);
    try
    {
      paramList = yDY;
      String str;
      if (paramList != null)
      {
        str = Pb(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.yEb = paramLong;
        }
      }
      else
      {
        paramList = yDY;
        if (paramList == null) {
          break label106;
        }
        str = Pd(paramInt);
        if (str == null) {
          break label99;
        }
      }
      label99:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.yEc = paramLong;
        AppMethodBeat.o(189618);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label106:
      AppMethodBeat.o(189618);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(189618);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg;
    if (Pm(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        g.yxI.dD(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localg = g.yxI;
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
          g.yxI.dD(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localg = g.yxI;
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
    b localb = dOC();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.yEm = paramLong;
    localb.yEn = paramBoolean1;
    localb.doj = Pf(paramInt);
    if ((localb.yEl > 0L) && (localb.yEm > 0L)) {
      localb.twc = (localb.yEm - localb.yEl);
    }
    int i;
    if ((localb.twc > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      ae.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.yEg, localb.yEh, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.twc), Integer.valueOf(i) });
      g.yxI.f(18724, new Object[] { localb.yEg, localb.yEh, Integer.valueOf(localb.doj), Integer.valueOf(i), Long.valueOf(localb.twc) });
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
    if (!yDX)
    {
      ae.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    ae.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      g.yxI.dD(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        g.yxI.dD(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          g.yxI.dD(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          g.yxI.dD(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          g.yxI.dD(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          g.yxI.dD(1259, 26);
        } else if (paramLong >= 5000L) {
          g.yxI.dD(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          g.yxI.dD(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          g.yxI.dD(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          g.yxI.dD(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          g.yxI.dD(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          g.yxI.dD(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = dOC();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.yEl = paramLong;
    ae.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.yEg, localb.yEh, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  private static o<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(189623);
    label148:
    for (;;)
    {
      try
      {
        if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
        {
          String str = paramBaseScanRequest.getExtra("key_sns_ad_ux_info", "");
          p.g(str, "bizInfo");
          paramBaseScanRequest = (String)j.F(n.a((CharSequence)str, new String[] { "|" }), 1);
          if (paramBaseScanRequest != null) {
            break label148;
          }
          paramBaseScanRequest = "";
          ae.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new o(paramBaseScanRequest, str);
          AppMethodBeat.o(189623);
          return paramBaseScanRequest;
        }
      }
      catch (Exception paramBaseScanRequest)
      {
        ae.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
        paramBaseScanRequest = new o("", "");
        AppMethodBeat.o(189623);
        return paramBaseScanRequest;
      }
    }
  }
  
  public static final void b(int paramInt1, BaseScanRequest paramBaseScanRequest, int paramInt2)
  {
    AppMethodBeat.i(189620);
    paramInt1 = Pe(paramInt1);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt2 == 1)
    {
      yDZ = l3;
      l1 = l2;
    }
    for (;;)
    {
      int i = a(paramBaseScanRequest);
      o localo = b(paramBaseScanRequest);
      g.yxI.f(20275, new Object[] { localo.first, localo.second, dAa, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l3), Long.valueOf(l1) });
      if ((paramInt2 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        g.yxI.dD(1259, 108);
      }
      AppMethodBeat.o(189620);
      return;
      l1 = l2;
      if (paramInt2 == 2)
      {
        l1 = l2;
        if (yDZ > 0L)
        {
          l1 = l3 - yDZ;
          yDZ = 0L;
        }
      }
    }
  }
  
  public static final void dOA()
  {
    AppMethodBeat.i(52220);
    dAa = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  public static final String dOB()
  {
    return dAa;
  }
  
  private static b dOC()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)yDU.get(Integer.valueOf(12));
    String str = (String)yDT.get(Integer.valueOf(12));
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if ((i != 1) || (str == null)) {
          break label135;
        }
        if (((CharSequence)str).length() <= 0) {
          break label130;
        }
      }
      label130:
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label135;
        }
        localObject = (String)localObject + "," + str;
        localObject = (b)yDW.get(localObject);
        AppMethodBeat.o(52235);
        return localObject;
        i = 0;
        break;
      }
    }
    label135:
    AppMethodBeat.o(52235);
    return null;
  }
  
  public static final void dOD()
  {
    AppMethodBeat.i(52236);
    ae.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    g.yxI.dD(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void dOE()
  {
    AppMethodBeat.i(52237);
    ae.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    g.yxI.dD(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void dOF()
  {
    AppMethodBeat.i(161973);
    if (yDX)
    {
      ae.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      g.yxI.dD(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void dOG()
  {
    AppMethodBeat.i(189616);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    g.yxI.dD(1259, 62);
    AppMethodBeat.o(189616);
  }
  
  public static final void dOH()
  {
    AppMethodBeat.i(189617);
    ae.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    g.yxI.dD(1259, 63);
    AppMethodBeat.o(189617);
  }
  
  public static final void e(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189621);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      g.yxI.dD(1259, 109);
    }
    AppMethodBeat.o(189621);
  }
  
  public static final void f(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189622);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      g.yxI.dD(1259, 110);
    }
    AppMethodBeat.o(189622);
  }
  
  public static final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    ae.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    g localg;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localg = g.yxI;
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
  
  public static final void ho(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)dAa).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = Pe(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      ae.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), dAa });
      g.yxI.f(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), dAa });
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
  
  public static final void hp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)yDU.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = Pe(paramInt1);
    ae.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    g.yxI.f(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void l(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(189619);
    if (yDY == null)
    {
      AppMethodBeat.o(189619);
      return;
    }
    Object localObject1 = yDY;
    if (localObject1 == null) {
      p.gkB();
    }
    int i = ((ad.a)localObject1).yEe.size();
    localObject1 = yDY;
    if (localObject1 == null) {
      p.gkB();
    }
    long l1 = ((ad.a)localObject1).yEb;
    localObject1 = yDY;
    if (localObject1 == null) {
      p.gkB();
    }
    ae.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession:  %d, scanSession: %d, chooseIndex: %d, resultOpType: %d, scanCost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((ad.a)localObject1).yEc), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    localObject1 = yDY;
    if (localObject1 == null) {
      p.gkB();
    }
    if (!((ad.a)localObject1).fLk)
    {
      localObject1 = yDY;
      if (localObject1 == null) {
        p.gkB();
      }
      ((ad.a)localObject1).yEd = paramInt2;
      localObject1 = yDY;
      if (localObject1 == null) {
        p.gkB();
      }
      ((ad.a)localObject1).fLk = true;
      List localList2 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      List localList1 = (List)new ArrayList();
      localObject1 = yDY;
      if (localObject1 == null) {
        p.gkB();
      }
      Object localObject4 = ((Iterable)((ad.a)localObject1).yEe).iterator();
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
      localObject4 = g.yxI;
      localObject1 = yDY;
      if (localObject1 == null) {
        p.gkB();
      }
      paramLong = ((ad.a)localObject1).yEb;
      localObject1 = yDY;
      if (localObject1 == null) {
        p.gkB();
      }
      i = ((ad.a)localObject1).yEe.size();
      String str1 = j.a((Iterable)localList2, (CharSequence)"#", null, null, 0, null, null, 62);
      ae.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      ae.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
      Object localObject2 = (String)j.F(localList2, paramInt2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = (Integer)j.F((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = Integer.valueOf(0);
      }
      localObject3 = yDY;
      if (localObject3 == null) {
        p.gkB();
      }
      l1 = ((ad.a)localObject3).yEf;
      localObject3 = yDY;
      if (localObject3 == null) {
        p.gkB();
      }
      long l2 = ((ad.a)localObject3).yEb;
      localObject3 = j.a((Iterable)localList1, (CharSequence)"#", null, null, 0, null, null, 62);
      ae.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode typeName: ".concat(String.valueOf(localObject3)));
      ((g)localObject4).f(19332, new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject1, localObject2, Long.valueOf(l1), Long.valueOf(l2), localObject3 });
      yDY = null;
    }
    AppMethodBeat.o(189619);
  }
  
  public static final void qx(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    v.a((w)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void qy(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    ae.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    yDX = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  public static final void zw(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = dOC();
    if (localb != null) {
      localb.yEi = paramLong;
    }
    ae.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void zx(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = dOC();
    if (localb != null) {
      localb.yEj = paramLong;
    }
    ae.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    int doj;
    int fHy;
    long twc;
    String yEg = "";
    String yEh = "";
    long yEi;
    long yEj;
    long yEk;
    long yEl;
    long yEm;
    boolean yEn;
    
    public final void axX(String paramString)
    {
      AppMethodBeat.i(52215);
      p.h(paramString, "<set-?>");
      this.yEg = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void axY(String paramString)
    {
      AppMethodBeat.i(52216);
      p.h(paramString, "<set-?>");
      this.yEh = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = d.g.b.ad.Njc;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.yEg, this.yEh, Long.valueOf(this.yEi), Long.valueOf(this.yEj), Long.valueOf(this.yEk), Integer.valueOf(this.fHy) }, 6));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements w
  {
    c(boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(52219);
      ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52218);
          ad localad = ad.yEa;
          ad.h(this.yEq.yEo, this.yEr, this.yEq.yEp);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ad
 * JD-Core Version:    0.7.0.1
 */