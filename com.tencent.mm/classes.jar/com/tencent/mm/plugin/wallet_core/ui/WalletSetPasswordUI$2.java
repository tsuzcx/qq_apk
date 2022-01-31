package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletSetPasswordUI$2
  implements EditHintPasswdView.a
{
  WalletSetPasswordUI$2(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.qGE.llh.getMd5Value();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_new_pwd1", str);
      this.qGE.llh.bvr();
      a.j(this.qGE, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.2
 * JD-Core Version:    0.7.0.1
 */