package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c
  extends com.tencent.mm.wallet_core.c
{
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI)) {
      return new c.1(this, paramMMActivity, parami, this.kke);
    }
    if ((paramMMActivity instanceof WalletPayUCardElementUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          if (((paramAnonymousm instanceof a)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.a(c.this).putInt("key_errcode_payu", 0);
            c.this.b(this.gfb, c.b(c.this));
          }
          if ((paramAnonymousm instanceof NetScenePayUElementQuery))
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              paramAnonymousString = ((NetScenePayUElementQuery)paramAnonymousm).qMH;
              if (bk.bl(paramAnonymousString.qMI)) {
                paramAnonymousString.qMJ = ae.getContext().getString(a.i.wallet_payu_bind_err_card_number);
              }
              c.c(c.this).putParcelable("key_card_element", ((NetScenePayUElementQuery)paramAnonymousm).qMH);
            }
          }
          else {
            return false;
          }
          NetScenePayUElementQuery.PayUBankcardElement localPayUBankcardElement = new NetScenePayUElementQuery.PayUBankcardElement();
          paramAnonymousm = paramAnonymousString;
          if (bk.bl(paramAnonymousString)) {
            paramAnonymousm = "err card element";
          }
          localPayUBankcardElement.qMJ = paramAnonymousm;
          c.d(c.this).putParcelable("key_card_element", localPayUBankcardElement);
          return false;
        }
        
        public final boolean m(Object... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = (NetScenePayUElementQuery.PayUBankcardElement)c.e(c.this).getParcelable("key_card_element");
          this.wBd.a(new a(paramAnonymousVarArgs.mOX, paramAnonymousVarArgs.qMJ, c.f(c.this).getString("key_bank_username"), c.g(c.this).getString("key_card_id"), c.h(c.this).getString("key_expire_data"), paramAnonymousVarArgs.cardType, c.i(c.this).getString("key_cvv"), c.j(c.this).getString("key_pwd1")), true);
          return false;
        }
      };
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletPayUCheckPwdUI)) {
      b(paramActivity, WalletPayUCardElementUI.class, paramBundle);
    }
  }
  
  public final String aTh()
  {
    return "PayUBindProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if (this.kke.getInt("key_errcode_payu", -1) == 0)
    {
      s.makeText(paramActivity, a.i.wallet_order_info_result_success, 0).show();
      a(paramActivity, WalletPayUBankcardManageUI.class, -1, false);
      return;
    }
    s.makeText(paramActivity, a.i.wallet_err_wording_comm_failed, 0).show();
    a(paramActivity, WalletPayUBankcardManageUI.class, 0, false);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.c
 * JD-Core Version:    0.7.0.1
 */