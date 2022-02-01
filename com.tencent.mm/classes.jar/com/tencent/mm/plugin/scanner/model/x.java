package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.WxQBarResult;
import d.a.j;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "REPORT_CODE_TYPE_BLACK", "", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "", "finishScanGoods", "source", "success", "isCancelled", "getCurrentScanSession", "getCurrentTabSession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "scanCost", "reportMultiCodeCancel", "reportMultiCodeClick", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResult", "reportScanOperation", "op", "reportScanSuccessResult", "reportScanTabSelected", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "showScanResult", "startScanGoods", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class x
{
  private static String dpw;
  private static HashMap<Integer, String> vPp;
  private static HashMap<Integer, String> vPq;
  private static HashMap<Integer, Integer> vPr;
  private static HashMap<String, b> vPs;
  private static boolean vPt;
  private static x.a vPu;
  public static final x vPv;
  
  static
  {
    AppMethodBeat.i(52238);
    vPv = new x();
    dpw = "";
    vPp = new HashMap();
    vPq = new HashMap();
    vPr = new HashMap();
    vPs = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void KQ(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)vPq).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ad.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), vPq.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String KR(int paramInt)
  {
    AppMethodBeat.i(195447);
    String str = (String)vPq.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(195447);
    return str;
  }
  
  public static final void KS(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!Le(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)vPp).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    ad.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), vPp.get(Integer.valueOf(paramInt)) });
    String str1 = (String)vPq.get(Integer.valueOf(paramInt));
    String str2 = (String)vPp.get(Integer.valueOf(paramInt));
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
      localb = (b)vPs.get(str3);
      if (localb != null) {
        break label256;
      }
      localb = new b();
      localb.amy(str1);
      localb.amz(str2);
      ((Map)vPs).put(str3, localb);
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
    localb.vPB = "";
    localb.vPC = "";
    localb.vPD = 0L;
    localb.vPE = 0L;
    localb.vPF = 0L;
    localb.fjS = 0;
    localb.vPG = 0L;
    localb.vPH = 0L;
    localb.rfP = 0L;
    localb.dep = 0;
    localb.vPI = false;
    localb.amy(str1);
    localb.amz(str2);
    label336:
    AppMethodBeat.o(52224);
  }
  
  public static final String KT(int paramInt)
  {
    AppMethodBeat.i(195448);
    String str = (String)vPp.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(195448);
    return str;
  }
  
  public static final void KU(int paramInt)
  {
    AppMethodBeat.i(52226);
    String str1 = (String)vPq.get(Integer.valueOf(12));
    String str2 = (String)vPp.get(Integer.valueOf(12));
    CharSequence localCharSequence = (CharSequence)str1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)str2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label102;
        }
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label107;
      }
      AppMethodBeat.o(52226);
      return;
      i = 0;
      break;
    }
    label107:
    paramInt = KX(paramInt);
    ad.d("MicroMsg.ScanReporter", "alvinluo reportScanSuccessResult logId: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s", new Object[] { Integer.valueOf(18558), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt) });
    h.vKh.f(18558, new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(52226);
  }
  
  public static final void KV(int paramInt)
  {
    AppMethodBeat.i(52229);
    b localb = dlD();
    if (localb == null)
    {
      AppMethodBeat.o(52229);
      return;
    }
    localb.fjS = paramInt;
    if (localb.vPE > localb.vPD) {
      localb.vPF = (localb.vPE - localb.vPD);
    }
    if (localb.vPF > 0L)
    {
      ad.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, info: %s", new Object[] { Integer.valueOf(18560), localb });
      h.vKh.f(18560, new Object[] { localb.vPB, localb.vPC, Long.valueOf(localb.vPD), Long.valueOf(localb.vPE), Long.valueOf(localb.vPF), Integer.valueOf(localb.fjS) });
    }
    ((Map)vPp).put(Integer.valueOf(12), "");
    AppMethodBeat.o(52229);
  }
  
  private static int KW(int paramInt)
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
  
  private static int KX(int paramInt)
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
  
  public static final void KY(int paramInt)
  {
    AppMethodBeat.i(161056);
    ad.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      h.vKh.dB(1259, 20);
      h.vKh.dB(1259, 21);
      AppMethodBeat.o(161056);
      return;
    }
    if (paramInt == 2)
    {
      h.vKh.dB(1259, 20);
      h.vKh.dB(1259, 22);
    }
    AppMethodBeat.o(161056);
  }
  
  public static final void KZ(int paramInt)
  {
    AppMethodBeat.i(170036);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Le(paramInt))
    {
      localInteger = (Integer)vPr.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ((Map)vPr).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        h.vKh.dB(1259, 50);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12)
    {
      AppMethodBeat.o(170036);
      return;
    }
    Integer localInteger = (Integer)vPr.get(Integer.valueOf(paramInt));
    if (localInteger == null) {}
    for (;;)
    {
      ((Map)vPr).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      h.vKh.dB(1259, 100);
      break;
      if (localInteger.intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localh = h.vKh;
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
      localh = h.vKh;
      if (paramBoolean) {
        paramInt = 106;
      } else {
        paramInt = 107;
      }
    }
  }
  
  public static final void La(int paramInt)
  {
    AppMethodBeat.i(170037);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger;
    if (Le(paramInt))
    {
      localInteger = (Integer)vPr.get(Integer.valueOf(paramInt));
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        ad.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)vPr).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      h.vKh.dB(1259, 51);
      AppMethodBeat.o(170037);
      return;
    }
    if (paramInt == 12)
    {
      localInteger = (Integer)vPr.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        break label150;
      }
    }
    label150:
    while (localInteger.intValue() != 1)
    {
      ad.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)vPr).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    h.vKh.dB(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void Lb(int paramInt)
  {
    AppMethodBeat.i(170040);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Le(paramInt))
    {
      h.vKh.dB(1259, 55);
      AppMethodBeat.o(170040);
      return;
    }
    if (paramInt == 12) {
      h.vKh.dB(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void Lc(int paramInt)
  {
    AppMethodBeat.i(170041);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Le(paramInt))
    {
      h.vKh.dB(1259, 56);
      AppMethodBeat.o(170041);
      return;
    }
    if (paramInt == 12) {
      h.vKh.dB(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void Ld(int paramInt)
  {
    AppMethodBeat.i(170042);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (Le(paramInt))
    {
      h.vKh.dB(1259, 57);
      AppMethodBeat.o(170042);
      return;
    }
    if (paramInt == 12) {
      h.vKh.dB(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean Le(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(195451);
    k.h(paramList, "codeResultList");
    vPu = new x.a(paramList, paramLong);
    try
    {
      paramList = vPu;
      String str;
      if (paramList != null)
      {
        str = KR(paramInt);
        if (str != null)
        {
          paramLong = Long.parseLong(str);
          paramList.vPw = paramLong;
        }
      }
      else
      {
        paramList = vPu;
        if (paramList == null) {
          break label106;
        }
        str = KT(paramInt);
        if (str == null) {
          break label99;
        }
      }
      label99:
      for (paramLong = Long.parseLong(str);; paramLong = System.currentTimeMillis())
      {
        paramList.vPx = paramLong;
        AppMethodBeat.o(195451);
        return;
        paramLong = System.currentTimeMillis();
        break;
      }
      label106:
      AppMethodBeat.o(195451);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(195451);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h localh;
    if (Le(paramInt1))
    {
      if (paramInt2 != 1) {
        break label125;
      }
      if (paramBoolean)
      {
        h.vKh.dB(1259, 52);
        if (paramInt3 != 1) {
          break label102;
        }
        localh = h.vKh;
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
          h.vKh.dB(1259, 61);
        }
        AppMethodBeat.o(170038);
        return;
      } while (paramInt2 != 2);
      localh = h.vKh;
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
    b localb = dlD();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.vPH = paramLong;
    localb.vPI = paramBoolean1;
    localb.dep = KX(paramInt);
    if ((localb.vPG > 0L) && (localb.vPH > 0L)) {
      localb.rfP = (localb.vPH - localb.vPG);
    }
    int i;
    if ((localb.rfP > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label251;
      }
      i = 3;
    }
    for (;;)
    {
      ad.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.vPB, localb.vPC, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.rfP), Integer.valueOf(i) });
      h.vKh.f(18724, new Object[] { localb.vPB, localb.vPC, Integer.valueOf(localb.dep), Integer.valueOf(i), Long.valueOf(localb.rfP) });
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
    if (!vPt)
    {
      ad.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      h.vKh.dB(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        h.vKh.dB(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          h.vKh.dB(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          h.vKh.dB(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          h.vKh.dB(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          h.vKh.dB(1259, 26);
        } else if (paramLong >= 5000L) {
          h.vKh.dB(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          h.vKh.dB(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          h.vKh.dB(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          h.vKh.dB(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          h.vKh.dB(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          h.vKh.dB(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void ar(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = dlD();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.vPG = paramLong;
    ad.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.vPB, localb.vPC, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  public static final void dlC()
  {
    AppMethodBeat.i(52220);
    dpw = String.valueOf(System.currentTimeMillis());
    AppMethodBeat.o(52220);
  }
  
  private static b dlD()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)vPq.get(Integer.valueOf(12));
    String str = (String)vPp.get(Integer.valueOf(12));
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
        localObject = (b)vPs.get(localObject);
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
  
  public static final void dlE()
  {
    AppMethodBeat.i(52236);
    ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    h.vKh.dB(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void dlF()
  {
    AppMethodBeat.i(52237);
    ad.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    h.vKh.dB(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void dlG()
  {
    AppMethodBeat.i(161973);
    if (vPt)
    {
      ad.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      h.vKh.dB(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void dlH()
  {
    AppMethodBeat.i(195449);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    h.vKh.dB(1259, 62);
    AppMethodBeat.o(195449);
  }
  
  public static final void dlI()
  {
    AppMethodBeat.i(195450);
    ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    h.vKh.dB(1259, 63);
    AppMethodBeat.o(195450);
  }
  
  public static final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    ad.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    h localh;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localh = h.vKh;
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
  
  public static final void gN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    if (((CharSequence)dpw).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52221);
      return;
    }
    i = KW(paramInt1);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      ad.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), dpw });
      h.vKh.f(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), dpw });
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
  
  public static final void gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52230);
    String str = (String)vPq.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52230);
      return;
    }
    i = KW(paramInt1);
    ad.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    h.vKh.f(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(52230);
  }
  
  public static final void k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(195452);
    if (vPu == null)
    {
      AppMethodBeat.o(195452);
      return;
    }
    Object localObject1 = vPu;
    if (localObject1 == null) {
      k.fvU();
    }
    int i = ((x.a)localObject1).vPz.size();
    localObject1 = vPu;
    if (localObject1 == null) {
      k.fvU();
    }
    long l = ((x.a)localObject1).vPw;
    localObject1 = vPu;
    if (localObject1 == null) {
      k.fvU();
    }
    ad.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession:  %d, scanSession: %d, chooseIndex: %d, resultOpType: %d, scanCost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Long.valueOf(((x.a)localObject1).vPx), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    localObject1 = vPu;
    if (localObject1 == null) {
      k.fvU();
    }
    if (!((x.a)localObject1).fnG)
    {
      localObject1 = vPu;
      if (localObject1 == null) {
        k.fvU();
      }
      ((x.a)localObject1).vPy = paramInt2;
      localObject1 = vPu;
      if (localObject1 == null) {
        k.fvU();
      }
      ((x.a)localObject1).fnG = true;
      localObject1 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      Object localObject2 = vPu;
      if (localObject2 == null) {
        k.fvU();
      }
      localObject2 = ((Iterable)((x.a)localObject2).vPz).iterator();
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
      Object localObject4 = h.vKh;
      localObject2 = vPu;
      if (localObject2 == null) {
        k.fvU();
      }
      paramLong = ((x.a)localObject2).vPw;
      localObject2 = vPu;
      if (localObject2 == null) {
        k.fvU();
      }
      i = ((x.a)localObject2).vPz.size();
      String str1 = j.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62);
      ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(str1)));
      String str2 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      ad.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(str2)));
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
      localObject3 = vPu;
      if (localObject3 == null) {
        k.fvU();
      }
      l = ((x.a)localObject3).vPA;
      localObject3 = vPu;
      if (localObject3 == null) {
        k.fvU();
      }
      ((h)localObject4).f(19332, new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), localObject1, localObject2, Long.valueOf(l), Long.valueOf(((x.a)localObject3).vPw) });
      vPu = null;
    }
    AppMethodBeat.o(195452);
  }
  
  public static final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    s.a((t)new c(paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    ad.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    vPt = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  public static final void rZ(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = dlD();
    if (localb != null) {
      localb.vPD = paramLong;
    }
    ad.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void sa(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = dlD();
    if (localb != null) {
      localb.vPE = paramLong;
    }
    ad.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
  static final class b
  {
    int dep;
    int fjS;
    long rfP;
    String vPB = "";
    String vPC = "";
    long vPD;
    long vPE;
    long vPF;
    long vPG;
    long vPH;
    boolean vPI;
    
    public final void amy(String paramString)
    {
      AppMethodBeat.i(52215);
      k.h(paramString, "<set-?>");
      this.vPB = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void amz(String paramString)
    {
      AppMethodBeat.i(52216);
      k.h(paramString, "<set-?>");
      this.vPC = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = z.Jhz;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.vPB, this.vPC, Long.valueOf(this.vPD), Long.valueOf(this.vPE), Long.valueOf(this.vPF), Integer.valueOf(this.fjS) }, 6));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements t
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
          x localx = x.vPv;
          x.h(this.vPL.vPJ, this.vPM, this.vPL.vPK);
          AppMethodBeat.o(52218);
        }
      });
      AppMethodBeat.o(52219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.x
 * JD-Core Version:    0.7.0.1
 */