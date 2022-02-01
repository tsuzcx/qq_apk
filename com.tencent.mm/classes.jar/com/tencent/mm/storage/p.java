package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.j;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.af;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  private static String aHn(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo().age(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  private static String bT(String paramString, long paramLong)
  {
    AppMethodBeat.i(124578);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(124578);
    return paramString;
  }
  
  public final int M(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(124593);
    bl localbl = this.Fee.rm(paramLong2);
    if (localbl.field_msgId == 0L)
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = agG(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aHn(paramString) + bT(paramString, paramLong1) + "AND " + this.Fee.cOW() + " AND createTime < " + localbl.field_createTime;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(bl parambl, bi.b paramb)
  {
    AppMethodBeat.i(124581);
    if (parambl == null)
    {
      ad.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    parambl.kZ(-1L);
    if (paramb != null)
    {
      if (!f.pc(parambl.field_talker)) {
        break label406;
      }
      if (bt.isNullOrNil(paramb.gOf))
      {
        ad.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambl.esh });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.am.a.c();
      ((com.tencent.mm.am.a.c)localObject).field_bizChatServId = paramb.gOf;
      ((com.tencent.mm.am.a.c)localObject).field_brandUserName = parambl.field_talker;
      if (!bt.isNullOrNil(paramb.gOg)) {
        ((com.tencent.mm.am.a.c)localObject).field_chatVersion = bt.getInt(paramb.gOg, -1);
      }
      if (bt.isNullOrNil(paramb.gOe)) {
        break label360;
      }
      i = bt.getInt(paramb.gOd, j.gZn.gZr);
      ((com.tencent.mm.am.a.c)localObject).field_chatType = bt.getInt(paramb.gOe, i);
      ad.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.gOf, paramb.userId });
      localObject = com.tencent.mm.am.a.e.e((com.tencent.mm.am.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      parambl.kZ(((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
      parambl.field_bizChatUserId = bt.nullAsNil(paramb.userId);
      parambl.eOL = true;
      if (paramb.gOi.equals("1")) {
        parambl.jV(1);
      }
      parambl.oc(paramb.gNX);
      if ((parambl.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = af.awi().eb(parambl.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambl.jV(1);
        }
      }
      if (!bt.isNullOrNil(paramb.userId))
      {
        localObject = new com.tencent.mm.am.a.k();
        ((com.tencent.mm.am.a.k)localObject).field_userId = paramb.userId;
        ((com.tencent.mm.am.a.k)localObject).field_userName = paramb.gOh;
        ((com.tencent.mm.am.a.k)localObject).field_brandUserName = parambl.field_talker;
        af.awi().c((com.tencent.mm.am.a.k)localObject);
      }
    }
    label360:
    while (bt.isNullOrNil(paramb.gOf))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!bt.isNullOrNil(paramb.gOd)) {
          ((com.tencent.mm.am.a.c)localObject).field_chatType = bt.getInt(paramb.gOd, j.gZn.gZr);
        }
      }
      ad.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      AppMethodBeat.o(124581);
      return false;
    }
    label391:
    label406:
    ad.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    AppMethodBeat.o(124581);
    return false;
  }
  
  public final String aHk(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!f.pc(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final int agw(String paramString)
  {
    AppMethodBeat.i(124587);
    ad.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, at.eFU() });
    String str = "talker= '" + paramString + "'";
    kX(agG(paramString), str);
    int i = getDB().delete(agG(paramString), str, null);
    if (i != 0)
    {
      this.Fee.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.tyH = -1L;
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
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124584);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aHn(paramString) + bT(paramString, paramLong) + "AND " + this.Fee.cOW() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final List<bl> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.Fee.aN(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + agG(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bT(paramString, paramLong1) + "AND " + this.Fee.cOW() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
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
        bl localbl = new bl();
        localbl.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbl);
          continue;
          paramString = "select * from " + agG(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bT(paramString, paramLong1) + "AND " + this.Fee.cOW() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbl);
      }
    }
    label313:
    paramString.close();
    ad.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final bl bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    bl localbl = new bl();
    paramString = "select * from " + agG(paramString) + " where" + bT(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localbl;
  }
  
  public final Cursor bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = agG(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bT(paramString, paramLong) + "AND " + this.Fee.cOX() + "  order by createTime";
    localObject = getDB().a(paramString, null, 0);
    ad.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    ad.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, at.eFU() });
    kX(agG(paramString), bT(paramString, paramLong));
    int i = getDB().delete(agG(paramString), bT(paramString, paramLong), null);
    if (i != 0)
    {
      this.Fee.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.tyH = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor bX(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(agG(paramString), null, bT(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      ad.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = af.awh().mf(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    ad.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = bZ(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int bZ(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + agG(paramString) + " WHERE " + bT(paramString, paramLong);
    ad.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int ca(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.Fee.agG(paramString) + " WHERE " + aHn(paramString) + bT(paramString, paramLong) + "AND " + this.Fee.cOW();
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
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124585);
      return null;
    }
    String str = agG(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bT(paramString, paramLong1) + "AND " + this.Fee.cOW() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<bl> o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + agG(paramString) + " WHERE" + bT(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bl localbl = new bl();
        localbl.convertFrom(paramString);
        paramString.moveToNext();
        if (localbl.isText()) {
          localArrayList.add(localbl);
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
    String str = "SELECT * FROM ( SELECT * FROM " + agG(paramString) + " WHERE" + bT(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    ad.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = getDB().a(str, null, 0);
    AppMethodBeat.o(124589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */