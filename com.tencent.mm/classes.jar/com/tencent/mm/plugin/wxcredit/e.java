package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class e
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48639);
    if (!t.cTN().cUq())
    {
      if (!t.cTN().cUl()) {
        break label38;
      }
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(48639);
      return this;
      label38:
      b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
    }
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48643);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new e.1(this, paramMMActivity, parami);
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCheckIdentityUI))
    {
      paramMMActivity = new e.2(this, paramMMActivity, parami);
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new e.3(this, paramMMActivity, parami);
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBindDepositUI))
    {
      paramMMActivity = new e.4(this, paramMMActivity, parami);
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(48635);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousm instanceof b))
            {
              this.AXB.a(new ab(), true, 1);
              AppMethodBeat.o(48635);
              return true;
            }
            if ((paramAnonymousm instanceof ab))
            {
              paramAnonymousString = new com.tencent.mm.plugin.wxcredit.a.g(e.aa(e.this).getString("key_verify_code"), e.ab(e.this).getString("KEY_SESSION_KEY"), e.ac(e.this).getString("key_pwd1"), t.cTN().cUP(), e.ad(e.this).getString("key_bank_type"));
              this.AXB.a(paramAnonymousString, true, 1);
              AppMethodBeat.o(48635);
              return true;
            }
            if ((paramAnonymousm instanceof com.tencent.mm.plugin.wxcredit.a.g))
            {
              paramAnonymousString = ((com.tencent.mm.plugin.wxcredit.a.g)paramAnonymousm).cCC;
              if (!bo.isNullOrNil(paramAnonymousString)) {
                e.ae(e.this).putString("key_bank_username", paramAnonymousString);
              }
              e.this.a(this.hwZ, 0, e.af(e.this));
              AppMethodBeat.o(48635);
              return true;
            }
          }
          AppMethodBeat.o(48635);
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(48636);
          if (!e.ag(e.this).getBoolean("key_is_bank_user", false)) {
            this.AXB.a(new b((u)paramAnonymousVarArgs[0]), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(48636);
            return true;
            this.AXB.a(new com.tencent.mm.plugin.wxcredit.a.g(e.ah(e.this).getString("key_verify_code"), e.ai(e.this).getString("KEY_SESSION_KEY"), e.aj(e.this).getString("key_pwd1"), t.cTN().cUP(), e.ak(e.this).getString("key_bank_type")), true, 1);
          }
        }
      };
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletWXCreditOpenResultUI))
    {
      paramMMActivity = new e.6(this, paramMMActivity, parami);
      AppMethodBeat.o(48643);
      return paramMMActivity;
    }
    AppMethodBeat.o(48643);
    return null;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48640);
    if ((paramActivity instanceof WalletWXCreditOpenUI))
    {
      b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      B(paramActivity);
      b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditOpenUI))
    {
      b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletCheckIdentityUI))
    {
      if (paramBundle.getBoolean("key_need_bind_deposit", true))
      {
        b(paramActivity, WalletBindDepositUI.class, paramBundle);
        AppMethodBeat.o(48640);
        return;
      }
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletBindDepositUI))
    {
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (t.cTN().cUl())
      {
        b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
        AppMethodBeat.o(48640);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
      AppMethodBeat.o(48640);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditOpenResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(48640);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48642);
    d(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(48642);
  }
  
  public final String bzC()
  {
    return "WXCreditOpenProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48641);
    B(paramActivity);
    AppMethodBeat.o(48641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e
 * JD-Core Version:    0.7.0.1
 */