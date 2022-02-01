package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String Pla;
  public String Plb;
  public String Plc;
  public String Pld;
  public String Ple;
  public int Plf;
  public boolean Plg;
  public String Plh;
  public String Pli;
  public boolean Plj;
  public String Plk;
  public String fwv;
  public double fwy;
  public String fyc;
  public String tUC;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71963);
    this.Pla = paramString1;
    this.Plb = paramString2;
    this.fwv = paramString3;
    this.fwy = paramDouble;
    this.fyc = paramString4;
    this.Plc = paramString5;
    this.Pld = paramString6;
    this.Ple = paramString7;
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
  
  public final int gIA()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71964);
    this.tUC = paramJSONObject.optString("trans_id");
    this.Plf = paramJSONObject.optInt("response_result");
    this.Plg = paramJSONObject.optBoolean("redirect");
    this.Plh = paramJSONObject.optString("gateway_reference");
    this.Pli = paramJSONObject.optString("gateway_code");
    this.Plj = paramJSONObject.optBoolean("is_force_adjust");
    this.Plk = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(71964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */