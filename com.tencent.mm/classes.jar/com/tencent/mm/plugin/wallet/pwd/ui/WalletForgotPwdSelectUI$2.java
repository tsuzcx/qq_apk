package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.c;

final class WalletForgotPwdSelectUI$2
  implements View.OnClickListener
{
  WalletForgotPwdSelectUI$2(WalletForgotPwdSelectUI paramWalletForgotPwdSelectUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.qoJ.cNj() != null) {
      h.nFQ.f(15774, new Object[] { Integer.valueOf(this.qoJ.cNj().kke.getInt("key_forgot_scene", 1)), Integer.valueOf(3) });
    }
    WalletForgotPwdSelectUI.b(this.qoJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI.2
 * JD-Core Version:    0.7.0.1
 */