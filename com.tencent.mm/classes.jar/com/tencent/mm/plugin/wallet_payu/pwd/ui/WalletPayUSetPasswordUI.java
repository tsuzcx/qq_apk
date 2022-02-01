package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletPayUSetPasswordUI
  extends WalletSetPasswordUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72165);
    super.onCreate(paramBundle);
    a.a(this.tDZ, false);
    AppMethodBeat.o(72165);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */