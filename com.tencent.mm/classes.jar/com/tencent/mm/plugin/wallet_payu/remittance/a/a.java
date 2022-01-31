package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String cGY;
  public String cnI;
  public double cnL;
  public String cpp;
  public String pin;
  public String tSr;
  public int uBF;
  public int uDE;
  public double uDF;
  public String uDG;
  
  public a(String paramString1, String paramString2, double paramDouble, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(48525);
    this.cnI = paramString1;
    this.pin = paramString2;
    this.cnL = paramDouble;
    this.cpp = paramString3;
    if (paramInt == 2) {}
    for (int i = 0;; i = paramInt)
    {
      this.uDE = i;
      this.cGY = paramString4;
      this.tSr = paramString5;
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
      AppMethodBeat.o(48525);
      return;
    }
  }
  
  public final int cTa()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48526);
    this.uBF = paramJSONObject.optInt("response_result");
    this.uDF = bo.getDouble(paramJSONObject.optString("total_fee"), 0.0D);
    this.uDG = paramJSONObject.optString("fee_type");
    AppMethodBeat.o(48526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */