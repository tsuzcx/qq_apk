package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.h.a.tl;
import com.tencent.mm.h.a.tl.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void P(Activity paramActivity) {}
  
  public final void a(Activity paramActivity, b.b paramb)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      return;
    }
    if ((paramb != null) && (!paramb.Q(paramActivity)))
    {
      y.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
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
    paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
    paramb.addFlags(131072);
    paramb.putExtra("action", "action.verify_pattern");
    paramb.putExtra("next_action", "next_action.goto_protected_page");
    paramb.putExtra("page_intent", paramActivity.getIntent());
    paramb.putExtra("scene", R(paramActivity));
    paramb.setPackage(ae.getPackageName());
    paramActivity.startActivity(paramb);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
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
      paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", R(paramActivity));
      paramb.setPackage(ae.getPackageName());
      paramActivity.startActivity(paramb);
      return;
    }
    y.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2) {
      return;
    }
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    y.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.br.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
  }
  
  public final b.b bXL()
  {
    return com.tencent.mm.plugin.walletlock.c.d.bYu();
  }
  
  public final boolean bXM()
  {
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    return com.tencent.mm.plugin.walletlock.c.g.bXQ();
  }
  
  public final boolean bXN()
  {
    return false;
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    com.tencent.mm.br.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
  }
  
  public final void h(Activity paramActivity, int paramInt) {}
  
  public final void init()
  {
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    com.tencent.mm.plugin.walletlock.c.g.bYx();
    com.tencent.mm.plugin.walletlock.c.g.qQZ.Be(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.b
 * JD-Core Version:    0.7.0.1
 */