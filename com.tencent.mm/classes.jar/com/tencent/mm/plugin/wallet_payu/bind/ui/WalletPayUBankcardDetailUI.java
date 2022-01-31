package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

public class WalletPayUBankcardDetailUI
  extends WalletBankcardDetailUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48353);
    super.onCreate(paramBundle);
    if (1 == this.tOQ.field_bankcardState)
    {
      cRx();
      findViewById(2131829006).setVisibility(8);
      findViewById(2131829007).setVisibility(8);
    }
    for (;;)
    {
      findViewById(2131829009).setVisibility(8);
      ((TextView)findViewById(2131829010)).setText(2131304861);
      AppMethodBeat.o(48353);
      return;
      nu(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */