package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72144);
    HashMap localHashMap = new HashMap();
    localHashMap.put("old_pin", paramString1);
    localHashMap.put("new_pin", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72144);
  }
  
  public final int fPU()
  {
    return 2;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */