package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String BRd;
  public String BRj;
  public String BRk;
  public String BRm;
  public double BSB;
  public String BSC;
  public double BSD;
  public String BSE;
  public boolean BSF;
  public boolean BSG;
  public String BSH;
  public String BSI;
  public String BSJ;
  public String dac;
  public String dlU;
  public String dlW;
  public String owt;
  public int oxC;
  public String pin;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.dac = paramString1;
    this.BSB = paramDouble;
    this.BSC = paramString2;
    this.dlW = paramString3;
    this.dlU = paramString4;
    this.BRd = paramString5;
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
  
  public final int eqK()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.BSH.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.owt = paramJSONObject.optString("trans_id");
      this.BSD = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.BSE = paramJSONObject.optString("fee_type");
      this.BSF = paramJSONObject.optBoolean("redirect");
      this.BRj = paramJSONObject.optString("gateway_reference");
      this.BRk = paramJSONObject.optString("gateway_code");
      this.BSH = paramJSONObject.optString("pay_status");
      this.oxC = paramJSONObject.optInt("timestamp");
      this.BSI = paramJSONObject.optString("pay_status_name");
      this.BSJ = paramJSONObject.optString("bank_type");
      this.BSG = paramJSONObject.optBoolean("is_force_adjust");
      this.BRm = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */