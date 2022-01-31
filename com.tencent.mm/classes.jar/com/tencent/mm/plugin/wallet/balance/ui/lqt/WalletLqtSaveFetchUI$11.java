package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletLqtSaveFetchUI$11
  implements a
{
  WalletLqtSaveFetchUI$11(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(155079);
    if (paramBoolean)
    {
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 2)
      {
        WalletLqtSaveFetchUI.q(this.tRZ);
        AppMethodBeat.o(155079);
        return;
      }
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 1) {
        AppMethodBeat.o(155079);
      }
    }
    else
    {
      WalletLqtSaveFetchUI.r(this.tRZ).scrollTo(0, 0);
      if ((WalletLqtSaveFetchUI.e(this.tRZ) == 2) && (bo.isNullOrNil(WalletLqtSaveFetchUI.h(this.tRZ).getText()))) {
        WalletLqtSaveFetchUI.s(this.tRZ);
      }
    }
    AppMethodBeat.o(155079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.11
 * JD-Core Version:    0.7.0.1
 */