package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtSaveFetchUI$14$1
  implements d.a
{
  WalletLqtSaveFetchUI$14$1(WalletLqtSaveFetchUI.14 param14) {}
  
  public final void cc(Object paramObject)
  {
    AppMethodBeat.i(207216);
    ac.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramObject });
    this.BeB.Beu.aLi();
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label74;
      }
    }
    label74:
    for (paramObject = paramObject.toString();; paramObject = this.BeB.Beu.getString(2131765420))
    {
      h.d(this.BeB.Beu, paramObject, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(207215);
          ac.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
          AppMethodBeat.o(207215);
        }
      });
      AppMethodBeat.o(207216);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.14.1
 * JD-Core Version:    0.7.0.1
 */