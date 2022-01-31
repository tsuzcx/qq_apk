package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String bRP;
  public String id;
  public boolean jMT;
  public String lQN;
  public String qOM;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString2;
    this.lQN = paramString3;
    this.bRP = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString2);
    localHashMap.put("answer", paramString3);
    localHashMap.put("payu_reference", paramString1);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.jMT = paramJSONObject.optBoolean("verified");
    this.qOM = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.b
 * JD-Core Version:    0.7.0.1
 */