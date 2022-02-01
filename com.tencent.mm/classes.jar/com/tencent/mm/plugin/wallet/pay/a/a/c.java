package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends b
{
  private boolean zPO;
  
  public c(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders);
    this.zPO = paramBoolean;
  }
  
  protected void aL(Map<String, String> paramMap) {}
  
  public int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69268);
    int i = super.doScene(parame, paramg);
    AppMethodBeat.o(69268);
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
    AppMethodBeat.i(69269);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    AppMethodBeat.o(69269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.c
 * JD-Core Version:    0.7.0.1
 */