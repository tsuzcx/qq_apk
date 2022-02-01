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
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;

public class b
  extends e
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_balance_fetch_finish_confirm;
  }
  
  public final com.tencent.mm.wallet_core.c.g a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.i parami)
  {
    AppMethodBeat.i(68389);
    if ((paramMMActivity instanceof WalletBalanceFetchUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68371);
          paramAnonymousVarArgs = b.a(b.this);
          com.tencent.mm.plugin.wallet.model.p.ifO();
          paramAnonymousVarArgs.putParcelable("key_history_bankcard", com.tencent.mm.plugin.wallet.model.p.ifP().VKd);
          paramAnonymousVarArgs = (PayInfo)b.this.hPH.get("key_pay_info");
          com.tencent.mm.wallet_core.c.i locali = this.agTR;
          if (paramAnonymousVarArgs == null) {}
          for (paramAnonymousVarArgs = null;; paramAnonymousVarArgs = paramAnonymousVarArgs.hAT)
          {
            locali.b(new ab(paramAnonymousVarArgs), true);
            AppMethodBeat.o(68371);
            return false;
          }
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68372);
          b.this.a(this.activity, 0, b.this.hPH);
          AppMethodBeat.o(68372);
          return true;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBalanceFetchPwdInputUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          boolean bool = false;
          AppMethodBeat.i(68373);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousp;
            b.b(b.this).putString("kreq_token", paramAnonymousString.getToken());
            b.c(b.this).putParcelable("key_authen", paramAnonymousString.VmM);
            paramAnonymousp = b.d(b.this);
            if (!paramAnonymousString.VmK) {
              bool = true;
            }
            paramAnonymousp.putBoolean("key_need_verify_sms", bool);
            paramAnonymousp = paramAnonymousString.MyJ;
            if (paramAnonymousp != null) {
              b.e(b.this).putParcelable("key_realname_guide_helper", paramAnonymousp);
            }
            if (paramAnonymousString.VmT != null) {
              b.f(b.this).putString("key_fetch_result_show_info", paramAnonymousString.VmT.toString());
            }
            a.k(this.activity, b.g(b.this));
            this.activity.finish();
            AppMethodBeat.o(68373);
            return true;
          }
          AppMethodBeat.o(68373);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68374);
          Bankcard localBankcard = (Bankcard)b.h(b.this).getParcelable("key_bankcard");
          Object localObject = (String)paramAnonymousVarArgs[0];
          b.i(b.this).putString("key_pwd1", (String)localObject);
          b.j(b.this).putString("key_mobile", localBankcard.field_mobile);
          localObject = new Authen();
          ((Authen)localObject).eQp = 3;
          ((Authen)localObject).VCA = ((String)paramAnonymousVarArgs[0]);
          ((Authen)localObject).MDt = localBankcard.field_bindSerial;
          ((Authen)localObject).hAk = localBankcard.field_bankcardType;
          ((Authen)localObject).Nxi = ((PayInfo)b.k(b.this).getParcelable("key_pay_info"));
          ((Authen)localObject).VCG = localBankcard.field_arrive_type;
          this.agTR.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen)localObject, (Orders)b.l(b.this).getParcelable("key_orders")), true, 1);
          AppMethodBeat.o(68374);
          return true;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(68375);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousp;
              b.m(b.this).putString("kreq_token", paramAnonymousString.getToken());
              if (paramAnonymousString.isPaySuccess) {
                b.n(b.this).putParcelable("key_orders", paramAnonymousString.VmL);
              }
            }
            if (b.this.c(this.activity, null))
            {
              this.agTR.a(new ae(b.o(b.this), 13), true, 1);
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
        
        public final boolean t(Object... paramAnonymousVarArgs)
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
            if (!b.this.ill()) {
              localAuthen.eQp = 1;
            }
            break;
          }
          for (;;)
          {
            b.r(b.this).putParcelable("key_authen", localAuthen);
            this.agTR.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
            AppMethodBeat.o(68376);
            return true;
            localAuthen.eQp = 4;
            continue;
            if (!b.this.ill())
            {
              localAuthen.eQp = 2;
            }
            else
            {
              localAuthen.eQp = 5;
              continue;
              if (!b.this.ill()) {
                localAuthen.eQp = 3;
              } else {
                localAuthen.eQp = 6;
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
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean E(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68379);
          paramAnonymousVarArgs = (Orders)b.x(b.this).getParcelable("key_orders");
          Authen localAuthen = (Authen)b.y(b.this).getParcelable("key_authen");
          this.agTR.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(68379);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(68377);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pay.a.d.g))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.d.g)paramAnonymousp;
              if (paramAnonymousString.isPaySuccess) {
                b.s(b.this).putParcelable("key_orders", paramAnonymousString.VmL);
              }
              a.k(this.activity, b.t(b.this));
              AppMethodBeat.o(68377);
              return true;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramAnonymousp;
              paramAnonymousp = paramAnonymousString.MyJ;
              if (paramAnonymousp != null) {
                b.u(b.this).putParcelable("key_realname_guide_helper", paramAnonymousp);
              }
              b.v(b.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(68377);
              return true;
            }
          }
          AppMethodBeat.o(68377);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68378);
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[1];
          if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.Nxi != null)) {
            paramAnonymousVarArgs.Nxi.hUR = 21;
          }
          Orders localOrders = (Orders)b.w(b.this).getParcelable("key_orders");
          switch (b.this.hPH.getInt("key_pay_flag", 0))
          {
          default: 
            AppMethodBeat.o(68378);
            return false;
          case 1: 
            paramAnonymousVarArgs.flag = "1";
          }
          for (;;)
          {
            this.agTR.a(new com.tencent.mm.plugin.wallet.pay.a.d.g(paramAnonymousVarArgs, localOrders), true, 1);
            AppMethodBeat.o(68378);
            return true;
            if (!b.this.ill())
            {
              paramAnonymousVarArgs.flag = "2";
            }
            else
            {
              paramAnonymousVarArgs.flag = "5";
              continue;
              if (!b.this.ill()) {
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
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68380);
          Orders localOrders = (Orders)b.z(b.this).getParcelable("key_orders");
          Bankcard localBankcard = u.iiC().VcF;
          localBankcard.VDo -= localOrders.hAW;
          b.A(b.this).putInt("key_balance_result_logo", a.h.remittance_wait);
          boolean bool = super.D(paramAnonymousVarArgs);
          AppMethodBeat.o(68380);
          return bool;
        }
        
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
            localObject = this.activity.getString(a.i.wallet_balance_result_fetch_title);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = (Orders)b.B(b.this).getParcelable("key_orders");
            if ((localObject != null) && (!Util.isNullOrNil(((Orders)localObject).VGR)))
            {
              localObject = ((Orders)localObject).VGR;
              AppMethodBeat.o(68381);
              return localObject;
            }
            localObject = this.activity.getString(a.i.wallet_balance_result_fetch_request_title);
            AppMethodBeat.o(68381);
            return localObject;
            localObject = (Orders)b.C(b.this).getParcelable("key_orders");
          } while ((localObject == null) || (((Orders)localObject).VGQ <= 0L));
          Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(((Orders)localObject).VGQ));
          AppMethodBeat.o(68381);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(68389);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(68382);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof j)))
          {
            paramAnonymousString = (j)paramAnonymousp;
            if (paramAnonymousString.isPaySuccess) {
              b.D(b.this).putParcelable("key_orders", paramAnonymousString.VmL);
            }
            b.this.a(this.activity, 0, b.E(b.this));
            AppMethodBeat.o(68382);
            return true;
          }
          AppMethodBeat.o(68382);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(68383);
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[0];
          Orders localOrders = (Orders)b.F(b.this).getParcelable("key_orders");
          this.agTR.a(new j(paramAnonymousVarArgs, localOrders), true, 1);
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
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68385);
    aa.aGq(14);
    if ((paramActivity instanceof WalletBalanceFetchUI))
    {
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf()) {
        if ((Bankcard)this.hPH.getParcelable("key_bankcard") != null)
        {
          this.hPH.putInt("key_pay_flag", 3);
          this.hPH.putString("key_pwd_cash_title", paramActivity.getString(a.i.wallet_balance_fetch_title));
          Orders localOrders = (Orders)this.hPH.getParcelable("key_orders");
          if (localOrders != null) {
            this.hPH.putString("key_pwd_cash_money", com.tencent.mm.wallet_core.ui.i.X(localOrders.hAW));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68385);
      return this;
      this.hPH.putInt("key_pay_flag", 2);
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      continue;
      this.hPH.putInt("key_pay_flag", 1);
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
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
      {
        if ((Bankcard)this.hPH.getParcelable("key_bankcard") != null)
        {
          this.hPH.putInt("key_pay_flag", 3);
          this.hPH.putString("key_pwd_cash_title", paramActivity.getString(a.i.wallet_balance_fetch_title));
          Orders localOrders = (Orders)this.hPH.getParcelable("key_orders");
          if (localOrders != null) {
            this.hPH.putString("key_pwd_cash_money", com.tencent.mm.wallet_core.ui.i.X(localOrders.hAW));
          }
          b(paramActivity, WalletBalanceFetchPwdInputUI.class, paramBundle);
          AppMethodBeat.o(68386);
          return;
        }
        this.hPH.putInt("key_pay_flag", 2);
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        AppMethodBeat.o(68386);
        return;
      }
      this.hPH.putInt("key_pay_flag", 1);
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
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
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
    if (this.hPH.getInt("key_balance_fetch_scene", 0) == 0)
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
  
  public final String fud()
  {
    return "BalanceFetchProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
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
      aa.jOQ();
      b(paramActivity, this.hPH);
      AppMethodBeat.o(68387);
      return;
    }
    aa.jOQ();
    Z(paramActivity);
    AppMethodBeat.o(68387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b
 * JD-Core Version:    0.7.0.1
 */