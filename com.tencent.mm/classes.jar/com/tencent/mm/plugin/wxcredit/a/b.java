package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends j
{
  public String name;
  public String rQG;
  public boolean rQH = true;
  public String token;
  
  public b(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt));
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("check_pwd_scene", String.valueOf(paramInt));
    aC(paramString1);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.token = paramJSONObject.optString("session_key");
    if ("1".equals(paramJSONObject.optString("all_info")))
    {
      this.rQH = false;
      return;
    }
    this.rQH = true;
    this.name = paramJSONObject.optString("name");
    this.rQG = paramJSONObject.optString("cre_id");
  }
  
  public final int aEC()
  {
    return 63;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.b
 * JD-Core Version:    0.7.0.1
 */