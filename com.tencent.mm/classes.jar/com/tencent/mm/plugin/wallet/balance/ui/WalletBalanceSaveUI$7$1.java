package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletBalanceSaveUI$7$1
  implements Runnable
{
  WalletBalanceSaveUI$7$1(WalletBalanceSaveUI.7 param7, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(45477);
    if ((this.tOW.tOS.tNH != null) && (this.tOW.tOs != null) && (this.tOW.tOs.getTag() != null) && (this.tOW.tOs.getTag().equals(this.tOW.tOS.tNH.field_bindSerial))) {
      this.tOW.tOs.setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(45477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.7.1
 * JD-Core Version:    0.7.0.1
 */