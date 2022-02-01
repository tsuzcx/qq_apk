package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.offline.a.t;
import com.tencent.mm.plugin.offline.a.u;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  private static int Bwf;
  public static int MxB;
  private static int MxC;
  public static int MxD;
  public static int MxE;
  public static int MxF;
  public static int MxG;
  public static int MxH;
  public static int MxI;
  public static int MxJ;
  public static int MxK;
  public static int MxL;
  public static int MxM;
  public static int MxN;
  public static int MxO;
  public static String TAG;
  public com.tencent.mm.am.h MxP;
  public boolean MxQ;
  public MTimerHandler MxR;
  public int status;
  
  static
  {
    AppMethodBeat.i(66225);
    TAG = "MicroMsg.OfflineGetMsgLogic";
    MxB = 5000;
    MxC = 30000;
    Bwf = 5000;
    MxD = 0;
    MxE = 24;
    MxF = 4;
    MxG = 8;
    MxH = 23;
    MxI = 6;
    MxJ = 5;
    MxK = 20;
    MxL = 20000;
    MxM = 20001;
    MxN = 10001;
    MxO = Bwf;
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acRP, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      MxO = i;
      if (i == 0) {
        MxO = Bwf;
      }
    }
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acRR, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        MxC = i;
      }
    }
    AppMethodBeat.o(66225);
  }
  
  public g()
  {
    AppMethodBeat.i(66216);
    this.status = 0;
    this.MxP = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(66214);
        if (((paramAnonymousp instanceof com.tencent.mm.plugin.offline.a.f)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousp = (com.tencent.mm.plugin.offline.a.f)paramAnonymousp;
          g.access$002(paramAnonymousp.MyD);
          if (g.MxO == 0) {
            g.access$002(g.Bwf);
          }
          Log.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramAnonymousp.MyE, paramAnonymousp.MyC });
          if ((Util.isNullOrNil(paramAnonymousp.MyC)) || (Util.isNullOrNil(paramAnonymousp.MyE))) {
            break label313;
          }
          if (g.kK(paramAnonymousp.MyE, paramAnonymousp.MyC))
          {
            Log.i(g.TAG, "from cgi");
            if (XmlParser.parseXml(paramAnonymousp.MyC, "sysmsg", null) == null)
            {
              AppMethodBeat.o(66214);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 71L, 1L, true);
            k.gvj();
            paramAnonymousString = k.gvk();
            paramAnonymousp = paramAnonymousp.MyC;
            Log.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
            if (!TextUtils.isEmpty(paramAnonymousp))
            {
              paramAnonymousInt1 = -1;
              Map localMap = XmlParser.parseXml(paramAnonymousp, "sysmsg", null);
              if (localMap != null)
              {
                localMap.get(".sysmsg.paymsg.ack_key");
                paramAnonymousInt1 = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
              }
              if ((d.gxc()) && (paramAnonymousInt1 != 7) && (paramAnonymousInt1 != 10))
              {
                Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                paramAnonymousString.aQB(paramAnonymousp);
                paramAnonymousString.aQC(paramAnonymousp);
              }
            }
          }
        }
        for (;;)
        {
          Log.i(g.TAG, "mIntercal=" + g.MxO);
          g.a(g.this).startTimer(g.MxO);
          AppMethodBeat.o(66214);
          return;
          label313:
          Log.i(g.TAG, "OfflineGetMsgLogic msg is null");
        }
      }
    };
    this.MxQ = true;
    this.MxR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66215);
        if (g.a(g.this) != null)
        {
          if (!com.tencent.mm.kernel.h.baz())
          {
            g.a(g.this).startTimer(g.MxB);
            AppMethodBeat.o(66215);
            return false;
          }
          if ((d.gxc()) && (d.gwA())) {
            g.gvg();
          }
        }
        AppMethodBeat.o(66215);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this.MxP);
    AppMethodBeat.o(66216);
  }
  
  private static boolean a(t paramt)
  {
    boolean bool = false;
    AppMethodBeat.i(66217);
    if (paramt != null) {
      Log.i(TAG, "isOrderClosed lastest status req_key=" + paramt.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(MxL));
    ((HashSet)localObject).add(Integer.valueOf(MxI));
    ((HashSet)localObject).add(Integer.valueOf(MxJ));
    ((HashSet)localObject).add(Integer.valueOf(MxF));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramt == null) || (((HashSet)localObject).contains(Integer.valueOf(paramt.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramt == null) {
        bool = true;
      }
      Log.i((String)localObject, bool);
      if (paramt != null) {
        Log.i(TAG, "isOrderClosed status.field_status=" + paramt.field_status);
      }
      AppMethodBeat.o(66217);
      return true;
    }
    Log.i(TAG, "isOrderClosed false");
    if (paramt != null) {
      Log.i(TAG, "status=" + paramt.field_status + ";req_key=" + paramt.field_reqkey);
    }
    for (;;)
    {
      AppMethodBeat.o(66217);
      return false;
      Log.i(TAG, "isOrderClosed status=null");
    }
  }
  
  private static boolean a(t paramt, int paramInt)
  {
    AppMethodBeat.i(66220);
    int i = paramInt;
    if (paramInt == MxF) {
      i = MxL;
    }
    boolean bool = ko(paramt.field_status, i);
    Log.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramt.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramt.field_status = i;
      k.gvj();
      k.gvn().c(paramt);
    }
    AppMethodBeat.o(66220);
    return bool;
  }
  
  public static void gs(String paramString, int paramInt)
  {
    AppMethodBeat.i(66221);
    if (!Util.isNullOrNil(paramString))
    {
      k.gvj();
      t localt = k.gvn().aQD(paramString);
      if (localt != null)
      {
        a(localt, paramInt);
        AppMethodBeat.o(66221);
        return;
      }
      localt = new t();
      localt.field_reqkey = paramString;
      localt.field_status = paramInt;
      k.gvj();
      k.gvn().c(localt);
    }
    AppMethodBeat.o(66221);
  }
  
  public static int gvd()
  {
    return MxC;
  }
  
  public static void gve()
  {
    AppMethodBeat.i(66222);
    Log.i(TAG, "endAllOldOrder");
    k.gvj();
    a locala = k.gvn();
    Log.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.gvs()), locala.gvr() });
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
      localObject = "UPDATE OfflineOrderStatus SET status=" + MxL + " where status!=" + MxL;
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
  
  public static int gvf()
  {
    return MxO;
  }
  
  public static boolean kK(String paramString1, String paramString2)
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
      k.gvj();
      localObject1 = k.gvn().gvq();
      paramString2 = XmlParser.parseXml(paramString2, "sysmsg", null);
      i = Util.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1046;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 58L, 1L, true);
      label99:
      if ((localObject1 == null) || (((t)localObject1).field_reqkey == null) || (!((t)localObject1).field_reqkey.equals(paramString2))) {
        break label1125;
      }
      a((t)localObject1, i);
    }
    for (;;)
    {
      Log.i(TAG, "dealMsg true");
      AppMethodBeat.o(66218);
      return true;
      localObject1 = XmlParser.parseXml(paramString2, "sysmsg", null);
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = Util.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.gvj();
      t localt1 = k.gvn().aQD(str3);
      k.gvj();
      t localt2 = k.gvn().gvq();
      boolean bool2 = a(localt2);
      label243:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localt1 != null)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 63L, 1L, true);
        if (localt2 == null) {
          break label370;
        }
        str1 = TAG;
        localObject3 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
        localObject2 = new Object[3];
        localObject2[0] = localt2.field_reqkey;
        localObject2[1] = Integer.valueOf(localt2.field_status);
        i = 2;
        bool1 = bool2;
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1[i] = Boolean.valueOf(bool1);
        Log.i(str1, (String)localObject3, (Object[])localObject2);
        if (localt1 != null) {
          break label557;
        }
        if (localt2 != null) {
          break label454;
        }
        Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 64L, 1L, true);
        break label243;
        label370:
        str1 = TAG;
        String str2 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
        localObject1 = new Object[2];
        localObject1[0] = Boolean.valueOf(bool2);
        i = 1;
        if (localt1 == null)
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
        Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
        i = 1;
        break;
      }
      Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
      i = 0;
      break;
      label557:
      if (a(localt1))
      {
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localt1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localt1.field_status) });
        i = 0;
        break;
      }
      if (localt2 == null)
      {
        Log.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status) });
        k.gvj();
        k.gvn().aQE(str3);
        i = 0;
        break;
      }
      Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
      if (localt1.field_reqkey.equals(localt2.field_reqkey))
      {
        if (ko(localt2.field_status, j))
        {
          Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
          i = 1;
          break;
        }
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
        if (localt2.field_status != j)
        {
          Log.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.gvj();
          k.gvn().aQE(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
        i = 1;
        break;
      }
      Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localt1.field_status), localt2.field_reqkey, Integer.valueOf(localt2.field_status) });
      k.gvj();
      k.gvn().aQE(str3);
      i = 0;
      break;
      label1046:
      if (i == 6)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 59L, 1L, true);
        break label99;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 60L, 1L, true);
        break label99;
      }
      if (i != 23) {
        break label99;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 66L, 1L, true);
      break label99;
      label1125:
      localObject1 = new t();
      ((t)localObject1).field_reqkey = paramString2;
      if (!Util.isNullOrNil(paramString1)) {
        ((t)localObject1).field_ack_key = paramString1;
      }
      ((t)localObject1).field_status = MxD;
      a((t)localObject1, i);
    }
    label1171:
    Log.i(TAG, "dealMsg false");
    AppMethodBeat.o(66218);
    return false;
  }
  
  private static boolean ko(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66219);
    Log.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxD)
    {
      AppMethodBeat.o(66219);
      return true;
    }
    if (paramInt1 == MxE)
    {
      if (paramInt2 != MxE)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxI)
    {
      if (paramInt2 == MxL)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxJ)
    {
      if (paramInt2 == MxL)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxF)
    {
      if (paramInt2 == MxL)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxK)
    {
      if (paramInt2 == MxL)
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if ((paramInt1 == MxG) || (paramInt1 == MxH))
    {
      if ((paramInt2 == MxI) || (paramInt2 == MxL))
      {
        AppMethodBeat.o(66219);
        return true;
      }
      AppMethodBeat.o(66219);
      return false;
    }
    if (paramInt1 == MxN)
    {
      if ((paramInt2 == MxI) || (paramInt2 == MxL))
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
  
  public final void stop()
  {
    AppMethodBeat.i(66223);
    if (d.gxc())
    {
      Log.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.MxR.stopped());
      if (!this.MxR.stopped())
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 62L, 1L, true);
        this.MxR.stopTimer();
      }
    }
    AppMethodBeat.o(66223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */