package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<n>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70581);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(n.info, "LoanEntryInfo") };
    AppMethodBeat.o(70581);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.info, "LoanEntryInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean byd()
  {
    AppMethodBeat.i(70580);
    boolean bool = this.db.execSQL("LoanEntryInfo", "delete from LoanEntryInfo");
    AppMethodBeat.o(70580);
    return bool;
  }
  
  public final n gKR()
  {
    n localn = null;
    AppMethodBeat.i(70579);
    Cursor localCursor = this.db.rawQuery("select * from LoanEntryInfo", null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */