package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String bHY;
  public String bMX;
  public String bYR;
  public double nCq;
  public String pin;
  public int qMy;
  public int qOx;
  public double qOy;
  public String qOz;
  public String qjr;
  
  public a(String paramString1, String paramString2, double paramDouble, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    this.bMX = paramString1;
    this.pin = paramString2;
    this.nCq = paramDouble;
    this.bHY = paramString3;
    if (paramInt == 2) {}
    for (int i = 0;; i = paramInt)
    {
      this.qOx = i;
      this.bYR = paramString4;
      this.qjr = paramString5;
      HashMap localHashMap = new HashMap();
      localHashMap.put("pin", paramString2);
      localHashMap.put("req_key", paramString1);
      localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString3);
      localHashMap.put("transfer_type", String.valueOf(paramInt));
      localHashMap.put("target_username", paramString4);
      localHashMap.put("bind_serial", paramString5);
      localHashMap.put("transfer_qrcode_id", paramString6);
      D(localHashMap);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.qMy = paramJSONObject.optInt("response_result");
    this.qOy = bk.getDouble(paramJSONObject.optString("total_fee"), 0.0D);
    this.qOz = paramJSONObject.optString("fee_type");
  }
  
  public final int bUM()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */