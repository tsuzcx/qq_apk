package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends m
{
  public String RtT;
  
  public o(String paramString)
  {
    AppMethodBeat.i(72781);
    this.RtT = paramString;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("crt_no", com.tencent.mm.compatible.util.q.encode(paramString));
    localHashMap1.put("deviceid", com.tencent.mm.compatible.deviceinfo.q.dr(false));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(72781);
  }
  
  public final int getFuncId()
  {
    return 1568;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1568;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72782);
    Log.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(72782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */