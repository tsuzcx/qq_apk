package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletPayUPwdConfirmUI
  extends WalletPwdConfirmUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48523);
    super.onCreate(paramBundle);
    a.a(this.nID, false);
    AppMethodBeat.o(48523);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */