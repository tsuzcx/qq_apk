package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends j
{
  public String qqS;
  public int qqT;
  public String qqU;
  public String qqV;
  
  public s(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("use_touch", "1");
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("soter_req", paramString2);
    aC(paramString1);
  }
  
  public s(String paramString1, String paramString2, byte paramByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    D(localHashMap);
    aC(new HashMap());
  }
  
  public s(String paramString1, String paramString2, char paramChar)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("resend", "1");
    D(localHashMap);
    aC(new HashMap());
  }
  
  public final int HH()
  {
    return 1515;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + paramInt + " errMsg: " + paramString);
    this.qqS = paramJSONObject.optString("usertoken");
    this.qqT = paramJSONObject.optInt("is_free_sms");
    this.qqU = paramJSONObject.optString("mobile_no");
    this.qqV = paramJSONObject.optString("relation_key");
  }
  
  public final int aEC()
  {
    return 100;
  }
  
  public final boolean bUI()
  {
    return this.qqT == 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */