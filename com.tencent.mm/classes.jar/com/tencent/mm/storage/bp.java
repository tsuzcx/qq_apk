package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class bp
  extends j<bo>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(29069);
    SQL_CREATE = new String[] { j.getCreateSQLs(bo.info, "OpenMsgListener") };
    AppMethodBeat.o(29069);
  }
  
  public bp(e parame)
  {
    super(parame, bo.info, "OpenMsgListener", null);
    AppMethodBeat.i(29065);
    this.db = parame;
    parame.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
    parame.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    AppMethodBeat.o(29065);
  }
  
  public final bo asu(String paramString)
  {
    AppMethodBeat.i(29066);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(29066);
      return null;
    }
    Cursor localCursor = this.db.a("OpenMsgListener", null, "appId=?", new String[] { com.tencent.mm.sdk.platformtools.bo.wC(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(29066);
      return null;
    }
    paramString = new bo();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(29066);
    return paramString;
  }
  
  public final Cursor dyD()
  {
    AppMethodBeat.i(29067);
    Cursor localCursor = rawQuery("select * from OpenMsgListener where (status = ?) ", new String[] { "1" });
    AppMethodBeat.o(29067);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */