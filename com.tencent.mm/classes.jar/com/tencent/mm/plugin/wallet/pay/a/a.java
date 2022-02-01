package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static com.tencent.mm.plugin.wallet.pay.a.a.b a(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69249);
    if ((paramAuthen == null) || (paramOrders == null))
    {
      Log.i("MicroMsg.CgiManager", "empty authen or orders");
      AppMethodBeat.o(69249);
      return null;
    }
    PayInfo localPayInfo = paramAuthen.HzF;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.fwv;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        Log.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.fwv;
      }
    }
    if (Util.isNullOrNil(str2))
    {
      Log.i("MicroMsg.CgiManager", "empty reqKey!");
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.b(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    Log.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[] { str2 });
    if ((localPayInfo != null) && (paramOrders != null)) {
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.fwv, paramOrders.fwv });
    }
    Log.i("MicroMsg.CgiManager", "authen go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.a(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.m(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.e(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("ts_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.g(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("sns_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.j(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("offline_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.h(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("up_"))
    {
      paramAuthen = new n(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.i(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("tax_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.l(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    if (str2.startsWith("dc_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.d(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.b(paramAuthen, paramOrders, paramBoolean);
    AppMethodBeat.o(69249);
    return paramAuthen;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.g a(w paramw, Orders paramOrders)
  {
    AppMethodBeat.i(69250);
    if ((paramw == null) || (paramOrders == null))
    {
      Log.e("MicroMsg.CgiManager", "empty verify or orders");
      AppMethodBeat.o(69250);
      return null;
    }
    PayInfo localPayInfo = paramw.HzF;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.fwv;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.fwv;
    }
    if (Util.isNullOrNil(str2))
    {
      Log.i("MicroMsg.CgiManager", "empty reqKey!");
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (localPayInfo != null) {
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.fwv, paramOrders.fwv });
    }
    Log.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    Log.i("MicroMsg.CgiManager", "verify go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.a(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.l(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.d(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("ts_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.f(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("sns_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.j(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("up_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.m(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.h(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("tax_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.k(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (str2.startsWith("dc_"))
    {
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.c(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    paramw = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramw, paramOrders);
    AppMethodBeat.o(69250);
    return paramw;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69251);
    s.gGL();
    boolean bool1;
    boolean bool2;
    if ((s.gGM().OUc != null) && (paramAuthen.HzF != null) && (!paramBoolean)) {
      if ((paramAuthen.HzF.fOY == 31) || (paramAuthen.HzF.fOY == 32) || (paramAuthen.HzF.fOY == 33) || (paramAuthen.HzF.fOY == 42) || (paramAuthen.HzF.fOY == 37) || (paramAuthen.HzF.fOY == 56))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
      if (bool2)
      {
        paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.k(paramAuthen, paramOrders, paramBoolean);
        AppMethodBeat.o(69251);
        return paramAuthen;
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1)
        {
          paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.f(paramAuthen, paramOrders, paramBoolean);
          AppMethodBeat.o(69251);
          return paramAuthen;
        }
        paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.c(paramAuthen, paramOrders, paramBoolean);
        AppMethodBeat.o(69251);
        return paramAuthen;
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.b b(w paramw, Orders paramOrders)
  {
    AppMethodBeat.i(69252);
    s.gGL();
    boolean bool1;
    boolean bool2;
    if ((s.gGM().OUc != null) && (paramw.HzF != null))
    {
      String str = paramw.fvP;
      s.gGL();
      if (str.equals(s.gGM().OUc.field_bankcardType)) {
        if ((paramw.HzF.fOY == 31) || (paramw.HzF.fOY == 32) || (paramw.HzF.fOY == 33) || (paramw.HzF.fOY == 42) || (paramw.HzF.fOY == 37) || (paramw.HzF.fOY == 56))
        {
          bool1 = false;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        paramw = new com.tencent.mm.plugin.wallet.pay.a.d.i(paramw, paramOrders);
        AppMethodBeat.o(69252);
        return paramw;
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1)
        {
          paramw = new com.tencent.mm.plugin.wallet.pay.a.d.e(paramw, paramOrders);
          AppMethodBeat.o(69252);
          return paramw;
        }
        paramw = new com.tencent.mm.plugin.wallet.pay.a.d.b(paramw, paramOrders);
        AppMethodBeat.o(69252);
        return paramw;
        bool1 = false;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a
 * JD-Core Version:    0.7.0.1
 */