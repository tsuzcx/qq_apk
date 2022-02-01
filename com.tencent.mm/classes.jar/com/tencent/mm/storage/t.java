package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.a.j;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
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
    a(new i.b(16, "bizchatmessage", i.b.d(2500001L, 3000000L, 99000001L, 102000000L)));
    AppMethodBeat.o(124576);
  }
  
  private static String bvo(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aLt(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  private static String cp(String paramString, long paramLong)
  {
    AppMethodBeat.i(124578);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(124578);
    return paramString;
  }
  
  public final int R(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(124593);
    cc localcc = this.acDE.sl(paramLong2);
    if ((localcc == null) || (localcc.field_msgId == 0L))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = aLY(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + bvo(paramString) + cp(paramString, paramLong1) + "AND " + this.acDE.gbo() + " AND createTime < " + localcc.getCreateTime();
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(cc paramcc, br.b paramb)
  {
    AppMethodBeat.i(124581);
    if (paramcc == null)
    {
      Log.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    paramcc.gY(-1L);
    if (paramb != null)
    {
      if (!g.Dn(paramcc.field_talker)) {
        break label406;
      }
      if (Util.isNullOrNil(paramb.olZ))
      {
        Log.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { paramcc.jUr });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.an.a.c();
      ((com.tencent.mm.an.a.c)localObject).field_bizChatServId = paramb.olZ;
      ((com.tencent.mm.an.a.c)localObject).field_brandUserName = paramcc.field_talker;
      if (!Util.isNullOrNil(paramb.oma)) {
        ((com.tencent.mm.an.a.c)localObject).field_chatVersion = Util.getInt(paramb.oma, -1);
      }
      if (Util.isNullOrNil(paramb.olY)) {
        break label360;
      }
      i = Util.getInt(paramb.olX, j.oyj.oyn);
      ((com.tencent.mm.an.a.c)localObject).field_chatType = Util.getInt(paramb.olY, i);
      Log.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.olZ, paramb.userId });
      localObject = com.tencent.mm.an.a.e.e((com.tencent.mm.an.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      paramcc.gY(((com.tencent.mm.an.a.c)localObject).field_bizChatLocalId);
      paramcc.field_bizChatUserId = Util.nullAsNil(paramb.userId);
      paramcc.kKZ = true;
      if (paramb.omc.equals("1")) {
        paramcc.pI(1);
      }
      paramcc.BW(paramb.olR);
      if ((paramcc.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = af.bHj().hN(paramcc.field_talker);
        if (paramb.userId.equals(localObject)) {
          paramcc.pI(1);
        }
      }
      if (!Util.isNullOrNil(paramb.userId))
      {
        localObject = new k();
        ((k)localObject).field_userId = paramb.userId;
        ((k)localObject).field_userName = paramb.omb;
        ((k)localObject).field_brandUserName = paramcc.field_talker;
        af.bHj().c((k)localObject);
      }
    }
    label360:
    while (Util.isNullOrNil(paramb.olZ))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!Util.isNullOrNil(paramb.olX)) {
          ((com.tencent.mm.an.a.c)localObject).field_chatType = Util.getInt(paramb.olX, j.oyj.oyn);
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
  
  public final String aAD(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!g.Dn(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final int aLO(String paramString)
  {
    AppMethodBeat.i(124587);
    Log.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    String str = "talker= '" + paramString + "'";
    pD(aLY(paramString), str);
    int i = getDB().delete(aLY(paramString), str, null);
    if (i != 0)
    {
      this.acDE.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.KRp = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124587);
    return i;
  }
  
  public final List<cc> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.acDE.bc(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + aLY(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + cp(paramString, paramLong1) + "AND " + this.acDE.gbo() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
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
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localcc);
          continue;
          paramString = "select * from " + aLY(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + cp(paramString, paramLong1) + "AND " + this.acDE.gbo() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localcc);
      }
    }
    label312:
    paramString.close();
    Log.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final Cursor c(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124584);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124584);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bvo(paramString) + cp(paramString, paramLong) + "AND " + this.acDE.gbo() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().rawQuery(paramString, null);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final cc cq(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    cc localcc = new cc();
    paramString = "select * from " + aLY(paramString) + " where" + cp(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localcc;
  }
  
  public final Cursor cr(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = aLY(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + cp(paramString, paramLong) + "AND " + this.acDE.gbp() + "  order by createTime";
    localObject = getDB().rawQuery(paramString, null);
    Log.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int cs(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    Log.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, MMStack.getStack(true) });
    pD(aLY(paramString), cp(paramString, paramLong));
    int i = getDB().delete(aLY(paramString), cp(paramString, paramLong), null);
    if (i != 0)
    {
      this.acDE.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.KRp = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor ct(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(aLY(paramString), null, cp(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int cu(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      Log.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = af.bHi().iD(paramLong);
    if ((locala != null) && (locala.field_msgCount != 0))
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    Log.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = cv(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int cv(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + aLY(paramString) + " WHERE " + cp(paramString, paramLong);
    Log.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int cw(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.acDE.aLY(paramString) + " WHERE " + bvo(paramString) + cp(paramString, paramLong) + "AND " + this.acDE.gbo();
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124592);
    return i;
  }
  
  public final Cursor e(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(124585);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124585);
      return null;
    }
    String str = aLY(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + cp(paramString, paramLong1) + "AND " + this.acDE.gbo() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().rawQuery(paramString, null);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<cc> y(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aLY(paramString) + " WHERE" + cp(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().rawQuery(paramString, null);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        cc localcc = new cc();
        localcc.convertFrom(paramString);
        paramString.moveToNext();
        if (localcc.iYl()) {
          localArrayList.add(localcc);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124580);
    return localArrayList;
  }
  
  public final Cursor z(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124589);
    String str = "SELECT * FROM " + aLY(paramString) + " WHERE " + cp(paramString, paramLong) + " ORDER BY createTime DESC LIMIT " + paramInt;
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