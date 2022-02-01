package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import java.util.Map;

public final class x
{
  public String VJs;
  public int VJt;
  public String VJu;
  public String VJv;
  public String VJw;
  public String bgColor;
  public String wording;
  
  public static void bgy(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)h.az(a.class)).getWalletCacheStg().set(at.a.acVp, paramString);
    AppMethodBeat.o(70409);
  }
  
  public static x bl(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    x localx = new x();
    localx.wording = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localx.VJs = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localx.bgColor = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localx.VJu = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localx.VJv = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localx.VJw = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localx.VJt = Util.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */