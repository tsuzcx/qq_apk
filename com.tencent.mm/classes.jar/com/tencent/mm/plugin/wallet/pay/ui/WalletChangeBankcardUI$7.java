package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletChangeBankcardUI$7
  implements DialogInterface.OnCancelListener
{
  WalletChangeBankcardUI$7(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(45964);
    ab.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { bo.dtY().toString() });
    WalletChangeBankcardUI.c(this.tVU);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.tVU.gJv = null;
    if (WalletChangeBankcardUI.d(this.tVU).getVisibility() != 0) {
      this.tVU.byK();
    }
    this.tVU.tVS = null;
    AppMethodBeat.o(45964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.7
 * JD-Core Version:    0.7.0.1
 */