package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends b
{
  public e(u paramu, Orders paramOrders)
  {
    super(paramu, paramOrders);
  }
  
  protected final void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69291);
    paramMap.put("busi_scene", this.zPU.dca);
    AppMethodBeat.o(69291);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(69292);
    h.vKh.idkeyStat(663L, 22L, 1L, false);
    int i = super.doScene(parame, paramg);
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
    h.vKh.idkeyStat(663L, 23L, 1L, false);
    AppMethodBeat.o(69293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */