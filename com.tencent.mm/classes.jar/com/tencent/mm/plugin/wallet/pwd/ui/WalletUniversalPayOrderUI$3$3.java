package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

final class WalletUniversalPayOrderUI$3$3
  implements DialogInterface.OnClickListener
{
  WalletUniversalPayOrderUI$3$3(WalletUniversalPayOrderUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46426);
    WalletUniversalPayOrderUI.d(this.ube.ubc).setCheck(true);
    h.qsU.e(16343, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(46426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.3.3
 * JD-Core Version:    0.7.0.1
 */