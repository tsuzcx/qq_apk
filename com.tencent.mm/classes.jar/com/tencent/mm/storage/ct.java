package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ct
  extends MAutoStorage<cs>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(32891);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cs.info, "UserOpenIdInApp") };
    AppMethodBeat.o(32891);
  }
  
  public ct(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, cs.info, "UserOpenIdInApp", null);
    AppMethodBeat.i(32887);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    paramISQLiteDatabase.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    AppMethodBeat.o(32887);
  }
  
  public final boolean a(cs paramcs)
  {
    AppMethodBeat.i(32889);
    if ((paramcs == null) || (Util.isNullOrNil(paramcs.field_appId)) || (Util.isNullOrNil(paramcs.field_openId)) || (Util.isNullOrNil(paramcs.field_username)))
    {
      Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      AppMethodBeat.o(32889);
      return false;
    }
    ContentValues localContentValues = paramcs.convertTo();
    if (this.db.replace("UserOpenIdInApp", cs.info.primaryKey, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { paramcs.field_appId, paramcs.field_username, Boolean.valueOf(bool) });
      AppMethodBeat.o(32889);
      return bool;
    }
  }
  
  public final cs bxx(String paramString)
  {
    AppMethodBeat.i(32888);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32888);
      return null;
    }
    Cursor localCursor = this.db.query("UserOpenIdInApp", null, "openId=?", new String[] { Util.escapeSqlValue(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32888);
      return null;
    }
    paramString = new cs();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ct
 * JD-Core Version:    0.7.0.1
 */