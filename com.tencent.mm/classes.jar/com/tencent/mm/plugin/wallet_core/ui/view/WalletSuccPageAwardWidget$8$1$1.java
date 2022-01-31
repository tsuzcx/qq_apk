package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSuccPageAwardWidget$8$1$1
  implements Runnable
{
  WalletSuccPageAwardWidget$8$1$1(WalletSuccPageAwardWidget.8.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(47948);
    ViewGroup.LayoutParams localLayoutParams = WalletSuccPageAwardWidget.i(this.uxP.uxO.uxM).getLayoutParams();
    localLayoutParams.height = WalletSuccPageAwardWidget.b(this.uxP.uxO.uxM).getHeight();
    localLayoutParams.width = WalletSuccPageAwardWidget.b(this.uxP.uxO.uxM).getWidth();
    WalletSuccPageAwardWidget.i(this.uxP.uxO.uxM).setLayoutParams(localLayoutParams);
    this.uxP.uxO.uxM.findViewById(2131825332).setVisibility(8);
    this.uxP.uxO.uxM.findViewById(2131827210).setVisibility(8);
    AppMethodBeat.o(47948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.8.1.1
 * JD-Core Version:    0.7.0.1
 */