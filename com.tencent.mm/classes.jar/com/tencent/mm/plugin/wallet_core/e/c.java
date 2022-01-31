package com.tencent.mm.plugin.wallet_core.e;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;

public final class c
{
  public static long qJB = 0L;
  public static int qJC = 2;
  public static int qJD = 1;
  public static int qJE = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    paramActivity = a.aj(paramActivity);
    if ((!o.bVs().bVN()) && (paramActivity != null) && (paramActivity.cMo()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.nFQ.f(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.bUV), Integer.valueOf((int)(paramBundle.nCq * 100.0D)), paramBundle.mOZ });
      }
    }
    while ((o.bVs().bVN()) || (paramBundle == null) || (!paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      return;
    }
    h.nFQ.f(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    if ((!o.bVs().bVN()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.nFQ.f(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.bUV), Integer.valueOf((int)(paramOrders.nCq * 100.0D)), paramOrders.mOZ });
    }
  }
  
  public static void bXt()
  {
    qJB = System.currentTimeMillis();
  }
  
  public static int bXu()
  {
    return (int)((System.currentTimeMillis() - qJB) / 1000L);
  }
  
  public static void ev(int paramInt1, int paramInt2)
  {
    h.nFQ.f(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.c
 * JD-Core Version:    0.7.0.1
 */