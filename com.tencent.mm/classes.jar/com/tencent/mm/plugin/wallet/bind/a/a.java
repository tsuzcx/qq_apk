package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  public int qjp;
  public String qjq;
  
  public a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankcard_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1540;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0)
    {
      if (paramJSONObject != null)
      {
        this.qjp = paramJSONObject.optInt("unbindbannerlevel", 0);
        this.qjq = paramJSONObject.optString("unbindbannerwording");
      }
    }
    else {
      return;
    }
    y.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
  }
  
  public final int aEC()
  {
    return 1540;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.a
 * JD-Core Version:    0.7.0.1
 */