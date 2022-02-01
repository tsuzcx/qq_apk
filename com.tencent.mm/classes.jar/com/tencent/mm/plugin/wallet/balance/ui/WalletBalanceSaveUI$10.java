package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;

final class WalletBalanceSaveUI$10
  implements d.a
{
  WalletBalanceSaveUI$10(WalletBalanceSaveUI paramWalletBalanceSaveUI, Dialog paramDialog) {}
  
  public final void cn(Object paramObject)
  {
    AppMethodBeat.i(68701);
    if (this.tcT != null) {
      this.tcT.dismiss();
    }
    Log.i("MicroMsg.WalletBalanceSaveUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label71;
      }
    }
    label71:
    for (paramObject = paramObject.toString();; paramObject = this.HwD.getString(2131767869))
    {
      Toast.makeText(this.HwD.getContext(), paramObject, 1).show();
      AppMethodBeat.o(68701);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.10
 * JD-Core Version:    0.7.0.1
 */