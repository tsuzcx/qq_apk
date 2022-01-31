package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class e
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  private static void b(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(48454);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("shouldForceViewPort", paramBoolean);
    localIntent.putExtra("pay_channel", 2);
    localIntent.putExtra("view_port_code", paramString2);
    d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, 23351);
    AppMethodBeat.o(48454);
  }
  
  private void f(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48455);
    int i = paramBundle.getInt("key_pay_scene", 6);
    if ((i == 11) || (i == 21))
    {
      b(paramActivity, WalletPayUBalanceResultUI.class, paramBundle);
      AppMethodBeat.o(48455);
      return;
    }
    if ((i == 31) || (i == 32) || (i == 33))
    {
      a(paramActivity, "remittance", ".ui.RemittanceResultUI", paramBundle);
      AppMethodBeat.o(48455);
      return;
    }
    b(paramActivity, WalletPayUOrderInfoUI.class, paramBundle);
    AppMethodBeat.o(48455);
  }
  
  private void i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48453);
    if (paramBundle.getBoolean("key_should_redirect", false))
    {
      paramBundle.getString("key_gateway_code");
      b(paramActivity, paramBundle.getString("key_gateway_reference"), paramBundle.getBoolean("key_should_force_adjust"), paramBundle.getString("key_force_adjust_code"));
      AppMethodBeat.o(48453);
      return;
    }
    f(paramActivity, paramBundle);
    AppMethodBeat.o(48453);
  }
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131305477;
  }
  
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48449);
    paramBundle.putInt("key_pay_scene", ((PayInfo)paramBundle.getParcelable("key_pay_info")).cCD);
    switch (paramBundle.getInt("key_err_code", 0))
    {
    default: 
      ab.d("MicroMsg.PayUPayProcess", "start pay_flag : " + paramBundle.getInt("key_pay_flag", 0));
      switch (paramBundle.getInt("key_pay_flag", 0))
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(48449);
      return this;
      paramBundle.putInt("key_pay_flag", 3);
      paramBundle.putInt("key_err_code", 0);
      b(paramActivity, WalletPayUChangeBankcardUI.class, paramBundle);
      AppMethodBeat.o(48449);
      return this;
      i(paramActivity, paramBundle);
    }
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48457);
    if ((paramMMActivity instanceof WalletPayUPayUI))
    {
      paramMMActivity = new e.1(this, paramMMActivity, parami);
      AppMethodBeat.o(48457);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUBalanceResultUI))
    {
      paramMMActivity = new e.2(this, paramMMActivity, parami);
      AppMethodBeat.o(48457);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48457);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    paramInt = 1;
    AppMethodBeat.i(48450);
    switch (paramBundle.getInt("key_err_code", 0))
    {
    default: 
      paramInt = 0;
    }
    while (paramInt != 0)
    {
      ab.i("MicroMsg.PayUPayProcess", "deal with the err!");
      AppMethodBeat.o(48450);
      return;
      b(paramActivity, paramBundle);
      continue;
      com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_payu.bind.model.c.class, paramBundle);
      continue;
      paramBundle.putInt("key_pay_flag", 3);
      paramBundle.putInt("key_err_code", 0);
      b(paramActivity, WalletPayUChangeBankcardUI.class, paramBundle);
    }
    if (paramBundle.containsKey("key_pay_flag"))
    {
      paramInt = paramBundle.getInt("key_pay_flag", 0);
      ab.d("MicroMsg.PayUPayProcess", "forward pay_flag : ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(48450);
      return;
      paramInt = this.mEJ.getInt("key_pay_flag", 0);
      break;
      if ((paramActivity instanceof WalletPayUVerifyCodeUI))
      {
        f(paramActivity, paramBundle);
        AppMethodBeat.o(48450);
        return;
      }
      if ((paramActivity instanceof WalletPayUChangeBankcardUI))
      {
        i(paramActivity, paramBundle);
        AppMethodBeat.o(48450);
        return;
      }
      if ((paramActivity instanceof WalletPayUBalanceResultUI))
      {
        Intent localIntent = new Intent(paramActivity, WalletPayUBalanceManagerUI.class);
        localIntent.putExtras(new Bundle());
        localIntent.getExtras().putAll(paramBundle);
        a(paramActivity, WalletPayUBalanceManagerUI.class, localIntent);
        AppMethodBeat.o(48450);
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
    AppMethodBeat.i(48452);
    ab.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.mEJ.getInt("key_pay_flag", 0));
    int i;
    Intent localIntent;
    vk.a locala;
    if (this.mEJ.getBoolean("intent_pay_end", false))
    {
      i = -1;
      localIntent = new Intent();
      if (paramBundle != null)
      {
        paramBundle = new Bundle();
        paramBundle.putInt("intent_pay_end_errcode", this.mEJ.getInt("intent_pay_end_errcode"));
        paramBundle.putString("intent_pay_app_url", this.mEJ.getString("intent_pay_app_url"));
        paramBundle.putBoolean("intent_pay_end", this.mEJ.getBoolean("intent_pay_end"));
        paramBundle.putString("intent_wap_pay_jump_url", this.mEJ.getString("intent_wap_pay_jump_url"));
        localIntent.putExtras(paramBundle);
      }
      paramBundle = new vk();
      paramBundle.cMA.intent = localIntent;
      locala = paramBundle.cMA;
      if (!this.mEJ.getBoolean("intent_pay_end", false)) {
        break label218;
      }
    }
    for (;;)
    {
      locala.result = j;
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      a(paramActivity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i, localIntent, false);
      AppMethodBeat.o(48452);
      return;
      i = 0;
      break;
      label218:
      j = 0;
    }
  }
  
  public final String bzC()
  {
    return "PayUPayProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48456);
    ab.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.mEJ.getInt("key_pay_flag", 0));
    switch (this.mEJ.getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(48456);
      return false;
    }
    AppMethodBeat.o(48456);
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48451);
    ab.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.mEJ.getInt("key_pay_flag", 0));
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      AppMethodBeat.o(48451);
      return;
    }
    B(paramActivity);
    AppMethodBeat.o(48451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.e
 * JD-Core Version:    0.7.0.1
 */