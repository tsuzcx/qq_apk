package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.d.a;

final class WalletLqtSaveFetchUI$7
  implements d.a
{
  WalletLqtSaveFetchUI$7(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final Intent s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(199235);
    ad.i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", new Object[] { paramBundle });
    AppMethodBeat.o(199235);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7
 * JD-Core Version:    0.7.0.1
 */