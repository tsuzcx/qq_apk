package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String czq;
  public boolean uCI;
  public String uCk;
  public String uCl;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48408);
    this.uCk = paramString1;
    this.uCl = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(48408);
  }
  
  public final int cTa()
  {
    return 12;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48409);
    ab.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.uCI = paramJSONObject.optBoolean("has_mobile");
    this.czq = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.b
 * JD-Core Version:    0.7.0.1
 */