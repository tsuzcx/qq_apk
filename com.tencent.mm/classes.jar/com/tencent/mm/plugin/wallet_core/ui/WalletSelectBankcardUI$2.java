package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.h;

final class WalletSelectBankcardUI$2
  implements AdapterView.OnItemClickListener
{
  WalletSelectBankcardUI$2(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(47655);
    paramAdapterView = (Bankcard)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView != null)
    {
      h.a(this.utE, true, this.utE.getString(2131305629, new Object[] { paramAdapterView.field_desc, paramAdapterView.field_mobile }), this.utE.getString(2131305631), this.utE.getString(2131305628), this.utE.getString(2131305630), new WalletSelectBankcardUI.2.1(this, paramAdapterView), new WalletSelectBankcardUI.2.2(this, paramAdapterView));
      AppMethodBeat.o(47655);
      return;
    }
    this.utE.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
    WalletSelectBankcardUI.a(this.utE, null);
    AppMethodBeat.o(47655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.2
 * JD-Core Version:    0.7.0.1
 */