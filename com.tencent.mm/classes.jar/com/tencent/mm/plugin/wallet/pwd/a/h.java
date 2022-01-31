package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends j
{
  public h(String paramString1, String paramString2)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("resetpwd_token", paramString2);
    localHashMap1.put("passwd", paramString1);
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public final int HH()
  {
    return 1371;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", new Object[] { paramJSONObject.toString() });
  }
  
  public final int aEC()
  {
    return 1371;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */