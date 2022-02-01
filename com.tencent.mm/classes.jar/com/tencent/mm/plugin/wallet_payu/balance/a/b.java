package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String AyH;
  public String AyI;
  public String AyJ;
  public String AyK;
  public int AyL;
  public boolean AyM;
  public String AyN;
  public String AyO;
  public boolean AyP;
  public String AyQ;
  public String dcE;
  public double dcH;
  public String dem;
  public String nSY;
  public String pin;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71963);
    this.pin = paramString1;
    this.AyH = paramString2;
    this.dcE = paramString3;
    this.dcH = paramDouble;
    this.dem = paramString4;
    this.AyI = paramString5;
    this.AyJ = paramString6;
    this.AyK = paramString7;
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
  
  public final int ebo()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71964);
    this.nSY = paramJSONObject.optString("trans_id");
    this.AyL = paramJSONObject.optInt("response_result");
    this.AyM = paramJSONObject.optBoolean("redirect");
    this.AyN = paramJSONObject.optString("gateway_reference");
    this.AyO = paramJSONObject.optString("gateway_code");
    this.AyP = paramJSONObject.optBoolean("is_force_adjust");
    this.AyQ = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(71964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */