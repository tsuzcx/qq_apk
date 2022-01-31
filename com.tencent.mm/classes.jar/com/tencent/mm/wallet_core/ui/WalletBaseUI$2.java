package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$2
  implements View.OnClickListener
{
  WalletBaseUI$2(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142663);
    this.AYz.hideTenpayKB();
    AppMethodBeat.o(142663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.2
 * JD-Core Version:    0.7.0.1
 */