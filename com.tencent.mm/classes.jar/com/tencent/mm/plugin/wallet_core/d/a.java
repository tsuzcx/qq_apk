package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class a
  extends j<p>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(47049);
    SQL_CREATE = new String[] { j.getCreateSQLs(p.info, "LoanEntryInfo") };
    AppMethodBeat.o(47049);
  }
  
  public a(e parame)
  {
    super(parame, p.info, "LoanEntryInfo", null);
    this.db = parame;
  }
  
  public final boolean aql()
  {
    AppMethodBeat.i(47048);
    boolean bool = this.db.execSQL("LoanEntryInfo", "delete from LoanEntryInfo");
    AppMethodBeat.o(47048);
    return bool;
  }
  
  public final p cVd()
  {
    p localp = null;
    AppMethodBeat.i(47047);
    Cursor localCursor = this.db.a("select * from LoanEntryInfo", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(47047);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localp = new p();
      localp.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(47047);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */