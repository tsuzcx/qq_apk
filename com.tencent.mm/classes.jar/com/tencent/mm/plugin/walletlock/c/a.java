package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  implements com.tencent.mm.plugin.walletlock.a.b
{
  protected static int aX(Activity paramActivity)
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
  
  public void aV(Activity paramActivity) {}
  
  public void amN(int paramInt) {}
  
  public void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129891);
    Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  public void e(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129893);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(129893);
  }
  
  public b.b gNk()
  {
    return null;
  }
  
  public boolean gNl()
  {
    return false;
  }
  
  public boolean gNm()
  {
    return false;
  }
  
  public void init()
  {
    AppMethodBeat.i(129889);
    g.PqZ.amS(0);
    AppMethodBeat.o(129889);
  }
  
  public void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129890);
    Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      new c().m(paramActivity, paramInt);
      AppMethodBeat.o(129890);
      return;
    }
    if (paramInt == 2) {
      new com.tencent.mm.plugin.walletlock.fingerprint.a.b().m(paramActivity, paramInt);
    }
    AppMethodBeat.o(129890);
  }
  
  public void n(Activity paramActivity, int paramInt) {}
  
  public void n(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129892);
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(129892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.a
 * JD-Core Version:    0.7.0.1
 */