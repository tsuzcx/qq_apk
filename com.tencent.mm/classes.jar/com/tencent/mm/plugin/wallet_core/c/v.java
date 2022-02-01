package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public v(String paramString)
  {
    AppMethodBeat.i(69933);
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_tpa_country", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69933);
  }
  
  public final int getFuncId()
  {
    return 1663;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1663;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(69934);
    int i = super.getType();
    AppMethodBeat.o(69934);
    return i;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */