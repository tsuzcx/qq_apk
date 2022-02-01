package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public String AJk;
  public int AJl;
  public String AJm;
  
  public d()
  {
    AppMethodBeat.i(66286);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.kernel.g.aAi();
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ocl, null);
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
    long l = com.tencent.mm.plugin.offline.g.ezj();
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
      h.CyF.idkeyStat(135L, 56L, 1L, true);
      this.AJk = paramJSONObject.optString("appmsg");
      this.AJl = (paramJSONObject.optInt("poll_time") * 1000);
      this.AJm = paramJSONObject.optString("ack_key");
      if (this.AJl > 0)
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ock, Integer.valueOf(this.AJl));
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ocl, this.AJm);
      AppMethodBeat.o(66287);
      return;
    }
    h.CyF.idkeyStat(135L, 57L, 1L, true);
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