package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;

final class WalletSuccPageAwardWidget$6$1
  implements Runnable
{
  WalletSuccPageAwardWidget$6$1(WalletSuccPageAwardWidget.6 param6, NinePatchDrawable paramNinePatchDrawable) {}
  
  public final void run()
  {
    WalletSuccPageAwardWidget.i(this.qJg.qJe).setImageDrawable(this.qJf);
    WalletSuccPageAwardWidget.i(this.qJg.qJe).setVisibility(0);
    WalletSuccPageAwardWidget.i(this.qJg.qJe).post(new WalletSuccPageAwardWidget.6.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.6.1
 * JD-Core Version:    0.7.0.1
 */