package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static int GBA;
  public static int GBB;
  public static int GBC;
  public static int GBD;
  public static int GBE;
  public static int GBF;
  public static int GBs;
  private static int GBt;
  public static int GBu;
  public static int GBv;
  public static int GBw;
  public static int GBx;
  public static int GBy;
  public static int GBz;
  public static String TAG;
  private static int xVs;
  public i GBG;
  public boolean GBH;
  public MTimerHandler GBI;
  public int status;
  
  static
  {
    AppMethodBeat.i(66225);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    GBs = 5000;
    GBt = 30000;
    xVs = 5000;
    GBu = 0;
    GBv = 24;
    GBw = 4;
    GBx = 8;
    GBy = 23;
    GBz = 6;
    GBA = 5;
    GBB = 20;
    GBC = 20000;
    GBD = 20001;
    GBE = 10001;
    GBF = xVs;
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqn, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      GBF = i;
      if (i == 0) {
        GBF = xVs;
      }
    }
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqp, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        GBt = i;
      }
    }
    AppMethodBeat.o(66225);
  }
  
  public g()
  {
    AppMethodBeat.i(66216);
    this.status = 0;
    this.GBG = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(66214);
        if (((paramAnonymousq instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousq = (d)paramAnonymousq;
          g.access$002(paramAnonymousq.GCs);
          if (g.GBF == 0) {
            g.access$002(g.xVs);
          }
          Log.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramAnonymousq.GCt, paramAnonymousq.GCr });
          if ((Util.isNullOrNil(paramAnonymousq.GCr)) || (Util.isNullOrNil(paramAnonymousq.GCt))) {
            break label313;
          }
          if (g.jt(paramAnonymousq.GCt, paramAnonymousq.GCr))
          {
            Log.i(g.TAG, "from cgi");
            if (XmlParser.parseXml(paramAnonymousq.GCr, "sysmsg", null) == null)
            {
              AppMethodBeat.o(66214);
              return;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 71L, 1L, true);
            k.fkT();
            paramAnonymousString = k.fkU();
            paramAnonymousq = paramAnonymousq.GCr;
            Log.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
            if (!TextUtils.isEmpty(paramAnonymousq))
            {
              paramAnonymousInt1 = -1;
              Map localMap = XmlParser.parseXml(paramAnonymousq, "sysmsg", null);
              if (localMap != null)
              {
                localMap.get(".sysmsg.paymsg.ack_key");
                paramAnonymousInt1 = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
              }
              if ((com.tencent.mm.plugin.offline.c.a.fmp()) && (paramAnonymousInt1 != 7) && (paramAnonymousInt1 != 10))
              {
                Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                paramAnonymousString.aTy(paramAnonymousq);
                paramAnonymousString.aTz(paramAnonymousq);
              }
            }
          }
        }
        for (;;)
        {
          Log.i(g.TAG, "mIntercal=" + g.GBF);
          g.a(g.this).startTimer(g.GBF);
          AppMethodBeat.o(66214);
          return;
          label313:
          Log.i(g.TAG, "OfflineGetMsgLogic msg is null");
        }
      }
    };
    this.GBH = true;
    this.GBI = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66215);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.h.aHB())
          {
            g.a(g.this).startTimer(g.GBs);
            AppMethodBeat.o(66215);
            return false;
          }
          if ((com.tencent.mm.plugin.offline.c.a.fmp()) && (com.tencent.mm.plugin.offline.c.a.flN())) {
            g.fkP();
          }
        }
        AppMethodBeat.o(66215);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this.GBG);
    AppMethodBeat.o(66216);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    AppMethodBeat.i(66217);
    if (paramr != null) {
      Log.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(GBC));
    ((HashSet)localObject).add(Integer.valueOf(GBz));
    ((HashSet)localObject).add(Integer.valueOf(GBA));
    ((HashSet)localObject).add(Integer.valueOf(GBw));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      Log.i((String)localObject, bool);
      if (paramr != null) {
        Log.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      AppMethodBeat.o(66217);
      return true;
    }
    Log.i(TAG, "isOrderClosed false");
    if (paramr != null) {
      Log.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(66217);
      return false;
      Log.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    AppMethodBeat.i(66220);
    int i = paramInt;
    if (paramInt == GBw) {
      i = GBC;
    }
    boolean bool = iI(paramr.field_status, i);
    Log.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.fkT();
      k.fkX().c(paramr);
    }
    AppMethodBeat.o(66220);
    return bool;
  }
  
  public static int fkM()
  {
    return GBt;
  }
  
  public static void fkN()
  {
    AppMethodBeat.i(66222);
    Log.i(TAG, "endAllOldOrder");
    k.fkT();
    com.tencent.mm.plugin.offline.b.a locala = k.fkX();
    Log.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.flb()), locala.fla() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.db.rawQuery((String)localObject, null, 2);
    long l2 = 0L;
    long l1;
    if (localObject == null)
    {
      Log.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l1 = l2;
      if (l1 - 10L <= 0L) {
        break label313;
      }
      localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l1 - 10L) });
      Log.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l1), localObject });
      locala.db.execSQL("OfflineOrderStatus", (String)localObject);
    }
    for (;;)
    {
      localObject = "UPDATE OfflineOrderStatus SET status=" + GBC + " where status!=" + GBC;
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
      Log.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l1) });
    }
  }
  
  public static int fkO()
  {
    return GBF;
  }
  
  public static void fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(66221);
    if (!Util.isNullOrNil(paramString))
    {
      k.fkT();
      r localr = k.fkX().aTA(paramString);
      if (localr != null)
      {
        a(localr, paramInt);
        AppMethodBeat.o(66221);
        return;
      }
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = paramInt;
      k.fkT();
      k.fkX().c(localr);
    }
    AppMethodBeat.o(66221);
  }
  
  private static boolean iI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66219);
    Log.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBu)
    {
      AppMethodBeat.o(66219);
      return true;
    }
    if (paramInt1 == GBv)
    {
      if (paramInt2 != GBv)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBz)
    {
      if (paramInt2 == GBC)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBA)
    {
      if (paramInt2 == GBC)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBw)
    {
      if (paramInt2 == GBC)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBB)
    {
      if (paramInt2 == GBC)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if ((paramInt1 == GBx) || (paramInt1 == GBy))
    {
      if ((paramInt2 == GBz) || (paramInt2 == GBC))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == GBE)
    {
      if ((paramInt2 == GBz) || (paramInt2 == GBC))
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
  
  public static boolean jt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66218);
    int i;
    Object localObject1;
    if (Util.isNullOrNil(paramString2))
    {
      Log.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1171;
      }
      k.fkT();
      localObject1 = k.fkX().fkZ();
      paramString2 = XmlParser.parseXml(paramString2, "sysmsg", null);
      i = Util.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1046;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 58L, 1L, true);
      label99:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1125;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      Log.i(TAG, "dealMsg true");
      AppMethodBeat.o(66218);
      return true;
      localObject1 = XmlParser.parseXml(paramString2, "sysmsg", null);
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = Util.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.fkT();
      r localr1 = k.fkX().aTA(str3);
      k.fkT();
      r localr2 = k.fkX().fkZ();
      boolean bool2 = a(localr2);
      label243:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 63L, 1L, true);
        if (localr2 == null) {
          break label370;
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
        Log.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label557;
        }
        if (localr2 != null) {
          break label454;
        }
        Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 64L, 1L, true);
        break label243;
        label370:
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
      label454:
      if (bool2)
      {
        Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label557:
      if (a(localr1))
      {
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        Log.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.fkT();
        k.fkX().aTB(str3);
        i = 0;
        break;
      }
      Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (iI(localr2.field_status, j))
        {
          Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          Log.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.fkT();
          k.fkX().aTB(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.fkT();
      k.fkX().aTB(str3);
      i = 0;
      break;
      label1046:
      if (i == 6)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 59L, 1L, true);
        break label99;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 60L, 1L, true);
        break label99;
      }
      if (i != 23) {
        break label99;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 66L, 1L, true);
      break label99;
      label1125:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!Util.isNullOrNil(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = GBu;
      a((r)localObject1, i);
    }
    label1171:
    Log.i(TAG, "dealMsg false");
    AppMethodBeat.o(66218);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(66223);
    if (com.tencent.mm.plugin.offline.c.a.fmp())
    {
      Log.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.GBI.stopped());
      if (!this.GBI.stopped())
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 62L, 1L, true);
        this.GBI.stopTimer();
      }
    }
    AppMethodBeat.o(66223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */