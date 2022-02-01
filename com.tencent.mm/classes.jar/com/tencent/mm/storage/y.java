package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class y
{
  private static String IJd = null;
  private static long IJe = 0L;
  public static int IJf = 0;
  public static int IJg = 1;
  public static long IJh = 180L;
  public static long IJi = 60L;
  public static boolean IJj = false;
  private static boolean IJk = false;
  private static boolean IJl = false;
  public static long IJm = 0L;
  public static long IJn = 0L;
  private static Boolean IJo = null;
  private static Boolean IJp = null;
  private static Boolean IJq = null;
  private static Boolean IJr = null;
  private static Boolean IJs = null;
  private static Boolean IJt = null;
  private static int dmM = 0;
  
  public static void Ap(int paramInt)
  {
    dmM = paramInt;
  }
  
  public static long DX(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean DY(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (ag.aGv().DR(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (ag.aGv().fsY() <= ag.aGv().fts()) {
      ag.aGv().ftt();
    }
    ag.aGv().DQ(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void DZ(long paramLong)
  {
    AppMethodBeat.i(124679);
    IJe = paramLong;
    ak.fox().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
  
  public static void a(oe paramoe)
  {
    AppMethodBeat.i(124663);
    if ((IJj) || (paramoe == null))
    {
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg is isInTimeLine now");
      abt(8);
      AppMethodBeat.o(124663);
      return;
    }
    Object localObject1 = paramoe.GbP;
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg size %d, replaceExposureTime %d, rank_sessionid %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(paramoe.GbQ), paramoe.Gbi });
    if (bu.ht((List)localObject1))
    {
      abt(4);
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg items is null");
      AppMethodBeat.o(124663);
      return;
    }
    abt(5);
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg");
    if (ag.aGv().ftr() <= 0)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg no redDot");
      abt(10);
      AppMethodBeat.o(124663);
      return;
    }
    long l = ag.aGv().fts();
    if (l != ay.aRX("brandService").decodeLong("ReSortBizMsgMaxGroupId", 0L))
    {
      abt(11);
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg MsgMaxGroupId has changed!");
      AppMethodBeat.o(124663);
      return;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBt, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg insertCard = %s", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (bu.ht(paramoe.GbR))) {
        break;
      }
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg recommend_article_info size = %s", new Object[] { Integer.valueOf(paramoe.GbR.size()) });
      int i = 0;
      while (i < paramoe.GbR.size())
      {
        aUc(((csk)paramoe.GbR.get(i)).dCX);
        i += 1;
      }
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((LinkedList)localObject1).iterator();
    if (localIterator.hasNext())
    {
      oc localoc = (oc)localIterator.next();
      Object localObject2;
      if (localoc == null) {
        localObject2 = null;
      }
      label542:
      for (;;)
      {
        label353:
        if (localObject2 != null)
        {
          ((w)localObject2).field_rankSessionId = paramoe.Gbi;
          localLinkedList.add(localObject2);
          break;
          if (bu.isNullOrNil(localoc.GbA)) {
            localObject1 = ag.aGv().N(localoc.GbG, "msgId");
          }
          for (;;)
          {
            if ((localObject1 != null) && (((w)localObject1).field_msgId != 0L)) {
              break label542;
            }
            ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg not found");
            localObject2 = null;
            break;
            localObject2 = ag.aGv();
            String str = localoc.GbA;
            if (bu.isNullOrNil(str))
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = new w();
              localObject2 = ((x)localObject2).hKK.a("BizTimeLineInfo", null, "bizClientMsgId=?", new String[] { String.valueOf(str) }, null, null, null, 2);
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
            ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg is read");
            localObject2 = null;
          }
          else if (System.currentTimeMillis() - ((w)localObject1).field_createTime > 604800000L)
          {
            ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo too old msg %d", new Object[] { Long.valueOf(((w)localObject1).field_createTime) });
            localObject2 = null;
          }
          else
          {
            if (((w)localObject1).fsY() != l) {
              ((w)localObject1).IIF = true;
            }
            ((w)localObject1).field_orderFlag = (aA(l, ((w)localObject1).field_createTime / 1000L) | localoc.weight << 24 & 0xFF000000 | l << 32);
            r((w)localObject1);
            if (localoc.GbB != 1) {
              break label925;
            }
            ((w)localObject1).hl(1);
          }
        }
      }
      for (;;)
      {
        ((w)localObject1).hl(1073741824);
        ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo bizclientmsgid:%s msgid:%d pic_type:%d biz_flag:%d cardType:%d, weight:%d", new Object[] { localoc.GbA, Long.valueOf(localoc.GbG), Integer.valueOf(localoc.GbB), Integer.valueOf(((w)localObject1).field_bitFlag), Integer.valueOf(localoc.mwj), Integer.valueOf(localoc.weight) });
        localObject2 = u.IIC;
        d.g.b.p.h(localoc, "item");
        d.g.b.p.h(localObject1, "info");
        localObject2 = localObject1;
        if (!u.fsX()) {
          break label353;
        }
        if (localoc.weight != ((w)localObject1).fsZ()) {
          u.aTZ("checkRespData weight invalid!");
        }
        if (((localoc.GbB == 1) && (!((w)localObject1).hk(1))) || ((localoc.GbB != 1) && (((w)localObject1).hk(1)))) {
          u.aTZ("checkRespData show big pic flag invalid!");
        }
        if (!((w)localObject1).hk(1073741824)) {
          u.aTZ("checkRespData resort flag invalid!");
        }
        if (((w)localObject1).field_isRead != 0) {
          u.aTZ("CheckRespProcessedData Msg has exposed!");
        }
        localObject2 = localObject1;
        if (System.currentTimeMillis() - ((w)localObject1).field_createTime <= 604800000L) {
          break label353;
        }
        u.aTZ("CheckRespProcessedData time invalid!");
        localObject2 = localObject1;
        break label353;
        break;
        label925:
        ((w)localObject1).field_bitFlag &= 0xFFFFFFFE;
      }
    }
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg new size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (!bu.ht(localLinkedList))
    {
      abt(7);
      paramoe = ag.aGv();
      if (!bu.ht(localLinkedList)) {
        com.tencent.mm.cm.g.fWL().h(new x.5(paramoe, localLinkedList)).b(new x.4(paramoe));
      }
      paramoe = com.tencent.mm.pluginsdk.c.Fbx;
      if (com.tencent.mm.pluginsdk.c.fcy())
      {
        paramoe = com.tencent.mm.pluginsdk.c.Fbx;
        if (com.tencent.mm.pluginsdk.c.fcz())
        {
          ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizImagePreloadStrategy preload after resort");
          paramoe = com.tencent.mm.pluginsdk.c.Fbx;
          com.tencent.mm.pluginsdk.c.fcC();
        }
      }
      p.IIi.abj(1);
      AppMethodBeat.o(124663);
      return;
    }
    abt(6);
    AppMethodBeat.o(124663);
  }
  
  public static long aA(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYm, "");
    long l1 = l2;
    if (!bu.isNullOrNil(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (bu.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - bu.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      l1 = 604800L;
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYm, str);
      ae.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static void aI(bv parambv)
  {
    AppMethodBeat.i(124662);
    if (parambv == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.zd(parambv.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (com.tencent.mm.model.x.wb(parambv.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv.field_talker);
    if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type)) && (!localan.fug()))
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
    Object localObject2 = bl.BS(parambv.eNd);
    if (localObject2 != null)
    {
      m = ((bl.b)localObject2).hJF;
      k = ((bl.b)localObject2).cRx;
      j = ((bl.b)localObject2).hJG;
      l1 = ((bl.b)localObject2).hJK;
      if ((((bl.b)localObject2).hJL & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bl.b)localObject2).hJL & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bl.b)localObject2).hJL & 0x4) != 0L)
      {
        ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambv.field_talker, Long.valueOf(((bl.b)localObject2).hJL) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bl.b)localObject2).hJL & 0x40) != 0L) && (localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type)))
    {
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((parambv.getType() == 34) || (parambv.getType() == 3))
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(parambv.getType()) });
      bool1 = false;
    }
    Object localObject1;
    for (;;)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambv.field_talker, Boolean.valueOf(bool1) });
      if (bool1) {
        break label521;
      }
      com.tencent.mm.pluginsdk.c.Fbt = true;
      d(parambv, false);
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (parambv.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!parambv.fta()) {
          break;
        }
        if (parambv.fta()) {}
        for (localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (bu.ht(((com.tencent.mm.ah.u)localObject1).hFT))) {
            break label515;
          }
          bool1 = true;
          break;
        }
        label515:
        bool1 = false;
      }
    }
    label521:
    if ((localObject2 != null) && ((((bl.b)localObject2).hJL & 0x2) != 0L))
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambv.field_talker, Long.valueOf(((bl.b)localObject2).hJL) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.c.Fbt = true;
    localObject2 = ag.aGv().N(parambv.field_msgId, "msgId");
    label730:
    long l3;
    long l2;
    if (localObject2 == null)
    {
      localObject1 = new w();
      ((w)localObject1).field_msgId = parambv.field_msgId;
      ((w)localObject1).field_msgSvrId = parambv.field_msgSvrId;
      ((w)localObject1).field_content = parambv.field_content;
      ((w)localObject1).field_type = parambv.getType();
      ((w)localObject1).field_talker = parambv.field_talker;
      ((w)localObject1).field_talkerId = parambv.field_talkerId;
      ((w)localObject1).field_createTime = parambv.field_createTime;
      ((w)localObject1).field_imgPath = parambv.field_imgPath;
      ((w)localObject1).ka(parambv.eNc);
      ((w)localObject1).tk(parambv.eNd);
      ((w)localObject1).field_bizClientMsgId = parambv.field_bizClientMsgId;
      if (!bOd()) {
        break label986;
      }
      ((w)localObject1).field_status = parambv.field_status;
      ((w)localObject1).field_hasShow = 0;
      if (i != 0) {
        ((w)localObject1).hl(1);
      }
      l3 = ag.aGv().fsY();
      long l4 = aA(l3, ((w)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = ag.aGv().ftt();
        l2 = aA(l3, ((w)localObject1).field_createTime / 1000L);
      }
      ((w)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      r((w)localObject1);
      if ((localan == null) || (!localan.adB())) {
        break label1001;
      }
    }
    label986:
    label1001:
    for (((w)localObject1).field_placeTop = 1;; ((w)localObject1).field_placeTop = 0)
    {
      if (localObject2 != null) {
        break label1010;
      }
      ((w)localObject1).field_isExpand = bool2;
      ag.aGv().p((w)localObject1);
      if (!IJl)
      {
        IJl = true;
        com.tencent.e.h.MqF.a(new y.5(), 1000L, "BizTimeLineInfoStorageThread");
      }
      if (ftH()) {
        abs(IJf);
      }
      ae.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((w)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
      ((w)localObject1).field_status = 4;
      ((w)localObject1).field_hasShow = 1;
      break label730;
    }
    label1010:
    ag.aGv().q((w)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void aJ(bv parambv)
  {
    AppMethodBeat.i(124676);
    if (parambv == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    ag.aGv().DU(parambv.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static void aUc(String paramString)
  {
    AppMethodBeat.i(188983);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(188983);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
      AppMethodBeat.o(188983);
      return;
    }
    int i = paramString.indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = bx.M(paramString.substring(i), "sysmsg");
      if (localObject1 == null)
      {
        ae.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
        AppMethodBeat.o(188983);
      }
    }
    else
    {
      AppMethodBeat.o(188983);
      return;
    }
    Object localObject2 = ag.aGv().ftp();
    paramString = bP((Map)localObject1);
    aa.a(paramString, (Map)localObject1);
    if (!aa.b(paramString, null))
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
      AppMethodBeat.o(188983);
      return;
    }
    int j = paramString.pos;
    long l4 = paramString.weight;
    if ((j < 0) && (l4 < 0L))
    {
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
      AppMethodBeat.o(188983);
      return;
    }
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
    if (aa.e(paramString))
    {
      AppMethodBeat.o(188983);
      return;
    }
    long l3 = ag.aGv().fsY();
    if (paramString.style != 103)
    {
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString.HTQ.HTL.nIJ);
      if ((localObject1 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject1).field_type)))
      {
        ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", new Object[] { paramString.HTQ.HTL.nIJ });
        AppMethodBeat.o(188983);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 1L, 1L, false);
    Object localObject1 = new w();
    ((w)localObject1).field_msgId = ag.aGv().ftx();
    ((w)localObject1).field_msgSvrId = 0L;
    ((w)localObject1).field_type = 620757041;
    ((w)localObject1).field_talker = paramString.HTQ.HTL.nIJ;
    ((w)localObject1).field_talkerId = 0;
    long l1;
    label452:
    long l2;
    if (paramString.HTT == 1)
    {
      i = 1;
      if (i == 0) {
        break label767;
      }
      if (Math.abs(paramString.HDI * 1000L - System.currentTimeMillis()) > 86400000L) {
        break label759;
      }
      l1 = paramString.HDI * 1000L;
      ((w)localObject1).field_createTime = l1;
      ((w)localObject1).ka(1);
      ((w)localObject1).field_status = 3;
      aa.a((w)localObject1, paramString);
      ((w)localObject1).b(paramString);
      l2 = 0L;
      l1 = l2;
      if (localObject2 != null)
      {
        if (l4 < 0L) {
          break label801;
        }
        l1 = Math.min(l4, DX(((w)localObject2).field_orderFlag));
      }
      label517:
      l2 = aA(l3, ((w)localObject1).field_createTime / 1000L);
      if (l2 < 4294967296L) {
        break label869;
      }
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l2) });
      l3 = ag.aGv().ftt();
      l2 = aA(l3, ((w)localObject1).field_createTime / 1000L);
    }
    label801:
    label862:
    label869:
    for (;;)
    {
      ((w)localObject1).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      r((w)localObject1);
      boolean bool = ag.aGv().p((w)localObject1);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s", new Object[] { Boolean.valueOf(bool), paramString.HTQ.HTL.nIJ });
      int k;
      if ((bool) && (paramString.style == 101))
      {
        localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(84L);
        localObject2 = q.IIu;
        i = paramString.pos;
        j = paramString.HTT;
        k = paramString.style;
        l1 = paramString.HDI;
        localObject2 = paramString.HTV;
        if (paramString.HTS == null) {
          break label862;
        }
      }
      for (paramString = paramString.HTS.Gau;; paramString = "")
      {
        q.a((w)localObject1, 1, i, j, 3, k, l1, (String)localObject2, paramString, "");
        AppMethodBeat.o(188983);
        return;
        i = 0;
        break;
        label759:
        l1 = System.currentTimeMillis();
        break label452;
        label767:
        if (localObject2 != null) {}
        for (l1 = ((w)localObject2).field_createTime + 1000L;; l1 = System.currentTimeMillis())
        {
          ((w)localObject1).field_createTime = l1;
          break;
        }
        if (j == 0)
        {
          l1 = DX(((w)localObject2).field_orderFlag);
          break label517;
        }
        localObject2 = ag.aGv().abp(j - 1);
        if (localObject2 == null)
        {
          ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
          l1 = l2;
          break label517;
        }
        l1 = DX(((w)localObject2).field_orderFlag);
        break label517;
      }
    }
  }
  
  public static void aUd(String paramString)
  {
    IJd = paramString;
  }
  
  public static void abs(int paramInt)
  {
    AppMethodBeat.i(124664);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124656);
        y.abu(this.IJu);
        AppMethodBeat.o(124656);
      }
    }, "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(124664);
  }
  
  public static void abt(int paramInt)
  {
    AppMethodBeat.i(124665);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(124665);
  }
  
  public static boolean bOd()
  {
    AppMethodBeat.i(124680);
    if (IJo != null)
    {
      bool = IJo.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    int i = ay.aRX("brandService").decodeInt("BizTimeLineOpenStatus", -1);
    if (i == 1) {
      IJo = Boolean.TRUE;
    }
    while (IJo != null)
    {
      bool = IJo.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
      if (i == 0) {
        IJo = Boolean.FALSE;
      }
    }
    if ((((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYn, Integer.valueOf(0))).intValue() & 0x1) > 0)
    {
      IJo = Boolean.TRUE;
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      bool = IJo.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    i = ag.aGv().ftv();
    if (i > 4000)
    {
      IJo = Boolean.FALSE;
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen too match data totalCount %d", new Object[] { Integer.valueOf(i) });
      bool = IJo.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAU, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IJo = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { IJo });
      bool = IJo.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
  }
  
  private static dmq bP(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    dmq localdmq = new dmq();
    localdmq.HTQ = new dml();
    localdmq.HTQ.Gys = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localdmq.HTQ.Gct = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localdmq.HTQ.HTL = new dmn();
    localdmq.HTQ.HTL.Gcs = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localdmq.HTQ.HTL.nIJ = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localdmq.HTQ.HTL.nJO = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localdmq.HTQ.HTL.HTN = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localdmq.HTQ.HTL.jfY = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new dmp();
    Object localObject3 = new ali();
    int i = 0;
    Object localObject1;
    if (i < 20)
    {
      StringBuilder localStringBuilder = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount.NegativeFeedbackReason");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (bu.isNullOrNil((String)localObject1)) {
          break label296;
        }
        ((ali)localObject3).Gcm.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((ali)localObject3).Gcn = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((dmp)localObject2).HTP = ((ali)localObject3);
    localdmq.HTQ.HTM = ((dmp)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new dmm();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((dmm)localObject2).Title = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (bu.isNullOrNil(((dmm)localObject2).Title)) {
          break label923;
        }
        ((dmm)localObject2).FYq = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((dmm)localObject2).FYs = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((dmm)localObject2).FYu = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((dmm)localObject2).FYv = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((dmm)localObject2).FYw = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((dmm)localObject2).hFR = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((dmm)localObject2).FYD = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((dmm)localObject2).FYE = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((dmm)localObject2).FYF = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((dmm)localObject2).FYG = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((dmm)localObject2).CreateTime = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((dmm)localObject2).Gco = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        ((dmm)localObject2).Gcp = bu.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VoiceDuration"), -1);
        localdmq.HTQ.Gcu.add(localObject2);
        i += 1;
        break;
      }
    }
    label923:
    localdmq.pos = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localdmq.weight = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localdmq.HDI = bu.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localdmq.HTV = ((String)paramMap.get(".sysmsg.BizAccountRecommend.CardId"));
    localdmq.style = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    AppMethodBeat.o(124669);
    return localdmq;
  }
  
  public static void c(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.gte == null) || (parama.gte.FNI == null))
    {
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    Object localObject2 = parama.gte;
    d.g.b.p.h(localObject2, "addMsg");
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ();
    String str1 = com.tencent.mm.platformtools.z.a(((cv)localObject2).FNG);
    label136:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aJ(str1, ((cv)localObject2).xrk);
      if (localObject1 == null) {
        break label234;
      }
      l = ((ei)localObject1).field_msgId;
      if (l == 0L) {
        break label246;
      }
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((ei)localObject1).field_createTime + 604800000L >= bl.B(str1, ((cv)localObject2).CreateTime)) {
        break label240;
      }
      bool = true;
      label178:
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] filerDuplicateMsg user = " + ((cv)localObject2).FNG + ", result = " + bool);
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
    int j = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    localObject1 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if (localObject1 == null)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).zn(j))
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(124666);
      return;
    }
    int k = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", new Object[] { Integer.valueOf(k) });
    localObject1 = com.tencent.mm.platformtools.z.a(parama.gte.FNI);
    parama = ay.aRX("brandService");
    if (k <= 0)
    {
      localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
      com.tencent.mm.kernel.g.ajP();
      parama.encode(com.tencent.mm.kernel.a.aiF(), (String)localObject1);
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 0L, 1L, false);
    long l = bu.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
    String str2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
    int m = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    int n = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    int i1 = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
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
        if (bu.isNullOrNil((String)localObject3)) {
          break label799;
        }
        parama = (String)paramMap.get(str3 + ".UserName");
        str3 = (String)paramMap.get(str3 + ".AppMsg.ContentUrl");
        localObject3 = com.tencent.mm.pluginsdk.ui.tools.x.aPc((String)localObject3);
        str3 = com.tencent.mm.pluginsdk.ui.tools.x.aPc(str3);
        ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", new Object[] { parama });
        com.tencent.mm.plugin.report.service.g.yxI.f(18106, new Object[] { parama, Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), localObject3, str3 });
        i += 1;
        break;
      }
    }
    label799:
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { str2, Long.valueOf(l) });
    if (k > 0) {
      com.tencent.e.h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124659);
          y.aUc(this.jLx);
          if (y.ftH()) {
            y.abs(y.IJf);
          }
          AppMethodBeat.o(124659);
        }
      }, "BizInsertTlRecCardThreadImmediately");
    }
    if (j == 101)
    {
      paramMap = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(83L);
      paramMap = q.IIu;
      q.a(m, n, i1, 3, j, l, (String)localObject2, str1, "");
    }
    AppMethodBeat.o(124666);
  }
  
  public static void d(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(188985);
    if (bu.lX(parambv.field_talker, IJd))
    {
      ae.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { IJd });
      AppMethodBeat.o(188985);
      return;
    }
    w localw2 = ag.aGw().N(parambv.field_msgSvrId, "msgSvrId");
    w localw1;
    if (localw2 == null)
    {
      localw1 = new w();
      if ((!paramBoolean) && (parambv.getType() != 318767153)) {
        break label198;
      }
    }
    label198:
    for (localw1.field_msgId = ag.aGw().ftK();; localw1.field_msgId = parambv.field_msgId)
    {
      localw1.field_msgSvrId = parambv.field_msgSvrId;
      localw1.field_content = parambv.field_content;
      localw1.field_type = parambv.getType();
      localw1.field_talker = parambv.field_talker;
      localw1.field_talkerId = parambv.field_talkerId;
      localw1.field_createTime = parambv.field_createTime;
      localw1.field_imgPath = parambv.field_imgPath;
      localw1.ka(parambv.eNc);
      localw1.tk(parambv.eNd);
      localw1.field_status = parambv.field_status;
      if (localw2 != null) {
        break label209;
      }
      ag.aGw().p(localw1);
      AppMethodBeat.o(188985);
      return;
      localw1 = localw2;
      break;
    }
    label209:
    ag.aGw().q(localw1);
    AppMethodBeat.o(188985);
  }
  
  public static void ftA()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(124668);
      return;
    }
    Object localObject2 = ay.aRX("brandService");
    Object localObject1 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.ajP();
    Object localObject3 = com.tencent.mm.kernel.a.aiF();
    Object localObject4 = ((ay)localObject2).decodeString((String)localObject3);
    if (bu.isNullOrNil((String)localObject4))
    {
      ae.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(124668);
      return;
    }
    int i = ((String)localObject4).indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = bx.M(((String)localObject4).substring(i), "sysmsg");
      if (localObject1 == null)
      {
        ae.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject4 });
        AppMethodBeat.o(124668);
      }
    }
    else
    {
      AppMethodBeat.o(124668);
      return;
    }
    d.g.b.p.h(localObject1, "values");
    if (!bu.isNullOrNil((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Data"))) {
      i = 1;
    }
    boolean bool;
    int j;
    int k;
    while (i != 0)
    {
      d.g.b.p.h(localObject1, "values");
      localObject2 = ag.aGv();
      d.g.b.p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      localObject2 = ((x)localObject2).ftp();
      if (localObject2 == null)
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
        AppMethodBeat.o(124668);
        return;
        i = 0;
      }
      else
      {
        if (((w)localObject2).field_status == 4)
        {
          ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
          AppMethodBeat.o(124668);
          return;
        }
        localObject3 = ay.aRX("brandService");
        localObject4 = new StringBuilder("BizLatestRecommendCardInfo");
        d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
        ((ay)localObject3).encode(com.tencent.mm.kernel.a.aiF(), "");
        localObject3 = aa.bQ((Map)localObject1);
        if (localObject3 == null)
        {
          AppMethodBeat.o(124668);
          return;
        }
        if (!aa.b((dmq)localObject3, null))
        {
          ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
          AppMethodBeat.o(124668);
          return;
        }
        if (!aa.e((dmq)localObject3))
        {
          localObject1 = ag.aGv();
          d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
          l2 = ((x)localObject1).fts();
          if (ag.aGv().DW(l2 << 32) != null)
          {
            ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard groupId %d already has a recommend msg", new Object[] { Long.valueOf(l2) });
            AppMethodBeat.o(124668);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 1L, 1L, false);
          localObject4 = new w();
          ((w)localObject4).field_msgId = ag.aGv().ftx();
          ((w)localObject4).field_msgSvrId = 0L;
          ((w)localObject4).field_type = 620757041;
          ((w)localObject4).field_talker = "";
          ((w)localObject4).field_talkerId = 0;
          ((w)localObject2).field_createTime -= 1000L;
          ((w)localObject4).ka(1);
          ((w)localObject4).field_status = 3;
          aa.a((w)localObject4, (dmq)localObject3);
          ((w)localObject4).b((dmq)localObject3);
          l1 = 0L;
          if (((dmq)localObject3).HTU.weight < 0) {
            break label803;
          }
          l1 = d.k.j.aH(((dmq)localObject3).HTU.weight, DX(((w)localObject2).field_orderFlag));
          ((w)localObject4).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | aA(l2, ((w)localObject4).field_createTime / 1000L));
          r((w)localObject4);
          bool = ag.aGv().p((w)localObject4);
          ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + bool + ", title = " + ((dmq)localObject3).HTU.title);
          if (bool)
          {
            localObject1 = p.IIi;
            if (p.fsJ())
            {
              localObject1 = com.tencent.mm.plugin.webcanvas.h.DQL;
              com.tencent.mm.plugin.webcanvas.h.eUa();
            }
            p.IIi.o((w)localObject4);
            localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(82L);
            localObject1 = q.IIu;
            i = ((dmq)localObject3).pos;
            j = ((dmq)localObject3).HTT;
            k = ((dmq)localObject3).style;
            l1 = ((dmq)localObject3).HDI;
            localObject1 = ((dmq)localObject3).HTU;
            if (localObject1 == null) {
              break label901;
            }
            localObject1 = ((csm)localObject1).cardId;
            label741:
            localObject2 = ((dmq)localObject3).HTS;
            if (localObject2 == null) {
              break label907;
            }
            localObject2 = ((aiq)localObject2).Gau;
            label760:
            localObject3 = ((dmq)localObject3).HTU;
            if (localObject3 == null) {
              break label913;
            }
          }
        }
        label901:
        label907:
        label913:
        for (localObject3 = ((csm)localObject3).dAU;; localObject3 = null)
        {
          q.a((w)localObject4, 2, i, j, 5, k, l1, (String)localObject1, (String)localObject2, (String)localObject3);
          AppMethodBeat.o(124668);
          return;
          label803:
          if (((dmq)localObject3).HTU.pos == 0)
          {
            l1 = DX(((w)localObject2).field_orderFlag);
            ((w)localObject2).field_createTime += 1000L;
            break;
          }
          localObject1 = ag.aGv().abp(((dmq)localObject3).HTU.pos - 1);
          if (localObject1 == null)
          {
            ae.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
            break;
          }
          l1 = DX(((w)localObject1).field_orderFlag);
          ((w)localObject1).field_createTime -= 1000L;
          break;
          localObject1 = null;
          break label741;
          localObject2 = null;
          break label760;
        }
      }
    }
    localObject4 = ag.aGv().ftp();
    if (localObject4 == null)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      AppMethodBeat.o(124668);
      return;
    }
    if (((w)localObject4).field_status == 4)
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
      AppMethodBeat.o(124668);
      return;
    }
    ((ay)localObject2).encode((String)localObject3, "");
    localObject3 = bP((Map)localObject1);
    aa.a((dmq)localObject3, (Map)localObject1);
    if (!aa.b((dmq)localObject3, null))
    {
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      AppMethodBeat.o(124668);
      return;
    }
    i = ((dmq)localObject3).pos;
    long l3 = ((dmq)localObject3).weight;
    if ((i < 0) && (l3 < 0L))
    {
      ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l3) });
      AppMethodBeat.o(124668);
      return;
    }
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l3) });
    if (aa.e((dmq)localObject3))
    {
      AppMethodBeat.o(124668);
      return;
    }
    long l2 = ag.aGv().fts();
    if (((dmq)localObject3).style != 103)
    {
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(((dmq)localObject3).HTQ.HTL.nIJ);
      if ((localObject1 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject1).field_type)))
      {
        ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { ((dmq)localObject3).HTQ.HTL.nIJ });
        AppMethodBeat.o(124668);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 1L, 1L, false);
    localObject2 = new w();
    ((w)localObject2).field_msgId = ag.aGv().ftx();
    ((w)localObject2).field_msgSvrId = 0L;
    ((w)localObject2).field_type = 620757041;
    ((w)localObject2).field_talker = ((dmq)localObject3).HTQ.HTL.nIJ;
    ((w)localObject2).field_talkerId = 0;
    ((w)localObject4).field_createTime -= 1000L;
    ((w)localObject2).ka(1);
    ((w)localObject2).field_status = 3;
    aa.a((w)localObject2, (dmq)localObject3);
    ((w)localObject2).b((dmq)localObject3);
    long l1 = 0L;
    if (l3 >= 0L)
    {
      l1 = Math.min(l3, DX(((w)localObject4).field_orderFlag));
      ((w)localObject2).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | aA(l2, ((w)localObject2).field_createTime / 1000L));
      r((w)localObject2);
      bool = ag.aGv().p((w)localObject2);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s", new Object[] { Boolean.valueOf(bool), ((dmq)localObject3).HTQ.HTL.nIJ });
      if ((bool) && (((dmq)localObject3).style == 101))
      {
        localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(84L);
        localObject1 = q.IIu;
        i = ((dmq)localObject3).pos;
        j = ((dmq)localObject3).HTT;
        k = ((dmq)localObject3).style;
        l1 = ((dmq)localObject3).HDI;
        localObject4 = ((dmq)localObject3).HTV;
        if (((dmq)localObject3).HTS == null) {
          break label1622;
        }
      }
    }
    label1622:
    for (localObject1 = ((dmq)localObject3).HTS.Gau;; localObject1 = "")
    {
      q.a((w)localObject2, 2, i, j, 3, k, l1, (String)localObject4, (String)localObject1, "");
      AppMethodBeat.o(124668);
      return;
      if (i == 0)
      {
        l1 = DX(((w)localObject4).field_orderFlag);
        ((w)localObject4).field_createTime += 1000L;
        break;
      }
      localObject1 = ag.aGv().abp(i - 1);
      if (localObject1 == null)
      {
        ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
        break;
      }
      l1 = DX(((w)localObject1).field_orderFlag);
      ((w)localObject1).field_createTime -= 1000L;
      break;
    }
  }
  
  public static void ftB()
  {
    AppMethodBeat.i(188984);
    com.tencent.e.h.MqF.f(new y.6(), "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(188984);
  }
  
  public static void ftC()
  {
    AppMethodBeat.i(124678);
    if (!bOd())
    {
      AppMethodBeat.o(124678);
      return;
    }
    br localbr = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL();
    au localau = localbr.aVa("officialaccounts");
    if (localau == null) {
      localau = new au("officialaccounts");
    }
    label1028:
    label1414:
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = ag.aGw().ftp();
      Object localObject1 = ag.aGv().ftp();
      Object localObject2 = ag.aGv().hKK.a("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null, 0);
      if (((Cursor)localObject2).moveToFirst()) {}
      label1038:
      for (long l1 = ((Cursor)localObject2).getLong(0);; l1 = 0L)
      {
        ((Cursor)localObject2).close();
        long l2;
        if (localObject3 != null)
        {
          l2 = ((w)localObject3).field_createTime;
          if (localObject1 == null) {
            break label1436;
          }
        }
        label919:
        label1433:
        label1436:
        for (int i = ag.aGv().DT(((w)localObject1).field_orderFlag);; i = 0)
        {
          int j = ag.aGw().bVY();
          if (j > 0) {
            if (l2 > l1)
            {
              localau.lR(16);
              localau.kr(j);
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            if ((localObject2 != null) && (((w)localObject2).field_msgId != 0L)) {
              break label288;
            }
            ae.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
            localau.fuK();
            if (!bool) {
              localbr.a(localau, localau.field_username);
            }
            AppMethodBeat.o(124678);
            return;
            l2 = 0L;
            break;
            localau.lQ(16);
            localau.kr(i);
            localObject2 = localObject1;
            continue;
            localau.lQ(16);
            localau.kr(i);
            localObject2 = localObject1;
          }
          label288:
          long l3;
          if ((localObject2 == localObject1) && (((w)localObject2).field_placeTop == 1))
          {
            localau.lQ(32);
            if (localObject2 == localObject3)
            {
              l3 = ((w)localObject2).field_msgId;
              if (IJe == 0L) {
                IJe = ak.fox().getLong("biz_time_line_last_notify_msg_id", -1L);
              }
              if (l3 != IJe) {
                break label1028;
              }
              localau.lR(64);
            }
            label365:
            if (!((w)localObject2).ftb()) {
              break label1038;
            }
            localObject1 = new bv();
            ((bv)localObject1).setContent(((am)localObject2).eNd);
            ((bv)localObject1).ui(((w)localObject2).field_talker);
            ((bv)localObject1).setStatus(3);
            ((bv)localObject1).qN(((w)localObject2).field_createTime);
          }
          for (;;)
          {
            label418:
            l3 = Math.min(ch.aDb(), localau.field_conversationTime);
            l1 = Math.max(l2, l1);
            if (((ei)localObject1).field_msgId <= 0L)
            {
              if (((w)localObject2).field_type == 10002)
              {
                i = 1;
                label461:
                if ((i == 0) && (!((w)localObject2).ftb()) && (!((w)localObject2).ftc()) && (!((w)localObject2).ftd()) && (!((w)localObject2).fte())) {
                  break label1364;
                }
              }
            }
            else
            {
              localau.aK((bv)localObject1);
              localau.setContent(((ei)localObject1).field_talker + ":" + ((ei)localObject1).field_content);
              localau.tV(Integer.toString(((bv)localObject1).getType()));
              br.b localb = localbr.MV();
              if (localb != null)
              {
                localObject3 = new PString();
                PString localPString = new PString();
                PInt localPInt = new PInt();
                ((bv)localObject1).ui("officialaccounts");
                ((bv)localObject1).setContent(localau.field_content);
                localb.a((bv)localObject1, (PString)localObject3, localPString, localPInt, true);
                if (((w)localObject2).ftb())
                {
                  j = 0;
                  localObject1 = ((w)localObject2).ftk();
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (((dmq)localObject1).style == 1001)
                    {
                      i = j;
                      if (((dmq)localObject1).HTU != null)
                      {
                        i = j;
                        if (!bu.isNullOrNil(((dmq)localObject1).HTU.Gyu))
                        {
                          ((PString)localObject3).value = ((dmq)localObject1).HTU.Gyu;
                          i = 1;
                        }
                      }
                    }
                  }
                  if ((i != 0) || (localObject1 == null) || (((dmq)localObject1).HTQ == null) || (bu.isNullOrNil(((dmq)localObject1).HTQ.Gys))) {
                    break label1312;
                  }
                  ((PString)localObject3).value = ((dmq)localObject1).HTQ.Gys;
                  if (((((dmq)localObject1).style == 101) || (((dmq)localObject1).style == 102) || (((dmq)localObject1).style == 103)) && (((dmq)localObject1).HTS != null) && (!bu.isNullOrNil(((dmq)localObject1).HTS.Gyu))) {
                    ((PString)localObject3).value = ((dmq)localObject1).HTS.Gyu;
                  }
                }
                label816:
                if (((w)localObject2).ftc()) {
                  ((PString)localObject3).value = ak.getResources().getString(2131761760);
                }
                if (((w)localObject2).ftd())
                {
                  if (((w)localObject2).IIH == null) {
                    break label1333;
                  }
                  localObject1 = ((w)localObject2).IIH.hGg;
                  label864:
                  ((PString)localObject3).value = ((String)localObject1);
                }
                if (((w)localObject2).fte()) {
                  ((PString)localObject3).value = ab.u((w)localObject2);
                }
                localau.tW(((PString)localObject3).value);
                localau.tX(localPString.value);
                localau.ku(localPInt.value);
              }
              localau.qH(Math.max(l3, l1));
              if (!bool) {
                break label1414;
              }
            }
            for (l1 = localbr.e(localau);; l1 = localbr.a(localau, localau.field_username))
            {
              l2 = ((w)localObject2).field_msgId;
              localObject1 = ay.aRX("brandService");
              if (localObject1 != null) {
                ((ay)localObject1).encode("BizLastMsgId", l2);
              }
              ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localau.field_conversationTime) });
              AppMethodBeat.o(124678);
              return;
              localau.lR(32);
              break;
              localau.lQ(64);
              break label365;
              if (((w)localObject2).ftd())
              {
                localObject1 = new bv();
                ((bv)localObject1).setContent(((w)localObject2).field_content);
                ((bv)localObject1).ui(((w)localObject2).field_talker);
                ((bv)localObject1).setStatus(3);
                ((bv)localObject1).qN(((w)localObject2).field_createTime);
                break label418;
              }
              if (((w)localObject2).fte())
              {
                localObject1 = new bv();
                ((bv)localObject1).setContent(((w)localObject2).field_content);
                ((bv)localObject1).ui(((w)localObject2).field_talker);
                ((bv)localObject1).setStatus(3);
                ((bv)localObject1).qN(((w)localObject2).field_createTime);
                ((bv)localObject1).setMsgId(((w)localObject2).field_msgId);
                break label418;
              }
              if (((w)localObject2).ftc())
              {
                localObject1 = new bv();
                ((bv)localObject1).setContent(((w)localObject2).field_content);
                ((bv)localObject1).ui(((w)localObject2).field_talker);
                ((bv)localObject1).setStatus(3);
                ((bv)localObject1).qN(((am)localObject2).eNf);
                break label418;
              }
              localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((w)localObject2).field_msgId);
              if (bu.lX(((ei)localObject1).field_talker, ((w)localObject2).field_talker)) {
                break label1433;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1378L, 2L, 1L, false);
              ae.e("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is not biz msg %s,%s", new Object[] { ((ei)localObject1).field_talker, ((w)localObject2).field_talker });
              AppMethodBeat.o(124678);
              return;
              i = 0;
              break label461;
              label1312:
              if (i != 0) {
                break label816;
              }
              ((PString)localObject3).value = ak.getResources().getString(2131756587);
              break label816;
              label1333:
              localObject1 = com.tencent.mm.plugin.biz.b.a.nUu;
              ((w)localObject2).IIH = com.tencent.mm.plugin.biz.b.a.Xl(((w)localObject2).field_content);
              localObject1 = ((w)localObject2).IIH.hGg;
              break label864;
              label1364:
              if (((w)localObject2).field_type != 10002)
              {
                localau.fuK();
                ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((w)localObject2).field_talker });
                break label919;
              }
              ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is system biz reject msg");
              break label919;
            }
          }
        }
      }
    }
  }
  
  public static boolean ftD()
  {
    AppMethodBeat.i(188986);
    long l = System.currentTimeMillis();
    int i = com.tencent.mm.n.g.acL().getInt("BizTimeLineStayTime", 180);
    if ((IJm != 0L) && (IJn != 0L) && (l - IJm < i * 1000))
    {
      AppMethodBeat.o(188986);
      return true;
    }
    AppMethodBeat.o(188986);
    return false;
  }
  
  private static boolean ftE()
  {
    AppMethodBeat.i(124681);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.bv.fpT()))
    {
      AppMethodBeat.o(124681);
      return true;
    }
    if (!bOd())
    {
      AppMethodBeat.o(124681);
      return false;
    }
    if (IJp != null)
    {
      bool = IJp.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBd, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IJp = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizMsgResortOpen open %b", new Object[] { IJp });
      bool = IJp.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
  }
  
  public static boolean ftF()
  {
    AppMethodBeat.i(176159);
    if (IJr != null)
    {
      bool = IJr.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBh, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IJr = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { IJr });
      bool = IJr.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static boolean ftG()
  {
    AppMethodBeat.i(124682);
    if (com.tencent.mm.sdk.platformtools.j.DEBUG)
    {
      AppMethodBeat.o(124682);
      return true;
    }
    if (!ftE())
    {
      AppMethodBeat.o(124682);
      return false;
    }
    if (IJs != null)
    {
      bool = IJs.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBe, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IJs = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { IJs });
      bool = IJs.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
  }
  
  public static boolean ftH()
  {
    AppMethodBeat.i(188987);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.bv.fpT()))
    {
      AppMethodBeat.o(188987);
      return true;
    }
    if (!ftE())
    {
      AppMethodBeat.o(188987);
      return false;
    }
    if (IJt != null)
    {
      bool = IJt.booleanValue();
      AppMethodBeat.o(188987);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBf, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IJt = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "isReceiveMsgResortOpen open %b", new Object[] { IJt });
      bool = IJt.booleanValue();
      AppMethodBeat.o(188987);
      return bool;
    }
  }
  
  private static boolean ftI()
  {
    AppMethodBeat.i(124683);
    if (ay.aRX("brandService").decodeInt("BizTimeLineReSortMsgCheck", 1) == 1)
    {
      AppMethodBeat.o(124683);
      return true;
    }
    AppMethodBeat.o(124683);
    return false;
  }
  
  public static boolean fty()
  {
    return IJk;
  }
  
  public static void ftz()
  {
    AppMethodBeat.i(124667);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124660);
        y.ftA();
        Object localObject2 = p.IIi;
        Object localObject1;
        Object localObject3;
        int i;
        if (p.fsG())
        {
          y.ftD();
          localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(29L);
          localObject1 = p.bOc().decodeString(p.aTK("biz_ad_card_data"));
          localObject3 = (CharSequence)localObject1;
          if ((localObject3 != null) && (!n.aD((CharSequence)localObject3))) {
            break label165;
          }
          i = 1;
          if ((i != 0) || (bu.isNullOrNil(p.aTM((String)localObject1)))) {
            break label170;
          }
          i = 1;
          label86:
          if (i != 0) {
            break label277;
          }
          ae.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
          localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(30L);
          localObject1 = p.fsO();
          if (localObject1 != null)
          {
            localObject2 = p.IIi;
            l1 = p.DJ(((w)localObject1).field_orderFlag);
            if ((((w)localObject1).field_orderFlag != l1) && (l1 > 0L)) {
              break label175;
            }
          }
        }
        label165:
        label170:
        label175:
        boolean bool;
        label277:
        Object localObject4;
        for (;;)
        {
          localObject1 = p.IIi;
          p.fsN();
          AppMethodBeat.o(124660);
          return;
          i = 0;
          break;
          i = 0;
          break label86;
          ((w)localObject1).field_orderFlag = l1;
          localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(36L);
          p.IIi.o((w)localObject1);
          bool = ag.aGv().b((w)localObject1, true);
          ae.i("MicroMsg.BizCardLogic", "insertAd updateById result: " + bool + ", msgId:" + ((w)localObject1).field_msgId + " orderFlag:" + ((w)localObject1).field_orderFlag + " aid: " + ((w)localObject1).ftm());
          continue;
          localObject3 = ag.aGv();
          d.g.b.p.g(localObject3, "SubCoreBiz.getBizTimeLineInfoStorage()");
          localObject3 = ((x)localObject3).ftp();
          if (localObject3 == null)
          {
            ae.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
          }
          else
          {
            localObject4 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(31L);
            com.tencent.mm.plugin.report.service.g.yxI.f(20636, new Object[] { "", "", Integer.valueOf(4) });
            localObject4 = ag.aGv();
            d.g.b.p.g(localObject4, "SubCoreBiz.getBizTimeLineInfoStorage()");
            l1 = ((x)localObject4).fts();
            localObject4 = new w();
            ((w)localObject4).field_content = ((String)localObject1);
            ((w)localObject4).field_type = 637534257;
            int j = 0;
            i = j;
            if (!y.ftD())
            {
              i = j;
              if (p.fsO() != null)
              {
                localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
                com.tencent.mm.plugin.webcanvas.g.CH(37L);
                localObject1 = ag.aGv();
                localObject5 = String.format("DELETE FROM %s WHERE %s = %d and isRead = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), Integer.valueOf(0) });
                ae.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%dret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(((x)localObject1).hKK.execSQL("BizTimeLineInfo", (String)localObject5)) });
                localObject5 = new x.a();
                ((x.a)localObject5).IIW = x.b.IIZ;
                ((x)localObject1).a((x.a)localObject5);
                i = 1;
              }
            }
            if (p.fsF() <= 0)
            {
              localObject1 = ag.aGv();
              localObject5 = "SELECT count(*) FROM BizTimeLineInfo where type=637534257 and createTime > ".concat(String.valueOf(bl.aCr() - 86400000L));
              localObject1 = ((x)localObject1).hKK.a((String)localObject5, null, 0);
              j = 0;
              if (((Cursor)localObject1).moveToFirst()) {
                j = ((Cursor)localObject1).getInt(0);
              }
              ((Cursor)localObject1).close();
              long l2 = p.bOc().decodeLong("BizLastExposeAdTime", 0L);
              int k = p.IHY;
              if (1 > k) {}
              for (;;)
              {
                p.IHY = p.bOc().decodeInt("biz_card_max_ad_count", 1);
                k = p.IHY;
                if ((1 > k) || (10 < k)) {
                  p.IHY = 1;
                }
                do
                {
                  k = p.IHY;
                  if ((j < k) && ((k != 1) || (Math.abs(System.currentTimeMillis() - l2) >= 86400000L))) {
                    break label860;
                  }
                  ae.i("MicroMsg.BizCardLogic", "insertAd too much ad count=".concat(String.valueOf(j)));
                  localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
                  com.tencent.mm.plugin.webcanvas.g.CH(32L);
                  com.tencent.mm.plugin.report.service.g.yxI.f(20636, new Object[] { ((w)localObject4).ftm(), ((w)localObject4).getTraceId(), Integer.valueOf(3) });
                  break;
                } while (10 >= k);
              }
            }
            ae.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
            localObject1 = ag.aGv();
            Object localObject5 = String.format("DELETE FROM %s WHERE %s = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257) });
            ae.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(((x)localObject1).hKK.execSQL("BizTimeLineInfo", (String)localObject5)) });
            localObject5 = new x.a();
            ((x.a)localObject5).IIW = x.b.IIZ;
            ((x)localObject1).a((x.a)localObject5);
            label860:
            localObject1 = ag.aGv();
            localObject5 = "SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(l1 << 32));
            localObject5 = ((x)localObject1).hKK.a((String)localObject5, null, 0);
            localObject1 = null;
            if (((Cursor)localObject5).moveToFirst())
            {
              localObject1 = new w();
              ((w)localObject1).convertFrom((Cursor)localObject5);
            }
            ((Cursor)localObject5).close();
            if (localObject1 != null)
            {
              ae.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", new Object[] { Long.valueOf(l1) });
              com.tencent.mm.plugin.report.service.g.yxI.f(20636, new Object[] { ((w)localObject4).ftm(), ((w)localObject4).getTraceId(), Integer.valueOf(2) });
              localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
              com.tencent.mm.plugin.webcanvas.g.CH(33L);
            }
            else
            {
              if ((p.fsF() == 1) || (ag.aGv().DW(l1 << 32) == null)) {
                break label1097;
              }
              ae.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", new Object[] { Long.valueOf(l1) });
              com.tencent.mm.plugin.report.service.g.yxI.f(20636, new Object[] { ((w)localObject4).ftm(), ((w)localObject4).getTraceId(), Integer.valueOf(1) });
              localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
              com.tencent.mm.plugin.webcanvas.g.CH(34L);
            }
          }
        }
        label1097:
        ((w)localObject4).field_msgId = ag.aGv().ftx();
        ((w)localObject4).field_msgSvrId = 0L;
        ((w)localObject4).field_talker = "";
        ((w)localObject4).field_talkerId = 0;
        ((w)localObject4).field_hasShow = 1;
        ((w)localObject4).field_createTime = bl.aCr();
        if (((w)localObject3).ftc()) {}
        for (long l1 = ((am)localObject3).eNf;; l1 = ((w)localObject3).field_createTime)
        {
          ((am)localObject4).eNf = l1;
          ((am)localObject4).eMD = true;
          ((w)localObject4).ka(1);
          ((w)localObject4).field_status = 3;
          ((w)localObject4).field_orderFlag = p.DJ(0L);
          if (((w)localObject4).field_orderFlag <= 0L) {
            break;
          }
          p.bOc().encode(p.aTK("biz_ad_card_data"), "");
          ((p)localObject2).o((w)localObject4);
          bool = ag.aGv().p((w)localObject4);
          ae.i("MicroMsg.BizCardLogic", "insertAd result: " + bool + ", msgId:" + ((w)localObject4).field_msgId + " orderFlag:" + ((w)localObject4).field_orderFlag + " aid: " + ((w)localObject4).ftm());
          com.tencent.mm.plugin.report.service.g.yxI.f(20636, new Object[] { ((w)localObject4).ftm(), ((w)localObject4).getTraceId(), Integer.valueOf(0) });
          localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(35L);
          if (i != 0) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(38L);
          break;
        }
      }
    }, "BizInsertTlRecCardThread");
    AppMethodBeat.o(124667);
  }
  
  public static int getSessionId()
  {
    return dmM;
  }
  
  public static void r(w paramw)
  {
    AppMethodBeat.i(124670);
    while (ag.aGv().DL(paramw.field_orderFlag) != null) {
      paramw.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static void wW(boolean paramBoolean)
  {
    IJj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */