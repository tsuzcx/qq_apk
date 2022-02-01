package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.w;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends b
{
  public i(w paramw, Orders paramOrders)
  {
    super(paramw, paramOrders);
  }
  
  protected final void aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69296);
    paramMap.put("busi_scene", this.OxP.fvP);
    AppMethodBeat.o(69296);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(69297);
    h.IzE.idkeyStat(663L, 26L, 1L, false);
    int i = super.doScene(paramg, parami);
    AppMethodBeat.o(69297);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1281;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69298);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    h.IzE.idkeyStat(663L, 27L, 1L, false);
    AppMethodBeat.o(69298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.i
 * JD-Core Version:    0.7.0.1
 */