package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.kw;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.p;
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
    return super.a(paramActivity, paramBundle);
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            if ((paramAnonymousm instanceof y))
            {
              if ((((WalletBaseUI)this.gfb).BX != null) && (((WalletBaseUI)this.gfb).BX.getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.bqH()))
              {
                c.g(this.gfb);
                return true;
              }
            }
            else if ((paramAnonymousm instanceof k))
            {
              com.tencent.mm.wallet_core.a.j(this.gfb, ((WalletBaseUI)this.gfb).BX);
              com.tencent.mm.plugin.offline.c.a.H(this.gfb);
              return true;
            }
          }
          return false;
        }
        
        public final boolean m(Object... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = (p)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.flag = "2";
          this.wBd.a(new q(paramAnonymousVarArgs), true, 1);
          return true;
        }
      };
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new c.2(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    super.a(paramActivity, paramInt, paramBundle);
  }
  
  public final String aTh()
  {
    return "OfflineBindCardProcess";
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.mm.sdk.b.a.udP.m(new kw());
    if (com.tencent.mm.plugin.offline.c.a.bqH()) {
      c(paramActivity, WalletOfflineEntranceUI.class);
    }
    for (;;)
    {
      if (paramActivity != null) {
        paramActivity.finish();
      }
      return;
      if (paramBundle.getInt("key_entry_scene", -1) == 2) {
        d(paramActivity, "offline", "ui.WalletOfflineEntranceUI");
      } else {
        d(paramActivity, "mall", ".ui.MallIndexUI");
      }
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return super.c(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c
 * JD-Core Version:    0.7.0.1
 */