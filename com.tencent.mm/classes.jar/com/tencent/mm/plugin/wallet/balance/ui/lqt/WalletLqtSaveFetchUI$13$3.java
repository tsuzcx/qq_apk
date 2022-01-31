package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtSaveFetchUI$13$3
  implements d.a
{
  WalletLqtSaveFetchUI$13$3(WalletLqtSaveFetchUI.13 param13) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(155083);
    this.tSf.tRZ.aCV();
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label48;
      }
    }
    label48:
    for (paramObject = paramObject.toString();; paramObject = this.tSf.tRZ.getString(2131305218))
    {
      this.tSf.tRZ.XJ(paramObject);
      AppMethodBeat.o(155083);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.3
 * JD-Core Version:    0.7.0.1
 */