package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends b
{
  public e(v paramv, Orders paramOrders)
  {
    super(paramv, paramOrders);
  }
  
  protected final void aX(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69291);
    paramMap.put("busi_scene", this.HFW.dDj);
    AppMethodBeat.o(69291);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69292);
    h.CyF.idkeyStat(663L, 22L, 1L, false);
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
    h.CyF.idkeyStat(663L, 23L, 1L, false);
    AppMethodBeat.o(69293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */