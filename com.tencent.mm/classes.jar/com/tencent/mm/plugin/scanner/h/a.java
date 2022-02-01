package com.tencent.mm.plugin.scanner.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<com.tencent.mm.plugin.scanner.history.a.a>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(51671);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem") };
    AppMethodBeat.o(51671);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(51670);
    Cursor localCursor = this.db.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    AppMethodBeat.o(51670);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h.a
 * JD-Core Version:    0.7.0.1
 */