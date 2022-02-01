package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class r
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
  
  public r(i parami)
  {
    super(parami);
    AppMethodBeat.i(124576);
    d(getDB(), "bizchatmessage");
    a(new i.b(16, "bizchatmessage", i.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
    AppMethodBeat.o(124576);
  }
  
  private static String aTQ(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aAi().aqP(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  private static String ca(String paramString, long paramLong)
  {
    AppMethodBeat.i(124578);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(124578);
    return paramString;
  }
  
  public final int L(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(124593);
    bv localbv = this.IHS.ys(paramLong2);
    if (localbv.field_msgId == 0L)
    {
      ae.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = art(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aTQ(paramString) + ca(paramString, paramLong1) + "AND " + this.IHS.doY() + " AND createTime < " + localbv.field_createTime;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(bv parambv, bl.b paramb)
  {
    AppMethodBeat.i(124581);
    if (parambv == null)
    {
      ae.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    parambv.qO(-1L);
    if (paramb != null)
    {
      if (!com.tencent.mm.al.g.vz(parambv.field_talker)) {
        break label406;
      }
      if (bu.isNullOrNil(paramb.hJP))
      {
        ae.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambv.eNd });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.al.a.c();
      ((com.tencent.mm.al.a.c)localObject).field_bizChatServId = paramb.hJP;
      ((com.tencent.mm.al.a.c)localObject).field_brandUserName = parambv.field_talker;
      if (!bu.isNullOrNil(paramb.hJQ)) {
        ((com.tencent.mm.al.a.c)localObject).field_chatVersion = bu.getInt(paramb.hJQ, -1);
      }
      if (bu.isNullOrNil(paramb.hJO)) {
        break label360;
      }
      i = bu.getInt(paramb.hJN, j.hUZ.hVd);
      ((com.tencent.mm.al.a.c)localObject).field_chatType = bu.getInt(paramb.hJO, i);
      ae.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.hJP, paramb.userId });
      localObject = com.tencent.mm.al.a.e.e((com.tencent.mm.al.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      parambv.qO(((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      parambv.field_bizChatUserId = bu.nullAsNil(paramb.userId);
      parambv.eNk = true;
      if (paramb.hJS.equals("1")) {
        parambv.kt(1);
      }
      parambv.um(paramb.hJH);
      if ((parambv.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = ag.aGt().eQ(parambv.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambv.kt(1);
        }
      }
      if (!bu.isNullOrNil(paramb.userId))
      {
        localObject = new k();
        ((k)localObject).field_userId = paramb.userId;
        ((k)localObject).field_userName = paramb.hJR;
        ((k)localObject).field_brandUserName = parambv.field_talker;
        ag.aGt().c((k)localObject);
      }
    }
    label360:
    while (bu.isNullOrNil(paramb.hJP))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!bu.isNullOrNil(paramb.hJN)) {
          ((com.tencent.mm.al.a.c)localObject).field_chatType = bu.getInt(paramb.hJN, j.hUZ.hVd);
        }
      }
      ae.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      AppMethodBeat.o(124581);
      return false;
    }
    label391:
    label406:
    ae.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    AppMethodBeat.o(124581);
    return false;
  }
  
  public final String ajr(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!com.tencent.mm.al.g.vz(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final int arj(String paramString)
  {
    AppMethodBeat.i(124587);
    ae.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, au.foR() });
    String str = "talker= '" + paramString + "'";
    ma(art(paramString), str);
    int i = getDB().delete(art(paramString), str, null);
    if (i != 0)
    {
      this.IHS.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vWl = -1L;
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
      ae.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124584);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aTQ(paramString) + ca(paramString, paramLong) + "AND " + this.IHS.doY() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final List<bv> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.IHS.aR(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      ae.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + art(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ca(paramString, paramLong1) + "AND " + this.IHS.doY() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
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
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbv);
          continue;
          paramString = "select * from " + art(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ca(paramString, paramLong1) + "AND " + this.IHS.doY() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbv);
      }
    }
    label313:
    paramString.close();
    ae.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final bv cb(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    bv localbv = new bv();
    paramString = "select * from " + art(paramString) + " where" + ca(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localbv;
  }
  
  public final Cursor cc(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = art(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ca(paramString, paramLong) + "AND " + this.IHS.doZ() + "  order by createTime";
    localObject = getDB().a(paramString, null, 0);
    ae.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int cd(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    ae.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, au.foR() });
    ma(art(paramString), ca(paramString, paramLong));
    int i = getDB().delete(art(paramString), ca(paramString, paramLong), null);
    if (i != 0)
    {
      this.IHS.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vWl = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor ce(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(art(paramString), null, ca(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int cf(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      ae.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = ag.aGs().sf(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    ae.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = cg(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int cg(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + art(paramString) + " WHERE " + ca(paramString, paramLong);
    ae.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int ch(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.IHS.art(paramString) + " WHERE " + aTQ(paramString) + ca(paramString, paramLong) + "AND " + this.IHS.doY();
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
      ae.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124585);
      return null;
    }
    String str = art(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ca(paramString, paramLong1) + "AND " + this.IHS.doY() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<bv> q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + art(paramString) + " WHERE" + ca(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bv localbv = new bv();
        localbv.convertFrom(paramString);
        paramString.moveToNext();
        if (localbv.isText()) {
          localArrayList.add(localbv);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124580);
    return localArrayList;
  }
  
  public final Cursor r(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124589);
    String str = "SELECT * FROM ( SELECT * FROM " + art(paramString) + " WHERE" + ca(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    ae.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = getDB().a(str, null, 0);
    AppMethodBeat.o(124589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */