package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String WdL;
  public String WdM;
  public String hQR;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72147);
    this.WdL = paramString1;
    this.WdM = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", paramString1);
    localHashMap.put("new_pin", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(72147);
  }
  
  public final int ihO()
  {
    return 19;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72148);
    this.hQR = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */