package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o
  extends e
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
  
  public o(g paramg)
  {
    super(paramg);
    a(bhV(), "bizchatmessage");
    a(new g.b(16, "bizchatmessage", g.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
  }
  
  private static String as(String paramString, long paramLong)
  {
    return " bizChatId= " + paramLong + " AND talker= '" + paramString + "'";
  }
  
  public final int HG(String paramString)
  {
    y.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[] { paramString, ak.crj() });
    String str = "talker= '" + paramString + "'";
    gl(HT(paramString), str);
    int i = bhV().delete(HT(paramString), str, null);
    if (i != 0)
    {
      this.umP.aam("delete_talker " + paramString);
      paramString = new g.c(paramString, "delete", null, i, (byte)0);
      paramString.mdy = -1L;
      a(paramString);
    }
    return i;
  }
  
  protected final boolean a(bi parambi, bd.b paramb)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      return false;
    }
    parambi.bh(-1L);
    if (paramb != null)
    {
      if (!f.eW(parambi.field_talker)) {
        break label310;
      }
      if (bk.bl(paramb.dWF))
      {
        y.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { parambi.czr });
        return false;
      }
      localObject = new c();
      ((c)localObject).field_bizChatServId = paramb.dWF;
      ((c)localObject).field_brandUserName = parambi.field_talker;
      if (!bk.bl(paramb.dWG)) {
        ((c)localObject).field_chatVersion = bk.getInt(paramb.dWG, -1);
      }
      if (!bk.bl(paramb.dWE)) {
        ((c)localObject).field_chatType = bk.getInt(paramb.dWE, -1);
      }
      y.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.dWF, paramb.userId });
      localObject = com.tencent.mm.ai.a.e.e((c)localObject);
      if (localObject == null) {
        break label300;
      }
      parambi.bh(((c)localObject).field_bizChatLocalId);
      parambi.field_bizChatUserId = bk.pm(paramb.userId);
      parambi.cQy = true;
      if (paramb.dWI.equals("1")) {
        parambi.fA(1);
      }
      if ((parambi.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = z.MC().bZ(parambi.field_talker);
        if (paramb.userId.equals(localObject)) {
          parambi.fA(1);
        }
      }
      if (!bk.bl(paramb.userId))
      {
        localObject = new j();
        ((j)localObject).field_userId = paramb.userId;
        ((j)localObject).field_userName = paramb.dWH;
        ((j)localObject).field_brandUserName = parambi.field_talker;
        z.MC().c((j)localObject);
      }
    }
    label300:
    label310:
    while (bk.bl(paramb.dWF))
    {
      Object localObject;
      return true;
      y.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      return false;
    }
    y.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    return false;
  }
  
  public final String aaD(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!f.eW(paramString)) {
        break;
      }
      return "bizchatmessage";
    }
    return null;
  }
  
  public final bi at(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    bi localbi = new bi();
    paramString = "select * from " + HT(paramString) + " where" + as(paramString, paramLong) + "order by createTime DESC limit 1";
    paramString = bhV().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localbi.d(paramString);
    }
    paramString.close();
    return localbi;
  }
  
  public final Cursor au(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    Object localObject = HT(paramString);
    paramString = "select * from " + (String)localObject + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + as(paramString, paramLong) + "AND " + this.umP.bid() + "  order by createTime";
    localObject = bhV().a(paramString, null, 0);
    y.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    return localObject;
  }
  
  public final int av(String paramString, long paramLong)
  {
    y.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, ak.crj() });
    gl(HT(paramString), as(paramString, paramLong));
    int i = bhV().delete(HT(paramString), as(paramString, paramLong), null);
    if (i != 0)
    {
      this.umP.aam("delete_talker " + paramString);
      paramString = new g.c(paramString, "delete", null, i, (byte)0);
      paramString.mdy = -1L;
      a(paramString);
    }
    return i;
  }
  
  public final Cursor aw(String paramString, long paramLong)
  {
    return bhV().query(HT(paramString), null, as(paramString, paramLong), null, null, null, "createTime ASC ");
  }
  
  public final int ax(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      y.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      return -1;
    }
    a locala = z.MB().bK(paramLong);
    if (locala.field_msgCount != 0) {
      return locala.field_msgCount;
    }
    y.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    return ay(paramString, paramLong);
  }
  
  public final int ay(String paramString, long paramLong)
  {
    int i = 0;
    paramString = "SELECT COUNT(*) FROM " + HT(paramString) + " WHERE " + as(paramString, paramLong);
    y.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = bhV().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final int az(String paramString, long paramLong)
  {
    int i = 0;
    paramString = "SELECT COUNT(*) FROM " + this.umP.HT(paramString) + " WHERE " + as(paramString, paramLong) + "AND " + this.umP.bic();
    paramString = bhV().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
  
  public final Cursor b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from ( select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + as(paramString, paramLong) + "AND " + this.umP.bic() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    return bhV().a(paramString, null, 0);
  }
  
  public final Cursor b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      return null;
    }
    String str = HT(paramString);
    paramString = "select * from " + str + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + as(paramString, paramLong1) + "AND " + this.umP.bic() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    return bhV().a(paramString, null, 0);
  }
  
  public final List<bi> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      return null;
    }
    paramLong2 = this.umP.X(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      y.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + HT(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + as(paramString, paramLong1) + "AND " + this.umP.bic() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
      paramString = bhV().a(paramString, null, 0);
      if (!paramString.moveToFirst()) {}
    }
    else
    {
      for (;;)
      {
        if (paramString.isAfterLast()) {
          break label298;
        }
        bi localbi = new bi();
        localbi.d(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localbi);
          continue;
          paramString = "select * from " + HT(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + as(paramString, paramLong1) + "AND " + this.umP.bic() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localbi);
      }
    }
    label298:
    paramString.close();
    y.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localArrayList;
  }
  
  public final List<bi> k(String paramString, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + HT(paramString) + " WHERE" + as(paramString, paramLong) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = bhV().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        bi localbi = new bi();
        localbi.d(paramString);
        paramString.moveToNext();
        if (localbi.isText()) {
          localArrayList.add(localbi);
        }
      }
    }
    paramString.close();
    return localArrayList;
  }
  
  public final Cursor l(String paramString, long paramLong, int paramInt)
  {
    String str = "SELECT * FROM ( SELECT * FROM " + HT(paramString) + " WHERE" + as(paramString, paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    y.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    return bhV().a(str, null, 0);
  }
  
  public final int y(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    bi localbi = this.umP.fd(paramLong2);
    if (localbi.field_msgId == 0L)
    {
      y.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      return 0;
    }
    String str = HT(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + as(paramString, paramLong1) + "AND " + this.umP.bic() + " AND createTime < " + localbi.field_createTime;
    paramString = bhV().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.o
 * JD-Core Version:    0.7.0.1
 */