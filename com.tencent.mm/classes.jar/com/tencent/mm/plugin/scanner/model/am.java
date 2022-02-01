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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "MASK_EXTRA_INFO_BACK_PRESS", "MASK_EXTRA_INFO_BACK_PRESS_BY_GESTURE", "MASK_EXTRA_INFO_CLICK_CANCEL_BTN", "MASK_EXTRA_INFO_CLICK_OUTSIDE", "MASK_EXTRA_INFO_DEFAULT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_CANCEL_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_CLICK_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_JUMP_SCAN_GOODS_SUCCESS", "RESULT_OP_TYPE_SHOW_JUMP_SCAN_GOODS_TIPS", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "enableScanCodeProductMerge", "", "hasCameraPermission", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", "timestamp", "finishScanGoods", "source", "success", "isCancelled", "getActionResultStr", "currentCardIndex", "totalCardCount", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getScanGoodsReportScene", "getTabAction", "tabSelectedAction", "getTabType", "productCombine", "isScanCode", "reportAddScanProduct", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "reportMultiCodeCancel", "reportMultiCodeClick", "reportMultiCodeOp", "maskExtraInfo", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRGBA2WxamFailed", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanCombineAction", "enterScene", "actionType", "tabEnterTs", "detectSession", "scanImageType", "itemSource", "itemType", "cardType", "cardTitle", "preloadType", "errorCode", "reportScanCombineActionForLoadOrClickProductCard", "status", "reportScanCombineActionForSelectImgFromGallery", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "scene", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanGoodsScene", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
{
  public static final am OTh;
  private static HashMap<Integer, String> OTi;
  private static HashMap<Integer, String> OTj;
  private static HashMap<Integer, Integer> OTk;
  private static HashMap<String, b> OTl;
  private static boolean OTm;
  private static boolean OTn;
  private static am.a OTo;
  private static long OTp;
  private static String hQR;
  
  static
  {
    AppMethodBeat.i(52238);
    OTh = new am();
    hQR = "";
    OTi = new HashMap();
    OTj = new HashMap();
    OTk = new HashMap();
    OTl = new HashMap();
    AppMethodBeat.o(52238);
  }
  
  public static final void BZ(boolean paramBoolean)
  {
    AppMethodBeat.i(314293);
    hQR = String.valueOf(System.currentTimeMillis());
    OTn = paramBoolean;
    AppMethodBeat.o(314293);
  }
  
  public static final void Ca(boolean paramBoolean)
  {
    AppMethodBeat.i(52231);
    ac.a(new am..ExternalSyntheticLambda0(12, paramBoolean));
    AppMethodBeat.o(52231);
  }
  
  public static final void Cb(boolean paramBoolean)
  {
    AppMethodBeat.i(161976);
    Log.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    OTm = paramBoolean;
    AppMethodBeat.o(161976);
  }
  
  public static final void I(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(314303);
    if (((CharSequence)hQR).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(314303);
      return;
    }
    i = bx(paramInt1, paramBoolean);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", new Object[] { Integer.valueOf(18557), Integer.valueOf(i), Integer.valueOf(paramInt1), hQR });
      h.OAn.b(18557, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt1), hQR });
      AppMethodBeat.o(314303);
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
  
  public static final void J(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(314341);
    String str = (String)OTj.get(Integer.valueOf(paramInt1));
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(314341);
      return;
    }
    i = bx(paramInt1, paramBoolean);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", new Object[] { Integer.valueOf(18561), Integer.valueOf(paramInt1), Integer.valueOf(i), str, Integer.valueOf(paramInt2) });
    h.OAn.b(18561, new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(314341);
  }
  
  public static final void K(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(314439);
    if (OTo == null)
    {
      AppMethodBeat.o(314439);
      return;
    }
    Object localObject1 = OTo;
    s.checkNotNull(localObject1);
    int i = ((am.a)localObject1).OTq.size();
    localObject1 = OTo;
    s.checkNotNull(localObject1);
    long l1 = ((am.a)localObject1).OTs;
    localObject1 = OTo;
    s.checkNotNull(localObject1);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession: %d, scanSession: %d, chooseIndex: %d, resultOpType: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(((am.a)localObject1).OTt), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    localObject1 = OTo;
    s.checkNotNull(localObject1);
    Object localObject3;
    Object localObject5;
    Object localObject2;
    int j;
    String str1;
    String str2;
    label556:
    long l2;
    long l3;
    if (!((am.a)localObject1).lwK)
    {
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      ((am.a)localObject1).OTu = paramInt2;
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      ((am.a)localObject1).lwK = true;
      localObject3 = (List)new ArrayList();
      List localList = (List)new ArrayList();
      Object localObject4 = (List)new ArrayList();
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      localObject5 = ((Iterable)((am.a)localObject1).OTq).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (WxQBarResult)((Iterator)localObject5).next();
        if (localObject1 != null)
        {
          localObject2 = URLEncoder.encode(((WxQBarResult)localObject1).data, "utf-8");
          s.s(localObject2, "encode(codeResult.data, \"utf-8\")");
          ((List)localObject3).add(localObject2);
          localList.add(Integer.valueOf(((WxQBarResult)localObject1).priorityLevel));
          localObject2 = ((WxQBarResult)localObject1).typeName;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((List)localObject4).add(localObject1);
        }
      }
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      if (((am.a)localObject1).OTv <= 0L) {
        break label758;
      }
      l1 = System.currentTimeMillis();
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      localObject1 = String.valueOf(l1 - ((am.a)localObject1).OTv);
      localObject5 = h.OAn;
      localObject2 = OTo;
      s.checkNotNull(localObject2);
      l1 = ((am.a)localObject2).OTt;
      localObject2 = OTo;
      s.checkNotNull(localObject2);
      j = ((am.a)localObject2).OTq.size();
      str1 = p.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.i("MicroMsg.ScanReporter", s.X("alvinluo reportMultiCode result: ", str1));
      localObject2 = ah.aiuX;
      str2 = p.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", s.X("alvinluo reportMultiCode type: ", str2));
      localObject2 = ah.aiuX;
      localObject3 = (String)p.ae((List)localObject3, paramInt2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject3 = (Integer)p.ae(localList, paramInt2);
      if (localObject3 != null) {
        break label765;
      }
      paramInt2 = 0;
      localObject3 = OTo;
      s.checkNotNull(localObject3);
      l2 = ((am.a)localObject3).OTr;
      localObject3 = OTo;
      s.checkNotNull(localObject3);
      l3 = ((am.a)localObject3).OTs;
      localObject3 = p.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
      Log.v("MicroMsg.ScanReporter", s.X("alvinluo reportMultiCode typeName: ", localObject3));
      localObject4 = ah.aiuX;
      if (!paramBoolean) {
        break label774;
      }
    }
    label774:
    for (i = 1;; i = 0)
    {
      ((h)localObject5).b(19332, new Object[] { Long.valueOf(l1), Integer.valueOf(j), str1, str2, Integer.valueOf(paramInt1), localObject2, Integer.valueOf(paramInt2), Long.valueOf(l2), Long.valueOf(l3), localObject3, localObject1, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(314439);
      return;
      label758:
      localObject1 = "";
      break;
      label765:
      paramInt2 = ((Integer)localObject3).intValue();
      break label556;
    }
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
  
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, int paramInt6, int paramInt7, int paramInt8, String paramString, int paramInt9)
  {
    AppMethodBeat.i(314448);
    s.u(paramString, "cardTitle");
    if (paramInt6 == 2) {}
    for (paramInt6 = 2;; paramInt6 = 1)
    {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2, paramInt6, paramInt7 + 1, paramInt8, paramString, paramInt9);
      AppMethodBeat.o(314448);
      return;
    }
  }
  
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(314451);
    if (paramInt5 == 2) {}
    for (paramInt5 = 2;; paramInt5 = 1)
    {
      b(paramInt1, paramInt2, paramInt3, 1, paramInt4, paramLong1, paramLong2, paramInt5, 0, 0, "", 0);
      AppMethodBeat.o(314451);
      return;
    }
  }
  
  public static final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(314446);
    b(paramInt1, paramInt2, paramInt3, 0, 0, paramLong1, paramLong2, 0, 0, 0, "", 0);
    AppMethodBeat.o(314446);
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(314337);
    b localb = gRo();
    if (localb == null)
    {
      AppMethodBeat.o(314337);
      return;
    }
    localb.lsO = paramInt2;
    if (localb.OTB > localb.OTz) {
      localb.OTC = (localb.OTB - localb.OTz);
    }
    if (localb.OTC > 0L)
    {
      paramBaseScanRequest = b(paramBaseScanRequest);
      Log.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", new Object[] { Integer.valueOf(18560), localb, Integer.valueOf(paramInt1), paramBaseScanRequest.bsC, paramBaseScanRequest.bsD });
      h.OAn.b(18560, new Object[] { localb.OTx, localb.OTy, Long.valueOf(localb.OTz), Long.valueOf(localb.OTB), Long.valueOf(localb.OTC), Integer.valueOf(localb.lsO), Integer.valueOf(paramInt1), paramBaseScanRequest.bsC, paramBaseScanRequest.bsD, hQR });
    }
    ((Map)OTi).put(Integer.valueOf(12), "");
    AppMethodBeat.o(314337);
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3)
  {
    AppMethodBeat.i(314327);
    String str1 = (String)OTj.get(Integer.valueOf(12));
    String str2 = (String)OTi.get(Integer.valueOf(12));
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
      AppMethodBeat.o(314327);
      return;
      i = 0;
      break;
    }
    label117:
    paramInt2 = ahV(paramInt2);
    paramBaseScanRequest = b(paramBaseScanRequest);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, scene: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", new Object[] { Integer.valueOf(18558), Integer.valueOf(paramInt1), Integer.valueOf(12), str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.OAn.b(18558, new Object[] { str1, str2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramBaseScanRequest.bsC, paramBaseScanRequest.bsD, hQR });
    AppMethodBeat.o(314327);
  }
  
  public static final void a(int paramInt1, int paramInt2, BaseScanRequest paramBaseScanRequest, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(314442);
    paramInt2 = bx(paramInt2, paramBoolean);
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1;
    if (paramInt3 == 1)
    {
      OTp = l3;
      l1 = l2;
    }
    for (;;)
    {
      r localr = b(paramBaseScanRequest);
      h.OAn.b(20275, new Object[] { localr.bsC, localr.bsD, hQR, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(l3), Long.valueOf(l1), Integer.valueOf(paramInt4) });
      if ((paramInt3 == 1) && ((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5)) {
        h.OAn.kJ(1259, 108);
      }
      AppMethodBeat.o(314442);
      return;
      l1 = l2;
      if (paramInt3 == 2)
      {
        l1 = l2;
        if (OTp > 0L)
        {
          l1 = l3 - OTp;
          OTp = 0L;
        }
      }
    }
  }
  
  public static final void a(int paramInt, List<? extends WxQBarResult> paramList, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(314431);
    s.u(paramList, "codeResultList");
    OTo = new am.a(paramList, paramLong);
    try
    {
      am.a locala = OTo;
      if (locala != null)
      {
        paramList = ahS(paramInt);
        if (paramList == null)
        {
          paramList = null;
          if (paramList != null) {
            break label132;
          }
          paramLong = System.currentTimeMillis();
          label57:
          locala.OTs = paramLong;
        }
      }
      else
      {
        locala = OTo;
        if (locala != null)
        {
          paramList = ahU(paramInt);
          if (paramList != null) {
            break label140;
          }
          paramList = localObject;
          label85:
          if (paramList != null) {
            break label151;
          }
        }
      }
      label132:
      label140:
      label151:
      for (paramLong = System.currentTimeMillis();; paramLong = paramList.longValue())
      {
        locala.OTt = paramLong;
        paramList = OTo;
        if (paramList == null) {
          break label160;
        }
        paramList.OTv = System.currentTimeMillis();
        AppMethodBeat.o(314431);
        return;
        paramList = Long.valueOf(Long.parseLong(paramList));
        break;
        paramLong = paramList.longValue();
        break label57;
        paramList = Long.valueOf(Long.parseLong(paramList));
        break label85;
      }
      label160:
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(314431);
    }
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(170038);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (aic(paramInt1)) {}
    switch (paramInt2)
    {
    default: 
    case 1: 
    case 3: 
      label159:
      do
      {
        do
        {
          AppMethodBeat.o(170038);
          return;
        } while (!paramBoolean);
        localh = h.OAn;
        if (!OTn)
        {
          paramInt1 = 52;
          localh.kJ(1259, paramInt1);
          if (paramInt3 != 1) {
            continue;
          }
          localh = h.OAn;
          if (OTn) {
            break label159;
          }
        }
        for (paramInt1 = 60;; paramInt1 = 80)
        {
          localh.kJ(1259, paramInt1);
          AppMethodBeat.o(170038);
          return;
          paramInt1 = 72;
          break;
        }
      } while (paramInt3 <= 1);
      localh = h.OAn;
      if (!OTn) {}
      for (paramInt1 = 61;; paramInt1 = 81)
      {
        localh.kJ(1259, paramInt1);
        AppMethodBeat.o(170038);
        return;
      }
    }
    if (paramBoolean)
    {
      localh = h.OAn;
      if (!OTn) {}
      for (paramInt1 = 58;; paramInt1 = 76)
      {
        localh.kJ(1259, paramInt1);
        AppMethodBeat.o(170038);
        return;
      }
    }
    h localh = h.OAn;
    if (!OTn) {}
    for (paramInt1 = 59;; paramInt1 = 77)
    {
      localh.kJ(1259, paramInt1);
      break;
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
    b localb = gRo();
    if (localb == null)
    {
      AppMethodBeat.o(52234);
      return;
    }
    localb.OTE = paramLong;
    localb.OTG = paramBoolean1;
    localb.source = ahV(paramInt);
    if ((localb.OTD > 0L) && (localb.OTE > 0L)) {
      localb.OTF = (localb.OTE - localb.OTD);
    }
    int i;
    if ((localb.OTF > 0L) || (paramBoolean2))
    {
      if (!paramBoolean2) {
        break label252;
      }
      i = 3;
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.OTx, localb.OTy, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong), Long.valueOf(localb.OTF), Integer.valueOf(i) });
      h.OAn.b(18724, new Object[] { localb.OTx, localb.OTy, Integer.valueOf(localb.source), Integer.valueOf(i), Long.valueOf(localb.OTF) });
      AppMethodBeat.o(52234);
      return;
      label252:
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
    if (!OTm)
    {
      Log.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
      AppMethodBeat.o(161974);
      return;
    }
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) });
    if (paramBoolean2) {
      h.OAn.kJ(1259, 28);
    }
    while ((paramBoolean1) && (paramInt == 1)) {
      if (paramBoolean2)
      {
        h.OAn.kJ(1259, 36);
        AppMethodBeat.o(161974);
        return;
        if ((paramLong >= 0L) && (paramLong < 1000L)) {
          h.OAn.kJ(1259, 23);
        } else if ((paramLong >= 1000L) && (paramLong < 2000L)) {
          h.OAn.kJ(1259, 24);
        } else if ((paramLong >= 2000L) && (paramLong < 3000L)) {
          h.OAn.kJ(1259, 25);
        } else if ((paramLong >= 3000L) && (paramLong < 5000L)) {
          h.OAn.kJ(1259, 26);
        } else if (paramLong >= 5000L) {
          h.OAn.kJ(1259, 27);
        }
      }
      else
      {
        if ((paramLong >= 0L) && (paramLong < 1000L))
        {
          h.OAn.kJ(1259, 31);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 1000L) && (paramLong < 2000L))
        {
          h.OAn.kJ(1259, 32);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 2000L) && (paramLong < 3000L))
        {
          h.OAn.kJ(1259, 33);
          AppMethodBeat.o(161974);
          return;
        }
        if ((paramLong >= 3000L) && (paramLong < 5000L))
        {
          h.OAn.kJ(1259, 34);
          AppMethodBeat.o(161974);
          return;
        }
        if (paramLong >= 5000L) {
          h.OAn.kJ(1259, 35);
        }
      }
    }
    AppMethodBeat.o(161974);
  }
  
  public static final void aY(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52232);
    b localb = gRo();
    if (localb == null)
    {
      AppMethodBeat.o(52232);
      return;
    }
    localb.OTD = paramLong;
    Log.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", new Object[] { Integer.valueOf(localb.hashCode()), localb.OTx, localb.OTy, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(52232);
  }
  
  public static final void ag(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(170039);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    h localh;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        localh = h.OAn;
        paramInt = 102;
      }
    }
    for (;;)
    {
      localh.kJ(1259, paramInt);
      do
      {
        AppMethodBeat.o(170039);
        return;
        if (paramInt == 2)
        {
          localh = h.OAn;
          if (paramBoolean) {}
          for (paramInt = 106;; paramInt = 107)
          {
            localh.kJ(1259, paramInt);
            AppMethodBeat.o(170039);
            return;
          }
        }
      } while ((paramInt != 4) || (!OTn));
      localh = h.OAn;
      if (paramBoolean) {
        paramInt = 78;
      } else {
        paramInt = 79;
      }
    }
  }
  
  public static final void ahR(int paramInt)
  {
    AppMethodBeat.i(52222);
    ((Map)OTj).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), OTj.get(Integer.valueOf(paramInt)) });
    AppMethodBeat.o(52222);
  }
  
  public static final String ahS(int paramInt)
  {
    AppMethodBeat.i(314310);
    String str = (String)OTj.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(314310);
    return str;
  }
  
  public static final void ahT(int paramInt)
  {
    AppMethodBeat.i(52224);
    if ((paramInt != 12) && (!aic(paramInt)))
    {
      AppMethodBeat.o(52224);
      return;
    }
    ((Map)OTi).put(Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()));
    Log.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", new Object[] { Integer.valueOf(paramInt), OTi.get(Integer.valueOf(paramInt)) });
    String str1 = (String)OTj.get(Integer.valueOf(paramInt));
    String str2 = (String)OTi.get(Integer.valueOf(paramInt));
    if (str1 != null) {
      if (((CharSequence)str1).length() > 0)
      {
        paramInt = 1;
        if (paramInt != 1) {
          break label256;
        }
        paramInt = 1;
        label134:
        if (paramInt == 0) {
          break label351;
        }
        if (str2 == null) {
          break label266;
        }
        if (((CharSequence)str2).length() <= 0) {
          break label261;
        }
        paramInt = 1;
        label156:
        if (paramInt != 1) {
          break label266;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        String str3 = str1 + ',' + str2;
        b localb = (b)OTl.get(str3);
        if (localb == null)
        {
          localb = new b();
          localb.aUN(str1);
          localb.aUO(str2);
          ((Map)OTl).put(str3, localb);
          AppMethodBeat.o(52224);
          return;
          paramInt = 0;
          break;
          label256:
          paramInt = 0;
          break label134;
          label261:
          paramInt = 0;
          break label156;
          label266:
          paramInt = 0;
          continue;
        }
        localb.OTx = "";
        localb.OTy = "";
        localb.OTz = 0L;
        localb.OTB = 0L;
        localb.OTC = 0L;
        localb.lsO = 0;
        localb.OTD = 0L;
        localb.OTE = 0L;
        localb.OTF = 0L;
        localb.source = 0;
        localb.OTG = false;
        localb.aUN(str1);
        localb.aUO(str2);
      }
    }
    label351:
    AppMethodBeat.o(52224);
  }
  
  public static final String ahU(int paramInt)
  {
    AppMethodBeat.i(314321);
    String str = (String)OTi.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(314321);
    return str;
  }
  
  private static int ahV(int paramInt)
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
  
  public static final void ahW(int paramInt)
  {
    AppMethodBeat.i(161056);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(161056);
      return;
      h.OAn.kJ(1259, 20);
      h.OAn.kJ(1259, 21);
      AppMethodBeat.o(161056);
      return;
      h.OAn.kJ(1259, 20);
      h.OAn.kJ(1259, 22);
    }
  }
  
  public static final void ahX(int paramInt)
  {
    AppMethodBeat.i(170036);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (aic(paramInt))
    {
      localObject = (Integer)OTk.get(Integer.valueOf(paramInt));
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 1)
      {
        ((Map)OTk).put(Integer.valueOf(paramInt), Integer.valueOf(1));
        localObject = h.OAn;
        if (OTn) {
          break;
        }
        paramInt = 50;
        ((h)localObject).kJ(1259, paramInt);
        AppMethodBeat.o(170036);
        return;
      }
    }
    while (paramInt != 12) {
      for (;;)
      {
        AppMethodBeat.o(170036);
        return;
        paramInt = 70;
      }
    }
    Object localObject = (Integer)OTk.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    for (;;)
    {
      ((Map)OTk).put(Integer.valueOf(paramInt), Integer.valueOf(1));
      h.OAn.kJ(1259, 100);
      break;
      if (((Integer)localObject).intValue() == 1) {
        break;
      }
    }
  }
  
  public static final void ahY(int paramInt)
  {
    AppMethodBeat.i(170037);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    if (aic(paramInt))
    {
      localObject = (Integer)OTk.get(Integer.valueOf(paramInt));
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 1)
      {
        Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        AppMethodBeat.o(170037);
        return;
      }
      ((Map)OTk).put(Integer.valueOf(paramInt), Integer.valueOf(2));
      localObject = h.OAn;
      if (!OTn) {}
      for (paramInt = 51;; paramInt = 71)
      {
        ((h)localObject).kJ(1259, paramInt);
        AppMethodBeat.o(170037);
        return;
      }
    }
    if (paramInt == 12)
    {
      localObject = (Integer)OTk.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        break label169;
      }
    }
    label169:
    while (((Integer)localObject).intValue() != 1)
    {
      Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
      AppMethodBeat.o(170037);
      return;
    }
    ((Map)OTk).put(Integer.valueOf(paramInt), Integer.valueOf(2));
    h.OAn.kJ(1259, 101);
    AppMethodBeat.o(170037);
  }
  
  public static final void ahZ(int paramInt)
  {
    AppMethodBeat.i(170040);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (aic(paramInt))
    {
      h localh = h.OAn;
      if (!OTn) {}
      for (paramInt = 55;; paramInt = 73)
      {
        localh.kJ(1259, paramInt);
        AppMethodBeat.o(170040);
        return;
      }
    }
    if (paramInt == 12) {
      h.OAn.kJ(1259, 103);
    }
    AppMethodBeat.o(170040);
  }
  
  public static final void aia(int paramInt)
  {
    AppMethodBeat.i(170041);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (aic(paramInt))
    {
      h localh = h.OAn;
      if (!OTn) {}
      for (paramInt = 56;; paramInt = 74)
      {
        localh.kJ(1259, paramInt);
        AppMethodBeat.o(170041);
        return;
      }
    }
    if (paramInt == 12) {
      h.OAn.kJ(1259, 104);
    }
    AppMethodBeat.o(170041);
  }
  
  public static final void aib(int paramInt)
  {
    AppMethodBeat.i(170042);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (aic(paramInt))
    {
      h localh = h.OAn;
      if (!OTn) {}
      for (paramInt = 57;; paramInt = 75)
      {
        localh.kJ(1259, paramInt);
        AppMethodBeat.o(170042);
        return;
      }
    }
    if (paramInt == 12) {
      h.OAn.kJ(1259, 105);
    }
    AppMethodBeat.o(170042);
  }
  
  private static final boolean aic(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  private static r<String, String> b(BaseScanRequest paramBaseScanRequest)
  {
    AppMethodBeat.i(314467);
    try
    {
      if (((paramBaseScanRequest instanceof ScanGoodsRequest)) && (((ScanGoodsRequest)paramBaseScanRequest).mode == 5))
      {
        String str = ((ScanGoodsRequest)paramBaseScanRequest).getExtra("key_sns_ad_ux_info", "");
        s.s(str, "bizInfo");
        paramBaseScanRequest = (String)p.ae(n.a((CharSequence)str, new String[] { "|" }), 1);
        if (paramBaseScanRequest == null) {
          paramBaseScanRequest = "";
        }
        for (;;)
        {
          Log.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", new Object[] { str, paramBaseScanRequest });
          paramBaseScanRequest = new r(paramBaseScanRequest, str);
          AppMethodBeat.o(314467);
          return paramBaseScanRequest;
        }
      }
      return paramBaseScanRequest;
    }
    catch (Exception paramBaseScanRequest)
    {
      Log.printErrStackTrace("MicroMsg.ScanReporter", (Throwable)paramBaseScanRequest, "alvinluo getBizId exception", new Object[0]);
      paramBaseScanRequest = new r("", "");
      AppMethodBeat.o(314467);
    }
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, int paramInt6, int paramInt7, int paramInt8, String paramString, int paramInt9)
  {
    AppMethodBeat.i(314453);
    s.u(paramString, "cardTitle");
    if (!OTn)
    {
      AppMethodBeat.o(314453);
      return;
    }
    Object localObject2 = ahS(paramInt1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(System.currentTimeMillis());
    }
    Object localObject3 = ahU(paramInt1);
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = Long.valueOf(System.currentTimeMillis());
    }
    localObject3 = c.ORj;
    c.a(paramInt2, paramInt3, kN(paramInt4, paramInt5), paramLong1, localObject1.toString(), localObject2.toString(), String.valueOf(paramLong2), paramInt6, paramInt7, paramInt8, paramString, hQR, paramInt9);
    AppMethodBeat.o(314453);
  }
  
  public static final void b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(314440);
    if (OTo == null)
    {
      AppMethodBeat.o(314440);
      return;
    }
    Object localObject1 = OTo;
    s.checkNotNull(localObject1);
    long l1 = ((am.a)localObject1).OTs;
    localObject1 = OTo;
    s.checkNotNull(localObject1);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCodeOp tabSession:  %d, scanSession: %d, resultOpType: %d", new Object[] { Long.valueOf(l1), Long.valueOf(((am.a)localObject1).OTt), Integer.valueOf(paramInt1) });
    if (paramInt1 == 4)
    {
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      ((am.a)localObject1).OTw = System.currentTimeMillis();
    }
    Object localObject2;
    long l2;
    if ((paramInt1 == 6) || (paramInt1 == 5))
    {
      l1 = System.currentTimeMillis();
      localObject1 = OTo;
      s.checkNotNull(localObject1);
      localObject1 = String.valueOf(l1 - ((am.a)localObject1).OTw);
      localObject2 = h.OAn;
      am.a locala = OTo;
      s.checkNotNull(locala);
      l1 = locala.OTt;
      locala = OTo;
      s.checkNotNull(locala);
      l2 = locala.OTs;
      if (!paramBoolean) {
        break label354;
      }
    }
    label354:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((h)localObject2).b(19332, new Object[] { Long.valueOf(l1), Integer.valueOf(0), "", "", Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l2), "", localObject1, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (paramInt1 != 4) {
        break label359;
      }
      h.OAn.kJ(1259, 64);
      AppMethodBeat.o(314440);
      return;
      if (paramInt1 == 7)
      {
        localObject2 = ahS(paramInt2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
      }
      localObject1 = "";
      break;
    }
    label359:
    if (paramInt1 == 6)
    {
      h.OAn.kJ(1259, 65);
      AppMethodBeat.o(314440);
      return;
    }
    if (paramInt1 == 5) {
      h.OAn.kJ(1259, 66);
    }
    AppMethodBeat.o(314440);
  }
  
  private static int bx(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 4: 
    case 8: 
      if (paramBoolean) {
        return 4;
      }
      return 1;
    case 12: 
      return 2;
    }
    return 3;
  }
  
  private static final void by(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(314477);
    MMHandlerThread.postToMainThread(new am..ExternalSyntheticLambda1(paramInt, ac.getReportString(), paramBoolean));
    AppMethodBeat.o(314477);
  }
  
  public static final void d(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314457);
    s.u(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.OAn.kJ(1259, 109);
    }
    AppMethodBeat.o(314457);
  }
  
  public static final void e(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314460);
    s.u(paramScanGoodsRequest, "request");
    if (paramScanGoodsRequest.mode == 5) {
      h.OAn.kJ(1259, 110);
    }
    AppMethodBeat.o(314460);
  }
  
  private static final void g(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(314474);
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanFocusEngineReportInfo %s", new Object[] { paramString });
    Object localObject1 = (CharSequence)paramString;
    String str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label248;
      }
      localObject1 = (String)OTj.get(Integer.valueOf(paramInt));
      str = (String)OTi.get(Integer.valueOf(paramInt));
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label148;
      }
      i = 1;
      label104:
      if (i == 0)
      {
        localObject2 = (CharSequence)str;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label153;
        }
      }
    }
    label148:
    label153:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label158;
      }
      AppMethodBeat.o(314474);
      return;
      i = 0;
      break;
      i = 0;
      break label104;
    }
    label158:
    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanFocusEngineReportInfo logId: %d, tabId: %d, tabSession: %s, scanSession: %s, hasResult: %b", new Object[] { Integer.valueOf(18731), Integer.valueOf(paramInt), localObject1, str, Boolean.valueOf(paramBoolean) });
    Object localObject2 = h.OAn;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((h)localObject2).b(18731, new Object[] { localObject1, str, Integer.valueOf(paramInt), paramString });
      label248:
      AppMethodBeat.o(314474);
      return;
    }
  }
  
  public static final String gRn()
  {
    return hQR;
  }
  
  private static b gRo()
  {
    AppMethodBeat.i(52235);
    Object localObject = (String)OTj.get(Integer.valueOf(12));
    String str = (String)OTi.get(Integer.valueOf(12));
    if (localObject != null) {
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label142;
        }
        i = 1;
        label61:
        if (i == 0) {
          break label157;
        }
        if (str == null) {
          break label152;
        }
        if (((CharSequence)str).length() <= 0) {
          break label147;
        }
        i = 1;
        label83:
        if (i != 1) {
          break label152;
        }
      }
    }
    label142:
    label147:
    label152:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label157;
      }
      localObject = localObject + ',' + str;
      localObject = (b)OTl.get(localObject);
      AppMethodBeat.o(52235);
      return localObject;
      i = 0;
      break;
      i = 0;
      break label61;
      i = 0;
      break label83;
    }
    label157:
    AppMethodBeat.o(52235);
    return null;
  }
  
  public static final void gRp()
  {
    AppMethodBeat.i(52236);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
    h.OAn.kJ(1259, 0);
    AppMethodBeat.o(52236);
  }
  
  public static final void gRq()
  {
    AppMethodBeat.i(52237);
    Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
    h.OAn.kJ(1259, 1);
    AppMethodBeat.o(52237);
  }
  
  public static final void gRr()
  {
    AppMethodBeat.i(161973);
    if (OTm)
    {
      Log.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
      h.OAn.kJ(1259, 2);
    }
    AppMethodBeat.o(161973);
  }
  
  public static final void gRs()
  {
    AppMethodBeat.i(314417);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
    h localh = h.OAn;
    if (!OTn) {}
    for (int i = 62;; i = 82)
    {
      localh.kJ(1259, i);
      AppMethodBeat.o(314417);
      return;
    }
  }
  
  public static final void gRt()
  {
    AppMethodBeat.i(314422);
    Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
    h localh = h.OAn;
    if (!OTn) {}
    for (int i = 63;; i = 83)
    {
      localh.kJ(1259, i);
      AppMethodBeat.o(314422);
      return;
    }
  }
  
  public static final void gRv()
  {
    AppMethodBeat.i(314445);
    h.OAn.kJ(1259, 84);
    AppMethodBeat.o(314445);
  }
  
  public static final void gRw()
  {
    AppMethodBeat.i(314471);
    h.OAn.kJ(1259, 90);
    AppMethodBeat.o(314471);
  }
  
  private static String kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314456);
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      AppMethodBeat.o(314456);
      return "";
    }
    String str = paramInt2 + ';' + paramInt1;
    AppMethodBeat.o(314456);
    return str;
  }
  
  public static final void n(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161975);
    Log.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    h localh;
    if ((paramBoolean1) && (paramInt == 2))
    {
      localh = h.OAn;
      if (!paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramInt = 29;; paramInt = 30)
    {
      localh.kJ(1259, paramInt);
      AppMethodBeat.o(161975);
      return;
    }
  }
  
  public static final void tX(long paramLong)
  {
    AppMethodBeat.i(52227);
    b localb = gRo();
    if (localb != null) {
      localb.OTz = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52227);
  }
  
  public static final void tY(long paramLong)
  {
    AppMethodBeat.i(52228);
    b localb = gRo();
    if (localb != null) {
      localb.OTB = paramLong;
    }
    Log.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", new Object[] { Integer.valueOf(12), Long.valueOf(paramLong) });
    AppMethodBeat.o(52228);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    long OTB;
    long OTC;
    long OTD;
    long OTE;
    long OTF;
    boolean OTG;
    String OTx = "";
    String OTy = "";
    long OTz;
    int lsO;
    int source;
    
    public final void aUN(String paramString)
    {
      AppMethodBeat.i(52215);
      s.u(paramString, "<set-?>");
      this.OTx = paramString;
      AppMethodBeat.o(52215);
    }
    
    public final void aUO(String paramString)
    {
      AppMethodBeat.i(52216);
      s.u(paramString, "<set-?>");
      this.OTy = paramString;
      AppMethodBeat.o(52216);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52217);
      Object localObject = kotlin.g.b.am.aixg;
      localObject = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[] { this.OTx, this.OTy, Long.valueOf(this.OTz), Long.valueOf(this.OTB), Long.valueOf(this.OTC), Integer.valueOf(this.lsO) }, 6));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(52217);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.am
 * JD-Core Version:    0.7.0.1
 */