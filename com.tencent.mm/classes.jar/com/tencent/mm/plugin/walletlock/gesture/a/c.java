package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.tl;
import com.tencent.mm.h.a.tl.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void P(Activity paramActivity)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    if (!b.bYc())
    {
      y.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
      return;
    }
    Intent localIntent = new Intent(paramActivity, GestureGuardLogicUI.class);
    localIntent.addFlags(131072);
    localIntent.putExtra("action", "action.verify_pattern");
    localIntent.putExtra("next_action", "next_action.modify_pattern");
    localIntent.setPackage(ae.getPackageName());
    paramActivity.startActivity(localIntent);
  }
  
  public final void a(Activity paramActivity, b.b paramb)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    if ((paramb != null) && (!paramb.Q(paramActivity)))
    {
      y.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      return;
    }
    paramb = new tl();
    paramb.cdG.cdI = 0;
    paramb.cdG.activity = paramActivity;
    com.tencent.mm.sdk.b.a.udP.m(paramb);
    switch (((Integer)paramb.cdH.data).intValue())
    {
    default: 
      return;
    }
    paramActivity.finish();
    paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
    paramb.addFlags(131072);
    paramb.putExtra("action", "action.verify_pattern");
    paramb.putExtra("next_action", "next_action.goto_protected_page");
    paramb.putExtra("page_intent", paramActivity.getIntent());
    paramb.putExtra("scene", R(paramActivity));
    paramb.setPackage(ae.getPackageName());
    paramActivity.startActivity(paramb);
    h.nFQ.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    parama = new tl();
    parama.cdG.cdI = 1;
    parama.cdG.activity = paramActivity;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    switch (((Integer)parama.cdH.data).intValue())
    {
    default: 
      return;
    }
    if ((paramb == null) || (paramb.Q(paramActivity)))
    {
      paramb = new Intent(paramActivity, GestureGuardLogicUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", R(paramActivity));
      paramb.setPackage(ae.getPackageName());
      paramActivity.startActivity(paramb);
      return;
    }
    y.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1) {
      return;
    }
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
  }
  
  public final boolean bXM()
  {
    return b.bYc();
  }
  
  public final boolean bXN()
  {
    return b.bYd();
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 1);
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
      return;
    }
    if (!b.bYc())
    {
      y.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
      return;
    }
    Intent localIntent = new Intent(paramActivity, GestureGuardLogicUI.class);
    localIntent.addFlags(131072);
    localIntent.putExtra("action", "action.verify_pattern");
    localIntent.putExtra("next_action", "next_action.switch_off_pattern");
    localIntent.setPackage(ae.getPackageName());
    paramActivity.startActivity(localIntent);
  }
  
  public final void init()
  {
    y.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    com.tencent.mm.plugin.walletlock.c.g.kR(true);
    com.tencent.mm.plugin.walletlock.c.g.qQZ.Be(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.c
 * JD-Core Version:    0.7.0.1
 */