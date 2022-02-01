package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.a.xr.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129757);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129757);
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
      AppMethodBeat.o(129757);
      return;
      if ((paramb == null) || (paramb.aK(paramActivity)))
      {
        paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", aL(paramActivity));
        paramb.setPackage(ai.getPackageName());
        paramb = new com.tencent.mm.hellhoundlib.b.a().ba(paramb);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.aeD(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramb.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129757);
        return;
      }
      ac.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129756);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129756);
      return false;
    }
    if ((paramb != null) && (!paramb.aK(paramActivity)))
    {
      ac.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129756);
      return false;
    }
    paramb = new xr();
    paramb.dBa.dBc = 0;
    paramb.dBa.activity = paramActivity;
    com.tencent.mm.sdk.b.a.GpY.l(paramb);
    switch (((Integer)paramb.dBb.data).intValue())
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
      paramb.putExtra("scene", aL(paramActivity));
      paramb.setPackage(ai.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().ba(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.aeD(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      h.wUl.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129756);
      return true;
    }
    AppMethodBeat.o(129756);
    return false;
  }
  
  public final void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(129760);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129760);
      return;
    }
    if (!b.evy())
    {
      ac.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(129760);
      return;
    }
    Object localObject = new Intent(paramActivity, GestureGuardLogicUI.class);
    ((Intent)localObject).addFlags(131072);
    ((Intent)localObject).putExtra("action", "action.verify_pattern");
    ((Intent)localObject).putExtra("next_action", "next_action.modify_pattern");
    ((Intent)localObject).setPackage(ai.getPackageName());
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129759);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(129759);
  }
  
  public final boolean evi()
  {
    AppMethodBeat.i(210403);
    boolean bool = b.evy();
    AppMethodBeat.o(210403);
    return bool;
  }
  
  public final boolean evj()
  {
    AppMethodBeat.i(129763);
    boolean bool = b.evz();
    AppMethodBeat.o(129763);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129755);
    ac.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    com.tencent.mm.plugin.walletlock.c.g.tW(true);
    com.tencent.mm.plugin.walletlock.c.g.BVG.TZ(1);
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
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129758);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(129758);
  }
  
  public final void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129761);
    if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ac.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129761);
      return;
    }
    if (!b.evy())
    {
      ac.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(129761);
      return;
    }
    Object localObject = new Intent(paramActivity, GestureGuardLogicUI.class);
    ((Intent)localObject).addFlags(131072);
    ((Intent)localObject).putExtra("action", "action.verify_pattern");
    ((Intent)localObject).putExtra("next_action", "next_action.switch_off_pattern");
    ((Intent)localObject).setPackage(ai.getPackageName());
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.c
 * JD-Core Version:    0.7.0.1
 */