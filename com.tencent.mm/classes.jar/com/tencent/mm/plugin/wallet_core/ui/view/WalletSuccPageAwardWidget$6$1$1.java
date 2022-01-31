package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

final class WalletSuccPageAwardWidget$6$1$1
  implements Runnable
{
  WalletSuccPageAwardWidget$6$1$1(WalletSuccPageAwardWidget.6.1 param1) {}
  
  public final void run()
  {
    ViewGroup.LayoutParams localLayoutParams = WalletSuccPageAwardWidget.i(this.qJh.qJg.qJe).getLayoutParams();
    localLayoutParams.height = WalletSuccPageAwardWidget.b(this.qJh.qJg.qJe).getHeight();
    localLayoutParams.width = WalletSuccPageAwardWidget.b(this.qJh.qJg.qJe).getWidth();
    WalletSuccPageAwardWidget.i(this.qJh.qJg.qJe).setLayoutParams(localLayoutParams);
    this.qJh.qJg.qJe.findViewById(a.f.order_info_tinyapp_splitter_1).setVisibility(8);
    this.qJh.qJg.qJe.findViewById(a.f.order_info_tinyapp_splitter_2).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.6.1.1
 * JD-Core Version:    0.7.0.1
 */