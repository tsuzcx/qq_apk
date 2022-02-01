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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_CANCEL_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_CLICK_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_JUMP_SCAN_GOODS_SUCCESS", "RESULT_OP_TYPE_SHOW_JUMP_SCAN_GOODS_TIPS", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getScanGoodsReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "reportMultiCodeCancel", "reportMultiCodeClick", "reportMultiCodeOp", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "scene", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanGoodsScene", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class ad
{
  private static HashMap<Integer, String> ILW;
  private static HashMap<Integer, String> ILX;
  private static HashMap<Integer, Integer> ILY;
  private static HashMap<String, b> ILZ;
  private static boolean IMa;
  private static a IMb;
  private static long IMc;
  public static final ad IMd;
  private static String fLj;
  
  static
  {
    AppMethodBeat.i(52238);
    IMd = new ad();
    fLj = "";
    ILW = new HashMap();
    ILX = new HashMap();
    ILY = new HashMap();
    ILZ = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  private static int OH(int paramInt)
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
  
  public static final void PS(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = fDe();
    if (localb != null) {
      localb.IMn = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void PT(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = fDe();
    if (localb != null) {
      localb.IMo = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
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
    AppMethodBeat.i(220597);
    b localb = fDe();
    if (localb == null)
    {
      AppMethodBeat.o(220597);
      return;
    }
    localb.iQS = paramInt2;
    if (localb.IMo > localb.IMn) {
      localb.IMp = (localb.IMo - localb.IMn);
    }
    if (localb.IMp > 0L)
    {
      paramBaseScanRequest = b(paramBaseScanRequest);
      Log.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt1), paramBaseScanRequest.Mx, paramBaseScanRequest.My });
      h.IzE.a(18560, new Object[] { localb.IMl, localb.IMm, Long.valueOf(localb.IMn), Long.valueOf(localb.IMo), Long.valueOf(localb.IMp), Integer.valueOf(localb.iQS), Integer.valueOf(paramInt1), paramBaseScanRequest.Mx, paramBaseScanRequest.My, fLj });
    }
    ((Map)ILW).put(Integer.valueOf(12), "");
    AppMethodBeat.o(220597);
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3)
  {
    AppMethodBeat.i(220585);
    String str1 = (String)ILX.get(Integer.valueOf(12));
    String str2 = (String)ILW.get(Integer.valueOf(12));
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
      AppMethodBeat.o(220585);
      return;
      i = 0;
      break;
    }
    label117:
    paramInt2 = ady(paramInt2);
    paramBaseScanRequest = b(paramBaseScanRequest);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, scene: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", new Object[] { Integer.valueOf(18558), Integer.valueOf(paramInt1), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.IzE.a(18558, new Object[] { str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramBaseScanRequest.Mx, paramBaseScanRequest.My, fLj });
    AppMethodBeat.o(220585);
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(220699);
    p.k(paramList, "codeResultList");
    IMb = new a(paramList, paramLong);
    try
    {
      paramList = IMb;
      String str;
      if (paramList != null)
      {
        str = adv(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.IMe = paramLong;
        }
      }
      else
      {
        paramList = IMb;
        if (paramList != null)
        {
          str = adx(paramInt);
          if (str == null) {
            break label114;
          }
        }
      }
      label114:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.IMf = paramLong;
        paramList = IMb;
        if (paramList == null) {
          break label121;
        }
        paramList.IMh = System.currentTimeMillis();
        AppMethodBeat.o(220699);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label121:
      AppMethodBeat.o(220699);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(220699);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h localh;
    if (adF(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        h.IzE.el(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localh = h.IzE;
        paramInt1 = 60;
      }
    }
    for (;;)
    {
      localh.el(1259, paramInt1);
      label102:
      label125:
      do
      {
        AppMethodBeat.o(170038);
        return;
        if (paramInt3 > 1) {
          h.IzE.el(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localh = h.IzE;
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
    b localb = fDe();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.IMr = paramLong;
    localb.IMt = paramBoolean1;
    localb.source = ady(paramInt);
    if ((localb.IMq > 0L) && (localb.IMr > 0L)) {
      localb.IMs = (localb.IMr - localb.IMq);
    }
    int i;
    if ((localb.IMs > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.IMl, localb.IMm, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.IMs), Integer.valueOf(i) });
      h.IzE.a(18724, new Object[] { localb.IMl, localb.IMm, Integer.valueOf(localb.source), Integer.valueOf(i), Long.valueOf(localb.IMs) });
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
    if (!IMa)
    {
      Log.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      h.IzE.el(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        h.IzE.el(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          h.IzE.el(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          h.IzE.el(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          h.IzE.el(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          h.IzE.el(1259, 26);
        } else if (paramLong >= 5000L) {
          h.IzE.el(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          h.IzE.el(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          h.IzE.el(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          h.IzE.el(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          h.IzE.el(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          h.IzE.el(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = fDe();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.IMq = paramLong;
    Log.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.IMl, localb.IMm, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  public static final void adA(int paramInt)
  {
    AppMethodBeat.i(170036);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (adF(paramInt))
    {
      localInteger = (Integer)ILY.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)ILY).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        h.IzE.el(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)ILY.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)ILY).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      h.IzE.el(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void adB(int paramInt)
  {
    AppMethodBeat.i(170037);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (adF(paramInt))
    {
      localInteger = (Integer)ILY.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)ILY).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      h.IzE.el(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)ILY.get(Integer.valueOf(paramInt));
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
    ((Map)ILY).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    h.IzE.el(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void adC(int paramInt)
  {
    AppMethodBeat.i(170040);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (adF(paramInt))
    {
      h.IzE.el(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      h.IzE.el(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void adD(int paramInt)
  {
    AppMethodBeat.i(170041);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (adF(paramInt))
    {
      h.IzE.el(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      h.IzE.el(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void adE(int paramInt)
  {
    AppMethodBeat.i(170042);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (adF(paramInt))
    {
      h.IzE.el(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      h.IzE.el(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean adF(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static final void adu(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)ILX).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), ILX.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String adv(int paramInt)
  {
    AppMethodBeat.i(220572);
    String str = (String)ILX.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(220572);
    return str;
  }
  
  public static final void adw(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!adF(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)ILW).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), ILW.get(Integer.valueOf(paramInt)) });
    String str1 = (String)ILX.get(Integer.valueOf(paramInt));
    String str2 = (String)ILW.get(Integer.valueOf(paramInt));
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
      localb = (b)ILZ.get(str3);
      if (localb != null) {
        break label263;
      }
      localb = new b();
      localb.aXi(str1);
      localb.aXj(str2);
      ((Map)ILZ).put(str3, localb);
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
    localb.IMl = "";
    localb.IMm = "";
    localb.IMn = 0L;
    localb.IMo = 0L;
    localb.IMp = 0L;
    localb.iQS = 0;
    localb.IMq = 0L;
    localb.IMr = 0L;
    localb.IMs = 0L;
    localb.source = 0;
    localb.IMt = false;
    localb.aXi(str1);
    localb.aXj(str2);
    label343:
    AppMethodBeat.o(52224);
  }
  
  public static final String adx(int paramInt)
  {
    AppMethodBeat.i(220580);
    String str = (String)ILW.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(220580);
    return str;
  }
  
  private static int ady(int paramInt)
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
  
  public static final void adz(int paramInt)
  {
    AppMethodBeat.i(161056);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      h.IzE.el(1259, 20);
      h.IzE.el(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      h.IzE.el(1259, 20);
      h.IzE.el(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  public static final void ae(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localh = h.IzE;
        paramInt = 102;
      }
    }
    for (;;)
    {
      localh.el(1259, paramInt);
      do
      {
        AppMethodBeat.o(170039);
        return;
      } while (paramInt != 2);
      localh = h.IzE;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
  }
  
  private static o<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(220764);
    label148:
    for (;;)
    {
      try
      {
        if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
        {
          String str = paramBaseScanRequest.getExtra("key_sns_ad_ux_info", "");
          p.j(str, "bizInfo");
          paramBaseScanRequest = (String)j.M(n.a((CharSequence)str, new String[] { "|" }), 1);
          if (paramBaseScanRequest != null) {
            break label148;
          }
          paramBaseScanRequest = "";
          Log.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new o(paramBaseScanRequest, str);
          AppMethodBeat.o(220764);
          return paramBaseScanRequest;
        }
      }
      catch (Exception paramBaseScanRequest)
      {
        Log.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
        paramBaseScanRequest = new o("", "");
        AppMethodBeat.o(220764);
        return paramBaseScanRequest;
      }
    }
  }
  
  public static final void b(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3)
  {
    AppMethodBeat.i(220750);
    paramInt2 = OH(paramInt2);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt3 == 1)
    {
      IMc = l3;
      l1 = l2;
    }
    for (;;)
    {
      o localo = b(paramBaseScanRequest);
      h.IzE.a(20275, new Object[] { localo.Mx, localo.My, fLj, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l3), Long.valueOf(l1) });
      if ((paramInt3 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        h.IzE.el(1259, 108);
      }
      AppMethodBeat.o(220750);
      return;
      l1 = l2;
      if (paramInt3 == 2)
      {
        l1 = l2;
        if (IMc > 0L)
        {
          l1 = l3 - IMc;
          IMc = 0L;
        }
      }
    }
  }
  
  public static final void e(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(220751);
    p.k(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.IzE.el(1259, 109);
    }
    AppMethodBeat.o(220751);
  }
  
  public static final void f(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(220755);
    p.k(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.IzE.el(1259, 110);
    }
    AppMethodBeat.o(220755);
  }
  
  public static final void fDc()
  {
    AppMethodBeat.i(52220);
    fLj = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  public static final String fDd()
  {
    return fLj;
  }
  
  private static b fDe()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)ILX.get(Integer.valueOf(12));
    String str = (String)ILW.get(Integer.valueOf(12));
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
        localObject = (b)ILZ.get(localObject);
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
  
  public static final void fDf()
  {
    AppMethodBeat.i(52236);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    h.IzE.el(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void fDg()
  {
    AppMethodBeat.i(52237);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    h.IzE.el(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void fDh()
  {
    AppMethodBeat.i(161973);
    if (IMa)
    {
      Log.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      h.IzE.el(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void fDi()
  {
    AppMethodBeat.i(220679);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    h.IzE.el(1259, 62);
    AppMethodBeat.o(220679);
  }
  
  public static final void fDj()
  {
    AppMethodBeat.i(220682);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    h.IzE.el(1259, 63);
    AppMethodBeat.o(220682);
  }
  
  public static final void jd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)fLj).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = OH(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), fLj });
      h.IzE.a(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), fLj });
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
  
  public static final void je(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)ILX.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = OH(paramInt1);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    h.IzE.a(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void jf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220719);
    if (IMb == null)
    {
      AppMethodBeat.o(220719);
      return;
    }
    Object localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    int i = ((a)localObject1).IMj.size();
    localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    long l1 = ((a)localObject1).IMe;
    localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession: %d, scanSession: %d, chooseIndex: %d, resultOpType: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((a)localObject1).IMf), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    Object localObject3;
    Object localObject4;
    List localList;
    Object localObject5;
    Object localObject2;
    if (!((a)localObject1).iUF)
    {
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      ((a)localObject1).IMg = paramInt2;
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      ((a)localObject1).iUF = true;
      localObject3 = (List)new ArrayList();
      localObject4 = (List)new ArrayList();
      localList = (List)new ArrayList();
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject5 = ((Iterable)((a)localObject1).IMj).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (WxQBarResult)((Iterator)localObject5).next();
        if (localObject1 != null)
        {
          localObject2 = URLEncoder.encode(((WxQBarResult)localObject1).data, "utf-8");
          p.j(localObject2, "URLEncoder.encode(codeResult.data, \"utf-8\")");
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
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((a)localObject1).IMh <= 0L) {
        break label763;
      }
      l1 = System.currentTimeMillis();
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
    }
    label763:
    for (localObject1 = String.valueOf(l1 - ((a)localObject1).IMh);; localObject1 = "")
    {
      localObject5 = h.IzE;
      localObject2 = IMb;
      if (localObject2 == null) {
        p.iCn();
      }
      l1 = ((a)localObject2).IMf;
      localObject2 = IMb;
      if (localObject2 == null) {
        p.iCn();
      }
      i = ((a)localObject2).IMj.size();
      String str1 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
      localObject3 = (String)j.M((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject4 = (Integer)j.M((List)localObject4, paramInt2);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = Integer.valueOf(0);
      }
      localObject4 = IMb;
      if (localObject4 == null) {
        p.iCn();
      }
      long l2 = ((a)localObject4).IMk;
      localObject4 = IMb;
      if (localObject4 == null) {
        p.iCn();
      }
      long l3 = ((a)localObject4).IMe;
      localObject4 = j.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode typeName: ".concat(String.valueOf(localObject4)));
      ((h)localObject5).a(19332, new Object[] { Long.valueOf(l1), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject2, localObject3, Long.valueOf(l2), Long.valueOf(l3), localObject4, localObject1, Integer.valueOf(3) });
      AppMethodBeat.o(220719);
      return;
    }
  }
  
  public static final void jg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220737);
    if (IMb == null)
    {
      AppMethodBeat.o(220737);
      return;
    }
    Object localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    long l = ((a)localObject1).IMe;
    localObject1 = IMb;
    if (localObject1 == null) {
      p.iCn();
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCodeOp tabSession:  %d, scanSession: %d, resultOpType: %d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject1).IMf), Integer.valueOf(paramInt1) });
    if (paramInt1 == 4)
    {
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      ((a)localObject1).IMi = System.currentTimeMillis();
    }
    Object localObject2;
    if ((paramInt1 == 6) || (paramInt1 == 5))
    {
      l = System.currentTimeMillis();
      localObject1 = IMb;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = String.valueOf(l - ((a)localObject1).IMi);
      localObject2 = h.IzE;
      a locala = IMb;
      if (locala == null) {
        p.iCn();
      }
      l = locala.IMf;
      locala = IMb;
      if (locala == null) {
        p.iCn();
      }
      ((h)localObject2).a(19332, new Object[] { Long.valueOf(l), Integer.valueOf(0), "", "", Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(locala.IMe), "", localObject1, Integer.valueOf(3) });
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220737);
      return;
      if (paramInt1 == 7)
      {
        localObject2 = adv(paramInt2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
      }
      localObject1 = "";
      break;
      h.IzE.el(1259, 64);
      AppMethodBeat.o(220737);
      return;
      h.IzE.el(1259, 65);
      AppMethodBeat.o(220737);
      return;
      h.IzE.el(1259, 66);
    }
  }
  
  public static final void l(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    Log.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    h localh;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localh = h.IzE;
      if (!paramBoolean2) {
        break label67;
      }
    }
    label67:
    for (paramInt = 29;; paramInt = 30)
    {
      localh.el(1259, paramInt);
      AppMethodBeat.o(161975);
      return;
    }
  }
  
  public static final void xl(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    v.a((w)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    Log.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    IMa = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "showInfoViewTimestamp", "getShowInfoViewTimestamp", "setShowInfoViewTimestamp", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
  static final class a
  {
    long IMe;
    long IMf;
    int IMg;
    long IMh;
    long IMi;
    final List<WxQBarResult> IMj;
    final long IMk;
    boolean iUF;
    
    public a(List<? extends WxQBarResult> paramList, long paramLong)
    {
      AppMethodBeat.i(223185);
      this.IMj = paramList;
      this.IMk = paramLong;
      this.IMg = -1;
      AppMethodBeat.o(223185);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223195);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.IMj, paramObject.IMj)) || (this.IMk != paramObject.IMk)) {}
        }
      }
      else
      {
        AppMethodBeat.o(223195);
        return true;
      }
      AppMethodBeat.o(223195);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(223193);
      List localList = this.IMj;
      if (localList != null) {}
      for (int i = localList.hashCode();; i = 0)
      {
        long l = this.IMk;
        int j = (int)(l ^ l >>> 32);
        AppMethodBeat.o(223193);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223187);
      String str = "ScanMultiCodeReportInfo(codeResultList=" + this.IMj + ", scanCost=" + this.IMk + ")";
      AppMethodBeat.o(223187);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    String IMl = "";
    String IMm = "";
    long IMn;
    long IMo;
    long IMp;
    long IMq;
    long IMr;
    long IMs;
    boolean IMt;
    int iQS;
    int source;
    
    public final void aXi(String paramString)
    {
      AppMethodBeat.i(52215);
      p.k(paramString, "<set-?>");
      this.IMl = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void aXj(String paramString)
    {
      AppMethodBeat.i(52216);
      p.k(paramString, "<set-?>");
      this.IMm = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = af.aaBG;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.IMl, this.IMm, Long.valueOf(this.IMn), Long.valueOf(this.IMo), Long.valueOf(this.IMp), Integer.valueOf(this.iQS) }, 6));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements w
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
          ad localad = ad.IMd;
          ad.g(this.IMw.IMu, this.IMx, this.IMw.IMv);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ad
 * JD-Core Version:    0.7.0.1
 */