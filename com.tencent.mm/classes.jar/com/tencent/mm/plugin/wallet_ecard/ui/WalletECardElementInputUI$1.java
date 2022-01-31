package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletECardElementInputUI$1
  implements View.OnClickListener
{
  WalletECardElementInputUI$1(WalletECardElementInputUI paramWalletECardElementInputUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.qKN.BX.getInt("key_support_bankcard", 3));
    paramView.putInt("key_bind_scene", this.qKN.BX.getInt("key_bind_scene", -1));
    if (!bk.bl(WalletECardElementInputUI.a(this.qKN).getText()))
    {
      paramView.putString("key_bank_type", WalletECardElementInputUI.b(this.qKN).mOb);
      paramView.putInt("key_bankcard_type", WalletECardElementInputUI.b(this.qKN).qvf);
    }
    c localc = a.aj(this.qKN);
    if (localc != null) {
      localc.a(this.qKN, WalletCardSelectUI.class, paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI.1
 * JD-Core Version:    0.7.0.1
 */