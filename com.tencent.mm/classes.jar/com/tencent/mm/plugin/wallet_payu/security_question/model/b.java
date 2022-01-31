package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String czq;
  public String id;
  public boolean mhc;
  public String ooD;
  public String uDT;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(48568);
    this.id = paramString2;
    this.ooD = paramString3;
    this.czq = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString2);
    localHashMap.put("answer", paramString3);
    localHashMap.put("payu_reference", paramString1);
    setRequestData(localHashMap);
    AppMethodBeat.o(48568);
  }
  
  public final int cTa()
  {
    return 18;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48569);
    this.mhc = paramJSONObject.optBoolean("verified");
    this.uDT = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.b
 * JD-Core Version:    0.7.0.1
 */