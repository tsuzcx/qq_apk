package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static b LTf;
  
  public static boolean b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(72645);
    a.cof();
    try
    {
      i = ((Integer)g.ajR().ajA().get(am.a.Jap, Integer.valueOf(0))).intValue();
      paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramBoolean);
      ae.i("MicroMsg.TenPaySdkAbTest", "isKindaBindCardEnable configval %s svrConfig %s isDebug %s isFlavorRed %s isFlavorPurple %s BuildInfo %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(j.IS_FLAVOR_RED), Boolean.valueOf(j.IS_FLAVOR_PURPLE), j.KINDA_DEFAULT });
      if ("open".equals(j.KINDA_DEFAULT))
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
        ae.printErrStackTrace("MicroMsg.TenPaySdkAbTest", localb, "isKindaEnable get configVal error! AccountNotReady!", new Object[0]);
        i = 0;
      }
      if ("close".equals(j.KINDA_DEFAULT))
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
      if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE))
      {
        AppMethodBeat.o(72645);
        return true;
      }
      AppMethodBeat.o(72645);
    }
    return false;
  }
  
  public static b fVf()
  {
    AppMethodBeat.i(72641);
    if (LTf == null) {
      LTf = new b();
    }
    b localb = LTf;
    AppMethodBeat.o(72641);
    return localb;
  }
  
  public static boolean fVg()
  {
    AppMethodBeat.i(72642);
    c localc = com.tencent.mm.model.c.d.aDI().xi("100368");
    if ((localc.isValid()) && ("1".equals(localc.fsy().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72642);
        return true;
      }
      AppMethodBeat.o(72642);
      return false;
    }
  }
  
  public static boolean fVh()
  {
    AppMethodBeat.i(72643);
    c localc = com.tencent.mm.model.c.d.aDI().xi("100370");
    if ((localc.isValid()) && ("1".equals(localc.fsy().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(72643);
        return true;
      }
      AppMethodBeat.o(72643);
      return false;
    }
  }
  
  public static boolean fVi()
  {
    AppMethodBeat.i(72644);
    c localc = com.tencent.mm.model.c.d.aDI().xi("100369");
    if ((localc.isValid()) && ("1".equals(localc.fsy().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Integer.valueOf(i) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */