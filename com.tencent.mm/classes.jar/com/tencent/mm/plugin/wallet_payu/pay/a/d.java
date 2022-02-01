package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xk.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  private static void b(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(72095);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("shouldForceViewPort", paramBoolean);
    localIntent.putExtra("pay_channel", 2);
    localIntent.putExtra("view_port_code", paramString2);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, 23351);
    AppMethodBeat.o(72095);
  }
  
  private void f(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72096);
    int i = paramBundle.getInt("key_pay_scene", 6);
    if ((i == 11) || (i == 21))
    {
      b(paramActivity, WalletPayUBalanceResultUI.class, paramBundle);
      AppMethodBeat.o(72096);
      return;
    }
    if ((i == 31) || (i == 32) || (i == 33))
    {
      a(paramActivity, "remittance", ".ui.RemittanceResultUI", paramBundle);
      AppMethodBeat.o(72096);
      return;
    }
    b(paramActivity, WalletPayUOrderInfoUI.class, paramBundle);
    AppMethodBeat.o(72096);
  }
  
  private void j(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72094);
    if (paramBundle.getBoolean("key_should_redirect", false))
    {
      paramBundle.getString("key_gateway_code");
      b(paramActivity, paramBundle.getString("key_gateway_reference"), paramBundle.getBoolean("key_should_force_adjust"), paramBundle.getString("key_force_adjust_code"));
      AppMethodBeat.o(72094);
      return;
    }
    f(paramActivity, paramBundle);
    AppMethodBeat.o(72094);
  }
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131765691;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72098);
    if ((paramMMActivity instanceof WalletPayUPayUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean x(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72087);
          paramAnonymousVarArgs = (PayInfo)this.activity.getIntent().getParcelableExtra("key_pay_info");
          if ((paramAnonymousVarArgs != null) && (!bt.isNullOrNil(paramAnonymousVarArgs.dcE)))
          {
            this.Ieo.a(new b(paramAnonymousVarArgs.dcE), paramAnonymousVarArgs.Coq, 1);
            this.Ieo.a(new com.tencent.mm.plugin.wallet_core.c.b.a(), paramAnonymousVarArgs.Coq, 1);
            AppMethodBeat.o(72087);
            return true;
          }
          AppMethodBeat.o(72087);
          return false;
        }
      };
      AppMethodBeat.o(72098);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUBalanceResultUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(72089);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(72089);
            return localObject;
          case 0: 
            localObject = this.activity.getString(2131765020);
            AppMethodBeat.o(72089);
            return localObject;
          }
          Object localObject = this.activity.getString(2131765019);
          AppMethodBeat.o(72089);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72088);
          paramAnonymousVarArgs = (Orders)paramAnonymousVarArgs[0];
          s.dZT();
          Bankcard localBankcard = s.dZU().zHd;
          localBankcard.AbU += paramAnonymousVarArgs.dcH;
          AppMethodBeat.o(72088);
          return false;
        }
      };
      AppMethodBeat.o(72098);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72098);
    return paramMMActivity;
  }
  
  public final com.tencent.mm.wallet_core.d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72090);
    paramBundle.putInt("key_pay_scene", ((PayInfo)paramBundle.getParcelable("key_pay_info")).dtb);
    switch (paramBundle.getInt("key_err_code", 0))
    {
    default: 
      ad.d("MicroMsg.PayUPayProcess", "start pay_flag : " + paramBundle.getInt("key_pay_flag", 0));
      switch (paramBundle.getInt("key_pay_flag", 0))
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(72090);
      return this;
      paramBundle.putInt("key_pay_flag", 3);
      paramBundle.putInt("key_err_code", 0);
      b(paramActivity, WalletPayUChangeBankcardUI.class, paramBundle);
      AppMethodBeat.o(72090);
      return this;
      j(paramActivity, paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    paramInt = 1;
    AppMethodBeat.i(72091);
    switch (paramBundle.getInt("key_err_code", 0))
    {
    default: 
      paramInt = 0;
    }
    while (paramInt != 0)
    {
      ad.i("MicroMsg.PayUPayProcess", "deal with the err!");
      AppMethodBeat.o(72091);
      return;
      b(paramActivity, paramBundle);
      continue;
      com.tencent.mm.wallet_core.a.a(paramActivity, c.class, paramBundle);
      continue;
      paramBundle.putInt("key_pay_flag", 3);
      paramBundle.putInt("key_err_code", 0);
      b(paramActivity, WalletPayUChangeBankcardUI.class, paramBundle);
    }
    if (paramBundle.containsKey("key_pay_flag"))
    {
      paramInt = paramBundle.getInt("key_pay_flag", 0);
      ad.d("MicroMsg.PayUPayProcess", "forward pay_flag : ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72091);
      return;
      paramInt = this.dow.getInt("key_pay_flag", 0);
      break;
      if ((paramActivity instanceof WalletPayUVerifyCodeUI))
      {
        f(paramActivity, paramBundle);
        AppMethodBeat.o(72091);
        return;
      }
      if ((paramActivity instanceof WalletPayUChangeBankcardUI))
      {
        j(paramActivity, paramBundle);
        AppMethodBeat.o(72091);
        return;
      }
      if ((paramActivity instanceof WalletPayUBalanceResultUI))
      {
        Intent localIntent = new Intent(paramActivity, WalletPayUBalanceManagerUI.class);
        localIntent.putExtras(new Bundle());
        localIntent.getExtras().putAll(paramBundle);
        a(paramActivity, WalletPayUBalanceManagerUI.class, localIntent);
        AppMethodBeat.o(72091);
        return;
      }
      super.a(paramActivity, 0, paramBundle);
    }
  }
  
  public final boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int j = -1;
    AppMethodBeat.i(72093);
    ad.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.dow.getInt("key_pay_flag", 0));
    int i;
    Intent localIntent;
    xk.a locala;
    if (this.dow.getBoolean("intent_pay_end", false))
    {
      i = -1;
      localIntent = new Intent();
      if (paramBundle != null)
      {
        paramBundle = new Bundle();
        paramBundle.putInt("intent_pay_end_errcode", this.dow.getInt("intent_pay_end_errcode"));
        paramBundle.putString("intent_pay_app_url", this.dow.getString("intent_pay_app_url"));
        paramBundle.putBoolean("intent_pay_end", this.dow.getBoolean("intent_pay_end"));
        paramBundle.putString("intent_wap_pay_jump_url", this.dow.getString("intent_wap_pay_jump_url"));
        localIntent.putExtras(paramBundle);
      }
      paramBundle = new xk();
      paramBundle.dDy.intent = localIntent;
      locala = paramBundle.dDy;
      if (!this.dow.getBoolean("intent_pay_end", false)) {
        break label218;
      }
    }
    for (;;)
    {
      locala.result = j;
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      a(paramActivity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i, localIntent, false);
      AppMethodBeat.o(72093);
      return;
      i = 0;
      break;
      label218:
      j = 0;
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72097);
    ad.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.dow.getInt("key_pay_flag", 0));
    switch (this.dow.getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(72097);
      return false;
    }
    AppMethodBeat.o(72097);
    return false;
  }
  
  public final String cuB()
  {
    return "PayUPayProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72092);
    ad.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.dow.getInt("key_pay_flag", 0));
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      AppMethodBeat.o(72092);
      return;
    }
    P(paramActivity);
    AppMethodBeat.o(72092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.d
 * JD-Core Version:    0.7.0.1
 */