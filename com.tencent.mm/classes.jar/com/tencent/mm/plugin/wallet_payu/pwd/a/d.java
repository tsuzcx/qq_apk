package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String bRP;
  public String qOt;
  public String qOu;
  
  public d(String paramString1, String paramString2)
  {
    this.qOt = paramString1;
    this.qOu = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", paramString1);
    localHashMap.put("new_pin", paramString2);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.bRP = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */