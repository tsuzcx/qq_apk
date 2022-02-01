package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.message.u;
import com.tencent.mm.pluginsdk.model.c.a;
import com.tencent.mm.pluginsdk.model.c.d;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "cardType", "", "getCardType", "()I", "setCardType", "(I)V", "hasRedDot", "getHasRedDot", "setHasRedDot", "isFinderLiveDigestShow", "", "()Z", "setFinderLiveDigestShow", "(Z)V", "isMainCellHideReportOpen", "isMainCellHideReportOpen$delegate", "Lkotlin/Lazy;", "lastDesc", "getLastDesc", "()Ljava/lang/String;", "setLastDesc", "(Ljava/lang/String;)V", "lastExposeId", "", "getLastExposeId", "()J", "setLastExposeId", "(J)V", "lastExposeMid", "getLastExposeMid", "setLastExposeMid", "lastExposeMsgId", "getLastExposeMsgId", "setLastExposeMsgId", "lastExposeMsgType", "getLastExposeMsgType", "setLastExposeMsgType", "lastExposeUserName", "getLastExposeUserName", "setLastExposeUserName", "lastRedDotUserName", "getLastRedDotUserName", "setLastRedDotUserName", "mBizNotifyMsgPriorityShowSwitch", "getMBizNotifyMsgPriorityShowSwitch", "setMBizNotifyMsgPriorityShowSwitch", "mMaxNotifyMsgExposureCount", "getMMaxNotifyMsgExposureCount", "setMMaxNotifyMsgExposureCount", "mMaxNotifyMsgExposureTime", "getMMaxNotifyMsgExposureTime", "setMMaxNotifyMsgExposureTime", "mMaxNotifyMsgWithinUnreadCount", "getMMaxNotifyMsgWithinUnreadCount", "setMMaxNotifyMsgWithinUnreadCount", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "msgTypeFinderLive", "officialAccountShow", "getOfficialAccountShow", "setOfficialAccountShow", "isMsgExpose", "msgId", "isNotifyMsgShowFirst", "notifyInfoMsgId", "unReadCount", "postDoReportMainCellHide", "", "desc", "pos", "reportFinderLiveRedDotExpose", "conv", "Lcom/tencent/mm/storage/Conversation;", "reportFinderLiveRedDotHide", "reportMainCellExpose", "reportMainCellHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "setReportParams", "exposeId", "msgType", "bizUserName", "mId", "updateExposeTime", "currentTime", "HasExposeKey", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v acEJ;
  private static String acEK;
  static volatile boolean acEL;
  private static boolean acEM;
  private static final kotlin.j acEN;
  private static String acEO;
  private static int acEP;
  static int acEQ;
  static long acER;
  static int acES;
  static int acET;
  private static final MultiProcessMMKV eMf;
  private static int nSq;
  private static long vGZ;
  static long vHa;
  private static long vHb;
  private static int vHe;
  private static String vHf;
  
  static
  {
    AppMethodBeat.i(248918);
    acEJ = new v();
    vHf = "";
    eMf = MultiProcessMMKV.getSingleMMKV("brandService");
    acEN = kotlin.k.cm((kotlin.g.a.a)v.a.acEU);
    vHa = -1L;
    acEQ = -1;
    acER = -1L;
    acES = -1;
    acET = -1;
    AppMethodBeat.o(248918);
  }
  
  private static final void a(bb parambb, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248907);
    Object localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
    label49:
    int j;
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.pluginsdk.model.c.iGX())
    {
      i = com.tencent.mm.pluginsdk.model.c.atj().decodeInt("biz_finder_live_func_flag", 1);
      localObject1 = c.a.XPQ;
      if ((i & c.a.iHy()) != 0)
      {
        i = 1;
        if (i != 0) {
          break label480;
        }
      }
    }
    else
    {
      if (!parambb.rx(128)) {
        break label587;
      }
      if ((parambb != null) && ((!acEL) || (!s.p(acEO, parambb.field_digestUser))))
      {
        j = parambb.field_unReadCount;
        l1 = System.currentTimeMillis();
        acEO = parambb.field_digestUser;
        localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
        localObject1 = com.tencent.mm.pluginsdk.model.c.bpi(parambb.field_digestUser);
        com.tencent.mm.pluginsdk.model.c.XPt.pc(parambb.field_digestUser, (String)localObject1);
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.iHq();
        localObject2 = parambb.field_digestUser;
        localObject3 = com.tencent.mm.an.c.ovO;
        s.s(localObject2, "bizUsername");
        if (((com.tencent.mm.an.c)localObject3).decodeInt(bvw((String)localObject2), 0) != 1) {
          break label576;
        }
        paramInt2 = 0;
        label170:
        localObject3 = (MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite();
        ((MultiProcessMMKV)localObject3).encode(bvw((String)localObject2), 1);
        ((MultiProcessMMKV)localObject3).encode(bvs((String)localObject2), l1);
        if (!parambb.rx(256)) {
          break label581;
        }
      }
    }
    label576:
    label581:
    for (int i = 1;; i = 0)
    {
      acEP = i;
      com.tencent.mm.plugin.report.service.h.OAn.b(18218, new Object[] { Integer.valueOf((int)(l1 / 1000L)), localObject2, Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), aa.aUC(paramString), Integer.valueOf(j), Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(acEP), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", localObject1 });
      b(l1, 7, (String)localObject2, 0L);
      if ((acEL) && (vHa != 0L)) {
        e("", 0, 0, vHa);
      }
      acEM = true;
      acEL = true;
      vHa = -1L;
      Log.d("MicroMsg.BizMainCellExposeHelper", s.X("reportFinderLiveRedDotExpose bizUsername=", localObject2));
      AppMethodBeat.o(248907);
      return;
      i = 0;
      break;
      label480:
      i = kotlin.k.k.qu(com.tencent.mm.pluginsdk.model.c.atj().decodeInt(s.X("bar_list_refresh_interval-", Integer.valueOf(10)), 0), 60) * 1000;
      l1 = com.tencent.mm.pluginsdk.model.c.iHd();
      Log.d("MicroMsg.BizFinderLiveLogic", s.X("preCheckLiveBar listRefreshInterval = ", Integer.valueOf(i)));
      if (System.currentTimeMillis() - l1 <= i) {
        break label49;
      }
      kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new c.d(null), 2);
      break label49;
      paramInt2 = 1;
      break label170;
    }
    label587:
    long l2 = System.currentTimeMillis();
    long l1 = eMf.decodeLong("BizLastMsgId");
    if (l1 == 0L)
    {
      AppMethodBeat.o(248907);
      return;
    }
    if ((acEL) && (l1 == vHa))
    {
      AppMethodBeat.o(248907);
      return;
    }
    Object localObject4 = (MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite();
    if ((acEL) && (vHa != 0L)) {
      e("", 0, 0, vHa);
    }
    acEM = false;
    acEO = "";
    vHa = l1;
    acEL = true;
    Object localObject5 = String.valueOf(l1);
    if (com.tencent.mm.an.c.ovO.decodeInt((String)localObject5, 0) == 1) {}
    int k;
    ab localab;
    for (int m = 0;; m = 1)
    {
      k = 0;
      acEP = ai.iZe();
      parambb = "";
      nSq = 0;
      try
      {
        localab = af.bHl().aq(l1, "msgId");
        if ((localab != null) || (l1 >= 0L)) {
          break label1710;
        }
        localab = af.bHo().aq(l1, "msgId");
        if (localab != null) {
          break;
        }
        AppMethodBeat.o(248907);
        return;
      }
      finally
      {
        Log.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { parambb.getMessage() });
        AppMethodBeat.o(248907);
        return;
      }
    }
    nSq = ah.K(localab);
    label925:
    label953:
    Object localObject6;
    int n;
    int i1;
    if (localab.iYe())
    {
      parambb = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(localab.field_msgId, localab.field_content);
      if ((parambb == null) || (Util.isNullOrNil((List)parambb.nUC))) {
        break label1701;
      }
      parambb = (com.tencent.mm.message.v)parambb.nUC.get(0);
      if (Util.isNullOrNil(parambb.url)) {
        break label1701;
      }
      parambb = Uri.parse(parambb.url);
      l1 = Util.getLong(parambb.getQueryParameter("mid"), 0L);
      j = Util.getInt(parambb.getQueryParameter("idx"), 0);
      localObject1 = localab.field_talker;
      s.s(localObject1, "info.field_talker");
      i = 0;
      parambb = "";
      localObject2 = "";
      break label1713;
      ((MultiProcessMMKV)localObject4).encode((String)localObject5, 1);
      ((MultiProcessMMKV)localObject4).encode(bvs((String)localObject5), l2);
      ((MultiProcessMMKV)localObject4).encode(bvu((String)localObject5), com.tencent.mm.an.c.ovO.decodeInt(bvu((String)localObject5), 0) + 1);
      ((MultiProcessMMKV)localObject4).encode(bvv((String)localObject5), Math.min(com.tencent.mm.an.c.ovO.decodeInt(bvv((String)localObject5), paramInt1), paramInt1));
      localObject4 = aa.aUC(paramString);
      if (m == 1)
      {
        paramString = com.tencent.mm.pluginsdk.c.XNm;
        boolean bool = com.tencent.mm.pluginsdk.c.atj().getBoolean("biz_time_preload_at_biz_box_expose", false);
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = com.tencent.mm.pluginsdk.c.XNm;
          com.tencent.mm.pluginsdk.c.iGz();
        }
      }
      paramString = com.tencent.mm.plugin.biz.b.a.vtj;
      localObject3 = com.tencent.mm.plugin.biz.b.a.b(localab);
      r.acDM.iXy();
      if (localab.iYf())
      {
        paramString = af.bHn();
        localObject5 = new y();
        ((y)localObject5).field_msgId = localab.field_msgId;
        ((y)localObject5).field_exposeType = y.acEX;
        ((y)localObject5).field_exposeTime = System.currentTimeMillis();
        localObject6 = kotlin.ah.aiuX;
        paramString.a((y)localObject5);
      }
      localObject5 = eMf.decodeString("BizLastRecCardId", "");
      localObject6 = com.tencent.mm.plugin.report.service.h.OAn;
      n = (int)(l2 / 1000L);
      i1 = acEP;
      if (localObject3 != null) {
        break label1653;
      }
      paramString = null;
      break label1737;
    }
    for (;;)
    {
      label1206:
      ((com.tencent.mm.plugin.report.service.h)localObject6).b(18218, new Object[] { Integer.valueOf(n), parambb, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(paramInt1), localObject4, Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(l2), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i1), paramString, localObject3, Integer.valueOf(nSq), Integer.valueOf(j), Integer.valueOf(k), aa.aUC((String)localObject2), aa.aUC((String)localObject1), localObject5, "" });
      Log.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCountReport %d, currentTime %d, msgId=" + localab.field_msgId + ", lastRecCardId=" + localObject5, new Object[] { parambb, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l2) });
      b(l2, i, parambb, l1);
      AppMethodBeat.o(248907);
      return;
      if (localab.iYi())
      {
        parambb = ai.M(localab);
        i = ai.h(localab);
        paramString = ai.L(localab);
        paramInt2 = af.bHo().dkF();
        Log.v("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose dyeing template bizUsername = " + parambb + ", msgType = " + i);
        j = 0;
        localObject1 = "";
        localObject2 = "";
        l1 = 0L;
        break label953;
      }
      if (localab.iYf())
      {
        parambb = ae.acGm;
        localObject1 = ae.I(localab);
        i = ((cj)localObject1).style;
        l1 = ((cj)localObject1).nVr;
        j = ((cj)localObject1).idx;
        localObject2 = ((cj)localObject1).adln;
        parambb = ((cj)localObject1).extData;
        localObject1 = ((cj)localObject1).hUQ;
        if (localObject1 == null)
        {
          localObject1 = "";
          localObject3 = parambb;
          k = j;
          break label1720;
          label1653:
          paramString = (String)((kotlin.r)localObject3).bsC;
        }
      }
      label1701:
      label1710:
      label1713:
      label1720:
      label1737:
      while (localObject3 != null)
      {
        localObject3 = (String)((kotlin.r)localObject3).bsD;
        break label1206;
        break label1713;
        j = 0;
        i = 0;
        localObject1 = "";
        localObject2 = "";
        l1 = 0L;
        break label953;
        j = 0;
        l1 = 0L;
        break label925;
        break;
        k = j;
        localObject3 = parambb;
        j = i;
        parambb = (bb)localObject1;
        i = 0;
        localObject1 = localObject3;
        break label953;
      }
      localObject3 = null;
    }
  }
  
  public static void a(String paramString, int paramInt, bb parambb)
  {
    AppMethodBeat.i(248835);
    if (parambb == null)
    {
      AppMethodBeat.o(248835);
      return;
    }
    int i = parambb.field_unReadCount;
    com.tencent.threadpool.h.ahAA.g(new v..ExternalSyntheticLambda0(parambb, paramString, paramInt, i), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(248835);
  }
  
  private static final void aZ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248912);
    e(paramString, paramInt1, paramInt2, 0L);
    AppMethodBeat.o(248912);
  }
  
  private static void b(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    vGZ = paramLong1;
    vHe = paramInt;
    vHf = paramString;
    vHb = paramLong2;
  }
  
  static void bG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248865);
    String str = String.valueOf(paramLong1);
    paramLong1 = com.tencent.mm.an.c.ovO.decodeLong(bvs(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = com.tencent.mm.an.c.ovO.decodeLong(bvt(str), 0L) + paramLong2 - paramLong1;
      ((MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite()).encode(bvt(str), paramLong1);
      Log.v("MicroMsg.BizMainCellExposeHelper", s.X("updateExposeTime totalExposeTime=", Long.valueOf(paramLong1)));
    }
    AppMethodBeat.o(248865);
  }
  
  public static String bvs(String paramString)
  {
    AppMethodBeat.i(248771);
    s.u(paramString, "<this>");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(248771);
    return paramString;
  }
  
  public static String bvt(String paramString)
  {
    AppMethodBeat.i(248774);
    s.u(paramString, "<this>");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(248774);
    return paramString;
  }
  
  public static String bvu(String paramString)
  {
    AppMethodBeat.i(248779);
    s.u(paramString, "<this>");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(248779);
    return paramString;
  }
  
  public static String bvv(String paramString)
  {
    AppMethodBeat.i(248786);
    s.u(paramString, "<this>");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(248786);
    return paramString;
  }
  
  private static String bvw(String paramString)
  {
    AppMethodBeat.i(248787);
    s.u(paramString, "<this>");
    paramString = "hasExpose_" + paramString + '}';
    AppMethodBeat.o(248787);
    return paramString;
  }
  
  public static void bvx(String paramString)
  {
    acEK = paramString;
  }
  
  public static void bvy(String paramString)
  {
    AppMethodBeat.i(248843);
    com.tencent.threadpool.h.ahAA.g(new v..ExternalSyntheticLambda1(paramString, 0, 0), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(248843);
  }
  
  private static void e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(248857);
    if (!acEL)
    {
      AppMethodBeat.o(248857);
      return;
    }
    acEL = false;
    Object localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
    com.tencent.mm.pluginsdk.model.c.iHr();
    Object localObject2;
    if (acEM)
    {
      paramLong = System.currentTimeMillis();
      localObject1 = acEO;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        localObject2 = com.tencent.mm.pluginsdk.model.c.bpi((String)localObject1);
        l1 = com.tencent.mm.an.c.ovO.decodeLong(bvs((String)localObject1), 0L);
        com.tencent.mm.plugin.report.service.h.OAn.b(18218, new Object[] { Integer.valueOf((int)(paramLong / 1000L)), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), aa.aUC(paramString), Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(acEP), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", localObject2 });
        Log.d("MicroMsg.BizMainCellExposeHelper", s.X("reportFinderLiveRedDotHide bizUsername=", localObject1));
      }
      AppMethodBeat.o(248857);
      return;
    }
    long l3 = System.currentTimeMillis();
    if (paramLong != 0L) {}
    for (long l1 = paramLong; l1 == 0L; l1 = eMf.decodeLong("BizLastMsgId"))
    {
      AppMethodBeat.o(248857);
      return;
    }
    paramLong = 0L;
    int k = 0;
    int m = 0;
    int i1 = ai.iZe();
    localObject1 = "";
    int i = 0;
    int j = 0;
    try
    {
      localObject2 = af.bHl().aq(l1, "msgId");
      if ((localObject2 != null) || (l1 >= 0L)) {
        break label943;
      }
      localObject2 = af.bHo().aq(l1, "msgId");
      if (localObject2 == null)
      {
        AppMethodBeat.o(248857);
        return;
      }
    }
    finally
    {
      Log.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(248857);
      return;
    }
    int i2 = ah.K((ab)localObject2);
    if (((ab)localObject2).iYe())
    {
      localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(((ab)localObject2).field_msgId, ((ab)localObject2).field_content);
      if ((localObject1 == null) || (Util.isNullOrNil((List)((u)localObject1).nUC))) {
        break label937;
      }
      localObject1 = (com.tencent.mm.message.v)((u)localObject1).nUC.get(0);
      if (Util.isNullOrNil(((com.tencent.mm.message.v)localObject1).url)) {
        break label937;
      }
      localObject1 = Uri.parse(((com.tencent.mm.message.v)localObject1).url);
      paramLong = Util.getLong(((Uri)localObject1).getQueryParameter("mid"), 0L);
      j = Util.getInt(((Uri)localObject1).getQueryParameter("idx"), 0);
      label542:
      localObject1 = ((ab)localObject2).field_talker;
      s.s(localObject1, "info.field_talker");
      break label946;
    }
    for (;;)
    {
      l1 = com.tencent.mm.an.c.ovO.decodeLong(bvs(String.valueOf(l1)), 0L);
      bG(((ab)localObject2).field_msgId, l3);
      com.tencent.mm.plugin.report.service.h.OAn.b(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), localObject1, Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(paramInt1), aa.aUC(paramString), Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i1), "", "", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(k), "", "", "", "" });
      Log.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { localObject1, Long.valueOf(paramLong), Long.valueOf(l1) });
      AppMethodBeat.o(248857);
      return;
      if (((ab)localObject2).iYi())
      {
        localObject1 = ai.M((ab)localObject2);
        m = ai.h((ab)localObject2);
        i = j;
        j = m;
      }
      else
      {
        i = j;
        j = m;
        if (((ab)localObject2).iYf())
        {
          localObject1 = ae.acGm;
          localObject1 = ae.I((ab)localObject2);
          k = ((cj)localObject1).style;
          long l2 = ((cj)localObject1).nVr;
          int n = ((cj)localObject1).idx;
          String str = ((cj)localObject1).hUQ;
          localObject1 = str;
          i = k;
          paramLong = l2;
          j = n;
          if (str == null)
          {
            localObject1 = "";
            i = k;
            paramLong = l2;
            j = n;
            break label946;
            label937:
            j = 0;
            break label542;
            label943:
            break;
          }
          label946:
          k = j;
          j = m;
        }
      }
    }
  }
  
  public static long iXL()
  {
    return vGZ;
  }
  
  public static long iXM()
  {
    return vHb;
  }
  
  public static int iXN()
  {
    return vHe;
  }
  
  public static String iXO()
  {
    return vHf;
  }
  
  public static String iXP()
  {
    return acEK;
  }
  
  public static boolean iXQ()
  {
    return acEL;
  }
  
  public static boolean iXR()
  {
    return acEM;
  }
  
  public static boolean iXS()
  {
    AppMethodBeat.i(248816);
    boolean bool = ((Boolean)acEN.getValue()).booleanValue();
    AppMethodBeat.o(248816);
    return bool;
  }
  
  public static long iXT()
  {
    return vHa;
  }
  
  public static String iXU()
  {
    return acEO;
  }
  
  public static int iXV()
  {
    return nSq;
  }
  
  public static int iXW()
  {
    return acEP;
  }
  
  public static boolean yE(long paramLong)
  {
    AppMethodBeat.i(248874);
    if (MMKVSlotManager.decodeInt$default((MMKVSlotManager)com.tencent.mm.an.c.ovO, String.valueOf(paramLong), 0, 2, null) == 1)
    {
      AppMethodBeat.o(248874);
      return true;
    }
    AppMethodBeat.o(248874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */