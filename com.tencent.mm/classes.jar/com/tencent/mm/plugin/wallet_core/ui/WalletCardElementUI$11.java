package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$11
  implements View.OnClickListener
{
  WalletCardElementUI$11(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47225);
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.uoW.getInput().getInt("key_support_bankcard", 3));
    paramView.putInt("key_bind_scene", this.uoW.getInput().getInt("key_bind_scene", -1));
    bo.isNullOrNil(WalletCardElementUI.c(this.uoW).getText());
    this.uoW.hideTenpayKB();
    c localc = a.aM(this.uoW);
    if (localc != null) {
      localc.a(this.uoW, WalletBankCardSelectUI.class, paramView, 1);
    }
    AppMethodBeat.o(47225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.11
 * JD-Core Version:    0.7.0.1
 */