package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
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
  
  protected final void bi(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69291);
    paramMap.put("busi_scene", this.Vna.hAk);
    AppMethodBeat.o(69291);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69292);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 22L, 1L, false);
    int i = super.doScene(paramg, paramh);
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
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 23L, 1L, false);
    AppMethodBeat.o(69293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */