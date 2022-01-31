package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac
  extends j
{
  public String qqR;
  public String qrc;
  
  public ac(p paramp, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("verify_code", paramp.qyu);
    localHashMap.put("token", paramp.token);
    localHashMap.put("passwd", paramp.feN);
    localHashMap.put("relation_key", paramString);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1604;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.qqR = paramJSONObject.optString("token_type");
      this.qrc = paramJSONObject.optString("usertoken");
    }
  }
  
  public final int aEC()
  {
    return 124;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */