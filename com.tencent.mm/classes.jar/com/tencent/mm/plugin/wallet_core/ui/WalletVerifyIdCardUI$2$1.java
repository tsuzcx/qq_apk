package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletVerifyIdCardUI$2$1
  implements Runnable
{
  WalletVerifyIdCardUI$2$1(WalletVerifyIdCardUI.2 param2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(47719);
    if (this.uus)
    {
      if (WalletVerifyIdCardUI.a(this.uut.uur, WalletVerifyIdCardUI.a(this.uut.uur)))
      {
        AppMethodBeat.o(47719);
        return;
      }
      WalletVerifyIdCardUI.b(this.uut.uur);
    }
    AppMethodBeat.o(47719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.2.1
 * JD-Core Version:    0.7.0.1
 */