package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String bRP;
  public String pin;
  public String qNd;
  public String qNe;
  public String qNf;
  public String qNg;
  public String qNh;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.qNd = paramString1;
    this.qNe = paramString2;
    this.pin = paramString3;
    this.qNg = paramString4;
    this.qNf = paramString4;
    this.qNh = paramString6;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", paramString2);
    localHashMap.put("pin", paramString3);
    localHashMap.put("secret_question_id", paramString4);
    localHashMap.put("secret_question_answer", paramString5);
    localHashMap.put("payu_reference", paramString6);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.bRP = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.a
 * JD-Core Version:    0.7.0.1
 */