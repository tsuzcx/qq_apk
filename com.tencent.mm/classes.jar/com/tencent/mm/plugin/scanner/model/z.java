package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qbar.WxQBarResult;
import d.a.j;
import d.g.b.k;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "SCAN_REPORT_SCENE_DEFAULT", "SCAN_REPORT_SCENE_SNS_AD", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "scanCost", "reportMultiCodeCancel", "reportMultiCodeClick", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanOperation", "op", "reportScanSuccessResult", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "showScanResult", "startScanGoods", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class z
{
  private static String dnh;
  private static HashMap<Integer, String> wZV;
  private static HashMap<Integer, String> wZW;
  private static HashMap<Integer, Integer> wZX;
  private static HashMap<String, b> wZY;
  private static boolean wZZ;
  private static z.a xaa;
  private static long xab;
  public static final z xac;
  
  static
  {
    AppMethodBeat.i(52238);
    xac = new z();
    dnh = "";
    wZV = new HashMap();
    wZW = new HashMap();
    wZX = new HashMap();
    wZY = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void MR(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)wZW).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ac.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), wZW.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String MS(int paramInt)
  {
    AppMethodBeat.i(199610);
    String str = (String)wZW.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(199610);
    return str;
  }
  
  public static final void MT(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!Nd(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)wZV).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ac.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), wZV.get(Integer.valueOf(paramInt)) });
    String str1 = (String)wZW.get(Integer.valueOf(paramInt));
    String str2 = (String)wZV.get(Integer.valueOf(paramInt));
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
      localb = (b)wZY.get(str3);
      if (localb != null) {
        break label256;
      }
      localb = new b();
      localb.arH(str1);
      localb.arI(str2);
      ((Map)wZY).put(str3, localb);
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
    localb.xai = "";
    localb.xaj = "";
    localb.xak = 0L;
    localb.xal = 0L;
    localb.xam = 0L;
    localb.fnm = 0;
    localb.xan = 0L;
    localb.xao = 0L;
    localb.soH = 0L;
    localb.dbL = 0;
    localb.xap = false;
    localb.arH(str1);
    localb.arI(str2);
    label336:
    AppMethodBeat.o(52224);
  }
  
  public static final String MU(int paramInt)
  {
    AppMethodBeat.i(199611);
    String str = (String)wZV.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(199611);
    return str;
  }
  
  private static int MV(int paramInt)
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
  
  private static int MW(int paramInt)
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
  
  public static final void MX(int paramInt)
  {
    AppMethodBeat.i(161056);
    ac.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      h.wUl.dB(1259, 20);
      h.wUl.dB(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      h.wUl.dB(1259, 20);
      h.wUl.dB(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  public static final void MY(int paramInt)
  {
    AppMethodBeat.i(170036);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Nd(paramInt))
    {
      localInteger = (Integer)wZX.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)wZX).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        h.wUl.dB(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)wZX.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)wZX).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      h.wUl.dB(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void MZ(int paramInt)
  {
    AppMethodBeat.i(170037);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (Nd(paramInt))
    {
      localInteger = (Integer)wZX.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ac.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)wZX).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      h.wUl.dB(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)wZX.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        break label150;
      }
    }
    label150:
    while (localInteger.intValue() != 1)
    {
      ac.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)wZX).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    h.wUl.dB(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void N(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localh = h.wUl;
        paramInt = 102;
      }
    }
    for (;;)
    {
      localh.dB(1259, paramInt);
      do
      {
        AppMethodBeat.o(170039);
        return;
      } while (paramInt != 2);
      localh = h.wUl;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
  }
  
  public static final void Na(int paramInt)
  {
    AppMethodBeat.i(170040);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Nd(paramInt))
    {
      h.wUl.dB(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      h.wUl.dB(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void Nb(int paramInt)
  {
    AppMethodBeat.i(170041);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Nd(paramInt))
    {
      h.wUl.dB(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      h.wUl.dB(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void Nc(int paramInt)
  {
    AppMethodBeat.i(170042);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Nd(paramInt))
    {
      h.wUl.dB(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      h.wUl.dB(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean Nd(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  private static int a(BaseScanRequest paramBaseScanRequest)
  {
    if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
      return 1;
    }
    return 0;
  }
  
  public static final void a(int paramInt, BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(199612);
    String str1 = (String)wZW.get(Integer.valueOf(12));
    String str2 = (String)wZV.get(Integer.valueOf(12));
    CharSequence localCharSequence = (CharSequence)str1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)str2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label104;
        }
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label109;
      }
      AppMethodBeat.o(199612);
      return;
      i = 0;
      break;
    }
    label109:
    paramInt = MW(paramInt);
    i = a(paramBaseScanRequest);
    paramBaseScanRequest = b(paramBaseScanRequest);
    ac.d("MicroMsg.ScanReporter", "alvinluo reportScanSuccessResult logId: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s", new Object[] { Integer.valueOf(18558), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt) });
    h.wUl.f(18558, new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(1), Integer.valueOf(i), paramBaseScanRequest.first, paramBaseScanRequest.second, dnh });
    AppMethodBeat.o(199612);
  }
  
  public static final void a(int paramInt1, BaseScanRequest paramBaseScanRequest, int paramInt2)
  {
    AppMethodBeat.i(199618);
    paramInt1 = MV(paramInt1);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt2 == 1)
    {
      xab = l3;
      l1 = l2;
    }
    for (;;)
    {
      int i = a(paramBaseScanRequest);
      o localo = b(paramBaseScanRequest);
      h.wUl.f(20275, new Object[] { localo.first, localo.second, dnh, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l3), Long.valueOf(l1) });
      if ((paramInt2 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        h.wUl.dB(1259, 108);
      }
      AppMethodBeat.o(199618);
      return;
      l1 = l2;
      if (paramInt2 == 2)
      {
        l1 = l2;
        if (xab > 0L)
        {
          l1 = l3 - xab;
          xab = 0L;
        }
      }
    }
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(199616);
    k.h(paramList, "codeResultList");
    xaa = new z.a(paramList, paramLong);
    try
    {
      paramList = xaa;
      String str;
      if (paramList != null)
      {
        str = MS(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.xad = paramLong;
        }
      }
      else
      {
        paramList = xaa;
        if (paramList == null) {
          break label106;
        }
        str = MU(paramInt);
        if (str == null) {
          break label99;
        }
      }
      label99:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.xae = paramLong;
        AppMethodBeat.o(199616);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label106:
      AppMethodBeat.o(199616);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(199616);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h localh;
    if (Nd(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        h.wUl.dB(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localh = h.wUl;
        paramInt1 = 60;
      }
    }
    for (;;)
    {
      localh.dB(1259, paramInt1);
      label102:
      label125:
      do
      {
        AppMethodBeat.o(170038);
        return;
        if (paramInt3 > 1) {
          h.wUl.dB(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localh = h.wUl;
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
    b localb = dzJ();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.xao = paramLong;
    localb.xap = paramBoolean1;
    localb.dbL = MW(paramInt);
    if ((localb.xan > 0L) && (localb.xao > 0L)) {
      localb.soH = (localb.xao - localb.xan);
    }
    int i;
    if ((localb.soH > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      ac.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.xai, localb.xaj, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.soH), Integer.valueOf(i) });
      h.wUl.f(18724, new Object[] { localb.xai, localb.xaj, Integer.valueOf(localb.dbL), Integer.valueOf(i), Long.valueOf(localb.soH) });
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
    if (!wZZ)
    {
      ac.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    ac.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      h.wUl.dB(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        h.wUl.dB(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          h.wUl.dB(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          h.wUl.dB(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          h.wUl.dB(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          h.wUl.dB(1259, 26);
        } else if (paramLong >= 5000L) {
          h.wUl.dB(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          h.wUl.dB(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          h.wUl.dB(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          h.wUl.dB(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          h.wUl.dB(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          h.wUl.dB(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aq(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = dzJ();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.xan = paramLong;
    ac.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.xai, localb.xaj, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  private static o<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(199621);
    label148:
    for (;;)
    {
      try
      {
        if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
        {
          String str = paramBaseScanRequest.iN("key_sns_ad_ux_info", "");
          k.g(str, "bizInfo");
          paramBaseScanRequest = (String)j.C(n.a((CharSequence)str, new String[] { "|" }), 1);
          if (paramBaseScanRequest != null) {
            break label148;
          }
          paramBaseScanRequest = "";
          ac.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new o(paramBaseScanRequest, str);
          AppMethodBeat.o(199621);
          return paramBaseScanRequest;
        }
      }
      catch (Exception paramBaseScanRequest)
      {
        ac.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
        paramBaseScanRequest = new o("", "");
        AppMethodBeat.o(199621);
        return paramBaseScanRequest;
      }
    }
  }
  
  public static final void b(int paramInt, BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(199613);
    b localb = dzJ();
    if (localb == null)
    {
      AppMethodBeat.o(199613);
      return;
    }
    localb.fnm = paramInt;
    if (localb.xal > localb.xak) {
      localb.xam = (localb.xal - localb.xak);
    }
    if (localb.xam > 0L)
    {
      paramInt = a(paramBaseScanRequest);
      paramBaseScanRequest = b(paramBaseScanRequest);
      ac.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second });
      h.wUl.f(18560, new Object[] { localb.xai, localb.xaj, Long.valueOf(localb.xak), Long.valueOf(localb.xal), Long.valueOf(localb.xam), Integer.valueOf(localb.fnm), Integer.valueOf(paramInt), paramBaseScanRequest.first, paramBaseScanRequest.second, dnh });
    }
    ((Map)wZV).put(Integer.valueOf(12), "");
    AppMethodBeat.o(199613);
  }
  
  public static final void c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199619);
    k.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.wUl.dB(1259, 109);
    }
    AppMethodBeat.o(199619);
  }
  
  public static final void d(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199620);
    k.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.wUl.dB(1259, 110);
    }
    AppMethodBeat.o(199620);
  }
  
  public static final void dzH()
  {
    AppMethodBeat.i(52220);
    dnh = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  public static final String dzI()
  {
    return dnh;
  }
  
  private static b dzJ()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)wZW.get(Integer.valueOf(12));
    String str = (String)wZV.get(Integer.valueOf(12));
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
        localObject = (b)wZY.get(localObject);
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
  
  public static final void dzK()
  {
    AppMethodBeat.i(52236);
    ac.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    h.wUl.dB(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void dzL()
  {
    AppMethodBeat.i(52237);
    ac.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    h.wUl.dB(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void dzM()
  {
    AppMethodBeat.i(161973);
    if (wZZ)
    {
      ac.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      h.wUl.dB(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void dzN()
  {
    AppMethodBeat.i(199614);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    h.wUl.dB(1259, 62);
    AppMethodBeat.o(199614);
  }
  
  public static final void dzO()
  {
    AppMethodBeat.i(199615);
    ac.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    h.wUl.dB(1259, 63);
    AppMethodBeat.o(199615);
  }
  
  public static final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    ac.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    h localh;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localh = h.wUl;
      if (!paramBoolean2) {
        break label67;
      }
    }
    label67:
    for (paramInt = 29;; paramInt = 30)
    {
      localh.dB(1259, paramInt);
      AppMethodBeat.o(161975);
      return;
    }
  }
  
  public static final void gV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)dnh).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = MV(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      ac.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), dnh });
      h.wUl.f(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), dnh });
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
  
  public static final void gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)wZW.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = MV(paramInt1);
    ac.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    h.wUl.f(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(199617);
    if (xaa == null)
    {
      AppMethodBeat.o(199617);
      return;
    }
    Object localObject1 = xaa;
    if (localObject1 == null) {
      k.fOy();
    }
    int i = ((z.a)localObject1).xag.size();
    localObject1 = xaa;
    if (localObject1 == null) {
      k.fOy();
    }
    long l = ((z.a)localObject1).xad;
    localObject1 = xaa;
    if (localObject1 == null) {
      k.fOy();
    }
    ac.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession:  %d, scanSession: %d, chooseIndex: %d, resultOpType: %d, scanCost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Long.valueOf(((z.a)localObject1).xae), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    localObject1 = xaa;
    if (localObject1 == null) {
      k.fOy();
    }
    if (!((z.a)localObject1).fra)
    {
      localObject1 = xaa;
      if (localObject1 == null) {
        k.fOy();
      }
      ((z.a)localObject1).xaf = paramInt2;
      localObject1 = xaa;
      if (localObject1 == null) {
        k.fOy();
      }
      ((z.a)localObject1).fra = true;
      localObject1 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      Object localObject2 = xaa;
      if (localObject2 == null) {
        k.fOy();
      }
      localObject2 = ((Iterable)((z.a)localObject2).xag).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (WxQBarResult)((Iterator)localObject2).next();
        if (localObject4 != null)
        {
          str1 = URLEncoder.encode(((WxQBarResult)localObject4).data, "utf-8");
          k.g(str1, "URLEncoder.encode(codeResult.data, \"utf-8\")");
          ((List)localObject1).add(str1);
          ((List)localObject3).add(Integer.valueOf(((WxQBarResult)localObject4).priorityLevel));
        }
      }
      Object localObject4 = h.wUl;
      localObject2 = xaa;
      if (localObject2 == null) {
        k.fOy();
      }
      paramLong = ((z.a)localObject2).xad;
      localObject2 = xaa;
      if (localObject2 == null) {
        k.fOy();
      }
      i = ((z.a)localObject2).xag.size();
      String str1 = j.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62);
      ac.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      ac.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
      localObject2 = (String)j.C((List)localObject1, paramInt2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = (Integer)j.C((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = Integer.valueOf(0);
      }
      localObject3 = xaa;
      if (localObject3 == null) {
        k.fOy();
      }
      l = ((z.a)localObject3).xah;
      localObject3 = xaa;
      if (localObject3 == null) {
        k.fOy();
      }
      ((h)localObject4).f(19332, new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject1, localObject2, Long.valueOf(l), Long.valueOf(((z.a)localObject3).xad) });
      xaa = null;
    }
    AppMethodBeat.o(199617);
  }
  
  public static final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    s.a((t)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    ac.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    wZZ = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  public static final void wC(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = dzJ();
    if (localb != null) {
      localb.xak = paramLong;
    }
    ac.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void wD(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = dzJ();
    if (localb != null) {
      localb.xal = paramLong;
    }
    ac.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    int dbL;
    int fnm;
    long soH;
    String xai = "";
    String xaj = "";
    long xak;
    long xal;
    long xam;
    long xan;
    long xao;
    boolean xap;
    
    public final void arH(String paramString)
    {
      AppMethodBeat.i(52215);
      k.h(paramString, "<set-?>");
      this.xai = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void arI(String paramString)
    {
      AppMethodBeat.i(52216);
      k.h(paramString, "<set-?>");
      this.xaj = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = d.g.b.z.KUT;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.xai, this.xaj, Long.valueOf(this.xak), Long.valueOf(this.xal), Long.valueOf(this.xam), Integer.valueOf(this.fnm) }, 6));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements t
  {
    c(boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(52219);
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52218);
          z localz = z.xac;
          z.h(this.xas.xaq, this.xat, this.xas.xar);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */