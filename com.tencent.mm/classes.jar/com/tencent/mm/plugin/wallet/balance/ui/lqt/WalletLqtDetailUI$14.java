package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.f;

final class WalletLqtDetailUI$14
  implements Runnable
{
  WalletLqtDetailUI$14(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void run()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletLqtDetailUI.d(this.qil).getLayoutParams();
    localLayoutParams.topMargin = Math.max(this.qil.findViewById(a.f.lqt_detail_root).getHeight() - this.qil.findViewById(a.f.lqt_detail_inner_container).getBottom() - a.fromDPToPix(this.qil, 20) - a.fromDPToPix(this.qil, 20), a.fromDPToPix(this.qil, 50));
    WalletLqtDetailUI.d(this.qil).setLayoutParams(localLayoutParams);
    WalletLqtDetailUI.d(this.qil).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.14
 * JD-Core Version:    0.7.0.1
 */