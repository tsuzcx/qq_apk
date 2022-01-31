package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ca
  extends j<bz>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(29075);
    SQL_CREATE = new String[] { j.getCreateSQLs(bz.info, "UserOpenIdInApp") };
    AppMethodBeat.o(29075);
  }
  
  public ca(e parame)
  {
    super(parame, bz.info, "UserOpenIdInApp", null);
    AppMethodBeat.i(29071);
    this.db = parame;
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    AppMethodBeat.o(29071);
  }
  
  public final boolean a(bz parambz)
  {
    AppMethodBeat.i(29073);
    if ((parambz == null) || (bo.isNullOrNil(parambz.field_appId)) || (bo.isNullOrNil(parambz.field_openId)) || (bo.isNullOrNil(parambz.field_username)))
    {
      ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      AppMethodBeat.o(29073);
      return false;
    }
    ContentValues localContentValues = parambz.convertTo();
    if (this.db.replace("UserOpenIdInApp", bz.info.yrL, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { parambz.field_appId, parambz.field_username, Boolean.valueOf(bool) });
      AppMethodBeat.o(29073);
      return bool;
    }
  }
  
  public final bz asG(String paramString)
  {
    AppMethodBeat.i(29072);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(29072);
      return null;
    }
    Cursor localCursor = this.db.a("UserOpenIdInApp", null, "openId=?", new String[] { bo.wC(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(29072);
      return null;
    }
    paramString = new bz();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(29072);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */