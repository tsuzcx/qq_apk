package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String Pla;
  public String Plb;
  public String Plh;
  public String Pli;
  public String Plk;
  public String PmA;
  public double PmB;
  public String PmC;
  public boolean PmD;
  public boolean PmE;
  public String PmF;
  public String PmG;
  public String PmH;
  public double Pmz;
  public int dXr;
  public String fJC;
  public String fJD;
  public String fwv;
  public String tUC;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.fwv = paramString1;
    this.Pmz = paramDouble;
    this.PmA = paramString2;
    this.fJC = paramString3;
    this.fJD = paramString4;
    this.Plb = paramString5;
    this.Pla = paramString6;
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
  
  public final int gIA()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.PmF.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.tUC = paramJSONObject.optString("trans_id");
      this.PmB = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.PmC = paramJSONObject.optString("fee_type");
      this.PmD = paramJSONObject.optBoolean("redirect");
      this.Plh = paramJSONObject.optString("gateway_reference");
      this.Pli = paramJSONObject.optString("gateway_code");
      this.PmF = paramJSONObject.optString("pay_status");
      this.dXr = paramJSONObject.optInt("timestamp");
      this.PmG = paramJSONObject.optString("pay_status_name");
      this.PmH = paramJSONObject.optString("bank_type");
      this.PmE = paramJSONObject.optBoolean("is_force_adjust");
      this.Plk = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */