package com.tencent.mm.plugin.walletlock.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  implements com.tencent.mm.plugin.walletlock.a.b
{
  protected static int bC(Activity paramActivity)
  {
    AppMethodBeat.i(129888);
    Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[] { paramActivity.getClass().getSimpleName() });
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
  
  public void a(Activity paramActivity, b.b paramb, b.a parama) {}
  
  public boolean a(Activity paramActivity, b.b paramb)
  {
    return false;
  }
  
  public void asE(int paramInt) {}
  
  public void bA(Activity paramActivity) {}
  
  public void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129891);
    Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      new e().c(paramActivity, paramInt1, paramInt2);
      AppMethodBeat.o(129891);
      return;
    }
    if (paramInt1 == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().c(paramActivity, paramInt1, paramInt2);
    }
    AppMethodBeat.o(129891);
  }
  
  public void h(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129893);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUIForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(129893);
  }
  
  public boolean imA()
  {
    return false;
  }
  
  public boolean imB()
  {
    return false;
  }
  
  public b.b imz()
  {
    return null;
  }
  
  public void init()
  {
    AppMethodBeat.i(129889);
    f.WhM.asJ(0);
    AppMethodBeat.o(129889);
  }
  
  public void o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129890);
    Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      new e().o(paramActivity, paramInt);
      AppMethodBeat.o(129890);
      return;
    }
    if (paramInt == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().o(paramActivity, paramInt);
    }
    AppMethodBeat.o(129890);
  }
  
  public void p(Activity paramActivity, int paramInt) {}
  
  public void t(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129892);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.a
 * JD-Core Version:    0.7.0.1
 */