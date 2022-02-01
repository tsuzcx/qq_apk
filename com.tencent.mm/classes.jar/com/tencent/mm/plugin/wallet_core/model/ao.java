package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class ao
{
  public static boolean bni()
  {
    AppMethodBeat.i(70534);
    g.ajD();
    if (((Boolean)g.ajC().ajl().get(al.a.IDn, Boolean.FALSE)).booleanValue())
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