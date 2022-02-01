package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class cb
  extends j<ca>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(32891);
    SQL_CREATE = new String[] { j.getCreateSQLs(ca.info, "UserOpenIdInApp") };
    AppMethodBeat.o(32891);
  }
  
  public cb(e parame)
  {
    super(parame, ca.info, "UserOpenIdInApp", null);
    AppMethodBeat.i(32887);
    this.db = parame;
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    AppMethodBeat.o(32887);
  }
  
  public final boolean a(ca paramca)
  {
    AppMethodBeat.i(32889);
    if ((paramca == null) || (bt.isNullOrNil(paramca.field_appId)) || (bt.isNullOrNil(paramca.field_openId)) || (bt.isNullOrNil(paramca.field_username)))
    {
      ad.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      AppMethodBeat.o(32889);
      return false;
    }
    ContentValues localContentValues = paramca.convertTo();
    if (this.db.replace("UserOpenIdInApp", ca.info.EYu, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { paramca.field_appId, paramca.field_username, Boolean.valueOf(bool) });
      AppMethodBeat.o(32889);
      return bool;
    }
  }
  
  public final ca aJl(String paramString)
  {
    AppMethodBeat.i(32888);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32888);
      return null;
    }
    Cursor localCursor = this.db.a("UserOpenIdInApp", null, "openId=?", new String[] { bt.aFQ(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ad.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32888);
      return null;
    }
    paramString = new ca();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.cb
 * JD-Core Version:    0.7.0.1
 */