package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

final class WalletPayUPayUI$2
  implements View.OnClickListener
{
  WalletPayUPayUI$2(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48484);
    WalletPayUPayUI.a(this.uDn, (FavorPayInfo)paramView.getTag());
    if (WalletPayUPayUI.a(this.uDn) != null) {
      WalletPayUPayUI.b(this.uDn).uhY = "";
    }
    WalletPayUPayUI.c(this.uDn, "");
    WalletPayUPayUI.c(this.uDn).dismiss();
    WalletPayUPayUI.d(this.uDn);
    WalletPayUPayUI.e(this.uDn);
    AppMethodBeat.o(48484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.2
 * JD-Core Version:    0.7.0.1
 */