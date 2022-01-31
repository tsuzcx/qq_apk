package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletScratchShakeView$b$5
  implements Runnable
{
  WalletScratchShakeView$b$5(WalletScratchShakeView.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(47927);
    this.uxv.animate().alpha(0.0F).setDuration(100L);
    if (WalletScratchShakeView.a(this.uxv.uxu) != null) {
      WalletScratchShakeView.a(this.uxv.uxu).cWM();
    }
    AppMethodBeat.o(47927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.5
 * JD-Core Version:    0.7.0.1
 */