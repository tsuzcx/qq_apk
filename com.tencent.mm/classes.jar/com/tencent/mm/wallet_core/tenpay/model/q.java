package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class q
  extends m
{
  public q()
  {
    AppMethodBeat.i(72896);
    setRequestData(new HashMap());
    AppMethodBeat.o(72896);
  }
  
  public final int getFuncId()
  {
    return 477;
  }
  
  public final int getTenpayCgicmd()
  {
    return 19;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/timeseed";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72897);
    ac.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + paramInt + " errMsg :" + paramString);
    paramString = paramJSONObject.optString("time_stamp");
    ac.i("Micromsg.NetSceneTenpayTimeSeed", "get svr time stamp: %s", new Object[] { paramString });
    if (!bs.isNullOrNil(paramString))
    {
      y.setTimeStamp(paramString);
      AppMethodBeat.o(72897);
      return;
    }
    ac.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
    y.setTimeStamp(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(72897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.q
 * JD-Core Version:    0.7.0.1
 */