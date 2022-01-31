package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends j
{
  public c(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString);
    localHashMap.put("pay_scene", String.valueOf(paramInt1));
    localHashMap.put("pay_channel", String.valueOf(paramInt2));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int aEC()
  {
    return 1385;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.c
 * JD-Core Version:    0.7.0.1
 */