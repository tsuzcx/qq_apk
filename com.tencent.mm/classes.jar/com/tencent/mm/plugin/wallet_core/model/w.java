package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class w
{
  public String Daj;
  public int Dak;
  public String Dal;
  public String Dam;
  public String Dan;
  public String dxD;
  public String zxx;
  
  public static void aEo(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)g.ad(a.class)).getWalletCacheStg().set(al.a.ICF, paramString);
    AppMethodBeat.o(70409);
  }
  
  public static w aV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    w localw = new w();
    localw.dxD = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localw.Daj = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localw.zxx = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localw.Dal = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localw.Dam = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localw.Dan = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localw.Dak = bt.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.w
 * JD-Core Version:    0.7.0.1
 */