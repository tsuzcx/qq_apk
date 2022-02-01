package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static b RrX;
  
  public static boolean b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72645);
    a.cMr();
    try
    {
      i = ((Integer)g.aAh().azQ().get(ar.a.OiV, Integer.valueOf(0))).intValue();
      paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramBoolean);
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
  
  public static b hgC()
  {
    AppMethodBeat.i(72641);
    if (RrX == null) {
      RrX = new b();
    }
    b localb = RrX;
    AppMethodBeat.o(72641);
    return localb;
  }
  
  public static boolean hgD()
  {
    AppMethodBeat.i(72642);
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100368");
    if ((localc.isValid()) && ("1".equals(localc.gzz().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72642);
        return true;
      }
      AppMethodBeat.o(72642);
      return false;
    }
  }
  
  public static boolean hgE()
  {
    AppMethodBeat.i(72643);
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100370");
    if ((localc.isValid()) && ("1".equals(localc.gzz().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72643);
        return true;
      }
      AppMethodBeat.o(72643);
      return false;
    }
  }
  
  public static boolean hgF()
  {
    AppMethodBeat.i(72644);
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100369");
    if ((localc.isValid()) && ("1".equals(localc.gzz().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72644);
        return true;
      }
      AppMethodBeat.o(72644);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */