package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class ce
  extends j<cd>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(32891);
    SQL_CREATE = new String[] { j.getCreateSQLs(cd.info, "UserOpenIdInApp") };
    AppMethodBeat.o(32891);
  }
  
  public ce(e parame)
  {
    super(parame, cd.info, "UserOpenIdInApp", null);
    AppMethodBeat.i(32887);
    this.db = parame;
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    AppMethodBeat.o(32887);
  }
  
  public final boolean a(cd paramcd)
  {
    AppMethodBeat.i(32889);
    if ((paramcd == null) || (bs.isNullOrNil(paramcd.field_appId)) || (bs.isNullOrNil(paramcd.field_openId)) || (bs.isNullOrNil(paramcd.field_username)))
    {
      ac.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      AppMethodBeat.o(32889);
      return false;
    }
    ContentValues localContentValues = paramcd.convertTo();
    if (this.db.replace("UserOpenIdInApp", cd.info.GvG, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { paramcd.field_appId, paramcd.field_username, Boolean.valueOf(bool) });
      AppMethodBeat.o(32889);
      return bool;
    }
  }
  
  public final cd aOH(String paramString)
  {
    AppMethodBeat.i(32888);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32888);
      return null;
    }
    Cursor localCursor = this.db.a("UserOpenIdInApp", null, "openId=?", new String[] { bs.aLh(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ac.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32888);
      return null;
    }
    paramString = new cd();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ce
 * JD-Core Version:    0.7.0.1
 */