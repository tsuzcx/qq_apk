package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b
  extends c
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_balance_fetch_finish_confirm;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    v.IX(14);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      p.bTK();
      if (p.bTL().bVN())
      {
        if ((Bankcard)this.kke.getParcelable("key_bankcard") != null)
        {
          this.kke.putInt("key_pay_flag", 3);
          this.kke.putString("key_pwd_cash_title", paramActivity.getString(a.i.wallet_balance_fetch_title));
          Orders localOrders = (Orders)this.kke.getParcelable("key_orders");
          if (localOrders != null) {
            this.kke.putString("key_pwd_cash_money", e.B(localOrders.nCq));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
          return this;
        }
        this.kke.putInt("key_pay_flag", 2);
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        return this;
      }
      this.kke.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      return this;
    }
    b(paramActivity, WalletBalanceFetchUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletBalanceFetchUI)) {
      return new b.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletBalanceFetchPwdInputUI)) {
      return new b.2(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletCardElementUI)) {
      return new b.3(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new b.4(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletBalanceFetchResultUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          return false;
        }
        
        public final boolean m(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          Orders localOrders = (Orders)b.y(b.this).getParcelable("key_orders");
          Bankcard localBankcard = o.bVs().qhj;
          localBankcard.qty -= localOrders.nCq;
          b.z(b.this).putInt("key_balance_result_logo", a.h.remittance_wait);
          return super.s(paramAnonymousVarArgs);
        }
        
        public final CharSequence vy(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          }
          Orders localOrders;
          do
          {
            return super.vy(paramAnonymousInt);
            return this.gfb.getString(a.i.wallet_balance_result_fetch_title);
            localOrders = (Orders)b.A(b.this).getParcelable("key_orders");
            if ((localOrders != null) && (!bk.bl(localOrders.qwI))) {
              return localOrders.qwI;
            }
            return this.gfb.getString(a.i.wallet_balance_result_fetch_request_title);
            localOrders = (Orders)b.B(b.this).getParcelable("key_orders");
          } while ((localOrders == null) || (localOrders.qwH <= 0L));
          return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(localOrders.qwH));
        }
      };
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new b.6(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      p.bTK();
      if (p.bTL().bVN()) {
        if ((Bankcard)this.kke.getParcelable("key_bankcard") != null)
        {
          this.kke.putInt("key_pay_flag", 3);
          this.kke.putString("key_pwd_cash_title", paramActivity.getString(a.i.wallet_balance_fetch_title));
          Orders localOrders = (Orders)this.kke.getParcelable("key_orders");
          if (localOrders != null) {
            this.kke.putString("key_pwd_cash_money", e.B(localOrders.nCq));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
        }
      }
    }
    do
    {
      return;
      this.kke.putInt("key_pay_flag", 2);
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      return;
      this.kke.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      return;
      if ((paramActivity instanceof WalletBalanceFetchPwdInputUI))
      {
        if (paramBundle.getBoolean("key_need_verify_sms", false))
        {
          b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
          return;
        }
        b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        b(paramActivity, WalletBankcardIdUI.class, paramBundle);
        return;
      }
      if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
      {
        b(paramActivity, WalletCardElementUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletCardElementUI))
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        p.bTK();
        if (p.bTL().bVN())
        {
          b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
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
        b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletBalanceFetchResultUI));
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "BalanceFetchProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      return;
    }
    if ((paramActivity instanceof WalletBalanceResultUI))
    {
      v.cMD();
      b(paramActivity, this.kke);
      return;
    }
    v.cMD();
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity, WalletBalanceManagerUI.class, -1, true);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b
 * JD-Core Version:    0.7.0.1
 */