package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ah.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static long qml = 0L;
  
  public static void ad(String paramString, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (l - qml > 1000L)
    {
      qml = l;
      if (bk.bl(paramString)) {
        break label190;
      }
      if (!paramString.startsWith("sns_aa_")) {
        break label75;
      }
      paramString = new c(paramString, paramInt1, paramInt2);
    }
    label190:
    for (;;)
    {
      if (paramString != null)
      {
        y.v("NetSceneCancelPayHelper", "start cancelPay request");
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
      }
      return;
      label75:
      if (paramString.startsWith("sns_tf_")) {
        paramString = new f(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("sns_ff_")) {
        paramString = new e(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("sns_")) {
        paramString = new d(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("ts_")) {
        paramString = new g(paramString, paramInt1, paramInt2);
      } else if (paramString.startsWith("up_")) {
        paramString = new h(paramString, paramInt1, paramInt2);
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