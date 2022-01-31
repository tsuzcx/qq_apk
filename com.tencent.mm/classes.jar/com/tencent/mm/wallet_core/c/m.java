package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public String AWV;
  
  public m(String paramString)
  {
    AppMethodBeat.i(49061);
    this.AWV = paramString;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("crt_no", com.tencent.mm.compatible.util.q.encode(paramString));
    localHashMap1.put("deviceid", com.tencent.mm.compatible.e.q.bP(false));
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(49061);
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
    AppMethodBeat.i(49062);
    ab.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(49062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */