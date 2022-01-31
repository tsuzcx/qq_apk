package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c
  extends com.tencent.mm.wallet_core.c
{
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48341);
    ab.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(48341);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48345);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new c.1(this, paramMMActivity, parami, this.mEJ);
      AppMethodBeat.o(48345);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUCardElementUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(48339);
          if (((paramAnonymousm instanceof a)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.a(c.this).putInt("key_errcode_payu", 0);
            c.this.b(this.hwZ, c.b(c.this));
          }
          if ((paramAnonymousm instanceof NetScenePayUElementQuery))
          {
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label126;
            }
            paramAnonymousString = ((NetScenePayUElementQuery)paramAnonymousm).uBO;
            if (bo.isNullOrNil(paramAnonymousString.uBP)) {
              paramAnonymousString.uBQ = ah.getContext().getString(2131305496);
            }
            c.c(c.this).putParcelable("key_card_element", ((NetScenePayUElementQuery)paramAnonymousm).uBO);
          }
          for (;;)
          {
            AppMethodBeat.o(48339);
            return false;
            label126:
            NetScenePayUElementQuery.PayUBankcardElement localPayUBankcardElement = new NetScenePayUElementQuery.PayUBankcardElement();
            paramAnonymousm = paramAnonymousString;
            if (bo.isNullOrNil(paramAnonymousString)) {
              paramAnonymousm = "err card element";
            }
            localPayUBankcardElement.uBQ = paramAnonymousm;
            c.d(c.this).putParcelable("key_card_element", localPayUBankcardElement);
          }
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(48340);
          paramAnonymousVarArgs = (NetScenePayUElementQuery.PayUBankcardElement)c.e(c.this).getParcelable("key_card_element");
          this.AXB.a(new a(paramAnonymousVarArgs.ppn, paramAnonymousVarArgs.uBQ, c.f(c.this).getString("key_bank_username"), c.g(c.this).getString("key_card_id"), c.h(c.this).getString("key_expire_data"), paramAnonymousVarArgs.cardType, c.i(c.this).getString("key_cvv"), c.j(c.this).getString("key_pwd1")), true);
          AppMethodBeat.o(48340);
          return false;
        }
      };
      AppMethodBeat.o(48345);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48345);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48342);
    if ((paramActivity instanceof WalletPayUCheckPwdUI)) {
      b(paramActivity, WalletPayUCardElementUI.class, paramBundle);
    }
    AppMethodBeat.o(48342);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48344);
    if (this.mEJ.getInt("key_errcode_payu", -1) == 0)
    {
      t.makeText(paramActivity, 2131305355, 0).show();
      a(paramActivity, WalletPayUBankcardManageUI.class, -1, false);
      AppMethodBeat.o(48344);
      return;
    }
    t.makeText(paramActivity, 2131305060, 0).show();
    a(paramActivity, WalletPayUBankcardManageUI.class, 0, false);
    AppMethodBeat.o(48344);
  }
  
  public final String bzC()
  {
    return "PayUBindProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48343);
    B(paramActivity);
    AppMethodBeat.o(48343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.c
 * JD-Core Version:    0.7.0.1
 */