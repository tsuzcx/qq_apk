package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends j
{
  public String mKI;
  public int mKJ;
  public String mKK;
  
  public d()
  {
    HashMap localHashMap = new HashMap();
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.uwz, null);
    if (localObject != null) {
      localHashMap.put("ack_key", (String)localObject);
    }
    localHashMap.put("timestamp", System.currentTimeMillis());
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0)
    {
      h.nFQ.a(135L, 56L, 1L, true);
      this.mKI = paramJSONObject.optString("appmsg");
      this.mKJ = (paramJSONObject.optInt("poll_time") * 1000);
      this.mKK = paramJSONObject.optString("ack_key");
      if (this.mKJ > 0)
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uwy, Integer.valueOf(this.mKJ));
      }
      g.DQ();
      g.DP().Dz().c(ac.a.uwz, this.mKK);
      return;
    }
    h.nFQ.a(135L, 57L, 1L, true);
  }
  
  public final int aEC()
  {
    return 1981;
  }
  
  public final boolean bqc()
  {
    return false;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.d
 * JD-Core Version:    0.7.0.1
 */