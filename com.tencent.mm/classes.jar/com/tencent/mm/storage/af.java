package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.message.u;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.emz;
import com.tencent.mm.protocal.protobuf.ena;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizTimeLineResortLogic;", "", "()V", "MIN_FORE_GROUND_REQ_TIME", "", "MIN_IN_TIMELINE_REQ_TIME", "MIN_REV_MSG_REQ_TIME", "TAG", "", "clickFirstVisibleItem", "", "getClickFirstVisibleItem", "()I", "setClickFirstVisibleItem", "(I)V", "isBizMsgResortCheckOpen", "", "()Z", "isBizMsgResortCheckOpen$delegate", "Lkotlin/Lazy;", "isDoingSortBizMsg", "lastExposeOrderFlag", "getLastExposeOrderFlag", "()J", "setLastExposeOrderFlag", "(J)V", "minNewGroupCount", "minReSortTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "opFlagDelete", "opFlagSlink", "resortBizMsgRespFlagOpenClickArticle", "resortBizMsgRespFlagOpenClickOftenRead", "resortBizMsgRespFlagOpenEnterTimeline", "sFirstVisibleItem", "getSFirstVisibleItem", "setSFirstVisibleItem", "doInsertRecCard", "", "resp", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortResp;", "maxWeight", "fromScene", "doReSortCgi", "context", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "orderFlag", "doSink", "groupId", "resortList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "getBizMsgItem", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "maxOrderFlag", "Lcom/tencent/mm/pointers/PLong;", "getLastExposeBizMsgItem", "getResortBizTimeLineInfo", "lastMsgId", "handleReSortResult", "extraRecList", "", "handleReSortResultImpl", "hasScrollOrExitNotDoResort", "inTimeLineNotDoResort", "isInTimeLineResortScene", "markScroll", "notDotRecycleScene", "onReceiveRecCard", "msgContent", "digestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "isTimeLineResort", "reSortBizMsg", "recordFailReason", "reason", "reportBizMsgResortIDKey", "value", "saveConfig", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final af acGt;
  private static boolean acGu;
  private static long acGv;
  private static final j acGw;
  private static final j exj;
  private static int vIc;
  private static int vNO;
  
  static
  {
    AppMethodBeat.i(248651);
    acGt = new af();
    exj = kotlin.k.cm((kotlin.g.a.a)af.e.acGC);
    acGw = kotlin.k.cm((kotlin.g.a.a)af.d.acGB);
    AppMethodBeat.o(248651);
  }
  
  public static void Hp(int paramInt)
  {
    vIc = paramInt;
  }
  
  private static final int a(int paramInt1, ah.e parame, qa paramqa, List paramList, int paramInt2, int paramInt3, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(248648);
    s.u(parame, "$groupId");
    s.u(paramList, "$recList");
    Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi CGI callback errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (ayJ(paramInt1)) {}
      for (paramInt1 = 62;; paramInt1 = 2)
      {
        ayF(paramInt1);
        acGu = false;
        AppMethodBeat.o(248648);
        return 0;
      }
    }
    if (ayJ(paramInt1)) {}
    for (paramInt2 = 61;; paramInt2 = 1)
    {
      ayF(paramInt2);
      paramString = c.c.b(paramc.otC);
      if (paramString != null) {
        break;
      }
      parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortResp");
      AppMethodBeat.o(248648);
      throw parame;
    }
    paramString = (qd)paramString;
    atj().encode(s.X("ReSortBizMsgNextReqTime-", Integer.valueOf(paramInt1)), kotlin.k.k.bS(paramString.YUP, 604800L));
    atj().encode(s.X("ReSortBizMsgMinUnExposedCount-", Integer.valueOf(paramInt1)), paramString.Jfu);
    atj().encode(s.X("ReSortBizMsgMinUnReadCount-", Integer.valueOf(paramInt1)), paramString.YUQ);
    atj().encode(s.X("ReSortBizMsgLimitTime-", Integer.valueOf(paramInt1)), paramString.YUR);
    atj().encode(s.X("ReSortBizMsgContextMsgLimit-", Integer.valueOf(paramInt1)), paramString.YUX);
    atj().encode(s.X("ReSortBizMsgReqCount-", Integer.valueOf(paramInt1)), paramString.YSK);
    atj().encode(s.X("ReSortBizMsgExtraRecMsgCount-", Integer.valueOf(paramInt1)), paramString.YUY);
    atj().encode("ReSortBizMsgFlag", paramString.eQp);
    atj().encode("ReSortBizMsgBuffer", paramString.igg);
    paramc = paramString.YUV;
    if (paramc != null)
    {
      atj().encode("RecCardMaxKeepMsgCount", paramc.abrl);
      atj().encode("RecCardMinNewMsgCount", paramc.abrk);
    }
    paramc = com.tencent.mm.model.p.ojc;
    p.a.atj().encode("SubscribeMsgLimit", paramString.YUW);
    Log.i("MicroMsg.BizTimeLineResortLogic", "saveConfig subscribeMsgLimit=" + paramString.YUW + ", flag=" + paramString.eQp);
    com.tencent.threadpool.h.ahAA.g(new af..ExternalSyntheticLambda3(paramString, paramInt1, parame, paramqa, paramList), "BizReSortThread");
    AppMethodBeat.o(248648);
    return 0;
  }
  
  public static void a(int paramInt, qa paramqa, long paramLong)
  {
    AppMethodBeat.i(248529);
    long l = System.currentTimeMillis() - PluginBiz.startTime;
    if (l < 15000L)
    {
      com.tencent.threadpool.h.ahAA.a(new af..ExternalSyntheticLambda1(paramInt, paramqa, paramLong), kotlin.k.k.bR(15000L - l, 5000L), "BizReSortThread");
      AppMethodBeat.o(248529);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new af..ExternalSyntheticLambda2(paramInt, paramqa, paramLong), "BizReSortThread");
    AppMethodBeat.o(248529);
  }
  
  private static void a(qd paramqd, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(248593);
    if (paramqd == null)
    {
      AppMethodBeat.o(248593);
      return;
    }
    if (!Util.isNullOrNil((List)paramqd.YUU))
    {
      Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult recommend_article_info size = %s", new Object[] { Integer.valueOf(paramqd.YUU.size()) });
      boolean bool = ayJ(paramInt2);
      Object localObject1 = paramqd.YUU;
      paramInt2 = i;
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (ena)localIterator.next();
          localObject1 = ((ena)localObject2).xml;
          localObject2 = ((ena)localObject2).YUs;
          Object localObject3;
          if ((localObject1 != null) && (com.tencent.mm.kernel.h.baz()))
          {
            paramInt2 = n.a((CharSequence)localObject1, "<sysmsg", 0, false, 6);
            if (paramInt2 != -1)
            {
              if (localObject1 == null)
              {
                paramqd = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(248593);
                throw paramqd;
              }
              localObject3 = ((String)localObject1).substring(paramInt2);
              s.s(localObject3, "(this as java.lang.String).substring(startIndex)");
              localObject3 = XmlParser.parseXml((String)localObject3, "sysmsg", null);
              if (localObject3 != null) {
                break label245;
              }
              Log.e("MicroMsg.BizTimeLineResortLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
            }
          }
          else
          {
            label231:
            paramInt2 = 0;
          }
          for (;;)
          {
            i = paramInt2 | i;
            break;
            paramInt2 = 0;
            continue;
            label245:
            if (ah.cz((Map)localObject3))
            {
              if (!ah.iZd()) {
                break label231;
              }
              paramInt2 = Util.getInt((String)((Map)localObject3).get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1);
              if (paramInt2 == 2)
              {
                localObject2 = ae.acGm;
                ae.bvF((String)localObject1);
                localObject1 = ae.acGm;
                ae.yX(0L);
                paramInt2 = 1;
                continue;
              }
              localObject3 = ah.cA((Map)localObject3);
              if (localObject3 == null) {
                break label231;
              }
              if (!ah.c((flj)localObject3, null))
              {
                Log.i("MicroMsg.BizTimeLineResortLogic", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
                break label231;
              }
              if (paramInt2 == 0)
              {
                ad.bvD((String)localObject1);
                r.a(r.acDM, (flj)localObject3);
                paramInt2 = 1;
                continue;
              }
              if (paramInt2 == 1)
              {
                localObject1 = ah.a((flj)localObject3, paramInt1, bool);
                if (localObject1 == null) {
                  localObject1 = null;
                }
                for (;;)
                {
                  if (localObject1 == null) {
                    break label409;
                  }
                  paramInt2 = 1;
                  break;
                  localObject3 = com.tencent.mm.plugin.biz.b.a.vtj;
                  com.tencent.mm.plugin.biz.b.a.a((akj)localObject2, (ab)localObject1);
                }
                paramInt2 = 0;
                continue;
              }
              paramInt2 = 0;
              continue;
            }
            label409:
            paramInt2 = Util.getInt((String)((Map)localObject3).get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
            if (paramInt2 == 2)
            {
              localObject2 = ae.acGm;
              ae.bvF((String)localObject1);
              localObject1 = ae.acGm;
              ae.yX(1L);
              paramInt2 = 1;
            }
            else if (paramInt2 == 0)
            {
              ad.bvD((String)localObject1);
              paramInt2 = 1;
            }
            else
            {
              if (paramInt2 != 1) {
                break label231;
              }
              localObject1 = ad.a((String)localObject1, (Map)localObject3, paramInt1, bool);
              if (localObject1 == null) {
                localObject1 = null;
              }
              for (;;)
              {
                if (localObject1 == null) {
                  break label530;
                }
                paramInt2 = 1;
                break;
                localObject3 = com.tencent.mm.plugin.biz.b.a.vtj;
                com.tencent.mm.plugin.biz.b.a.a((akj)localObject2, (ab)localObject1);
              }
              label530:
              paramInt2 = 0;
            }
          }
        }
      }
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      if (paramInt2 != 0) {
        atj().encode("ReSortBizMsgRecBuffer", paramqd.YUO);
      }
      AppMethodBeat.o(248593);
      return;
      atj().encode("ReSortBizMsgRecBuffer", paramqd.YUO);
    }
  }
  
  private static final void a(qd paramqd, int paramInt, ah.e parame, qa paramqa, List paramList)
  {
    AppMethodBeat.i(248641);
    s.u(paramqd, "$resp");
    s.u(parame, "$groupId");
    s.u(paramList, "$recList");
    long l1 = parame.aixc;
    int j;
    if (paramqa == null)
    {
      j = 0;
      if (!ayH(paramInt)) {
        break label83;
      }
      Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult is isInTimeLine now");
      ayF(8);
      ayL(1);
    }
    for (;;)
    {
      acGu = false;
      AppMethodBeat.o(248641);
      return;
      j = paramqa.YUy;
      break;
      label83:
      if (!ayI(paramInt)) {
        break label97;
      }
      ayL(2);
    }
    label97:
    parame = paramqd.YUS;
    Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult size %d, rank_sessionid %s, groupId=" + l1 + ", maxWeight=" + j, new Object[] { Integer.valueOf(parame.size()), paramqd.YTN });
    int i;
    if (Util.isNullOrNil((List)parame))
    {
      ayF(4);
      Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult items is null");
      i = 4;
    }
    label489:
    for (;;)
    {
      a(paramqd, j, paramInt);
      ayL(i);
      break;
      if (!ayJ(paramInt)) {
        l1 = com.tencent.mm.an.af.bHl().iYD();
      }
      Object localObject1;
      if (!ayK(paramInt))
      {
        paramqa = aa.acFb;
        s.s(parame, "items");
        paramqa = aa.cu(parame);
        localObject1 = (Collection)paramqa;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label363;
        }
      }
      label363:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          d.a(parame, (b)new af.a(paramqa));
        }
        c(l1, parame);
        d.a(parame, (b)af.b.acGy);
        d.a(parame, (b)new af.c(paramList, l1));
        ayF(5);
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult");
        if ((com.tencent.mm.an.af.bHl().iYB() > 0) || (ayJ(paramInt))) {
          break label369;
        }
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult no redDot");
        ayF(10);
        i = 3;
        break;
      }
      label369:
      if ((l1 != atj().decodeLong("ReSortBizMsgMaxGroupId", 0L)) && (!ayJ(paramInt)))
      {
        ayF(11);
        Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult MsgMaxGroupId has changed!");
        i = 5;
      }
      else
      {
        paramqa = new LinkedList();
        long l4 = atj().decodeLong("BizLastMsgId", 0L);
        paramList = parame.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localObject1 = (pz)paramList.next();
          if (j > 0) {
            ((pz)localObject1).weight = kotlin.k.k.qv(((pz)localObject1).weight, j);
          }
          if (localObject1 == null) {
            parame = null;
          }
          Object localObject2;
          boolean bool;
          long l2;
          long l3;
          for (;;)
          {
            if (parame != null)
            {
              parame.field_rankSessionId = paramqd.YTN;
              paramqa.add(parame);
              localObject2 = com.tencent.mm.plugin.biz.b.a.vtj;
              s.s(localObject1, "item");
              com.tencent.mm.plugin.biz.b.a.a((pz)localObject1, parame);
              if (parame.iYa() != l1) {
                break;
              }
              i += 1;
              break;
              parame = com.tencent.mm.an.af.bHl().aq(((pz)localObject1).YUq, "msgId");
              if ((parame == null) || (parame.field_msgId == 0L))
              {
                Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo msg not found");
                parame = null;
              }
              else if (parame.field_isRead == 1)
              {
                Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo msg is read");
                parame = null;
              }
              else if (System.currentTimeMillis() - parame.field_createTime > 604800000L)
              {
                Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo too old msg %d", new Object[] { Long.valueOf(parame.field_createTime) });
                parame = null;
              }
              else
              {
                if ((parame.iYa() != l1) && (((pz)localObject1).YUv != 2) && (!ayJ(paramInt))) {
                  parame.acFx = true;
                }
                long l5 = ((pz)localObject1).weight;
                if ((((pz)localObject1).YUv != 2) || (l4 == parame.field_msgId)) {
                  break label1061;
                }
                localObject2 = v.acEJ;
                if (v.yE(parame.field_msgId)) {
                  break label1061;
                }
                bool = true;
                if (!bool) {
                  break label1067;
                }
                l2 = ad.bI(l1, parame.field_createTime / 1000L);
                if (!bool) {
                  break label1085;
                }
                l3 = l1 - 1L;
                Log.d("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo groupId - 1");
                ayF(92);
                parame.field_orderFlag = (l5 << 24 & 0xFF000000 | l3 << 32 | l2);
                ad.H(parame);
                if (((pz)localObject1).YUl != 1) {
                  break label1092;
                }
                parame.nH(1);
              }
            }
          }
          for (;;)
          {
            parame.nH(1073741824);
            Log.i("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo bizclientmsgid:%s msgid:%d pic_type:%d biz_flag:%d cardType:%d, weight:%d, groupId=" + l3 + ", serialNumber=" + l2 + ", groupFlag=" + ((pz)localObject1).YUv + ", isSink=" + bool, new Object[] { ((pz)localObject1).YUk, Long.valueOf(((pz)localObject1).YUq), Integer.valueOf(((pz)localObject1).YUl), Integer.valueOf(parame.field_bitFlag), Integer.valueOf(((pz)localObject1).tNW), Integer.valueOf(((pz)localObject1).weight) });
            localObject2 = w.acEV;
            s.u(localObject1, "item");
            s.u(parame, "info");
            if (w.iXX())
            {
              if (((((pz)localObject1).YUl == 1) && (!parame.nG(1))) || ((((pz)localObject1).YUl != 1) && (parame.nG(1)))) {
                w.bvz("checkRespData show big pic flag invalid!");
              }
              if (!parame.nG(1073741824)) {
                w.bvz("checkRespData resort flag invalid!");
              }
              if (parame.field_isRead != 0) {
                w.bvz("CheckRespProcessedData Msg has exposed!");
              }
              if (System.currentTimeMillis() - parame.field_createTime > 604800000L) {
                w.bvz("CheckRespProcessedData time invalid!");
              }
            }
            break label489;
            break;
            bool = false;
            break label725;
            l2 = ad.bH(l1, parame.field_createTime / 1000L);
            break label745;
            l3 = l1;
            break label769;
            parame.field_bitFlag &= 0xFFFFFFFE;
          }
        }
        int k = paramqa.size();
        if ((i < 3) && (i < k))
        {
          Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult return new size %d, newGroupCount %d， lastMsgId=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(l4) });
          ayF(91);
          i = 6;
        }
        else
        {
          Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult new size %d, newGroupCount %d， lastMsgId=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(l4) });
          if (Util.isNullOrNil((List)paramqa)) {
            break label1330;
          }
          ayF(7);
          if (ayH(paramInt))
          {
            ayF(8);
            Log.i("MicroMsg.BizTimeLineResortLogic", "batResortBizTimeLineInfo isInTimeLine just return");
            i = 1;
          }
          else
          {
            if (!ayI(paramInt)) {
              break label1271;
            }
            Log.i("MicroMsg.BizTimeLineResortLogic", "batResortBizTimeLineInfo isInTimeLine just return");
            i = 2;
          }
        }
      }
    }
    label725:
    label745:
    label1271:
    com.tencent.mm.an.af.bHl().mH((List)paramqa);
    label769:
    label1061:
    label1067:
    label1085:
    label1092:
    parame = com.tencent.mm.pluginsdk.c.XNm;
    if (com.tencent.mm.pluginsdk.c.iGw())
    {
      parame = com.tencent.mm.pluginsdk.c.XNm;
      if (com.tencent.mm.pluginsdk.c.iGx())
      {
        Log.i("MicroMsg.BizTimeLineResortLogic", "BizImagePreloadStrategy preload after resort");
        parame = com.tencent.mm.pluginsdk.c.XNm;
        com.tencent.mm.pluginsdk.c.iGA();
      }
    }
    r.acDM.ayv(1);
    for (;;)
    {
      i = 0;
      break;
      label1330:
      ayF(6);
    }
  }
  
  private static boolean a(ab paramab, pz parampz, PLong paramPLong)
  {
    AppMethodBeat.i(248574);
    s.u(paramab, "info");
    s.u(parampz, "item");
    s.u(paramPLong, "maxOrderFlag");
    if ((!paramab.iYe()) && (!paramab.iYf()))
    {
      AppMethodBeat.o(248574);
      return false;
    }
    parampz.YUk = paramab.field_bizClientMsgId;
    parampz.YUq = paramab.field_msgId;
    parampz.weight = ((int)ad.yU(paramab.field_orderFlag));
    label115:
    int j;
    label126:
    Object localObject;
    if (paramab.nG(1))
    {
      i = 1;
      parampz.YUl = i;
      parampz.time = ((int)(paramab.field_createTime / 1000L));
      if (paramab.field_hasShow != 1) {
        break label422;
      }
      i = 1;
      if (paramab.field_isRead != 1) {
        break label427;
      }
      j = 2;
      parampz.eQp = (i | j);
      localObject = v.acEJ;
      long l = paramab.field_msgId;
      s.u(parampz, "item");
      localObject = String.valueOf(l);
      if (MMKVSlotManager.decodeInt$default((MMKVSlotManager)com.tencent.mm.an.c.ovO, (String)localObject, 0, 2, null) != 1) {
        break label433;
      }
    }
    label401:
    label422:
    label427:
    label433:
    for (int i = 1;; i = 0)
    {
      parampz.YUm = i;
      parampz.YUn = com.tencent.mm.an.c.ovO.decodeInt(v.bvu((String)localObject), 0);
      parampz.YUo = ((int)com.tencent.mm.an.c.ovO.decodeLong(v.bvt((String)localObject), 0L));
      parampz.YUp = com.tencent.mm.an.c.ovO.decodeInt(v.bvv((String)localObject), 0);
      Log.d("setExposeParams", "setExposeParams digest_exposure=" + parampz.YUm + ", digest_exposure_cnt=" + parampz.YUn + ", digest_exposure_period=" + parampz.YUo + ", digest_exposure_pos=" + parampz.YUp);
      if (paramab.field_orderFlag > paramPLong.value) {
        paramPLong.value = paramab.field_orderFlag;
      }
      if (!paramab.iYe()) {
        break label438;
      }
      try
      {
        paramPLong = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
        if ((paramPLong != null) && (!Util.isNullOrNil((List)paramPLong.nUC)))
        {
          parampz.url = ((com.tencent.mm.message.v)paramPLong.nUC.get(0)).url;
          parampz.YHv = ((com.tencent.mm.message.v)paramPLong.nUC.get(0)).type;
        }
      }
      catch (Exception paramPLong)
      {
        break label401;
      }
      parampz.tNW = ah.K(paramab);
      AppMethodBeat.o(248574);
      return true;
      i = 2;
      break;
      i = 0;
      break label115;
      j = 0;
      break label126;
    }
    label438:
    if (paramab.iYf())
    {
      paramPLong = paramab.iYp();
      if (paramPLong != null)
      {
        s.u(paramPLong, "<this>");
        if (paramPLong.abrz == 2) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(248574);
          return false;
        }
      }
      if ((paramPLong != null) && (paramPLong.style == 1001) && (paramPLong.abLO != null)) {
        parampz.DVu = paramPLong.hRR;
      }
      for (;;)
      {
        parampz.tNW = ah.K(paramab);
        break;
        ah.a(paramab, parampz);
      }
    }
    AppMethodBeat.o(248574);
    return false;
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(248510);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(248510);
    return localMultiProcessMMKV;
  }
  
  public static void ayE(int paramInt)
  {
    vNO = paramInt;
  }
  
  public static void ayF(int paramInt)
  {
    AppMethodBeat.i(248520);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(248520);
  }
  
  public static void ayG(int paramInt)
  {
    AppMethodBeat.i(248525);
    a(paramInt, null, 0L);
    AppMethodBeat.o(248525);
  }
  
  private static boolean ayH(int paramInt)
  {
    AppMethodBeat.i(248597);
    if ((ad.acGg) && (!ayJ(paramInt)))
    {
      AppMethodBeat.o(248597);
      return true;
    }
    AppMethodBeat.o(248597);
    return false;
  }
  
  private static boolean ayI(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(248602);
    int i;
    if (vIc != vNO)
    {
      i = 1;
      if (((i == 0) && (ad.acGg)) || (!ayJ(paramInt))) {
        break label66;
      }
    }
    for (;;)
    {
      if (bool)
      {
        ayF(34);
        Log.i("MicroMsg.BizTimeLineResortLogic", "hasScrollNotDoResort");
      }
      AppMethodBeat.o(248602);
      return bool;
      i = 0;
      break;
      label66:
      bool = false;
    }
  }
  
  public static boolean ayJ(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5);
  }
  
  private static boolean ayK(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  private static void ayL(int paramInt)
  {
    AppMethodBeat.i(248617);
    atj().encode("ReSortBizMsgFailReason", paramInt);
    AppMethodBeat.o(248617);
  }
  
  private static void b(int paramInt, qa paramqa, long paramLong)
  {
    AppMethodBeat.i(248561);
    Log.d("MicroMsg.BizTimeLineResortLogic", "doReSortCgi isDoingSortBizMsg=%b, isInTimeLine=%b", new Object[] { Boolean.valueOf(acGu), Boolean.valueOf(ad.acGg) });
    if (acGu)
    {
      AppMethodBeat.o(248561);
      return;
    }
    if (ayH(paramInt))
    {
      ayF(9);
      AppMethodBeat.o(248561);
      return;
    }
    long l2 = atj().decodeLong("ReSortBizMsgLastTime", 0L);
    long l3 = atj().decodeLong(s.X("ReSortBizMsgNextReqTime-", Integer.valueOf(paramInt)), 0L);
    switch (paramInt)
    {
    default: 
      l1 = 2L;
      l1 = Math.max(l3, l1);
      l3 = System.currentTimeMillis() / 1000L;
      if ((!iYZ()) || (Math.abs(l3 - l2) >= l1)) {
        break label253;
      }
      if (!ayJ(paramInt)) {
        break;
      }
    }
    for (paramInt = 41;; paramInt = 42)
    {
      ayF(paramInt);
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi return currentTime:%d, lastReSortBizMsgTime:%d, timePast:%d, minReSortBizMsgGap:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l3 - l2), Long.valueOf(l1) });
      AppMethodBeat.o(248561);
      return;
      l1 = 180L;
      break;
      l1 = 60L;
      break;
    }
    label253:
    ab localab = com.tencent.mm.an.af.bHl().iYx();
    if ((localab == null) || (localab.field_msgId == 0L))
    {
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi getLastBizTimeLineInfo return null");
      AppMethodBeat.o(248561);
      return;
    }
    int j = kotlin.k.k.qv(kotlin.k.k.qu(atj().decodeInt(s.X("ReSortBizMsgReqCount-", Integer.valueOf(paramInt)), 10), 5), 200);
    int k = kotlin.k.k.qv(kotlin.k.k.qu(atj().decodeInt(s.X("ReSortBizMsgExtraRecMsgCount-", Integer.valueOf(paramInt)), 10), 0), 50);
    int m = kotlin.k.k.qv(kotlin.k.k.qu(atj().decodeInt(s.X("ReSortBizMsgMinUnExposedCount-", Integer.valueOf(paramInt)), 2), 1), 20);
    int n = kotlin.k.k.qv(kotlin.k.k.qu(atj().decodeInt(s.X("ReSortBizMsgMinUnReadCount-", Integer.valueOf(paramInt)), 1), 0), 20);
    int i = kotlin.k.k.qu(atj().decodeInt(s.X("ReSortBizMsgLimitTime-", Integer.valueOf(paramInt)), 86400), 21600);
    long l1 = (l3 - i) * 1000L;
    atj().encode("ReSortBizMsgMaxGroupId", com.tencent.mm.an.af.bHl().iYD());
    Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi fromScene=" + paramInt + " reqLimit=%d, unReadLimit=%d, unExposedLimit=%d, limitTime=%d, fromScene=" + paramInt, new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i) });
    ah.e locale = new ah.e();
    if (ayJ(paramInt))
    {
      if (paramLong <= 0L)
      {
        Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi orderFlag <= 0");
        AppMethodBeat.o(248561);
        return;
      }
      locale.aixc = ((0x0 & paramLong) >> 32);
    }
    Object localObject2 = com.tencent.mm.an.af.bHl().g(Math.max(j, m), l1, paramLong, paramInt);
    Object localObject1;
    Object localObject4;
    Object localObject5;
    if ((k > 0) && (!ayK(paramInt)))
    {
      localObject1 = com.tencent.mm.an.af.bHl().omV;
      localObject3 = "orderFlag DESC limit ".concat(String.valueOf(k));
      localObject3 = (Iterable)ac.s(((com.tencent.mm.storagebase.h)localObject1).query("BizTimeLineInfo", null, "type=? and isRead=?", new String[] { "620757041", "0" }, null, null, (String)localObject3));
      localObject1 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ab)((Iterator)localObject1).next()).acFy = true;
      }
      s.s(localObject3, "getBizTimeLineInfoStorag…sortExtraRecCard = true }");
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label807:
      label842:
      label872:
      label878:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (ab)localObject4;
        s.s(localObject2, "list");
        localObject6 = (Iterable)localObject2;
        if ((!(localObject6 instanceof Collection)) || (!((Collection)localObject6).isEmpty()))
        {
          localObject6 = ((Iterable)localObject6).iterator();
          if (((Iterator)localObject6).hasNext()) {
            if (((ab)((Iterator)localObject6).next()).field_msgId == ((ab)localObject5).field_msgId)
            {
              i = 1;
              if (i == 0) {
                break label872;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label878;
          }
          ((Collection)localObject1).add(localObject4);
          break;
          i = 0;
          break label842;
          break label807;
        }
      }
      localObject1 = (List)localObject1;
      localObject4 = new LinkedList();
      localObject5 = new PLong(0L);
      localObject3 = v.acEJ;
      paramLong = System.currentTimeMillis();
      if ((v.acEL) && (v.vHa > 0L))
      {
        v.bG(v.vHa, paramLong);
        ((MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite()).encode(v.bvs(String.valueOf(v.vHa)), paramLong);
      }
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll((Collection)localObject2);
      ((LinkedList)localObject3).addAll((Collection)localObject1);
      localObject6 = kotlin.ah.aiuX;
      localObject3 = ((LinkedList)localObject3).iterator();
      do
      {
        do
        {
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject6 = (ab)((Iterator)localObject3).next();
          } while ((((ab)localObject6).field_createTime < l1) && (!((ab)localObject6).acFy));
          localObject7 = new pz();
          s.s(localObject6, "info");
        } while (!a((ab)localObject6, (pz)localObject7, (PLong)localObject5));
        ((LinkedList)localObject4).add(localObject7);
        if (!((ab)localObject6).acFy)
        {
          localObject8 = w.acEV;
          s.u(localObject7, "item");
          s.u(localObject6, "info");
          if (w.iXX())
          {
            if (((pz)localObject7).weight != ((ab)localObject6).iYb()) {
              w.bvz("checkReqData weight invalid!");
            }
            if (((((pz)localObject7).YUl == 1) && (!((ab)localObject6).nG(1))) || ((((pz)localObject7).YUl != 1) && (((ab)localObject6).nG(1)))) {
              w.bvz("checkReqData show big pic flag invalid!");
            }
            if (((ab)localObject6).field_isRead != 0) {
              w.bvz("checkReqData Msg has exposed!");
            }
            if (((pz)localObject7).time < l1 / 1000L) {
              w.bvz("CheckReqData Msg time invalid!");
            }
          }
        }
      } while (((LinkedList)localObject4).size() < j + k);
      if (!Util.isNullOrNil((List)localObject4)) {
        break label1288;
      }
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi reqMsg is empty");
      if (!ayJ(paramInt)) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = 52;; paramInt = 53)
    {
      ayF(paramInt);
      AppMethodBeat.o(248561);
      return;
      localObject1 = (List)new LinkedList();
      break;
    }
    label1288:
    Object localObject3 = w.acEV;
    if (j + k < ((LinkedList)localObject4).size()) {
      w.bvz("checkReqLimit reqLimit check fail!");
    }
    j = 0;
    localObject2 = ((List)localObject2).iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ab)((Iterator)localObject2).next();
      k = j;
      if (((ab)localObject3).field_hasShow != 1) {
        k = j + 1;
      }
      j = k;
      if (((ab)localObject3).field_isRead != 1)
      {
        i += 1;
        j = k;
      }
    }
    if (iYZ())
    {
      if ((!ayJ(paramInt)) && (j < n))
      {
        Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi unReadLimit return %d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(248561);
        return;
      }
      if (i < m)
      {
        Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi unExposedLimit return %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(248561);
        return;
      }
    }
    localObject2 = new c.a();
    ((c.a)localObject2).otE = ((com.tencent.mm.bx.a)new qc());
    ((c.a)localObject2).otF = ((com.tencent.mm.bx.a)new qd());
    ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/timeline/bizmsgresort";
    ((c.a)localObject2).funcId = 2818;
    Object localObject6 = ((c.a)localObject2).bEF();
    localObject2 = c.b.b(((com.tencent.mm.am.c)localObject6).otB);
    if (localObject2 == null)
    {
      paramqa = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortReq");
      AppMethodBeat.o(248561);
      throw paramqa;
    }
    Object localObject7 = (qc)localObject2;
    ((qc)localObject7).YUB = ((LinkedList)localObject4);
    ((qc)localObject7).scene = paramInt;
    ((qc)localObject7).YUC = 0;
    ((qc)localObject7).YUH = paramqa;
    i = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dav();
    ((qc)localObject7).YUK = i;
    ((qc)localObject7).igg = atj().decodeString("ReSortBizMsgBuffer");
    ((qc)localObject7).YUO = atj().decodeString("ReSortBizMsgRecBuffer");
    localObject2 = v.acEJ;
    ((qc)localObject7).YUL = v.iXP();
    ((qc)localObject7).YUG = com.tencent.mm.an.af.bHl().iYB();
    ((qc)localObject7).YUI = com.tencent.mm.an.af.bHn().ayz(y.acEY);
    ((qc)localObject7).YUJ = com.tencent.mm.an.af.bHn().ayz(y.acEX);
    s.u(localObject5, "maxOrderFlag");
    Object localObject8 = new pz();
    localObject2 = v.acEJ;
    if (v.iXR())
    {
      localObject2 = v.acEJ;
      ((pz)localObject8).YIf = v.iXU();
      ((pz)localObject8).msg_type = 7;
      ((qc)localObject7).YUM = ((pz)localObject8);
      ((qc)localObject7).YUN = atj().decodeInt("ReSortBizMsgFailReason", 0);
      if (localab.field_orderFlag <= ((PLong)localObject5).value) {
        ((qc)localObject7).YUC |= 0x1;
      }
      localObject2 = com.tencent.mm.plugin.biz.b.a.vtj;
      s.u(localObject7, "req");
      localObject2 = String.valueOf(System.currentTimeMillis() / 43200000L);
      localObject3 = String.valueOf((System.currentTimeMillis() - 43200000L) / 43200000L);
      ((qc)localObject7).YUE = (com.tencent.mm.an.c.ovO.decodeInt(com.tencent.mm.plugin.biz.b.a.aii((String)localObject2), 0) + com.tencent.mm.an.c.ovO.decodeInt(com.tencent.mm.plugin.biz.b.a.aii((String)localObject3), 0));
      ((qc)localObject7).YUF = (com.tencent.mm.an.c.ovO.decodeInt(com.tencent.mm.plugin.biz.b.a.aih((String)localObject2), 0) + com.tencent.mm.an.c.ovO.decodeInt(com.tencent.mm.plugin.biz.b.a.aih((String)localObject3), 0));
      acGu = true;
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi, bitFlag=" + ((qc)localObject7).YUC + ", digest_bold_cnt=" + ((qc)localObject7).YUE + ", digest_expose_cnt=" + ((qc)localObject7).YUF + ", size=" + ((LinkedList)localObject4).size() + ", officialAccountPos=" + i + ", rec_card_content_expose_cnt=" + ((qc)localObject7).YUI + ", rec_card_digest_expose_cnt=" + ((qc)localObject7).YUJ + ", lastFailReason=" + ((qc)localObject7).YUN);
      atj().encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000L);
      com.tencent.mm.am.z.a((com.tencent.mm.am.c)localObject6, new af..ExternalSyntheticLambda0(paramInt, locale, paramqa, (List)localObject1));
      if (!ayJ(paramInt)) {
        break label2156;
      }
    }
    label2156:
    for (paramInt = 60;; paramInt = 0)
    {
      ayF(paramInt);
      AppMethodBeat.o(248561);
      return;
      paramLong = atj().decodeLong("BizLastMsgId");
      localObject3 = com.tencent.mm.an.af.bHl().aq(paramLong, "msgId");
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = localObject3;
        if (paramLong < 0L) {
          localObject2 = com.tencent.mm.an.af.bHo().aq(paramLong, "msgId");
        }
      }
      if (localObject2 == null) {
        break;
      }
      a((ab)localObject2, (pz)localObject8, (PLong)localObject5);
      break;
    }
  }
  
  private static final void c(int paramInt, qa paramqa, long paramLong)
  {
    AppMethodBeat.i(248621);
    b(paramInt, paramqa, paramLong);
    AppMethodBeat.o(248621);
  }
  
  private static void c(long paramLong, LinkedList<pz> paramLinkedList)
  {
    AppMethodBeat.i(248581);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    label97:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (pz)localObject2;
      if ((((pz)localObject3).tNW != 0) && ((((pz)localObject3).YUt & 0x2) != 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label97;
        }
        paramLinkedList.add(localObject2);
        break;
      }
    }
    localObject1 = (List)paramLinkedList;
    if (((Collection)localObject1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(248581);
      return;
    }
    paramLinkedList = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (pz)((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.an.af.bHl().aq(((pz)localObject2).YUq, "msgId");
      if ((localObject3 == null) || (((ab)localObject3).field_msgId == 0L))
      {
        Log.w("MicroMsg.BizTimeLineResortLogic", "doSink msg not found");
      }
      else if (((ab)localObject3).field_isRead == 1)
      {
        Log.w("MicroMsg.BizTimeLineResortLogic", "doSink msg is read");
      }
      else
      {
        ((ab)localObject3).field_orderFlag = (ad.bH(paramLong, ((ab)localObject3).field_createTime / 1000L) | paramLong - 1L << 32);
        ad.H((ab)localObject3);
        paramLinkedList.add(localObject3);
        Log.i("MicroMsg.BizTimeLineResortLogic", "doSink msgid:" + ((pz)localObject2).YUq + ", userName:" + ((ab)localObject3).field_talker);
      }
    }
    if (!((Collection)paramLinkedList).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.BizTimeLineResortLogic", s.X("doSink size=", Integer.valueOf(paramLinkedList.size())));
        localObject1 = aa.acFb;
        aa.jX(20L);
        com.tencent.mm.an.af.bHl().mH((List)paramLinkedList);
      }
      AppMethodBeat.o(248581);
      return;
    }
  }
  
  private static final void d(int paramInt, qa paramqa, long paramLong)
  {
    AppMethodBeat.i(248625);
    b(paramInt, paramqa, paramLong);
    AppMethodBeat.o(248625);
  }
  
  public static int iYY()
  {
    return vIc;
  }
  
  private static boolean iYZ()
  {
    AppMethodBeat.i(248514);
    boolean bool = ((Boolean)acGw.getValue()).booleanValue();
    AppMethodBeat.o(248514);
    return bool;
  }
  
  public static boolean iZa()
  {
    return acGu;
  }
  
  public static void yY(long paramLong)
  {
    acGv = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.af
 * JD-Core Version:    0.7.0.1
 */