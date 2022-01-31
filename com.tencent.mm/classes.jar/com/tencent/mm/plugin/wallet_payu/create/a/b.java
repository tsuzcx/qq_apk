package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String bRP;
  public String caM;
  public String pin;
  public String qNd;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.qNd = paramString1;
    this.caM = paramString2;
    this.pin = paramString3;
    this.bRP = paramString4;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", paramString2);
    localHashMap.put("pin", paramString3);
    localHashMap.put("payu_reference", paramString4);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int bUM()
  {
    return 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.b
 * JD-Core Version:    0.7.0.1
 */