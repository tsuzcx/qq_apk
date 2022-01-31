package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String bRP;
  public String id;
  public String qON;
  
  public c()
  {
    this("");
  }
  
  public c(String paramString)
  {
    this.bRP = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", bk.aM(paramString, ""));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optString("id");
    this.qON = paramJSONObject.optString("description");
  }
  
  public final int bUM()
  {
    return 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.c
 * JD-Core Version:    0.7.0.1
 */