package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String IsA;
  public String Isr;
  public String Isx;
  public String Isy;
  public double ItP;
  public String ItQ;
  public double ItR;
  public String ItS;
  public boolean ItT;
  public boolean ItU;
  public String ItV;
  public String ItW;
  public String ItX;
  public String dDL;
  public String dQl;
  public String dQm;
  public String pin;
  public String qvD;
  public int qwL;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.dDL = paramString1;
    this.ItP = paramDouble;
    this.ItQ = paramString2;
    this.dQl = paramString3;
    this.dQm = paramString4;
    this.Isr = paramString5;
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
  
  public final int fPU()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.ItV.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.qvD = paramJSONObject.optString("trans_id");
      this.ItR = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.ItS = paramJSONObject.optString("fee_type");
      this.ItT = paramJSONObject.optBoolean("redirect");
      this.Isx = paramJSONObject.optString("gateway_reference");
      this.Isy = paramJSONObject.optString("gateway_code");
      this.ItV = paramJSONObject.optString("pay_status");
      this.qwL = paramJSONObject.optInt("timestamp");
      this.ItW = paramJSONObject.optString("pay_status_name");
      this.ItX = paramJSONObject.optString("bank_type");
      this.ItU = paramJSONObject.optBoolean("is_force_adjust");
      this.IsA = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */