package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.c.eo;
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

public final class cf
  extends MAutoStorage<ce>
{
  public static volatile boolean Orv;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabaseEx kOg;
  
  static
  {
    AppMethodBeat.i(232429);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ce.info, "NotifyMessageRecord") };
    Orv = false;
    AppMethodBeat.o(232429);
  }
  
  public cf(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    this(paramISQLiteDatabaseEx, ce.info, "NotifyMessageRecord");
  }
  
  private cf(ISQLiteDatabaseEx paramISQLiteDatabaseEx, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabaseEx, paramMAutoDBInfo, paramString, null);
    this.kOg = paramISQLiteDatabaseEx;
  }
  
  public static String bc(ca paramca)
  {
    Object localObject = null;
    AppMethodBeat.i(232427);
    paramca = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (paramca != null) {}
    for (paramca = Util.nullAsNil((String)paramca.get(".msg.fromusername"));; paramca = localObject)
    {
      AppMethodBeat.o(232427);
      return paramca;
      Log.i("MicroMsg.NotifyMessageRecordStorage", "not template message, can't find username field from content");
    }
  }
  
  public static String bd(ca paramca)
  {
    AppMethodBeat.i(232428);
    paramca = h.b(paramca, new PString(), new PString(), new PInt(), false);
    AppMethodBeat.o(232428);
    return paramca;
  }
  
  public static boolean gEg()
  {
    return Orv;
  }
  
  public final Cursor J(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(232426);
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT * FROM ( SELECT * FROM message AS MESSAGE INNER JOIN NotifyMessageRecord AS NOTIFY_RECORD").append(" ON MESSAGE.msgId = NOTIFY_RECORD.msgId").append(" WHERE NOTIFY_RECORD.talker = '").append(Util.escapeSqlValue(paramString)).append("'");
      if (paramLong > 0L) {}
      for (paramString = " AND createTime > ".concat(String.valueOf(paramLong));; paramString = "")
      {
        localStringBuilder2.append(paramString).append(" ORDER BY MESSAGE.createTime DESC LIMIT ").append(paramInt).append(") ORDER BY createTime ASC");
        paramString = this.kOg.rawQuery(localStringBuilder1.toString(), null);
        if (paramString == null) {
          break;
        }
        paramString.moveToFirst();
        AppMethodBeat.o(232426);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(232426);
    }
  }
  
  public final boolean bb(ca paramca)
  {
    AppMethodBeat.i(232420);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    boolean bool = super.delete(localce, new String[0]);
    AppMethodBeat.o(232420);
    return bool;
  }
  
  public final boolean e(ca paramca, String paramString)
  {
    AppMethodBeat.i(232419);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    localce.field_talker = paramca.field_talker;
    localce.field_createTime = paramca.field_createTime;
    localce.field_digest = paramString;
    boolean bool = super.insert(localce);
    AppMethodBeat.o(232419);
    return bool;
  }
  
  public final boolean f(ca paramca, String paramString)
  {
    AppMethodBeat.i(232421);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    localce.field_talker = paramca.field_talker;
    localce.field_createTime = paramca.field_createTime;
    localce.field_digest = paramString;
    boolean bool = super.update(localce, new String[0]);
    AppMethodBeat.o(232421);
    return bool;
  }
  
  public final int gEh()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(232422);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM message WHERE talker = '").append(Util.escapeSqlValue("notifymessage")).append("'");
      localCursor1 = localCursor2;
      localCursor2 = this.kOg.rawQuery(((StringBuilder)localObject).toString(), null);
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
    AppMethodBeat.o(232422);
    return i;
  }
  
  public final int gEi()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(232423);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM NotifyMessageRecord");
      localCursor1 = localCursor2;
      localCursor2 = this.kOg.rawQuery(((StringBuilder)localObject).toString(), null);
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
    AppMethodBeat.o(232423);
    return i;
  }
  
  public final boolean gEj()
  {
    bool1 = true;
    AppMethodBeat.i(232424);
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SELECT * FROM message AS MESSAGE LEFT JOIN (SELECT msgId AS ").append("NOTIFY_RECORD_msgId FROM NotifyMessageRecord) AS NOTIFY_RECORD ON MESSAGE.").append("msgId = NOTIFY_RECORD.NOTIFY_RECORD_msgId WHERE MESSAGE.").append("talker = '").append(Util.escapeSqlValue("notifymessage")).append("' AND NOTIFY_RECORD.NOTIFY_RECORD_msgId IS NULL");
        localObject1 = this.kOg.rawQuery(((StringBuilder)localObject1).toString(), null);
        try
        {
          ((Cursor)localObject1).moveToFirst();
          localca = new ca();
          localca.convertFrom((Cursor)localObject1);
          if (Util.isNullOrNil(localca.field_talker))
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
          ca localca;
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
        AppMethodBeat.o(232424);
        return bool1;
      }
      catch (Exception localException3)
      {
        bool1 = true;
        continue;
      }
      str = bc(localca);
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.NotifyMessageRecordStorage", "username is null or nil");
      }
      localObject2 = new ce();
      ((ce)localObject2).field_msgId = localca.field_msgId;
      ((ce)localObject2).field_createTime = localca.field_createTime;
      ((ce)localObject2).field_talker = str;
      ((ce)localObject2).field_digest = bd(localca);
      continue;
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[handleSyncRecordMsg] exception %s", new Object[] { localException1.toString() });
    }
  }
  
  public final Cursor gEk()
  {
    AppMethodBeat.i(232425);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SELECT talker,msgId,MAX(createTime) AS createTime").append(",digest FROM NotifyMessageRecord WHERE talker IS NOT NULL AND LENGTH(talker").append(") > 0 GROUP BY talker ORDER BY createTime DESC");
      localObject = this.kOg.rawQuery(((StringBuilder)localObject).toString(), null);
      if (localObject != null)
      {
        ((Cursor)localObject).moveToFirst();
        AppMethodBeat.o(232425);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMsgConversationCursor] exception %s", new Object[] { localException.toString() });
      AppMethodBeat.o(232425);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.cf
 * JD-Core Version:    0.7.0.1
 */