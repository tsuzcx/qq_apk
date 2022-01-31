package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String bHY;
  public String bMX;
  public String iGK;
  public double nCq;
  public String pin;
  public String qMA;
  public String qMB;
  public boolean qMC;
  public String qMD;
  public String qMu;
  public String qMv;
  public String qMw;
  public String qMx;
  public int qMy;
  public boolean qMz;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.pin = paramString1;
    this.qMu = paramString2;
    this.bMX = paramString3;
    this.nCq = paramDouble;
    this.bHY = paramString4;
    this.qMv = paramString5;
    this.qMw = paramString6;
    this.qMx = paramString7;
    HashMap localHashMap = new HashMap();
    localHashMap.put("pin", paramString1);
    localHashMap.put("bind_serial", paramString5);
    localHashMap.put("req_key", paramString3);
    localHashMap.put("fee_type", paramString4);
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("bank_type", paramString6);
    localHashMap.put("cvv", paramString2);
    localHashMap.put("dest_bind_serial", paramString7);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.iGK = paramJSONObject.optString("trans_id");
    this.qMy = paramJSONObject.optInt("response_result");
    this.qMz = paramJSONObject.optBoolean("redirect");
    this.qMA = paramJSONObject.optString("gateway_reference");
    this.qMB = paramJSONObject.optString("gateway_code");
    this.qMC = paramJSONObject.optBoolean("is_force_adjust");
    this.qMD = paramJSONObject.optString("force_adjust_code");
  }
  
  public final int bUM()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */