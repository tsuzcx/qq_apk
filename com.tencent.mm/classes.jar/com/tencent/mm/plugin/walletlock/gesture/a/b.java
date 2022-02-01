package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
{
  public static boolean fUV()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdX, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean fUW()
  {
    AppMethodBeat.i(129754);
    g localg = d.fUX();
    Log.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.IvB), Long.valueOf(localg.IvC) });
    if (localg.IvB != -1L)
    {
      e.a(localg);
      if (localg.IvC / 1000L < 600L)
      {
        d.aB(localg.IvB, localg.IvC);
        AppMethodBeat.o(129754);
        return true;
      }
      d.fUY();
    }
    AppMethodBeat.o(129754);
    return false;
  }
  
  public static void yD(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    Log.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdX, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.aAh().azQ().gBI();
    AppMethodBeat.o(129753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */