package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

public final class d
{
  public static long uyj = 0L;
  public static int uyk = 2;
  public static int uyl = 1;
  public static int uym = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(48012);
    paramActivity = a.aM(paramActivity);
    if ((!t.cTN().cUl()) && (paramActivity != null) && (paramActivity.dRQ()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.qsU.e(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.cCD), Integer.valueOf((int)(paramBundle.cnL * 100.0D)), paramBundle.ppp });
      }
      AppMethodBeat.o(48012);
      return;
    }
    if ((!t.cTN().cUl()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      h.qsU.e(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(48012);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(48014);
    if ((!t.cTN().cUl()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.qsU.e(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.cCD), Integer.valueOf((int)(paramOrders.cnL * 100.0D)), paramOrders.ppp });
    }
    AppMethodBeat.o(48014);
  }
  
  public static void cWY()
  {
    AppMethodBeat.i(48010);
    uyj = System.currentTimeMillis();
    AppMethodBeat.o(48010);
  }
  
  public static int cWZ()
  {
    AppMethodBeat.i(48011);
    int i = (int)((System.currentTimeMillis() - uyj) / 1000L);
    AppMethodBeat.o(48011);
    return i;
  }
  
  public static void gz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48013);
    h.qsU.e(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(48013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.d
 * JD-Core Version:    0.7.0.1
 */