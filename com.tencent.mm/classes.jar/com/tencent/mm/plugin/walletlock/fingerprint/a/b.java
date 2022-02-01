package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.b;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends com.tencent.mm.plugin.walletlock.model.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129670);
    if (!h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129670);
      return;
    }
    parama = new ada();
    parama.igZ.ihb = 1;
    parama.igZ.activity = paramActivity;
    parama.publish();
    switch (((Integer)parama.iha.cpt).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129670);
      return;
      if ((paramb == null) || (paramb.bB(paramActivity)))
      {
        paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", bC(paramActivity));
        paramb.setPackage(MMApplicationContext.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramb.aYi(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129670);
        return;
      }
      Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129669);
    if (!h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129669);
      return false;
    }
    if ((paramb != null) && (!paramb.bB(paramActivity)))
    {
      Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129669);
      return false;
    }
    paramb = new ada();
    paramb.igZ.ihb = 0;
    paramb.igZ.activity = paramActivity;
    paramb.publish();
    switch (((Integer)paramb.iha.cpt).intValue())
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
      paramb.putExtra("scene", bC(paramActivity));
      paramb.setPackage(MMApplicationContext.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramb.aYi(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      AppMethodBeat.o(129669);
      return true;
    }
    AppMethodBeat.o(129669);
    return false;
  }
  
  public final void bA(Activity paramActivity) {}
  
  public final void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129672);
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(129672);
      return;
    }
    if (!h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
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
  
  public final boolean imA()
  {
    AppMethodBeat.i(129674);
    f localf = f.WhM;
    boolean bool = f.imE();
    AppMethodBeat.o(129674);
    return bool;
  }
  
  public final boolean imB()
  {
    return false;
  }
  
  public final b.b imz()
  {
    AppMethodBeat.i(129673);
    com.tencent.mm.plugin.walletlock.model.c localc = com.tencent.mm.plugin.walletlock.model.c.inl();
    AppMethodBeat.o(129673);
    return localc;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129668);
    f localf = f.WhM;
    f.inn();
    f.WhM.asJ(2);
    AppMethodBeat.o(129668);
  }
  
  public final void o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129671);
    if (paramInt != 2)
    {
      AppMethodBeat.o(129671);
      return;
    }
    if (!h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
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
  
  public final void p(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.b
 * JD-Core Version:    0.7.0.1
 */