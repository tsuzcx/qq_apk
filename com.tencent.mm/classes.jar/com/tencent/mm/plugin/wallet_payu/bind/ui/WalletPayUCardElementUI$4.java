package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;

final class WalletPayUCardElementUI$4
  implements View.OnClickListener
{
  WalletPayUCardElementUI$4(WalletPayUCardElementUI paramWalletPayUCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48363);
    paramView = (NetScenePayUElementQuery.PayUBankcardElement)WalletPayUCardElementUI.d(this.uCg).get(WalletPayUCardElementUI.c(this.uCg).getText());
    if (paramView == null)
    {
      ab.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
      AppMethodBeat.o(48363);
      return;
    }
    WalletPayUCardElementUI.c(this.uCg).setEncryptType(50);
    this.uCg.getInput().putParcelable("key_card_element", paramView);
    this.uCg.getInput().putString("key_card_id", WalletPayUCardElementUI.c(this.uCg).getText());
    this.uCg.getInput().putString("key_cvv", WalletPayUCardElementUI.a(this.uCg).getText());
    this.uCg.getInput().putString("key_expire_data", this.uCg.uBV.getText());
    this.uCg.getNetController().p(new Object[0]);
    AppMethodBeat.o(48363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.4
 * JD-Core Version:    0.7.0.1
 */