package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class b
{
  public static boolean ege()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqV, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean egf()
  {
    AppMethodBeat.i(129754);
    g localg = d.egg();
    ad.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.ABS), Long.valueOf(localg.ABT) });
    if (localg.ABS != -1L)
    {
      e.a(localg);
      if (localg.ABT / 1000L < 600L)
      {
        d.ar(localg.ABS, localg.ABT);
        AppMethodBeat.o(129754);
        return true;
      }
      d.egh();
    }
    AppMethodBeat.o(129754);
    return false;
  }
  
  public static void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    ad.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqV, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(129753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */