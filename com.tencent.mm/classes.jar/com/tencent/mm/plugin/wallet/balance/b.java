package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
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
    return 2131304806;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45213);
    x.RT(14);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      s.cRG();
      if (s.cRH().cUl()) {
        if ((Bankcard)this.mEJ.getParcelable("key_bankcard") != null)
        {
          this.mEJ.putInt("key_pay_flag", 3);
          this.mEJ.putString("key_pwd_cash_title", paramActivity.getString(2131304811));
          Orders localOrders = (Orders)this.mEJ.getParcelable("key_orders");
          if (localOrders != null) {
            this.mEJ.putString("key_pwd_cash_money", e.F(localOrders.cnL));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(45213);
      return this;
      this.mEJ.putInt("key_pay_flag", 2);
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      continue;
      this.mEJ.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      continue;
      b(paramActivity, WalletBalanceFetchUI.class, paramBundle);
    }
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(45217);
    if ((paramMMActivity instanceof WalletBalanceFetchUI))
    {
      paramMMActivity = new b.1(this, paramMMActivity, parami);
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBalanceFetchPwdInputUI))
    {
      paramMMActivity = new b.2(this, paramMMActivity, parami);
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new b.3(this, paramMMActivity, parami);
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new b.4(this, paramMMActivity, parami);
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBalanceFetchResultUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(45209);
          switch (paramAnonymousInt)
          {
          }
          do
          {
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(45209);
            return localObject;
            localObject = this.hwZ.getString(2131304833);
            AppMethodBeat.o(45209);
            return localObject;
            localObject = (Orders)b.B(b.this).getParcelable("key_orders");
            if ((localObject != null) && (!bo.isNullOrNil(((Orders)localObject).ujg)))
            {
              localObject = ((Orders)localObject).ujg;
              AppMethodBeat.o(45209);
              return localObject;
            }
            localObject = this.hwZ.getString(2131304830);
            AppMethodBeat.o(45209);
            return localObject;
            localObject = (Orders)b.C(b.this).getParcelable("key_orders");
          } while ((localObject == null) || (((Orders)localObject).ujf <= 0L));
          Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(((Orders)localObject).ujf));
          AppMethodBeat.o(45209);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean x(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(45208);
          Orders localOrders = (Orders)b.z(b.this).getParcelable("key_orders");
          Bankcard localBankcard = t.cTN().tOD;
          localBankcard.ufM -= localOrders.cnL;
          b.A(b.this).putInt("key_balance_result_logo", 2131231926);
          boolean bool = super.x(paramAnonymousVarArgs);
          AppMethodBeat.o(45208);
          return bool;
        }
      };
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new b.6(this, paramMMActivity, parami);
      AppMethodBeat.o(45217);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(45217);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(45214);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      s.cRG();
      if (s.cRH().cUl())
      {
        if ((Bankcard)this.mEJ.getParcelable("key_bankcard") != null)
        {
          this.mEJ.putInt("key_pay_flag", 3);
          this.mEJ.putString("key_pwd_cash_title", paramActivity.getString(2131304811));
          Orders localOrders = (Orders)this.mEJ.getParcelable("key_orders");
          if (localOrders != null) {
            this.mEJ.putString("key_pwd_cash_money", e.F(localOrders.cnL));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
          AppMethodBeat.o(45214);
          return;
        }
        this.mEJ.putInt("key_pay_flag", 2);
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        AppMethodBeat.o(45214);
        return;
      }
      this.mEJ.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletBalanceFetchPwdInputUI))
    {
      if (paramBundle.getBoolean("key_need_verify_sms", false))
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(45214);
        return;
      }
      b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
    {
      b(paramActivity, WalletCardElementUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletCardElementUI))
    {
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      s.cRG();
      if (s.cRH().cUl())
      {
        b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
        AppMethodBeat.o(45214);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
      AppMethodBeat.o(45214);
      return;
    }
    if ((paramActivity instanceof WalletBalanceFetchResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(45214);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45216);
    a(paramActivity, WalletBalanceManagerUI.class, -1, true);
    AppMethodBeat.o(45216);
  }
  
  public final String bzC()
  {
    return "BalanceFetchProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(45215);
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      AppMethodBeat.o(45215);
      return;
    }
    if ((paramActivity instanceof WalletBalanceResultUI))
    {
      x.dSs();
      b(paramActivity, this.mEJ);
      AppMethodBeat.o(45215);
      return;
    }
    x.dSs();
    B(paramActivity);
    AppMethodBeat.o(45215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b
 * JD-Core Version:    0.7.0.1
 */