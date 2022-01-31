package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;
import java.util.HashMap;
import org.json.JSONObject;

public final class n
  extends j
{
  public n()
  {
    D(new HashMap());
  }
  
  public final int HH()
  {
    return 477;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + paramInt + " errMsg :" + paramString);
    paramString = paramJSONObject.optString("time_stamp");
    if (!bk.bl(paramString))
    {
      u.setTimeStamp(paramString);
      return;
    }
    y.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
    u.setTimeStamp(System.currentTimeMillis() / 1000L);
  }
  
  public final int aEC()
  {
    return 19;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/timeseed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */