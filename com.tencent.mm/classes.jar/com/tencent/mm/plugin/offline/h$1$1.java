package com.tencent.mm.plugin.offline;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1) {}
  
  public final void run()
  {
    y.d("MicroMsg.OfflineProcess", "tofutest do callback");
    this.mKe.mKd.a(this.mKe.gfb, 0, h.b(this.mKe.mKd));
    this.mKe.wBd.bTT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h.1.1
 * JD-Core Version:    0.7.0.1
 */