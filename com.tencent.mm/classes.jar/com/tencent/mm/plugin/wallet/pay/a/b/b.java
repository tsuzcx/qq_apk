package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  private static long Dad = 0L;
  
  public static void aB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69280);
    long l = System.currentTimeMillis();
    if (l - Dad > 1000L)
    {
      Dad = l;
      if (bu.isNullOrNil(paramString)) {
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
        ae.v("NetSceneCancelPayHelper", "start cancelPay request");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
      }
      AppMethodBeat.o(69280);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b.b
 * JD-Core Version:    0.7.0.1
 */