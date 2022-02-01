package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static String TAG;
  private static int vrA;
  private static int vrB;
  public static int vrC;
  public static int vrD;
  public static int vrE;
  public static int vrF;
  public static int vrG;
  public static int vrH;
  public static int vrI;
  public static int vrJ;
  public static int vrK;
  public static int vrL;
  public static int vrM;
  public static int vrN;
  public static int vrz;
  public int status;
  public com.tencent.mm.ak.g vrO;
  public boolean vrP;
  public au vrQ;
  
  static
  {
    AppMethodBeat.i(66225);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    vrz = 5000;
    vrA = 30000;
    vrB = 5000;
    vrC = 0;
    vrD = 24;
    vrE = 4;
    vrF = 8;
    vrG = 23;
    vrH = 6;
    vrI = 5;
    vrJ = 20;
    vrK = 20000;
    vrL = 20001;
    vrM = 10001;
    vrN = vrB;
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNg, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      vrN = i;
      if (i == 0) {
        vrN = vrB;
      }
    }
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNi, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        vrA = i;
      }
    }
    AppMethodBeat.o(66225);
  }
  
  public g()
  {
    AppMethodBeat.i(66216);
    this.status = 0;
    this.vrO = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(66214);
        Map localMap;
        if (((paramAnonymousn instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousn = (d)paramAnonymousn;
          g.access$002(paramAnonymousn.vsC);
          if (g.vrN == 0) {
            g.access$002(g.vrB);
          }
          ac.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramAnonymousn.vsD, paramAnonymousn.vsB });
          if ((bs.isNullOrNil(paramAnonymousn.vsB)) || (bs.isNullOrNil(paramAnonymousn.vsD))) {
            break label317;
          }
          if (g.ig(paramAnonymousn.vsD, paramAnonymousn.vsB))
          {
            ac.i(g.TAG, "from cgi");
            if (bv.L(paramAnonymousn.vsB, "sysmsg") == null)
            {
              AppMethodBeat.o(66214);
              return;
            }
            h.wUl.idkeyStat(135L, 71L, 1L, true);
            k.dlZ();
            paramAnonymousString = k.dma();
            paramAnonymousn = paramAnonymousn.vsB;
            ac.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
            if (!TextUtils.isEmpty(paramAnonymousn))
            {
              localMap = bv.L(paramAnonymousn, "sysmsg");
              if (localMap == null) {
                break label328;
              }
              localMap.get(".sysmsg.paymsg.ack_key");
            }
          }
        }
        label317:
        label328:
        for (paramAnonymousInt1 = bs.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; paramAnonymousInt1 = -1)
        {
          if ((com.tencent.mm.plugin.offline.c.a.dnr()) && (paramAnonymousInt1 != 7) && (paramAnonymousInt1 != 10))
          {
            ac.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
            paramAnonymousString.aoB(paramAnonymousn);
            paramAnonymousString.aoC(paramAnonymousn);
          }
          for (;;)
          {
            ac.i(g.TAG, "mIntercal=" + g.vrN);
            paramAnonymousString = g.a(g.this);
            long l = g.vrN;
            paramAnonymousString.au(l, l);
            AppMethodBeat.o(66214);
            return;
            ac.i(g.TAG, "OfflineGetMsgLogic msg is null");
          }
        }
      }
    };
    this.vrP = true;
    this.vrQ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66215);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.g.agM())
          {
            au localau = g.a(g.this);
            long l = g.vrz;
            localau.au(l, l);
            AppMethodBeat.o(66215);
            return false;
          }
          if ((com.tencent.mm.plugin.offline.c.a.dnr()) && (com.tencent.mm.plugin.offline.c.a.dmQ())) {
            g.dlW();
          }
        }
        AppMethodBeat.o(66215);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this.vrO);
    AppMethodBeat.o(66216);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    AppMethodBeat.i(66217);
    if (paramr != null) {
      ac.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(vrK));
    ((HashSet)localObject).add(Integer.valueOf(vrH));
    ((HashSet)localObject).add(Integer.valueOf(vrI));
    ((HashSet)localObject).add(Integer.valueOf(vrE));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      ac.i((String)localObject, bool);
      if (paramr != null) {
        ac.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      AppMethodBeat.o(66217);
      return true;
    }
    ac.i(TAG, "isOrderClosed false");
    if (paramr != null) {
      ac.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(66217);
      return false;
      ac.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    AppMethodBeat.i(66220);
    int i = paramInt;
    if (paramInt == vrE) {
      i = vrK;
    }
    boolean bool = gz(paramr.field_status, i);
    ac.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.dlZ();
      k.dmd().c(paramr);
    }
    AppMethodBeat.o(66220);
    return bool;
  }
  
  public static int dlT()
  {
    return vrA;
  }
  
  public static void dlU()
  {
    AppMethodBeat.i(66222);
    ac.i(TAG, "endAllOldOrder");
    k.dlZ();
    com.tencent.mm.plugin.offline.b.a locala = k.dmd();
    ac.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.dmh()), locala.dmg() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.db.a((String)localObject, null, 2);
    long l2 = 0L;
    long l1;
    if (localObject == null)
    {
      ac.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l1 = l2;
      if (l1 - 10L <= 0L) {
        break label313;
      }
      localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l1 - 10L) });
      ac.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l1), localObject });
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
    }
    for (;;)
    {
      localObject = "UPDATE OfflineOrderStatus SET status=" + vrK + " where status!=" + vrK;
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
      ac.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l1) });
    }
  }
  
  public static int dlV()
  {
    return vrN;
  }
  
  public static void ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(66221);
    if (!bs.isNullOrNil(paramString))
    {
      k.dlZ();
      r localr = k.dmd().aoD(paramString);
      if (localr != null)
      {
        a(localr, paramInt);
        AppMethodBeat.o(66221);
        return;
      }
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = paramInt;
      k.dlZ();
      k.dmd().c(localr);
    }
    AppMethodBeat.o(66221);
  }
  
  private static boolean gz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66219);
    ac.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrC)
    {
      AppMethodBeat.o(66219);
      return true;
    }
    if (paramInt1 == vrD)
    {
      if (paramInt2 != vrD)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrH)
    {
      if (paramInt2 == vrK)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrI)
    {
      if (paramInt2 == vrK)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrE)
    {
      if (paramInt2 == vrK)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrJ)
    {
      if (paramInt2 == vrK)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if ((paramInt1 == vrF) || (paramInt1 == vrG))
    {
      if ((paramInt2 == vrH) || (paramInt2 == vrK))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == vrM)
    {
      if ((paramInt2 == vrH) || (paramInt2 == vrK))
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
  
  public static boolean ig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66218);
    int i;
    Object localObject1;
    if (bs.isNullOrNil(paramString2))
    {
      ac.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1169;
      }
      k.dlZ();
      localObject1 = k.dmd().dmf();
      paramString2 = bv.L(paramString2, "sysmsg");
      i = bs.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1044;
      }
      h.wUl.idkeyStat(135L, 58L, 1L, true);
      label98:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1123;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      ac.i(TAG, "dealMsg true");
      AppMethodBeat.o(66218);
      return true;
      localObject1 = bv.L(paramString2, "sysmsg");
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = bs.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.dlZ();
      r localr1 = k.dmd().aoD(str3);
      k.dlZ();
      r localr2 = k.dmd().dmf();
      boolean bool2 = a(localr2);
      label241:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        h.wUl.idkeyStat(135L, 63L, 1L, true);
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
        ac.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label555;
        }
        if (localr2 != null) {
          break label452;
        }
        ac.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        h.wUl.idkeyStat(135L, 64L, 1L, true);
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
        ac.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ac.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label555:
      if (a(localr1))
      {
        ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        ac.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.dlZ();
        k.dmd().aoE(str3);
        i = 0;
        break;
      }
      ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (gz(localr2.field_status, j))
        {
          ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          ac.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.dlZ();
          k.dmd().aoE(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ac.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.dlZ();
      k.dmd().aoE(str3);
      i = 0;
      break;
      label1044:
      if (i == 6)
      {
        h.wUl.idkeyStat(135L, 59L, 1L, true);
        break label98;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        h.wUl.idkeyStat(135L, 60L, 1L, true);
        break label98;
      }
      if (i != 23) {
        break label98;
      }
      h.wUl.idkeyStat(135L, 66L, 1L, true);
      break label98;
      label1123:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!bs.isNullOrNil(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = vrC;
      a((r)localObject1, i);
    }
    label1169:
    ac.i(TAG, "dealMsg false");
    AppMethodBeat.o(66218);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(66223);
    if (com.tencent.mm.plugin.offline.c.a.dnr())
    {
      ac.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.vrQ.eVs());
      if (!this.vrQ.eVs())
      {
        h.wUl.idkeyStat(135L, 62L, 1L, true);
        this.vrQ.stopTimer();
      }
    }
    AppMethodBeat.o(66223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */