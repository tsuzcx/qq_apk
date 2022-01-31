package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String cHB;
  public String czq;
  public String pin;
  public String uCk;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48371);
    this.uCk = paramString1;
    this.cHB = paramString2;
    this.pin = paramString3;
    this.czq = paramString4;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dial_code", paramString1);
    localHashMap.put("number", paramString2);
    localHashMap.put("pin", paramString3);
    localHashMap.put("payu_reference", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(48371);
  }
  
  public final int cTa()
  {
    return 17;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.b
 * JD-Core Version:    0.7.0.1
 */