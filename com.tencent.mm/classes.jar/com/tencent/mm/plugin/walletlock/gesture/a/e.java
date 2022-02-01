package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.b;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.plugin.walletlock.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
  extends com.tencent.mm.plugin.walletlock.model.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129757);
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129757);
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
      AppMethodBeat.o(129757);
      return;
      if ((paramb == null) || (paramb.bB(paramActivity)))
      {
        paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", bC(paramActivity));
        paramb.setPackage(MMApplicationContext.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramb.aYi(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129757);
        return;
      }
      Log.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129756);
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129756);
      return false;
    }
    if ((paramb != null) && (!paramb.bB(paramActivity)))
    {
      Log.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129756);
      return false;
    }
    paramb = new ada();
    paramb.igZ.ihb = 0;
    paramb.igZ.activity = paramActivity;
    paramb.publish();
    switch (((Integer)paramb.iha.cpt).intValue())
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
      paramb.putExtra("scene", bC(paramActivity));
      paramb.setPackage(MMApplicationContext.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramb.aYi(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      com.tencent.mm.plugin.report.service.h.OAn.b(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129756);
      return true;
    }
    AppMethodBeat.o(129756);
    return false;
  }
  
  public final void bA(Activity paramActivity)
  {
    AppMethodBeat.i(129760);
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129760);
      return;
    }
    if (!d.imQ())
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129760);
  }
  
  public final void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129759);
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(129759);
      return;
    }
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129759);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(129759);
  }
  
  public final boolean imA()
  {
    AppMethodBeat.i(369739);
    boolean bool = d.imQ();
    AppMethodBeat.o(369739);
    return bool;
  }
  
  public final boolean imB()
  {
    AppMethodBeat.i(129763);
    boolean bool = d.imR();
    AppMethodBeat.o(129763);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129755);
    Log.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
    f localf = f.WhM;
    f.Id(true);
    f.WhM.asJ(1);
    AppMethodBeat.o(129755);
  }
  
  public final void o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129758);
    if (paramInt != 1)
    {
      AppMethodBeat.o(129758);
      return;
    }
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129758);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(129758);
  }
  
  public final void p(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129761);
    if (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129761);
      return;
    }
    if (!d.imQ())
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.e
 * JD-Core Version:    0.7.0.1
 */