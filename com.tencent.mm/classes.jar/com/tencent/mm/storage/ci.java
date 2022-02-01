package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ci
  extends MAutoStorage<ch>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(32885);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ch.info, "OpenMsgListener") };
    AppMethodBeat.o(32885);
  }
  
  public ci(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ch.info, "OpenMsgListener", null);
    AppMethodBeat.i(32881);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
    paramISQLiteDatabase.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    AppMethodBeat.o(32881);
  }
  
  public final ch byD(String paramString)
  {
    AppMethodBeat.i(32882);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32882);
      return null;
    }
    Cursor localCursor = this.db.query("OpenMsgListener", null, "appId=?", new String[] { Util.escapeSqlValue(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32882);
      return null;
    }
    paramString = new ch();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32882);
    return paramString;
  }
  
  public final Cursor jcE()
  {
    AppMethodBeat.i(32883);
    Cursor localCursor = rawQuery("select * from OpenMsgListener where (status = ?) ", new String[] { "1" });
    AppMethodBeat.o(32883);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ci
 * JD-Core Version:    0.7.0.1
 */