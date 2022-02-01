package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public int BRh;
  public int BTf;
  public double BTg;
  public String BTh;
  public String dac;
  public double daf;
  public String dbI;
  public String dlU;
  public String dvw;
  public String pin;
  
  public a(String paramString1, String paramString2, double paramDouble, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72166);
    this.dac = paramString1;
    this.pin = paramString2;
    this.daf = paramDouble;
    this.dbI = paramString3;
    if (paramInt == 2) {}
    for (int i = 0;; i = paramInt)
    {
      this.BTf = i;
      this.dvw = paramString4;
      this.dlU = paramString5;
      HashMap localHashMap = new HashMap();
      localHashMap.put("pin", paramString2);
      localHashMap.put("req_key", paramString1);
      localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString3);
      localHashMap.put("transfer_type", String.valueOf(paramInt));
      localHashMap.put("target_username", paramString4);
      localHashMap.put("bind_serial", paramString5);
      localHashMap.put("transfer_qrcode_id", paramString6);
      setRequestData(localHashMap);
      AppMethodBeat.o(72166);
      return;
    }
  }
  
  public final int eqK()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72167);
    this.BRh = paramJSONObject.optInt("response_result");
    this.BTg = bs.getDouble(paramJSONObject.optString("total_fee"), 0.0D);
    this.BTh = paramJSONObject.optString("fee_type");
    AppMethodBeat.o(72167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */