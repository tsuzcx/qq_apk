package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class v
{
  public String BzQ;
  public int BzR;
  public String BzS;
  public String BzT;
  public String BzU;
  public String dlQ;
  public String yhq;
  
  public static v aS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    v localv = new v();
    localv.dlQ = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localv.BzQ = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localv.yhq = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localv.BzS = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localv.BzT = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localv.BzU = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localv.BzR = bs.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localv;
  }
  
  public static void azg(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)g.ad(a.class)).getWalletCacheStg().set(ah.a.GQl, paramString);
    AppMethodBeat.o(70409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */