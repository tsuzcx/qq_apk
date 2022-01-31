package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.ui.s;

final class WalletBindUI$2
  implements Runnable
{
  WalletBindUI$2(WalletBindUI paramWalletBindUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45796);
    if (WalletBindUI.a(this.tTw))
    {
      AppMethodBeat.o(45796);
      return;
    }
    if (WalletBindUI.b(this.tTw) == 4)
    {
      ak localak = new ak();
      WalletBindUI.d(this.tTw).a(new WalletBindUI.2.1(this), localak.cUj());
    }
    for (;;)
    {
      if (!WalletBindUI.a(this.tTw)) {
        WalletBindUI.e(this.tTw);
      }
      AppMethodBeat.o(45796);
      return;
      WalletBindUI.c(this.tTw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.2
 * JD-Core Version:    0.7.0.1
 */