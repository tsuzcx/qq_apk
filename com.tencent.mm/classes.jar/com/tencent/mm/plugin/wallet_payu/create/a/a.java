package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String czq;
  public String pin;
  public String uCk;
  public String uCl;
  public String uCm;
  public String uCn;
  public String uCo;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(48369);
    this.uCk = paramString1;
    this.uCl = paramString2;
    this.pin = paramString3;
    this.uCn = paramString4;
    this.uCm = paramString4;
    this.uCo = paramString6;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", String.valueOf(paramString2));
    localHashMap.put("pin", String.valueOf(paramString3));
    localHashMap.put("secret_question_id", String.valueOf(paramString4));
    localHashMap.put("secret_question_answer", String.valueOf(paramString5));
    localHashMap.put("payu_reference", paramString6);
    setRequestData(localHashMap);
    AppMethodBeat.o(48369);
  }
  
  public final int cTa()
  {
    return 5;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48370);
    ab.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.czq = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.a
 * JD-Core Version:    0.7.0.1
 */