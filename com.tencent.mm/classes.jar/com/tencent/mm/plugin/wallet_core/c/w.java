package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends j
{
  public String qrc;
  
  public w(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt));
    localHashMap.put("package", URLEncoder.encode(paramString2));
    localHashMap.put("sign", paramString3);
    localHashMap.put("sign_type", paramString4);
    localHashMap.put("busi_id", paramString5);
    D(localHashMap);
  }
  
  public w(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt1));
    localHashMap.put("package", URLEncoder.encode(paramString2));
    localHashMap.put("sign", paramString3);
    localHashMap.put("sign_type", paramString4);
    localHashMap.put("busi_id", paramString5);
    localHashMap.put("use_touch", String.valueOf(paramInt2));
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("soter_req", paramString6);
    paramString1.put("fingerData", paramString7);
    aC(paramString1);
  }
  
  public final int HH()
  {
    return 2704;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.qrc = paramJSONObject.optString("usertoken", "");
  }
  
  public final int aEC()
  {
    return 2704;
  }
  
  public final boolean bUL()
  {
    return true;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/getpaypwdtoken";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */