package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.ae.i;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class s
{
  private static int igH = 0;
  private static String unh = null;
  private static long uni = 0L;
  private static Boolean unj = null;
  
  public static void Fj(int paramInt)
  {
    igH = paramInt;
  }
  
  private static long U(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzp, "");
    long l1 = l2;
    if (!bk.bl(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (bk.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - bk.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzp, str);
      y.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
      return 604800L;
    }
    y.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    return l1;
  }
  
  private static boolean a(bi parambi, int paramInt1, int paramInt2)
  {
    return ((parambi.ctz()) || (parambi.getType() == 1) || (parambi.getType() == 34) || (parambi.getType() == 3)) && ((paramInt1 == 3) || (paramInt2 == 9) || (paramInt2 == 15) || (paramInt2 == 17));
  }
  
  public static void aaK(String paramString)
  {
    unh = paramString;
  }
  
  public static void ag(bi parambi)
  {
    if (parambi == null) {}
    ad localad;
    int k;
    int j;
    int i;
    long l1;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          return;
        } while ((i.gr(parambi.field_talker)) || (com.tencent.mm.model.s.fn(parambi.field_talker)));
        localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(parambi.field_talker);
      } while ((localad != null) && (a.gR(localad.field_type)) && (!localad.cua()));
      k = 0;
      j = -1;
      i = 0;
      l1 = 0L;
      bool1 = false;
      bool2 = false;
      localObject1 = com.tencent.mm.model.bd.iM(parambi.czr);
      if (localObject1 != null)
      {
        k = ((bd.b)localObject1).dWw;
        j = ((bd.b)localObject1).dWx;
        i = ((bd.b)localObject1).dWy;
        l1 = ((bd.b)localObject1).dWB;
        bool1 = bool2;
        if ((((bd.b)localObject1).dWC & 0x8) != 0L) {
          bool1 = true;
        }
        if ((((bd.b)localObject1).dWC & 0x4) != 0L)
        {
          y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambi.field_talker, Long.valueOf(((bd.b)localObject1).dWC) });
          return;
        }
      }
    } while (j != 0);
    boolean bool2 = a(parambi, k, i);
    y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambi.field_talker, Boolean.valueOf(bool2) });
    if (!bool2)
    {
      if (bk.isEqual(parambi.field_talker, unh))
      {
        y.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { unh });
        return;
      }
      localObject2 = com.tencent.mm.ai.z.MF();
      l1 = parambi.field_msgSvrId;
      localObject1 = new q();
      localObject2 = ((t)localObject2).dXo.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[] { String.valueOf(l1) }, null, null, null, 2);
      if (((Cursor)localObject2).moveToFirst())
      {
        ((q)localObject1).d((Cursor)localObject2);
        ((Cursor)localObject2).close();
        if (localObject1 != null) {
          break label501;
        }
      }
      label501:
      for (localObject2 = new q();; localObject2 = localObject1)
      {
        ((q)localObject2).field_msgId = parambi.field_msgId;
        ((q)localObject2).field_msgSvrId = parambi.field_msgSvrId;
        ((q)localObject2).field_content = parambi.field_content;
        ((q)localObject2).field_type = parambi.getType();
        ((q)localObject2).field_talker = parambi.field_talker;
        ((q)localObject2).field_talkerId = parambi.field_talkerId;
        ((q)localObject2).field_createTime = parambi.field_createTime;
        ((q)localObject2).field_imgPath = parambi.field_imgPath;
        ((q)localObject2).ff(parambi.czq);
        ((q)localObject2).cY(parambi.czr);
        ((q)localObject2).field_status = parambi.field_status;
        if (localObject1 != null) {
          break label508;
        }
        com.tencent.mm.ai.z.MF().g((q)localObject2);
        return;
        ((Cursor)localObject2).close();
        localObject1 = null;
        break;
      }
      label508:
      com.tencent.mm.ai.z.MF().h((q)localObject2);
      return;
    }
    if ((localObject1 != null) && ((((bd.b)localObject1).dWC & 0x2) != 0L))
    {
      y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambi.field_talker, Long.valueOf(((bd.b)localObject1).dWC) });
      return;
    }
    Object localObject2 = com.tencent.mm.ai.z.ME().D(parambi.field_msgSvrId, "msgSvrId");
    if (localObject2 == null) {}
    long l3;
    long l2;
    for (Object localObject1 = new q();; localObject1 = localObject2)
    {
      ((q)localObject1).field_msgId = parambi.field_msgId;
      ((q)localObject1).field_msgSvrId = parambi.field_msgSvrId;
      ((q)localObject1).field_content = parambi.field_content;
      ((q)localObject1).field_type = parambi.getType();
      ((q)localObject1).field_talker = parambi.field_talker;
      ((q)localObject1).field_talkerId = parambi.field_talkerId;
      ((q)localObject1).field_createTime = parambi.field_createTime;
      ((q)localObject1).field_imgPath = parambi.field_imgPath;
      ((q)localObject1).ff(parambi.czq);
      ((q)localObject1).cY(parambi.czr);
      ((q)localObject1).field_status = parambi.field_status;
      if (localObject2 != null) {
        break label932;
      }
      ((q)localObject1).field_hasShow = 0;
      ((q)localObject1).field_isExpand = bool1;
      l3 = com.tencent.mm.ai.z.ME().cty();
      long l4 = U(l3, ((q)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        y.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.ai.z.ME().ctH();
        l2 = U(l3, ((q)localObject1).field_createTime / 1000L);
      }
      for (((q)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2); com.tencent.mm.ai.z.ME().D(((q)localObject1).field_orderFlag, "orderFlag") != null; ((q)localObject1).field_orderFlag += 1L) {}
    }
    if ((localad != null) && (localad.Bl())) {}
    for (((q)localObject1).field_placeTop = 1;; ((q)localObject1).field_placeTop = 0)
    {
      com.tencent.mm.ai.z.ME().g((q)localObject1);
      y.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((q)localObject1).field_orderFlag) });
      return;
    }
    label932:
    com.tencent.mm.ai.z.ME().h((q)localObject1);
  }
  
  public static void ah(bi parambi)
  {
    if (parambi == null) {
      return;
    }
    com.tencent.mm.ai.z.ME().hz(parambi.field_msgId);
  }
  
  public static void ctK()
  {
    if (!ctL()) {
      return;
    }
    be localbe = ((j)com.tencent.mm.kernel.g.r(j.class)).FB();
    ak localak = localbe.abv("officialaccounts");
    if (localak == null) {
      localak = new ak("officialaccounts");
    }
    for (boolean bool = true;; bool = false)
    {
      int i = com.tencent.mm.ai.z.ME().ctF();
      Object localObject2 = com.tencent.mm.ai.z.MF().dXo.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
      Object localObject1 = null;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new q();
        ((q)localObject1).d((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
      Object localObject3 = com.tencent.mm.ai.z.ME().ctD();
      label131:
      long l2;
      label143:
      int j;
      if (localObject1 != null)
      {
        l1 = ((q)localObject1).field_createTime;
        if (localObject3 == null) {
          break label242;
        }
        l2 = ((q)localObject3).field_createTime;
        localak.gU(32);
        j = com.tencent.mm.ai.z.MF().aAo();
        if ((j <= 0) || (i <= 0)) {
          break label268;
        }
        if (l1 <= l2) {
          break label248;
        }
        localak.gU(16);
        localak.fy(j);
        localObject2 = localObject1;
      }
      for (;;)
      {
        if ((localObject2 != null) && (((q)localObject2).field_msgId != 0L)) {
          break label312;
        }
        y.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
        localak.cuB();
        if (bool) {
          break;
        }
        localbe.a(localak, localak.field_username);
        return;
        l1 = 0L;
        break label131;
        label242:
        l2 = 0L;
        break label143;
        label248:
        localak.gT(16);
        localak.fy(i);
        localObject2 = localObject3;
        continue;
        label268:
        if (j > 0)
        {
          localak.gU(16);
          localak.fy(j);
          localObject2 = localObject1;
        }
        else
        {
          localak.gT(16);
          localak.fy(i);
          localObject2 = localObject3;
        }
      }
      label312:
      if ((localObject2 == localObject3) && (((q)localObject2).field_placeTop == 1)) {
        localak.gT(32);
      }
      long l3;
      if (localObject2 == localObject1)
      {
        l3 = ((q)localObject2).field_msgId;
        if (uni == 0L) {
          uni = ae.cqS().getLong("biz_time_line_last_notify_msg_id", -1L);
        }
        if (l3 == uni) {
          localak.gU(64);
        }
      }
      else
      {
        localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((q)localObject2).field_msgId);
        if (((cs)localObject1).field_msgId <= 0L) {
          break label669;
        }
        localak.ai((bi)localObject1);
        localak.setContent(((cs)localObject1).field_talker + ":" + ((cs)localObject1).field_content);
        localak.dP(Integer.toString(((bi)localObject1).getType()));
        localObject2 = localbe.tt();
        if (localObject2 != null)
        {
          localObject3 = new PString();
          PString localPString = new PString();
          PInt localPInt = new PInt();
          ((bi)localObject1).ec("officialaccounts");
          ((bi)localObject1).setContent(localak.field_content);
          ((be.b)localObject2).a((bi)localObject1, (PString)localObject3, localPString, localPInt, true);
          localak.dQ(((PString)localObject3).value);
          localak.dR(localPString.value);
          localak.fB(localPInt.value);
        }
        label586:
        l3 = l2;
        if (l1 > l2) {
          l3 = l1;
        }
        localak.ba(l3);
        if (!bool) {
          break label697;
        }
      }
      label669:
      label697:
      for (long l1 = localbe.d(localak);; l1 = localbe.a(localak, localak.field_username))
      {
        y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localak.field_conversationTime) });
        return;
        localak.gT(64);
        break;
        localak.cuB();
        y.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((q)localObject2).field_talker });
        break label586;
      }
    }
  }
  
  public static boolean ctL()
  {
    if (unj != null) {
      return unj.booleanValue();
    }
    c localc = com.tencent.mm.model.c.c.IX().fJ("100391");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("isOpenSubscribeListVersion1")))) {}
    for (boolean bool = true;; bool = false)
    {
      unj = Boolean.valueOf(bool);
      y.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { unj });
      if ((!unj.booleanValue()) && ((((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzq, Integer.valueOf(0))).intValue() & 0x1) > 0))
      {
        unj = Boolean.valueOf(true);
        y.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      }
      if ((!unj.booleanValue()) && (com.tencent.mm.m.g.AA().getInt("BizTimeLineOpen", 0) == 1))
      {
        unj = Boolean.valueOf(true);
        y.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen dynamicConfigOpen user");
      }
      return unj.booleanValue();
    }
  }
  
  public static int getSessionId()
  {
    return igH;
  }
  
  public static boolean hB(long paramLong)
  {
    if (com.tencent.mm.ai.z.ME().hy(paramLong) <= 0) {
      return false;
    }
    r localr = com.tencent.mm.ai.z.ME();
    localr.dXo.gk("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where status != 4");
    r.a locala = new r.a();
    locala.unb = r.b.unf;
    localr.b(locala);
    if (com.tencent.mm.ai.z.ME().cty() <= com.tencent.mm.ai.z.ME().ctG()) {
      com.tencent.mm.ai.z.ME().ctH();
    }
    return true;
  }
  
  public static void hC(long paramLong)
  {
    uni = paramLong;
    ae.cqS().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
  }
  
  public static void mA(boolean paramBoolean)
  {
    Cursor localCursor1 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().c(com.tencent.mm.model.s.dUT, null, "officialaccounts");
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.ai.z.ME().ctD();
      if (localObject1 == null) {}
    }
    for (long l1 = ((q)localObject1).field_createTime;; l1 = 0L)
    {
      int m = 0;
      int n = 0;
      Cursor localCursor2;
      bi localbi;
      int k;
      int j;
      int i;
      boolean bool;
      if ((m < 50) && (localCursor1.moveToNext()))
      {
        localObject1 = new ak();
        ((ak)localObject1).d(localCursor1);
        localCursor2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().g(((as)localObject1).field_username, 3, 0L);
        while (localCursor2.moveToNext())
        {
          localbi = new bi();
          localbi.d(localCursor2);
          if ((!paramBoolean) || (localbi.field_createTime >= l1))
          {
            k = 0;
            j = -1;
            i = 0;
            localObject1 = com.tencent.mm.model.bd.iM(localbi.czr);
            if (localObject1 == null) {
              break label659;
            }
            int i3 = ((bd.b)localObject1).dWw;
            int i2 = ((bd.b)localObject1).dWx;
            int i1 = ((bd.b)localObject1).dWy;
            i = i1;
            j = i2;
            k = i3;
            if ((((bd.b)localObject1).dWC & 0x8) == 0L) {
              break label659;
            }
            bool = true;
            k = i3;
            j = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        if ((j == 0) && (a(localbi, k, i)))
        {
          y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", new Object[] { localbi.field_talker });
          Object localObject2 = com.tencent.mm.ai.z.ME().D(localbi.field_msgSvrId, "msgSvrId");
          if (localObject2 == null) {}
          for (localObject1 = new q();; localObject1 = localObject2)
          {
            ((q)localObject1).field_msgId = localbi.field_msgId;
            ((q)localObject1).field_msgSvrId = localbi.field_msgSvrId;
            ((q)localObject1).field_content = localbi.field_content;
            ((q)localObject1).field_type = localbi.getType();
            ((q)localObject1).field_talker = localbi.field_talker;
            ((q)localObject1).field_talkerId = localbi.field_talkerId;
            ((q)localObject1).field_createTime = localbi.field_createTime;
            ((q)localObject1).field_imgPath = localbi.field_imgPath;
            ((q)localObject1).ff(localbi.czq);
            ((q)localObject1).cY(localbi.czr);
            if (localObject2 != null) {
              break label543;
            }
            ((q)localObject1).field_status = 4;
            ((q)localObject1).field_isExpand = bool;
            long l2 = 1L;
            if (paramBoolean) {
              l2 = com.tencent.mm.ai.z.ME().cty();
            }
            for (((q)localObject1).field_orderFlag = (l2 << 32 | ((q)localObject1).field_createTime / 1000L); com.tencent.mm.ai.z.ME().D(((q)localObject1).field_orderFlag, "orderFlag") != null; ((q)localObject1).field_orderFlag += 1L) {}
          }
          localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(localbi.field_talker);
          if ((localObject2 == null) || (!((ad)localObject2).Bl())) {
            break label552;
          }
        }
        label543:
        label552:
        for (((q)localObject1).field_placeTop = 1;; ((q)localObject1).field_placeTop = 0)
        {
          com.tencent.mm.ai.z.ME().g((q)localObject1);
          n += 1;
          break;
        }
        localCursor2.close();
        m += 1;
        break;
        y.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", new Object[] { Integer.valueOf(localCursor1.getCount()), Integer.valueOf(n) });
        localCursor1.close();
        i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzq, Integer.valueOf(0))).intValue();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzq, Integer.valueOf(i | 0x2));
        return;
        label659:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */