package com.tencent.mm.plugin.walletlock.b;

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
import com.tencent.mm.plugin.walletlock.model.c;
import com.tencent.mm.plugin.walletlock.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends com.tencent.mm.plugin.walletlock.model.a
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
    if (!h.baA().aw(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      Log.d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
      AppMethodBeat.o(129651);
      return false;
    }
    if ((paramb != null) && (!paramb.bB(paramActivity)))
    {
      Log.d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
      AppMethodBeat.o(129651);
      return false;
    }
    paramb = new ada();
    paramb.igZ.ihb = 0;
    paramb.igZ.activity = paramActivity;
    paramb.publish();
    switch (((Integer)paramb.iha.cpt).intValue())
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
      paramb.putExtra("scene", bC(paramActivity));
      paramb.setPackage(MMApplicationContext.getPackageName());
      paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramb.aYi(), "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramb.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.finish();
      AppMethodBeat.o(129651);
      return true;
    }
    AppMethodBeat.o(129651);
    return false;
  }
  
  public final void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129653);
    super.c(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(129653);
  }
  
  public final boolean imA()
  {
    AppMethodBeat.i(129655);
    f localf = f.WhM;
    boolean bool = f.imF();
    AppMethodBeat.o(129655);
    return bool;
  }
  
  public final b.b imz()
  {
    AppMethodBeat.i(129654);
    c localc = c.inl();
    AppMethodBeat.o(129654);
    return localc;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129650);
    f localf = f.WhM;
    f.ino();
    f.WhM.asJ(3);
    AppMethodBeat.o(129650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.b.a
 * JD-Core Version:    0.7.0.1
 */