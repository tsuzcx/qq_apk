package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class w
{
  public String DWN;
  public String Iba;
  public int Ibb;
  public String Ibc;
  public String Ibd;
  public String Ibe;
  public String dQx;
  
  public static void aVh(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)g.ah(a.class)).getWalletCacheStg().set(ar.a.Ofy, paramString);
    AppMethodBeat.o(70409);
  }
  
  public static w ba(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    w localw = new w();
    localw.dQx = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localw.Iba = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localw.DWN = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localw.Ibc = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localw.Ibd = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localw.Ibe = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localw.Ibb = Util.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.w
 * JD-Core Version:    0.7.0.1
 */