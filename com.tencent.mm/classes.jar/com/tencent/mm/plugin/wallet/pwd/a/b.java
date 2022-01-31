package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.luggage.j.c;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  extends j
{
  public b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("auth_token", paramString1);
    localHashMap.put("passwd", paramString2);
    localHashMap.put("timestamp", System.currentTimeMillis());
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 2514;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    c.i("MicroMsg.NetSceneResetPayPwdByFace", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
    }
  }
  
  public final int aEC()
  {
    return 2514;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/resetpaypwdbyface";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */