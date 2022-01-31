package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends j
  implements k
{
  public JSONObject qop;
  
  public e(boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", new Object[] { paramString1, paramString2 });
    localHashMap.put("is_root", "0");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_device_open_touch", str);
      localHashMap.put("cpu_id", paramString1);
      localHashMap.put("app_uid", paramString2);
      D(localHashMap);
      return;
    }
  }
  
  public final int HH()
  {
    return 1669;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return super.a(parame, paramf);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", new Object[] { paramJSONObject.toString() });
      this.qop = paramJSONObject;
      com.tencent.mm.wallet_core.c.y.cMH().aC(this.qop);
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.e
 * JD-Core Version:    0.7.0.1
 */