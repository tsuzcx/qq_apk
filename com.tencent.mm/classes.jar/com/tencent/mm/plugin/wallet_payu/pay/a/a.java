package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String DrC;
  public String DrD;
  public String DrF;
  public String Drw;
  public double DsU;
  public String DsV;
  public double DsW;
  public String DsX;
  public boolean DsY;
  public boolean DsZ;
  public String Dta;
  public String Dtb;
  public String Dtc;
  public String dlu;
  public String dxI;
  public String dxK;
  public String oZO;
  public int paX;
  public String pin;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.dlu = paramString1;
    this.DsU = paramDouble;
    this.DsV = paramString2;
    this.dxK = paramString3;
    this.dxI = paramString4;
    this.Drw = paramString5;
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
  
  public final int eEK()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.Dta.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.oZO = paramJSONObject.optString("trans_id");
      this.DsW = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.DsX = paramJSONObject.optString("fee_type");
      this.DsY = paramJSONObject.optBoolean("redirect");
      this.DrC = paramJSONObject.optString("gateway_reference");
      this.DrD = paramJSONObject.optString("gateway_code");
      this.Dta = paramJSONObject.optString("pay_status");
      this.paX = paramJSONObject.optInt("timestamp");
      this.Dtb = paramJSONObject.optString("pay_status_name");
      this.Dtc = paramJSONObject.optString("bank_type");
      this.DsZ = paramJSONObject.optBoolean("is_force_adjust");
      this.DrF = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */