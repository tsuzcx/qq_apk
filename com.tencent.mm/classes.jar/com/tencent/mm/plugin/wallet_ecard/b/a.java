package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.c.w;

public class a
  extends b
{
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "start", paramActivity, paramBundle });
    y.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      w.fT(6, paramBundle.getInt("key_bind_scene"));
      v.IX(paramBundle.getInt("key_bind_scene"));
    }
    while (o.bVs().bVN()) {
      if (paramBundle != null)
      {
        if (paramBundle.getBoolean("key_is_import_bind", false))
        {
          b(paramActivity, WalletCardImportUI.class, paramBundle);
          return this;
          w.fT(6, 0);
          v.IX(0);
        }
        else
        {
          b(paramActivity, WalletBankcardIdUI.class, paramBundle);
          return this;
        }
      }
      else {
        return super.a(paramActivity, paramBundle);
      }
    }
    if (paramBundle != null) {
      com.tencent.mm.plugin.wallet_core.e.c.ev(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      return this;
    }
    return super.a(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "OpenECardBindCardProcess";
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
      return;
    }
    a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.a
 * JD-Core Version:    0.7.0.1
 */