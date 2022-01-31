package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.bs.a;
import com.tencent.mm.sdk.platformtools.y;

final class p$4$1
  implements Runnable
{
  p$4$1(p.4 param4, bs parambs) {}
  
  public final void run()
  {
    if (this.kkU.bHT != null) {
      y.i("MicroMsg.SubCoreMMWallet", "close result: %s", new Object[] { Integer.valueOf(this.kkU.bHT.retCode) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p.4.1
 * JD-Core Version:    0.7.0.1
 */