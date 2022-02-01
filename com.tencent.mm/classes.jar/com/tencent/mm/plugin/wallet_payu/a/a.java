package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String AzM;
  public String AzN;
  public String dpw;
  public boolean whO;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72047);
    this.AzM = paramString1;
    this.dpw = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("otp", paramString1);
    localHashMap.put("payu_reference", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72047);
  }
  
  public final int ebo()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72048);
    ad.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.whO = paramJSONObject.optBoolean("verified");
    this.AzN = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.a
 * JD-Core Version:    0.7.0.1
 */