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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static com.tencent.mm.plugin.wallet.pay.a.a.b a(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(69249);
    if ((paramAuthen == null) || (paramOrders == null))
    {
      ad.i("MicroMsg.CgiManager", "empty authen or orders");
      AppMethodBeat.o(69249);
      return null;
    }
    PayInfo localPayInfo = paramAuthen.xnF;
    String str1 = "";
    if (localPayInfo != null)
    {
      ad.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dlu;
    }
    String str2 = str1;
    if (bt.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        ad.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.dlu;
      }
    }
    if (bt.isNullOrNil(str2))
    {
      ad.i("MicroMsg.CgiManager", "empty reqKey!");
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.b(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(69249);
      return paramAuthen;
    }
    ad.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[] { str2 });
    if ((localPayInfo != null) && (paramOrders != null)) {
      ad.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dlu, paramOrders.dlu });
    }
    ad.i("MicroMsg.CgiManager", "authen go new split cgi");
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
      ad.e("MicroMsg.CgiManager", "empty verify or orders");
      AppMethodBeat.o(69250);
      return null;
    }
    PayInfo localPayInfo = paramv.xnF;
    String str1 = "";
    if (localPayInfo != null)
    {
      ad.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.dlu;
    }
    String str2 = str1;
    if (bt.isNullOrNil(str1))
    {
      ad.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.dlu;
    }
    if (bt.isNullOrNil(str2))
    {
      ad.i("MicroMsg.CgiManager", "empty reqKey!");
      paramv = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramv, paramOrders);
      AppMethodBeat.o(69250);
      return paramv;
    }
    if (localPayInfo != null) {
      ad.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.dlu, paramOrders.dlu });
    }
    ad.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    ad.i("MicroMsg.CgiManager", "verify go new split cgi");
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
    s.eDp();
    boolean bool1;
    boolean bool2;
    if ((s.eDq().Dba != null) && (paramAuthen.xnF != null) && (!paramBoolean)) {
      if ((paramAuthen.xnF.dCC == 31) || (paramAuthen.xnF.dCC == 32) || (paramAuthen.xnF.dCC == 33) || (paramAuthen.xnF.dCC == 42) || (paramAuthen.xnF.dCC == 37) || (paramAuthen.xnF.dCC == 56))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
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
    s.eDp();
    boolean bool1;
    boolean bool2;
    if ((s.eDq().Dba != null) && (paramv.xnF != null))
    {
      String str = paramv.dkR;
      s.eDp();
      if (str.equals(s.eDq().Dba.field_bankcardType)) {
        if ((paramv.xnF.dCC == 31) || (paramv.xnF.dCC == 32) || (paramv.xnF.dCC == 33) || (paramv.xnF.dCC == 42) || (paramv.xnF.dCC == 37) || (paramv.xnF.dCC == 56))
        {
          bool1 = false;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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