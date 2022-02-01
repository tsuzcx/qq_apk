package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.a.i;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.e;
import java.util.List;

public class j
  extends e
{
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66251);
    Object localObject;
    if (paramBundle != null) {
      if (!Util.isNullOrNil(paramBundle.getString("key_trans_id"))) {
        localObject = "key_trans_id";
      }
    }
    for (;;)
    {
      h.baF();
      h.baD().mCm.a(new i("offlineshowpage", "push", (String)localObject), 0);
      b(paramActivity, WalletOrderInfoUI.class, paramBundle);
      h.baF();
      h.baE().ban().set(at.a.acOf, Boolean.TRUE);
      AppMethodBeat.o(66251);
      return this;
      localObject = (Orders)paramBundle.getParcelable("key_orders");
      if ((localObject != null) && (((Orders)localObject).VGX != null) && (((Orders)localObject).VGX.size() > 0)) {
        localObject = ((Orders.Commodity)((Orders)localObject).VGX.get(0)).hAU;
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
      Z(paramActivity);
      b(paramActivity, null);
    }
    AppMethodBeat.o(66252);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66254);
    co(paramActivity);
    if (this.hPH.getInt("key_from_scene") == 8) {
      d.aQW(this.hPH.getString("key_appid"));
    }
    AppMethodBeat.o(66254);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "ShowOrderSuccessProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66253);
    Z(paramActivity);
    AppMethodBeat.o(66253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.j
 * JD-Core Version:    0.7.0.1
 */