package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.v;
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
    PayInfo localPayInfo = paramAuthen.BDB;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dDL;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        Log.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.dDL;
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
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dDL, paramOrders.dDL });
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
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.g a(v paramv, Orders paramOrders)
  {
    AppMethodBeat.i(69250);
    if ((paramv == null) || (paramOrders == null))
    {
      Log.e("MicroMsg.CgiManager", "empty verify or orders");
      AppMethodBeat.o(69250);
      return null;
    }
    PayInfo localPayInfo = paramv.BDB;
    String str1 = "";
    if (localPayInfo != null)
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dDL;
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.dDL;
    }
    if (Util.isNullOrNil(str2))
    {
      Log.i("MicroMsg.CgiManager", "empty reqKey!");
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (localPayInfo != null) {
      Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dDL, paramOrders.dDL });
    }
    Log.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    Log.i("MicroMsg.CgiManager", "verify go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.a(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.l(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.d(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("ts_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.f(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("sns_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.j(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("up_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.m(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.h(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("tax_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.k(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (str2.startsWith("dc_"))
    {
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.c(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    paramv = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramv, paramOrders);
    AppMethodBeat.o(69250);
    return paramv;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69251);
    s.fOg();
    boolean bool1;
    boolean bool2;
    if ((s.fOh().IbQ != null) && (paramAuthen.BDB != null) && (!paramBoolean)) {
      if ((paramAuthen.BDB.dVv == 31) || (paramAuthen.BDB.dVv == 32) || (paramAuthen.BDB.dVv == 33) || (paramAuthen.BDB.dVv == 42) || (paramAuthen.BDB.dVv == 37) || (paramAuthen.BDB.dVv == 56))
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
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.b b(v paramv, Orders paramOrders)
  {
    AppMethodBeat.i(69252);
    s.fOg();
    boolean bool1;
    boolean bool2;
    if ((s.fOh().IbQ != null) && (paramv.BDB != null))
    {
      String str = paramv.dDj;
      s.fOg();
      if (str.equals(s.fOh().IbQ.field_bankcardType)) {
        if ((paramv.BDB.dVv == 31) || (paramv.BDB.dVv == 32) || (paramv.BDB.dVv == 33) || (paramv.BDB.dVv == 42) || (paramv.BDB.dVv == 37) || (paramv.BDB.dVv == 56))
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
        paramv = new com.tencent.mm.plugin.wallet.pay.a.d.i(paramv, paramOrders);
        AppMethodBeat.o(69252);
        return paramv;
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1)
        {
          paramv = new com.tencent.mm.plugin.wallet.pay.a.d.e(paramv, paramOrders);
          AppMethodBeat.o(69252);
          return paramv;
        }
        paramv = new com.tencent.mm.plugin.wallet.pay.a.d.b(paramv, paramOrders);
        AppMethodBeat.o(69252);
        return paramv;
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