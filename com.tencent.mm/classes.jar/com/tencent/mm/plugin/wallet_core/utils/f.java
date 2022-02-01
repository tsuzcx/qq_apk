package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public final class f
{
  public static long BNJ = 0L;
  public static int BNK = 2;
  public static int BNL = 1;
  public static int BNM = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.br(paramActivity);
    if ((!s.ery().esa()) && (paramActivity != null) && (paramActivity.fzH()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.wUl.f(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.dqL), Integer.valueOf((int)(paramBundle.daf * 100.0D)), paramBundle.vxl });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!s.ery().esa()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      h.wUl.f(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!s.ery().esa()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.wUl.f(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.dqL), Integer.valueOf((int)(paramOrders.daf * 100.0D)), paramOrders.vxl });
    }
    AppMethodBeat.o(71649);
  }
  
  public static void euN()
  {
    AppMethodBeat.i(71645);
    BNJ = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int euO()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - BNJ) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    h.wUl.f(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */