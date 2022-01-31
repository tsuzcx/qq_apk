package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;

public class a
  extends b
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48071);
    G(new Object[] { "start", paramActivity, paramBundle });
    ab.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      z.id(6, paramBundle.getInt("key_bind_scene"));
      x.RT(paramBundle.getInt("key_bind_scene"));
      if (!t.cTN().cUl()) {
        break label133;
      }
      if (paramBundle == null) {
        break label119;
      }
      if (!paramBundle.getBoolean("key_is_import_bind", false)) {
        break label108;
      }
      b(paramActivity, WalletCardImportUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(48071);
      return this;
      z.id(6, 0);
      x.RT(0);
      break;
      label108:
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    }
    label119:
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(48071);
    return paramActivity;
    label133:
    if (paramBundle != null) {
      d.gz(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      AppMethodBeat.o(48071);
      return this;
    }
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(48071);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48072);
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
      AppMethodBeat.o(48072);
      return;
    }
    a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
    paramActivity.finish();
    AppMethodBeat.o(48072);
  }
  
  public final String bzC()
  {
    return "OpenECardBindCardProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.a
 * JD-Core Version:    0.7.0.1
 */