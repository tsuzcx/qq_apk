package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c;
import java.util.List;

public class j
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43349);
    Object localObject;
    if (paramBundle != null) {
      if (!bo.isNullOrNil(paramBundle.getString("key_trans_id"))) {
        localObject = "key_trans_id";
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", (String)localObject), 0);
      b(paramActivity, WalletOrderInfoUI.class, paramBundle);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDG, Boolean.TRUE);
      AppMethodBeat.o(43349);
      return this;
      localObject = (Orders)paramBundle.getParcelable("key_orders");
      if ((localObject != null) && (((Orders)localObject).ujl != null) && (((Orders)localObject).ujl.size() > 0)) {
        localObject = ((Orders.Commodity)((Orders)localObject).ujl.get(0)).cnJ;
      } else {
        localObject = "";
      }
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(43350);
    if ((paramActivity instanceof WalletOrderInfoUI))
    {
      B(paramActivity);
      b(paramActivity, null);
    }
    AppMethodBeat.o(43350);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43352);
    aO(paramActivity);
    if (this.mEJ.getInt("key_from_scene") == 8) {
      a.WC(this.mEJ.getString("key_appid"));
    }
    AppMethodBeat.o(43352);
  }
  
  public final String bzC()
  {
    return "ShowOrderSuccessProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43351);
    B(paramActivity);
    AppMethodBeat.o(43351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.j
 * JD-Core Version:    0.7.0.1
 */