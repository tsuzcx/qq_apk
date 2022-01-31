package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vg.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(51464);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51464);
      return;
    }
    if ((paramb != null) && (!paramb.al(paramActivity)))
    {
      ab.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(51464);
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
      AppMethodBeat.o(51464);
      return;
      paramActivity.finish();
      paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", am(paramActivity));
      paramb.setPackage(ah.getPackageName());
      paramActivity.startActivity(paramb);
    }
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(51465);
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51465);
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
      AppMethodBeat.o(51465);
      return;
      if ((paramb == null) || (paramb.al(paramActivity)))
      {
        paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
        paramb.addFlags(131072);
        paramb.putExtra("action", "action.verify_pattern");
        paramb.putExtra("next_action", "next_action.goto_protected_page");
        paramb.putExtra("page_intent", paramActivity.getIntent());
        paramb.putExtra("scene", am(paramActivity));
        paramb.setPackage(ah.getPackageName());
        paramActivity.startActivity(paramb);
        AppMethodBeat.o(51465);
        return;
      }
      ab.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
    }
  }
  
  public final void ak(Activity paramActivity) {}
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51467);
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(51467);
      return;
    }
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51467);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    ab.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.bq.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt2);
    AppMethodBeat.o(51467);
  }
  
  public final b.b cXt()
  {
    AppMethodBeat.i(51468);
    com.tencent.mm.plugin.walletlock.c.d locald = com.tencent.mm.plugin.walletlock.c.d.cYf();
    AppMethodBeat.o(51468);
    return locald;
  }
  
  public final boolean cXu()
  {
    AppMethodBeat.i(51469);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    boolean bool = com.tencent.mm.plugin.walletlock.c.g.cXy();
    AppMethodBeat.o(51469);
    return bool;
  }
  
  public final boolean cXv()
  {
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51463);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    com.tencent.mm.plugin.walletlock.c.g.cYh();
    com.tencent.mm.plugin.walletlock.c.g.uGh.IQ(2);
    AppMethodBeat.o(51463);
  }
  
  public final void j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51466);
    if (paramInt != 2)
    {
      AppMethodBeat.o(51466);
      return;
    }
    if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ab.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(51466);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.verify_paypwd");
    localIntent.putExtra("next_action", "next_action.switch_on_pattern");
    localIntent.putExtra("key_wallet_lock_type", 2);
    com.tencent.mm.bq.d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent);
    AppMethodBeat.o(51466);
  }
  
  public final void k(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.b
 * JD-Core Version:    0.7.0.1
 */