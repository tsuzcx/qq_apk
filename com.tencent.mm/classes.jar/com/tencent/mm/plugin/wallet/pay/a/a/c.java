package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends b
{
  private boolean qmk;
  
  public c(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders);
    this.qmk = paramBoolean;
  }
  
  public int HH()
  {
    return 1600;
  }
  
  protected void P(Map<String, String> paramMap) {}
  
  public int a(e parame, f paramf)
  {
    return super.a(parame, paramf);
  }
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
  }
  
  public final int aEC()
  {
    return 120;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.c
 * JD-Core Version:    0.7.0.1
 */