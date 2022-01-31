package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
{
  public static boolean bYc()
  {
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxP, Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean bYd()
  {
    g localg = d.bYe();
    y.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[] { Long.valueOf(localg.qPE), Long.valueOf(localg.qPF) });
    if (localg.qPE != -1L)
    {
      e.a(localg);
      if (localg.qPF / 1000L < 600L)
      {
        d.Q(localg.qPE, localg.qPF);
        return true;
      }
      d.bYf();
    }
    return false;
  }
  
  public static void kR(boolean paramBoolean)
  {
    y.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxP, Boolean.valueOf(paramBoolean));
    com.tencent.mm.kernel.g.DP().Dz().mC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.b
 * JD-Core Version:    0.7.0.1
 */