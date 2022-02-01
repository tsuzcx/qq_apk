package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ac
{
  public static String TAG = "MicroMsg.WalletIndexPayMenu";
  
  public static void aev(String paramString)
  {
    AppMethodBeat.i(70428);
    g.aAi();
    g.aAh().azQ().set(ar.a.OcL, paramString);
    AppMethodBeat.o(70428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */