package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static b JDm;
  
  public static boolean b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72645);
    a.cil();
    try
    {
      i = ((Integer)g.agR().agA().get(ah.a.GTk, Integer.valueOf(0))).intValue();
      paramBoolean = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(parama, paramBoolean);
      ac.i("MicroMsg.TenPaySdkAbTest", "isKindaBindCardEnable configval %s svrConfig %s isDebug %s isFlavorRed %s isFlavorPurple %s BuildInfo %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(h.IS_FLAVOR_RED), Boolean.valueOf(h.IS_FLAVOR_PURPLE), h.KINDA_DEFAULT });
      if ("open".equals(h.KINDA_DEFAULT))
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
        ac.printErrStackTrace("MicroMsg.TenPaySdkAbTest", localb, "isKindaEnable get configVal error! AccountNotReady!", new Object[0]);
        i = 0;
      }
      if ("close".equals(h.KINDA_DEFAULT))
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
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE))
      {
        AppMethodBeat.o(72645);
        return true;
      }
      AppMethodBeat.o(72645);
    }
    return false;
  }
  
  public static boolean fzA()
  {
    AppMethodBeat.i(72642);
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100368");
    if ((localc.isValid()) && ("1".equals(localc.eYV().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72642);
        return true;
      }
      AppMethodBeat.o(72642);
      return false;
    }
  }
  
  public static boolean fzB()
  {
    AppMethodBeat.i(72643);
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100370");
    if ((localc.isValid()) && ("1".equals(localc.eYV().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72643);
        return true;
      }
      AppMethodBeat.o(72643);
      return false;
    }
  }
  
  public static boolean fzC()
  {
    AppMethodBeat.i(72644);
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100369");
    if ((localc.isValid()) && ("1".equals(localc.eYV().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72644);
        return true;
      }
      AppMethodBeat.o(72644);
      return false;
    }
  }
  
  public static b fzz()
  {
    AppMethodBeat.i(72641);
    if (JDm == null) {
      JDm = new b();
    }
    b localb = JDm;
    AppMethodBeat.o(72641);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */