package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends b
{
  private boolean tVA;
  
  public c(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders);
    this.tVA = paramBoolean;
  }
  
  protected void aj(Map<String, String> paramMap) {}
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(45925);
    int i = super.doScene(parame, paramf);
    AppMethodBeat.o(45925);
    return i;
  }
  
  public int getFuncId()
  {
    return 1600;
  }
  
  public int getTenpayCgicmd()
  {
    return 120;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45926);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    AppMethodBeat.o(45926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.c
 * JD-Core Version:    0.7.0.1
 */