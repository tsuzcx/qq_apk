package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.j;

public final class e
  extends j<y>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(70612);
    SQL_CREATE = new String[] { j.getCreateSQLs(y.info, "WalletBulletin") };
    AppMethodBeat.o(70612);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, y.info, "WalletBulletin", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.e
 * JD-Core Version:    0.7.0.1
 */