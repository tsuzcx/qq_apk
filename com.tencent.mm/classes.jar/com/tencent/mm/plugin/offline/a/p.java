package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  public p(String paramString)
  {
    AppMethodBeat.i(43415);
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_id", q.LK());
    localHashMap.put("passwd", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(43415);
  }
  
  public final int getTenpayCgicmd()
  {
    return 51;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.p
 * JD-Core Version:    0.7.0.1
 */