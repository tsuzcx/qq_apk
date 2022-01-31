package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String czq;
  public String uDA;
  public String uDB;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48506);
    this.uDA = paramString1;
    this.uDB = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", paramString1);
    localHashMap.put("new_pin", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(48506);
  }
  
  public final int cTa()
  {
    return 19;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48507);
    this.czq = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */