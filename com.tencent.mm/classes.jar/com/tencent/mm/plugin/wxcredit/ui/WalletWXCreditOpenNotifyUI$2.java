package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.wallet_core.a;

final class WalletWXCreditOpenNotifyUI$2
  implements View.OnClickListener
{
  WalletWXCreditOpenNotifyUI$2(WalletWXCreditOpenNotifyUI paramWalletWXCreditOpenNotifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48741);
    paramView = new Bundle();
    paramView.putParcelable("key_bankcard", this.vIH.getInput().getParcelable("key_bankcard"));
    a.a(this.vIH, b.class, paramView);
    AppMethodBeat.o(48741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI.2
 * JD-Core Version:    0.7.0.1
 */