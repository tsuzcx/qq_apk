package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends m
{
  public j(String paramString)
  {
    AppMethodBeat.i(66298);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    localHashMap.put("device_id", com.tencent.mm.compatible.deviceinfo.q.XX());
    setRequestData(localHashMap);
    AppMethodBeat.o(66298);
  }
  
  public final int getFuncId()
  {
    return 566;
  }
  
  public final int getTenpayCgicmd()
  {
    return 47;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66299);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    AppMethodBeat.o(66299);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.j
 * JD-Core Version:    0.7.0.1
 */