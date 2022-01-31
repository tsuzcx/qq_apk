package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class s
{
  private static int cnU = 0;
  private static String ywS = null;
  private static long ywT = 0L;
  private static boolean ywU = false;
  private static Boolean ywV = null;
  
  public static void Np(int paramInt)
  {
    cnU = paramInt;
  }
  
  public static boolean aWl()
  {
    AppMethodBeat.i(11902);
    if (ywV != null)
    {
      bool = ywV.booleanValue();
      AppMethodBeat.o(11902);
      return bool;
    }
    int i = as.eu("brandService", 1).decodeInt("BizTimeLineOpenStatus", -1);
    if (i == 1) {
      ywV = Boolean.TRUE;
    }
    while (ywV != null)
    {
      bool = ywV.booleanValue();
      AppMethodBeat.o(11902);
      return bool;
      if (i == 0) {
        ywV = Boolean.FALSE;
      }
    }
    if ((((Integer)g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue() & 0x1) > 0)
    {
      ywV = Boolean.TRUE;
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
      bool = ywV.booleanValue();
      AppMethodBeat.o(11902);
      return bool;
    }
    i = com.tencent.mm.aj.z.afo().dwi();
    if (i > 20000)
    {
      ywV = Boolean.FALSE;
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen too match data totalCount %d", new Object[] { Integer.valueOf(i) });
      bool = ywV.booleanValue();
      AppMethodBeat.o(11902);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUv, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ywV = Boolean.valueOf(bool);
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { ywV });
      bool = ywV.booleanValue();
      AppMethodBeat.o(11902);
      return bool;
    }
  }
  
  private static long ai(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(11899);
    String str = (String)g.RL().Ru().get(ac.a.yKd, "");
    long l1 = l2;
    if (!bo.isNullOrNil(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (bo.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - bo.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      l1 = 604800L;
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      g.RL().Ru().set(ac.a.yKd, str);
      ab.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(11899);
      return paramLong1;
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static void an(bi parambi)
  {
    AppMethodBeat.i(11894);
    if (parambi == null)
    {
      AppMethodBeat.o(11894);
      return;
    }
    if (l.na(parambi.field_talker))
    {
      AppMethodBeat.o(11894);
      return;
    }
    if (com.tencent.mm.model.t.lA(parambi.field_talker))
    {
      AppMethodBeat.o(11894);
      return;
    }
    ad localad = ((j)g.E(j.class)).YA().arw(parambi.field_talker);
    if ((localad != null) && (com.tencent.mm.n.a.je(localad.field_type)) && (!localad.dwz()))
    {
      AppMethodBeat.o(11894);
      return;
    }
    int m = 0;
    int k = -1;
    int j = 0;
    long l1 = 0L;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    int n = 0;
    Object localObject1 = bf.pA(parambi.dns);
    if (localObject1 != null)
    {
      m = ((bf.b)localObject1).fmE;
      k = ((bf.b)localObject1).fmF;
      j = ((bf.b)localObject1).fmG;
      l1 = ((bf.b)localObject1).fmJ;
      bool1 = bool2;
      if ((((bf.b)localObject1).fmK & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bf.b)localObject1).fmK & 0x10) != 0L) {
        i = 1;
      }
      if ((((bf.b)localObject1).fmK & 0x4) != 0L)
      {
        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambi.field_talker, Long.valueOf(((bf.b)localObject1).fmK) });
        AppMethodBeat.o(11894);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(11894);
      return;
    }
    if ((parambi.getType() == 34) || (parambi.getType() == 3)) {
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(parambi.getType()) });
    }
    for (bool2 = false;; bool2 = b(parambi, m, j))
    {
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[] { parambi.field_talker, Boolean.valueOf(bool2) });
      if (bool2) {
        break label660;
      }
      if (!bo.isEqual(parambi.field_talker, ywS)) {
        break;
      }
      ab.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { ywS });
      AppMethodBeat.o(11894);
      return;
    }
    Object localObject2 = com.tencent.mm.aj.z.afp();
    l1 = parambi.field_msgSvrId;
    localObject1 = new q();
    localObject2 = ((t)localObject2).fnw.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[] { String.valueOf(l1) }, null, null, null, 2);
    if (((Cursor)localObject2).moveToFirst())
    {
      ((q)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
      if (localObject1 != null) {
        break label637;
      }
    }
    label637:
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
      ((q)localObject2).hr(parambi.dnr);
      ((q)localObject2).jl(parambi.dns);
      ((q)localObject2).field_status = parambi.field_status;
      if (localObject1 != null) {
        break label644;
      }
      com.tencent.mm.aj.z.afp().h((q)localObject2);
      AppMethodBeat.o(11894);
      return;
      ((Cursor)localObject2).close();
      localObject1 = null;
      break;
    }
    label644:
    com.tencent.mm.aj.z.afp().i((q)localObject2);
    AppMethodBeat.o(11894);
    return;
    label660:
    if ((localObject1 != null) && ((((bf.b)localObject1).fmK & 0x2) != 0L))
    {
      ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { parambi.field_talker, Long.valueOf(((bf.b)localObject1).fmK) });
      AppMethodBeat.o(11894);
      return;
    }
    localObject2 = com.tencent.mm.aj.z.afo().C(parambi.field_msgSvrId, "msgSvrId");
    if (localObject2 == null)
    {
      localObject1 = new q();
      ((q)localObject1).field_msgId = parambi.field_msgId;
      ((q)localObject1).field_msgSvrId = parambi.field_msgSvrId;
      ((q)localObject1).field_content = parambi.field_content;
      ((q)localObject1).field_type = parambi.getType();
      ((q)localObject1).field_talker = parambi.field_talker;
      ((q)localObject1).field_talkerId = parambi.field_talkerId;
      ((q)localObject1).field_createTime = parambi.field_createTime;
      ((q)localObject1).field_imgPath = parambi.field_imgPath;
      ((q)localObject1).hr(parambi.dnr);
      ((q)localObject1).jl(parambi.dns);
      if (!aWl()) {
        break label1020;
      }
      ((q)localObject1).field_status = parambi.field_status;
    }
    long l3;
    long l2;
    for (((q)localObject1).field_hasShow = 0;; ((q)localObject1).field_hasShow = 1)
    {
      if (i != 0) {
        ((q)localObject1).dwa();
      }
      if (localObject2 != null) {
        break label1149;
      }
      ((q)localObject1).field_isExpand = bool1;
      l3 = com.tencent.mm.aj.z.afo().dvU();
      long l4 = ai(l3, ((q)localObject1).field_createTime / 1000L);
      l2 = l4;
      if (l4 >= 4294967296L)
      {
        ab.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.aj.z.afo().dwg();
        l2 = ai(l3, ((q)localObject1).field_createTime / 1000L);
      }
      for (((q)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2); com.tencent.mm.aj.z.afo().C(((q)localObject1).field_orderFlag, "orderFlag") != null; ((q)localObject1).field_orderFlag += 1L) {}
      localObject1 = localObject2;
      break;
      label1020:
      ((q)localObject1).field_status = 4;
    }
    if ((localad != null) && (localad.Oa())) {}
    for (((q)localObject1).field_placeTop = 1;; ((q)localObject1).field_placeTop = 0)
    {
      com.tencent.mm.aj.z.afo().h((q)localObject1);
      if (!ywU)
      {
        ywU = true;
        d.ysm.b(new s.1(), "BizTimeLineInfoStorageThread", 1000L);
      }
      ab.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((q)localObject1).field_orderFlag) });
      AppMethodBeat.o(11894);
      return;
    }
    label1149:
    com.tencent.mm.aj.z.afo().i((q)localObject1);
    AppMethodBeat.o(11894);
  }
  
  public static void ao(bi parambi)
  {
    AppMethodBeat.i(11898);
    if (parambi == null)
    {
      AppMethodBeat.o(11898);
      return;
    }
    com.tencent.mm.aj.z.afo().og(parambi.field_msgId);
    AppMethodBeat.o(11898);
  }
  
  private static p ap(bi parambi)
  {
    AppMethodBeat.i(151392);
    if (parambi.dvV())
    {
      parambi = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
      AppMethodBeat.o(151392);
      return parambi;
    }
    AppMethodBeat.o(151392);
    return null;
  }
  
  public static void aqU(String paramString)
  {
    ywS = paramString;
  }
  
  private static boolean b(bi parambi, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11895);
    if ((paramInt1 == 3) || (paramInt2 == 9) || (paramInt2 == 15) || (paramInt2 == 17))
    {
      if (parambi.getType() == 1)
      {
        AppMethodBeat.o(11895);
        return true;
      }
      if (parambi.dvV())
      {
        parambi = ap(parambi);
        if ((parambi != null) && (!bo.es(parambi.fjy)))
        {
          AppMethodBeat.o(11895);
          return true;
        }
        AppMethodBeat.o(11895);
        return false;
      }
    }
    AppMethodBeat.o(11895);
    return false;
  }
  
  public static void dwk()
  {
    AppMethodBeat.i(11900);
    if (!aWl())
    {
      AppMethodBeat.o(11900);
      return;
    }
    be localbe = ((j)g.E(j.class)).YF();
    ak localak = localbe.arH("officialaccounts");
    if (localak == null) {
      localak = new ak("officialaccounts");
    }
    for (boolean bool = true;; bool = false)
    {
      Object localObject2 = com.tencent.mm.aj.z.afp().fnw.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
      Object localObject1 = null;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new q();
        ((q)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
      Object localObject3 = com.tencent.mm.aj.z.afo().dwc();
      long l1;
      if (localObject1 != null)
      {
        l1 = ((q)localObject1).field_createTime;
        if (localObject3 == null) {
          break label781;
        }
      }
      label781:
      for (int i = com.tencent.mm.aj.z.afo().of(((q)localObject3).field_orderFlag);; i = 0)
      {
        long l2;
        label165:
        int j;
        if (localObject3 != null)
        {
          l2 = ((q)localObject3).field_createTime;
          localak.jh(32);
          j = com.tencent.mm.aj.z.afp().bbZ();
          if ((j <= 0) || (i <= 0)) {
            break label296;
          }
          if (l1 <= l2) {
            break label276;
          }
          localak.jh(16);
          localak.hJ(j);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if ((localObject2 != null) && (((q)localObject2).field_msgId != 0L)) {
            break label340;
          }
          ab.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
          localak.dxc();
          if (!bool) {
            localbe.a(localak, localak.field_username);
          }
          AppMethodBeat.o(11900);
          return;
          l1 = 0L;
          break;
          l2 = 0L;
          break label165;
          label276:
          localak.jg(16);
          localak.hJ(i);
          localObject2 = localObject3;
          continue;
          label296:
          if (j > 0)
          {
            localak.jh(16);
            localak.hJ(j);
            localObject2 = localObject1;
          }
          else
          {
            localak.jg(16);
            localak.hJ(i);
            localObject2 = localObject3;
          }
        }
        label340:
        if ((localObject2 == localObject3) && (((q)localObject2).field_placeTop == 1)) {
          localak.jg(32);
        }
        long l3;
        if (localObject2 == localObject1)
        {
          l3 = ((q)localObject2).field_msgId;
          if (ywT == 0L) {
            ywT = ah.dsQ().getLong("biz_time_line_last_notify_msg_id", -1L);
          }
          if (l3 == ywT) {
            localak.jh(64);
          }
        }
        else
        {
          localObject1 = ((j)g.E(j.class)).bPQ().kB(((q)localObject2).field_msgId);
          if (((dd)localObject1).field_msgId <= 0L) {
            break label734;
          }
          localak.aq((bi)localObject1);
          localak.setContent(((dd)localObject1).field_talker + ":" + ((dd)localObject1).field_content);
          localak.jV(Integer.toString(((bi)localObject1).getType()));
          localObject2 = localbe.BX();
          if (localObject2 != null)
          {
            localObject3 = new PString();
            PString localPString = new PString();
            PInt localPInt = new PInt();
            ((bi)localObject1).kj("officialaccounts");
            ((bi)localObject1).setContent(localak.field_content);
            ((be.b)localObject2).a((bi)localObject1, (PString)localObject3, localPString, localPInt, true);
            localak.jW(((PString)localObject3).value);
            localak.jX(localPString.value);
            localak.hM(localPInt.value);
          }
          label614:
          l3 = l2;
          if (l1 > l2) {
            l3 = l1;
          }
          localak.fK(l3);
          if (!bool) {
            break label762;
          }
        }
        label734:
        label762:
        for (l1 = localbe.d(localak);; l1 = localbe.a(localak, localak.field_username))
        {
          l2 = ((dd)localObject1).field_msgId;
          localObject1 = as.eu("brandService", 1);
          if (localObject1 != null) {
            ((as)localObject1).encode("LastMsgId", l2);
          }
          ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localak.field_conversationTime) });
          AppMethodBeat.o(11900);
          return;
          localak.jg(64);
          break;
          localak.dxc();
          ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[] { ((q)localObject2).field_talker });
          break label614;
        }
      }
    }
  }
  
  public static int getSessionId()
  {
    return cnU;
  }
  
  public static boolean oi(long paramLong)
  {
    AppMethodBeat.i(11897);
    if (com.tencent.mm.aj.z.afo().od(paramLong) <= 0)
    {
      AppMethodBeat.o(11897);
      return false;
    }
    if (com.tencent.mm.aj.z.afo().dvU() <= com.tencent.mm.aj.z.afo().dwf()) {
      com.tencent.mm.aj.z.afo().dwg();
    }
    com.tencent.mm.aj.z.afo().oc(paramLong);
    AppMethodBeat.o(11897);
    return true;
  }
  
  public static void oj(long paramLong)
  {
    AppMethodBeat.i(11901);
    ywT = paramLong;
    ah.dsQ().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(11901);
  }
  
  public static void pR(boolean paramBoolean)
  {
    AppMethodBeat.i(11896);
    Cursor localCursor1 = ((j)g.E(j.class)).YF().c(com.tencent.mm.model.t.flc, null, "officialaccounts");
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.aj.z.afo().dwc();
      if (localObject1 == null) {}
    }
    for (long l1 = ((q)localObject1).field_createTime;; l1 = 0L)
    {
      int m = 0;
      int n = 0;
      Cursor localCursor2;
      bi localbi;
      int j;
      int i;
      int k;
      boolean bool2;
      boolean bool1;
      int i2;
      if ((m < 50) && (localCursor1.moveToNext()))
      {
        localObject1 = new ak();
        ((ak)localObject1).convertFrom(localCursor1);
        localCursor2 = ((j)g.E(j.class)).bPQ().k(((au)localObject1).field_username, 3, 0L);
        while (localCursor2.moveToNext())
        {
          localbi = new bi();
          localbi.convertFrom(localCursor2);
          if ((!paramBoolean) || (localbi.field_createTime >= l1))
          {
            j = 0;
            i = -1;
            k = 0;
            bool2 = false;
            bool1 = false;
            localObject1 = bf.pA(localbi.dns);
            if (localObject1 == null) {
              break label711;
            }
            int i3 = ((bf.b)localObject1).fmE;
            i2 = ((bf.b)localObject1).fmF;
            int i1 = ((bf.b)localObject1).fmG;
            if ((((bf.b)localObject1).fmK & 0x8) != 0L) {
              bool1 = true;
            }
            bool2 = bool1;
            k = i1;
            i = i2;
            j = i3;
            if ((((bf.b)localObject1).fmK & 0x10) == 0L) {
              break label711;
            }
            k = 1;
            j = i3;
            i = i2;
            i2 = k;
            k = i1;
          }
        }
      }
      for (;;)
      {
        if ((i == 0) && (b(localbi, j, k)))
        {
          ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", new Object[] { localbi.field_talker });
          Object localObject2 = com.tencent.mm.aj.z.afo().C(localbi.field_msgSvrId, "msgSvrId");
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
            ((q)localObject1).hr(localbi.dnr);
            ((q)localObject1).jl(localbi.dns);
            if (i2 != 0) {
              ((q)localObject1).dwa();
            }
            if (localObject2 != null) {
              break label589;
            }
            ((q)localObject1).field_status = 4;
            ((q)localObject1).field_isExpand = bool1;
            long l2 = 1L;
            if (paramBoolean) {
              l2 = com.tencent.mm.aj.z.afo().dvU();
            }
            for (((q)localObject1).field_orderFlag = (l2 << 32 | ((q)localObject1).field_createTime / 1000L); com.tencent.mm.aj.z.afo().C(((q)localObject1).field_orderFlag, "orderFlag") != null; ((q)localObject1).field_orderFlag += 1L) {}
          }
          localObject2 = ((j)g.E(j.class)).YA().arw(localbi.field_talker);
          if ((localObject2 == null) || (!((ad)localObject2).Oa())) {
            break label598;
          }
        }
        label589:
        label598:
        for (((q)localObject1).field_placeTop = 1;; ((q)localObject1).field_placeTop = 0)
        {
          com.tencent.mm.aj.z.afo().h((q)localObject1);
          n += 1;
          break;
        }
        localCursor2.close();
        m += 1;
        break;
        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", new Object[] { Integer.valueOf(localCursor1.getCount()), Integer.valueOf(n) });
        localCursor1.close();
        i = ((Integer)g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue();
        g.RL().Ru().set(ac.a.yKe, Integer.valueOf(i | 0x2));
        AppMethodBeat.o(11896);
        return;
        label711:
        i2 = 0;
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */