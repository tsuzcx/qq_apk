package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends j
{
  public String TAG = "MicroMsg.NetSceneOfflineAckMsg";
  
  public b(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ack_key", a.bre());
    localHashMap.put("req_key", a.brf());
    localHashMap.put("paymsg_type", a.brg());
    localHashMap.put("transactionid", a.brh());
    localHashMap.put("network", a.getNetworkType(ae.getContext()));
    if (k.mKz)
    {
      str = "1";
      localHashMap.put("processed", str);
      if (!a.bri()) {
        break label203;
      }
      str = "1";
      label135:
      localHashMap.put("is_pos_enabled", str);
      if (!paramBoolean) {
        break label209;
      }
    }
    label203:
    label209:
    for (String str = "pull";; str = "push")
    {
      localHashMap.put("channel", str);
      localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
      D(localHashMap);
      return;
      str = "0";
      break;
      str = "0";
      break label135;
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0)
    {
      y.v(this.TAG, "response ok");
      h.nFQ.a(135L, 68L, 1L, true);
      paramInt = paramJSONObject.optInt("poll_time") * 1000;
      if (paramInt > 0)
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uwy, Integer.valueOf(paramInt));
      }
      return;
    }
    y.v(this.TAG, "response fail");
    h.nFQ.a(135L, 69L, 1L, true);
  }
  
  public final int aEC()
  {
    return 1230;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.b
 * JD-Core Version:    0.7.0.1
 */