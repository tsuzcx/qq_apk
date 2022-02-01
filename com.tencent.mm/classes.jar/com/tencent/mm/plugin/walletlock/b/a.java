package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129652);
    super.a(paramActivity, paramb, parama);
    AppMethodBeat.o(129652);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129651);
    if (!com.tencent.mm.kernel.g.afx().aa(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      ad.d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129651);
      return false;
    }
    if ((paramb != null) && (!paramb.aG(paramActivity)))
    {
      ad.d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129651);
      return false;
    }
    paramb = new xg();
    paramb.dDo.dDq = 0;
    paramb.dDo.activity = paramActivity;
    com.tencent.mm.sdk.b.a.ESL.l(paramb);
    switch (((Integer)paramb.dDp.data).intValue())
    {
    default: 
      AppMethodBeat.o(129651);
      return false;
    case 17: 
      paramb = new Intent(paramActivity, FingerprintWalletLockUI.class);
      paramb.addFlags(131072);
      paramb.putExtra("action", "action.verify_pattern");
      paramb.putExtra("next_action", "next_action.goto_protected_page");
      paramb.putExtra("page_intent", paramActivity.getIntent());
      paramb.putExtra("scene", aH(paramActivity));
      paramb.setPackage(aj.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().bd(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramb.adn(), "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      AppMethodBeat.o(129651);
      return true;
    }
    AppMethodBeat.o(129651);
    return false;
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129653);
    super.b(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(129653);
  }
  
  public final b.b efN()
  {
    AppMethodBeat.i(129654);
    d locald = d.egz();
    AppMethodBeat.o(129654);
    return locald;
  }
  
  public final boolean efO()
  {
    AppMethodBeat.i(129655);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
    boolean bool = com.tencent.mm.plugin.walletlock.c.g.efT();
    AppMethodBeat.o(129655);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129650);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
    com.tencent.mm.plugin.walletlock.c.g.egC();
    com.tencent.mm.plugin.walletlock.c.g.ADl.RP(3);
    AppMethodBeat.o(129650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.b.a
 * JD-Core Version:    0.7.0.1
 */