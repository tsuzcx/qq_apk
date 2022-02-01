package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.af;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class v
{
  public static int GCA = 1;
  public static long GCB = 180L;
  public static long GCC = 60L;
  public static boolean GCD = false;
  private static boolean GCE = false;
  private static boolean GCF = false;
  private static Boolean GCG = null;
  private static Boolean GCH = null;
  private static Boolean GCI = null;
  private static Boolean GCJ = null;
  private static Boolean GCK = null;
  private static Boolean GCL = null;
  private static String GCx = null;
  private static long GCy = 0L;
  public static int GCz;
  private static int daq = 0;
  
  static
  {
    GCz = 0;
  }
  
  private static long AI(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean AJ(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (af.aDc().AC(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (af.aDc().eZh() <= af.aDc().eZu()) {
      af.aDc().eZv();
    }
    af.aDc().AB(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void AK(long paramLong)
  {
    AppMethodBeat.i(124679);
    GCy = paramLong;
    com.tencent.mm.sdk.platformtools.ai.eUY().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
  
  public static void UZ(int paramInt)
  {
    daq = paramInt;
  }
  
  public static void YB(int paramInt)
  {
    AppMethodBeat.i(124664);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124656);
        v.YD(this.GCN);
        AppMethodBeat.o(124656);
      }
    }, "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(124664);
  }
  
  public static void YC(int paramInt)
  {
    AppMethodBeat.i(124665);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(124665);
  }
  
  public static void a(ng paramng)
  {
    AppMethodBeat.i(124663);
    if ((GCD) || (paramng == null))
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg is isInTimeLine now");
      YC(8);
      AppMethodBeat.o(124663);
      return;
    }
    Object localObject = paramng.Edk;
    ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg size %d, replaceExposureTime %d, rank_sessionid %s", new Object[] { Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(paramng.Edl), paramng.EcO });
    if (bs.gY((List)localObject))
    {
      YC(4);
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg items is null");
      AppMethodBeat.o(124663);
      return;
    }
    YC(5);
    ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg");
    if (af.aDc().eZt() <= 0)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg no redDot");
      YC(10);
      AppMethodBeat.o(124663);
      return;
    }
    long l = af.aDc().eZu();
    if (l != aw.aKU("brandService").decodeLong("ReSortBizMsgMaxGroupId", 0L))
    {
      YC(11);
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg MsgMaxGroupId has changed!");
      AppMethodBeat.o(124663);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((LinkedList)localObject).iterator();
    if (localIterator.hasNext())
    {
      ne localne = (ne)localIterator.next();
      if (localne == null) {
        localObject = null;
      }
      label235:
      t localt;
      for (;;)
      {
        if (localObject != null)
        {
          ((t)localObject).field_rankSessionId = paramng.EcO;
          localLinkedList.add(localObject);
          break;
          localObject = af.aDc();
          String str = localne.EcX;
          if (bs.isNullOrNil(str)) {
            localt = null;
          }
          for (;;)
          {
            if ((localt != null) && (localt.field_msgId != 0L)) {
              break label383;
            }
            ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg not found");
            localObject = null;
            break;
            localt = new t();
            localObject = ((u)localObject).hpA.a("BizTimeLineInfo", null, "bizClientMsgId=?", new String[] { String.valueOf(str) }, null, null, null, 2);
            if (((Cursor)localObject).moveToFirst())
            {
              localt.convertFrom((Cursor)localObject);
              ((Cursor)localObject).close();
            }
            else
            {
              ((Cursor)localObject).close();
              localt = null;
            }
          }
          label383:
          if (localt.field_isRead == 1)
          {
            ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg is read");
            localObject = null;
          }
          else if (System.currentTimeMillis() - localt.field_createTime > 604800000L)
          {
            ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo too old msg %d", new Object[] { Long.valueOf(localt.field_createTime) });
            localObject = null;
          }
          else
          {
            if (localt.eZh() != l) {
              localt.GCb = true;
            }
            localt.field_orderFlag = (aw(l, localt.field_createTime / 1000L) | localne.weight << 24 & 0xFF000000 | l << 32);
            l(localt);
            if (localne.EcY != 1) {
              break label726;
            }
            localt.hd(1);
          }
        }
      }
      for (;;)
      {
        localt.hd(1073741824);
        ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo bizclientmsgid:%s pic_type:%d biz_flag:%d", new Object[] { localne.EcX, Integer.valueOf(localne.EcY), Integer.valueOf(localt.field_bitFlag) });
        localObject = s.GBY;
        d.g.b.k.h(localne, "item");
        d.g.b.k.h(localt, "info");
        localObject = localt;
        if (!s.eZg()) {
          break label235;
        }
        if (localne.weight != localt.eZi()) {
          s.aMQ("checkRespData weight invalid!");
        }
        if (((localne.EcY == 1) && (!localt.hc(1))) || ((localne.EcY != 1) && (localt.hc(1)))) {
          s.aMQ("checkRespData show big pic flag invalid!");
        }
        if (!localt.hc(1073741824)) {
          s.aMQ("checkRespData resort flag invalid!");
        }
        if (localt.field_isRead != 0) {
          s.aMQ("CheckRespProcessedData Msg has exposed!");
        }
        localObject = localt;
        if (System.currentTimeMillis() - localt.field_createTime <= 604800000L) {
          break label235;
        }
        s.aMQ("CheckRespProcessedData time invalid!");
        localObject = localt;
        break label235;
        break;
        label726:
        localt.field_bitFlag &= 0xFFFFFFFE;
      }
    }
    ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg new size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (!bs.gY(localLinkedList))
    {
      YC(7);
      paramng = af.aDc();
      if (!bs.gY(localLinkedList)) {
        com.tencent.mm.cn.g.fBc().h(new u.5(paramng, localLinkedList)).b(new u.4(paramng));
      }
      paramng = com.tencent.mm.pluginsdk.b.Dfd;
      if (com.tencent.mm.pluginsdk.b.eJW())
      {
        paramng = com.tencent.mm.pluginsdk.b.Dfd;
        if (com.tencent.mm.pluginsdk.b.eJX())
        {
          ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizImagePreloadStrategy preload after resort");
          paramng = com.tencent.mm.pluginsdk.b.Dfd;
          com.tencent.mm.pluginsdk.b.eKa();
          AppMethodBeat.o(124663);
        }
      }
    }
    else
    {
      YC(6);
    }
    AppMethodBeat.o(124663);
  }
  
  public static boolean a(dgg paramdgg)
  {
    AppMethodBeat.i(209583);
    dgb localdgb = paramdgg.FPB;
    if (localdgb == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (localdgb.FPn == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (localdgb.FPp == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(209583);
      return false;
    }
    dgd localdgd = localdgb.FPo;
    if (localdgd == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (localdgd.ncR == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (localdgd.ndW == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (localdgd.FPw == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(209583);
      return false;
    }
    if (bs.gY(localdgb.FPq))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(209583);
      return false;
    }
    int i = paramdgg.style;
    if (((i == 5) || (i == 6)) && (localdgb.FPq.size() < 2))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(209583);
      return false;
    }
    AppMethodBeat.o(209583);
    return true;
  }
  
  public static void aG(bo parambo)
  {
    AppMethodBeat.i(124662);
    if (parambo == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.vC(parambo.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (com.tencent.mm.model.w.sQ(parambo.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo.field_talker);
    if ((localai != null) && (com.tencent.mm.n.b.ln(localai.field_type)) && (!localai.fad()))
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
    Object localObject2 = bi.yr(parambo.eul);
    if (localObject2 != null)
    {
      m = ((bi.b)localObject2).hov;
      k = ((bi.b)localObject2).cFI;
      j = ((bi.b)localObject2).how;
      l1 = ((bi.b)localObject2).hoA;
      if ((((bi.b)localObject2).hoB & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bi.b)localObject2).hoB & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bi.b)localObject2).hoB & 0x4) != 0L)
      {
        ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambo.field_talker, Long.valueOf(((bi.b)localObject2).hoB) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bi.b)localObject2).hoB & 0x40) != 0L) && (localai != null) && (com.tencent.mm.n.b.ln(localai.field_type)))
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((parambo.getType() == 34) || (parambo.getType() == 3))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(parambo.getType()) });
      bool1 = false;
    }
    for (;;)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambo.field_talker, Boolean.valueOf(bool1) });
      if (bool1) {
        break label813;
      }
      com.tencent.mm.pluginsdk.b.DeZ = true;
      if (!bs.lr(parambo.field_talker, GCx)) {
        break label547;
      }
      ac.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { GCx });
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (parambo.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!parambo.eZj()) {
          break;
        }
        if (parambo.eZj()) {}
        for (localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (bs.gY(((com.tencent.mm.ah.u)localObject1).hkS))) {
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
    localObject2 = af.aDd();
    l1 = parambo.field_msgSvrId;
    Object localObject1 = new t();
    localObject2 = ((w)localObject2).hpA.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[] { String.valueOf(l1) }, null, null, null, 2);
    if (((Cursor)localObject2).moveToFirst())
    {
      ((t)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
      if (localObject1 != null) {
        break label790;
      }
    }
    label790:
    for (localObject2 = new t();; localObject2 = localObject1)
    {
      ((t)localObject2).field_msgId = parambo.field_msgId;
      ((t)localObject2).field_msgSvrId = parambo.field_msgSvrId;
      ((t)localObject2).field_content = parambo.field_content;
      ((t)localObject2).field_type = parambo.getType();
      ((t)localObject2).field_talker = parambo.field_talker;
      ((t)localObject2).field_talkerId = parambo.field_talkerId;
      ((t)localObject2).field_createTime = parambo.field_createTime;
      ((t)localObject2).field_imgPath = parambo.field_imgPath;
      ((t)localObject2).jA(parambo.euk);
      ((t)localObject2).qf(parambo.eul);
      ((t)localObject2).field_status = parambo.field_status;
      if (localObject1 != null) {
        break label797;
      }
      af.aDd().j((t)localObject2);
      AppMethodBeat.o(124662);
      return;
      ((Cursor)localObject2).close();
      localObject1 = null;
      break;
    }
    label797:
    af.aDd().k((t)localObject2);
    AppMethodBeat.o(124662);
    return;
    label813:
    if ((localObject2 != null) && ((((bi.b)localObject2).hoB & 0x2) != 0L))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambo.field_talker, Long.valueOf(((bi.b)localObject2).hoB) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.b.DeZ = true;
    localObject2 = af.aDc().Ax(parambo.field_msgId);
    label1019:
    long l3;
    long l2;
    if (localObject2 == null)
    {
      localObject1 = new t();
      ((t)localObject1).field_msgId = parambo.field_msgId;
      ((t)localObject1).field_msgSvrId = parambo.field_msgSvrId;
      ((t)localObject1).field_content = parambo.field_content;
      ((t)localObject1).field_type = parambo.getType();
      ((t)localObject1).field_talker = parambo.field_talker;
      ((t)localObject1).field_talkerId = parambo.field_talkerId;
      ((t)localObject1).field_createTime = parambo.field_createTime;
      ((t)localObject1).field_imgPath = parambo.field_imgPath;
      ((t)localObject1).jA(parambo.euk);
      ((t)localObject1).qf(parambo.eul);
      ((t)localObject1).field_bizClientMsgId = parambo.field_bizClientMsgId;
      if (!bIO()) {
        break label1294;
      }
      ((t)localObject1).field_status = parambo.field_status;
      ((t)localObject1).field_hasShow = 0;
      if (i != 0) {
        ((t)localObject1).hd(1);
      }
      l3 = af.aDc().eZh();
      long l4 = aw(l3, ((t)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = af.aDc().eZv();
        l2 = aw(l3, ((t)localObject1).field_createTime / 1000L);
      }
      ((t)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      l((t)localObject1);
      if ((localai == null) || (!localai.aaN())) {
        break label1309;
      }
      ((t)localObject1).field_placeTop = 1;
      label1157:
      if (localObject2 != null) {
        break label1415;
      }
      ((t)localObject1).field_isExpand = bool2;
      af.aDc().j((t)localObject1);
      if (!GCF)
      {
        GCF = true;
        com.tencent.e.h.JZN.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124660);
            u localu = af.aDc();
            long l = System.currentTimeMillis();
            int j = localu.eZx();
            int i;
            if (j <= 2000)
            {
              if ((ac.getLogLevel() > 0) || (j < 500))
              {
                i = 0;
                if (i == 0) {
                  break label168;
                }
              }
            }
            else
            {
              String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
              localu.hpA.execSQL("BizTimeLineInfo", str);
              ac.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
            }
            for (;;)
            {
              v.bvu();
              AppMethodBeat.o(124660);
              return;
              if (aw.aKU("brandService").decodeInt("BizTimeLineDeleteOldData", 0) == 1)
              {
                i = 1;
                break;
              }
              i = 0;
              break;
              label168:
              ac.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(j) });
            }
          }
        }, 1000L, "BizTimeLineInfoStorageThread");
      }
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!bt.eWo())) {
        break label1318;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1) {
        YB(GCz);
      }
      ac.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((t)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
      label1294:
      ((t)localObject1).field_status = 4;
      ((t)localObject1).field_hasShow = 1;
      break label1019;
      label1309:
      ((t)localObject1).field_placeTop = 0;
      break label1157;
      label1318:
      if (!eZE())
      {
        bool1 = false;
      }
      else
      {
        if (GCL == null) {
          break label1347;
        }
        bool1 = GCL.booleanValue();
      }
    }
    label1347:
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQb, 1) == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      GCL = Boolean.valueOf(bool1);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "isReceiveMsgResortOpen open %b", new Object[] { GCL });
      bool1 = GCL.booleanValue();
      break;
    }
    label1415:
    af.aDc().k((t)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void aH(bo parambo)
  {
    AppMethodBeat.i(124676);
    if (parambo == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    af.aDc().AF(parambo.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static void aMS(String paramString)
  {
    GCx = paramString;
  }
  
  private static long aw(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRi, "");
    long l1 = l2;
    if (!bs.isNullOrNil(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (bs.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - bs.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      l1 = 604800L;
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRi, str);
      ac.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  private static dgg bG(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    dgg localdgg = new dgg();
    localdgg.FPB = new dgb();
    localdgg.FPB.FPn = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localdgg.FPB.FPp = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localdgg.FPB.FPo = new dgd();
    localdgg.FPB.FPo.FPx = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localdgg.FPB.FPo.ncR = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localdgg.FPB.FPo.ndW = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localdgg.FPB.FPo.FPw = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localdgg.FPB.FPo.iJW = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new dgf();
    Object localObject3 = new aii();
    int i = 0;
    Object localObject1;
    if (i < 20)
    {
      StringBuilder localStringBuilder = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount.NegativeFeedbackReason");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (bs.isNullOrNil((String)localObject1)) {
          break label296;
        }
        ((aii)localObject3).EDf.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((aii)localObject3).EDg = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((dgf)localObject2).FPA = ((aii)localObject3);
    localdgg.FPB.FPt = ((dgf)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new dgc();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((dgc)localObject2).Title = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (bs.isNullOrNil(((dgc)localObject2).Title)) {
          break label885;
        }
        ((dgc)localObject2).Eal = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((dgc)localObject2).Ean = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((dgc)localObject2).Eap = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((dgc)localObject2).Eaq = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((dgc)localObject2).Ear = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((dgc)localObject2).hkQ = bs.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((dgc)localObject2).Eay = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((dgc)localObject2).Eaz = bs.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((dgc)localObject2).EaA = bs.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((dgc)localObject2).EaB = bs.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((dgc)localObject2).CreateTime = bs.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((dgc)localObject2).FPv = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        localdgg.FPB.FPq.add(localObject2);
        i += 1;
        break;
      }
    }
    label885:
    localdgg.pos = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localdgg.weight = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localdgg.FPC = bs.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localdgg.style = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    AppMethodBeat.o(124669);
    return localdgg;
  }
  
  public static boolean bIO()
  {
    AppMethodBeat.i(124680);
    if (GCG != null)
    {
      bool = GCG.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    int i = aw.aKU("brandService").decodeInt("BizTimeLineOpenStatus", -1);
    if (i == 1) {
      GCG = Boolean.TRUE;
    }
    while (GCG != null)
    {
      bool = GCG.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
      if (i == 0) {
        GCG = Boolean.FALSE;
      }
    }
    if ((((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRj, Integer.valueOf(0))).intValue() & 0x1) > 0)
    {
      GCG = Boolean.TRUE;
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      bool = GCG.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    i = af.aDc().eZx();
    if (i > 4000)
    {
      GCG = Boolean.FALSE;
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen too match data totalCount %d", new Object[] { Integer.valueOf(i) });
      bool = GCG.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPY, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      GCG = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { GCG });
      bool = GCG.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
  }
  
  public static void c(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.fXi == null) || (parama.fXi.DPV == null))
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    int i = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    Object localObject1 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if (localObject1 == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).yu(i))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(124666);
      return;
    }
    parama = z.a(parama.fXi.DPV);
    localObject1 = aw.aKU("brandService");
    Object localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.agP();
    ((aw)localObject1).encode(com.tencent.mm.kernel.a.afE(), parama);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 0L, 1L, false);
    long l = bs.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
    localObject1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
    int j = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    int k = bs.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    i = 0;
    if (i < 2)
    {
      localObject2 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (parama = "";; parama = Integer.valueOf(1))
      {
        localObject2 = parama;
        parama = (String)paramMap.get((String)localObject2 + ".AppMsg.Title");
        if (bs.isNullOrNil(parama)) {
          break label468;
        }
        localObject2 = (String)paramMap.get((String)localObject2 + ".AppMsg.ContentUrl");
        parama = x.aId(parama);
        localObject2 = x.aId((String)localObject2);
        com.tencent.mm.plugin.report.service.h.wUl.f(18106, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), parama, localObject2 });
        i += 1;
        break;
      }
    }
    label468:
    ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { localObject1, Long.valueOf(l) });
    AppMethodBeat.o(124666);
  }
  
  public static void d(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(124671);
    ac.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineSingleMsg by SysCmd, values：" + paramMap + " addMsgInfo：" + parama);
    parama = z.a(parama.fXi.DPV);
    paramMap = (String)paramMap.get(".sysmsg.BizMsgRejectRecommend.Content");
    if ((TextUtils.isEmpty(parama)) || (TextUtils.isEmpty(paramMap)))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "info content == null");
      AppMethodBeat.o(124671);
      return;
    }
    lw(parama, paramMap);
    AppMethodBeat.o(124671);
  }
  
  public static boolean eZA()
  {
    return GCE;
  }
  
  public static void eZB()
  {
    AppMethodBeat.i(124667);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124659);
        v.eZC();
        AppMethodBeat.o(124659);
      }
    }, "BizInsertTlRecCardThread");
    AppMethodBeat.o(124667);
  }
  
  public static void eZC()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(124668);
      return;
    }
    Object localObject2 = aw.aKU("brandService");
    Object localObject1 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.agP();
    Object localObject3 = com.tencent.mm.kernel.a.afE();
    localObject1 = ((aw)localObject2).decodeString((String)localObject3);
    if (bs.isNullOrNil((String)localObject1))
    {
      ac.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(124668);
      return;
    }
    int i = ((String)localObject1).indexOf("<sysmsg");
    if (i != -1)
    {
      localObject4 = bv.L(((String)localObject1).substring(i), "sysmsg");
      if (localObject4 == null)
      {
        ac.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
        AppMethodBeat.o(124668);
      }
    }
    else
    {
      AppMethodBeat.o(124668);
      return;
    }
    localObject1 = af.aDc().eZr();
    if (localObject1 == null)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      AppMethodBeat.o(124668);
      return;
    }
    if (((t)localObject1).field_status == 4)
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
      AppMethodBeat.o(124668);
      return;
    }
    ((aw)localObject2).encode((String)localObject3, "");
    localObject2 = bG((Map)localObject4);
    if (!a((dgg)localObject2))
    {
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      AppMethodBeat.o(124668);
      return;
    }
    i = ((dgg)localObject2).pos;
    long l1 = ((dgg)localObject2).weight;
    if ((i < 0) && (l1 < 0L))
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
      AppMethodBeat.o(124668);
      return;
    }
    ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
    long l2 = af.aDc().eZu();
    if (af.aDc().AH(l2 << 32) != null)
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard groupId %d already has a recommend msg", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(124668);
      return;
    }
    localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((dgg)localObject2).FPB.FPo.ncR);
    if ((localObject3 != null) && (com.tencent.mm.n.b.ln(((av)localObject3).field_type)))
    {
      ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { ((dgg)localObject2).FPB.FPo.ncR });
      AppMethodBeat.o(124668);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 1L, 1L, false);
    localObject3 = new t();
    ((t)localObject3).field_msgId = af.aDc().eZz();
    ((t)localObject3).field_msgSvrId = 0L;
    ((t)localObject3).field_type = 620757041;
    ((t)localObject3).field_talker = ((dgg)localObject2).FPB.FPo.ncR;
    ((t)localObject3).field_talkerId = 0;
    ((t)localObject1).field_createTime -= 1000L;
    ((t)localObject3).jA(1);
    ((t)localObject3).field_status = 3;
    ((t)localObject3).b((dgg)localObject2);
    if (l1 >= 0L) {
      l1 = Math.min(l1, AI(((t)localObject1).field_orderFlag));
    }
    for (;;)
    {
      ((t)localObject3).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | aw(l2, ((t)localObject3).field_createTime / 1000L));
      l((t)localObject3);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s", new Object[] { Boolean.valueOf(af.aDc().j((t)localObject3)), ((dgg)localObject2).FPB.FPo.ncR });
      AppMethodBeat.o(124668);
      return;
      if (i != 0) {
        break;
      }
      l1 = AI(((t)localObject1).field_orderFlag);
      ((t)localObject1).field_createTime += 1000L;
    }
    Object localObject4 = af.aDc();
    localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(i - 1));
    Cursor localCursor = ((u)localObject4).hpA.a((String)localObject1, null, 0);
    localObject1 = null;
    if (localCursor.moveToFirst())
    {
      localObject1 = new t();
      ((t)localObject1).convertFrom(localCursor);
    }
    localCursor.close();
    if (localObject1 == null)
    {
      l1 = ((u)localObject4).eZu();
      localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l1 << 32) + " order by orderFlag asc limit 1";
      localObject4 = ((u)localObject4).hpA.a((String)localObject1, null, 0);
      localObject1 = null;
      if (((Cursor)localObject4).moveToFirst())
      {
        localObject1 = new t();
        ((t)localObject1).convertFrom((Cursor)localObject4);
      }
      ((Cursor)localObject4).close();
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
        l1 = 0L;
        break;
      }
      l1 = AI(((t)localObject1).field_orderFlag);
      ((t)localObject1).field_createTime -= 1000L;
      break;
    }
  }
  
  public static void eZD()
  {
    AppMethodBeat.i(124678);
    if (!bIO())
    {
      AppMethodBeat.o(124678);
      return;
    }
    bk localbk = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG();
    ap localap = localbk.aNI("officialaccounts");
    if (localap == null) {
      localap = new ap("officialaccounts");
    }
    label288:
    label471:
    label990:
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = af.aDd().eZr();
      Object localObject2 = af.aDc().eZr();
      Object localObject1 = af.aDc().hpA.a("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null, 0);
      if (((Cursor)localObject1).moveToFirst()) {}
      label745:
      for (long l1 = ((Cursor)localObject1).getLong(0);; l1 = 0L)
      {
        ((Cursor)localObject1).close();
        long l2;
        if (localObject3 != null)
        {
          l2 = ((t)localObject3).field_createTime;
          if (localObject2 == null) {
            break label1009;
          }
        }
        label365:
        label1009:
        for (int i = af.aDc().AE(((t)localObject2).field_orderFlag);; i = 0)
        {
          int j = af.aDd().bQe();
          if (j > 0) {
            if (l2 > l1)
            {
              localap.lq(16);
              localap.jR(j);
              localObject1 = localObject3;
            }
          }
          for (;;)
          {
            if ((localObject1 != null) && (((t)localObject1).field_msgId != 0L)) {
              break label288;
            }
            ac.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
            localap.faH();
            if (!bool) {
              localbk.a(localap, localap.field_username);
            }
            AppMethodBeat.o(124678);
            return;
            l2 = 0L;
            break;
            localap.lp(16);
            localap.jR(i);
            localObject1 = localObject2;
            continue;
            localap.lp(16);
            localap.jR(i);
            localObject1 = localObject2;
          }
          if ((localObject1 == localObject2) && (((t)localObject1).field_placeTop == 1))
          {
            localap.lp(32);
            if (localObject1 == localObject3)
            {
              l3 = ((t)localObject1).field_msgId;
              if (GCy == 0L) {
                GCy = com.tencent.mm.sdk.platformtools.ai.eUY().getLong("biz_time_line_last_notify_msg_id", -1L);
              }
              if (l3 != GCy) {
                break label884;
              }
              localap.lq(64);
            }
            if (((t)localObject1).eZn())
            {
              localObject2 = new bo();
              ((bo)localObject2).setContent(((am)localObject1).eul);
              ((bo)localObject2).re(((t)localObject1).field_talker);
              ((bo)localObject2).setStatus(3);
              ((bo)localObject2).oA(((t)localObject1).field_createTime);
            }
            if (!((t)localObject1).eZk()) {
              break label894;
            }
            localObject2 = new bo();
            ((bo)localObject2).setContent(((am)localObject1).eul);
            ((bo)localObject2).re(((t)localObject1).field_talker);
            ((bo)localObject2).setStatus(3);
            ((bo)localObject2).oA(((t)localObject1).field_createTime);
            long l3 = Math.min(ce.azI(), localap.field_conversationTime);
            l1 = Math.max(l2, l1);
            if ((((dy)localObject2).field_msgId <= 0L) && (!((t)localObject1).eZn()) && (!((t)localObject1).eZk())) {
              break label940;
            }
            localap.aI((bo)localObject2);
            localap.setContent(((dy)localObject2).field_talker + ":" + ((dy)localObject2).field_content);
            localap.qQ(Integer.toString(((bo)localObject2).getType()));
            Object localObject4 = localbk.Ls();
            if (localObject4 != null)
            {
              localObject3 = new PString();
              PString localPString = new PString();
              PInt localPInt = new PInt();
              ((bo)localObject2).re("officialaccounts");
              ((bo)localObject2).setContent(localap.field_content);
              ((bk.b)localObject4).a((bo)localObject2, (PString)localObject3, localPString, localPInt, true);
              if (((t)localObject1).eZn())
              {
                localObject4 = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131756584);
                ((PString)localObject3).value = String.format(((PString)localObject3).value, new Object[] { localObject4 });
              }
              if (((t)localObject1).eZk())
              {
                localObject1 = ((t)localObject1).eZq();
                if ((localObject1 == null) || (((dgg)localObject1).FPB == null) || (bs.isNullOrNil(((dgg)localObject1).FPB.FPn))) {
                  break label923;
                }
                ((PString)localObject3).value = ((dgg)localObject1).FPB.FPn;
              }
              localap.qR(((PString)localObject3).value);
              localap.qS(localPString.value);
              localap.jU(localPInt.value);
            }
            localap.ou(Math.max(l3, l1));
            if (!bool) {
              break label990;
            }
          }
          for (l1 = localbk.e(localap);; l1 = localbk.a(localap, localap.field_username))
          {
            l2 = ((dy)localObject2).field_msgId;
            localObject1 = aw.aKU("brandService");
            if (localObject1 != null) {
              ((aw)localObject1).encode("BizLastMsgId", l2);
            }
            ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localap.field_conversationTime) });
            AppMethodBeat.o(124678);
            return;
            localap.lq(32);
            break;
            label884:
            localap.lp(64);
            break label365;
            label894:
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(((t)localObject1).field_msgId);
            break label471;
            ((PString)localObject3).value = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131756587);
            break label745;
            if (((t)localObject1).field_type != 10002)
            {
              localap.faH();
              ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((t)localObject1).field_talker });
              break label775;
            }
            ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is system biz reject msg");
            break label775;
          }
        }
      }
    }
  }
  
  private static boolean eZE()
  {
    AppMethodBeat.i(124681);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bt.eWo()))
    {
      AppMethodBeat.o(124681);
      return true;
    }
    if (!bIO())
    {
      AppMethodBeat.o(124681);
      return false;
    }
    if (GCH != null)
    {
      bool = GCH.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPZ, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      GCH = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizMsgResortOpen open %b", new Object[] { GCH });
      bool = GCH.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
  }
  
  public static boolean eZF()
  {
    AppMethodBeat.i(176159);
    if (GCJ != null)
    {
      bool = GCJ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQd, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      GCJ = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { GCJ });
      bool = GCJ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static boolean eZG()
  {
    AppMethodBeat.i(124682);
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      AppMethodBeat.o(124682);
      return true;
    }
    if (!eZE())
    {
      AppMethodBeat.o(124682);
      return false;
    }
    if (GCK != null)
    {
      bool = GCK.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQa, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      GCK = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { GCK });
      bool = GCK.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
  }
  
  private static boolean eZH()
  {
    AppMethodBeat.i(124683);
    if (aw.aKU("brandService").decodeInt("BizTimeLineReSortMsgCheck", 1) == 1)
    {
      AppMethodBeat.o(124683);
      return true;
    }
    AppMethodBeat.o(124683);
    return false;
  }
  
  public static int getSessionId()
  {
    return daq;
  }
  
  private static void l(t paramt)
  {
    AppMethodBeat.i(124670);
    while (af.aDc().Aw(paramt.field_orderFlag) != null) {
      paramt.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  private static void lw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124672);
    t localt = new t();
    localt.field_msgSvrId = 0L;
    localt.field_content = paramString1;
    localt.field_type = 10002;
    localt.field_talker = "weixinguanhaozhushou";
    localt.field_talkerId = 0;
    localt.field_createTime = System.currentTimeMillis();
    localt.jA(1);
    localt.qf(paramString2);
    localt.field_status = 3;
    int i = 0;
    if (i < 4)
    {
      Cursor localCursor = af.aDd().hpA.a("SELECT * FROM BizTimeLineSingleMsgInfo order by bizRejectMsgId DESC limit 1", null, 0);
      paramString2 = null;
      if (localCursor.moveToFirst())
      {
        paramString2 = new t();
        paramString2.convertFrom(localCursor);
      }
      localCursor.close();
      if (paramString2 == null) {
        localt.field_bizRejectMsgId = 1L;
      }
      for (localt.field_msgId = 1000000001L;; localt.field_msgId = (1000000000L + paramString2.field_bizRejectMsgId + 1L))
      {
        ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "sysmsg get. msgId = %s, msgSvrId = %s, content = %s, createTime = %s", new Object[] { Long.valueOf(localt.field_msgId), Long.valueOf(localt.field_msgSvrId), localt.field_content, Long.valueOf(localt.field_createTime) });
        ac.i("MicroMsg.BizTimeLineInfoStorageLogic", paramString1);
        boolean bool = af.aDd().j(localt);
        ac.i("MicroMsg.BizTimeLineInfoStorageLogic", "insertSingleMsgWithRetry: result : %s, tryTime = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break label283;
        }
        i += 1;
        break;
        paramString2.field_bizRejectMsgId += 1L;
      }
    }
    label283:
    AppMethodBeat.o(124672);
  }
  
  public static void wb(boolean paramBoolean)
  {
    GCD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */