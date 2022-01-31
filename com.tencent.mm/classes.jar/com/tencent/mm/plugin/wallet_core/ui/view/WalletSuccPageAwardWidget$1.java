package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSuccPageAwardWidget$1
  implements Runnable
{
  WalletSuccPageAwardWidget$1(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    AppMethodBeat.i(47940);
    if (WalletSuccPageAwardWidget.a(this.uxM).getHeight() != this.uxM.getHeight())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.a(this.uxM).getLayoutParams();
      localLayoutParams.width = WalletSuccPageAwardWidget.b(this.uxM).getWidth();
      localLayoutParams.height = WalletSuccPageAwardWidget.b(this.uxM).getHeight();
      WalletSuccPageAwardWidget.a(this.uxM).setLayoutParams(localLayoutParams);
    }
    WalletSuccPageAwardWidget.c(this.uxM);
    AppMethodBeat.o(47940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.1
 * JD-Core Version:    0.7.0.1
 */