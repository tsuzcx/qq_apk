package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class cl
  extends j<ck>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(32891);
    SQL_CREATE = new String[] { j.getCreateSQLs(ck.info, "UserOpenIdInApp") };
    AppMethodBeat.o(32891);
  }
  
  public cl(e parame)
  {
    super(parame, ck.info, "UserOpenIdInApp", null);
    AppMethodBeat.i(32887);
    this.db = parame;
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    AppMethodBeat.o(32887);
  }
  
  public final boolean a(ck paramck)
  {
    AppMethodBeat.i(32889);
    if ((paramck == null) || (bu.isNullOrNil(paramck.field_appId)) || (bu.isNullOrNil(paramck.field_openId)) || (bu.isNullOrNil(paramck.field_username)))
    {
      ae.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      AppMethodBeat.o(32889);
      return false;
    }
    ContentValues localContentValues = paramck.convertTo();
    if (this.db.replace("UserOpenIdInApp", ck.info.IBM, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { paramck.field_appId, paramck.field_username, Boolean.valueOf(bool) });
      AppMethodBeat.o(32889);
      return bool;
    }
  }
  
  public final ck aVZ(String paramString)
  {
    AppMethodBeat.i(32888);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32888);
      return null;
    }
    Cursor localCursor = this.db.a("UserOpenIdInApp", null, "openId=?", new String[] { bu.aSk(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ae.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32888);
      return null;
    }
    paramString = new ck();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cl
 * JD-Core Version:    0.7.0.1
 */