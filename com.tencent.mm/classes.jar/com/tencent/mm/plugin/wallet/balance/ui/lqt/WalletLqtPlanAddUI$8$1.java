package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class WalletLqtPlanAddUI$8$1
  implements Runnable
{
  WalletLqtPlanAddUI$8$1(WalletLqtPlanAddUI.8 param8, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(45565);
    if ((this.tQD.tQC != null) && (WalletLqtPlanAddUI.n(this.tQD.tQA).getTag() != null) && (WalletLqtPlanAddUI.n(this.tQD.tQA).getTag().equals(this.tQD.tQC.field_bindSerial))) {
      WalletLqtPlanAddUI.n(this.tQD.tQA).setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(45565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.8.1
 * JD-Core Version:    0.7.0.1
 */