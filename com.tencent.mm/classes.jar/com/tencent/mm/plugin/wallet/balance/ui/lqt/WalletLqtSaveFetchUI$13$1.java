package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtSaveFetchUI$13$1
  implements d.a
{
  WalletLqtSaveFetchUI$13$1(WalletLqtSaveFetchUI.13 param13) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68984);
    ad.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramObject });
    this.zMk.zMe.aEr();
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label74;
      }
    }
    label74:
    for (paramObject = paramObject.toString();; paramObject = this.zMk.zMe.getString(2131765420))
    {
      h.d(this.zMk.zMe, paramObject, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68983);
          ad.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
          AppMethodBeat.o(68983);
        }
      });
      AppMethodBeat.o(68984);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.1
 * JD-Core Version:    0.7.0.1
 */