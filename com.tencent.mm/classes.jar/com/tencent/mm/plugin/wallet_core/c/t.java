package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class t
  extends m
{
  public t()
  {
    AppMethodBeat.i(69932);
    setRequestData(new HashMap());
    AppMethodBeat.o(69932);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */