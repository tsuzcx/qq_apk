package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.WxQBarResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_CANCEL_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_CLICK_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_JUMP_SCAN_GOODS_SUCCESS", "RESULT_OP_TYPE_SHOW_JUMP_SCAN_GOODS_TIPS", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getScanGoodsReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "reportMultiCodeCancel", "reportMultiCodeClick", "reportMultiCodeOp", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "scene", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanGoodsScene", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class af
{
  private static HashMap<Integer, String> CGL;
  private static HashMap<Integer, String> CGM;
  private static HashMap<Integer, Integer> CGN;
  private static HashMap<String, b> CGO;
  private static boolean CGP;
  private static a CGQ;
  private static long CGR;
  public static final af CGS;
  private static String dRM;
  
  static
  {
    AppMethodBeat.i(52238);
    CGS = new af();
    dRM = "";
    CGL = new HashMap();
    CGM = new HashMap();
    CGN = new HashMap();
    CGO = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void Iy(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = eQi();
    if (localb != null) {
      localb.CHc = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void Iz(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = eQi();
    if (localb != null) {
      localb.CHd = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  private static int JH(int paramInt)
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
  
  public static final void T(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localh = h.CyF;
        paramInt = 102;
      }
    }
    for (;;)
    {
      localh.dN(1259, paramInt);
      do
      {
        AppMethodBeat.o(170039);
        return;
      } while (paramInt != 2);
      localh = h.CyF;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
  }
  
  public static final void WA(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!WJ(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)CGL).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), CGL.get(Integer.valueOf(paramInt)) });
    String str1 = (String)CGM.get(Integer.valueOf(paramInt));
    String str2 = (String)CGL.get(Integer.valueOf(paramInt));
    if (str1 != null) {
      if (((CharSequence)str1).length() > 0)
      {
        paramInt = 1;
        if (paramInt != 1) {
          break label338;
        }
        if (str2 == null) {
          break label252;
        }
        if (((CharSequence)str2).length() <= 0) {
          break label247;
        }
      }
    }
    b localb;
    label247:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 1) {
        break label338;
      }
      String str3 = str1 + "," + str2;
      localb = (b)CGO.get(str3);
      if (localb != null) {
        break label258;
      }
      localb = new b();
      localb.aMB(str1);
      localb.aMC(str2);
      ((Map)CGO).put(str3, localb);
      AppMethodBeat.o(52224);
      return;
      paramInt = 0;
      break;
      AppMethodBeat.o(52224);
      return;
    }
    label252:
    AppMethodBeat.o(52224);
    return;
    label258:
    localb.CHa = "";
    localb.CHb = "";
    localb.CHc = 0L;
    localb.CHd = 0L;
    localb.CHe = 0L;
    localb.gmJ = 0;
    localb.CHf = 0L;
    localb.CHg = 0L;
    localb.wNg = 0L;
    localb.source = 0;
    localb.CHh = false;
    localb.aMB(str1);
    localb.aMC(str2);
    label338:
    AppMethodBeat.o(52224);
  }
  
  public static final String WB(int paramInt)
  {
    AppMethodBeat.i(240464);
    String str = (String)CGL.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(240464);
    return str;
  }
  
  private static int WC(int paramInt)
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
  
  public static final void WD(int paramInt)
  {
    AppMethodBeat.i(161056);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      h.CyF.dN(1259, 20);
      h.CyF.dN(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      h.CyF.dN(1259, 20);
      h.CyF.dN(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  public static final void WE(int paramInt)
  {
    AppMethodBeat.i(170036);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (WJ(paramInt))
    {
      localInteger = (Integer)CGN.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)CGN).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        h.CyF.dN(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)CGN.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)CGN).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      h.CyF.dN(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void WF(int paramInt)
  {
    AppMethodBeat.i(170037);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (WJ(paramInt))
    {
      localInteger = (Integer)CGN.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)CGN).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      h.CyF.dN(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)CGN.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        break label150;
      }
    }
    label150:
    while (localInteger.intValue() != 1)
    {
      Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)CGN).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    h.CyF.dN(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void WG(int paramInt)
  {
    AppMethodBeat.i(170040);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (WJ(paramInt))
    {
      h.CyF.dN(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      h.CyF.dN(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void WH(int paramInt)
  {
    AppMethodBeat.i(170041);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (WJ(paramInt))
    {
      h.CyF.dN(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      h.CyF.dN(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void WI(int paramInt)
  {
    AppMethodBeat.i(170042);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (WJ(paramInt))
    {
      h.CyF.dN(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      h.CyF.dN(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean WJ(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static final void Wy(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)CGM).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), CGM.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String Wz(int paramInt)
  {
    AppMethodBeat.i(240463);
    String str = (String)CGM.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(240463);
    return str;
  }
  
  public static final int a(BaseScanRequest paramBaseScanRequest)
  {
    if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
      return 1;
    }
    if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).requestType == 2)) {
      return 2;
    }
    return 0;
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(240466);
    b localb = eQi();
    if (localb == null)
    {
      AppMethodBeat.o(240466);
      return;
    }
    localb.gmJ = paramInt2;
    if (localb.CHd > localb.CHc) {
      localb.CHe = (localb.CHd - localb.CHc);
    }
    if (localb.CHe > 0L)
    {
      paramBaseScanRequest = b(paramBaseScanRequest);
      Log.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt1), paramBaseScanRequest.first, paramBaseScanRequest.second });
      h.CyF.a(18560, new Object[] { localb.CHa, localb.CHb, Long.valueOf(localb.CHc), Long.valueOf(localb.CHd), Long.valueOf(localb.CHe), Integer.valueOf(localb.gmJ), Integer.valueOf(paramInt1), paramBaseScanRequest.first, paramBaseScanRequest.second, dRM });
    }
    ((Map)CGL).put(Integer.valueOf(12), "");
    AppMethodBeat.o(240466);
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3)
  {
    AppMethodBeat.i(240465);
    String str1 = (String)CGM.get(Integer.valueOf(12));
    String str2 = (String)CGL.get(Integer.valueOf(12));
    CharSequence localCharSequence = (CharSequence)str1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)str2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label111;
        }
      }
    }
    label111:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label117;
      }
      AppMethodBeat.o(240465);
      return;
      i = 0;
      break;
    }
    label117:
    paramInt2 = WC(paramInt2);
    paramBaseScanRequest = b(paramBaseScanRequest);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, scene: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", new Object[] { Integer.valueOf(18558), Integer.valueOf(paramInt1), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.CyF.a(18558, new Object[] { str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramBaseScanRequest.first, paramBaseScanRequest.second, dRM });
    AppMethodBeat.o(240465);
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(240469);
    p.h(paramList, "codeResultList");
    CGQ = new a(paramList, paramLong);
    try
    {
      paramList = CGQ;
      String str;
      if (paramList != null)
      {
        str = Wz(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.CGT = paramLong;
        }
      }
      else
      {
        paramList = CGQ;
        if (paramList != null)
        {
          str = WB(paramInt);
          if (str == null) {
            break label114;
          }
        }
      }
      label114:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.CGU = paramLong;
        paramList = CGQ;
        if (paramList == null) {
          break label121;
        }
        paramList.CGW = System.currentTimeMillis();
        AppMethodBeat.o(240469);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label121:
      AppMethodBeat.o(240469);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(240469);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h localh;
    if (WJ(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        h.CyF.dN(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localh = h.CyF;
        paramInt1 = 60;
      }
    }
    for (;;)
    {
      localh.dN(1259, paramInt1);
      label102:
      label125:
      do
      {
        AppMethodBeat.o(170038);
        return;
        if (paramInt3 > 1) {
          h.CyF.dN(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localh = h.CyF;
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
    b localb = eQi();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.CHg = paramLong;
    localb.CHh = paramBoolean1;
    localb.source = WC(paramInt);
    if ((localb.CHf > 0L) && (localb.CHg > 0L)) {
      localb.wNg = (localb.CHg - localb.CHf);
    }
    int i;
    if ((localb.wNg > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.CHa, localb.CHb, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.wNg), Integer.valueOf(i) });
      h.CyF.a(18724, new Object[] { localb.CHa, localb.CHb, Integer.valueOf(localb.source), Integer.valueOf(i), Long.valueOf(localb.wNg) });
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
    if (!CGP)
    {
      Log.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      h.CyF.dN(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        h.CyF.dN(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          h.CyF.dN(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          h.CyF.dN(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          h.CyF.dN(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          h.CyF.dN(1259, 26);
        } else if (paramLong >= 5000L) {
          h.CyF.dN(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          h.CyF.dN(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          h.CyF.dN(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          h.CyF.dN(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          h.CyF.dN(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          h.CyF.dN(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aE(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = eQi();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.CHf = paramLong;
    Log.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.CHa, localb.CHb, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  private static o<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(240476);
    label148:
    for (;;)
    {
      try
      {
        if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
        {
          String str = paramBaseScanRequest.getExtra("key_sns_ad_ux_info", "");
          p.g(str, "bizInfo");
          paramBaseScanRequest = (String)j.L(n.a((CharSequence)str, new String[] { "|" }), 1);
          if (paramBaseScanRequest != null) {
            break label148;
          }
          paramBaseScanRequest = "";
          Log.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new o(paramBaseScanRequest, str);
          AppMethodBeat.o(240476);
          return paramBaseScanRequest;
        }
      }
      catch (Exception paramBaseScanRequest)
      {
        Log.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
        paramBaseScanRequest = new o("", "");
        AppMethodBeat.o(240476);
        return paramBaseScanRequest;
      }
    }
  }
  
  public static final void b(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3)
  {
    AppMethodBeat.i(240473);
    paramInt2 = JH(paramInt2);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt3 == 1)
    {
      CGR = l3;
      l1 = l2;
    }
    for (;;)
    {
      o localo = b(paramBaseScanRequest);
      h.CyF.a(20275, new Object[] { localo.first, localo.second, dRM, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l3), Long.valueOf(l1) });
      if ((paramInt3 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        h.CyF.dN(1259, 108);
      }
      AppMethodBeat.o(240473);
      return;
      l1 = l2;
      if (paramInt3 == 2)
      {
        l1 = l2;
        if (CGR > 0L)
        {
          l1 = l3 - CGR;
          CGR = 0L;
        }
      }
    }
  }
  
  public static final void e(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240474);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.CyF.dN(1259, 109);
    }
    AppMethodBeat.o(240474);
  }
  
  public static final void eQg()
  {
    AppMethodBeat.i(52220);
    dRM = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  public static final String eQh()
  {
    return dRM;
  }
  
  private static b eQi()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)CGM.get(Integer.valueOf(12));
    String str = (String)CGL.get(Integer.valueOf(12));
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
        localObject = (b)CGO.get(localObject);
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
  
  public static final void eQj()
  {
    AppMethodBeat.i(52236);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    h.CyF.dN(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void eQk()
  {
    AppMethodBeat.i(52237);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    h.CyF.dN(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void eQl()
  {
    AppMethodBeat.i(161973);
    if (CGP)
    {
      Log.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      h.CyF.dN(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void eQm()
  {
    AppMethodBeat.i(240467);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    h.CyF.dN(1259, 62);
    AppMethodBeat.o(240467);
  }
  
  public static final void eQn()
  {
    AppMethodBeat.i(240468);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    h.CyF.dN(1259, 63);
    AppMethodBeat.o(240468);
  }
  
  public static final void f(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240475);
    p.h(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.CyF.dN(1259, 110);
    }
    AppMethodBeat.o(240475);
  }
  
  public static final void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)dRM).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = JH(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), dRM });
      h.CyF.a(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), dRM });
      AppMethodBeat.o(52221);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
      continue;
      paramInt1 = 4;
    }
  }
  
  public static final void i(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    Log.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    h localh;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localh = h.CyF;
      if (!paramBoolean2) {
        break label67;
      }
    }
    label67:
    for (paramInt = 29;; paramInt = 30)
    {
      localh.dN(1259, paramInt);
      AppMethodBeat.o(161975);
      return;
    }
  }
  
  public static final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)CGM.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = JH(paramInt1);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    h.CyF.a(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240470);
    if (CGQ == null)
    {
      AppMethodBeat.o(240470);
      return;
    }
    Object localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    int i = ((a)localObject1).CGY.size();
    localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    long l1 = ((a)localObject1).CGT;
    localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession: %d, scanSession: %d, chooseIndex: %d, resultOpType: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((a)localObject1).CGU), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject3;
    Object localObject4;
    List localList;
    Object localObject5;
    Object localObject2;
    if (!((a)localObject1).gqx)
    {
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      ((a)localObject1).CGV = paramInt2;
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      ((a)localObject1).gqx = true;
      localObject3 = (List)new ArrayList();
      localObject4 = (List)new ArrayList();
      localList = (List)new ArrayList();
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject5 = ((Iterable)((a)localObject1).CGY).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (WxQBarResult)((Iterator)localObject5).next();
        if (localObject1 != null)
        {
          localObject2 = URLEncoder.encode(((WxQBarResult)localObject1).data, "utf-8");
          p.g(localObject2, "URLEncoder.encode(codeResult.data, \"utf-8\")");
          ((List)localObject3).add(localObject2);
          ((List)localObject4).add(Integer.valueOf(((WxQBarResult)localObject1).priorityLevel));
          localObject2 = ((WxQBarResult)localObject1).typeName;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localList.add(localObject1);
        }
      }
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((a)localObject1).CGW <= 0L) {
        break label755;
      }
      l1 = System.currentTimeMillis();
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
    }
    label755:
    for (localObject1 = String.valueOf(l1 - ((a)localObject1).CGW);; localObject1 = "")
    {
      localObject5 = h.CyF;
      localObject2 = CGQ;
      if (localObject2 == null) {
        p.hyc();
      }
      l1 = ((a)localObject2).CGU;
      localObject2 = CGQ;
      if (localObject2 == null) {
        p.hyc();
      }
      i = ((a)localObject2).CGY.size();
      String str1 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
      localObject3 = (String)j.L((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject4 = (Integer)j.L((List)localObject4, paramInt2);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = Integer.valueOf(0);
      }
      localObject4 = CGQ;
      if (localObject4 == null) {
        p.hyc();
      }
      long l2 = ((a)localObject4).CGZ;
      localObject4 = CGQ;
      if (localObject4 == null) {
        p.hyc();
      }
      long l3 = ((a)localObject4).CGT;
      localObject4 = j.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode typeName: ".concat(String.valueOf(localObject4)));
      ((h)localObject5).a(19332, new Object[] { Long.valueOf(l1), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject2, localObject3, Long.valueOf(l2), Long.valueOf(l3), localObject4, localObject1 });
      AppMethodBeat.o(240470);
      return;
    }
  }
  
  public static final void ic(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240471);
    if (CGQ == null)
    {
      AppMethodBeat.o(240471);
      return;
    }
    Object localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    long l = ((a)localObject1).CGT;
    localObject1 = CGQ;
    if (localObject1 == null) {
      p.hyc();
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCodeOp tabSession:  %d, scanSession: %d, resultOpType: %d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject1).CGU), Integer.valueOf(paramInt1) });
    if (paramInt1 == 4)
    {
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      ((a)localObject1).CGX = System.currentTimeMillis();
    }
    Object localObject2;
    if ((paramInt1 == 6) || (paramInt1 == 5))
    {
      l = System.currentTimeMillis();
      localObject1 = CGQ;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = String.valueOf(l - ((a)localObject1).CGX);
      localObject2 = h.CyF;
      a locala = CGQ;
      if (locala == null) {
        p.hyc();
      }
      l = locala.CGU;
      locala = CGQ;
      if (locala == null) {
        p.hyc();
      }
      ((h)localObject2).a(19332, new Object[] { Long.valueOf(l), Integer.valueOf(0), "", "", Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(locala.CGT), "", localObject1 });
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240471);
      return;
      if (paramInt1 == 7)
      {
        localObject2 = Wz(paramInt2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
      }
      localObject1 = "";
      break;
      h.CyF.dN(1259, 64);
      AppMethodBeat.o(240471);
      return;
      h.CyF.dN(1259, 65);
      AppMethodBeat.o(240471);
      return;
      h.CyF.dN(1259, 66);
    }
  }
  
  public static final void tO(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    x.a((y)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void tP(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    Log.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    CGP = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "showInfoViewTimestamp", "getShowInfoViewTimestamp", "setShowInfoViewTimestamp", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
  static final class a
  {
    long CGT;
    long CGU;
    int CGV;
    long CGW;
    long CGX;
    final List<WxQBarResult> CGY;
    final long CGZ;
    boolean gqx;
    
    public a(List<? extends WxQBarResult> paramList, long paramLong)
    {
      AppMethodBeat.i(240459);
      this.CGY = paramList;
      this.CGZ = paramLong;
      this.CGV = -1;
      AppMethodBeat.o(240459);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(240462);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.CGY, paramObject.CGY)) || (this.CGZ != paramObject.CGZ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(240462);
        return true;
      }
      AppMethodBeat.o(240462);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(240461);
      List localList = this.CGY;
      if (localList != null) {}
      for (int i = localList.hashCode();; i = 0)
      {
        long l = this.CGZ;
        int j = (int)(l ^ l >>> 32);
        AppMethodBeat.o(240461);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(240460);
      String str = "ScanMultiCodeReportInfo(codeResultList=" + this.CGY + ", scanCost=" + this.CGZ + ")";
      AppMethodBeat.o(240460);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    String CHa = "";
    String CHb = "";
    long CHc;
    long CHd;
    long CHe;
    long CHf;
    long CHg;
    boolean CHh;
    int gmJ;
    int source;
    long wNg;
    
    public final void aMB(String paramString)
    {
      AppMethodBeat.i(52215);
      p.h(paramString, "<set-?>");
      this.CHa = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void aMC(String paramString)
    {
      AppMethodBeat.i(52216);
      p.h(paramString, "<set-?>");
      this.CHb = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = ae.SYK;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.CHa, this.CHb, Long.valueOf(this.CHc), Long.valueOf(this.CHd), Long.valueOf(this.CHe), Integer.valueOf(this.gmJ) }, 6));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements y
  {
    c(boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(52219);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52218);
          af localaf = af.CGS;
          af.f(this.CHk.CHi, this.CHl, this.CHk.CHj);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.af
 * JD-Core Version:    0.7.0.1
 */