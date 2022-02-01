package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;

public class a
  extends b
{
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71704);
    P(new Object[] { "start", paramActivity, paramBundle });
    Log.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      ac.pu(6, paramBundle.getInt("key_bind_scene"));
      aa.aGq(paramBundle.getInt("key_bind_scene"));
      if (!u.iiC().ijf()) {
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
      AppMethodBeat.o(71704);
      return this;
      ac.pu(6, 0);
      aa.aGq(0);
      break;
      label108:
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    }
    label119:
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(71704);
    return paramActivity;
    label133:
    if (paramBundle != null) {
      m.mW(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      AppMethodBeat.o(71704);
      return this;
    }
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(71704);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71705);
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
      AppMethodBeat.o(71705);
      return;
    }
    a(paramActivity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
    paramActivity.finish();
    AppMethodBeat.o(71705);
  }
  
  public final String fud()
  {
    return "OpenECardBindCardProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.a
 * JD-Core Version:    0.7.0.1
 */