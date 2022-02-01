package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String DtN;
  public String dyV;
  public String id;
  public boolean rgp;
  public String vpC;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72209);
    this.id = paramString2;
    this.vpC = paramString3;
    this.dyV = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString2);
    localHashMap.put("answer", paramString3);
    localHashMap.put("payu_reference", paramString1);
    setRequestData(localHashMap);
    AppMethodBeat.o(72209);
  }
  
  public final int eEK()
  {
    return 18;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72210);
    this.rgp = paramJSONObject.optBoolean("verified");
    this.DtN = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.b
 * JD-Core Version:    0.7.0.1
 */