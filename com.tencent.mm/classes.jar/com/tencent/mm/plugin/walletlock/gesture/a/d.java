package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class d
{
  public static void Id(boolean paramBoolean)
  {
    AppMethodBeat.i(129753);
    Log.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    h.baE().ban().set(at.a.acTN, Boolean.valueOf(paramBoolean));
    h.baE().ban().iZy();
    AppMethodBeat.o(129753);
  }
  
  public static boolean imQ()
  {
    AppMethodBeat.i(129752);
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acTN, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129752);
    return bool;
  }
  
  public static boolean imR()
  {
    AppMethodBeat.i(129754);
    i locali = f.imS();
    Log.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(locali.Wgt), Long.valueOf(locali.Wgu) });
    if (locali.Wgt != -1L)
    {
      g.a(locali);
      if (locali.Wgu / 1000L < 600L)
      {
        f.bD(locali.Wgt, locali.Wgu);
        AppMethodBeat.o(129754);
        return true;
      }
      f.imT();
    }
    AppMethodBeat.o(129754);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */