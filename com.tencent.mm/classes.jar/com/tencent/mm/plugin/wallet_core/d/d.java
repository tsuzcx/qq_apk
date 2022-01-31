package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d
  extends j<w>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(47072);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "WalletBulletin") };
    AppMethodBeat.o(47072);
  }
  
  public d(e parame)
  {
    super(parame, w.info, "WalletBulletin", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.d
 * JD-Core Version:    0.7.0.1
 */