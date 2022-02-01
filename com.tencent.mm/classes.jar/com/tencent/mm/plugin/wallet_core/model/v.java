package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class v
{
  public String AhA;
  public String Ahw;
  public int Ahx;
  public String Ahy;
  public String Ahz;
  public String doh;
  public String wUC;
  
  public static v aO(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    v localv = new v();
    localv.doh = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localv.Ahw = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localv.wUC = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localv.Ahy = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localv.Ahz = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localv.AhA = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localv.Ahx = bt.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localv;
  }
  
  public static void atO(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)g.ad(a.class)).getWalletCacheStg().set(ae.a.Fsu, paramString);
    AppMethodBeat.o(70409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */