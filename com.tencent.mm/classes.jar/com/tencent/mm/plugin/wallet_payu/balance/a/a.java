package com.tencent.mm.plugin.wallet_payu.balance.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String bHY;
  public String bMX;
  public double nCq;
  
  public a(double paramDouble, String paramString)
  {
    this.nCq = paramDouble;
    this.bHY = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.bMX = paramJSONObject.optString("prepayid");
  }
  
  public final int bUM()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.a
 * JD-Core Version:    0.7.0.1
 */