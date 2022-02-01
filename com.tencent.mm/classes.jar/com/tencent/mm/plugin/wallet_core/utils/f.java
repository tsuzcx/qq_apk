package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public final class f
{
  public static long DFH = 0L;
  public static int DFI = 2;
  public static int DFJ = 1;
  public static int DFK = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.bs(paramActivity);
    if ((!t.eJf().eJH()) && (paramActivity != null) && (paramActivity.fVn()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        g.yxI.f(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.dDH), Integer.valueOf((int)(paramBundle.dmz * 100.0D)), paramBundle.wSq });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!t.eJf().eJH()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      g.yxI.f(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!t.eJf().eJH()) && (paramPayInfo != null) && (paramOrders != null)) {
      g.yxI.f(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.dDH), Integer.valueOf((int)(paramOrders.dmz * 100.0D)), paramOrders.wSq });
    }
    AppMethodBeat.o(71649);
  }
  
  public static void eMB()
  {
    AppMethodBeat.i(71645);
    DFH = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int eMC()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - DFH) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void iP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    g.yxI.f(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */