package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String bMX;
  public String iGK;
  public String pin;
  public String qAc;
  public String qMA;
  public String qMB;
  public String qMD;
  public String qMu;
  public double qNS;
  public String qNT;
  public double qNU;
  public String qNV;
  public boolean qNW;
  public boolean qNX;
  public String qNY;
  public String qNZ;
  public String qOa;
  public String qjr;
  public int timestamp;
  
  public b(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.bMX = paramString1;
    this.qNS = paramDouble;
    this.qNT = paramString2;
    this.qAc = paramString3;
    this.qjr = paramString4;
    this.qMu = paramString5;
    this.pin = paramString6;
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString1);
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("bank_type", paramString3);
    localHashMap.put("bind_serial", paramString4);
    if (!paramString3.equals("SVA_PAYU")) {
      localHashMap.put("cvv", paramString5);
    }
    localHashMap.put("pin", paramString6);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.iGK = paramJSONObject.optString("trans_id");
      this.qNU = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.qNV = paramJSONObject.optString("fee_type");
      this.qNW = paramJSONObject.optBoolean("redirect");
      this.qMA = paramJSONObject.optString("gateway_reference");
      this.qMB = paramJSONObject.optString("gateway_code");
      this.qNY = paramJSONObject.optString("pay_status");
      this.timestamp = paramJSONObject.optInt("timestamp");
      this.qNZ = paramJSONObject.optString("pay_status_name");
      this.qOa = paramJSONObject.optString("bank_type");
      this.qNX = paramJSONObject.optBoolean("is_force_adjust");
      this.qMD = paramJSONObject.optString("force_adjust_code");
    }
  }
  
  public final int bUM()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    return this.qNY.equals("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.b
 * JD-Core Version:    0.7.0.1
 */