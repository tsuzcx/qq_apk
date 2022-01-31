package com.tencent.mm.wallet_core.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class aa
{
  public static void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    y.v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 });
    h.nFQ.f(15001, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 });
  }
  
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    y.v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    h.nFQ.f(14997, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.aa
 * JD-Core Version:    0.7.0.1
 */