package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.message.b.a;
import com.tencent.mm.message.b.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;

public final class cg
  extends MAutoStorage<c>
  implements a
{
  public static final String[] SQL_CREATE;
  private static volatile boolean adlm;
  private ISQLiteDatabaseEx qGR;
  
  static
  {
    AppMethodBeat.i(248454);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "NotifyMessageRecord") };
    adlm = false;
    AppMethodBeat.o(248454);
  }
  
  public cg(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    this(paramISQLiteDatabaseEx, c.info, "NotifyMessageRecord");
  }
  
  private cg(ISQLiteDatabaseEx paramISQLiteDatabaseEx, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabaseEx, paramMAutoDBInfo, paramString, null);
    this.qGR = paramISQLiteDatabaseEx;
  }
  
  private int jcA()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(248448);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM message WHERE talker = '").append(Util.escapeSqlValue("notifymessage")).append("'");
      localCursor1 = localCursor2;
      localCursor2 = this.qGR.rawQuery(((StringBuilder)localObject).toString(), null);
      localCursor1 = localCursor2;
      localCursor2.moveToFirst();
      i = j;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      if (localCursor2.moveToLast())
      {
        localCursor1 = localCursor2;
        i = localCursor2.getInt(0);
        localObject = localCursor2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMessageCount] exception %s", new Object[] { localException.toString() });
        int i = j;
        Object localObject = localCursor1;
      }
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(248448);
    return i;
  }
  
  private int jcB()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(248449);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM NotifyMessageRecord");
      localCursor1 = localCursor2;
      localCursor2 = this.qGR.rawQuery(((StringBuilder)localObject).toString(), null);
      localCursor1 = localCursor2;
      localCursor2.moveToFirst();
      i = j;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      if (localCursor2.moveToLast())
      {
        localCursor1 = localCursor2;
        i = localCursor2.getInt(0);
        localObject = localCursor2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMessageRecordCount] exception %s", new Object[] { localException.toString() });
        int i = j;
        Object localObject = localCursor1;
      }
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(248449);
    return i;
  }
  
  private boolean jcC()
  {
    bool1 = true;
    AppMethodBeat.i(248452);
    Log.i("MicroMsg.NotifyMessageRecordStorage", "sync msg not in record start");
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SELECT * FROM message AS MESSAGE LEFT JOIN (SELECT msgId AS ").append("NOTIFY_RECORD_msgId FROM NotifyMessageRecord) AS NOTIFY_RECORD ON MESSAGE.").append("msgId = NOTIFY_RECORD.NOTIFY_RECORD_msgId WHERE MESSAGE.").append("talker = '").append(Util.escapeSqlValue("notifymessage")).append("' AND NOTIFY_RECORD.NOTIFY_RECORD_msgId IS NULL");
        localObject1 = this.qGR.rawQuery(((StringBuilder)localObject1).toString(), null);
        try
        {
          ((Cursor)localObject1).moveToFirst();
          localcc = new cc();
          localcc.convertFrom((Cursor)localObject1);
          if (Util.isNullOrNil(localcc.field_talker))
          {
            Log.i("MicroMsg.NotifyMessageRecordStorage", "talker is null");
            localObject2 = null;
            if (localObject2 != null) {
              insertNotify((IAutoDBItem)localObject2, false);
            }
            boolean bool2 = ((Cursor)localObject1).moveToNext();
            if (bool2) {
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          cc localcc;
          Object localObject2;
          String str;
          bool1 = false;
        }
      }
      catch (Exception localException2)
      {
        bool1 = false;
        Object localObject1 = null;
        continue;
      }
      try
      {
        Log.i("MicroMsg.NotifyMessageRecordStorage", "sync row: %d", new Object[] { Integer.valueOf(((Cursor)localObject1).getCount()) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        Log.i("MicroMsg.NotifyMessageRecordStorage", "sync msg not in record finish");
        AppMethodBeat.o(248452);
        return bool1;
      }
      catch (Exception localException3)
      {
        bool1 = true;
        continue;
      }
      str = z(localcc);
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.NotifyMessageRecordStorage", "username is null or nil");
      }
      localObject2 = new c();
      ((c)localObject2).field_msgId = localcc.field_msgId;
      ((c)localObject2).field_createTime = localcc.getCreateTime();
      ((c)localObject2).field_talker = str;
      ((c)localObject2).field_digest = A(localcc);
      continue;
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[syncMsgNotInRecord] exception %s", new Object[] { localException1.toString() });
    }
  }
  
  private boolean jcD()
  {
    bool = true;
    AppMethodBeat.i(248453);
    Log.i("MicroMsg.NotifyMessageRecordStorage", "delete unreachable record start");
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DELETE FROM NotifyMessageRecord WHERE msgId IN (SELECT NotifyMessageRecord.").append("msgId FROM NotifyMessageRecord LEFT JOIN message ON NotifyMessageRecord.").append("msgId = message.msgId WHERE message.").append("talker IS NULL OR message.talker != '").append(Util.escapeSqlValue("notifymessage")).append("')");
        this.qGR.execSQL("NotifyMessageRecord", ((StringBuilder)localObject).toString());
      }
      catch (Exception localException1)
      {
        Object localObject;
        bool = false;
      }
      try
      {
        localObject = new Object[1];
        throw new NullPointerException();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          bool = true;
        }
      }
      Log.i("MicroMsg.NotifyMessageRecordStorage", "delete unreachable record finish");
      AppMethodBeat.o(248453);
      return bool;
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[deleteUnreachableRecord] exception %s", new Object[] { localException1.toString() });
    }
  }
  
  public final String A(cc paramcc)
  {
    AppMethodBeat.i(248507);
    paramcc = h.b(paramcc, new PString(), new PString(), new PInt(), false);
    AppMethodBeat.o(248507);
    return paramcc;
  }
  
  public final Cursor Ho(String paramString)
  {
    AppMethodBeat.i(248480);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SELECT WX_CONTACT.nickname, NOTIFY_RECORD.talker").append(", COUNT(NOTIFY_RECORD.msgId) FROM NotifyMessageRecord").append(" AS NOTIFY_RECORD LEFT JOIN rcontact AS WX_CONTACT ON NOTIFY_RECORD").append(".talker = WX_CONTACT.username WHERE NOTIFY_RECORD").append(".talker != 'notifymessage'");
      if (!Util.isNullOrNil(paramString)) {
        localStringBuilder.append(" AND WX_CONTACT.nickname LIKE '%").append(paramString).append("%'");
      }
      localStringBuilder.append(" GROUP BY NOTIFY_RECORD.talker");
      paramString = this.qGR.rawQuery(localStringBuilder.toString(), null);
      if (paramString != null)
      {
        paramString.moveToFirst();
        AppMethodBeat.o(248480);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(248480);
    }
    return null;
  }
  
  public final int Hp(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(248485);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramString)).append("'");
    paramString = this.qGR.rawQuery(localStringBuilder.toString(), null);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    AppMethodBeat.o(248485);
    return i;
  }
  
  public final long Hq(String paramString)
  {
    AppMethodBeat.i(248492);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT createTime FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramString)).append("' ORDER BY createTime DESC LIMIT 1");
    paramString = this.qGR.rawQuery(localStringBuilder.toString(), null);
    if (paramString.moveToFirst())
    {
      long l = paramString.getLong(0);
      paramString.close();
      AppMethodBeat.o(248492);
      return l;
    }
    paramString.close();
    AppMethodBeat.o(248492);
    return -1L;
  }
  
  public final boolean a(cc paramcc, String paramString)
  {
    AppMethodBeat.i(248456);
    c localc = new c();
    localc.field_msgId = paramcc.field_msgId;
    localc.field_talker = paramcc.field_talker;
    localc.field_createTime = paramcc.getCreateTime();
    localc.field_digest = paramString;
    boolean bool = super.insert(localc);
    AppMethodBeat.o(248456);
    return bool;
  }
  
  public final Cursor aH(String paramString, int paramInt)
  {
    AppMethodBeat.i(248472);
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT * FROM ( SELECT * FROM message AS MESSAGE INNER JOIN NotifyMessageRecord AS NOTIFY_RECORD").append(" ON MESSAGE.msgId = NOTIFY_RECORD.msgId").append(" WHERE NOTIFY_RECORD.talker = '").append(Util.escapeSqlValue(paramString)).append("'");
      if (0L > 0L) {}
      for (paramString = " AND MESSAGE.createTime > 0";; paramString = "")
      {
        localStringBuilder2.append(paramString).append(" ORDER BY MESSAGE.createTime DESC LIMIT ").append(paramInt).append(") ORDER BY createTime ASC");
        paramString = this.qGR.rawQuery(localStringBuilder1.toString(), null);
        if (paramString == null) {
          break;
        }
        paramString.moveToFirst();
        AppMethodBeat.o(248472);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(248472);
    }
  }
  
  public final boolean b(cc paramcc, String paramString)
  {
    AppMethodBeat.i(248462);
    c localc = new c();
    localc.field_msgId = paramcc.field_msgId;
    localc.field_talker = paramcc.field_talker;
    localc.field_createTime = paramcc.getCreateTime();
    localc.field_digest = paramString;
    boolean bool = super.update(localc, new String[0]);
    AppMethodBeat.o(248462);
    return bool;
  }
  
  public final boolean bwv()
  {
    AppMethodBeat.i(248464);
    if (jcA() != jcB()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NotifyMessageRecordStorage", "need sync record: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(248464);
      return bool;
    }
  }
  
  public final boolean bww()
  {
    return adlm;
  }
  
  public final boolean bwx()
  {
    AppMethodBeat.i(248466);
    if (adlm)
    {
      Log.e("MicroMsg.NotifyMessageRecordStorage", "sync is running");
      AppMethodBeat.o(248466);
      return false;
    }
    Log.i("MicroMsg.NotifyMessageRecordStorage", "syncRecord");
    long l = Util.currentTicks();
    adlm = true;
    boolean bool1 = jcC();
    boolean bool2 = jcD();
    Log.i("MicroMsg.NotifyMessageRecordStorage", "handle msg info done, cost: %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    adlm = false;
    AppMethodBeat.o(248466);
    return bool1 & bool2;
  }
  
  public final boolean bwy()
  {
    AppMethodBeat.i(248460);
    boolean bool = execSQL("NotifyMessageRecord", "DELETE FROM NotifyMessageRecord");
    AppMethodBeat.o(248460);
    return bool;
  }
  
  public final Cursor bwz()
  {
    AppMethodBeat.i(248469);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SELECT talker,msgId,MAX(createTime) AS createTime").append(",digest FROM NotifyMessageRecord WHERE talker IS NOT NULL AND LENGTH(talker").append(") > 0 AND talker != 'notifymessage' GROUP BY talker").append(" ORDER BY createTime DESC");
      localObject = this.qGR.rawQuery(((StringBuilder)localObject).toString(), null);
      if (localObject != null)
      {
        ((Cursor)localObject).moveToFirst();
        AppMethodBeat.o(248469);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMsgConversationCursor] exception %s", new Object[] { localException.toString() });
      AppMethodBeat.o(248469);
    }
    return null;
  }
  
  public final Cursor j(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248477);
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT * FROM ( SELECT * FROM message AS MESSAGE INNER JOIN NotifyMessageRecord AS NOTIFY_RECORD").append(" ON MESSAGE.msgId = NOTIFY_RECORD.msgId").append(" WHERE NOTIFY_RECORD.talker = '").append(Util.escapeSqlValue(paramString)).append("'");
      if (paramLong1 > 0L)
      {
        paramString = " AND MESSAGE.createTime >= ".concat(String.valueOf(paramLong1));
        localStringBuilder2 = localStringBuilder2.append(paramString);
        if (paramLong2 <= 0L) {
          break label148;
        }
      }
      label148:
      for (paramString = " AND MESSAGE.createTime <= ".concat(String.valueOf(paramLong2));; paramString = "")
      {
        localStringBuilder2.append(paramString).append(" ORDER BY MESSAGE.createTime DESC ) ORDER BY createTime ASC");
        paramString = this.qGR.rawQuery(localStringBuilder1.toString(), null);
        if (paramString == null) {
          break label175;
        }
        paramString.moveToFirst();
        AppMethodBeat.o(248477);
        return paramString;
        paramString = "";
        break;
      }
      label175:
      return null;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(248477);
    }
  }
  
  public final int k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248489);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT COUNT(*) FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramString)).append("'");
    if (paramLong1 > 0L)
    {
      paramString = " AND createTime >= ".concat(String.valueOf(paramLong1));
      localStringBuilder2 = localStringBuilder2.append(paramString);
      if (paramLong2 <= 0L) {
        break label144;
      }
      paramString = " AND createTime <= ".concat(String.valueOf(paramLong2));
      label81:
      localStringBuilder2.append(paramString);
      paramString = this.qGR.rawQuery(localStringBuilder1.toString(), null);
      if (!paramString.moveToLast()) {
        break label151;
      }
    }
    label144:
    label151:
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      AppMethodBeat.o(248489);
      return i;
      paramString = "";
      break;
      paramString = "";
      break label81;
    }
  }
  
  public final long v(String paramString, long paramLong)
  {
    AppMethodBeat.i(248496);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT createTime FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramString)).append("'");
    if (paramLong > 0L) {}
    for (paramString = " AND createTime < ".concat(String.valueOf(paramLong));; paramString = "")
    {
      localStringBuilder2.append(paramString).append(" ORDER BY createTime DESC LIMIT 48");
      paramString = this.qGR.rawQuery(localStringBuilder1.toString(), null);
      if (!paramString.moveToLast()) {
        break;
      }
      paramLong = paramString.getLong(0);
      Log.d("MicroMsg.NotifyMessageRecordStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(248496);
      return paramLong;
    }
    paramString.close();
    Log.w("MicroMsg.NotifyMessageRecordStorage", "get result fail");
    AppMethodBeat.o(248496);
    return paramLong;
  }
  
  public final long w(String paramString, long paramLong)
  {
    AppMethodBeat.i(248501);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT createTime FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(paramString)).append("'");
    if (paramLong > 0L) {}
    for (paramString = " AND createTime > ".concat(String.valueOf(paramLong));; paramString = "")
    {
      localStringBuilder2.append(paramString).append(" ORDER BY createTime ASC LIMIT 48");
      paramString = this.qGR.rawQuery(localStringBuilder1.toString(), null);
      if (!paramString.moveToFirst()) {
        break;
      }
      paramLong = paramString.getLong(0);
      Log.d("MicroMsg.NotifyMessageRecordStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      AppMethodBeat.o(248501);
      return paramLong;
    }
    paramString.close();
    Log.w("MicroMsg.NotifyMessageRecordStorage", "get result fail");
    AppMethodBeat.o(248501);
    return paramLong;
  }
  
  public final boolean y(cc paramcc)
  {
    AppMethodBeat.i(248458);
    c localc = new c();
    localc.field_msgId = paramcc.field_msgId;
    boolean bool = super.delete(localc, new String[0]);
    AppMethodBeat.o(248458);
    return bool;
  }
  
  public final String z(cc paramcc)
  {
    Object localObject = null;
    AppMethodBeat.i(248505);
    paramcc = XmlParser.parseXml(paramcc.field_content, "msg", null);
    if (paramcc != null) {}
    for (paramcc = Util.nullAsNil((String)paramcc.get(".msg.fromusername"));; paramcc = localObject)
    {
      AppMethodBeat.o(248505);
      return paramcc;
      Log.i("MicroMsg.NotifyMessageRecordStorage", "not template message, can't find username field from content");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cg
 * JD-Core Version:    0.7.0.1
 */