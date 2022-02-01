package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;

final class WalletBalanceSaveUI$6
  implements d.a
{
  WalletBalanceSaveUI$6(WalletBalanceSaveUI paramWalletBalanceSaveUI, Dialog paramDialog) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68701);
    if (this.rvc != null) {
      this.rvc.dismiss();
    }
    ad.i("MicroMsg.WalletBalanceSaveUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label71;
      }
    }
    label71:
    for (paramObject = paramObject.toString();; paramObject = this.CAd.getString(2131765420))
    {
      Toast.makeText(this.CAd.getContext(), paramObject, 1).show();
      AppMethodBeat.o(68701);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.6
 * JD-Core Version:    0.7.0.1
 */