package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends h
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43396);
    HashMap localHashMap = new HashMap();
    localHashMap.put("buss_type", paramString1);
    localHashMap.put("method", paramString2);
    if (at.isWifi(ah.getContext())) {
      paramString1 = "wifi";
    }
    for (;;)
    {
      localHashMap.put("network", paramString1);
      localHashMap.put("transactionid", paramString3);
      setRequestData(localHashMap);
      AppMethodBeat.o(43396);
      return;
      if (at.is3G(ah.getContext())) {
        paramString1 = "3g";
      } else if (at.is2G(ah.getContext())) {
        paramString1 = "2g";
      } else if (at.isWap(ah.getContext())) {
        paramString1 = "wap";
      } else if (at.is4G(ah.getContext())) {
        paramString1 = "4g";
      } else {
        paramString1 = "unknown";
      }
    }
  }
  
  public final int getFuncId()
  {
    return 1602;
  }
  
  public final int getTenpayCgicmd()
  {
    return 122;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/datareport";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.g
 * JD-Core Version:    0.7.0.1
 */