package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends com.tencent.mm.wallet_core.c
{
  private int byI()
  {
    AppMethodBeat.i(48110);
    int i = this.mEJ.getInt(a.uyJ);
    AppMethodBeat.o(48110);
    return i;
  }
  
  private String cXb()
  {
    AppMethodBeat.i(48109);
    String str = this.mEJ.getString(a.uyL);
    AppMethodBeat.o(48109);
    return str;
  }
  
  private void g(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48105);
    ab.b("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(byI()) });
    if (byI() == 3)
    {
      paramBundle.putInt(a.uyJ, 3);
      paramBundle.putString(a.uyP, this.mEJ.getString(a.uyP, ""));
      b(paramActivity, WalletOpenLqbProxyUI.class, paramBundle);
      AppMethodBeat.o(48105);
      return;
    }
    b(paramActivity, WalletECardFinishUI.class, null);
    AppMethodBeat.o(48105);
  }
  
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48103);
    b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
    ab.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(byI()) });
    AppMethodBeat.o(48103);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48111);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new b.b(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new b.g(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardBindCardListUI))
    {
      paramMMActivity = new b.d(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardCheckOtherCardUI))
    {
      paramMMActivity = new b.a(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardElementInputUI))
    {
      paramMMActivity = new b.e(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletOpenECardProxyUI))
    {
      paramMMActivity = new b.c(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletOpenLqbProxyUI))
    {
      paramMMActivity = new b.f(this, paramMMActivity, parami);
      AppMethodBeat.o(48111);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48111);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48104);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(a.uzb, false))
      {
        ab.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.mEJ.putBoolean(a.uzb, true);
        b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
        paramActivity.finish();
        AppMethodBeat.o(48104);
        return;
      }
      b(paramActivity, WalletECardBindCardListUI.class, null);
      AppMethodBeat.o(48104);
      return;
    }
    if ((paramActivity instanceof WalletECardBindCardListUI))
    {
      if (this.mEJ.getInt(a.uyN, a.uze) == a.uze)
      {
        if (paramBundle.getBoolean(a.uyY))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(48104);
          return;
        }
        g(paramActivity, paramBundle);
        AppMethodBeat.o(48104);
        return;
      }
      b(paramActivity, WalletECardCheckOtherCardUI.class, null);
      AppMethodBeat.o(48104);
      return;
    }
    if (!(paramActivity instanceof WalletVerifyCodeUI))
    {
      boolean bool1;
      if ((paramActivity instanceof WalletECardCheckOtherCardUI))
      {
        bool1 = paramBundle.getBoolean(a.uyZ, false);
        boolean bool2 = paramBundle.getBoolean(a.uyY);
        ab.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (bool1)
        {
          b(paramActivity, WalletECardElementInputUI.class, null);
          AppMethodBeat.o(48104);
          return;
        }
        if (bool2)
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(48104);
        }
      }
      else
      {
        if ((paramActivity instanceof WalletECardElementInputUI))
        {
          if (paramBundle.getBoolean(a.uyY))
          {
            paramBundle.putBoolean("key_need_confirm_finish", true);
            a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
            AppMethodBeat.o(48104);
            return;
          }
          g(paramActivity, paramBundle);
          AppMethodBeat.o(48104);
          return;
        }
        if (!(paramActivity instanceof WalletOpenECardProxyUI)) {
          break label521;
        }
        bool1 = paramBundle.getBoolean(a.uyM, false);
        this.mEJ.putBoolean(a.uyM, bool1);
        String str = this.mEJ.getString(a.uyK);
        paramInt = byI();
        int i = paramBundle.getInt("key_ecard_proxy_action", 1);
        ab.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bo.isNullOrNil(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i == 1)
        {
          if (!bo.isNullOrNil(str))
          {
            if (bool1)
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(48104);
              return;
            }
            if (paramInt != 3) {
              break label521;
            }
            b(paramActivity, WalletECardBindCardListUI.class, null);
            AppMethodBeat.o(48104);
            return;
          }
          a(paramActivity, WalletCheckPwdUI.class, paramBundle, 1);
          AppMethodBeat.o(48104);
          return;
        }
        if (paramBundle.getBoolean(a.uyY))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(48104);
          return;
        }
      }
    }
    g(paramActivity, paramBundle);
    label521:
    AppMethodBeat.o(48104);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(48107);
    ab.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramActivity, WalletOpenECardProxyUI.class);
    paramBundle.putExtras(localBundle);
    if (localBundle.containsKey("key_process_result_code")) {
      i = localBundle.getInt("key_process_result_code", 0);
    }
    a(paramActivity, WalletOpenECardProxyUI.class, i, paramBundle, true);
    AppMethodBeat.o(48107);
  }
  
  public final String bzC()
  {
    return "OpenECardProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48106);
    if (paramInt == 100)
    {
      ab.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = byI();
      String str1 = cXb();
      String str2 = (String)this.mEJ.get("key_pwd1");
      this.mEJ.clear();
      this.mEJ.putInt(a.uyJ, paramInt);
      this.mEJ.putString(a.uyL, str1);
      this.mEJ.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(48106);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.mEJ.getInt(a.uyN) == a.uze)
      {
        a(paramActivity, WalletECardBindCardListUI.class, 0);
        AppMethodBeat.o(48106);
        return;
      }
      a(paramActivity, WalletECardCheckOtherCardUI.class, 0);
    }
    AppMethodBeat.o(48106);
  }
  
  public final boolean h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48108);
    ab.d("MicroMsg.OpenECardProcess", "intercept");
    paramBundle.putInt("key_process_result_code", 0);
    boolean bool = super.h(paramActivity, paramBundle);
    AppMethodBeat.o(48108);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */