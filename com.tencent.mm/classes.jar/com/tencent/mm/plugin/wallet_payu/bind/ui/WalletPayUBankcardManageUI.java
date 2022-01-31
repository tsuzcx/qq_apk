package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUBankcardManageUI
  extends WalletBankcardManageUI
{
  protected final com.tencent.mm.plugin.wallet.bind.ui.a bTD()
  {
    return new a(this, this.qjX);
  }
  
  protected final void bTE()
  {
    com.tencent.mm.wallet_core.a.a(this, c.class, null);
  }
  
  protected final void c(Bankcard paramBankcard)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, d.class, localBundle);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      bTF();
      return true;
    }
    return false;
  }
  
  protected final void ks(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(new com.tencent.mm.plugin.wallet_core.c.b.a(), false, false);
      return;
    }
    a(new com.tencent.mm.plugin.wallet_core.c.b.a(), true, false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */