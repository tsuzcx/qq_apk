package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class e
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    if (!o.bVs().bVM())
    {
      if (o.bVs().bVN()) {
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      }
    }
    else {
      return this;
    }
    b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new e.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletCheckIdentityUI)) {
      return new e.2(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new e.3(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletBindDepositUI)) {
      return new e.4(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new e.5(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletWXCreditOpenResultUI)) {
      return new e.6(this, paramMMActivity, parami);
    }
    return null;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletWXCreditOpenUI)) {
      b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        E(paramActivity);
        b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletWXCreditOpenUI))
      {
        b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletCheckIdentityUI))
      {
        if (paramBundle.getBoolean("key_need_bind_deposit", true))
        {
          b(paramActivity, WalletBindDepositUI.class, paramBundle);
          return;
        }
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletBindDepositUI))
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        if (o.bVs().bVN())
        {
          b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
          return;
        }
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletPwdConfirmUI))
      {
        b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletWXCreditOpenResultUI));
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "WXCreditOpenProcess";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e
 * JD-Core Version:    0.7.0.1
 */