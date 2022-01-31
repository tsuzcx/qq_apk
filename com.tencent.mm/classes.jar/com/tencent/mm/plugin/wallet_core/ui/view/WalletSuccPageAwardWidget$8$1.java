package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSuccPageAwardWidget$8$1
  implements Runnable
{
  WalletSuccPageAwardWidget$8$1(WalletSuccPageAwardWidget.8 param8, NinePatchDrawable paramNinePatchDrawable) {}
  
  public final void run()
  {
    AppMethodBeat.i(47949);
    WalletSuccPageAwardWidget.i(this.uxO.uxM).setImageDrawable(this.uxN);
    WalletSuccPageAwardWidget.i(this.uxO.uxM).setVisibility(0);
    WalletSuccPageAwardWidget.i(this.uxO.uxM).post(new WalletSuccPageAwardWidget.8.1.1(this));
    AppMethodBeat.o(47949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.8.1
 * JD-Core Version:    0.7.0.1
 */