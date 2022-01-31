package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletVerifyCodeUI$4
  implements View.OnClickListener
{
  WalletVerifyCodeUI$4(WalletVerifyCodeUI paramWalletVerifyCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47692);
    this.uul.hideVKB();
    if (WalletVerifyCodeUI.a(this.uul, WalletVerifyCodeUI.c(this.uul)))
    {
      AppMethodBeat.o(47692);
      return;
    }
    this.uul.cWc();
    AppMethodBeat.o(47692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.4
 * JD-Core Version:    0.7.0.1
 */