package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public s(String paramString)
  {
    AppMethodBeat.i(46528);
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_tpa_country", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(46528);
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
    AppMethodBeat.i(46529);
    int i = super.getType();
    AppMethodBeat.o(46529);
    return i;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */