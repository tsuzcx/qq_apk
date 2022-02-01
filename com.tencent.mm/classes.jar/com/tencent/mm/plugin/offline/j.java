package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
      if (!bu.isNullOrNil(paramBundle.getString("key_trans_id"))) {
        localObject = "key_trans_id";
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", (String)localObject), 0);
      b(paramActivity, WalletOrderInfoUI.class, paramBundle);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQJ, Boolean.TRUE);
      AppMethodBeat.o(66251);
      return this;
      localObject = (Orders)paramBundle.getParcelable("key_orders");
      if ((localObject != null) && (((Orders)localObject).DpP != null) && (((Orders)localObject).DpP.size() > 0)) {
        localObject = ((Orders.Commodity)((Orders)localObject).DpP.get(0)).dmx;
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
      R(paramActivity);
      b(paramActivity, null);
    }
    AppMethodBeat.o(66252);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66254);
    bu(paramActivity);
    if (this.dyY.getInt("key_from_scene") == 8) {
      a.avj(this.dyY.getString("key_appid"));
    }
    AppMethodBeat.o(66254);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cSH()
  {
    return "ShowOrderSuccessProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66253);
    R(paramActivity);
    AppMethodBeat.o(66253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.j
 * JD-Core Version:    0.7.0.1
 */