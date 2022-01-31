package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vg.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(51551);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51551);
      return;
    }
    if ((paramb != null) && (!paramb.al(paramActivity)))
    {
      ab.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(51551);
      return;
    }
    paramb = new vg();
    paramb.cMq.cMs = 0;
    paramb.cMq.activity = paramActivity;
    com.tencent.mm.sdk.b.a.ymk.l(paramb);
    switch (((Integer)paramb.cMr.data).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51551);
      return;
      paramActivity.finish();
      paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", am(paramActivity));
      paramb.setPackage(ah.getPackageName());
      paramActivity.startActivity(paramb);
      h.qsU.e(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(51552);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51552);
      return;
    }
    parama = new vg();
    parama.cMq.cMs = 1;
    parama.cMq.activity = paramActivity;
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    switch (((Integer)parama.cMr.data).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51552);
      return;
      if ((paramb == null) || (paramb.al(paramActivity)))
      {
        paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", am(paramActivity));
        paramb.setPackage(ah.getPackageName());
        paramActivity.startActivity(paramb);
        AppMethodBeat.o(51552);
        return;
      }
      ab.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final void ak(Activity paramActivity)
  {
    AppMethodBeat.i(51555);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51555);
      return;
    }
    if (!b.cXK())
    {
      ab.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(51555);
      return;
    }
    Intent localIntent = new Intent(paramActivity, GestureGuardLogicUI.class);
    localIntent.addFlags(131072);
    localIntent.putExtra("action", "action.verify_pattern");
    localIntent.putExtra("next_action", "next_action.modify_pattern");
    localIntent.setPackage(ah.getPackageName());
    paramActivity.startActivity(localIntent);
    AppMethodBeat.o(51555);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51554);
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(51554);
      return;
    }
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51554);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(51554);
  }
  
  public final boolean cXu()
  {
    AppMethodBeat.i(156803);
    boolean bool = b.cXK();
    AppMethodBeat.o(156803);
    return bool;
  }
  
  public final boolean cXv()
  {
    AppMethodBeat.i(51558);
    boolean bool = b.cXL();
    AppMethodBeat.o(51558);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51550);
    ab.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    com.tencent.mm.plugin.walletlock.c.g.oa(true);
    com.tencent.mm.plugin.walletlock.c.g.uGh.IQ(1);
    AppMethodBeat.o(51550);
  }
  
  public final void j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51553);
    if (paramInt != 1)
    {
      AppMethodBeat.o(51553);
      return;
    }
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51553);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(51553);
  }
  
  public final void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51556);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51556);
      return;
    }
    if (!b.cXK())
    {
      ab.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
      AppMethodBeat.o(51556);
      return;
    }
    Intent localIntent = new Intent(paramActivity, GestureGuardLogicUI.class);
    localIntent.addFlags(131072);
    localIntent.putExtra("action", "action.verify_pattern");
    localIntent.putExtra("next_action", "next_action.switch_off_pattern");
    localIntent.setPackage(ah.getPackageName());
    paramActivity.startActivity(localIntent);
    AppMethodBeat.o(51556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.c
 * JD-Core Version:    0.7.0.1
 */