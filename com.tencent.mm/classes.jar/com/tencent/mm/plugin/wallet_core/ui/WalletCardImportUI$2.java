package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletCardImportUI$2
  implements View.OnClickListener
{
  WalletCardImportUI$2(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.qCx.BX.getInt("key_support_bankcard", 3));
    paramView.putString("key_bank_type", WalletCardImportUI.c(this.qCx).mOb);
    paramView.putInt("key_bankcard_type", WalletCardImportUI.c(this.qCx).qvf);
    a.aj(this.qCx).a(this.qCx, WalletCardSelectUI.class, paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.2
 * JD-Core Version:    0.7.0.1
 */