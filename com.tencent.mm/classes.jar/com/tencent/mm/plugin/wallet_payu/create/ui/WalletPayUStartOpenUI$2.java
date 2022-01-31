package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.d.g;

final class WalletPayUStartOpenUI$2
  implements View.OnClickListener
{
  WalletPayUStartOpenUI$2(WalletPayUStartOpenUI paramWalletPayUStartOpenUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48396);
    if (WalletPayUStartOpenUI.b(this.uCF).getVisibility() == 0)
    {
      this.uCF.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(this.uCF));
      this.uCF.getInput().putString("dial_code", WalletPayUStartOpenUI.d(this.uCF));
    }
    this.uCF.getNetController().p(new Object[0]);
    AppMethodBeat.o(48396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI.2
 * JD-Core Version:    0.7.0.1
 */