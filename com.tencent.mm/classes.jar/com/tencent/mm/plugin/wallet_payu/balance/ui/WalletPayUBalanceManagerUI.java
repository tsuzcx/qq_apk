package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletPayUBalanceManagerUI
  extends WalletBalanceManagerUI
{
  protected final void bTp()
  {
    p.bTK();
    if (p.bTL().qhj == null) {}
    for (boolean bool = true;; bool = false)
    {
      a(new a(), bool, false);
      return;
    }
  }
  
  protected final void bTq()
  {
    Y(WalletPayUBalanceSaveUI.class);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a))) {
      aZ();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */