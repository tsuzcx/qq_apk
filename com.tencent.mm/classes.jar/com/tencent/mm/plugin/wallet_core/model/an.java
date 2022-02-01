package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class an
{
  public static boolean bcB()
  {
    AppMethodBeat.i(70534);
    g.afC();
    if (((Boolean)g.afB().afk().get(ae.a.FsX, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(70534);
      return false;
    }
    AppMethodBeat.o(70534);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */