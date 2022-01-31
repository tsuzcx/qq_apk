package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletVerifyCodeUI$1$1
  implements DialogInterface.OnClickListener
{
  WalletVerifyCodeUI$1$1(WalletVerifyCodeUI.1 param1, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47689);
    this.uun.uul.cWb();
    h.qsU.e(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(this.uum) });
    AppMethodBeat.o(47689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.1.1
 * JD-Core Version:    0.7.0.1
 */