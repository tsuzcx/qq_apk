package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ca
  extends j<bz>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(32885);
    SQL_CREATE = new String[] { j.getCreateSQLs(bz.info, "OpenMsgListener") };
    AppMethodBeat.o(32885);
  }
  
  public ca(e parame)
  {
    super(parame, bz.info, "OpenMsgListener", null);
    AppMethodBeat.i(32881);
    this.db = parame;
    parame.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
    parame.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    AppMethodBeat.o(32881);
  }
  
  public final bz aVN(String paramString)
  {
    AppMethodBeat.i(32882);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(32882);
      return null;
    }
    Cursor localCursor = this.db.a("OpenMsgListener", null, "appId=?", new String[] { bu.aSk(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ae.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(32882);
      return null;
    }
    paramString = new bz();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(32882);
    return paramString;
  }
  
  public final Cursor fwz()
  {
    AppMethodBeat.i(32883);
    Cursor localCursor = rawQuery("select * from OpenMsgListener where (status = ?) ", new String[] { "1" });
    AppMethodBeat.o(32883);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */