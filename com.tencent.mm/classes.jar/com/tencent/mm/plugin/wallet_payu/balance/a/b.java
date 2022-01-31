package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String cnI;
  public double cnL;
  public String cpp;
  public String kMN;
  public String pin;
  public String uBB;
  public String uBC;
  public String uBD;
  public String uBE;
  public int uBF;
  public boolean uBG;
  public String uBH;
  public String uBI;
  public boolean uBJ;
  public String uBK;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(48322);
    this.pin = paramString1;
    this.uBB = paramString2;
    this.cnI = paramString3;
    this.cnL = paramDouble;
    this.cpp = paramString4;
    this.uBC = paramString5;
    this.uBD = paramString6;
    this.uBE = paramString7;
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
    AppMethodBeat.o(48322);
  }
  
  public final int cTa()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48323);
    this.kMN = paramJSONObject.optString("trans_id");
    this.uBF = paramJSONObject.optInt("response_result");
    this.uBG = paramJSONObject.optBoolean("redirect");
    this.uBH = paramJSONObject.optString("gateway_reference");
    this.uBI = paramJSONObject.optString("gateway_code");
    this.uBJ = paramJSONObject.optBoolean("is_force_adjust");
    this.uBK = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(48323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */