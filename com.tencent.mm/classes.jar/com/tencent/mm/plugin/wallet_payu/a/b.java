package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String BRM;
  public String BRN;
  public boolean BSk;
  public String dnh;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72049);
    this.BRM = paramString1;
    this.BRN = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72049);
  }
  
  public final int eqK()
  {
    return 12;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72050);
    ac.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.BSk = paramJSONObject.optBoolean("has_mobile");
    this.dnh = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.b
 * JD-Core Version:    0.7.0.1
 */