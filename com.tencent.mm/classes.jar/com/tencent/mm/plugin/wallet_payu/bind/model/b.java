package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String DJr;
  public String dAa;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71977);
    this.DJr = paramString1;
    this.dAa = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serial", paramString1);
    localHashMap.put("payu_reference", String.valueOf(paramString2));
    setRequestData(localHashMap);
    AppMethodBeat.o(71977);
  }
  
  public final int eIr()
  {
    return 6;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.b
 * JD-Core Version:    0.7.0.1
 */