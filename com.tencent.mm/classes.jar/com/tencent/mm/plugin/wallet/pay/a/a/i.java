package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends c
{
  public i(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  public final int HH()
  {
    return 1274;
  }
  
  protected final void P(Map<String, String> paramMap)
  {
    paramMap.put("busi_scene", this.qmd.mOb);
  }
  
  public final int a(e parame, f paramf)
  {
    h.nFQ.a(663L, 24L, 1L, false);
    return super.a(parame, paramf);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      h.nFQ.a(663L, 25L, 1L, false);
    }
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.i
 * JD-Core Version:    0.7.0.1
 */