package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(66202);
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(66197);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            if ((paramAnonymousn instanceof ad))
            {
              if ((((WalletBaseUI)this.activity).getInput() != null) && (((WalletBaseUI)this.activity).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.dmQ()))
              {
                d.k(this.activity);
                AppMethodBeat.o(66197);
                return true;
              }
            }
            else if ((paramAnonymousn instanceof k))
            {
              com.tencent.mm.wallet_core.a.k(this.activity, ((WalletBaseUI)this.activity).getInput());
              com.tencent.mm.plugin.offline.c.a.ay(this.activity);
              AppMethodBeat.o(66197);
              return true;
            }
          }
          AppMethodBeat.o(66197);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66196);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.flag = "1";
          this.JFQ.a(new v(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(66196);
          return true;
        }
      };
      AppMethodBeat.o(66202);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(66199);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof ad))
            {
              if ((((WalletBaseUI)this.activity).getInput() != null) && (((WalletBaseUI)this.activity).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.dmQ())) {
                d.k(this.activity);
              }
              AppMethodBeat.o(66199);
              return true;
            }
            if ((paramAnonymousn instanceof k))
            {
              paramAnonymousString = ((WalletBaseUI)this.activity).getInput();
              paramAnonymousString.putBoolean("intent_bind_end", true);
              com.tencent.mm.wallet_core.a.k(this.activity, paramAnonymousString);
              com.tencent.mm.plugin.offline.c.a.ay(this.activity);
              AppMethodBeat.o(66199);
              return true;
            }
          }
          AppMethodBeat.o(66199);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66198);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
          this.JFQ.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(66198);
          return true;
        }
      };
      AppMethodBeat.o(66202);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(66202);
    return paramMMActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66200);
    com.tencent.mm.sdk.b.a.GpY.l(new nd());
    c(paramActivity, WalletOfflineEntranceUI.class);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(66200);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66203);
    boolean bool = super.c(paramActivity, paramBundle);
    AppMethodBeat.o(66203);
    return bool;
  }
  
  public final String cHN()
  {
    return "OfflineBindCardRegProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66201);
    super.g(paramActivity, paramInt);
    AppMethodBeat.o(66201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.d
 * JD-Core Version:    0.7.0.1
 */