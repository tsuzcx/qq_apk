package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceSaveUI$8
  implements DialogInterface.OnClickListener
{
  WalletBalanceSaveUI$8(WalletBalanceSaveUI paramWalletBalanceSaveUI, ak paramak) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68703);
    ad.i("MicroMsg.WalletBalanceSaveUI", "click open lqt: %s", new Object[] { Integer.valueOf(this.zHI.zWW) });
    h.vKh.f(17084, new Object[] { Integer.valueOf(8) });
    if (this.zHI.zWW == 2)
    {
      WalletBalanceSaveUI.d(this.zHE);
      e.p(this.zHE.getContext(), this.zHI.zWV, true);
      AppMethodBeat.o(68703);
      return;
    }
    if (this.zHI.zWW == 3)
    {
      WalletBalanceSaveUI.d(this.zHE);
      e.v(this.zHI.gIw, this.zHI.zWV, 0, 1000);
    }
    AppMethodBeat.o(68703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.8
 * JD-Core Version:    0.7.0.1
 */