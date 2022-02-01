package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.ad;

public class a
  implements com.tencent.mm.plugin.walletlock.a.b
{
  protected static int aL(Activity paramActivity)
  {
    AppMethodBeat.i(129888);
    ad.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if ((paramActivity.getClass().getSimpleName().equals("MallIndexUI")) || (paramActivity.getClass().getSimpleName().equals("MallIndexUIv2")))
    {
      AppMethodBeat.o(129888);
      return 1;
    }
    if (paramActivity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI"))
    {
      AppMethodBeat.o(129888);
      return 2;
    }
    AppMethodBeat.o(129888);
    return -1;
  }
  
  public void VM(int paramInt) {}
  
  public void a(Activity paramActivity, b.b paramb, b.a parama) {}
  
  public boolean a(Activity paramActivity, b.b paramb)
  {
    return false;
  }
  
  public void aJ(Activity paramActivity) {}
  
  public void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129891);
    ad.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      new c().b(paramActivity, paramInt1, paramInt2);
      AppMethodBeat.o(129891);
      return;
    }
    if (paramInt1 == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(paramActivity, paramInt1, paramInt2);
    }
    AppMethodBeat.o(129891);
  }
  
  public void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129893);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(129893);
  }
  
  public void e(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129892);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.ahp(), "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129892);
  }
  
  public b.b eJn()
  {
    return null;
  }
  
  public boolean eJo()
  {
    return false;
  }
  
  public boolean eJp()
  {
    return false;
  }
  
  public void init()
  {
    AppMethodBeat.i(129889);
    g.Dwa.VR(0);
    AppMethodBeat.o(129889);
  }
  
  public void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129890);
    ad.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      new c().l(paramActivity, paramInt);
      AppMethodBeat.o(129890);
      return;
    }
    if (paramInt == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().l(paramActivity, paramInt);
    }
    AppMethodBeat.o(129890);
  }
  
  public void m(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.a
 * JD-Core Version:    0.7.0.1
 */