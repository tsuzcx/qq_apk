package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String cnI;
  public String kMN;
  public String pin;
  public String tSr;
  public int timestamp;
  public String uBB;
  public String uBH;
  public String uBI;
  public String uBK;
  public double uCZ;
  public String uDa;
  public double uDb;
  public String uDc;
  public boolean uDd;
  public boolean uDe;
  public String uDf;
  public String uDg;
  public String uDh;
  public String umN;
  
  public b(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(48440);
    this.cnI = paramString1;
    this.uCZ = paramDouble;
    this.uDa = paramString2;
    this.umN = paramString3;
    this.tSr = paramString4;
    this.uBB = paramString5;
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
    AppMethodBeat.o(48440);
  }
  
  public final int cTa()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(48441);
    boolean bool = this.uDf.equals("1");
    AppMethodBeat.o(48441);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48442);
    if (paramJSONObject != null)
    {
      this.kMN = paramJSONObject.optString("trans_id");
      this.uDb = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.uDc = paramJSONObject.optString("fee_type");
      this.uDd = paramJSONObject.optBoolean("redirect");
      this.uBH = paramJSONObject.optString("gateway_reference");
      this.uBI = paramJSONObject.optString("gateway_code");
      this.uDf = paramJSONObject.optString("pay_status");
      this.timestamp = paramJSONObject.optInt("timestamp");
      this.uDg = paramJSONObject.optString("pay_status_name");
      this.uDh = paramJSONObject.optString("bank_type");
      this.uDe = paramJSONObject.optBoolean("is_force_adjust");
      this.uBK = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(48442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.b
 * JD-Core Version:    0.7.0.1
 */