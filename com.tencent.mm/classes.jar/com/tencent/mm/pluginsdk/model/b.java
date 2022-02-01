package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.an.d.a;
import com.tencent.mm.f.a.ap;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic;", "", "()V", "TAG", "", "cacheCardTitleLiveExpose", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Lkotlin/collections/HashMap;", "getCacheCardTitleLiveExpose", "()Ljava/util/HashMap;", "cacheIsClick", "getCacheIsClick", "clickRedDotExportId", "getClickRedDotExportId", "()Ljava/lang/String;", "setClickRedDotExportId", "(Ljava/lang/String;)V", "clickRedDotUserName", "getClickRedDotUserName", "setClickRedDotUserName", "clickScene", "", "getClickScene", "()I", "setClickScene", "(I)V", "exportIdExpireTime", "isCheckingFinderLiveRedDot", "", "()Z", "setCheckingFinderLiveRedDot", "(Z)V", "isClick", "setClick", "isForceOpen", "isForceOpen$delegate", "Lkotlin/Lazy;", "isGettingFinderLiveRedDot", "setGettingFinderLiveRedDot", "lastMainCellRedDotUserNameKey", "mainCellRedDotTimeKey", "mainCellRedDotUserNameKey", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "onClickUser", "openBizProfileLive", "getOpenBizProfileLive", "openBizProfileLive$delegate", "openBizSessionLive", "getOpenBizSessionLive", "openBizSessionLive$delegate", "openCardTitleLive", "getOpenCardTitleLive", "openCardTitleLive$delegate", "openFinderLiveBar", "getOpenFinderLiveBar", "openFinderLiveBar$delegate", "openFlag", "getOpenFlag", "openFlag$delegate", "openOftenReadLive", "getOpenOftenReadLive", "openOftenReadLive$delegate", "openWebTopBarLive", "getOpenWebTopBarLive", "openWebTopBarLive$delegate", "slot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "testLiveScene", "getTestLiveScene", "setTestLiveScene", "updateMainCellRedDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "updatingLiveMap", "checkClickUser", "", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/TimelineOftenReadBizInfo;", "checkFinderLive", "bizUserName", "force", "scene", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "exportId", "isChange", "checkLiveRedDotNotify", "userName", "clearClickData", "forceOpen", "getBizFinderLives", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveResp;", "_scene", "_bizUserName", "(ILjava/util/LinkedList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExportId", "getLiveScene", "getLiveTitle", "getMainCellRedDotTime", "getMainCellRedDotUserName", "getMidFromBizInfo", "info", "getOftenReadSvrOpen", "getSvrOpenFlag", "isExportIdChange", "finderFeedExportId", "isExportIdClick", "isExportIdClickLastTime", "isExportIdClickThisTime", "isLiveNow", "isRedDotUserShowCircle", "isShowCircleForOftenRead", "isShowCircleForSecondBar", "onCardTitleLiveExposed", "onClick", "context", "Landroid/content/Context;", "liveScene", "onDestroy", "onFinderLiveRedDotNotify", "onMainCellRedDotClick", "onOftenReadLiveExpose", "onResume", "publishLiveStatusChangeEvent", "reportCardTitleLive", "sessionId", "reportIdKey1703", "value", "reportLiveClickOp", "bizInfo", "resetMainCellRedDotInfo", "resetRedDotClickInfo", "saveBizFinderLiveInfo", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveInfo;", "saveFinderLiveRedDotInfo", "saveOftenReadSvrOpen", "showFinderLive", "saveSvrOpenFlag", "flag", "shouldRefreshNow", "shouldShowFinderDigest", "Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$ShowFinderDigestResult;", "msgTime", "startCheckMaiCellRedDot", "stopCheckMaiCellRedDot", "updateBizFinderLiveInfoTime", "clickExportIdKey", "clickKey", "exportIdKey", "exposeExportIdKey", "liveSceneKey", "refreshIntervalKey", "saveExportIdTimeKey", "titleKey", "BizFinderLiveOpenFlag", "BizFinderLiveScene", "ShowFinderDigestResult", "SvrFinderLiveControlBit", "plugin-biz_release"})
public final class b
{
  private static boolean MWt;
  public static final kotlin.f QTA;
  private static int QTB;
  private static final HashMap<Long, z> QTC;
  private static final kotlin.f QTD;
  private static String QTE;
  private static String QTF;
  public static MTimerHandler QTG;
  private static boolean QTH;
  private static boolean QTI;
  public static final b QTJ;
  public static final MMKVSlotManager QTq;
  private static HashMap<String, Boolean> QTr;
  private static String QTs;
  private static final HashMap<String, String> QTt;
  private static final kotlin.f QTu;
  private static final kotlin.f QTv;
  public static final kotlin.f QTw;
  private static final kotlin.f QTx;
  private static final kotlin.f QTy;
  public static final kotlin.f QTz;
  private static final kotlin.f lrB;
  private static int yiD;
  
  static
  {
    AppMethodBeat.i(207073);
    QTJ = new b();
    lrB = kotlin.g.ar((kotlin.g.a.a)g.QUe);
    Object localObject = bcJ();
    p.j(localObject, "mmkv");
    QTq = new MMKVSlotManager((MultiProcessMMKV)localObject, 15552000L);
    QTr = new HashMap();
    QTt = new HashMap();
    QTu = kotlin.g.ar((kotlin.g.a.a)o.QUl);
    QTv = kotlin.g.ar((kotlin.g.a.a)p.QUm);
    QTw = kotlin.g.ar((kotlin.g.a.a)n.QUk);
    QTx = kotlin.g.ar((kotlin.g.a.a)m.QUj);
    QTy = kotlin.g.ar((kotlin.g.a.a)l.QUi);
    QTz = kotlin.g.ar((kotlin.g.a.a)k.QUh);
    QTA = kotlin.g.ar((kotlin.g.a.a)q.QUn);
    localObject = b.QUa;
    yiD = b.hgA();
    QTC = new HashMap();
    QTD = kotlin.g.ar((kotlin.g.a.a)f.QUd);
    AppMethodBeat.o(207073);
  }
  
  public static void A(z paramz)
  {
    AppMethodBeat.i(207041);
    p.k(paramz, "info");
    Map localMap = (Map)QTC;
    long l = paramz.field_msgId;
    paramz.Vef = System.currentTimeMillis();
    localMap.put(Long.valueOf(l), paramz);
    AppMethodBeat.o(207041);
  }
  
  public static void DI(boolean paramBoolean)
  {
    AppMethodBeat.i(207043);
    bcJ().encode("SvrShowFinderLive", paramBoolean);
    Log.d("MicroMsg.BizFinderLiveLogic", "showOftenReadFinderLive = ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(207043);
  }
  
  public static void DJ(boolean paramBoolean)
  {
    AppMethodBeat.i(207045);
    bcJ().encode("forceOpenLive", paramBoolean);
    AppMethodBeat.o(207045);
  }
  
  public static void DK(boolean paramBoolean)
  {
    QTH = paramBoolean;
  }
  
  public static void DL(boolean paramBoolean)
  {
    QTI = paramBoolean;
  }
  
  public static void TM(long paramLong)
  {
    AppMethodBeat.i(207014);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1703L, paramLong, 1L, false);
    AppMethodBeat.o(207014);
  }
  
  public static final e XW(long paramLong)
  {
    AppMethodBeat.i(292844);
    if (bcJ().decodeLong("KeyMainRedDotTime", 0L) < paramLong)
    {
      localObject1 = new e(false, false);
      AppMethodBeat.o(292844);
      return localObject1;
    }
    Object localObject1 = bcJ().decodeString("KeyMainCellRedDotUserName", "");
    String str = bpq((String)localObject1);
    Object localObject2 = QTq;
    p.j(localObject1, "redDotUserName");
    localObject2 = ((MMKVSlotManager)localObject2).decodeString(bpw((String)localObject1), "");
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = new e(false, false);
      AppMethodBeat.o(292844);
      return localObject1;
    }
    if (Util.isEqual(str, (String)localObject2))
    {
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        Log.d("MicroMsg.BizFinderLiveLogic", "shouldShowFinderLiveRedDot clickExportId=" + (String)localObject2 + " return");
      }
      localObject1 = new e(true, false);
      AppMethodBeat.o(292844);
      return localObject1;
    }
    localObject2 = QTq.decodeString(bpv((String)localObject1), "");
    boolean bool = Util.isEqual((String)localObject1, bcJ().decodeString("KeyLastMainCellRedDotUserName", ""));
    if ((!bool) && (Util.isEqual(str, (String)localObject2)))
    {
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        Log.d("MicroMsg.BizFinderLiveLogic", "shouldShowFinderLiveRedDot exposeExposeId=" + (String)localObject2 + " return");
      }
      localObject1 = new e(true, false);
      AppMethodBeat.o(292844);
      return localObject1;
    }
    if (!bool) {
      bcJ().encode("KeyLastMainCellRedDotUserName", (String)localObject1);
    }
    localObject1 = new e(true, true);
    AppMethodBeat.o(292844);
    return localObject1;
  }
  
  public static Object a(int paramInt, LinkedList<String> paramLinkedList, kotlin.d.d<? super oe> paramd)
  {
    AppMethodBeat.i(207013);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.k(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject = new d.a();
    od localod = new od();
    localod.scene = paramInt;
    if (paramLinkedList != null) {
      localod.RVr = paramLinkedList;
    }
    bcJ().decodeBytes("FinderLiveBuffer");
    localod.RVt = 12;
    ((d.a)localObject).c((com.tencent.mm.cd.a)localod);
    ((d.a)localObject).d((com.tencent.mm.cd.a)new oe());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/timeline/bizfinderlive");
    ((d.a)localObject).vD(4703);
    localObject = ((d.a)localObject).bgN();
    Log.i("MicroMsg.BizFinderLiveLogic", "getBizFinderLives scene=".concat(String.valueOf(paramInt)));
    TM(0L);
    if (1 > paramInt) {}
    while (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext()) {
        bIO((String)paramLinkedList.next());
      }
      if (19 >= paramInt) {
        TM(40L + paramInt);
      }
    }
    paramLinkedList = new aa.a();
    paramLinkedList.aaBx = false;
    IPCRunCgi.a((com.tencent.mm.an.d)localObject, (IPCRunCgi.a)new b.s(paramLinkedList, locald));
    paramLinkedList = localh.iBS();
    if (paramLinkedList == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(207013);
    return paramLinkedList;
  }
  
  public static void a(oc paramoc)
  {
    AppMethodBeat.i(207016);
    if (paramoc == null)
    {
      AppMethodBeat.o(207016);
      return;
    }
    Object localObject = paramoc.RKL;
    if (localObject == null)
    {
      AppMethodBeat.o(207016);
      return;
    }
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpl((String)localObject), Util.nullAsNil(paramoc.RVp));
    bIO((String)localObject);
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpn((String)localObject), paramoc.RVp);
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpo((String)localObject), paramoc.title);
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpp((String)localObject), paramoc.RVq);
    localObject = (CharSequence)paramoc.RVp;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        Log.i("MicroMsg.BizFinderLiveLogic", "saveBizFinderLiveInfo " + paramoc.RKL + ' ' + paramoc.RVp);
      }
      AppMethodBeat.o(207016);
      return;
    }
  }
  
  public static void a(String paramString, z paramz)
  {
    AppMethodBeat.i(207040);
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = ab.getSessionId();
    long l = 0L;
    if (paramz != null) {
      l = z(paramz);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString, Long.valueOf(l), Integer.valueOf(26), Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(207040);
  }
  
  public static void a(final String paramString, boolean paramBoolean, final int paramInt, final kotlin.g.a.q<? super String, ? super String, ? super Boolean, x> paramq)
  {
    AppMethodBeat.i(207034);
    p.k(paramq, "block");
    if (paramString == null)
    {
      AppMethodBeat.o(207034);
      return;
    }
    kotlinx.coroutines.g.b((kotlinx.coroutines.ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new c(paramBoolean, paramString, paramInt, paramq, null), 2);
    AppMethodBeat.o(207034);
  }
  
  public static void apA(int paramInt)
  {
    AppMethodBeat.i(207042);
    Iterator localIterator = ((Map)QTC).entrySet().iterator();
    if (localIterator.hasNext())
    {
      z localz = (z)((Map.Entry)localIterator.next()).getValue();
      long l = z(localz);
      if (localz.Veg) {}
      for (int i = 1;; i = 0)
      {
        localz.Veg = false;
        int j = bpr(localz.field_talker);
        String str = bpq(localz.field_talker);
        com.tencent.mm.plugin.report.service.h.IzE.a(23056, new Object[] { localz.field_talker, Long.valueOf(l), Long.valueOf(localz.Vef), Integer.valueOf(paramInt), str, Integer.valueOf(i), Integer.valueOf(j) });
        break;
      }
    }
    AppMethodBeat.o(207042);
  }
  
  public static void apz(int paramInt)
  {
    QTB = paramInt;
  }
  
  public static void ax(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(207035);
    Log.d("MicroMsg.BizFinderLiveLogic", "publishLiveStatusChangeEvent bizUserName=" + paramString1 + ", exportId=" + paramString2 + ", scene=" + paramInt);
    ap localap = new ap();
    localap.fvY.fvZ = paramString1;
    localap.fvY.fwa = paramString2;
    localap.fvY.scene = paramInt;
    EventCenter.instance.asyncPublish((IEvent)localap, Looper.getMainLooper());
    AppMethodBeat.o(207035);
  }
  
  private static void bIO(String paramString)
  {
    AppMethodBeat.i(292843);
    if (paramString == null)
    {
      AppMethodBeat.o(292843);
      return;
    }
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpm(paramString), System.currentTimeMillis());
    AppMethodBeat.o(292843);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(206999);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(206999);
    return localMultiProcessMMKV;
  }
  
  public static boolean bmt(String paramString)
  {
    AppMethodBeat.i(207015);
    if (paramString == null)
    {
      AppMethodBeat.o(207015);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)MMKVSlotManager.decodeString$default(QTq, bpl(paramString), null, 2, null);
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207015);
      return false;
    }
    long l = QTq.decodeLong(bpm(paramString), 0L);
    if (System.currentTimeMillis() - l > 21600000L)
    {
      Log.i("MicroMsg.BizFinderLiveLogic", "isLiveNow expired live status");
      AppMethodBeat.o(207015);
      return false;
    }
    AppMethodBeat.o(207015);
    return true;
  }
  
  private static String bpk(String paramString)
  {
    AppMethodBeat.i(207001);
    paramString = "click-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207001);
    return paramString;
  }
  
  private static String bpl(String paramString)
  {
    AppMethodBeat.i(207002);
    paramString = "exportId-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207002);
    return paramString;
  }
  
  private static String bpm(String paramString)
  {
    AppMethodBeat.i(207003);
    paramString = "saveExportIdTime-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207003);
    return paramString;
  }
  
  public static String bpn(String paramString)
  {
    AppMethodBeat.i(207004);
    p.k(paramString, "$this$refreshIntervalKey");
    paramString = "refreshInterval-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207004);
    return paramString;
  }
  
  private static String bpo(String paramString)
  {
    AppMethodBeat.i(207005);
    paramString = "title-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207005);
    return paramString;
  }
  
  private static String bpp(String paramString)
  {
    AppMethodBeat.i(207006);
    paramString = "live_scene-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207006);
    return paramString;
  }
  
  public static String bpq(String paramString)
  {
    AppMethodBeat.i(207017);
    if (paramString == null)
    {
      AppMethodBeat.o(207017);
      return null;
    }
    paramString = MMKVSlotManager.decodeString$default(QTq, bpl(paramString), null, 2, null);
    AppMethodBeat.o(207017);
    return paramString;
  }
  
  public static int bpr(String paramString)
  {
    AppMethodBeat.i(207019);
    if (paramString == null)
    {
      AppMethodBeat.o(207019);
      return 0;
    }
    int i = QTq.decodeInt(bpp(paramString), 0);
    AppMethodBeat.o(207019);
    return i;
  }
  
  private static String bps(String paramString)
  {
    AppMethodBeat.i(207020);
    if (paramString == null)
    {
      AppMethodBeat.o(207020);
      return null;
    }
    paramString = MMKVSlotManager.decodeString$default(QTq, bpo(paramString), null, 2, null);
    AppMethodBeat.o(207020);
    return paramString;
  }
  
  public static boolean bpt(String paramString)
  {
    AppMethodBeat.i(207028);
    if (p.h(paramString, QTE))
    {
      paramString = (CharSequence)QTF;
      if ((paramString == null) || (n.ba(paramString))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(207028);
        return true;
      }
    }
    AppMethodBeat.o(207028);
    return false;
  }
  
  public static boolean bpu(String paramString)
  {
    AppMethodBeat.i(207032);
    if (paramString == null)
    {
      AppMethodBeat.o(207032);
      return false;
    }
    long l1 = kotlin.k.i.be(MMKVSlotManager.decodeLong$default(QTq, bpn(paramString), 0L, 2, null), 5L);
    long l2 = MMKVSlotManager.decodeLong$default(QTq, bpm(paramString), 0L, 2, null);
    if (System.currentTimeMillis() - l2 > 1000L * l1)
    {
      AppMethodBeat.o(207032);
      return true;
    }
    AppMethodBeat.o(207032);
    return false;
  }
  
  private static String bpv(String paramString)
  {
    AppMethodBeat.i(207046);
    paramString = "expose-exportId-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207046);
    return paramString;
  }
  
  private static String bpw(String paramString)
  {
    AppMethodBeat.i(207047);
    paramString = "click-exportId-".concat(String.valueOf(paramString));
    AppMethodBeat.o(207047);
    return paramString;
  }
  
  public static void bpx(String paramString)
  {
    AppMethodBeat.i(207054);
    if ((QTE != null) && (p.h(paramString, QTE)))
    {
      QTE = null;
      QTF = null;
    }
    AppMethodBeat.o(207054);
  }
  
  public static void bpy(String paramString)
  {
    AppMethodBeat.i(207068);
    p.k(paramString, "userName");
    kotlinx.coroutines.g.b((kotlinx.coroutines.ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new d(paramString, null), 2);
    AppMethodBeat.o(207068);
  }
  
  public static void cc(LinkedList<eru> paramLinkedList)
  {
    AppMethodBeat.i(207056);
    p.k(paramLinkedList, "list");
    Object localObject = (CharSequence)QTE;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)QTF;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
          break label73;
        }
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label78;
      }
      AppMethodBeat.o(207056);
      return;
      i = 0;
      break;
    }
    label78:
    localObject = (Iterable)paramLinkedList;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!p.h(((eru)((Iterator)localObject).next()).RKL, QTE));
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new eru();
        ((eru)localObject).RKL = QTE;
        ((eru)localObject).RVp = QTF;
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(207056);
      return;
    }
  }
  
  public static void cd(LinkedList<eru> paramLinkedList)
  {
    AppMethodBeat.i(207064);
    p.k(paramLinkedList, "list");
    LinkedList localLinkedList = new LinkedList();
    Object localObject = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.add(((eru)((Iterator)localObject).next()).RKL);
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    if (((Collection)localLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207064);
      return;
    }
    kotlinx.coroutines.g.b((kotlinx.coroutines.ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new i(localLinkedList, null), 2);
    AppMethodBeat.o(207064);
  }
  
  public static MMKVSlotManager hga()
  {
    return QTq;
  }
  
  public static HashMap<String, String> hgb()
  {
    return QTt;
  }
  
  public static int hgc()
  {
    AppMethodBeat.i(207007);
    int i = ((Number)QTu.getValue()).intValue();
    AppMethodBeat.o(207007);
    return i;
  }
  
  public static boolean hgd()
  {
    AppMethodBeat.i(207008);
    boolean bool = ((Boolean)QTv.getValue()).booleanValue();
    AppMethodBeat.o(207008);
    return bool;
  }
  
  public static boolean hge()
  {
    AppMethodBeat.i(207010);
    boolean bool = ((Boolean)QTx.getValue()).booleanValue();
    AppMethodBeat.o(207010);
    return bool;
  }
  
  public static boolean hgf()
  {
    AppMethodBeat.i(207011);
    boolean bool = ((Boolean)QTy.getValue()).booleanValue();
    AppMethodBeat.o(207011);
    return bool;
  }
  
  public static int hgg()
  {
    return QTB;
  }
  
  public static void hgh()
  {
    AppMethodBeat.i(207033);
    ((MultiProcessMMKV)QTq.getSlotForWrite()).clearAll();
    AppMethodBeat.o(207033);
  }
  
  public static int hgi()
  {
    AppMethodBeat.i(207044);
    int i = bcJ().decodeInt("SvrOpenFlag", 0);
    Log.i("MicroMsg.BizFinderLiveLogic", "SvrOpenFlag ".concat(String.valueOf(i)));
    AppMethodBeat.o(207044);
    return i;
  }
  
  public static String hgj()
  {
    return QTE;
  }
  
  public static void hgk()
  {
    AppMethodBeat.i(207051);
    String str1 = hgp();
    if (str1 == null)
    {
      AppMethodBeat.o(207051);
      return;
    }
    String str2 = bpq(str1);
    if (str2 == null)
    {
      AppMethodBeat.o(207051);
      return;
    }
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpw(str1), str2);
    QTE = str1;
    QTF = str2;
    AppMethodBeat.o(207051);
  }
  
  public static void hgl()
  {
    AppMethodBeat.i(207052);
    if (bcJ().containsKey("KeyMainCellRedDotUserName"))
    {
      bcJ().removeValueForKey("KeyMainCellRedDotUserName");
      bcJ().removeValueForKey("KeyMainRedDotTime");
    }
    AppMethodBeat.o(207052);
  }
  
  public static boolean hgm()
  {
    return QTH;
  }
  
  public static boolean hgn()
  {
    return QTI;
  }
  
  public static void hgo()
  {
    AppMethodBeat.i(207069);
    if (QTG != null)
    {
      Log.d("MicroMsg.BizFinderLiveLogic", "stopCheckMaiCellRedDot");
      MTimerHandler localMTimerHandler = QTG;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      QTG = null;
    }
    AppMethodBeat.o(207069);
  }
  
  public static final String hgp()
  {
    AppMethodBeat.i(207071);
    String str = bcJ().decodeString("KeyMainCellRedDotUserName");
    AppMethodBeat.o(207071);
    return str;
  }
  
  public static final long hgq()
  {
    AppMethodBeat.i(207072);
    long l = bcJ().decodeLong("KeyMainRedDotTime", 0L);
    AppMethodBeat.o(207072);
    return l;
  }
  
  public static boolean nd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207024);
    if (paramString1 == null)
    {
      AppMethodBeat.o(207024);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207024);
      return false;
    }
    boolean bool = p.h(paramString2, MMKVSlotManager.decodeString$default(QTq, bpk(paramString1), null, 2, null));
    AppMethodBeat.o(207024);
    return bool;
  }
  
  private static boolean ne(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207025);
    if (paramString1 == null)
    {
      AppMethodBeat.o(207025);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207025);
      return false;
    }
    boolean bool = p.h((String)QTt.get(paramString1), paramString2);
    AppMethodBeat.o(207025);
    return bool;
  }
  
  private static boolean nf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207026);
    if ((ne(paramString1, paramString2)) || (nd(paramString1, paramString2)))
    {
      AppMethodBeat.o(207026);
      return true;
    }
    AppMethodBeat.o(207026);
    return false;
  }
  
  public static boolean nh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207029);
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207029);
      return false;
    }
    if (!ne(paramString1, paramString2))
    {
      AppMethodBeat.o(207029);
      return true;
    }
    AppMethodBeat.o(207029);
    return false;
  }
  
  public static boolean ni(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207030);
    boolean bool = p.h(Util.nullAsNil(bpq(paramString1)), Util.nullAsNil(paramString2));
    AppMethodBeat.o(207030);
    return bool ^ true;
  }
  
  public static void nj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207049);
    if (paramString1 == null)
    {
      AppMethodBeat.o(207049);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(207049);
      return;
    }
    ((MultiProcessMMKV)QTq.getSlotForWrite()).encode(bpv(paramString1), paramString2);
    AppMethodBeat.o(207049);
  }
  
  public static void nk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207070);
    if (paramString1 == null)
    {
      AppMethodBeat.o(207070);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(207070);
      return;
    }
    Log.i("MicroMsg.BizFinderLiveLogic", "saveFinderLiveRedDotInfo bizUserName=" + paramString1 + ", exportId=" + paramString2);
    bcJ().encode("KeyMainCellRedDotUserName", paramString1);
    bcJ().encode("KeyMainRedDotTime", bq.beS());
    AppMethodBeat.o(207070);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(207023);
    com.tencent.e.h.ZvG.be((Runnable)h.QUf);
    AppMethodBeat.o(207023);
  }
  
  public static void onResume()
  {
    AppMethodBeat.i(207022);
    if (MWt)
    {
      MWt = false;
      TM(9L);
      String str = QTs;
      b localb = b.QUa;
      a(str, true, b.hgD(), (kotlin.g.a.q)j.QUg);
    }
    AppMethodBeat.o(207022);
  }
  
  private static long z(z paramz)
  {
    AppMethodBeat.i(207038);
    p.k(paramz, "info");
    for (;;)
    {
      try
      {
        u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramz.field_msgId, paramz.field_content);
        if (localu == null) {
          continue;
        }
        paramz = localu.lpz;
        if (Util.isNullOrNil((List)paramz)) {
          continue;
        }
        paramz = (com.tencent.mm.aj.v)localu.lpz.get(0);
        if (Util.isNullOrNil(paramz.url)) {
          continue;
        }
        l = Util.getLong(Uri.parse(paramz.url).getQueryParameter("mid"), 0L);
      }
      catch (Exception paramz)
      {
        Log.w("MicroMsg.BizFinderLiveLogic", "reportLiveClickOp exp %s", new Object[] { paramz.getMessage() });
        long l = 0L;
        continue;
      }
      AppMethodBeat.o(207038);
      return l;
      paramz = null;
    }
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207021);
    p.k(paramContext, "context");
    if (paramString1 == null)
    {
      AppMethodBeat.o(207021);
      return;
    }
    if (paramString2 == null) {
      paramString2 = MMKVSlotManager.decodeString$default(QTq, bpl(paramString1), null, 2, null);
    }
    for (;;)
    {
      Object localObject = (CharSequence)paramString2;
      if ((localObject == null) || (n.ba((CharSequence)localObject)))
      {
        i = 1;
        localObject = paramString2;
        if (i != 0)
        {
          localObject = paramString2;
          if (p.h(paramString1, QTE)) {
            localObject = QTF;
          }
        }
        paramString2 = (CharSequence)localObject;
        if ((paramString2 != null) && (!n.ba(paramString2))) {
          break label157;
        }
      }
      label157:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label163;
        }
        Log.w("MicroMsg.BizFinderLiveLogic", "onClick bizUserName=" + paramString1 + ", exportId is null");
        AppMethodBeat.o(207021);
        return;
        i = 0;
        break;
      }
      label163:
      paramString2 = b.QUa;
      int j;
      if (b.hgA() == paramInt1)
      {
        i = 1;
        paramString2 = b.QUa;
        if (b.hgz() != paramInt1) {
          break label548;
        }
        j = 1;
        label193:
        boolean bool = j | i;
        if (bool) {
          ((Map)QTt).put(paramString1, localObject);
        }
        paramString2 = com.tencent.mm.storage.v.Vdz;
        if ((com.tencent.mm.storage.v.hAS()) && (p.h(hgp(), paramString1)))
        {
          Log.i("MicroMsg.BizFinderLiveLogic", "onClick update expose status");
          hgk();
          hgl();
          ab.hxj();
        }
        Log.i("MicroMsg.BizFinderLiveLogic", "onClick bizUserName=" + paramString1 + ", exportId=" + (String)localObject + ", isBarClick=" + bool + ", liveScene=" + paramInt2);
        if ((paramInt2 <= 0) && (QTB <= 0)) {
          break label583;
        }
        TM(66L);
        Intent localIntent = new Intent();
        paramString2 = b.QUa;
        if (paramInt1 != b.hgz())
        {
          paramString2 = b.QUa;
          if (paramInt1 != b.hgA())
          {
            paramString2 = b.QUa;
            if (paramInt1 != b.hgB()) {
              break label554;
            }
          }
        }
        i = 26;
        label380:
        localIntent.putExtra("key_entry_scene", i);
        localIntent.putExtra("key_biz_user_name", paramString1);
        localIntent.putExtra("key_feed_export_id", (String)localObject);
        paramString2 = bps(paramString1);
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
          break label569;
        }
        i = 1;
        label439:
        if (i != 0)
        {
          paramString2 = aa.PJ(paramString1);
          paramString2 = MMApplicationContext.getContext().getString(com.tencent.mm.plugin.biz.b.f.biz_finder_live, new Object[] { paramString2 });
        }
        localIntent.putExtra("key_page_title", paramString2);
        if (paramInt2 <= 0) {
          break label575;
        }
        label482:
        localIntent.putExtra("key_request_scene", paramInt2);
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).openFinderLiveOperationUI(paramContext, localIntent);
      }
      for (;;)
      {
        MWt = true;
        QTs = paramString1;
        yiD = paramInt1;
        TM(20L);
        if (1 <= paramInt1) {
          break label615;
        }
        AppMethodBeat.o(207021);
        return;
        i = 0;
        break;
        label548:
        j = 0;
        break label193;
        label554:
        paramString2 = b.QUa;
        b.hgC();
        i = 27;
        break label380;
        label569:
        i = 0;
        break label439;
        label575:
        paramInt2 = QTB;
        break label482;
        label583:
        TM(67L);
        ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveUIByBiz(paramContext, (String)localObject, paramString1, Integer.valueOf(paramInt1));
      }
      label615:
      if (19 >= paramInt1) {
        TM(paramInt1 + 20L);
      }
      AppMethodBeat.o(207021);
      return;
    }
  }
  
  public final boolean ng(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207027);
    if (bpt(paramString1))
    {
      AppMethodBeat.o(207027);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207027);
      return false;
    }
    if (!nf(paramString1, paramString2))
    {
      AppMethodBeat.o(207027);
      return true;
    }
    AppMethodBeat.o(207027);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$BizFinderLiveOpenFlag;", "", "()V", "bizProfile", "", "getBizProfile", "()I", "bizSession", "getBizSession", "cardTitle", "getCardTitle", "liveBar", "getLiveBar", "oftenRead", "getOftenRead", "webTopBar", "getWebTopBar", "plugin-biz_release"})
  public static final class a
  {
    private static final int QTK = 1;
    private static final int QTL = 2;
    private static final int QTM = 4;
    private static final int QTN = 8;
    private static final int QTO = 16;
    private static final int QTP = 32;
    public static final a QTQ;
    
    static
    {
      AppMethodBeat.i(209851);
      QTQ = new a();
      QTK = 1;
      QTL = 2;
      QTM = 4;
      QTN = 8;
      QTO = 16;
      QTP = 32;
      AppMethodBeat.o(209851);
    }
    
    public static int hgt()
    {
      return QTK;
    }
    
    public static int hgu()
    {
      return QTL;
    }
    
    public static int hgv()
    {
      return QTM;
    }
    
    public static int hgw()
    {
      return QTN;
    }
    
    public static int hgx()
    {
      return QTO;
    }
    
    public static int hgy()
    {
      return QTP;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$BizFinderLiveScene;", "", "()V", "REQ_SCENE_BACK_FROM_LIVE", "", "getREQ_SCENE_BACK_FROM_LIVE", "()I", "REQ_SCENE_BIZSSION", "getREQ_SCENE_BIZSSION", "REQ_SCENE_LIVE_BAR", "getREQ_SCENE_LIVE_BAR", "REQ_SCENE_MSG_CARD", "getREQ_SCENE_MSG_CARD", "REQ_SCENE_NOTIFY_CHECK", "getREQ_SCENE_NOTIFY_CHECK", "REQ_SCENE_OFTEN_READ", "getREQ_SCENE_OFTEN_READ", "REQ_SCENE_PROFILE", "getREQ_SCENE_PROFILE", "REQ_SCENE_RED_DOT_CHECK", "getREQ_SCENE_RED_DOT_CHECK", "REQ_SCENE_UNKNOWN", "getREQ_SCENE_UNKNOWN", "REQ_SCENE_WEBVIEW_TOP_BAR", "getREQ_SCENE_WEBVIEW_TOP_BAR", "plugin-biz_release"})
  public static final class b
  {
    private static final int QTR = 1;
    private static final int QTS = 2;
    private static final int QTT = 3;
    private static final int QTU = 4;
    private static final int QTV = 5;
    private static final int QTW = 6;
    private static final int QTX = 7;
    private static final int QTY = 8;
    private static final int QTZ = 9;
    public static final b QUa;
    
    static
    {
      AppMethodBeat.i(206284);
      QUa = new b();
      QTR = 1;
      QTS = 2;
      QTT = 3;
      QTU = 4;
      QTV = 5;
      QTW = 6;
      QTX = 7;
      QTY = 8;
      QTZ = 9;
      AppMethodBeat.o(206284);
    }
    
    public static int hgA()
    {
      return QTS;
    }
    
    public static int hgB()
    {
      return QTT;
    }
    
    public static int hgC()
    {
      return QTU;
    }
    
    public static int hgD()
    {
      return QTV;
    }
    
    public static int hgE()
    {
      return QTW;
    }
    
    public static int hgF()
    {
      return QTX;
    }
    
    public static int hgG()
    {
      return QTY;
    }
    
    public static int hgz()
    {
      return QTR;
    }
    
    public static int hwn()
    {
      return QTZ;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<kotlinx.coroutines.ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private kotlinx.coroutines.ak p$;
    
    c(boolean paramBoolean, String paramString, int paramInt, kotlin.g.a.q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(207373);
      p.k(paramd, "completion");
      paramd = new c(this.QUb, paramString, paramInt, paramq, paramd);
      paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
      AppMethodBeat.o(207373);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(207375);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(207375);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(207371);
      Object localObject2 = kotlin.d.a.a.aaAA;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207371);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        if (!this.QUb)
        {
          localObject1 = b.QTJ;
          if (!b.bpu(paramString)) {
            break label459;
          }
        }
        localObject1 = b.QTJ;
        if (b.hgr().containsKey(paramString))
        {
          paramObject = x.aazN;
          AppMethodBeat.o(207371);
          return paramObject;
        }
        localObject1 = b.QTJ;
        ((Map)b.hgr()).put(paramString, Boolean.TRUE);
        Log.d("MicroMsg.BizFinderLiveLogic", "checkFinderLive bizUserName=" + paramString + ", force=" + this.QUb);
        localObject1 = b.QTJ;
        i = paramInt;
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(paramString);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = b.a(i, (LinkedList)localObject1, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(207371);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (oe)paramObject;
      Object localObject1 = b.QTJ;
      b.hgr().remove(paramString);
      if (paramObject != null)
      {
        paramObject = paramObject.RVu;
        localObject1 = (Collection)paramObject;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label430;
        }
        i = 1;
        label282:
        if (i != 0) {
          break label459;
        }
        paramObject = ((Iterable)paramObject).iterator();
        label296:
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localObject1 = (oc)paramObject.next();
        } while (!Util.isEqual(((oc)localObject1).RKL, paramString));
        localObject2 = b.QTJ;
        if (!b.ni(((oc)localObject1).RKL, ((oc)localObject1).RVp)) {
          break label435;
        }
        paramq.c(paramString, ((oc)localObject1).RVp, Boolean.TRUE);
        Log.i("MicroMsg.BizFinderLiveLogic", "checkFinderLive data change bizUserName=" + ((oc)localObject1).RKL);
        localObject2 = b.QTJ;
        b.ax(paramString, ((oc)localObject1).RVp, paramInt);
      }
      for (;;)
      {
        localObject2 = b.QTJ;
        b.a((oc)localObject1);
        break label296;
        paramObject = null;
        break;
        label430:
        i = 0;
        break label282;
        label435:
        paramq.c(paramString, ((oc)localObject1).RVp, Boolean.FALSE);
      }
      label459:
      paramObject = x.aazN;
      AppMethodBeat.o(207371);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends kotlin.d.b.a.j
    implements m<kotlinx.coroutines.ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private kotlinx.coroutines.ak p$;
    
    d(String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(207203);
      p.k(paramd, "completion");
      paramd = new d(this.mtC, paramd);
      paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
      AppMethodBeat.o(207203);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(207204);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(207204);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(207202);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207202);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = b.QTJ;
        if (!b.hgn())
        {
          localObject1 = b.QTJ;
          if (b.bpu(this.mtC)) {}
        }
        else
        {
          Log.d("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify return");
          paramObject = x.aazN;
          AppMethodBeat.o(207202);
          return paramObject;
        }
        localObject1 = b.QTJ;
        b.DL(true);
        Log.d("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify");
        localObject1 = b.QTJ;
        localObject1 = b.b.QUa;
        int i = b.b.hgF();
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(this.mtC);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = b.a(i, (LinkedList)localObject1, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(207202);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (oe)paramObject;
      Object localObject1 = b.QTJ;
      b.DL(false);
      if (paramObject != null)
      {
        paramObject = paramObject.RVu;
        if (paramObject != null) {}
      }
      else
      {
        paramObject = x.aazN;
        AppMethodBeat.o(207202);
        return paramObject;
      }
      paramObject = ((Iterable)paramObject).iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (oc)paramObject.next();
        if (Util.isNullOrNil(((oc)localObject1).RVp))
        {
          Log.i("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify live stop!");
          localObject2 = b.QTJ;
          b.a((oc)localObject1);
          localObject2 = b.QTJ;
          b.bpx(((oc)localObject1).RKL);
          localObject1 = b.QTJ;
          b.hgl();
          localObject1 = b.QTJ;
          b.hgo();
          ab.hxj();
        }
        else
        {
          localObject2 = b.QTJ;
          b.a((oc)localObject1);
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(207202);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$ShowFinderDigestResult;", "", "showDigest", "", "showRedDot", "(ZZ)V", "getShowDigest", "()Z", "setShowDigest", "(Z)V", "getShowRedDot", "setShowRedDot", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-biz_release"})
  public static final class e
  {
    public boolean fUV;
    public boolean sTm;
    
    public e(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.sTm = paramBoolean1;
      this.fUV = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((this.sTm != paramObject.sTm) || (this.fUV != paramObject.fUV)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(292835);
      String str = "ShowFinderDigestResult(showDigest=" + this.sTm + ", showRedDot=" + this.fUV + ")";
      AppMethodBeat.o(292835);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final f QUd;
    
    static
    {
      AppMethodBeat.i(207846);
      QUd = new f();
      AppMethodBeat.o(207846);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final g QUe;
    
    static
    {
      AppMethodBeat.i(205257);
      QUe = new g();
      AppMethodBeat.o(205257);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    public static final h QUf;
    
    static
    {
      AppMethodBeat.i(205871);
      QUf = new h();
      AppMethodBeat.o(205871);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205868);
      Object localObject1 = b.QTJ;
      localObject1 = ((Map)b.hgb()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = b.QTJ;
        localObject2 = (MultiProcessMMKV)b.hga().getSlotForWrite();
        b localb = b.QTJ;
        ((MultiProcessMMKV)localObject2).encode(b.bpz((String)localEntry.getKey()), (String)localEntry.getValue());
      }
      localObject1 = b.QTJ;
      b.hgb().clear();
      AppMethodBeat.o(205868);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class i
    extends kotlin.d.b.a.j
    implements m<kotlinx.coroutines.ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private kotlinx.coroutines.ak p$;
    
    i(LinkedList paramLinkedList, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(205956);
      p.k(paramd, "completion");
      paramd = new i(this.svN, paramd);
      paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
      AppMethodBeat.o(205956);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(205958);
      paramObject1 = ((i)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(205958);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205951);
      Object localObject2 = kotlin.d.a.a.aaAA;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205951);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = b.QTJ;
        if (b.hgm())
        {
          paramObject = x.aazN;
          AppMethodBeat.o(205951);
          return paramObject;
        }
        localObject1 = b.QTJ;
        b.DK(true);
        Log.d("MicroMsg.BizFinderLiveLogic", "onFinderLiveRedDotNotify");
        localObject1 = b.QTJ;
        localObject1 = b.b.QUa;
        i = b.b.hgE();
        localObject1 = this.svN;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = b.a(i, (LinkedList)localObject1, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(205951);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (oe)paramObject;
      Object localObject1 = b.QTJ;
      b.DK(false);
      if (paramObject != null)
      {
        paramObject = paramObject.RVu;
        localObject1 = (Collection)paramObject;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label332;
        }
        i = 1;
      }
      for (;;)
      {
        label194:
        if (i == 0)
        {
          localObject1 = ((Iterable)paramObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              paramObject = (oc)((Iterator)localObject1).next();
              if (!Util.isNullOrNil(paramObject.RVp))
              {
                localObject1 = b.QTJ;
                localObject1 = b.bcJ().decodeString("KeyLastMainCellRedDotUserName", "");
                localObject2 = b.QTJ;
                localObject2 = b.hga();
                b localb = b.QTJ;
                p.j(localObject1, "lastRedDotUserName");
                localObject2 = ((MMKVSlotManager)localObject2).decodeString(b.bpA((String)localObject1), "");
                if ((p.h(localObject1, paramObject.RKL)) && (p.h(localObject2, paramObject.RVp)))
                {
                  Log.i("MicroMsg.BizFinderLiveLogic", "onFinderLiveRedDotNotify same live return!");
                  paramObject = x.aazN;
                  AppMethodBeat.o(205951);
                  return paramObject;
                  paramObject = null;
                  break;
                  label332:
                  i = 0;
                  break label194;
                }
                Log.i("MicroMsg.BizFinderLiveLogic", "onFinderLiveRedDotNotify live start!");
                localObject1 = b.QTJ;
                b.a(paramObject);
                localObject1 = b.QTJ;
                b.nk(paramObject.RKL, paramObject.RVp);
                ab.hxj();
                paramObject = x.aazN;
                AppMethodBeat.o(205951);
                return paramObject;
              }
            }
          }
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(205951);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, Boolean, x>
  {
    public static final j QUg;
    
    static
    {
      AppMethodBeat.i(207347);
      QUg = new j();
      AppMethodBeat.o(207347);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final k QUh;
    
    static
    {
      AppMethodBeat.i(205578);
      QUh = new k();
      AppMethodBeat.o(205578);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final l QUi;
    
    static
    {
      AppMethodBeat.i(207292);
      QUi = new l();
      AppMethodBeat.o(207292);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final m QUj;
    
    static
    {
      AppMethodBeat.i(207254);
      QUj = new m();
      AppMethodBeat.o(207254);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final n QUk;
    
    static
    {
      AppMethodBeat.i(207762);
      QUk = new n();
      AppMethodBeat.o(207762);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final o QUl;
    
    static
    {
      AppMethodBeat.i(205655);
      QUl = new o();
      AppMethodBeat.o(205655);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final p QUm;
    
    static
    {
      AppMethodBeat.i(207243);
      QUm = new p();
      AppMethodBeat.o(207243);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final q QUn;
    
    static
    {
      AppMethodBeat.i(207764);
      QUn = new q();
      AppMethodBeat.o(207764);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  public static final class r
    implements MTimerHandler.CallBack
  {
    public static final r QUo;
    
    static
    {
      AppMethodBeat.i(205789);
      QUo = new r();
      AppMethodBeat.o(205789);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(205787);
      Object localObject1 = b.hgp();
      Object localObject2 = (CharSequence)localObject1;
      int i;
      if ((localObject2 == null) || (n.ba((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label61;
        }
        localObject2 = com.tencent.mm.storage.v.Vdz;
        if (!com.tencent.mm.storage.v.hAS()) {
          break label61;
        }
        localObject2 = b.QTJ;
        b.bpy((String)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(205787);
        return true;
        i = 0;
        break;
        label61:
        Log.d("MicroMsg.BizFinderLiveLogic", "startCheckMaiCellRedDot not show finderReadDot");
        localObject1 = b.QTJ;
        b.hgo();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */