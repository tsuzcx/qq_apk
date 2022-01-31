package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends j
{
  public String qqR;
  private int scene;
  public String token;
  
  public r(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString2);
    if (paramInt == 6) {
      localHashMap.put("time_stamp", System.currentTimeMillis());
    }
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("check_pwd_scene", String.valueOf(paramInt));
    if (v.cMA())
    {
      paramString1.put("uuid_for_bindcard", v.cMC());
      paramString1.put("bindcard_scene", v.cMB());
    }
    aC(paramString1);
    this.scene = paramInt;
  }
  
  public final int HH()
  {
    return 476;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if ((this.scene == 6) || (this.scene == 8) || (this.scene == 18))
    {
      this.token = paramJSONObject.optString("usertoken");
      this.qqR = paramJSONObject.optString("token_type");
    }
  }
  
  public final int aEC()
  {
    return 18;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */