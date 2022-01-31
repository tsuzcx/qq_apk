package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends j
{
  public p(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_tpa_country", paramString);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1663;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 1663;
  }
  
  public final int getType()
  {
    return super.getType();
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */