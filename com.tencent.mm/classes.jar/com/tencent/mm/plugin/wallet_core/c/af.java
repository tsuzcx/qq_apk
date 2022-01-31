package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends m
{
  public String ubN;
  public String ubZ;
  
  public af(u paramu, String paramString)
  {
    AppMethodBeat.i(46554);
    HashMap localHashMap = new HashMap();
    localHashMap.put("verify_code", paramu.uld);
    localHashMap.put("token", paramu.token);
    localHashMap.put("passwd", paramu.gww);
    localHashMap.put("relation_key", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(46554);
  }
  
  public final int getFuncId()
  {
    return 1604;
  }
  
  public final int getTenpayCgicmd()
  {
    return 124;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46555);
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.ubN = paramJSONObject.optString("token_type");
      this.ubZ = paramJSONObject.optString("usertoken");
    }
    AppMethodBeat.o(46555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.af
 * JD-Core Version:    0.7.0.1
 */