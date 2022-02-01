package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String DJb;
  public String DJh;
  public String DJi;
  public String DJk;
  public String DKA;
  public double DKB;
  public String DKC;
  public boolean DKD;
  public boolean DKE;
  public String DKF;
  public String DKG;
  public String DKH;
  public double DKz;
  public String dmw;
  public String dyN;
  public String dyP;
  public String pgs;
  public int phB;
  public String pin;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.dmw = paramString1;
    this.DKz = paramDouble;
    this.DKA = paramString2;
    this.dyP = paramString3;
    this.dyN = paramString4;
    this.DJb = paramString5;
    this.pin = paramString6;
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString1);
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("bank_type", String.valueOf(paramString3));
    localHashMap.put("bind_serial", paramString4);
    if (!paramString3.equals("SVA_PAYU")) {
      localHashMap.put("cvv", String.valueOf(paramString5));
    }
    localHashMap.put("pin", String.valueOf(paramString6));
    setRequestData(localHashMap);
    AppMethodBeat.o(72081);
  }
  
  public final int eIr()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.DKF.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.pgs = paramJSONObject.optString("trans_id");
      this.DKB = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.DKC = paramJSONObject.optString("fee_type");
      this.DKD = paramJSONObject.optBoolean("redirect");
      this.DJh = paramJSONObject.optString("gateway_reference");
      this.DJi = paramJSONObject.optString("gateway_code");
      this.DKF = paramJSONObject.optString("pay_status");
      this.phB = paramJSONObject.optInt("timestamp");
      this.DKG = paramJSONObject.optString("pay_status_name");
      this.DKH = paramJSONObject.optString("bank_type");
      this.DKE = paramJSONObject.optBoolean("is_force_adjust");
      this.DJk = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */