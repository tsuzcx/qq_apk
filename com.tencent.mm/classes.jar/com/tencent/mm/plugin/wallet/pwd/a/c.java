package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends j
{
  public c(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("new_passwd", paramString2);
    localHashMap.put("new_rpasswd", paramString2);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 468;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + paramInt + " errMsg: " + paramString);
  }
  
  public final int aEC()
  {
    return 9;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/changepwd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */