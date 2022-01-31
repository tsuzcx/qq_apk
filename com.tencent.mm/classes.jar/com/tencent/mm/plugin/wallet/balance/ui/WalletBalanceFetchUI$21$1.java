package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletBalanceFetchUI$21$1
  implements Runnable
{
  WalletBalanceFetchUI$21$1(WalletBalanceFetchUI.21 param21, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(45381);
    if ((WalletBalanceFetchUI.b(this.tOt.tOj) != null) && (this.tOt.tOs != null) && (this.tOt.tOs.getTag() != null) && (this.tOt.tOs.getTag().equals(WalletBalanceFetchUI.b(this.tOt.tOj).field_bindSerial))) {
      this.tOt.tOs.setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(45381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.21.1
 * JD-Core Version:    0.7.0.1
 */