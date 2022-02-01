package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public double AAf;
  public String AAg;
  public double AAh;
  public String AAi;
  public boolean AAj;
  public boolean AAk;
  public String AAl;
  public String AAm;
  public String AAn;
  public String AyH;
  public String AyN;
  public String AyO;
  public String AyQ;
  public String dcE;
  public String dol;
  public String don;
  public String nSY;
  public int nUh;
  public String pin;
  
  public a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72081);
    this.dcE = paramString1;
    this.AAf = paramDouble;
    this.AAg = paramString2;
    this.don = paramString3;
    this.dol = paramString4;
    this.AyH = paramString5;
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
  
  public final int ebo()
  {
    return 9;
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(72082);
    boolean bool = this.AAl.equals("1");
    AppMethodBeat.o(72082);
    return bool;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72083);
    if (paramJSONObject != null)
    {
      this.nSY = paramJSONObject.optString("trans_id");
      this.AAh = (paramJSONObject.optDouble("total_fee") / 100.0D);
      this.AAi = paramJSONObject.optString("fee_type");
      this.AAj = paramJSONObject.optBoolean("redirect");
      this.AyN = paramJSONObject.optString("gateway_reference");
      this.AyO = paramJSONObject.optString("gateway_code");
      this.AAl = paramJSONObject.optString("pay_status");
      this.nUh = paramJSONObject.optInt("timestamp");
      this.AAm = paramJSONObject.optString("pay_status_name");
      this.AAn = paramJSONObject.optString("bank_type");
      this.AAk = paramJSONObject.optBoolean("is_force_adjust");
      this.AyQ = paramJSONObject.optString("force_adjust_code");
    }
    AppMethodBeat.o(72083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */