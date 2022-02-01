package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class ab
{
  public static String TAG = "MicroMsg.WalletIndexPayMenu";
  
  public static void afB(String paramString)
  {
    AppMethodBeat.i(70428);
    h.baF();
    h.baE().ban().set(at.a.acSq, paramString);
    AppMethodBeat.o(70428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */