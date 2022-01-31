package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.wallet_core.tenpay.model.j
{
  public j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1304;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return super.a(parame, paramf);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "null")
    {
      y.v("MicroMsg.NetSceneTouchLockVerifyByPwd", "alvinluo errCode: %d, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
      return;
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.j
 * JD-Core Version:    0.7.0.1
 */