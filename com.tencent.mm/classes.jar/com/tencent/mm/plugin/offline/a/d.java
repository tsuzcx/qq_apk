package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public String wNE;
  public int wNF;
  public String wNG;
  
  public d()
  {
    AppMethodBeat.i(66286);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITX, null);
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
    long l = com.tencent.mm.plugin.offline.g.dzC();
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 56L, 1L, true);
      this.wNE = paramJSONObject.optString("appmsg");
      this.wNF = (paramJSONObject.optInt("poll_time") * 1000);
      this.wNG = paramJSONObject.optString("ack_key");
      if (this.wNF > 0)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITW, Integer.valueOf(this.wNF));
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITX, this.wNG);
      AppMethodBeat.o(66287);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 57L, 1L, true);
    AppMethodBeat.o(66287);
  }
  
  public final boolean resend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.d
 * JD-Core Version:    0.7.0.1
 */