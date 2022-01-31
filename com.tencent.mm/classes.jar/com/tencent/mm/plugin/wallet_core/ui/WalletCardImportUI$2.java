package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

final class WalletCardImportUI$2
  implements View.OnClickListener
{
  WalletCardImportUI$2(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47266);
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.uph.getInput().getInt("key_support_bankcard", 3));
    paramView.putString("key_bank_type", WalletCardImportUI.c(this.uph).poq);
    paramView.putInt("key_bankcard_type", WalletCardImportUI.c(this.uph).uhx);
    a.aM(this.uph).a(this.uph, WalletCardSelectUI.class, paramView, 1);
    AppMethodBeat.o(47266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.2
 * JD-Core Version:    0.7.0.1
 */