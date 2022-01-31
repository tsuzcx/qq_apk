package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletSelectBankcardUI$2$2
  implements DialogInterface.OnClickListener
{
  WalletSelectBankcardUI$2$2(WalletSelectBankcardUI.2 param2, Bankcard paramBankcard) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47654);
    this.utG.utE.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
    WalletSelectBankcardUI.a(this.utG.utE, this.utF);
    AppMethodBeat.o(47654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.2.2
 * JD-Core Version:    0.7.0.1
 */