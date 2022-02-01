package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceFetchUI$10
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchUI$10(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68587);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.AYV.getString(2131765260));
    localIntent.putExtra("showShare", false);
    e.al(this.AYV.getContext(), localIntent);
    paramDialogInterface.dismiss();
    h.wUl.f(16398, new Object[] { WalletBalanceFetchUI.d(this.AYV), Integer.valueOf(3), "", "" });
    AppMethodBeat.o(68587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.10
 * JD-Core Version:    0.7.0.1
 */