package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public String pkZ;
  public int pla;
  public String plb;
  
  public d()
  {
    AppMethodBeat.i(43388);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.kernel.g.RM();
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGH, null);
    if (localObject != null) {
      localHashMap.put("ack_key", (String)localObject);
    }
    localHashMap.put("timestamp", System.currentTimeMillis());
    setRequestData(localHashMap);
    AppMethodBeat.o(43388);
  }
  
  public final long getReturnTimeout()
  {
    AppMethodBeat.i(142116);
    long l = com.tencent.mm.plugin.offline.g.bYB();
    AppMethodBeat.o(142116);
    return l;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1981;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43389);
    if (paramInt == 0)
    {
      h.qsU.idkeyStat(135L, 56L, 1L, true);
      this.pkZ = paramJSONObject.optString("appmsg");
      this.pla = (paramJSONObject.optInt("poll_time") * 1000);
      this.plb = paramJSONObject.optString("ack_key");
      if (this.pla > 0)
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGG, Integer.valueOf(this.pla));
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGH, this.plb);
      AppMethodBeat.o(43389);
      return;
    }
    h.qsU.idkeyStat(135L, 57L, 1L, true);
    AppMethodBeat.o(43389);
  }
  
  public final boolean resend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.d
 * JD-Core Version:    0.7.0.1
 */