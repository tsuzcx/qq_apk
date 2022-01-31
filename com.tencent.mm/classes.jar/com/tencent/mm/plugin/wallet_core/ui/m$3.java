package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$3
  implements DialogInterface.OnCancelListener
{
  m$3(Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47394);
    ab.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
    if ((this.rcw != null) && (this.rcw.isShowing())) {
      this.rcw.dismiss();
    }
    AppMethodBeat.o(47394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.3
 * JD-Core Version:    0.7.0.1
 */