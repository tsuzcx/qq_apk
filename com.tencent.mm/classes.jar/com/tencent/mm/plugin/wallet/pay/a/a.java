package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public static com.tencent.mm.plugin.wallet.pay.a.a.b a(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69249);
    if ((paramAuthen == null) || (paramOrders == null))
    {
      ac.i("MicroMsg.CgiManager", "empty authen or orders");
      AppMethodBeat.o(69249);
      return null;
    }
    PayInfo localPayInfo = paramAuthen.wfX;
    String str1 = "";
    if (localPayInfo != null)
    {
      ac.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dac;
    }
    String str2 = str1;
    if (bs.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        ac.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.dac;
      }
    }
    if (bs.isNullOrNil(str2))
    {
      ac.i("MicroMsg.CgiManager", "empty reqKey!");
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.b(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    ac.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[] { str2 });
    if ((localPayInfo != null) && (paramOrders != null)) {
      ac.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dac, paramOrders.dac });
    }
    ac.i("MicroMsg.CgiManager", "authen go new split cgi");
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
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.g a(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(69250);
    if ((paramu == null) || (paramOrders == null))
    {
      ac.e("MicroMsg.CgiManager", "empty verify or orders");
      AppMethodBeat.o(69250);
      return null;
    }
    PayInfo localPayInfo = paramu.wfX;
    String str1 = "";
    if (localPayInfo != null)
    {
      ac.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dac;
    }
    String str2 = str1;
    if (bs.isNullOrNil(str1))
    {
      ac.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.dac;
    }
    if (bs.isNullOrNil(str2))
    {
      ac.i("MicroMsg.CgiManager", "empty reqKey!");
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (localPayInfo != null) {
      ac.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dac, paramOrders.dac });
    }
    ac.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    ac.i("MicroMsg.CgiManager", "verify go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.a(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.l(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.d(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("ts_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.f(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("sns_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.j(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("up_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.m(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.h(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("tax_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.k(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    if (str2.startsWith("dc_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.c(paramu, paramOrders);
      AppMethodBeat.o(69250);
      return paramu;
    }
    paramu = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramu, paramOrders);
    AppMethodBeat.o(69250);
    return paramu;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69251);
    s.epp();
    boolean bool1;
    boolean bool2;
    if ((s.epq().BAI != null) && (paramAuthen.wfX != null) && (!paramBoolean)) {
      if ((paramAuthen.wfX.dqL == 31) || (paramAuthen.wfX.dqL == 32) || (paramAuthen.wfX.dqL == 33) || (paramAuthen.wfX.dqL == 42) || (paramAuthen.wfX.dqL == 37) || (paramAuthen.wfX.dqL == 56))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
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
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.b b(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(69252);
    s.epp();
    boolean bool1;
    boolean bool2;
    if ((s.epq().BAI != null) && (paramu.wfX != null))
    {
      String str = paramu.cZz;
      s.epp();
      if (str.equals(s.epq().BAI.field_bankcardType)) {
        if ((paramu.wfX.dqL == 31) || (paramu.wfX.dqL == 32) || (paramu.wfX.dqL == 33) || (paramu.wfX.dqL == 42) || (paramu.wfX.dqL == 37) || (paramu.wfX.dqL == 56))
        {
          bool1 = false;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        paramu = new com.tencent.mm.plugin.wallet.pay.a.d.i(paramu, paramOrders);
        AppMethodBeat.o(69252);
        return paramu;
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1)
        {
          paramu = new com.tencent.mm.plugin.wallet.pay.a.d.e(paramu, paramOrders);
          AppMethodBeat.o(69252);
          return paramu;
        }
        paramu = new com.tencent.mm.plugin.wallet.pay.a.d.b(paramu, paramOrders);
        AppMethodBeat.o(69252);
        return paramu;
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