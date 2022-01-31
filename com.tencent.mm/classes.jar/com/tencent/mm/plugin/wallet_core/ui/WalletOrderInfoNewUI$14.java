package com.tencent.mm.plugin.wallet_core.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

final class WalletOrderInfoNewUI$14
  implements Runnable
{
  WalletOrderInfoNewUI$14(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, ImageView paramImageView) {}
  
  public final void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.qEr.findViewById(a.f.root_layout);
    ViewGroup.LayoutParams localLayoutParams = this.nBy.getLayoutParams();
    localLayoutParams.width = localViewGroup.getWidth();
    localLayoutParams.height = localViewGroup.getHeight();
    this.nBy.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.14
 * JD-Core Version:    0.7.0.1
 */