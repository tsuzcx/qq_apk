package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<y>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70612);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(y.info, "WalletBulletin") };
    AppMethodBeat.o(70612);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, y.info, "WalletBulletin", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.e
 * JD-Core Version:    0.7.0.1
 */