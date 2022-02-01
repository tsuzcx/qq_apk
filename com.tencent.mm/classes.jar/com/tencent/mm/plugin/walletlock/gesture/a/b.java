package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
{
  public static boolean eJE()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBg, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean eJF()
  {
    AppMethodBeat.i(129754);
    g localg = d.eJG();
    ad.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.DuH), Long.valueOf(localg.DuI) });
    if (localg.DuH != -1L)
    {
      e.a(localg);
      if (localg.DuI / 1000L < 600L)
      {
        d.av(localg.DuH, localg.DuI);
        AppMethodBeat.o(129754);
        return true;
      }
      d.eJH();
    }
    AppMethodBeat.o(129754);
    return false;
  }
  
  public static void uG(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    ad.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBg, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajC().ajl().fqc();
    AppMethodBeat.o(129753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */