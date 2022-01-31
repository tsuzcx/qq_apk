package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletForgotPwdVerifyIdUI$1
  implements View.OnClickListener
{
  WalletForgotPwdVerifyIdUI$1(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46306);
    paramView = WalletForgotPwdVerifyIdUI.a(this.tZw).getText();
    int i = t.cTN().cUv();
    String str = WalletForgotPwdVerifyIdUI.b(this.tZw).getText().toString();
    if ((!bo.isNullOrNil(paramView)) && (!bo.isNullOrNil(str)))
    {
      this.tZw.getInput().putString("key_identity", paramView);
      this.tZw.getInput().putInt("key_id_type", i);
      this.tZw.getInput().putString("key_true_name", str);
      if (this.tZw.getProcess() != null)
      {
        this.tZw.getProcess().mEJ.putString("key_identity", paramView);
        this.tZw.getProcess().mEJ.putInt("key_id_type", i);
        this.tZw.getProcess().mEJ.putString("key_true_name", str);
      }
      this.tZw.getNetController().p(new Object[] { paramView, Integer.valueOf(i), str });
    }
    AppMethodBeat.o(46306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.1
 * JD-Core Version:    0.7.0.1
 */