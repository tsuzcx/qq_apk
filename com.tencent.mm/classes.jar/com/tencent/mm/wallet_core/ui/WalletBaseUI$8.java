package com.tencent.mm.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$8
  implements Runnable
{
  WalletBaseUI$8(WalletBaseUI paramWalletBaseUI, View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(72967);
    this.val$rootView.scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(72967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.8
 * JD-Core Version:    0.7.0.1
 */