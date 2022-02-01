package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.j;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  private static String aSt(String paramString)
  {
    AppMethodBeat.i(176158);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azS().apK(paramString);
    if (l > 0L)
    {
      paramString = " createTime > " + l + " AND ";
      AppMethodBeat.o(176158);
      return paramString;
    }
    AppMethodBeat.o(176158);
    return "";
  }
  
  private static String bZ(String paramString, long paramLong)
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
    bu localbu = this.InH.xY(paramLong2);
    if (localbu.field_msgId == 0L)
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(124593);
      return 0;
    }
    String str = aqo(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aSt(paramString) + bZ(paramString, paramLong1) + "AND " + this.InH.dlZ() + " AND createTime < " + localbu.field_createTime;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124593);
    return i;
  }
  
  protected final boolean a(bu parambu, bj.b paramb)
  {
    AppMethodBeat.i(124581);
    if (parambu == null)
    {
      ad.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(124581);
      return false;
    }
    parambu.qB(-1L);
    if (paramb != null)
    {
      if (!com.tencent.mm.am.g.vd(parambu.field_talker)) {
        break label406;
      }
      if (bt.isNullOrNil(paramb.hGX))
      {
        ad.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambu.eLs });
        AppMethodBeat.o(124581);
        return false;
      }
      localObject = new com.tencent.mm.am.a.c();
      ((com.tencent.mm.am.a.c)localObject).field_bizChatServId = paramb.hGX;
      ((com.tencent.mm.am.a.c)localObject).field_brandUserName = parambu.field_talker;
      if (!bt.isNullOrNil(paramb.hGY)) {
        ((com.tencent.mm.am.a.c)localObject).field_chatVersion = bt.getInt(paramb.hGY, -1);
      }
      if (bt.isNullOrNil(paramb.hGW)) {
        break label360;
      }
      i = bt.getInt(paramb.hGV, j.hSh.hSl);
      ((com.tencent.mm.am.a.c)localObject).field_chatType = bt.getInt(paramb.hGW, i);
      ad.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.hGX, paramb.userId });
      localObject = com.tencent.mm.am.a.e.e((com.tencent.mm.am.a.c)localObject);
      if (localObject == null) {
        break label391;
      }
      parambu.qB(((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
      parambu.field_bizChatUserId = bt.nullAsNil(paramb.userId);
      parambu.eLz = true;
      if (paramb.hHa.equals("1")) {
        parambu.kr(1);
      }
      parambu.tR(paramb.hGP);
      if ((parambu.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = ag.aGd().eL(parambu.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambu.kr(1);
        }
      }
      if (!bt.isNullOrNil(paramb.userId))
      {
        localObject = new k();
        ((k)localObject).field_userId = paramb.userId;
        ((k)localObject).field_userName = paramb.hGZ;
        ((k)localObject).field_brandUserName = parambu.field_talker;
        ag.aGd().c((k)localObject);
      }
    }
    label360:
    while (bt.isNullOrNil(paramb.hGX))
    {
      for (;;)
      {
        Object localObject;
        int i;
        AppMethodBeat.o(124581);
        return true;
        if (!bt.isNullOrNil(paramb.hGV)) {
          ((com.tencent.mm.am.a.c)localObject).field_chatType = bt.getInt(paramb.hGV, j.hSh.hSl);
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
  
  public final String aiu(String paramString)
  {
    AppMethodBeat.i(124577);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!com.tencent.mm.am.g.vd(paramString)) {
        break;
      }
      AppMethodBeat.o(124577);
      return "bizchatmessage";
    }
    AppMethodBeat.o(124577);
    return null;
  }
  
  public final int aqe(String paramString)
  {
    AppMethodBeat.i(124587);
    ad.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, at.fkW() });
    String str = "talker= '" + paramString + "'";
    lT(aqo(paramString), str);
    int i = getDB().delete(aqo(paramString), str, null);
    if (i != 0)
    {
      this.InH.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vKh = -1L;
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
    String str = aqo(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aSt(paramString) + bZ(paramString, paramLong) + "AND " + this.InH.dlZ() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124584);
    return paramString;
  }
  
  public final List<bu> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(124582);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(124582);
      return null;
    }
    paramLong2 = this.InH.aQ(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(124582);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + aqo(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bZ(paramString, paramLong1) + "AND " + this.InH.dlZ() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
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
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbu);
          continue;
          paramString = "select * from " + aqo(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bZ(paramString, paramLong1) + "AND " + this.InH.dlZ() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbu);
      }
    }
    label313:
    paramString.close();
    ad.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(124582);
    return localArrayList;
  }
  
  public final bu ca(String paramString, long paramLong)
  {
    AppMethodBeat.i(124579);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124579);
      return null;
    }
    bu localbu = new bu();
    paramString = "select * from " + aqo(paramString) + " where" + bZ(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = getDB().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(124579);
    return localbu;
  }
  
  public final Cursor cb(String paramString, long paramLong)
  {
    AppMethodBeat.i(124583);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(124583);
      return null;
    }
    Object localObject = aqo(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bZ(paramString, paramLong) + "AND " + this.InH.dma() + "  order by createTime";
    localObject = getDB().a(paramString, null, 0);
    ad.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(124583);
    return localObject;
  }
  
  public final int cc(String paramString, long paramLong)
  {
    AppMethodBeat.i(124586);
    ad.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, at.fkW() });
    lT(aqo(paramString), bZ(paramString, paramLong));
    int i = getDB().delete(aqo(paramString), bZ(paramString, paramLong), null);
    if (i != 0)
    {
      this.InH.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new i.c(paramString, "delete", null, i, (byte)0);
      paramString.vKh = -1L;
      a(paramString);
    }
    AppMethodBeat.o(124586);
    return i;
  }
  
  public final Cursor cd(String paramString, long paramLong)
  {
    AppMethodBeat.i(124588);
    paramString = getDB().query(aqo(paramString), null, bZ(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(124588);
    return paramString;
  }
  
  public final int ce(String paramString, long paramLong)
  {
    AppMethodBeat.i(124590);
    if (paramString == null)
    {
      ad.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(124590);
      return -1;
    }
    a locala = ag.aGc().rS(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(124590);
      return i;
    }
    ad.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = cf(paramString, paramLong);
    AppMethodBeat.o(124590);
    return i;
  }
  
  public final int cf(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124591);
    paramString = "SELECT COUNT(*) FROM " + aqo(paramString) + " WHERE " + bZ(paramString, paramLong);
    ad.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(124591);
    return i;
  }
  
  public final int cg(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124592);
    paramString = "SELECT COUNT(*) FROM " + this.InH.aqo(paramString) + " WHERE " + aSt(paramString) + bZ(paramString, paramLong) + "AND " + this.InH.dlZ();
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
    String str = aqo(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bZ(paramString, paramLong1) + "AND " + this.InH.dlZ() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = getDB().a(paramString, null, 0);
    AppMethodBeat.o(124585);
    return paramString;
  }
  
  public final List<bu> q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(124580);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + aqo(paramString) + " WHERE" + bZ(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = getDB().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bu localbu = new bu();
        localbu.convertFrom(paramString);
        paramString.moveToNext();
        if (localbu.isText()) {
          localArrayList.add(localbu);
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
    String str = "SELECT * FROM ( SELECT * FROM " + aqo(paramString) + " WHERE" + bZ(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    ad.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = getDB().a(str, null, 0);
    AppMethodBeat.o(124589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */