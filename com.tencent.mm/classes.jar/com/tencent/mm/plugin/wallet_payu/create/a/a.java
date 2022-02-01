package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.d.a.a
{
  public String WcW;
  public String WcX;
  public String WcY;
  public String WcZ;
  public String Wcz;
  public String Wda;
  public String hQR;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72009);
    this.WcW = paramString1;
    this.WcX = paramString2;
    this.Wcz = paramString3;
    this.WcZ = paramString4;
    this.WcY = paramString4;
    this.Wda = paramString6;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", String.valueOf(paramString2));
    localHashMap.put("pin", String.valueOf(paramString3));
    localHashMap.put("secret_question_id", String.valueOf(paramString4));
    localHashMap.put("secret_question_answer", String.valueOf(paramString5));
    localHashMap.put("payu_reference", paramString6);
    setRequestData(localHashMap);
    AppMethodBeat.o(72009);
  }
  
  public final int ihO()
  {
    return 5;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72010);
    Log.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.hQR = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.a
 * JD-Core Version:    0.7.0.1
 */