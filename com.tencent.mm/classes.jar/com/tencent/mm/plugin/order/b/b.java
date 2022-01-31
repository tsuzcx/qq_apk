package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(43797);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "OrderCommonMsgXml") };
    AppMethodBeat.o(43797);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "OrderCommonMsgXml", null);
    this.db = parame;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(43794);
    boolean bool = super.insert(parama);
    AppMethodBeat.o(43794);
    return bool;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(43793);
    Cursor localCursor = this.db.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    AppMethodBeat.o(43793);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.b
 * JD-Core Version:    0.7.0.1
 */