package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public final class WalletPayUSecurityQuestionSettingUI$a
{
  protected WalletPayUSecurityQuestionSettingUI$a(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  private void cXn()
  {
    AppMethodBeat.i(48587);
    if (cXs())
    {
      WalletPayUSecurityQuestionSettingUI.g(this.uEe).setEnabled(true);
      AppMethodBeat.o(48587);
      return;
    }
    WalletPayUSecurityQuestionSettingUI.g(this.uEe).setEnabled(false);
    AppMethodBeat.o(48587);
  }
  
  protected final boolean cXs()
  {
    AppMethodBeat.i(48588);
    if ((WalletPayUSecurityQuestionSettingUI.b(this.uEe).asv()) && (WalletPayUSecurityQuestionSettingUI.c(this.uEe).asv()))
    {
      AppMethodBeat.o(48588);
      return true;
    }
    AppMethodBeat.o(48588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.a
 * JD-Core Version:    0.7.0.1
 */