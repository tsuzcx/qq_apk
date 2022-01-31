package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  private static long tVB = 0L;
  
  public static void av(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45937);
    long l = System.currentTimeMillis();
    if (l - tVB > 1000L)
    {
      tVB = l;
      if (bo.isNullOrNil(paramString)) {
        break label269;
      }
      if (!paramString.startsWith("sns_aa_")) {
        break label85;
      }
      paramString = new e(paramString, paramInt1, paramInt2);
    }
    label269:
    for (;;)
    {
      if (paramString != null)
      {
        ab.v("NetSceneCancelPayHelper", "start cancelPay request");
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
      }
      AppMethodBeat.o(45937);
      return;
      label85:
      if (paramString.startsWith("sns_tf_")) {
        paramString = new h(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("sns_ff_")) {
        paramString = new g(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("sns_")) {
        paramString = new f(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("ts_")) {
        paramString = new j(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("up_")) {
        paramString = new k(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("seb_ff_")) {
        paramString = new d(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("tax_")) {
        paramString = new i(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("dc_")) {
        paramString = new c(paramString, paramInt1, paramInt2);
      } else {
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b.b
 * JD-Core Version:    0.7.0.1
 */