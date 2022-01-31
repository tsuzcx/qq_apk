package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewPropertyAnimator;

final class WalletScratchShakeView$b$5
  implements Runnable
{
  WalletScratchShakeView$b$5(WalletScratchShakeView.b paramb) {}
  
  public final void run()
  {
    this.qIN.animate().alpha(0.0F).setDuration(100L);
    if (WalletScratchShakeView.a(this.qIN.qIM) != null) {
      WalletScratchShakeView.a(this.qIN.qIM).bXl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.5
 * JD-Core Version:    0.7.0.1
 */