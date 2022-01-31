package com.tencent.mm.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$6
  implements Runnable
{
  WalletBaseUI$6(WalletBaseUI paramWalletBaseUI, View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(142665);
    this.val$rootView.scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(142665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.6
 * JD-Core Version:    0.7.0.1
 */