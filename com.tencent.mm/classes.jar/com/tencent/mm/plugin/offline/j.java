package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.d;
import java.util.List;

public class j
  extends d
{
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66251);
    Object localObject;
    if (paramBundle != null) {
      if (!bt.isNullOrNil(paramBundle.getString("key_trans_id"))) {
        localObject = "key_trans_id";
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", (String)localObject), 0);
      b(paramActivity, WalletOrderInfoUI.class, paramBundle);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwl, Boolean.TRUE);
      AppMethodBeat.o(66251);
      return this;
      localObject = (Orders)paramBundle.getParcelable("key_orders");
      if ((localObject != null) && (((Orders)localObject).CYk != null) && (((Orders)localObject).CYk.size() > 0)) {
        localObject = ((Orders.Commodity)((Orders)localObject).CYk.get(0)).dlv;
      } else {
        localObject = "";
      }
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66252);
    if ((paramActivity instanceof WalletOrderInfoUI))
    {
      Q(paramActivity);
      b(paramActivity, null);
    }
    AppMethodBeat.o(66252);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66254);
    bt(paramActivity);
    if (this.dxT.getInt("key_from_scene") == 8) {
      a.atU(this.dxT.getString("key_appid"));
    }
    AppMethodBeat.o(66254);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cQc()
  {
    return "ShowOrderSuccessProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66253);
    Q(paramActivity);
    AppMethodBeat.o(66253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.j
 * JD-Core Version:    0.7.0.1
 */