package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;

public final class b
{
  private static b agRB;
  
  public static boolean b(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72645);
    if (!e.aQh())
    {
      AppMethodBeat.o(72645);
      return false;
    }
    try
    {
      i locali = i.agtt;
      i = i.a(b.a.agsx, 0);
      paramBoolean = ((c)h.ax(c.class)).a(parama, paramBoolean);
      Log.i("MicroMsg.TenPaySdkAbTest", "isKindaBindCardEnable configval %s svrConfig %s isDebug %s isFlavorRed %s isFlavorPurple %s BuildInfo %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(BuildInfo.IS_FLAVOR_RED), Boolean.valueOf(BuildInfo.IS_FLAVOR_PURPLE), BuildInfo.KINDA_DEFAULT });
      if ("open".equals(BuildInfo.KINDA_DEFAULT))
      {
        AppMethodBeat.o(72645);
        return true;
      }
    }
    catch (com.tencent.mm.model.b localb)
    {
      int i;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TenPaySdkAbTest", localb, "isKindaEnable get configVal error! AccountNotReady!", new Object[0]);
        i = 0;
      }
      if ("close".equals(BuildInfo.KINDA_DEFAULT))
      {
        AppMethodBeat.o(72645);
        return false;
      }
      if (i == 1)
      {
        AppMethodBeat.o(72645);
        return true;
      }
      if (i == 2)
      {
        AppMethodBeat.o(72645);
        return false;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(72645);
        return true;
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        AppMethodBeat.o(72645);
        return true;
      }
      AppMethodBeat.o(72645);
    }
    return false;
  }
  
  public static b jNX()
  {
    AppMethodBeat.i(72641);
    if (agRB == null) {
      agRB = new b();
    }
    b localb = agRB;
    AppMethodBeat.o(72641);
    return localb;
  }
  
  public static boolean jNY()
  {
    AppMethodBeat.i(72642);
    if (((c)h.ax(c.class)).a(c.a.yXs, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72642);
      return bool;
    }
  }
  
  public static boolean jNZ()
  {
    AppMethodBeat.i(72643);
    if (((c)h.ax(c.class)).a(c.a.yXu, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72643);
      return bool;
    }
  }
  
  public static boolean jOa()
  {
    AppMethodBeat.i(72644);
    if (((c)h.ax(c.class)).a(c.a.yXt, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72644);
      return bool;
    }
  }
  
  public static boolean jOb()
  {
    AppMethodBeat.i(242119);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXc, false);
    AppMethodBeat.o(242119);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */