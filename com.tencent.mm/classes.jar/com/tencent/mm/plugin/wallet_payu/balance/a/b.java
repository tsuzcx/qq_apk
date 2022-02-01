package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public int DrA;
  public boolean DrB;
  public String DrC;
  public String DrD;
  public boolean DrE;
  public String DrF;
  public String Drw;
  public String Drx;
  public String Dry;
  public String Drz;
  public String dlu;
  public double dlx;
  public String dne;
  public String oZO;
  public String pin;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71963);
    this.pin = paramString1;
    this.Drw = paramString2;
    this.dlu = paramString3;
    this.dlx = paramDouble;
    this.dne = paramString4;
    this.Drx = paramString5;
    this.Dry = paramString6;
    this.Drz = paramString7;
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
  
  public final int eEK()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71964);
    this.oZO = paramJSONObject.optString("trans_id");
    this.DrA = paramJSONObject.optInt("response_result");
    this.DrB = paramJSONObject.optBoolean("redirect");
    this.DrC = paramJSONObject.optString("gateway_reference");
    this.DrD = paramJSONObject.optString("gateway_code");
    this.DrE = paramJSONObject.optBoolean("is_force_adjust");
    this.DrF = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(71964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */