package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Map;

public final class x
{
  public String OTl;
  public int OTm;
  public String OTn;
  public String OTo;
  public String OTp;
  public String bgColor;
  public String wording;
  
  public static x aU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70408);
    if (paramMap == null)
    {
      AppMethodBeat.o(70408);
      return null;
    }
    x localx = new x();
    localx.wording = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording"));
    localx.OTl = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_color"));
    localx.bgColor = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.bg_color"));
    localx.OTn = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.route_url"));
    localx.OTo = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.left_icon"));
    localx.OTp = ((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.right_icon"));
    localx.OTm = Util.getInt((String)paramMap.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
    AppMethodBeat.o(70408);
    return localx;
  }
  
  public static void bgQ(String paramString)
  {
    AppMethodBeat.i(70409);
    ((a)h.ag(a.class)).getWalletCacheStg().set(ar.a.VtK, paramString);
    AppMethodBeat.o(70409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */