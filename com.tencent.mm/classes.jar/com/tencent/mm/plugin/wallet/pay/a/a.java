package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.l;
import com.tencent.mm.plugin.wallet.pay.a.a.m;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static b a(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(45907);
    if ((paramAuthen == null) || (paramOrders == null))
    {
      ab.i("MicroMsg.CgiManager", "empty authen or orders");
      AppMethodBeat.o(45907);
      return null;
    }
    PayInfo localPayInfo = paramAuthen.pVo;
    String str1 = "";
    if (localPayInfo != null)
    {
      ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.cnI;
    }
    String str2 = str1;
    if (bo.isNullOrNil(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        ab.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.cnI;
      }
    }
    if (bo.isNullOrNil(str2))
    {
      ab.i("MicroMsg.CgiManager", "empty reqKey!");
      paramAuthen = new b(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    ab.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[] { str2 });
    if ((localPayInfo != null) && (paramOrders != null)) {
      ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.cnI, paramOrders.cnI });
    }
    ab.i("MicroMsg.CgiManager", "authen go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.a(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramAuthen = new m(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.e(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("ts_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.g(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("sns_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.j(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("offline_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.h(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("up_"))
    {
      paramAuthen = new n(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.i(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("tax_"))
    {
      paramAuthen = new l(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    if (str2.startsWith("dc_"))
    {
      paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.d(paramAuthen, paramOrders, paramBoolean);
      AppMethodBeat.o(45907);
      return paramAuthen;
    }
    paramAuthen = new b(paramAuthen, paramOrders, paramBoolean);
    AppMethodBeat.o(45907);
    return paramAuthen;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.f a(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(45908);
    if ((paramu == null) || (paramOrders == null))
    {
      ab.e("MicroMsg.CgiManager", "empty verify or orders");
      AppMethodBeat.o(45908);
      return null;
    }
    PayInfo localPayInfo = paramu.pVo;
    String str1 = "";
    if (localPayInfo != null)
    {
      ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.cnI;
    }
    String str2 = str1;
    if (bo.isNullOrNil(str1))
    {
      ab.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.cnI;
    }
    if (bo.isNullOrNil(str2))
    {
      ab.i("MicroMsg.CgiManager", "empty reqKey!");
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.f(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (localPayInfo != null) {
      ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.cnI, paramOrders.cnI });
    }
    ab.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    ab.i("MicroMsg.CgiManager", "verify go new split cgi");
    if (str2.startsWith("sns_aa_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.a(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("sns_tf_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.j(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("sns_ff_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.d(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("ts_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.e(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("sns_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.h(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("up_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.k(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("seb_ff_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.g(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("tax_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.i(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    if (str2.startsWith("dc_"))
    {
      paramu = new com.tencent.mm.plugin.wallet.pay.a.d.c(paramu, paramOrders);
      AppMethodBeat.o(45908);
      return paramu;
    }
    paramu = new com.tencent.mm.plugin.wallet.pay.a.d.f(paramu, paramOrders);
    AppMethodBeat.o(45908);
    return paramu;
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    AppMethodBeat.i(45909);
    s.cRG();
    boolean bool1;
    boolean bool2;
    if ((s.cRH().ulT != null) && (paramAuthen.pVo != null) && (!paramBoolean)) {
      if ((paramAuthen.pVo.cCD == 31) || (paramAuthen.pVo.cCD == 32) || (paramAuthen.pVo.cCD == 33) || (paramAuthen.pVo.cCD == 42) || (paramAuthen.pVo.cCD == 37))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
      if (bool2)
      {
        paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.k(paramAuthen, paramOrders, paramBoolean);
        AppMethodBeat.o(45909);
        return paramAuthen;
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1)
        {
          paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.f(paramAuthen, paramOrders, paramBoolean);
          AppMethodBeat.o(45909);
          return paramAuthen;
        }
        paramAuthen = new com.tencent.mm.plugin.wallet.pay.a.a.c(paramAuthen, paramOrders, paramBoolean);
        AppMethodBeat.o(45909);
        return paramAuthen;
        bool1 = false;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a
 * JD-Core Version:    0.7.0.1
 */