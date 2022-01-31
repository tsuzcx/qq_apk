package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.a;

final class WalletLqtSaveFetchUI$6
  implements c.a
{
  WalletLqtSaveFetchUI$6(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final Intent p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(155072);
    ab.i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", new Object[] { paramBundle });
    AppMethodBeat.o(155072);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.6
 * JD-Core Version:    0.7.0.1
 */