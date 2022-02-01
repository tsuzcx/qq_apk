package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.w;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends b
{
  public e(w paramw, Orders paramOrders)
  {
    super(paramw, paramOrders);
  }
  
  protected final void aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69291);
    paramMap.put("busi_scene", this.OxP.fvP);
    AppMethodBeat.o(69291);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69292);
    h.IzE.idkeyStat(663L, 22L, 1L, false);
    int i = super.doScene(paramg, parami);
    AppMethodBeat.o(69292);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1305;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69293);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    h.IzE.idkeyStat(663L, 23L, 1L, false);
    AppMethodBeat.o(69293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */