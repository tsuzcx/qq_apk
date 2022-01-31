package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUCheckPwdUI
  extends WalletCheckPwdUI
{
  protected final boolean bTZ()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.llh, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */