package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static String TAG;
  public static int pjZ;
  private static int pka;
  private static int pkb;
  public static int pkc;
  public static int pkd;
  public static int pke;
  public static int pkf;
  public static int pkg;
  public static int pkh;
  public static int pki;
  public static int pkj;
  public static int pkk;
  public static int pkl;
  public static int pkm;
  public static int pkn;
  public f pko;
  public boolean pkp;
  public ap pkq;
  public int status;
  
  static
  {
    AppMethodBeat.i(43323);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    pjZ = 5000;
    pka = 30000;
    pkb = 5000;
    pkc = 0;
    pkd = 24;
    pke = 4;
    pkf = 8;
    pkg = 23;
    pkh = 6;
    pki = 5;
    pkj = 20;
    pkk = 20000;
    pkl = 20001;
    pkm = 10001;
    pkn = pkb;
    com.tencent.mm.kernel.g.RM();
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGG, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      pkn = i;
      if (i == 0) {
        pkn = pkb;
      }
    }
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGI, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        pka = i;
      }
    }
    AppMethodBeat.o(43323);
  }
  
  public g()
  {
    AppMethodBeat.i(43314);
    this.status = 0;
    this.pko = new g.1(this);
    this.pkp = true;
    this.pkq = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(43313);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.g.RG())
          {
            ap localap = g.a(g.this);
            long l = g.pjZ;
            localap.ag(l, l);
            AppMethodBeat.o(43313);
            return false;
          }
          if ((com.tencent.mm.plugin.offline.c.a.bZX()) && (com.tencent.mm.plugin.offline.c.a.bZw())) {
            g.bYC();
          }
        }
        AppMethodBeat.o(43313);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(385, this.pko);
    AppMethodBeat.o(43314);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    AppMethodBeat.i(43315);
    if (paramr != null) {
      ab.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(pkk));
    ((HashSet)localObject).add(Integer.valueOf(pkh));
    ((HashSet)localObject).add(Integer.valueOf(pki));
    ((HashSet)localObject).add(Integer.valueOf(pke));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      ab.i((String)localObject, bool);
      if (paramr != null) {
        ab.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      AppMethodBeat.o(43315);
      return true;
    }
    ab.i(TAG, "isOrderClosed false");
    if (paramr != null) {
      ab.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(43315);
      return false;
      ab.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    AppMethodBeat.i(43318);
    int i = paramInt;
    if (paramInt == pke) {
      i = pkk;
    }
    boolean bool = eW(paramr.field_status, i);
    ab.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.bYF();
      k.bYJ().c(paramr);
    }
    AppMethodBeat.o(43318);
    return bool;
  }
  
  public static void bYA()
  {
    AppMethodBeat.i(43320);
    ab.i(TAG, "endAllOldOrder");
    k.bYF();
    com.tencent.mm.plugin.offline.b.a locala = k.bYJ();
    ab.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.bYN()), locala.bYM() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.db.a((String)localObject, null, 2);
    long l2 = 0L;
    long l1;
    if (localObject == null)
    {
      ab.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l1 = l2;
      if (l1 - 10L <= 0L) {
        break label313;
      }
      localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l1 - 10L) });
      ab.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l1), localObject });
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
    }
    for (;;)
    {
      localObject = "UPDATE OfflineOrderStatus SET status=" + pkk + " where status!=" + pkk;
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
      AppMethodBeat.o(43320);
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
      ab.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l1) });
    }
  }
  
  public static int bYB()
  {
    return pkn;
  }
  
  public static int bYz()
  {
    return pka;
  }
  
  public static void cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(43319);
    if (!bo.isNullOrNil(paramString))
    {
      k.bYF();
      r localr = k.bYJ().Wl(paramString);
      if (localr != null)
      {
        a(localr, paramInt);
        AppMethodBeat.o(43319);
        return;
      }
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = paramInt;
      k.bYF();
      k.bYJ().c(localr);
    }
    AppMethodBeat.o(43319);
  }
  
  private static boolean eW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43317);
    ab.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pkc)
    {
      AppMethodBeat.o(43317);
      return true;
    }
    if (paramInt1 == pkd)
    {
      if (paramInt2 != pkd)
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pkh)
    {
      if (paramInt2 == pkk)
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pki)
    {
      if (paramInt2 == pkk)
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pke)
    {
      if (paramInt2 == pkk)
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pkj)
    {
      if (paramInt2 == pkk)
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if ((paramInt1 == pkf) || (paramInt1 == pkg))
    {
      if ((paramInt2 == pkh) || (paramInt2 == pkk))
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    if (paramInt1 == pkm)
    {
      if ((paramInt2 == pkh) || (paramInt2 == pkk))
      {
        AppMethodBeat.o(43317);
        return true;
      }
      AppMethodBeat.o(43317);
      return false;
    }
    AppMethodBeat.o(43317);
    return false;
  }
  
  public static boolean fH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43316);
    int i;
    Object localObject1;
    if (bo.isNullOrNil(paramString2))
    {
      ab.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1169;
      }
      k.bYF();
      localObject1 = k.bYJ().bYL();
      paramString2 = br.F(paramString2, "sysmsg");
      i = bo.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1044;
      }
      h.qsU.idkeyStat(135L, 58L, 1L, true);
      label98:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1123;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      ab.i(TAG, "dealMsg true");
      AppMethodBeat.o(43316);
      return true;
      localObject1 = br.F(paramString2, "sysmsg");
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = bo.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.bYF();
      r localr1 = k.bYJ().Wl(str3);
      k.bYF();
      r localr2 = k.bYJ().bYL();
      boolean bool2 = a(localr2);
      label241:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        h.qsU.idkeyStat(135L, 63L, 1L, true);
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
        ab.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label555;
        }
        if (localr2 != null) {
          break label452;
        }
        ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        h.qsU.idkeyStat(135L, 64L, 1L, true);
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
        ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label555:
      if (a(localr1))
      {
        ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        ab.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.bYF();
        k.bYJ().Wm(str3);
        i = 0;
        break;
      }
      ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (eW(localr2.field_status, j))
        {
          ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          ab.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.bYF();
          k.bYJ().Wm(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.bYF();
      k.bYJ().Wm(str3);
      i = 0;
      break;
      label1044:
      if (i == 6)
      {
        h.qsU.idkeyStat(135L, 59L, 1L, true);
        break label98;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        h.qsU.idkeyStat(135L, 60L, 1L, true);
        break label98;
      }
      if (i != 23) {
        break label98;
      }
      h.qsU.idkeyStat(135L, 66L, 1L, true);
      break label98;
      label1123:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!bo.isNullOrNil(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = pkc;
      a((r)localObject1, i);
    }
    label1169:
    ab.i(TAG, "dealMsg false");
    AppMethodBeat.o(43316);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(43321);
    if (com.tencent.mm.plugin.offline.c.a.bZX())
    {
      ab.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.pkq.dtj());
      if (!this.pkq.dtj())
      {
        h.qsU.idkeyStat(135L, 62L, 1L, true);
        this.pkq.stopTimer();
      }
    }
    AppMethodBeat.o(43321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */