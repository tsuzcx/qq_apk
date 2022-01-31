package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b
  extends c
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_set_password_finish_confirm;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new b.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new b.2(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletPwdConfirmUI));
    b(paramActivity, paramBundle);
  }
  
  public final boolean a(final WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(a.i.wallet_set_password_finish_confirm), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        b.this.b(paramWalletBaseUI, b.c(b.this));
        if (paramWalletBaseUI.aSk()) {
          paramWalletBaseUI.finish();
        }
        WalletBaseUI.cNh();
      }
    });
    return true;
  }
  
  public final String aTh()
  {
    return "ModifyPwdProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity, WalletPasswordSettingUI.class, -1, false);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b
 * JD-Core Version:    0.7.0.1
 */