package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends a
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI)) {
      return new d.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletBankcardDetailUI)) {
      b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    }
    while (!(paramActivity instanceof WalletPayUCheckPwdUI)) {
      return;
    }
    b(paramActivity, paramBundle);
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
  
  protected final void d(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletPayUBankcardDetailUI.class, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.d
 * JD-Core Version:    0.7.0.1
 */