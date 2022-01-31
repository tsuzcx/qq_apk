package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.y;

public class a
  implements com.tencent.mm.plugin.walletlock.a.b
{
  public static int R(Activity paramActivity)
  {
    y.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if (paramActivity.getClass().getSimpleName().equals("MallIndexUI")) {
      return 1;
    }
    if (paramActivity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
      return 2;
    }
    return -1;
  }
  
  public void AZ(int paramInt) {}
  
  public void P(Activity paramActivity) {}
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivity(paramIntent);
  }
  
  public void a(Activity paramActivity, b.b paramb) {}
  
  public void a(Activity paramActivity, b.b paramb, b.a parama) {}
  
  public void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      new c().b(paramActivity, paramInt1, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(paramActivity, paramInt1, paramInt2);
  }
  
  public void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.setClass(paramActivity, WalletLockSettingUI.class);
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public b.b bXL()
  {
    return null;
  }
  
  public boolean bXM()
  {
    return false;
  }
  
  public boolean bXN()
  {
    return false;
  }
  
  public void g(Activity paramActivity, int paramInt)
  {
    y.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      new c().g(paramActivity, paramInt);
    }
    while (paramInt != 2) {
      return;
    }
    new com.tencent.mm.plugin.walletlock.fingerprint.a.b().g(paramActivity, paramInt);
  }
  
  public void h(Activity paramActivity, int paramInt) {}
  
  public void init()
  {
    g.qQZ.Be(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.a
 * JD-Core Version:    0.7.0.1
 */