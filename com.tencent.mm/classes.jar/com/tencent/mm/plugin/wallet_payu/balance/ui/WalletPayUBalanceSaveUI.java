package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletPayUBalanceSaveUI
  extends WalletBalanceSaveUI
{
  protected final void bTt()
  {
    a(new a(this.nzU, "ZAR"), true, true);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a))) {
      h.a(this, ((a)paramm).bMX, "", 11, 1);
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qgv.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */