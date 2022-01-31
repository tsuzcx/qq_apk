package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletOpenLqbProxyUI
  extends WalletBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(4);
    paramBundle = cNj();
    if (paramBundle != null)
    {
      int i = this.BX.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.qJR, 0);
      String str = this.BX.getString(com.tencent.mm.plugin.wallet_ecard.a.a.qJX);
      y.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", new Object[] { Integer.valueOf(i), str });
      if (i == 3) {
        cNk().m(new Object[] { Integer.valueOf(i), str });
      }
    }
    else
    {
      return;
    }
    paramBundle.b(this, this.BX);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI
 * JD-Core Version:    0.7.0.1
 */