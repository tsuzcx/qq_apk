package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
{
  public static boolean cXK()
  {
    AppMethodBeat.i(51547);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHZ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(51547);
    return bool;
  }
  
  public static boolean cXL()
  {
    AppMethodBeat.i(51549);
    g localg = d.cXM();
    ab.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.uEM), Long.valueOf(localg.uEN) });
    if (localg.uEM != -1L)
    {
      e.a(localg);
      if (localg.uEN / 1000L < 600L)
      {
        d.ae(localg.uEM, localg.uEN);
        AppMethodBeat.o(51549);
        return true;
      }
      d.cXN();
    }
    AppMethodBeat.o(51549);
    return false;
  }
  
  public static void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(51548);
    ab.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHZ, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.RL().Ru().dww();
    AppMethodBeat.o(51548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */