package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends j
{
  private boolean bZB = true;
  
  public f(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code_ver", paramString1);
    localHashMap.put("cn", paramString2);
    y.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[] { paramString1, paramString2 });
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1686;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      y.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
      h.nFQ.a(135L, 22L, 1L, true);
      return;
    }
    y.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[] { Integer.valueOf(paramInt), paramString });
    h.nFQ.a(135L, 23L, 1L, true);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject)
  {
    if ((paramc.wAk == 0) && (paramc.errType != 0)) {}
    for (this.bZB = false;; this.bZB = true)
    {
      y.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[] { Boolean.valueOf(this.bZB) });
      return;
    }
  }
  
  public final int aEC()
  {
    return 1686;
  }
  
  public final boolean bqd()
  {
    return this.bZB;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.f
 * JD-Core Version:    0.7.0.1
 */