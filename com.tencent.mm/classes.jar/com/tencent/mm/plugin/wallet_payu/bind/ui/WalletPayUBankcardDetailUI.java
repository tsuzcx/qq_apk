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
    AppMethodBeat.i(71993);
    super.onCreate(paramBundle);
    if (1 == this.CRA.field_bankcardState)
    {
      eGN();
      findViewById(2131306672).setVisibility(8);
      findViewById(2131306671).setVisibility(8);
    }
    for (;;)
    {
      findViewById(2131306674).setVisibility(8);
      ((TextView)findViewById(2131306676)).setText(2131765048);
      AppMethodBeat.o(71993);
      return;
      ug(false);
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