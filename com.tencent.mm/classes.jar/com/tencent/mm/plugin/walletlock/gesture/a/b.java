package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
{
  public static void Cy(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    Log.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    h.aHG().aHp().set(ar.a.Vsi, Boolean.valueOf(paramBoolean));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(129753);
  }
  
  public static boolean gNB()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.Vsi, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean gNC()
  {
    AppMethodBeat.i(129754);
    g localg = d.gND();
    Log.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.PpG), Long.valueOf(localg.PpH) });
    if (localg.PpG != -1L)
    {
      e.a(localg);
      if (localg.PpH / 1000L < 600L)
      {
        d.aR(localg.PpG, localg.PpH);
        AppMethodBeat.o(129754);
        return true;
      }
      d.gNE();
    }
    AppMethodBeat.o(129754);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */