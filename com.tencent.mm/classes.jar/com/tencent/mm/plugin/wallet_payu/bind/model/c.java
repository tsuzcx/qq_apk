package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c
  extends d
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(71985);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new com.tencent.mm.plugin.wallet_payu.pwd.a.a(paramMMActivity, parami, this.dQL)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(71978);
          if (paramAnonymousInt == 0)
          {
            localObject = this.activity.getString(2131767639);
            AppMethodBeat.o(71978);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(71978);
          return localObject;
        }
      };
      AppMethodBeat.o(71985);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUCardElementUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(71979);
          if (((paramAnonymousq instanceof a)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.a(c.this).putInt("key_errcode_payu", 0);
            c.this.b(this.activity, c.b(c.this));
          }
          if ((paramAnonymousq instanceof NetScenePayUElementQuery))
          {
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label126;
            }
            paramAnonymousString = ((NetScenePayUElementQuery)paramAnonymousq).IsE;
            if (Util.isNullOrNil(paramAnonymousString.IsF)) {
              paramAnonymousString.IsG = MMApplicationContext.getContext().getString(2131768164);
            }
            c.c(c.this).putParcelable("key_card_element", ((NetScenePayUElementQuery)paramAnonymousq).IsE);
          }
          for (;;)
          {
            AppMethodBeat.o(71979);
            return false;
            label126:
            NetScenePayUElementQuery.PayUBankcardElement localPayUBankcardElement = new NetScenePayUElementQuery.PayUBankcardElement();
            paramAnonymousq = paramAnonymousString;
            if (Util.isNullOrNil(paramAnonymousString)) {
              paramAnonymousq = "err card element";
            }
            localPayUBankcardElement.IsG = paramAnonymousq;
            c.d(c.this).putParcelable("key_card_element", localPayUBankcardElement);
          }
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(71980);
          paramAnonymousVarArgs = (NetScenePayUElementQuery.PayUBankcardElement)c.e(c.this).getParcelable("key_card_element");
          this.Ruz.b(new a(paramAnonymousVarArgs.AOj, paramAnonymousVarArgs.IsG, c.f(c.this).getString("key_bank_username"), c.g(c.this).getString("key_card_id"), c.h(c.this).getString("key_expire_data"), paramAnonymousVarArgs.cardType, c.i(c.this).getString("key_cvv"), c.j(c.this).getString("key_pwd1")), true);
          AppMethodBeat.o(71980);
          return false;
        }
      };
      AppMethodBeat.o(71985);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(71985);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71981);
    Log.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(71981);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71982);
    if ((paramActivity instanceof WalletPayUCheckPwdUI)) {
      b(paramActivity, WalletPayUCardElementUI.class, paramBundle);
    }
    AppMethodBeat.o(71982);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71984);
    if (this.dQL.getInt("key_errcode_payu", -1) == 0)
    {
      u.makeText(paramActivity, 2131768018, 0).show();
      a(paramActivity, WalletPayUBankcardManageUI.class, -1, false);
      AppMethodBeat.o(71984);
      return;
    }
    u.makeText(paramActivity, 2131767695, 0).show();
    a(paramActivity, WalletPayUBankcardManageUI.class, 0, false);
    AppMethodBeat.o(71984);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String dKC()
  {
    return "PayUBindProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71983);
    P(paramActivity);
    AppMethodBeat.o(71983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.c
 * JD-Core Version:    0.7.0.1
 */