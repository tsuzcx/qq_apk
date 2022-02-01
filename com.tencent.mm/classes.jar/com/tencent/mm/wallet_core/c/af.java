package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
{
  public static void f(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(72820);
    Log.v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 });
    h.CyF.a(15001, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(72820);
  }
  
  public static void z(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(72819);
    Log.v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    h.CyF.a(14997, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(72819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.af
 * JD-Core Version:    0.7.0.1
 */