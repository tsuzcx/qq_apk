package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c;
import java.util.List;

public class j
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null) {
      if (!bk.bl(paramBundle.getString("key_trans_id"))) {
        localObject = "key_trans_id";
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", (String)localObject), 0);
      b(paramActivity, WalletOrderInfoUI.class, paramBundle);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.utD, Boolean.valueOf(true));
      return this;
      localObject = (Orders)paramBundle.getParcelable("key_orders");
      if ((localObject != null) && (((Orders)localObject).qwN != null) && (((Orders)localObject).qwN.size() > 0)) {
        localObject = ((Orders.Commodity)((Orders)localObject).qwN.get(0)).bMY;
      } else {
        localObject = "";
      }
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletOrderInfoUI))
    {
      E(paramActivity);
      b(paramActivity, null);
    }
  }
  
  public final String aTh()
  {
    return "ShowOrderSuccessProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    ak(paramActivity);
    if (this.kke.getInt("key_from_scene") == 8) {
      a.KA(this.kke.getString("key_appid"));
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.j
 * JD-Core Version:    0.7.0.1
 */