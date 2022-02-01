package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public boolean DcO;
  public String Itw;
  public String Itx;
  public String dRM;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72047);
    this.Itw = paramString1;
    this.dRM = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("otp", paramString1);
    localHashMap.put("payu_reference", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72047);
  }
  
  public final int fPU()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72048);
    Log.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.DcO = paramJSONObject.optBoolean("verified");
    this.Itx = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.a
 * JD-Core Version:    0.7.0.1
 */