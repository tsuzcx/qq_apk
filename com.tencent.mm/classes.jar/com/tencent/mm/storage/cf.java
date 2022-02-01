package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.f.c.et;
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

public class cf
  extends MAutoStorage<ce>
{
  public static final String[] SQL_CREATE;
  public static volatile boolean VHr;
  public ISQLiteDatabaseEx nHd;
  
  static
  {
    AppMethodBeat.i(283995);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ce.info, "NotifyMessageRecord") };
    VHr = false;
    AppMethodBeat.o(283995);
  }
  
  public cf(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    this(paramISQLiteDatabaseEx, ce.info, "NotifyMessageRecord", null);
  }
  
  public cf(ISQLiteDatabaseEx paramISQLiteDatabaseEx, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabaseEx, paramMAutoDBInfo, paramString, paramArrayOfString);
    this.nHd = paramISQLiteDatabaseEx;
  }
  
  public static String bv(ca paramca)
  {
    Object localObject = null;
    AppMethodBeat.i(283993);
    paramca = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (paramca != null) {}
    for (paramca = Util.nullAsNil((String)paramca.get(".msg.fromusername"));; paramca = localObject)
    {
      AppMethodBeat.o(283993);
      return paramca;
      Log.i("MicroMsg.NotifyMessageRecordStorage", "not template message, can't find username field from content");
    }
  }
  
  public static String bw(ca paramca)
  {
    AppMethodBeat.i(283994);
    paramca = h.b(paramca, new PString(), new PString(), new PInt(), false);
    AppMethodBeat.o(283994);
    return paramca;
  }
  
  public static boolean hAw()
  {
    return VHr;
  }
  
  public final boolean bu(ca paramca)
  {
    AppMethodBeat.i(283981);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    boolean bool = super.delete(localce, new String[0]);
    AppMethodBeat.o(283981);
    return bool;
  }
  
  public final boolean g(ca paramca, String paramString)
  {
    AppMethodBeat.i(283980);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    localce.field_talker = paramca.field_talker;
    localce.field_createTime = paramca.field_createTime;
    localce.field_digest = paramString;
    boolean bool = super.insert(localce);
    AppMethodBeat.o(283980);
    return bool;
  }
  
  public final boolean h(ca paramca, String paramString)
  {
    AppMethodBeat.i(283982);
    ce localce = new ce();
    localce.field_msgId = paramca.field_msgId;
    localce.field_talker = paramca.field_talker;
    localce.field_createTime = paramca.field_createTime;
    localce.field_digest = paramString;
    boolean bool = super.update(localce, new String[0]);
    AppMethodBeat.o(283982);
    return bool;
  }
  
  public final Cursor hAA()
  {
    AppMethodBeat.i(283989);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SELECT talker,msgId,MAX(createTime) AS createTime").append(",digest FROM NotifyMessageRecord WHERE talker IS NOT NULL AND LENGTH(talker").append(") > 0 GROUP BY talker ORDER BY createTime DESC");
      localObject = this.nHd.rawQuery(((StringBuilder)localObject).toString(), null);
      if (localObject != null)
      {
        ((Cursor)localObject).moveToFirst();
        AppMethodBeat.o(283989);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMsgConversationCursor] exception %s", new Object[] { localException.toString() });
      AppMethodBeat.o(283989);
    }
    return null;
  }
  
  public final int hAx()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(283983);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM message WHERE talker = '").append(Util.escapeSqlValue("notifymessage")).append("'");
      localCursor1 = localCursor2;
      localCursor2 = this.nHd.rawQuery(((StringBuilder)localObject).toString(), null);
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
    AppMethodBeat.o(283983);
    return i;
  }
  
  public final int hAy()
  {
    Cursor localCursor2 = null;
    j = 0;
    AppMethodBeat.i(283984);
    localCursor1 = localCursor2;
    try
    {
      localObject = new StringBuilder();
      localCursor1 = localCursor2;
      ((StringBuilder)localObject).append("SELECT COUNT(*) FROM NotifyMessageRecord");
      localCursor1 = localCursor2;
      localCursor2 = this.nHd.rawQuery(((StringBuilder)localObject).toString(), null);
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
    AppMethodBeat.o(283984);
    return i;
  }
  
  public final boolean hAz()
  {
    bool1 = true;
    AppMethodBeat.i(283986);
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SELECT * FROM message AS MESSAGE LEFT JOIN (SELECT msgId AS ").append("NOTIFY_RECORD_msgId FROM NotifyMessageRecord) AS NOTIFY_RECORD ON MESSAGE.").append("msgId = NOTIFY_RECORD.NOTIFY_RECORD_msgId WHERE MESSAGE.").append("talker = '").append(Util.escapeSqlValue("notifymessage")).append("' AND NOTIFY_RECORD.NOTIFY_RECORD_msgId IS NULL");
        localObject1 = this.nHd.rawQuery(((StringBuilder)localObject1).toString(), null);
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
        AppMethodBeat.o(283986);
        return bool1;
      }
      catch (Exception localException3)
      {
        bool1 = true;
        continue;
      }
      str = bv(localca);
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.NotifyMessageRecordStorage", "username is null or nil");
      }
      localObject2 = new ce();
      ((ce)localObject2).field_msgId = localca.field_msgId;
      ((ce)localObject2).field_createTime = localca.field_createTime;
      ((ce)localObject2).field_talker = str;
      ((ce)localObject2).field_digest = bw(localca);
      continue;
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[handleSyncRecordMsg] exception %s", new Object[] { localException1.toString() });
    }
  }
  
  public final Cursor hB(String paramString, int paramInt)
  {
    AppMethodBeat.i(283992);
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT * FROM ( SELECT * FROM message AS MESSAGE INNER JOIN NotifyMessageRecord AS NOTIFY_RECORD").append(" ON MESSAGE.msgId = NOTIFY_RECORD.msgId").append(" WHERE NOTIFY_RECORD.talker = '").append(Util.escapeSqlValue(paramString)).append("'");
      if (0L > 0L) {}
      for (paramString = " AND createTime > 0";; paramString = "")
      {
        localStringBuilder2.append(paramString).append(" ORDER BY MESSAGE.createTime DESC LIMIT ").append(paramInt).append(") ORDER BY createTime ASC");
        paramString = this.nHd.rawQuery(localStringBuilder1.toString(), null);
        if (paramString == null) {
          break;
        }
        paramString.moveToFirst();
        AppMethodBeat.o(283992);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(283992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cf
 * JD-Core Version:    0.7.0.1
 */