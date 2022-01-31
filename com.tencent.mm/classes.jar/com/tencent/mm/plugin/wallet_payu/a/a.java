package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String bRP;
  public boolean nUR;
  public String qNA;
  public String qNz;
  
  public a(String paramString1, String paramString2)
  {
    this.qNz = paramString1;
    this.bRP = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("otp", paramString1);
    localHashMap.put("payu_reference", paramString2);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.nUR = paramJSONObject.optBoolean("verified");
    this.qNA = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.a
 * JD-Core Version:    0.7.0.1
 */