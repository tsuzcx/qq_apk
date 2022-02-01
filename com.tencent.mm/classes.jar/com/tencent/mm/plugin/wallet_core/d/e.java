package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.e.j;

public final class e
  extends j<x>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(70612);
    SQL_CREATE = new String[] { j.getCreateSQLs(x.info, "WalletBulletin") };
    AppMethodBeat.o(70612);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, x.info, "WalletBulletin", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.e
 * JD-Core Version:    0.7.0.1
 */