package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  public String MyC;
  public int MyD;
  public String MyE;
  
  public f()
  {
    AppMethodBeat.i(66286);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acRQ, null);
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
    long l = g.gvf();
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
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 56L, 1L, true);
      this.MyC = paramJSONObject.optString("appmsg");
      this.MyD = (paramJSONObject.optInt("poll_time") * 1000);
      this.MyE = paramJSONObject.optString("ack_key");
      if (this.MyD > 0)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acRP, Integer.valueOf(this.MyD));
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRQ, this.MyE);
      AppMethodBeat.o(66287);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 57L, 1L, true);
    AppMethodBeat.o(66287);
  }
  
  public final boolean resend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.f
 * JD-Core Version:    0.7.0.1
 */