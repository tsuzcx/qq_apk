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
  public static long Dob = 0L;
  public static int Doc = 2;
  public static int Dod = 1;
  public static int Doe = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.br(paramActivity);
    if ((!t.eFy().eGa()) && (paramActivity != null) && (paramActivity.fQR()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        g.yhR.f(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.dCC), Integer.valueOf((int)(paramBundle.dlx * 100.0D)), paramBundle.wCF });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!t.eFy().eGa()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      g.yhR.f(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!t.eFy().eGa()) && (paramPayInfo != null) && (paramOrders != null)) {
      g.yhR.f(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.dCC), Integer.valueOf((int)(paramOrders.dlx * 100.0D)), paramOrders.wCF });
    }
    AppMethodBeat.o(71649);
  }
  
  public static void eIT()
  {
    AppMethodBeat.i(71645);
    Dob = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int eIU()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - Dob) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    g.yhR.f(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */