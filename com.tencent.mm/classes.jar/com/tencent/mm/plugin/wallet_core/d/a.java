package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class a
  extends j<n>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(70581);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "LoanEntryInfo") };
    AppMethodBeat.o(70581);
  }
  
  public a(e parame)
  {
    super(parame, n.info, "LoanEntryInfo", null);
    this.db = parame;
  }
  
  public final boolean aSJ()
  {
    AppMethodBeat.i(70580);
    boolean bool = this.db.execSQL("LoanEntryInfo", "delete from LoanEntryInfo");
    AppMethodBeat.o(70580);
    return bool;
  }
  
  public final n eGZ()
  {
    n localn = null;
    AppMethodBeat.i(70579);
    Cursor localCursor = this.db.a("select * from LoanEntryInfo", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(70579);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localn = new n();
      localn.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(70579);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */