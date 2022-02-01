package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class g
  extends MAutoStorage<ae>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70616);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ae.info, "WalletKindInfo") };
    AppMethodBeat.o(70616);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ae.info, "WalletKindInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final ArrayList<ae> gKX()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(70615);
    Cursor localCursor = this.db.rawQuery("select * from WalletKindInfo", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(70615);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        ae localae = new ae();
        localae.convertFrom(localCursor);
        localArrayList.add(localae);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(70615);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */