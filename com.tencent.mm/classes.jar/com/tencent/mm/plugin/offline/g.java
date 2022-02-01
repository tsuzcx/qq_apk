package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static String TAG;
  public static int wwR;
  private static int wwS;
  private static int wwT;
  public static int wwU;
  public static int wwV;
  public static int wwW;
  public static int wwX;
  public static int wwY;
  public static int wwZ;
  public static int wxa;
  public static int wxb;
  public static int wxc;
  public static int wxd;
  public static int wxe;
  public static int wxf;
  public int status;
  public f wxg;
  public boolean wxh;
  public av wxi;
  
  static
  {
    AppMethodBeat.i(66225);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    wwR = 5000;
    wwS = 30000;
    wwT = 5000;
    wwU = 0;
    wwV = 24;
    wwW = 4;
    wwX = 8;
    wwY = 23;
    wwZ = 6;
    wxa = 5;
    wxb = 20;
    wxc = 20000;
    wxd = 20001;
    wxe = 10001;
    wxf = wwT;
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izx, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      wxf = i;
      if (i == 0) {
        wxf = wwT;
      }
    }
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izz, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        wwS = i;
      }
    }
    AppMethodBeat.o(66225);
  }
  
  public g()
  {
    AppMethodBeat.i(66216);
    this.status = 0;
    this.wxg = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(66214);
        Map localMap;
        if (((paramAnonymousn instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousn = (d)paramAnonymousn;
          g.access$002(paramAnonymousn.wxU);
          if (g.wxf == 0) {
            g.access$002(g.wwT);
          }
          ad.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramAnonymousn.wxV, paramAnonymousn.wxT });
          if ((bt.isNullOrNil(paramAnonymousn.wxT)) || (bt.isNullOrNil(paramAnonymousn.wxV))) {
            break label317;
          }
          if (g.ir(paramAnonymousn.wxV, paramAnonymousn.wxT))
          {
            ad.i(g.TAG, "from cgi");
            if (bw.M(paramAnonymousn.wxT, "sysmsg") == null)
            {
              AppMethodBeat.o(66214);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 71L, 1L, true);
            k.dwq();
            paramAnonymousString = k.dwr();
            paramAnonymousn = paramAnonymousn.wxT;
            ad.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
            if (!TextUtils.isEmpty(paramAnonymousn))
            {
              localMap = bw.M(paramAnonymousn, "sysmsg");
              if (localMap == null) {
                break label328;
              }
              localMap.get(".sysmsg.paymsg.ack_key");
            }
          }
        }
        label317:
        label328:
        for (paramAnonymousInt1 = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; paramAnonymousInt1 = -1)
        {
          if ((com.tencent.mm.plugin.offline.c.a.dxJ()) && (paramAnonymousInt1 != 7) && (paramAnonymousInt1 != 10))
          {
            ad.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
            paramAnonymousString.atB(paramAnonymousn);
            paramAnonymousString.atC(paramAnonymousn);
          }
          for (;;)
          {
            ad.i(g.TAG, "mIntercal=" + g.wxf);
            paramAnonymousString = g.a(g.this);
            long l = g.wxf;
            paramAnonymousString.az(l, l);
            AppMethodBeat.o(66214);
            return;
            ad.i(g.TAG, "OfflineGetMsgLogic msg is null");
          }
        }
      }
    };
    this.wxh = true;
    this.wxi = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66215);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.g.ajx())
          {
            av localav = g.a(g.this);
            long l = g.wwR;
            localav.az(l, l);
            AppMethodBeat.o(66215);
            return false;
          }
          if ((com.tencent.mm.plugin.offline.c.a.dxJ()) && (com.tencent.mm.plugin.offline.c.a.dxi())) {
            g.dwn();
          }
        }
        AppMethodBeat.o(66215);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(385, this.wxg);
    AppMethodBeat.o(66216);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    AppMethodBeat.i(66217);
    if (paramr != null) {
      ad.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(wxc));
    ((HashSet)localObject).add(Integer.valueOf(wwZ));
    ((HashSet)localObject).add(Integer.valueOf(wxa));
    ((HashSet)localObject).add(Integer.valueOf(wwW));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      ad.i((String)localObject, bool);
      if (paramr != null) {
        ad.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      AppMethodBeat.o(66217);
      return true;
    }
    ad.i(TAG, "isOrderClosed false");
    if (paramr != null) {
      ad.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(66217);
      return false;
      ad.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    AppMethodBeat.i(66220);
    int i = paramInt;
    if (paramInt == wwW) {
      i = wxc;
    }
    boolean bool = gR(paramr.field_status, i);
    ad.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.dwq();
      k.dwu().c(paramr);
    }
    AppMethodBeat.o(66220);
    return bool;
  }
  
  public static int dwk()
  {
    return wwS;
  }
  
  public static void dwl()
  {
    AppMethodBeat.i(66222);
    ad.i(TAG, "endAllOldOrder");
    k.dwq();
    com.tencent.mm.plugin.offline.b.a locala = k.dwu();
    ad.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.dwy()), locala.dwx() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.db.a((String)localObject, null, 2);
    long l2 = 0L;
    long l1;
    if (localObject == null)
    {
      ad.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l1 = l2;
      if (l1 - 10L <= 0L) {
        break label313;
      }
      localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l1 - 10L) });
      ad.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l1), localObject });
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
    }
    for (;;)
    {
      localObject = "UPDATE OfflineOrderStatus SET status=" + wxc + " where status!=" + wxc;
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
      ad.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l1) });
    }
  }
  
  public static int dwm()
  {
    return wxf;
  }
  
  public static void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(66221);
    if (!bt.isNullOrNil(paramString))
    {
      k.dwq();
      r localr = k.dwu().atD(paramString);
      if (localr != null)
      {
        a(localr, paramInt);
        AppMethodBeat.o(66221);
        return;
      }
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = paramInt;
      k.dwq();
      k.dwu().c(localr);
    }
    AppMethodBeat.o(66221);
  }
  
  private static boolean gR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66219);
    ad.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wwU)
    {
      AppMethodBeat.o(66219);
      return true;
    }
    if (paramInt1 == wwV)
    {
      if (paramInt2 != wwV)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wwZ)
    {
      if (paramInt2 == wxc)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wxa)
    {
      if (paramInt2 == wxc)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wwW)
    {
      if (paramInt2 == wxc)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wxb)
    {
      if (paramInt2 == wxc)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if ((paramInt1 == wwX) || (paramInt1 == wwY))
    {
      if ((paramInt2 == wwZ) || (paramInt2 == wxc))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == wxe)
    {
      if ((paramInt2 == wwZ) || (paramInt2 == wxc))
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
  
  public static boolean ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66218);
    int i;
    Object localObject1;
    if (bt.isNullOrNil(paramString2))
    {
      ad.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1169;
      }
      k.dwq();
      localObject1 = k.dwu().dww();
      paramString2 = bw.M(paramString2, "sysmsg");
      i = bt.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1044;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 58L, 1L, true);
      label98:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1123;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      ad.i(TAG, "dealMsg true");
      AppMethodBeat.o(66218);
      return true;
      localObject1 = bw.M(paramString2, "sysmsg");
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = bt.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.dwq();
      r localr1 = k.dwu().atD(str3);
      k.dwq();
      r localr2 = k.dwu().dww();
      boolean bool2 = a(localr2);
      label241:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 63L, 1L, true);
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
        ad.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label555;
        }
        if (localr2 != null) {
          break label452;
        }
        ad.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 64L, 1L, true);
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
        ad.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ad.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label555:
      if (a(localr1))
      {
        ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        ad.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.dwq();
        k.dwu().atE(str3);
        i = 0;
        break;
      }
      ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (gR(localr2.field_status, j))
        {
          ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          ad.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.dwq();
          k.dwu().atE(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ad.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.dwq();
      k.dwu().atE(str3);
      i = 0;
      break;
      label1044:
      if (i == 6)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 59L, 1L, true);
        break label98;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 60L, 1L, true);
        break label98;
      }
      if (i != 23) {
        break label98;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 66L, 1L, true);
      break label98;
      label1123:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!bt.isNullOrNil(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = wwU;
      a((r)localObject1, i);
    }
    label1169:
    ad.i(TAG, "dealMsg false");
    AppMethodBeat.o(66218);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(66223);
    if (com.tencent.mm.plugin.offline.c.a.dxJ())
    {
      ad.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.wxi.fkZ());
      if (!this.wxi.fkZ())
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 62L, 1L, true);
        this.wxi.stopTimer();
      }
    }
    AppMethodBeat.o(66223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */