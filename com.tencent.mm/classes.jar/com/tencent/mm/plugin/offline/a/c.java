package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends m
{
  public c(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43386);
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString);
    localHashMap.put("pay_scene", String.valueOf(paramInt1));
    localHashMap.put("pay_channel", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(43386);
  }
  
  public final int getTenpayCgicmd()
  {
    return 1385;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43387);
    ab.i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(43387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.c
 * JD-Core Version:    0.7.0.1
 */