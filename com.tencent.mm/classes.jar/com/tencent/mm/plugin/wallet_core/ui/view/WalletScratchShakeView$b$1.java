package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bk;

final class WalletScratchShakeView$b$1
  extends c.a
{
  WalletScratchShakeView$b$1(WalletScratchShakeView.b paramb) {}
  
  public final void bnY()
  {
    long l = bk.cp(WalletScratchShakeView.b.a(this.qIN));
    if (!WalletScratchShakeView.b.b(this.qIN))
    {
      if (l >= 1200L) {}
    }
    else {
      while (l < 80L) {
        return;
      }
    }
    WalletScratchShakeView.b.a(this.qIN, bk.UZ());
    WalletScratchShakeView.b.c(this.qIN);
    WalletScratchShakeView.b.d(this.qIN);
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.1
 * JD-Core Version:    0.7.0.1
 */