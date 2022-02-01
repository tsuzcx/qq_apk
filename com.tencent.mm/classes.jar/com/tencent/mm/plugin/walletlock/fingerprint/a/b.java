package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.g.a.zw.b;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129670);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129670);
      return;
    }
    parama = new zw();
    parama.egz.egB = 1;
    parama.egz.activity = paramActivity;
    EventCenter.instance.publish(parama);
    switch (((Integer)parama.egA.data).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129670);
      return;
      if ((paramb == null) || (paramb.aR(paramActivity)))
      {
        paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", aS(paramActivity));
        paramb.setPackage(MMApplicationContext.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().bl(paramb);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129670);
        return;
      }
      Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129669);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129669);
      return false;
    }
    if ((paramb != null) && (!paramb.aR(paramActivity)))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129669);
      return false;
    }
    paramb = new zw();
    paramb.egz.egB = 0;
    paramb.egz.activity = paramActivity;
    EventCenter.instance.publish(paramb);
    switch (((Integer)paramb.egA.data).intValue())
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
      paramb.putExtra("scene", aS(paramActivity));
      paramb.setPackage(MMApplicationContext.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().bl(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      AppMethodBeat.o(129669);
      return true;
    }
    AppMethodBeat.o(129669);
    return false;
  }
  
  public final void aQ(Activity paramActivity) {}
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129672);
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(129672);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129672);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    Log.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.br.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(129672);
  }
  
  public final b.b fUE()
  {
    AppMethodBeat.i(129673);
    d locald = d.fVq();
    AppMethodBeat.o(129673);
    return locald;
  }
  
  public final boolean fUF()
  {
    AppMethodBeat.i(129674);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    boolean bool = com.tencent.mm.plugin.walletlock.c.g.fUJ();
    AppMethodBeat.o(129674);
    return bool;
  }
  
  public final boolean fUG()
  {
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129668);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    com.tencent.mm.plugin.walletlock.c.g.fVs();
    com.tencent.mm.plugin.walletlock.c.g.IwU.afe(2);
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
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129671);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    com.tencent.mm.br.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(129671);
  }
  
  public final void m(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.b
 * JD-Core Version:    0.7.0.1
 */