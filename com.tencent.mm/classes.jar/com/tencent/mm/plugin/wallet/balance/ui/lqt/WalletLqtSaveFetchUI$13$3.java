package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtSaveFetchUI$13$3
  implements d.a
{
  WalletLqtSaveFetchUI$13$3(WalletLqtSaveFetchUI.13 param13) {}
  
  public final void ce(Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(68988);
    this.zMk.zMe.zLZ = false;
    this.zMk.zMe.aEr();
    if (paramObject != null)
    {
      if ((paramObject instanceof cie)) {
        bool = com.tencent.mm.wallet_core.d.h.a(this.zMk.zMe, null, 1000, ((cie)paramObject).ntx, ((cie)paramObject).nty);
      }
      if (!bool) {
        if (!(paramObject instanceof String)) {
          break label112;
        }
      }
    }
    label112:
    for (paramObject = paramObject.toString();; paramObject = this.zMk.zMe.getString(2131765420))
    {
      com.tencent.mm.ui.base.h.d(this.zMk.zMe, paramObject, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68987);
          ad.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
          AppMethodBeat.o(68987);
        }
      });
      AppMethodBeat.o(68988);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.3
 * JD-Core Version:    0.7.0.1
 */