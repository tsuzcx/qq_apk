package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCheckIdentityUI$1
  implements View.OnClickListener
{
  WalletCheckIdentityUI$1(WalletCheckIdentityUI paramWalletCheckIdentityUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48681);
    paramView = WalletCheckIdentityUI.a(this.vIa).getText();
    String str = WalletCheckIdentityUI.b(this.vIa).getText();
    if (WalletCheckIdentityUI.a(this.vIa, paramView, str)) {
      this.vIa.getNetController().p(new Object[] { paramView, str });
    }
    AppMethodBeat.o(48681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI.1
 * JD-Core Version:    0.7.0.1
 */