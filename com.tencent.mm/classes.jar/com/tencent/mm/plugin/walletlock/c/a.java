package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.ab;

public class a
  implements com.tencent.mm.plugin.walletlock.a.b
{
  protected static int am(Activity paramActivity)
  {
    AppMethodBeat.i(51682);
    ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if (paramActivity.getClass().getSimpleName().equals("MallIndexUI"))
    {
      AppMethodBeat.o(51682);
      return 1;
    }
    if (paramActivity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI"))
    {
      AppMethodBeat.o(51682);
      return 2;
    }
    AppMethodBeat.o(51682);
    return -1;
  }
  
  public void IL(int paramInt) {}
  
  public void a(Activity paramActivity, b.b paramb) {}
  
  public void a(Activity paramActivity, b.b paramb, b.a parama) {}
  
  public void ak(Activity paramActivity) {}
  
  public void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51685);
    ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      new c().b(paramActivity, paramInt1, paramInt2);
      AppMethodBeat.o(51685);
      return;
    }
    if (paramInt1 == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(paramActivity, paramInt1, paramInt2);
    }
    AppMethodBeat.o(51685);
  }
  
  public void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(51686);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivity(paramIntent);
    AppMethodBeat.o(51686);
  }
  
  public void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(51687);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(51687);
  }
  
  public b.b cXt()
  {
    return null;
  }
  
  public boolean cXu()
  {
    return false;
  }
  
  public boolean cXv()
  {
    return false;
  }
  
  public void init()
  {
    AppMethodBeat.i(51683);
    g.uGh.IQ(0);
    AppMethodBeat.o(51683);
  }
  
  public void j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51684);
    ab.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      new c().j(paramActivity, paramInt);
      AppMethodBeat.o(51684);
      return;
    }
    if (paramInt == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().j(paramActivity, paramInt);
    }
    AppMethodBeat.o(51684);
  }
  
  public void k(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.a
 * JD-Core Version:    0.7.0.1
 */