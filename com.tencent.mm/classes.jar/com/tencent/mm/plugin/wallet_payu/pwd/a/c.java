package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String token = "";
  
  public c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pin", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    this.token = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */