package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
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
    PayInfo localPayInfo = paramAuthen.Nxi;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.hAT;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        Log.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.hAT;
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
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.hAT, paramOrders.hAT });
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
  
  public static com.tencent.mm.plugin.wallet.pay.a.c.f a(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(315534);
    if ((paramPayInfo == null) || (Util.isNullOrNil(paramPayInfo.hAT)))
    {
      Log.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      AppMethodBeat.o(315534);
      return null;
    }
    String str = paramPayInfo.hAT;
    Log.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
    Log.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
    if (str.startsWith("sns_aa_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.a(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("sns_tf_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.j(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("sns_ff_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.c(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("ts_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.d(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("sns_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.h(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("offline_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.e(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("up_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.k(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("seb_ff_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.g(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("tax_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.i(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    if (str.startsWith("dc_"))
    {
      paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.b(paramPayInfo, paramInt);
      AppMethodBeat.o(315534);
      return paramPayInfo;
    }
    paramPayInfo = new com.tencent.mm.plugin.wallet.pay.a.c.f(paramPayInfo, paramInt);
    AppMethodBeat.o(315534);
    return paramPayInfo;
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
    PayInfo localPayInfo = paramw.Nxi;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.hAT;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.hAT;
    }
    if (Util.isNullOrNil(str2))
    {
      Log.i("MicroMsg.CgiManager", "empty reqKey!");
      paramw = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramw, paramOrders);
      AppMethodBeat.o(69250);
      return paramw;
    }
    if (localPayInfo != null) {
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.hAT, paramOrders.hAT });
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
    p.ifO();
    boolean bool1;
    boolean bool2;
    if ((p.ifP().VKi != null) && (paramAuthen.Nxi != null) && (!paramBoolean)) {
      if ((paramAuthen.Nxi.hUR == 31) || (paramAuthen.Nxi.hUR == 32) || (paramAuthen.Nxi.hUR == 33) || (paramAuthen.Nxi.hUR == 42) || (paramAuthen.Nxi.hUR == 37) || (paramAuthen.Nxi.hUR == 56))
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
    p.ifO();
    boolean bool1;
    boolean bool2;
    if ((p.ifP().VKi != null) && (paramw.Nxi != null))
    {
      String str = paramw.hAk;
      p.ifO();
      if (str.equals(p.ifP().VKi.field_bankcardType)) {
        if ((paramw.Nxi.hUR == 31) || (paramw.Nxi.hUR == 32) || (paramw.Nxi.hUR == 33) || (paramw.Nxi.hUR == 42) || (paramw.Nxi.hUR == 37) || (paramw.Nxi.hUR == 56))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a
 * JD-Core Version:    0.7.0.1
 */