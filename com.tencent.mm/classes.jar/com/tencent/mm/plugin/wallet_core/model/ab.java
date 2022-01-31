package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class ab
{
  public static String TAG = "MicroMsg.WalletIndexPayMenu";
  
  public static void afj(String paramString)
  {
    AppMethodBeat.i(46909);
    g.RM();
    g.RL().Ru().set(ac.a.yHg, paramString);
    AppMethodBeat.o(46909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */