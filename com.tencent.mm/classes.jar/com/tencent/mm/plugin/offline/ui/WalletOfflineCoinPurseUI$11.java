package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class WalletOfflineCoinPurseUI$11
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$11(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    d.x(this.mNj.mController.uMN, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
    if (c.BS().b(ac.a.uyu, ac.a.uxr))
    {
      c.BS().c(ac.a.uyu, ac.a.uxr);
      this.mNx.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.11
 * JD-Core Version:    0.7.0.1
 */