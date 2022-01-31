package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletSelectBankcardUI$2$1
  implements DialogInterface.OnClickListener
{
  WalletSelectBankcardUI$2$1(WalletSelectBankcardUI.2 param2, Bankcard paramBankcard) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47653);
    this.utG.utE.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
    WalletSelectBankcardUI.a(this.utG.utE, this.utF);
    h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(47653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.2.1
 * JD-Core Version:    0.7.0.1
 */