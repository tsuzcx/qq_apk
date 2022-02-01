package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.e.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class y
{
  private static String IoN = null;
  private static long IoO = 0L;
  public static int IoP = 0;
  public static int IoQ = 1;
  public static long IoR = 180L;
  public static long IoS = 60L;
  public static boolean IoT = false;
  private static boolean IoU = false;
  private static boolean IoV = false;
  private static Boolean IoW = null;
  private static Boolean IoX = null;
  private static Boolean IoY = null;
  private static Boolean IoZ = null;
  private static Boolean Ipa = null;
  private static Boolean Ipb = null;
  private static int dlK = 0;
  
  public static void DA(long paramLong)
  {
    AppMethodBeat.i(124679);
    IoO = paramLong;
    aj.fkD().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
  
  public static long Dy(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean Dz(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (ag.aGf().Ds(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (ag.aGf().fpb() <= ag.aGf().fpt()) {
      ag.aGf().fpu();
    }
    ag.aGf().Dr(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void WP(int paramInt)
  {
    dlK = paramInt;
  }
  
  public static void a(oc paramoc)
  {
    AppMethodBeat.i(124663);
    if ((IoT) || (paramoc == null))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg is isInTimeLine now");
      aaL(8);
      AppMethodBeat.o(124663);
      return;
    }
    Object localObject1 = paramoc.FJq;
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg size %d, replaceExposureTime %d, rank_sessionid %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(paramoc.FJr), paramoc.FIL });
    if (bt.hj((List)localObject1))
    {
      aaL(4);
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg items is null");
      AppMethodBeat.o(124663);
      return;
    }
    aaL(5);
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg");
    if (ag.aGf().fps() <= 0)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg no redDot");
      aaL(10);
      AppMethodBeat.o(124663);
      return;
    }
    long l = ag.aGf().fpt();
    if (l != ax.aQA("brandService").decodeLong("ReSortBizMsgMaxGroupId", 0L))
    {
      aaL(11);
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg MsgMaxGroupId has changed!");
      AppMethodBeat.o(124663);
      return;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quC, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg insertCard = %s", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (bt.hj(paramoc.FJs))) {
        break;
      }
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg recommend_article_info size = %s", new Object[] { Integer.valueOf(paramoc.FJs.size()) });
      int i = 0;
      while (i < paramoc.FJs.size())
      {
        aSE(((crq)paramoc.FJs.get(i)).dBS);
        i += 1;
      }
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((LinkedList)localObject1).iterator();
    if (localIterator.hasNext())
    {
      oa localoa = (oa)localIterator.next();
      Object localObject2;
      if (localoa == null) {
        localObject2 = null;
      }
      label542:
      for (;;)
      {
        label353:
        if (localObject2 != null)
        {
          ((w)localObject2).field_rankSessionId = paramoc.FIL;
          localLinkedList.add(localObject2);
          break;
          if (bt.isNullOrNil(localoa.FJb)) {
            localObject1 = ag.aGf().M(localoa.FJh, "msgId");
          }
          for (;;)
          {
            if ((localObject1 != null) && (((w)localObject1).field_msgId != 0L)) {
              break label542;
            }
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg not found");
            localObject2 = null;
            break;
            localObject2 = ag.aGf();
            String str = localoa.FJb;
            if (bt.isNullOrNil(str))
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = new w();
              localObject2 = ((x)localObject2).hHS.a("BizTimeLineInfo", null, "bizClientMsgId=?", new String[] { String.valueOf(str) }, null, null, null, 2);
              if (((Cursor)localObject2).moveToFirst())
              {
                ((w)localObject1).convertFrom((Cursor)localObject2);
                ((Cursor)localObject2).close();
              }
              else
              {
                ((Cursor)localObject2).close();
                localObject1 = null;
              }
            }
          }
          if (((w)localObject1).field_isRead == 1)
          {
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg is read");
            localObject2 = null;
          }
          else if (System.currentTimeMillis() - ((w)localObject1).field_createTime > 604800000L)
          {
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo too old msg %d", new Object[] { Long.valueOf(((w)localObject1).field_createTime) });
            localObject2 = null;
          }
          else
          {
            if (((w)localObject1).fpb() != l) {
              ((w)localObject1).Iop = true;
            }
            ((w)localObject1).field_orderFlag = (aB(l, ((w)localObject1).field_createTime / 1000L) | localoa.weight << 24 & 0xFF000000 | l << 32);
            r((w)localObject1);
            if (localoa.FJc != 1) {
              break label925;
            }
            ((w)localObject1).hk(1);
          }
        }
      }
      for (;;)
      {
        ((w)localObject1).hk(1073741824);
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo bizclientmsgid:%s msgid:%d pic_type:%d biz_flag:%d cardType:%d, weight:%d", new Object[] { localoa.FJb, Long.valueOf(localoa.FJh), Integer.valueOf(localoa.FJc), Integer.valueOf(((w)localObject1).field_bitFlag), Integer.valueOf(localoa.mrl), Integer.valueOf(localoa.weight) });
        localObject2 = u.Iom;
        d.g.b.p.h(localoa, "item");
        d.g.b.p.h(localObject1, "info");
        localObject2 = localObject1;
        if (!u.fpa()) {
          break label353;
        }
        if (localoa.weight != ((w)localObject1).fpc()) {
          u.aSC("checkRespData weight invalid!");
        }
        if (((localoa.FJc == 1) && (!((w)localObject1).hj(1))) || ((localoa.FJc != 1) && (((w)localObject1).hj(1)))) {
          u.aSC("checkRespData show big pic flag invalid!");
        }
        if (!((w)localObject1).hj(1073741824)) {
          u.aSC("checkRespData resort flag invalid!");
        }
        if (((w)localObject1).field_isRead != 0) {
          u.aSC("CheckRespProcessedData Msg has exposed!");
        }
        localObject2 = localObject1;
        if (System.currentTimeMillis() - ((w)localObject1).field_createTime <= 604800000L) {
          break label353;
        }
        u.aSC("CheckRespProcessedData time invalid!");
        localObject2 = localObject1;
        break label353;
        break;
        label925:
        ((w)localObject1).field_bitFlag &= 0xFFFFFFFE;
      }
    }
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg new size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (!bt.hj(localLinkedList))
    {
      aaL(7);
      paramoc = ag.aGf();
      if (!bt.hj(localLinkedList)) {
        com.tencent.mm.cn.g.fSm().h(new x.5(paramoc, localLinkedList)).b(new x.4(paramoc));
      }
      paramoc = c.EIZ;
      if (c.eYK())
      {
        paramoc = c.EIZ;
        if (c.eYL())
        {
          ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizImagePreloadStrategy preload after resort");
          paramoc = c.EIZ;
          c.eYO();
        }
      }
      p.InU.aaD(1);
      AppMethodBeat.o(124663);
      return;
    }
    aaL(6);
    AppMethodBeat.o(124663);
  }
  
  public static long aB(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDM, "");
    long l1 = l2;
    if (!bt.isNullOrNil(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (bt.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - bt.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      l1 = 604800L;
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDM, str);
      ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static void aJ(bu parambu)
  {
    AppMethodBeat.i(124662);
    if (parambu == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.yt(parambu.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (com.tencent.mm.model.w.vF(parambu.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu.field_talker);
    if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type)) && (!localam.fqg()))
    {
      AppMethodBeat.o(124662);
      return;
    }
    int m = 0;
    int k = -1;
    int j = 0;
    long l1 = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    int n = 0;
    Object localObject2 = bj.Bq(parambu.eLs);
    if (localObject2 != null)
    {
      m = ((bj.b)localObject2).hGN;
      k = ((bj.b)localObject2).cQN;
      j = ((bj.b)localObject2).hGO;
      l1 = ((bj.b)localObject2).hGS;
      if ((((bj.b)localObject2).hGT & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bj.b)localObject2).hGT & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bj.b)localObject2).hGT & 0x4) != 0L)
      {
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambu.field_talker, Long.valueOf(((bj.b)localObject2).hGT) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bj.b)localObject2).hGT & 0x40) != 0L) && (localam != null) && (com.tencent.mm.o.b.lM(localam.field_type)))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((parambu.getType() == 34) || (parambu.getType() == 3))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(parambu.getType()) });
      bool1 = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambu.field_talker, Boolean.valueOf(bool1) });
      if (bool1) {
        break label813;
      }
      c.EIV = true;
      if (!bt.lQ(parambu.field_talker, IoN)) {
        break label547;
      }
      ad.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { IoN });
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (parambu.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!parambu.fpd()) {
          break;
        }
        if (parambu.fpd()) {}
        for (localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (bt.hj(((com.tencent.mm.ai.u)localObject1).hDb))) {
            break label541;
          }
          bool1 = true;
          break;
        }
        label541:
        bool1 = false;
      }
    }
    label547:
    localObject2 = ag.aGg();
    l1 = parambu.field_msgSvrId;
    Object localObject1 = new w();
    localObject2 = ((z)localObject2).hHS.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[] { String.valueOf(l1) }, null, null, null, 2);
    if (((Cursor)localObject2).moveToFirst())
    {
      ((w)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
      if (localObject1 != null) {
        break label790;
      }
    }
    label790:
    for (localObject2 = new w();; localObject2 = localObject1)
    {
      ((w)localObject2).field_msgId = parambu.field_msgId;
      ((w)localObject2).field_msgSvrId = parambu.field_msgSvrId;
      ((w)localObject2).field_content = parambu.field_content;
      ((w)localObject2).field_type = parambu.getType();
      ((w)localObject2).field_talker = parambu.field_talker;
      ((w)localObject2).field_talkerId = parambu.field_talkerId;
      ((w)localObject2).field_createTime = parambu.field_createTime;
      ((w)localObject2).field_imgPath = parambu.field_imgPath;
      ((w)localObject2).jY(parambu.eLr);
      ((w)localObject2).sP(parambu.eLs);
      ((w)localObject2).field_status = parambu.field_status;
      if (localObject1 != null) {
        break label797;
      }
      ag.aGg().o((w)localObject2);
      AppMethodBeat.o(124662);
      return;
      ((Cursor)localObject2).close();
      localObject1 = null;
      break;
    }
    label797:
    ag.aGg().p((w)localObject2);
    AppMethodBeat.o(124662);
    return;
    label813:
    if ((localObject2 != null) && ((((bj.b)localObject2).hGT & 0x2) != 0L))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambu.field_talker, Long.valueOf(((bj.b)localObject2).hGT) });
      AppMethodBeat.o(124662);
      return;
    }
    c.EIV = true;
    localObject2 = ag.aGf().M(parambu.field_msgId, "msgId");
    label1022:
    long l3;
    long l2;
    if (localObject2 == null)
    {
      localObject1 = new w();
      ((w)localObject1).field_msgId = parambu.field_msgId;
      ((w)localObject1).field_msgSvrId = parambu.field_msgSvrId;
      ((w)localObject1).field_content = parambu.field_content;
      ((w)localObject1).field_type = parambu.getType();
      ((w)localObject1).field_talker = parambu.field_talker;
      ((w)localObject1).field_talkerId = parambu.field_talkerId;
      ((w)localObject1).field_createTime = parambu.field_createTime;
      ((w)localObject1).field_imgPath = parambu.field_imgPath;
      ((w)localObject1).jY(parambu.eLr);
      ((w)localObject1).sP(parambu.eLs);
      ((w)localObject1).field_bizClientMsgId = parambu.field_bizClientMsgId;
      if (!bNf()) {
        break label1278;
      }
      ((w)localObject1).field_status = parambu.field_status;
      ((w)localObject1).field_hasShow = 0;
      if (i != 0) {
        ((w)localObject1).hk(1);
      }
      l3 = ag.aGf().fpb();
      long l4 = aB(l3, ((w)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = ag.aGf().fpu();
        l2 = aB(l3, ((w)localObject1).field_createTime / 1000L);
      }
      ((w)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      r((w)localObject1);
      if ((localam == null) || (!localam.adq())) {
        break label1293;
      }
    }
    label1293:
    for (((w)localObject1).field_placeTop = 1;; ((w)localObject1).field_placeTop = 0)
    {
      if (localObject2 != null) {
        break label1302;
      }
      ((w)localObject1).field_isExpand = bool2;
      ag.aGf().o((w)localObject1);
      if (!IoV)
      {
        IoV = true;
        com.tencent.e.h.LTJ.a(new y.5(), 1000L, "BizTimeLineInfoStorageThread");
      }
      if (fpH()) {
        aaK(IoP);
      }
      ad.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((w)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
      label1278:
      ((w)localObject1).field_status = 4;
      ((w)localObject1).field_hasShow = 1;
      break label1022;
    }
    label1302:
    ag.aGf().p((w)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void aK(bu parambu)
  {
    AppMethodBeat.i(124676);
    if (parambu == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    ag.aGf().Dv(parambu.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static void aSE(String paramString)
  {
    AppMethodBeat.i(207279);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(207279);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
      AppMethodBeat.o(207279);
      return;
    }
    int i = paramString.indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = bw.M(paramString.substring(i), "sysmsg");
      if (localObject1 == null)
      {
        ad.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
        AppMethodBeat.o(207279);
      }
    }
    else
    {
      AppMethodBeat.o(207279);
      return;
    }
    Object localObject2 = ag.aGf().fpq();
    paramString = bJ((Map)localObject1);
    aa.a(paramString, (Map)localObject1);
    if (!aa.b(paramString, null))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
      AppMethodBeat.o(207279);
      return;
    }
    int j = paramString.pos;
    long l4 = paramString.weight;
    if ((j < 0) && (l4 < 0L))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
      AppMethodBeat.o(207279);
      return;
    }
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
    long l3 = ag.aGf().fpb();
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString.HAd.HzY.nDo);
    if ((localObject1 != null) && (com.tencent.mm.o.b.lM(((aw)localObject1).field_type)))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", new Object[] { paramString.HAd.HzY.nDo });
      AppMethodBeat.o(207279);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 1L, 1L, false);
    localObject1 = new w();
    ((w)localObject1).field_msgId = ag.aGf().fpy();
    ((w)localObject1).field_msgSvrId = 0L;
    ((w)localObject1).field_type = 620757041;
    ((w)localObject1).field_talker = paramString.HAd.HzY.nDo;
    ((w)localObject1).field_talkerId = 0;
    long l1;
    label429:
    long l2;
    if (paramString.HAg == 1)
    {
      i = 1;
      if (i == 0) {
        break label738;
      }
      if (Math.abs(paramString.Hki * 1000L - System.currentTimeMillis()) > 86400000L) {
        break label730;
      }
      l1 = paramString.Hki * 1000L;
      ((w)localObject1).field_createTime = l1;
      ((w)localObject1).jY(1);
      ((w)localObject1).field_status = 3;
      ((w)localObject1).b(paramString);
      l2 = 0L;
      l1 = l2;
      if (localObject2 != null)
      {
        if (l4 < 0L) {
          break label772;
        }
        l1 = Math.min(l4, Dy(((w)localObject2).field_orderFlag));
      }
      label488:
      l2 = aB(l3, ((w)localObject1).field_createTime / 1000L);
      if (l2 < 4294967296L) {
        break label840;
      }
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l2) });
      l3 = ag.aGf().fpu();
      l2 = aB(l3, ((w)localObject1).field_createTime / 1000L);
    }
    label772:
    label833:
    label840:
    for (;;)
    {
      ((w)localObject1).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      r((w)localObject1);
      boolean bool = ag.aGf().o((w)localObject1);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s", new Object[] { Boolean.valueOf(bool), paramString.HAd.HzY.nDo });
      int k;
      if ((bool) && (paramString.style == 101))
      {
        localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(84L);
        localObject2 = q.Ioe;
        i = paramString.pos;
        j = paramString.HAg;
        k = paramString.style;
        l1 = paramString.Hki;
        localObject2 = paramString.HAi;
        if (paramString.HAf == null) {
          break label833;
        }
      }
      for (paramString = paramString.HAf.FHY;; paramString = "")
      {
        q.a((w)localObject1, 1, i, j, 3, k, l1, (String)localObject2, paramString, "");
        AppMethodBeat.o(207279);
        return;
        i = 0;
        break;
        label730:
        l1 = System.currentTimeMillis();
        break label429;
        label738:
        if (localObject2 != null) {}
        for (l1 = ((w)localObject2).field_createTime + 1000L;; l1 = System.currentTimeMillis())
        {
          ((w)localObject1).field_createTime = l1;
          break;
        }
        if (j == 0)
        {
          l1 = Dy(((w)localObject2).field_orderFlag);
          break label488;
        }
        localObject2 = ag.aGf().aaI(j - 1);
        if (localObject2 == null)
        {
          ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
          l1 = l2;
          break label488;
        }
        l1 = Dy(((w)localObject2).field_orderFlag);
        break label488;
      }
    }
  }
  
  public static void aSF(String paramString)
  {
    IoN = paramString;
  }
  
  public static void aaK(int paramInt)
  {
    AppMethodBeat.i(124664);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124656);
        y.aaM(this.Ipc);
        AppMethodBeat.o(124656);
      }
    }, "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(124664);
  }
  
  public static void aaL(int paramInt)
  {
    AppMethodBeat.i(124665);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(124665);
  }
  
  private static dlt bJ(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    dlt localdlt = new dlt();
    localdlt.HAd = new dlo();
    localdlt.HAd.GfK = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localdlt.HAd.FJU = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localdlt.HAd.HzY = new dlq();
    localdlt.HAd.HzY.FJT = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localdlt.HAd.HzY.nDo = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localdlt.HAd.HzY.nEt = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localdlt.HAd.HzY.HAa = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localdlt.HAd.HzY.jdf = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new dls();
    Object localObject3 = new aky();
    int i = 0;
    Object localObject1;
    if (i < 20)
    {
      StringBuilder localStringBuilder = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount.NegativeFeedbackReason");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (bt.isNullOrNil((String)localObject1)) {
          break label296;
        }
        ((aky)localObject3).FJN.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((aky)localObject3).FJO = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((dls)localObject2).HAc = ((aky)localObject3);
    localdlt.HAd.HzZ = ((dls)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new dlp();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((dlp)localObject2).Title = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (bt.isNullOrNil(((dlp)localObject2).Title)) {
          break label923;
        }
        ((dlp)localObject2).FFU = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((dlp)localObject2).FFW = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((dlp)localObject2).FFY = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((dlp)localObject2).FFZ = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((dlp)localObject2).FGa = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((dlp)localObject2).hCZ = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((dlp)localObject2).FGh = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((dlp)localObject2).FGi = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((dlp)localObject2).FGj = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((dlp)localObject2).FGk = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((dlp)localObject2).CreateTime = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((dlp)localObject2).FJP = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        ((dlp)localObject2).FJQ = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VoiceDuration"), -1);
        localdlt.HAd.FJV.add(localObject2);
        i += 1;
        break;
      }
    }
    label923:
    localdlt.pos = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localdlt.weight = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localdlt.Hki = bt.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localdlt.HAi = ((String)paramMap.get(".sysmsg.BizAccountRecommend.CardId"));
    localdlt.style = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    AppMethodBeat.o(124669);
    return localdlt;
  }
  
  public static boolean bNf()
  {
    AppMethodBeat.i(124680);
    if (IoW != null)
    {
      bool = IoW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    int i = ax.aQA("brandService").decodeInt("BizTimeLineOpenStatus", -1);
    if (i == 1) {
      IoW = Boolean.TRUE;
    }
    while (IoW != null)
    {
      bool = IoW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
      if (i == 0) {
        IoW = Boolean.FALSE;
      }
    }
    if ((((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDN, Integer.valueOf(0))).intValue() & 0x1) > 0)
    {
      IoW = Boolean.TRUE;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      bool = IoW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    i = ag.aGf().fpw();
    if (i > 4000)
    {
      IoW = Boolean.FALSE;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen too match data totalCount %d", new Object[] { Integer.valueOf(i) });
      bool = IoW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quf, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IoW = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { IoW });
      bool = IoW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
  }
  
  public static void c(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.gqE == null) || (parama.gqE.Fvk == null))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    Object localObject2 = parama.gqE;
    d.g.b.p.h(localObject2, "addMsg");
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK();
    String str1 = com.tencent.mm.platformtools.z.a(((cv)localObject2).Fvi);
    label136:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aI(str1, ((cv)localObject2).xbt);
      if (localObject1 == null) {
        break label234;
      }
      l = ((ei)localObject1).field_msgId;
      if (l == 0L) {
        break label246;
      }
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (((ei)localObject1).field_createTime + 604800000L >= bj.B(str1, ((cv)localObject2).CreateTime)) {
        break label240;
      }
      bool = true;
      label178:
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "filerDuplicateMsg user = " + ((cv)localObject2).Fvi + ", result = " + bool);
    }
    for (;;)
    {
      if (!bool) {
        break label252;
      }
      AppMethodBeat.o(124666);
      return;
      localObject1 = null;
      break;
      label234:
      l = 0L;
      break label136;
      label240:
      bool = false;
      break label178;
      label246:
      bool = false;
    }
    label252:
    int j = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    localObject1 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if (localObject1 == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).ze(j))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(124666);
      return;
    }
    int k = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", new Object[] { Integer.valueOf(k) });
    localObject1 = com.tencent.mm.platformtools.z.a(parama.gqE.Fvk);
    parama = ax.aQA("brandService");
    if (k <= 0)
    {
      localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
      com.tencent.mm.kernel.g.ajA();
      parama.encode(com.tencent.mm.kernel.a.aiq(), (String)localObject1);
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 0L, 1L, false);
    long l = bt.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
    String str2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
    int m = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    int n = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    int i1 = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
    localObject2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.CardId");
    str1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.ExpType");
    int i = 0;
    if (i < 2)
    {
      Object localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (parama = "";; parama = Integer.valueOf(1))
      {
        String str3 = parama;
        localObject3 = (String)paramMap.get(str3 + ".AppMsg.Title");
        if (bt.isNullOrNil((String)localObject3)) {
          break label799;
        }
        parama = (String)paramMap.get(str3 + ".UserName");
        str3 = (String)paramMap.get(str3 + ".AppMsg.ContentUrl");
        localObject3 = com.tencent.mm.pluginsdk.ui.tools.x.aNF((String)localObject3);
        str3 = com.tencent.mm.pluginsdk.ui.tools.x.aNF(str3);
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", new Object[] { parama });
        com.tencent.mm.plugin.report.service.g.yhR.f(18106, new Object[] { parama, Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), localObject3, str3 });
        i += 1;
        break;
      }
    }
    label799:
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { str2, Long.valueOf(l) });
    if (k > 0) {
      com.tencent.e.h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124659);
          y.aSE(this.jIw);
          if (y.fpH()) {
            y.aaK(y.IoP);
          }
          AppMethodBeat.o(124659);
        }
      }, "BizInsertTlRecCardThreadImmediately");
    }
    if (j == 101)
    {
      paramMap = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.Cj(83L);
      paramMap = q.Ioe;
      q.a(m, n, i1, 3, j, l, (String)localObject2, str1, "");
    }
    AppMethodBeat.o(124666);
  }
  
  public static void fpA()
  {
    AppMethodBeat.i(124667);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124660);
        y.fpB();
        p localp = p.InU;
        String str;
        Object localObject1;
        int i;
        if (p.foN())
        {
          str = p.bNe().decodeString(p.aSn("biz_ad_card_data"));
          localObject1 = (CharSequence)str;
          if ((localObject1 != null) && (!n.aE((CharSequence)localObject1))) {
            break label96;
          }
          i = 1;
          if ((i != 0) || (bt.isNullOrNil(p.aSp(str)))) {
            break label101;
          }
          i = 1;
          label71:
          if (i != 0) {
            break label106;
          }
          ad.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
        }
        for (;;)
        {
          localObject1 = p.InU;
          p.foS();
          AppMethodBeat.o(124660);
          return;
          label96:
          i = 0;
          break;
          label101:
          i = 0;
          break label71;
          label106:
          localObject1 = ag.aGf();
          d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
          Object localObject2 = ((x)localObject1).fpq();
          if (localObject2 == null)
          {
            ad.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
            com.tencent.mm.plugin.webcanvas.f.Cj(31L);
            localObject1 = ag.aGf();
            d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
            long l = ((x)localObject1).fpt();
            w localw = new w();
            localw.field_content = str;
            localw.field_type = 637534257;
            if (p.foM() <= 0)
            {
              localObject1 = ag.aGf();
              localObject3 = "SELECT count(*) FROM BizTimeLineInfo where type=637534257 and createTime > ".concat(String.valueOf(bj.aCb() - 86400000L));
              localObject1 = ((x)localObject1).hHS.a((String)localObject3, null, 0);
              i = 0;
              if (((Cursor)localObject1).moveToFirst()) {
                i = ((Cursor)localObject1).getInt(0);
              }
              ((Cursor)localObject1).close();
              int j = p.InN;
              if (1 > j) {}
              for (;;)
              {
                p.InN = p.bNe().decodeInt("biz_card_max_ad_count", 1);
                j = p.InN;
                if ((1 > j) || (10 < j)) {
                  p.InN = 1;
                }
                do
                {
                  if (i < p.InN) {
                    break label448;
                  }
                  ad.i("MicroMsg.BizCardLogic", "insertAd too much ad count=".concat(String.valueOf(i)));
                  localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
                  com.tencent.mm.plugin.webcanvas.f.Cj(32L);
                  break;
                } while (10 >= j);
              }
            }
            ad.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
            localObject1 = ag.aGf();
            Object localObject3 = String.format("DELETE FROM %s WHERE %s = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257) });
            ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(((x)localObject1).hHS.execSQL("BizTimeLineInfo", (String)localObject3)) });
            localObject3 = new x.a();
            ((x.a)localObject3).IoG = x.b.IoJ;
            ((x)localObject1).a((x.a)localObject3);
            label448:
            localObject1 = ag.aGf();
            localObject3 = "SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(l << 32));
            localObject3 = ((x)localObject1).hHS.a((String)localObject3, null, 0);
            localObject1 = null;
            if (((Cursor)localObject3).moveToFirst())
            {
              localObject1 = new w();
              ((w)localObject1).convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
            if (localObject1 != null)
            {
              ad.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.g.yhR.f(20636, new Object[] { localw.fpo(), localw.getTraceId(), Integer.valueOf(2) });
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(33L);
            }
            else if ((p.foM() != 1) && (ag.aGf().Dx(l << 32) != null))
            {
              ad.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.g.yhR.f(20636, new Object[] { localw.fpo(), localw.getTraceId(), Integer.valueOf(1) });
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(34L);
            }
            else
            {
              localw.field_msgId = ag.aGf().fpy();
              localw.field_msgSvrId = 0L;
              localw.field_talker = "";
              localw.field_talkerId = 0;
              localw.field_createTime = bj.aCb();
              if (((w)localObject2).fpf()) {}
              for (l = ((com.tencent.mm.g.c.am)localObject2).eLu;; l = ((w)localObject2).field_createTime)
              {
                localw.eLu = l;
                localw.eKU = true;
                localw.jY(1);
                localw.field_status = 3;
                localObject2 = ag.aGf().hHS.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset 1", null, 0);
                localObject1 = null;
                if (((Cursor)localObject2).moveToFirst())
                {
                  localObject1 = new w();
                  ((w)localObject1).convertFrom((Cursor)localObject2);
                }
                ((Cursor)localObject2).close();
                if (localObject1 != null) {
                  break label832;
                }
                ad.w("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
                break;
              }
              label832:
              p.bNe().encode(p.aSn("biz_ad_card_data"), "");
              localp.n(localw);
              for (localw.field_orderFlag = (((w)localObject1).field_orderFlag - 1L); ag.aGf().Dm(localw.field_orderFlag) != null; localw.field_orderFlag -= 1L) {
                ad.w("MicroMsg.BizCardLogic", "insertAd field_orderFlag conflict orderFlag=" + localw.field_orderFlag);
              }
              boolean bool = ag.aGf().o(localw);
              ad.i("MicroMsg.BizCardLogic", "insertAd result: " + bool + ", msgId:" + localw.field_msgId + " orderFlag:" + localw.field_orderFlag + " content: " + str);
              com.tencent.mm.plugin.report.service.g.yhR.f(20636, new Object[] { localw.fpo(), localw.getTraceId(), Integer.valueOf(0) });
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(35L);
            }
          }
        }
      }
    }, "BizInsertTlRecCardThread");
    AppMethodBeat.o(124667);
  }
  
  public static void fpB()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(124668);
      return;
    }
    Object localObject2 = ax.aQA("brandService");
    Object localObject1 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.ajA();
    Object localObject3 = com.tencent.mm.kernel.a.aiq();
    Object localObject4 = ((ax)localObject2).decodeString((String)localObject3);
    if (bt.isNullOrNil((String)localObject4))
    {
      ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(124668);
      return;
    }
    int i = ((String)localObject4).indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = bw.M(((String)localObject4).substring(i), "sysmsg");
      if (localObject1 == null)
      {
        ad.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject4 });
        AppMethodBeat.o(124668);
      }
    }
    else
    {
      AppMethodBeat.o(124668);
      return;
    }
    d.g.b.p.h(localObject1, "values");
    if (!bt.isNullOrNil((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Data"))) {
      i = 1;
    }
    boolean bool;
    int j;
    int k;
    while (i != 0)
    {
      d.g.b.p.h(localObject1, "values");
      localObject2 = ag.aGf();
      d.g.b.p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      localObject2 = ((x)localObject2).fpq();
      if (localObject2 == null)
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
        AppMethodBeat.o(124668);
        return;
        i = 0;
      }
      else
      {
        if (((w)localObject2).field_status == 4)
        {
          ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
          AppMethodBeat.o(124668);
          return;
        }
        localObject3 = ax.aQA("brandService");
        localObject4 = new StringBuilder("BizLatestRecommendCardInfo");
        d.g.b.p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
        ((ax)localObject3).encode(com.tencent.mm.kernel.a.aiq(), "");
        localObject3 = aa.bK((Map)localObject1);
        if (localObject3 == null)
        {
          AppMethodBeat.o(124668);
          return;
        }
        if (!aa.b((dlt)localObject3, null))
        {
          ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
          AppMethodBeat.o(124668);
          return;
        }
        localObject1 = ag.aGf();
        d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
        l2 = ((x)localObject1).fpt();
        if (ag.aGf().Dx(l2 << 32) != null)
        {
          ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard groupId %d already has a recommend msg", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(124668);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 1L, 1L, false);
        localObject4 = new w();
        ((w)localObject4).field_msgId = ag.aGf().fpy();
        ((w)localObject4).field_msgSvrId = 0L;
        ((w)localObject4).field_type = 620757041;
        ((w)localObject4).field_talker = "";
        ((w)localObject4).field_talkerId = 0;
        ((w)localObject2).field_createTime -= 1000L;
        ((w)localObject4).jY(1);
        ((w)localObject4).field_status = 3;
        ((w)localObject4).b((dlt)localObject3);
        l1 = 0L;
        if (((dlt)localObject3).HAh.weight >= 0)
        {
          l1 = d.k.h.aI(((dlt)localObject3).HAh.weight, Dy(((w)localObject2).field_orderFlag));
          ((w)localObject4).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | aB(l2, ((w)localObject4).field_createTime / 1000L));
          r((w)localObject4);
          bool = ag.aGf().o((w)localObject4);
          ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + bool + ", title = " + ((dlt)localObject3).HAh.title);
          if (bool)
          {
            localObject1 = com.tencent.mm.plugin.webcanvas.g.Dzc;
            com.tencent.mm.plugin.webcanvas.g.eLs();
            p.InU.n((w)localObject4);
            localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
            com.tencent.mm.plugin.webcanvas.f.Cj(82L);
            localObject1 = q.Ioe;
            i = ((dlt)localObject3).pos;
            j = ((dlt)localObject3).HAg;
            k = ((dlt)localObject3).style;
            l1 = ((dlt)localObject3).Hki;
            localObject1 = ((dlt)localObject3).HAh;
            if (localObject1 == null) {
              break label875;
            }
            localObject1 = ((crs)localObject1).cardId;
            label715:
            localObject2 = ((dlt)localObject3).HAf;
            if (localObject2 == null) {
              break label881;
            }
            localObject2 = ((aig)localObject2).FHY;
            label734:
            localObject3 = ((dlt)localObject3).HAh;
            if (localObject3 == null) {
              break label887;
            }
          }
        }
        label875:
        label881:
        label887:
        for (localObject3 = ((crs)localObject3).dzP;; localObject3 = null)
        {
          q.a((w)localObject4, 2, i, j, 5, k, l1, (String)localObject1, (String)localObject2, (String)localObject3);
          AppMethodBeat.o(124668);
          return;
          if (((dlt)localObject3).HAh.pos == 0)
          {
            l1 = Dy(((w)localObject2).field_orderFlag);
            ((w)localObject2).field_createTime += 1000L;
            break;
          }
          localObject1 = ag.aGf().aaI(((dlt)localObject3).HAh.pos - 1);
          if (localObject1 == null)
          {
            ad.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
            break;
          }
          l1 = Dy(((w)localObject1).field_orderFlag);
          ((w)localObject1).field_createTime -= 1000L;
          break;
          localObject1 = null;
          break label715;
          localObject2 = null;
          break label734;
        }
      }
    }
    localObject4 = ag.aGf().fpq();
    if (localObject4 == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      AppMethodBeat.o(124668);
      return;
    }
    if (((w)localObject4).field_status == 4)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
      AppMethodBeat.o(124668);
      return;
    }
    ((ax)localObject2).encode((String)localObject3, "");
    localObject3 = bJ((Map)localObject1);
    aa.a((dlt)localObject3, (Map)localObject1);
    if (!aa.b((dlt)localObject3, null))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      AppMethodBeat.o(124668);
      return;
    }
    i = ((dlt)localObject3).pos;
    long l3 = ((dlt)localObject3).weight;
    if ((i < 0) && (l3 < 0L))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l3) });
      AppMethodBeat.o(124668);
      return;
    }
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l3) });
    long l2 = ag.aGf().fpt();
    if (ag.aGf().Dx(l2 << 32) != null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard groupId %d already has a recommend msg", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(124668);
      return;
    }
    localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(((dlt)localObject3).HAd.HzY.nDo);
    if ((localObject1 != null) && (com.tencent.mm.o.b.lM(((aw)localObject1).field_type)))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { ((dlt)localObject3).HAd.HzY.nDo });
      AppMethodBeat.o(124668);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 1L, 1L, false);
    localObject2 = new w();
    ((w)localObject2).field_msgId = ag.aGf().fpy();
    ((w)localObject2).field_msgSvrId = 0L;
    ((w)localObject2).field_type = 620757041;
    ((w)localObject2).field_talker = ((dlt)localObject3).HAd.HzY.nDo;
    ((w)localObject2).field_talkerId = 0;
    ((w)localObject4).field_createTime -= 1000L;
    ((w)localObject2).jY(1);
    ((w)localObject2).field_status = 3;
    ((w)localObject2).b((dlt)localObject3);
    long l1 = 0L;
    if (l3 >= 0L)
    {
      l1 = Math.min(l3, Dy(((w)localObject4).field_orderFlag));
      ((w)localObject2).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | aB(l2, ((w)localObject2).field_createTime / 1000L));
      r((w)localObject2);
      bool = ag.aGf().o((w)localObject2);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s", new Object[] { Boolean.valueOf(bool), ((dlt)localObject3).HAd.HzY.nDo });
      if ((bool) && (((dlt)localObject3).style == 101))
      {
        localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(84L);
        localObject1 = q.Ioe;
        i = ((dlt)localObject3).pos;
        j = ((dlt)localObject3).HAg;
        k = ((dlt)localObject3).style;
        l1 = ((dlt)localObject3).Hki;
        localObject4 = ((dlt)localObject3).HAi;
        if (((dlt)localObject3).HAf == null) {
          break label1605;
        }
      }
    }
    label1605:
    for (localObject1 = ((dlt)localObject3).HAf.FHY;; localObject1 = "")
    {
      q.a((w)localObject2, 2, i, j, 3, k, l1, (String)localObject4, (String)localObject1, "");
      AppMethodBeat.o(124668);
      return;
      if (i == 0)
      {
        l1 = Dy(((w)localObject4).field_orderFlag);
        ((w)localObject4).field_createTime += 1000L;
        break;
      }
      localObject1 = ag.aGf().aaI(i - 1);
      if (localObject1 == null)
      {
        ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
        break;
      }
      l1 = Dy(((w)localObject1).field_orderFlag);
      ((w)localObject1).field_createTime -= 1000L;
      break;
    }
  }
  
  public static void fpC()
  {
    AppMethodBeat.i(207280);
    com.tencent.e.h.LTJ.f(new y.6(), "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(207280);
  }
  
  public static void fpD()
  {
    AppMethodBeat.i(124678);
    if (!bNf())
    {
      AppMethodBeat.o(124678);
      return;
    }
    bq localbq = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv();
    at localat = localbq.aTz("officialaccounts");
    if (localat == null) {
      localat = new at("officialaccounts");
    }
    label798:
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = ag.aGg().fpq();
      Object localObject1 = ag.aGf().fpq();
      Object localObject2 = ag.aGf().hHS.a("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null, 0);
      if (((Cursor)localObject2).moveToFirst()) {}
      label288:
      label1312:
      for (long l1 = ((Cursor)localObject2).getLong(0);; l1 = 0L)
      {
        ((Cursor)localObject2).close();
        long l2;
        if (localObject3 != null)
        {
          l2 = ((w)localObject3).field_createTime;
          if (localObject1 == null) {
            break label1334;
          }
        }
        label418:
        label1331:
        label1334:
        for (int i = ag.aGf().Du(((w)localObject1).field_orderFlag);; i = 0)
        {
          int j = ag.aGg().bUJ();
          if (j > 0) {
            if (l2 > l1)
            {
              localat.lP(16);
              localat.kp(j);
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            if ((localObject2 != null) && (((w)localObject2).field_msgId != 0L)) {
              break label288;
            }
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
            localat.fqK();
            if (!bool) {
              localbq.a(localat, localat.field_username);
            }
            AppMethodBeat.o(124678);
            return;
            l2 = 0L;
            break;
            localat.lO(16);
            localat.kp(i);
            localObject2 = localObject1;
            continue;
            localat.lO(16);
            localat.kp(i);
            localObject2 = localObject1;
          }
          long l3;
          if ((localObject2 == localObject1) && (((w)localObject2).field_placeTop == 1))
          {
            localat.lO(32);
            if (localObject2 == localObject3)
            {
              l3 = ((w)localObject2).field_msgId;
              if (IoO == 0L) {
                IoO = aj.fkD().getLong("biz_time_line_last_notify_msg_id", -1L);
              }
              if (l3 != IoO) {
                break label992;
              }
              localat.lP(64);
            }
            label365:
            if (!((w)localObject2).fpe()) {
              break label1002;
            }
            localObject1 = new bu();
            ((bu)localObject1).setContent(((com.tencent.mm.g.c.am)localObject2).eLs);
            ((bu)localObject1).tN(((w)localObject2).field_talker);
            ((bu)localObject1).setStatus(3);
            ((bu)localObject1).qA(((w)localObject2).field_createTime);
          }
          for (;;)
          {
            l3 = Math.min(cf.aCL(), localat.field_conversationTime);
            l1 = Math.max(l2, l1);
            if (((ei)localObject1).field_msgId <= 0L)
            {
              if (((w)localObject2).field_type == 10002)
              {
                i = 1;
                label461:
                if ((i == 0) && (!((w)localObject2).fpe()) && (!((w)localObject2).fpf()) && (!((w)localObject2).fpg())) {
                  break label1262;
                }
              }
            }
            else
            {
              localat.aL((bu)localObject1);
              localat.setContent(((ei)localObject1).field_talker + ":" + ((ei)localObject1).field_content);
              localat.tA(Integer.toString(((bu)localObject1).getType()));
              bq.b localb = localbq.Na();
              if (localb != null)
              {
                localObject3 = new PString();
                PString localPString = new PString();
                PInt localPInt = new PInt();
                ((bu)localObject1).tN("officialaccounts");
                ((bu)localObject1).setContent(localat.field_content);
                localb.a((bu)localObject1, (PString)localObject3, localPString, localPInt, true);
                if (((w)localObject2).fpe())
                {
                  j = 0;
                  localObject1 = ((w)localObject2).fpm();
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (((dlt)localObject1).style == 1001)
                    {
                      i = j;
                      if (((dlt)localObject1).HAh != null)
                      {
                        i = j;
                        if (!bt.isNullOrNil(((dlt)localObject1).HAh.GfM))
                        {
                          ((PString)localObject3).value = ((dlt)localObject1).HAh.GfM;
                          i = 1;
                        }
                      }
                    }
                  }
                  if ((i != 0) || (localObject1 == null) || (((dlt)localObject1).HAd == null) || (bt.isNullOrNil(((dlt)localObject1).HAd.GfK))) {
                    break label1210;
                  }
                  ((PString)localObject3).value = ((dlt)localObject1).HAd.GfK;
                  if (((((dlt)localObject1).style == 101) || (((dlt)localObject1).style == 102)) && (((dlt)localObject1).HAf != null) && (!bt.isNullOrNil(((dlt)localObject1).HAf.GfM))) {
                    ((PString)localObject3).value = ((dlt)localObject1).HAf.GfM;
                  }
                }
                if (((w)localObject2).fpf()) {
                  ((PString)localObject3).value = aj.getResources().getString(2131761760);
                }
                if (((w)localObject2).fpg())
                {
                  if (((w)localObject2).Ior == null) {
                    break label1231;
                  }
                  localObject1 = ((w)localObject2).Ior.hDo;
                  label846:
                  ((PString)localObject3).value = ((String)localObject1);
                }
                localat.tB(((PString)localObject3).value);
                localat.tC(localPString.value);
                localat.ks(localPInt.value);
              }
              label883:
              localat.qu(Math.max(l3, l1));
              if (!bool) {
                break label1312;
              }
            }
            for (l1 = localbq.e(localat);; l1 = localbq.a(localat, localat.field_username))
            {
              l2 = ((w)localObject2).field_msgId;
              localObject1 = ax.aQA("brandService");
              if (localObject1 != null) {
                ((ax)localObject1).encode("BizLastMsgId", l2);
              }
              ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localat.field_conversationTime) });
              AppMethodBeat.o(124678);
              return;
              localat.lP(32);
              break;
              label992:
              localat.lO(64);
              break label365;
              label1002:
              if (((w)localObject2).fpg())
              {
                localObject1 = new bu();
                ((bu)localObject1).setContent(((w)localObject2).field_content);
                ((bu)localObject1).tN(((w)localObject2).field_talker);
                ((bu)localObject1).setStatus(3);
                ((bu)localObject1).qA(((w)localObject2).field_createTime);
                break label418;
              }
              if (((w)localObject2).fpf())
              {
                localObject1 = new bu();
                ((bu)localObject1).setContent(((w)localObject2).field_content);
                ((bu)localObject1).tN(((w)localObject2).field_talker);
                ((bu)localObject1).setStatus(3);
                ((bu)localObject1).qA(((com.tencent.mm.g.c.am)localObject2).eLu);
                break label418;
              }
              localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((w)localObject2).field_msgId);
              if (bt.lQ(((ei)localObject1).field_talker, ((w)localObject2).field_talker)) {
                break label1331;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1378L, 2L, 1L, false);
              ad.e("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is not biz msg %s,%s", new Object[] { ((ei)localObject1).field_talker, ((w)localObject2).field_talker });
              AppMethodBeat.o(124678);
              return;
              i = 0;
              break label461;
              label1210:
              if (i != 0) {
                break label798;
              }
              ((PString)localObject3).value = aj.getResources().getString(2131756587);
              break label798;
              label1231:
              localObject1 = com.tencent.mm.plugin.biz.b.a.nOO;
              ((w)localObject2).Ior = com.tencent.mm.plugin.biz.b.a.Wz(((w)localObject2).field_content);
              localObject1 = ((w)localObject2).Ior.hDo;
              break label846;
              label1262:
              if (((w)localObject2).field_type != 10002)
              {
                localat.fqK();
                ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((w)localObject2).field_talker });
                break label883;
              }
              ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is system biz reject msg");
              break label883;
            }
          }
        }
      }
    }
  }
  
  private static boolean fpE()
  {
    AppMethodBeat.i(124681);
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.bu.flY()))
    {
      AppMethodBeat.o(124681);
      return true;
    }
    if (!bNf())
    {
      AppMethodBeat.o(124681);
      return false;
    }
    if (IoX != null)
    {
      bool = IoX.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qum, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IoX = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizMsgResortOpen open %b", new Object[] { IoX });
      bool = IoX.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
  }
  
  public static boolean fpF()
  {
    AppMethodBeat.i(176159);
    if (IoZ != null)
    {
      bool = IoZ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quq, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IoZ = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { IoZ });
      bool = IoZ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static boolean fpG()
  {
    AppMethodBeat.i(124682);
    if (com.tencent.mm.sdk.platformtools.i.DEBUG)
    {
      AppMethodBeat.o(124682);
      return true;
    }
    if (!fpE())
    {
      AppMethodBeat.o(124682);
      return false;
    }
    if (Ipa != null)
    {
      bool = Ipa.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qun, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ipa = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { Ipa });
      bool = Ipa.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
  }
  
  public static boolean fpH()
  {
    AppMethodBeat.i(207281);
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.bu.flY()))
    {
      AppMethodBeat.o(207281);
      return true;
    }
    if (!fpE())
    {
      AppMethodBeat.o(207281);
      return false;
    }
    if (Ipb != null)
    {
      bool = Ipb.booleanValue();
      AppMethodBeat.o(207281);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quo, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ipb = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isReceiveMsgResortOpen open %b", new Object[] { Ipb });
      bool = Ipb.booleanValue();
      AppMethodBeat.o(207281);
      return bool;
    }
  }
  
  private static boolean fpI()
  {
    AppMethodBeat.i(124683);
    if (ax.aQA("brandService").decodeInt("BizTimeLineReSortMsgCheck", 1) == 1)
    {
      AppMethodBeat.o(124683);
      return true;
    }
    AppMethodBeat.o(124683);
    return false;
  }
  
  public static boolean fpz()
  {
    return IoU;
  }
  
  public static int getSessionId()
  {
    return dlK;
  }
  
  public static void r(w paramw)
  {
    AppMethodBeat.i(124670);
    while (ag.aGf().Dm(paramw.field_orderFlag) != null) {
      paramw.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static void wN(boolean paramBoolean)
  {
    IoT = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */