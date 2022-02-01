package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String BSi;
  public String BSj;
  public String dnh;
  public boolean xte;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72047);
    this.BSi = paramString1;
    this.dnh = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("otp", paramString1);
    localHashMap.put("payu_reference", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72047);
  }
  
  public final int eqK()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72048);
    ac.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.xte = paramJSONObject.optBoolean("verified");
    this.BSj = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.a
 * JD-Core Version:    0.7.0.1
 */