package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  public String bOT = null;
  
  public a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", String.valueOf(paramInt1));
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString3);
    localHashMap.put("verify_code", paramString2);
    localHashMap.put("pay_scene", String.valueOf(paramInt2));
    D(localHashMap);
    paramString1 = new HashMap();
    if (v.cMA())
    {
      paramString1.put("uuid_for_bindcard", v.cMC());
      paramString1.put("bindcard_scene", v.cMB());
    }
    aC(paramString1);
  }
  
  public final int HH()
  {
    return 1506;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.bOT = paramJSONObject.optString("req_key");
  }
  
  public final int aEC()
  {
    return 76;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/verifybind";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a
 * JD-Core Version:    0.7.0.1
 */