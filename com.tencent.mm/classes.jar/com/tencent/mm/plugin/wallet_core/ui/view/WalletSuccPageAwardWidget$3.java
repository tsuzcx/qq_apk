package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.cb.a;

final class WalletSuccPageAwardWidget$3
  implements Runnable
{
  WalletSuccPageAwardWidget$3(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    if (WalletSuccPageAwardWidget.d(this.qJe).getHeight() != this.qJe.getHeight())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(this.qJe).getLayoutParams();
      localLayoutParams.width = WalletSuccPageAwardWidget.b(this.qJe).getWidth();
      localLayoutParams.height = (WalletSuccPageAwardWidget.b(this.qJe).getHeight() - a.fromDPToPix(this.qJe.getContext(), 2));
      localLayoutParams.topMargin = a.fromDPToPix(this.qJe.getContext(), 1);
      localLayoutParams.bottomMargin = a.fromDPToPix(this.qJe.getContext(), 1);
      WalletSuccPageAwardWidget.d(this.qJe).setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.3
 * JD-Core Version:    0.7.0.1
 */