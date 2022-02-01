package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
  
  public t(i parami)
  {
    super(parami);
    AppMethodBeat.i(124576);
    e(getDB(), "bizchatmessage");
    a(new i.b(16, "bizchatmessage", i.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
    AppMethodBeat.o(124576);
  }
  
  private static String bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(124578);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(124578);
    return paramString;
  }
  
  private static String biM(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aTq().aEk(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  public final int M(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(124593);
    ca localca = this.NOL.Hb(paramLong2);
    if (localca.field_msgId == 0L)
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = aEO(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + biM(paramString) + bW(paramString, paramLong1) + "AND " + this.NOL.eiN() + " AND createTime < " + localca.field_createTime;
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(ca paramca, bp.b paramb)
  {
    AppMethodBeat.i(124581);
    if (paramca == null)
    {
      Log.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    paramca.yG(-1L);
    if (paramb != null)
    {
      if (!com.tencent.mm.al.g.DQ(paramca.field_talker)) {
        break label406;
      }
      if (Util.isNullOrNil(paramb.iEz))
      {
        Log.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { paramca.fqK });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.al.a.c();
      ((com.tencent.mm.al.a.c)localObject).field_bizChatServId = paramb.iEz;
      ((com.tencent.mm.al.a.c)localObject).field_brandUserName = paramca.field_talker;
      if (!Util.isNullOrNil(paramb.iEA)) {
        ((com.tencent.mm.al.a.c)localObject).field_chatVersion = Util.getInt(paramb.iEA, -1);
      }
      if (Util.isNullOrNil(paramb.iEy)) {
        break label360;
      }
      i = Util.getInt(paramb.iEx, j.iQm.iQq);
      ((com.tencent.mm.al.a.c)localObject).field_chatType = Util.getInt(paramb.iEy, i);
      Log.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.iEz, paramb.userId });
      localObject = com.tencent.mm.al.a.e.e((com.tencent.mm.al.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      paramca.yG(((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      paramca.field_bizChatUserId = Util.nullAsNil(paramb.userId);
      paramca.fqR = true;
      if (paramb.iEC.equals("1")) {
        paramca.nv(1);
      }
      paramca.CC(paramb.iEr);
      if ((paramca.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = ag.bal().fC(paramca.field_talker);
        if (paramb.userId.equals(localObject)) {
          paramca.nv(1);
        }
      }
      if (!Util.isNullOrNil(paramb.userId))
      {
        localObject = new k();
        ((k)localObject).field_userId = paramb.userId;
        ((k)localObject).field_userName = paramb.iEB;
        ((k)localObject).field_brandUserName = paramca.field_talker;
        ag.bal().c((k)localObject);
      }
    }
    label360:
    while (Util.isNullOrNil(paramb.iEz))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!Util.isNullOrNil(paramb.iEx)) {
          ((com.tencent.mm.al.a.c)localObject).field_chatType = Util.getInt(paramb.iEx, j.iQm.iQq);
        }
      }
      Log.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      AppMethodBeat.o(124581);
      return false;
    }
    label391:
    label406:
    Log.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    AppMethodBeat.o(124581);
    return false;
  }
  
  public final int aEE(String paramString)
  {
    AppMethodBeat.i(124587);
    Log.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    String str = "talker= '" + paramString + "'";
    mO(aEO(paramString), str);
    int i = getDB().delete(aEO(paramString), str, null);
    if (i != 0)
    {
      this.NOL.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.zqq = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124587);
    return i;
  }
  
  public final String avu(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!com.tencent.mm.al.g.DQ(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final Cursor b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124584);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124584);
      return null;
    }
    String str = aEO(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + biM(paramString) + bW(paramString, paramLong) + "AND " + this.NOL.eiN() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().rawQuery(paramString, null);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final List<ca> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.NOL.aR(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + aEO(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(paramString, paramLong1) + "AND " + this.NOL.eiN() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
      paramString = getDB().rawQuery(paramString, null);
      if (!paramString.moveToFirst()) {}
    }
    else
    {
      for (;;)
      {
        if (paramString.isAfterLast()) {
          break label312;
        }
        ca localca = new ca();
        localca.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localca);
          continue;
          paramString = "select * from " + aEO(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(paramString, paramLong1) + "AND " + this.NOL.eiN() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localca);
      }
    }
    label312:
    paramString.close();
    Log.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final ca bX(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    ca localca = new ca();
    paramString = "select * from " + aEO(paramString) + " where" + bW(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localca.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localca;
  }
  
  public final Cursor bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = aEO(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(paramString, paramLong) + "AND " + this.NOL.eiO() + "  order by createTime";
    localObject = getDB().rawQuery(paramString, null);
    Log.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int bZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    Log.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    mO(aEO(paramString), bW(paramString, paramLong));
    int i = getDB().delete(aEO(paramString), bW(paramString, paramLong), null);
    if (i != 0)
    {
      this.NOL.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.zqq = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor ca(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(aEO(paramString), null, bW(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int cb(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      Log.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = ag.bak().Al(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    Log.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = cc(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int cc(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + aEO(paramString) + " WHERE " + bW(paramString, paramLong);
    Log.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int cd(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.NOL.aEO(paramString) + " WHERE " + biM(paramString) + bW(paramString, paramLong) + "AND " + this.NOL.eiN();
    paramString = getDB().rawQuery(paramString, null);
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
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124585);
      return null;
    }
    String str = aEO(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(paramString, paramLong1) + "AND " + this.NOL.eiN() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().rawQuery(paramString, null);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<ca> s(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aEO(paramString) + " WHERE" + bW(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(paramString);
        paramString.moveToNext();
        if (localca.isText()) {
          localArrayList.add(localca);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124580);
    return localArrayList;
  }
  
  public final Cursor t(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124589);
    String str = "SELECT * FROM ( SELECT * FROM " + aEO(paramString) + " WHERE" + bW(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    Log.i("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = getDB().rawQuery(str, null);
    AppMethodBeat.o(124589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */