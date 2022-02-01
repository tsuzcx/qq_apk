package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar.a;

public final class ao
{
  public static boolean bJw()
  {
    AppMethodBeat.i(70534);
    g.aAi();
    if (((Boolean)g.aAh().azQ().get(ar.a.Ogk, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(70534);
      return false;
    }
    AppMethodBeat.o(70534);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ao
 * JD-Core Version:    0.7.0.1
 */