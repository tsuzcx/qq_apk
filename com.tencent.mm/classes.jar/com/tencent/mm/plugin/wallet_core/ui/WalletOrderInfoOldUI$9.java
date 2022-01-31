package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class WalletOrderInfoOldUI$9
  implements h.c
{
  WalletOrderInfoOldUI$9(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(47482);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(47482);
      return;
      WalletOrderInfoOldUI.a(this.urV, false);
      Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.urV.pqF));
      localIntent.addFlags(268435456);
      this.urV.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.9
 * JD-Core Version:    0.7.0.1
 */