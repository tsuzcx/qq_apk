package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public final class f
{
  public static long IoT = 0L;
  public static int IoU = 2;
  public static int IoV = 1;
  public static int IoW = 2;
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!t.fQI().fRk()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.CyF.a(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.dVv), Integer.valueOf((int)(paramOrders.dDO * 100.0D)), paramOrders.AOl });
    }
    AppMethodBeat.o(71649);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.by(paramActivity);
    if ((!t.fQI().fRk()) && (paramActivity != null) && (paramActivity.hgK()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.CyF.a(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.dVv), Integer.valueOf((int)(paramBundle.dDO * 100.0D)), paramBundle.AOl });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!t.fQI().fRk()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      h.CyF.a(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void fUi()
  {
    AppMethodBeat.i(71645);
    IoT = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int fUj()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - IoT) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    h.CyF.a(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */