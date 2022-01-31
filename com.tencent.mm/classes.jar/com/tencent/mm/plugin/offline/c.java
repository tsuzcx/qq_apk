package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c
  extends b
{
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43288);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(43288);
    return paramActivity;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(43291);
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(43285);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            if ((paramAnonymousm instanceof ab))
            {
              if ((((WalletBaseUI)this.hwZ).getInput() != null) && (((WalletBaseUI)this.hwZ).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.bZw()))
              {
                c.h(this.hwZ);
                AppMethodBeat.o(43285);
                return true;
              }
            }
            else if ((paramAnonymousm instanceof k))
            {
              com.tencent.mm.wallet_core.a.j(this.hwZ, ((WalletBaseUI)this.hwZ).getInput());
              com.tencent.mm.plugin.offline.c.a.ac(this.hwZ);
              AppMethodBeat.o(43285);
              return true;
            }
          }
          AppMethodBeat.o(43285);
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(43284);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.flag = "2";
          this.AXB.a(new t(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(43284);
          return true;
        }
      };
      AppMethodBeat.o(43291);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new c.2(this, paramMMActivity, parami);
      AppMethodBeat.o(43291);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(43291);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(43289);
    super.a(paramActivity, paramInt, paramBundle);
    AppMethodBeat.o(43289);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43290);
    com.tencent.mm.sdk.b.a.ymk.l(new lk());
    if (com.tencent.mm.plugin.offline.c.a.bZw()) {
      c(paramActivity, WalletOfflineEntranceUI.class);
    }
    for (;;)
    {
      if (paramActivity != null) {
        paramActivity.finish();
      }
      AppMethodBeat.o(43290);
      return;
      if (paramBundle.getInt("key_entry_scene", -1) == 2) {
        d(paramActivity, "offline", "ui.WalletOfflineEntranceUI");
      } else {
        d(paramActivity, "mall", ".ui.MallIndexUI");
      }
    }
  }
  
  public final String bzC()
  {
    return "OfflineBindCardProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43292);
    boolean bool = super.c(paramActivity, paramBundle);
    AppMethodBeat.o(43292);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c
 * JD-Core Version:    0.7.0.1
 */