package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.g.a.zw.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129757);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129757);
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
      AppMethodBeat.o(129757);
      return;
      if ((paramb == null) || (paramb.aR(paramActivity)))
      {
        paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", aS(paramActivity));
        paramb.setPackage(MMApplicationContext.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().bl(paramb);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129757);
        return;
      }
      Log.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129756);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129756);
      return false;
    }
    if ((paramb != null) && (!paramb.aR(paramActivity)))
    {
      Log.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129756);
      return false;
    }
    paramb = new zw();
    paramb.egz.egB = 0;
    paramb.egz.activity = paramActivity;
    EventCenter.instance.publish(paramb);
    switch (((Integer)paramb.egA.data).intValue())
    {
    default: 
      AppMethodBeat.o(129756);
      return false;
    case 17: 
      paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", aS(paramActivity));
      paramb.setPackage(MMApplicationContext.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().bl(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      h.CyF.a(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129756);
      return true;
    }
    AppMethodBeat.o(129756);
    return false;
  }
  
  public final void aQ(Activity paramActivity)
  {
    AppMethodBeat.i(129760);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129760);
      return;
    }
    if (!b.fUV())
    {
      Log.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(129760);
      return;
    }
    Object localObject = new Intent(paramActivity, GestureGuardLogicUI.class);
    ((Intent)localObject).addFlags(131072);
    ((Intent)localObject).putExtra("action", "action.verify_pattern");
    ((Intent)localObject).putExtra("next_action", "next_action.modify_pattern");
    ((Intent)localObject).setPackage(MMApplicationContext.getPackageName());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129760);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129759);
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(129759);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129759);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    com.tencent.mm.br.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(129759);
  }
  
  public final boolean fUF()
  {
    AppMethodBeat.i(258667);
    boolean bool = b.fUV();
    AppMethodBeat.o(258667);
    return bool;
  }
  
  public final boolean fUG()
  {
    AppMethodBeat.i(129763);
    boolean bool = b.fUW();
    AppMethodBeat.o(129763);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129755);
    Log.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    com.tencent.mm.plugin.walletlock.c.g.yD(true);
    com.tencent.mm.plugin.walletlock.c.g.IwU.afe(1);
    AppMethodBeat.o(129755);
  }
  
  public final void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129758);
    if (paramInt != 1)
    {
      AppMethodBeat.o(129758);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129758);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    com.tencent.mm.br.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(129758);
  }
  
  public final void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129761);
    if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129761);
      return;
    }
    if (!b.fUV())
    {
      Log.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(129761);
      return;
    }
    Object localObject = new Intent(paramActivity, GestureGuardLogicUI.class);
    ((Intent)localObject).addFlags(131072);
    ((Intent)localObject).putExtra("action", "action.verify_pattern");
    ((Intent)localObject).putExtra("next_action", "next_action.switch_off_pattern");
    ((Intent)localObject).setPackage(MMApplicationContext.getPackageName());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.c
 * JD-Core Version:    0.7.0.1
 */