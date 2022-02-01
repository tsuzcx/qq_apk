package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class b
{
  public static boolean evy()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOL, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean evz()
  {
    AppMethodBeat.i(129754);
    g localg = d.evA();
    ac.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.BUn), Long.valueOf(localg.BUo) });
    if (localg.BUn != -1L)
    {
      e.a(localg);
      if (localg.BUo / 1000L < 600L)
      {
        d.aq(localg.BUn, localg.BUo);
        AppMethodBeat.o(129754);
        return true;
      }
      d.evB();
    }
    AppMethodBeat.o(129754);
    return false;
  }
  
  public static void tW(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    ac.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOL, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(129753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */