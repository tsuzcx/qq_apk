package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String DJb;
  public String DJc;
  public String DJd;
  public String DJe;
  public int DJf;
  public boolean DJg;
  public String DJh;
  public String DJi;
  public boolean DJj;
  public String DJk;
  public String dmw;
  public double dmz;
  public String dog;
  public String pgs;
  public String pin;
  
  public b(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71963);
    this.pin = paramString1;
    this.DJb = paramString2;
    this.dmw = paramString3;
    this.dmz = paramDouble;
    this.dog = paramString4;
    this.DJc = paramString5;
    this.DJd = paramString6;
    this.DJe = paramString7;
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
  
  public final int eIr()
  {
    return 10;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71964);
    this.pgs = paramJSONObject.optString("trans_id");
    this.DJf = paramJSONObject.optInt("response_result");
    this.DJg = paramJSONObject.optBoolean("redirect");
    this.DJh = paramJSONObject.optString("gateway_reference");
    this.DJi = paramJSONObject.optString("gateway_code");
    this.DJj = paramJSONObject.optBoolean("is_force_adjust");
    this.DJk = paramJSONObject.optString("force_adjust_code");
    AppMethodBeat.o(71964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.b
 * JD-Core Version:    0.7.0.1
 */