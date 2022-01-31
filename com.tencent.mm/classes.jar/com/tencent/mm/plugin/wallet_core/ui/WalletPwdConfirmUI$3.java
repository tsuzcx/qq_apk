package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletPwdConfirmUI$3
  implements EditHintPasswdView.a
{
  WalletPwdConfirmUI$3(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str1 = this.qFp.BX.getString("key_new_pwd1");
      String str2 = this.qFp.llh.getMd5Value();
      if ((str1 == null) || (!str1.equals(str2)))
      {
        a.n(this.qFp, -1002);
        return;
      }
      WalletPwdConfirmUI.b(this.qFp).setEnabled(paramBoolean);
      WalletPwdConfirmUI.b(this.qFp).setClickable(paramBoolean);
      return;
    }
    WalletPwdConfirmUI.b(this.qFp).setEnabled(paramBoolean);
    WalletPwdConfirmUI.b(this.qFp).setClickable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.3
 * JD-Core Version:    0.7.0.1
 */