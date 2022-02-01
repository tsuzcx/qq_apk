package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(66705);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "OrderCommonMsgXml") };
    AppMethodBeat.o(66705);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "OrderCommonMsgXml", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(66702);
    boolean bool = super.insert(parama);
    AppMethodBeat.o(66702);
    return bool;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(66701);
    Cursor localCursor = this.db.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    AppMethodBeat.o(66701);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.b
 * JD-Core Version:    0.7.0.1
 */