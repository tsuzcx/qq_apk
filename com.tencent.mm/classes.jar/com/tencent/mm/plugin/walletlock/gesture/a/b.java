package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class b
{
  public static boolean eNm()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVF, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean eNn()
  {
    AppMethodBeat.i(129754);
    g localg = d.eNo();
    ae.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.DMm), Long.valueOf(localg.DMn) });
    if (localg.DMm != -1L)
    {
      e.a(localg);
      if (localg.DMn / 1000L < 600L)
      {
        d.au(localg.DMm, localg.DMn);
        AppMethodBeat.o(129754);
        return true;
      }
      d.eNp();
    }
    AppMethodBeat.o(129754);
    return false;
  }
  
  public static void uO(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    ae.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVF, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.ajR().ajA().fuc();
    AppMethodBeat.o(129753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */