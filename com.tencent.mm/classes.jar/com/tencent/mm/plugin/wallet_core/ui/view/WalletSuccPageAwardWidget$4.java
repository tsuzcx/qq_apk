package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class WalletSuccPageAwardWidget$4
  implements Runnable
{
  WalletSuccPageAwardWidget$4(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    AppMethodBeat.i(47944);
    if (WalletSuccPageAwardWidget.d(this.uxM).getHeight() != this.uxM.getHeight())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)WalletSuccPageAwardWidget.d(this.uxM).getLayoutParams();
      localLayoutParams.width = WalletSuccPageAwardWidget.b(this.uxM).getWidth();
      localLayoutParams.height = (WalletSuccPageAwardWidget.b(this.uxM).getHeight() - a.fromDPToPix(this.uxM.getContext(), 2));
      localLayoutParams.topMargin = a.fromDPToPix(this.uxM.getContext(), 1);
      localLayoutParams.bottomMargin = a.fromDPToPix(this.uxM.getContext(), 1);
      WalletSuccPageAwardWidget.d(this.uxM).setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(47944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.4
 * JD-Core Version:    0.7.0.1
 */