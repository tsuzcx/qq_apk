package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletPayUStartOpenUI$2
  implements View.OnClickListener
{
  WalletPayUStartOpenUI$2(WalletPayUStartOpenUI paramWalletPayUStartOpenUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletPayUStartOpenUI.b(this.qNy).getVisibility() == 0)
    {
      this.qNy.BX.putString("key_mobile", WalletPayUStartOpenUI.c(this.qNy));
      this.qNy.BX.putString("dial_code", WalletPayUStartOpenUI.d(this.qNy));
    }
    this.qNy.cNk().m(new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI.2
 * JD-Core Version:    0.7.0.1
 */