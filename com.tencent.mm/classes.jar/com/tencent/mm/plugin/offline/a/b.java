package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
    AppMethodBeat.i(43384);
    this.TAG = "MicroMsg.NetSceneOfflineAckMsg";
    HashMap localHashMap = new HashMap();
    localHashMap.put("ack_key", a.bZT());
    localHashMap.put("req_key", a.bZU());
    localHashMap.put("paymsg_type", a.bZV());
    localHashMap.put("transactionid", a.bZW());
    localHashMap.put("network", a.getNetworkType(ah.getContext()));
    if (k.pkO)
    {
      str = "1";
      localHashMap.put("processed", str);
      if (!a.bZX()) {
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
      AppMethodBeat.o(43384);
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
    AppMethodBeat.i(43385);
    if (paramInt == 0)
    {
      ab.v(this.TAG, "response ok");
      h.qsU.idkeyStat(135L, 68L, 1L, true);
      paramInt = paramJSONObject.optInt("poll_time") * 1000;
      if (paramInt > 0)
      {
        g.RM();
        g.RL().Ru().set(ac.a.yGG, Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(43385);
      return;
    }
    ab.v(this.TAG, "response fail");
    h.qsU.idkeyStat(135L, 69L, 1L, true);
    AppMethodBeat.o(43385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.b
 * JD-Core Version:    0.7.0.1
 */