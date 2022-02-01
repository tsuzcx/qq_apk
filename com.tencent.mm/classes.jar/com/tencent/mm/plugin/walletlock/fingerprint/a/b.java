package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.a.xr.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129670);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129670);
      return;
    }
    parama = new xr();
    parama.dBa.dBc = 1;
    parama.dBa.activity = paramActivity;
    com.tencent.mm.sdk.b.a.GpY.l(parama);
    switch (((Integer)parama.dBb.data).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129670);
      return;
      if ((paramb == null) || (paramb.aK(paramActivity)))
      {
        paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", aL(paramActivity));
        paramb.setPackage(ai.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().ba(paramb);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.aeD(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129670);
        return;
      }
      ac.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129669);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129669);
      return false;
    }
    if ((paramb != null) && (!paramb.aK(paramActivity)))
    {
      ac.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129669);
      return false;
    }
    paramb = new xr();
    paramb.dBa.dBc = 0;
    paramb.dBa.activity = paramActivity;
    com.tencent.mm.sdk.b.a.GpY.l(paramb);
    switch (((Integer)paramb.dBb.data).intValue())
    {
    default: 
      AppMethodBeat.o(129669);
      return false;
    case 17: 
      paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", aL(paramActivity));
      paramb.setPackage(ai.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().ba(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.aeD(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      AppMethodBeat.o(129669);
      return true;
    }
    AppMethodBeat.o(129669);
    return false;
  }
  
  public final void aJ(Activity paramActivity) {}
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129672);
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(129672);
      return;
    }
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129672);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    ac.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.br.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(129672);
  }
  
  public final b.b evh()
  {
    AppMethodBeat.i(129673);
    com.tencent.mm.plugin.walletlock.c.d locald = com.tencent.mm.plugin.walletlock.c.d.evT();
    AppMethodBeat.o(129673);
    return locald;
  }
  
  public final boolean evi()
  {
    AppMethodBeat.i(129674);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    boolean bool = com.tencent.mm.plugin.walletlock.c.g.evm();
    AppMethodBeat.o(129674);
    return bool;
  }
  
  public final boolean evj()
  {
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129668);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    com.tencent.mm.plugin.walletlock.c.g.evV();
    com.tencent.mm.plugin.walletlock.c.g.BVG.TZ(2);
    AppMethodBeat.o(129668);
  }
  
  public final void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129671);
    if (paramInt != 2)
    {
      AppMethodBeat.o(129671);
      return;
    }
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129671);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    com.tencent.mm.br.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(129671);
  }
  
  public final void m(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.b
 * JD-Core Version:    0.7.0.1
 */