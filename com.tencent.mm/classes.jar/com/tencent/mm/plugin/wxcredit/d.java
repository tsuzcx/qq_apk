package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
    b(paramActivity, WalletWXCreditDetailUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletWXCreditDetailUI)) {
      return new d.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new d.2(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      b(paramActivity, WalletWXCreditErrDetailUI.class, paramBundle);
      paramActivity.finish();
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletWXCreditDetailUI))
      {
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        b(paramActivity, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletWXCreditErrDetailUI));
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
  }
  
  public final String aTh()
  {
    return "WXCreditManagerProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    d(paramActivity, "mall", ".ui.MallIndexUI");
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.d
 * JD-Core Version:    0.7.0.1
 */