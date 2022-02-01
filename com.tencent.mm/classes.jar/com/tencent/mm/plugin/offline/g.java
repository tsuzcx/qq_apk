package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static String TAG;
  public static int wMC;
  private static int wMD;
  private static int wME;
  public static int wMF;
  public static int wMG;
  public static int wMH;
  public static int wMI;
  public static int wMJ;
  public static int wMK;
  public static int wML;
  public static int wMM;
  public static int wMN;
  public static int wMO;
  public static int wMP;
  public static int wMQ;
  public int status;
  public f wMR;
  public boolean wMS;
  public aw wMT;
  
  static
  {
    AppMethodBeat.i(66225);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    wMC = 5000;
    wMD = 30000;
    wME = 5000;
    wMF = 0;
    wMG = 24;
    wMH = 4;
    wMI = 8;
    wMJ = 23;
    wMK = 6;
    wML = 5;
    wMM = 20;
    wMN = 20000;
    wMO = 20001;
    wMP = 10001;
    wMQ = wME;
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITW, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      wMQ = i;
      if (i == 0) {
        wMQ = wME;
      }
    }
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITY, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        wMD = i;
      }
    }
    AppMethodBeat.o(66225);
  }
  
  public g()
  {
    AppMethodBeat.i(66216);
    this.status = 0;
    this.wMR = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(66214);
        Map localMap;
        if (((paramAnonymousn instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousn = (d)paramAnonymousn;
          g.access$002(paramAnonymousn.wNF);
          if (g.wMQ == 0) {
            g.access$002(g.wME);
          }
          ae.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramAnonymousn.wNG, paramAnonymousn.wNE });
          if ((bu.isNullOrNil(paramAnonymousn.wNE)) || (bu.isNullOrNil(paramAnonymousn.wNG))) {
            break label317;
          }
          if (g.ix(paramAnonymousn.wNG, paramAnonymousn.wNE))
          {
            ae.i(g.TAG, "from cgi");
            if (bx.M(paramAnonymousn.wNE, "sysmsg") == null)
            {
              AppMethodBeat.o(66214);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 71L, 1L, true);
            k.dzG();
            paramAnonymousString = k.dzH();
            paramAnonymousn = paramAnonymousn.wNE;
            ae.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
            if (!TextUtils.isEmpty(paramAnonymousn))
            {
              localMap = bx.M(paramAnonymousn, "sysmsg");
              if (localMap == null) {
                break label328;
              }
              localMap.get(".sysmsg.paymsg.ack_key");
            }
          }
        }
        label317:
        label328:
        for (paramAnonymousInt1 = bu.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; paramAnonymousInt1 = -1)
        {
          if ((com.tencent.mm.plugin.offline.c.a.dAZ()) && (paramAnonymousInt1 != 7) && (paramAnonymousInt1 != 10))
          {
            ae.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
            paramAnonymousString.auQ(paramAnonymousn);
            paramAnonymousString.auR(paramAnonymousn);
          }
          for (;;)
          {
            ae.i(g.TAG, "mIntercal=" + g.wMQ);
            paramAnonymousString = g.a(g.this);
            long l = g.wMQ;
            paramAnonymousString.ay(l, l);
            AppMethodBeat.o(66214);
            return;
            ae.i(g.TAG, "OfflineGetMsgLogic msg is null");
          }
        }
      }
    };
    this.wMS = true;
    this.wMT = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66215);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.g.ajM())
          {
            aw localaw = g.a(g.this);
            long l = g.wMC;
            localaw.ay(l, l);
            AppMethodBeat.o(66215);
            return false;
          }
          if ((com.tencent.mm.plugin.offline.c.a.dAZ()) && (com.tencent.mm.plugin.offline.c.a.dAy())) {
            g.dzD();
          }
        }
        AppMethodBeat.o(66215);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(385, this.wMR);
    AppMethodBeat.o(66216);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    AppMethodBeat.i(66217);
    if (paramr != null) {
      ae.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(wMN));
    ((HashSet)localObject).add(Integer.valueOf(wMK));
    ((HashSet)localObject).add(Integer.valueOf(wML));
    ((HashSet)localObject).add(Integer.valueOf(wMH));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      ae.i((String)localObject, bool);
      if (paramr != null) {
        ae.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      AppMethodBeat.o(66217);
      return true;
    }
    ae.i(TAG, "isOrderClosed false");
    if (paramr != null) {
      ae.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(66217);
      return false;
      ae.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    AppMethodBeat.i(66220);
    int i = paramInt;
    if (paramInt == wMH) {
      i = wMN;
    }
    boolean bool = gS(paramr.field_status, i);
    ae.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.dzG();
      k.dzK().c(paramr);
    }
    AppMethodBeat.o(66220);
    return bool;
  }
  
  public static int dzA()
  {
    return wMD;
  }
  
  public static void dzB()
  {
    AppMethodBeat.i(66222);
    ae.i(TAG, "endAllOldOrder");
    k.dzG();
    com.tencent.mm.plugin.offline.b.a locala = k.dzK();
    ae.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.dzO()), locala.dzN() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.db.a((String)localObject, null, 2);
    long l2 = 0L;
    long l1;
    if (localObject == null)
    {
      ae.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l1 = l2;
      if (l1 - 10L <= 0L) {
        break label313;
      }
      localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l1 - 10L) });
      ae.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l1), localObject });
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
    }
    for (;;)
    {
      localObject = "UPDATE OfflineOrderStatus SET status=" + wMN + " where status!=" + wMN;
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
      AppMethodBeat.o(66222);
      return;
      ((Cursor)localObject).moveToFirst();
      l1 = l2;
      if (!((Cursor)localObject).isAfterLast())
      {
        l1 = l2;
        if (((Cursor)localObject).getColumnCount() > 0) {
          l1 = ((Cursor)localObject).getLong(0);
        }
      }
      ((Cursor)localObject).close();
      break;
      label313:
      ae.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l1) });
    }
  }
  
  public static int dzC()
  {
    return wMQ;
  }
  
  public static void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(66221);
    if (!bu.isNullOrNil(paramString))
    {
      k.dzG();
      r localr = k.dzK().auS(paramString);
      if (localr != null)
      {
        a(localr, paramInt);
        AppMethodBeat.o(66221);
        return;
      }
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = paramInt;
      k.dzG();
      k.dzK().c(localr);
    }
    AppMethodBeat.o(66221);
  }
  
  private static boolean gS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66219);
    ae.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wMF)
    {
      AppMethodBeat.o(66219);
      return true;
    }
    if (paramInt1 == wMG)
    {
      if (paramInt2 != wMG)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wMK)
    {
      if (paramInt2 == wMN)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wML)
    {
      if (paramInt2 == wMN)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wMH)
    {
      if (paramInt2 == wMN)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wMM)
    {
      if (paramInt2 == wMN)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if ((paramInt1 == wMI) || (paramInt1 == wMJ))
    {
      if ((paramInt2 == wMK) || (paramInt2 == wMN))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wMP)
    {
      if ((paramInt2 == wMK) || (paramInt2 == wMN))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    AppMethodBeat.o(66219);
    return false;
  }
  
  public static boolean ix(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66218);
    int i;
    Object localObject1;
    if (bu.isNullOrNil(paramString2))
    {
      ae.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1169;
      }
      k.dzG();
      localObject1 = k.dzK().dzM();
      paramString2 = bx.M(paramString2, "sysmsg");
      i = bu.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1044;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 58L, 1L, true);
      label98:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1123;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      ae.i(TAG, "dealMsg true");
      AppMethodBeat.o(66218);
      return true;
      localObject1 = bx.M(paramString2, "sysmsg");
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = bu.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.dzG();
      r localr1 = k.dzK().auS(str3);
      k.dzG();
      r localr2 = k.dzK().dzM();
      boolean bool2 = a(localr2);
      label241:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 63L, 1L, true);
        if (localr2 == null) {
          break label368;
        }
        str1 = TAG;
        localObject3 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
        localObject2 = new Object[3];
        localObject2[0] = localr2.field_reqkey;
        localObject2[1] = Integer.valueOf(localr2.field_status);
        i = 2;
        bool1 = bool2;
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1[i] = Boolean.valueOf(bool1);
        ae.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label555;
        }
        if (localr2 != null) {
          break label452;
        }
        ae.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 64L, 1L, true);
        break label241;
        label368:
        str1 = TAG;
        String str2 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
        localObject1 = new Object[2];
        localObject1[0] = Boolean.valueOf(bool2);
        i = 1;
        if (localr1 == null)
        {
          bool1 = true;
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = str2;
        }
        else
        {
          bool1 = false;
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = str2;
        }
      }
      label452:
      if (bool2)
      {
        ae.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ae.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label555:
      if (a(localr1))
      {
        ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        ae.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.dzG();
        k.dzK().auT(str3);
        i = 0;
        break;
      }
      ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (gS(localr2.field_status, j))
        {
          ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          ae.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.dzG();
          k.dzK().auT(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ae.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.dzG();
      k.dzK().auT(str3);
      i = 0;
      break;
      label1044:
      if (i == 6)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 59L, 1L, true);
        break label98;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 60L, 1L, true);
        break label98;
      }
      if (i != 23) {
        break label98;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 66L, 1L, true);
      break label98;
      label1123:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!bu.isNullOrNil(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = wMF;
      a((r)localObject1, i);
    }
    label1169:
    ae.i(TAG, "dealMsg false");
    AppMethodBeat.o(66218);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(66223);
    if (com.tencent.mm.plugin.offline.c.a.dAZ())
    {
      ae.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.wMT.foU());
      if (!this.wMT.foU())
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 62L, 1L, true);
        this.wMT.stopTimer();
      }
    }
    AppMethodBeat.o(66223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */