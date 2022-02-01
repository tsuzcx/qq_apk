package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;

public class b
  extends d
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131764989;
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(68389);
    if ((paramMMActivity instanceof WalletBalanceFetchUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68372);
          b.this.a(this.activity, 0, b.this.dow);
          AppMethodBeat.o(68372);
          return true;
        }
        
        public final boolean x(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68371);
          paramAnonymousVarArgs = b.a(b.this);
          com.tencent.mm.plugin.wallet.a.s.dZT();
          paramAnonymousVarArgs.putParcelable("key_history_bankcard", com.tencent.mm.plugin.wallet.a.s.dZU().Aii);
          paramAnonymousVarArgs = (PayInfo)b.this.dow.get("key_pay_info");
          i locali = this.Ieo;
          if (paramAnonymousVarArgs == null) {}
          for (paramAnonymousVarArgs = null;; paramAnonymousVarArgs = paramAnonymousVarArgs.dcE)
          {
            locali.b(new aa(paramAnonymousVarArgs), true);
            AppMethodBeat.o(68371);
            return false;
          }
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBalanceFetchPwdInputUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          boolean bool = false;
          AppMethodBeat.i(68373);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
            b.b(b.this).putString("kreq_token", paramAnonymousString.getToken());
            b.c(b.this).putParcelable("key_authen", paramAnonymousString.zPG);
            paramAnonymousn = b.d(b.this);
            if (!paramAnonymousString.zPE) {
              bool = true;
            }
            paramAnonymousn.putBoolean("key_need_verify_sms", bool);
            paramAnonymousn = paramAnonymousString.ujM;
            if (paramAnonymousn != null) {
              b.e(b.this).putParcelable("key_realname_guide_helper", paramAnonymousn);
            }
            if (paramAnonymousString.zPN != null) {
              b.f(b.this).putString("key_fetch_result_show_info", paramAnonymousString.zPN.toString());
            }
            a.k(this.activity, b.g(b.this));
            this.activity.finish();
            AppMethodBeat.o(68373);
            return true;
          }
          AppMethodBeat.o(68373);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68374);
          Bankcard localBankcard = (Bankcard)b.h(b.this).getParcelable("key_bankcard");
          Object localObject = (String)paramAnonymousVarArgs[0];
          b.i(b.this).putString("key_pwd1", (String)localObject);
          b.j(b.this).putString("key_mobile", localBankcard.field_mobile);
          localObject = new Authen();
          ((Authen)localObject).dtM = 3;
          ((Authen)localObject).Abg = ((String)paramAnonymousVarArgs[0]);
          ((Authen)localObject).uns = localBankcard.field_bindSerial;
          ((Authen)localObject).dca = localBankcard.field_bankcardType;
          ((Authen)localObject).uXi = ((PayInfo)b.k(b.this).getParcelable("key_pay_info"));
          ((Authen)localObject).Abm = localBankcard.field_arrive_type;
          this.Ieo.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen)localObject, (Orders)b.l(b.this).getParcelable("key_orders")), true, 1);
          AppMethodBeat.o(68374);
          return true;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(68375);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
              b.m(b.this).putString("kreq_token", paramAnonymousString.getToken());
              if (paramAnonymousString.isPaySuccess) {
                b.n(b.this).putParcelable("key_orders", paramAnonymousString.zPF);
              }
            }
            if (b.this.c(this.activity, null))
            {
              this.Ieo.a(new ad(b.o(b.this), 13), true, 1);
              AppMethodBeat.o(68375);
              return true;
            }
            b.this.a(this.activity, 0, b.p(b.this));
            AppMethodBeat.o(68375);
            return true;
          }
          AppMethodBeat.o(68375);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68376);
          Authen localAuthen = (Authen)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = (Orders)paramAnonymousVarArgs[1];
          switch (b.q(b.this).getInt("key_pay_flag", 0))
          {
          default: 
            AppMethodBeat.o(68376);
            return false;
          case 1: 
            if (!b.this.eez()) {
              localAuthen.dtM = 1;
            }
            break;
          }
          for (;;)
          {
            b.r(b.this).putParcelable("key_authen", localAuthen);
            this.Ieo.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
            AppMethodBeat.o(68376);
            return true;
            localAuthen.dtM = 4;
            continue;
            if (!b.this.eez())
            {
              localAuthen.dtM = 2;
            }
            else
            {
              localAuthen.dtM = 5;
              continue;
              if (!b.this.eez()) {
                localAuthen.dtM = 3;
              } else {
                localAuthen.dtM = 6;
              }
            }
          }
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(68377);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.d.g))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.d.g)paramAnonymousn;
              if (paramAnonymousString.isPaySuccess) {
                b.s(b.this).putParcelable("key_orders", paramAnonymousString.zPF);
              }
              a.k(this.activity, b.t(b.this));
              AppMethodBeat.o(68377);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
              paramAnonymousn = paramAnonymousString.ujM;
              if (paramAnonymousn != null) {
                b.u(b.this).putParcelable("key_realname_guide_helper", paramAnonymousn);
              }
              b.v(b.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(68377);
              return true;
            }
          }
          AppMethodBeat.o(68377);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68378);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.uXi != null)) {
            paramAnonymousVarArgs.uXi.dtb = 21;
          }
          Orders localOrders = (Orders)b.w(b.this).getParcelable("key_orders");
          switch (b.this.dow.getInt("key_pay_flag", 0))
          {
          default: 
            AppMethodBeat.o(68378);
            return false;
          case 1: 
            paramAnonymousVarArgs.flag = "1";
          }
          for (;;)
          {
            this.Ieo.a(new com.tencent.mm.plugin.wallet.pay.a.d.g(paramAnonymousVarArgs, localOrders), true, 1);
            AppMethodBeat.o(68378);
            return true;
            if (!b.this.eez())
            {
              paramAnonymousVarArgs.flag = "2";
            }
            else
            {
              paramAnonymousVarArgs.flag = "5";
              continue;
              if (!b.this.eez()) {
                paramAnonymousVarArgs.flag = "3";
              } else {
                paramAnonymousVarArgs.flag = "6";
              }
            }
          }
        }
        
        public final boolean y(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68379);
          paramAnonymousVarArgs = (Orders)b.x(b.this).getParcelable("key_orders");
          Authen localAuthen = (Authen)b.y(b.this).getParcelable("key_authen");
          this.Ieo.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(68379);
          return true;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBalanceFetchResultUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(68381);
          switch (paramAnonymousInt)
          {
          }
          do
          {
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = this.activity.getString(2131765017);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = (Orders)b.B(b.this).getParcelable("key_orders");
            if ((localObject != null) && (!bt.isNullOrNil(((Orders)localObject).Afr)))
            {
              localObject = ((Orders)localObject).Afr;
              AppMethodBeat.o(68381);
              return localObject;
            }
            localObject = this.activity.getString(2131765014);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = (Orders)b.C(b.this).getParcelable("key_orders");
          } while ((localObject == null) || (((Orders)localObject).Afq <= 0L));
          Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(((Orders)localObject).Afq));
          AppMethodBeat.o(68381);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean x(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68380);
          Orders localOrders = (Orders)b.z(b.this).getParcelable("key_orders");
          Bankcard localBankcard = com.tencent.mm.plugin.wallet_core.model.s.ecc().zHd;
          localBankcard.AbU -= localOrders.dcH;
          b.A(b.this).putInt("key_balance_result_logo", 2131691098);
          boolean bool = super.x(paramAnonymousVarArgs);
          AppMethodBeat.o(68380);
          return bool;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(68382);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof j)))
          {
            paramAnonymousString = (j)paramAnonymousn;
            if (paramAnonymousString.isPaySuccess) {
              b.D(b.this).putParcelable("key_orders", paramAnonymousString.zPF);
            }
            b.this.a(this.activity, 0, b.E(b.this));
            AppMethodBeat.o(68382);
            return true;
          }
          AppMethodBeat.o(68382);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68383);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
          Orders localOrders = (Orders)b.F(b.this).getParcelable("key_orders");
          this.Ieo.a(new j(paramAnonymousVarArgs, localOrders), true, 1);
          AppMethodBeat.o(68383);
          return true;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(68389);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68385);
    z.abt(14);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecF()) {
        if ((Bankcard)this.dow.getParcelable("key_bankcard") != null)
        {
          this.dow.putInt("key_pay_flag", 3);
          this.dow.putString("key_pwd_cash_title", paramActivity.getString(2131764994));
          Orders localOrders = (Orders)this.dow.getParcelable("key_orders");
          if (localOrders != null) {
            this.dow.putString("key_pwd_cash_money", e.E(localOrders.dcH));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68385);
      return this;
      this.dow.putInt("key_pay_flag", 2);
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      continue;
      this.dow.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      continue;
      b(paramActivity, WalletBalanceFetchUI.class, paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(68386);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecF())
      {
        if ((Bankcard)this.dow.getParcelable("key_bankcard") != null)
        {
          this.dow.putInt("key_pay_flag", 3);
          this.dow.putString("key_pwd_cash_title", paramActivity.getString(2131764994));
          Orders localOrders = (Orders)this.dow.getParcelable("key_orders");
          if (localOrders != null) {
            this.dow.putString("key_pwd_cash_money", e.E(localOrders.dcH));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
          AppMethodBeat.o(68386);
          return;
        }
        this.dow.putInt("key_pay_flag", 2);
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        AppMethodBeat.o(68386);
        return;
      }
      this.dow.putInt("key_pay_flag", 1);
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletBalanceFetchPwdInputUI))
    {
      if (paramBundle.getBoolean("key_need_verify_sms", false))
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(68386);
        return;
      }
      b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
    {
      b(paramActivity, WalletCardElementUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletCardElementUI))
    {
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecF())
      {
        b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
        AppMethodBeat.o(68386);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, WalletBalanceFetchResultUI.class, paramBundle);
      AppMethodBeat.o(68386);
      return;
    }
    if ((paramActivity instanceof WalletBalanceFetchResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(68386);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68388);
    if (this.dow.getInt("key_balance_fetch_scene", 0) == 0)
    {
      a(paramActivity, WalletBalanceManagerUI.class, -1, true);
      AppMethodBeat.o(68388);
      return;
    }
    a(paramActivity, WalletBalanceFetchUI.class, -1, false);
    AppMethodBeat.o(68388);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cuB()
  {
    return "BalanceFetchProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(68387);
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      AppMethodBeat.o(68387);
      return;
    }
    if ((paramActivity instanceof WalletBalanceResultUI))
    {
      z.fjZ();
      b(paramActivity, this.dow);
      AppMethodBeat.o(68387);
      return;
    }
    z.fjZ();
    P(paramActivity);
    AppMethodBeat.o(68387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b
 * JD-Core Version:    0.7.0.1
 */