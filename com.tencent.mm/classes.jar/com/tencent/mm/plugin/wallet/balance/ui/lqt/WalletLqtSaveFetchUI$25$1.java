package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletLqtSaveFetchUI$25$1
  implements Runnable
{
  WalletLqtSaveFetchUI$25$1(WalletLqtSaveFetchUI.25 param25, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(142341);
    if ((WalletLqtSaveFetchUI.i(this.tSl.tRZ) != null) && (WalletLqtSaveFetchUI.j(this.tSl.tRZ) != null) && (WalletLqtSaveFetchUI.j(this.tSl.tRZ).getTag() != null) && (WalletLqtSaveFetchUI.j(this.tSl.tRZ).getTag().equals(WalletLqtSaveFetchUI.i(this.tSl.tRZ).field_bindSerial))) {
      WalletLqtSaveFetchUI.j(this.tSl.tRZ).setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(142341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.25.1
 * JD-Core Version:    0.7.0.1
 */