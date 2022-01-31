package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h
  extends c
{
  public final void E(Activity paramActivity)
  {
    int i = 2;
    int j;
    if (paramActivity != null)
    {
      j = this.kke.getInt("offline_from_scene", -1);
      if (j != 1) {
        break label86;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14096, new Object[] { Integer.valueOf(i) });
      Intent localIntent = new Intent(paramActivity, WalletOfflineEntranceUI.class);
      localIntent.putExtra("key_from_scene", j);
      localIntent.putExtra("is_offline_create", true);
      a(paramActivity, WalletOfflineEntranceUI.class, localIntent);
      paramActivity.finish();
      return;
      label86:
      if (j == 2) {
        i = 1;
      } else if (j == 3) {
        i = 3;
      } else if (j == 4) {
        i = 6;
      } else if (j == 8) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new h.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      E(paramActivity);
    }
  }
  
  public final String aTh()
  {
    return "OfflineProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.finish();
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    E(paramActivity);
    if ((paramBundle != null) && (paramBundle.getBoolean("is_offline_create"))) {
      a.H((WalletBaseUI)paramActivity);
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h
 * JD-Core Version:    0.7.0.1
 */