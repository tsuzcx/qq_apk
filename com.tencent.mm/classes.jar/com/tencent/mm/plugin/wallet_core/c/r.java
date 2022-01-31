package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class r
  extends m
{
  public r()
  {
    AppMethodBeat.i(46527);
    setRequestData(new HashMap());
    AppMethodBeat.o(46527);
  }
  
  public final int getFuncId()
  {
    return 2791;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2791;
  }
  
  public final int getType()
  {
    return 2791;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setpayuserduty";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */