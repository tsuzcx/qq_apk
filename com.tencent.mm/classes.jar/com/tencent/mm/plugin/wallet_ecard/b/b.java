package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends c
{
  private int aSp()
  {
    return this.kke.getInt(a.qJR);
  }
  
  private String bXw()
  {
    return this.kke.getString(a.qJT);
  }
  
  private void g(Activity paramActivity, Bundle paramBundle)
  {
    y.l("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(aSp()) });
    if (aSp() == 3)
    {
      paramBundle.putInt(a.qJR, 3);
      paramBundle.putString(a.qJX, this.kke.getString(a.qJX, ""));
      b(paramActivity, WalletOpenLqbProxyUI.class, paramBundle);
      return;
    }
    b(paramActivity, WalletECardFinishUI.class, null);
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
    y.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(aSp()) });
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new b.b(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new b.g(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletECardBindCardListUI)) {
      return new b.d(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletECardCheckOtherCardUI)) {
      return new b.a(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletECardElementInputUI)) {
      return new b.e(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletOpenECardProxyUI)) {
      return new b.c(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletOpenLqbProxyUI)) {
      return new b.f(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      if (paramBundle.getBoolean(a.qKj, false))
      {
        y.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.kke.putBoolean(a.qKj, true);
        b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
        paramActivity.finish();
      }
    }
    do
    {
      do
      {
        return;
        b(paramActivity, WalletECardBindCardListUI.class, null);
        return;
        if ((paramActivity instanceof WalletECardBindCardListUI))
        {
          if (this.kke.getInt(a.qJV, a.qKm) == a.qKm)
          {
            if (paramBundle.getBoolean(a.qKg))
            {
              paramBundle.putBoolean("key_need_confirm_finish", true);
              a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
              return;
            }
            g(paramActivity, paramBundle);
            return;
          }
          b(paramActivity, WalletECardCheckOtherCardUI.class, null);
          return;
        }
        if ((paramActivity instanceof WalletVerifyCodeUI)) {
          break;
        }
        if ((paramActivity instanceof WalletECardCheckOtherCardUI))
        {
          bool1 = paramBundle.getBoolean(a.qKh, false);
          boolean bool2 = paramBundle.getBoolean(a.qKg);
          y.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (bool1)
          {
            b(paramActivity, WalletECardElementInputUI.class, null);
            return;
          }
          if (!bool2) {
            break;
          }
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          return;
        }
        if ((paramActivity instanceof WalletECardElementInputUI))
        {
          if (paramBundle.getBoolean(a.qKg))
          {
            paramBundle.putBoolean("key_need_confirm_finish", true);
            a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
            return;
          }
          g(paramActivity, paramBundle);
          return;
        }
      } while (!(paramActivity instanceof WalletOpenECardProxyUI));
      boolean bool1 = paramBundle.getBoolean(a.qJU, false);
      this.kke.putBoolean(a.qJU, bool1);
      String str = this.kke.getString(a.qJS);
      paramInt = aSp();
      int i = paramBundle.getInt("key_ecard_proxy_action", 1);
      y.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bk.bl(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
      if (i != 1) {
        break label416;
      }
      if (bk.bl(str)) {
        break;
      }
      if (bool1)
      {
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
        return;
      }
    } while (paramInt != 3);
    b(paramActivity, WalletECardBindCardListUI.class, null);
    return;
    a(paramActivity, WalletCheckPwdUI.class, paramBundle, 1);
    return;
    label416:
    if (paramBundle.getBoolean(a.qKg))
    {
      paramBundle.putBoolean("key_need_confirm_finish", true);
      a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
      return;
    }
    g(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "OpenECardProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if (paramInt == 100)
    {
      y.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = aSp();
      str1 = bXw();
      str2 = (String)this.kke.get("key_pwd1");
      this.kke.clear();
      this.kke.putInt(a.qJR, paramInt);
      this.kke.putString(a.qJT, str1);
      this.kke.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
    }
    while (!(paramActivity instanceof WalletVerifyCodeUI))
    {
      String str1;
      String str2;
      return;
    }
    if (this.kke.getInt(a.qJV) == a.qKm)
    {
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      return;
    }
    a(paramActivity, WalletECardCheckOtherCardUI.class, 0);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    y.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramActivity, WalletOpenECardProxyUI.class);
    paramBundle.putExtras(localBundle);
    a(paramActivity, WalletOpenECardProxyUI.class, localBundle.getInt("key_process_result_code", -1), paramBundle, true);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean h(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.OpenECardProcess", "intercept");
    paramBundle.putInt("key_process_result_code", 0);
    return super.h(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */