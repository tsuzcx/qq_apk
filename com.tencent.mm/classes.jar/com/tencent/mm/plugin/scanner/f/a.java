package com.tencent.mm.plugin.scanner.f;

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
    AppMethodBeat.i(51671);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem") };
    AppMethodBeat.o(51671);
  }
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem", null);
    this.db = parame;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(51670);
    Cursor localCursor = this.db.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    AppMethodBeat.o(51670);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a
 * JD-Core Version:    0.7.0.1
 */