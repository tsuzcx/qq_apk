package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class p
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
  
  public p(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh)
  {
    super(paramh);
    AppMethodBeat.i(124576);
    c(getDB(), "bizchatmessage");
    a(new h.b(16, "bizchatmessage", h.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
    AppMethodBeat.o(124576);
  }
  
  private static String aMH(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).axd().akY(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  private static String bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(124578);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(124578);
    return paramString;
  }
  
  public final int K(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(124593);
    bo localbo = this.GBN.vP(paramLong2);
    if (localbo.field_msgId == 0L)
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = alA(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aMH(paramString) + bV(paramString, paramLong1) + "AND " + this.GBN.dcF() + " AND createTime < " + localbo.field_createTime;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(bo parambo, bi.b paramb)
  {
    AppMethodBeat.i(124581);
    if (parambo == null)
    {
      ac.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    parambo.oB(-1L);
    if (paramb != null)
    {
      if (!f.so(parambo.field_talker)) {
        break label406;
      }
      if (bs.isNullOrNil(paramb.hoF))
      {
        ac.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambo.eul });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.al.a.c();
      ((com.tencent.mm.al.a.c)localObject).field_bizChatServId = paramb.hoF;
      ((com.tencent.mm.al.a.c)localObject).field_brandUserName = parambo.field_talker;
      if (!bs.isNullOrNil(paramb.hoG)) {
        ((com.tencent.mm.al.a.c)localObject).field_chatVersion = bs.getInt(paramb.hoG, -1);
      }
      if (bs.isNullOrNil(paramb.hoE)) {
        break label360;
      }
      i = bs.getInt(paramb.hoD, j.hzM.hzQ);
      ((com.tencent.mm.al.a.c)localObject).field_chatType = bs.getInt(paramb.hoE, i);
      ac.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.hoF, paramb.userId });
      localObject = com.tencent.mm.al.a.e.e((com.tencent.mm.al.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      parambo.oB(((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      parambo.field_bizChatUserId = bs.nullAsNil(paramb.userId);
      parambo.eRT = true;
      if (paramb.hoI.equals("1")) {
        parambo.jT(1);
      }
      parambo.ri(paramb.hox);
      if ((parambo.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = af.aDa().dQ(parambo.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambo.jT(1);
        }
      }
      if (!bs.isNullOrNil(paramb.userId))
      {
        localObject = new com.tencent.mm.al.a.k();
        ((com.tencent.mm.al.a.k)localObject).field_userId = paramb.userId;
        ((com.tencent.mm.al.a.k)localObject).field_userName = paramb.hoH;
        ((com.tencent.mm.al.a.k)localObject).field_brandUserName = parambo.field_talker;
        af.aDa().c((com.tencent.mm.al.a.k)localObject);
      }
    }
    label360:
    while (bs.isNullOrNil(paramb.hoF))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!bs.isNullOrNil(paramb.hoD)) {
          ((com.tencent.mm.al.a.c)localObject).field_chatType = bs.getInt(paramb.hoD, j.hzM.hzQ);
        }
      }
      ac.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      AppMethodBeat.o(124581);
      return false;
    }
    label391:
    label406:
    ac.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    AppMethodBeat.o(124581);
    return false;
  }
  
  public final String aME(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!f.so(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final int alq(String paramString)
  {
    AppMethodBeat.i(124587);
    ac.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, as.eVp() });
    String str = "talker= '" + paramString + "'";
    lu(alA(paramString), str);
    int i = getDB().delete(alA(paramString), str, null);
    if (i != 0)
    {
      this.GBN.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.uHe = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124587);
    return i;
  }
  
  public final Cursor b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124584);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124584);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aMH(paramString) + bV(paramString, paramLong) + "AND " + this.GBN.dcF() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final List<bo> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.GBN.aP(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + alA(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bV(paramString, paramLong1) + "AND " + this.GBN.dcF() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
      paramString = getDB().a(paramString, null, 0);
      if (!paramString.moveToFirst()) {}
    }
    else
    {
      for (;;)
      {
        if (paramString.isAfterLast()) {
          break label313;
        }
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbo);
          continue;
          paramString = "select * from " + alA(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bV(paramString, paramLong1) + "AND " + this.GBN.dcF() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbo);
      }
    }
    label313:
    paramString.close();
    ac.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final bo bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    bo localbo = new bo();
    paramString = "select * from " + alA(paramString) + " where" + bV(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbo.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localbo;
  }
  
  public final Cursor bX(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = alA(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bV(paramString, paramLong) + "AND " + this.GBN.dcG() + "  order by createTime";
    localObject = getDB().a(paramString, null, 0);
    ac.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    ac.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, as.eVp() });
    lu(alA(paramString), bV(paramString, paramLong));
    int i = getDB().delete(alA(paramString), bV(paramString, paramLong), null);
    if (i != 0)
    {
      this.GBN.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.uHe = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor bZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(alA(paramString), null, bV(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int ca(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      ac.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = af.aCZ().pT(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    ac.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = cb(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int cb(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + alA(paramString) + " WHERE " + bV(paramString, paramLong);
    ac.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int cc(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.GBN.alA(paramString) + " WHERE " + aMH(paramString) + bV(paramString, paramLong) + "AND " + this.GBN.dcF();
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124592);
    return i;
  }
  
  public final Cursor d(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(124585);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124585);
      return null;
    }
    String str = alA(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bV(paramString, paramLong1) + "AND " + this.GBN.dcF() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<bo> o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + alA(paramString) + " WHERE" + bV(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bo localbo = new bo();
        localbo.convertFrom(paramString);
        paramString.moveToNext();
        if (localbo.isText()) {
          localArrayList.add(localbo);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124580);
    return localArrayList;
  }
  
  public final Cursor p(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124589);
    String str = "SELECT * FROM ( SELECT * FROM " + alA(paramString) + " WHERE" + bV(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    ac.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = getDB().a(str, null, 0);
    AppMethodBeat.o(124589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */