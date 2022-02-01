package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.report.service.g;
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
  
  protected final void aS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69291);
    paramMap.put("busi_scene", this.CIC.dkR);
    AppMethodBeat.o(69291);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(69292);
    g.yhR.idkeyStat(663L, 22L, 1L, false);
    int i = super.doScene(parame, paramf);
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
    g.yhR.idkeyStat(663L, 23L, 1L, false);
    AppMethodBeat.o(69293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */