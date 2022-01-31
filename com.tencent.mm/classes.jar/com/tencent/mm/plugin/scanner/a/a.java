package com.tencent.mm.plugin.scanner.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class a
  extends j<com.tencent.mm.plugin.scanner.history.a.a>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(80895);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem") };
    AppMethodBeat.o(80895);
  }
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem", null);
    this.db = parame;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(80894);
    Cursor localCursor = this.db.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    AppMethodBeat.o(80894);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.a
 * JD-Core Version:    0.7.0.1
 */