package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class WalletCheckPwdUI$4
  implements View.OnClickListener
{
  WalletCheckPwdUI$4(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final void onClick(View paramView)
  {
    
    if (WalletCheckPwdUI.e(this.qDk) == 0)
    {
      WalletCheckPwdUI.a(this.qDk, 1);
      WalletCheckPwdUI.f(this.qDk);
    }
    for (;;)
    {
      WalletCheckPwdUI.g(this.qDk);
      return;
      WalletCheckPwdUI.a(this.qDk, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.4
 * JD-Core Version:    0.7.0.1
 */