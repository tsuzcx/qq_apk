package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(66193);
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(66187);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            if ((paramAnonymousn instanceof ad))
            {
              if ((((WalletBaseUI)this.activity).getInput() != null) && (((WalletBaseUI)this.activity).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.cZi()))
              {
                c.j(this.activity);
                AppMethodBeat.o(66187);
                return true;
              }
            }
            else if ((paramAnonymousn instanceof k))
            {
              com.tencent.mm.wallet_core.a.k(this.activity, ((WalletBaseUI)this.activity).getInput());
              com.tencent.mm.plugin.offline.c.a.au(this.activity);
              AppMethodBeat.o(66187);
              return true;
            }
          }
          AppMethodBeat.o(66187);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66186);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.flag = "2";
          this.Ieo.a(new v(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(66186);
          return true;
        }
      };
      AppMethodBeat.o(66193);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(66189);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            if ((paramAnonymousn instanceof ad))
            {
              if ((((WalletBaseUI)this.activity).getInput() != null) && (((WalletBaseUI)this.activity).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.cZi()))
              {
                c.j(this.activity);
                AppMethodBeat.o(66189);
                return true;
              }
            }
            else if ((paramAnonymousn instanceof k))
            {
              paramAnonymousString = ((WalletBaseUI)this.activity).getInput();
              paramAnonymousString.putBoolean("intent_bind_end", true);
              com.tencent.mm.wallet_core.a.k(this.activity, paramAnonymousString);
              com.tencent.mm.plugin.offline.c.a.au(this.activity);
              AppMethodBeat.o(66189);
              return true;
            }
          }
          AppMethodBeat.o(66189);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66188);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
          this.Ieo.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(66188);
          return true;
        }
      };
      AppMethodBeat.o(66193);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(66193);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66190);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(66190);
    return paramActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66191);
    super.a(paramActivity, paramInt, paramBundle);
    AppMethodBeat.o(66191);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66192);
    com.tencent.mm.sdk.b.a.ESL.l(new mu());
    if (com.tencent.mm.plugin.offline.c.a.cZi()) {
      c(paramActivity, WalletOfflineEntranceUI.class);
    }
    for (;;)
    {
      if (paramActivity != null) {
        paramActivity.finish();
      }
      AppMethodBeat.o(66192);
      return;
      if (paramBundle.getInt("key_entry_scene", -1) == 2) {
        e(paramActivity, "offline", "ui.WalletOfflineEntranceUI");
      } else {
        e(paramActivity, "mall", ".ui.MallIndexUI");
      }
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66194);
    boolean bool = super.c(paramActivity, paramBundle);
    AppMethodBeat.o(66194);
    return bool;
  }
  
  public final String cuB()
  {
    return "OfflineBindCardProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c
 * JD-Core Version:    0.7.0.1
 */