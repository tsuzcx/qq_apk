package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$10
  implements View.OnClickListener
{
  WalletCardElementUI$10(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.qCj.BX.getInt("key_support_bankcard", 3));
    paramView.putInt("key_bind_scene", this.qCj.BX.getInt("key_bind_scene", -1));
    bk.bl(WalletCardElementUI.c(this.qCj).getText());
    this.qCj.VH();
    c localc = a.aj(this.qCj);
    if (localc != null) {
      localc.a(this.qCj, WalletBankCardSelectUI.class, paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.10
 * JD-Core Version:    0.7.0.1
 */