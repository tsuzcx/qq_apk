package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class an
{
  public static boolean Pk()
  {
    AppMethodBeat.i(47002);
    g.RM();
    if (((Boolean)g.RL().Ru().get(ac.a.yJM, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(47002);
      return false;
    }
    AppMethodBeat.o(47002);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */