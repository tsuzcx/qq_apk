package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public Orders nEh = null;
  private String qmm = null;
  
  public c(String paramString)
  {
    this(paramString, 0);
  }
  
  public c(String paramString, int paramInt)
  {
    this.qmm = paramString;
    paramString = new HashMap();
    paramString.put("req_key", this.qmm);
    paramString.put("query_scene", String.valueOf(paramInt));
    D(paramString);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.nEh = Orders.ak(paramJSONObject);
    if (this.nEh != null) {
      this.nEh.bMX = this.qmm;
    }
  }
  
  public final int bUM()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.c
 * JD-Core Version:    0.7.0.1
 */