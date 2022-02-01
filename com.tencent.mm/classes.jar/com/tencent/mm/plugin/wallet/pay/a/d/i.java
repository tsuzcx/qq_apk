package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends b
{
  public i(u paramu, Orders paramOrders)
  {
    super(paramu, paramOrders);
  }
  
  protected final void aP(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69296);
    paramMap.put("busi_scene", this.Bio.cZz);
    AppMethodBeat.o(69296);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69297);
    h.wUl.idkeyStat(663L, 26L, 1L, false);
    int i = super.doScene(parame, paramg);
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
    h.wUl.idkeyStat(663L, 27L, 1L, false);
    AppMethodBeat.o(69298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.i
 * JD-Core Version:    0.7.0.1
 */