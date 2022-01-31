package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class m
{
  private static String TAG = "MicroMsg.SoterUtil";
  public static int sot = 3;
  
  public static void Fx(int paramInt)
  {
    AppMethodBeat.i(141737);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJt, Integer.valueOf(paramInt));
    AppMethodBeat.o(141737);
  }
  
  public static void cyd()
  {
    AppMethodBeat.i(59347);
    if (bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.RH().E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ab.d(TAG, "alvinluo set all soter support flag to true");
        ac.erA.cJE = true;
        ac.erA.err = 255;
        ac.ery.eqB = 1;
        ac.ery.eqC = 1;
        com.tencent.mm.sdk.platformtools.ab.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(ac.erA.cJE), Integer.valueOf(ac.ery.eqB), Integer.valueOf(ac.ery.eqC) });
      }
      AppMethodBeat.o(59347);
      return;
    }
  }
  
  public static String cye()
  {
    AppMethodBeat.i(59348);
    try
    {
      String str = com.tencent.mm.a.g.w(r.Zq().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(59348);
        return str;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(59348);
    }
    return "";
  }
  
  public static String cyf()
  {
    AppMethodBeat.i(59349);
    String str = "WechatAuthKeyPay&" + r.Zq();
    AppMethodBeat.o(59349);
    return str;
  }
  
  public static boolean cyg()
  {
    AppMethodBeat.i(156849);
    boolean bool = cyh();
    AppMethodBeat.o(156849);
    return bool;
  }
  
  private static boolean cyh()
  {
    AppMethodBeat.i(59352);
    if (!ac.erA.cJE)
    {
      com.tencent.mm.sdk.platformtools.ab.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(59352);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.dVs();
    AppMethodBeat.o(59352);
    return bool;
  }
  
  public static int cyi()
  {
    AppMethodBeat.i(141736);
    int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJt, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(141736);
    return i;
  }
  
  public static boolean eZ(Context paramContext)
  {
    AppMethodBeat.i(59350);
    if ((cyh()) && (com.tencent.soter.core.a.jg(paramContext)))
    {
      AppMethodBeat.o(59350);
      return true;
    }
    AppMethodBeat.o(59350);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.m
 * JD-Core Version:    0.7.0.1
 */