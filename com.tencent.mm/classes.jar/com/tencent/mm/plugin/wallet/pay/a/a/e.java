package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends c
{
  public e(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  public final int HH()
  {
    return 1259;
  }
  
  protected final void P(Map<String, String> paramMap)
  {
    paramMap.put("busi_scene", this.qmd.mOb);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    h.nFQ.a(663L, 20L, 1L, false);
    return super.a(parame, paramf);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      h.nFQ.a(663L, 21L, 1L, false);
    }
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.e
 * JD-Core Version:    0.7.0.1
 */