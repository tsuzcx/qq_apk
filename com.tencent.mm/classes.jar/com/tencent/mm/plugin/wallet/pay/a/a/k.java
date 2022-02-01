package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
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
  
  protected final void bi(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69273);
    paramMap.put("busi_scene", this.VmM.hAk);
    AppMethodBeat.o(69273);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69274);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 24L, 1L, false);
    int i = super.doScene(paramg, paramh);
    AppMethodBeat.o(69274);
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
    AppMethodBeat.i(69275);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 25L, 1L, false);
    }
    AppMethodBeat.o(69275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.k
 * JD-Core Version:    0.7.0.1
 */