package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.f.a;
import com.tencent.mm.co.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u
{
  private static String FeN = null;
  private static long FeO = 0L;
  public static int FeP = 0;
  public static int FeQ = 1;
  public static long FeR = 180L;
  public static long FeS = 60L;
  public static boolean FeT = false;
  private static boolean FeU = false;
  private static boolean FeV = false;
  private static Boolean FeW = null;
  private static Boolean FeX = null;
  private static Boolean FeY = null;
  private static Boolean FeZ = null;
  private static Boolean Ffa = null;
  private static Boolean Ffb = null;
  private static int dcS = 0;
  
  public static void SR(int paramInt)
  {
    dcS = paramInt;
  }
  
  public static void Wr(int paramInt)
  {
    AppMethodBeat.i(124664);
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124656);
        u.Wt(this.Ffc);
        AppMethodBeat.o(124656);
      }
    }, "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(124664);
  }
  
  public static void Ws(int paramInt)
  {
    AppMethodBeat.i(124665);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(124665);
  }
  
  public static void a(mz parammz)
  {
    AppMethodBeat.i(124663);
    if ((FeT) || (parammz == null))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg is isInTimeLine now");
      Ws(8);
      AppMethodBeat.o(124663);
      return;
    }
    Object localObject1 = parammz.CKI;
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg size %d, replaceExposureTime %d, rank_sessionid %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(parammz.CKJ), parammz.CKm });
    if (bt.gL((List)localObject1))
    {
      Ws(4);
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg items is null");
      AppMethodBeat.o(124663);
      return;
    }
    Ws(5);
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg");
    if (com.tencent.mm.am.af.awk().eJW() <= 0)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg no redDot");
      Ws(10);
      AppMethodBeat.o(124663);
      return;
    }
    long l = com.tencent.mm.am.af.awk().eJX();
    if (l != ax.aFD("brandService").decodeLong("ReSortBizMsgMaxGroupId", 0L))
    {
      Ws(11);
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg MsgMaxGroupId has changed!");
      AppMethodBeat.o(124663);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((LinkedList)localObject1).iterator();
    if (localIterator.hasNext())
    {
      mx localmx = (mx)localIterator.next();
      if (localmx == null) {
        localObject1 = null;
      }
      for (;;)
      {
        label234:
        if (localObject1 != null)
        {
          ((s)localObject1).field_rankSessionId = parammz.CKm;
          localLinkedList.add(localObject1);
          break;
          Object localObject2 = com.tencent.mm.am.af.awk();
          String str = localmx.CKv;
          if (bt.isNullOrNil(str)) {
            localObject1 = null;
          }
          for (;;)
          {
            if ((localObject1 != null) && (((s)localObject1).field_msgId != 0L)) {
              break label383;
            }
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg not found");
            localObject1 = null;
            break;
            localObject1 = new s();
            localObject2 = ((t)localObject2).gPa.a("BizTimeLineInfo", null, "bizClientMsgId=?", new String[] { String.valueOf(str) }, null, null, null, 2);
            if (((Cursor)localObject2).moveToFirst())
            {
              ((s)localObject1).convertFrom((Cursor)localObject2);
              ((Cursor)localObject2).close();
            }
            else
            {
              ((Cursor)localObject2).close();
              localObject1 = null;
            }
          }
          label383:
          if (((s)localObject1).field_isRead == 1)
          {
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo msg is read");
            localObject1 = null;
          }
          else if (System.currentTimeMillis() - ((s)localObject1).field_createTime > 604800000L)
          {
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo too old msg %d", new Object[] { Long.valueOf(((s)localObject1).field_createTime) });
            localObject1 = null;
          }
          else
          {
            if (((s)localObject1).eJJ() != l) {
              ((s)localObject1).Fer = true;
            }
            ((s)localObject1).field_orderFlag = (ax(l, ((s)localObject1).field_createTime / 1000L) | localmx.weight << 24 & 0xFF000000 | l << 32);
            l((s)localObject1);
            if (localmx.CKw != 1) {
              break label564;
            }
            ((s)localObject1).hu(1);
          }
        }
      }
      for (;;)
      {
        ((s)localObject1).hu(1073741824);
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doGetResortBizTimeLineInfo bizclientmsgid:%s pic_type:%d biz_flag:%d", new Object[] { localmx.CKv, Integer.valueOf(localmx.CKw), Integer.valueOf(((s)localObject1).field_bitFlag) });
        break label234;
        break;
        label564:
        ((s)localObject1).field_bitFlag &= 0xFFFFFFFE;
      }
    }
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doReSortBizMsg new size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (!bt.gL(localLinkedList))
    {
      Ws(7);
      parammz = com.tencent.mm.am.af.awk();
      if (!bt.gL(localLinkedList)) {
        com.tencent.mm.co.g.fkM().h(new t.5(parammz, localLinkedList)).b(new t.4(parammz));
      }
      parammz = com.tencent.mm.pluginsdk.b.BMT;
      if (com.tencent.mm.pluginsdk.b.euD())
      {
        parammz = com.tencent.mm.pluginsdk.b.BMT;
        if (com.tencent.mm.pluginsdk.b.euE())
        {
          ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizImagePreloadStrategy preload after resort");
          parammz = com.tencent.mm.pluginsdk.b.BMT;
          com.tencent.mm.pluginsdk.b.euH();
          AppMethodBeat.o(124663);
        }
      }
    }
    else
    {
      Ws(6);
    }
    AppMethodBeat.o(124663);
  }
  
  public static boolean a(dau paramdau)
  {
    AppMethodBeat.i(191104);
    dap localdap = paramdau.Esz;
    if (localdap == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (localdap.Esl == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (localdap.Esn == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(191104);
      return false;
    }
    dar localdar = localdap.Esm;
    if (localdar == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (localdar.mAQ == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (localdar.mBV == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (localdar.Esu == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(191104);
      return false;
    }
    if (bt.gL(localdap.Eso))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(191104);
      return false;
    }
    int i = paramdau.style;
    if (((i == 5) || (i == 6)) && (localdap.Eso.size() < 2))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(191104);
      return false;
    }
    AppMethodBeat.o(191104);
    return true;
  }
  
  public static void aE(bl parambl)
  {
    AppMethodBeat.i(124662);
    if (parambl == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.rz(parambl.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (w.pF(parambl.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(parambl.field_talker);
    if ((localaf != null) && (com.tencent.mm.n.b.ls(localaf.field_type)) && (!localaf.eKB()))
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
    Object localObject2 = bi.ul(parambl.esh);
    if (localObject2 != null)
    {
      m = ((bi.b)localObject2).gNV;
      k = ((bi.b)localObject2).cIB;
      j = ((bi.b)localObject2).gNW;
      l1 = ((bi.b)localObject2).gOa;
      if ((((bi.b)localObject2).gOb & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bi.b)localObject2).gOb & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bi.b)localObject2).gOb & 0x4) != 0L)
      {
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambl.field_talker, Long.valueOf(((bi.b)localObject2).gOb) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bi.b)localObject2).gOb & 0x40) != 0L) && (localaf != null) && (com.tencent.mm.n.b.ls(localaf.field_type)))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((parambl.getType() == 34) || (parambl.getType() == 3))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(parambl.getType()) });
      bool1 = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambl.field_talker, Boolean.valueOf(bool1) });
      if (bool1) {
        break label813;
      }
      com.tencent.mm.pluginsdk.b.BMP = true;
      if (!bt.kU(parambl.field_talker, FeN)) {
        break label547;
      }
      ad.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { FeN });
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (parambl.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!parambl.eJL()) {
          break;
        }
        if (parambl.eJL()) {}
        for (localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (bt.gL(((com.tencent.mm.ai.u)localObject1).gKs))) {
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
    localObject2 = com.tencent.mm.am.af.awl();
    l1 = parambl.field_msgSvrId;
    Object localObject1 = new s();
    localObject2 = ((v)localObject2).gPa.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[] { String.valueOf(l1) }, null, null, null, 2);
    if (((Cursor)localObject2).moveToFirst())
    {
      ((s)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
      if (localObject1 != null) {
        break label790;
      }
    }
    label790:
    for (localObject2 = new s();; localObject2 = localObject1)
    {
      ((s)localObject2).field_msgId = parambl.field_msgId;
      ((s)localObject2).field_msgSvrId = parambl.field_msgSvrId;
      ((s)localObject2).field_content = parambl.field_content;
      ((s)localObject2).field_type = parambl.getType();
      ((s)localObject2).field_talker = parambl.field_talker;
      ((s)localObject2).field_talkerId = parambl.field_talkerId;
      ((s)localObject2).field_createTime = parambl.field_createTime;
      ((s)localObject2).field_imgPath = parambl.field_imgPath;
      ((s)localObject2).jC(parambl.esg);
      ((s)localObject2).mZ(parambl.esh);
      ((s)localObject2).field_status = parambl.field_status;
      if (localObject1 != null) {
        break label797;
      }
      com.tencent.mm.am.af.awl().j((s)localObject2);
      AppMethodBeat.o(124662);
      return;
      ((Cursor)localObject2).close();
      localObject1 = null;
      break;
    }
    label797:
    com.tencent.mm.am.af.awl().k((s)localObject2);
    AppMethodBeat.o(124662);
    return;
    label813:
    if ((localObject2 != null) && ((((bi.b)localObject2).gOb & 0x2) != 0L))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambl.field_talker, Long.valueOf(((bi.b)localObject2).gOb) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.b.BMP = true;
    localObject2 = com.tencent.mm.am.af.awk().vU(parambl.field_msgId);
    label1019:
    long l3;
    long l2;
    if (localObject2 == null)
    {
      localObject1 = new s();
      ((s)localObject1).field_msgId = parambl.field_msgId;
      ((s)localObject1).field_msgSvrId = parambl.field_msgSvrId;
      ((s)localObject1).field_content = parambl.field_content;
      ((s)localObject1).field_type = parambl.getType();
      ((s)localObject1).field_talker = parambl.field_talker;
      ((s)localObject1).field_talkerId = parambl.field_talkerId;
      ((s)localObject1).field_createTime = parambl.field_createTime;
      ((s)localObject1).field_imgPath = parambl.field_imgPath;
      ((s)localObject1).jC(parambl.esg);
      ((s)localObject1).mZ(parambl.esh);
      ((s)localObject1).field_bizClientMsgId = parambl.field_bizClientMsgId;
      if (!bBQ()) {
        break label1294;
      }
      ((s)localObject1).field_status = parambl.field_status;
      ((s)localObject1).field_hasShow = 0;
      if (i != 0) {
        ((s)localObject1).hu(1);
      }
      l3 = com.tencent.mm.am.af.awk().eJJ();
      long l4 = ax(l3, ((s)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.am.af.awk().eJY();
        l2 = ax(l3, ((s)localObject1).field_createTime / 1000L);
      }
      ((s)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      l((s)localObject1);
      if ((localaf == null) || (!localaf.ZS())) {
        break label1309;
      }
      ((s)localObject1).field_placeTop = 1;
      label1157:
      if (localObject2 != null) {
        break label1415;
      }
      ((s)localObject1).field_isExpand = bool2;
      com.tencent.mm.am.af.awk().j((s)localObject1);
      if (!FeV)
      {
        FeV = true;
        com.tencent.e.h.Iye.a(new u.4(), 1000L, "BizTimeLineInfoStorageThread");
      }
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!bu.eGT())) {
        break label1318;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1) {
        Wr(FeP);
      }
      ad.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((s)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
      label1294:
      ((s)localObject1).field_status = 4;
      ((s)localObject1).field_hasShow = 1;
      break label1019;
      label1309:
      ((s)localObject1).field_placeTop = 0;
      break label1157;
      label1318:
      if (!eKh())
      {
        bool1 = false;
      }
      else
      {
        if (Ffb == null) {
          break label1347;
        }
        bool1 = Ffb.booleanValue();
      }
    }
    label1347:
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmB, 1) == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      Ffb = Boolean.valueOf(bool1);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isReceiveMsgResortOpen open %b", new Object[] { Ffb });
      bool1 = Ffb.booleanValue();
      break;
    }
    label1415:
    com.tencent.mm.am.af.awk().k((s)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void aF(bl parambl)
  {
    AppMethodBeat.i(124676);
    if (parambl == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    com.tencent.mm.am.af.awk().wc(parambl.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static void aHx(String paramString)
  {
    FeN = paramString;
  }
  
  private static long ax(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fto, "");
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
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fto, str);
      ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  private static dau bB(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    dau localdau = new dau();
    localdau.Esz = new dap();
    localdau.Esz.Esl = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localdau.Esz.Esn = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localdau.Esz.Esm = new dar();
    localdau.Esz.Esm.Esv = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localdau.Esz.Esm.mAQ = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localdau.Esz.Esm.mBV = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localdau.Esz.Esm.Esu = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localdau.Esz.Esm.ijP = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new dat();
    Object localObject3 = new ahj();
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
        ((ahj)localObject3).DjZ.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((ahj)localObject3).Dka = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((dat)localObject2).Esy = ((ahj)localObject3);
    localdau.Esz.Esr = ((dat)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new daq();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((daq)localObject2).Title = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (bt.isNullOrNil(((daq)localObject2).Title)) {
          break label885;
        }
        ((daq)localObject2).CHJ = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((daq)localObject2).CHL = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((daq)localObject2).CHN = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((daq)localObject2).CHO = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((daq)localObject2).CHP = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((daq)localObject2).gKq = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((daq)localObject2).CHW = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((daq)localObject2).CHX = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((daq)localObject2).CHY = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((daq)localObject2).CHZ = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((daq)localObject2).CreateTime = bt.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((daq)localObject2).Est = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        localdau.Esz.Eso.add(localObject2);
        i += 1;
        break;
      }
    }
    label885:
    localdau.pos = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localdau.weight = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localdau.EsA = bt.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localdau.style = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    AppMethodBeat.o(124669);
    return localdau;
  }
  
  public static boolean bBQ()
  {
    AppMethodBeat.i(124680);
    if (FeW != null)
    {
      bool = FeW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    int i = ax.aFD("brandService").decodeInt("BizTimeLineOpenStatus", -1);
    if (i == 1) {
      FeW = Boolean.TRUE;
    }
    while (FeW != null)
    {
      bool = FeW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
      if (i == 0) {
        FeW = Boolean.FALSE;
      }
    }
    if ((((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftp, Integer.valueOf(0))).intValue() & 0x1) > 0)
    {
      FeW = Boolean.TRUE;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      bool = FeW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    i = com.tencent.mm.am.af.awk().eKa();
    if (i > 4000)
    {
      FeW = Boolean.FALSE;
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen too match data totalCount %d", new Object[] { Integer.valueOf(i) });
      bool = FeW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmy, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      FeW = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { FeW });
      bool = FeW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
  }
  
  public static void c(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.fTo == null) || (parama.fTo.Cxz == null))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    int i = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    Object localObject1 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if (localObject1 == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).xC(i))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(124666);
      return;
    }
    parama = z.a(parama.fTo.Cxz);
    localObject1 = ax.aFD("brandService");
    Object localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.afz();
    ((ax)localObject1).encode(com.tencent.mm.kernel.a.aeo(), parama);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 0L, 1L, false);
    long l = bt.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
    localObject1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
    int j = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    int k = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    i = 0;
    if (i < 2)
    {
      localObject2 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (parama = "";; parama = Integer.valueOf(1))
      {
        localObject2 = parama;
        parama = (String)paramMap.get((String)localObject2 + ".AppMsg.Title");
        if (bt.isNullOrNil(parama)) {
          break label468;
        }
        localObject2 = (String)paramMap.get((String)localObject2 + ".AppMsg.ContentUrl");
        parama = x.aCL(parama);
        localObject2 = x.aCL((String)localObject2);
        com.tencent.mm.plugin.report.service.h.vKh.f(18106, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), parama, localObject2 });
        i += 1;
        break;
      }
    }
    label468:
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { localObject1, Long.valueOf(l) });
    AppMethodBeat.o(124666);
  }
  
  public static void d(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(124671);
    ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineSingleMsg by SysCmd, values：" + paramMap + " addMsgInfo：" + parama);
    parama = z.a(parama.fTo.Cxz);
    paramMap = (String)paramMap.get(".sysmsg.BizMsgRejectRecommend.Content");
    if ((TextUtils.isEmpty(parama)) || (TextUtils.isEmpty(paramMap)))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "info content == null");
      AppMethodBeat.o(124671);
      return;
    }
    kZ(parama, paramMap);
    AppMethodBeat.o(124671);
  }
  
  public static boolean eKd()
  {
    return FeU;
  }
  
  public static void eKe()
  {
    AppMethodBeat.i(124667);
    com.tencent.e.h.Iye.f(new u.3(), "BizInsertTlRecCardThread");
    AppMethodBeat.o(124667);
  }
  
  public static void eKf()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(124668);
      return;
    }
    Object localObject2 = ax.aFD("brandService");
    Object localObject1 = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.g.afz();
    Object localObject3 = com.tencent.mm.kernel.a.aeo();
    localObject1 = ((ax)localObject2).decodeString((String)localObject3);
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(124668);
      return;
    }
    int i = ((String)localObject1).indexOf("<sysmsg");
    if (i != -1)
    {
      localObject4 = bw.K(((String)localObject1).substring(i), "sysmsg");
      if (localObject4 == null)
      {
        ad.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
        AppMethodBeat.o(124668);
      }
    }
    else
    {
      AppMethodBeat.o(124668);
      return;
    }
    localObject1 = com.tencent.mm.am.af.awk().eJU();
    if (localObject1 == null)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      AppMethodBeat.o(124668);
      return;
    }
    if (((s)localObject1).field_status == 4)
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
      AppMethodBeat.o(124668);
      return;
    }
    ((ax)localObject2).encode((String)localObject3, "");
    localObject2 = bB((Map)localObject4);
    if (!a((dau)localObject2))
    {
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      AppMethodBeat.o(124668);
      return;
    }
    i = ((dau)localObject2).pos;
    long l1 = ((dau)localObject2).weight;
    if ((i < 0) && (l1 < 0L))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
      AppMethodBeat.o(124668);
      return;
    }
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) });
    long l2 = com.tencent.mm.am.af.awk().eJX();
    if (com.tencent.mm.am.af.awk().we(l2 << 32) != null)
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard groupId %d already has a recommend msg", new Object[] { Long.valueOf(l2) });
      AppMethodBeat.o(124668);
      return;
    }
    localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(((dau)localObject2).Esz.Esm.mAQ);
    if ((localObject3 != null) && (com.tencent.mm.n.b.ls(((au)localObject3).field_type)))
    {
      ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { ((dau)localObject2).Esz.Esm.mAQ });
      AppMethodBeat.o(124668);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 1L, 1L, false);
    localObject3 = new s();
    ((s)localObject3).field_msgId = com.tencent.mm.am.af.awk().eKc();
    ((s)localObject3).field_msgSvrId = 0L;
    ((s)localObject3).field_type = 620757041;
    ((s)localObject3).field_talker = ((dau)localObject2).Esz.Esm.mAQ;
    ((s)localObject3).field_talkerId = 0;
    ((s)localObject1).field_createTime -= 1000L;
    ((s)localObject3).jC(1);
    ((s)localObject3).field_status = 3;
    ((s)localObject3).b((dau)localObject2);
    if (l1 >= 0L) {
      l1 = Math.min(l1, wf(((s)localObject1).field_orderFlag));
    }
    for (;;)
    {
      ((s)localObject3).field_orderFlag = (l1 << 24 & 0xFF000000 | l2 << 32 | ax(l2, ((s)localObject3).field_createTime / 1000L));
      l((s)localObject3);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s", new Object[] { Boolean.valueOf(com.tencent.mm.am.af.awk().j((s)localObject3)), ((dau)localObject2).Esz.Esm.mAQ });
      AppMethodBeat.o(124668);
      return;
      if (i != 0) {
        break;
      }
      l1 = wf(((s)localObject1).field_orderFlag);
      ((s)localObject1).field_createTime += 1000L;
    }
    Object localObject4 = com.tencent.mm.am.af.awk();
    localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(i - 1));
    Cursor localCursor = ((t)localObject4).gPa.a((String)localObject1, null, 0);
    localObject1 = null;
    if (localCursor.moveToFirst())
    {
      localObject1 = new s();
      ((s)localObject1).convertFrom(localCursor);
    }
    localCursor.close();
    if (localObject1 == null)
    {
      l1 = ((t)localObject4).eJX();
      localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l1 << 32) + " order by orderFlag asc limit 1";
      localObject4 = ((t)localObject4).gPa.a((String)localObject1, null, 0);
      localObject1 = null;
      if (((Cursor)localObject4).moveToFirst())
      {
        localObject1 = new s();
        ((s)localObject1).convertFrom((Cursor)localObject4);
      }
      ((Cursor)localObject4).close();
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
        l1 = 0L;
        break;
      }
      l1 = wf(((s)localObject1).field_orderFlag);
      ((s)localObject1).field_createTime -= 1000L;
      break;
    }
  }
  
  public static void eKg()
  {
    AppMethodBeat.i(124678);
    if (!bBQ())
    {
      AppMethodBeat.o(124678);
      return;
    }
    bh localbh = ((k)com.tencent.mm.kernel.g.ab(k.class)).apR();
    am localam = localbh.aIn("officialaccounts");
    if (localam == null) {
      localam = new am("officialaccounts");
    }
    label288:
    label472:
    label991:
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = com.tencent.mm.am.af.awl().eJU();
      Object localObject2 = com.tencent.mm.am.af.awk().eJU();
      Object localObject1 = com.tencent.mm.am.af.awk().gPa.a("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null, 0);
      if (((Cursor)localObject1).moveToFirst()) {}
      label746:
      for (long l1 = ((Cursor)localObject1).getLong(0);; l1 = 0L)
      {
        ((Cursor)localObject1).close();
        long l2;
        if (localObject3 != null)
        {
          l2 = ((s)localObject3).field_createTime;
          if (localObject2 == null) {
            break label1010;
          }
        }
        label366:
        label1010:
        for (int i = com.tencent.mm.am.af.awk().wb(((s)localObject2).field_orderFlag);; i = 0)
        {
          int j = com.tencent.mm.am.af.awl().bIR();
          if (j > 0) {
            if (l2 > l1)
            {
              localam.lv(16);
              localam.jT(j);
              localObject1 = localObject3;
            }
          }
          for (;;)
          {
            if ((localObject1 != null) && (((s)localObject1).field_msgId != 0L)) {
              break label288;
            }
            ad.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
            localam.eLf();
            if (!bool) {
              localbh.a(localam, localam.field_username);
            }
            AppMethodBeat.o(124678);
            return;
            l2 = 0L;
            break;
            localam.lu(16);
            localam.jT(i);
            localObject1 = localObject2;
            continue;
            localam.lu(16);
            localam.jT(i);
            localObject1 = localObject2;
          }
          if ((localObject1 == localObject2) && (((s)localObject1).field_placeTop == 1))
          {
            localam.lu(32);
            if (localObject1 == localObject3)
            {
              l3 = ((s)localObject1).field_msgId;
              if (FeO == 0L) {
                FeO = aj.eFE().getLong("biz_time_line_last_notify_msg_id", -1L);
              }
              if (l3 != FeO) {
                break label885;
              }
              localam.lv(64);
            }
            if (((s)localObject1).eJP())
            {
              localObject2 = new bl();
              ((bl)localObject2).setContent(((com.tencent.mm.g.c.am)localObject1).esh);
              ((bl)localObject2).nY(((s)localObject1).field_talker);
              ((bl)localObject2).setStatus(3);
              ((bl)localObject2).kY(((s)localObject1).field_createTime);
            }
            if (!((s)localObject1).eJM()) {
              break label895;
            }
            localObject2 = new bl();
            ((bl)localObject2).setContent(((com.tencent.mm.g.c.am)localObject1).esh);
            ((bl)localObject2).nY(((s)localObject1).field_talker);
            ((bl)localObject2).setStatus(3);
            ((bl)localObject2).kY(((s)localObject1).field_createTime);
            long l3 = Math.min(ce.asR(), localam.field_conversationTime);
            l1 = Math.max(l2, l1);
            if ((((du)localObject2).field_msgId <= 0L) && (!((s)localObject1).eJP()) && (!((s)localObject1).eJM())) {
              break label941;
            }
            localam.aG((bl)localObject2);
            localam.setContent(((du)localObject2).field_talker + ":" + ((du)localObject2).field_content);
            localam.nK(Integer.toString(((bl)localObject2).getType()));
            Object localObject4 = localbh.Lu();
            if (localObject4 != null)
            {
              localObject3 = new PString();
              PString localPString = new PString();
              PInt localPInt = new PInt();
              ((bl)localObject2).nY("officialaccounts");
              ((bl)localObject2).setContent(localam.field_content);
              ((bh.b)localObject4).a((bl)localObject2, (PString)localObject3, localPString, localPInt, true);
              if (((s)localObject1).eJP())
              {
                localObject4 = aj.getResources().getString(2131756584);
                ((PString)localObject3).value = String.format(((PString)localObject3).value, new Object[] { localObject4 });
              }
              if (((s)localObject1).eJM())
              {
                localObject1 = ((s)localObject1).eJS();
                if ((localObject1 == null) || (((dau)localObject1).Esz == null) || (bt.isNullOrNil(((dau)localObject1).Esz.Esl))) {
                  break label924;
                }
                ((PString)localObject3).value = ((dau)localObject1).Esz.Esl;
              }
              localam.nL(((PString)localObject3).value);
              localam.nM(localPString.value);
              localam.jW(localPInt.value);
            }
            localam.kS(Math.max(l3, l1));
            if (!bool) {
              break label991;
            }
          }
          for (l1 = localbh.e(localam);; l1 = localbh.a(localam, localam.field_username))
          {
            l2 = ((du)localObject2).field_msgId;
            localObject1 = ax.aFD("brandService");
            if (localObject1 != null) {
              ((ax)localObject1).encode("BizLastMsgId", l2);
            }
            ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localam.field_conversationTime) });
            AppMethodBeat.o(124678);
            return;
            localam.lv(32);
            break;
            label885:
            localam.lu(64);
            break label366;
            label895:
            localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(((s)localObject1).field_msgId);
            break label472;
            ((PString)localObject3).value = aj.getResources().getString(2131756587);
            break label746;
            if (((s)localObject1).field_type != 10002)
            {
              localam.eLf();
              ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((s)localObject1).field_talker });
              break label776;
            }
            ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is system biz reject msg");
            break label776;
          }
        }
      }
    }
  }
  
  private static boolean eKh()
  {
    AppMethodBeat.i(124681);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bu.eGT()))
    {
      AppMethodBeat.o(124681);
      return true;
    }
    if (!bBQ())
    {
      AppMethodBeat.o(124681);
      return false;
    }
    if (FeX != null)
    {
      bool = FeX.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmz, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      FeX = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizMsgResortOpen open %b", new Object[] { FeX });
      bool = FeX.booleanValue();
      AppMethodBeat.o(124681);
      return bool;
    }
  }
  
  public static boolean eKi()
  {
    AppMethodBeat.i(176159);
    if (FeZ != null)
    {
      bool = FeZ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmD, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      FeZ = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { FeZ });
      bool = FeZ.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static boolean eKj()
  {
    AppMethodBeat.i(124682);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bu.eGT()))
    {
      AppMethodBeat.o(124682);
      return true;
    }
    if (!eKh())
    {
      AppMethodBeat.o(124682);
      return false;
    }
    if (Ffa != null)
    {
      bool = Ffa.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmA, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ffa = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { Ffa });
      bool = Ffa.booleanValue();
      AppMethodBeat.o(124682);
      return bool;
    }
  }
  
  private static boolean eKk()
  {
    AppMethodBeat.i(124683);
    if (ax.aFD("brandService").decodeInt("BizTimeLineReSortMsgCheck", 1) == 1)
    {
      AppMethodBeat.o(124683);
      return true;
    }
    AppMethodBeat.o(124683);
    return false;
  }
  
  public static int getSessionId()
  {
    return dcS;
  }
  
  private static void kZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124672);
    s locals = new s();
    locals.field_msgSvrId = 0L;
    locals.field_content = paramString1;
    locals.field_type = 10002;
    locals.field_talker = "weixinguanhaozhushou";
    locals.field_talkerId = 0;
    locals.field_createTime = System.currentTimeMillis();
    locals.jC(1);
    locals.mZ(paramString2);
    locals.field_status = 3;
    int i = 0;
    if (i < 4)
    {
      Cursor localCursor = com.tencent.mm.am.af.awl().gPa.a("SELECT * FROM BizTimeLineSingleMsgInfo order by bizRejectMsgId DESC limit 1", null, 0);
      paramString2 = null;
      if (localCursor.moveToFirst())
      {
        paramString2 = new s();
        paramString2.convertFrom(localCursor);
      }
      localCursor.close();
      if (paramString2 == null) {
        locals.field_bizRejectMsgId = 1L;
      }
      for (locals.field_msgId = 1000000001L;; locals.field_msgId = (1000000000L + paramString2.field_bizRejectMsgId + 1L))
      {
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "sysmsg get. msgId = %s, msgSvrId = %s, content = %s, createTime = %s", new Object[] { Long.valueOf(locals.field_msgId), Long.valueOf(locals.field_msgSvrId), locals.field_content, Long.valueOf(locals.field_createTime) });
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", paramString1);
        boolean bool = com.tencent.mm.am.af.awl().j(locals);
        ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "insertSingleMsgWithRetry: result : %s, tryTime = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
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
  
  private static void l(s params)
  {
    AppMethodBeat.i(124670);
    while (com.tencent.mm.am.af.awk().vT(params.field_orderFlag) != null) {
      params.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static void uZ(boolean paramBoolean)
  {
    FeT = paramBoolean;
  }
  
  private static long wf(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean wg(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (com.tencent.mm.am.af.awk().vZ(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (com.tencent.mm.am.af.awk().eJJ() <= com.tencent.mm.am.af.awk().eJX()) {
      com.tencent.mm.am.af.awk().eJY();
    }
    com.tencent.mm.am.af.awk().vY(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void wh(long paramLong)
  {
    AppMethodBeat.i(124679);
    FeO = paramLong;
    aj.eFE().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */