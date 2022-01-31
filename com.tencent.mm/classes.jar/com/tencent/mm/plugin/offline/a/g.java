package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends h
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("buss_type", paramString1);
    localHashMap.put("method", paramString2);
    if (aq.isWifi(ae.getContext())) {
      paramString1 = "wifi";
    }
    for (;;)
    {
      localHashMap.put("network", paramString1);
      localHashMap.put("transactionid", paramString3);
      D(localHashMap);
      return;
      if (aq.is3G(ae.getContext())) {
        paramString1 = "3g";
      } else if (aq.is2G(ae.getContext())) {
        paramString1 = "2g";
      } else if (aq.isWap(ae.getContext())) {
        paramString1 = "wap";
      } else if (aq.is4G(ae.getContext())) {
        paramString1 = "4g";
      } else {
        paramString1 = "unknown";
      }
    }
  }
  
  public final int HH()
  {
    return 1602;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 122;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/datareport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.g
 * JD-Core Version:    0.7.0.1
 */