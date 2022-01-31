package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.h.a.tl;
import com.tencent.mm.h.a.tl.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.walletlock.c.a
{
  public final void a(Activity paramActivity, b.b paramb)
  {
    if (!com.tencent.mm.kernel.g.DL().q(com.tencent.mm.plugin.walletlock.a.a.class))
    {
      y.d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
      return;
    }
    if ((paramb != null) && (!paramb.Q(paramActivity)))
    {
      y.d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
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
    super.a(paramActivity, paramb, parama);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super.b(paramActivity, paramInt1, paramInt2);
  }
  
  public final b.b bXL()
  {
    return d.bYu();
  }
  
  public final boolean bXM()
  {
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    return com.tencent.mm.plugin.walletlock.c.g.bXR();
  }
  
  public final void init()
  {
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    com.tencent.mm.plugin.walletlock.c.g.bYy();
    com.tencent.mm.plugin.walletlock.c.g.qQZ.Be(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.b.a
 * JD-Core Version:    0.7.0.1
 */