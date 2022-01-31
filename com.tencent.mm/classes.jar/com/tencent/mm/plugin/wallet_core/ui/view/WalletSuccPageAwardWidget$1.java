package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

final class WalletSuccPageAwardWidget$1
  implements Runnable
{
  WalletSuccPageAwardWidget$1(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    if (WalletSuccPageAwardWidget.a(this.qJe).getHeight() != this.qJe.getHeight())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.a(this.qJe).getLayoutParams();
      localLayoutParams.width = WalletSuccPageAwardWidget.b(this.qJe).getWidth();
      localLayoutParams.height = WalletSuccPageAwardWidget.b(this.qJe).getHeight();
      WalletSuccPageAwardWidget.a(this.qJe).setLayoutParams(localLayoutParams);
    }
    WalletSuccPageAwardWidget.c(this.qJe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.1
 * JD-Core Version:    0.7.0.1
 */