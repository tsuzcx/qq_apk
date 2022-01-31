package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletCheckPwdUI$4
  implements View.OnClickListener
{
  WalletCheckPwdUI$4(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47335);
    WalletCheckPwdUI.cVF();
    if (WalletCheckPwdUI.e(this.uqg) == 0)
    {
      WalletCheckPwdUI.a(this.uqg, 1);
      WalletCheckPwdUI.f(this.uqg);
    }
    for (;;)
    {
      WalletCheckPwdUI.g(this.uqg);
      AppMethodBeat.o(47335);
      return;
      WalletCheckPwdUI.a(this.uqg, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.4
 * JD-Core Version:    0.7.0.1
 */