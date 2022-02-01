package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class cm
  extends MAutoStorage<cl>
  implements m
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117342);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cl.info, "shakeverifymessage") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
    AppMethodBeat.o(117342);
  }
  
  public cm(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, cl.info, "shakeverifymessage", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor Pf(int paramInt)
  {
    AppMethodBeat.i(117334);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117334);
    return localObject;
  }
  
  public final boolean a(cl paramcl)
  {
    AppMethodBeat.i(117337);
    if (paramcl == null)
    {
      Log.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(117337);
      return false;
    }
    if (super.insert(paramcl))
    {
      doNotify(paramcl.systemRowid);
      AppMethodBeat.o(117337);
      return true;
    }
    AppMethodBeat.o(117337);
    return false;
  }
  
  public final void aEp(String paramString)
  {
    AppMethodBeat.i(117335);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117335);
  }
  
  public final long aEr(String paramString)
  {
    AppMethodBeat.i(117340);
    if (paramString != null)
    {
      paramString = ((cm)((l)g.af(l.class)).eiu()).gEx();
      if (paramString == null) {}
    }
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = Util.nowSecond();
      if (l1 > l2)
      {
        AppMethodBeat.o(117340);
        return l1;
      }
      AppMethodBeat.o(117340);
      return l2;
    }
  }
  
  public final cl[] bkW(String paramString)
  {
    AppMethodBeat.i(117339);
    Log.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + Util.escapeSqlValue(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      cl localcl = new cl();
      localcl.convertFrom(paramString);
      localArrayList.add(localcl);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117339);
      return null;
    }
    paramString = (cl[])localArrayList.toArray(new cl[localArrayList.size()]);
    AppMethodBeat.o(117339);
    return paramString;
  }
  
  public final void byC()
  {
    AppMethodBeat.i(117336);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117336);
  }
  
  public final int ctM()
  {
    AppMethodBeat.i(117331);
    Cursor localCursor = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117331);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(117331);
      return i;
    }
    AppMethodBeat.o(117331);
    return 0;
  }
  
  public final cl gEx()
  {
    AppMethodBeat.i(117333);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117333);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117333);
      return null;
    }
    cl localcl = new cl();
    localcl.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117333);
    return localcl;
  }
  
  public final cl[] gT(String paramString, int paramInt)
  {
    AppMethodBeat.i(117338);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + Util.escapeSqlValue(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      cl localcl = new cl();
      localcl.convertFrom(paramString);
      localArrayList.add(localcl);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = (cl[])localArrayList.toArray(new cl[localArrayList.size()]);
    AppMethodBeat.o(117338);
    return paramString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(117332);
    Cursor localCursor = this.db.rawQuery("select count(*) from " + getTableName(), null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117332);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(117332);
      return i;
    }
    AppMethodBeat.o(117332);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cm
 * JD-Core Version:    0.7.0.1
 */