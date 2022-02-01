package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
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
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68372);
          b.this.a(this.activity, 0, b.this.dyY);
          AppMethodBeat.o(68372);
          return true;
        }
        
        public final boolean z(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68371);
          paramAnonymousVarArgs = b.a(b.this);
          s.eGW();
          paramAnonymousVarArgs.putParcelable("key_history_bankcard", s.eGX().Dsz);
          paramAnonymousVarArgs = (PayInfo)b.this.dyY.get("key_pay_info");
          i locali = this.LVJ;
          if (paramAnonymousVarArgs == null) {}
          for (paramAnonymousVarArgs = null;; paramAnonymousVarArgs = paramAnonymousVarArgs.dmw)
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          boolean bool = false;
          AppMethodBeat.i(68373);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
            b.b(b.this).putString("kreq_token", paramAnonymousString.getToken());
            b.c(b.this).putParcelable("key_authen", paramAnonymousString.CZU);
            paramAnonymousn = b.d(b.this);
            if (!paramAnonymousString.CZS) {
              bool = true;
            }
            paramAnonymousn.putBoolean("key_need_verify_sms", bool);
            paramAnonymousn = paramAnonymousString.wNL;
            if (paramAnonymousn != null) {
              b.e(b.this).putParcelable("key_realname_guide_helper", paramAnonymousn);
            }
            if (paramAnonymousString.Dab != null) {
              b.f(b.this).putString("key_fetch_result_show_info", paramAnonymousString.Dab.toString());
            }
            a.k(this.activity, b.g(b.this));
            this.activity.finish();
            AppMethodBeat.o(68373);
            return true;
          }
          AppMethodBeat.o(68373);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68374);
          Bankcard localBankcard = (Bankcard)b.h(b.this).getParcelable("key_bankcard");
          Object localObject = (String)paramAnonymousVarArgs[0];
          b.i(b.this).putString("key_pwd1", (String)localObject);
          b.j(b.this).putString("key_mobile", localBankcard.field_mobile);
          localObject = new Authen();
          ((Authen)localObject).dEu = 3;
          ((Authen)localObject).Dlv = ((String)paramAnonymousVarArgs[0]);
          ((Authen)localObject).wRt = localBankcard.field_bindSerial;
          ((Authen)localObject).dlT = localBankcard.field_bankcardType;
          ((Authen)localObject).xDC = ((PayInfo)b.k(b.this).getParcelable("key_pay_info"));
          ((Authen)localObject).DlB = localBankcard.field_arrive_type;
          this.LVJ.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen)localObject, (Orders)b.l(b.this).getParcelable("key_orders")), true, 1);
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(68375);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
              b.m(b.this).putString("kreq_token", paramAnonymousString.getToken());
              if (paramAnonymousString.isPaySuccess) {
                b.n(b.this).putParcelable("key_orders", paramAnonymousString.CZT);
              }
            }
            if (b.this.c(this.activity, null))
            {
              this.LVJ.a(new ad(b.o(b.this), 13), true, 1);
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
        
        public final boolean r(Object... paramAnonymousVarArgs)
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
            if (!b.this.eLI()) {
              localAuthen.dEu = 1;
            }
            break;
          }
          for (;;)
          {
            b.r(b.this).putParcelable("key_authen", localAuthen);
            this.LVJ.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
            AppMethodBeat.o(68376);
            return true;
            localAuthen.dEu = 4;
            continue;
            if (!b.this.eLI())
            {
              localAuthen.dEu = 2;
            }
            else
            {
              localAuthen.dEu = 5;
              continue;
              if (!b.this.eLI()) {
                localAuthen.dEu = 3;
              } else {
                localAuthen.dEu = 6;
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
        public final boolean A(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68379);
          paramAnonymousVarArgs = (Orders)b.x(b.this).getParcelable("key_orders");
          Authen localAuthen = (Authen)b.y(b.this).getParcelable("key_authen");
          this.LVJ.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(68379);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(68377);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.d.g))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.d.g)paramAnonymousn;
              if (paramAnonymousString.isPaySuccess) {
                b.s(b.this).putParcelable("key_orders", paramAnonymousString.CZT);
              }
              a.k(this.activity, b.t(b.this));
              AppMethodBeat.o(68377);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousn;
              paramAnonymousn = paramAnonymousString.wNL;
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
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68378);
          paramAnonymousVarArgs = (v)paramAnonymousVarArgs[1];
          if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.xDC != null)) {
            paramAnonymousVarArgs.xDC.dDH = 21;
          }
          Orders localOrders = (Orders)b.w(b.this).getParcelable("key_orders");
          switch (b.this.dyY.getInt("key_pay_flag", 0))
          {
          default: 
            AppMethodBeat.o(68378);
            return false;
          case 1: 
            paramAnonymousVarArgs.flag = "1";
          }
          for (;;)
          {
            this.LVJ.a(new com.tencent.mm.plugin.wallet.pay.a.d.g(paramAnonymousVarArgs, localOrders), true, 1);
            AppMethodBeat.o(68378);
            return true;
            if (!b.this.eLI())
            {
              paramAnonymousVarArgs.flag = "2";
            }
            else
            {
              paramAnonymousVarArgs.flag = "5";
              continue;
              if (!b.this.eLI()) {
                paramAnonymousVarArgs.flag = "3";
              } else {
                paramAnonymousVarArgs.flag = "6";
              }
            }
          }
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
            if ((localObject != null) && (!bu.isNullOrNil(((Orders)localObject).DpJ)))
            {
              localObject = ((Orders)localObject).DpJ;
              AppMethodBeat.o(68381);
              return localObject;
            }
            localObject = this.activity.getString(2131765014);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = (Orders)b.C(b.this).getParcelable("key_orders");
          } while ((localObject == null) || (((Orders)localObject).DpI <= 0L));
          Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(((Orders)localObject).DpI));
          AppMethodBeat.o(68381);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean z(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68380);
          Orders localOrders = (Orders)b.z(b.this).getParcelable("key_orders");
          Bankcard localBankcard = t.eJf().CRg;
          localBankcard.Dmj -= localOrders.dmz;
          b.A(b.this).putInt("key_balance_result_logo", 2131691098);
          boolean bool = super.z(paramAnonymousVarArgs);
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(68382);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof j)))
          {
            paramAnonymousString = (j)paramAnonymousn;
            if (paramAnonymousString.isPaySuccess) {
              b.D(b.this).putParcelable("key_orders", paramAnonymousString.CZT);
            }
            b.this.a(this.activity, 0, b.E(b.this));
            AppMethodBeat.o(68382);
            return true;
          }
          AppMethodBeat.o(68382);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68383);
          paramAnonymousVarArgs = (v)paramAnonymousVarArgs[0];
          Orders localOrders = (Orders)b.F(b.this).getParcelable("key_orders");
          this.LVJ.a(new j(paramAnonymousVarArgs, localOrders), true, 1);
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
    z.agV(14);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      s.eGW();
      if (s.eGX().eJH()) {
        if ((Bankcard)this.dyY.getParcelable("key_bankcard") != null)
        {
          this.dyY.putInt("key_pay_flag", 3);
          this.dyY.putString("key_pwd_cash_title", paramActivity.getString(2131764994));
          Orders localOrders = (Orders)this.dyY.getParcelable("key_orders");
          if (localOrders != null) {
            this.dyY.putString("key_pwd_cash_money", f.D(localOrders.dmz));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68385);
      return this;
      this.dyY.putInt("key_pay_flag", 2);
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      continue;
      this.dyY.putInt("key_pay_flag", 1);
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
      s.eGW();
      if (s.eGX().eJH())
      {
        if ((Bankcard)this.dyY.getParcelable("key_bankcard") != null)
        {
          this.dyY.putInt("key_pay_flag", 3);
          this.dyY.putString("key_pwd_cash_title", paramActivity.getString(2131764994));
          Orders localOrders = (Orders)this.dyY.getParcelable("key_orders");
          if (localOrders != null) {
            this.dyY.putString("key_pwd_cash_money", f.D(localOrders.dmz));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
          AppMethodBeat.o(68386);
          return;
        }
        this.dyY.putInt("key_pay_flag", 2);
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        AppMethodBeat.o(68386);
        return;
      }
      this.dyY.putInt("key_pay_flag", 1);
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
      s.eGW();
      if (s.eGX().eJH())
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
    if (this.dyY.getInt("key_balance_fetch_scene", 0) == 0)
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
  
  public final String cSH()
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
      z.fVV();
      b(paramActivity, this.dyY);
      AppMethodBeat.o(68387);
      return;
    }
    z.fVV();
    R(paramActivity);
    AppMethodBeat.o(68387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b
 * JD-Core Version:    0.7.0.1
 */