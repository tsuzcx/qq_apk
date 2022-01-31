package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c.a;

final class WalletBindUI$4
  implements c.a
{
  WalletBindUI$4(WalletBindUI paramWalletBindUI) {}
  
  public final Intent p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(45799);
    paramBundle = new Intent(this.tTw.getContext(), WalletBankcardManageUI.class);
    AppMethodBeat.o(45799);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.4
 * JD-Core Version:    0.7.0.1
 */