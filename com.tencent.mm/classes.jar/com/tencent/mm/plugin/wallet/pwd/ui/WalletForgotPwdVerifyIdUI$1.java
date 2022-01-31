package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletForgotPwdVerifyIdUI$1
  implements View.OnClickListener
{
  WalletForgotPwdVerifyIdUI$1(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = WalletForgotPwdVerifyIdUI.a(this.qpj).getText();
    int i = o.bVs().bVT();
    String str = o.bVo().bWq().field_true_name;
    if ((!bk.bl(paramView)) && (!bk.bl(str)))
    {
      this.qpj.BX.putString("key_identity", paramView);
      this.qpj.BX.putInt("key_id_type", i);
      this.qpj.BX.putString("key_true_name", str);
      if (this.qpj.cNj() != null)
      {
        this.qpj.cNj().kke.putString("key_identity", paramView);
        this.qpj.cNj().kke.putInt("key_id_type", i);
        this.qpj.cNj().kke.putString("key_true_name", str);
      }
      this.qpj.cNk().m(new Object[] { paramView, Integer.valueOf(i), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.1
 * JD-Core Version:    0.7.0.1
 */