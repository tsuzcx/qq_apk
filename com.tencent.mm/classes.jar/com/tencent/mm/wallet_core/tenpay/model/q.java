package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class q
  extends m
{
  public q()
  {
    AppMethodBeat.i(49178);
    setRequestData(new HashMap());
    AppMethodBeat.o(49178);
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
    AppMethodBeat.i(49179);
    ab.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + paramInt + " errMsg :" + paramString);
    paramString = paramJSONObject.optString("time_stamp");
    if (!bo.isNullOrNil(paramString))
    {
      w.setTimeStamp(paramString);
      AppMethodBeat.o(49179);
      return;
    }
    ab.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
    w.setTimeStamp(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(49179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.q
 * JD-Core Version:    0.7.0.1
 */