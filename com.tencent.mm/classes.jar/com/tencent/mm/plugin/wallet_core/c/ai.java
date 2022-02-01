package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ai
  extends m
{
  public String VxV;
  public String Vyh;
  
  public ai(w paramw, String paramString)
  {
    AppMethodBeat.i(69960);
    HashMap localHashMap = new HashMap();
    localHashMap.put("verify_code", paramw.VJo);
    localHashMap.put("token", paramw.token);
    localHashMap.put("passwd", paramw.pRM);
    localHashMap.put("relation_key", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69960);
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
    AppMethodBeat.i(69961);
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.VxV = paramJSONObject.optString("token_type");
      this.Vyh = paramJSONObject.optString("usertoken");
    }
    AppMethodBeat.o(69961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ai
 * JD-Core Version:    0.7.0.1
 */