package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String cnI;
  public double cnL;
  public String cpp;
  
  public a(double paramDouble, String paramString)
  {
    AppMethodBeat.i(48320);
    this.cnL = paramDouble;
    this.cpp = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(48320);
  }
  
  public final int cTa()
  {
    return 20;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48321);
    this.cnI = paramJSONObject.optString("prepayid");
    AppMethodBeat.o(48321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.a.a
 * JD-Core Version:    0.7.0.1
 */