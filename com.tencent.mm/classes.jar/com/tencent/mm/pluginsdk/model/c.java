package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.protocal.protobuf.fnc;
import com.tencent.mm.protocal.protobuf.geq;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic;", "", "()V", "MAX_FINDER_LIVE_SHOW_COUNT", "", "TAG", "", "cacheCardTitleLiveExpose", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Lkotlin/collections/HashMap;", "getCacheCardTitleLiveExpose", "()Ljava/util/HashMap;", "cacheLiveBarExpose", "getCacheLiveBarExpose", "clickRedDotCoverUrl", "getClickRedDotCoverUrl", "()Ljava/lang/String;", "setClickRedDotCoverUrl", "(Ljava/lang/String;)V", "clickRedDotExportId", "getClickRedDotExportId", "setClickRedDotExportId", "clickRedDotUserName", "getClickRedDotUserName", "setClickRedDotUserName", "clickScene", "getClickScene", "()I", "setClickScene", "(I)V", "exportIdExpireTime", "hasPreloadWeApp", "", "getHasPreloadWeApp", "()Z", "setHasPreloadWeApp", "(Z)V", "isCheckingFinderLiveRedDot", "setCheckingFinderLiveRedDot", "isClick", "setClick", "isForceOpen", "isForceOpen$delegate", "Lkotlin/Lazy;", "isGettingFinderLiveRedDot", "setGettingFinderLiveRedDot", "isUpdatingLiveBar", "liveBarItemMaxExposedTimes", "getLiveBarItemMaxExposedTimes", "liveBarItemMaxExposedTimes$delegate", "liveRedDotMaxExposedTimes", "getLiveRedDotMaxExposedTimes", "liveRedDotMaxExposedTimes$delegate", "mainCellRedDotTimeKey", "mainCellRedDotUserNameKey", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "onClickUser", "openBizProfileLive", "getOpenBizProfileLive", "openBizProfileLive$delegate", "openBizSessionLive", "getOpenBizSessionLive", "openBizSessionLive$delegate", "openCardTitleLive", "getOpenCardTitleLive", "openCardTitleLive$delegate", "openFinderLiveBar", "getOpenFinderLiveBar", "openFinderLiveBar$delegate", "openFlag", "getOpenFlag", "openFlag$delegate", "openOftenReadLive", "getOpenOftenReadLive", "openOftenReadLive$delegate", "openWebTopBarLive", "getOpenWebTopBarLive", "openWebTopBarLive$delegate", "slot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "updateMainCellRedDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "updatingLiveMap", "canShowLiveBarItem", "info", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveInfo;", "canShowOftenReadRedDot", "checkBizFinderLiveBar", "", "checkClickUser", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/TimelineOftenReadBizInfo;", "checkFinderLive", "bizUserName", "force", "scene", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "exportId", "isChange", "checkLiveBarClickUser", "checkLiveRedDotNotify", "userName", "clearCacheData", "forceOpen", "getBizFinderLiveInfo", "getBizFinderLives", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveResp;", "_scene", "_bizUserName", "(ILjava/util/LinkedList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExportId", "getFuncFlag", "getKeepDataInterval", "getListRefreshInterval", "getLiveBarExposeTimesToDay", "index", "getLiveBarRefreshTime", "getLiveBarResp", "getLiveScene", "getMainCellRedDotTime", "getMainCellRedDotUserName", "getMidFromBizInfo", "getOftenReadSvrOpen", "getRedDotClickExportId", "getRedDotExposeTimesToDay", "getSvrOpenFlag", "isAllLiveBarItemExposed", "", "isExportIdChange", "finderFeedExportId", "isLiveBarItemExposed", "isLiveNow", "isOftenReadLiveClick", "isPreloadLiveBarOpen", "isRedDotUserShowCircle", "isShowCircleForOftenRead", "oftenReadClick", "onCardTitleLiveExposed", "onClick", "context", "Landroid/content/Context;", "liveScene", "liveList", "bypass", "onDestroy", "onFinderLiveRedDotNotify", "onLiveBarExposed", "onMainCellRedDotClick", "onOftenReadLiveExpose", "onResume", "preCheckLiveBar", "publishLiveStatusChangeEvent", "reportCardTitleLive", "sessionId", "reportIdKey1703", "value", "reportLiveClickOp", "bizInfo", "resetMainCellRedDotInfo", "resetRedDotClickInfo", "saveBizFinderLiveInfo", "saveFinderLiveRedDotInfo", "saveFuncFlag", "flag", "saveKeepDataInterval", "interval", "saveListRefreshInterval", "saveLiveBarListRefreshTime", "time", "saveLiveBarResp", "resp", "saveOftenReadSvrOpen", "showFinderLive", "saveSvrOpenFlag", "setShowLiveBarWhenExpose", "show", "shouldRefreshNow", "shouldShowFinderDigest", "Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$ShowFinderDigestResult;", "msgTime", "showLiveBarAfterExpose", "startCheckMainCellRedDot", "stopCheckMaiCellRedDot", "todayIndex", "updateBizFinderLiveInfoTime", "updateLiveBarExposeTimes", "updateRedDotExposeTimes", "clickExportIdKey", "exportIdKey", "exposeExportIdKey", "finderLiveInfoKey", "liveBarDateExportTimesKey", "liveBarExposeExportIdKey", "liveRedDotDateExportTimesKey", "liveSceneKey", "oftenReadClickKey", "refreshIntervalKey", "saveExportIdTimeKey", "BizFinderLiveFuncFlag", "BizFinderLiveOpenFlag", "BizFinderLiveScene", "ShowFinderDigestResult", "SvrFinderLiveControlBit", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static int CIH;
  private static boolean TIX;
  private static final kotlin.j XPA;
  private static final kotlin.j XPB;
  private static final kotlin.j XPC;
  private static final kotlin.j XPD;
  private static final kotlin.j XPE;
  private static final kotlin.j XPF;
  static final kotlin.j XPG;
  private static boolean XPH;
  private static final HashMap<Long, com.tencent.mm.storage.ab> XPI;
  private static final kotlin.j XPJ;
  public static String XPK;
  private static String XPL;
  private static String XPM;
  private static MTimerHandler XPN;
  private static boolean XPO;
  private static boolean XPP;
  public static final c XPt;
  static final MMKVSlotManager XPu;
  private static HashMap<String, Boolean> XPv;
  private static String XPw;
  private static final HashMap<String, String> XPx;
  private static final kotlin.j XPy;
  private static final kotlin.j XPz;
  private static final kotlin.j exj;
  private static boolean vOr;
  
  static
  {
    AppMethodBeat.i(245076);
    XPt = new c();
    exj = kotlin.k.cm((kotlin.g.a.a)k.XQe);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    s.s(localMultiProcessMMKV, "mmkv");
    XPu = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    XPv = new HashMap();
    XPx = new HashMap();
    XPy = kotlin.k.cm((kotlin.g.a.a)r.XQk);
    XPz = kotlin.k.cm((kotlin.g.a.a)s.XQl);
    XPA = kotlin.k.cm((kotlin.g.a.a)q.XQj);
    XPB = kotlin.k.cm((kotlin.g.a.a)p.XQi);
    XPC = kotlin.k.cm((kotlin.g.a.a)o.XQh);
    XPD = kotlin.k.cm((kotlin.g.a.a)n.XQg);
    XPE = kotlin.k.cm((kotlin.g.a.a)t.XQm);
    XPF = kotlin.k.cm((kotlin.g.a.a)i.XQc);
    XPG = kotlin.k.cm((kotlin.g.a.a)j.XQd);
    CIH = 2;
    XPI = new HashMap();
    XPJ = kotlin.k.cm((kotlin.g.a.a)h.XQb);
    AppMethodBeat.o(245076);
  }
  
  public static void Jp(boolean paramBoolean)
  {
    AppMethodBeat.i(244959);
    atj().encode("SvrShowFinderLive", paramBoolean);
    Log.d("MicroMsg.BizFinderLiveLogic", s.X("showOftenReadFinderLive = ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(244959);
  }
  
  public static void Jq(boolean paramBoolean)
  {
    AppMethodBeat.i(244977);
    atj().encode("forceOpenLive", paramBoolean);
    AppMethodBeat.o(244977);
  }
  
  public static void Jr(boolean paramBoolean)
  {
    XPO = paramBoolean;
  }
  
  public static void Js(boolean paramBoolean)
  {
    XPP = paramBoolean;
  }
  
  public static Object a(final int paramInt, LinkedList<String> paramLinkedList, kotlin.d.d<? super pn> paramd)
  {
    AppMethodBeat.i(244827);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject = new c.a();
    pm localpm = new pm();
    localpm.scene = paramInt;
    if (paramLinkedList != null) {
      localpm.YSU = paramLinkedList;
    }
    atj().decodeBytes("FinderLiveBuffer");
    localpm.YSW = 30;
    ah localah = ah.aiuX;
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localpm);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new pn());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/timeline/bizfinderlive";
    ((c.a)localObject).funcId = 4703;
    localObject = ((c.a)localObject).bEF();
    Log.i("MicroMsg.BizFinderLiveLogic", s.X("getBizFinderLives scene=", Integer.valueOf(paramInt)));
    xY(0L);
    int i;
    if (paramInt > 0) {
      if (paramInt <= 19) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        xY(40L + paramInt);
      }
      if (paramLinkedList == null) {
        break;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext()) {
        bph((String)paramLinkedList.next());
      }
      i = 0;
      continue;
      i = 0;
    }
    IPCRunCgi.a((com.tencent.mm.am.c)localObject, (IPCRunCgi.a)new g(new ah.a(), locald, paramInt));
    paramLinkedList = localh.kli();
    if (paramLinkedList == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(244827);
    return paramLinkedList;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, List<? extends pi> paramList, String paramString3)
  {
    AppMethodBeat.i(244884);
    s.u(paramContext, "context");
    if (paramString1 == null)
    {
      AppMethodBeat.o(244884);
      return;
    }
    Object localObject1;
    int i;
    if (paramString2 == null)
    {
      paramString2 = MMKVSlotManager.decodeString$default(XPu, s.X("exportId-", paramString1), null, 2, null);
      localObject1 = (CharSequence)paramString2;
      if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
        break label152;
      }
      i = 1;
      label67:
      if ((i == 0) || (!s.p(paramString1, XPK))) {
        break label1000;
      }
      paramString2 = XPL;
    }
    label152:
    label164:
    label722:
    label988:
    label994:
    label1000:
    for (;;)
    {
      localObject1 = (CharSequence)paramString2;
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label164;
        }
        Log.w("MicroMsg.BizFinderLiveLogic", "onClick bizUserName=" + paramString1 + ", exportId is null");
        AppMethodBeat.o(244884);
        return;
        break;
        i = 0;
        break label67;
      }
      if (1 == paramInt1) {
        oY(paramString1, paramString2);
      }
      localObject1 = com.tencent.mm.storage.v.acEJ;
      if ((com.tencent.mm.storage.v.iXR()) && (s.p(iHs(), paramString1)))
      {
        Log.i("MicroMsg.BizFinderLiveLogic", "onClick update expose status");
        iHm();
        iHn();
        ad.iYO();
      }
      Log.i("MicroMsg.BizFinderLiveLogic", "onClick bizUserName=" + paramString1 + ", exportId=" + paramString2 + ", liveScene=" + paramInt2);
      localObject1 = bpg(paramString1);
      Object localObject2;
      if ((localObject1 != null) && (((pi)localObject1).YSO))
      {
        localObject2 = ((pi)localObject1).YSP;
        if (localObject2 != null)
        {
          localObject2 = ((geq)localObject2).appid;
          if (localObject2 != null) {
            if (n.bp((CharSequence)localObject2))
            {
              i = 1;
              if (i != 1) {
                break label518;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label524;
          }
          xY(68L);
          paramContext = new com.tencent.mm.plugin.appbrand.api.g();
          paramContext.appId = ((pi)localObject1).YSP.appid;
          paramContext.euz = ((pi)localObject1).YSP.Tqb;
          paramContext.scene = 1214;
          paramString1 = new d();
          paramString2 = ((pi)localObject1).YSP.acch;
          if (paramString2 != null) {
            paramString1.vPX = paramString2.ZV();
          }
          paramString1.scene = paramInt1;
          paramString1.XQo = paramString3;
          paramContext.qAG = ((com.tencent.mm.plugin.appbrand.api.d)paramString1);
          paramContext.qAF = ((pi)localObject1).YSP.path;
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(MMApplicationContext.getContext(), paramContext);
          Log.i("MicroMsg.BizFinderLiveLogic", "onClick use WeApp appId = " + paramContext.appId + ", versionType=" + paramContext.euz + ", enterPath=" + paramContext.qAF);
          AppMethodBeat.o(244884);
          return;
          i = 0;
          break;
        }
      }
      if (paramInt2 > 0)
      {
        xY(66L);
        paramList = new Intent();
        switch (paramInt1)
        {
        default: 
          i = 27;
          paramList.putExtra("key_entry_scene", i);
          paramList.putExtra("key_biz_user_name", paramString1);
          paramList.putExtra("key_feed_export_id", paramString2);
          if (localObject1 == null)
          {
            paramString2 = null;
            label618:
            localObject1 = (CharSequence)paramString2;
            if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
              break label801;
            }
            i = 1;
            if (i != 0)
            {
              paramString2 = aa.getDisplayName(paramString1);
              paramString2 = MMApplicationContext.getContext().getString(b.f.biz_finder_live, new Object[] { paramString2 });
            }
            paramList.putExtra("key_page_title", paramString2);
            paramList.putExtra("key_request_scene", paramInt2);
            if (paramString3 != null) {
              paramList.putExtra("key_by_pass", paramString3);
            }
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).openFinderLiveOperationUI(paramContext, paramList);
            TIX = true;
            XPw = paramString1;
            CIH = paramInt1;
            xY(20L);
            if (paramInt1 <= 0) {
              break label994;
            }
            if (paramInt1 > 19) {
              break label988;
            }
            paramInt2 = 1;
          }
          break;
        }
      }
      for (;;)
      {
        if (paramInt2 != 0) {
          xY(20L + paramInt1);
        }
        AppMethodBeat.o(244884);
        return;
        i = 26;
        break;
        i = 27;
        break;
        paramString2 = ((pi)localObject1).title;
        break label618;
        i = 0;
        break label640;
        xY(67L);
        paramString3 = null;
        localObject1 = null;
        localObject2 = (Collection)paramList;
        if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
        for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
        {
          localObject2 = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          paramString3 = (String)localObject2;
          localObject1 = localLinkedList;
          if (paramList == null) {
            break;
          }
          paramList = ((Iterable)paramList).iterator();
          for (;;)
          {
            paramString3 = (String)localObject2;
            localObject1 = localLinkedList;
            if (!paramList.hasNext()) {
              break;
            }
            paramString3 = (pi)paramList.next();
            ((LinkedList)localObject2).add(paramString3.YSM);
            localLinkedList.add(paramString3.YIf);
          }
        }
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveUIByBiz(paramContext, paramString2, paramString1, Integer.valueOf(paramInt1), (List)paramString3, (List)localObject1);
        break label722;
        paramInt2 = 0;
        continue;
        paramInt2 = 0;
      }
    }
  }
  
  public static void a(pi parampi)
  {
    AppMethodBeat.i(244862);
    if (parampi == null)
    {
      AppMethodBeat.o(244862);
      return;
    }
    Object localObject = parampi.YIf;
    if (localObject == null)
    {
      AppMethodBeat.o(244862);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)XPu.getSlotForWrite();
    s.s(localObject, "bizUserName");
    localMultiProcessMMKV.encode(s.X("exportId-", localObject), Util.nullAsNil(parampi.YSM));
    bph((String)localObject);
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(bpe((String)localObject), parampi.wrl);
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("live_scene-", localObject), parampi.YSN);
    try
    {
      ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("biz_finder_live_info-", localObject), parampi.toByteArray());
      if ((parampi.YSO) && (!XPH))
      {
        XPH = true;
        ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(com.tencent.mm.plugin.appbrand.service.ab.tTZ);
      }
      localObject = (CharSequence)parampi.YSM;
      if ((localObject == null) || (n.bp((CharSequence)localObject)))
      {
        i = 1;
        if (i == 0) {
          Log.i("MicroMsg.BizFinderLiveLogic", "saveBizFinderLiveInfo " + parampi.YIf + ' ' + parampi.YSM + " useWeApp:" + parampi.YSO);
        }
        AppMethodBeat.o(244862);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.BizFinderLiveLogic", s.X("saveBizFinderLiveInfo ex ", localException.getMessage()));
        continue;
        int i = 0;
      }
    }
  }
  
  public static void a(pn parampn)
  {
    AppMethodBeat.i(244849);
    s.u(parampn, "resp");
    try
    {
      atj().encode("live_bar_resp_data", parampn.toByteArray());
      int i = parampn.func_flag;
      atj().encode("biz_finder_live_func_flag", i);
      AppMethodBeat.o(244849);
      return;
    }
    catch (Exception parampn)
    {
      Log.w("MicroMsg.BizFinderLiveLogic", s.X("saveLiveBarResp ex ", parampn.getMessage()));
      AppMethodBeat.o(244849);
    }
  }
  
  public static void a(final String paramString, boolean paramBoolean, final int paramInt, final q<? super String, ? super String, ? super Boolean, ah> paramq)
  {
    AppMethodBeat.i(244932);
    s.u(paramq, "block");
    if (paramString == null)
    {
      AppMethodBeat.o(244932);
      return;
    }
    kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new e(paramBoolean, paramString, paramInt, paramq, null), 2);
    AppMethodBeat.o(244932);
  }
  
  public static void aJ(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(244935);
    Log.d("MicroMsg.BizFinderLiveLogic", "publishLiveStatusChangeEvent bizUserName=" + paramString1 + ", exportId=" + paramString2 + ", scene=" + paramInt);
    at localat = new at();
    localat.hAv.hAw = paramString1;
    localat.hAv.hAx = paramString2;
    localat.hAv.scene = paramInt;
    localat.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(244935);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(244764);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(244764);
    return localMultiProcessMMKV;
  }
  
  public static void avD(int paramInt)
  {
    AppMethodBeat.i(244952);
    Iterator localIterator = ((Map)XPI).entrySet().iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.storage.ab localab = (com.tencent.mm.storage.ab)((Map.Entry)localIterator.next()).getValue();
      long l = y(localab);
      if (localab.acFB) {}
      for (int i = 1;; i = 0)
      {
        localab.acFB = false;
        int j = bpj(localab.field_talker);
        String str = bpi(localab.field_talker);
        com.tencent.mm.plugin.report.service.h.OAn.b(23056, new Object[] { localab.field_talker, Long.valueOf(l), Long.valueOf(localab.acFA), Integer.valueOf(paramInt), str, Integer.valueOf(i), Integer.valueOf(j) });
        break;
      }
    }
    AppMethodBeat.o(244952);
  }
  
  public static void b(String paramString, com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(244948);
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = ad.getSessionId();
    long l = 0L;
    if (paramab != null) {
      l = y(paramab);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramString, Long.valueOf(l), Integer.valueOf(26), Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(244948);
  }
  
  public static String bpe(String paramString)
  {
    AppMethodBeat.i(244772);
    s.u(paramString, "<this>");
    paramString = s.X("refreshInterval-", paramString);
    AppMethodBeat.o(244772);
    return paramString;
  }
  
  public static boolean bpf(String paramString)
  {
    AppMethodBeat.i(244856);
    if (paramString == null)
    {
      AppMethodBeat.o(244856);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)MMKVSlotManager.decodeString$default(XPu, s.X("exportId-", paramString), null, 2, null);
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244856);
      return false;
    }
    long l = XPu.decodeLong(s.X("saveExportIdTime-", paramString), 0L);
    if (System.currentTimeMillis() - l > 21600000L)
    {
      Log.i("MicroMsg.BizFinderLiveLogic", "isLiveNow expired live status");
      AppMethodBeat.o(244856);
      return false;
    }
    AppMethodBeat.o(244856);
    return true;
  }
  
  private static pi bpg(String paramString)
  {
    AppMethodBeat.i(244866);
    if (paramString == null)
    {
      AppMethodBeat.o(244866);
      return null;
    }
    Object localObject = XPu;
    paramString = s.X("biz_finder_live_info-", paramString);
    localObject = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramString);
    if (localObject == null) {}
    label145:
    for (paramString = null;; paramString = null)
    {
      paramString = (pi)paramString;
      AppMethodBeat.o(244866);
      return paramString;
      if (((MultiProcessMMKV)localObject).containsKey(paramString))
      {
        paramString = ((MultiProcessMMKV)localObject).decodeBytes(paramString);
        if (paramString != null)
        {
          if (paramString.length == 0)
          {
            i = 1;
            label83:
            if (i != 0) {
              break label122;
            }
          }
          for (int i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label145;
              }
              try
              {
                localObject = pi.class.newInstance();
                ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
                paramString = (com.tencent.mm.bx.a)localObject;
              }
              catch (Exception paramString)
              {
                label122:
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label83;
          }
        }
      }
    }
  }
  
  private static void bph(String paramString)
  {
    AppMethodBeat.i(244869);
    if (paramString == null)
    {
      AppMethodBeat.o(244869);
      return;
    }
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("saveExportIdTime-", paramString), System.currentTimeMillis());
    AppMethodBeat.o(244869);
  }
  
  public static String bpi(String paramString)
  {
    AppMethodBeat.i(244871);
    if (paramString == null)
    {
      AppMethodBeat.o(244871);
      return null;
    }
    paramString = MMKVSlotManager.decodeString$default(XPu, s.X("exportId-", paramString), null, 2, null);
    AppMethodBeat.o(244871);
    return paramString;
  }
  
  public static int bpj(String paramString)
  {
    AppMethodBeat.i(244872);
    if (paramString == null)
    {
      AppMethodBeat.o(244872);
      return 0;
    }
    int i = XPu.decodeInt(s.X("live_scene-", paramString), 0);
    AppMethodBeat.o(244872);
    return i;
  }
  
  public static boolean bpk(String paramString)
  {
    AppMethodBeat.i(244919);
    if (s.p(paramString, XPK))
    {
      paramString = (CharSequence)XPL;
      if ((paramString == null) || (n.bp(paramString))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(244919);
        return true;
      }
    }
    AppMethodBeat.o(244919);
    return false;
  }
  
  public static boolean bpl(String paramString)
  {
    AppMethodBeat.i(244927);
    if (paramString == null)
    {
      AppMethodBeat.o(244927);
      return false;
    }
    int i = kotlin.k.k.qu(MMKVSlotManager.decodeInt$default(XPu, bpe(paramString), 0, 2, null), 5);
    long l = MMKVSlotManager.decodeLong$default(XPu, s.X("saveExportIdTime-", paramString), 0L, 2, null);
    if (System.currentTimeMillis() - l > i * 1000)
    {
      AppMethodBeat.o(244927);
      return true;
    }
    AppMethodBeat.o(244927);
    return false;
  }
  
  static String bpm(String paramString)
  {
    AppMethodBeat.i(244984);
    paramString = s.X("expose-exportId-", paramString);
    AppMethodBeat.o(244984);
    return paramString;
  }
  
  public static void bpn(String paramString)
  {
    XPM = paramString;
  }
  
  public static String bpo(String paramString)
  {
    AppMethodBeat.i(245012);
    if (paramString == null)
    {
      AppMethodBeat.o(245012);
      return "";
    }
    paramString = XPu.decodeString(s.X("click-exportId-", paramString), "");
    AppMethodBeat.o(245012);
    return paramString;
  }
  
  public static void bpp(String paramString)
  {
    AppMethodBeat.i(245019);
    if ((XPK != null) && (s.p(paramString, XPK)))
    {
      XPK = null;
      XPL = null;
      XPM = null;
    }
    AppMethodBeat.o(245019);
  }
  
  public static void cn(LinkedList<fnc> paramLinkedList)
  {
    AppMethodBeat.i(245029);
    s.u(paramLinkedList, "list");
    Object localObject = (CharSequence)XPK;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)XPL;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
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
      AppMethodBeat.o(245029);
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
      } while (!s.p(((fnc)((Iterator)localObject).next()).YIf, XPK));
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new fnc();
        ((fnc)localObject).YIf = XPK;
        ((fnc)localObject).YSM = XPL;
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(245029);
      return;
    }
  }
  
  public static void co(LinkedList<pi> paramLinkedList)
  {
    AppMethodBeat.i(245033);
    s.u(paramLinkedList, "list");
    Object localObject = (CharSequence)XPK;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)XPL;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
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
      AppMethodBeat.o(245033);
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
      } while (!s.p(((pi)((Iterator)localObject).next()).YIf, XPK));
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new pi();
        ((pi)localObject).YIf = XPK;
        ((pi)localObject).YSM = XPL;
        ((pi)localObject).nUM = XPM;
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(245033);
      return;
    }
  }
  
  public static void cp(LinkedList<fnc> paramLinkedList)
  {
    AppMethodBeat.i(245039);
    s.u(paramLinkedList, "list");
    LinkedList localLinkedList = new LinkedList();
    Object localObject = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.add(((fnc)((Iterator)localObject).next()).YIf);
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    if (((Collection)localLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(245039);
      return;
    }
    kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new l(localLinkedList, null), 2);
    AppMethodBeat.o(245039);
  }
  
  public static MMKVSlotManager iGU()
  {
    return XPu;
  }
  
  public static int iGV()
  {
    AppMethodBeat.i(244777);
    int i = ((Number)XPy.getValue()).intValue();
    AppMethodBeat.o(244777);
    return i;
  }
  
  public static boolean iGW()
  {
    AppMethodBeat.i(244781);
    boolean bool = ((Boolean)XPz.getValue()).booleanValue();
    AppMethodBeat.o(244781);
    return bool;
  }
  
  public static boolean iGX()
  {
    AppMethodBeat.i(244785);
    boolean bool = ((Boolean)XPA.getValue()).booleanValue();
    AppMethodBeat.o(244785);
    return bool;
  }
  
  public static boolean iGY()
  {
    AppMethodBeat.i(244790);
    boolean bool = ((Boolean)XPB.getValue()).booleanValue();
    AppMethodBeat.o(244790);
    return bool;
  }
  
  public static boolean iGZ()
  {
    AppMethodBeat.i(244799);
    boolean bool = ((Boolean)XPC.getValue()).booleanValue();
    AppMethodBeat.o(244799);
    return bool;
  }
  
  public static boolean iHa()
  {
    AppMethodBeat.i(244805);
    boolean bool = ((Boolean)XPD.getValue()).booleanValue();
    AppMethodBeat.o(244805);
    return bool;
  }
  
  public static boolean iHb()
  {
    AppMethodBeat.i(244810);
    boolean bool = ((Boolean)XPE.getValue()).booleanValue();
    AppMethodBeat.o(244810);
    return bool;
  }
  
  public static int iHc()
  {
    AppMethodBeat.i(244818);
    int i = ((Number)XPF.getValue()).intValue();
    AppMethodBeat.o(244818);
    return i;
  }
  
  public static long iHd()
  {
    AppMethodBeat.i(244843);
    long l = atj().decodeLong("live_bar_list_last_refresh_time", 0L);
    AppMethodBeat.o(244843);
    return l;
  }
  
  public static pn iHe()
  {
    int j = 1;
    AppMethodBeat.i(244854);
    Object localObject1 = atj();
    s.s(localObject1, "mmkv");
    int i;
    if (((MultiProcessMMKV)localObject1).containsKey("live_bar_resp_data"))
    {
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("live_bar_resp_data");
      if (localObject1 != null) {
        if (localObject1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label97;
          }
          i = j;
          label54:
          if (i == 0) {
            break label120;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = pn.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (pn)localObject1;
        AppMethodBeat.o(244854);
        return localObject1;
      }
      catch (Exception localException)
      {
        label97:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label54;
      label120:
      Object localObject2 = null;
    }
  }
  
  public static void iHf()
  {
    AppMethodBeat.i(244928);
    XPx.clear();
    ((MultiProcessMMKV)XPu.getSlotForWrite()).clearAll();
    AppMethodBeat.o(244928);
  }
  
  public static boolean iHg()
  {
    AppMethodBeat.i(244930);
    boolean bool = atj().decodeBool("showLiveBarWhenExpose", false);
    AppMethodBeat.o(244930);
    return bool;
  }
  
  public static int iHh()
  {
    AppMethodBeat.i(244965);
    int i = atj().decodeInt("SvrOpenFlag", 0);
    Log.i("MicroMsg.BizFinderLiveLogic", s.X("SvrOpenFlag ", Integer.valueOf(i)));
    AppMethodBeat.o(244965);
    return i;
  }
  
  public static boolean iHi()
  {
    AppMethodBeat.i(244972);
    boolean bool = ((Boolean)XPJ.getValue()).booleanValue();
    AppMethodBeat.o(244972);
    return bool;
  }
  
  public static String iHj()
  {
    return XPK;
  }
  
  public static String iHk()
  {
    return XPL;
  }
  
  public static int iHl()
  {
    AppMethodBeat.i(245002);
    int i = (int)(System.currentTimeMillis() / 86400000L);
    AppMethodBeat.o(245002);
    return i;
  }
  
  public static void iHm()
  {
    AppMethodBeat.i(245010);
    String str1 = iHs();
    if (str1 == null)
    {
      AppMethodBeat.o(245010);
      return;
    }
    String str2 = bpi(str1);
    if (str2 == null)
    {
      AppMethodBeat.o(245010);
      return;
    }
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("click-exportId-", str1), str2);
    XPK = str1;
    XPL = str2;
    AppMethodBeat.o(245010);
  }
  
  public static void iHn()
  {
    AppMethodBeat.i(245015);
    if (atj().containsKey("KeyMainCellRedDotUserName"))
    {
      atj().removeValueForKey("KeyMainCellRedDotUserName");
      atj().removeValueForKey("KeyMainRedDotTime");
    }
    AppMethodBeat.o(245015);
  }
  
  public static boolean iHo()
  {
    return XPO;
  }
  
  public static boolean iHp()
  {
    return XPP;
  }
  
  public static void iHq()
  {
    AppMethodBeat.i(245045);
    if (XPN != null)
    {
      AppMethodBeat.o(245045);
      return;
    }
    Object localObject = iHs();
    if (localObject == null)
    {
      AppMethodBeat.o(245045);
      return;
    }
    long l = kotlin.k.k.qu(MMKVSlotManager.decodeInt$default(XPu, bpe((String)localObject), 0, 2, null), 10) * 1000 / 2L;
    Log.d("MicroMsg.BizFinderLiveLogic", s.X("startCheckMaiCellRedDot interval=", Long.valueOf(l)));
    localObject = new MTimerHandler("updateMainCellFinderLiveRedDotTimer", c..ExternalSyntheticLambda0.INSTANCE, true);
    XPN = (MTimerHandler)localObject;
    ((MTimerHandler)localObject).startTimer(500L, l);
    AppMethodBeat.o(245045);
  }
  
  public static void iHr()
  {
    AppMethodBeat.i(245047);
    if (XPN != null)
    {
      Log.d("MicroMsg.BizFinderLiveLogic", "stopCheckMaiCellRedDot");
      MTimerHandler localMTimerHandler = XPN;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      XPN = null;
    }
    AppMethodBeat.o(245047);
  }
  
  public static final String iHs()
  {
    AppMethodBeat.i(245056);
    String str = atj().decodeString("KeyMainCellRedDotUserName");
    AppMethodBeat.o(245056);
    return str;
  }
  
  public static final long iHt()
  {
    AppMethodBeat.i(245060);
    long l = atj().decodeLong("KeyMainRedDotTime", 0L);
    AppMethodBeat.o(245060);
    return l;
  }
  
  private static final void iHu()
  {
    AppMethodBeat.i(245064);
    Iterator localIterator = ((Map)XPx).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      s.u(str1, "bizUserName");
      s.u(str2, "finderFeedExportId");
      int i = iHl();
      if (!oZ(str1, str2))
      {
        int j = im(str1, i) + 1;
        ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(ik(str1, i), j);
        Log.d("MicroMsg.BizFinderLiveLogic", s.X("updateLiveBarExposeTimes currentExposeTimes = ", Integer.valueOf(j)));
      }
      ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("live_bar_expose-exportId-", (String)localEntry.getKey()), (String)localEntry.getValue());
    }
    XPx.clear();
    AppMethodBeat.o(245064);
  }
  
  private static final boolean iHv()
  {
    AppMethodBeat.i(245068);
    String str = iHs();
    Object localObject = (CharSequence)str;
    int i;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label92;
      }
      localObject = com.tencent.mm.storage.v.acEJ;
      if (!com.tencent.mm.storage.v.iXR()) {
        break label92;
      }
      s.u(str, "userName");
      kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new f(str, null), 2);
    }
    for (;;)
    {
      AppMethodBeat.o(245068);
      return true;
      i = 0;
      break;
      label92:
      Log.d("MicroMsg.BizFinderLiveLogic", "startCheckMaiCellRedDot not show finderReadDot");
      iHr();
    }
  }
  
  private static String ik(String paramString, int paramInt)
  {
    AppMethodBeat.i(244989);
    paramString = "date-" + paramInt + "-expose-live-bar-" + paramString;
    AppMethodBeat.o(244989);
    return paramString;
  }
  
  private static String il(String paramString, int paramInt)
  {
    AppMethodBeat.i(244992);
    paramString = "date-" + paramInt + "-expose-live-red-dot-" + paramString;
    AppMethodBeat.o(244992);
    return paramString;
  }
  
  public static int im(String paramString, int paramInt)
  {
    AppMethodBeat.i(245005);
    s.u(paramString, "bizUserName");
    paramInt = XPu.decodeInt(ik(paramString, paramInt), 0);
    AppMethodBeat.o(245005);
    return paramInt;
  }
  
  public static int in(String paramString, int paramInt)
  {
    AppMethodBeat.i(245006);
    s.u(paramString, "bizUserName");
    paramInt = XPu.decodeInt(il(paramString, paramInt), 0);
    AppMethodBeat.o(245006);
    return paramInt;
  }
  
  public static boolean ms(List<? extends pi> paramList)
  {
    AppMethodBeat.i(244980);
    if (paramList == null)
    {
      AppMethodBeat.o(244980);
      return true;
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      pi localpi = (pi)paramList.next();
      if (!oZ(localpi.YIf, localpi.YSM))
      {
        AppMethodBeat.o(244980);
        return false;
      }
    }
    AppMethodBeat.o(244980);
    return true;
  }
  
  public static void nE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244834);
    atj().encode(s.X("bar_list_refresh_interval-", Integer.valueOf(paramInt1)), paramInt2);
    AppMethodBeat.o(244834);
  }
  
  public static void nF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244838);
    atj().encode(s.X("bar_list_keep_data_interval-", Integer.valueOf(paramInt1)), paramInt2);
    AppMethodBeat.o(244838);
  }
  
  public static void oY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244899);
    s.u(paramString1, "bizUserName");
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("oftenread-click-", paramString1), paramString2);
    AppMethodBeat.o(244899);
  }
  
  public static boolean oZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244909);
    if (paramString1 == null)
    {
      AppMethodBeat.o(244909);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244909);
      return false;
    }
    boolean bool = s.p(MMKVSlotManager.decodeString$default(XPu, s.X("live_bar_expose-exportId-", paramString1), null, 2, null), paramString2);
    AppMethodBeat.o(244909);
    return bool;
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(244905);
    com.tencent.threadpool.h.ahAA.bm(c..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(244905);
  }
  
  public static void onResume()
  {
    AppMethodBeat.i(244895);
    if ((TIX) && (CIH != 2))
    {
      xY(9L);
      a(XPw, true, 5, (q)m.XQf);
    }
    TIX = false;
    AppMethodBeat.o(244895);
  }
  
  public static boolean pa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244915);
    if (bpk(paramString1))
    {
      AppMethodBeat.o(244915);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244915);
      return false;
    }
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    while (!bool)
    {
      AppMethodBeat.o(244915);
      return true;
      localCharSequence = (CharSequence)paramString2;
      if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label112;
        }
        bool = false;
        break;
      }
      label112:
      bool = s.p(paramString2, MMKVSlotManager.decodeString$default(XPu, s.X("oftenread-click-", paramString1), null, 2, null));
    }
    AppMethodBeat.o(244915);
    return false;
  }
  
  public static boolean pb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244922);
    if (!s.p(Util.nullAsNil(bpi(paramString1)), Util.nullAsNil(paramString2)))
    {
      AppMethodBeat.o(244922);
      return true;
    }
    AppMethodBeat.o(244922);
    return false;
  }
  
  public static void pd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244998);
    if (paramString1 == null)
    {
      AppMethodBeat.o(244998);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(244998);
      return;
    }
    if (!iHg()) {
      ((Map)XPx).put(paramString1, paramString2);
    }
    AppMethodBeat.o(244998);
  }
  
  private static void pe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245000);
    s.u(paramString1, "bizUserName");
    s.u(paramString2, "finderFeedExportId");
    if (s.p(XPu.decodeString(s.X("expose-exportId-", paramString1), ""), paramString2))
    {
      AppMethodBeat.o(245000);
      return;
    }
    int i = iHl();
    int j = in(paramString1, i) + 1;
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(il(paramString1, i), j);
    Log.d("MicroMsg.BizFinderLiveLogic", s.X("updateRedDotExposeTimes currentExposeTimes = ", Integer.valueOf(j)));
    AppMethodBeat.o(245000);
  }
  
  public static void pf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245051);
    if (paramString1 == null)
    {
      AppMethodBeat.o(245051);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(245051);
      return;
    }
    Log.i("MicroMsg.BizFinderLiveLogic", "saveFinderLiveRedDotInfo bizUserName=" + paramString1 + ", exportId=" + paramString2);
    atj().encode("KeyMainCellRedDotUserName", paramString1);
    atj().encode("KeyMainRedDotTime", br.bCJ());
    AppMethodBeat.o(245051);
  }
  
  public static void xY(long paramLong)
  {
    AppMethodBeat.i(244831);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1703L, paramLong, 1L, false);
    AppMethodBeat.o(244831);
  }
  
  public static void xZ(long paramLong)
  {
    AppMethodBeat.i(244841);
    atj().encode("live_bar_list_last_refresh_time", paramLong);
    AppMethodBeat.o(244841);
  }
  
  private static long y(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(244941);
    s.u(paramab, "info");
    for (;;)
    {
      try
      {
        localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
        if (localu != null) {
          continue;
        }
        paramab = null;
        if (Util.isNullOrNil((List)paramab)) {
          continue;
        }
        paramab = (com.tencent.mm.message.v)localu.nUC.get(0);
        if (Util.isNullOrNil(paramab.url)) {
          continue;
        }
        l = Util.getLong(Uri.parse(paramab.url).getQueryParameter("mid"), 0L);
      }
      catch (Exception paramab)
      {
        com.tencent.mm.message.u localu;
        Log.w("MicroMsg.BizFinderLiveLogic", "reportLiveClickOp exp %s", new Object[] { paramab.getMessage() });
        long l = 0L;
        continue;
      }
      AppMethodBeat.o(244941);
      return l;
      paramab = localu.nUC;
    }
  }
  
  public static final c ya(long paramLong)
  {
    AppMethodBeat.i(245034);
    if (atj().decodeLong("KeyMainRedDotTime", 0L) < paramLong)
    {
      localObject = new c(false, false);
      AppMethodBeat.o(245034);
      return localObject;
    }
    String str = atj().decodeString("KeyMainCellRedDotUserName", "");
    Object localObject = bpi(str);
    str = bpo(str);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new c(false, false);
      AppMethodBeat.o(245034);
      return localObject;
    }
    if (Util.isEqual((String)localObject, str))
    {
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        Log.d("MicroMsg.BizFinderLiveLogic", "shouldShowFinderLiveRedDot clickExportId=" + str + " return");
      }
      localObject = new c(true, false);
      AppMethodBeat.o(245034);
      return localObject;
    }
    localObject = new c(true, true);
    AppMethodBeat.o(245034);
    return localObject;
  }
  
  public static void z(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(244950);
    s.u(paramab, "info");
    Map localMap = (Map)XPI;
    long l = paramab.field_msgId;
    paramab.acFA = System.currentTimeMillis();
    localMap.put(Long.valueOf(l), paramab);
    AppMethodBeat.o(244950);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, List<? extends pi> paramList)
  {
    AppMethodBeat.i(245081);
    s.u(paramContext, "context");
    a(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramList, null);
    AppMethodBeat.o(245081);
  }
  
  public final void pc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245084);
    if (paramString1 == null)
    {
      AppMethodBeat.o(245084);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(245084);
      return;
    }
    pe(paramString1, paramString2);
    ((MultiProcessMMKV)XPu.getSlotForWrite()).encode(s.X("expose-exportId-", paramString1), paramString2);
    AppMethodBeat.o(245084);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$BizFinderLiveOpenFlag;", "", "()V", "bizProfile", "", "getBizProfile", "()I", "bizSession", "getBizSession", "cardTitle", "getCardTitle", "liveBar", "getLiveBar", "oftenRead", "getOftenRead", "webTopBar", "getWebTopBar", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b XPS;
    private static final int XPT;
    private static final int XPU;
    private static final int XPV;
    private static final int XPW;
    private static final int XPX;
    private static final int XPY;
    
    static
    {
      AppMethodBeat.i(244690);
      XPS = new b();
      XPT = 1;
      XPU = 4;
      XPV = 8;
      XPW = 16;
      XPX = 32;
      XPY = 64;
      AppMethodBeat.o(244690);
    }
    
    public static int iHA()
    {
      return XPU;
    }
    
    public static int iHB()
    {
      return XPV;
    }
    
    public static int iHC()
    {
      return XPW;
    }
    
    public static int iHD()
    {
      return XPX;
    }
    
    public static int iHE()
    {
      return XPY;
    }
    
    public static int iHz()
    {
      return XPT;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveLogic$ShowFinderDigestResult;", "", "showDigest", "", "showRedDot", "(ZZ)V", "getShowDigest", "()Z", "setShowDigest", "(Z)V", "getShowRedDot", "setShowRedDot", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public boolean iaS;
    public boolean vYC;
    
    public c(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.vYC = paramBoolean1;
      this.iaS = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.vYC != paramObject.vYC) {
          return false;
        }
      } while (this.iaS == paramObject.iaS);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(244685);
      String str = "ShowFinderDigestResult(showDigest=" + this.vYC + ", showRedDot=" + this.iaS + ')';
      AppMethodBeat.o(244685);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int aai;
    int label;
    
    public d(kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(244692);
      paramObject = (kotlin.d.d)new d(paramd);
      AppMethodBeat.o(244692);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      int i = 10;
      AppMethodBeat.i(244689);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(244689);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (c.iHx())
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(244689);
          return paramObject;
        }
        paramObject = c.XPt;
        c.Jt(true);
        paramObject = c.XPt;
        c.xZ(System.currentTimeMillis());
        paramObject = c.XPt;
        paramObject = (kotlin.d.d)this;
        this.aai = 10;
        this.label = 1;
        localObject = c.a(10, null, paramObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(244689);
          return locala;
        }
        break;
      case 1: 
        i = this.aai;
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (pn)paramObject;
      if (paramObject != null)
      {
        localObject = c.XPt;
        c.nE(i, paramObject.YSY);
        localObject = c.XPt;
        c.nF(i, paramObject.YSZ);
        localObject = c.XPt;
        c.a(paramObject);
      }
      Log.d("MicroMsg.BizFinderLiveLogic", "checkBizFinderLiveBar");
      paramObject = c.XPt;
      c.Jt(false);
      paramObject = ah.aiuX;
      AppMethodBeat.o(244689);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(boolean paramBoolean, String paramString, int paramInt, q<? super String, ? super String, ? super Boolean, ah> paramq, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(244683);
      paramObject = (kotlin.d.d)new e(this.FmG, paramString, paramInt, paramq, paramd);
      AppMethodBeat.o(244683);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(244677);
      Object localObject2 = kotlin.d.a.a.aiwj;
      int i;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(244677);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (!this.FmG)
        {
          paramObject = c.XPt;
          if (!c.bpl(paramString)) {
            break label446;
          }
        }
        if (c.iHw().containsKey(paramString))
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(244677);
          return paramObject;
        }
        ((Map)c.iHw()).put(paramString, Boolean.TRUE);
        Log.d("MicroMsg.BizFinderLiveLogic", "checkFinderLive bizUserName=" + paramString + ", force=" + this.FmG);
        paramObject = c.XPt;
        i = paramInt;
        paramObject = new LinkedList();
        paramObject.add(paramString);
        localObject1 = ah.aiuX;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = c.a(i, paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(244677);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (pn)paramObject;
      c.iHw().remove(paramString);
      label266:
      label300:
      pi localpi;
      c localc;
      if (paramObject == null)
      {
        paramObject = null;
        localObject1 = (Collection)paramObject;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label422;
        }
        i = 1;
        if (i != 0) {
          break label446;
        }
        localObject2 = (Iterable)paramObject;
        paramObject = paramString;
        localObject1 = paramq;
        i = paramInt;
        localObject2 = ((Iterable)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localpi = (pi)((Iterator)localObject2).next();
        } while (!Util.isEqual(localpi.YIf, paramObject));
        localc = c.XPt;
        if (!c.pb(localpi.YIf, localpi.YSM)) {
          break label427;
        }
        ((q)localObject1).invoke(paramObject, localpi.YSM, Boolean.TRUE);
        Log.i("MicroMsg.BizFinderLiveLogic", s.X("checkFinderLive data change bizUserName=", localpi.YIf));
        localc = c.XPt;
        c.aJ(paramObject, localpi.YSM, i);
      }
      for (;;)
      {
        localc = c.XPt;
        c.a(localpi);
        break label300;
        paramObject = paramObject.YSX;
        break;
        label422:
        i = 0;
        break label266;
        label427:
        ((q)localObject1).invoke(paramObject, localpi.YSM, Boolean.FALSE);
      }
      label446:
      paramObject = ah.aiuX;
      AppMethodBeat.o(244677);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    f(String paramString, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(244681);
      paramObject = (kotlin.d.d)new f(this.pmW, paramd);
      AppMethodBeat.o(244681);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(244675);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(244675);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.XPt;
        if (!c.iHp())
        {
          paramObject = c.XPt;
          if (c.bpl(this.pmW)) {}
        }
        else
        {
          Log.d("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify return");
          paramObject = ah.aiuX;
          AppMethodBeat.o(244675);
          return paramObject;
        }
        paramObject = c.XPt;
        c.Js(true);
        Log.d("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify");
        paramObject = c.XPt;
        paramObject = new LinkedList();
        paramObject.add(this.pmW);
        localObject1 = ah.aiuX;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = c.a(7, paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(244675);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (pn)paramObject;
      Object localObject1 = c.XPt;
      c.Js(false);
      if (paramObject == null) {}
      for (paramObject = null; paramObject == null; paramObject = paramObject.YSX)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(244675);
        return paramObject;
      }
      paramObject = ((Iterable)paramObject).iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (pi)paramObject.next();
        if (Util.isNullOrNil(((pi)localObject1).YSM))
        {
          Log.i("MicroMsg.BizFinderLiveLogic", "checkLiveRedDotNotify live stop!");
          localObject2 = c.XPt;
          c.a((pi)localObject1);
          localObject2 = c.XPt;
          c.bpp(((pi)localObject1).YIf);
          localObject1 = c.XPt;
          c.iHn();
          localObject1 = c.XPt;
          c.iHr();
          ad.iYO();
        }
        else
        {
          localObject2 = c.XPt;
          c.a((pi)localObject1);
          localObject2 = c.XPt;
          c.bpn(((pi)localObject1).nUM);
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(244675);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    implements IPCRunCgi.a
  {
    g(ah.a parama, kotlin.d.d<? super pn> paramd, int paramInt) {}
    
    public final void callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      paramString = null;
      int i = 1;
      AppMethodBeat.i(244660);
      s.u(paramc, "rr");
      Log.i("MicroMsg.BizFinderLiveLogic", "getBizFinderLives callback " + paramInt1 + ", " + paramInt2);
      if (this.ojj.aiwY)
      {
        AppMethodBeat.o(244660);
        return;
      }
      this.ojj.aiwY = true;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        try
        {
          paramString = c.XPt;
          c.xY(2L);
          paramString = locald;
          paramc = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(null));
          AppMethodBeat.o(244660);
          return;
        }
        catch (Exception paramString)
        {
          paramc = c.XPt;
          c.xY(3L);
          Log.e("MicroMsg.BizFinderLiveLogic", s.X("callback ex ", paramString.getMessage()));
          AppMethodBeat.o(244660);
          return;
        }
      }
      Object localObject = c.XPt;
      c.xY(1L);
      if (!(com.tencent.mm.am.c.c.b(paramc.otC) instanceof pn))
      {
        paramString = locald;
        paramc = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(244660);
        return;
      }
      paramc = com.tencent.mm.am.c.c.b(paramc.otC);
      if (paramc == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFinderLiveResp");
        AppMethodBeat.o(244660);
        throw paramString;
      }
      paramc = (pn)paramc;
      localObject = com.tencent.mm.plugin.webview.core.i.Wya;
      if (i.a.anH())
      {
        localObject = MultiProcessMMKV.getSingleMMKV("brandService");
        if ((localObject == null) || (((MultiProcessMMKV)localObject).decodeInt("BizTimeLineFinderLiveStatus", 1) != 0)) {
          break label427;
        }
        paramInt1 = i;
        if (paramInt1 != 0) {
          paramc.YSX.clear();
        }
      }
      localObject = new StringBuilder("getBizFinderLives card scene = ").append(paramInt).append(" size=");
      LinkedList localLinkedList = paramc.YSX;
      if (localLinkedList == null) {}
      for (;;)
      {
        Log.i("MicroMsg.BizFinderLiveLogic", paramString + " interval=" + paramc.YSY + " funcFlag=" + paramc.func_flag);
        if ((paramc.YSV != null) && (paramc.YSV.Op.length > 0))
        {
          paramString = c.XPt;
          c.atj().encode("FinderLiveBuffer", paramc.YSV.toByteArray());
        }
        paramString = locald;
        localObject = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
        AppMethodBeat.o(244660);
        return;
        label427:
        paramInt1 = 0;
        break;
        paramInt1 = localLinkedList.size();
        paramString = Integer.valueOf(paramInt1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final h XQb;
    
    static
    {
      AppMethodBeat.i(244650);
      XQb = new h();
      AppMethodBeat.o(244650);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final i XQc;
    
    static
    {
      AppMethodBeat.i(244644);
      XQc = new i();
      AppMethodBeat.o(244644);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final j XQd;
    
    static
    {
      AppMethodBeat.i(244647);
      XQd = new j();
      AppMethodBeat.o(244647);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final k XQe;
    
    static
    {
      AppMethodBeat.i(244652);
      XQe = new k();
      AppMethodBeat.o(244652);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    l(LinkedList<String> paramLinkedList, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(244676);
      paramObject = (kotlin.d.d)new l(this.vBA, paramd);
      AppMethodBeat.o(244676);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(244674);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(244674);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.XPt;
        if (c.iHo())
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(244674);
          return paramObject;
        }
        paramObject = c.XPt;
        c.Jr(true);
        Log.d("MicroMsg.BizFinderLiveLogic", "onFinderLiveRedDotNotify");
        paramObject = c.XPt;
        paramObject = this.vBA;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = c.a(6, paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(244674);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (pn)paramObject;
      Object localObject1 = c.XPt;
      c.Jr(false);
      int i;
      if (paramObject == null)
      {
        paramObject = null;
        localObject1 = (Collection)paramObject;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label330;
        }
        i = 1;
        label188:
        if (i != 0) {
          break label472;
        }
        localObject1 = ((Iterable)paramObject).iterator();
      }
      label330:
      label470:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label472;
        }
        paramObject = (pi)((Iterator)localObject1).next();
        if (!Util.isNullOrNil(paramObject.YSM))
        {
          localObject2 = c.XPt;
          s.s(paramObject, "info");
          s.u(paramObject, "info");
          if (paramObject.YIf == null) {
            i = 0;
          }
          for (;;)
          {
            if (i == 0) {
              break label470;
            }
            Log.i("MicroMsg.BizFinderLiveLogic", "onFinderLiveRedDotNotify live start!");
            localObject1 = c.XPt;
            c.a(paramObject);
            localObject1 = c.XPt;
            c.pf(paramObject.YIf, paramObject.YSM);
            ad.iYO();
            localObject1 = c.XPt;
            c.bpn(paramObject.nUM);
            paramObject = ah.aiuX;
            AppMethodBeat.o(244674);
            return paramObject;
            paramObject = paramObject.YSX;
            break;
            i = 0;
            break label188;
            localObject2 = c.XPu;
            String str = paramObject.YIf;
            s.s(str, "info.bizusername");
            if (s.p(((MMKVSlotManager)localObject2).decodeString(c.bpm(str), ""), paramObject.YSM))
            {
              Log.i("MicroMsg.BizFinderLiveLogic", "canShowOftenReadRedDot same live return!");
              i = 0;
            }
            else
            {
              i = ((Number)c.XPG.getValue()).intValue();
              localObject2 = paramObject.YIf;
              s.s(localObject2, "info.bizusername");
              int j = c.in((String)localObject2, c.iHl());
              if (j >= i)
              {
                Log.i("MicroMsg.BizFinderLiveLogic", "canShowOftenReadRedDot return " + paramObject.YIf + " : " + j);
                i = 0;
              }
              else
              {
                i = 1;
              }
            }
          }
        }
      }
      label472:
      paramObject = ah.aiuX;
      AppMethodBeat.o(244674);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements q<String, String, Boolean, ah>
  {
    public static final m XQf;
    
    static
    {
      AppMethodBeat.i(244668);
      XQf = new m();
      AppMethodBeat.o(244668);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final n XQg;
    
    static
    {
      AppMethodBeat.i(244654);
      XQg = new n();
      AppMethodBeat.o(244654);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final o XQh;
    
    static
    {
      AppMethodBeat.i(244666);
      XQh = new o();
      AppMethodBeat.o(244666);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final p XQi;
    
    static
    {
      AppMethodBeat.i(244696);
      XQi = new p();
      AppMethodBeat.o(244696);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final q XQj;
    
    static
    {
      AppMethodBeat.i(244698);
      XQj = new q();
      AppMethodBeat.o(244698);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final r XQk;
    
    static
    {
      AppMethodBeat.i(244701);
      XQk = new r();
      AppMethodBeat.o(244701);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final s XQl;
    
    static
    {
      AppMethodBeat.i(244694);
      XQl = new s();
      AppMethodBeat.o(244694);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final t XQm;
    
    static
    {
      AppMethodBeat.i(244700);
      XQm = new t();
      AppMethodBeat.o(244700);
    }
    
    t()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */