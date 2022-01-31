package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends j
{
  public String wAr;
  
  public k(String paramString)
  {
    this.wAr = paramString;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("crt_no", com.tencent.mm.compatible.util.q.encode(paramString));
    localHashMap1.put("deviceid", com.tencent.mm.compatible.e.q.getDeviceID(ae.getContext()));
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public final int HH()
  {
    return 1568;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int aEC()
  {
    return 1568;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */