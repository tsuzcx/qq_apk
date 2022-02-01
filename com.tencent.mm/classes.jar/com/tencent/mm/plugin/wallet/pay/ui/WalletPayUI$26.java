package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.d.a;

final class WalletPayUI$26
  implements d.a
{
  WalletPayUI$26(WalletPayUI paramWalletPayUI) {}
  
  public final Intent q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69415);
    ad.i(this.zRD.TAG, "pay process end");
    this.zRD.zQS = false;
    paramBundle = new Intent();
    AppMethodBeat.o(69415);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.26
 * JD-Core Version:    0.7.0.1
 */