package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class w
{
  public String DrO;
  public int DrP;
  public String DrQ;
  public String DrR;
  public String DrS;
  public String dyI;
  public String zOW;
  
  public static void aFI(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)g.ad(a.class)).getWalletCacheStg().set(am.a.IXf, paramString);
    AppMethodBeat.o(70409);
  }
  
  public static w bb(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    w localw = new w();
    localw.dyI = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localw.DrO = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localw.zOW = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localw.DrQ = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localw.DrR = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localw.DrS = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localw.DrP = bu.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.w
 * JD-Core Version:    0.7.0.1
 */