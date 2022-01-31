package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardManageUI$6
  implements View.OnClickListener
{
  WalletBankcardManageUI$6(WalletBankcardManageUI paramWalletBankcardManageUI, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45768);
    if (!bo.isNullOrNil(this.tTm.ugu)) {
      e.m(this.tTk.getContext(), this.tTm.ugu, false);
    }
    AppMethodBeat.o(45768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.6
 * JD-Core Version:    0.7.0.1
 */