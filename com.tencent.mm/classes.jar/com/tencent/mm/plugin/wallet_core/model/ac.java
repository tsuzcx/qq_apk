package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class ac
{
  public static String TAG = "MicroMsg.WalletIndexPayMenu";
  
  public static void UH(String paramString)
  {
    AppMethodBeat.i(70428);
    g.ajS();
    g.ajR().ajA().set(am.a.IUx, paramString);
    AppMethodBeat.o(70428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */