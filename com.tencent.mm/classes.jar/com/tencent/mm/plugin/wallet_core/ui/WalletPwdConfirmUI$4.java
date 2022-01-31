package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.mm.wallet_core.ui.a;

final class WalletPwdConfirmUI$4
  implements a
{
  WalletPwdConfirmUI$4(WalletPwdConfirmUI paramWalletPwdConfirmUI, ScrollView paramScrollView) {}
  
  public final void gK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WalletPwdConfirmUI.a(this.qFp, this.qFq, WalletPwdConfirmUI.b(this.qFp));
      return;
    }
    this.qFq.scrollTo(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.4
 * JD-Core Version:    0.7.0.1
 */