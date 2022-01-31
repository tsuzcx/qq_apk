package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u
  extends j
{
  public u(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("appid", URLEncoder.encode(paramString1, "UTF-8"));
      localHashMap.put("timestamp", URLEncoder.encode(paramString2, "UTF-8"));
      localHashMap.put("noncestr", URLEncoder.encode(paramString3, "UTF-8"));
      localHashMap.put("package", URLEncoder.encode(paramString4, "UTF-8"));
      localHashMap.put("sign", URLEncoder.encode(paramString5, "UTF-8"));
      D(localHashMap);
      y.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "package: %s, sign: %s", new Object[] { paramString4, paramString5 });
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      y.printErrStackTrace("MicroMsg.NetSceneTenpayF2fJsapiCheck", paramString1, "", new Object[0]);
    }
  }
  
  public final int HH()
  {
    return 1973;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frcvdlistjsapicheck";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */