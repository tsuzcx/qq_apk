package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class WalletLqtDetailUI$13
  implements View.OnClickListener
{
  WalletLqtDetailUI$13(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new rc();
    paramView.caq.userName = WalletLqtDetailUI.c(this.qil).tCe.username;
    paramView.caq.cas = bk.aM(WalletLqtDetailUI.c(this.qil).tCe.path, "");
    paramView.caq.scene = 1061;
    paramView.caq.cat = 0;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.13
 * JD-Core Version:    0.7.0.1
 */