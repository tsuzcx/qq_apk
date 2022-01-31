package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.s.a;

final class WalletBindUI$2$1
  implements s.a
{
  WalletBindUI$2$1(WalletBindUI.2 param2) {}
  
  public final void bOM()
  {
    AppMethodBeat.i(45793);
    WalletBindUI.c(this.tTx.tTw);
    AppMethodBeat.o(45793);
  }
  
  public final void bON()
  {
    AppMethodBeat.i(45795);
    WalletBindUI.c(this.tTx.tTw);
    AppMethodBeat.o(45795);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(45794);
    this.tTx.tTw.finish();
    AppMethodBeat.o(45794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.2.1
 * JD-Core Version:    0.7.0.1
 */