package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI
  extends WalletCheckPwdUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof s)) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      return false;
    }
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (cNj() != null) {
      setBackBtn(new WalletLoanCheckPwdUI.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */