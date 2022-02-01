package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public String vsB;
  public int vsC;
  public String vsD;
  
  public d()
  {
    AppMethodBeat.i(66286);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNh, null);
    if (localObject != null) {
      localHashMap.put("ack_key", (String)localObject);
    }
    localHashMap.put("timestamp", System.currentTimeMillis());
    setRequestData(localHashMap);
    AppMethodBeat.o(66286);
  }
  
  public final long getReturnTimeout()
  {
    AppMethodBeat.i(66288);
    long l = com.tencent.mm.plugin.offline.g.dlV();
    AppMethodBeat.o(66288);
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
    AppMethodBeat.i(66287);
    if (paramInt == 0)
    {
      h.wUl.idkeyStat(135L, 56L, 1L, true);
      this.vsB = paramJSONObject.optString("appmsg");
      this.vsC = (paramJSONObject.optInt("poll_time") * 1000);
      this.vsD = paramJSONObject.optString("ack_key");
      if (this.vsC > 0)
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNg, Integer.valueOf(this.vsC));
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNh, this.vsD);
      AppMethodBeat.o(66287);
      return;
    }
    h.wUl.idkeyStat(135L, 57L, 1L, true);
    AppMethodBeat.o(66287);
  }
  
  public final boolean resend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.d
 * JD-Core Version:    0.7.0.1
 */