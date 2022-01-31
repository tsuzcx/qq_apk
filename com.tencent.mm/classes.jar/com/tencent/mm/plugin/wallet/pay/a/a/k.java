package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends c
{
  public k(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  protected final void aj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(45930);
    paramMap.put("busi_scene", this.tVs.poq);
    AppMethodBeat.o(45930);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(45931);
    h.qsU.idkeyStat(663L, 24L, 1L, false);
    int i = super.doScene(parame, paramf);
    AppMethodBeat.o(45931);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1274;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45932);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      h.qsU.idkeyStat(663L, 25L, 1L, false);
    }
    AppMethodBeat.o(45932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.k
 * JD-Core Version:    0.7.0.1
 */