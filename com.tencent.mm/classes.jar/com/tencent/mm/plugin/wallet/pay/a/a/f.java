package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends c
{
  public f(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  protected final void bi(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69270);
    paramMap.put("busi_scene", this.VmM.hAk);
    AppMethodBeat.o(69270);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69271);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 20L, 1L, false);
    int i = super.doScene(paramg, paramh);
    AppMethodBeat.o(69271);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1259;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69272);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 21L, 1L, false);
    }
    AppMethodBeat.o(69272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.f
 * JD-Core Version:    0.7.0.1
 */