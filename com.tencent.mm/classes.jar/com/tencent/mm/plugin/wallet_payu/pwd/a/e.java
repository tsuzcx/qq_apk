package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public abstract class e
  extends c
{
  public g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI)) {
      return new e.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletPayUSetPasswordUI)) {
      b(paramActivity, WalletPayUPwdConfirmUI.class, paramBundle);
    }
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPayUPwdConfirmUI)) {
      a(paramActivity, WalletPayUSetPasswordUI.class, paramInt);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if (this.kke.getInt("key_errcode_payu", -1) == 0) {
      s.makeText(paramActivity, a.i.wallet_order_info_result_success, 0).show();
    }
    for (;;)
    {
      d(paramActivity, "mall", ".ui.MallIndexUI");
      return;
      s.makeText(paramActivity, a.i.wallet_err_wording_comm_failed, 0).show();
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.e
 * JD-Core Version:    0.7.0.1
 */