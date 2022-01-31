package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletWXCreditChangeAmountUI)) {
      return new b.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new b.2(this, paramMMActivity, parami);
    }
    return null;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      b(paramActivity, WalletWXCreditChangeAmountUI.class, paramBundle);
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletWXCreditChangeAmountUI))
      {
        b(paramActivity, WalletWXCreditChangeAmountResultUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletWXCreditChangeAmountResultUI));
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "WXCreditChangeAmountProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    d(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b
 * JD-Core Version:    0.7.0.1
 */