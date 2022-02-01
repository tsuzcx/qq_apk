package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String IsA;
  public String Isr;
  public String Iss;
  public String Ist;
  public String Isu;
  public int Isv;
  public boolean Isw;
  public String Isx;
  public String Isy;
  public boolean Isz;
  public String dDL;
  public double dDO;
  public String dFv;
  public String pin;
  public String qvD;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71963);
    this.pin = paramString1;
    this.Isr = paramString2;
    this.dDL = paramString3;
    this.dDO = paramDouble;
    this.dFv = paramString4;
    this.Iss = paramString5;
    this.Ist = paramString6;
    this.Isu = paramString7;
    HashMap localHashMap = new HashMap();
    localHashMap.put("pin", paramString1);
    localHashMap.put("bind_serial", paramString5);
    localHashMap.put("req_key", paramString3);
    localHashMap.put("fee_type", paramString4);
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("bank_type", paramString6);
    localHashMap.put("cvv", paramString2);
    localHashMap.put("dest_bind_serial", paramString7);
    setRequestData(localHashMap);
    AppMethodBeat.o(71963);
  }
  
  public final int fPU()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71964);
    this.qvD = paramJSONObject.optString("trans_id");
    this.Isv = paramJSONObject.optInt("response_result");
    this.Isw = paramJSONObject.optBoolean("redirect");
    this.Isx = paramJSONObject.optString("gateway_reference");
    this.Isy = paramJSONObject.optString("gateway_code");
    this.Isz = paramJSONObject.optBoolean("is_force_adjust");
    this.IsA = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(71964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */