package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Map;

public final class g
{
  public static String TAG = "MicroMsg.OfflineGetMsgLogic";
  public static int mJK = 5000;
  private static int mJL = 30000;
  private static int mJM = 5000;
  public static int mJN = 0;
  public static int mJO = 24;
  public static int mJP = 4;
  public static int mJQ = 8;
  public static int mJR = 23;
  public static int mJS = 6;
  public static int mJT = 5;
  public static int mJU = 20;
  public static int mJV = 20000;
  public static int mJW = 20001;
  public static int mJX = 10001;
  public static int mJY = mJM;
  public f mJZ = new g.1(this);
  public boolean mKa = true;
  public am mKb = new am(new g.2(this), false);
  public int status = 0;
  
  static
  {
    com.tencent.mm.kernel.g.DQ();
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwy, null);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      mJY = i;
      if (i == 0) {
        mJY = mJM;
      }
    }
    com.tencent.mm.kernel.g.DQ();
    localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwA, Integer.valueOf(0));
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      if (i != 0) {
        mJL = i;
      }
    }
  }
  
  public g()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(385, this.mJZ);
  }
  
  private static boolean a(r paramr)
  {
    boolean bool = false;
    if (paramr != null) {
      y.i(TAG, "isOrderClosed lastest status req_key=" + paramr.field_reqkey);
    }
    Object localObject = new HashSet();
    ((HashSet)localObject).add(Integer.valueOf(mJV));
    ((HashSet)localObject).add(Integer.valueOf(mJS));
    ((HashSet)localObject).add(Integer.valueOf(mJT));
    ((HashSet)localObject).add(Integer.valueOf(mJP));
    ((HashSet)localObject).add(Integer.valueOf(-1));
    if ((paramr == null) || (((HashSet)localObject).contains(Integer.valueOf(paramr.field_status))))
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("isOrderClosed true;status==null?");
      if (paramr == null) {
        bool = true;
      }
      y.i((String)localObject, bool);
      if (paramr != null) {
        y.i(TAG, "isOrderClosed status.field_status=" + paramr.field_status);
      }
      return true;
    }
    y.i(TAG, "isOrderClosed false");
    if (paramr != null)
    {
      y.i(TAG, "status=" + paramr.field_status + ";req_key=" + paramr.field_reqkey);
      return false;
    }
    y.i(TAG, "isOrderClosed status=null");
    return false;
  }
  
  private static boolean a(r paramr, int paramInt)
  {
    int i = paramInt;
    if (paramInt == mJP) {
      i = mJV;
    }
    boolean bool = dw(paramr.field_status, i);
    y.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramr.field_status), Integer.valueOf(i) });
    if (bool)
    {
      paramr.field_status = i;
      k.bpX();
      k.bqb().b(paramr);
    }
    return bool;
  }
  
  public static int bpS()
  {
    return mJL;
  }
  
  public static void bpT()
  {
    y.i(TAG, "endAllOldOrder");
    k.bpX();
    com.tencent.mm.plugin.offline.b.a locala = k.bqb();
    y.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(locala.bqh()), locala.bqg() });
    Object localObject = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[] { "rowid", "OfflineOrderStatus", "rowid" });
    localObject = locala.dXw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
      l = 0L;
      if (l - 10L > 0L)
      {
        localObject = String.format("DELETE FROM %s WHERE %s < %d;", new Object[] { "OfflineOrderStatus", "rowid", Long.valueOf(l - 10L) });
        y.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[] { Long.valueOf(l), localObject });
        locala.dXw.gk("OfflineOrderStatus", (String)localObject);
        label181:
        localObject = "UPDATE OfflineOrderStatus SET status=" + mJV + " where status!=" + mJV;
        locala.dXw.gk("OfflineOrderStatus", (String)localObject);
      }
    }
    else
    {
      ((Cursor)localObject).moveToFirst();
      if ((((Cursor)localObject).isAfterLast()) || (((Cursor)localObject).getColumnCount() <= 0)) {
        break label292;
      }
    }
    label292:
    for (long l = ((Cursor)localObject).getLong(0);; l = 0L)
    {
      ((Cursor)localObject).close();
      break;
      y.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[] { Long.valueOf(l) });
      break label181;
    }
  }
  
  public static void ce(String paramString, int paramInt)
  {
    if (!bk.bl(paramString))
    {
      k.bpX();
      localr = k.bqb().Km(paramString);
      if (localr != null) {
        a(localr, paramInt);
      }
    }
    else
    {
      return;
    }
    r localr = new r();
    localr.field_reqkey = paramString;
    localr.field_status = paramInt;
    k.bpX();
    k.bqb().b(localr);
  }
  
  private static boolean dw(int paramInt1, int paramInt2)
  {
    y.i(TAG, "checkStatus from=" + paramInt1 + ";to=" + paramInt2);
    if (paramInt1 == paramInt2) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                  if (paramInt1 == mJN) {
                    return true;
                  }
                  if (paramInt1 != mJO) {
                    break;
                  }
                } while (paramInt2 == mJO);
                return true;
                if (paramInt1 != mJS) {
                  break;
                }
              } while (paramInt2 != mJV);
              return true;
              if (paramInt1 != mJT) {
                break;
              }
            } while (paramInt2 != mJV);
            return true;
            if (paramInt1 != mJP) {
              break;
            }
          } while (paramInt2 != mJV);
          return true;
          if (paramInt1 != mJU) {
            break;
          }
        } while (paramInt2 != mJV);
        return true;
        if ((paramInt1 != mJQ) && (paramInt1 != mJR)) {
          break;
        }
      } while ((paramInt2 != mJS) && (paramInt2 != mJV));
      return true;
    } while ((paramInt1 != mJX) || ((paramInt2 != mJS) && (paramInt2 != mJV)));
    return true;
  }
  
  public static boolean em(String paramString1, String paramString2)
  {
    int i;
    Object localObject1;
    if (bk.bl(paramString2))
    {
      y.i(TAG, "shouldDeal appmsg is null");
      i = 0;
      if (i == 0) {
        break label1157;
      }
      k.bpX();
      localObject1 = k.bqb().bqf();
      paramString2 = bn.s(paramString2, "sysmsg");
      i = bk.getInt((String)paramString2.get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString2 = (String)paramString2.get(".sysmsg.paymsg.req_key");
      if (i != 24) {
        break label1032;
      }
      h.nFQ.a(135L, 58L, 1L, true);
      label92:
      if ((localObject1 == null) || (((r)localObject1).field_reqkey == null) || (!((r)localObject1).field_reqkey.equals(paramString2))) {
        break label1111;
      }
      a((r)localObject1, i);
    }
    for (;;)
    {
      y.i(TAG, "dealMsg true");
      return true;
      localObject1 = bn.s(paramString2, "sysmsg");
      String str3 = (String)((Map)localObject1).get(".sysmsg.paymsg.req_key");
      int j = bk.getInt((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType"), -1);
      k.bpX();
      r localr1 = k.bqb().Km(str3);
      k.bpX();
      r localr2 = k.bqb().bqf();
      boolean bool2 = a(localr2);
      label229:
      String str1;
      Object localObject3;
      Object localObject2;
      boolean bool1;
      if (localr1 != null)
      {
        h.nFQ.a(135L, 63L, 1L, true);
        if (localr2 == null) {
          break label356;
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
        y.i(str1, (String)localObject3, (Object[])localObject2);
        if (localr1 != null) {
          break label543;
        }
        if (localr2 != null) {
          break label440;
        }
        y.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[] { str3, Integer.valueOf(j) });
        i = 1;
        break;
        h.nFQ.a(135L, 64L, 1L, true);
        break label229;
        label356:
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
      label440:
      if (bool2)
      {
        y.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      y.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[] { str3, Integer.valueOf(j), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      i = 0;
      break;
      label543:
      if (a(localr1))
      {
        y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[] { localr1.field_reqkey, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        i = 0;
        break;
      }
      if (localr2 == null)
      {
        y.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status) });
        k.bpX();
        k.bqb().Kn(str3);
        i = 0;
        break;
      }
      y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      if (localr1.field_reqkey.equals(localr2.field_reqkey))
      {
        if (dw(localr2.field_status, j))
        {
          y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
          i = 1;
          break;
        }
        y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        if (localr2.field_status != j)
        {
          y.i(TAG, "mark reqKey: %s as give up", new Object[] { str3 });
          k.bpX();
          k.bqb().Kn(str3);
        }
        i = 0;
        break;
      }
      if (bool2)
      {
        y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
        i = 1;
        break;
      }
      y.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[] { str3, Integer.valueOf(j), Integer.valueOf(localr1.field_status), localr2.field_reqkey, Integer.valueOf(localr2.field_status) });
      k.bpX();
      k.bqb().Kn(str3);
      i = 0;
      break;
      label1032:
      if (i == 6)
      {
        h.nFQ.a(135L, 59L, 1L, true);
        break label92;
      }
      if ((i == 4) || (i == 5) || (i == 20))
      {
        h.nFQ.a(135L, 60L, 1L, true);
        break label92;
      }
      if (i != 23) {
        break label92;
      }
      h.nFQ.a(135L, 66L, 1L, true);
      break label92;
      label1111:
      localObject1 = new r();
      ((r)localObject1).field_reqkey = paramString2;
      if (!bk.bl(paramString1)) {
        ((r)localObject1).field_ack_key = paramString1;
      }
      ((r)localObject1).field_status = mJN;
      a((r)localObject1, i);
    }
    label1157:
    y.i(TAG, "dealMsg false");
    return false;
  }
  
  public final void stop()
  {
    if (com.tencent.mm.plugin.offline.c.a.bri())
    {
      y.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.mKb.crl());
      if (!this.mKb.crl())
      {
        h.nFQ.a(135L, 62L, 1L, true);
        this.mKb.stopTimer();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g
 * JD-Core Version:    0.7.0.1
 */