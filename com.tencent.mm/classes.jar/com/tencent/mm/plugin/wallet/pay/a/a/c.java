package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends b
{
  private boolean VmU;
  
  public c(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders);
    this.VmU = paramBoolean;
  }
  
  protected void bi(Map<String, String> paramMap) {}
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69268);
    int i = super.doScene(paramg, paramh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.c
 * JD-Core Version:    0.7.0.1
 */