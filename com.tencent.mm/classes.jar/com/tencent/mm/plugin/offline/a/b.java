package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends m
{
  public String TAG;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(66282);
    this.TAG = "MicroMsg.NetSceneOfflineAckMsg";
    HashMap localHashMap = new HashMap();
    localHashMap.put("ack_key", a.fml());
    localHashMap.put("req_key", a.fmm());
    localHashMap.put("paymsg_type", a.fmn());
    localHashMap.put("transactionid", a.fmo());
    localHashMap.put("network", a.getNetworkType(MMApplicationContext.getContext()));
    if (k.GCg)
    {
      str = "1";
      localHashMap.put("processed", str);
      if (!a.fmp()) {
        break label213;
      }
      str = "1";
      label140:
      localHashMap.put("is_pos_enabled", str);
      if (!paramBoolean) {
        break label219;
      }
    }
    label213:
    label219:
    for (String str = "pull";; str = "push")
    {
      localHashMap.put("channel", str);
      localHashMap.put("timestamp", System.currentTimeMillis() / 1000L);
      setRequestData(localHashMap);
      AppMethodBeat.o(66282);
      return;
      str = "0";
      break;
      str = "0";
      break label140;
    }
  }
  
  public final int getTenpayCgicmd()
  {
    return 1230;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66283);
    if (paramInt == 0)
    {
      Log.v(this.TAG, "response ok");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 68L, 1L, true);
      paramInt = paramJSONObject.optInt("poll_time") * 1000;
      if (paramInt > 0)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqn, Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(66283);
      return;
    }
    Log.v(this.TAG, "response fail");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 69L, 1L, true);
    AppMethodBeat.o(66283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.b
 * JD-Core Version:    0.7.0.1
 */