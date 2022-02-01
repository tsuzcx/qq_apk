package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a;

final class WalletBindUI$4
  implements e.a
{
  WalletBindUI$4(WalletBindUI paramWalletBindUI)
  {
    AppMethodBeat.i(160859);
    AppMethodBeat.o(160859);
  }
  
  public final Intent v(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(315571);
    paramBundle = new Intent(this.VkQ.getContext(), WalletBankcardManageUI.class);
    AppMethodBeat.o(315571);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.4
 * JD-Core Version:    0.7.0.1
 */