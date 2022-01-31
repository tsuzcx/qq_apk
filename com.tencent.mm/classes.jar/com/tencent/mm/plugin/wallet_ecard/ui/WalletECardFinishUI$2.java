package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.lk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c;

final class WalletECardFinishUI$2
  implements View.OnClickListener
{
  WalletECardFinishUI$2(WalletECardFinishUI paramWalletECardFinishUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletECardFinishUI", "click finish");
    paramView = new lk();
    a.udP.m(paramView);
    paramView = this.qKO.cNj();
    if (paramView != null)
    {
      Bundle localBundle = new Bundle();
      paramView.b(this.qKO.mController.uMN, localBundle);
      return;
    }
    y.w("MicroMsg.WalletECardFinishUI", "process is null");
    this.qKO.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.2
 * JD-Core Version:    0.7.0.1
 */