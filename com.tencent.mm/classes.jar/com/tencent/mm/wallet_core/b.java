package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.i;

public final class b
{
  private static b YTx;
  
  public static boolean b(com.tencent.mm.plugin.expt.b.b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72645);
    a.dbf();
    try
    {
      i locali = i.YyX;
      i = i.a(com.tencent.mm.util.b.a.Yyv, 0);
      paramBoolean = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramBoolean);
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
  
  public static b iie()
  {
    AppMethodBeat.i(72641);
    if (YTx == null) {
      YTx = new b();
    }
    b localb = YTx;
    AppMethodBeat.o(72641);
    return localb;
  }
  
  public static boolean iif()
  {
    AppMethodBeat.i(72642);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHr, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72642);
      return bool;
    }
  }
  
  public static boolean iig()
  {
    AppMethodBeat.i(72643);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHt, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72643);
      return bool;
    }
  }
  
  public static boolean iih()
  {
    AppMethodBeat.i(72644);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHs, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72644);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */