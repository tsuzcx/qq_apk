package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletECardElementInputUI$1
  implements View.OnClickListener
{
  WalletECardElementInputUI$1(WalletECardElementInputUI paramWalletECardElementInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48138);
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", this.uzK.getInput().getInt("key_support_bankcard", 3));
    paramView.putInt("key_bind_scene", this.uzK.getInput().getInt("key_bind_scene", -1));
    if (!bo.isNullOrNil(WalletECardElementInputUI.a(this.uzK).getText()))
    {
      paramView.putString("key_bank_type", WalletECardElementInputUI.b(this.uzK).poq);
      paramView.putInt("key_bankcard_type", WalletECardElementInputUI.b(this.uzK).uhx);
    }
    c localc = a.aM(this.uzK);
    if (localc != null) {
      localc.a(this.uzK, WalletCardSelectUI.class, paramView, 1);
    }
    AppMethodBeat.o(48138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI.1
 * JD-Core Version:    0.7.0.1
 */