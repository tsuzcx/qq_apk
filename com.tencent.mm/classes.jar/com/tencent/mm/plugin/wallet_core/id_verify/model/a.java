package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  public a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1584;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + paramInt + ";errMsg = " + paramString);
  }
  
  public final int aEC()
  {
    return 1584;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.a
 * JD-Core Version:    0.7.0.1
 */