package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e;
import org.json.JSONObject;

public final class m
{
  public static long VYo = 0L;
  public static int VYp = 2;
  public static int VYq = 1;
  public static int VYr = 2;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(71647);
    paramActivity = a.cm(paramActivity);
    if ((!u.iiC().ijf()) && (paramActivity != null) && (paramActivity.jOh()))
    {
      paramActivity = (PayInfo)paramBundle.getParcelable("key_pay_info");
      paramBundle = (Orders)paramBundle.getParcelable("key_orders");
      if ((paramActivity != null) && (paramBundle != null)) {
        h.OAn.b(10725, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramActivity.hUR), Integer.valueOf((int)(paramBundle.hAW * 100.0D)), paramBundle.MEq });
      }
      AppMethodBeat.o(71647);
      return;
    }
    if ((!u.iiC().ijf()) && (paramBundle != null) && (paramBundle.getBoolean("key_is_bind_reg_process", false))) {
      h.OAn.b(10932, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("key_bind_scene", 0)) });
    }
    AppMethodBeat.o(71647);
  }
  
  public static void a(PayInfo paramPayInfo, Orders paramOrders)
  {
    AppMethodBeat.i(71649);
    if ((!u.iiC().ijf()) && (paramPayInfo != null) && (paramOrders != null)) {
      h.OAn.b(10725, new Object[] { Integer.valueOf(1), Integer.valueOf(paramPayInfo.hUR), Integer.valueOf((int)(paramOrders.hAW * 100.0D)), paramOrders.MEq });
    }
    AppMethodBeat.o(71649);
  }
  
  public static String asD(int paramInt)
  {
    AppMethodBeat.i(301440);
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("EnterScene", paramInt);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(301440);
    }
    return "";
  }
  
  public static void imd()
  {
    AppMethodBeat.i(71645);
    VYo = System.currentTimeMillis();
    AppMethodBeat.o(71645);
  }
  
  public static int ime()
  {
    AppMethodBeat.i(71646);
    int i = (int)((System.currentTimeMillis() - VYo) / 1000L);
    AppMethodBeat.o(71646);
    return i;
  }
  
  public static void mW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71648);
    h.OAn.b(10932, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(71648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.m
 * JD-Core Version:    0.7.0.1
 */