package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public final class j
{
  public static long PhA = 0L;
  public static int PhB = 2;
  public static int PhC = 1;
  public static int PhD = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.bF(paramActivity);
    if ((!u.gJo().gJQ()) && (paramActivity != null) && (paramActivity.iim()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.IzE.a(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.fOY), Integer.valueOf((int)(paramBundle.fwy * 100.0D)), paramBundle.GHz });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!u.gJo().gJQ()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      h.IzE.a(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!u.gJo().gJQ()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.IzE.a(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.fOY), Integer.valueOf((int)(paramOrders.fwy * 100.0D)), paramOrders.GHz });
    }
    AppMethodBeat.o(71649);
  }
  
  public static void gMO()
  {
    AppMethodBeat.i(71645);
    PhA = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int gMP()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - PhA) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void ll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    h.IzE.a(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.j
 * JD-Core Version:    0.7.0.1
 */