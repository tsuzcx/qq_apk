package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
  
  public o(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh)
  {
    super(paramh);
    AppMethodBeat.i(11826);
    a(bPX(), "bizchatmessage");
    a(new h.b(16, "bizchatmessage", h.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
    AppMethodBeat.o(11826);
  }
  
  private static String ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(11828);
    paramString = " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
    AppMethodBeat.o(11828);
    return paramString;
  }
  
  public final int G(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(11843);
    bi localbi = this.ywv.kB(paramLong2);
    if (localbi.field_msgId == 0L)
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      AppMethodBeat.o(11843);
      return 0;
    }
    String str = TC(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + ba(paramString, paramLong1) + "AND " + this.ywv.bQe() + " AND createTime < " + localbi.field_createTime;
    paramString = bPX().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(11843);
    return i;
  }
  
  public final int Ts(String paramString)
  {
    AppMethodBeat.i(11837);
    ab.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, an.dth() });
    String str = "talker= '" + paramString + "'";
    im(TC(paramString), str);
    int i = bPX().delete(TC(paramString), str, null);
    if (i != 0)
    {
      this.ywv.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.oDU = -1L;
      a(paramString);
    }
    AppMethodBeat.o(11837);
    return i;
  }
  
  protected final boolean a(bi parambi, bf.b paramb)
  {
    AppMethodBeat.i(11831);
    if (parambi == null)
    {
      ab.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      AppMethodBeat.o(11831);
      return false;
    }
    parambi.fR(-1L);
    if (paramb != null)
    {
      if (!f.lg(parambi.field_talker)) {
        break label342;
      }
      if (bo.isNullOrNil(paramb.fmN))
      {
        ab.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambi.dns });
        AppMethodBeat.o(11831);
        return false;
      }
      localObject = new c();
      ((c)localObject).field_bizChatServId = paramb.fmN;
      ((c)localObject).field_brandUserName = parambi.field_talker;
      if (!bo.isNullOrNil(paramb.fmO)) {
        ((c)localObject).field_chatVersion = bo.getInt(paramb.fmO, -1);
      }
      if (!bo.isNullOrNil(paramb.fmM)) {
        ((c)localObject).field_chatType = bo.getInt(paramb.fmM, -1);
      }
      ab.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.fmN, paramb.userId });
      localObject = com.tencent.mm.aj.a.e.e((c)localObject);
      if (localObject == null) {
        break label326;
      }
      parambi.fR(((c)localObject).field_bizChatLocalId);
      parambi.field_bizChatUserId = bo.nullAsNil(paramb.userId);
      parambi.dGK = true;
      if (paramb.fmQ.equals("1")) {
        parambi.hL(1);
      }
      if ((parambi.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = z.afm().dg(parambi.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambi.hL(1);
        }
      }
      if (!bo.isNullOrNil(paramb.userId))
      {
        localObject = new j();
        ((j)localObject).field_userId = paramb.userId;
        ((j)localObject).field_userName = paramb.fmP;
        ((j)localObject).field_brandUserName = parambi.field_talker;
        z.afm().c((j)localObject);
      }
    }
    label326:
    label342:
    while (bo.isNullOrNil(paramb.fmN))
    {
      Object localObject;
      AppMethodBeat.o(11831);
      return true;
      ab.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      AppMethodBeat.o(11831);
      return false;
    }
    ab.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    AppMethodBeat.o(11831);
    return false;
  }
  
  public final String aqO(String paramString)
  {
    AppMethodBeat.i(11827);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!f.lg(paramString)) {
        break;
      }
      AppMethodBeat.o(11827);
      return "bizchatmessage";
    }
    AppMethodBeat.o(11827);
    return null;
  }
  
  public final Cursor b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11834);
    System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(11834);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ba(paramString, paramLong) + "AND " + this.ywv.bQe() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = bPX().a(paramString, null, 0);
    AppMethodBeat.o(11834);
    return paramString;
  }
  
  public final List<bi> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(11832);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      AppMethodBeat.o(11832);
      return null;
    }
    paramLong2 = this.ywv.ap(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      AppMethodBeat.o(11832);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + TC(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ba(paramString, paramLong1) + "AND " + this.ywv.bQe() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
      paramString = bPX().a(paramString, null, 0);
      if (!paramString.moveToFirst()) {}
    }
    else
    {
      for (;;)
      {
        if (paramString.isAfterLast()) {
          break label313;
        }
        bi localbi = new bi();
        localbi.convertFrom(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbi);
          continue;
          paramString = "select * from " + TC(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ba(paramString, paramLong1) + "AND " + this.ywv.bQe() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbi);
      }
    }
    label313:
    paramString.close();
    ab.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(11832);
    return localArrayList;
  }
  
  public final bi bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(11829);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11829);
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + TC(paramString) + " where" + ba(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = bPX().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbi.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(11829);
    return localbi;
  }
  
  public final Cursor bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(11833);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(11833);
      return null;
    }
    Object localObject = TC(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ba(paramString, paramLong) + "AND " + this.ywv.bQf() + "  order by createTime";
    localObject = bPX().a(paramString, null, 0);
    ab.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(11833);
    return localObject;
  }
  
  public final int bd(String paramString, long paramLong)
  {
    AppMethodBeat.i(11836);
    ab.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, an.dth() });
    im(TC(paramString), ba(paramString, paramLong));
    int i = bPX().delete(TC(paramString), ba(paramString, paramLong), null);
    if (i != 0)
    {
      this.ywv.doNotify("delete_talker ".concat(String.valueOf(paramString)));
      paramString = new h.c(paramString, "delete", null, i, (byte)0);
      paramString.oDU = -1L;
      a(paramString);
    }
    AppMethodBeat.o(11836);
    return i;
  }
  
  public final Cursor be(String paramString, long paramLong)
  {
    AppMethodBeat.i(11838);
    paramString = bPX().query(TC(paramString), null, ba(paramString, paramLong), null, null, null, "createTime ASC ");
    AppMethodBeat.o(11838);
    return paramString;
  }
  
  public final int bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(11840);
    if (paramString == null)
    {
      ab.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(11840);
      return -1;
    }
    a locala = z.afl().gF(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      AppMethodBeat.o(11840);
      return i;
    }
    ab.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = bg(paramString, paramLong);
    AppMethodBeat.o(11840);
    return i;
  }
  
  public final int bg(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(11841);
    paramString = "SELECT COUNT(*) FROM " + TC(paramString) + " WHERE " + ba(paramString, paramLong);
    ab.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = bPX().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(11841);
    return i;
  }
  
  public final int bh(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(11842);
    paramString = "SELECT COUNT(*) FROM " + this.ywv.TC(paramString) + " WHERE " + ba(paramString, paramLong) + "AND " + this.ywv.bQe();
    paramString = bPX().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(11842);
    return i;
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(11835);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      AppMethodBeat.o(11835);
      return null;
    }
    String str = TC(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ba(paramString, paramLong1) + "AND " + this.ywv.bQe() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = bPX().a(paramString, null, 0);
    AppMethodBeat.o(11835);
    return paramString;
  }
  
  public final List<bi> o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(11830);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + TC(paramString) + " WHERE" + ba(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = bPX().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bi localbi = new bi();
        localbi.convertFrom(paramString);
        paramString.moveToNext();
        if (localbi.isText()) {
          localArrayList.add(localbi);
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(11830);
    return localArrayList;
  }
  
  public final Cursor p(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(11839);
    String str = "SELECT * FROM ( SELECT * FROM " + TC(paramString) + " WHERE" + ba(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    ab.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = bPX().a(str, null, 0);
    AppMethodBeat.o(11839);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.o
 * JD-Core Version:    0.7.0.1
 */